package com.shopee.app.ui.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.h;
import com.shopee.id.R;
import java.lang.ref.WeakReference;

public abstract class a extends h {

    /* renamed from: a  reason: collision with root package name */
    protected WeakReference<c> f23185a;

    /* renamed from: b  reason: collision with root package name */
    protected View f23186b;

    /* renamed from: c  reason: collision with root package name */
    protected float f23187c;

    /* renamed from: d  reason: collision with root package name */
    protected float f23188d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f23189e = false;

    /* access modifiers changed from: protected */
    public abstract int a();

    /* access modifiers changed from: protected */
    public void a(float f2, float f3, String str, String str2) {
    }

    protected a(Context context) {
        super(context);
        this.f23185a = new WeakReference<>((c) context);
        View a2 = a(context);
        if (a2 != null) {
            addView(a2, new LinearLayout.LayoutParams(-1, -1));
            this.f23186b = a2;
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        this.f23187c = f2;
        this.f23188d = f3;
        this.f23189e = true;
    }

    /* access modifiers changed from: protected */
    public void setTitle(String str) {
        ((TextView) findViewById(R.id.map_view_title)).setText(str);
    }

    /* access modifiers changed from: protected */
    public void setSendAction(boolean z) {
        if (z) {
            findViewById(R.id.send_location).setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void setHomeAction(int i) {
        if (i != -1) {
            ((ImageButton) findViewById(R.id.location_close_window)).setImageDrawable(b.f(i));
        }
    }

    /* access modifiers changed from: protected */
    public View a(Context context) {
        int a2 = a();
        if (a2 != 0) {
            return LayoutInflater.from(context).inflate(a2, (ViewGroup) null);
        }
        return null;
    }

    public c getActivity() {
        return (c) this.f23185a.get();
    }

    public void d() {
        this.f23186b = null;
    }

    public void e() {
        getActivity().finish();
    }

    public LayoutInflater getInflater() {
        return LayoutInflater.from(getActivity());
    }
}
