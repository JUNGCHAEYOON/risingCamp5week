package com.example.risingcamp5week.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SRService {
    @GET("SafetyRestrntInfo")
    fun getSRData(@Query("KEY") KEY : String,
                  @Query("Type") Type : String): Call<SRResponse>
}