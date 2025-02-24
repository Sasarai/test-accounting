package fr.tvallierremy.test.app.api.adapter

import fr.tvallierremy.test.app.adapter.AccountingAdapter
import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.service.AccountingFinder
import fr.tvallierremy.test.domain.service.AccountingSummarizer
import fr.tvallierremy.test.utils.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class AccountingAdapterTest {
    private val accountingFinder: AccountingFinder = mock()
    private val accountingSummarizer: AccountingSummarizer = mock()

    private val accountingAdapter = AccountingAdapter(accountingFinder, accountingSummarizer)

    @Nested
    inner class SearchForAll {
        @Test
        fun `Search for all accounting`() {
            given(accountingFinder.searchForAll()).willReturn(
                listOf(
                    EDF_ACCOUNTING_CREDIT_CAT_1,
                    EDF_ACCOUNTING_DEBIT_CAT_1
                )
            )

            val actual = accountingAdapter.searchForAll()

            assertThat(actual).isEqualTo(listOf(EDF_ACCOUNTING_CREDIT_DTO, EDF_ACCOUNTING_DEBIT_DTO))
        }
    }

    @Nested
    inner class GetSummarizedData {
        @Test
        fun `Get SummarizedData`() {
            val criteria = AccountingCriteria(categories = listOf(1))
            given(accountingSummarizer.calculateProfitAndLoss(criteria)).willReturn(
                listOf(EDF_SUMMARIZED_ACCOUNTING_CAT_1)
            )

            val actual = accountingAdapter.getSummarizedData(criteria)

            assertThat(actual).isEqualTo(listOf(EDF_SUMMARIZED_ACCOUNTING_DTO))
        }
    }
}
