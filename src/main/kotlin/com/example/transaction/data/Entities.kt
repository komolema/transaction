package com.example.transaction.data

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Transaction(
    var date: LocalDateTime,
    var transactionType: TransactionType,
    var amount: BigDecimal,
    var accountId: UUID,
    @Id @GeneratedValue var id: UUID? = null
)

enum class TransactionType {
    DEPOSIT,
    WITHDRAWAL
}
