package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.appsflyer.share.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.k;
import com.tencent.liteav.network.f;
import com.tencent.liteav.network.g;
import com.tencent.liteav.network.i;
import com.tencent.liteav.txcvodplayer.TextureRenderView;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

public class TXVodPlayer implements a, g {
    public static final int PLAYER_TYPE_EXO = 1;
    public static final int PLAYER_TYPE_FFPLAY = 0;
    public static final String TAG = "TXVodPlayer";
    private boolean mAutoPlay = true;
    private int mBitrateIndex;
    private TXVodPlayConfig mConfig;
    private Context mContext;
    private boolean mEnableHWDec = false;
    private boolean mIsGetPlayInfo;
    private boolean mIsNeedClearLastImg = true;
    private ITXLivePlayListener mListener;
    private boolean mLoop;
    private boolean mMirror;
    private boolean mMute = false;
    private f mNetApi;
    private ITXVodPlayListener mNewListener;
    private String mPlayUrl = "";
    private k mPlayer;
    private float mRate = 1.0f;
    private int mRenderMode;
    private int mRenderRotation;
    /* access modifiers changed from: private */
    public boolean mSnapshotRunning = false;
    protected float mStartTime;
    private Surface mSurface;
    private TXCloudVideoView mTXCloudVideoView;
    private TextureRenderView mTextureView;
    private String mToken;

    public TXVodPlayer(Context context) {
        TXCLog.init();
        this.mListener = null;
        this.mNewListener = null;
        this.mContext = context.getApplicationContext();
    }

