package com.app.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.domain.model.CardData
import com.app.home.presentation.CardListUiState
import com.app.ui.ErrorUI
import com.app.ui.ShimmerEffect


@Composable
internal fun HomeUI(
    modifier: Modifier,
    cardUIState: CardListUiState,
    onSelected: (String) -> Unit
) {
    when (cardUIState) {
        is CardListUiState.Loading -> ShimmerEffect()
        is CardListUiState.Error -> ErrorUI(message = cardUIState.message)
        is CardListUiState.Init -> ErrorUI(message = "Initialising")
        is CardListUiState.Success -> {
            //GridScreenFixed(modifier, cardList = cardUIState.cardData, onSelected)
            GridScreenAdaptive(modifier = modifier, cardList = cardUIState.cardData, onSelected)
        }
    }

}

@Composable
internal fun GridScreenFixed(
    modifier: Modifier,
    cardList: List<CardData>,
    onSelected: (String) -> Unit
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(4),
        content = {
            items(cardList.size) {
                val card = cardList[it]
                Card(
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onSelected(card.id) },
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                    ) {
                        AsyncImage(
                            model = card.thumbnail,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxWidth()
                        )
                    }
                }
            }
        })
}


@Composable
internal fun GridScreenAdaptive(
    modifier: Modifier,
    cardList: List<CardData>,
    onSelected: (String) -> Unit
) {
    Column(modifier.fillMaxSize()) {
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp),

            content = {
                items(cardList.size) {
                    val card = cardList[it]
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 4.dp, vertical = 4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onSelected(card.id) },
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                    ) {
                        Box {
                            AsyncImage(
                                model = card.thumbnail,
                                contentDescription = null,
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            })
    }
}

