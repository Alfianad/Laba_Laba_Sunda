package lat.pam.laba_laba_sunda.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import lat.pam.laba_laba_sunda.databinding.ItemMenuBinding
import lat.pam.laba_laba_sunda.model.MenuItem

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onSelectionChanged: (MenuItem?) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    inner class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                select(adapterPosition)
            }
            binding.radioSelect.setOnClickListener {
                select(adapterPosition)
            }
        }

        fun bind(item: MenuItem, position: Int) {
            binding.tvName.text = item.name
            binding.tvDesc.text = item.description
            binding.tvPrice.text = "Rp ${item.price}"
            binding.ivFood.setImageResource(item.drawableRes)
            binding.radioSelect.isChecked = (position == selectedPosition)
        }
    }

    private fun select(position: Int) {
        if (position == RecyclerView.NO_POSITION) return
        val previous = selectedPosition
        selectedPosition = position
        if (previous != RecyclerView.NO_POSITION) notifyItemChanged(previous)
        notifyItemChanged(selectedPosition)
        onSelectionChanged(items[selectedPosition])
    }

    fun getSelected(): MenuItem? {
        return if (selectedPosition != RecyclerView.NO_POSITION) items[selectedPosition] else null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(inflater, parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}
