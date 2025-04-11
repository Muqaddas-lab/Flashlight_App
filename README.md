# Flashlight App 🔦

This is a simple Android Flashlight app built using **Java** and **Camera2 API**. It allows users to toggle the flashlight (torch) of their device with a single button press.

## 📱 Features

- Turn flashlight ON/OFF
- Simple user interface
- Runtime permission handling for camera access
- Compatible with most Android devices

## 🛠️ Technologies Used

- Java
- Android Studio
- Camera2 API
- XML Layout

## 🔐 Permissions

This app requires the following permission:
- `CAMERA`: To control the device's flashlight

## 📸 How It Works

- The app checks and requests **CAMERA** permission at runtime.
- Once granted, it uses `CameraManager` and `setTorchMode()` to toggle the flashlight.
- A single button updates its text depending on the flashlight state.

## 📂 Project Structure

app/ └── src/ └── main/ ├── MainActivity.java ├── activity_main.xml ├── AndroidManifest.xml └── res/ └── strings.xml
