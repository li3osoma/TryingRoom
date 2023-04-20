package com.example.tryingroom.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notions")
class Notion(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "body") val body: String) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}