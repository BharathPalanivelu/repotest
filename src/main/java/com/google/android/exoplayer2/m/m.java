package com.google.android.exoplayer2.m;

import android.content.Context;
import com.google.android.exoplayer2.m.f;

public final class m implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10794a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super f> f10795b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f10796c;

    public m(Context context, u<? super f> uVar, f.a aVar) {
        this.f10794a = context.getApplicationContext();
        this.f10795b = uVar;
        this.f10796c = aVar;
    }

    /* renamed from: b */
    public l a() {
        return new l(this.f10794a, this.f10795b, this.f10796c.a());
    }
}
