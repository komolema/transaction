package com.example.transaction.service

import com.example.transaction.data.Transaction
import com.example.transaction.data.TransactionRepository
import com.example.transaction.data.TransactionType
import io.leangen.graphql.annotations.GraphQLArgument
import io.leangen.graphql.annotations.GraphQLMutation
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Service
@GraphQLApi
class AuditService(val transactionRepository: TransactionRepository) {

    @GraphQLQuery
    fun getTransactions(@GraphQLArgument(name = "accountUUID") accountUUID: UUID): List<TransactionDTO> {
        return transactionRepository.findByAccount(accountUUID)
            .map { t -> TransactionDTO(t.id!!, t.date, t.transactionType, t.amount) }
            .toList()
    }

    @GraphQLMutation
    fun saveTransaction(
        @GraphQLArgument(name = "accountUUID") accountId: UUID,
        @GraphQLArgument(name = "transactionType") transactionType: TransactionType,
        @GraphQLArgument(name = "amount") amount: BigDecimal
    ): TransactionDTO {
        val transaction = Transaction(LocalDateTime.now(), transactionType, amount, accountId)
        val savedTransaction = transactionRepository.save(transaction)
        return TransactionDTO(
            savedTransaction.id!!,
            savedTransaction.date,
            savedTransaction.transactionType,
            savedTransaction.amount
        )
    }
}