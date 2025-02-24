package fr.tvallierremy.test.domain.spi

import fr.tvallierremy.test.domain.model.Accounting
import fr.tvallierremy.test.domain.model.AccountingCriteria

interface AccountingRepository {
    fun add(accounting: Accounting)
    fun addAll(accounting: Collection<Accounting>)
    fun getAll(): List<Accounting>
    fun getBy(criteria: AccountingCriteria): List<Accounting>
}
