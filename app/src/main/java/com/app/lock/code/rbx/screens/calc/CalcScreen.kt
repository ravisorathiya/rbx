package com.app.lock.code.rbx.screens.calc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lock.code.rbx.R
import com.app.lock.code.rbx.screens.main.composables.SafeImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalcScreen(
    onBackClick: () -> Unit = {},
    onItemClick: (CalcItem) -> Unit = {}
) {
    val items = listOf(
        CalcItem("USD to RBX", "Calculate USD to RBX value", R.drawable.ic_usd_rbx),
        CalcItem("RBX to USD", "Calculate RBX to USD value", R.drawable.ic_rbx_usd),
        CalcItem("RBX to Dollar", "Calculate RBX to Dollar value", R.drawable.ic_rbx_dollar),
        CalcItem("Dollar to RBX", "Calculate Dollar to RBX value", R.drawable.ic_dollar_rbx),
        CalcItem("BC to RBX", "Calculate BC to RBX value", R.drawable.ic_bc_rbx),
        CalcItem("TBC to RBX", "Calculate TBC to RBX value", R.drawable.ic_tbc_rbx),
        CalcItem("OBC to RBX", "Calculate OBC to RBX value", R.drawable.ic_obc_rbx),
        CalcItem("Play Game", "Play smart, Play hard", R.drawable.ic_game, isAdBadge = true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        // 🔹 Top Bar
        TopAppBar(
            title = {
                Text(
                    "All Calculator",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF111111)
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(items) { item ->
                CalcCard(item = item, onClick = { onItemClick(item) })
            }

            // 🔹 Ad Banner (full width)
            item(span = { GridItemSpan(2) }) {
                SafeImage(
                    resId = R.drawable.ad, // null-safe
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun CalcScreenPreview() {
        CalcScreen()
}
