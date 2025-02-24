package fr.tvallierremy.test.app

import fr.tvallierremy.test.app.adapter.AccountingAdapter
import fr.tvallierremy.test.app.api.rest.AccountingController
import fr.tvallierremy.test.domain.model.AccountingCriteria
import fr.tvallierremy.test.domain.service.AccountingFinder
import fr.tvallierremy.test.domain.service.AccountingSummarizer
import fr.tvallierremy.test.provider.adapter.AccountingInMemoryRepositoryAdapter
import fr.tvallierremy.test.provider.messaging.MessageQueueConsumer
import fr.tvallierremy.test.provider.parser.AccountingDataXmlParser

fun main() {
    val accountingRepository = AccountingInMemoryRepositoryAdapter()
    val accountingFinder = AccountingFinder(accountingRepository)

    val messageQueueConsumer = MessageQueueConsumer(
        parser = AccountingDataXmlParser(),
        accountingRepository = accountingRepository
    )

    val accountingController = AccountingController(
        accountingAdapter = AccountingAdapter(
            accountingFinder = accountingFinder,
            accountingSummarizer = AccountingSummarizer(accountingFinder)
        )
    )

    println("Data acquisition")
    messageQueueConsumer.consume(object{}.javaClass.getResourceAsStream("/__files/input/brignolles-full.xml")!!)

    println("Get all data")
    val data = accountingController.exportAccounting()

    println("Data")
    data.forEach {
        println(it)
    }

    println("Summarized Data all")
    val summarizedData = accountingController.getSummarizedData(AccountingCriteria())

    summarizedData.forEach {
        println(it)
    }

    println("Summarized Data all")
    val filteredSummarizedData = accountingController.getSummarizedData(AccountingCriteria(categories = listOf(1, 2)))

    filteredSummarizedData.forEach {
        println(it)
    }
}
