package com.example.android_w7_task3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val studentList: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var filteredList = studentList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = filteredList[position]
        holder.nameTextView.text = student.name
        holder.mssvTextView.text = student.mssv
    }

    override fun getItemCount() = filteredList.size

    fun filter(query: String) {
        filteredList = if (query.length < 3) {
            studentList.toMutableList()
        } else {
            studentList.filter {
                it.name.contains(query, ignoreCase = true) || it.mssv.contains(query)
            }.toMutableList()
        }
        notifyDataSetChanged()
    }

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val mssvTextView: TextView = itemView.findViewById(R.id.mssvTextView)
    }
}