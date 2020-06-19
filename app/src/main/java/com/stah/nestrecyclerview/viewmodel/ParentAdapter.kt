package com.stah.nestrecyclerview.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stah.nestrecyclerview.R
import com.stah.nestrecyclerview.model.ParentModel
import kotlinx.android.synthetic.main.parent_recycler.view.*

class ParentAdapter(private val parents: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler, parent, false)
        return ViewHolder(v)
    }

    //val inflater = LayoutInflater.from(parent.context)

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        // holder.textView.text = parent.title
        //val childLayoutManager =         LinearLayoutManager(holder.recyclerView.context, Re.HORIZONTAL, false)
        //childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
              layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.children)
            setRecycledViewPool(viewPool)
            //adapter = SearchSavedConditionView.SavedConditionAdapter(context, list, null)
        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
    }


    sealed class AdapterItem(open val viewType: Int) {
        data class ParentItem(val temp: String) : AdapterItem(1)
        //   data class SavedConditions(val searchCondition: SearchSavedConditionView.SavedConditionAdapter.Item) : AdapterItem(VIEW_TYPE_SAVED_CONDITIONS)
        //  class SavedConditionIsEmpty() : AdapterItem(VIEW_TYPE_SAVED_CONDITION_IS_EMPTY)
        //  data class FavoriteBrands(val favoriteBrands: List<FavoriteBrand>) : AdapterItem(VIEW_TYPE_FAVORITE_BRANDS)
        // data class Features(val feature: SearchContent) : AdapterItem(VIEW_TYPE_FEATURES)
    }

}