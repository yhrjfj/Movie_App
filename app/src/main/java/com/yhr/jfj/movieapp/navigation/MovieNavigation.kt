package com.yhr.jfj.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yhr.jfj.movieapp.screens.home.HomeScreen
import com.yhr.jfj.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {

        // Navigation for home page
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        // Navigation for details screen
        composable(MovieScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }
    }
}