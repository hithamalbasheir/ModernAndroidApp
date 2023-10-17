package com.hitham.modernandroidsample.data.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("hitham.net/medicines")
    suspend fun getMedicineData(): Response<MedicineResponse>
}