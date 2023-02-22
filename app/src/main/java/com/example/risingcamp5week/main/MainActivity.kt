package com.example.risingcamp5week.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.risingcamp5week.databinding.ActivityMainBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {

    // 뷰바인딩 변수 생성
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate로 레이아웃 생성
        binding = ActivityMainBinding.inflate(layoutInflater)
        // activity_main.xml 이 root 로 설정됨
        setContentView(binding.root)
    }
}