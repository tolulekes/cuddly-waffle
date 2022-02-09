package com.toluleke.mktfy.ui.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.geometry.Offset
import com.toluleke.mktfy.models.LoadState

@Composable
fun LoadState(
    loadState: LoadState,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = Modifier) {
        when (loadState){
            is LoadState.Error -> TODO()
            is LoadState.Loading -> TODO()
            is LoadState.Success -> TODO()
            else -> content()
        }
    }
}

@Composable
fun ProgressArc(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface,
    percent: Int
) {
    val padding = 50f
    val radius = 109f
    val animateFloat = remember{ Animatable(0f) }
    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = tween(3000, easing = LinearEasing)
        )
    }
    Canvas(modifier = modifier
        .fillMaxSize()
    ){

        drawArc(
            color = backgroundColor,
            startAngle = 0f,
            sweepAngle = 90f * animateFloat.value,
            useCenter = false,
            size = Size(radius * (percent / 100f), radius * (percent / 100f)),
            topLeft = Offset(x = padding/2f, y = padding/2f),
            style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round)
        )

    }
}

