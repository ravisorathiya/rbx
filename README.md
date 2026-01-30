# RBX Calculator App

RBX Calculator is an Android app built with **Jetpack Compose** that allows users to:

- Convert between RBX and real currency
- Spin a lucky wheel to win RBX coins
- View ads inside an in-app browser
- Store RBX balance locally using DataStore
- Receive live configuration updates from Firebase

---

## 🚀 Clone the Project

```bash
git clone https://github.com/ravisorathiya/rbx.git
```

Open the project in **Android Studio (Hedgehog or newer recommended)** and let Gradle sync.

---

## 🔥 Firebase Setup (Required)

This project uses **Firebase Remote Config, Crashlytics, and Firestore**.  
You must connect your own Firebase project.

### 1️⃣ Create Firebase Project
1. Go to **https://console.firebase.google.com/**
2. Click **Add Project**
3. Follow setup steps

---

### 2️⃣ Add Android App in Firebase
1. Click **Add App → Android**
2. Enter package name (same as project)
3. Download **`google-services.json`**

---

### 3️⃣ Add File to Project

Place the downloaded file here:

```
app/google-services.json
```

⚠️ This file is **not included in the repo** for security reasons.

---

### 4️⃣ Enable Required Firebase Services

Inside Firebase Console enable:

- **Remote Config**
- **Crashlytics**
- **Firestore Database**

---

### 5️⃣ Add Remote Config Parameter

Go to **Remote Config → Add parameter**

| Key | Value |
|-----|------|
| `ad_link` | Your ad URL |

Click **Publish Changes**

---

## ▶ Run the App

1. Connect device or start emulator
2. Click **Run ▶** in Android Studio

---

## 📁 Important Files

| File | Purpose |
|------|---------|
| `RemoteConfigHelper.kt` | Fetches live config from Firebase |
| `DataUtil.kt` | Stores RBX coin balance |
| `WebAdActivity.kt` | In-app browser for ads |
| `LuckySpinScreen.kt` | Spin & win feature |

---

## ⚠ Disclaimer

This app is a fan-made utility and is **not affiliated with Roblox Corporation**.

---

## ⭐ Support

If you like this project, consider giving it a ⭐ on GitHub!
