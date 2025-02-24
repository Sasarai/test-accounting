package fr.tvallierremy.test.app.api.rest

import fr.tvallierremy.test.app.adapter.AccountingAdapter
import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_CREDIT_DTO
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_DEBIT_DTO
import fr.tvallierremy.test.utils.EDF_SUMMARIZED_ACCOUNTING_DTO
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class AccountingControllerTest {
    private val accountingAdapter: AccountingAdapter = mock(AccountingAdapter::class.java)
    private val accountingController: AccountingController = AccountingController(accountingAdapter)

    @Nested
    inner class GetAll {
        @Test
        fun `should return all accounting data`() {
            val allAccounting = listOf(
                EDF_ACCOUNTING_CREDIT_DTO,
                EDF_ACCOUNTING_DEBIT_DTO
            )

            given(accountingAdapter.searchForAll()).willReturn(allAccounting)

            val actual = accountingController.exportAccounting()

            assertThat(actual).isEqualTo(allAccounting)
        }
    }

    @Nested
    inner class GetSummarized {
        fun `should return summarized accounting data`() {
            val criteria = AccountingCriteria(categories = listOf(1))
            given(accountingAdapter.getSummarizedData(criteria)).willReturn(listOf(EDF_SUMMARIZED_ACCOUNTING_DTO))

            val actual = accountingController.getSummarizedData(criteria)

            assertThat(actual).isEqualTo(listOf(EDF_SUMMARIZED_ACCOUNTING_DTO))
        }
    }
}
