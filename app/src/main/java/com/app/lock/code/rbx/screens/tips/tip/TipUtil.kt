package com.app.lock.code.rbx.screens.tips.tip

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object TipUtil {
    val tipsList = listOf(
        TipItem(
            "1",
            "Staying informed with app updates",
            "Keep your app updated to access new features, performance improvements, and important security fixes. Updates ensure you always get the best and safest experience.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "2",
            "Play Game",
            "Try featured games to earn rewards, discover new experiences, and make the most out of your time in the app.",
            TipIcon.GAMEPAD,
            TipItemType.GAME_AD
        ),
        TipItem(
            "3",
            "Engaging with the community",
            "Join discussions, follow creators, and participate in events to become an active part of the community and unlock more fun opportunities.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "4",
            "Exploring the Robx Marketplace",
            "Browse the marketplace to find exclusive items, accessories, and upgrades that enhance your in-app experience.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "5",
            "Play Game",
            "Play sponsored or featured games to earn bonuses and discover trending experiences.",
            TipIcon.GAMEPAD,
            TipItemType.GAME_AD
        ),
        TipItem(
            "6",
            "Navigating the Robx App",
            "Use menus, search, and categories to quickly find games, items, and features within the app.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "7",
            "Managing your Robx Balance",
            "Track your Robx balance regularly and spend wisely on items, upgrades, and experiences you truly value.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "8",
            "Redeeming Robx Codes",
            "Enter promo codes in the redemption section to claim free rewards, bonuses, and special items.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "9",
            "Become a Robx savvy buyer",
            "Compare prices, wait for deals, and make smart purchasing decisions to maximize the value of your Robx.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "10",
            "Play Game",
            "Explore new game worlds and limited-time events to earn extra rewards.",
            TipIcon.GAMEPAD,
            TipItemType.GAME_AD
        ),
        TipItem(
            "11",
            "Utilizing Robx in-Game",
            "Use Robx inside games to unlock abilities, cosmetics, and premium features that enhance gameplay.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "12",
            "Hunt for Hidden deals",
            "Look out for limited-time offers, bundles, and seasonal sales to get more value for your Robx.",
            TipIcon.BULB,
            TipItemType.TIP
        ),
        TipItem(
            "13",
            "Master the marketplace",
            "Learn pricing trends and popular items to become confident when buying or exploring marketplace listings.",
            TipIcon.BULB,
            TipItemType.TIP
        )
    )

}

enum class TipItemType {
    TIP,
    GAME_AD
}

@Parcelize
data class TipItem(
    val id: String,
    val title: String,
    val description: String,
    val icon: TipIcon,
    val type: TipItemType
) : Parcelable

enum class TipIcon {
    BULB,
    GAMEPAD
}