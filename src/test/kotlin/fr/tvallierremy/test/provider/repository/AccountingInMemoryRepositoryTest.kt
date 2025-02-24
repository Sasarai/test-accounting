package fr.tvallierremy.test.provider.repository

import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_CREDIT_DATA_CAT_1
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_DEBIT_DATA_CAT_1
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_DEBIT_DATA_CAT_2
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class AccountingInMemoryRepositoryTest {
    private val repository = AccountingInMemoryRepository()

    @Test
    fun `should insert data into database`() {
        repository.add(EDF_ACCOUNTING_CREDIT_DATA_CAT_1)

        val actual = repository.getAll()

        assertThat(actual).isNotNull
            .containsExactly(EDF_ACCOUNTING_CREDIT_DATA_CAT_1)
    }

    @Test
    fun `should insert data by batch`() {
        repository.addAll(listOf(EDF_ACCOUNTING_CREDIT_DATA_CAT_1, EDF_ACCOUNTING_DEBIT_DATA_CAT_1))

        val actual = repository.getAll()

        assertThat(actual).isNotNull
            .containsExactly(EDF_ACCOUNTING_CREDIT_DATA_CAT_1, EDF_ACCOUNTING_DEBIT_DATA_CAT_1)
    }

    @Nested
    inner class GetBy {
        @BeforeEach
        internal fun setUp() {
            repository.addAll(listOf(EDF_ACCOUNTING_CREDIT_DATA_CAT_1, EDF_ACCOUNTING_DEBIT_DATA_CAT_1, EDF_ACCOUNTING_DEBIT_DATA_CAT_2))
        }

        @Test
        fun `should return all accounting data if criteria's category list is empty`() {
            val criteria = AccountingCriteria()

            val actual = repository.getBy(criteria)

            assertThat(actual).isNotNull
                .containsExactly(EDF_ACCOUNTING_CREDIT_DATA_CAT_1, EDF_ACCOUNTING_DEBIT_DATA_CAT_1, EDF_ACCOUNTING_DEBIT_DATA_CAT_2)
        }

        @Test
        fun `should filter on category if criteria's category list is not empty`() {
            val criteria = AccountingCriteria(categories = listOf(2))

            val actual = repository.getBy(criteria)

            assertThat(actual).isNotNull
                .containsExactly(EDF_ACCOUNTING_DEBIT_DATA_CAT_2)
        }
    }
}
