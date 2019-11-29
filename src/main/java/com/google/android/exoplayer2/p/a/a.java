package com.google.android.exoplayer2.p.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.appsflyer.BuildConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.e;
import com.google.android.exoplayer2.p.g;
import com.google.android.exoplayer2.p.i;
import com.google.android.exoplayer2.p.j;
import com.google.android.exoplayer2.s.l;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.shopee.live.livestreaming.data.entity.DanmaKuEntity;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qalsdk.im_open.http;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tencent.tls.platform.TLSErrInfo;

public final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f11026a = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f11027b = {0, 4, 8, 12, 16, 20, 24, 28};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f11028c = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f11029d = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, JfifUtil.MARKER_APP1, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f11030e = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f11031f = {193, DanmaKuEntity.MESSAGE_PUBLIC, 211, JfifUtil.MARKER_SOS, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, JfifUtil.MARKER_SOFn, 194, 199, 200, 202, 203, 235, http.Partial_Content, 207, 239, 212, JfifUtil.MARKER_EOI, 249, 219, 171, 187};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f11032g = {195, 227, 205, http.No_Content, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, ModuleDescriptor.MODULE_VERSION, 246, 223, 165, 164, 9474, BuildConfig.VERSION_CODE, TLSErrInfo.LOGIN_NO_ACCOUNT, 216, 248, 9484, 9488, 9492, 9496};
    private final l h = new l();
    private final int i;
    private final int j;
    private final LinkedList<C0180a> k = new LinkedList<>();
    private C0180a l = new C0180a(0, 4);
    private List<b> m;
    private List<b> n;
    private int o;
    private int p;
    private boolean q;
    private byte r;
    private byte s;

    private static boolean c(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean d(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean e(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean f(byte b2, byte b3) {
        return (b2 & 247) == 20 && (b3 & 240) == 32;
    }

    private static boolean g(byte b2) {
        return (b2 & 240) == 16;
    }

    public void d() {
    }

    public /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    public /* bridge */ /* synthetic */ void b(i iVar) throws g {
        super.a(iVar);
    }

    public /* bridge */ /* synthetic */ j g() throws g {
        return super.b();
    }

    public /* bridge */ /* synthetic */ i h() throws g {
        return super.a();
    }

    public a(String str, int i2) {
        this.i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 3 || i2 == 4) {
            this.j = 2;
        } else {
            this.j = 1;
        }
        a(0);
        j();
    }

    public void c() {
        super.c();
        this.m = null;
        this.n = null;
        a(0);
        j();
        this.p = 4;
        this.q = false;
        this.r = 0;
        this.s = 0;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return this.m != this.n;
    }

    /* access modifiers changed from: protected */
    public e f() {
        List<b> list = this.m;
        this.n = list;
        return new f(list);
    }

    /* access modifiers changed from: protected */
    public void a(i iVar) {
        byte b2;
        this.h.a(iVar.f9881b.array(), iVar.f9881b.limit());
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int b3 = this.h.b();
            int i2 = this.i;
            if (b3 < i2) {
                break;
            }
            if (i2 == 2) {
                b2 = -4;
            } else {
                b2 = (byte) this.h.g();
            }
            byte g2 = (byte) (this.h.g() & 127);
            byte g3 = (byte) (this.h.g() & 127);
            if ((b2 & 6) == 4 && ((this.j != 1 || (b2 & 1) == 0) && ((this.j != 2 || (b2 & 1) == 1) && !(g2 == 0 && g3 == 0)))) {
                if ((g2 & 247) == 17 && (g3 & 240) == 48) {
                    this.l.a(d(g3));
                } else if ((g2 & 246) == 18 && (g3 & 224) == 32) {
                    this.l.b();
                    if ((g2 & 1) == 0) {
                        this.l.a(e(g3));
                    } else {
                        this.l.a(f(g3));
                    }
                } else if ((g2 & 224) == 0) {
                    z2 = a(g2, g3);
                } else {
                    this.l.a(c(g2));
                    if ((g3 & 224) != 0) {
                        this.l.a(c(g3));
                    }
                }
                z = true;
            }
        }
        if (z) {
            if (!z2) {
                this.q = false;
            }
            int i3 = this.o;
            if (i3 == 1 || i3 == 3) {
                this.m = i();
            }
        }
    }

    private boolean a(byte b2, byte b3) {
        boolean g2 = g(b2);
        if (g2) {
            if (this.q && this.r == b2 && this.s == b3) {
                this.q = false;
                return true;
            }
            this.q = true;
            this.r = b2;
            this.s = b3;
        }
        if (c(b2, b3)) {
            a(b3);
        } else if (d(b2, b3)) {
            b(b2, b3);
        } else if (e(b2, b3)) {
            this.l.c(b3 - 32);
        } else if (f(b2, b3)) {
            b(b3);
        }
        return g2;
    }

    private void a(byte b2) {
        this.l.a((b2 & 1) == 1);
        int i2 = (b2 >> 1) & 15;
        if (i2 == 7) {
            this.l.a((CharacterStyle) new StyleSpan(2), 2);
            this.l.a((CharacterStyle) new ForegroundColorSpan(-1), 1);
            return;
        }
        this.l.a((CharacterStyle) new ForegroundColorSpan(f11028c[i2]), 1);
    }

    private void b(byte b2, byte b3) {
        int i2 = f11026a[b2 & 7];
        if ((b3 & 32) != 0) {
            i2++;
        }
        if (i2 != this.l.c()) {
            if (this.o != 1 && !this.l.a()) {
                this.l = new C0180a(this.o, this.p);
                this.k.add(this.l);
            }
            this.l.a(i2);
        }
        if ((b3 & 1) == 1) {
            this.l.a((CharacterStyle) new UnderlineSpan());
        }
        int i3 = (b3 >> 1) & 15;
        if (i3 > 7) {
            this.l.b(f11027b[i3 & 7]);
        } else if (i3 == 7) {
            this.l.a((CharacterStyle) new StyleSpan(2));
            this.l.a((CharacterStyle) new ForegroundColorSpan(-1));
        } else {
            this.l.a((CharacterStyle) new ForegroundColorSpan(f11028c[i3]));
        }
    }

    private void b(byte b2) {
        if (b2 == 32) {
            a(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    this.p = 2;
                    a(1);
                    return;
                case 38:
                    this.p = 3;
                    a(1);
                    return;
                case 39:
                    this.p = 4;
                    a(1);
                    return;
                default:
                    int i2 = this.o;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.m = null;
                                    if (i2 == 1 || i2 == 3) {
                                        j();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i2 == 1 && !this.l.a()) {
                                        this.l.d();
                                        return;
                                    }
                                    return;
                                case 46:
                                    j();
                                    return;
                                case 47:
                                    this.m = i();
                                    j();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.l.b();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            a(3);
        }
    }

    private List<b> i() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            b f2 = this.k.get(i2).f();
            if (f2 != null) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    private void a(int i2) {
        int i3 = this.o;
        if (i3 != i2) {
            this.o = i2;
            j();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.m = null;
            }
        }
    }

    private void j() {
        this.l.a(this.o, this.p);
        this.k.clear();
        this.k.add(this.l);
    }

    private static char c(byte b2) {
        return (char) f11029d[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static char d(byte b2) {
        return (char) f11030e[b2 & 15];
    }

    private static char e(byte b2) {
        return (char) f11031f[b2 & 31];
    }

    private static char f(byte b2) {
        return (char) f11032g[b2 & 31];
    }

    /* renamed from: com.google.android.exoplayer2.p.a.a$a  reason: collision with other inner class name */
    private static class C0180a {

        /* renamed from: a  reason: collision with root package name */
        private final List<CharacterStyle> f11033a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<C0181a> f11034b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<SpannableString> f11035c = new LinkedList();

        /* renamed from: d  reason: collision with root package name */
        private final SpannableStringBuilder f11036d = new SpannableStringBuilder();

        /* renamed from: e  reason: collision with root package name */
        private int f11037e;

        /* renamed from: f  reason: collision with root package name */
        private int f11038f;

        /* renamed from: g  reason: collision with root package name */
        private int f11039g;
        private int h;
        private int i;
        private int j;

        public C0180a(int i2, int i3) {
            a(i2, i3);
        }

        public void a(int i2, int i3) {
            this.f11033a.clear();
            this.f11034b.clear();
            this.f11035c.clear();
            this.f11036d.clear();
            this.f11037e = 15;
            this.f11038f = 0;
            this.f11039g = 0;
            this.h = i2;
            this.i = i3;
            this.j = -1;
        }

        public boolean a() {
            return this.f11033a.isEmpty() && this.f11034b.isEmpty() && this.f11035c.isEmpty() && this.f11036d.length() == 0;
        }

        public void b() {
            int length = this.f11036d.length();
            if (length > 0) {
                this.f11036d.delete(length - 1, length);
            }
        }

        public int c() {
            return this.f11037e;
        }

        public void a(int i2) {
            this.f11037e = i2;
        }

        public void d() {
            this.f11035c.add(e());
            this.f11036d.clear();
            this.f11033a.clear();
            this.f11034b.clear();
            this.j = -1;
            int min = Math.min(this.i, this.f11037e);
            while (this.f11035c.size() >= min) {
                this.f11035c.remove(0);
            }
        }

        public void b(int i2) {
            this.f11038f = i2;
        }

        public void c(int i2) {
            this.f11039g = i2;
        }

        public void a(CharacterStyle characterStyle) {
            this.f11033a.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i2) {
            this.f11034b.add(new C0181a(characterStyle, this.f11036d.length(), i2));
        }

        public void a(boolean z) {
            if (z) {
                this.j = this.f11036d.length();
            } else if (this.j != -1) {
                this.f11036d.setSpan(new UnderlineSpan(), this.j, this.f11036d.length(), 33);
                this.j = -1;
            }
        }

        public void a(char c2) {
            this.f11036d.append(c2);
        }

        public SpannableString e() {
            int length = this.f11036d.length();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f11033a.size(); i3++) {
                this.f11036d.setSpan(this.f11033a.get(i3), 0, length, 33);
            }
            while (i2 < this.f11034b.size()) {
                C0181a aVar = this.f11034b.get(i2);
                this.f11036d.setSpan(aVar.f11040a, aVar.f11041b, i2 < this.f11034b.size() - aVar.f11042c ? this.f11034b.get(aVar.f11042c + i2).f11041b : length, 33);
                i2++;
            }
            if (this.j != -1) {
                this.f11036d.setSpan(new UnderlineSpan(), this.j, length, 33);
            }
            return new SpannableString(this.f11036d);
        }

        public b f() {
            int i2;
            float f2;
            int i3;
            int i4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f11035c.size(); i5++) {
                spannableStringBuilder.append(this.f11035c.get(i5));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(e());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i6 = this.f11038f + this.f11039g;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (this.h == 2 && Math.abs(i7) < 3) {
                f2 = 0.5f;
                i2 = 1;
            } else if (this.h != 2 || i7 <= 0) {
                f2 = ((((float) i6) / 32.0f) * 0.8f) + 0.1f;
                i2 = 0;
            } else {
                f2 = ((((float) (32 - length)) / 32.0f) * 0.8f) + 0.1f;
                i2 = 2;
            }
            if (this.h != 1) {
                i4 = this.f11037e;
                if (i4 <= 7) {
                    i3 = 0;
                    return new b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i4, 1, i3, f2, i2, Float.MIN_VALUE);
                }
            }
            i4 = (this.f11037e - 15) - 2;
            i3 = 2;
            return new b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i4, 1, i3, f2, i2, Float.MIN_VALUE);
        }

        public String toString() {
            return this.f11036d.toString();
        }

        /* renamed from: com.google.android.exoplayer2.p.a.a$a$a  reason: collision with other inner class name */
        private static class C0181a {

            /* renamed from: a  reason: collision with root package name */
            public final CharacterStyle f11040a;

            /* renamed from: b  reason: collision with root package name */
            public final int f11041b;

            /* renamed from: c  reason: collision with root package name */
            public final int f11042c;

            public C0181a(CharacterStyle characterStyle, int i, int i2) {
                this.f11040a = characterStyle;
                this.f11041b = i;
                this.f11042c = i2;
            }
        }
    }
}
