package fr.tvallierremy.test.domain.service

import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.spi.AccountingRepository
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_CREDIT_CAT_1
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_DEBIT_CAT_1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class AccountingFinderTest {
    private val accountingRepository: AccountingRepository = mock()

    private val accountingFinder: AccountingFinder = AccountingFinder(accountingRepository)

    @Nested
    inner class Find {
        @Test
        fun `should search for all accounting`() {
            given(accountingRepository.getAll()).willReturn(
                listOf(EDF_ACCOUNTING_DEBIT_CAT_1, EDF_ACCOUNTING_CREDIT_CAT_1)
            )

            val actual = accountingFinder.searchForAll()

            assertThat(actual).isEqualTo(listOf(EDF_ACCOUNTING_DEBIT_CAT_1, EDF_ACCOUNTING_CREDIT_CAT_1))
        }

        @Test
        fun `should search for accounting by given criteria`() {
            val criteria = AccountingCriteria(categories = listOf(1))

            given(accountingRepository.getBy(criteria)).willReturn(
                listOf(EDF_ACCOUNTING_DEBIT_CAT_1, EDF_ACCOUNTING_CREDIT_CAT_1)
            )

            val actual = accountingRepository.getBy(criteria)

            assertThat(actual).isEqualTo(listOf(EDF_ACCOUNTING_DEBIT_CAT_1, EDF_ACCOUNTING_CREDIT_CAT_1))
        }
    }
}
