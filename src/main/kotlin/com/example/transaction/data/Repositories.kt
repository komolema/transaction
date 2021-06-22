package com.example.transaction.data

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TransactionRepository : CrudRepository<Transaction, UUID> {
    @Query("SELECT * FROM Transaction WHERE account_id = :accountUUID", nativeQuery = true)
    fun findByAccount(accountUUID: UUID): Iterable<Transaction>
}