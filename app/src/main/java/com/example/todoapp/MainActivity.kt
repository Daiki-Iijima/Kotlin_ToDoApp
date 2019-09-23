package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val items = ArrayList<String>()
        items.add("test")


        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items)
        TodoTableView.adapter = adapter


        TodoTableView.setOnItemClickListener{ _,view,_,_->
            val textView = view.findViewById<TextView>(android.R.id.text1)
            Toast.makeText(this,"クリックされたぞ : ${textView.text}",Toast.LENGTH_SHORT).show()
        }

        val addButton = this.findViewById<Button>(R.id.AddButton)

        addButton.setOnClickListener()
        {
            items.add("test")
            TodoTableView.adapter = adapter

            //  情報追加画面に遷移
            val intent = Intent(application, SubActivity::class.java)
            startActivity(intent)
        }
    }
}
