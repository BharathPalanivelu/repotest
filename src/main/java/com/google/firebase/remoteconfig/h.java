package com.google.firebase.remoteconfig;

import com.google.android.gms.internal.firebase_remote_config.zzes;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f14348a;

    /* renamed from: b  reason: collision with root package name */
    private final long f14349b;

    /* renamed from: c  reason: collision with root package name */
    private final long f14350c;

    private h(a aVar) {
        this.f14348a = aVar.f14351a;
        this.f14349b = aVar.f14352b;
        this.f14350c = aVar.f14353c;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f14351a = false;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f14352b = 5;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f14353c = zzes.zzla;

        @Deprecated
        public a a(boolean z) {
            this.f14351a = z;
            return this;
        }

        public a a(long j) throws IllegalArgumentException {
            if (j >= 0) {
                this.f14352b = j;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", new Object[]{Long.valueOf(j)}));
        }

        public a b(long j) {
            if (j >= 0) {
                this.f14353c = j;
                return this;
            }
            StringBuilder sb = new StringBuilder(109);
            sb.append("Minimum interval between fetches has to be a non-negative number. ");
            sb.append(j);
            sb.append(" is an invalid argument");
            throw new IllegalArgumentException(sb.toString());
        }

        public h a() {
            return new h(this);
        }
    }

    @Deprecated
    public boolean a() {
        return this.f14348a;
    }

    public long b() {
        return this.f14349b;
    }

    public long c() {
        return this.f14350c;
    }
}
