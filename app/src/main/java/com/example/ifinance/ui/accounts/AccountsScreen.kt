package com.example.ifinance.ui.accounts


import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.ifinance.R
import com.example.ifinance.data.Account
import com.example.ifinance.ui.components.AccountRow
import com.example.ifinance.ui.components.StatementBody


@Composable
fun AccountsBody(
    accounts: List<Account>,
    onAccountClick: (String) -> Unit = {},
) {
    StatementBody(
        modifier = Modifier.semantics { contentDescription = "Receita" },
        items = accounts,
        amounts = { account -> account.balance },
        colors = { account -> account.color },
        amountsTotal = accounts.map { account -> account.balance }.sum(),
        circleLabel = stringResource(R.string.total),
        rows = { account ->
            AccountRow(
                modifier = Modifier.clickable {
                    onAccountClick(account.name)
                },
                name = account.name,
                amount = account.balance,
                color = account.color
            )
        }
    )
}

@Composable
fun SingleAccountBody(account: Account) {
    StatementBody(
        items = listOf(account),
        colors = { account.color },
        amounts = { account.balance },
        amountsTotal = account.balance,
        circleLabel = account.name,
    ) { row ->
        AccountRow(
            name = row.name,
            amount = row.balance,
            color = row.color
        )
    }
}