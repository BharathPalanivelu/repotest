package com.google.android.exoplayer2.m;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class p implements f {

    /* renamed from: a  reason: collision with root package name */
    private final u<? super p> f10808a;

    /* renamed from: b  reason: collision with root package name */
    private RandomAccessFile f10809b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f10810c;

    /* renamed from: d  reason: collision with root package name */
    private long f10811d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10812e;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public p() {
        this((u<? super p>) null);
    }

    public p(u<? super p> uVar) {
        this.f10808a = uVar;
    }

    public long a(i iVar) throws a {
        try {
            this.f10810c = iVar.f10764a;
            this.f10809b = new RandomAccessFile(iVar.f10764a.getPath(), "r");
            this.f10809b.seek(iVar.f10767d);
            this.f10811d = iVar.f10768e == -1 ? this.f10809b.length() - iVar.f10767d : iVar.f10768e;
            if (this.f10811d >= 0) {
                this.f10812e = true;
                u<? super p> uVar = this.f10808a;
                if (uVar != null) {
                    uVar.a(this, iVar);
                }
                return this.f10811d;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f10811d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.f10809b.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                this.f10811d -= (long) read;
                u<? super p> uVar = this.f10808a;
                if (uVar != null) {
                    uVar.a(this, read);
                }
            }
            return read;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public Uri a() {
        return this.f10810c;
    }

    public void b() throws a {
        this.f10810c = null;
        try {
            if (this.f10809b != null) {
                this.f10809b.close();
            }
            this.f10809b = null;
            if (this.f10812e) {
                this.f10812e = false;
                u<? super p> uVar = this.f10808a;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.f10809b = null;
            if (this.f10812e) {
                this.f10812e = false;
                u<? super p> uVar2 = this.f10808a;
                if (uVar2 != null) {
                    uVar2.a(this);
                }
            }
            throw th;
        }
    }
}
