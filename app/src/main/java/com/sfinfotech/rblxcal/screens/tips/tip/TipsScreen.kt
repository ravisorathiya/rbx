package com.sfinfotech.rblxcal.screens.tips.tip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sfinfotech.rblxcal.screens.tips.tip.TipUtil.tipsList
import com.sfinfotech.rblxcal.screens.tips.tip.composables.TipRow
import com.sfinfotech.rblxcal.screens.tips.tip.composables.TipTopBar

@Composable
fun TipsScreen(
    onItemClick: (TipItem) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TipTopBar(onBackClick = onBackClick)
        },
        containerColor = Color.Black
    ) { innerPadding ->
        Box(Modifier.fillMaxSize().padding(innerPadding)) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                items(items = tipsList, key = { it.id }) { item ->
                    TipRow(
                        item = item,
                        onClick = { onItemClick(item) }
                    )
                }
            }

        }

    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipsScreenPreview() {

    TipsScreen(
        onItemClick = { },
        onBackClick = {  }
    )
}