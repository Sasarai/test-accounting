package fr.tvallierremy.test.domain.service

import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.utils.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class AccountingSummarizerTest {
    private val accountingFinder: AccountingFinder = mock()

    private val accountingSummarizer = AccountingSummarizer(accountingFinder)

    @Nested
    inner class ProfitAndLoss {
        @Test
        fun `should calculate profit and loss` () {
            val criteria = AccountingCriteria(listOf(1, 2))
            given(accountingFinder.searchFor(criteria)).willReturn(
                listOf(
                    EDF_ACCOUNTING_DEBIT_CAT_1,
                    EDF_ACCOUNTING_CREDIT_CAT_1,
                    EDF_ACCOUNTING_DEBIT_CAT_2
                )
            )

            val actual = accountingSummarizer.calculateProfitAndLoss(criteria)

            assertThat(actual).isEqualTo(listOf(EDF_SUMMARIZED_ACCOUNTING_CAT_1, EDF_SUMMARIZED_ACCOUNTING_CAT_2))
        }
    }
}
