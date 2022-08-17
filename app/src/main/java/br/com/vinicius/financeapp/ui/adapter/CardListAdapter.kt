package br.com.vinicius.financeapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.databinding.ItemCardBinding

class CardListAdapter: ListAdapter<Card, CardListAdapter.ViewHolder>(CardDiffCallback()){

    inner class ViewHolder(
        private val binding: ItemCardBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Card) {
            binding.tvCardName.text = item.name
            binding.tvCardClosure.text = item.closureDate
            binding.tvCardDue.text = item.dueDate
            binding.tvCardFinalNumber.text = item.finalNumber
            binding.tvCardTotal.text = "$2343.99"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CardDiffCallback(): DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Card, newItem: Card) = oldItem.id == newItem.id


}