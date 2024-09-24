package com.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.app.database.entity.CardsDBEntity

@Dao
interface CardsDao {

    @Upsert
    suspend fun upsertAll(list: List<CardsDBEntity>)

    @Upsert
    suspend fun upsert(entity: CardsDBEntity)


    @Query("DELETE FROM trending_cards")
    suspend fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCard(card: CardsDBEntity)

    @Query("SELECT * FROM trending_cards WHERE cardId = :cardId")
    suspend fun getCard(cardId: String): CardsDBEntity?

    @Query("SELECT * FROM trending_cards")
    suspend fun getCards(): List<CardsDBEntity>?

}
