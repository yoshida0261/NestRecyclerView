package com.stah.nestrecyclerview.viewmodel

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stah.nestrecyclerview.R
import com.stah.nestrecyclerview.model.ParentModel
import kotlinx.android.synthetic.main.parent_recycler.view.*

class ParentAdapter(private val parents: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        holder.textView.text = parent.title
        holder.recyclerView.apply {
            layoutManager = LinearLayoutManager(holder.recyclerView.context, LinearLayout.VERTICAL, false)
            adapter = ChildAdapter(parent.children)
         //   recycledViewPool = viewPool
        }
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.rv_child
        val textView: TextView = itemView.textView
    }
}