package com.example.mealapp.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealapp.databinding.FragmentMealListBinding
import com.example.mealapp.models.Meal

class MealListFragment : Fragment() {

    // viewmodel + binding
    private lateinit var viewModel: MealListViewModel
    private lateinit var binding: FragmentMealListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding + viewmodel declaration
        binding = FragmentMealListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MealListViewModel::class.java)
        binding.viewModel = viewModel
        // lifecyclerowner
        binding.lifecycleOwner = this

        // recycerlview adapter + manager
        val adapter = MealAdapter(MealClickListener {
            viewModel.onMealClicked(it)
        })
        binding.rvMeals.adapter = adapter
        val manager = LinearLayoutManager(activity)
        binding.rvMeals.layoutManager = manager

        // error display
        viewModel.error.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.etFirstletter.setError(it)
            }
        })

        // search for meals
        viewModel.mealBase.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it.meals)
                print(it.meals)
            }
        })

        // click on meal
        viewModel.meal.observe(viewLifecycleOwner, Observer {
            it?.let {
                navigateToMealDetail(it)
                viewModel.navigateToDetailFinished()
            }
        })

        // lifecycleowner
        binding.setLifecycleOwner(this)

        return binding.root
    }

    // click on meal function to navigate
    fun navigateToMealDetail(meal: Meal) {
        findNavController().navigate(MealListFragmentDirections.actionMealListFragmentToDetailFragment(meal))
    }

}