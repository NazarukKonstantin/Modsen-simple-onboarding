package com.example.onboarding

import androidx.annotation.DrawableRes

sealed class OnboardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
) {
    data object FirstPage: OnboardingModel(
        image = R.drawable.img_car1,
        title = "Your first car without \n" +
                "a driver's license",
        description = "Goes to meet people who just got their license"
    )

    data object SecondPage: OnboardingModel(
        image = R.drawable.img_car2,
        title = "Always there: more than 1000 cars in Tbilisi",
        description = "Our company is a leader by the number of cars in the fleet"
    )

    data object ThirdPage: OnboardingModel(
        image = R.drawable.img_car3,
        title = "Do not pay for parking, maintenance and gasoline",
        description = "We will pay for you, all expenses related to the car"
    )

    data object FourthPage: OnboardingModel(
        image = R.drawable.img_car4,
        title = "29 car models: from Skoda Octavia to Porsche 911",
        description = "Choose between regular car models \n" +
                "or exclusive ones"
    )
}