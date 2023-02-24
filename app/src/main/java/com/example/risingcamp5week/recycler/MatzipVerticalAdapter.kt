package com.example.risingcamp5week.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.risingcamp5week.R

class MatzipVerticalAdapter (val itemList : ArrayList<MatzipVerticalItem>) : RecyclerView.Adapter<MatzipVerticalAdapter.MatzipVerticalViewHolder>(){
    inner class MatzipVerticalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        // iv
        val iv_item_matzip_vertical = itemView.findViewById<ImageView>(R.id.iv_item_matzip_vertical)

        // tv
        val tv_item_matzip_vertical_location =  itemView.findViewById<TextView>(R.id.tv_item_matzip_vertical_location)
        val tv_item_matzip_vertical_title =  itemView.findViewById<TextView>(R.id.tv_item_matzip_vertical_title)
        val tv_item_matzip_vertical_foodtype =  itemView.findViewById<TextView>(R.id.tv_item_matzip_vertical_foodtype)
        val tv_item_matzip_vertical_point =  itemView.findViewById<TextView>(R.id.tv_item_matzip_vertical_point)
        val tv_item_matzip_vertical_review =  itemView.findViewById<TextView>(R.id.tv_item_matzip_vertical_review)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatzipVerticalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_matzip_vertical,parent,false)
        return MatzipVerticalViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatzipVerticalViewHolder, position: Int) {
        // iv
        Glide.with(holder.itemView.context).load(itemList[position].image).transform(CenterCrop(), RoundedCorners(30)).into(holder.iv_item_matzip_vertical)

        // tv
        holder.tv_item_matzip_vertical_location.text = itemList[position].location
        holder.tv_item_matzip_vertical_title.text = itemList[position].title
        holder.tv_item_matzip_vertical_foodtype.text = itemList[position].foodtype
        holder.tv_item_matzip_vertical_point.text = itemList[position].point
        holder.tv_item_matzip_vertical_review.text = itemList[position].review
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }
}