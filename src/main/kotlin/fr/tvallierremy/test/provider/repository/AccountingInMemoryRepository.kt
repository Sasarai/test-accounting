package fr.tvallierremy.test.provider.repository

import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.provider.parser.data.AccountingData

class AccountingInMemoryRepository {
    private val repository = mutableListOf<AccountingData>()

    fun add(accountingData: AccountingData) {
        repository.add(accountingData)
    }

    fun addAll(accountingData: Collection<AccountingData>) {
        repository.addAll(accountingData)
    }

    fun getAll(): List<AccountingData> {
        return repository
    }

    fun getBy(criteria: AccountingCriteria): List<AccountingData> {
        return repository.filter { criteria.categories.isEmpty() || criteria.categories.contains(it.category) }
    }

}
