package com.shopee.app.d.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.view.View;
import com.garena.android.appkit.tools.b;
import com.shopee.app.util.bi;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final Object f15980a;

    /* renamed from: b  reason: collision with root package name */
    protected bi f15981b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15982c = false;

    public long a() {
        return 0;
    }

    public String b() {
        return "";
    }

    public String j() {
        return "";
    }

    public String k() {
        return "";
    }

    public String l() {
        return "";
    }

    public String m() {
        return "";
    }

    public int o() {
        return 0;
    }

    public a(Object obj) {
        this.f15980a = obj;
        this.f15981b = new bi();
    }

    public final boolean c() {
        return !TextUtils.isEmpty(b());
    }

    public C0251a d() {
        return new C0251a();
    }

    public C0251a e() {
        return new C0251a();
    }

    public C0251a f() {
        return new C0251a();
    }

    public C0251a g() {
        return new C0251a();
    }

    public C0251a h() {
        return new C0251a();
    }

    public C0251a i() {
        return new C0251a();
    }

    public final boolean n() {
        return !TextUtils.isEmpty(l());
    }

    /* access modifiers changed from: protected */
    public String a(int i) {
        return b.e(i);
    }

    public final boolean p() {
        return d().f15985c != 2;
    }

    /* access modifiers changed from: protected */
    public CharSequence b(int i) {
        return a(i);
    }

    public boolean q() {
        return this.f15982c;
    }

    public void a(boolean z) {
        this.f15982c = z;
    }

    /* renamed from: com.shopee.app.d.b.a.a$a  reason: collision with other inner class name */
    public static class C0251a {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f15983a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f15984b;

        /* renamed from: c  reason: collision with root package name */
        public int f15985c = 2;

        public C0251a() {
        }

        public C0251a(CharSequence charSequence, int i, View.OnClickListener onClickListener) {
            this.f15983a = charSequence;
            this.f15984b = onClickListener;
            this.f15985c = i;
        }

        public int a() {
            return this.f15985c == 2 ? 8 : 0;
        }

        public boolean b() {
            return this.f15985c != 1;
        }
    }

    public final Activity a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
