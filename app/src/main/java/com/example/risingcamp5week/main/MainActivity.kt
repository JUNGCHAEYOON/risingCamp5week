package com.example.risingcamp5week.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.risingcamp5week.R
import com.example.risingcamp5week.databinding.ActivityMainBinding
import com.example.risingcamp5week.frag.*
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

        /* 바텀 네비게이션 */
        val bnv_main = binding.bnvMain
        bnv_main.setOnItemSelectedListener { item ->
            changeFragment(
                when(item.itemId){
                    R.id.item1 ->{
                        MatzipFragment()
                        // Respond to navigation item 1 click
                    }
                    R.id.item2 ->{
                        HalinFragment()
                        // Respond to navigation item 1 click
                    }
                    R.id.item4 ->{
                        SosikFragment()
                        // Respond to navigation item 1 click
                    }
                    R.id.item5 ->{
                        MypageFragment()
                        // Respond to navigation item 1 click
                    }
                    else ->{
                        AddFragment()
                        // Respond to navigation item 1 click
                    }

                }
            )
            true
        }
        bnv_main.selectedItemId = R.id.item1
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }
}