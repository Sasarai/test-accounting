package fr.tvallierremy.test.app.mapper

import fr.tvallierremy.test.app.dto.AccountingDTO
import fr.tvallierremy.test.app.dto.SummarizedAccountingDTO
import fr.tvallierremy.test.domain.model.Accounting
import fr.tvallierremy.test.domain.model.SummarizedAccounting

fun Accounting.toDTO(): AccountingDTO {
    return AccountingDTO(
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

fun SummarizedAccounting.toDTO(): SummarizedAccountingDTO {
    return SummarizedAccountingDTO(
        category = category,
        balance = balance,
        isAsset = isAsset()
    )
}
