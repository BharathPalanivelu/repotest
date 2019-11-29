package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCRenderAndDec extends com.tencent.liteav.basic.module.a implements c, com.tencent.liteav.basic.c.a, a.C0490a, f, com.tencent.liteav.videodecoder.c {
    public static final String TAG = "TXCRenderAndDec";
    private boolean isAddAudioFirstFrame = false;
    private String mAudioInfo = "";
    private com.tencent.liteav.audio.a mAudioPlayer = null;
    private g mConfig = null;
    private Context mContext = null;
    private a mDecListener = null;
    private boolean mEnableDecoderChange = false;
    private boolean mEnableVolumeLevelCal = false;
    private boolean mFirstRender = false;
    private long mFrameDecErrCnt = 0;
    private boolean mIsFirstPlay = false;
    private boolean mIsRendering = false;
    private long mLastRenderCalculateTS = 0;
    private long mLastRenderFrameCount = 0;
    private long mLastReqKeyFrameTS = 0;
    private final float mMinJitterCacheHWDecode = 0.4f;
    private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener;
    private boolean mRealTime = false;
    private final float mRealTimeJitterCache = com.tencent.liteav.basic.a.a.f31227a;
    private final float mRealTimeJitterCacheMax = com.tencent.liteav.basic.a.a.f31229c;
    private final float mRealTimeJitterCacheMin = com.tencent.liteav.basic.a.a.f31228b;
    private WeakReference<b> mRenderAndDecDelegate;
    private long mRenderFrameCount = 0;
    private int mRenderMode = 0;
    private int mSmoothMode = 0;
    private int mStreamFormat = 0;
    /* access modifiers changed from: private */
    public int mStreamType = 0;
    private TXCVideoDecoder mVideoDecoder = null;
    /* access modifiers changed from: private */
    public g mVideoFrameFilter = null;
    /* access modifiers changed from: private */
    public p mVideoFrameListener;
    private e mVideoRender = null;

    public interface a {
        void a(SurfaceTexture surfaceTexture);

        void a(com.tencent.liteav.basic.structs.a aVar);

        void a(byte[] bArr, long j, int i, int i2);
    }

    public interface b {
        void a(String str, int i);
    }

    public void decVideo(TXSNALPacket tXSNALPacket) {
    }

    public int getVideoGop() {
        return 0;
    }

    public void onPlayError(int i, String str) {
    }

    public static void setAudioCorePlayListener(c cVar) {
        com.tencent.liteav.audio.a.a(cVar);
    }

    public TXCRenderAndDec(Context context) {
        this.mContext = context;
        com.tencent.liteav.basic.e.b.a().a(this.mContext);
    }

    public void setVideoRender(e eVar) {
        TXCLog.i(TAG, "set video render " + eVar + " id " + getID() + ", " + this.mStreamType);
        this.mVideoRender = eVar;
        e eVar2 = this.mVideoRender;
        if (eVar2 != null) {
            eVar2.setID(getID());
            this.mVideoRender.a(this.mStreamType);
            this.mVideoRender.a((com.tencent.liteav.basic.c.a) this);
            this.mVideoRender.c(this.mRenderMode);
            e eVar3 = this.mVideoRender;
            if (eVar3 instanceof com.tencent.liteav.renderer.a) {
                ((com.tencent.liteav.renderer.a) eVar3).b((a.C0490a) this);
            }
            g gVar = this.mConfig;
            if (gVar != null) {
                this.mVideoRender.b(gVar.f31630d);
            }
        }
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.mNotifyListener = new WeakReference<>(aVar);
    }

    public void setRenderAndDecDelegate(b bVar) {
        this.mRenderAndDecDelegate = new WeakReference<>(bVar);
    }

    public void setVideoFrameListener(p pVar) {
        this.mVideoFrameListener = pVar;
        TXCLog.i(TAG, "setVideoFrameListener->enter listener: " + pVar);
    }

    public void setConfig(g gVar) {
        this.mConfig = gVar;
        setPlayCacheStrategy();
    }

    public g getConfig() {
        return this.mConfig;
    }

    public void setID(String str) {
        super.setID(str);
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.setID(getID());
        }
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.setUserId(str);
        }
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public boolean isAddAudioFirstFrame() {
        return this.isAddAudioFirstFrame;
    }

    public void setAddAudioFirstFrame(boolean z) {
        this.isAddAudioFirstFrame = z;
    }

    public void setDecListener(a aVar) {
        this.mDecListener = aVar;
    }

    public void enableDecoderChange(boolean z) {
        this.mEnableDecoderChange = z;
    }

    public void start(boolean z) {
        TXCLog.i(TAG, "start render dec " + getID() + ", " + this.mStreamType);
        this.mRealTime = z;
        this.mIsFirstPlay = true;
        this.mFrameDecErrCnt = 0;
        this.mLastReqKeyFrameTS = 0;
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.a((f) this);
            this.mVideoRender.i();
            this.mVideoRender.setID(getID());
        }
        this.mVideoDecoder = new TXCVideoDecoder();
        this.mVideoDecoder.setUserId(getID());
        this.mVideoDecoder.setStreamType(this.mStreamType);
        this.mVideoDecoder.setListener(this);
        this.mVideoDecoder.setNotifyListener(this);
        this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
        if (this.mAudioPlayer == null) {
            this.mAudioPlayer = new com.tencent.liteav.audio.a();
        }
        this.mAudioPlayer.b((c) this);
        setupRealTimePlayParams(this.mRealTime);
        this.mAudioPlayer.b(this.mSmoothMode);
        this.mAudioPlayer.a(this.mStreamFormat);
        this.mAudioPlayer.a(getID());
        this.mAudioPlayer.b(this.mEnableVolumeLevelCal);
        this.mAudioPlayer.a(this.mContext);
        startDecode();
        setPlayCacheStrategy();
        this.mIsRendering = true;
    }

    public void startVideo() {
        stopVideo();
        this.mRealTime = true;
        this.mIsFirstPlay = true;
        this.mFrameDecErrCnt = 0;
        this.mLastReqKeyFrameTS = 0;
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.a((f) this);
            this.mVideoRender.i();
            this.mVideoRender.setID(getID());
        }
        TXCLog.i(TAG, "start video dec " + getID() + ", " + this.mStreamType);
        this.mVideoDecoder = new TXCVideoDecoder();
        this.mVideoDecoder.setUserId(getID());
        this.mVideoDecoder.setStreamType(this.mStreamType);
        this.mVideoDecoder.setListener(this);
        this.mVideoDecoder.setNotifyListener(this);
        this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
        startDecode();
        this.mIsRendering = true;
    }

    public void stopVideo() {
        this.mIsRendering = false;
        this.mSmoothMode = 0;
        if (this.mVideoDecoder != null) {
            TXCLog.d(TAG, "stop video dec " + getID() + ", " + this.mStreamType);
            this.mVideoDecoder.setListener((com.tencent.liteav.videodecoder.c) null);
            this.mVideoDecoder.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            this.mVideoDecoder.stop();
        }
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.j();
            this.mVideoRender.a((f) null);
        }
    }

    public void startAudio() {
        this.mRealTime = true;
        if (this.mAudioPlayer == null) {
            this.mAudioPlayer = new com.tencent.liteav.audio.a();
        }
        this.mAudioPlayer.b((c) this);
        setupRealTimePlayParams(this.mRealTime);
        this.mAudioPlayer.b(this.mSmoothMode);
        this.mAudioPlayer.a(this.mStreamFormat);
        this.mAudioPlayer.a(getID());
        this.mAudioPlayer.b(this.mEnableVolumeLevelCal);
        this.mAudioPlayer.a(this.mContext);
    }

    public void stopAudio() {
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.b((c) null);
            this.mAudioPlayer.a();
        }
    }

    public void stop() {
        TXCLog.d(TAG, "stop video render dec " + getID() + ", " + this.mStreamType);
        this.mIsRendering = false;
        this.mRealTime = false;
        this.mSmoothMode = 0;
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.setListener((com.tencent.liteav.videodecoder.c) null);
            this.mVideoDecoder.setNotifyListener((com.tencent.liteav.basic.c.a) null);
            this.mVideoDecoder.stop();
        }
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.b((c) null);
            this.mAudioPlayer.a();
        }
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.j();
            this.mVideoRender.a((f) null);
        }
    }

    public boolean isRendering() {
        return this.mIsRendering;
    }

    public void decAudio(com.tencent.liteav.basic.structs.a aVar) {
        if (this.mAudioPlayer == null) {
            TXCLog.w(TAG, "decAudio fail which audio play hasn't been created!");
        }
    }

    public void setRenderMode(int i) {
        this.mRenderMode = i;
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.c(i);
        }
    }

    public void setRenderRotation(int i) {
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.d(i);
        }
    }

    public void setMute(boolean z) {
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.e(z);
            TXCEventRecorderProxy.a(getID(), 3002, z ? 1 : 0, -1, "", this.mStreamType);
        }
    }

    public void setSmoothMode(int i) {
        this.mSmoothMode = i;
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.b(this.mSmoothMode);
        }
    }

    public void setStreamFormat(int i) {
        this.mStreamFormat = i;
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.a(this.mStreamFormat);
        }
    }

    public void setBlockInterval(int i) {
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.e(i);
        }
    }

    public void setEnableVolumeLevelCal(boolean z) {
        this.mEnableVolumeLevelCal = z;
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public int getVolumeLevel() {
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            return aVar.b();
        }
        return 0;
    }

    public static void setAudioMode(Context context, int i) {
        com.tencent.liteav.audio.a.a(context, i);
    }

    public static void setEnableCorePlayVolumeLevel(boolean z) {
        com.tencent.liteav.audio.a.f(z);
    }

    public static int GetCorePlayVolumeLevel() {
        return com.tencent.liteav.audio.a.h();
    }

    public long getAudioCacheDuration() {
        return getLongValue(2007);
    }

    public long getVideoCacheDuration() {
        return (long) getIntValue(BaseConstants.ERR_HTTP_REQ_FAILED, 2);
    }

    public long getVideoCacheFrameCount() {
        return (long) getIntValue(BaseConstants.ERR_TO_USER_INVALID, 2);
    }

    public int getVideoDecCacheFrameCount() {
        return getIntValue(BaseConstants.ERR_REQUEST_TIMEOUT, 2);
    }

    public long getAVPlayInterval() {
        return getLongValue(BaseConstants.ERR_SDK_NOT_INITIALIZED, 2);
    }

    public int getAudioJitter() {
        return getIntValue(TXLiteAVCode.EVT_VOD_PLAY_DNS_RESOLVED);
    }

    public long getAVNetRecvInterval() {
        return getLongValue(BaseConstants.ERR_SDK_NOT_LOGGED_IN, 2);
    }

    public float getAudioCacheThreshold() {
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        return aVar != null ? aVar.c() : BitmapDescriptorFactory.HUE_RED;
    }

    public String getAudioInfo() {
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        int i = 0;
        int d2 = aVar != null ? aVar.d() : 0;
        int intValue = getIntValue(TXLiteAVCode.EVT_VOD_PLAY_SEEK_COMPLETE);
        int intValue2 = getIntValue(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES);
        com.tencent.liteav.audio.a aVar2 = this.mAudioPlayer;
        int e2 = aVar2 != null ? aVar2.e() : 0;
        com.tencent.liteav.audio.a aVar3 = this.mAudioPlayer;
        if (aVar3 != null) {
            i = aVar3.f();
        }
        String str = intValue + "," + intValue2 + " | " + e2 + "," + i;
        if (!this.mAudioInfo.equals(str) && this.mDecListener != null) {
            com.tencent.liteav.basic.structs.a aVar4 = new com.tencent.liteav.basic.structs.a();
            aVar4.f31397a = e2;
            aVar4.f31398b = i;
            this.mDecListener.a(aVar4);
        }
        this.mAudioInfo = str;
        return d2 + " | " + this.mAudioInfo;
    }

    public void updateLoadInfo() {
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        long j = 0;
        if (aVar != null) {
            TXAudioJitterBufferReportInfo g2 = aVar.g();
            if (g2 != null) {
                long j2 = g2.mLoadCnt == 0 ? 0 : (long) (g2.mLoadTime / g2.mLoadCnt);
                long j3 = g2.mTimeTotalCacheTimeCnt == 0 ? 0 : g2.mTimeTotalCacheTime / g2.mTimeTotalCacheTimeCnt;
                int i = g2.mTimeTotalJittCnt == 0 ? 0 : g2.mTimeTotalJitt / g2.mTimeTotalJittCnt;
                setStatusValue(2001, this.mStreamType, Long.valueOf(j2));
                setStatusValue(2002, this.mStreamType, Long.valueOf((long) g2.mLoadCnt));
                setStatusValue(2003, this.mStreamType, Long.valueOf((long) g2.mLoadMaxTime));
                setStatusValue(2004, this.mStreamType, Long.valueOf((long) g2.mSpeedCnt));
                setStatusValue(2005, this.mStreamType, Long.valueOf((long) g2.mNoDataCnt));
                setStatusValue(2008, this.mStreamType, Long.valueOf((long) g2.mAvgCacheTime));
                setStatusValue(2009, this.mStreamType, Long.valueOf((long) g2.mIsRealTime));
                setStatusValue(2010, Long.valueOf(j3));
                setStatusValue(2011, Long.valueOf((long) i));
                setStatusValue(2014, Long.valueOf((long) g2.mTimeDropCnt));
            }
        }
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            int i2 = this.mStreamType;
            if (tXCVideoDecoder.isHardwareDecode()) {
                j = 1;
            }
            setStatusValue(5002, i2, Long.valueOf(j));
        }
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.r();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = currentTimeMillis - this.mLastRenderCalculateTS;
        if (j4 >= 1000) {
            long j5 = this.mRenderFrameCount;
            double d2 = (double) (j5 - this.mLastRenderFrameCount);
            Double.isNaN(d2);
            double d3 = (double) j4;
            Double.isNaN(d3);
            this.mLastRenderFrameCount = j5;
            this.mLastRenderCalculateTS = currentTimeMillis;
            setStatusValue(BaseConstants.ERR_SERIALIZE_REQ_FAILED, this.mStreamType, Double.valueOf((d2 * 1000.0d) / d3));
        }
    }

    public com.tencent.liteav.audio.a getAudioPlayer() {
        return this.mAudioPlayer;
    }

    public e getVideoRender() {
        return this.mVideoRender;
    }

    public void setStreamType(int i) {
        this.mStreamType = i;
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.a(this.mStreamType);
        }
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.setStreamType(this.mStreamType);
        }
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    private void startDecode(SurfaceTexture surfaceTexture) {
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.stop();
            tXCVideoDecoder.enableHWDec(this.mConfig.i);
            String id = getID();
            boolean z = this.mConfig.i;
            TXCEventRecorderProxy.a(id, 4005, z ? 1 : 0, -1, "", this.mStreamType);
            TXCLog.d(TAG, "trtc_ start decode " + surfaceTexture + ", hw: " + this.mConfig.i + ", id " + getID() + "_" + this.mStreamType);
            if (surfaceTexture != null) {
                tXCVideoDecoder.setup(surfaceTexture, (ByteBuffer) null, (ByteBuffer) null, !this.mRealTime);
                tXCVideoDecoder.setUserId(getID());
                tXCVideoDecoder.start();
            } else if (!this.mConfig.i) {
                tXCVideoDecoder.setup((Surface) null, (ByteBuffer) null, (ByteBuffer) null, !this.mRealTime);
                tXCVideoDecoder.setUserId(getID());
                tXCVideoDecoder.start();
            }
        }
    }

    private void startDecode() {
        e eVar = this.mVideoRender;
        startDecode(eVar != null ? eVar.a() : null);
    }

    private void setPlayCacheStrategy() {
        setupRealTimePlayParams(this.mRealTime);
        com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
        if (aVar != null) {
            aVar.a(this.mConfig.f31627a);
            this.mAudioPlayer.a(this.mConfig.f31633g);
            this.mAudioPlayer.c(this.mConfig.f31629c);
            this.mAudioPlayer.b(this.mConfig.f31628b);
            setStatusValue(2012, this.mStreamType, Long.valueOf((long) (this.mConfig.f31629c * 1000.0f)));
            setStatusValue(2013, this.mStreamType, Long.valueOf((long) (this.mConfig.f31628b * 1000.0f)));
            setStatusValue(2015, 0L);
        }
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null && tXCVideoDecoder.isHardwareDecode() && this.mConfig.f31629c < 0.4f && this.mConfig.f31628b < 0.4f) {
            this.mConfig.i = false;
            this.mVideoDecoder.stop();
            startDecode();
        }
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.b(this.mConfig.f31630d);
        }
    }

    private void setupRealTimePlayParams(boolean z) {
        if (z) {
            float f2 = this.mConfig.f31627a;
            float f3 = this.mConfig.f31629c;
            float f4 = this.mConfig.f31628b;
            float f5 = this.mRealTimeJitterCacheMin;
            if (f3 > f5) {
                f3 = (!this.mConfig.i || f5 >= 0.4f) ? f5 : 0.4f;
            }
            float f6 = this.mRealTimeJitterCacheMax;
            if (f4 > f6) {
                f4 = f6;
            }
            if (f3 >= f4) {
                f3 = this.mRealTimeJitterCacheMin;
                f4 = this.mRealTimeJitterCacheMax;
            }
            g gVar = this.mConfig;
            gVar.f31633g = true;
            gVar.f31627a = f3;
            gVar.f31629c = f3;
            gVar.f31628b = f4;
            com.tencent.liteav.audio.a aVar = this.mAudioPlayer;
            if (aVar != null) {
                aVar.a(true, this.mContext);
                this.mAudioPlayer.d(true);
                return;
            }
            return;
        }
        TXCLog.e(TAG, "setupRealTimePlayParams current cache time : min-cache[" + this.mConfig.f31629c + "], max-cache[" + this.mConfig.f31628b + "], org-cache[" + this.mConfig.f31627a + "]");
        if (this.mAudioPlayer != null) {
            g gVar2 = this.mConfig;
            if (gVar2 == null || !gVar2.h) {
                this.mAudioPlayer.a(false, this.mContext);
            } else {
                this.mAudioPlayer.a(true, this.mContext);
            }
            this.mAudioPlayer.d(false);
        }
        if (this.mConfig.f31627a > this.mConfig.f31628b || this.mConfig.f31627a < this.mConfig.f31629c) {
            g gVar3 = this.mConfig;
            gVar3.f31627a = gVar3.f31628b;
        }
    }

    private void notifyEvent(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", getID());
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        bundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
        com.tencent.liteav.basic.util.b.a(this.mNotifyListener, i, bundle);
    }

    private void switchToSoftDecoder() {
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            TXCLog.w(TAG, "switch to soft decoder when hw error");
            tXCVideoDecoder.stop();
            this.mConfig.i = false;
            setPlayCacheStrategy();
            tXCVideoDecoder.enableChange(false);
            startDecode();
        }
    }

    public void restartDecoder() {
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null && tXCVideoDecoder.isHevc()) {
            tXCVideoDecoder.restart(true);
        }
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        if (i == 2106) {
            switchToSoftDecoder();
        } else if (i == 2003) {
            if (this.mIsFirstPlay) {
                notifyEvent(2004, "视频播放开始");
                this.mIsFirstPlay = false;
            }
        } else if (i == 2020) {
            TXCLog.e(TAG, "decoding too many frame(>40) without output! request key frame now.");
            requestKeyFrame();
            return;
        }
        bundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
        com.tencent.liteav.basic.util.b.a(this.mNotifyListener, i, bundle);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture) {
        TXCLog.w(TAG, "play decode when surface texture create hw " + this.mConfig.i);
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.setup(surfaceTexture, (ByteBuffer) null, (ByteBuffer) null, !this.mRealTime);
        }
        if (this.mConfig.i) {
            startDecode(surfaceTexture);
        }
    }

    public void onSurfaceTextureDestroy(SurfaceTexture surfaceTexture) {
        try {
            TXCLog.w(TAG, "play:stop decode when surface texture release");
            if (this.mVideoDecoder != null) {
                this.mVideoDecoder.stop();
            }
            if (this.mVideoFrameFilter != null) {
                this.mVideoFrameFilter.d();
                this.mVideoFrameFilter = null;
            }
            if (this.mDecListener != null) {
                this.mDecListener.a(surfaceTexture);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int i, int i2, long j, long j2, int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 3) {
            i3 = 360 - (i3 * 90);
        }
        p pVar = this.mVideoFrameListener;
        if (pVar != null) {
            pVar.a(getID(), this.mStreamType, (this.mVideoRender == null || tXSVideoFrame == null) ? tXSVideoFrame : tXSVideoFrame.clone());
        }
        if (!this.mFirstRender) {
            this.mFirstRender = true;
            TXCKeyPointReportProxy.a(getID(), 32004);
            TXCEventRecorderProxy.a(getID(), 5007, -1, -1, "", this.mStreamType);
        }
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.a(tXSVideoFrame, i, i2, i3);
        } else if (this.mLastRenderCalculateTS == 0) {
            this.mLastRenderCalculateTS = System.currentTimeMillis();
            this.mLastRenderFrameCount = 0;
            this.mRenderFrameCount = 0;
        } else {
            this.mRenderFrameCount++;
        }
    }

    public void onVideoSizeChange(int i, int i2) {
        e eVar = this.mVideoRender;
        if (eVar != null) {
            eVar.b(i, i2);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "分辨率改变为" + i + "x" + i2);
        bundle.putInt("EVT_PARAM1", i);
        bundle.putInt("EVT_PARAM2", i2);
        bundle.putString("EVT_USERID", getID());
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        onNotifyEvent(2009, bundle);
        setStatusValue(5003, this.mStreamType, Integer.valueOf((i << 16) | i2));
        TXCEventRecorderProxy.a(getID(), 4003, i, i2, "", this.mStreamType);
        TXCKeyPointReportProxy.a(getID(), 40002, i);
        TXCKeyPointReportProxy.a(getID(), 40003, i2);
    }

    public void onDecodeFailed(int i) {
        TXCLog.e(TAG, "video decode failed " + i);
        requestKeyFrame();
        int i2 = this.mStreamType;
        long j = this.mFrameDecErrCnt + 1;
        this.mFrameDecErrCnt = j;
        setStatusValue(17014, i2, Long.valueOf(j));
    }

    public void onTextureProcess(int i, int i2, int i3) {
        if (this.mVideoFrameListener != null && this.mConfig.i) {
            if (this.mVideoFrameFilter == null) {
                this.mVideoFrameFilter = new o(1, true);
                this.mVideoFrameFilter.a(true);
                if (this.mVideoFrameFilter.a()) {
                    this.mVideoFrameFilter.a(i2, i3);
                    this.mVideoFrameFilter.a((g.a) new g.a() {
                        public void a(int i) {
                            g access$000 = TXCRenderAndDec.this.mVideoFrameFilter;
                            if (access$000 != null) {
                                TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                                tXSVideoFrame.width = access$000.n();
                                tXSVideoFrame.height = access$000.o();
                                tXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
                                tXSVideoFrame.loadI420BufferFromGL();
                                p access$100 = TXCRenderAndDec.this.mVideoFrameListener;
                                if (access$100 != null) {
                                    access$100.a(TXCRenderAndDec.this.getID(), TXCRenderAndDec.this.mStreamType, tXSVideoFrame);
                                }
                            }
                        }
                    });
                } else {
                    TXCLog.i(TAG, "throwVideoFrame->release mVideoFrameFilter");
                    this.mVideoFrameFilter = null;
                }
            }
            if (this.mVideoFrameFilter != null) {
                GLES20.glViewport(0, 0, i2, i3);
                this.mVideoFrameFilter.a(i2, i3);
                this.mVideoFrameFilter.b(i);
            }
        }
    }

    public void onPlayPcmData(byte[] bArr, long j, int i, int i2) {
        a aVar = this.mDecListener;
        if (aVar != null) {
            aVar.a(bArr, j, i, i2);
        }
    }

    public void onPlayJitterStateNotify(int i) {
        if (i == 2024) {
            notifyEvent(2007, "视频缓冲中...");
        } else if (i == 2023) {
            notifyEvent(2007, "视频缓冲中...");
        } else if (i == 2025) {
            notifyEvent(2004, "视频播放开始");
        } else if (i == 2026) {
            if (this.mIsFirstPlay) {
                notifyEvent(2004, "视频播放开始");
                this.mIsFirstPlay = false;
            }
            notifyEvent(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_PLAY, "音频播放开始");
        }
    }

    private void requestKeyFrame() {
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick > this.mLastReqKeyFrameTS + 3000) {
            this.mLastReqKeyFrameTS = timeTick;
            TXCLog.e(TAG, "requestKeyFrame: " + getID());
            WeakReference<b> weakReference = this.mRenderAndDecDelegate;
            if (weakReference != null) {
                b bVar = (b) weakReference.get();
                if (bVar != null) {
                    bVar.a(getID(), this.mStreamType);
                }
            }
        }
    }
}
