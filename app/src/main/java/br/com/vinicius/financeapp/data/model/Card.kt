package br.com.vinicius.financeapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO Alterar as datas para o tipo correto
@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val finalNumber: String,
    val closureDate: String,
    val dueDate: String
)
