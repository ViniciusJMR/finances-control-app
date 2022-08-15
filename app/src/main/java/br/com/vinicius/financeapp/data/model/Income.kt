package br.com.vinicius.financeapp.data.model

/**
 * TODO - Alterar date para o tipo correto
 * TODO - Criar IncomeType e ParcelableIncome
 */
data class Income(
    val id: Long,
    val amount: Double,
    val description: String,
    val date: String,
    val card: Card
){
    val tags = mutableListOf<Tag>()
}
