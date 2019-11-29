package com.google.android.exoplayer2.j.e;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.j.b;
import com.google.android.exoplayer2.j.d;
import com.google.android.exoplayer2.j.f;
import com.google.android.exoplayer2.n.k;
import com.google.android.exoplayer2.n.t;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.nio.charset.Charset;
import java.util.List;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10566a = t.g("styl");

    /* renamed from: b  reason: collision with root package name */
    private static final int f10567b = t.g("tbox");

    /* renamed from: c  reason: collision with root package name */
    private final k f10568c = new k();

    /* renamed from: d  reason: collision with root package name */
    private boolean f10569d;

    /* renamed from: e  reason: collision with root package name */
    private int f10570e;

    /* renamed from: f  reason: collision with root package name */
    private int f10571f;

    /* renamed from: g  reason: collision with root package name */
    private String f10572g;
    private float h;
    private int i;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        a(list);
    }

    private void a(List<byte[]> list) {
        String str = "sans-serif";
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f10570e = bArr[24];
            this.f10571f = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            if ("Serif".equals(new String(bArr, 43, bArr.length - 43))) {
                str = "serif";
            }
            this.f10572g = str;
            this.i = bArr[25] * 20;
            if ((bArr[0] & 32) != 0) {
                z = true;
            }
            this.f10569d = z;
            if (this.f10569d) {
                this.h = ((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) this.i);
                this.h = t.a(this.h, (float) BitmapDescriptorFactory.HUE_RED, 0.95f);
                return;
            }
            this.h = 0.85f;
            return;
        }
        this.f10570e = 0;
        this.f10571f = -1;
        this.f10572g = str;
        this.f10569d = false;
        this.h = 0.85f;
    }

    /* access modifiers changed from: protected */
    public d a(byte[] bArr, int i2, boolean z) throws f {
        this.f10568c.a(bArr, i2);
        String a2 = a(this.f10568c);
        if (a2.isEmpty()) {
            return b.f10573a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        a(spannableStringBuilder2, this.f10570e, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder2, this.f10571f, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder2, this.f10572g, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float f2 = this.h;
        while (this.f10568c.b() >= 8) {
            int d2 = this.f10568c.d();
            int n = this.f10568c.n();
            int n2 = this.f10568c.n();
            boolean z2 = true;
            if (n2 == f10566a) {
                if (this.f10568c.b() < 2) {
                    z2 = false;
                }
                a(z2);
                int h2 = this.f10568c.h();
                for (int i3 = 0; i3 < h2; i3++) {
                    a(this.f10568c, spannableStringBuilder);
                }
            } else if (n2 == f10567b && this.f10569d) {
                if (this.f10568c.b() < 2) {
                    z2 = false;
                }
                a(z2);
                f2 = t.a(((float) this.f10568c.h()) / ((float) this.i), (float) BitmapDescriptorFactory.HUE_RED, 0.95f);
            }
            this.f10568c.c(d2 + n);
        }
        return new b(new com.google.android.exoplayer2.j.a(spannableStringBuilder, (Layout.Alignment) null, f2, 0, 0, Float.MIN_VALUE, RNCartPanelDataEntity.NULL_VALUE, Float.MIN_VALUE));
    }

    private static String a(k kVar) throws f {
        a(kVar.b() >= 2);
        int h2 = kVar.h();
        if (h2 == 0) {
            return "";
        }
        if (kVar.b() >= 2) {
            char f2 = kVar.f();
            if (f2 == 65279 || f2 == 65534) {
                return kVar.a(h2, Charset.forName("UTF-16"));
            }
        }
        return kVar.a(h2, Charset.forName("UTF-8"));
    }

    private void a(k kVar, SpannableStringBuilder spannableStringBuilder) throws f {
        a(kVar.b() >= 12);
        int h2 = kVar.h();
        int h3 = kVar.h();
        kVar.d(2);
        int g2 = kVar.g();
        kVar.d(1);
        int n = kVar.n();
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i2 = h2;
        int i3 = h3;
        a(spannableStringBuilder2, g2, this.f10570e, i2, i3, 0);
        b(spannableStringBuilder2, n, this.f10571f, i2, i3, 0);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            int i7 = i6 | 33;
            boolean z = true;
            boolean z2 = (i2 & 1) != 0;
            boolean z3 = (i2 & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i4, i5, i7);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i4, i5, i7);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i4, i5, i7);
            }
            if ((i2 & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i4, i5, i7);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i4, i5, i7);
            }
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i2, int i3, int i4) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, i4 | 33);
        }
    }

    private static void a(boolean z) throws f {
        if (!z) {
            throw new f("Unexpected subtitle format.");
        }
    }
}
