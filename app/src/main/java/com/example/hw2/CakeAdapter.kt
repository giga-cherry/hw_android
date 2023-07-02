package com.example.hw2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.hw2.databinding.ItemCakeBinding

class CakeAdapter(
    private var list: List<Cake>,
    private val glide: RequestManager,
    private val onItemClick: (Cake) -> Unit,
) : RecyclerView.Adapter<CakeHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CakeHolder = CakeHolder(
        binding = ItemCakeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onItemClick = onItemClick

    )

    override fun onBindViewHolder(
        holder: CakeHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<Cake>) {
        list = newList
        notifyDataSetChanged()
    }

}