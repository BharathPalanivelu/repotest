package com.shopee.app.ui.product.add.wholesale;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.g.e;
import com.shopee.app.ui.a.q;
import com.shopee.id.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class k extends q<l> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24210a;

    /* renamed from: c  reason: collision with root package name */
    private final SettingConfigStore f24211c;

    /* renamed from: d  reason: collision with root package name */
    private final List<WholesaleTierModel> f24212d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    private List<WholesaleTierModel> f24213e;

    /* renamed from: f  reason: collision with root package name */
    private Long f24214f;

    /* renamed from: g  reason: collision with root package name */
    private final LinkedList<WeakReference<f>> f24215g = new LinkedList<>();

    public void a() {
    }

    public void b() {
    }

    public k(Context context, SettingConfigStore settingConfigStore) {
        this.f24210a = context;
        this.f24211c = settingConfigStore;
    }

    public void a(Long l) {
        this.f24214f = l;
    }

    public Long e() {
        return this.f24214f;
    }

    public void a(List<WholesaleTierModel> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        if (list.isEmpty()) {
            f();
        } else {
            for (WholesaleTierModel a2 : list) {
                a(a2);
            }
        }
        this.f24213e = new LinkedList(this.f24212d);
    }

    private void a(WholesaleTierModel wholesaleTierModel) {
        wholesaleTierModel.a(this.f24212d);
        Long l = this.f24214f;
        wholesaleTierModel.a(l != null ? l.longValue() : 0);
        this.f24212d.add(wholesaleTierModel);
        f a2 = ((l) this.f19220b).a(wholesaleTierModel);
        if (this.f24212d.size() == 1) {
            ((l) this.f19220b).showKeyboard(a2.getMinView());
        }
        this.f24215g.add(new WeakReference(a2));
    }

    public void f() {
        String str;
        if (this.f24212d.size() == this.f24211c.wholesaleMaxTier()) {
            ((l) this.f19220b).a(this.f24210a.getString(R.string.wholesale_maximum_reached));
            return;
        }
        if (!this.f24212d.isEmpty()) {
            try {
                str = String.valueOf(a(this.f24212d.get(this.f24212d.size() - 1).f24171b));
            } catch (NumberFormatException unused) {
            }
            a(WholesaleTierModel.c().a(this.f24212d).a(str).c("").a());
        }
        str = "";
        a(WholesaleTierModel.c().a(this.f24212d).a(str).c("").a());
    }

    public void a(WholesaleTierModel wholesaleTierModel, View view, boolean z) {
        if (!z && (view instanceof EditText)) {
            int indexOf = this.f24212d.indexOf(wholesaleTierModel);
            EditText editText = (EditText) view;
            editText.setText(b.a(editText.getText().toString()));
            a(indexOf, editText.getText().toString());
        }
    }

    private void a(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            int i2 = i + 1;
            if (i2 < this.f24212d.size()) {
                WholesaleTierModel wholesaleTierModel = this.f24212d.get(i2);
                wholesaleTierModel.f24170a = a(str);
                f fVar = (f) this.f24215g.get(i2).get();
                if (fVar != null) {
                    fVar.a(wholesaleTierModel);
                }
            }
        }
    }

    private String a(String str) {
        try {
            return String.valueOf(Integer.parseInt(str) + 1);
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public void a(WholesaleTierModel wholesaleTierModel, View view) {
        int indexOf = this.f24212d.indexOf(wholesaleTierModel);
        this.f24212d.remove(wholesaleTierModel);
        a((f) view);
        ((l) this.f19220b).removeTier(view);
        a(indexOf);
    }

    private void a(f fVar) {
        Iterator it = this.f24215g.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == fVar) {
                it.remove();
                return;
            }
        }
    }

    private void a(int i) {
        int i2 = i - 1;
        if (i != -1 && i2 >= 0) {
            a(i2, this.f24212d.get(i2).f24171b);
        }
        if (b(i)) {
            f fVar = (f) this.f24215g.get(0).get();
            if (fVar != null) {
                fVar.a(this.f24212d.get(0));
            }
        }
    }

    private boolean b(int i) {
        return i == 0 && !this.f24212d.isEmpty() && !this.f24215g.isEmpty();
    }

    public List<WholesaleTierModel> g() {
        return this.f24212d;
    }

    public void h() {
        i();
        ((l) this.f19220b).l();
        a k = k();
        if (k.b()) {
            ((l) this.f19220b).p();
            return;
        }
        int a2 = k.f24216a;
        long j = 0;
        if (a2 == R.string.wholesale_price_relationship_1) {
            Long l = this.f24214f;
            if (l != null) {
                j = l.longValue();
            }
            String a3 = e.a(j, "IDR", true, false);
            ((l) this.f19220b).a(this.f24210a.getString(a2, new Object[]{a3}));
        } else if (a2 != R.string.wholesale_price_relationship_3) {
            ((l) this.f19220b).a(this.f24210a.getString(a2));
        } else {
            Long a4 = e.a(this.f24211c.getPriceMin(), "IDR");
            if (a4 != null) {
                j = a4.longValue();
            }
            String a5 = e.a(j, "IDR", true, false);
            ((l) this.f19220b).a(this.f24210a.getString(a2, new Object[]{a5}));
        }
        int b2 = k.f24217b;
        if (b2 != -1) {
            ((l) this.f19220b).b(b2);
        }
    }

    public void i() {
        for (WholesaleTierModel next : this.f24212d) {
            a(this.f24212d.indexOf(next), next.f24171b);
        }
    }

    private a k() {
        int i = 0;
        if (!this.f24212d.isEmpty()) {
            WholesaleTierModel wholesaleTierModel = this.f24212d.get(0);
            Long a2 = e.a(wholesaleTierModel.f24172c, "IDR");
            if (a2 != null && this.f24214f != null && a2.longValue() >= this.f24214f.longValue()) {
                return a.a(R.string.wholesale_price_relationship_1, 0);
            }
            try {
                if (Integer.parseInt(wholesaleTierModel.f24170a) < 2) {
                    return a.a(R.string.wholesale_qty_relationship_2, 0);
                }
            } catch (NumberFormatException unused) {
            }
            int size = this.f24212d.size() - 1;
            if (TextUtils.isEmpty(this.f24212d.get(size).f24170a)) {
                return a.a(R.string.wholesale_missing_qty_value, size);
            }
        }
        int size2 = this.f24212d.size();
        while (i < size2) {
            WholesaleTierModel wholesaleTierModel2 = this.f24212d.get(i);
            if (i != size2 - 1 && b(wholesaleTierModel2)) {
                return a.a(R.string.wholesale_missing_qty_value, i);
            }
            if (TextUtils.isEmpty(wholesaleTierModel2.f24172c)) {
                return a.a(R.string.wholesale_missing_price_value, i);
            }
            Long a3 = e.a(wholesaleTierModel2.f24172c, "IDR");
            Long a4 = e.a(this.f24211c.getPriceMin(), "IDR");
            if (a3 != null && a4 != null && a3.longValue() < a4.longValue()) {
                return a.a(R.string.wholesale_price_relationship_3, i);
            }
            if (i > 0) {
                Long a5 = e.a(this.f24212d.get(i - 1).f24172c, "IDR");
                if (!(a3 == null || a5 == null || a3.longValue() < a5.longValue())) {
                    return a.a(R.string.wholesale_price_relationship_2, i);
                }
            }
            try {
                if (Integer.parseInt(wholesaleTierModel2.f24171b) < Integer.parseInt(wholesaleTierModel2.f24170a)) {
                    return a.a(R.string.wholesale_qty_relationship_1, i);
                }
                i++;
            } catch (NumberFormatException unused2) {
            }
        }
        return a.a();
    }

    private boolean b(WholesaleTierModel wholesaleTierModel) {
        return TextUtils.isEmpty(wholesaleTierModel.f24170a) || TextUtils.isEmpty(wholesaleTierModel.f24171b);
    }

    public boolean j() {
        int size = this.f24213e.size();
        if (size != this.f24212d.size()) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (!this.f24213e.get(i).a(this.f24212d.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f24216a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f24217b;

        public static a a() {
            return new a(-1, -1);
        }

        public static a a(int i, int i2) {
            return new a(i, i2);
        }

        private a(int i, int i2) {
            this.f24216a = i;
            this.f24217b = i2;
        }

        public boolean b() {
            return this.f24216a == -1;
        }
    }
}
