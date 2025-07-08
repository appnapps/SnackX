# SnackX 🍩

A beautiful and customizable toast/snackbar alternative for Android apps.  
SnackX offers top or bottom positioning, icon support, background/text customization, animation styles, and more.

---

## ✨ Features

- ✅ Easy-to-use static `show()` method
- 🎯 Top or bottom positioning
- 🖼 Optional icons
- 🎨 Custom background and text colors
- 🔁 Fade or Slide animation styles
- ⏱ Customizable animation duration
- 🕐 Auto dismiss with timer

---

## 🚀 Usage Example

```kotlin
SnackX.show(
    context = this,
    message = "Action completed!",
    iconResId = R.drawable.ic_check,
    duration = 2500, // visible time in milliseconds
    position = SnackX.Position.TOP,
    backgroundColor = Color.DKGRAY,
    textColor = Color.WHITE,
    animation = SnackX.AnimationStyle.SLIDE, // or FADE
    animationDuration = 600L // appear/disappear animation speed
)



dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

implementation 'com.github.appnapps:SnackX:v1.1.0'
```

## 🎞 Animation Styles

| Style | Description |
|-------|-------------|
| `FADE` | Smooth fade in/out |
| `SLIDE` | Slide from top or bottom |
| `SCALE` | Zoom in from large → normal, then zoom out |  ← ✅ 추가


## 🎆 SnackX Demo


<img src="https://github.com/appnapps/SnackX/docs/SnackX.gif" width="320"/>

