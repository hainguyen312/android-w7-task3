package com.example.android_w7_task3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchEditText = findViewById(R.id.searchEditText)

        // Danh sách sinh viên mẫu
        val studentList = listOf(
            Student("Nguyen Van A", "123456"),
            Student("Le Thi B", "654321"),
            Student("Tran Van C", "112233"),
            Student("Pham Thi D", "445566"),
            Student("Hoang Van E", "778899"),
            Student("Nguyen Thi F", "990011"),
            Student("Le Van G", "223344"),
            Student("Vu Thi H", "556677"),
            Student("Tran Van I", "889900"),
            Student("Nguyen Van J", "101112"),
            Student("Pham Thi K", "121314"),
            Student("Bui Van L", "151617"),
            Student("Tran Thi M", "181920"),
            Student("Nguyen Van N", "212223"),
            Student("Pham Thi O", "242526"),
            Student("Hoang Van P", "272829"),
            Student("Nguyen Thi Q", "303132"),
            Student("Le Van R", "333435"),
            Student("Tran Van S", "363738"),
            Student("Vu Thi T", "394041")
        )

        adapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                adapter.filter(query)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
