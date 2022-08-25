package br.com.vinicius.financeapp.domain.card

import android.os.Build
import br.com.vinicius.financeapp.R
import br.com.vinicius.financeapp.data.local.repository.Repository
import br.com.vinicius.financeapp.data.model.Card
import br.com.vinicius.financeapp.data.model.dto.CardDto
import br.com.vinicius.financeapp.domain.UseCase
import br.com.vinicius.financeapp.exception.DateException
import kotlinx.coroutines.flow.Flow
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class InsertUserCardUseCase(
    private val cardRepository: Repository<Card>
) : UseCase.NoSource<CardDto>() {

    override suspend fun execute(param: CardDto): Flow<Unit> {
        val dateFormat = "dd/MM/yyyy"
        var card: Card? = null
        var closureDate: String
        var dueDate: String

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val formatter = DateTimeFormatter.ofPattern(dateFormat)
                closureDate = LocalDate.parse(param.closureDate, formatter).toString()
                dueDate = LocalDate.parse(param.dueDate, formatter).toString()
            } else {
                val formatter = SimpleDateFormat(dateFormat)
                closureDate = formatter.format(param.closureDate)
                dueDate = formatter.format(param.dueDate)
            }
            card = Card(
                0,
                param.name,
                param.finalNumber,
                closureDate,
                dueDate
            )
        } catch (e: ParseException) {
            throw DateException("Error parsing date")
        }

        return cardRepository.insert(card)
    }

}