package fr.tvallierremy.test.domain.service

import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.model.SummarizedAccounting
import java.math.BigDecimal

class AccountingSummarizer(
    private val accountingFinder: AccountingFinder
) {
    fun calculateProfitAndLoss(criteria: AccountingCriteria): List<SummarizedAccounting> {
        val accounting = accountingFinder.searchFor(criteria)

        return accounting.groupBy { it.category }
            .values
            .map { it.fold(SummarizedAccounting(it[0].category, BigDecimal.ZERO)) { acc, c ->
                SummarizedAccounting(acc.category, acc.balance + c.balance)
            } }
    }

}
