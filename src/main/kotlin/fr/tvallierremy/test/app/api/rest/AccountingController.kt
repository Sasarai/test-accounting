package fr.tvallierremy.test.app.api.rest

import fr.tvallierremy.test.app.adapter.AccountingAdapter
import fr.tvallierremy.test.app.dto.AccountingDTO
import fr.tvallierremy.test.app.dto.SummarizedAccountingDTO
import fr.tvallierremy.test.domain.model.AccountingCriteria

class AccountingController(
    private val accountingAdapter: AccountingAdapter
){
    fun exportAccounting(): List<AccountingDTO> {
        return accountingAdapter.searchForAll()
    }

    fun getSummarizedData(criteria: AccountingCriteria): List<SummarizedAccountingDTO> {
        return accountingAdapter.getSummarizedData(criteria)
    }
}
