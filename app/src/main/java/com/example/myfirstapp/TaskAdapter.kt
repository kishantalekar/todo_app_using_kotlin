package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TaskAdapter(private val tasks:MutableList<Task>):RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
         val checkBox: CheckBox = itemView.findViewById(R.id.checkBoxCompleted)
        val deleteButton: ImageView= itemView.findViewById(R.id.imageViewDelete)
    }

        override fun onCreateViewHolder(parent:ViewGroup,viewType: Int):ViewHolder{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder:ViewHolder,position:Int){
            val task = tasks[position]
            holder.titleTextView.text = task.title
            holder.checkBox.isChecked = task.isCompleted

            // Set up long-click listener for delete button
            holder.deleteButton.setOnClickListener{
                removeTask(position)
            }
        }
        override fun getItemCount():Int{
            if (tasks.isNotEmpty())return tasks.size
            return 0
        }

        fun addTask(task: Task) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
        }
    private fun removeTask(position: Int) {
        if (tasks.isNotEmpty() && position in 0 until tasks.size) {
            tasks.removeAt(position)
            notifyItemRemoved(position)
        }
    }



}