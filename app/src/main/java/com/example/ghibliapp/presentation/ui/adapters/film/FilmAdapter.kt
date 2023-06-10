package com.example.ghibliapp.presentation.ui.adapters.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ghibliapp.databinding.ItemFilmBinding
import com.example.ghibliapp.presentation.model.FilmModelUI

class FilmAdapter: ListAdapter<FilmModelUI, FilmAdapter.FilmViewHolder>(FilmDiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): FilmAdapter.FilmViewHolder {
        return FilmViewHolder(
            ItemFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilmAdapter.FilmViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class FilmViewHolder(
        private val binding: ItemFilmBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: FilmModelUI) {
            binding.titleItem = item.title
            Glide.with(binding.imFilm)
                .load(item.image)
                .into(binding.imFilm)
        }
    }
}

object FilmDiffCallBack : DiffUtil.ItemCallback<FilmModelUI>() {
    override fun areItemsTheSame(
        oldItem: FilmModelUI,
        newItem: FilmModelUI
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: FilmModelUI,
        newItem: FilmModelUI
    ): Boolean {
        return oldItem == newItem
    }
}