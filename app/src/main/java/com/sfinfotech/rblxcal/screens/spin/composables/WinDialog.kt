package com.sfinfotech.rblxcal.screens.spin.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sfinfotech.rblxcal.util.Util

@Composable
fun WinDialog(
    amount: Int,
    onAddToWallet: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        containerColor = Color(0xFF1C1C1E),
        confirmButton = {
            Button(
                onClick = onAddToWallet,
                colors = ButtonDefaults.buttonColors(containerColor = Util.PRIMARY__COLOR)
            ) {
                Text("Add to Wallet", color = Color.Black)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Dismiss", color = Color.White)
            }
        },
        title = {
            Text("🎉 Congratulations!", color = Color.White)
        },
        text = {
            Text("You won $amount RBX!", color = Color.LightGray)
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun WinDialogPreview() {
    WinDialog(
        amount = 325,
        onAddToWallet = {},
        onDismiss = {}
    )
}
