package com.tencent.liteav.network.a;

import com.tencent.ijk.media.player.IjkMediaCodecInfo;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f31744a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31745b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31746c;

    /* renamed from: d  reason: collision with root package name */
    public final long f31747d;

    public e(String str, int i, int i2, long j) {
        this.f31744a = str;
        this.f31745b = i;
        this.f31746c = i2 >= 600 ? i2 : IjkMediaCodecInfo.RANK_LAST_CHANCE;
        this.f31747d = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f31744a.equals(eVar.f31744a) && this.f31745b == eVar.f31745b && this.f31746c == eVar.f31746c && this.f31747d == eVar.f31747d) {
            return true;
        }
        return false;
    }

    public boolean a() {
        return this.f31745b == 5;
    }
}
