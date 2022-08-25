package br.com.vinicius.financeapp.exception

data class DateException(
    override val message: String
) : Exception(message) {
}