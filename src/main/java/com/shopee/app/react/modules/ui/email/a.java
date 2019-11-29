package com.shopee.app.react.modules.ui.email;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.UiThreadUtil;
import com.garena.android.appkit.b.i;
import com.google.a.o;
import com.shopee.app.d.c.dl;
import com.shopee.app.g.d;
import com.shopee.app.h.l;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.OpenEmailComposer;
import com.shopee.id.R;
import java.io.File;

public class a extends b implements com.shopee.app.react.util.a {

    /* renamed from: f  reason: collision with root package name */
    private static String[] f18832f = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with root package name */
    dl f18833a;

    /* renamed from: b  reason: collision with root package name */
    private i f18834b = com.garena.a.a.a.b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private Promise f18835c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public c f18836d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public OpenEmailComposer f18837e;

    public a(c cVar) {
        this.f18836d = cVar;
        this.f18836d.c().a(this);
    }

    public void a(String str, Promise promise) {
        this.f18837e = (OpenEmailComposer) WebRegister.GSON.a(str, OpenEmailComposer.class);
        OpenEmailComposer openEmailComposer = this.f18837e;
        if (openEmailComposer == null) {
            d(promise);
        } else if (openEmailComposer.hasImage()) {
            a(promise);
        } else {
            b(promise);
        }
    }

    private void a(Promise promise) {
        this.f18835c = promise;
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(this.f18836d.a())) {
            this.f18833a.a(this.f18837e.getImageUrl(), this.f18837e.getImageFilename(), true);
        } else {
            a(this.f18836d.a(), this.f18837e.getImageUrl(), this.f18837e.getImageFilename());
        }
    }

    private void b(final Promise promise) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("message/rfc822");
                    intent.putExtra("android.intent.extra.SUBJECT", a.this.f18837e.getSubject());
                    intent.putExtra("android.intent.extra.TEXT", a.this.f18837e.getBody());
                    if (a.this.f18837e.hasImage()) {
                        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(l.b() + a.this.f18837e.getImageFilename())));
                    }
                    a.this.f18836d.a().startActivity(intent);
                    a.this.c(promise);
                } catch (Exception unused) {
                    a.this.d(promise);
                }
            }
        });
    }

    public void a() {
        this.f18834b.a();
    }

    public void b() {
        this.f18834b.c();
    }

    public void c() {
        this.f18834b.d();
    }

    public void d() {
        this.f18834b.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Boolean, Boolean> pair) {
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        boolean booleanValue2 = ((Boolean) pair.second).booleanValue();
        Promise promise = this.f18835c;
        if (promise != null && booleanValue) {
            if (booleanValue2) {
                b(promise);
            } else {
                d(promise);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Promise promise) {
        o oVar = new o();
        oVar.a("status", (Number) 1);
        promise.resolve(oVar.toString());
    }

    /* access modifiers changed from: private */
    public void d(Promise promise) {
        o oVar = new o();
        oVar.a("status", (Number) 1);
        promise.resolve(oVar.toString());
    }

    private void a(Activity activity, final String str, final String str2) {
        d.a(activity, f18832f, 512, 0, R.string.msg_permission_gallery, R.string.sp_no_storage_access, R.string.sp_to_allow_gallery_hint, new d.a() {
            public void b() {
            }

            public void c() {
            }

            public void a() {
                a.this.f18833a.a(str, str2, true);
            }
        });
    }
}
