package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.w3c.dom.Text
import java.io.BufferedReader
import java.io.File
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    //  情報を保存する画面
    var items = ArrayList<String>()
    var map : MutableMap<String, String> = mutableMapOf()

    //  コンストラクタ
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //  最初に画面に表示するActivity
        setMainActivity()
    }

    fun SaveJsonFile(saveMap:MutableMap<String,String>){

        Log.d("これはタグ","これはログで出力したい文字列")
        val gson = Gson()
        val jsonString : String = gson.toJson(saveMap)

        //  データ保存用にテキストを保存
        val fileName = "saveJson.json"
        File(applicationContext.filesDir, fileName).writer().use {
            it.write(jsonString)
        }
    }

    fun LoadJsonFile()
    {
        val readFile = File(applicationContext.filesDir,"saveJson.json")

        if(readFile.exists()){
            val contents = readFile.bufferedReader().use(BufferedReader::readText)

            val gson = Gson()
            val type : Type = object : TypeToken<MutableMap<String, String>>() {}.type

            val loadDataMap : MutableMap<String, String> = gson.fromJson(contents, type)
            for (mapValue in loadDataMap.values) {
                Log.d("LoadKotlin", mapValue)
            }

            map = loadDataMap
        }


    }

    //  メイン画面(ListViewがある画面)
    private fun setMainActivity()
    {
        //  使用するレイアウトファイルを設定
        setContentView(R.layout.activity_main)

        //  保存した情報の保存
        LoadJsonFile()

        //  代入用にキーをリストに変換
        var itemData = map.keys.toList()




        val adapter  = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemData)

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

            var setDataStr = this.findViewById<TextView>(R.id.AddTextView).text.toString()
            val df = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
            val date = Date()
            map.put(setDataStr,df.format(date))

            SaveJsonFile(map)
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
            map.remove(dataStr)
            setMainActivity()
        }

        this.findViewById<Button>(R.id.CanselButton).setOnClickListener()
        {
            setMainActivity()
        }

    }
}
