package com.example.risingcamp5week.frag.halinfrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.risingcamp5week.R
import com.example.risingcamp5week.recycler.HalinEatdealAdapter
import com.example.risingcamp5week.recycler.HalinEatdealItem

class EatdealFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eatdeal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv_halin_eatdeal = view.findViewById<RecyclerView>(R.id.rv_halin_eatdeal)
        val itemList = ArrayList<HalinEatdealItem>()

        itemList.add(HalinEatdealItem(R.drawable.background_orange,"[마포]","등촌 갈비","소갈비"))
        itemList.add(HalinEatdealItem(R.drawable.background_orange,"[마포]","등촌 갈비","소갈비"))
        itemList.add(HalinEatdealItem(R.drawable.background_orange,"[마포]","등촌 갈비","소갈비"))
        itemList.add(HalinEatdealItem(R.drawable.background_orange,"[마포]","등촌 갈비","소갈비"))
        itemList.add(HalinEatdealItem(R.drawable.background_orange,"[마포]","등촌 갈비","소갈비"))
        itemList.add(HalinEatdealItem(R.drawable.background_orange,"[마포]","등촌 갈비","소갈비"))

        val halinEatdealAdapter = HalinEatdealAdapter(itemList)
        halinEatdealAdapter.notifyDataSetChanged()
        rv_halin_eatdeal.adapter = halinEatdealAdapter
        rv_halin_eatdeal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}