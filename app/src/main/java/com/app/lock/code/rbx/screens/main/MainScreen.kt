package com.app.lock.code.rbx.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.retain.retain
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.lock.code.rbx.R
import com.app.lock.code.rbx.util.Util

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        var currencyList by retain { mutableStateOf(Util.convertModelList) }


        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(
                        text = "RBX Calculator",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "Robox Counter",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start

                    )
                }


                IconButton(
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color.Black)
                        .padding(16.dp),
                    onClick = {},
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_launcher_background),
                        contentDescription = null

                    )
                }
            }

            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(items = currencyList, span = {item->
                    GridItemSpan(item.span)
                }) { item ->
                    CurrencyCalcCard(item)
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPrevoew() {
    MainScreen()
}