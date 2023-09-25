package com.csergio.network.api

import com.csergio.network.model.CityDataModel
import retrofit2.Response
import retrofit2.http.GET

interface CityDataService {

    @GET
    suspend fun getCityData() : Response<List<CityDataModel>>

}