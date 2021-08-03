package com.example.ifinance

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ifinance.data.UserData
import com.example.ifinance.ui.accounts.AccountsBody
import com.example.ifinance.ui.bills.BillsBody
import com.example.ifinance.ui.overview.OverviewBody



enum class FinanceScreen (
    val icon: ImageVector,
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Resumo(
        icon = Icons.Filled.PieChart,
        body = { OverviewBody() }
    ),
    Receita(
        icon = Icons.Filled.AttachMoney,
        body = { AccountsBody(UserData.Receita) }
    ),
    Contas(
        icon = Icons.Filled.MoneyOff,
        body = { BillsBody(UserData.Contas) }
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: String?): FinanceScreen =
            when (route?.substringBefore("/")) {
                Receita.name -> Receita
                Contas.name -> Contas
                Resumo.name -> Resumo
                null -> Resumo
                else -> throw IllegalArgumentException("Rota $route inão reconhecida")
            }
    }
}


