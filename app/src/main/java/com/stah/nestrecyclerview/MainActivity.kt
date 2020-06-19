package com.stah.nestrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.stah.nestrecyclerview.model.ParentDataFactory
import com.stah.nestrecyclerview.viewmodel.ParentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        recyclerView = rv_parent

        recyclerView.apply {
            //  layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)
            adapter = ParentAdapter(
                ParentDataFactory
                    .getParents(40)
            )
        }

    }
}
