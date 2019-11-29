package androidx.core.g;

import android.view.View;
import android.view.ViewParent;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f1791a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f1792b;

    /* renamed from: c  reason: collision with root package name */
    private final View f1793c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1794d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f1795e;

    public m(View view) {
        this.f1793c = view;
    }

    public void a(boolean z) {
        if (this.f1794d) {
            w.z(this.f1793c);
        }
        this.f1794d = z;
    }

    public boolean a() {
        return this.f1794d;
    }

    public boolean b() {
        return a(0);
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        View view = this.f1793c;
        for (ViewParent parent = this.f1793c.getParent(); parent != null; parent = parent.getParent()) {
            if (z.a(parent, view, this.f1793c, i, i2)) {
                a(i2, parent);
                z.b(parent, view, this.f1793c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        ViewParent d2 = d(i);
        if (d2 != null) {
            z.a(d2, this.f1793c, i);
            a(i, (ViewParent) null);
        }
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return b(i, i2, i3, i4, iArr, 0, (int[]) null);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return b(i, i2, i3, i4, iArr, i5, (int[]) null);
    }

    public void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    private boolean b(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (a()) {
            ViewParent d2 = d(i5);
            if (d2 == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                if (iArr4 != null) {
                    this.f1793c.getLocationInWindow(iArr4);
                    i7 = iArr4[0];
                    i6 = iArr4[1];
                } else {
                    i7 = 0;
                    i6 = 0;
                }
                if (iArr2 == null) {
                    int[] d3 = d();
                    d3[0] = 0;
                    d3[1] = 0;
                    iArr3 = d3;
                } else {
                    iArr3 = iArr2;
                }
                z.a(d2, this.f1793c, i, i2, i3, i4, i5, iArr3);
                if (iArr4 != null) {
                    this.f1793c.getLocationInWindow(iArr4);
                    iArr4[0] = iArr4[0] - i7;
                    iArr4[1] = iArr4[1] - i6;
                }
                return true;
            } else if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int i4;
        int i5;
        if (a()) {
            ViewParent d2 = d(i3);
            if (d2 == null) {
                return false;
            }
            if (i != 0 || i2 != 0) {
                if (iArr2 != null) {
                    this.f1793c.getLocationInWindow(iArr2);
                    i5 = iArr2[0];
                    i4 = iArr2[1];
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                if (iArr == null) {
                    iArr = d();
                }
                iArr[0] = 0;
                iArr[1] = 0;
                z.a(d2, this.f1793c, i, i2, iArr, i3);
                if (iArr2 != null) {
                    this.f1793c.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i5;
                    iArr2[1] = iArr2[1] - i4;
                }
                if (iArr[0] == 0 && iArr[1] == 0) {
                    return false;
                }
                return true;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
        }
        return false;
    }

    public boolean a(float f2, float f3, boolean z) {
        if (a()) {
            ViewParent d2 = d(0);
            if (d2 != null) {
                return z.a(d2, this.f1793c, f2, f3, z);
            }
        }
        return false;
    }

    public boolean a(float f2, float f3) {
        if (a()) {
            ViewParent d2 = d(0);
            if (d2 != null) {
                return z.a(d2, this.f1793c, f2, f3);
            }
        }
        return false;
    }

    private ViewParent d(int i) {
        if (i == 0) {
            return this.f1791a;
        }
        if (i != 1) {
            return null;
        }
        return this.f1792b;
    }

    private void a(int i, ViewParent viewParent) {
        if (i == 0) {
            this.f1791a = viewParent;
        } else if (i == 1) {
            this.f1792b = viewParent;
        }
    }

    private int[] d() {
        if (this.f1795e == null) {
            this.f1795e = new int[2];
        }
        return this.f1795e;
    }
}
