package com.example.prisonercalling

import java.util.*

data class Admin(
    val name: String = "",
    val id: String = "",
    val password: String = ""
)

data class Prisoner(
    val prisonerId: String = "",
    val prisonerName: String = "",
    val fatherHusbandName: String = "",
    val motherName: String = "",
    val gender: String = "",
    val age: Int = 0,
    val idProof: String = "",
    val idNumber: String = "",
    val admissionDate: String = "",
    val religion: String = "",
    val nationality: String = "",
    val state: String = "",
    val district: String = "",
    val address: String = "",
    val identificationMark: String = "",
    val prisonerType: String = "",
    val securityType: String = "",
    val entryType: String = "",
    val callNumber1: String = "",
    val callName1: String = "",
    val callNumber2: String = "",
    val callName2: String = "",
    val callNumber3: String = "",
    val callName3: String = "",
    val cardStatus: Boolean = true,
    val photoUrl: String = "",
    val createdAt: Date = Date(),
    val updatedAt: Date = Date(),
    val createdBy: String = "",
    val cardNumber: String = "",
    val rfid: String = "",
    val amount: Long = 0L
)

data class Receiver(
    val prisonerCardNumber: String = "",
    val prisonerName: String = "",
    val receiverName: String = "",
    val phoneNumber: String = ""
)