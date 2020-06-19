package com.stah.nestrecyclerview.model

import java.util.*

data class ChildModel(val title: String = "")

object ChildDataFactory {

    private val random = Random()

    private val titles =
        arrayListOf("Aviator", "Now you can See me", "God Father", "Mission Impossible", "3 idiots")

    private fun randomTitle(): String {
        val index = random.nextInt(titles.size)
        return titles[index]
    }


    fun getChildren(count: Int): List<ChildModel> {
        val children = mutableListOf<ChildModel>()
        repeat(count) {
            val child = ChildModel(randomTitle())
            children.add(child)
        }
        return children
    }


}