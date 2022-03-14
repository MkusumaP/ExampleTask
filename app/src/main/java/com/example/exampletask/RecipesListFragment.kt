package com.example.exampletask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampletask.databinding.FragmentRecipesListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecipesListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRecipesListBinding
    private lateinit var viewModel: RecipesListViewModel
    private lateinit var adapter: RecipesListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentRecipesListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[RecipesListViewModel::class.java]
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = RecipesListAdapter()
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewDataBinding.recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        viewDataBinding.recyclerView.adapter = adapter


        setupObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupObservers() {
        viewModel.recipesResult.observe(viewLifecycleOwner, Observer {
            adapter.setData(recipesResult = it)
        })
        viewModel.getRecipesList()
    }

}
