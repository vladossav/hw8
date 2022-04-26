package com.example.hw8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class EmployeesAdapter(): RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {
    private val employees = mutableListOf<Employee>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.photo)
        val name: TextView = view.findViewById(R.id.name)
        val liked: ImageView = view.findViewById(R.id.liked)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = employees[position]

        with(holder) {
            name.text = employee.name
            Glide.with(photo.context)
                .load(employee.photoUrl)
                .centerCrop()
                .into(photo)

            if (employee.liked) liked.visibility = View.VISIBLE
            else liked.visibility = View.GONE

            photo.setOnClickListener{
                if (!employee.liked) {
                    employee.liked = true
                    liked.visibility = View.VISIBLE
                } else {
                    employee.liked = false
                    liked.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int {
         return employees.size
    }

    fun reload(list: List<Employee>) {
        val dif = EmployeesDiffCallback(employees,list)
        val diffResult = DiffUtil.calculateDiff(dif)
        employees.clear()
        employees.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }
}

class EmployeesDiffCallback(
    private val oldList: List<Employee>,
    private val newList: List<Employee>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}