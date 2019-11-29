package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.appsflyer.share.Constants;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class TXCStreamUploader extends com.tencent.liteav.basic.module.a implements b {
    public static final int RTMPSENDSTRATEGY_LIVE = 1;
    public static final int RTMPSENDSTRATEGY_REALTIME_QUIC = 3;
    public static final int RTMPSENDSTRATEGY_REALTIME_TCP = 2;
    static final String TAG = "TXCStreamUploader";
    public static final int TXE_UPLOAD_MODE_AUDIO_ONLY = 1;
    public static final int TXE_UPLOAD_MODE_LINK_MIC = 2;
    public static final int TXE_UPLOAD_MODE_REAL_TIME = 0;
    public static final int TXE_UPLOAD_PROTOCOL_AV = 1;
    public static final int TXE_UPLOAD_PROTOCOL_RTMP = 0;
    private final int MSG_EVENT = 102;
    private final int MSG_RECONNECT = 101;
    private final int MSG_REPORT_STATUS = 103;
    private final int MSG_RTMPPROXY_HEARTBEAT = 104;
    /* access modifiers changed from: private */
    public boolean mAudioMuted = false;
    private int mChannelType = 0;
    private int mConnectCountQuic = 0;
    private int mConnectCountTcp = 0;
    private long mConnectSuccessTimeStamps = 0;
    private Context mContext = null;
    private int mCurrentRecordIdx = 0;
    private boolean mEnableNearestIP = true;
    private long mGoodPushTime = BaseConstants.DEFAULT_MSG_TIMEOUT;
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    private HandlerThread mHandlerThread = null;
    private c mIntelligentRoute = null;
    /* access modifiers changed from: private */
    public ArrayList<a> mIpList = null;
    private boolean mIsPushing = false;
    private int mLastNetworkType = 0;
    private long mLastTimeStamp = 0;
    private UploadStats mLastUploadStats = null;
    private WeakReference<com.tencent.liteav.basic.c.a> mNotifyListener = null;
    /* access modifiers changed from: private */
    public l mParam = null;
    /* access modifiers changed from: private */
    public boolean mQuicChannel = false;
    private int mRetryCount = 0;
    /* access modifiers changed from: private */
    public long mRtmpMsgRecvThreadInstance = 0;
    /* access modifiers changed from: private */
    public Object mRtmpMsgRecvThreadLock = new Object();
    /* access modifiers changed from: private */
    public boolean mRtmpProxyEnable = false;
    private int mRtmpProxyIPIndex = 0;
    private Vector<String> mRtmpProxyIPList = new Vector<>();
    /* access modifiers changed from: private */
    public long mRtmpProxyInstance = 0;
    /* access modifiers changed from: private */
    public Object mRtmpProxyLock = new Object();
    /* access modifiers changed from: private */
    public a mRtmpProxyParam = new a();
    /* access modifiers changed from: private */
    public String mRtmpUrl = "";
    private Thread mThread = null;
    /* access modifiers changed from: private */
    public Object mThreadLock = null;
    /* access modifiers changed from: private */
    public n mUploadQualityReport = null;
    /* access modifiers changed from: private */
    public long mUploaderInstance = 0;
    /* access modifiers changed from: private */
    public Vector<TXSNALPacket> mVecPendingNAL = new Vector<>();

    private native void nativeCacheJNIParams();

    private native void nativeEnableDrop(long j, boolean z);

    private native UploadStats nativeGetStats(long j);

    /* access modifiers changed from: private */
    public native long nativeInitRtmpMsgRecvThreadInstance(long j, long j2);

    /* access modifiers changed from: private */
    public native long nativeInitRtmpProxyInstance(long j, long j2, String str, long j3, String str2, long j4, long j5, String str3, boolean z, String str4);

    /* access modifiers changed from: private */
    public native long nativeInitUploader(String str, String str2, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8);

    /* access modifiers changed from: private */
    public native void nativeOnThreadRun(long j);

    private native void nativePushAAC(long j, byte[] bArr, long j2);

    /* access modifiers changed from: private */
    public native void nativePushNAL(long j, byte[] bArr, int i, long j2, long j3, long j4);

    private native void nativeReleaseJNIParams();

    private native void nativeRtmpMsgRecvThreadStart(long j);

    /* access modifiers changed from: private */
    public native void nativeRtmpMsgRecvThreadStop(long j);

    private native void nativeRtmpProxyEnterRoom(long j);

    private native void nativeRtmpProxyLeaveRoom(long j);

    private native void nativeRtmpProxySendHeartBeat(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11);

    private native void nativeSendRtmpProxyMsg(long j, byte[] bArr);

    private native void nativeSetSendStrategy(long j, int i, boolean z);

    /* access modifiers changed from: private */
    public native void nativeSetVideoDropParams(long j, boolean z, int i, int i2);

    private native void nativeStopPush(long j);

    /* access modifiers changed from: private */
    public native void nativeUninitRtmpMsgRecvThreadInstance(long j);

    /* access modifiers changed from: private */
    public native void nativeUninitRtmpProxyInstance(long j);

    /* access modifiers changed from: private */
    public native void nativeUninitUploader(long j);

    public int init() {
        return 0;
    }

    private class b {

        /* renamed from: a  reason: collision with root package name */
        public String f31720a = "";

        /* renamed from: b  reason: collision with root package name */
        public boolean f31721b = false;

        public b(String str, boolean z) {
            this.f31720a = str;
            this.f31721b = z;
        }
    }

    public class UploadStats {
        public long audioCacheLen;
        public long audioDropCount;
        public long channelType;
        public long connTS;
        public long connectTimeCost;
        public String connectionID;
        public String connectionStats;
        public long dnsTS;
        public long dnsparseTimeCost;
        public long handshakeTimeCost;
        public long inAudioBytes;
        public long inVideoBytes;
        public long outAudioBytes;
        public long outVideoBytes;
        public String serverIP;
        public long startTS;
        public long videoCacheLen;
        public long videoDropCount;

        public UploadStats() {
        }
    }

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f31713a;

        /* renamed from: b  reason: collision with root package name */
        public long f31714b;

        /* renamed from: c  reason: collision with root package name */
        public String f31715c;

        /* renamed from: d  reason: collision with root package name */
        public long f31716d;

        /* renamed from: e  reason: collision with root package name */
        public String f31717e;

        /* renamed from: f  reason: collision with root package name */
        public long f31718f;

        /* renamed from: g  reason: collision with root package name */
        public long f31719g;
        public String h;
        public boolean i;
        public String j;

        public a() {
        }

        public void a() {
            this.f31713a = 0;
            this.f31714b = 0;
            this.f31715c = "";
            this.f31716d = 0;
            this.f31717e = "";
            this.f31718f = 0;
            this.f31719g = 0;
            this.i = false;
            this.j = "";
        }
    }

    public class RtmpProxyUserInfo {
        public String account = "";
        public String playUrl = "";

        public RtmpProxyUserInfo() {
        }
    }

    static {
        com.tencent.liteav.basic.util.b.f();
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.mNotifyListener = new WeakReference<>(aVar);
    }

    public TXCStreamUploader(Context context, l lVar) {
        this.mContext = context;
        if (lVar == null) {
            lVar = new l();
            lVar.f31827a = 0;
            lVar.f31833g = 3;
            lVar.f31832f = 3;
            lVar.h = 40;
            lVar.i = 1000;
            lVar.j = true;
        }
        this.mParam = lVar;
        this.mThreadLock = new Object();
        this.mIntelligentRoute = new c();
        this.mIntelligentRoute.f31748a = this;
        this.mUploaderInstance = 0;
        this.mRetryCount = 0;
        this.mCurrentRecordIdx = 0;
        this.mIpList = null;
        this.mIsPushing = false;
        this.mThread = null;
        this.mRtmpUrl = null;
        this.mLastNetworkType = 0;
        this.mHandlerThread = null;
        this.mUploadQualityReport = new n(context);
        m.a().a(context);
    }

    public void setRetryInterval(int i) {
        l lVar = this.mParam;
        if (lVar != null) {
            lVar.f31833g = i;
        }
    }

    public void setAudioInfo(int i, int i2) {
        l lVar = this.mParam;
        if (lVar != null) {
            lVar.f31830d = i2;
            lVar.f31831e = i;
        }
    }

    public void setRetryTimes(int i) {
        l lVar = this.mParam;
        if (lVar != null) {
            lVar.f31832f = i;
        }
    }

    public void setMode(int i) {
        l lVar = this.mParam;
        if (lVar != null) {
            lVar.f31827a = i;
        }
    }

    private void postReconnectMsg(String str, boolean z, int i) {
        Message message = new Message();
        message.what = 101;
        message.obj = str;
        message.arg1 = z ? 2 : 1;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessageDelayed(message, (long) i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFetchDone(int r5, java.util.ArrayList<com.tencent.liteav.network.a> r6) {
        /*
            r4 = this;
            boolean r0 = r4.mIsPushing
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            if (r6 == 0) goto L_0x0035
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onFetchDone: code = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ip count = "
            r1.append(r2)
            int r2 = r6.size()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TXCStreamUploader"
            com.tencent.liteav.basic.log.TXCLog.e(r2, r1)
            if (r5 != 0) goto L_0x0035
            r4.mIpList = r6
            int r5 = r6.size()
            r4.mCurrentRecordIdx = r0
            goto L_0x0036
        L_0x0035:
            r5 = 0
        L_0x0036:
            if (r5 <= 0) goto L_0x00ae
            java.util.ArrayList<com.tencent.liteav.network.a> r5 = r4.mIpList
            java.util.Iterator r5 = r5.iterator()
            java.lang.String r6 = ""
            r1 = r6
            r6 = 0
        L_0x0042:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0089
            java.lang.Object r2 = r5.next()
            com.tencent.liteav.network.a r2 = (com.tencent.liteav.network.a) r2
            if (r2 == 0) goto L_0x0062
            boolean r3 = r2.f31725c
            if (r3 == 0) goto L_0x0062
            java.lang.String r3 = r2.f31723a
            if (r3 == 0) goto L_0x0062
            java.lang.String r3 = r2.f31723a
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0062
            int r6 = r6 + 1
        L_0x0062:
            if (r2 == 0) goto L_0x0042
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " "
            r3.append(r1)
            java.lang.String r1 = r2.f31723a
            java.lang.String r1 = r4.getConfusionIP(r1)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            java.lang.String r1 = r2.f31724b
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            goto L_0x0042
        L_0x0089:
            r5 = 7016(0x1b68, float:9.832E-42)
            long r2 = (long) r6
            java.lang.Long r6 = java.lang.Long.valueOf(r2)
            r4.setStatusValue(r5, r6)
            r5 = 7019(0x1b6b, float:9.836E-42)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "{"
            r6.append(r2)
            r6.append(r1)
            java.lang.String r1 = " }"
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r4.setStatusValue(r5, r6)
        L_0x00ae:
            com.tencent.liteav.network.TXCStreamUploader$b r5 = r4.getRtmpRealConnectInfo()
            java.lang.String r6 = r5.f31720a
            boolean r5 = r5.f31721b
            r4.postReconnectMsg(r6, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.TXCStreamUploader.onFetchDone(int, java.util.ArrayList):void");
    }

    public String getConfusionIP(String str) {
        if (str == null) {
            return str;
        }
        int indexOf = str.indexOf(".");
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(indexOf + 1);
        int indexOf2 = substring.indexOf(".");
        if (indexOf2 == -1) {
            return str;
        }
        String substring2 = substring.substring(indexOf2 + 1);
        return "A.B." + substring2;
    }

    public String start(String str, boolean z, int i) {
        if (this.mIsPushing) {
            return this.mRtmpUrl;
        }
        this.mIsPushing = true;
        this.mConnectSuccessTimeStamps = 0;
        this.mRetryCount = 0;
        this.mRtmpUrl = str;
        this.mChannelType = i;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mRtmpProxyEnable = false;
        this.mRtmpProxyParam.a();
        this.mRtmpProxyIPList.clear();
        this.mRtmpProxyIPIndex = 0;
        this.mRtmpProxyInstance = 0;
        this.mRtmpMsgRecvThreadInstance = 0;
        setStatusValue(7016, 0L);
        setStatusValue(7017, 0L);
        setStatusValue(7018, 0L);
        this.mUploadQualityReport.a();
        StringBuilder sb = new StringBuilder();
        sb.append("start push with url:");
        sb.append(this.mRtmpUrl);
        sb.append(" enable nearest ip:");
        sb.append(z ? "yes" : "no");
        sb.append("channel type:");
        sb.append(i);
        TXCLog.d(TAG, sb.toString());
        if (com.tencent.liteav.basic.util.b.d(this.mContext) == 0) {
            sendNotifyEvent(TXLiteAVCode.ERR_RTMP_PUSH_NO_NETWORK);
            return this.mRtmpUrl;
        }
        this.mEnableNearestIP = z;
        if (this.mHandlerThread == null) {
            this.mHandlerThread = new HandlerThread("RTMP_PUSH");
            this.mHandlerThread.start();
        }
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 101) {
                    TXCStreamUploader.this.startPushTask((String) message.obj, message.arg1 == 2, 0);
                } else if (i == 103) {
                    TXCStreamUploader.this.reportNetStatus();
                } else if (i == 104) {
                    TXCStreamUploader.this.rtmpProxySendHeartBeat();
                    if (TXCStreamUploader.this.mHandler != null) {
                        TXCStreamUploader.this.mHandler.sendEmptyMessageDelayed(104, 2000);
                    }
                }
            }
        };
        parseProxyInfo(str);
        if (this.mRtmpProxyEnable) {
            this.mLastNetworkType = com.tencent.liteav.basic.util.b.d(this.mContext);
            nativeCacheJNIParams();
            startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        } else if (!this.mEnableNearestIP || this.mLastNetworkType == com.tencent.liteav.basic.util.b.d(this.mContext)) {
            startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
        } else {
            TXCLog.d(TAG, "fetching nearest ip list");
            this.mLastNetworkType = com.tencent.liteav.basic.util.b.d(this.mContext);
            this.mIntelligentRoute.a(str, i);
        }
        this.mHandler.sendEmptyMessageDelayed(103, 2000);
        return this.mRtmpUrl;
    }

    public void stop() {
        if (this.mIsPushing) {
            this.mIsPushing = false;
            TXCLog.d(TAG, "stop push");
            if (this.mRtmpProxyEnable) {
                synchronized (this.mRtmpProxyLock) {
                    nativeRtmpProxyLeaveRoom(this.mRtmpProxyInstance);
                }
            }
            synchronized (this.mThreadLock) {
                nativeStopPush(this.mUploaderInstance);
            }
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.getLooper().quit();
                this.mHandlerThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
            if (this.mRtmpProxyEnable) {
                nativeReleaseJNIParams();
            }
            this.mUploadQualityReport.c();
            this.mUploadQualityReport.a();
        }
    }

    private void tryResetRetryCount() {
        if (this.mConnectSuccessTimeStamps != 0 && TXCTimeUtil.getTimeTick() - this.mConnectSuccessTimeStamps > ((long) (this.mParam.f31832f * (this.mParam.f31833g + 13) * 1000))) {
            this.mRetryCount = 0;
            this.mConnectSuccessTimeStamps = 0;
            TXCLog.d(TAG, "reset retry count");
        }
    }

    public void pushAAC(byte[] bArr, long j) {
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            if (!this.mAudioMuted || !this.mRtmpProxyEnable) {
                nativePushAAC(this.mUploaderInstance, bArr, j);
            }
        }
    }

    public void pushNAL(TXSNALPacket tXSNALPacket) {
        tryResetRetryCount();
        synchronized (this.mThreadLock) {
            if (this.mUploaderInstance == 0) {
                if (tXSNALPacket.nalType == 0) {
                    this.mVecPendingNAL.removeAllElements();
                }
                this.mVecPendingNAL.add(tXSNALPacket);
            } else if (!(tXSNALPacket == null || tXSNALPacket.nalData == null || tXSNALPacket.nalData.length <= 0)) {
                nativePushNAL(this.mUploaderInstance, tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.frameIndex, tXSNALPacket.pts, tXSNALPacket.dts);
            }
        }
    }

    public void setAudioMute(boolean z) {
        synchronized (this.mThreadLock) {
            this.mAudioMuted = z;
            if (this.mRtmpProxyEnable && this.mUploaderInstance != 0) {
                nativeSetSendStrategy(this.mUploaderInstance, this.mParam.m ? this.mQuicChannel ? 3 : 2 : 1, false);
            }
        }
    }

    public void setDropEanble(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("drop enable ");
        sb.append(z ? "yes" : "no");
        TXCLog.d(TAG, sb.toString());
        synchronized (this.mThreadLock) {
            nativeEnableDrop(this.mUploaderInstance, z);
        }
    }

    public void setVideoDropParams(boolean z, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("drop params wait i frame:");
        sb.append(z ? "yes" : "no");
        sb.append(" max video count:");
        sb.append(i);
        sb.append(" max video cache time: ");
        sb.append(i2);
        sb.append(" ms");
        TXCLog.d(TAG, sb.toString());
        synchronized (this.mThreadLock) {
            this.mParam.j = z;
            this.mParam.h = i;
            this.mParam.i = i2;
            if (this.mUploaderInstance != 0) {
                nativeSetVideoDropParams(this.mUploaderInstance, this.mParam.j, this.mParam.h, this.mParam.i);
            }
        }
    }

    public void setSendStrategy(boolean z, boolean z2) {
        l lVar = this.mParam;
        lVar.m = z;
        lVar.n = z2;
        this.mUploadQualityReport.a(z);
        int i = z ? this.mQuicChannel ? 3 : 2 : 1;
        if (!this.mRtmpProxyEnable) {
            ArrayList<a> arrayList = this.mIpList;
            if (arrayList == null || arrayList.size() == 0) {
                i = 1;
            }
        }
        synchronized (this.mThreadLock) {
            if (this.mUploaderInstance != 0) {
                nativeSetSendStrategy(this.mUploaderInstance, i, z2);
            }
        }
        setStatusValue(7020, Long.valueOf((long) i));
    }

    public UploadStats getUploadStats() {
        UploadStats nativeGetStats;
        synchronized (this.mThreadLock) {
            nativeGetStats = nativeGetStats(this.mUploaderInstance);
            if (nativeGetStats != null) {
                nativeGetStats.channelType = this.mQuicChannel ? 2 : 1;
            }
        }
        return nativeGetStats;
    }

    /* access modifiers changed from: private */
    public void startPushTask(final String str, final boolean z, int i) {
        TXCLog.d(TAG, "start push task");
        boolean z2 = this.mQuicChannel;
        if (z2 != z && z2) {
            String str2 = this.mRtmpUrl;
            TXCEventRecorderProxy.a(str2, 91005, -1, -1, "switch video push channel from quic to tcp(limits:" + this.mParam.f31832f + " current:" + this.mRetryCount + SQLBuilder.PARENTHESES_RIGHT, 0);
        }
        if (z) {
            int i2 = this.mConnectCountQuic + 1;
            this.mConnectCountQuic = i2;
            setStatusValue(7017, Long.valueOf((long) i2));
        } else {
            int i3 = this.mConnectCountTcp + 1;
            this.mConnectCountTcp = i3;
            setStatusValue(7018, Long.valueOf((long) i3));
        }
        this.mThread = new Thread("RTMPUpload") {
            public void run() {
                while (TXCStreamUploader.this.mUploaderInstance != 0) {
                    try {
                        sleep(100, 0);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                TXCStreamUploader.this.mUploadQualityReport.b();
                TXCStreamUploader.this.mUploadQualityReport.a(TXCStreamUploader.this.mParam.m);
                TXCStreamUploader.this.mUploadQualityReport.a(TXCStreamUploader.this.mRtmpUrl);
                TXCStreamUploader.this.mUploadQualityReport.a(z, TXCStreamUploader.this.getAddressFromUrl(str));
                synchronized (TXCStreamUploader.this.mThreadLock) {
                    boolean unused = TXCStreamUploader.this.mQuicChannel = z;
                    int i = TXCStreamUploader.this.mParam.m ? TXCStreamUploader.this.mQuicChannel ? 3 : 2 : 1;
                    if (!TXCStreamUploader.this.mRtmpProxyEnable) {
                        if (TXCStreamUploader.this.mIpList == null || TXCStreamUploader.this.mIpList.size() == 0) {
                            i = 1;
                        }
                    } else if (TXCStreamUploader.this.mAudioMuted) {
                        TXCStreamUploader.this.mParam.n = false;
                    }
                    TXCStreamUploader.this.setStatusValue(7020, Long.valueOf((long) i));
                    long unused2 = TXCStreamUploader.this.mUploaderInstance = TXCStreamUploader.this.nativeInitUploader(TXCStreamUploader.this.mRtmpUrl, str, z, TXCStreamUploader.this.mParam.f31831e, TXCStreamUploader.this.mParam.f31830d, TXCStreamUploader.this.mParam.f31827a, TXCStreamUploader.this.mParam.f31829c, TXCStreamUploader.this.mParam.h, 16, i, TXCStreamUploader.this.mParam.n, TXCStreamUploader.this.mParam.o);
                    if (TXCStreamUploader.this.mUploaderInstance != 0) {
                        TXCStreamUploader.this.nativeSetVideoDropParams(TXCStreamUploader.this.mUploaderInstance, TXCStreamUploader.this.mParam.j, TXCStreamUploader.this.mParam.h, TXCStreamUploader.this.mParam.i);
                        Iterator it = TXCStreamUploader.this.mVecPendingNAL.iterator();
                        boolean z = false;
                        while (it.hasNext()) {
                            TXSNALPacket tXSNALPacket = (TXSNALPacket) it.next();
                            if (!z && tXSNALPacket.nalType == 0) {
                                z = true;
                            }
                            if (z) {
                                TXCStreamUploader.this.nativePushNAL(TXCStreamUploader.this.mUploaderInstance, tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.frameIndex, tXSNALPacket.pts, tXSNALPacket.dts);
                            }
                        }
                        TXCStreamUploader.this.mVecPendingNAL.removeAllElements();
                    }
                }
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock) {
                        long unused3 = TXCStreamUploader.this.mRtmpProxyInstance = TXCStreamUploader.this.nativeInitRtmpProxyInstance(TXCStreamUploader.this.mRtmpProxyParam.f31713a, TXCStreamUploader.this.mRtmpProxyParam.f31714b, TXCStreamUploader.this.mRtmpProxyParam.f31715c, TXCStreamUploader.this.mRtmpProxyParam.f31716d, TXCStreamUploader.this.mRtmpProxyParam.f31717e, TXCStreamUploader.this.mRtmpProxyParam.f31718f, TXCStreamUploader.this.mRtmpProxyParam.f31719g, TXCStreamUploader.this.mRtmpProxyParam.h, TXCStreamUploader.this.mRtmpProxyParam.i, TXCStreamUploader.this.mRtmpProxyParam.j);
                    }
                    synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock) {
                        long unused4 = TXCStreamUploader.this.mRtmpMsgRecvThreadInstance = TXCStreamUploader.this.nativeInitRtmpMsgRecvThreadInstance(TXCStreamUploader.this.mRtmpProxyInstance, TXCStreamUploader.this.mUploaderInstance);
                    }
                }
                TXCStreamUploader tXCStreamUploader = TXCStreamUploader.this;
                tXCStreamUploader.nativeOnThreadRun(tXCStreamUploader.mUploaderInstance);
                if (TXCStreamUploader.this.mRtmpProxyEnable) {
                    synchronized (TXCStreamUploader.this.mRtmpMsgRecvThreadLock) {
                        TXCStreamUploader.this.nativeRtmpMsgRecvThreadStop(TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                        TXCStreamUploader.this.nativeUninitRtmpMsgRecvThreadInstance(TXCStreamUploader.this.mRtmpMsgRecvThreadInstance);
                        long unused5 = TXCStreamUploader.this.mRtmpMsgRecvThreadInstance = 0;
                    }
                    synchronized (TXCStreamUploader.this.mRtmpProxyLock) {
                        TXCStreamUploader.this.nativeUninitRtmpProxyInstance(TXCStreamUploader.this.mRtmpProxyInstance);
                        long unused6 = TXCStreamUploader.this.mRtmpProxyInstance = 0;
                    }
                }
                synchronized (TXCStreamUploader.this.mThreadLock) {
                    TXCStreamUploader.this.nativeUninitUploader(TXCStreamUploader.this.mUploaderInstance);
                    long unused7 = TXCStreamUploader.this.mUploaderInstance = 0;
                }
            }
        };
        this.mThread.start();
    }

    private void stopPushTask() {
        TXCLog.d(TAG, "stop push task");
        synchronized (this.mThreadLock) {
            this.mVecPendingNAL.removeAllElements();
            nativeStopPush(this.mUploaderInstance);
        }
    }

    private b getRtmpRealConnectInfo() {
        if (!this.mEnableNearestIP) {
            return new b(this.mRtmpUrl, false);
        }
        ArrayList<a> arrayList = this.mIpList;
        if (arrayList == null) {
            return new b(this.mRtmpUrl, false);
        }
        if (this.mCurrentRecordIdx < arrayList.size()) {
            int i = this.mCurrentRecordIdx;
            if (i >= 0) {
                a aVar = this.mIpList.get(i);
                String[] split = this.mRtmpUrl.split("://");
                if (split.length < 2) {
                    return new b(this.mRtmpUrl, false);
                }
                String[] split2 = split[1].split(Constants.URL_PATH_DELIMITER);
                split2[0] = aVar.f31723a + ":" + aVar.f31724b;
                StringBuilder sb = new StringBuilder(split2[0]);
                for (int i2 = 1; i2 < split2.length; i2++) {
                    sb.append(Constants.URL_PATH_DELIMITER);
                    sb.append(split2[i2]);
                }
                return new b(split[0] + "://" + sb.toString(), aVar.f31725c);
            }
        }
        return new b(this.mRtmpUrl, false);
    }

    private boolean nextRecordIdx(boolean z) {
        ArrayList<a> arrayList = this.mIpList;
        if (!(arrayList == null || arrayList.size() == 0)) {
            if (z) {
                this.mIpList.get(this.mCurrentRecordIdx).f31727e++;
            }
            if (this.mCurrentRecordIdx + 1 < this.mIpList.size()) {
                this.mCurrentRecordIdx++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public String getAddressFromUrl(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf("://");
        if (indexOf == -1) {
            return "";
        }
        String substring = str.substring(indexOf + 3);
        int indexOf2 = substring.indexOf(Constants.URL_PATH_DELIMITER);
        return indexOf2 != -1 ? substring.substring(0, indexOf2) : "";
    }

    private void reconnect(final boolean z) {
        stopPushTask();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    TXCStreamUploader.this.internalReconnect(z);
                }
            }, (long) (this.mParam.f31833g * 1000));
        }
    }

    /* access modifiers changed from: private */
    public void internalReconnect(boolean z) {
        if (this.mIsPushing) {
            if (!this.mRtmpProxyEnable) {
                this.mUploadQualityReport.c();
                if (!this.mEnableNearestIP || this.mLastNetworkType == com.tencent.liteav.basic.util.b.d(this.mContext)) {
                    boolean z2 = !this.mEnableNearestIP ? false : z;
                    if (this.mQuicChannel) {
                        z2 = true;
                    }
                    if (z2 && !nextRecordIdx(true)) {
                        TXCLog.e(TAG, "reconnect: try all addresses failed");
                        TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1, -1, "connect upload server failed(try all addresses failed)", 0);
                    }
                    b rtmpRealConnectInfo = getRtmpRealConnectInfo();
                    String addressFromUrl = getAddressFromUrl(rtmpRealConnectInfo.f31720a);
                    StringBuilder sb = new StringBuilder();
                    sb.append("reconnect change ip: ");
                    sb.append(addressFromUrl);
                    sb.append(" enableNearestIP: ");
                    sb.append(this.mEnableNearestIP);
                    sb.append(" last channel type: ");
                    sb.append(this.mQuicChannel ? "Q Channel" : "TCP");
                    TXCLog.e(TAG, sb.toString());
                    if (this.mQuicChannel) {
                        TXCLog.e(TAG, "reconnect last channel type is Q Channel，ignore retry limit");
                        TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1, -1, "reconnect upload server:" + addressFromUrl + "(last channel type is Q Channel)", 0);
                        startPushTask(rtmpRealConnectInfo.f31720a, rtmpRealConnectInfo.f31721b, 0);
                        sendNotifyEvent(1102);
                        return;
                    }
                    TXCLog.e(TAG, "reconnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f31832f);
                    if (this.mRetryCount < this.mParam.f31832f) {
                        this.mRetryCount++;
                        TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1, -1, "reconnect upload server:(retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f31832f + SQLBuilder.PARENTHESES_RIGHT, 0);
                        startPushTask(rtmpRealConnectInfo.f31720a, rtmpRealConnectInfo.f31721b, 0);
                        sendNotifyEvent(1102);
                        return;
                    }
                    TXCLog.e(TAG, "reconnect: try all times failed");
                    TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1, -1, "connect upload server failed(try all times failed)", 0);
                    sendNotifyEvent(TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL);
                    return;
                }
                TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.b.d(this.mContext));
                this.mLastNetworkType = com.tencent.liteav.basic.util.b.d(this.mContext);
                this.mIntelligentRoute.a(this.mRtmpUrl, this.mChannelType);
                this.mRetryCount = 0;
            } else if (this.mLastNetworkType != com.tencent.liteav.basic.util.b.d(this.mContext)) {
                TXCLog.e(TAG, "reconnect network switch from " + this.mLastNetworkType + " to " + com.tencent.liteav.basic.util.b.d(this.mContext));
                this.mLastNetworkType = com.tencent.liteav.basic.util.b.d(this.mContext);
                this.mRetryCount = 0;
                sendNotifyEvent(1021, String.format("网络类型发生变化，需要重新进房", new Object[0]));
            } else if (this.mRetryCount < this.mParam.f31832f) {
                this.mRetryCount++;
                TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1, -1, "reconnect rtmp-proxy server(econnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f31832f + SQLBuilder.PARENTHESES_RIGHT, 0);
                sendNotifyEvent(1102);
                startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            } else if (getNextRtmpProxyIP()) {
                this.mRetryCount = 0;
                TXCEventRecorderProxy.a(this.mRtmpUrl, 91003, -1, -1, "reconnect rtmp-proxy server(econnect retry count:" + this.mRetryCount + " retry limit:" + this.mParam.f31832f + SQLBuilder.PARENTHESES_RIGHT, 0);
                sendNotifyEvent(1102);
                startPushTask(this.mRtmpUrl, this.mQuicChannel, 0);
            } else {
                TXCEventRecorderProxy.a(this.mRtmpUrl, 91002, -1, -1, "connect rtmp-proxy server failed(try all addresses)", 0);
                sendNotifyEvent(TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL);
            }
        }
    }

    private void sendNotifyEvent(int i, String str) {
        if (str == null || str.isEmpty()) {
            sendNotifyEvent(i);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            com.tencent.liteav.basic.util.b.a(this.mNotifyListener, i, bundle);
        }
        if (i == 1002) {
            UploadStats uploadStats = getUploadStats();
            if (uploadStats != null) {
                this.mUploadQualityReport.a(uploadStats.dnsparseTimeCost, uploadStats.connectTimeCost, uploadStats.handshakeTimeCost);
            }
        } else if (i == 1101) {
            this.mUploadQualityReport.d();
        }
    }

    private void sendNotifyEvent(int i) {
        if (i == 0) {
            reconnect(false);
        } else if (i == 1) {
            reconnect(true);
        } else {
            if (i == 1001) {
                this.mConnectSuccessTimeStamps = TXCTimeUtil.getTimeTick();
            }
            if (i == 1026) {
                if (this.mRtmpProxyEnable) {
                    synchronized (this.mRtmpMsgRecvThreadLock) {
                        nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
                    }
                    synchronized (this.mRtmpProxyLock) {
                        nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                    }
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(104, 2000);
                    }
                }
            } else if (this.mNotifyListener != null) {
                Bundle bundle = new Bundle();
                if (i == -2308) {
                    bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "服务器拒绝连接请求，可能是该推流地址已经被占用或过期，或者防盗链错误");
                } else if (i == -1307) {
                    bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "经连续多次重连失败，放弃重连");
                } else if (i != 1026) {
                    if (i == 3003) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP服务器握手失败");
                    } else if (i == -1325) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "没有网络，请检测WiFi或移动数据是否开启");
                    } else if (i == -1324) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "所有IP都已经尝试失败,可以放弃治疗");
                    } else if (i == 1001) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "已经连接rtmp服务器");
                    } else if (i == 1002) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "rtmp开始推流");
                    } else if (i == 1101) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "上行带宽不足，数据发送不及时");
                    } else if (i == 1102) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "启动网络重连");
                    } else if (i == 3008) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "超过30s没有数据发送，主动断开连接");
                    } else if (i != 3009) {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN");
                    } else {
                        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                    }
                } else if (this.mRtmpProxyEnable) {
                    synchronized (this.mRtmpMsgRecvThreadLock) {
                        nativeRtmpMsgRecvThreadStart(this.mRtmpMsgRecvThreadInstance);
                    }
                    synchronized (this.mRtmpProxyLock) {
                        nativeRtmpProxyEnterRoom(this.mRtmpProxyInstance);
                    }
                    Handler handler2 = this.mHandler;
                    if (handler2 != null) {
                        handler2.sendEmptyMessageDelayed(104, 2000);
                        return;
                    }
                    return;
                } else {
                    return;
                }
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                com.tencent.liteav.basic.util.b.a(this.mNotifyListener, i, bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reportNetStatus() {
        long j;
        long j2;
        long j3;
        long timeTick = TXCTimeUtil.getTimeTick();
        long j4 = timeTick - this.mLastTimeStamp;
        UploadStats uploadStats = getUploadStats();
        if (uploadStats != null) {
            UploadStats uploadStats2 = this.mLastUploadStats;
            long j5 = 0;
            if (uploadStats2 != null) {
                long j6 = j4;
                long longValue = getSpeed(uploadStats2.inVideoBytes, uploadStats.inVideoBytes, j6).longValue();
                j2 = getSpeed(this.mLastUploadStats.inAudioBytes, uploadStats.inAudioBytes, j6).longValue();
                j = getSpeed(this.mLastUploadStats.outVideoBytes, uploadStats.outVideoBytes, j6).longValue();
                j3 = getSpeed(this.mLastUploadStats.outAudioBytes, uploadStats.outAudioBytes, j6).longValue();
                j5 = longValue;
            } else {
                j3 = 0;
                j2 = 0;
                j = 0;
            }
            setStatusValue(7001, Long.valueOf(j5));
            setStatusValue(7002, Long.valueOf(j2));
            setStatusValue(7003, Long.valueOf(j));
            setStatusValue(7004, Long.valueOf(j3));
            setStatusValue(7005, Long.valueOf(uploadStats.videoCacheLen));
            setStatusValue(7006, Long.valueOf(uploadStats.audioCacheLen));
            setStatusValue(7007, Long.valueOf(uploadStats.videoDropCount));
            setStatusValue(7008, Long.valueOf(uploadStats.audioDropCount));
            setStatusValue(7009, Long.valueOf(uploadStats.startTS));
            setStatusValue(7010, Long.valueOf(uploadStats.dnsTS));
            setStatusValue(7011, Long.valueOf(uploadStats.connTS));
            setStatusValue(7012, String.valueOf(uploadStats.serverIP));
            setStatusValue(7013, Long.valueOf(this.mQuicChannel ? 2 : 1));
            setStatusValue(7014, uploadStats.connectionID);
            setStatusValue(7015, uploadStats.connectionStats);
            this.mUploadQualityReport.a(uploadStats.videoDropCount, uploadStats.audioDropCount);
            this.mUploadQualityReport.b(uploadStats.videoCacheLen, uploadStats.audioCacheLen);
        }
        this.mLastTimeStamp = timeTick;
        this.mLastUploadStats = uploadStats;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(103, 2000);
        }
    }

    private Long getSpeed(long j, long j2, long j3) {
        if (j <= j2) {
            j2 -= j;
        }
        long j4 = 0;
        if (j3 > 0) {
            j4 = ((j2 * 8) * 1000) / (j3 * IjkMediaMeta.AV_CH_SIDE_RIGHT);
        }
        return Long.valueOf(j4);
    }

    private boolean isQCloudStreamUrl(String str) {
        if (!(str == null || str.length() == 0)) {
            int indexOf = str.indexOf("://");
            if (indexOf != -1) {
                String substring = str.substring(indexOf + 3);
                if (substring == null || !substring.startsWith("cloud.tencent.com")) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    private void parseProxyInfo(String str) {
        String str2 = str;
        if (str2 != null && str.length() != 0 && str2.startsWith("room")) {
            this.mRtmpProxyParam.i = isQCloudStreamUrl(str);
            HashMap paramsFromUrl = getParamsFromUrl(str);
            if (paramsFromUrl != null) {
                if (paramsFromUrl.containsKey("sdkappid")) {
                    this.mRtmpProxyParam.f31713a = Long.valueOf((String) paramsFromUrl.get("sdkappid")).longValue();
                }
                if (paramsFromUrl.containsKey("roomid") && paramsFromUrl.containsKey("userid") && paramsFromUrl.containsKey("roomsig")) {
                    this.mRtmpProxyParam.f31716d = Long.valueOf((String) paramsFromUrl.get("roomid")).longValue();
                    this.mRtmpProxyParam.f31715c = (String) paramsFromUrl.get("userid");
                    if (paramsFromUrl.containsKey("bizbuf")) {
                        try {
                            this.mRtmpProxyParam.j = URLDecoder.decode((String) paramsFromUrl.get("bizbuf"), "UTF-8");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(URLDecoder.decode((String) paramsFromUrl.get("roomsig"), "UTF-8"));
                        this.mRtmpProxyParam.f31714b = 0;
                        if (jSONObject.has("Key")) {
                            this.mRtmpProxyParam.f31717e = jSONObject.optString("Key");
                            JSONObject optJSONObject = jSONObject.optJSONObject("RtmpProxy");
                            if (optJSONObject != null) {
                                if (!optJSONObject.has("Ip") || !optJSONObject.has("Port") || !optJSONObject.has("Type")) {
                                    return;
                                }
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray("AccessList");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                    if (jSONObject2 != null && jSONObject2.has("Ip") && jSONObject2.has("Port")) {
                                        if (jSONObject2.has("Type")) {
                                            String optString = jSONObject2.optString("Ip");
                                            long optLong = jSONObject2.optLong("Port");
                                            if (jSONObject2.optLong("Type") == 2) {
                                                this.mRtmpProxyIPList.add(optString + ":" + optLong);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!this.mRtmpProxyParam.i) {
                                this.mRtmpUrl = str2;
                                this.mQuicChannel = false;
                            } else if (optJSONObject != null) {
                                this.mRtmpUrl = str2.substring(0, str2.indexOf("?")) + "/webrtc/" + (this.mRtmpProxyParam.f31713a + "_" + this.mRtmpProxyParam.f31716d + "_" + this.mRtmpProxyParam.f31715c) + "?real_rtmp_ip=" + optJSONObject.optString("Ip") + "&real_rtmp_port=" + optJSONObject.optLong("Port") + "&tinyid=" + this.mRtmpProxyParam.f31714b + "&srctinyid=0";
                                getNextRtmpProxyIP();
                            } else {
                                return;
                            }
                            this.mRtmpProxyEnable = true;
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    private HashMap getParamsFromUrl(String str) {
        HashMap hashMap = new HashMap();
        String[] split = str.split("[?]");
        if (!(split == null || split.length < 2 || split[1] == null || split[1].length() == 0)) {
            for (String str2 : split[1].split("[&]")) {
                if (str2.indexOf(SimpleComparison.EQUAL_TO_OPERATION) != -1) {
                    String[] split2 = str2.split("[=]");
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
            }
        }
        return hashMap;
    }

    private boolean getNextRtmpProxyIP() {
        a aVar = this.mRtmpProxyParam;
        aVar.f31718f = 234;
        aVar.f31719g = 80;
        Vector<String> vector = this.mRtmpProxyIPList;
        if (vector == null || vector.size() <= 0) {
            return false;
        }
        if (this.mRtmpProxyIPIndex >= this.mRtmpProxyIPList.size()) {
            this.mRtmpProxyIPIndex = 0;
            return false;
        }
        String[] split = this.mRtmpUrl.split("://");
        if (split.length < 2) {
            return false;
        }
        String substring = split[1].substring(split[1].indexOf(Constants.URL_PATH_DELIMITER));
        String str = this.mRtmpProxyIPList.get(this.mRtmpProxyIPIndex);
        this.mRtmpProxyParam.h = str;
        this.mRtmpUrl = "room://" + str + substring;
        this.mQuicChannel = true;
        this.mRtmpProxyIPIndex = this.mRtmpProxyIPIndex + 1;
        return true;
    }

    /* access modifiers changed from: private */
    public void rtmpProxySendHeartBeat() {
        Object obj;
        int[] a2 = com.tencent.liteav.basic.util.b.a();
        long j = (long) (a2[0] / 10);
        long j2 = (long) (a2[1] / 10);
        long c2 = (long) TXCStatus.c(getID(), 7004);
        long c3 = (long) TXCStatus.c(getID(), 7003);
        long c4 = (long) TXCStatus.c(getID(), 1001);
        long c5 = (long) TXCStatus.c(getID(), 4001);
        long c6 = (long) TXCStatus.c(getID(), 7006);
        long c7 = (long) TXCStatus.c(getID(), 7005);
        long c8 = (long) TXCStatus.c(getID(), 7008);
        long c9 = (long) TXCStatus.c(getID(), 7007);
        Object obj2 = this.mRtmpProxyLock;
        synchronized (obj2) {
            try {
                obj = obj2;
                nativeRtmpProxySendHeartBeat(this.mRtmpProxyInstance, j, j2, c2, c3, c4, c5, c6, c7, c8, c9);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    private void onSendRtmpProxyMsg(byte[] bArr) {
        synchronized (this.mThreadLock) {
            if (this.mUploaderInstance != 0) {
                nativeSendRtmpProxyMsg(this.mUploaderInstance, bArr);
            }
        }
    }

    private void onRtmpProxyUserListPushed(RtmpProxyUserInfo[] rtmpProxyUserInfoArr) {
        if (rtmpProxyUserInfoArr != null && this.mIsPushing && this.mRtmpProxyEnable && this.mRtmpProxyParam != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < rtmpProxyUserInfoArr.length; i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("userid", rtmpProxyUserInfoArr[i].account);
                    jSONObject.put("playurl", rtmpProxyUserInfoArr[i].playUrl);
                    jSONArray.put(i, jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("userlist", jSONArray);
                sendNotifyEvent(1020, jSONObject2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onRtmpProxyRoomEvent(int i, int i2) {
        if (i == 1) {
            sendNotifyEvent(1018, String.format("已在房间中，[%d]", new Object[]{Integer.valueOf(i2)}));
        } else if (i == 2) {
            sendNotifyEvent(1019, String.format("不在房间中，[%d]", new Object[]{Integer.valueOf(i2)}));
        }
    }
}
