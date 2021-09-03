package com.example.mvvmexample.features.location.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.core.adapter.BindableAdapter
import com.example.mvvmexample.databinding.ItemLocationBinding
import com.example.mvvmexample.features.location.all.presentation.model.LocationDisplayable

class LocationAdapter : BindableAdapter<LocationDisplayable>,
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations = mutableListOf<LocationDisplayable>()
    lateinit var onLocationClickListener: (LocationDisplayable) -> Unit

    override fun setItems(items: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) locations.clear()
        locations.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLocationBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
        holder.itemView.setOnClickListener { onLocationClickListener.invoke(location) }
    }

    override fun getItemCount(): Int = locations.size

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            with(binding) {
                binding.item = location
                binding.executePendingBindings()
            }
        }
    }
}