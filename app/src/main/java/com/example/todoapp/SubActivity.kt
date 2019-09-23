package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subavtivity_main)

        val addButton = findViewById<Button>(R.id.AddButton)
        val canselButton = findViewById<Button>(R.id.CanselButton)
        val addTextView = findViewById<TextView>(R.id.AddTextView)

        canselButton.setOnClickListener()
        {
            //  前の画面に遷移
            finish()
        }

        addButton.setOnClickListener()
        {
            val getText = addTextView.text.toString()


        }




    }
}