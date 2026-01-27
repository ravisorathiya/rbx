package com.app.lock.code.rbx.screens.memes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lock.code.rbx.screens.memes.MemeUtil.memeList
import com.app.lock.code.rbx.screens.memes.composables.MemeItemRow
import com.app.lock.code.rbx.screens.memes.composables.MemesTopBar

@Composable
fun MemesScreen(
    onBackClick: () -> Unit = {},
    onShareClick: (MemeItem) -> Unit = {}
) {
    Scaffold(
        containerColor = Color.Black,
        topBar = {
            MemesTopBar(onBackClick)
        }
    ) { innerPadding ->

        Box(Modifier.fillMaxSize().padding(innerPadding)){
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                items(memeList, key = { it.id }) { meme ->
                    MemeItemRow(
                        meme = meme,
                        onShareClick = { onShareClick(meme) }
                    )
                }

                item { Spacer(modifier = Modifier.height(80.dp)) } // space for bottom ad if added later
            }

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000, showSystemUi = true)
@Composable
fun MemesScreenPreview() {
    MemesScreen()
}
