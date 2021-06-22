package com.example.transaction.service

import com.example.transaction.data.Transaction
import com.example.transaction.data.TransactionRepository
import com.example.transaction.data.TransactionType
import org.junit.jupiter.api.Test
import org.mockito.Matchers
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal
import java.util.*

class AuditServiceIntegrationTest {
    /*
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var transactionRepository: TransactionRepository

    @Test
    fun test() {
        mvc.perform(
            post("/graphql")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    saveTransactionMutation(
                        TransactionType.DEPOSIT,
                        BigDecimal(100),
                        UUID.fromString("22222626-124e-4f0a-8dd7-2fee265eff1d")
                    )
                )).andExpect(status().isCreated)

        verify(transactionRepository).save(Matchers.any<Transaction>())
    }
    */

    fun saveTransactionMutation(transactionType: TransactionType, amount: BigDecimal, accountUUID: UUID): String {

        return "{\"operationName\":null,\"variables\":{},\"query\":\"mutation {\\n  saveTransaction(transactionType: ${transactionType.name}, amount: $amount, accountUUID: \\\"$accountUUID\\\") {\\n    amount\\n    id\\n    transactionType\\n  }\\n}\\n\"}"
    }
}
