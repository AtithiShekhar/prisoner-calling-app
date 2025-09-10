package com.example.prisonercalling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prisonercalling.ui.theme.PrisonManagementTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            PrisonManagementTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") { SplashScreen(navController) }
                    composable("login_selection") { LoginSelectionScreen(navController) }
                    composable("admin_login") { AdminLoginScreen(navController) }
                    composable("prisoner_login") { PrisonerLoginScreen(navController) }
                    composable("admin_home") { AdminHomeScreen(navController) }
                    composable("prisoner_home/{cardNumber}") { backStackEntry ->
                        val cardNumber = backStackEntry.arguments?.getString("cardNumber") ?: ""
                        PrisonerHomeScreen(navController, cardNumber) } } } } } }
