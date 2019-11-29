package com.google.android.exoplayer2.j.f;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Log;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;

final class e extends com.google.android.exoplayer2.j.a {
    public final long m;
    public final long n;

    public e(CharSequence charSequence) {
        this(0, 0, charSequence);
    }

    public e(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, (Layout.Alignment) null, Float.MIN_VALUE, RNCartPanelDataEntity.NULL_VALUE, RNCartPanelDataEntity.NULL_VALUE, Float.MIN_VALUE, RNCartPanelDataEntity.NULL_VALUE, Float.MIN_VALUE);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f2, int i, int i2, float f3, int i3, float f4) {
        super(charSequence, alignment, f2, i, i2, f3, i3, f4);
        this.m = j;
        this.n = j2;
    }

    public boolean a() {
        return this.f10432d == Float.MIN_VALUE && this.f10435g == Float.MIN_VALUE;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f10592a;

        /* renamed from: b  reason: collision with root package name */
        private long f10593b;

        /* renamed from: c  reason: collision with root package name */
        private SpannableStringBuilder f10594c;

        /* renamed from: d  reason: collision with root package name */
        private Layout.Alignment f10595d;

        /* renamed from: e  reason: collision with root package name */
        private float f10596e;

        /* renamed from: f  reason: collision with root package name */
        private int f10597f;

        /* renamed from: g  reason: collision with root package name */
        private int f10598g;
        private float h;
        private int i;
        private float j;

        public a() {
            a();
        }

        public void a() {
            this.f10592a = 0;
            this.f10593b = 0;
            this.f10594c = null;
            this.f10595d = null;
            this.f10596e = Float.MIN_VALUE;
            this.f10597f = RNCartPanelDataEntity.NULL_VALUE;
            this.f10598g = RNCartPanelDataEntity.NULL_VALUE;
            this.h = Float.MIN_VALUE;
            this.i = RNCartPanelDataEntity.NULL_VALUE;
            this.j = Float.MIN_VALUE;
        }

        public e b() {
            if (this.h != Float.MIN_VALUE && this.i == Integer.MIN_VALUE) {
                c();
            }
            return new e(this.f10592a, this.f10593b, this.f10594c, this.f10595d, this.f10596e, this.f10597f, this.f10598g, this.h, this.i, this.j);
        }

        public a a(long j2) {
            this.f10592a = j2;
            return this;
        }

        public a b(long j2) {
            this.f10593b = j2;
            return this;
        }

        public a a(SpannableStringBuilder spannableStringBuilder) {
            this.f10594c = spannableStringBuilder;
            return this;
        }

        public a a(Layout.Alignment alignment) {
            this.f10595d = alignment;
            return this;
        }

        public a a(float f2) {
            this.f10596e = f2;
            return this;
        }

        public a a(int i2) {
            this.f10597f = i2;
            return this;
        }

        public a b(int i2) {
            this.f10598g = i2;
            return this;
        }

        public a b(float f2) {
            this.h = f2;
            return this;
        }

        public a c(int i2) {
            this.i = i2;
            return this;
        }

        public a c(float f2) {
            this.j = f2;
            return this;
        }

        private a c() {
            if (this.f10595d == null) {
                this.i = RNCartPanelDataEntity.NULL_VALUE;
            } else {
                int i2 = AnonymousClass1.f10591a[this.f10595d.ordinal()];
                if (i2 == 1) {
                    this.i = 0;
                } else if (i2 == 2) {
                    this.i = 1;
                } else if (i2 != 3) {
                    Log.w("WebvttCueBuilder", "Unrecognized alignment: " + this.f10595d);
                    this.i = 0;
                } else {
                    this.i = 2;
                }
            }
            return this;
        }
    }

    /* renamed from: com.google.android.exoplayer2.j.f.e$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10591a = new int[Layout.Alignment.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                android.text.Layout$Alignment[] r0 = android.text.Layout.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10591a = r0
                int[] r0 = f10591a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f10591a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f10591a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.f.e.AnonymousClass1.<clinit>():void");
        }
    }
}
