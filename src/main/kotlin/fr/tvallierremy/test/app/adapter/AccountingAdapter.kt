package fr.tvallierremy.test.app.adapter

import fr.tvallierremy.test.app.dto.AccountingDTO
import fr.tvallierremy.test.app.dto.SummarizedAccountingDTO
import fr.tvallierremy.test.app.mapper.toDTO
import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.service.AccountingFinder
import fr.tvallierremy.test.domain.service.AccountingSummarizer

class AccountingAdapter(
    private val accountingFinder: AccountingFinder,
    private val accountingSummarizer: AccountingSummarizer
) {
    fun searchForAll(): List<AccountingDTO> {
        return accountingFinder.searchForAll()
            .map { it.toDTO() }
    }

    fun getSummarizedData(criteria: AccountingCriteria): List<SummarizedAccountingDTO> {
        return accountingSummarizer.calculateProfitAndLoss(criteria)
            .map { it.toDTO() }
    }
}
