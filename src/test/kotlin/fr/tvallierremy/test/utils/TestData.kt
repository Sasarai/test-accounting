package fr.tvallierremy.test.utils

import fr.tvallierremy.test.app.mapper.toDTO
import fr.tvallierremy.test.domain.model.Accounting
import fr.tvallierremy.test.domain.model.SummarizedAccounting
import fr.tvallierremy.test.provider.mapper.toAccountingData
import java.math.BigDecimal
import java.time.LocalDate

val EDF_ACCOUNTING_CREDIT_CAT_1 = Accounting(
    balance = BigDecimal("-77754.23"),
    category = 1,
    collectif = 411100,
    credit = BigDecimal("77754.23"),
    currency = "EUR",
    currencyAmount = BigDecimal.ZERO,
    date = LocalDate.of(2016, 6, 1),
    debit = BigDecimal.ZERO,
    description = "EDF",
    header = "{6BB250E2-EF74-4B41-AB79-4E6AAD599DDF}",
    internalID = "{C575EABB-D2E8-422B-A9E6-02042EFD0310}",
    journalIndex = 1467886848315,
    lastModifyDate = LocalDate.of(2016, 7, 7),
    letter = "Oui",
    letterID = "{34950884-49A6-4FA6-A700-B1FDCFBBE819}",
    letteredInBetween = "Non",
    name = "EDF",
    number = "0EDF",
    paymentMethod = 0,
    paymentMethodDescription = "Aucun",
    piece = "2",
    quantity = 0,
    ref = "BQ06",
    voucherRef = "VIR"
)
val EDF_ACCOUNTING_DEBIT_CAT_1 = Accounting(
    balance = BigDecimal("65572.06"),
    category = 1,
    collectif = 411100,
    credit = BigDecimal.ZERO,
    currency = "EUR",
    currencyAmount = BigDecimal.ZERO,
    date = LocalDate.of(2016, 4, 8),
    debit = BigDecimal("65572.06"),
    description = "EDF 03/16",
    header = "{7F28EE2E-E8DB-4A96-8985-5B74F66862DD}",
    internalID = "{A7FF3014-D805-44DE-89BB-0A45845A6CA4}",
    journalIndex = 1462792597843,
    lastModifyDate = LocalDate.of(2016, 6, 7),
    letter = "Oui",
    letterID = "{24D9A5AC-4301-4B31-B0D9-554E3E90024B}",
    letteredInBetween = "Non",
    name = "EDF",
    number = "0EDF",
    paymentMethod = 0,
    paymentMethodDescription = "Aucun",
    piece = "1",
    quantity = 0,
    ref = "VTE",
    voucherRef = "2016.BRI.03"
)
val EDF_ACCOUNTING_DEBIT_CAT_2 = Accounting(
    balance = BigDecimal("65572.06"),
    category = 2,
    collectif = 411100,
    credit = BigDecimal.ZERO,
    currency = "EUR",
    currencyAmount = BigDecimal.ZERO,
    date = LocalDate.of(2016, 4, 8),
    debit = BigDecimal("65572.06"),
    description = "EDF 03/16",
    header = "{7F28EE2E-E8DB-4A96-8985-5B74F66862DD}",
    internalID = "{A7FF3014-D805-44DE-89BB-0A45845A6CA4}",
    journalIndex = 1462792597843,
    lastModifyDate = LocalDate.of(2016, 6, 7),
    letter = "Oui",
    letterID = "{24D9A5AC-4301-4B31-B0D9-554E3E90024B}",
    letteredInBetween = "Non",
    name = "EDF",
    number = "0EDF",
    paymentMethod = 0,
    paymentMethodDescription = "Aucun",
    piece = "1",
    quantity = 0,
    ref = "VTE",
    voucherRef = "2016.BRI.03"
)
val EDF_SUMMARIZED_ACCOUNTING_CAT_1 = SummarizedAccounting(
    balance = EDF_ACCOUNTING_DEBIT_CAT_1.balance.plus(EDF_ACCOUNTING_CREDIT_CAT_1.balance),
    category = 1
)
val EDF_SUMMARIZED_ACCOUNTING_CAT_2 = SummarizedAccounting(
    balance = EDF_ACCOUNTING_DEBIT_CAT_2.balance,
    category = 2
)

val EDF_ACCOUNTING_CREDIT_DATA_CAT_1 = EDF_ACCOUNTING_CREDIT_CAT_1.toAccountingData()
val EDF_ACCOUNTING_DEBIT_DATA_CAT_1 = EDF_ACCOUNTING_DEBIT_CAT_1.toAccountingData()
val EDF_ACCOUNTING_DEBIT_DATA_CAT_2 = EDF_ACCOUNTING_DEBIT_CAT_2.toAccountingData()

val EDF_ACCOUNTING_CREDIT_DTO = EDF_ACCOUNTING_CREDIT_CAT_1.toDTO()
val EDF_ACCOUNTING_DEBIT_DTO = EDF_ACCOUNTING_DEBIT_CAT_1.toDTO()
val EDF_SUMMARIZED_ACCOUNTING_DTO = EDF_SUMMARIZED_ACCOUNTING_CAT_1.toDTO()
