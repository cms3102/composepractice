package com.csergio.citydata

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.csergio.citydata.viewmodel.CityDataViewModel
import com.csergio.domain.entity.CityData

@Composable
fun CityDataScreen(viewModel: CityDataViewModel) {
    val cityDataState = viewModel.cityDataState.collectAsStateWithLifecycle()
    when (val cityData = cityDataState.value) {
        is CityDataState.Loading -> { Text("데이터 로딩 중") }
        is CityDataState.Failure -> { Text("데이터 로딩 실패") }
        is CityDataState.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(
                    items = cityData.data,
                    key = { it.id },
                ) { cityData ->
                    CityDataItem(cityData)
                }
            }
        }
    }
}

@Composable
fun CityDataItem(item: CityData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = item.image,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(item.title)
            Spacer(modifier = Modifier.height(2.dp))
            Text(item.description)
        }
    }
}