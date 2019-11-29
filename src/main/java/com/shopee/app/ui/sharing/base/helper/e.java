package com.shopee.app.ui.sharing.base.helper;

import android.net.Uri;
import android.util.Patterns;
import com.shopee.app.ui.sharing.base.data.ShareVideo;
import d.a.d;
import d.d.b.j;
import d.h.m;
import java.io.File;
import java.lang.ref.WeakReference;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<d> f25358a;

    /* renamed from: b  reason: collision with root package name */
    private final io.a.a.a.a.c.a<byte[], Void, Uri> f25359b = new b(this);

    /* renamed from: c  reason: collision with root package name */
    private final a f25360c = new a(this);

    public e(d dVar) {
        j.b(dVar, "processListener");
        this.f25358a = new WeakReference<>(dVar);
    }

    public static final class b extends io.a.a.a.a.c.a<byte[], Void, Uri> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f25362a;

        b(e eVar) {
            this.f25362a = eVar;
        }

        /* access modifiers changed from: protected */
        public Uri a(byte[]... bArr) {
            j.b(bArr, "p0");
            byte[] bArr2 = (byte[]) d.a((T[]) (Object[]) bArr, 0);
            if (bArr2 != null) {
                return c.a("instagram-video-sharing", bArr2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void a(Uri uri) {
            if (uri != null) {
                d dVar = (d) this.f25362a.f25358a.get();
                if (dVar != null) {
                    String path = uri.getPath();
                    j.a((Object) path, "result.path");
                    dVar.c(path);
                    return;
                }
                return;
            }
            d dVar2 = (d) this.f25362a.f25358a.get();
            if (dVar2 != null) {
                dVar2.g();
            }
        }
    }

    public final void a(ShareVideo shareVideo) {
        j.b(shareVideo, "shareVideo");
        d dVar = (d) this.f25358a.get();
        if (dVar != null) {
            dVar.f();
        }
        String videoUrl = shareVideo.getVideoUrl();
        CharSequence charSequence = videoUrl;
        if (charSequence == null || m.a(charSequence)) {
            d dVar2 = (d) this.f25358a.get();
            if (dVar2 != null) {
                dVar2.g();
            }
        } else if (Patterns.WEB_URL.matcher(charSequence).matches()) {
            com.shopee.app.h.a.a.a().a(videoUrl, String.valueOf(videoUrl.hashCode()), this.f25360c);
        } else if (!new File(videoUrl).isFile()) {
            d dVar3 = (d) this.f25358a.get();
            if (dVar3 != null) {
                dVar3.g();
            }
        } else {
            d dVar4 = (d) this.f25358a.get();
            if (dVar4 != null) {
                dVar4.c(videoUrl);
            }
        }
    }

    public static final class a implements com.beetalklib.a.a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f25361a;

        a(e eVar) {
            this.f25361a = eVar;
        }

        public void onFinish(byte[] bArr, int i) {
            if (bArr != null) {
                this.f25361a.a(bArr);
                return;
            }
            d dVar = (d) this.f25361a.f25358a.get();
            if (dVar != null) {
                dVar.g();
            }
        }

        public void onError(int i) {
            d dVar = (d) this.f25361a.f25358a.get();
            if (dVar != null) {
                dVar.g();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(byte[] bArr) {
        this.f25359b.c(bArr);
    }

    public final void a(boolean z) {
        this.f25359b.a(z);
    }
}
