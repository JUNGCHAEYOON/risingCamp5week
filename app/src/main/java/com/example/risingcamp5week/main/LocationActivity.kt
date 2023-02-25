package com.example.risingcamp5week.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingcamp5week.R
import com.example.risingcamp5week.databinding.ActivityLocationBinding
import net.daum.android.map.MapView
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPOIItem.MarkerType
import net.daum.mf.map.api.MapPoint.mapPointWithGeoCoord


class LocationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 가게 이름 받아오기
        val title = intent.getStringExtra("title")
        binding.tvLocationTitle.text = title

        /*카카오 지도 표시!*/
        val locationPoint = mapPointWithGeoCoord( intent.getDoubleExtra("lat",0.0), intent.getDoubleExtra("long", 0.0))
//        val locationPoint = mapPointWithGeoCoord( 37.62952779385139, 126.86311704725081)
        val mv_location = binding.mvLocation
        mv_location.setMapCenterPoint(locationPoint,true)

        // 마커 추가
        val marker = MapPOIItem()
        marker.itemName = title
        marker.setTag(0)
        marker.mapPoint = locationPoint
        mv_location.addPOIItem(marker)
    }

    override fun onResume() {
        super.onResume()

        // 뒤 화살 버튼 누르면 액티비티 종료! startActivity 가 아님 onDestroy 호출
        val iv_location_back = binding.ivLocationBack
        iv_location_back.setOnClickListener {
            finish()
        }
    }
}