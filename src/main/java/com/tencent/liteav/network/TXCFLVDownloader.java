package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.util.ByteConstants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.qcloud.core.http.HttpMetric;
import com.tencent.ugc.TXRecordCommon;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.SSLException;

public class TXCFLVDownloader extends TXIStreamDownloader {
    private final int CONNECT_TIMEOUT;
    private final int FLV_HEAD_SIZE;
    private final int MAX_FRAME_SIZE;
    private final int MSG_CONNECT;
    private final int MSG_DISCONNECT;
    private final int MSG_QUIT;
    private final int MSG_RECONNECT;
    private final int MSG_RECV_DATA;
    private final int MSG_RESUME;
    private final int MSG_SEEK;
    private final int READ_STREAM_SIZE;
    public final String TAG;
    private HttpURLConnection mConnection;
    private long mContentLength;
    private long mCurrentNalTs;
    private long mDownloadedSize;
    private long mFLVParser;
    private Handler mFlvHandler;
    private HandlerThread mFlvThread;
    private boolean mHandleDataInJava;
    private InputStream mInputStream;
    private long mLastIFramelTs;
    private byte[] mPacketBytes;
    private String mPlayUrl;
    private boolean mRecvData;
    private long mRefFLVParser;
    private TXCStreamDownloader.DownloadStats mStats;
    private boolean mStopJitter;
    private boolean mbFirstAudio;
    private boolean mbFirstVideo;

    private native void nativeCleanData(long j);

    private native int nativeGetAudioBytes(long j);

    private native int nativeGetVideoBytes(long j);

    private native int nativeGetVideoGop(long j);

    private native long nativeInitFlvHander(String str, int i, boolean z);

    private native long nativeInitFlvHanderByRef(long j);

    private native int nativeParseData(long j, byte[] bArr, int i);

    private native void nativeUninitFlvhander(long j, boolean z);

    public native void nativePushAudioFrame(long j, byte[] bArr, int i, long j2, int i2);

    public native void nativePushVideoFrame(long j, byte[] bArr, int i, long j2, long j3, int i2);

    public TXCFLVDownloader(Context context) {
        super(context);
        this.TAG = "network.TXCFLVDownloader";
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = ByteConstants.MB;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = 0;
        this.mDownloadedSize = 0;
        this.mHandleDataInJava = false;
        this.mFLVParser = 0;
        this.mRefFLVParser = 0;
        this.mCurrentNalTs = 0;
        this.mLastIFramelTs = 0;
        this.mStopJitter = true;
        this.mPlayUrl = "";
        this.mbFirstVideo = false;
        this.mbFirstAudio = false;
        this.mStats = null;
        this.mStats = new TXCStreamDownloader.DownloadStats();
        TXCStreamDownloader.DownloadStats downloadStats = this.mStats;
        downloadStats.afterParseAudioBytes = 0;
        downloadStats.dnsTS = 0;
        downloadStats.startTS = TXCTimeUtil.getTimeTick();
        TXCLog.i("network.TXCFLVDownloader", "new flv download " + this);
    }

