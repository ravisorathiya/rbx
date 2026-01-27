package com.app.lock.code.rbx.screens.tips.tip

import androidx.compose.foundation.layout.Arrangement
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
import com.app.lock.code.rbx.screens.tips.tip.TipUtil.tipsList
import com.app.lock.code.rbx.screens.tips.tip.composables.TipRow

@Composable
fun TipsScreen(
    onItemClick: (TipItem) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black
    ) { innerPadding ->

        LazyColumn(
            contentPadding = innerPadding,
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





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TipsScreenPreview() {

    TipsScreen(
        onItemClick = {  }
    )
}