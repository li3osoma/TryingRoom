package com.example.tryingroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tryingroom.dao.NotionDao
import com.example.tryingroom.database.NotionDatabase
import com.example.tryingroom.databinding.ActivityMainBinding
import com.example.tryingroom.entity.Notion

class MainActivity : AppCompatActivity() {

    lateinit var db:RoomDatabase
    lateinit var binding: ActivityMainBinding
    lateinit var notionDao: NotionDao

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)

        db=Room.databaseBuilder(applicationContext, NotionDatabase::class.java, "notions")
            .allowMainThreadQueries()
            .build()
        notionDao= (db as NotionDatabase).notionDao()
        updateUi()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            saveNotion()
            updateUi()
        }
    }

    private fun saveNotion(){
        notionDao.insert(Notion(
            binding.titleEditText.text.toString(),
            binding.bodyEditText.text.toString()))
    }

    private fun updateUi(){
        var title=""
        var text=""
        for(notion in notionDao.getNotionsList()){
            title+=notion.title+"\n"
            text+=notion.body+"\n"
        }
        binding.titleText.text=title
        binding.bodyText.text=text
    }


}