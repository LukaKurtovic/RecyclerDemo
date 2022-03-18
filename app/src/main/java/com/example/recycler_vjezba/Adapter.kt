package com.example.recycler_vjezba

import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_vjezba.databinding.SingleItemBinding

class Adapter(private val items: MutableList<String>) : RecyclerView.Adapter<Adapter.MyViewHolder>(), ItemTouchHelperListener {

    inner class MyViewHolder(private val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: String){
            binding.tvTitle.text = item
        }

    }

    override fun onItemMove(recyclerView: RecyclerView, fromPosition: Int, toPosition: Int): Boolean{
        val fromNote = items[fromPosition]
        items.remove(fromNote)
        items.add(toPosition, fromNote)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemSwipe(viewHolder: RecyclerView.ViewHolder, position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
       return items.size
    }

}