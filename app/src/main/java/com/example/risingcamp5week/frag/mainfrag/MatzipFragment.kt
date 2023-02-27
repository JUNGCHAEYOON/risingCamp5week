package com.example.risingcamp5week.frag.mainfrag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp5week.R
import com.example.risingcamp5week.recycler.MatzipHorizontalAdapter
import com.example.risingcamp5week.recycler.MatzipHorizontalItem
import com.example.risingcamp5week.recycler.MatzipVerticalAdapter
import com.example.risingcamp5week.recycler.MatzipVerticalItem
import com.example.risingcamp5week.retrofit.RetrofitApi
import com.example.risingcamp5week.retrofit.Row
import com.example.risingcamp5week.retrofit.SRResponse
import com.example.risingcamp5week.retrofit.SRService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MatzipFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_matzip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // viewflipper
        val vf_matzip = view.findViewById<ViewFlipper>(R.id.vf_matzip)
        vf_matzip.startFlipping()

        /* horizontal recyclerview */
        val rv_matzip_horizontal = view.findViewById<RecyclerView>(R.id.rv_matzip_horizontal)   // 리싸이클러뷰 세로방향 변수 선언
        val itemList_horizontal = ArrayList<MatzipHorizontalItem>()                             // 아이템 선언

        // add
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니 맛나","고길동",R.drawable.katsu))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니 맛나","고길동",R.drawable.katsu))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니 맛나","고길동",R.drawable.katsu))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니 맛나","고길동",R.drawable.katsu))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니 맛나","고길동",R.drawable.katsu))

        // 어댑터 변수선언
        val matzipHorizontalAdapter = MatzipHorizontalAdapter(itemList_horizontal)
        matzipHorizontalAdapter.notifyDataSetChanged()
        rv_matzip_horizontal.adapter = matzipHorizontalAdapter
        rv_matzip_horizontal.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)


//        /* vertical recyclerview */
//        val rv_matzip_vertical = view.findViewById<RecyclerView>(R.id.rv_matzip_vertical)
//        val itemList_vertical = ArrayList<MatzipVerticalItem>()

        // 레트로핏으로 경기도 식당 api 받아옴!
        retrofitWork()

//        // add
//        itemList_vertical.add(MatzipVerticalItem(R.drawable.ikea512,"고양시 522m","이케아 레스토랑","양식/ 기타 양식","3.6","(리뷰 32)",37.62952779385139, 126.86311704725081))
//        itemList_vertical.add(MatzipVerticalItem(R.drawable.thefesta600,"고양시 544m","더 페스타","양식/ 이탈리안","3.2","(리뷰 31)",37.62638025481359, 126.87324785223427))
//        itemList_vertical.add(MatzipVerticalItem(R.drawable.bgdd512,"고양시 874m","버건디도어","카페/ 디저트","3.2","(리뷰 30)",37.62728816160029, 126.85721915663338))
//        itemList_vertical.add(MatzipVerticalItem(R.drawable.kontai512,"고양시 458m","콘타이(이케아 고양점)","세계음식/ 태국음식","3.3","(리뷰 9)",37.62907493389039, 126.86263075305223))
//        itemList_vertical.add(MatzipVerticalItem(R.drawable.coffetosta512,"고양시 557m","커피토스타","카페/ 디저트","3.2","(리뷰 2)",37.63035753308983, 126.87188165633245))
//        itemList_vertical.add(MatzipVerticalItem(R.drawable.americantrailor350,"고양시 458m","아메리칸트레일러","카페/ 디저트","3.0","(리뷰 1)",37.64322463641078, 126.78968985817387))
//

//        // 어댑터
//        val matzipVerticalAdapter = MatzipVerticalAdapter(itemList_vertical)
//        matzipVerticalAdapter.notifyDataSetChanged()
//        rv_matzip_vertical.adapter = matzipVerticalAdapter
//        rv_matzip_vertical.layoutManager = GridLayoutManager(context,2)
    }


    private fun retrofitWork(){
        val service : SRService = RetrofitApi.sRService

        /* vertical recyclerview */
        val rv_matzip_vertical = view?.findViewById<RecyclerView>(R.id.rv_matzip_vertical)
        val itemList_vertical = ArrayList<MatzipVerticalItem>()

        // add
        itemList_vertical.add(MatzipVerticalItem(R.drawable.ikea512,"고양시 522m","이케아 레스토랑","양식/ 기타 양식","3.6","(리뷰 32)",37.62952779385139, 126.86311704725081))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.thefesta600,"고양시 544m","더 페스타","양식/ 이탈리안","3.2","(리뷰 31)",37.62638025481359, 126.87324785223427))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.bgdd512,"고양시 874m","버건디도어","카페/ 디저트","3.2","(리뷰 30)",37.62728816160029, 126.85721915663338))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.kontai512,"고양시 458m","콘타이(이케아 고양점)","세계음식/ 태국음식","3.3","(리뷰 9)",37.62907493389039, 126.86263075305223))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.coffetosta512,"고양시 557m","커피토스타","카페/ 디저트","3.2","(리뷰 2)",37.63035753308983, 126.87188165633245))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.americantrailor350,"고양시 458m","아메리칸트레일러","카페/ 디저트","3.0","(리뷰 1)",37.64322463641078, 126.78968985817387))


        service.getSRData(getString(R.string.api_key),"json")
            .enqueue(object : Callback<SRResponse>{
                override fun onResponse(call: Call<SRResponse>, response: Response<SRResponse>) {
                    if(response.isSuccessful){
//                        Log.d("TAG",response.body().toString())
                        val result = response.body()?.safetyRestrntInfo?.get(1)?.row
                        if (result != null) {
                            for (i in result){

                                // 요것들만 리싸이클러뷰로 넣어주면됨 고생했다!!!!
                                val location = i?.dETAILADDR.toString()
                                val name = i?.bIZPLCNM.toString()
                                val foodtype = i?.iNDUTYPEDETAILNM.toString()
                                val lat = i?.rEFINEWGS84LAT?.toDouble() ?: 0.0
                                val long = i?.rEFINEWGS84LOGT?.toDouble() ?: 0.0
                                itemList_vertical.add(MatzipVerticalItem(R.drawable.americantrailor350,location,name,foodtype,"3.3","(30)",lat,long))
                            }

                            // 어댑터
                            val matzipVerticalAdapter = MatzipVerticalAdapter(itemList_vertical)
                            matzipVerticalAdapter.notifyDataSetChanged()
                            if (rv_matzip_vertical != null) {
                                rv_matzip_vertical.adapter = matzipVerticalAdapter
                            }
                            if (rv_matzip_vertical != null) {
                                rv_matzip_vertical.layoutManager = GridLayoutManager(context,2)
                            }
                        }

                    }
                }

                override fun onFailure(call: Call<SRResponse>, t: Throwable) {
                    Log.d("TAG",t.message.toString())
                }
            })
    }
}