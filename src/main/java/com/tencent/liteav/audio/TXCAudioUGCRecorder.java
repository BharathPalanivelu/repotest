package com.tencent.liteav.audio;

import android.content.Context;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.f;
import com.tencent.liteav.audio.impl.Record.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class TXCAudioUGCRecorder implements h {
    private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
    static TXCAudioUGCRecorder instance = new TXCAudioUGCRecorder();
    protected int mAECType = 0;
    private a mBGMRecorder = null;
    protected int mBits = 16;
    protected int mChannels = 1;
    protected Context mContext;
    private boolean mCurBGMRecordFlag = false;
    private long mEffectorObj = 0;
    private boolean mEnableBGMRecord = false;
    protected boolean mIsEarphoneOn = false;
    protected boolean mIsMute = false;
    private boolean mIsPause = false;
    private long mLastPTS = 0;
    protected int mReverbType = 0;
    protected int mSampleRate = 48000;
    private float mSpeedRate = 1.0f;
    private int mVoiceEnvironment = -1;
    private int mVoiceKind = -1;
    private float mVolume = 1.0f;
    private WeakReference<d> mWeakRecordListener;

    private native void nativeClearCache(long j);

    private native long nativeCreateEffector(int i, int i2, int i3);

    private native void nativeDestroyEffector(long j);

    private native void nativeEnableEncoder(long j, boolean z);

    private native long nativeGetPcmCacheLen(long j);

    private native void nativeMixBGM(long j, boolean z);

    private native void nativeProcess(long j, byte[] bArr, int i);

    private native byte[] nativeReadOneFrame(long j);

    private native void nativeSetChangerType(long j, int i, int i2);

    private native void nativeSetReverbType(long j, int i);

    private native void nativeSetSpeedRate(long j, float f2);

    private native void nativeSetVolume(long j, float f2);

    public void sendCustomPCMData(byte[] bArr) {
    }

    static {
        b.f();
    }

    public static TXCAudioUGCRecorder getInstance() {
        return instance;
    }

    private TXCAudioUGCRecorder() {
    }

    public int startRecord(Context context) {
        TXCLog.i(TAG, "startRecord");
        if (isRecording()) {
            if (this.mEnableBGMRecord == this.mCurBGMRecordFlag) {
                TXCLog.e(TAG, "startRecord failed! recorder is still running!");
                return -1;
            }
            TXCLog.e(TAG, "recorder is still running. will restart record! bgm record flag = " + this.mEnableBGMRecord);
            stopRecord();
            enableBGMRecord(this.mCurBGMRecordFlag ^ true);
        }
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        initEffector();
        if (this.mEnableBGMRecord) {
            TXCLog.i(TAG, "录制BGM");
            this.mCurBGMRecordFlag = true;
            this.mBGMRecorder = new a();
            this.mBGMRecorder.a(this);
            setEarphoneOn(true);
            this.mBGMRecorder.a(this.mContext, this.mSampleRate, this.mChannels, this.mBits);
        } else {
            TXCLog.i(TAG, "录制人声");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            f.a().a(this);
            f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
        return 0;
    }

    public int stopRecord() {
        TXCLog.i(TAG, "stopRecord");
        a aVar = this.mBGMRecorder;
        if (aVar != null) {
            aVar.a();
            this.mBGMRecorder = null;
        }
        f.a().b();
        enableBGMRecord(false);
        this.mIsPause = false;
        uninitEffector();
        return 0;
    }

    public void pause() {
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        if (!this.mEnableBGMRecord && isRecording()) {
            TXCLog.i(TAG, "停止系统录音");
            f.a().b();
        }
    }

    public void resume() {
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        if (!this.mEnableBGMRecord && !isRecording()) {
            TXCLog.i(TAG, "恢复系统录音");
            this.mCurBGMRecordFlag = false;
            setEarphoneOn(false);
            f.a().a(this);
            f.a().a(this.mContext, this.mSampleRate, this.mChannels, this.mBits, this.mAECType);
        }
    }

    public synchronized void setListener(d dVar) {
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

    public void setChannels(int i) {
        TXCLog.i(TAG, "setChannels: " + i);
        this.mChannels = i;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public void setSampleRate(int i) {
        TXCLog.i(TAG, "setSampleRate: " + i);
        this.mSampleRate = i;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public synchronized void setReverbType(int i) {
        TXCLog.i(TAG, "setReverbType: " + i);
        this.mReverbType = i;
        if (this.mEffectorObj > 0) {
            nativeSetReverbType(this.mEffectorObj, i);
        }
    }

    public void setAECType(int i, Context context) {
        TXCLog.i(TAG, "setAECType: " + i);
        this.mAECType = i;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }

    public void setMute(boolean z) {
        TXCLog.i(TAG, "setMute: " + z);
        this.mIsMute = z;
    }

    public void enableBGMRecord(boolean z) {
        TXCLog.i(TAG, "enableBGMRecord: " + z);
        this.mEnableBGMRecord = z;
    }

    public synchronized void setEarphoneOn(boolean z) {
        TXCLog.i(TAG, "setEarphoneOn: " + z);
        this.mIsEarphoneOn = z;
        if (this.mEffectorObj > 0) {
            boolean z2 = false;
            if (z || this.mAECType == 1) {
                z2 = true;
            }
            nativeMixBGM(this.mEffectorObj, z2);
        }
    }

    public boolean isRecording() {
        a aVar = this.mBGMRecorder;
        if (aVar != null) {
            return aVar.b();
        }
        return f.a().c();
    }

    public synchronized long getPcmCacheLen() {
        if (this.mEffectorObj <= 0) {
            return 0;
        }
        return nativeGetPcmCacheLen(this.mEffectorObj);
    }

    public synchronized void setVolume(float f2) {
        TXCLog.i(TAG, "setVolume: " + f2);
        this.mVolume = f2;
        if (this.mEffectorObj > 0) {
            nativeSetVolume(this.mEffectorObj, f2);
        }
    }

    public synchronized void setSpeedRate(float f2) {
        TXCLog.i(TAG, "setSpeedRate: " + f2);
        this.mSpeedRate = f2;
        if (this.mEffectorObj > 0) {
            nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
        }
    }

    public synchronized void clearCache() {
        TXCLog.i(TAG, "clearCache");
        if (this.mEffectorObj > 0) {
            nativeClearCache(this.mEffectorObj);
        }
    }

    public void onAudioRecordStart() {
        TXCLog.i(TAG, "sys audio record start");
    }

    public void onAudioRecordStop() {
        TXCLog.i(TAG, "sys audio record stop");
        f.a().a((h) null);
    }

    public void onAudioRecordError(int i, String str) {
        TXCLog.e(TAG, "sys audio record error: " + i + ", " + str);
        f.a().a((h) null);
        d listener = getListener();
        if (listener != null) {
            listener.a(i, str);
        }
    }

    public void onAudioRecordPCM(byte[] bArr, int i, long j) {
        byte[] nativeReadOneFrame;
        if (!this.mIsPause) {
            if (this.mEffectorObj > 0) {
                if (this.mIsMute) {
                    Arrays.fill(bArr, (byte) 0);
                }
                long j2 = this.mLastPTS;
                if (j2 >= j) {
                    j = 2 + j2;
                }
                synchronized (this) {
                    nativeProcess(this.mEffectorObj, bArr, i);
                }
                do {
                    synchronized (this) {
                        nativeReadOneFrame = nativeReadOneFrame(this.mEffectorObj);
                    }
                    if (nativeReadOneFrame != null) {
                        this.mLastPTS = j;
                        d listener = getListener();
                        if (listener != null) {
                            listener.b(nativeReadOneFrame, j, this.mSampleRate, this.mChannels, this.mBits);
                        }
                    }
                    synchronized (this) {
                        j += (long) ((1024000.0f / ((float) this.mSampleRate)) * this.mSpeedRate);
                    }
                } while (nativeReadOneFrame != null);
                return;
            }
            TXCLog.e(TAG, "effectorObj is null");
        }
    }

    private synchronized void initEffector() {
        uninitEffector();
        this.mEffectorObj = nativeCreateEffector(this.mSampleRate, this.mChannels, this.mBits);
        boolean z = false;
        if (this.mIsEarphoneOn || this.mAECType == 1) {
            z = true;
        }
        nativeSetReverbType(this.mEffectorObj, this.mReverbType);
        nativeSetChangerType(this.mEffectorObj, this.mVoiceKind, this.mVoiceEnvironment);
        nativeMixBGM(this.mEffectorObj, z);
        nativeSetVolume(this.mEffectorObj, this.mVolume);
        nativeSetSpeedRate(this.mEffectorObj, this.mSpeedRate);
        nativeEnableEncoder(this.mEffectorObj, true);
        this.mLastPTS = 0;
    }

    private synchronized void uninitEffector() {
        if (this.mEffectorObj > 0) {
            nativeDestroyEffector(this.mEffectorObj);
            this.mEffectorObj = 0;
        }
    }

    public synchronized void setChangerType(int i, int i2) {
        TXCLog.i(TAG, "setChangerType: " + i + SQLBuilder.BLANK + i2);
        this.mVoiceKind = i;
        this.mVoiceEnvironment = i2;
        if (this.mEffectorObj > 0) {
            nativeSetChangerType(this.mEffectorObj, i, i2);
        }
    }
}
