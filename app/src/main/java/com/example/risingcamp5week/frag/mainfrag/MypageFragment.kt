package com.example.risingcamp5week.frag.mainfrag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.risingcamp5week.R


class MypageFragment : Fragment() {

    private var TAG = "BBBBBBBB"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // mainActivity 로 부터 넘겨받은 카카오톡 로그인 데이터
        val userName = arguments?.getString("userName")
        val userImageUrl = arguments?.getString("userImageUrl")
        if (userName != null) {
            Log.d(TAG,userName )
        }else{
            Log.d(TAG,"전달 안됬어요씨발" )
        }

        // 이미지뷰, 텍스트뷰에 넣기
        val iv_mypage_profile = view.findViewById<ImageView>(R.id.iv_mypage_profile)
        val tv_mypage_name = view.findViewById<TextView>(R.id.tv_mypage_name)
        tv_mypage_name.text = userName
        // 글라이드 이미지 둥글게
        Glide.with(view).load(userImageUrl).transform(CenterCrop(), RoundedCorners(20)).into(iv_mypage_profile)
    }

    override fun onStart() {
        super.onStart()
    }

}