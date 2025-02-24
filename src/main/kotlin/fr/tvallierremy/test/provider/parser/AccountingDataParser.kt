package fr.tvallierremy.test.provider.parser

import fr.tvallierremy.test.provider.parser.data.AccountingData
import java.io.InputStream

fun interface AccountingDataParser {
    fun parse(data: InputStream): List<AccountingData>
}
