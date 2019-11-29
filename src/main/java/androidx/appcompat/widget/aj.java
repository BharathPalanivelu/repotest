package androidx.appcompat.widget;

import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

class aj {

    /* renamed from: a  reason: collision with root package name */
    private int f1104a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1105b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1106c = RNCartPanelDataEntity.NULL_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f1107d = RNCartPanelDataEntity.NULL_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f1108e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1109f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1110g = false;
    private boolean h = false;

    aj() {
    }

    public int a() {
        return this.f1104a;
    }

    public int b() {
        return this.f1105b;
    }

    public int c() {
        return this.f1110g ? this.f1105b : this.f1104a;
    }

    public int d() {
        return this.f1110g ? this.f1104a : this.f1105b;
    }

    public void a(int i, int i2) {
        this.f1106c = i;
        this.f1107d = i2;
        this.h = true;
        if (this.f1110g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1104a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1105b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1104a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1105b = i2;
        }
    }

    public void b(int i, int i2) {
        this.h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1108e = i;
            this.f1104a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1109f = i2;
            this.f1105b = i2;
        }
    }

    public void a(boolean z) {
        if (z != this.f1110g) {
            this.f1110g = z;
            if (!this.h) {
                this.f1104a = this.f1108e;
                this.f1105b = this.f1109f;
            } else if (z) {
                int i = this.f1107d;
                if (i == Integer.MIN_VALUE) {
                    i = this.f1108e;
                }
                this.f1104a = i;
                int i2 = this.f1106c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f1109f;
                }
                this.f1105b = i2;
            } else {
                int i3 = this.f1106c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f1108e;
                }
                this.f1104a = i3;
                int i4 = this.f1107d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f1109f;
                }
                this.f1105b = i4;
            }
        }
    }
}
