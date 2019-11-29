package com.shopee.app.ui.setting;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f25182a;

    /* renamed from: b  reason: collision with root package name */
    private a f25183b;

    public interface a {
        void a();

        void b();
    }

    public b(Context context) {
        super(context);
    }

    public void setFont(String str) {
        AssetManager assets = getContext().getAssets();
        this.f25182a.setTypeface(Typeface.createFromAsset(assets, "fonts/" + str));
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a aVar = this.f25183b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a aVar = this.f25183b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setCallback(a aVar) {
        this.f25183b = aVar;
    }
}
