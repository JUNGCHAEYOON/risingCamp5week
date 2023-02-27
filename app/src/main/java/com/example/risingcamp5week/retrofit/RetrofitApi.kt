package com.example.risingcamp5week.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitApi {
    private const val BASE_URL = "https://openapi.gg.go.kr/"

    // lazy 를 붙이는 이유는 사용되는 순간이 와야지 비로소
    // 단하나의 인스턴스만이 만들어짐
    // 싱글톤으로 자원낭비 방지

    private val okHttpClient : OkHttpClient by lazy{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply{
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    val sRService : SRService by lazy{
        retrofit.create(SRService::class.java)
    }
}