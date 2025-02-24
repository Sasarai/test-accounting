package fr.tvallierremy.test.provider.mapper

import fr.tvallierremy.test.domain.model.Accounting
import fr.tvallierremy.test.provider.parser.data.AccountingData

fun Accounting.toAccountingData(): AccountingData {
    return AccountingData(
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
