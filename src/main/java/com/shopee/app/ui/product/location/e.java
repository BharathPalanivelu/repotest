package com.shopee.app.ui.product.location;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.garena.c.a.a;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.bh;
import com.shopee.app.database.orm.bean.DBShopInfo;
import com.shopee.app.network.d.bu;
import com.shopee.app.ui.a.r;
import com.shopee.app.ui.maps.BBMapLocationActivity;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.protocol.shop.Shop;

public class e extends FrameLayout implements r {

    /* renamed from: a  reason: collision with root package name */
    TextView f24636a;

    /* renamed from: b  reason: collision with root package name */
    EditText f24637b;

    /* renamed from: c  reason: collision with root package name */
    d f24638c;

    /* renamed from: d  reason: collision with root package name */
    bc f24639d;

    /* renamed from: e  reason: collision with root package name */
    private float f24640e;

    /* renamed from: f  reason: collision with root package name */
    private float f24641f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24642g = true;

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public e(Context context) {
        super(context);
        setId(R.id.set_location_notice_view);
        ((c) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f24639d.a(this.f24638c);
        this.f24638c.a(this);
    }

    public void e() {
        ((Activity) getContext()).finish();
    }

    public void f() {
        bh bhVar = new bh();
        DBShopInfo b2 = bhVar.b(((Integer) ak.a().i().b(-1)).intValue());
        if (b2 == null) {
            b2 = new DBShopInfo();
        }
        b2.a(((Integer) ak.a().i().b(-1)).intValue());
        b2.f(this.f24637b.getText().toString());
        b2.a((double) this.f24640e);
        b2.b((double) this.f24641f);
        bhVar.a(b2);
        bu buVar = new bu();
        Shop.Builder builder = new Shop.Builder();
        builder.shopid((Integer) ak.a().i().b(-1)).place(this.f24637b.getText().toString()).latitude(Double.valueOf((double) this.f24640e)).longitude(Double.valueOf((double) this.f24641f));
        buVar.a(builder.build());
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f24642g) {
            this.f24642g = false;
            ((Activity) getContext()).startActivityForResult(new Intent(getContext(), BBMapLocationActivity.class), 1041);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        ((Activity) getContext()).startActivityForResult(new Intent(getContext(), BBMapLocationActivity.class), 1041);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putBoolean("isFirstTime", this.f24642g);
        bundle.putFloat("latitude", this.f24640e);
        bundle.putFloat("longitude", this.f24641f);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f24642g = bundle.getBoolean("isFirstTime", true);
            this.f24640e = bundle.getFloat("latitude");
            this.f24641f = bundle.getFloat("longitude");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void a(a aVar) {
        this.f24637b.setFocusable(true);
        this.f24637b.setText(aVar.f7802d);
        this.f24640e = aVar.f7799a;
        this.f24641f = aVar.f7800b;
    }
}
