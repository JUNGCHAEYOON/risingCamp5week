package com.example.risingcamp5week.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp5week.R

class HalinEatdealAdapter (val itemList : ArrayList<HalinEatdealItem>): RecyclerView.Adapter<HalinEatdealAdapter.HalinEatdealViewHolder>(){
    inner class HalinEatdealViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        //iv
        val iv_halin_eatdeal = itemView.findViewById<ImageView>(R.id.iv_halin_eatdeal)

        //tv
        val tv_halin_eatdeal_location = itemView.findViewById<TextView>(R.id.tv_halin_eatdeal_location)
        val tv_halin_eatdeal_title = itemView.findViewById<TextView>(R.id.tv_halin_eatdeal_title)
        val tv_halin_eatdeal_menu = itemView.findViewById<TextView>(R.id.tv_halin_eatdeal_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HalinEatdealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_halin_eatdeal,parent,false)
        return HalinEatdealViewHolder(view)
    }

    override fun onBindViewHolder(holder: HalinEatdealViewHolder, position: Int) {
        // iv
        holder.iv_halin_eatdeal.setImageResource(itemList[position].image)

        // tv
        holder.tv_halin_eatdeal_location.text = itemList[position].location
        holder.tv_halin_eatdeal_title.text = itemList[position].title
        holder.tv_halin_eatdeal_menu.text = itemList[position].menu
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }
}