package com.example.ifinance.data


import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


@Immutable
data class Account(
    val name: String,
    val balance: Float,
    val color: Color
)

@Immutable
data class Bill(
    val name: String,
    val due: String,
    val amount: Float,
    val color: Color
)

object UserData {
    val Receita: List<Account> = listOf(
        Account(
            "Benefícios",
            2215.13f,
            Color(0xFF004940)
        ),
        Account(
            "Salário",
            8676.88f,
            Color(0xFF005D57)
        ),
        Account(
            "Férias",
            987.48f,
            Color(0xFF04B97F)
        ),
        Account(
            "Economias gerais",
            253f,
            Color(0xFF37EFBA)
        )
    )
    val Contas: List<Bill> = listOf(
        Bill(
            "Cartão de Crédito",
            "Jan 10",
            45.36f,
            Color(0xFFFFDC78)
        ),
        Bill(
            "Aluguel",
            "Fev 9",
            1200f,
            Color(0xFFFF6951)
        ),
        Bill(
            "Empréstimos",
            "Fev 22",
            87.33f,
            Color(0xFFFFD7D0)
        ),
        Bill(
            "Conta Luz",
            "Fev 29",
            400f,
            Color(0xFFFFAC12)
        ),
        Bill(
            "Conta Água",
            "Fev 29",
            77.4f,
            Color(0xFFFFAC12)
        )
    )

    fun getAccount(accountName: String?): Account {
        return Receita.first { it.name == accountName }
    }
}