package com.example.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoppinglist.ui.theme.ShoppingListTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShoppingListApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // 🔹 Drawer + Scaffold
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = when(currentRoute){
                        "home" -> "Shopping List"
                        "profile" -> "Profile"
                        "setting" -> "Setting"
                        else -> "Shopping List"
                    },
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )

                NavigationDrawerItem(
                    label = { Text("Setting") },
                    selected = currentRoute == "setting",
                    onClick = {
                        navController.navigate("setting")
                        scope.launch { drawerState.close() }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(
                        text = when(currentRoute){
                        "home" -> "Shopping List"
                        "profile" -> "Profile"
                        "setting" -> "Setting"
                        else -> "Shopping List"
                    },
                        )},
                    navigationIcon = {
                        IconButton(onClick = {scope.launch { drawerState.open() }}) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = currentRoute == "home",
                        onClick = {navController.navigate("home")},
                        label = {Text("Home")},
                        icon = {Icon(Icons.Default.Home, contentDescription = null)}
                    )
                    NavigationBarItem(
                        selected = currentRoute == "profile",
                        onClick = {navController.navigate("profile")},
                        label = {Text("Profile")},
                        icon = {Icon(Icons.Default.Person, contentDescription = null)}
                    )
                    NavigationBarItem(
                        selected = currentRoute == "setting",
                        onClick = {navController.navigate("setting")},
                        label = {Text("Setting")},
                        icon = {Icon(Icons.Default.Settings, contentDescription = null)}
                    )
                }
            }
        ) { innerPadding ->
            NavHost(
                navController, "home", Modifier.padding(innerPadding)
            ) {
                composable("home") { HomeScreen(navController) }
                composable("profile") { ProfileScreen() }
                composable("setting") { SettingScreen() }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Profile,
        Screen.Setting
    )

    NavigationBar {
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

// 🔹 Screen data class untuk navigasi bawah
sealed class Screen(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
    object Setting : Screen("setting", "Setting", Icons.Default.Settings)
}



@Preview(showBackground = true)
@Composable
fun ShoppingListPreview() {
    ShoppingListTheme {
        ShoppingListApp()
    }
}