    public TXCFLVDownloader(Context context, TXCFLVDownloader tXCFLVDownloader) {
        super(context);
        this.TAG = "network.TXCFLVDownloader";
        this.FLV_HEAD_SIZE = 9;
        this.MAX_FRAME_SIZE = ByteConstants.MB;
        this.MSG_CONNECT = 100;
        this.MSG_RECV_DATA = 101;
        this.MSG_DISCONNECT = 102;
        this.MSG_RECONNECT = 103;
        this.MSG_SEEK = 104;
        this.MSG_RESUME = 105;
        this.MSG_QUIT = 106;
        this.CONNECT_TIMEOUT = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        this.READ_STREAM_SIZE = 1388;
        this.mFlvThread = null;
        this.mFlvHandler = null;
        this.mInputStream = null;
        this.mConnection = null;
        this.mPacketBytes = null;
        this.mRecvData = false;
        this.mContentLength = 0;
        this.mDownloadedSize = 0;
        this.mHandleDataInJava = false;
        this.mFLVParser = 0;
        this.mRefFLVParser = 0;
        this.mCurrentNalTs = 0;
        this.mLastIFramelTs = 0;
        this.mStopJitter = true;
        this.mPlayUrl = "";
        this.mbFirstVideo = false;
        this.mbFirstAudio = false;
        this.mStats = null;
        this.mStats = new TXCStreamDownloader.DownloadStats();
        TXCStreamDownloader.DownloadStats downloadStats = this.mStats;
        downloadStats.afterParseAudioBytes = 0;
        downloadStats.dnsTS = 0;
        downloadStats.startTS = TXCTimeUtil.getTimeTick();
        if (tXCFLVDownloader != null) {
            this.mRefFLVParser = tXCFLVDownloader.mFLVParser;
            tXCFLVDownloader.mStopJitter = false;
        }
        TXCLog.i("network.TXCFLVDownloader", "new multi flv download " + this);
    }

    public void recvData(boolean z) {
        this.mHandleDataInJava = z;
    }

    public void PushVideoFrame(byte[] bArr, int i, long j, long j2, int i2) {
        nativePushVideoFrame(this.mFLVParser, bArr, i, j, j2, i2);
    }

    public void PushAudioFrame(byte[] bArr, int i, long j, int i2) {
        nativePushAudioFrame(this.mFLVParser, bArr, i, j, i2);
    }

    public long getCurrentTS() {
        return this.mCurrentNalTs;
    }

    public long getLastIFrameTS() {
        return this.mLastIFramelTs;
    }

    /* access modifiers changed from: private */
    public void processMsgConnect() {
        try {
            connect();
            if (this.mFLVParser == 0) {
                long j = this.mRefFLVParser;
                if (j != 0) {
                    this.mFLVParser = nativeInitFlvHanderByRef(j);
                    this.mRefFLVParser = 0;
                } else {
                    this.mFLVParser = nativeInitFlvHander(this.mUserID, 0, this.mEnableMessage);
                }
            }
            Handler handler = this.mFlvHandler;
            if (handler != null) {
                handler.sendEmptyMessage(101);
            }
        } catch (SocketTimeoutException unused) {
            TXCLog.e("network.TXCFLVDownloader", "socket timeout, reconnect");
            postReconnectMsg();
        } catch (FileNotFoundException e2) {
            TXCLog.e("network.TXCFLVDownloader", "file not found, reconnect");
            e2.printStackTrace();
            postReconnectMsg();
        } catch (Exception e3) {
            TXCLog.e("network.TXCFLVDownloader", "exception, reconnect");
            e3.printStackTrace();
            postReconnectMsg();
        } catch (Error e4) {
            TXCLog.e("network.TXCFLVDownloader", "error, reconnect");
            e4.printStackTrace();
            postReconnectMsg();
        }
    }

