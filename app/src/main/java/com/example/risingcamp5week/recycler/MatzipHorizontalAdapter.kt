package com.example.risingcamp5week.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp5week.R

class MatzipHorizontalAdapter(val itemList : ArrayList<MatzipHorizontalItem>) : RecyclerView.Adapter<MatzipHorizontalAdapter.MatzipHorizontalViewHolder>() {
    inner class MatzipHorizontalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tv_item_matzip_horizontal_title = itemView.findViewById<TextView>(R.id.tv_item_matzip_horizontal_title)
        val tv_item_matzip_horizontal_foodtype = itemView.findViewById<TextView>(R.id.tv_item_matzip_horizontal_foodtype)
        val tv_item_matzip_horizontal_info = itemView.findViewById<TextView>(R.id.tv_item_matzip_horizontal_info)
        val tv_item_matzip_horizontal_writer = itemView.findViewById<TextView>(R.id.tv_item_matzip_horizontal_writer)
        val iv_item_matzip_horizontal = itemView.findViewById<ImageView>(R.id.iv_item_matzip_horizontal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatzipHorizontalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_matzip_horizontal,parent,false)
        return MatzipHorizontalViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatzipHorizontalViewHolder, position: Int) {
        holder.tv_item_matzip_horizontal_title.text = itemList[position].title
        holder.tv_item_matzip_horizontal_foodtype.text = itemList[position].foodtype
        holder.tv_item_matzip_horizontal_info.text = itemList[position].info
        holder.tv_item_matzip_horizontal_writer.text = itemList[position].writer

        // 이미지 변경 부분, glide를 할지 setImageReSource를 할지 고민!
        holder.iv_item_matzip_horizontal.setImageResource(itemList[position].image)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }
}