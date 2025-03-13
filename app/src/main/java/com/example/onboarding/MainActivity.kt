package com.example.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.onboarding.ui.theme.OnBoardingTheme
import com.example.onboarding.ui.theme.fourthPageColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingTheme(dynamicColor = false) {
                OnboardingScreenUI {
                    setContent {
                        OnBoardingTheme(dynamicColor = false) {
                            ShowFinalScreen()
                        }
                    }
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun ShowFinalScreen() {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color = fourthPageColor)
            .fillMaxSize(),
    )
    {
        Text(
            text = "You are a clever person!",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}