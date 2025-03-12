package com.example.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingUI(onboardingModel: OnboardingModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.size(35.dp))
        Text(
            text = onboardingModel.title,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth().padding(30.dp,0.dp),

            )
        Spacer(
            modifier = Modifier
                .size(8.dp)
        )
        Text(
            text = onboardingModel.description,
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth().padding(10.dp,0.dp)
        )
        Spacer(
            modifier = Modifier
                .size(25.dp)
        )
        Image(
            painter = painterResource(id = onboardingModel.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding( 0.dp),
            alignment = Alignment.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingUI1() {
    OnboardingUI(OnboardingModel.FirstPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingUI2() {
    OnboardingUI(OnboardingModel.SecondPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingUI3() {
    OnboardingUI(OnboardingModel.ThirdPage)
}

@Preview(showBackground = true)
@Composable
fun OnboardingUI4() {
    OnboardingUI(OnboardingModel.FourthPage)
}