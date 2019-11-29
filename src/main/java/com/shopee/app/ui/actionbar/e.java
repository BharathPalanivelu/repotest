package com.shopee.app.ui.actionbar;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.garena.android.appkit.tools.a.b;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected PopupWindow f19297a;

    /* renamed from: b  reason: collision with root package name */
    protected View f19298b;

    /* renamed from: c  reason: collision with root package name */
    protected LinearLayout f19299c;

    /* renamed from: d  reason: collision with root package name */
    protected a f19300d;

    public interface c {
        void a(int i, Object obj);
    }

    public interface d {
        void a(boolean z);
    }

    public e(Context context, a aVar) {
        this.f19300d = aVar;
        this.f19297a = new PopupWindow(context);
        a(context);
        b(context);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        this.f19298b = View.inflate(context, R.layout.action_drop_down_layout, (ViewGroup) null);
        this.f19299c = (LinearLayout) this.f19298b.findViewById(R.id.container);
        this.f19297a.setWindowLayoutMode(-2, -2);
        this.f19297a.setContentView(this.f19298b);
        this.f19297a.setFocusable(true);
        this.f19297a.setBackgroundDrawable(new BitmapDrawable());
    }

    /* access modifiers changed from: protected */
    public void b(Context context) {
        int i = 0;
        for (b next : this.f19300d.f19301a) {
            f fVar = new f(context);
            fVar.a(next);
            boolean z = true;
            if (i >= this.f19300d.f19301a.size() - 1) {
                z = false;
            }
            fVar.setDividerVisibility(z);
            if (next.f19309e > 0) {
                fVar.a(next.f19309e);
            } else if (!TextUtils.isEmpty(next.f19310f)) {
                fVar.a(next.f19310f);
            }
            fVar.setTag(new Pair(Integer.valueOf(next.f19305a), next.f19308d));
            fVar.setOnClickListener(this);
            this.f19299c.addView(fVar, new LinearLayout.LayoutParams(-1, b.a.m * 2));
            i++;
        }
    }

    public void a(View view) {
        this.f19297a.showAsDropDown(view, (-view.getMeasuredWidth()) / 2, (-view.getMeasuredHeight()) + b.a.f7694e);
        this.f19297a.update();
        if (this.f19300d.f19303c != null) {
            this.f19300d.f19303c.a(true);
        }
    }

    public void b(View view) {
        this.f19297a.showAsDropDown(view, 0, 0);
        this.f19297a.update();
        if (this.f19300d.f19303c != null) {
            this.f19300d.f19303c.a(true);
        }
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f19297a.setOnDismissListener(onDismissListener);
    }

    public void onClick(View view) {
        this.f19297a.dismiss();
        Pair pair = (Pair) view.getTag();
        this.f19300d.f19302b.a(((Integer) pair.first).intValue(), pair.second);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f19305a;

        /* renamed from: b  reason: collision with root package name */
        public int f19306b;

        /* renamed from: c  reason: collision with root package name */
        public String f19307c;

        /* renamed from: d  reason: collision with root package name */
        public Object f19308d;

        /* renamed from: e  reason: collision with root package name */
        public int f19309e;

        /* renamed from: f  reason: collision with root package name */
        public String f19310f;

        public b(int i, String str, Object obj, String str2) {
            this.f19305a = i;
            this.f19307c = str;
            this.f19308d = obj;
            this.f19310f = str2;
        }

        public b(int i, int i2, Object obj, int i3) {
            this.f19305a = i;
            this.f19306b = i2;
            this.f19308d = obj;
            this.f19309e = i3;
        }

        public b(int i, int i2, Object obj, String str) {
            this.f19305a = i;
            this.f19306b = i2;
            this.f19308d = obj;
            this.f19310f = str;
        }

        public boolean a() {
            return !TextUtils.isEmpty(this.f19310f) || this.f19309e > 0;
        }

        public String b() {
            int i = this.f19306b;
            if (i != 0) {
                return com.garena.android.appkit.tools.b.e(i);
            }
            return !TextUtils.isEmpty(this.f19307c) ? this.f19307c : "";
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        List<b> f19301a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        c f19302b;

        /* renamed from: c  reason: collision with root package name */
        d f19303c;

        /* renamed from: d  reason: collision with root package name */
        boolean f19304d = false;

        public a a(int i, int i2, Object obj, int i3) {
            this.f19301a.add(new b(i2, i, obj, i3));
            return this;
        }

        public a a(int i, int i2, int i3) {
            this.f19301a.add(new b(i2, i, (Object) null, i3));
            return this;
        }

        public a a(int i, int i2, String str) {
            this.f19301a.add(new b(i2, i, (Object) null, str));
            return this;
        }

        public a a(b bVar) {
            this.f19301a.add(bVar);
            return this;
        }

        public a a(boolean z) {
            this.f19304d = z;
            return this;
        }

        public e a(Context context) {
            return new e(context, this);
        }

        public e b(Context context) {
            return new j(context, this);
        }

        public a a(c cVar) {
            this.f19302b = cVar;
            return this;
        }

        public a a(d dVar) {
            this.f19303c = dVar;
            return this;
        }
    }
}
