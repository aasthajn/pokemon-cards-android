package com.app.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.home.ui.HomeScreen


const val homeRoute = "home"

fun NavGraphBuilder.homeScreen(onNavigateToCard: (String) -> Unit) {
    composable(homeRoute) {
        HomeScreen(
            onNavigateToCard = onNavigateToCard
        )
    }
}
