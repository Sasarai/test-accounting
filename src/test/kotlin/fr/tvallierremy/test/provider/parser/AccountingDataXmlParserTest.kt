package fr.tvallierremy.test.provider.parser

import fr.tvallierremy.test.provider.parser.data.AccountingData
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_CREDIT_DATA_CAT_1
import fr.tvallierremy.test.utils.EDF_ACCOUNTING_DEBIT_DATA_CAT_1
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountingDataXmlParserTest {
    @Test
    fun `should parse a valid xml`() {
        val file = javaClass.getResourceAsStream("/__files/input/brignolles-light.xml")!!

        val expected: List<AccountingData> = listOf(
            EDF_ACCOUNTING_CREDIT_DATA_CAT_1,
            EDF_ACCOUNTING_DEBIT_DATA_CAT_1
        )

        val actual = AccountingDataXmlParser().parse(file)

        assertThat(actual).isEqualTo(expected)
    }
}
