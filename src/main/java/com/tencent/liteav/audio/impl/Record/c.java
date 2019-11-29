package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import java.lang.ref.WeakReference;

public abstract class c {
    private static final String TAG = ("AudioCenter:" + c.class.getSimpleName());
    protected int mAECType = 0;
    protected int mAudioFormat = 10;
    protected int mBits = 16;
    protected int mChannels = 1;
    protected Context mContext;
    protected boolean mEnableHWEncoder = false;
    protected boolean mEnableVolumeLevel = false;
    protected float mFecRatio = BitmapDescriptorFactory.HUE_RED;
    protected int mFrameLenMs = 21;
    protected String mID;
    protected boolean mIsCustomRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    protected int mNSMode = -1;
    protected int mReverbType = 0;
    protected int mSampleRate = 48000;
    protected int mSamplesNumPerFrame = 1024;
    protected int mVoiceEnvironment = -1;
    protected int mVoiceKind = -1;
    protected float mVolume = 1.0f;
    protected WeakReference<d> mWeakRecordListener;

    public int getVolumeLevel() {
        return 0;
    }

    public abstract boolean isRecording();

    public abstract void sendCustomPCMData(a aVar);

    public abstract void sendCustomPCMData(byte[] bArr);

    public void setEncBitRate(int i) {
    }

    public void setReverbParam(int i, float f2) {
    }

    public abstract int stopRecord();

    public void SetID(String str) {
        this.mID = str;
    }

    public synchronized void setListener(d dVar) {
        String str = TAG;
        TXCLog.i(str, "setListener:" + dVar);
        if (dVar == null) {
            this.mWeakRecordListener = null;
        } else {
            this.mWeakRecordListener = new WeakReference<>(dVar);
        }
    }

    public synchronized d getListener() {
        if (this.mWeakRecordListener == null) {
            return null;
        }
        return (d) this.mWeakRecordListener.get();
    }

    public void setSamplerate(int i) {
        String str = TAG;
        TXCLog.i(str, "setSampleRate: " + i);
        this.mSampleRate = i;
    }

    public void setChannels(int i) {
        String str = TAG;
        TXCLog.i(str, "setChannels: " + i);
        this.mChannels = i;
    }

    public void setReverbType(int i) {
        String str = TAG;
        TXCLog.i(str, "setReverbType: " + i);
        this.mReverbType = i;
    }

    public void setAECType(int i) {
        String str = TAG;
        TXCLog.i(str, "setAECType: " + i);
        this.mAECType = i;
    }

    public void enableHWEncoder(boolean z) {
        String str = TAG;
        TXCLog.i(str, "enableHWEncoder: " + z);
        this.mEnableHWEncoder = z;
    }

    public void setMute(boolean z) {
        String str = TAG;
        TXCLog.i(str, "setMute: " + z);
        this.mIsMute = z;
    }

    public void setVolume(float f2) {
        if (f2 <= 0.2f) {
            String str = TAG;
            TXCLog.w(str, "setVolume, warning volume too low : " + f2);
        }
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        this.mVolume = f2;
    }

    public void setEarphoneOn(boolean z) {
        String str = TAG;
        TXCLog.i(str, "setEarphoneOn: " + z);
        this.mIsEarphoneOn = z;
    }

    public void setNoiseSuppression(int i) {
        String str = TAG;
        TXCLog.i(str, "setNoiseSuppression: " + i);
        this.mNSMode = i;
    }

    public void setChangerType(int i, int i2) {
        String str = TAG;
        TXCLog.i(str, "setChangerType: " + i + SQLBuilder.BLANK + i2);
        this.mVoiceKind = i;
        this.mVoiceEnvironment = i2;
    }

    public void setAudioFormat(int i) {
        String str = TAG;
        TXCLog.i(str, "setAudioFormat : " + i);
        if (!isRecording()) {
            this.mAudioFormat = i;
            int i2 = this.mAudioFormat;
            if (10 == i2) {
                this.mSamplesNumPerFrame = 1024;
            } else if (11 == i2) {
                this.mSamplesNumPerFrame = TXEAudioDef.TXE_OPUS_SAMPLE_NUM;
            }
        }
    }

    public void setFecRatio(float f2) {
        this.mFecRatio = f2;
    }

    public void setEnableVolumeLevel(boolean z) {
        this.mEnableVolumeLevel = z;
    }

    public int startRecord(Context context) {
        if (context == null) {
            return 0;
        }
        this.mContext = context.getApplicationContext();
        return 0;
    }

    public void setIsCustomRecord(boolean z) {
        String str = TAG;
        TXCLog.i(str, "setIsCustomRecord: " + z);
        this.mIsCustomRecord = z;
    }

    public void setEncFrameLenMs(int i) {
        String str = TAG;
        TXCLog.i(str, "setEncFrameLenMs: " + i);
        this.mFrameLenMs = i;
    }

    public void setEncInfo(int i, int i2) {
        this.mFrameLenMs = i;
    }
}
