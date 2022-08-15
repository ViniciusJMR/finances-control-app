package br.com.vinicius.financeapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.vinicius.financeapp.data.model.Tag
import br.com.vinicius.financeapp.databinding.ItemTagBinding

class TagListAdapter: ListAdapter<Tag, TagListAdapter.ViewHolder>(TagDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTagBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemTagBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Tag) {
            binding.tvTagName.text = item.name
            val textTotal = "${item.total}"
            binding.tvTagTotal.text = textTotal
        }
    }

}

class TagDiffCallback: DiffUtil.ItemCallback<Tag>(){
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = oldItem.id == newItem.id
}