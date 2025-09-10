package com.example.prisonercalling

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddAdminScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val db = FirebaseFirestore.getInstance()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Add Admin")

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
        )

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp))
        Button(
            onClick = {
                if (password != confirmPassword) {
                    message = "Passwords don't match"
                    return@Button }
                val admin = Admin(
                    name = name,
                    id = id,
                    password = password)
                db.collection("admins")
                    .add(admin)
                    .addOnSuccessListener {
                        message = "Admin added successfully"
                        name = ""
                        id = ""
                        password = ""
                        confirmPassword = "" }
                    .addOnFailureListener {
                        message = "Failed to add admin" } },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text("Add Admin") }
        if (message.isNotEmpty()) {
            Text(message) } } }