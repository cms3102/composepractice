package com.csergio.introduce

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroduceScreen(onFinished: () -> Unit) {
    val pagerState = rememberPagerState { introList.size }
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
        ) { page ->
            IntroItem(introList[page])
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                introList.forEachIndexed { index, intro ->
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        tint = if (index == pagerState.currentPage) Color.Red else Color.Gray
                    )
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
                Text(text = if (pagerState.isLastPage()) "Let's Start" else "Next")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun PagerState.isLastPage(): Boolean {
    return currentPage == introList.lastIndex
}

@Composable
fun IntroItem(item: Intro) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = item.title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayMedium,
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

private val introList = listOf<Intro>(
    Intro(title = "소개 1번 입니다.", desc = "소개 1번 설명 입니다."),
    Intro(title = "소개 2번 입니다.", desc = "소개 2번 설명 입니다."),
    Intro(title = "소개 3번 입니다.", desc = "소개 3번 설명 입니다."),
)