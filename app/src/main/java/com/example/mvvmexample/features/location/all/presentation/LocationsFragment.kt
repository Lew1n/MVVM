package com.example.mvvmexample.features.location.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mvvmexample.BR
import com.example.mvvmexample.R
import com.example.mvvmexample.core.base.BaseFragment
import com.example.mvvmexample.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationBinding>(BR.viewModel,
    R.layout.fragment_location) {

    override val viewModel: LocationsViewModel by viewModel()
    private val locationAdapter: LocationAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationBinding) {
        with(binding.locationsRecyclerView) {
            locationAdapter.onLocationClickListener = { viewModel.onLocationClick(it) }
            adapter = locationAdapter
            addItemDecoration(dividerItemDecoration)
        }
    }
}