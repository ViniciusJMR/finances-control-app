package br.com.vinicius.financeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.databinding.FragmentHomeScreenBinding
import br.com.vinicius.financeapp.ui.adapter.CardListAdapter

class HomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private val adapter by lazy { CardListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)

        val x = listOf(
            Card(1, "Nubank", "2431", "10/14", "13/15"),
            Card(2, "Santader", "9583", "11/15", "58/15"),
            Card(1, "Nubank", "2431", "13/10", "10/20")
        )

        binding.rvCards.adapter = adapter
        binding.rvCards.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        adapter.submitList(x)

        return binding.root
    }
}