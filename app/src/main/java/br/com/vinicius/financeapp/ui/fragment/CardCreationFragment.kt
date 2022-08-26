package br.com.vinicius.financeapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.vinicius.financeapp.R
import br.com.vinicius.financeapp.data.model.dto.CardDto
import br.com.vinicius.financeapp.databinding.FragmentCardCreationBinding
import br.com.vinicius.financeapp.domain.State
import br.com.vinicius.financeapp.presentation.CardCreationViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardCreationFragment : Fragment() {

    private lateinit var binding: FragmentCardCreationBinding
    private val viewModel by viewModel<CardCreationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardCreationBinding.inflate(inflater, container, false)

        setupListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.card.observe(viewLifecycleOwner) {
            when (it) {
                is State.Success -> {
                    Snackbar.make(binding.root, R.string.txt_card_created, Snackbar.LENGTH_SHORT)
                        .show()
                }
                is State.Error -> {
                    it.error.message?.let { error ->
                        Snackbar.make(binding.root, error, Snackbar.LENGTH_SHORT).show()
                    }
                }
                is State.Loading -> {}
            }
        }

    }

    private fun setupListeners() {
        binding.btSaveCard.setOnClickListener {
            val cardDto = CardDto(
                binding.etCardName.text.toString(),
                binding.etCardFinalNumber.text.toString(),
                binding.etCardClosudeDate.text.toString(),
                binding.etDueDate.text.toString()
            )
            viewModel.insertCard(cardDto)
        }
    }
}