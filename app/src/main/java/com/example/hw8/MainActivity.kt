package com.example.hw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()
    private val empAdapter = EmployeesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv_holder)
        rv.layoutManager = GridLayoutManager(this, 2)
        rv.adapter = empAdapter
        val div = ItemOffsetDecoration(this, R.dimen.margin)
        rv.addItemDecoration(div)

        viewModel.employees.observe(this) {
            empAdapter.reload(it)
        }
    }

}