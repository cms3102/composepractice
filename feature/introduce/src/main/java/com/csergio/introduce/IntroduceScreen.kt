package com.csergio.introduce

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.csergio.features.introduce.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroduceScreen(onFinished: () -> Unit) {
    val pagerState = rememberPagerState { introList.size }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
        ) { page ->
            IntroItem(introList[page], page)
        }
        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                introList.forEachIndexed { index, _ ->
                    Box(modifier = Modifier.padding(4.dp)) {
                        Box(
                            modifier = Modifier
                                .background(
                                    color = if (index == pagerState.currentPage) {
                                        MaterialTheme.colorScheme.primary
                                    } else {
                                        Color.LightGray.copy(alpha = 0.5f)
                                    },
                                    shape = CircleShape
                                )
                                .size(10.dp)
                        )
                    }
                }
            }
            Button(
                modifier = Modifier
                    .padding(20.dp)
                    .animateContentSize(),
                onClick = {
                    coroutineScope.launch {
                        if (pagerState.isLastPage().not()) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        } else {
                            onFinished.invoke()
                        }
                    }
                },
                shape = CircleShape
            ) {
                Text(text = if (pagerState.isLastPage()) "시작해 볼까요" else "다음")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun PagerState.isLastPage(): Boolean {
    return currentPage == introList.lastIndex
}

@Composable
fun IntroItem(item: Intro, page: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            border = BorderStroke(1.dp, Color.LightGray.copy(0.5f)),
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(15.dp),
                verticalArrangement = Arrangement.Center
            ) {
                val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(
                    when(page) {
                        0 -> R.raw.intro1
                        1 -> R.raw.intro2
                        else -> R.raw.intro3
                    }
                ))
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier
                        .size(280.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = item.title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displaySmall,
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = item.desc,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}

data class Intro(
    val title: String,
    val desc: String
)

private val introList = listOf(
    Intro(title = "안녕하세요", desc = "만나서 반가워요"),
    Intro(title = "무슨 말을 해야 할지", desc = "모르겠어요.."),
    Intro(title = "여기서 마무리 하고", desc = "넘어가 볼까요"),
)

@Preview
@Composable
fun IntroduceScreenPreview() {
    IntroduceScreen { }
}