package com.shopee.live.livestreaming.util.a;

import android.os.Bundle;
import com.shopee.live.livestreaming.util.f;
import com.shopee.live.livestreaming.util.i;
import com.tencent.rtmp.TXLiveConstants;

public class e {
    public static String a(Bundle bundle) {
        return String.format("%-14s\n%-14s\n%-12s\n%-8s\n%-8s\n%-8s\n%-8s\n%-14s\n%-14s\n%-12s\n%-14s\n%-14s\n%-14s\n", new Object[]{"CPU(CPU使用率): " + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES(推/拉流分辨率): " + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD(网络上传速度): " + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT: " + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS(视频帧率): " + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP(关键帧间隔): " + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA(音频码率): " + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE(缓冲积压): " + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE), "DRP(主动丢包): " + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "VRA(视频码率): " + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "SVR(推流服务器IP): " + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO(音频信息): " + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO), "time: " + i.a()});
    }

    public static boolean a() {
        return f.a().b();
    }
}
