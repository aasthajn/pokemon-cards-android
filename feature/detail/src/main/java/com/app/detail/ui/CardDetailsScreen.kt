package com.app.detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.app.detail.presentation.CardDetailUiState
import com.app.detail.presentation.CardDetailViewModel
import com.app.ui.ErrorUI
import com.app.ui.LoaderUI
import com.app.ui.TopBar

@Composable
internal fun CardDetailsScreen(onNavigateBack: () -> Unit) {
    Scaffold(topBar = {
        TopBar(title = "Card Details", isHome = false) {
            onNavigateBack()
        }
    }) {
        val contentModifier = Modifier.padding(it)
        val viewModel = hiltViewModel<CardDetailViewModel>()
        val cardUiState = viewModel.cardDetails.collectAsStateWithLifecycle().value
        Box(
            modifier = contentModifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CardDetails(cardUiState)
        }
    }
}

@Composable
internal fun CardDetails(uiState: CardDetailUiState) {
    when (uiState) {
        is CardDetailUiState.Error -> ErrorUI(message = uiState.message)
        is CardDetailUiState.Init -> ErrorUI(message = "Initialising")
        is CardDetailUiState.Loading -> LoaderUI()
        is CardDetailUiState.Success -> {

            val loading = rememberAsyncImagePainter(LoaderUI())
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(uiState.cardData.image)
                    .diskCacheKey(uiState.cardData.image)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = loading,
                contentScale = ContentScale.Fit,
            )

        }
    }
}

