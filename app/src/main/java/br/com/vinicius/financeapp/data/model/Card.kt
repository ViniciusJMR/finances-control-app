package br.com.vinicius.financeapp.data.model

//TODO Alterar as datas para o tipo correto
data class Card(
    val id: Long,
    val name: String,
    val finalNumber: String,
    val closureDate: String,
    val dueDate: String
)
