package com.shopee.app.g;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import androidx.core.content.FileProvider;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.g.a;
import com.garena.g.c;
import com.shopee.app.d.c.de;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.g.h;
import com.shopee.app.h.r;
import com.shopee.app.ui.a.q;
import com.shopee.app.util.bi;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import java.io.File;

public class i extends q<h> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final bi f17542a;

    /* renamed from: c  reason: collision with root package name */
    private final de f17543c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f17544d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17545e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Runnable f17546f = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17547g = false;
    private e h = new g() {
        public void onEvent(a aVar) {
            com.garena.android.appkit.d.a.b("onNoWatermarkImageReady", new Object[0]);
            Pair pair = (Pair) aVar.data;
            if (((Integer) pair.second).intValue() == i.this.hashCode() && !i.this.f17544d) {
                i.this.f17542a.a("PROCESSING_IMAGE_DONE", new a());
                if (((Boolean) pair.first).booleanValue() && i.this.f17546f != null) {
                    i.this.f17546f.run();
                }
                Runnable unused = i.this.f17546f = null;
            }
        }
    };
    private e i = new g() {
        public void onEvent(a aVar) {
            Pair pair = (Pair) aVar.data;
            if (((Integer) pair.second).intValue() == i.this.hashCode() && i.this.f17544d) {
                i.this.f17542a.a("PROCESSING_IMAGE_DONE", new a());
                if (((Boolean) pair.first).booleanValue() && i.this.f17546f != null) {
                    i.this.f17546f.run();
                }
                Runnable unused = i.this.f17546f = null;
            }
        }
    };

    public void a() {
    }

    public void b() {
    }

    public i(bi biVar, de deVar) {
        this.f17542a = biVar;
        this.f17543c = deVar;
        this.f17542a.a("NO_WATERMARK_IMAGE_COMPLETE", this.h);
        this.f17542a.a("WATERMARK_IMAGE_COMPLETE", this.i);
    }

    public void a(String str, ShareMessage shareMessage, ImageConfig imageConfig, String str2) {
        this.f17543c.a(str, shareMessage, imageConfig, hashCode(), str2);
    }

    public void a(ShareMessage shareMessage) {
        b.a("FACEBOOK_SHARING_FB", new a(shareMessage), b.a.UI_BUS);
    }

    public h.c a(com.garena.g.a.a aVar, Context context, a.C0132a aVar2, String str, boolean z, h.f fVar) {
        if (new File(str.replace("file:///", "")).exists()) {
            aVar.a(context, aVar2.a(a(context, str)).b());
            return h.c.SUCCESS;
        } else if (z && this.f17545e) {
            r.a().b((int) R.string.sp_share_image_fail);
            return h.c.FAILED;
        } else if (z || !this.f17547g) {
            this.f17544d = z;
            this.f17542a.a("PROCESSING_IMAGE", new com.garena.android.appkit.b.a());
            final com.garena.g.a.a aVar3 = aVar;
            final Context context2 = context;
            final a.C0132a aVar4 = aVar2;
            final String str2 = str;
            final h.f fVar2 = fVar;
            this.f17546f = new Runnable() {
                public void run() {
                    try {
                        aVar3.a(context2, aVar4.a(i.this.a(context2, str2)).b());
                        fVar2.a(h.c.SUCCESS);
                    } catch (c unused) {
                        fVar2.a(h.c.APP_NOT_INSTALLED);
                    }
                }
            };
            return h.c.PROCESSING_IMAGE;
        } else {
            r.a().b((int) R.string.sp_share_image_fail);
            return h.c.FAILED;
        }
    }

    /* access modifiers changed from: private */
    public Uri a(Context context, String str) {
        return FileProvider.a(context, "com.shopee.id.fileprovider", new File(str.replace("file:///", "")));
    }
}
