package com.example.risingcamp5week.main

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.risingcamp5week.R
import com.example.risingcamp5week.databinding.ActivityIntroBinding
import com.example.risingcamp5week.databinding.ActivityMainBinding
import com.example.risingcamp5week.frag.mainfrag.MypageFragment
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient

class IntroActivity : AppCompatActivity() {

    // 뷰바인딩 변수 생성
    private lateinit var binding : ActivityIntroBinding
    private var TAG = "AAAAAAAAAAAAAAAAAAA"

    // 유저 데이터
    private var userName : String = "홍길동"
    private var userImageUrl : String = "https://picsum.photos/id/237/200/300"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate로 레이아웃 생성
        binding = ActivityIntroBinding.inflate(layoutInflater)
        // activity_main.xml 이 root 로 설정됨
        setContentView(binding.root)

        /* 카카오계정으로 로그인 버튼! */
        val iv_main_kakaologinbtn = binding.ivIntroKakaologinbtn
        iv_main_kakaologinbtn.setOnClickListener {
            KakaoLogin()
        }

        /* 건너 뛰기 버튼 */
        val tv_intro_tomainbtn = binding.tvIntroTomainbtn
        tv_intro_tomainbtn.setOnClickListener {
            // 바로 메인 액티비티로!
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun KakaoLogin() {
        /*로그인 조합 예제*/
        // 카카오계정으로 로그인 공통 callback 구성
        // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e(TAG, "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                Log.i(TAG, "카카오계정으로 로그인 성공 ${token.accessToken}")
                //로그인 성공시 카카오 이미지, 카카오 닉네임 넘겨준다!
                getUserData()
            }
        }

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(baseContext)) {
            UserApiClient.instance.loginWithKakaoTalk(baseContext) { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오톡으로 로그인 실패", error)
                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }
                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(baseContext, callback = callback)
                } else if (token != null) {
                    Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                    //로그인 성공시 카카오 이미지, 카카오 닉네임 넘겨준다!
                    getUserData()
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(baseContext, callback = callback)
        }
    }
    
    // 로그인 성공시 카카오톡 유저이름, 이미지url 넘겨주며 메인액티비티로 실행하는 함수
    // 비동기 함수 이므로 intent를 비동기 내부에 포함하였음
    fun getUserData(){
        // 로그인 성공시 메인 액티비티로 이동!
        val intent = Intent(this, MainActivity::class.java)
        // 사용자 정보 요청 (기본)
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            }
            else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n회원번호: ${user.id}" +
                        "\n이메일: ${user.kakaoAccount?.email}" +
                        "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                        "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")
                userName = user.kakaoAccount?.profile?.nickname.toString()
                userImageUrl = user.kakaoAccount?.profile?.thumbnailImageUrl.toString()
                //메인 액티비티로 변수 전달
                intent.putExtra("userName",userName)
                intent.putExtra("userImageUrl",userImageUrl)
                // 메인 액티비티 시작
                startActivity(intent)


            }
        }
    }
}