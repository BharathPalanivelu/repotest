package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import java.io.IOException;
import java.io.InputStream;

public final class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f14316a;

    /* renamed from: b  reason: collision with root package name */
    private final zzau f14317b;

    /* renamed from: c  reason: collision with root package name */
    private final zzbg f14318c;

    /* renamed from: d  reason: collision with root package name */
    private long f14319d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f14320e;

    /* renamed from: f  reason: collision with root package name */
    private long f14321f = -1;

    public a(InputStream inputStream, zzau zzau, zzbg zzbg) {
        this.f14318c = zzbg;
        this.f14316a = inputStream;
        this.f14317b = zzau;
        this.f14320e = this.f14317b.zzag();
    }

    public final int available() throws IOException {
        try {
            return this.f14316a.available();
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }

    public final void close() throws IOException {
        long zzcs = this.f14318c.zzcs();
        if (this.f14321f == -1) {
            this.f14321f = zzcs;
        }
        try {
            this.f14316a.close();
            if (this.f14319d != -1) {
                this.f14317b.zzk(this.f14319d);
            }
            if (this.f14320e != -1) {
                this.f14317b.zzi(this.f14320e);
            }
            this.f14317b.zzj(this.f14321f);
            this.f14317b.zzai();
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }

    public final void mark(int i) {
        this.f14316a.mark(i);
    }

    public final boolean markSupported() {
        return this.f14316a.markSupported();
    }

    public final int read() throws IOException {
        try {
            int read = this.f14316a.read();
            long zzcs = this.f14318c.zzcs();
            if (this.f14320e == -1) {
                this.f14320e = zzcs;
            }
            if (read == -1 && this.f14321f == -1) {
                this.f14321f = zzcs;
                this.f14317b.zzj(this.f14321f);
                this.f14317b.zzai();
            } else {
                this.f14319d++;
                this.f14317b.zzk(this.f14319d);
            }
            return read;
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.f14316a.read(bArr, i, i2);
            long zzcs = this.f14318c.zzcs();
            if (this.f14320e == -1) {
                this.f14320e = zzcs;
            }
            if (read == -1 && this.f14321f == -1) {
                this.f14321f = zzcs;
                this.f14317b.zzj(this.f14321f);
                this.f14317b.zzai();
            } else {
                this.f14319d += (long) read;
                this.f14317b.zzk(this.f14319d);
            }
            return read;
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            int read = this.f14316a.read(bArr);
            long zzcs = this.f14318c.zzcs();
            if (this.f14320e == -1) {
                this.f14320e = zzcs;
            }
            if (read == -1 && this.f14321f == -1) {
                this.f14321f = zzcs;
                this.f14317b.zzj(this.f14321f);
                this.f14317b.zzai();
            } else {
                this.f14319d += (long) read;
                this.f14317b.zzk(this.f14319d);
            }
            return read;
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }

    public final void reset() throws IOException {
        try {
            this.f14316a.reset();
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }

    public final long skip(long j) throws IOException {
        try {
            long skip = this.f14316a.skip(j);
            long zzcs = this.f14318c.zzcs();
            if (this.f14320e == -1) {
                this.f14320e = zzcs;
            }
            if (skip == -1 && this.f14321f == -1) {
                this.f14321f = zzcs;
                this.f14317b.zzj(this.f14321f);
            } else {
                this.f14319d += skip;
                this.f14317b.zzk(this.f14319d);
            }
            return skip;
        } catch (IOException e2) {
            this.f14317b.zzj(this.f14318c.zzcs());
            h.a(this.f14317b);
            throw e2;
        }
    }
}
