package fr.tvallierremy.test.app.dto

import java.math.BigDecimal
import java.time.LocalDate

data class AccountingDTO(
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
)
