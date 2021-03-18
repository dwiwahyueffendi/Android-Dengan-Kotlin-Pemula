package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_superhero.view.*

class SuperHeroAdapter (private val list: ArrayList<SuperHero>): RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder>(){

    private var onItemClickCallBack: onItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: onItemClickCallback){
        this.onItemClickCallBack = onItemClickCallback
    }

    inner class SuperHeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(superHero: SuperHero){
            with(itemView){
                tv_name.text = superHero.name
                tv_desc.text = superHero.desc

                itemView.setOnClickListener{ onItemClickCallBack?.onItemClicked(superHero)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(list[position])
    }

    interface onItemClickCallback{
        fun onItemClicked(data: SuperHero)
    }
}