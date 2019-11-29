package com.google.firebase.perf.network;

import com.google.android.gms.internal.p000firebaseperf.zzau;
import com.google.android.gms.internal.p000firebaseperf.zzbg;
import java.io.IOException;
import java.io.OutputStream;

public final class c extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f14323a;

    /* renamed from: b  reason: collision with root package name */
    private long f14324b = -1;

    /* renamed from: c  reason: collision with root package name */
    private zzau f14325c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbg f14326d;

    public c(OutputStream outputStream, zzau zzau, zzbg zzbg) {
        this.f14323a = outputStream;
        this.f14325c = zzau;
        this.f14326d = zzbg;
    }

    public final void close() throws IOException {
        long j = this.f14324b;
        if (j != -1) {
            this.f14325c.zzf(j);
        }
        this.f14325c.zzh(this.f14326d.zzcs());
        try {
            this.f14323a.close();
        } catch (IOException e2) {
            this.f14325c.zzj(this.f14326d.zzcs());
            h.a(this.f14325c);
            throw e2;
        }
    }

    public final void flush() throws IOException {
        try {
            this.f14323a.flush();
        } catch (IOException e2) {
            this.f14325c.zzj(this.f14326d.zzcs());
            h.a(this.f14325c);
            throw e2;
        }
    }

    public final void write(int i) throws IOException {
        try {
            this.f14323a.write(i);
            this.f14324b++;
            this.f14325c.zzf(this.f14324b);
        } catch (IOException e2) {
            this.f14325c.zzj(this.f14326d.zzcs());
            h.a(this.f14325c);
            throw e2;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        try {
            this.f14323a.write(bArr);
            this.f14324b += (long) bArr.length;
            this.f14325c.zzf(this.f14324b);
        } catch (IOException e2) {
            this.f14325c.zzj(this.f14326d.zzcs());
            h.a(this.f14325c);
            throw e2;
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.f14323a.write(bArr, i, i2);
            this.f14324b += (long) i2;
            this.f14325c.zzf(this.f14324b);
        } catch (IOException e2) {
            this.f14325c.zzj(this.f14326d.zzcs());
            h.a(this.f14325c);
            throw e2;
        }
    }
}
