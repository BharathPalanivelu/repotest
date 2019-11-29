package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import java.lang.ref.WeakReference;

public class g extends c {
    public void sendCustomPCMData(a aVar) {
    }

    public void sendCustomPCMData(byte[] bArr) {
    }

    public int startRecord(Context context) {
        TXCLog.i("AudioCenter:TXCAudioTraeRecordController", "trae startRecord");
        super.startRecord(context);
        TXCTraeJNI.InitTraeEngineLibrary(this.mContext);
        TXCTraeJNI.setTraeRecordListener(this.mWeakRecordListener);
        TXCTraeJNI.nativeTraeStartRecord(context, this.mSampleRate, this.mChannels, this.mBits, this.mAudioFormat, this.mFrameLenMs);
        TXCTraeJNI.nativeTraeSetChangerType(this.mVoiceKind, this.mVoiceEnvironment);
        if (!(this.mWeakRecordListener == null || this.mWeakRecordListener.get() == null)) {
            ((d) this.mWeakRecordListener.get()).a(1, "TRAE-AEC,采样率(" + this.mSampleRate + "|" + this.mSampleRate + "),声道数" + this.mChannels);
        }
        if (this.mAudioFormat != 11) {
            return 0;
        }
        TXCTraeJNI.nativeSetFecRatio(this.mFecRatio);
        return 0;
    }

    public void SetID(String str) {
        super.SetID(str);
    }

    public int stopRecord() {
        TXCLog.i("AudioCenter:TXCAudioTraeRecordController", "trae stopRecord");
        TXCTraeJNI.nativeTraeStopRecord(true);
        TXCTraeJNI.setTraeRecordListener((WeakReference<d>) null);
        this.mFecRatio = BitmapDescriptorFactory.HUE_RED;
        return 0;
    }

    public boolean isRecording() {
        return TXCTraeJNI.nativeTraeIsRecording();
    }

    public void setReverbType(int i) {
        super.setReverbType(i);
        TXCTraeJNI.nativeTraeSetRecordReverb(i);
    }

    public void setChangerType(int i, int i2) {
        super.setChangerType(i, i2);
        TXCTraeJNI.nativeTraeSetChangerType(i, i2);
    }

    public void setVolume(float f2) {
        super.setVolume(f2);
        TXCTraeJNI.nativeTraeSetVolume(f2);
    }

    public void setMute(boolean z) {
        super.setMute(z);
        TXCTraeJNI.nativeTraeSetRecordMute(z);
        this.mIsMute = z;
    }

    public void setEncBitRate(int i) {
        super.setEncBitRate(i);
        TXCTraeJNI.nativeSetEncBitRate(i);
    }

    public void setEncFrameLenMs(int i) {
        super.setEncFrameLenMs(i);
        TXCTraeJNI.nativeSetEncFrameLenMs(i);
    }

    public void setEncInfo(int i, int i2) {
        super.setEncInfo(i, i2);
        TXCTraeJNI.nativeSetEncInfo(i, i2);
    }

    public void setFecRatio(float f2) {
        super.setFecRatio(f2);
        TXCTraeJNI.nativeSetFecRatio(this.mFecRatio);
    }

    public void setEnableVolumeLevel(boolean z) {
        super.setEnableVolumeLevel(z);
        TXCTraeJNI.nativeTraeSetEnableVolumeLevel(z);
    }

    public int getVolumeLevel() {
        if (this.mEnableVolumeLevel) {
            return TXCTraeJNI.nativeTraeGetVolumeLevel();
        }
        return 0;
    }
}
