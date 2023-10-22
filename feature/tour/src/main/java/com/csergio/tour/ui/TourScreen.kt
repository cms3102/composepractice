package com.csergio.tour.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.csergio.common.ui.LoadingAnimation
import com.csergio.common.ui.MyScaffold
import com.csergio.tour.viewmodel.TourViewModel
import com.csergio.domain.entity.TourData
import com.csergio.tour.navigation.Tour
import com.csergio.tour.state.TourState

@Composable
fun TourScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    viewModel: TourViewModel,
    onItemClick: (item: TourData) -> Unit
) {
    val tourState = viewModel.tourState.collectAsStateWithLifecycle()
    MyScaffold(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        destination = Tour
    ) {
        when (val tourData = tourState.value) {
            is TourState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingAnimation()
                }
            }
            is TourState.Failure -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "데이터 로딩 실패",
                        textAlign = TextAlign.Center
                    )
                }
            }
            is TourState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(
                        items = tourData.data,
                        key = { it.id },
                    ) { tourData ->
                        TourItem(
                            item = tourData,
                            onItemClick = onItemClick
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TourItem(
    item: TourData,
    onItemClick: (item: TourData) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clickable {
                onItemClick(item)
            },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = item.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(6.dp)),
                )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = "장소 : ${item.title}",
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "설명 : ${item.description}",
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray.copy(alpha = 0.4f),
            thickness = 1.dp
        )
    }
}