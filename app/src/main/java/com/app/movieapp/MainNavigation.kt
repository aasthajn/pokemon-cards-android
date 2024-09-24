package com.app.movieapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.app.detail.cardDetailScreen
import com.app.detail.detailRoute
import com.app.home.homeRoute
import com.app.home.homeScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = homeRoute) {
        homeScreen {
            navController.navigate("{$detailRoute}/$it")
        }
        cardDetailScreen {
            navController.navigateUp()
        }
    }
}
