package com.example.mvvmexample.features.characters.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.mvvmexample.BR
import com.example.mvvmexample.R
import com.example.mvvmexample.core.base.BaseFragment
import com.example.mvvmexample.databinding.FragmentCharacterBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharacterBinding>(BR.viewModel,
    R.layout.fragment_character) {

    override val viewModel: CharactersViewModel by viewModel()
    private val characterAdapter: CharacterAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentCharacterBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharacterBinding) {
        with(binding.charactersRecyclerView) {
            characterAdapter.onCharacterClickListener = { viewModel.onCharacterClick(it) }
            adapter = characterAdapter
            addItemDecoration(dividerItemDecoration)
        }
    }
}