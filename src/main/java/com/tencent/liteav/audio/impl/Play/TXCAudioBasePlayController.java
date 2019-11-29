package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import android.os.Environment;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class TXCAudioBasePlayController implements c {
    private static final String TAG = ("AudioCenter:" + TXCAudioBasePlayController.class.getSimpleName());
    private static WeakReference<c> mAudioCoreListener = null;
    protected float mAutoAdjustMaxCache = a.f31118c;
    protected float mAutoAdjustMinCache = a.f31119d;
    protected float mCacheTime = a.f31116a;
    protected Context mContext;
    protected boolean mEnableVolumeLevelCal = false;
    protected boolean mIsAutoAdjustCache = a.f31117b;
    protected boolean mIsHWAcceleration = false;
    protected boolean mIsMute = a.f31120e;
    protected volatile boolean mIsPlaying = false;
    protected boolean mIsRealTimePlay = false;
    protected long mJitterBuffer = 0;
    protected c mListener;
    protected int mSmoothMode = 0;
    protected int mStreamFormat = 0;
    protected String mUserID = null;

    public static native void nativeEnableCoreplayVolumeLevelCal(boolean z);

    public static native int nativeGetCorePlayVolumeLevel();

    public static native byte[] nativeGetMixedTracksData(int i);

    public static native boolean nativeIsTracksEmpty();

    public static native void nativeSetTempPath(String str);

    /* access modifiers changed from: protected */
    public native long nativeCreateJitterBuffer(boolean z, TXCAudioBasePlayController tXCAudioBasePlayController, int i);

    /* access modifiers changed from: protected */
    public native void nativeDestoryJitterBuffer(long j);

    /* access modifiers changed from: protected */
    public native void nativeEnableAutoAdjustCache(long j, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeEnableRealTimePlay(long j, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeEnableVolumeLevelCal(long j, boolean z);

    /* access modifiers changed from: protected */
    public native float nativeGetCacheThreshold(long j);

    /* access modifiers changed from: protected */
    public native TXAudioJitterBufferReportInfo nativeGetLoadingInfo(long j);

    /* access modifiers changed from: protected */
    public native int nativeGetVolumeLevel(long j);

    /* access modifiers changed from: protected */
    public native void nativeSetAutoAdjustMaxCache(long j, float f2);

    /* access modifiers changed from: protected */
    public native void nativeSetAutoAdjustMinCache(long j, float f2);

    /* access modifiers changed from: protected */
    public native void nativeSetCacheTime(long j, float f2);

    /* access modifiers changed from: protected */
    public native void nativeSetJitterCycle(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetLoadingThreshold(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetMute(long j, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeSetRTCPlayHungryTimeThreshold(long j, int i);

    /* access modifiers changed from: protected */
    public native void nativeSetRealtimeJitterCycle(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetSmoothAdjust(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetSmoothMode(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetSmoothSpeed(long j, float f2);

    /* access modifiers changed from: protected */
    public native void nativeSetUserID(long j, String str);

    static {
        nativeSetTempPath(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public TXCAudioBasePlayController(Context context) {
        this.mContext = context;
    }

    public static void setAudioMode(Context context, int i) {
        b.a(context, i);
        c.a(context, i);
    }

    public static void setAudioCorePlayListener(c cVar) {
        mAudioCoreListener = new WeakReference<>(cVar);
    }

    public static void onCorePlayPcmData(byte[] bArr, long j, int i, int i2) {
        WeakReference<c> weakReference = mAudioCoreListener;
        if (weakReference != null) {
            c cVar = (c) weakReference.get();
            if (cVar != null) {
                cVar.onPlayPcmData(bArr, j, i, i2);
            }
        }
    }

    public synchronized void setListener(c cVar) {
        this.mListener = cVar;
    }

    public void setCacheTime(float f2) {
        String str = TAG;
        TXCLog.i(str, "set cache time to " + f2);
        nativeSetCacheTime(this.mJitterBuffer, f2);
        this.mCacheTime = f2;
    }

    public void enableAutojustCache(boolean z) {
        String str = TAG;
        TXCLog.i(str, "set auto adjust cache to " + z);
        nativeEnableAutoAdjustCache(this.mJitterBuffer, z);
        this.mIsAutoAdjustCache = z;
    }

    public void setAutoAdjustMaxCache(float f2) {
        String str = TAG;
        TXCLog.i(str, "set auto adjust max cache to " + f2);
        nativeSetAutoAdjustMaxCache(this.mJitterBuffer, f2);
        this.mAutoAdjustMaxCache = f2;
    }

    public void setAutoAdjustMinCache(float f2) {
        String str = TAG;
        TXCLog.i(str, "set auto adjust min cache to " + f2);
        nativeSetAutoAdjustMinCache(this.mJitterBuffer, f2);
        this.mAutoAdjustMinCache = f2;
    }

    public void enableHWAcceleration(boolean z) {
        String str = TAG;
        TXCLog.i(str, "set hw acceleration to " + z);
        this.mIsHWAcceleration = z;
    }

    public void setSmootheMode(int i) {
        String str = TAG;
        TXCLog.i(str, "set careful mode to " + i);
        this.mSmoothMode = i;
    }

    public void enableRealTimePlay(boolean z) {
        if (z != this.mIsRealTimePlay) {
            String str = TAG;
            TXCLog.i(str, "set real-time play to " + z);
            nativeEnableRealTimePlay(this.mJitterBuffer, z);
            this.mIsRealTimePlay = z;
        }
    }

    public void setUserID(String str) {
        this.mUserID = str;
        String str2 = this.mUserID;
        if (str2 != null) {
            nativeSetUserID(this.mJitterBuffer, str2);
        }
    }

    public void setEnableVolumeLevelCal(boolean z) {
        this.mEnableVolumeLevelCal = z;
        nativeEnableVolumeLevelCal(this.mJitterBuffer, z);
    }

    public int getVolumeLevel() {
        if (this.mEnableVolumeLevelCal) {
            return nativeGetVolumeLevel(this.mJitterBuffer);
        }
        return 0;
    }

    public TXAudioJitterBufferReportInfo getReportInfo() {
        if (!this.mIsPlaying) {
            return null;
        }
        long j = this.mJitterBuffer;
        if (j != 0) {
            return nativeGetLoadingInfo(j);
        }
        return null;
    }

    public float getCacheThreshold() {
        return nativeGetCacheThreshold(this.mJitterBuffer);
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public int startPlay() {
        this.mIsPlaying = true;
        return 0;
    }

    public int setStreamFormat(int i) {
        if (i == this.mStreamFormat) {
            return TXEAudioDef.TXE_AUDIO_PLAY_ERR_REPEAT_OPTION;
        }
        this.mStreamFormat = i;
        if (this.mJitterBuffer == 0) {
            this.mJitterBuffer = nativeCreateJitterBuffer(false, this, this.mStreamFormat);
            long j = this.mJitterBuffer;
            if (j != 0) {
                nativeSetSmoothMode(j, (long) this.mSmoothMode);
                nativeSetSmoothAdjust(this.mJitterBuffer, b.a().a("Audio", "SmoothAdjust"));
                nativeSetCacheTime(this.mJitterBuffer, this.mCacheTime);
                nativeSetMute(this.mJitterBuffer, this.mIsMute);
                nativeEnableRealTimePlay(this.mJitterBuffer, this.mIsRealTimePlay);
                nativeEnableAutoAdjustCache(this.mJitterBuffer, this.mIsAutoAdjustCache);
                nativeSetAutoAdjustMaxCache(this.mJitterBuffer, this.mAutoAdjustMaxCache);
                nativeSetAutoAdjustMinCache(this.mJitterBuffer, this.mAutoAdjustMinCache);
                nativeEnableVolumeLevelCal(this.mJitterBuffer, this.mEnableVolumeLevelCal);
                setUserID(this.mUserID);
                nativeSetSmoothSpeed(this.mJitterBuffer, b.a().b("Audio", "SmoothSpeed"));
                nativeSetJitterCycle(this.mJitterBuffer, b.a().a("Audio", "LIVE_JitterCycle"));
                nativeSetRealtimeJitterCycle(this.mJitterBuffer, b.a().a("Audio", "RTC_JitterCycle"));
                nativeSetLoadingThreshold(this.mJitterBuffer, b.a().a("Audio", "LoadingThreshold"));
                nativeSetRTCPlayHungryTimeThreshold(this.mJitterBuffer, (int) b.a().a("Audio", "RtcPlayHungryTimeThreshold"));
            } else {
                TXCLog.e(TAG, "soft dec, create jitterbuffer failed!!");
            }
            String str = TAG;
            TXCLog.e(str, "soft dec, create jitterbuffer with id " + this.mJitterBuffer);
        }
        return 0;
    }

    public int stopPlay() {
        this.mIsPlaying = false;
        this.mCacheTime = a.f31116a;
        this.mIsAutoAdjustCache = a.f31117b;
        this.mAutoAdjustMaxCache = a.f31118c;
        this.mAutoAdjustMinCache = a.f31119d;
        this.mIsRealTimePlay = false;
        this.mIsHWAcceleration = false;
        this.mIsMute = a.f31120e;
        this.mSmoothMode = 0;
        return 0;
    }

    public void setMute(boolean z) {
        if (z != this.mIsMute) {
            nativeSetMute(this.mJitterBuffer, z);
        }
        String str = TAG;
        TXCLog.i(str, "set mute to " + z);
        this.mIsMute = z;
    }

    public void onPlayPcmData(byte[] bArr, long j, int i, int i2) {
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.onPlayPcmData(bArr, j, i, i2);
        }
    }

    public synchronized void onPlayError(int i, String str) {
        if (this.mListener != null) {
            this.mListener.onPlayError(i, str);
        }
    }

    public synchronized void onPlayJitterStateNotify(int i) {
        String str = TAG;
        TXCLog.e(str, "onPlayJitterStateNotify  cur state " + i);
        if (this.mListener != null) {
            this.mListener.onPlayJitterStateNotify(i);
        }
    }
}
