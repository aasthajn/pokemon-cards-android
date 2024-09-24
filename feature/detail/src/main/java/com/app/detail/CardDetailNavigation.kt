package com.app.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.detail.ui.CardDetailsScreen

const val detailRoute = "cardDetail"
const val cardIdArg = "cardId"
fun NavGraphBuilder.cardDetailScreen(onNavigateBack: () -> Unit) {
    composable(
        "{$detailRoute}/{${cardIdArg}}",
        arguments = listOf(navArgument(cardIdArg) { type = NavType.StringType })
    ) {
        CardDetailsScreen(
            onNavigateBack = onNavigateBack
        )
    }
}
