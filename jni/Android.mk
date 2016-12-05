
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := daems
LOCAL_SRC_FILES := daems.cpp
include $(BUILD_SHARED_LIBRARY)

