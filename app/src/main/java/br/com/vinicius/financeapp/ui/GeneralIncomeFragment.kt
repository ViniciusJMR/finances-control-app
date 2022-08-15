package br.com.vinicius.financeapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.vinicius.financeapp.data.model.Tag
import br.com.vinicius.financeapp.databinding.FragmentGeneralIncomeBinding
import br.com.vinicius.financeapp.ui.adapter.TagListAdapter

class GeneralIncomeFragment : Fragment() {
    private lateinit var binding: FragmentGeneralIncomeBinding
    private val tagAdapter by lazy { TagListAdapter() }

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

        return binding.root
    }

}