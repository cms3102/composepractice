package com.csergio.network.api

import com.csergio.network.model.TourResponse
import retrofit2.Response
import retrofit2.http.GET

interface TourDataService {

    @GET("v3/47f63e6b-129f-42a5-817a-ad6ee811e81b")
    suspend fun getTourData() : Response<TourResponse>

}