package com.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.database.dao.CardsDao
import com.app.database.entity.CardsDBEntity

@Database(
    entities = [
        CardsDBEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class MainDatabase : RoomDatabase() {
    abstract fun cardsDao(): CardsDao
}
