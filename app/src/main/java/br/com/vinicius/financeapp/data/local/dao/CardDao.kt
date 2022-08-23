package br.com.vinicius.financeapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.vinicius.financeapp.data.model.Card
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {

    @Query("SELECT * FROM Card")
    fun getAllCards(): LiveData<List<Card>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newCard: Card)

}