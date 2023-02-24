package com.example.risingcamp5week.frag.mainfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ViewFlipper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp5week.R
import com.example.risingcamp5week.recycler.MatzipHorizontalAdapter
import com.example.risingcamp5week.recycler.MatzipHorizontalItem
import com.example.risingcamp5week.recycler.MatzipVerticalAdapter
import com.example.risingcamp5week.recycler.MatzipVerticalItem


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



        /* vertical recyclerview */
        val rv_matzip_vertical = view.findViewById<RecyclerView>(R.id.rv_matzip_vertical)
        val itemList_vertical = ArrayList<MatzipVerticalItem>()

        // add
        itemList_vertical.add(MatzipVerticalItem(R.drawable.ikea512,"고양시 522m","이케아 레스토랑","양식/ 기타 양식","3.6","(리뷰 32)"))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.thefesta600,"고양시 544m","더 페스타","양식/ 이탈리안","3.2","(리뷰 31)"))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.bgdd512,"고양시 874m","버건디도어","카페/ 디저트","3.2","(리뷰 30)"))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.kontai512,"고양시 458m","콘타이(이케아 고양점)","세계음식/ 태국음식","3.3","(리뷰 9)"))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.coffetosta512,"고양시 557m","커피토스타","카페/ 디저트","3.2","(리뷰 2)"))
        itemList_vertical.add(MatzipVerticalItem(R.drawable.americantrailor350,"고양시 458m","아메리칸트레일러","카페/ 디저트","3.0","(리뷰 1)"))

        // 어댑터
        val matzipVerticalAdapter = MatzipVerticalAdapter(itemList_vertical)
        matzipVerticalAdapter.notifyDataSetChanged()
        rv_matzip_vertical.adapter = matzipVerticalAdapter
        rv_matzip_vertical.layoutManager = GridLayoutManager(context,2)
    }
}