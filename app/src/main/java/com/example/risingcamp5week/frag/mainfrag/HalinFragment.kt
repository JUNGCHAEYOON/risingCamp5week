package com.example.risingcamp5week.frag.mainfrag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.risingcamp5week.R
import com.example.risingcamp5week.frag.halinfrag.EatdealFragment
import com.example.risingcamp5week.frag.halinfrag.MangopicFragment
import com.example.risingcamp5week.frag.halinfrag.ToplistFragment
import com.example.risingcamp5week.taplayout.PagerFragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HalinFragment : Fragment() {

    // 뷰페이저2, 탭레이아웃 변수 선언
    private lateinit var vp2_halin: ViewPager2
    private lateinit var tl_halin : TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_halin, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* 탭레이아웃 연결 */

        // 뷰페이저2, 탭레이아웃 변수 연결
        vp2_halin = view.findViewById(R.id.vp2_halin)
        tl_halin = view.findViewById(R.id.tl_halin)

        // 페이저 어댑터 생성
        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())

        // fragment 3개 add
        pagerAdapter.addFragment(EatdealFragment())
        pagerAdapter.addFragment(MangopicFragment())
        pagerAdapter.addFragment(ToplistFragment())

        // 어댑터 연결
        vp2_halin.adapter = pagerAdapter
        vp2_halin.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position+1}")
            }
        })

        // 탭레이아웃 연결
        TabLayoutMediator(tl_halin,vp2_halin){tab, position ->
            when(position){
                0->{
                    tab.text = "EAT 딜"
                }
                1->{
                    tab.text = "망고픽 스토리"
                }
                else->{
                    tab.text = "TOP 리스트"
                }
            }
        }.attach()
    }

}