package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.d;
import com.tencent.liteav.network.k;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class TXCStreamDownloader extends com.tencent.liteav.basic.module.a implements com.tencent.liteav.basic.c.a, TXIStreamDownloader.a, d.a, h {
    public static final String TAG = "TXCStreamDownloader";
    /* access modifiers changed from: private */
    public k mAccUrlFetcher;
    /* access modifiers changed from: private */
    public Context mApplicationContext;
    /* access modifiers changed from: private */
    public int mChannelType = 0;
    private long mCurrentNalTs = 0;
    private int mDownloadFormat = 1;
    /* access modifiers changed from: private */
    public TXIStreamDownloader mDownloader = null;
    /* access modifiers changed from: private */
    public boolean mDownloaderRunning = false;
    /* access modifiers changed from: private */
    public boolean mEnableMessage = false;
    /* access modifiers changed from: private */
    public boolean mEnableNearestIP = false;
    /* access modifiers changed from: private */
    public Handler mHandler = null;
    protected Map<String, String> mHeaders;
    private DownloadStats mLastDownloadStats = null;
    private long mLastIFramelTs = 0;
    private long mLastTimeStamp = 0;
    private h mListener = null;
    private byte[] mListenerLock = new byte[0];
    private com.tencent.liteav.basic.c.a mNotifyListener = null;
    /* access modifiers changed from: private */
    public String mOriginPlayUrl = "";
    private boolean mRecvFirstNal = false;
    /* access modifiers changed from: private */
    public Runnable mReportNetStatusRunnalbe = new Runnable() {
        public void run() {
            TXCStreamDownloader.this.reportNetStatus();
        }
    };
    private d mStreamSwitcher = null;
    private long mSwitchStartTime = 0;

    public static class DownloadStats {
        public long afterParseAudioBytes;
        public long afterParseVideoBytes;
        public long beforeParseAudioBytes;
        public long beforeParseVideoBytes;
        public long connTS;
        public long dnsTS;
        public long firstAudioTS;
        public long firstVideoTS;
        public String serverIP;
        public long startTS;
        public long videoGop;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f31701a;

        /* renamed from: b  reason: collision with root package name */
        public String f31702b;

        /* renamed from: c  reason: collision with root package name */
        public String f31703c;

        /* renamed from: d  reason: collision with root package name */
        public int f31704d;

        /* renamed from: e  reason: collision with root package name */
        public String f31705e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31706f;
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        synchronized (this.mListenerLock) {
            if (this.mNotifyListener != null) {
                Bundle bundle2 = new Bundle();
                if (i == -2308) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "服务器拒绝连接请求");
                } else if (i == 2012) {
                    byte[] byteArray = bundle.getByteArray(TXLiveConstants.EVT_GET_MSG);
                    if (byteArray != null && byteArray.length > 0) {
                        bundle2.putByteArray(TXLiveConstants.EVT_GET_MSG, byteArray);
                    }
                } else if (i == 2103) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "启动网络重连");
                } else if (i == 3010) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "该流地址无视频");
                } else if (i == -2302) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "获取加速拉流地址失败");
                } else if (i == -2301) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "经多次自动重连失败，放弃连接");
                } else if (i == 2001) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "已连接服务器");
                } else if (i == 2002) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "开始拉流");
                } else if (i == 3002) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "连接服务器失败");
                } else if (i == 3003) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "RTMP服务器握手失败");
                } else if (i == 3006) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "写数据错误，网络连接断开");
                } else if (i != 3007) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "UNKNOWN event = " + i);
                } else {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, "读数据错误，网络连接断开");
                }
                String str = "";
                if (bundle != null) {
                    str = bundle.getString(TXLiveConstants.EVT_DESCRIPTION, "");
                }
                if (str != null && !str.isEmpty()) {
                    bundle2.putString(TXLiveConstants.EVT_DESCRIPTION, str);
                }
                bundle2.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                this.mNotifyListener.onNotifyEvent(i, bundle2);
            }
        }
        if (i == 2001) {
            reportNetStatusInternal();
        }
    }

    private void tryResetRetryCount() {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.connectRetryTimes = 0;
        }
    }

    public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
        tryResetRetryCount();
        synchronized (this.mListenerLock) {
            if (this.mListener != null) {
                this.mListener.onPullAudio(aVar);
            }
            if (this.mDownloader != null) {
                this.mDownloader.PushAudioFrame(aVar.f31402f, aVar.h, aVar.f31401e, aVar.f31403g);
            }
        }
    }

    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        tryResetRetryCount();
        if (!this.mRecvFirstNal) {
            reportNetStatusInternal();
            this.mRecvFirstNal = true;
        }
        synchronized (this.mListenerLock) {
            this.mCurrentNalTs = tXSNALPacket.pts;
            if (tXSNALPacket.nalType == 0) {
                this.mLastIFramelTs = tXSNALPacket.pts;
            }
            if (this.mListener != null) {
                this.mListener.onPullNAL(tXSNALPacket);
            }
            if (this.mDownloader != null) {
                this.mDownloader.PushVideoFrame(tXSNALPacket.nalData, tXSNALPacket.nalType, tXSNALPacket.dts, tXSNALPacket.pts, tXSNALPacket.codecId);
            }
        }
    }

    public void onRestartDownloader() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(new Runnable() {
                public void run() {
                    TXCStreamDownloader.this.stop();
                    TXCStreamDownloader tXCStreamDownloader = TXCStreamDownloader.this;
                    tXCStreamDownloader.start(tXCStreamDownloader.mOriginPlayUrl, TXCStreamDownloader.this.mEnableNearestIP, TXCStreamDownloader.this.mChannelType, TXCStreamDownloader.this.mEnableMessage);
                }
            });
        }
    }

    public void onOldStreamStop() {
        synchronized (this.mListenerLock) {
            if (this.mStreamSwitcher != null) {
                this.mStreamSwitcher.b();
            }
        }
    }

    public void setListener(h hVar) {
        synchronized (this.mListenerLock) {
            this.mListener = hVar;
        }
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        synchronized (this.mListenerLock) {
            this.mNotifyListener = aVar;
        }
    }

    public void setID(String str) {
        super.setID(str);
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.setUserID(str);
        }
    }

    public void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        synchronized (this.mListenerLock) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.mSwitchStartTime);
            this.mSwitchStartTime = 0;
            Bundle bundle = new Bundle();
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (z) {
                this.mDownloader = tXIStreamDownloader;
                this.mDownloader.setListener(this);
                this.mDownloader.setNotifyListener(this);
                this.mDownloader.setRestartListener(this);
                bundle.putInt("EVT_ID", 2015);
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "切换分辨率成功");
                if (this.mNotifyListener != null) {
                    this.mNotifyListener.onNotifyEvent(2015, bundle);
                }
                TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bt, currentTimeMillis, "");
            } else {
                bundle.putInt("EVT_ID", 2015);
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "切换分辨率失败");
                if (this.mNotifyListener != null) {
                    this.mNotifyListener.onNotifyEvent(2015, bundle);
                }
                TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.bu);
            }
            this.mStreamSwitcher = null;
        }
    }

    static {
        b.f();
    }

    public TXCStreamDownloader(Context context, int i) {
        if (i == 0) {
            this.mDownloader = new TXCFLVDownloader(context);
        } else if (i == 1 || i == 4) {
            this.mDownloader = new TXCRTMPDownloader(context);
        }
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.setListener(this);
            this.mDownloader.setNotifyListener(this);
            this.mDownloader.setRestartListener(this);
        }
        this.mDownloadFormat = i;
        this.mAccUrlFetcher = new k(context);
        this.mApplicationContext = context;
        Context context2 = this.mApplicationContext;
        if (context2 != null) {
            this.mHandler = new Handler(context2.getMainLooper());
        }
    }

    public void setRetryTimes(int i) {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.connectRetryLimit = i;
        }
    }

    public void setRetryInterval(int i) {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.connectRetryInterval = i;
        }
    }

    public int start(final String str, boolean z, int i, final boolean z2) {
        boolean z3 = true;
        this.mDownloaderRunning = true;
        this.mRecvFirstNal = false;
        this.mOriginPlayUrl = str;
        this.mEnableNearestIP = z;
        this.mChannelType = i;
        this.mEnableMessage = z2;
        setStatusValue(7113, 0L);
        setStatusValue(7114, 0L);
        setStatusValue(7115, 0L);
        if (str.startsWith("room")) {
            setStatusValue(7113, 1L);
            setStatusValue(7112, 2L);
            if (this.mDownloader != null) {
                Vector vector = new Vector();
                vector.add(new e(str, true));
                this.mDownloader.setOriginUrl(str);
                this.mDownloader.setUserID(getID());
                this.mDownloader.startDownload(vector, false, false, z2);
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
            }
            return 0;
        } else if (!z || this.mDownloadFormat != 4) {
            if (this.mDownloader != null) {
                setStatusValue(7112, 1L);
                Vector vector2 = new Vector();
                vector2.add(new e(str, false));
                this.mDownloader.setOriginUrl(str);
                TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
                if (this.mDownloadFormat != 4) {
                    z3 = false;
                }
                tXIStreamDownloader.startDownload(vector2, z3, z, z2);
                Handler handler2 = this.mHandler;
                if (handler2 != null) {
                    handler2.postDelayed(this.mReportNetStatusRunnalbe, 2000);
                }
            }
            return 0;
        } else {
            int a2 = this.mAccUrlFetcher.a(str, i, new k.a() {
                public void a(int i, String str, Vector<e> vector) {
                    if (i != 0 || vector == null || vector.isEmpty()) {
                        TXCStreamDownloader.this.onNotifyEvent(-2302, (Bundle) null);
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, i, str);
                        TXCLog.e(TXCStreamDownloader.TAG, "getAccelerateStreamPlayUrl failed, play stream with raw url");
                        if (TXCStreamDownloader.this.mDownloaderRunning) {
                            TXCStreamDownloader.this.onNotifyEvent(-2301, (Bundle) null);
                        }
                    } else if (TXCStreamDownloader.this.mDownloaderRunning) {
                        if (TXCStreamDownloader.this.mDownloader != null) {
                            int i2 = 0;
                            Iterator<e> it = vector.iterator();
                            while (it.hasNext()) {
                                e next = it.next();
                                if (next != null && next.f31773b && next.f31772a != null && next.f31772a.length() > 0) {
                                    i2++;
                                }
                            }
                            TXCStreamDownloader.this.setStatusValue(7113, Long.valueOf((long) i2));
                            TXCStreamDownloader.this.setStatusValue(7112, 2L);
                            TXCStreamDownloader.this.mDownloader.setOriginUrl(str);
                            TXCStreamDownloader.this.mDownloader.startDownload(vector, true, true, z2);
                        }
                        if (TXCStreamDownloader.this.mHandler != null) {
                            TXCStreamDownloader.this.mHandler.postDelayed(TXCStreamDownloader.this.mReportNetStatusRunnalbe, 2000);
                        }
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, i, TXCStreamDownloader.this.mAccUrlFetcher.b());
                    } else {
                        TXCDRApi.txReportDAU(TXCStreamDownloader.this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, -4, "livePlayer have been stopped");
                    }
                }
            });
            if (a2 != 0) {
                if (a2 == -1) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, a2, "invalid playUrl");
                } else if (a2 == -2) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, a2, "invalid streamID");
                } else if (a2 == -3) {
                    TXCDRApi.txReportDAU(this.mApplicationContext, com.tencent.liteav.basic.datareport.a.at, a2, "invalid signature");
                }
                TXCLog.e(TAG, "getAccelerateStreamPlayUrl failed, result = " + a2 + ", play stream with raw url");
                onNotifyEvent(-2302, (Bundle) null);
                onNotifyEvent(-2301, (Bundle) null);
            }
            return 0;
        }
    }

    private void playStreamWithRawUrl(String str, boolean z) {
        if (this.mDownloader != null) {
            if (str != null && ((str.startsWith("http://") || str.startsWith("https://")) && str.contains(".flv"))) {
                int i = this.mDownloader.connectRetryLimit;
                int i2 = this.mDownloader.connectRetryInterval;
                this.mDownloader = null;
                this.mDownloader = new TXCFLVDownloader(this.mApplicationContext);
                this.mDownloader.setListener(this);
                this.mDownloader.setNotifyListener(this);
                this.mDownloader.setRestartListener(this);
                TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
                tXIStreamDownloader.connectRetryLimit = i;
                tXIStreamDownloader.connectRetryInterval = i2;
                tXIStreamDownloader.setHeaders(this.mHeaders);
                this.mDownloader.setUserID(getID());
            }
            setStatusValue(7112, 1L);
            Vector vector = new Vector();
            vector.add(new e(str, false));
            this.mDownloader.setOriginUrl(str);
            this.mDownloader.startDownload(vector, false, false, z);
        }
    }

    public void stop() {
        this.mDownloaderRunning = false;
        this.mRecvFirstNal = false;
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.stopDownload();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mReportNetStatusRunnalbe);
        }
        synchronized (this.mListenerLock) {
            if (this.mStreamSwitcher != null) {
                this.mStreamSwitcher.a((h) null);
                this.mStreamSwitcher.a();
                this.mStreamSwitcher = null;
            }
        }
    }

    public boolean switchStream(String str) {
        synchronized (this.mListenerLock) {
            if (this.mStreamSwitcher == null && this.mDownloader != null) {
                if (this.mDownloader instanceof TXCFLVDownloader) {
                    TXCFLVDownloader tXCFLVDownloader = new TXCFLVDownloader(this.mApplicationContext, (TXCFLVDownloader) this.mDownloader);
                    tXCFLVDownloader.connectRetryLimit = this.mDownloader.connectRetryLimit;
                    tXCFLVDownloader.connectRetryInterval = this.mDownloader.connectRetryInterval;
                    tXCFLVDownloader.setHeaders(this.mHeaders);
                    tXCFLVDownloader.setUserID(getID());
                    this.mStreamSwitcher = new d(this);
                    this.mStreamSwitcher.a((h) this);
                    this.mStreamSwitcher.a(this.mDownloader, tXCFLVDownloader, this.mCurrentNalTs, this.mLastIFramelTs, str);
                    this.mSwitchStartTime = System.currentTimeMillis();
                    return true;
                }
            }
            TXCLog.w(TAG, "stream_switch stream is changing ignore this change");
            return false;
        }
    }

    private DownloadStats getDownloadStats() {
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            return tXIStreamDownloader.getDownloadStats();
        }
        return null;
    }

    private a getRealTimeStreamInfo() {
        a aVar = new a();
        k kVar = this.mAccUrlFetcher;
        if (kVar != null) {
            aVar.f31702b = kVar.a();
            aVar.f31703c = this.mAccUrlFetcher.b();
            aVar.f31704d = this.mAccUrlFetcher.c();
            aVar.f31705e = this.mAccUrlFetcher.d();
        }
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            aVar.f31701a = tXIStreamDownloader.getCurrentStreamUrl();
            aVar.f31706f = this.mDownloader.isQuicChannel();
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public void reportNetStatus() {
        reportNetStatusInternal();
        this.mHandler.postDelayed(this.mReportNetStatusRunnalbe, 2000);
    }

    private void reportNetStatusInternal() {
        long j;
        long timeTick = TXCTimeUtil.getTimeTick();
        long j2 = timeTick - this.mLastTimeStamp;
        DownloadStats downloadStats = getDownloadStats();
        a realTimeStreamInfo = getRealTimeStreamInfo();
        if (downloadStats != null) {
            DownloadStats downloadStats2 = this.mLastDownloadStats;
            long j3 = 0;
            if (downloadStats2 != null) {
                long j4 = j2;
                long longValue = getSpeed(downloadStats2.afterParseVideoBytes, downloadStats.afterParseVideoBytes, j4).longValue();
                j = getSpeed(this.mLastDownloadStats.afterParseAudioBytes, downloadStats.afterParseAudioBytes, j4).longValue();
                j3 = longValue;
            } else {
                j = 0;
            }
            setStatusValue(7101, Long.valueOf(j3));
            setStatusValue(7102, Long.valueOf(j));
            setStatusValue(7103, Long.valueOf(downloadStats.firstVideoTS));
            setStatusValue(7104, Long.valueOf(downloadStats.firstAudioTS));
            setStatusValue(7120, Long.valueOf(downloadStats.videoGop));
            if (realTimeStreamInfo != null) {
                setStatusValue(7105, Long.valueOf((long) realTimeStreamInfo.f31704d));
                setStatusValue(7106, realTimeStreamInfo.f31705e);
                setStatusValue(7111, Long.valueOf(realTimeStreamInfo.f31706f ? 2 : 1));
                setStatusValue(7116, realTimeStreamInfo.f31701a);
                setStatusValue(7117, realTimeStreamInfo.f31702b);
                setStatusValue(7118, realTimeStreamInfo.f31703c);
            }
            setStatusValue(7107, Long.valueOf(downloadStats.startTS));
            setStatusValue(7108, Long.valueOf(downloadStats.dnsTS));
            setStatusValue(7109, Long.valueOf(downloadStats.connTS));
            setStatusValue(7110, String.valueOf(downloadStats.serverIP));
        }
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            int connectCountQuic = tXIStreamDownloader.getConnectCountQuic();
            int connectCountTcp = this.mDownloader.getConnectCountTcp();
            setStatusValue(7114, Long.valueOf((long) (connectCountQuic + 1)));
            setStatusValue(7115, Long.valueOf((long) (connectCountTcp + 1)));
            setStatusValue(7119, this.mDownloader.getRealStreamUrl());
        }
        this.mLastTimeStamp = timeTick;
        this.mLastDownloadStats = downloadStats;
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

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
        TXIStreamDownloader tXIStreamDownloader = this.mDownloader;
        if (tXIStreamDownloader != null) {
            tXIStreamDownloader.setHeaders(this.mHeaders);
        }
    }
}
