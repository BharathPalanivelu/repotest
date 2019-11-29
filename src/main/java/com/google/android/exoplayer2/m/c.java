package com.google.android.exoplayer2.m;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.appsflyer.share.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f10745a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super c> f10746b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f10747c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f10748d;

    /* renamed from: e  reason: collision with root package name */
    private long f10749e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10750f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, u<? super c> uVar) {
        this.f10745a = context.getAssets();
        this.f10746b = uVar;
    }

    public long a(i iVar) throws a {
        try {
            this.f10747c = iVar.f10764a;
            String path = this.f10747c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(Constants.URL_PATH_DELIMITER)) {
                path = path.substring(1);
            }
            this.f10748d = this.f10745a.open(path, 1);
            if (this.f10748d.skip(iVar.f10767d) >= iVar.f10767d) {
                if (iVar.f10768e != -1) {
                    this.f10749e = iVar.f10768e;
                } else {
                    this.f10749e = (long) this.f10748d.available();
                    if (this.f10749e == 2147483647L) {
                        this.f10749e = -1;
                    }
                }
                this.f10750f = true;
                u<? super c> uVar = this.f10746b;
                if (uVar != null) {
                    uVar.a(this, iVar);
                }
                return this.f10749e;
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
        long j = this.f10749e;
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
        int read = this.f10748d.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.f10749e;
            if (j2 != -1) {
                this.f10749e = j2 - ((long) read);
            }
            u<? super c> uVar = this.f10746b;
            if (uVar != null) {
                uVar.a(this, read);
            }
            return read;
        } else if (this.f10749e == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }

    public Uri a() {
        return this.f10747c;
    }

    public void b() throws a {
        this.f10747c = null;
        try {
            if (this.f10748d != null) {
                this.f10748d.close();
            }
            this.f10748d = null;
            if (this.f10750f) {
                this.f10750f = false;
                u<? super c> uVar = this.f10746b;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.f10748d = null;
            if (this.f10750f) {
                this.f10750f = false;
                u<? super c> uVar2 = this.f10746b;
                if (uVar2 != null) {
                    uVar2.a(this);
                }
            }
            throw th;
        }
    }
}
