package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.*


class MainActivity : AppCompatActivity() {

    var items = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setMainActivity()
    }

    private fun setMainActivity()
    {
        setContentView(R.layout.activity_main)

        val adapter  = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items)

        findViewById<ListView>(R.id.TodoTableView).adapter = adapter

        findViewById<ListView>(R.id.TodoTableView).setOnItemClickListener{ _,view,_,_->
            val textView = view.findViewById<TextView>(android.R.id.text1)
            Toast.makeText(this,"クリックされたぞ : ${textView.text}",Toast.LENGTH_SHORT).show()
        }

        this.findViewById<Button>(R.id.AddButton).setOnClickListener()
        {
            setAddDataActivity()
        }

    }

    private  fun setAddDataActivity()
    {
        setContentView(R.layout.subavtivity_main)

        this.findViewById<Button>(R.id.AddButton).setOnClickListener()
        {
            items.add(
                this.findViewById<TextView>(R.id.AddTextView).text.toString()
            )

            setMainActivity()
        }

    }
}
