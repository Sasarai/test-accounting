package fr.tvallierremy.test.domain.service

import fr.tvallierremy.test.domain.model.Accounting
import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.spi.AccountingRepository

class AccountingFinder(
    private val accountingRepository: AccountingRepository
) {
    fun searchForAll(): List<Accounting> {
        return accountingRepository.getAll()
    }

    fun searchFor(criteria: AccountingCriteria): List<Accounting> {
        return accountingRepository.getBy(criteria)
    }
}
