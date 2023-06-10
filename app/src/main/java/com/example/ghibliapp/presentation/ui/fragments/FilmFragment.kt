package com.example.ghibliapp.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ghibliapp.R
import com.example.ghibliapp.databinding.FragmentFilmBinding
import com.example.ghibliapp.presentation.base.BaseFragment
import com.example.ghibliapp.presentation.state.UIState
import com.example.ghibliapp.presentation.ui.adapters.film.FilmAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmFragment : BaseFragment<FilmViewModel>(R.layout.fragment_film) {

    override val viewModel: FilmViewModel by viewModels()
    private lateinit var binding: FragmentFilmBinding
    private val filmAdapter = FilmAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun initialize() {
        setupRecyclerview()
    }

    private fun setupRecyclerview() = with(binding.filmRecyclerview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = filmAdapter
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.filmState.collect {
                when (it) {
                    is UIState.Error -> {
                        Log.e("arzymat", it.error)
                    }

                    is UIState.Success -> {
                        Log.e("anime", it.data.toString())
                    }

                    is UIState.Idle -> {
                        Log.e("some", it.toString())
                    }
                    is UIState.Loading -> {
                        Log.e("some", it.toString())
                    }
                }
            }
        }
    }
}