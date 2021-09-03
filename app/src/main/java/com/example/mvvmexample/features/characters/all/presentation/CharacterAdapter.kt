package com.example.mvvmexample.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.core.adapter.BindableAdapter
import com.example.mvvmexample.databinding.ItemCharacterBinding
import com.example.mvvmexample.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : BindableAdapter<CharacterDisplayable>,
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters = mutableListOf<CharacterDisplayable>()
    lateinit var onCharacterClickListener: (CharacterDisplayable) -> Unit

    override fun setItems(items: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) characters.clear()
        characters.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
        holder.itemView.setOnClickListener { onCharacterClickListener.invoke(character) }
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            with(binding) {
                binding.item = character
                binding.executePendingBindings()
            }
        }
    }
}