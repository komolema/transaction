package com.example.transaction.service

import com.example.transaction.data.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class TransactionDTO(
    val id: UUID,
    val date: LocalDateTime,
    val transactionType: TransactionType,
    val amount: BigDecimal,
)