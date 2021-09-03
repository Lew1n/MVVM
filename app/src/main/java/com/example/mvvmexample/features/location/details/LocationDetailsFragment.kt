package com.example.mvvmexample.features.location.details

import com.example.mvvmexample.BR
import com.example.mvvmexample.R
import com.example.mvvmexample.core.base.BaseFragment
import com.example.mvvmexample.databinding.FragmentLocationDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailsFragment :
    BaseFragment<LocationViewModel, FragmentLocationDetailsBinding>(BR.viewModel,
        R.layout.fragment_location_details) {

    override val viewModel: LocationViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }
}