package fr.tvallierremy.test.app.dto

import java.math.BigDecimal

data class SummarizedAccountingDTO(
    val category: Int,
    val balance: BigDecimal,
    val isAsset: Boolean,
)
