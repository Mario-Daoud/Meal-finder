package com.example.mealapp.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mealapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    // viewmodel + binding
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding declaration
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        // meal from arguments
        val meal = DetailFragmentArgs.fromBundle(requireArguments()).meal
        // viewmodel factory with argument
        val viewmodelFactory = DetailViewModelFactory(meal)

        // viewmodel declaration
        viewModel = ViewModelProvider(this, viewmodelFactory).get(DetailViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

}