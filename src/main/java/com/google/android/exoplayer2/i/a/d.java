package com.google.android.exoplayer2.i.a;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.s.l;

abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected final m f9958a;

    /* access modifiers changed from: protected */
    public abstract void a(l lVar, long j) throws p;

    /* access modifiers changed from: protected */
    public abstract boolean a(l lVar) throws p;

    public static final class a extends p {
        public a(String str) {
            super(str);
        }
    }

    protected d(m mVar) {
        this.f9958a = mVar;
    }

    public final void b(l lVar, long j) throws p {
        if (a(lVar)) {
            a(lVar, j);
        }
    }
}
