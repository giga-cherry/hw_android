package com.example.hw2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.hw2.databinding.FragmentFourthBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.runBlocking

class FourthFragment: Fragment(R.layout.fragment_fourth) {
    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    private var adapter: CakeAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFourthBinding.bind(view)

//        adapter = CakeAdapter(CakeReposittory.cakes, Glide.with(this)) {
//            Snackbar.make(binding.root, "Cake: ${it.id}", Snackbar.LENGTH_SHORT).show()
//        }

        adapter = CakeAdapter(CakeReposittory.cakes, Glide.with(this)) {
            cake -> findNavController().navigate(R.id.action_fourthFragment_to_infoItem,
        InfoItem.createBundle(cake.name, cake.price))
        }
        binding.rvCake.adapter =adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}