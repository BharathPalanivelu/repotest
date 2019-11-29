package com.google.android.exoplayer2.r;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.appsflyer.share.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f11294a;

    /* renamed from: b  reason: collision with root package name */
    private final u<? super c> f11295b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f11296c;

    /* renamed from: d  reason: collision with root package name */
    private InputStream f11297d;

    /* renamed from: e  reason: collision with root package name */
    private long f11298e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11299f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public c(Context context, u<? super c> uVar) {
        this.f11294a = context.getAssets();
        this.f11295b = uVar;
    }

    public long a(i iVar) throws a {
        try {
            this.f11296c = iVar.f11313a;
            String path = this.f11296c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(Constants.URL_PATH_DELIMITER)) {
                path = path.substring(1);
            }
            this.f11297d = this.f11294a.open(path, 1);
            if (this.f11297d.skip(iVar.f11316d) >= iVar.f11316d) {
                if (iVar.f11317e != -1) {
                    this.f11298e = iVar.f11317e;
                } else {
                    this.f11298e = (long) this.f11297d.available();
                    if (this.f11298e == 2147483647L) {
                        this.f11298e = -1;
                    }
                }
                this.f11299f = true;
                u<? super c> uVar = this.f11295b;
                if (uVar != null) {
                    uVar.a(this, iVar);
                }
                return this.f11298e;
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
        long j = this.f11298e;
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
        int read = this.f11297d.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.f11298e;
            if (j2 != -1) {
                this.f11298e = j2 - ((long) read);
            }
            u<? super c> uVar = this.f11295b;
            if (uVar != null) {
                uVar.a(this, read);
            }
            return read;
        } else if (this.f11298e == -1) {
            return -1;
        } else {
            throw new a(new EOFException());
        }
    }

    public Uri b() {
        return this.f11296c;
    }

    public void a() throws a {
        this.f11296c = null;
        try {
            if (this.f11297d != null) {
                this.f11297d.close();
            }
            this.f11297d = null;
            if (this.f11299f) {
                this.f11299f = false;
                u<? super c> uVar = this.f11295b;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th) {
            this.f11297d = null;
            if (this.f11299f) {
                this.f11299f = false;
                u<? super c> uVar2 = this.f11295b;
                if (uVar2 != null) {
                    uVar2.a(this);
                }
            }
            throw th;
        }
    }
}
