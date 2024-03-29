#
# Copyright (C) 2021 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit from J607F device
$(call inherit-product, device/lenovo/J607F/device.mk)

# Inherit some common KaleidoscopeOS stuff.
$(call inherit-product, vendor/kscope/target/product/tablet_no_telephony.mk)

# Switch to Lawnchair
$(call inherit-product, vendor/lawnchair/lawnchair.mk)

DEVICE_MAINTAINER := bigsaltyfishes

# Enable Face Unlock
TARGET_FACE_UNLOCK_SUPPORTED := true

# AOSP Wallpaper Picker
PRODUCT_PACKAGES += \
	WallpaperPicker

# Device identifier. This must come after all inclusions.
PRODUCT_NAME := kscope_J607F
PRODUCT_DEVICE := J607F
PRODUCT_BRAND := Lenovo
PRODUCT_MODEL := Lenovo TB-J607F
PRODUCT_MANUFACTURER := LENOVO

PRODUCT_GMS_CLIENTID_BASE := android-lenovo

BUILD_FINGERPRINT := Lenovo/LenovoTB-J607F_PRC/J607F:11/RKQ1.201217.002/13.0.234_220111:user/release-keys
