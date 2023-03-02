package com.example.mealapp.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mealapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    // binding + viewmodel
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // binding + viewmodel + lifecycleowner decalaration
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        // username error display
        viewModel.loginError.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.etLogin.setError(it)
            }
        })
        // password error display
        viewModel.errorPassword.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.etPassword.setError(it)
            }
        })
        // navigate to rv
        viewModel.navigateToRecyclerList.observe(viewLifecycleOwner, Observer {
            if(it) {
                findNavController().navigate(MainFragmentDirections.actionMainFragmentToMealListFragment())
                viewModel.navigateFinished()
            }
        })

        return binding.root
    }

}