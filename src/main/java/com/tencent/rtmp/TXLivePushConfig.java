package com.tencent.rtmp;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class TXLivePushConfig {
    public static final int DEFAULT_MAX_VIDEO_BITRATE = 1200;
    public static final int DEFAULT_MIN_VIDEO_BITRATE = 800;
    int mAudioBitrate;
    int mAudioChannels = 1;
    String mAudioPreProcessFuncName;
    String mAudioPreProcessLibrary;
    int mAudioSample = 48000;
    boolean mAutoAdjustBitrate = false;
    int mAutoAdjustStrategy = 0;
    int mBeautyLevel = 0;
    int mConnectRetryCount = 3;
    int mConnectRetryInterval = 3;
    int mCustomModeType = 0;
    boolean mEnableAec = false;
    boolean mEnableAudioPreview = false;
    boolean mEnableHighResolutionCapture = true;
    boolean mEnableNearestIP = true;
    boolean mEnablePureAudioPush = false;
    boolean mEnableScreenCaptureAutoRotate = false;
    boolean mEnableVideoHardEncoderMainProfile = true;
    boolean mEnableZoom = false;
    int mEyeScaleLevel = 0;
    int mFaceSlimLevel = 0;
    boolean mFrontCamera = true;
    int mHardwareAccel = 2;
    int mHomeOrientation = 1;
    int mMaxVideoBitrate = 1000;
    int mMinVideoBitrate = 400;
    int mPauseFlag = 1;
    int mPauseFps = 5;
    Bitmap mPauseImg = null;
    int mPauseTime = 300;
    int mRtmpChannelType = 0;
    int mRuddyLevel = 0;
    boolean mTouchFocus = true;
    int mVideoBitrate = DEFAULT_MAX_VIDEO_BITRATE;
    int mVideoEncodeGop = 3;
    boolean mVideoEncoderXMirror = false;
    int mVideoFPS = 20;
    String mVideoPreProcessFuncName;
    String mVideoPreProcessLibrary;
    int mVideoResolution = 1;
    Bitmap mWatermark;
    float mWatermarkWidth = -1.0f;
    int mWatermarkX = 0;
    float mWatermarkXF = BitmapDescriptorFactory.HUE_RED;
    int mWatermarkY = 0;
    float mWatermarkYF = BitmapDescriptorFactory.HUE_RED;
    int mWhiteningLevel = 0;

    public void setHomeOrientation(int i) {
        this.mHomeOrientation = i;
    }

    public void setTouchFocus(boolean z) {
        this.mTouchFocus = z;
    }

    public void setEnableZoom(boolean z) {
        this.mEnableZoom = z;
    }

    public void setWatermark(Bitmap bitmap, int i, int i2) {
        this.mWatermark = bitmap;
        this.mWatermarkX = i;
        this.mWatermarkY = i2;
    }

    public void setWatermark(Bitmap bitmap, float f2, float f3, float f4) {
        this.mWatermark = bitmap;
        this.mWatermarkXF = f2;
        this.mWatermarkYF = f3;
        this.mWatermarkWidth = f4;
    }

    public void setPauseImg(Bitmap bitmap) {
        this.mPauseImg = bitmap;
    }

    public void setPauseImg(int i, int i2) {
        this.mPauseTime = i;
        this.mPauseFps = i2;
    }

    public void setPauseFlag(int i) {
        this.mPauseFlag = i;
    }

    public void setVideoResolution(int i) {
        this.mVideoResolution = i;
    }

    public void setVideoFPS(int i) {
        this.mVideoFPS = i;
    }

    public void setVideoEncodeGop(int i) {
        this.mVideoEncodeGop = i;
    }

    public void setVideoBitrate(int i) {
        this.mVideoBitrate = i;
    }

    public void setMaxVideoBitrate(int i) {
        this.mMaxVideoBitrate = i;
    }

    public void setMinVideoBitrate(int i) {
        this.mMinVideoBitrate = i;
    }

    public void setAutoAdjustBitrate(boolean z) {
        this.mAutoAdjustBitrate = z;
    }

    public void setAutoAdjustStrategy(int i) {
        this.mAutoAdjustStrategy = i;
    }

    public void setAudioSampleRate(int i) {
        this.mAudioSample = i;
    }

    public void setAudioChannels(int i) {
        this.mAudioChannels = i;
    }

    public void enablePureAudioPush(boolean z) {
        this.mEnablePureAudioPush = z;
    }

    public void enableScreenCaptureAutoRotate(boolean z) {
        this.mEnableScreenCaptureAutoRotate = z;
    }

    public void enableHighResolutionCaptureMode(boolean z) {
        this.mEnableHighResolutionCapture = z;
    }

    public void setVideoEncoderXMirror(boolean z) {
        this.mVideoEncoderXMirror = z;
    }

    public void setConnectRetryCount(int i) {
        this.mConnectRetryCount = i;
    }

    public void setConnectRetryInterval(int i) {
        this.mConnectRetryInterval = i;
    }

    public void setCustomModeType(int i) {
        this.mCustomModeType = i;
    }

    public void enableAEC(boolean z) {
        this.mEnableAec = z;
    }

    public void setHardwareAcceleration(int i) {
        if (i < 0) {
            i = 2;
        }
        if (i > 2) {
            i = 2;
        }
        this.mHardwareAccel = i;
    }

    public void enableVideoHardEncoderMainProfile(boolean z) {
        this.mEnableVideoHardEncoderMainProfile = z;
    }

    @Deprecated
    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    @Deprecated
    public void setBeautyFilter(int i, int i2, int i3) {
        this.mBeautyLevel = i;
        this.mWhiteningLevel = i2;
        this.mRuddyLevel = i3;
    }

    @Deprecated
    public void setEyeScaleLevel(int i) {
        this.mEyeScaleLevel = i;
    }

    @Deprecated
    public void setFaceSlimLevel(int i) {
        this.mFaceSlimLevel = i;
    }

    @Deprecated
    public void setRtmpChannelType(int i) {
        this.mRtmpChannelType = i;
    }

    @Deprecated
    public void enableNearestIP(boolean z) {
        this.mEnableNearestIP = z;
    }

    public void setCustomVideoPreProcessLibrary(String str, String str2) {
        this.mVideoPreProcessLibrary = str;
        this.mVideoPreProcessFuncName = str2;
    }

    public void setCustomAudioPreProcessLibrary(String str, String str2) {
        this.mAudioPreProcessLibrary = str;
        this.mAudioPreProcessFuncName = str2;
    }
}
