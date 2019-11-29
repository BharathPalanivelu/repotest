package com.google.android.exoplayer2.r;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class p implements f {

    /* renamed from: a  reason: collision with root package name */
    private final u<? super p> f11359a;

    /* renamed from: b  reason: collision with root package name */
    private RandomAccessFile f11360b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f11361c;

    /* renamed from: d  reason: collision with root package name */
    private long f11362d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11363e;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public p() {
        this((u<? super p>) null);
    }

    public p(u<? super p> uVar) {
        this.f11359a = uVar;
    }

    public long a(i iVar) throws a {
        try {
            this.f11361c = iVar.f11313a;
            this.f11360b = new RandomAccessFile(iVar.f11313a.getPath(), "r");
            this.f11360b.seek(iVar.f11316d);
            this.f11362d = iVar.f11317e == -1 ? this.f11360b.length() - iVar.f11316d : iVar.f11317e;
            if (this.f11362d >= 0) {
                this.f11363e = true;
                u<? super p> uVar = this.f11359a;
                if (uVar != null) {
                    uVar.a(this, iVar);
                }
                return this.f11362d;
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
        long j = this.f11362d;
        if (j == 0) {
            return -1;
        }
        try {
            int read = this.f11360b.read(bArr, i, (int) Math.min(j, (long) i2));
            if (read > 0) {
                this.f11362d -= (long) read;
                u<? super p> uVar = this.f11359a;
                if (uVar != null) {
                    uVar.a(this, read);
                }
            }
            return read;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public Uri b() {
        return this.f11361c;
    }

    public void a() throws a {
        this.f11361c = null;
        try {
            if (this.f11360b != null) {
                this.f11360b.close();
            }
            this.f11360b = null;
            if (this.f11363e) {
                this.f11363e = false;
                u<? super p> uVar = this.f11359a;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.f11360b = null;
            if (this.f11363e) {
                this.f11363e = false;
                u<? super p> uVar2 = this.f11359a;
                if (uVar2 != null) {
                    uVar2.a(this);
                }
            }
            throw th;
        }
    }
}
