package com.semba.cryptowallet.design.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.semba.cryptowallet.ui.theme.*

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier
) {

    val transition = rememberInfiniteTransition()

    val currentArchStartAngle by transition.animateValue(
        initialValue = 0,
        targetValue = 360,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    )

    val strokeWidth = 30.dp
    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
    }

    Canvas(modifier = modifier.progressSemantics().size(48.dp).padding(strokeWidth/2)) {
        drawCircle(color = ProgressBarLight, style = stroke)

        drawArc(
            color = ProgressBar ,
            startAngle = currentArchStartAngle.toFloat() - 90,
            sweepAngle = 90f,
            useCenter = false,
            style = stroke
        )
    }
}