package com.example.hw2

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.hw2.databinding.ItemCakeBinding

class CakeHolder(
    val binding: ItemCakeBinding,
    private val glide: RequestManager,
    private val onItemClick: (Cake) -> Unit,
): RecyclerView.ViewHolder(binding.root) {

    private val options: RequestOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)


    fun onBind(cake: Cake){
        with(binding) {
            tvName.text = cake.name
            tvPrice.text = cake.price
            root.setOnClickListener{
                onItemClick(cake)
            }
            glide
                .load(cake.url)
                .placeholder(R.drawable.kuk)
                .error(R.drawable.kuk)
                .into(ivCover)
        }



//        itemView.setOnClickListener{
//            onItemClick(cake)
//        }


    }
}