package com.example.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProgressBarButton(
    progress: () -> Float,
    color: Color = Color.Black,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
//        modifier = Modifier.background(color = Color.Green)
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier
                .size(74.dp),
            color = MaterialTheme.colorScheme.onBackground,
            strokeWidth = 2.dp,
            trackColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.4f)
        )
        Button(
            modifier = Modifier
                .size(54.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            onClick = onClick
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector_9),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(14.dp),
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(color)

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun First() {
    ProgressBarButton({ 0.25f }) { }
}

@Preview(showBackground = true)
@Composable
fun Second() {
    ProgressBarButton({ 0.5f }) { }
}

@Preview(showBackground = true)
@Composable
fun Third() {
    ProgressBarButton({ 0.75f }) { }
}

@Preview(showBackground = true)
@Composable
fun Fourth() {
    ProgressBarButton({ 1f }) { }
}