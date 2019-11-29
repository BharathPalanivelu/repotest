package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public interface a {
    int config(Surface surface);

    void decode(TXSNALPacket tXSNALPacket);

    boolean isHevc();

    void setListener(c cVar);

    void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.a> weakReference);

    int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2);

    void stop();
}
