package com.google.android.exoplayer2.r;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e implements f {

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f11300a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super e> f11301b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f11302c;

    /* renamed from: d  reason: collision with root package name */
    private AssetFileDescriptor f11303d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f11304e;

    /* renamed from: f  reason: collision with root package name */
    private long f11305f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11306g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public e(Context context, u<? super e> uVar) {
        this.f11300a = context.getContentResolver();
        this.f11301b = uVar;
    }

    public long a(i iVar) throws a {
        try {
            this.f11302c = iVar.f11313a;
            this.f11303d = this.f11300a.openAssetFileDescriptor(this.f11302c, "r");
            if (this.f11303d != null) {
                this.f11304e = new FileInputStream(this.f11303d.getFileDescriptor());
                long startOffset = this.f11303d.getStartOffset();
                if (this.f11304e.skip(iVar.f11316d + startOffset) - startOffset == iVar.f11316d) {
                    if (iVar.f11317e != -1) {
                        this.f11305f = iVar.f11317e;
                    } else {
                        this.f11305f = this.f11303d.getLength();
                        if (this.f11305f == -1) {
                            this.f11305f = (long) this.f11304e.available();
                            if (this.f11305f == 0) {
                                this.f11305f = -1;
                            }
                        }
                    }
                    this.f11306g = true;
                    u<? super e> uVar = this.f11301b;
                    if (uVar != null) {
                        uVar.a(this, iVar);
                    }
                    return this.f11305f;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException("Could not open file descriptor for: " + this.f11302c);
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f11305f;
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
        int read = this.f11304e.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.f11305f;
            if (j2 != -1) {
                this.f11305f = j2 - ((long) read);
            }
            u<? super e> uVar = this.f11301b;
            if (uVar != null) {
                uVar.a(this, read);
            }
            return read;
        } else if (this.f11305f == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }

    public Uri b() {
        return this.f11302c;
    }

    public void a() throws a {
        this.f11302c = null;
        try {
            if (this.f11304e != null) {
                this.f11304e.close();
            }
            this.f11304e = null;
            try {
                if (this.f11303d != null) {
                    this.f11303d.close();
                }
                this.f11303d = null;
                if (this.f11306g) {
                    this.f11306g = false;
                    u<? super e> uVar = this.f11301b;
                    if (uVar != null) {
                        uVar.a(this);
                    }
                }
            } catch (IOException e2) {
                throw new a(e2);
            } catch (Throwable th) {
                this.f11303d = null;
                if (this.f11306g) {
                    this.f11306g = false;
                    u<? super e> uVar2 = this.f11301b;
                    if (uVar2 != null) {
                        uVar2.a(this);
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new a(e3);
        } catch (Throwable th2) {
            this.f11304e = null;
            try {
                if (this.f11303d != null) {
                    this.f11303d.close();
                }
                this.f11303d = null;
                if (this.f11306g) {
                    this.f11306g = false;
                    u<? super e> uVar3 = this.f11301b;
                    if (uVar3 != null) {
                        uVar3.a(this);
                    }
                }
                throw th2;
            } catch (IOException e4) {
                throw new a(e4);
            } catch (Throwable th3) {
                this.f11303d = null;
                if (this.f11306g) {
                    this.f11306g = false;
                    u<? super e> uVar4 = this.f11301b;
                    if (uVar4 != null) {
                        uVar4.a(this);
                    }
                }
                throw th3;
            }
        }
    }
}
