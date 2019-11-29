package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.n.k;

abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected final n f9322a;

    /* access modifiers changed from: protected */
    public abstract void a(k kVar, long j) throws ak;

    /* access modifiers changed from: protected */
    public abstract boolean a(k kVar) throws ak;

    public static final class a extends ak {
        public a(String str) {
            super(str);
        }
    }

    protected d(n nVar) {
        this.f9322a = nVar;
    }

    public final void b(k kVar, long j) throws ak {
        if (a(kVar)) {
            a(kVar, j);
        }
    }
}
