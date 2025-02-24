package fr.tvallierremy.test.provider.parser

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import fr.tvallierremy.test.provider.parser.data.AccountingData
import java.io.InputStream

class AccountingDataXmlParser: AccountingDataParser {
    val deserializer = XmlMapper(
        JacksonXmlModule().apply {
            setDefaultUseWrapper(false)
        }
    ).registerKotlinModule()
        .registerModule(JavaTimeModule())


    override fun parse(xmlFile: InputStream): List<AccountingData> {
        return deserializer.readValue(xmlFile, XmlContent::class.java)
            .data.accountingData
    }
}

@JacksonXmlRootElement(localName = "WCFRestIRFGeneralLegerResult")
data class XmlContent(
    val response: Any,
    val data: XmlData
)

data class XmlData(
    @field:JsonProperty("wsGeneralLedger") val accountingData: List<AccountingData>
)
