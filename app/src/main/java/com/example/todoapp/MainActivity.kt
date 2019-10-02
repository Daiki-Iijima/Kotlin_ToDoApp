package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    //  情報を保存する画面
    var items = ArrayList<String>()

    //  コンストラクタ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  最初に画面に表示するActivity
        setMainActivity()
    }

    //  メイン画面(ListViewがある画面)
    private fun setMainActivity()
    {
        //  使用するレイアウトファイルを設定
        setContentView(R.layout.activity_main)

        val adapter  = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items)

        findViewById<ListView>(R.id.TodoTableView).adapter = adapter

        findViewById<ListView>(R.id.TodoTableView).setOnItemClickListener{ _,view,_,_->
            val textView = view.findViewById<TextView>(android.R.id.text1)
            setEditDataActivity(textView.text.toString())
        }

        this.findViewById<Button>(R.id.AddButton).setOnClickListener()
        {
            setAddDataActivity()
        }

    }

    //  データ設定画面
    private fun setAddDataActivity()
    {
        //  使用するレイアウトファイルを設定
        setContentView(R.layout.activity_sub)

        this.findViewById<Button>(R.id.AddButton).setOnClickListener()
        {
            items.add(
                this.findViewById<TextView>(R.id.AddTextView).text.toString()
            )

            setMainActivity()
        }

        this.findViewById<Button>(R.id.CanselButton).setOnClickListener()
        {
            setMainActivity()
        }

    }

    //  データ編集画面
    private fun setEditDataActivity(dataStr:String)
    {
        //  使用するレイアウトファイルを設定
        setContentView(R.layout.activity_edit)

        this.findViewById<TextView>(R.id.ToDoText).text = dataStr

        this.findViewById<Button>(R.id.CompleteButton).setOnClickListener()
        {
            items.remove(dataStr)
            setMainActivity()
        }

        this.findViewById<Button>(R.id.CanselButton).setOnClickListener()
        {
            setMainActivity()
        }

    }
}
