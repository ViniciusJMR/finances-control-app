package br.com.vinicius.financeapp.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.data.model.Income
import br.com.vinicius.financeapp.data.model.Tag
import br.com.vinicius.financeapp.databinding.FragmentGeneralIncomeBinding
import br.com.vinicius.financeapp.ui.adapter.IncomeListAdapter
import br.com.vinicius.financeapp.ui.adapter.TagListAdapter

class GeneralIncomeFragment : Fragment() {
    private lateinit var binding: FragmentGeneralIncomeBinding
    private val tagAdapter by lazy { TagListAdapter() }
    private val incomeListAdapter by lazy { IncomeListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneralIncomeBinding.inflate(inflater, container, false)
        binding.rvTags.adapter = tagAdapter
        binding.rvTags.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val x = mutableListOf(
            Tag(1, "Teste 1", "descricao", 1234.0),
            Tag(2, "Teste 2", "descricao", 5432.0),
            Tag(3, "Teste 3", "descricao", 614.0)
        )
        tagAdapter.submitList(x)

        binding.rvGeneralIncome.adapter = incomeListAdapter
        binding.rvGeneralIncome.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val card = Card(1, "Nubank", "1234", "10/23", "12")
        val y = mutableListOf(
            Income(1, 1234.0, "Comprei aquilo lá", "10/27", card),
            Income(2, 1233.0, "Comprei aquilo cá", "10/20", card),
            Income(3, 1240.0, "Comprei aquilo já", "10/28", card)
        )
        incomeListAdapter.submitList(y)

        return binding.root
    }

}