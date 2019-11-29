package com.google.android.exoplayer2.m;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f10751a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super e> f10752b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f10753c;

    /* renamed from: d  reason: collision with root package name */
    private AssetFileDescriptor f10754d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f10755e;

    /* renamed from: f  reason: collision with root package name */
    private long f10756f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10757g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, u<? super e> uVar) {
        this.f10751a = context.getContentResolver();
        this.f10752b = uVar;
    }

    public long a(i iVar) throws a {
        try {
            this.f10753c = iVar.f10764a;
            this.f10754d = this.f10751a.openAssetFileDescriptor(this.f10753c, "r");
            this.f10755e = new FileInputStream(this.f10754d.getFileDescriptor());
            if (this.f10755e.skip(iVar.f10767d) >= iVar.f10767d) {
                if (iVar.f10768e != -1) {
                    this.f10756f = iVar.f10768e;
                } else {
                    this.f10756f = (long) this.f10755e.available();
                    if (this.f10756f == 0) {
                        this.f10756f = -1;
                    }
                }
                this.f10757g = true;
                u<? super e> uVar = this.f10752b;
                if (uVar != null) {
                    uVar.a(this, iVar);
                }
                return this.f10756f;
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
        long j = this.f10756f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int read = this.f10755e.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.f10756f;
            if (j2 != -1) {
                this.f10756f = j2 - ((long) read);
            }
            u<? super e> uVar = this.f10752b;
            if (uVar != null) {
                uVar.a(this, read);
            }
            return read;
        } else if (this.f10756f == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }

    public Uri a() {
        return this.f10753c;
    }

    public void b() throws a {
        this.f10753c = null;
        try {
            if (this.f10755e != null) {
                this.f10755e.close();
            }
            this.f10755e = null;
            try {
                if (this.f10754d != null) {
                    this.f10754d.close();
                }
                this.f10754d = null;
                if (this.f10757g) {
                    this.f10757g = false;
                    u<? super e> uVar = this.f10752b;
                    if (uVar != null) {
                        uVar.a(this);
                    }
                }
            } catch (IOException e2) {
                throw new a(e2);
            } catch (Throwable th) {
                this.f10754d = null;
                if (this.f10757g) {
                    this.f10757g = false;
                    u<? super e> uVar2 = this.f10752b;
                    if (uVar2 != null) {
                        uVar2.a(this);
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new a(e3);
        } catch (Throwable th2) {
            this.f10755e = null;
            try {
                if (this.f10754d != null) {
                    this.f10754d.close();
                }
                this.f10754d = null;
                if (this.f10757g) {
                    this.f10757g = false;
                    u<? super e> uVar3 = this.f10752b;
                    if (uVar3 != null) {
                        uVar3.a(this);
                    }
                }
                throw th2;
            } catch (IOException e4) {
                throw new a(e4);
            } catch (Throwable th3) {
                this.f10754d = null;
                if (this.f10757g) {
                    this.f10757g = false;
                    u<? super e> uVar4 = this.f10752b;
                    if (uVar4 != null) {
                        uVar4.a(this);
                    }
                }
                throw th3;
            }
        }
    }
}
