package com.csergio.tour.screen

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.csergio.common.theme.PaddingDefaults
import com.csergio.common.theme.SpaceDefaults
import com.csergio.common.ui.MyScaffold
import com.csergio.domain.entity.TourData
import com.csergio.tour.navigation.TourDetail

@Composable
fun TourDetailScreen(
    navController: NavController,
    data: TourData
) {
    MyScaffold(
        navController = navController,
        destination = TourDetail
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            AsyncImage(
                model = data.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(1f/0.7f)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = PaddingDefaults.paddingHorizontal)
                    .verticalScroll(rememberScrollState())
            ) {
                SpaceDefaults.verticalSpacer()
                Text(
                    text = "data.title",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.Start)
                )
                SpaceDefaults.verticalSpacer()
                Text(
                    text = data.description,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }
    }
}