package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public class TXLivePlayer {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
    public static final int PLAY_TYPE_VOD_FLV = 2;
    public static final int PLAY_TYPE_VOD_HLS = 3;
    public static final int PLAY_TYPE_VOD_MP4 = 4;
    public static final String TAG = "TXLivePlayer";
    private a mTXLivePlayerImpl;

    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i, int i2, int i3);

        void onPcmDataAvailable(byte[] bArr, long j);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i, int i2, int i3);
    }

    public TXLivePlayer(Context context) {
        this.mTXLivePlayerImpl = new a(context);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        this.mTXLivePlayerImpl.a(tXLivePlayConfig);
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mTXLivePlayerImpl.a(iTXLivePlayListener);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        this.mTXLivePlayerImpl.a(tXCloudVideoView);
    }

    public int startPlay(String str, int i) {
        return this.mTXLivePlayerImpl.a(str, i);
    }

    public int stopPlay(boolean z) {
        return this.mTXLivePlayerImpl.a(z);
    }

    public boolean isPlaying() {
        return this.mTXLivePlayerImpl.a();
    }

    public void pause() {
        this.mTXLivePlayerImpl.b();
    }

    public void resume() {
        this.mTXLivePlayerImpl.c();
    }

    public void setSurface(Surface surface) {
        this.mTXLivePlayerImpl.a(surface);
    }

    public void setSurfaceSize(int i, int i2) {
        this.mTXLivePlayerImpl.a(i, i2);
    }

    public void setRenderMode(int i) {
        this.mTXLivePlayerImpl.a(i);
    }

    public void setRenderRotation(int i) {
        this.mTXLivePlayerImpl.b(i);
    }

    public boolean enableHardwareDecode(boolean z) {
        return this.mTXLivePlayerImpl.b(z);
    }

    public void setMute(boolean z) {
        this.mTXLivePlayerImpl.c(z);
    }

    public void setAudioRoute(int i) {
        this.mTXLivePlayerImpl.c(i);
    }

    public int switchStream(String str) {
        return this.mTXLivePlayerImpl.a(str);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mTXLivePlayerImpl.a(iTXVideoRecordListener);
    }

    public int startRecord(int i) {
        return this.mTXLivePlayerImpl.d(i);
    }

    public int stopRecord() {
        return this.mTXLivePlayerImpl.d();
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        this.mTXLivePlayerImpl.a(iTXSnapshotListener);
    }

    public boolean addVideoRawData(byte[] bArr) {
        return this.mTXLivePlayerImpl.a(bArr);
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        this.mTXLivePlayerImpl.a(iTXVideoRawDataListener);
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.mTXLivePlayerImpl.a(iTXAudioRawDataListener);
    }

    public int prepareLiveSeek(String str, int i) {
        return this.mTXLivePlayerImpl.b(str, i);
    }

    public void seek(int i) {
        this.mTXLivePlayerImpl.e(i);
    }

    public int resumeLive() {
        return this.mTXLivePlayerImpl.e();
    }

    @Deprecated
    public void setAutoPlay(boolean z) {
        this.mTXLivePlayerImpl.d(z);
    }

    @Deprecated
    public void setRate(float f2) {
        this.mTXLivePlayerImpl.a(f2);
    }
}
