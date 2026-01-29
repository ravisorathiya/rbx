# 🟢 RBX Calculator – Roblox Counter App

A modern Android app built with **Jetpack Compose** that lets users:

- Convert between **USD and RBX**
- Spin a **Lucky Wheel** to win RBX coins
- Track RBX balance using **persistent storage**
- Enjoy a smooth, dark-themed UI with animated screens

---

## ✨ Features

### 🧮 RBX Converters
Convert between multiple Roblox-related currencies:

- USD → RBX  
- RBX → USD  
- Dollar → RBX  
- BC / TBC / OBC → RBX  

All calculators use a **shared dynamic result screen**.

---

### 🎡 Lucky Spin Wheel
Interactive spin wheel where users can win RBX coins.

- Smooth animated spin  
- Accurate slice detection  
- Rewards saved to wallet  
- Persistent balance using DataStore  

---

### 💰 RBX Wallet System
Global coin balance system:

- Stored using **Jetpack DataStore**  
- Observed in real-time using **Compose State**  
- Automatically updates UI everywhere  

---

### 📱 Modern UI
- Built fully with **Jetpack Compose**  
- Dark theme design  
- Material 3 components  
- Smooth splash screen with system splash API  

---

## 🏗️ Tech Stack

| Tech | Usage |
|------|------|
| Kotlin | Main language |
| Jetpack Compose | UI framework |
| DataStore | Persistent coin storage |
| Coroutines | Background tasks |
| Material 3 | UI components |
| SplashScreen API | Launch screen |

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/yourusername/rbx-calculator.git
```

---

### 2️⃣ Open in Android Studio

- Use **Android Studio Hedgehog or newer**
- Let Gradle sync

---

### 3️⃣ Add Required Assets

Place these in your project:

```
res/drawable/ad.png        → Ad banner image  
res/drawable/app_logo.png  → Splash logo  
```

---

### 4️⃣ Run the App

- Select an emulator or device  
- Click **Run ▶**

---

## 🧠 Project Structure

```
ui/
 ├─ splash/          → Splash screen
 ├─ calculator/      → Conversion screens
 ├─ spin/            → Lucky wheel game
 └─ components/      → Reusable UI

data/
 └─ DataUtil.kt      → Global RBX wallet storage

util/
 └─ Util.kt          → App colors & constants
```

---

## 💾 RBX Coin Storage (How It Works)

RBX balance is managed globally via `DataUtil`:

- Uses **Preferences DataStore**
- Exposes `State<Int>` for Compose
- Automatically updates UI on change

Example:

```kotlin
val coins by DataUtil.rbxCoins
Text("RBX Coins: $coins")
```

Add coins:

```kotlin
viewModelScope.launch {
    DataUtil.incrementCoins(50)
}
```

---

## 🎯 Lucky Spin Accuracy

The spin wheel uses:

- Normalized rotation math  
- Pointer-based slice detection  
- Half-slice offset correction  

Ensures the prize always matches the visual segment.

---

## 🎨 Splash Screen System

App uses **Android 12 SplashScreen API**:

- Black background  
- Centered launcher icon  
- Then animated Compose splash  

---

## 🔒 Disclaimer

This app is a **fan-made utility** and is **not affiliated with Roblox Corporation**.  
RBX values are for entertainment and conversion estimation only.

---

## 📌 Future Improvements

- Weighted spin probabilities  
- Daily rewards system  
- Sound & haptic feedback  
- Online RBX rate sync  

---

## ❤️ Author

Made with Kotlin & Jetpack Compose.

If you like this project, ⭐ star the repo!
