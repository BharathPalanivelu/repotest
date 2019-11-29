package com.shopee.app.ui.setting.language;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.aa;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.setting.cell.b;
import com.shopee.app.ui.setting.cell.c;
import com.shopee.app.ui.setting.m;
import com.shopee.app.util.bc;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class d extends LinearLayout implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f25256g = {R.string.label_english, R.string.label_malay, R.string.label_traditional_chinese, R.string.label_simplified_chinese, R.string.label_thai, R.string.label_bahasa_indonesia, R.string.label_vietnamese};

    /* renamed from: a  reason: collision with root package name */
    int f25257a;

    /* renamed from: b  reason: collision with root package name */
    b f25258b;

    /* renamed from: c  reason: collision with root package name */
    bc f25259c;

    /* renamed from: d  reason: collision with root package name */
    aa f25260d;

    /* renamed from: e  reason: collision with root package name */
    r f25261e;

    /* renamed from: f  reason: collision with root package name */
    Activity f25262f;
    private List<b> h;
    private int i = -1;

    private String a(int i2) {
        switch (i2) {
            case R.string.label_bahasa_indonesia:
                return "id";
            case R.string.label_iran:
                return "fa";
            case R.string.label_malay:
                return "ms-my";
            case R.string.label_myanmar:
                return "my";
            case R.string.label_simplified_chinese:
                return "zh-Hans";
            case R.string.label_thai:
                return "th";
            case R.string.label_traditional_chinese:
                return "zh-Hant";
            case R.string.label_vietnamese:
                return "vi";
            default:
                return "en";
        }
    }

    public d(Context context) {
        super(context);
        ((m) ((x) context).b()).a(this);
        setOrientation(1);
        this.h = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f25259c.a(this.f25258b);
        this.f25258b.a(this);
        String b2 = this.f25260d.b();
        for (int i2 : f25256g) {
            if (i2 != 0) {
                b a2 = a(com.garena.android.appkit.tools.b.e(i2));
                a2.setTag(Integer.valueOf(i2));
                if (a(i2).equals(b2)) {
                    a2.setChecked(true);
                }
                this.h.add(a2);
                addView(a2, new LinearLayout.LayoutParams(-1, this.f25257a));
            }
        }
    }

    public b a(String str) {
        b a2 = c.a(getContext());
        a2.a(true);
        a2.setText(str);
        a2.setOnClickListener(this);
        return a2;
    }

    public void b() {
        String a2 = a(this.i);
        if (this.i == -1 || this.f25260d.b().equals(a2)) {
            this.f25262f.finish();
            return;
        }
        this.f25260d.a(a2);
        this.f25261e.a();
        this.f25262f.finish();
        ar.j();
    }

    public void onClick(View view) {
        b bVar = (b) view;
        this.i = ((Integer) view.getTag()).intValue();
        for (b checked : this.h) {
            checked.setChecked(false);
        }
        bVar.setChecked(true);
    }

    public void c() {
        this.f25261e.a();
    }
}