    /* access modifiers changed from: private */
    public void processMsgRecvData() {
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                int i = 0;
                int read = inputStream.read(this.mPacketBytes, 0, 1388);
                if (read > 0) {
                    long j = (long) read;
                    this.mDownloadedSize += j;
                    if (!this.mRecvData) {
                        TXCLog.w("network.TXCFLVDownloader", "flv play receive first data " + this);
                        this.mRecvData = true;
                    }
                    if (this.mFLVParser != 0) {
                        this.mStats.beforeParseVideoBytes += j;
                        i = nativeParseData(this.mFLVParser, this.mPacketBytes, read);
                        this.mStats.afterParseVideoBytes = (long) nativeGetVideoBytes(this.mFLVParser);
                        this.mStats.afterParseAudioBytes = (long) nativeGetAudioBytes(this.mFLVParser);
                        this.mStats.videoGop = (long) nativeGetVideoGop(this.mFLVParser);
                    }
                    if (i > 1048576) {
                        TXCLog.e("network.TXCFLVDownloader", "flv play parse frame: " + i + " > " + ByteConstants.MB + ",sart reconnect");
                        postReconnectMsg();
                        return;
                    }
                } else if (read < 0) {
                    TXCLog.w("network.TXCFLVDownloader", "http read: " + read + " < 0, start reconnect");
                    postReconnectMsg();
                    return;
                }
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.sendEmptyMessage(101);
                }
            } catch (SocketTimeoutException unused) {
                TXCLog.w("network.TXCFLVDownloader", "socket timeout start reconnect");
                postReconnectMsg();
            } catch (SocketException unused2) {
                TXCLog.w("network.TXCFLVDownloader", "socket exception start reconnect");
                postReconnectMsg();
            } catch (SSLException unused3) {
                TXCLog.w("network.TXCFLVDownloader", "ssl exception start reconnect");
                postReconnectMsg();
            } catch (EOFException unused4) {
                TXCLog.w("network.TXCFLVDownloader", "eof exception start reconnect");
                postReconnectMsg();
            } catch (Exception e2) {
                TXCLog.e("network.TXCFLVDownloader", HttpMetric.ATTR_EXCEPTION);
                e2.printStackTrace();
                this.mInputStream = null;
                this.mConnection = null;
            } catch (Error e3) {
                TXCLog.e("network.TXCFLVDownloader", "error");
                e3.printStackTrace();
                this.mInputStream = null;
                this.mConnection = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void processMsgDisConnect() {
        try {
            disconnect();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        long j = this.mFLVParser;
        if (j != 0) {
            nativeUninitFlvhander(j, this.mStopJitter);
            this.mFLVParser = 0;
        }
    }

    /* access modifiers changed from: private */
    public void processMsgReconnect() {
        if (this.mStopJitter) {
            reconnect();
            return;
        }
        TXCLog.i("network.TXCFLVDownloader", "ignore processMsgReconnect when start multi stream switch" + this);
        if (this.mRestartListener != null) {
            this.mRestartListener.onOldStreamStop();
        }
    }

    private void startInternal() {
        if (this.mFlvThread == null) {
            this.mFlvThread = new HandlerThread("FlvThread");
            this.mFlvThread.start();
        }
        if (this.mFlvHandler == null) {
            this.mFlvHandler = new Handler(this.mFlvThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 106) {
                        switch (i) {
                            case 100:
                                TXCFLVDownloader.this.processMsgConnect();
                                return;
                            case 101:
                                TXCFLVDownloader.this.processMsgRecvData();
                                return;
                            case 102:
                                TXCFLVDownloader.this.processMsgDisConnect();
                                return;
                            case 103:
                                TXCFLVDownloader.this.processMsgReconnect();
                                return;
                            default:
                                return;
                        }
                    } else {
                        try {
                            Looper.myLooper().quit();
                        } catch (Exception unused) {
                        }
                    }
                }
            };
        }
        postConnectMsg();
    }

    private void reconnect() {
        processMsgDisConnect();
        if (this.connectRetryTimes < this.connectRetryLimit) {
            this.connectRetryTimes++;
            TXCLog.d("network.TXCFLVDownloader", "reconnect retry time:" + this.connectRetryTimes + ", limit:" + this.connectRetryLimit);
            processMsgConnect();
            sendNotifyEvent(2103);
            return;
        }
        TXCLog.e("network.TXCFLVDownloader", "reconnect all times retried, send failed event ");
        sendNotifyEvent(-2301);
    }

    private void postReconnectMsg() {
        Handler handler = this.mFlvHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(103, (long) (this.connectRetryInterval * 1000));
        }
    }

    private void postDisconnectMsg() {
        Handler handler = this.mFlvHandler;
        if (handler != null) {
            handler.sendEmptyMessage(102);
        }
    }

    private void postConnectMsg() {
        this.mInputStream = null;
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.mConnection = null;
        }
        Message message = new Message();
        message.what = 100;
        message.arg1 = 0;
        Handler handler = this.mFlvHandler;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    private void connect() throws Exception {
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.mConnection = null;
        }
        this.mConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(this.mPlayUrl).openConnection()));
        this.mStats.dnsTS = TXCTimeUtil.getTimeTick();
        this.mConnection.setConnectTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        this.mConnection.setReadTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
        this.mConnection.setRequestProperty("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        this.mConnection.setInstanceFollowRedirects(true);
        if (this.mHeaders != null) {
            for (Map.Entry entry : this.mHeaders.entrySet()) {
                this.mConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.mConnection.connect();
        this.mInputStream = this.mConnection.getInputStream();
        this.mPacketBytes = new byte[1388];
        this.mRecvData = false;
        this.mContentLength = (long) this.mConnection.getContentLength();
        this.mDownloadedSize = 0;
        this.mStats.serverIP = InetAddress.getByName(this.mConnection.getURL().getHost()).getHostAddress();
        this.mStats.connTS = TXCTimeUtil.getTimeTick();
        sendNotifyEvent(2001);
    }

    public String getRealStreamUrl() {
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            return httpURLConnection.getURL().toString();
        }
        return null;
    }

    private void disconnect() throws Exception {
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.mConnection = null;
        }
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            inputStream.close();
            this.mInputStream = null;
        }
    }

    public TXCStreamDownloader.DownloadStats getDownloadStats() {
        TXCStreamDownloader.DownloadStats downloadStats = new TXCStreamDownloader.DownloadStats();
        downloadStats.afterParseAudioBytes = this.mStats.afterParseAudioBytes;
        downloadStats.afterParseVideoBytes = this.mStats.afterParseVideoBytes;
        downloadStats.beforeParseVideoBytes = this.mStats.beforeParseVideoBytes;
        downloadStats.beforeParseAudioBytes = this.mStats.beforeParseAudioBytes;
        downloadStats.videoGop = this.mStats.videoGop;
        downloadStats.startTS = this.mStats.startTS;
        downloadStats.dnsTS = this.mStats.dnsTS;
        downloadStats.connTS = this.mStats.connTS;
        downloadStats.firstAudioTS = this.mStats.firstAudioTS;
        downloadStats.firstVideoTS = this.mStats.firstVideoTS;
        downloadStats.serverIP = this.mStats.serverIP;
        return downloadStats;
    }

    public void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3) {
        if (!this.mIsRunning && vector != null && !vector.isEmpty()) {
            this.mEnableMessage = z3;
            this.mIsRunning = true;
            this.mPlayUrl = vector.get(0).f31772a;
            TXCLog.d("network.TXCFLVDownloader", "start pull with url " + this.mPlayUrl);
            startInternal();
        }
    }

    public void stopDownload() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            TXCLog.d("network.TXCFLVDownloader", "stop pull");
            try {
                if (this.mFlvHandler != null) {
                    this.mFlvHandler.removeCallbacksAndMessages((Object) null);
                    this.mFlvHandler.sendEmptyMessage(102);
                    this.mFlvHandler.sendEmptyMessage(106);
                    this.mFlvHandler = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        if (!this.mbFirstVideo) {
            this.mbFirstVideo = true;
            this.mStats.firstVideoTS = TXCTimeUtil.getTimeTick();
            TXCLog.d("network.TXCFLVDownloader", "receive first video with ts " + this.mStats.firstVideoTS);
        }
        this.mStats.afterParseVideoBytes += (long) bArr.length;
        super.onRecvVideoData(bArr, i, j, j2, i2);
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        if (!this.mbFirstAudio) {
            this.mbFirstAudio = true;
            this.mStats.firstAudioTS = TXCTimeUtil.getTimeTick();
            TXCLog.d("network.TXCFLVDownloader", "receive first audio with ts " + this.mStats.firstAudioTS);
        }
        this.mStats.afterParseAudioBytes += (long) bArr.length;
        super.onRecvAudioData(bArr, i, i2, i3);
    }
}
