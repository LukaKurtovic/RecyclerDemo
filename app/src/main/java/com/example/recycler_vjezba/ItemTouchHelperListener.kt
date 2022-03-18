package com.example.recycler_vjezba

import androidx.recyclerview.widget.RecyclerView

interface ItemTouchHelperListener {
    fun onItemMove(recyclerView: RecyclerView, fromPosition: Int, toPosition: Int): Boolean
    fun onItemSwipe(viewHolder: RecyclerView.ViewHolder, position: Int)
}