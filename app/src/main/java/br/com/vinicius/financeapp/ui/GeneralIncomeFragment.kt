package br.com.vinicius.financeapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.vinicius.financeapp.databinding.FragmentGeneralIncomeBinding

class GeneralIncomeFragment : Fragment() {
    private lateinit var binding: FragmentGeneralIncomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGeneralIncomeBinding.inflate(inflater, container, false)

        return binding.root
    }
}