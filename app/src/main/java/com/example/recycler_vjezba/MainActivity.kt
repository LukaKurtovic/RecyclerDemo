package com.example.recycler_vjezba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_vjezba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val listOfItems: MutableList<String> = mutableListOf()
        for (i in 0..30){
            listOfItems.add("List item $i")
        }
        listAdapter = Adapter(listOfItems)
        setUpItemTouchHelper()

        binding.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setUpItemTouchHelper(){
        val itemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback(listAdapter))
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

}