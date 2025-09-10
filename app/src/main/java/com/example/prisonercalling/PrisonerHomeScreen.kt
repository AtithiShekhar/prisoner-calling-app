package com.example.prisonercalling

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrisonerHomeScreen(navController: NavHostController, cardNumber: String) {
    var familyMembers by remember { mutableStateOf<List<Receiver>>(emptyList()) }
    var prisonerInfo by remember { mutableStateOf<Prisoner?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    val db = FirebaseFirestore.getInstance()

    LaunchedEffect(cardNumber) {
        db.collection("prisoners")
            .whereEqualTo("cardNumber", cardNumber)
            .get()
            .addOnSuccessListener { documents ->
                if (!documents.isEmpty) {
                    prisonerInfo = documents.first().toObject(Prisoner::class.java) } }
        db.collection("receivers")
            .whereEqualTo("prisonerCardNumber", cardNumber)
            .get()
            .addOnSuccessListener { documents ->
                familyMembers = documents.map { doc ->
                    doc.toObject(Receiver::class.java)
                }
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false } }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Welcome ${prisonerInfo?.prisonerName ?: ""}",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF424242)
                ),
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("login_selection") {
                                popUpTo(0) { inclusive = true } } }) {
                        Icon(
                            Icons.Default.Delete,
                            contentDescription = "Logout",
                            tint = Color.White) } }) }
    ) { paddingValues ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)) {
                prisonerInfo?.let { prisoner ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Your Information",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF424242)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("ID: ${prisoner.prisonerId}")
                            Text("Card Number: ${prisoner.cardNumber}")
                            Text("Admission Date: ${prisoner.admissionDate}")
                            Text("Balance: ₹${prisoner.amount}") } } }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Family Members",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF424242)
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (familyMembers.isEmpty()) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No family members added yet",
                                color = Color.Gray,
                                textAlign = TextAlign.Center) } }
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(familyMembers) { member ->
                            FamilyMemberCard(member) } } } } } } }

@Composable
fun FamilyMemberCard(member: Receiver) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color(0xFF424242)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = member.receiverName,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                Text(
                    text = member.phoneNumber,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            IconButton(
                onClick = { /* call functionality */ }
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = Color(0xFF4CAF50)) } } } }
data class FamilyMember(
    val name: String,
    val number: String
)