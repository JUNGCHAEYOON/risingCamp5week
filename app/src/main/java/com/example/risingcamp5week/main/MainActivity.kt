package com.example.risingcamp5week.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.risingcamp5week.R
import com.example.risingcamp5week.databinding.ActivityMainBinding
import com.example.risingcamp5week.frag.mainfrag.*

class MainActivity : AppCompatActivity() {

    // 뷰바인딩 변수 생성
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate로 레이아웃 생성
        binding = ActivityMainBinding.inflate(layoutInflater)
        // activity_main.xml 이 root 로 설정됨
        setContentView(binding.root)

        /* introActivity 로 부터 넘겨받은 카카오톡 유저데이터를 mypageFragment 로 전달 */
        val userName : String? = intent.getStringExtra("userName")
        val userImageUrl : String?= intent.getStringExtra("userImageUrl")
        // fragment 로 전달하기 위해 bundle 사용
        val mypageFragment = MypageFragment()
        val bundle = Bundle()
        bundle.putString("userName", userName)
        bundle.putString("userImageUrl", userImageUrl)
        mypageFragment.arguments = bundle


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
                        mypageFragment
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