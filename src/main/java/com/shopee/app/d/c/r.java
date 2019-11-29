package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.garena.android.appkit.b.a;
import com.shopee.app.application.ar;
import com.shopee.app.h.f;
import com.shopee.app.h.l;
import com.shopee.app.util.n;
import com.shopee.app.util.youtube.g;
import com.squareup.a.w;
import java.io.IOException;

public class r extends a {

    /* renamed from: c  reason: collision with root package name */
    private n f17117c;

    /* renamed from: d  reason: collision with root package name */
    private final ar f17118d;

    /* renamed from: e  reason: collision with root package name */
    private String f17119e;

    /* access modifiers changed from: protected */
    public String d() {
        return "DownloadYoutubeThumbnailInteractor";
    }

    protected r(n nVar, ar arVar) {
        super(nVar);
        this.f17117c = nVar;
        this.f17118d = arVar;
    }

    public void a(String str) {
        this.f17119e = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (TextUtils.isEmpty(this.f17119e)) {
            this.f17117c.a("GET_YOUTUBE_INFO_ERROR", new a(""));
            return;
        }
        try {
            Bitmap h = w.a(this.f17118d.getApplicationContext()).a(String.format("https://i.ytimg.com/vi/%1$s/mqdefault.jpg", new Object[]{this.f17119e})).h();
            if (h == null) {
                this.f17117c.a("GET_YOUTUBE_INFO_ERROR", new a(""));
                return;
            }
            String a2 = com.shopee.app.h.b.a.a().a(l.a().a(h, 80));
            String str = "file:///" + f.a().b(a2);
            com.garena.android.appkit.d.a.b("HELLO: %s", str);
            this.f17117c.a("YOUTUBE_VIDEO_ADDED", new a(str + "," + this.f17119e));
        } catch (IOException e2) {
            com.garena.android.appkit.d.a.a(e2);
            try {
                com.shopee.app.util.youtube.f.a("17", true, this.f17119e);
            } catch (g e3) {
                this.f17117c.a("GET_YOUTUBE_INFO_ERROR", new a(e3.errorCode));
            } catch (IOException unused) {
                this.f17117c.a("GET_YOUTUBE_INFO_ERROR", new a(""));
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }
}
