package com.shopee.live.livestreaming.ui.audience.a;

import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;

// ini config untuk
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f28938a;

    /* renamed from: b  reason: collision with root package name */
    private int f28939b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28940c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28941d = true;

    /* renamed from: e  reason: collision with root package name */
    private double f28942e = 5.0d;

    /* renamed from: f  reason: collision with root package name */
    private double f28943f = 1.0d;

    /* renamed from: g  reason: collision with root package name */
    private TXLivePlayConfig f28944g;

    public b a(int i) {
        this.f28938a = i;
        return this;
    }

    public b b(int i) {
        this.f28939b = i;
        return this;
    }

    public b a(TXLivePlayConfig tXLivePlayConfig) {
        this.f28944g = tXLivePlayConfig;
        return this;
    }

    public b a(boolean z, double d2, double d3) {
        this.f28941d = z;
        this.f28942e = d3;
        this.f28943f = d2;
        return this;
    }

    public void a(TXLivePlayer tXLivePlayer) {
        if (tXLivePlayer != null) {
            tXLivePlayer.setRenderMode(this.f28938a);
            tXLivePlayer.setRenderRotation(this.f28939b);
            tXLivePlayer.enableHardwareDecode(this.f28940c);
            TXLivePlayConfig tXLivePlayConfig = this.f28944g;
            if (tXLivePlayConfig != null) {
                tXLivePlayConfig.setAutoAdjustCacheTime(this.f28941d);
                this.f28944g.setMinAutoAdjustCacheTime((float) this.f28943f);
                this.f28944g.setMaxAutoAdjustCacheTime((float) this.f28942e);
                tXLivePlayer.setConfig(this.f28944g);
            }
        }
    }
}
