package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.audio.impl.TXCTraeJNI;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer implements Runnable {
    private static final int PLAY_ERR_AUDIO_TRACK = -3;
    private static final int PLAY_ERR_AUDIO_TRACK_PLAY = -4;
    private static final int PLAY_ERR_FILE_NOTFOUND = -2;
    private static final int PLAY_ERR_OPEN = -1;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = ("AudioCenter:" + TXCLiveBGMPlayer.class.getSimpleName());
    private static TXCLiveBGMPlayer instance;
    private int mAECType = 0;
    private int mBgmDurationMs = 0;
    private Context mContext = null;
    private String mFilePath = null;
    private boolean mIsPause = false;
    private boolean mIsRunning = false;
    private float mPitch = BitmapDescriptorFactory.HUE_RED;
    private Thread mThread = null;
    private WeakReference<e> mWeakListener = null;

    private native int nativeGetBitsPerChannel();

    private native int nativeGetChannels();

    private native long nativeGetCurPtsMS();

    private native long nativeGetDurationMS(String str);

    private native int nativeGetSampleRate();

    private native void nativePause();

    private native int nativeRead(byte[] bArr, int i);

    private native void nativeResume();

    private native void nativeSetPitch(float f2);

    private native void nativeSetVolume(float f2);

    private native boolean nativeStartPlay(String str, TXCLiveBGMPlayer tXCLiveBGMPlayer);

    private native void nativeStopPlay();

    static {
        b.f();
    }

    public static TXCLiveBGMPlayer getInstance() {
        if (instance == null) {
            synchronized (TXCLiveBGMPlayer.class) {
                if (instance == null) {
                    instance = new TXCLiveBGMPlayer();
                }
            }
        }
        return instance;
    }

    private TXCLiveBGMPlayer() {
    }

    public synchronized void setOnPlayListener(e eVar) {
        if (eVar == null) {
            this.mWeakListener = null;
        }
        this.mWeakListener = new WeakReference<>(eVar);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public boolean startPlay(String str, int i) {
        if (str == null || str.isEmpty()) {
            TXCLog.e(TAG, "start live bgm failed! invalid params!");
            return false;
        }
        stopPlay();
        this.mAECType = i;
        this.mFilePath = str;
        this.mIsRunning = true;
        if (!nativeStartPlay(this.mFilePath, this)) {
            onPlayEnd(-1);
            return false;
        }
        this.mBgmDurationMs = (int) nativeGetDurationMS(this.mFilePath);
        if (this.mAECType == 2) {
            TXCTraeJNI.traeStartPlay(this.mContext);
        } else if (this.mThread == null) {
            this.mThread = new Thread(this, "BGMPlayer");
            this.mThread.start();
        }
        onPlayStart();
        String str2 = TAG;
        TXCLog.i(str2, "startPlay filePath = " + str);
        return true;
    }

    public void stopPlay() {
        this.mIsRunning = false;
        long currentTimeMillis = System.currentTimeMillis();
        Thread thread = this.mThread;
        if (!(thread == null || !thread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
            try {
                this.mThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        this.mThread = null;
        nativeStopPlay();
        TXCTraeJNI.traeStopPlay();
        this.mIsPause = false;
        this.mBgmDurationMs = 0;
        String str = TAG;
        TXCLog.i(str, "stopBGMPlay cost(MS): " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public boolean isRunning() {
        return this.mIsRunning && !this.mIsPause;
    }

    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public void switchAecType(int i) {
        if (!this.mIsRunning) {
            TXCLog.w(TAG, "未开始播放BGM，不能切换AEC Type");
        } else if (this.mAECType == i) {
            String str = TAG;
            TXCLog.i(str, "无需切换AEC Type. aecType = " + this.mAECType);
        } else {
            String str2 = TAG;
            TXCLog.i(str2, "切换AEC Type为 " + i);
            this.mAECType = i;
            if (this.mAECType == 2) {
                Thread thread = this.mThread;
                if (!(thread == null || !thread.isAlive() || Thread.currentThread().getId() == this.mThread.getId())) {
                    try {
                        this.mThread.join();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                this.mThread = null;
            } else if (this.mThread == null) {
                this.mThread = new Thread(this, "BGMPlayer");
                this.mThread.start();
            }
        }
    }

    public void pause() {
        TXCLog.i(TAG, "pause");
        this.mIsPause = true;
        nativePause();
    }

    public void resume() {
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        nativeResume();
    }

    public void setVolume(float f2) {
        nativeSetVolume(f2);
    }

    public long getMusicDuration(String str) {
        if (str != null) {
            return nativeGetDurationMS(str);
        }
        return (long) this.mBgmDurationMs;
    }

    public void setPitch(float f2) {
        this.mPitch = f2;
        nativeSetPitch(f2);
    }

    private void onPlayStart() {
        final e eVar;
        synchronized (this) {
            eVar = this.mWeakListener != null ? (e) this.mWeakListener.get() : null;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.a();
                }
            }
        });
    }

    private void onPlayEnd(final int i) {
        final e eVar;
        synchronized (this) {
            eVar = this.mWeakListener != null ? (e) this.mWeakListener.get() : null;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                e eVar = eVar;
                if (eVar != null) {
                    eVar.a(i);
                }
            }
        });
    }

    private void onPlayProgress(long j, long j2) {
        e eVar;
        synchronized (this) {
            eVar = this.mWeakListener != null ? (e) this.mWeakListener.get() : null;
        }
        if (eVar != null) {
            eVar.a(j, j2);
        }
    }

    private void nativeOPlayProgress(long j, long j2) {
        onPlayProgress(j, j2);
        if (j == j2) {
            onPlayEnd(0);
        }
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.mFilePath;
        int i = 0;
        AudioTrack audioTrack = null;
        if (str == null || str.isEmpty()) {
            i = -2;
        } else {
            int nativeGetSampleRate = nativeGetSampleRate();
            int nativeGetChannels = nativeGetChannels();
            int nativeGetBitsPerChannel = nativeGetBitsPerChannel();
            int i2 = nativeGetChannels == 1 ? 2 : 3;
            int i3 = nativeGetBitsPerChannel == 8 ? 3 : 2;
            try {
                AudioTrack audioTrack2 = new AudioTrack(3, nativeGetSampleRate, i2, i3, AudioTrack.getMinBufferSize(nativeGetSampleRate, i2, i3), 1);
                try {
                    audioTrack2.play();
                    int i4 = nativeGetChannels * 2048;
                    byte[] bArr = new byte[i4];
                    while (true) {
                        if (!this.mIsRunning || Thread.interrupted() || this.mAECType == 2) {
                            break;
                        }
                        int nativeRead = nativeRead(bArr, i4);
                        if (nativeRead < 0) {
                            int i5 = this.mBgmDurationMs;
                            onPlayProgress((long) i5, (long) i5);
                            break;
                        } else if (nativeRead != 0) {
                            audioTrack2.write(bArr, 0, nativeRead);
                            onPlayProgress(nativeGetCurPtsMS(), (long) this.mBgmDurationMs);
                        } else if (this.mIsPause) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                    String str2 = TAG;
                    TXCLog.e(str2, "AudioTrack play Exception: " + e3.getMessage());
                    i = -4;
                }
                audioTrack = audioTrack2;
            } catch (Exception e4) {
                e4.printStackTrace();
                String str3 = TAG;
                TXCLog.e(str3, "new AudioTrack Exception: " + e4.getMessage());
                i = -3;
            }
        }
        if (audioTrack != null) {
            try {
                audioTrack.pause();
                audioTrack.flush();
                audioTrack.stop();
                audioTrack.release();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        String str4 = TAG;
        TXCLog.i(str4, "Live BGM player play time: " + (System.currentTimeMillis() - currentTimeMillis));
        if (this.mIsRunning) {
            onPlayEnd(i);
        }
    }
}
