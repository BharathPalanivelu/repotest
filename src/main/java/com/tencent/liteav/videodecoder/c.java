package com.tencent.liteav.videodecoder;

import com.tencent.liteav.basic.structs.TXSVideoFrame;

public interface c {
    void onDecodeFailed(int i);

    void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int i, int i2, long j, long j2, int i3);

    void onVideoSizeChange(int i, int i2);
}
