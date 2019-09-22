package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = Array(20,{ i -> "Title-$i" })

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items)
        TodoTableView.adapter = adapter

        TodoTableView.setOnItemClickListener{ _,view,_,_->
            val textView = view.findViewById<TextView>(android.R.id.text1)
            Toast.makeText(this,"クリックされたぞ : ${textView.text}",Toast.LENGTH_SHORT).show()
        }

    }
}