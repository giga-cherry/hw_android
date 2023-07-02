package com.example.hw2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hw2.databinding.FragmentFourthBinding
import com.example.hw2.databinding.ItemInfoBinding
import com.google.android.material.snackbar.Snackbar

class InfoItem: Fragment(R.layout.item_info) {
    private var _binding: ItemInfoBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ItemInfoBinding.bind(view)

        arguments?.getString(ARG_NAME)?.also{
            binding?.tvName?.text = it
        }

        arguments?.getString(ARG_PRICE)?.also{
            binding?.tvPrice?.text = it
        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object{

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_PRICE = "ARG_PRICE"
        fun createBundle(name: String, price: String) = Bundle().apply {
            putString(ARG_NAME, name)
            putString(ARG_PRICE, price)
        }
    }


    private fun setData(cake: Cake) {
        binding?.run {
            tvName.text = cake.name
            tvPrice.text = cake.price
            Glide.with(this@InfoItem)
                .load(cake.url)
                .into(ivCover)
        }
    }

}