package com.sfinfotech.rblxcal.screens.main

import androidx.activity.compose.BackHandler
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.retain.retain
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sfinfotech.rblxcal.R
import com.sfinfotech.rblxcal.model.ConvertModel
import com.sfinfotech.rblxcal.screens.main.composables.CurrencyCalcCard
import com.sfinfotech.rblxcal.screens.main.composables.FakeAdCard
import com.sfinfotech.rblxcal.screens.main.composables.ImageButtonCard
import com.sfinfotech.rblxcal.screens.main.composables.ScorePillButton
import com.sfinfotech.rblxcal.util.ActivityTracker
import com.sfinfotech.rblxcal.util.DataUtil
import com.sfinfotech.rblxcal.util.ExitAppDialog
import com.sfinfotech.rblxcal.util.NoInternetDialog
import com.sfinfotech.rblxcal.util.Util
import com.sfinfotech.rblxcal.util.Util.rememberIsNetworkAvailable

@Composable
fun MainScreen(
    onClick: (ConvertModel) -> Unit,
    onSettingClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        contentColor = Color.White
    ) { innerPadding ->

        val activity = LocalActivity.current
        var currencyList by retain { mutableStateOf(Util.convertModelList) }


        var showExitDialog by remember { mutableStateOf(false) }

        val available by rememberIsNetworkAvailable()

        if (!available) {
            NoInternetDialog()
        }


        if (showExitDialog) {
            ExitAppDialog(
                onDismiss = { showExitDialog = false },
                onExit = {
                    activity?.finishAffinity()
                    ActivityTracker.getAllActivities().onEach { it.finish() }
                    activity?.finish()
                }
            )
        }

        BackHandler {
            showExitDialog = true
        }

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1c1c1e))

            ) {

                // ─── Title Row ────────────────────────────────
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "RBX Calculator",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "Robox Counter",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }

                    ImageButtonCard(
                        icon = R.drawable.setting,
                        onClick = onSettingClick
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // ─── Score Button ──────────────────────────────
                ScorePillButton(
                    score = DataUtil.rbxCoins,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .offset(y = 24.dp)
                )
            }

            Spacer(Modifier.height(32.dp))


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {

//                items(
//                    items = currencyList,
//                    span = { GridItemSpan(it.span) },
//                    key = { it.title + it.hashCode() }
//                ) { item ->
//                    CurrencyCalcCard(item)
//                }

                itemsIndexed(
                    items = currencyList,
                    span = { index, item ->
                        if (index == 1) GridItemSpan(2) else GridItemSpan(item.span)
                    },
                    key = { _, item -> item.hashCode() }
                ) { index, item ->
                    if (index == 1) {
                        FakeAdCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                        )
                    } else {
                        CurrencyCalcCard(
                            item = item,
                            onClick = onClick
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPrevoew() {
    MainScreen(
        onClick = { },
        onSettingClick = { }
    )
}