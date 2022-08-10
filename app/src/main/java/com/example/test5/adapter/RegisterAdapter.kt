package com.example.test5.adapter

import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test5.R
import com.example.test5.databinding.ChoosesItemBinding
import com.example.test5.databinding.InputItemBinding
import com.example.test5.diffutils.RegisterDiffUtil
import com.example.test5.model.ListItems
//import com.example.test5.model.listOfItems

class RegisterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemsList = mutableListOf<ListItems>()

    var clickItem: ((ListItems) -> Unit)? = null

    companion object {
        const val INPUT_ITEM = 1
        const val CHOOSER_ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            INPUT_ITEM -> {
                InputTypeViewHolder(
                    InputItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }else -> {
                ChooserTypeViewHolder(
                    ChoosesItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is InputTypeViewHolder -> {
                holder.onBind()
            }
            is ChooserTypeViewHolder -> {
                holder.onBind()
            }
        }
    }

    override fun getItemViewType(position: Int) = when (itemsList[position].fieldType) {
        "input" -> {
            INPUT_ITEM
        }
        else -> {
            CHOOSER_ITEM
        }
    }

    override fun getItemCount() = itemsList.size

    inner class InputTypeViewHolder(private val binding: InputItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.apply {
                etInput.hint = itemsList[adapterPosition].hint
                ivIcon.setImageResource(itemsList[adapterPosition].icon)
            }
        }
    }

    inner class ChooserTypeViewHolder(private val binding: ChoosesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.apply {
                tvChoosesTitle.text = itemsList[adapterPosition].hint
                ibIcon.setImageResource(itemsList[adapterPosition].icon)
                root.setOnClickListener {
//                    clickItem?.invoke(listOfItems[adapterPosition])
                }
            }
        }
    }


    fun setData(list: List<ListItems>) {
        val diffUtils = RegisterDiffUtil(itemsList, list)
        val diffResult = DiffUtil.calculateDiff(diffUtils)
        itemsList = list as MutableList<ListItems>
        diffResult.dispatchUpdatesTo(this)
    }
}