package com.google.android.exoplayer2.m;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.n.a;
import com.google.android.exoplayer2.n.t;
import java.io.IOException;

public final class l implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f10789a;

    /* renamed from: b  reason: collision with root package name */
    private final f f10790b;

    /* renamed from: c  reason: collision with root package name */
    private final f f10791c;

    /* renamed from: d  reason: collision with root package name */
    private final f f10792d;

    /* renamed from: e  reason: collision with root package name */
    private f f10793e;

    public l(Context context, u<? super f> uVar, f fVar) {
        this.f10789a = (f) a.a(fVar);
        this.f10790b = new p(uVar);
        this.f10791c = new c(context, uVar);
        this.f10792d = new e(context, uVar);
    }

    public long a(i iVar) throws IOException {
        a.b(this.f10793e == null);
        String scheme = iVar.f10764a.getScheme();
        if (t.a(iVar.f10764a)) {
            if (iVar.f10764a.getPath().startsWith("/android_asset/")) {
                this.f10793e = this.f10791c;
            } else {
                this.f10793e = this.f10790b;
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.f10793e = this.f10791c;
        } else if (UriUtil.LOCAL_CONTENT_SCHEME.equals(scheme)) {
            this.f10793e = this.f10792d;
        } else {
            this.f10793e = this.f10789a;
        }
        return this.f10793e.a(iVar);
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.f10793e.a(bArr, i, i2);
    }

    public Uri a() {
        f fVar = this.f10793e;
        if (fVar == null) {
            return null;
        }
        return fVar.a();
    }

    public void b() throws IOException {
        f fVar = this.f10793e;
        if (fVar != null) {
            try {
                fVar.b();
            } finally {
                this.f10793e = null;
            }
        }
    }
}
