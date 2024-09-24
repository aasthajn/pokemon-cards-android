package com.app.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun ShimmerEffect() {
    // Define the shimmer colors (you can adjust these to better suit your app's theme)
    val colors = listOf(
        Color.LightGray.copy(alpha = 0.3f),
        Color.LightGray,
        Color.LightGray.copy(alpha = 0.3f)
    )

    // Create an infinite repeating animation
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val xShimmer by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    // Define the gradient shader
    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = Offset(x = 1000f * xShimmer, y = 1000f * xShimmer) // Move the gradient diagonally
    )

    // Create a Box that displays the shimmer animation
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    )
}
