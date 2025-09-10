package com.example.prisonercalling


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prisonercalling.ui.theme.PrisonManagementTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun SearchPrisonerScreen() {
    var searchId by remember { mutableStateOf("") }
    var prisoners by remember { mutableStateOf<List<Prisoner>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }

    val db = FirebaseFirestore.getInstance()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Search Prisoner",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = searchId,
                    onValueChange = { searchId = it },
                    label = { Text("Prisoner ID") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        isLoading = true
                        db.collection("prisoners")
                            .whereEqualTo("prisonerId", searchId)
                            .get()
                            .addOnSuccessListener { documents ->
                                isLoading = false
                                prisoners = documents.map { doc ->
                                    doc.toObject(Prisoner::class.java)
                                }
                            }
                            .addOnFailureListener {
                                isLoading = false
                            }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading && searchId.isNotBlank()
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            color = Color.White
                        )
                    } else {
                        Text("Search")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(prisoners) { prisoner ->
                PrisonerCard(prisoner)
            }
        }
    }
}

@Composable
fun PrisonerCard(prisoner: Prisoner) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "ID: ${prisoner.prisonerId}",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )
                Text(
                    text = "Card: ${prisoner.cardNumber}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Name: ${prisoner.prisonerName}", fontWeight = FontWeight.Medium)
            Text("Father/Husband: ${prisoner.fatherHusbandName}")
            Text("Mother: ${prisoner.motherName}")
            Text("Age: ${prisoner.age} | Gender: ${prisoner.gender}")
            Text("Admission Date: ${prisoner.admissionDate}")
        }
    }
}
