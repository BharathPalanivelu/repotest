package com.tencent.liteav.audio;

public interface c {
    void onPlayError(int i, String str);

    void onPlayJitterStateNotify(int i);

    void onPlayPcmData(byte[] bArr, long j, int i, int i2);
}
