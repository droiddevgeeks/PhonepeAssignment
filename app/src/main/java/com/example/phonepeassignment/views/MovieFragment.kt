package com.example.phonepeassignment.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.domainmodule.models.IPopularMovies
import com.example.phonepeassignment.databinding.ActivityMainBinding
import com.example.phonepeassignment.helper.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    companion object {
        fun getInstance(): MovieFragment {
            return MovieFragment()
        }
    }

    private val viewModel: MoviesViewModel by viewModels()
    private val moviesAdapter: MoviesListAdapter by lazy {
        MoviesListAdapter { openDetailFragment(it) }
    }
    private lateinit var binding: ActivityMainBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchPopularMovies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeDataChange()
        setAdapter()
    }

    private fun openDetailFragment(movie: IPopularMovies) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, DetailFragment.getInstance(movie.mapToMovie()))
            .addToBackStack("DetailFragment")
            .commit()
    }


    private fun observeDataChange() {
        viewModel.fetchPopularMovies.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ApiState.Success -> moviesAdapter.updateData(state.data)
                is ApiState.Loading -> binding.progress.visibility(state.isLoading)
                is ApiState.Failure -> state.failure.showToast(context)
            }
        }
    }

    private fun setAdapter() {
        binding.moviesRecycler.adapter = moviesAdapter
    }

}