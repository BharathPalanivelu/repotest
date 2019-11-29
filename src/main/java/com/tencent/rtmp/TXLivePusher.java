package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public class TXLivePusher {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private b mTXTxLivePusherImpl;

    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j, int i, int i2, int i3);

        void onRecordRawPcmData(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    public interface OnBGMNotify {
        void onBGMComplete(int i);

        void onBGMProgress(long j, long j2);

        void onBGMStart();
    }

    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i, int i2, int i3);

        void onTextureDestoryed();
    }

    public TXLivePusher(Context context) {
        this.mTXTxLivePusherImpl = new b(context);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        this.mTXTxLivePusherImpl.a(tXLivePushConfig);
    }

    public TXLivePushConfig getConfig() {
        return this.mTXTxLivePusherImpl.h();
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mTXTxLivePusherImpl.a(iTXLivePushListener);
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        this.mTXTxLivePusherImpl.a(tXCloudVideoView);
    }

    public void stopCameraPreview(boolean z) {
        this.mTXTxLivePusherImpl.b(z);
    }

    public int startPusher(String str) {
        return this.mTXTxLivePusherImpl.a(str);
    }

    public void stopPusher() {
        this.mTXTxLivePusherImpl.i();
    }

    public void startScreenCapture() {
        this.mTXTxLivePusherImpl.m();
    }

    public void stopScreenCapture() {
        this.mTXTxLivePusherImpl.n();
    }

    public void pausePusher() {
        this.mTXTxLivePusherImpl.j();
    }

    public void resumePusher() {
        this.mTXTxLivePusherImpl.k();
    }

    public boolean isPushing() {
        return this.mTXTxLivePusherImpl.l();
    }

    public void setVideoQuality(int i, boolean z, boolean z2) {
        this.mTXTxLivePusherImpl.a(i, z, z2);
    }

    public void switchCamera() {
        this.mTXTxLivePusherImpl.o();
    }

    public boolean setMirror(boolean z) {
        return this.mTXTxLivePusherImpl.c(z);
    }

    public void setRenderRotation(int i) {
        this.mTXTxLivePusherImpl.a(i);
    }

    public boolean turnOnFlashLight(boolean z) {
        return this.mTXTxLivePusherImpl.d(z);
    }

    public int getMaxZoom() {
        return this.mTXTxLivePusherImpl.p();
    }

    public boolean setZoom(int i) {
        return this.mTXTxLivePusherImpl.b(i);
    }

    public void setExposureCompensation(float f2) {
        this.mTXTxLivePusherImpl.a(f2);
    }

    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        return this.mTXTxLivePusherImpl.a(i, i2, i3, i4);
    }

    public void setFilter(Bitmap bitmap) {
        this.mTXTxLivePusherImpl.a(bitmap);
    }

    public void setSpecialRatio(float f2) {
        this.mTXTxLivePusherImpl.b(f2);
    }

    public void setEyeScaleLevel(int i) {
        this.mTXTxLivePusherImpl.c(i);
    }

    public void setFaceSlimLevel(int i) {
        this.mTXTxLivePusherImpl.d(i);
    }

    public void setFaceVLevel(int i) {
        this.mTXTxLivePusherImpl.e(i);
    }

    public void setChinLevel(int i) {
        this.mTXTxLivePusherImpl.f(i);
    }

    public void setFaceShortLevel(int i) {
        this.mTXTxLivePusherImpl.g(i);
    }

    public void setNoseSlimLevel(int i) {
        this.mTXTxLivePusherImpl.h(i);
    }

    @TargetApi(18)
    public boolean setGreenScreenFile(String str) {
        return this.mTXTxLivePusherImpl.b(str);
    }

    public void setMotionTmpl(String str) {
        this.mTXTxLivePusherImpl.c(str);
    }

    public void setMotionMute(boolean z) {
        this.mTXTxLivePusherImpl.e(z);
    }

    public void setMute(boolean z) {
        this.mTXTxLivePusherImpl.f(z);
    }

    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        this.mTXTxLivePusherImpl.a(onBGMNotify);
    }

    public boolean playBGM(String str) {
        return this.mTXTxLivePusherImpl.d(str);
    }

    public boolean stopBGM() {
        return this.mTXTxLivePusherImpl.q();
    }

    public boolean pauseBGM() {
        return this.mTXTxLivePusherImpl.r();
    }

    public boolean resumeBGM() {
        return this.mTXTxLivePusherImpl.s();
    }

    public int getMusicDuration(String str) {
        return this.mTXTxLivePusherImpl.e(str);
    }

    public boolean setBGMVolume(float f2) {
        return this.mTXTxLivePusherImpl.c(f2);
    }

    public boolean setMicVolume(float f2) {
        return this.mTXTxLivePusherImpl.d(f2);
    }

    public void setBgmPitch(float f2) {
        this.mTXTxLivePusherImpl.e(f2);
    }

    public void setReverb(int i) {
        this.mTXTxLivePusherImpl.i(i);
    }

    public void setVoiceChangerType(int i) {
        this.mTXTxLivePusherImpl.j(i);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mTXTxLivePusherImpl.a(iTXVideoRecordListener);
    }

    public int startRecord(String str) {
        return this.mTXTxLivePusherImpl.f(str);
    }

    public void stopRecord() {
        this.mTXTxLivePusherImpl.t();
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        this.mTXTxLivePusherImpl.a(iTXSnapshotListener);
    }

    public int sendCustomVideoTexture(int i, int i2, int i3) {
        return this.mTXTxLivePusherImpl.c(i, i2, i3);
    }

    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        return this.mTXTxLivePusherImpl.a(bArr, i, i2, i3);
    }

    public void sendCustomPCMData(byte[] bArr) {
        this.mTXTxLivePusherImpl.a(bArr);
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        this.mTXTxLivePusherImpl.a(videoCustomProcessListener);
    }

    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        this.mTXTxLivePusherImpl.a(audioCustomProcessListener);
    }

    public void setSurface(Surface surface) {
        this.mTXTxLivePusherImpl.a(surface);
    }

    public void setSurfaceSize(int i, int i2) {
        this.mTXTxLivePusherImpl.a(i, i2);
    }

    public void setFocusPosition(float f2, float f3) {
        this.mTXTxLivePusherImpl.a(f2, f3);
    }

    public boolean sendMessageEx(byte[] bArr) {
        return this.mTXTxLivePusherImpl.b(bArr);
    }

    @Deprecated
    public void sendMessage(byte[] bArr) {
        this.mTXTxLivePusherImpl.c(bArr);
    }

    public void onLogRecord(String str) {
        this.mTXTxLivePusherImpl.g(str);
    }
}
