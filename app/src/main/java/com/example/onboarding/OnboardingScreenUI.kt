package com.example.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreenUI(onFinished: () -> Unit) {
    val pages = listOf(
        OnboardingModel.FirstPage,
        OnboardingModel.SecondPage,
        OnboardingModel.ThirdPage,
        OnboardingModel.FourthPage
    )

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("Skip", "Next")
                1 -> listOf("Skip", "Next")
                2 -> listOf("Skip", "Next")
                3 -> listOf("Skip", "Start")
                else -> listOf("", "")
            }
        }
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = pages[pagerState.currentPage].backgroundColor,
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 60.dp)
                    .background(color = Color.Transparent),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        IndicatorUI(pageSize = pages.size, currentPage = pagerState.currentPage)
                    }
                    Box(
                        Modifier.padding(0.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (buttonState.value[0].isNotEmpty()) {
                            TextButton(
                                contentPadding = PaddingValues(0.dp),
                                modifier = Modifier.defaultMinSize(),
                                onClick = {
                                    scope.launch {
                                        if (pagerState.currentPage < pages.size - 1) {
                                            onFinished()
                                        }
                                    }
                                }) {
                                Text(
                                    text = buttonState.value[0],
                                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    ProgressBarButton(
                        progress = {(pagerState.currentPage+1)*0.25f},
                        color = pages.elementAt(pagerState.currentPage).backgroundColor
                    ) {
                        scope.launch{
                            if(pagerState.currentPage<pages.size - 1){
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                            else{
                                onFinished()
                            }
                        }
                    }
                }
            }
        },
        content = {
            Column(Modifier.padding(it)) {
                HorizontalPager(state = pagerState) { index ->
                    OnboardingUI(onboardingModel = pages[index])
                }
            }
        }
    )
}

@Preview(showBackground = false)
@Composable
fun OnboardingScreenUIPreview() {
    OnboardingScreenUI {

    }
}