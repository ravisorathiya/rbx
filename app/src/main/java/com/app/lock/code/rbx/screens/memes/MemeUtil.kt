package com.app.lock.code.rbx.screens.memes

import android.content.Context
import android.content.Intent

object MemeUtil {

    val memeList = listOf(

        MemeItem(
            "1",
            "Spawn Trapping",
            "Spawning in the middle of chaos like: 'Guess I’ll die.' 🤦‍♂️😭"
        ),
        MemeItem(
            "2",
            "Relatable Gamer Meme",
            "When your WiFi disconnects mid-game. 📶😭🎮"
        ),
        MemeItem(
            "3",
            "Robx Trade Offers",
            "When someone offers you a trade that's clearly not fair. Nice try buddy. 👀🙄😂"
        ),
        MemeItem(
            "4",
            "Friend Joins After Game Ends",
            "When your friend joins the server right after you rage-quit. 😡💀🤦‍♂️"
        ),
        MemeItem(
            "5",
            "Robx Budgeting",
            "Me: I’ll save my Robx for something special. Also me: buys a hat for 5 Robx 🎩😂"
        ),
        MemeItem(
            "6",
            "Roblox Fashion",
            "When you see someone with a cool outfit and immediately check the marketplace. 😎🛍️"
        ),

        MemeItem(
            "7",
            "Game Updates",
            "When the game updates and you have to relearn everything: Why, Roblox, why? 😭🤯"
        ),
        MemeItem(
            "8",
            "Roblox Roleplay",
            "When you join a roleplay server and everyone is super serious: Am I in the right place? 🤔🎭"
        ),
        MemeItem(
            "9",
            "Roblox Updates",
            "When the game updates and you have to start from scratch: Why, Roblox, why? 😭🔄"
        ),
        MemeItem(
            "10",
            "Robx Scams",
            "When you realize that 'free Robx' was just a scam: facepalm 🤦‍♂️🤦‍♀️"
        ),
        MemeItem(
            "11",
            "When You Get Robx",
            "Me after getting Robx: Spends it all on useless items 💸😂"
        ),
        MemeItem(
            "12",
            "Roblox Fashion (Limited)",
            "When you see someone with a limited edition item: I’m not worthy 😳🫣"
        ),
        MemeItem(
            "13",
            "Roblox Pets",
            "When you finally get that rare pet: I’m never letting you go! 🐾😍"
        ),
        MemeItem(
            "14",
            "Roblox Friends",
            "When your friend says they’ll join you but takes forever: I’m waiting… ⏳😩"
        ),
        MemeItem(
            "15",
            "Robx Inflation",
            "When you realize that 100 Robx doesn’t buy what it used to: Inflation is real 📈💸"
        ),
        MemeItem(
            "16",
            "Roblox Builders",
            "When you see a beautifully built game: I can barely build a box 🧱😭"
        ),
        MemeItem(
            "17",
            "Roblox Obby",
            "Me: This obby looks easy! Also me: Falls on the first jump 🤦‍♂️😂"
        ),
        MemeItem(
            "18",
            "Fun Robx Fact",
            "Did you know? Robx has over 40 million games created by users 🎮✨"
        ),
        MemeItem(
            "19",
            "Robx for Game Passes",
            "Me: I’ll never buy a game pass. Also me: spends 800 Robx on a double jump 😐💸"
        ),
        MemeItem(
            "20",
            "Roblox Game Passes",
            "When you buy a game pass and it doesn’t work: What a scam! 😡💸"
        ),
        MemeItem(
            "21",
            "Adopt Me Trades",
            "Friend: 'Fair trade only!' Proceeds to scam me for my legendary pet 🐾😭"
        ),
        MemeItem(
            "22",
            "Roblox Game Genres",
            "When you try a new game genre and it's nothing like you expected: What is this? 😳🎮"
        ),
        MemeItem(
            "23",
            "Invisible Walls",
            "Trying to walk through invisible walls like: 'Why can’t I go in?' 😭🚧"
        ),
        MemeItem(
            "24",
            "Roleplay Troll",
            "When the whole server is roleplaying, but you’re just there to troll 🤡😂"
        ),
        MemeItem(
            "25",
            "Roblox Community",
            "When you find a group of friends who love Roblox as much as you do: Finally, my people! 🎉😍"
        ),
        MemeItem(
            "26",
            "Simulator Grinding",
            "Spends 5 hours grinding… for one extra level ⛏️😩"
        ),
        MemeItem(
            "27",
            "Roblox Rage",
            "When you die for the 10th time in a row: I’m done with this game! 😤🔥"
        ),
        MemeItem(
            "28",
            "Pet Simulator Flex",
            "Friend: Look at my rare pet! Me: That’s great, but I have two cats 😼🐱"
        ),
        MemeItem(
            "29",
            "Tower of Hell",
            "Tower of Hell be like: 'You fell? Start over, loser.' 😈😂"
        ),
        MemeItem(
            "30",
            "Builder vs. Destroyer",
            "Friend: Let’s build something amazing! Me: Spams TNT everywhere 💥🤣"
        )
    )



    fun shareMeme(context: Context, meme: MemeItem) {
        try {
            val shareText = "${meme.title}\n\n${meme.subtitle}"

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            context.startActivity(
                Intent.createChooser(intent, "Share Meme via")
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }



}

data class MemeItem(
    val id: String,
    val title: String,
    val subtitle: String
)