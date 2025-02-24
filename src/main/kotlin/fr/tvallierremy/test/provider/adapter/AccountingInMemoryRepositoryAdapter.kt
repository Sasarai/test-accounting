package fr.tvallierremy.test.provider.adapter

import fr.tvallierremy.test.domain.model.Accounting
import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.spi.AccountingRepository
import fr.tvallierremy.test.provider.mapper.toAccountingData
import fr.tvallierremy.test.provider.repository.AccountingInMemoryRepository

class AccountingInMemoryRepositoryAdapter: AccountingRepository {
    private val accountingInMemoryRepository = AccountingInMemoryRepository()

    override fun add(accounting: Accounting) {
        accountingInMemoryRepository.add(accounting.toAccountingData())
    }

    override fun addAll(accounting: Collection<Accounting>) {
        accountingInMemoryRepository.addAll(accounting.map { it.toAccountingData() })
    }

    override fun getAll(): List<Accounting> {
        return accountingInMemoryRepository.getAll()
            .map { it.toAccounting() }
    }

    override fun getBy(criteria: AccountingCriteria): List<Accounting> {
        return accountingInMemoryRepository.getBy(criteria)
            .map { it.toAccounting() }
    }
}
