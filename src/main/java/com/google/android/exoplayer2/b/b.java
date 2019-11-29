package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f9152a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    public final int f9153b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9154c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9155d;

    /* renamed from: e  reason: collision with root package name */
    private AudioAttributes f9156e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f9157a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f9158b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f9159c = 1;

        public b a() {
            return new b(this.f9157a, this.f9158b, this.f9159c);
        }
    }

    private b(int i, int i2, int i3) {
        this.f9153b = i;
        this.f9154c = i2;
        this.f9155d = i3;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(21)
    public AudioAttributes a() {
        if (this.f9156e == null) {
            this.f9156e = new AudioAttributes.Builder().setContentType(this.f9153b).setFlags(this.f9154c).setUsage(this.f9155d).build();
        }
        return this.f9156e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f9153b == bVar.f9153b && this.f9154c == bVar.f9154c && this.f9155d == bVar.f9155d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f9153b) * 31) + this.f9154c) * 31) + this.f9155d;
    }
}
