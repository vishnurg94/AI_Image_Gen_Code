# Retain MainActivity to avoid reflection issues
-keep class com.example.text2image.MainActivity { *; }

# Keep all Activities
-keep class * extends android.app.Activity

# Prevent warnings for third-party libraries
-dontwarn okhttp3.**
-dontwarn retrofit2.**
-dontwarn javax.annotation.**

# Obfuscate and optimize aggressively
-optimizationpasses 5
-allowaccessmodification
-overloadaggressively
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
-useuniqueclassmembernames
-printmapping mapping.txt

# Remove unused code and classes
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify