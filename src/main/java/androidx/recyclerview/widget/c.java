package androidx.recyclerview.widget;

public class c implements n {

    /* renamed from: a  reason: collision with root package name */
    final n f2826a;

    /* renamed from: b  reason: collision with root package name */
    int f2827b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f2828c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f2829d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f2830e = null;

    public c(n nVar) {
        this.f2826a = nVar;
    }

    public void a() {
        int i = this.f2827b;
        if (i != 0) {
            if (i == 1) {
                this.f2826a.a(this.f2828c, this.f2829d);
            } else if (i == 2) {
                this.f2826a.b(this.f2828c, this.f2829d);
            } else if (i == 3) {
                this.f2826a.a(this.f2828c, this.f2829d, this.f2830e);
            }
            this.f2830e = null;
            this.f2827b = 0;
        }
    }

    public void a(int i, int i2) {
        if (this.f2827b == 1) {
            int i3 = this.f2828c;
            if (i >= i3) {
                int i4 = this.f2829d;
                if (i <= i3 + i4) {
                    this.f2829d = i4 + i2;
                    this.f2828c = Math.min(i, i3);
                    return;
                }
            }
        }
        a();
        this.f2828c = i;
        this.f2829d = i2;
        this.f2827b = 1;
    }

    public void b(int i, int i2) {
        if (this.f2827b == 2) {
            int i3 = this.f2828c;
            if (i3 >= i && i3 <= i + i2) {
                this.f2829d += i2;
                this.f2828c = i;
                return;
            }
        }
        a();
        this.f2828c = i;
        this.f2829d = i2;
        this.f2827b = 2;
    }

    public void c(int i, int i2) {
        a();
        this.f2826a.c(i, i2);
    }

    public void a(int i, int i2, Object obj) {
        if (this.f2827b == 3) {
            int i3 = this.f2828c;
            int i4 = this.f2829d;
            if (i <= i3 + i4) {
                int i5 = i + i2;
                if (i5 >= i3 && this.f2830e == obj) {
                    this.f2828c = Math.min(i, i3);
                    this.f2829d = Math.max(i4 + i3, i5) - this.f2828c;
                    return;
                }
            }
        }
        a();
        this.f2828c = i;
        this.f2829d = i2;
        this.f2830e = obj;
        this.f2827b = 3;
    }
}
