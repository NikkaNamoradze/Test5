package com.example.test5.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.test5.model.ListItems

class RegisterDiffUtil(
    private val newList: List<ListItems>,
    private val oldList: List<ListItems>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].hint == newList[newItemPosition].hint

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}