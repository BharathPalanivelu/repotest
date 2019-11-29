package androidx.recyclerview.widget;

import android.view.View;

class t {

    /* renamed from: a  reason: collision with root package name */
    final b f2971a;

    /* renamed from: b  reason: collision with root package name */
    a f2972b = new a();

    interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    t(b bVar) {
        this.f2971a = bVar;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2973a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f2974b;

        /* renamed from: c  reason: collision with root package name */
        int f2975c;

        /* renamed from: d  reason: collision with root package name */
        int f2976d;

        /* renamed from: e  reason: collision with root package name */
        int f2977e;

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2, int i3, int i4) {
            this.f2974b = i;
            this.f2975c = i2;
            this.f2976d = i3;
            this.f2977e = i4;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f2973a = i | this.f2973a;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f2973a = 0;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i = this.f2973a;
            if ((i & 7) != 0 && (i & (a(this.f2976d, this.f2974b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f2973a;
            if ((i2 & 112) != 0 && (i2 & (a(this.f2976d, this.f2975c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f2973a;
            if ((i3 & 1792) != 0 && (i3 & (a(this.f2977e, this.f2974b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f2973a;
            if ((i4 & 28672) == 0 || (i4 & (a(this.f2977e, this.f2975c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int a2 = this.f2971a.a();
        int b2 = this.f2971a.b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.f2971a.a(i);
            this.f2972b.a(a2, b2, this.f2971a.a(a3), this.f2971a.b(a3));
            if (i3 != 0) {
                this.f2972b.a();
                this.f2972b.a(i3);
                if (this.f2972b.b()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                this.f2972b.a();
                this.f2972b.a(i4);
                if (this.f2972b.b()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        this.f2972b.a(this.f2971a.a(), this.f2971a.b(), this.f2971a.a(view), this.f2971a.b(view));
        if (i == 0) {
            return false;
        }
        this.f2972b.a();
        this.f2972b.a(i);
        return this.f2972b.b();
    }
}
