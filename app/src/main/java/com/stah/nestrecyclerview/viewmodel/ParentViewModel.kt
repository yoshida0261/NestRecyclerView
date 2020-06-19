package com.stah.nestrecyclerview.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList

class ParentViewModel {
    val adapterItems = ObservableArrayList<ParentAdapter.AdapterItem>().apply {
        addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<ParentAdapter.AdapterItem>>() {
            override fun onChanged(sender: ObservableList<ParentAdapter.AdapterItem>?) = Unit
            override fun onItemRangeRemoved(sender: ObservableList<ParentAdapter.AdapterItem>?, positionStart: Int, itemCount: Int) = Unit
            override fun onItemRangeMoved(sender: ObservableList<ParentAdapter.AdapterItem>?, fromPosition: Int, toPosition: Int, itemCount: Int) = Unit
            override fun onItemRangeInserted(sender: ObservableList<ParentAdapter.AdapterItem>?, positionStart: Int, itemCount: Int) = Unit

            override fun onItemRangeChanged(sender: ObservableList<ParentAdapter.AdapterItem>?, positionStart: Int, itemCount: Int) = Unit

        })
    }
}