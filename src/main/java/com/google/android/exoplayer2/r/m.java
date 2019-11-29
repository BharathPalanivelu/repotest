package com.google.android.exoplayer2.r;

import android.content.Context;
import com.google.android.exoplayer2.r.f;

public final class m implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11345a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super f> f11346b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f11347c;

    public m(Context context, u<? super f> uVar, f.a aVar) {
        this.f11345a = context.getApplicationContext();
        this.f11346b = uVar;
        this.f11347c = aVar;
    }

    /* renamed from: b */
    public l a() {
        return new l(this.f11345a, this.f11346b, this.f11347c.a());
    }
}
