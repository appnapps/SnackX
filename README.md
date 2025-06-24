# SnackX 🍩

A beautiful customizable toast alternative for Android apps.

## ✨ Features

- Easy to use static `show()` method
- Top or bottom positioning
- Optional icons
- Auto dismiss with animation
- Custom background and text colors

## 🚀 Usage

```kotlin
SnackX.show(
    context = this,
    message = "Action completed!",
    iconResId = R.drawable.ic_check,
    duration = 2500,
    position = SnackX.Position.TOP
)

