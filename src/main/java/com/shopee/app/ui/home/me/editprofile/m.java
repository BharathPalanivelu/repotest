package com.shopee.app.ui.home.me.editprofile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.facebook.places.model.PlaceFields;
import com.garena.android.appkit.tools.b;
import com.garena.c.a.a;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class m extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    EditText f22410a;

    /* renamed from: b  reason: collision with root package name */
    EditText f22411b;

    /* renamed from: c  reason: collision with root package name */
    EditText f22412c;

    /* renamed from: d  reason: collision with root package name */
    EditText f22413d;

    /* renamed from: e  reason: collision with root package name */
    Button f22414e;

    /* renamed from: f  reason: collision with root package name */
    Activity f22415f;

    /* renamed from: g  reason: collision with root package name */
    private float f22416g = 370.0f;
    private float h = 370.0f;
    private TextWatcher i = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (m.this.c()) {
                m.this.f22414e.setClickable(true);
                m.this.f22414e.setTextColor(b.a(R.color.white96));
                return;
            }
            m.this.f22414e.setClickable(false);
            m.this.f22414e.setTextColor(b.a(R.color.white54));
        }
    };

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putFloat("previousLongitude", this.f22416g);
        bundle.putFloat("previousLongitude", this.f22416g);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f22416g = bundle.getFloat("previousLongitude");
            this.f22416g = bundle.getFloat("previousLongitude");
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r9 = this;
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r9.getContext()
            java.lang.Class<com.shopee.app.ui.maps.BBMapLocationActivity> r2 = com.shopee.app.ui.maps.BBMapLocationActivity.class
            r0.<init>(r1, r2)
            android.location.Geocoder r1 = new android.location.Geocoder
            android.content.Context r2 = r9.getContext()
            r1.<init>(r2)
            android.widget.EditText r2 = r9.f22412c
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.trim()
            r3 = 10
            r4 = 1136197632(0x43b90000, float:370.0)
            java.util.List r1 = r1.getFromLocationName(r2, r3)     // Catch:{ IOException -> 0x006f }
            r2 = 0
            java.util.Iterator r3 = r1.iterator()     // Catch:{ IOException -> 0x006f }
        L_0x002f:
            boolean r5 = r3.hasNext()     // Catch:{ IOException -> 0x006f }
            if (r5 == 0) goto L_0x0048
            java.lang.Object r5 = r3.next()     // Catch:{ IOException -> 0x006f }
            android.location.Address r5 = (android.location.Address) r5     // Catch:{ IOException -> 0x006f }
            java.lang.String r6 = "ID"
            java.lang.String r7 = r5.getCountryCode()     // Catch:{ IOException -> 0x006f }
            boolean r6 = r6.equals(r7)     // Catch:{ IOException -> 0x006f }
            if (r6 == 0) goto L_0x002f
            r2 = r5
        L_0x0048:
            if (r2 != 0) goto L_0x005a
            if (r1 == 0) goto L_0x005a
            boolean r3 = r1.isEmpty()     // Catch:{ IOException -> 0x006f }
            if (r3 != 0) goto L_0x005a
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch:{ IOException -> 0x006f }
            r2 = r1
            android.location.Address r2 = (android.location.Address) r2     // Catch:{ IOException -> 0x006f }
        L_0x005a:
            if (r2 == 0) goto L_0x006c
            double r5 = r2.getLatitude()     // Catch:{ IOException -> 0x006f }
            float r1 = (float) r5
            double r2 = r2.getLongitude()     // Catch:{ IOException -> 0x0067 }
            float r2 = (float) r2
            goto L_0x0078
        L_0x0067:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
            goto L_0x0072
        L_0x006c:
            r1 = 1136197632(0x43b90000, float:370.0)
            goto L_0x0076
        L_0x006f:
            r1 = move-exception
            r2 = 1136197632(0x43b90000, float:370.0)
        L_0x0072:
            com.garena.android.appkit.d.a.a(r1)
            r1 = r2
        L_0x0076:
            r2 = 1136197632(0x43b90000, float:370.0)
        L_0x0078:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0085
            float r3 = r9.h
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0085
            float r2 = r9.f22416g
            r1 = r3
        L_0x0085:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0093
            java.lang.String r3 = "BUNDLE_LATITUDE_KEY"
            r0.putExtra(r3, r1)
            java.lang.String r1 = "BUNDLE_LONGITUDE_KEY"
            r0.putExtra(r1, r2)
        L_0x0093:
            android.content.Context r1 = r9.getContext()
            android.app.Activity r1 = (android.app.Activity) r1
            r2 = 1041(0x411, float:1.459E-42)
            r1.startActivityForResult(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.home.me.editprofile.m.a():void");
    }

    public m(Context context) {
        super(context);
        setId(R.id.edit_profile_root_view);
        ((l) ((x) context).b()).a(this);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f22414e.setClickable(false);
        this.f22414e.setTextColor(b.a(R.color.white54));
        this.f22410a.addTextChangedListener(this.i);
        this.f22411b.addTextChangedListener(this.i);
        this.f22412c.addTextChangedListener(this.i);
        this.f22413d.addTextChangedListener(this.i);
        this.f22412c.setInputType(8192);
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return !TextUtils.isEmpty(this.f22410a.getText().toString().trim()) && !TextUtils.isEmpty(this.f22411b.getText().toString().trim()) && !TextUtils.isEmpty(this.f22412c.getText().toString().trim()) && !TextUtils.isEmpty(this.f22413d.getText().toString().trim());
    }

    public void a(a aVar) {
        aVar.f7802d = this.f22413d.getText().toString().trim() + ", " + this.f22412c.getText().toString().trim() + ", " + this.f22411b.getText().toString().trim() + ", " + this.f22410a.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra(PlaceFields.LOCATION, aVar.b());
        this.f22415f.setResult(-1, intent);
        this.f22415f.finish();
    }

    public void a(String str) {
        String[] split = str.split(",");
        int length = split.length;
        if (split.length > 3) {
            int i2 = length - 1;
            int i3 = length - 2;
            int i4 = length - 3;
            int length2 = split[i2].length() + 3 + split[i3].length() + split[i4].length();
            this.f22410a.setText(split[i2].substring(1));
            this.f22411b.setText(split[i3].substring(1));
            this.f22412c.setText(split[i4].substring(1));
            this.f22413d.setText(str.substring(0, str.length() - length2));
        }
    }

    public void a(float f2, float f3) {
        this.h = f2;
        this.f22416g = f3;
    }
}
