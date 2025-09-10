package com.example.prisonercalling

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
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
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        try {
            delay(3000)
            navController.navigate("login_selection") {
                popUpTo("splash") { inclusive = true }
                launchSingleTop = true
            }
        } catch (e: Exception) {
            Log.e("PrisonCalling", "Navigation error: ${e.message}", e)
        }
    }
    // ... rest of the code


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Call,
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            tint = Color(0xFF1976D2)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Prison Management",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1976D2),
            textAlign = TextAlign.Center
        )
        Text(
            text = "System",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
            color = Color(0xFF1976D2).copy(alpha = 0.9f)
        )
    }
}