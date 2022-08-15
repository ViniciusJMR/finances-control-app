package br.com.vinicius.financeapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.financeapp.data.model.Income
import br.com.vinicius.financeapp.data.model.Tag
import br.com.vinicius.financeapp.databinding.ItemIncomeBinding
import br.com.vinicius.financeapp.databinding.ItemTagBinding

class IncomeListAdapter: ListAdapter<Income, IncomeListAdapter.ViewHolder>(IncomeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemIncomeBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemIncomeBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Income) {
            binding.tvIncomeCardName.text = item.card.name
            binding.tvIncomeDate.text = item.date
            binding.tvIncomeValue.text = item.amount.toString()
            binding.tvIncomeDescription.text = item.description
            binding.tvIncomeInstallments.visibility = View.GONE
            binding.tvIncomeFees.visibility = View.GONE
            binding.tvIncomeDueDate.visibility = View.GONE
        }
    }

}

class IncomeDiffCallback: DiffUtil.ItemCallback<Income>(){
    override fun areItemsTheSame(oldItem: Income, newItem: Income) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Income, newItem: Income) = oldItem.id == newItem.id
}