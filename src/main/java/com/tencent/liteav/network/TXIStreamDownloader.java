package com.tencent.liteav.network;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Map;
import java.util.Vector;

public abstract class TXIStreamDownloader {
    public int connectRetryInterval = 3;
    public int connectRetryLimit = 3;
    public int connectRetryTimes = 0;
    protected Context mApplicationContext = null;
    protected boolean mEnableMessage = false;
    protected Map<String, String> mHeaders;
    protected boolean mIsRunning = false;
    protected h mListener = null;
    protected com.tencent.liteav.basic.c.a mNotifyListener = null;
    protected String mOriginUrl = "";
    protected a mRestartListener = null;
    protected String mUserID = "";

    public interface a {
        void onOldStreamStop();

        void onRestartDownloader();
    }

    public void PushAudioFrame(byte[] bArr, int i, long j, int i2) {
    }

    public void PushVideoFrame(byte[] bArr, int i, long j, long j2, int i2) {
    }

    public int getConnectCountQuic() {
        return 0;
    }

    public int getConnectCountTcp() {
        return 0;
    }

    public String getCurrentStreamUrl() {
        return null;
    }

    public long getCurrentTS() {
        return 0;
    }

    public TXCStreamDownloader.DownloadStats getDownloadStats() {
        return null;
    }

    public long getLastIFrameTS() {
        return 0;
    }

    public String getRealStreamUrl() {
        return null;
    }

    public boolean isQuicChannel() {
        return false;
    }

    public abstract void startDownload(Vector<e> vector, boolean z, boolean z2, boolean z3);

    public abstract void stopDownload();

    public TXIStreamDownloader(Context context) {
        this.mApplicationContext = context;
    }

    public void setListener(h hVar) {
        this.mListener = hVar;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setNotifyListener(com.tencent.liteav.basic.c.a aVar) {
        this.mNotifyListener = aVar;
    }

    public void setRestartListener(a aVar) {
        this.mRestartListener = aVar;
    }

    public void sendNotifyEvent(int i) {
        com.tencent.liteav.basic.c.a aVar = this.mNotifyListener;
        if (aVar != null) {
            aVar.onNotifyEvent(i, (Bundle) null);
        }
    }

    public void sendNotifyEvent(int i, String str) {
        if (this.mNotifyListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, str);
            this.mNotifyListener.onNotifyEvent(i, bundle);
        }
    }

    public void onRecvVideoData(byte[] bArr, int i, long j, long j2, int i2) {
        if (this.mListener != null) {
            TXSNALPacket tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = bArr;
            tXSNALPacket.nalType = i;
            tXSNALPacket.dts = j;
            tXSNALPacket.pts = j2;
            tXSNALPacket.codecId = i2;
            this.mListener.onPullNAL(tXSNALPacket);
        }
    }

    public void onRecvAudioData(byte[] bArr, int i, int i2, int i3) {
        if (this.mListener != null) {
            com.tencent.liteav.basic.structs.a aVar = new com.tencent.liteav.basic.structs.a();
            aVar.f31402f = bArr;
            aVar.f31401e = (long) i;
            if (i2 == 10) {
                if (i3 == 1) {
                    aVar.f31400d = 2;
                } else {
                    aVar.f31400d = 3;
                }
                if (aVar.f31400d == 2) {
                    aVar.f31399c = 16;
                }
            }
            if (i2 == 2) {
                aVar.f31400d = 5;
            }
            aVar.h = i2;
            aVar.f31403g = i3;
            this.mListener.onPullAudio(aVar);
        }
    }

    public void onRecvSEIData(byte[] bArr) {
        if (bArr != null && bArr.length > 0 && this.mNotifyListener != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(TXLiveConstants.EVT_GET_MSG, bArr);
            this.mNotifyListener.onNotifyEvent(2012, bundle);
        }
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }
}
