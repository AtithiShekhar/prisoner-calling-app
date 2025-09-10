package com.example.prisonercalling

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen(mainNavController: NavHostController) {
    val navController = rememberNavController()
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color(0xFF1976D2)
            ) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    label = { Text("Search") },
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                        navController.navigate("search") {
                            popUpTo("search") { inclusive = true } } })
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    },
                    label = { Text("Add") },
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        navController.navigate("add_options") {
                            popUpTo("add_options") { inclusive = true } } }) } },
        topBar = {
            TopAppBar(
                title = { Text("Admin Dashboard", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1976D2)
                ),
                actions = {
                    IconButton(
                        onClick = {
                            mainNavController.navigate("login_selection") {
                                popUpTo(0) { inclusive = true } } }) {
                        Icon(
                            Icons.Default.ExitToApp,
                            contentDescription = "Logout",
                            tint = Color.White) } }) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "search",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("search") { SearchPrisonerScreen() }
            composable("add_options") { AddOptionsScreen(navController) }
            composable("add_admin") { AddAdminScreen(navController) }
            composable("add_prisoner_1") { AddPrisonerScreen1(navController) }
            composable("add_prisoner_2") { AddPrisonerScreen2(navController) }
            composable("add_prisoner_3") { AddPrisonerScreen3(navController) }
        }
    }
}