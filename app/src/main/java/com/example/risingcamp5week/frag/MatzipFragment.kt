package com.example.risingcamp5week.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp5week.R
import com.example.risingcamp5week.recycler.MatzipHorizontalAdapter
import com.example.risingcamp5week.recycler.MatzipHorizontalItem


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

        /* horizontal recyclerview */
        val rv_matzip_horizontal = view.findViewById<RecyclerView>(R.id.rv_matzip_horizontal)   // 리싸이클러뷰 세로방향 변수 선언
        val itemList_horizontal = ArrayList<MatzipHorizontalItem>()                             // 아이템 선언

        // add
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니","고길동",R.drawable.background_grey_stroke))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니","고길동",R.drawable.background_grey_stroke))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니","고길동",R.drawable.background_grey_stroke))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니","고길동",R.drawable.background_grey_stroke))
        itemList_horizontal.add(MatzipHorizontalItem("호천당","까스요리","돈까스의 정석 그잡채 호천당! - 돈까스가 도톰하니","고길동",R.drawable.background_grey_stroke))

        // 어댑터 변수선언
        val matzipHorizontalAdapter = MatzipHorizontalAdapter(itemList_horizontal)
        matzipHorizontalAdapter.notifyDataSetChanged()
        rv_matzip_horizontal.adapter = matzipHorizontalAdapter
        rv_matzip_horizontal.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
    }
}