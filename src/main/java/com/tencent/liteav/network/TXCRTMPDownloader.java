package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public class TXCRTMPDownloader extends TXIStreamDownloader {
    private final int MSG_EVENT;
    private final int MSG_RECONNECT;
    private final String TAG;
    private int mConnectCountQuic;
    private int mConnectCountTcp;
    private a mCurrentThread;
    private boolean mEnableNearestIP;
    private Handler mHandler;
    private boolean mHasTcpPlayUrl;
    private boolean mIsPlayRtmpAccStream;
    private int mLastNetworkType;
    private String mPlayUrl;
    private boolean mQuicChannel;
    private Object mRTMPThreadLock;
    private String mServerIp;
    private HandlerThread mThread;
    private Vector<e> mVecPlayUrls;

    /* access modifiers changed from: private */
    public native TXCStreamDownloader.DownloadStats nativeGetStats(long j);

    /* access modifiers changed from: private */
    public native long nativeInitRtmpHandler(String str, String str2, String str3, boolean z, boolean z2);

    /* access modifiers changed from: private */
    public native void nativeStart(long j);

    /* access modifiers changed from: private */
    public native void nativeStop(long j);

    /* access modifiers changed from: private */
    public native void nativeUninitRtmpHandler(long j);

    public TXCRTMPDownloader(Context context) {
        super(context);
        this.TAG = "network.TXCRTMPDownloader";
        this.MSG_RECONNECT = 101;
        this.MSG_EVENT = 102;
        this.mPlayUrl = "";
        this.mQuicChannel = false;
        this.mServerIp = "";
        this.mCurrentThread = null;
        this.mRTMPThreadLock = null;
        this.mThread = null;
        this.mHandler = null;
        this.mIsPlayRtmpAccStream = false;
        this.mEnableNearestIP = false;
        this.mConnectCountQuic = 0;
        this.mConnectCountTcp = 0;
        this.mLastNetworkType = 0;
        this.mRTMPThreadLock = new Object();
    }

    class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private long f31693b = 0;

        /* renamed from: c  reason: collision with root package name */
        private String f31694c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31695d;

        a(String str, boolean z) {
            super("RTMPDownLoad");
            this.f31694c = str;
            this.f31695d = z;
        }

        public void run() {
            synchronized (this) {
                this.f31693b = TXCRTMPDownloader.this.nativeInitRtmpHandler(TXCRTMPDownloader.this.mUserID, TXCRTMPDownloader.this.mOriginUrl, this.f31694c, this.f31695d, TXCRTMPDownloader.this.mEnableMessage);
            }
            TXCRTMPDownloader.this.nativeStart(this.f31693b);
            synchronized (this) {
                TXCRTMPDownloader.this.nativeUninitRtmpHandler(this.f31693b);
                this.f31693b = 0;
            }
        }

        public void a() {
            synchronized (this) {
                if (this.f31693b != 0) {
                    TXCRTMPDownloader.this.nativeStop(this.f31693b);
                }
            }
        }

        public TXCStreamDownloader.DownloadStats b() {
            TXCStreamDownloader.DownloadStats access$400;
            synchronized (this) {
                access$400 = this.f31693b != 0 ? TXCRTMPDownloader.this.nativeGetStats(this.f31693b) : null;
            }
            return access$400;
        }
    }

    /* access modifiers changed from: private */
    public void startInternal() {
        if (this.mQuicChannel) {
            this.mConnectCountQuic++;
        } else {
            this.mConnectCountTcp++;
        }
        synchronized (this.mRTMPThreadLock) {
            this.mCurrentThread = new a(this.mPlayUrl, this.mQuicChannel);
            this.mCurrentThread.start();
        }
    }

    private void postReconnectMsg() {
        Message message = new Message();
        message.what = 101;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessageDelayed(message, (long) (this.connectRetryInterval * 1000));
        }
    }

    private void reconnect(final boolean z) {
        synchronized (this.mRTMPThreadLock) {
            if (this.mCurrentThread != null) {
                this.mCurrentThread.a();
                this.mCurrentThread = null;
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    TXCRTMPDownloader.this.internalReconnect(z);
                }
            }, (long) (this.connectRetryInterval * 1000));
        }
    }

    /* access modifiers changed from: private */
    public void internalReconnect(boolean z) {
        if (this.mIsRunning) {
            if (!this.mIsPlayRtmpAccStream || this.mLastNetworkType == b.d(this.mApplicationContext)) {
                boolean z2 = this.mQuicChannel;
                if (this.mIsPlayRtmpAccStream) {
                    if (!this.mEnableNearestIP) {
                        z = false;
                    }
                    if (z2) {
                        z = true;
                    }
                    if (z) {
                        Vector<e> vector = this.mVecPlayUrls;
                        if (vector != null && !vector.isEmpty()) {
                            e eVar = this.mVecPlayUrls.get(0);
                            this.mVecPlayUrls.remove(0);
                            this.mPlayUrl = eVar.f31772a;
                            this.mQuicChannel = eVar.f31773b;
                        }
                    }
                }
                if (z2 && this.mHasTcpPlayUrl) {
                    sendNotifyEvent(2103);
                    startInternal();
                } else if (this.connectRetryTimes < this.connectRetryLimit) {
                    this.connectRetryTimes++;
                    TXCLog.d("network.TXCRTMPDownloader", "reconnect retry count:" + this.connectRetryTimes + " limit:" + this.connectRetryLimit);
                    sendNotifyEvent(2103);
                    startInternal();
                } else {
                    TXCLog.e("network.TXCRTMPDownloader", "reconnect all times retried, send failed event ");
                    sendNotifyEvent(-2301);
                }
            } else {
                this.mLastNetworkType = b.d(this.mApplicationContext);
                if (this.mRestartListener != null) {
                    this.mRestartListener.onRestartDownloader();
                }
            }
        }
    }

    public void sendNotifyEvent(int i, String str) {
        if (str.isEmpty()) {
            sendNotifyEvent(i);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (this.mNotifyListener != null) {
            this.mNotifyListener.onNotifyEvent(i, bundle);
        }
    }

    public void sendNotifyEvent(int i) {
        boolean z = true;
        if (i == 0 || i == 1) {
            if (i != 1) {
                z = false;
            }
            reconnect(z);
            return;
        }
        super.sendNotifyEvent(i);
    }

    public void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3) {
        if (!this.mIsRunning && vector != null && !vector.isEmpty()) {
            this.mEnableMessage = z3;
            this.mIsPlayRtmpAccStream = z;
            this.mEnableNearestIP = z2;
            this.mVecPlayUrls = vector;
            this.mHasTcpPlayUrl = false;
            int i = 0;
            while (true) {
                if (i >= this.mVecPlayUrls.size()) {
                    break;
                } else if (!this.mVecPlayUrls.elementAt(i).f31773b) {
                    this.mHasTcpPlayUrl = true;
                    break;
                } else {
                    i++;
                }
            }
            e eVar = this.mVecPlayUrls.get(0);
            this.mVecPlayUrls.remove(0);
            this.mPlayUrl = eVar.f31772a;
            this.mQuicChannel = eVar.f31773b;
            this.mIsRunning = true;
            StringBuilder sb = new StringBuilder();
            sb.append("start pull with url:");
            sb.append(this.mPlayUrl);
            sb.append(" quic:");
            sb.append(this.mQuicChannel ? "yes" : "no");
            TXCLog.d("network.TXCRTMPDownloader", sb.toString());
            this.mConnectCountQuic = 0;
            this.mConnectCountTcp = 0;
            this.connectRetryTimes = 0;
            if (this.mThread == null) {
                this.mThread = new HandlerThread("RTMP_PULL");
                this.mThread.start();
            }
            this.mHandler = new Handler(this.mThread.getLooper()) {
                public void handleMessage(Message message) {
                    if (message.what == 101) {
                        TXCRTMPDownloader.this.startInternal();
                    }
                }
            };
            startInternal();
        }
    }

    public void stopDownload() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            this.mVecPlayUrls.removeAllElements();
            this.mVecPlayUrls = null;
            this.mIsPlayRtmpAccStream = false;
            this.mEnableNearestIP = false;
            TXCLog.d("network.TXCRTMPDownloader", "stop pull");
            synchronized (this.mRTMPThreadLock) {
                if (this.mCurrentThread != null) {
                    this.mCurrentThread.a();
                    this.mCurrentThread = null;
                }
            }
            HandlerThread handlerThread = this.mThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.mThread = null;
            }
            if (this.mHandler != null) {
                this.mHandler = null;
            }
        }
    }

    public TXCStreamDownloader.DownloadStats getDownloadStats() {
        synchronized (this.mRTMPThreadLock) {
            if (this.mCurrentThread == null) {
                return null;
            }
            TXCStreamDownloader.DownloadStats b2 = this.mCurrentThread.b();
            return b2;
        }
    }

    public String getCurrentStreamUrl() {
        return this.mPlayUrl;
    }

    public boolean isQuicChannel() {
        return this.mQuicChannel;
    }

    public int getConnectCountQuic() {
        return this.mConnectCountQuic;
    }

    public int getConnectCountTcp() {
        return this.mConnectCountTcp;
    }
}
