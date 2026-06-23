package com.example.expandmalangtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expandmalangtest.navigation.Screen
import com.example.expandmalangtest.ui.screens.*
import com.example.expandmalangtest.ui.theme.ExpandMalangTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpandMalangTestTheme(darkTheme = false, dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AppNavigationLayout()
                }
            }
        }
    }
}

@Composable
fun AppNavigationLayout() {
    var isLoggedIn by remember { mutableStateOf(false) }

    if (!isLoggedIn) {
        LoginScreen(onLoginSuccess = { isLoggedIn = true })
    } else {
        MainAppContent()
    }
}

@Composable
fun MainAppContent() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        containerColor = Color.White,
        contentColor = Color.Black,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                tonalElevation = 0.dp // Matikan elevasi agar tidak ada bayangan abu-abu
            ) {
                val items = listOf(
                    NavigationItemInfo("Home", Screen.Home.route, Icons.Default.Home),
                    NavigationItemInfo("Explore", Screen.Explore.route, Icons.Default.Explore),
                    NavigationItemInfo("My Trips", Screen.MyTrips.route, Icons.Default.TravelExplore),
                    NavigationItemInfo("Profile", Screen.Profile.route, Icons.Default.Person)
                )

                items.forEach { item ->
                    val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) },
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF2D6A4F),
                            selectedTextColor = Color(0xFF2D6A4F),
                            indicatorColor = Color(0xFFB7E4C7)
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Explore.route) { ExploreScreen() }
            composable(Screen.MyTrips.route) { MyTripsScreen() }
            composable(Screen.Profile.route) { ProfileScreen() }
        }
    }
}

data class NavigationItemInfo(
    val title: String, 
    val route: String, 
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)
