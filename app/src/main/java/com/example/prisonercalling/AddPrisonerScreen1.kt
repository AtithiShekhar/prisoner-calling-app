package com.example.prisonercalling

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore

object PrisonerData {
    var prisonerId: String = ""
    var prisonerName: String = ""
    var fatherHusbandName: String = ""
    var motherName: String = ""
    var gender: String = ""
    var age: String = ""
    var idProof: String = ""
    var idNumber: String = ""
    var admissionDate: String = ""
    var religion: String = ""
    var nationality: String = ""
    var state: String = ""
    var district: String = ""
    var address: String = ""
    var identificationMark: String = ""
    var prisonerType: String = ""
    var securityType: String = ""
    var entryType: String = ""
    var cardNumber: String = ""
    var rfid: String = ""
    var amount: String = ""
    var callNumber1: String = ""
    var callName1: String = ""
    var callNumber2: String = ""
    var callName2: String = ""
    var callNumber3: String = ""
    var callName3: String = "" }
@Composable
fun AddPrisonerScreen1(navController: NavHostController) {
    var prisonerId by remember { mutableStateOf(PrisonerData.prisonerId) }
    var prisonerName by remember { mutableStateOf(PrisonerData.prisonerName) }
    var fatherHusbandName by remember { mutableStateOf(PrisonerData.fatherHusbandName) }
    var motherName by remember { mutableStateOf(PrisonerData.motherName) }
    var gender by remember { mutableStateOf(PrisonerData.gender) }
    var age by remember { mutableStateOf(PrisonerData.age) }
    var idProof by remember { mutableStateOf(PrisonerData.idProof) }
    var idNumber by remember { mutableStateOf(PrisonerData.idNumber) }
    var admissionDate by remember { mutableStateOf(PrisonerData.admissionDate) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        Text("Add Prisoner - Page 1/3")

        OutlinedTextField(
            value = prisonerId,
            onValueChange = { prisonerId = it },
            label = { Text("Prisoner ID") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = prisonerName,
            onValueChange = { prisonerName = it },
            label = { Text("Prisoner Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = fatherHusbandName,
            onValueChange = { fatherHusbandName = it },
            label = { Text("Father/Husband Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = motherName,
            onValueChange = { motherName = it },
            label = { Text("Mother Name") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp))
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Gender") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = idProof,
            onValueChange = { idProof = it },
            label = { Text("ID Proof") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp))
        OutlinedTextField(
            value = idNumber,
            onValueChange = { idNumber = it },
            label = { Text("ID Number") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = admissionDate,
            onValueChange = { admissionDate = it },
            label = { Text("Admission Date") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp))
        Button(
            onClick = {
                PrisonerData.prisonerId = prisonerId
                PrisonerData.prisonerName = prisonerName
                PrisonerData.fatherHusbandName = fatherHusbandName
                PrisonerData.motherName = motherName
                PrisonerData.gender = gender
                PrisonerData.age = age
                PrisonerData.idProof = idProof
                PrisonerData.idNumber = idNumber
                PrisonerData.admissionDate = admissionDate
                navController.navigate("add_prisoner_2")
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        ) {
            Text("Next") } } }
@Composable
fun AddPrisonerScreen2(navController: NavHostController) {
    var religion by remember { mutableStateOf(PrisonerData.religion) }
    var nationality by remember { mutableStateOf(PrisonerData.nationality) }
    var state by remember { mutableStateOf(PrisonerData.state) }
    var district by remember { mutableStateOf(PrisonerData.district) }
    var address by remember { mutableStateOf(PrisonerData.address) }
    var identificationMark by remember { mutableStateOf(PrisonerData.identificationMark) }
    var prisonerType by remember { mutableStateOf(PrisonerData.prisonerType) }
    var securityType by remember { mutableStateOf(PrisonerData.securityType) }
    var entryType by remember { mutableStateOf(PrisonerData.entryType) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        Text("Add Prisoner - Page 2/3")

        OutlinedTextField(
            value = religion,
            onValueChange = { religion = it },
            label = { Text("Religion") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = nationality,
            onValueChange = { nationality = it },
            label = { Text("Nationality") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = state,
            onValueChange = { state = it },
            label = { Text("State") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = district,
            onValueChange = { district = it },
            label = { Text("District") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = identificationMark,
            onValueChange = { identificationMark = it },
            label = { Text("Identification Mark") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = prisonerType,
            onValueChange = { prisonerType = it },
            label = { Text("Prisoner Type") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp))
        OutlinedTextField(
            value = securityType,
            onValueChange = { securityType = it },
            label = { Text("Security Type") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp))
        OutlinedTextField(
            value = entryType,
            onValueChange = { entryType = it },
            label = { Text("Entry Type") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(1f).padding(end = 4.dp)
            ) {
                Text("Back") }
            Button(
                onClick = {
                    PrisonerData.religion = religion
                    PrisonerData.nationality = nationality
                    PrisonerData.state = state
                    PrisonerData.district = district
                    PrisonerData.address = address
                    PrisonerData.identificationMark = identificationMark
                    PrisonerData.prisonerType = prisonerType
                    PrisonerData.securityType = securityType
                    PrisonerData.entryType = entryType
                    navController.navigate("add_prisoner_3")
                },
                modifier = Modifier.weight(1f).padding(start = 4.dp)
            ) {
                Text("Next") } } } }
@Composable
fun AddPrisonerScreen3(navController: NavHostController) {
    var cardNumber by remember { mutableStateOf(PrisonerData.cardNumber) }
    var rfid by remember { mutableStateOf(PrisonerData.rfid) }
    var amount by remember { mutableStateOf(PrisonerData.amount) }
    var callNumber1 by remember { mutableStateOf(PrisonerData.callNumber1) }
    var callName1 by remember { mutableStateOf(PrisonerData.callName1) }
    var callNumber2 by remember { mutableStateOf(PrisonerData.callNumber2) }
    var callName2 by remember { mutableStateOf(PrisonerData.callName2) }
    var callNumber3 by remember { mutableStateOf(PrisonerData.callNumber3) }
    var callName3 by remember { mutableStateOf(PrisonerData.callName3) }
    var message by remember { mutableStateOf("") }

    val db = FirebaseFirestore.getInstance()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState())
    ) {
        Text("Add Prisoner - Page 3/3")

        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            label = { Text("Card Number") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = rfid,
            onValueChange = { rfid = it },
            label = { Text("RFID") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        Text("Family Member 1:")
        OutlinedTextField(
            value = callName1,
            onValueChange = { callName1 = it },
            label = { Text("Name 1") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )
        OutlinedTextField(
            value = callNumber1,
            onValueChange = { callNumber1 = it },
            label = { Text("Number 1") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        Text("Family Member 2:")
        OutlinedTextField(
            value = callName2,
            onValueChange = { callName2 = it },
            label = { Text("Name 2") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )
        OutlinedTextField(
            value = callNumber2,
            onValueChange = { callNumber2 = it },
            label = { Text("Number 2") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        Text("Family Member 3:")
        OutlinedTextField(
            value = callName3,
            onValueChange = { callName3 = it },
            label = { Text("Name 3") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )
        OutlinedTextField(
            value = callNumber3,
            onValueChange = { callNumber3 = it },
            label = { Text("Number 3") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(1f).padding(end = 4.dp)
            ) {
                Text("Back") }
            Button(
                onClick = {
                    val prisoner = Prisoner(
                        prisonerId = PrisonerData.prisonerId,
                        prisonerName = PrisonerData.prisonerName,
                        fatherHusbandName = PrisonerData.fatherHusbandName,
                        motherName = PrisonerData.motherName,
                        gender = PrisonerData.gender,
                        age = PrisonerData.age.toIntOrNull() ?: 0,
                        idProof = PrisonerData.idProof,
                        idNumber = PrisonerData.idNumber,
                        admissionDate = PrisonerData.admissionDate,
                        religion = PrisonerData.religion,
                        nationality = PrisonerData.nationality,
                        state = PrisonerData.state,
                        district = PrisonerData.district,
                        address = PrisonerData.address,
                        identificationMark = PrisonerData.identificationMark,
                        prisonerType = PrisonerData.prisonerType,
                        securityType = PrisonerData.securityType,
                        entryType = PrisonerData.entryType,
                        cardNumber = cardNumber,
                        rfid = rfid,
                        amount = amount.toLongOrNull() ?: 0L,
                        callNumber1 = callNumber1,
                        callName1 = callName1,
                        callNumber2 = callNumber2,
                        callName2 = callName2,
                        callNumber3 = callNumber3,
                        callName3 = callName3)
                    db.collection("prisoners")
                        .add(prisoner)
                        .addOnSuccessListener {
                            if (callNumber1.isNotEmpty()) {
                                val receiver1 = Receiver(
                                    prisonerCardNumber = cardNumber,
                                    prisonerName = PrisonerData.prisonerName,
                                    receiverName = callName1,
                                    phoneNumber = callNumber1
                                )
                                db.collection("receivers").add(receiver1)
                            }

                            if (callNumber2.isNotEmpty()) {
                                val receiver2 = Receiver(
                                    prisonerCardNumber = cardNumber,
                                    prisonerName = PrisonerData.prisonerName,
                                    receiverName = callName2,
                                    phoneNumber = callNumber2
                                )
                                db.collection("receivers").add(receiver2)
                            }

                            if (callNumber3.isNotEmpty()) {
                                val receiver3 = Receiver(
                                    prisonerCardNumber = cardNumber,
                                    prisonerName = PrisonerData.prisonerName,
                                    receiverName = callName3,
                                    phoneNumber = callNumber3
                                )
                                db.collection("receivers").add(receiver3) }
                            message = "Prisoner added successfully"
                        }
                        .addOnFailureListener {
                            message = "Failed to add prisoner" } },
                modifier = Modifier.weight(1f).padding(start = 4.dp)) {
                Text("Save") } }
        if (message.isNotEmpty()) {
            Text(message) } } }