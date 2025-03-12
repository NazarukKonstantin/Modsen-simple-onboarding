package com.example.onboarding.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.onboarding.R

val abel = FontFamily(
    Font(R.font.abel_regular, FontWeight.Normal)
)

val anek_malayalam = FontFamily(
    Font(R.font.anek_malayalam, FontWeight.Normal)
)

val sf_pro = FontFamily(
    Font(R.font.sf_pro, FontWeight.Normal)
)

val sf_pro_text = FontFamily(
    Font(R.font.sf_pro_text_black, FontWeight.Black),
    Font(R.font.sf_pro_text_bold, FontWeight.Bold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = sf_pro_text,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Start,
        color = Color.Red
    ),
    displayMedium = TextStyle(
        fontFamily = sf_pro,
        fontWeight = FontWeight.Normal,
        fontSize = 6.sp,
        lineHeight = 8.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = abel,
        fontWeight = FontWeight.Normal,
        fontSize = 6.sp,
        lineHeight = 8.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = anek_malayalam,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
    )
)