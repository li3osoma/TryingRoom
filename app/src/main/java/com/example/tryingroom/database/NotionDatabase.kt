package com.example.tryingroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tryingroom.dao.NotionDao
import com.example.tryingroom.entity.Notion

@Database(entities = [Notion::class], version = 1)
abstract class NotionDatabase : RoomDatabase() {
    abstract fun notionDao(): NotionDao
}