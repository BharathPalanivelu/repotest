package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class TXCVideoDecoder implements com.tencent.liteav.basic.c.a, c {
    private static final boolean NEW_DECODER = true;
    private static final String TAG = "TXCVideoDecoder";
    private int mDecoderCacheNum;
    private a mDecoderHandler;
    c mDecoderListener;
    private boolean mEnableDecoderChange = false;
    boolean mHWDec = true;
    boolean mHevc = false;
    private ArrayList<TXSNALPacket> mNALList = new ArrayList<>();
    private long mNativeContext;
    boolean mNeedSortFrame = true;
    private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener;
    private ByteBuffer mPps;
    boolean mRecvFirstFrame = false;
    private boolean mRestarting = false;
    private ByteBuffer mSps;
    private int mStreamType = 0;
    Surface mSurface;
    private String mUserId;
    a mVideoDecoder;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;

    private native long nativeCreateContext(boolean z);

    private native void nativeDecCache(long j);

    private native void nativeDecodeFrame(long j, byte[] bArr, int i, long j2, long j3, int i2, int i3);

    private native void nativeDestroyContext(long j);

    private native void nativeEnableDecodeChange(long j, boolean z);

    private native void nativeNotifyPts(long j, long j2);

    private native void nativeSetID(long j, String str);

    private native void nativeSetStreamType(long j, int i);

    public void onNotifyEvent(int i, Bundle bundle) {
        b.a(this.mNotifyListener, this.mUserId, i, bundle);
    }

    public void setUserId(String str) {
        this.mUserId = str;
        synchronized (this) {
            nativeSetID(this.mNativeContext, this.mUserId);
        }
    }

    public void setStreamType(int i) {
        this.mStreamType = i;
        synchronized (this) {
            nativeSetStreamType(this.mNativeContext, this.mStreamType);
        }
    }

    public void enableChange(boolean z) {
        this.mEnableDecoderChange = z;
        synchronized (this) {
            nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
        }
    }

    public void setListener(c cVar) {
        this.mDecoderListener = cVar;
    }

    public boolean isHardwareDecode() {
        return this.mHWDec;
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.mNotifyListener = new WeakReference<>(aVar);
    }

    public int setup(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        return setup(new Surface(surfaceTexture), byteBuffer, byteBuffer2, z);
    }

    public int setup(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z) {
        this.mSurface = surface;
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mNeedSortFrame = z;
        return 0;
    }

    public void enableHWDec(boolean z) {
        this.mHWDec = z;
    }

    private void addOneNalToDecoder(TXSNALPacket tXSNALPacket) {
        boolean z = tXSNALPacket.nalType == 0;
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", z);
        bundle.putByteArray("nal", tXSNALPacket.nalData);
        bundle.putLong("pts", tXSNALPacket.pts);
        bundle.putLong("dts", tXSNALPacket.dts);
        bundle.putInt("codecId", tXSNALPacket.codecId);
        Message message = new Message();
        message.what = 101;
        message.setData(bundle);
        a aVar = this.mDecoderHandler;
        if (aVar != null) {
            aVar.sendMessage(message);
        }
        this.mDecoderCacheNum++;
    }

    private void decNALByNewWay(TXSNALPacket tXSNALPacket) {
        if (this.mHWDec) {
            decodeFrame(tXSNALPacket.nalData, tXSNALPacket.pts, tXSNALPacket.dts, tXSNALPacket.rotation, tXSNALPacket.codecId);
            return;
        }
        synchronized (this) {
            nativeDecodeFrame(this.mNativeContext, tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.pts, tXSNALPacket.dts, tXSNALPacket.rotation, tXSNALPacket.codecId);
        }
    }

    private void decNALByOldWay(TXSNALPacket tXSNALPacket) {
        try {
            boolean z = tXSNALPacket.nalType == 0;
            if (this.mRecvFirstFrame || z) {
                if (!this.mRecvFirstFrame && z) {
                    TXCLog.w(TAG, "play:decode: push first i frame");
                    this.mRecvFirstFrame = true;
                }
                if (!this.mRestarting && tXSNALPacket.codecId == 1 && !this.mHWDec) {
                    TXCLog.w(TAG, "play:decode: hevc decode error  ");
                    b.a(this.mNotifyListener, -2304, "h265解码失败");
                    this.mRestarting = true;
                }
                if (this.mDecoderHandler != null) {
                    if (!this.mNALList.isEmpty()) {
                        Iterator<TXSNALPacket> it = this.mNALList.iterator();
                        while (it.hasNext()) {
                            addOneNalToDecoder(it.next());
                        }
                    }
                    this.mNALList.clear();
                    addOneNalToDecoder(tXSNALPacket);
                    return;
                }
                if (z && !this.mNALList.isEmpty()) {
                    this.mNALList.clear();
                }
                this.mNALList.add(tXSNALPacket);
                if (!this.mRestarting) {
                    start();
                    return;
                }
                return;
            }
            TXCLog.i(TAG, "play:decode: push nal ignore p frame when not got i frame");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void pushNAL(TXSNALPacket tXSNALPacket) {
        decNALByNewWay(tXSNALPacket);
    }

    public synchronized int start() {
        if (this.mHWDec && this.mSurface == null) {
            TXCLog.i(TAG, "play:decode: start decoder error when not setup surface, id " + this.mUserId + "_" + this.mStreamType);
            return -1;
        } else if (this.mNativeContext != 0) {
            TXCLog.w(TAG, "play:decode: start decoder error when decoder is started, id " + this.mUserId + "_" + this.mStreamType);
            return -1;
        } else {
            TXCLog.w(TAG, "play:decode: start decoder java id " + this.mUserId + "_" + this.mStreamType);
            this.mNativeContext = nativeCreateContext(this.mHWDec);
            nativeSetID(this.mNativeContext, this.mUserId);
            nativeSetStreamType(this.mNativeContext, this.mStreamType);
            nativeEnableDecodeChange(this.mNativeContext, this.mEnableDecoderChange);
            return 0;
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:657)
        	at java.util.ArrayList.get(ArrayList.java:433)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void stop() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.mNativeContext     // Catch:{ all -> 0x007d }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002d
            java.lang.String r0 = "TXCVideoDecoder"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "play:decode: stop decoder ignore when decoder is stopped, id "
            r1.append(r2)     // Catch:{ all -> 0x007d }
            java.lang.String r2 = r5.mUserId     // Catch:{ all -> 0x007d }
            r1.append(r2)     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x007d }
            int r2 = r5.mStreamType     // Catch:{ all -> 0x007d }
            r1.append(r2)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007d }
            com.tencent.liteav.basic.log.TXCLog.w(r0, r1)     // Catch:{ all -> 0x007d }
            monitor-exit(r5)
            return
        L_0x002d:
            java.lang.String r0 = "TXCVideoDecoder"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "play:decode: stop decoder java id "
            r1.append(r4)     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r5.mUserId     // Catch:{ all -> 0x007d }
            r1.append(r4)     // Catch:{ all -> 0x007d }
            java.lang.String r4 = "_"
            r1.append(r4)     // Catch:{ all -> 0x007d }
            int r4 = r5.mStreamType     // Catch:{ all -> 0x007d }
            r1.append(r4)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x007d }
            com.tencent.liteav.basic.log.TXCLog.w(r0, r1)     // Catch:{ all -> 0x007d }
            long r0 = r5.mNativeContext     // Catch:{ all -> 0x007d }
            r5.nativeDestroyContext(r0)     // Catch:{ all -> 0x007d }
            r5.mNativeContext = r2     // Catch:{ all -> 0x007d }
            java.util.ArrayList<com.tencent.liteav.basic.structs.TXSNALPacket> r0 = r5.mNALList     // Catch:{ all -> 0x007d }
            r0.clear()     // Catch:{ all -> 0x007d }
            r0 = 0
            r5.mRecvFirstFrame = r0     // Catch:{ all -> 0x007d }
            r5.mDecoderCacheNum = r0     // Catch:{ all -> 0x007d }
            monitor-enter(r5)     // Catch:{ all -> 0x007d }
            com.tencent.liteav.videodecoder.a r0 = r5.mVideoDecoder     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0077
            com.tencent.liteav.videodecoder.a r0 = r5.mVideoDecoder     // Catch:{ all -> 0x007a }
            r0.stop()     // Catch:{ all -> 0x007a }
            com.tencent.liteav.videodecoder.a r0 = r5.mVideoDecoder     // Catch:{ all -> 0x007a }
            r1 = 0
            r0.setListener(r1)     // Catch:{ all -> 0x007a }
            com.tencent.liteav.videodecoder.a r0 = r5.mVideoDecoder     // Catch:{ all -> 0x007a }
            r0.setNotifyListener(r1)     // Catch:{ all -> 0x007a }
            r5.mVideoDecoder = r1     // Catch:{ all -> 0x007a }
        L_0x0077:
            monitor-exit(r5)     // Catch:{ all -> 0x007a }
            monitor-exit(r5)
            return
        L_0x007a:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007a }
            throw r0     // Catch:{ all -> 0x007d }
        L_0x007d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videodecoder.TXCVideoDecoder.stop():void");
    }

    public void restart(boolean z) {
        synchronized (this) {
            this.mHWDec = z;
            this.mNALList.clear();
            int i = 0;
            this.mRecvFirstFrame = false;
            this.mDecoderCacheNum = 0;
            Message obtain = Message.obtain();
            obtain.what = 103;
            obtain.arg1 = this.mHWDec ? 1 : 0;
            if (this.mNeedSortFrame) {
                i = 1;
            }
            obtain.arg2 = i;
            if (this.mDecoderHandler != null) {
                this.mDecoderHandler.sendMessage(obtain);
            }
        }
    }

    public int getDecoderCacheNum() {
        return this.mDecoderCacheNum + this.mNALList.size();
    }

    public void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int i, int i2, long j, long j2, int i3) {
        c cVar = this.mDecoderListener;
        if (cVar != null) {
            cVar.onDecodeFrame(tXSVideoFrame, i, i2, j, j2, i3);
        }
        int i4 = this.mDecoderCacheNum;
        if (i4 > 0) {
            this.mDecoderCacheNum = i4 - 1;
        }
        if (tXSVideoFrame == null) {
            synchronized (this) {
                nativeNotifyPts(this.mNativeContext, j);
            }
        }
    }

    public void onVideoSizeChange(int i, int i2) {
        c cVar = this.mDecoderListener;
        if (cVar == null) {
            return;
        }
        if (this.mVideoWidth != i || this.mVideoHeight != i2) {
            this.mVideoWidth = i;
            this.mVideoHeight = i2;
            cVar.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
        }
    }

    public void onDecodeFailed(int i) {
        c cVar = this.mDecoderListener;
        if (cVar != null) {
            cVar.onDecodeFailed(i);
        }
        synchronized (this) {
            nativeDecCache(this.mNativeContext);
        }
    }

    public boolean isHevc() {
        a aVar = this.mDecoderHandler;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    private int startDecodeThread() {
        synchronized (this) {
            if (this.mDecoderHandler != null) {
                TXCLog.e(TAG, "play:decode: start decoder error when decoder is started");
                return -1;
            }
            this.mDecoderCacheNum = 0;
            this.mRestarting = false;
            HandlerThread handlerThread = new HandlerThread("VDecoder");
            handlerThread.start();
            if (this.mHWDec) {
                handlerThread.setName("VideoWDec" + handlerThread.getId());
            } else {
                handlerThread.setName("VideoSWDec" + handlerThread.getId());
            }
            a aVar = new a(handlerThread.getLooper());
            aVar.a(this.mHevc, this.mHWDec, this.mSurface, this.mSps, this.mPps, this, this);
            TXCLog.w(TAG, "play:decode: start decode thread");
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = Boolean.valueOf(this.mNeedSortFrame);
            aVar.sendMessage(obtain);
            this.mDecoderHandler = aVar;
            return 0;
        }
    }

    private void stopDecodeThread() {
        synchronized (this) {
            if (this.mDecoderHandler != null) {
                this.mDecoderHandler.sendEmptyMessage(102);
            }
            this.mDecoderHandler = null;
        }
    }

    private void notifyDecoderStartEvent(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", 2008);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, z ? "启动硬解" : "启动软解");
        bundle.putInt("EVT_PARAM1", z ? 1 : 2);
        b.a(this.mNotifyListener, this.mUserId, 2008, bundle);
    }

    private boolean hasSurface() {
        return this.mSurface != null;
    }

    static {
        b.f();
    }

    private void onDecodeDone(TXSVideoFrame tXSVideoFrame, int i, int i2, long j, long j2, int i3, int i4) {
        TXSVideoFrame tXSVideoFrame2 = tXSVideoFrame;
        int i5 = i;
        int i6 = i2;
        c cVar = this.mDecoderListener;
        if (cVar != null) {
            tXSVideoFrame2.width = i5;
            tXSVideoFrame2.height = i6;
            int i7 = i3;
            tXSVideoFrame2.rotation = i7;
            long j3 = j;
            tXSVideoFrame2.pts = j3;
            tXSVideoFrame2.frameType = i4;
            cVar.onDecodeFrame(tXSVideoFrame, i, i2, j3, j2, i7);
            if (this.mVideoWidth != i5 || this.mVideoHeight != i6) {
                this.mVideoWidth = i5;
                this.mVideoHeight = i6;
                cVar.onVideoSizeChange(this.mVideoWidth, this.mVideoHeight);
            }
        }
    }

    private void decodeFrame(byte[] bArr, long j, long j2, int i, int i2) {
        TXSNALPacket tXSNALPacket = new TXSNALPacket();
        tXSNALPacket.nalData = bArr;
        tXSNALPacket.pts = j;
        tXSNALPacket.dts = j2;
        tXSNALPacket.rotation = i;
        tXSNALPacket.codecId = i2;
        synchronized (this) {
            if (this.mNativeContext != 0 && this.mVideoDecoder == null) {
                this.mVideoDecoder = new b();
                this.mVideoDecoder.setListener(this);
                this.mVideoDecoder.setNotifyListener(this.mNotifyListener);
                this.mVideoDecoder.config(this.mSurface);
                this.mVideoDecoder.start(this.mSps, this.mPps, this.mNeedSortFrame, this.mHevc);
                notifyDecoderStartEvent(true);
            }
            if (this.mVideoDecoder != null) {
                this.mVideoDecoder.decode(tXSNALPacket);
            }
        }
    }

    private synchronized void stopHWDecoder() {
        if (this.mVideoDecoder != null) {
            this.mVideoDecoder.stop();
            this.mVideoDecoder.setListener((c) null);
            this.mVideoDecoder.setNotifyListener((WeakReference<com.tencent.liteav.basic.c.a>) null);
            this.mVideoDecoder = null;
        }
    }

    private void onStartDecoder(boolean z) {
        notifyDecoderStartEvent(z);
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        a f32080a;

        /* renamed from: b  reason: collision with root package name */
        c f32081b;

        /* renamed from: c  reason: collision with root package name */
        WeakReference<com.tencent.liteav.basic.c.a> f32082c;

        /* renamed from: d  reason: collision with root package name */
        boolean f32083d;

        /* renamed from: e  reason: collision with root package name */
        boolean f32084e;

        /* renamed from: f  reason: collision with root package name */
        Surface f32085f;

        /* renamed from: g  reason: collision with root package name */
        private ByteBuffer f32086g;
        private ByteBuffer h;

        public a(Looper looper) {
            super(looper);
        }

        public void a(boolean z, boolean z2, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, c cVar, com.tencent.liteav.basic.c.a aVar) {
            this.f32084e = z;
            this.f32083d = z2;
            this.f32085f = surface;
            this.f32086g = byteBuffer;
            this.h = byteBuffer2;
            this.f32081b = cVar;
            this.f32082c = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                    a(((Boolean) message.obj).booleanValue());
                    return;
                case 101:
                    try {
                        Bundle data = message.getData();
                        a(data.getByteArray("nal"), data.getLong("pts"), data.getLong("dts"), data.getInt("codecId"));
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                case 102:
                    b();
                    return;
                case 103:
                    boolean z = false;
                    boolean z2 = message.arg1 == 1;
                    if (message.arg2 == 1) {
                        z = true;
                    }
                    a(z2, z);
                    return;
                default:
                    return;
            }
        }

        public boolean a() {
            a aVar = this.f32080a;
            if (aVar != null) {
                return aVar.isHevc();
            }
            return false;
        }

        private void a(byte[] bArr, long j, long j2, int i) {
            TXSNALPacket tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = bArr;
            tXSNALPacket.pts = j;
            tXSNALPacket.dts = j2;
            tXSNALPacket.codecId = i;
            a aVar = this.f32080a;
            if (aVar != null) {
                aVar.decode(tXSNALPacket);
            }
        }

        private void b() {
            a aVar = this.f32080a;
            if (aVar != null) {
                aVar.stop();
                this.f32080a.setListener((c) null);
                this.f32080a.setNotifyListener((WeakReference<com.tencent.liteav.basic.c.a>) null);
                this.f32080a = null;
            }
            Looper.myLooper().quit();
            TXCLog.w(TXCVideoDecoder.TAG, "play:decode: stop decode hwdec: " + this.f32083d);
        }

        private void a(boolean z, boolean z2) {
            this.f32083d = z;
            TXCLog.w(TXCVideoDecoder.TAG, "play:decode: restart decode hwdec: " + this.f32083d);
            a aVar = this.f32080a;
            if (aVar != null) {
                aVar.stop();
                this.f32080a.setListener((c) null);
                this.f32080a.setNotifyListener((WeakReference<com.tencent.liteav.basic.c.a>) null);
                this.f32080a = null;
            }
            a(z2);
        }

        private void a(boolean z) {
            if (this.f32080a != null) {
                TXCLog.i(TXCVideoDecoder.TAG, "play:decode: start decode ignore hwdec: " + this.f32083d);
                return;
            }
            if (this.f32083d) {
                this.f32080a = new b();
            } else {
                this.f32080a = new TXCVideoFfmpegDecoder();
            }
            this.f32080a.setListener(this.f32081b);
            this.f32080a.setNotifyListener(this.f32082c);
            this.f32080a.config(this.f32085f);
            this.f32080a.start(this.f32086g, this.h, z, this.f32084e);
            TXCLog.w(TXCVideoDecoder.TAG, "play:decode: start decode hwdec: " + this.f32083d + ", hevc: " + this.f32084e);
        }
    }
}
