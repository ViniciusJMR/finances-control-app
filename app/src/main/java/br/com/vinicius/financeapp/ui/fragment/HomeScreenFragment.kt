package br.com.vinicius.financeapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vinicius.financeapp.R
import br.com.vinicius.financeapp.databinding.FragmentHomeScreenBinding
import br.com.vinicius.financeapp.domain.State
import br.com.vinicius.financeapp.presentation.HomeViewModel
import br.com.vinicius.financeapp.ui.adapter.CardListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private val homeViewModel by viewModel<HomeViewModel>()
    private val adapter by lazy { CardListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        homeViewModel.getCardList()
        setupCardRecyclerView()
    }

    private fun setupListeners() {
        binding.btAddCard.setOnClickListener{
            findNavController().navigate(R.id.action_homeScreenFragment_to_cardCreationFragment)
        }
    }

    private fun setupCardRecyclerView(){
        binding.rvCards.adapter = adapter
        binding.rvCards.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        homeViewModel.cards.observe(viewLifecycleOwner) {
            when(it) {
                is State.Error ->
                    Toast.makeText(context, it.error.message, Toast.LENGTH_SHORT).show()
                is State.Success -> {
                    adapter.submitList(it.response)
                    it.response?.forEach { card ->
                        Log.d("CARD", card.toString())
                    }
                }
                else ->
                    Toast.makeText(context, R.string.err_string, Toast.LENGTH_SHORT).show()
            }
        }

    }
}