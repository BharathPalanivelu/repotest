package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.impl.a;
import com.tencent.liteav.audio.impl.d;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.ugc.TXRecordCommon;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioSysRecordController extends c implements h, d {
    private static final String TAG = ("AudioCenter:" + TXCAudioSysRecordController.class.getSimpleName());
    private byte[] mBuf = null;
    private d mCustomRecord = null;
    private long mEffectorObj = 0;
    private e mHWEcoder = null;
    private long mLastPTS = 0;
    private boolean mNeedMix = false;
    private int mPosition = 0;
    private int mRecordSampleRate = 48000;
    private long mSoftEncObj = 0;
    private long mTimestampInSamples = 0;

    private native void nativeAddEffect(long j, byte[] bArr);

    private native void nativeAddEffectAndSoftEnc(long j, long j2, byte[] bArr, long j3);

    private native long nativeCreateEffector(int i, int i2, int i3);

    private native long nativeCreateSoftEncoder(int i, int i2, int i3, int i4, int i5);

    private native void nativeDestorySoftEncoder(long j);

    private native void nativeDestroyEffector(long j);

    private native void nativeEnableEncoder(long j, boolean z);

    private native void nativeEnableVolumeLevel(long j, boolean z);

    private native int nativeGetVolumeLevel(long j);

    private native void nativeMixBGM(long j, boolean z);

    private native byte[] nativeReadOneFrame(long j, int i);

    private native void nativeSetChangerType(long j, int i, int i2);

    private native void nativeSetEncBitRate(long j, int i);

    private native void nativeSetEncFrameLenMs(long j, int i);

    private native void nativeSetEncInfo(long j, int i, int i2);

    private native void nativeSetFecRatio(long j, float f2);

    private native void nativeSetID(long j, String str);

    private native void nativeSetInputInfo(long j, int i, int i2, int i3);

    private native void nativeSetReverbParam(long j, int i, float f2);

    private native void nativeSetReverbType(long j, int i);

    private native void nativeSetVolume(long j, float f2);

    static {
        b.f();
    }

    public TXCAudioSysRecordController() {
        a.a().a((d) this);
    }

    public void SetID(String str) {
        super.SetID(str);
        nativeSetID(this.mSoftEncObj, this.mID);
    }

    public int startRecord(Context context) {
        TXCLog.i(TAG, "startRecord");
        super.startRecord(context);
        if (!this.mIsCustomRecord) {
            if (this.mAECType == 1) {
                if (this.mSampleRate > com.tencent.liteav.basic.e.b.a().h()) {
                    this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().i();
                } else {
                    this.mRecordSampleRate = com.tencent.liteav.basic.e.b.a().h();
                }
                if (this.mRecordSampleRate == 0) {
                    this.mRecordSampleRate = TXRecordCommon.AUDIO_SAMPLERATE_16000;
                }
            } else {
                this.mRecordSampleRate = this.mSampleRate;
            }
            f.a().a(this);
            f.a().a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits, this.mAECType);
        } else {
            setNoiseSuppression(-1);
            this.mRecordSampleRate = this.mSampleRate;
            this.mCustomRecord = new d();
            this.mCustomRecord.a(this);
            this.mCustomRecord.a(this.mContext, this.mRecordSampleRate, this.mChannels, this.mBits);
        }
        if (this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null) {
            return 0;
        }
        String str = this.mAECType == 1 ? "SYSTEM-AEC," : "NO-AEC,";
        ((com.tencent.liteav.audio.d) this.mWeakRecordListener.get()).a(1, str + "采样率(" + this.mRecordSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        return 0;
    }

    private String getProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, "unknown"});
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public int stopRecord() {
        TXCLog.i(TAG, "stopRecord");
        d dVar = this.mCustomRecord;
        if (dVar != null) {
            dVar.c();
            this.mCustomRecord = null;
        }
        f.a().b();
        a.a().b((d) this);
        this.mNeedMix = false;
        this.mTimestampInSamples = 0;
        return 0;
    }

    public void sendCustomPCMData(byte[] bArr) {
        d dVar = this.mCustomRecord;
        if (dVar != null) {
            dVar.a(bArr);
        }
    }

    public void sendCustomPCMData(com.tencent.liteav.basic.structs.a aVar) {
        d dVar = this.mCustomRecord;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public boolean isRecording() {
        d dVar = this.mCustomRecord;
        if (dVar != null) {
            return dVar.d();
        }
        return f.a().c();
    }

    public synchronized void setEarphoneOn(boolean z) {
        super.setEarphoneOn(z);
        if (this.mEffectorObj > 0) {
            if (!z) {
                if (this.mAECType != 1) {
                    this.mNeedMix = false;
                    nativeMixBGM(this.mEffectorObj, this.mNeedMix);
                }
            }
            this.mNeedMix = true;
            nativeMixBGM(this.mEffectorObj, this.mNeedMix);
        }
    }

    public synchronized void setReverbType(int i) {
        super.setReverbType(i);
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
    }

    public void setVolume(float f2) {
        super.setVolume(f2);
        long j = this.mEffectorObj;
        if (j != 0) {
            nativeSetVolume(j, f2);
        }
    }

    public synchronized void setReverbParam(int i, float f2) {
        super.setReverbParam(i, f2);
        if (this.mEffectorObj != 0) {
            nativeSetReverbParam(this.mEffectorObj, i, f2);
        }
    }

    public void setChangerType(int i, int i2) {
        super.setChangerType(i, i2);
        long j = this.mEffectorObj;
        if (j != 0) {
            nativeSetChangerType(j, i, i2);
        }
    }

    public void setEncBitRate(int i) {
        super.setEncBitRate(i);
        long j = this.mSoftEncObj;
        if (j != 0) {
            nativeSetEncBitRate(j, i);
        }
    }

    public void setEncFrameLenMs(int i) {
        super.setEncFrameLenMs(i);
        long j = this.mSoftEncObj;
        if (j != 0) {
            nativeSetEncFrameLenMs(j, i);
        }
    }

    public void setEncInfo(int i, int i2) {
        super.setEncInfo(i, i2);
        long j = this.mSoftEncObj;
        if (j != 0) {
            nativeSetEncInfo(j, i, i2);
        }
    }

    public void setFecRatio(float f2) {
        super.setFecRatio(f2);
        long j = this.mSoftEncObj;
        if (j != 0) {
            nativeSetFecRatio(j, this.mFecRatio);
        }
    }

    public void setEnableVolumeLevel(boolean z) {
        super.setEnableVolumeLevel(z);
        long j = this.mEffectorObj;
        if (j != 0) {
            nativeEnableVolumeLevel(j, z);
        }
    }

    public int getVolumeLevel() {
        if (this.mEffectorObj == 0 || !this.mEnableVolumeLevel) {
            return 0;
        }
        return nativeGetVolumeLevel(this.mEffectorObj);
    }

    public synchronized void onAudioRecordStart() {
        TXCLog.i(TAG, "sys audio record start");
        uninitEffectAndEnc();
        initEffectAndEnc();
    }

    public synchronized void onAudioRecordStop() {
        TXCLog.i(TAG, "sys audio record stop");
        f.a().a((h) null);
        uninitEffectAndEnc();
        this.mFecRatio = BitmapDescriptorFactory.HUE_RED;
    }

    public synchronized void onAudioRecordError(int i, String str) {
        String str2 = TAG;
        TXCLog.e(str2, "sys audio record error: " + i + ", " + str);
        f.a().a((h) null);
        uninitEffectAndEnc();
        if (this.mWeakRecordListener != null) {
            com.tencent.liteav.audio.d dVar = (com.tencent.liteav.audio.d) this.mWeakRecordListener.get();
            if (dVar != null) {
                dVar.a(i, str);
            }
        }
    }

    public synchronized void onAudioRecordPCM(byte[] bArr, int i, long j) {
        byte[] nativeReadOneFrame;
        if (this.mEffectorObj > 0) {
            if (this.mIsMute) {
                Arrays.fill(bArr, (byte) 0);
            }
            if (this.mHWEcoder != null) {
                long j2 = this.mLastPTS >= j ? this.mLastPTS + 2 : j;
                nativeAddEffect(this.mEffectorObj, bArr);
                do {
                    nativeReadOneFrame = nativeReadOneFrame(this.mEffectorObj, ((this.mSamplesNumPerFrame * this.mChannels) * this.mBits) / 8);
                    if (nativeReadOneFrame != null) {
                        this.mLastPTS = j2;
                        if (this.mHWEcoder != null) {
                            doHWEncode(nativeReadOneFrame, j2);
                        } else {
                            com.tencent.liteav.audio.d listener = getListener();
                            if (listener != null) {
                                listener.b(nativeReadOneFrame, getFixedTimestamp(j2), this.mSampleRate, this.mChannels, this.mBits);
                            }
                        }
                    }
                    j2 += (long) ((this.mSamplesNumPerFrame * 1000) / this.mSampleRate);
                } while (nativeReadOneFrame != null);
            } else {
                nativeAddEffectAndSoftEnc(this.mEffectorObj, this.mSoftEncObj, bArr, j);
            }
        } else {
            TXCLog.e(TAG, "effectorObj is null");
        }
    }

    private long getFixedTimestamp(long j) {
        if (11 != this.mAudioFormat) {
            return j;
        }
        this.mTimestampInSamples += (long) ((this.mFrameLenMs * this.mSampleRate) / 1000);
        return this.mTimestampInSamples;
    }

    private void initEffectAndEnc() {
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        int i = this.mSampleRate;
        int i2 = this.mRecordSampleRate;
        if (i != i2) {
            nativeSetInputInfo(this.mEffectorObj, i2, this.mChannels, this.mBits);
        }
        boolean z = true;
        if (!this.mIsEarphoneOn && this.mAECType != 1) {
            z = false;
        }
        nativeEnableVolumeLevel(this.mEffectorObj, this.mEnableVolumeLevel);
        nativeSetReverbType(this.mEffectorObj, this.mReverbType);
        nativeMixBGM(this.mEffectorObj, z);
        nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
        if (this.mEnableHWEncoder) {
            this.mHWEcoder = new e();
            com.tencent.liteav.audio.d listener = getListener();
            this.mHWEcoder.a(this.mAudioFormat, this.mSampleRate, this.mChannels, this.mBits, listener != null ? new WeakReference(listener) : null);
            this.mBuf = new byte[(((this.mSamplesNumPerFrame * this.mChannels) * this.mBits) / 8)];
            this.mPosition = 0;
        } else {
            this.mSoftEncObj = nativeCreateSoftEncoder(this.mSampleRate, this.mChannels, this.mBits, this.mAudioFormat, this.mFrameLenMs);
            nativeSetID(this.mSoftEncObj, this.mID);
            if (this.mAudioFormat == 11) {
                nativeSetFecRatio(this.mSoftEncObj, this.mFecRatio);
            }
        }
        this.mLastPTS = 0;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("初始化直播录制:录制模式 = ");
        sb.append(this.mCustomRecord == null ? "麦克风录制" : "用户自定义录制");
        sb.append(", 录制采样率 = ");
        sb.append(this.mRecordSampleRate);
        sb.append(", 输出采样率 = ");
        sb.append(this.mSampleRate);
        sb.append(", 是否混音 = ");
        sb.append(z);
        sb.append(", 混响模式 = ");
        sb.append(this.mReverbType);
        sb.append(", 是否启动硬编码 = ");
        sb.append(this.mEnableHWEncoder);
        sb.append(", 噪声抑制mode = ");
        sb.append(this.mNSMode);
        TXCLog.i(str, sb.toString());
    }

    private void uninitEffectAndEnc() {
        long j = this.mEffectorObj;
        if (j != 0) {
            nativeDestroyEffector(j);
            this.mEffectorObj = 0;
        }
        long j2 = this.mSoftEncObj;
        if (j2 != 0) {
            nativeDestorySoftEncoder(j2);
            this.mSoftEncObj = 0;
        }
        e eVar = this.mHWEcoder;
        if (eVar != null) {
            eVar.a();
            this.mHWEcoder = null;
        }
    }

    private void doHWEncode(byte[] bArr, long j) {
        if (!(bArr == null || bArr.length == 0)) {
            byte[] bArr2 = this.mBuf;
            if (!(bArr2 == null || this.mHWEcoder == null)) {
                int length = bArr2.length - this.mPosition;
                if (length > bArr.length) {
                    length = bArr.length;
                }
                System.arraycopy(bArr, 0, this.mBuf, this.mPosition, length);
                this.mPosition += length;
                int i = this.mPosition;
                byte[] bArr3 = this.mBuf;
                if (i == bArr3.length) {
                    this.mPosition = 0;
                    this.mHWEcoder.a(bArr3, j);
                    return;
                }
                return;
            }
        }
        TXCLog.e(TAG, "doHWEncode failed! data = " + bArr + ", buf = " + this.mBuf + ", encoder = " + this.mHWEcoder);
    }

    private void onRecordRawPcmData(byte[] bArr, int i, int i2) {
        com.tencent.liteav.audio.d listener = getListener();
        if (listener != null) {
            listener.a(bArr, TXCTimeUtil.getTimeTick(), i, i2, this.mBits, TXCLiveBGMPlayer.getInstance().isRunning() && !this.mNeedMix);
        }
    }

    private void onRecordPcmData(byte[] bArr) {
        com.tencent.liteav.audio.d listener = getListener();
        if (listener != null) {
            listener.a(bArr, TXCTimeUtil.getTimeTick(), this.mSampleRate, this.mChannels, this.mBits);
        }
    }

    public void OnHeadsetState(boolean z) {
        setEarphoneOn(z);
    }
}
