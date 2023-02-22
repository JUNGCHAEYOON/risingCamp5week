package com.example.risingcamp5week.auth

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 다른 초기화 코드들

        // kakao 초기화
        KakaoSdk.init(this, "2bb65357084c33cfdcd5a54e067d3cfa")
    }
}