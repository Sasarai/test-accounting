package fr.tvallierremy.test.domain.model

import java.math.BigDecimal

data class SummarizedAccounting(
    val category: Int,
    val balance: BigDecimal
) {
    fun isAsset() = balance > BigDecimal.ZERO
}