    public void setConfig(TXVodPlayConfig tXVodPlayConfig) {
        this.mConfig = tXVodPlayConfig;
        if (this.mConfig == null) {
            this.mConfig = new TXVodPlayConfig();
        }
        k kVar = this.mPlayer;
        if (kVar != null) {
            com.tencent.liteav.g p = kVar.p();
            if (p == null) {
                p = new com.tencent.liteav.g();
            }
            p.f31631e = this.mConfig.mConnectRetryCount;
            p.f31632f = this.mConfig.mConnectRetryInterval;
            p.q = this.mConfig.mTimeout;
            p.i = this.mEnableHWDec;
            p.m = this.mConfig.mCacheFolderPath;
            p.n = this.mConfig.mMaxCacheItems;
            p.o = this.mConfig.mPlayerType;
            p.p = this.mConfig.mHeaders;
            p.r = this.mConfig.enableAccurateSeek;
            p.s = this.mConfig.autoRotate;
            p.t = this.mConfig.smoothSwitchBitrate;
            p.u = this.mConfig.cacheMp4ExtName;
            p.v = this.mConfig.progressInterval;
            p.w = this.mConfig.maxBufferSize;
            this.mPlayer.a(p);
        }
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        this.mTXCloudVideoView = tXCloudVideoView;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a(tXCloudVideoView);
        }
    }

    public void setPlayerView(TextureRenderView textureRenderView) {
        this.mTextureView = textureRenderView;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a(textureRenderView);
        }
    }

    public void setSurface(Surface surface) {
        this.mSurface = surface;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a(this.mSurface);
        }
    }

    public int startPlay(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        TXCDRApi.initCrashReport(this.mContext);
        int i = this.mBitrateIndex;
        stopPlay(this.mIsNeedClearLastImg);
        this.mBitrateIndex = i;
        if (this.mToken != null) {
            String path = Uri.parse(str).getPath();
            if (path != null) {
                String[] split = path.split(Constants.URL_PATH_DELIMITER);
                if (split.length > 0) {
                    int lastIndexOf = str.lastIndexOf(split[split.length - 1]);
                    str = str.substring(0, lastIndexOf) + "voddrm.token." + this.mToken + "." + str.substring(lastIndexOf);
                }
            }
        }
        this.mPlayUrl = checkPlayUrl(str);
        TXCLog.d(TAG, "===========================================================================================================================================================");
        TXCLog.d(TAG, "===========================================================================================================================================================");
        TXCLog.d(TAG, "=====  StartPlay url = " + this.mPlayUrl + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
        TXCLog.d(TAG, "===========================================================================================================================================================");
        TXCLog.d(TAG, "===========================================================================================================================================================");
        this.mPlayer = new k(this.mContext);
        updateConfig();
        TXCloudVideoView tXCloudVideoView = this.mTXCloudVideoView;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.clearLog();
            this.mTXCloudVideoView.setVisibility(0);
            this.mPlayer.a(this.mTXCloudVideoView);
        } else {
            Surface surface = this.mSurface;
            if (surface != null) {
                this.mPlayer.a(surface);
            } else {
                TextureRenderView textureRenderView = this.mTextureView;
                if (textureRenderView != null) {
                    this.mPlayer.a(textureRenderView);
                }
            }
        }
        this.mPlayer.e(this.mBitrateIndex);
        this.mPlayer.a((a) this);
        this.mPlayer.c(this.mAutoPlay);
        this.mPlayer.c(this.mStartTime);
        this.mPlayer.a(this.mPlayUrl, 0);
        this.mPlayer.b(this.mMute);
        this.mPlayer.b(this.mRate);
        this.mPlayer.b(this.mRenderRotation);
        this.mPlayer.a(this.mRenderMode);
        this.mPlayer.d(this.mLoop);
        setMirror(this.mMirror);
        return 0;
    }

    public int startPlay(TXPlayerAuthBuilder tXPlayerAuthBuilder) {
        this.mNetApi = new f();
        this.mNetApi.a(tXPlayerAuthBuilder.isHttps);
        this.mNetApi.a((g) this);
        return this.mNetApi.a(tXPlayerAuthBuilder.appId, tXPlayerAuthBuilder.fileId, tXPlayerAuthBuilder.timeout, tXPlayerAuthBuilder.us, tXPlayerAuthBuilder.exper, tXPlayerAuthBuilder.sign);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String checkPlayUrl(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "http"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = "UTF-8"
            byte[] r0 = r8.getBytes(r0)     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            int r2 = r0.length     // Catch:{ Exception -> 0x0086 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0086 }
            r2 = 0
            r3 = 0
        L_0x0016:
            int r4 = r0.length     // Catch:{ Exception -> 0x0086 }
            if (r3 >= r4) goto L_0x0081
            byte r4 = r0[r3]     // Catch:{ Exception -> 0x0086 }
            if (r4 >= 0) goto L_0x0022
            byte r4 = r0[r3]     // Catch:{ Exception -> 0x0086 }
            int r4 = r4 + 256
            goto L_0x0024
        L_0x0022:
            byte r4 = r0[r3]     // Catch:{ Exception -> 0x0086 }
        L_0x0024:
            r5 = 32
            r6 = 37
            if (r4 <= r5) goto L_0x0062
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 >= r5) goto L_0x0062
            r5 = 34
            if (r4 == r5) goto L_0x0062
            if (r4 == r6) goto L_0x0062
            r5 = 60
            if (r4 == r5) goto L_0x0062
            r5 = 62
            if (r4 == r5) goto L_0x0062
            r5 = 91
            if (r4 == r5) goto L_0x0062
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L_0x0062
            r5 = 92
            if (r4 == r5) goto L_0x0062
            r5 = 93
            if (r4 == r5) goto L_0x0062
            r5 = 94
            if (r4 == r5) goto L_0x0062
            r5 = 96
            if (r4 == r5) goto L_0x0062
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L_0x0062
            r5 = 124(0x7c, float:1.74E-43)
            if (r4 != r5) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            char r4 = (char) r4     // Catch:{ Exception -> 0x0086 }
            r1.append(r4)     // Catch:{ Exception -> 0x0086 }
            goto L_0x007e
        L_0x0062:
            if (r4 != r6) goto L_0x006c
            java.lang.String r0 = "TXVodPlayer"
            java.lang.String r1 = "传入URL已转码"
            com.tencent.liteav.basic.log.TXCLog.w(r0, r1)     // Catch:{ Exception -> 0x0086 }
            return r8
        L_0x006c:
            java.lang.String r5 = "%%%02X"
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0086 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0086 }
            r6[r2] = r4     // Catch:{ Exception -> 0x0086 }
            java.lang.String r4 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0086 }
            r1.append(r4)     // Catch:{ Exception -> 0x0086 }
        L_0x007e:
            int r3 = r3 + 1
            goto L_0x0016
        L_0x0081:
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r0 = move-exception
            r0.printStackTrace()
        L_0x008a:
            java.lang.String r8 = r8.trim()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.TXVodPlayer.checkPlayUrl(java.lang.String):java.lang.String");
    }

    public int stopPlay(boolean z) {
        if (z) {
            TXCloudVideoView tXCloudVideoView = this.mTXCloudVideoView;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.setVisibility(8);
            }
        }
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a(z);
        }
        this.mPlayUrl = "";
        f fVar = this.mNetApi;
        if (fVar != null) {
            fVar.a((g) null);
            this.mNetApi = null;
        }
        this.mBitrateIndex = 0;
        this.mIsGetPlayInfo = false;
        return 0;
    }

    public boolean isPlaying() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            return kVar.c();
        }
        return false;
    }

    public void pause() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a();
        }
    }

    public void resume() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.b();
        }
    }

    public void seek(int i) {
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.d(i);
        }
    }

    public void seek(float f2) {
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a(f2);
        }
    }

    public float getCurrentPlaybackTime() {
        k kVar = this.mPlayer;
        return kVar != null ? kVar.h() : BitmapDescriptorFactory.HUE_RED;
    }

    public float getBufferDuration() {
        k kVar = this.mPlayer;
        return kVar != null ? kVar.i() : BitmapDescriptorFactory.HUE_RED;
    }

    public float getDuration() {
        k kVar = this.mPlayer;
        return kVar != null ? kVar.j() : BitmapDescriptorFactory.HUE_RED;
    }

    public float getPlayableDuration() {
        k kVar = this.mPlayer;
        return kVar != null ? kVar.k() : BitmapDescriptorFactory.HUE_RED;
    }

    public int getWidth() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            return kVar.l();
        }
        return 0;
    }

    public int getHeight() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            return kVar.m();
        }
        return 0;
    }

    @Deprecated
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mListener = iTXLivePlayListener;
    }

    public void setVodListener(ITXVodPlayListener iTXVodPlayListener) {
        this.mNewListener = iTXVodPlayListener;
    }

    public void setRenderMode(int i) {
        this.mRenderMode = i;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setRenderRotation(int i) {
        this.mRenderRotation = i;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.b(i);
        }
    }

    public boolean enableHardwareDecode(boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT < 18) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
                return false;
            } else if (isAVCDecBlacklistDevices()) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
                return false;
            }
        }
        this.mEnableHWDec = z;
        updateConfig();
        return true;
    }

    public void setMute(boolean z) {
        this.mMute = z;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.b(z);
        }
    }

    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.c(z);
        }
    }

    public void setRate(float f2) {
        this.mRate = f2;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.b(f2);
        }
    }

    public int getBitrateIndex() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            return kVar.n();
        }
        return 0;
    }

    public void setBitrateIndex(int i) {
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.e(i);
        }
        this.mBitrateIndex = i;
    }

    public ArrayList<TXBitrateItem> getSupportedBitrates() {
        k kVar = this.mPlayer;
        if (kVar != null) {
            return kVar.o();
        }
        return new ArrayList<>();
    }

    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        Bitmap bitmap;
        if (!this.mSnapshotRunning && iTXSnapshotListener != null) {
            this.mSnapshotRunning = true;
            k kVar = this.mPlayer;
            TextureView d2 = kVar != null ? kVar.d() : null;
            if (d2 != null) {
                Bitmap bitmap2 = d2.getBitmap();
                if (bitmap2 != null) {
                    Matrix transform = d2.getTransform((Matrix) null);
                    if (this.mMirror) {
                        transform.postScale(-1.0f, 1.0f);
                    }
                    bitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), transform, true);
                    bitmap2.recycle();
                } else {
                    bitmap = bitmap2;
                }
                postBitmapToMainThread(iTXSnapshotListener, bitmap);
                return;
            }
            this.mSnapshotRunning = false;
        }
    }

    public void setMirror(boolean z) {
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.e(z);
        }
        this.mMirror = z;
    }

    public void setStartTime(float f2) {
        this.mStartTime = f2;
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (i == 15001) {
            TXCloudVideoView tXCloudVideoView = this.mTXCloudVideoView;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.setLogText(bundle, (Bundle) null, 0);
            }
            ITXLivePlayListener iTXLivePlayListener = this.mListener;
            if (iTXLivePlayListener != null) {
                iTXLivePlayListener.onNetStatus(bundle);
            }
            ITXVodPlayListener iTXVodPlayListener = this.mNewListener;
            if (iTXVodPlayListener != null) {
                iTXVodPlayListener.onNetStatus(this, bundle);
                return;
            }
            return;
        }
        TXCloudVideoView tXCloudVideoView2 = this.mTXCloudVideoView;
        if (tXCloudVideoView2 != null) {
            tXCloudVideoView2.setLogText((Bundle) null, bundle, i);
        }
        ITXLivePlayListener iTXLivePlayListener2 = this.mListener;
        if (iTXLivePlayListener2 != null) {
            iTXLivePlayListener2.onPlayEvent(i, bundle);
        }
        ITXVodPlayListener iTXVodPlayListener2 = this.mNewListener;
        if (iTXVodPlayListener2 != null) {
            iTXVodPlayListener2.onPlayEvent(this, i, bundle);
        }
    }

    private boolean isAVCDecBlacklistDevices() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && Build.MODEL.equalsIgnoreCase("Che2-TL00");
    }

    private void postBitmapToMainThread(final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        if (iTXSnapshotListener != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    TXLivePlayer.ITXSnapshotListener iTXSnapshotListener = iTXSnapshotListener;
                    if (iTXSnapshotListener != null) {
                        iTXSnapshotListener.onSnapshot(bitmap);
                    }
                    boolean unused = TXVodPlayer.this.mSnapshotRunning = false;
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void updateConfig() {
        setConfig(this.mConfig);
    }

    public void onNetSuccess(f fVar) {
        if (fVar == this.mNetApi) {
            i a2 = fVar.a();
            if (!this.mIsGetPlayInfo) {
                startPlay(a2.a());
            }
            this.mIsGetPlayInfo = false;
            Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", 2010);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "文件信息请求成功");
            bundle.putString(TXLiveConstants.EVT_PLAY_URL, a2.a());
            bundle.putString(TXLiveConstants.EVT_PLAY_COVER_URL, a2.b());
            bundle.putString(TXLiveConstants.EVT_PLAY_NAME, a2.f());
            bundle.putString(TXLiveConstants.EVT_PLAY_DESCRIPTION, a2.g());
            if (a2.d() != null) {
                bundle.putInt(TXLiveConstants.EVT_PLAY_DURATION, a2.d().c());
            }
            onNotifyEvent(2010, bundle);
        }
    }

    public void onNetFailed(f fVar, String str, int i) {
        if (fVar == this.mNetApi) {
            this.mIsGetPlayInfo = false;
            Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", 2010);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            bundle.putInt("EVT_PARAM1", i);
            onNotifyEvent(-2306, bundle);
        }
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setLoop(boolean z) {
        this.mLoop = z;
        k kVar = this.mPlayer;
        if (kVar != null) {
            kVar.d(this.mLoop);
        }
    }

    public boolean isLoop() {
        return this.mLoop;
    }
}
