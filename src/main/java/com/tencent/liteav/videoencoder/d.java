package com.tencent.liteav.videoencoder;

import android.media.MediaFormat;
import com.tencent.liteav.basic.structs.TXSNALPacket;

public interface d {
    void a(long j, long j2, long j3);

    void a(MediaFormat mediaFormat);

    void a(TXSNALPacket tXSNALPacket, int i);
}
