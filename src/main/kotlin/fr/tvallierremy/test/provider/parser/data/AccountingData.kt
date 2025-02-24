package fr.tvallierremy.test.provider.parser.data

import fr.tvallierremy.test.domain.model.Accounting
import java.math.BigDecimal
import java.time.LocalDate

data class AccountingData(
    val balance: BigDecimal,
    val category: Int,
    val collectif: Int,
    val comment: String = "",
    val credit: BigDecimal,
    val currency: String,
    val currencyAmount: BigDecimal? = null,
    val date: LocalDate,
    val debit: BigDecimal,
    val description: String,
    val header: String,
    val internalID: String,
    val journalIndex: Number,
    val lastModifyDate: LocalDate? = null,
    val letter: String,
    val letterID: String,
    val letteredInBetween: String,
    val name: String,
    val number: String,
    val paymentMethod: Int,
    val paymentMethodDescription: String,
    val periodEnd: LocalDate? = null,
    val periodStart: LocalDate? = null,
    val piece: String,
    val qtyUnit: String = "",
    val quantity: Int,
    val ref: String,
    val term: String = "",
    val voucherID: String = "",
    val voucherRef: String
) {
    fun toAccounting(): Accounting {
        return Accounting(
            balance = balance,
            category = category,
            collectif = collectif,
            comment = comment,
            credit = credit,
            currency = currency,
            currencyAmount = currencyAmount,
            date = date,
            debit = debit,
            description = description,
            header = header,
            internalID = internalID,
            journalIndex = journalIndex,
            lastModifyDate = lastModifyDate,
            letter = letter,
            letterID = letterID,
            letteredInBetween = letteredInBetween,
            name = name,
            number = number,
            paymentMethod = paymentMethod,
            paymentMethodDescription = paymentMethodDescription,
            periodEnd = periodEnd,
            periodStart = periodStart,
            piece = piece,
            qtyUnit = qtyUnit,
            quantity = quantity,
            ref = ref,
            term = term,
            voucherID = voucherID,
            voucherRef = voucherRef
        )
    }
}
