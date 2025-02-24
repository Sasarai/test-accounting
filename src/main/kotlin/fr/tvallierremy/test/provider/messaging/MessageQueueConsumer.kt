package fr.tvallierremy.test.provider.messaging

import fr.tvallierremy.test.domain.spi.AccountingRepository
import fr.tvallierremy.test.provider.parser.AccountingDataParser
import java.io.InputStream

class MessageQueueConsumer(
    private val parser: AccountingDataParser,
    private val accountingRepository: AccountingRepository
) {
    fun consume(input: InputStream) {
        val accountingData = parser.parse(input)
        accountingRepository.addAll(accountingData.map { it.toAccounting() })
    }
}
