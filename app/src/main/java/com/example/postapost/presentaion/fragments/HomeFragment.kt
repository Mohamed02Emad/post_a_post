package com.example.postapost.presentaion.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postapost.data.api.RequestState
import com.example.postapost.databinding.FragmentHomeBinding
import com.example.postapost.presentaion.MainActivity
import com.example.postapost.presentaion.MainViewModel
import com.example.postapost.presentaion.recyclerViews.PostsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var myAdapter: PostsAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setOnClicks()
        setupRecyclerView()
        setObservers()
    }

    private fun setOnClicks() {
        binding.btnAddPost.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPostFragment())
        }
    }

    private fun setupRecyclerView() {
        myAdapter = PostsAdapter()
        binding.rvPosts.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun setObservers() {
        viewModel.posts.observe(viewLifecycleOwner) { response ->
            when (response) {
                is RequestState.Sucess -> {
                    // hideProgressbar()
                    response.data?.let {
                        myAdapter.differ.submitList(it.posts.toList())
                    }
                }
                is RequestState.Error -> {
                    // hideProgressbar()
                    response.message?.let {
                        Log.d("mohamed", "an error occurred ${it}")
                    }
                }
                is RequestState.Loading -> {
                    //   showProgressbar()
                }
                else -> {

                }
            }

        }

    }


}