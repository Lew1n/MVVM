package com.example.mvvmexample.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.core.adapter.BindableAdapter
import com.example.mvvmexample.databinding.ItemEpisodeBinding
import com.example.mvvmexample.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BindableAdapter<EpisodeDisplayable>,
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes = mutableListOf<EpisodeDisplayable>()
    internal lateinit var onEpisodeClickListener: (EpisodeDisplayable) -> Unit

    override fun setItems(items: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) episodes.clear()
        episodes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
        holder.itemView.setOnClickListener { onEpisodeClickListener.invoke(episode) }
    }

    override fun getItemCount(): Int = episodes.size

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                binding.item = episode
                binding.executePendingBindings()
            }
        }
    }
}