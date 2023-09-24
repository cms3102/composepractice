package com.csergio.network.api

import com.csergio.network.model.CityData
import retrofit2.http.GET

interface CityDataService {

    @GET
    suspend fun getCityData() : List<CityData>

}