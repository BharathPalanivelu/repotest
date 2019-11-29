package com.shopee.app.ui.image;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;

public class m extends b implements x<h> {

    /* renamed from: a  reason: collision with root package name */
    String f23034a;

    /* renamed from: b  reason: collision with root package name */
    boolean f23035b;

    /* renamed from: c  reason: collision with root package name */
    Rect f23036c;

    /* renamed from: d  reason: collision with root package name */
    String f23037d;

    /* renamed from: e  reason: collision with root package name */
    double f23038e;

    /* renamed from: f  reason: collision with root package name */
    boolean f23039f;

    /* renamed from: g  reason: collision with root package name */
    boolean f23040g;
    boolean h;
    private h i;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
        a((View) q.a(this, this.f23034a, this.f23035b, this.f23040g, this.f23036c, this.f23037d, this.f23038e, this.h, this.f23039f));
        v().setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1);
    }

    /* renamed from: c */
    public h b() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.i = e.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.i.a(this);
    }
}
