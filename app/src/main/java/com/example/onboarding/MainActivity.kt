package com.example.onboarding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.onboarding.ui.theme.OnBoardingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnBoardingTheme {
                val context = LocalContext.current

                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    OnboardingScreenUI {
                        Toast.makeText(context, "Onboarding Completed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}