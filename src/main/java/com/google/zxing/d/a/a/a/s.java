package com.google.zxing.d.a.a.a;

import com.google.zxing.c.a;
import com.google.zxing.m;
import com.google.zxing.q;
import com.tencent.ijk.media.player.IjkMediaMeta;
import com.tencent.qcloud.core.util.IOUtils;

final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f14556a;

    /* renamed from: b  reason: collision with root package name */
    private final m f14557b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f14558c = new StringBuilder();

    s(a aVar) {
        this.f14556a = aVar;
    }

    /* access modifiers changed from: package-private */
    public String a(StringBuilder sb, int i) throws q, m {
        String str = null;
        while (true) {
            o a2 = a(i, str);
            String a3 = r.a(a2.a());
            if (a3 != null) {
                sb.append(a3);
            }
            String valueOf = a2.b() ? String.valueOf(a2.c()) : null;
            if (i == a2.e()) {
                return sb.toString();
            }
            i = a2.e();
            str = valueOf;
        }
    }

    private boolean a(int i) {
        if (i + 7 <= this.f14556a.a()) {
            int i2 = i;
            while (true) {
                int i3 = i + 3;
                if (i2 >= i3) {
                    return this.f14556a.a(i3);
                }
                if (this.f14556a.a(i2)) {
                    return true;
                }
                i2++;
            }
        } else if (i + 4 <= this.f14556a.a()) {
            return true;
        } else {
            return false;
        }
    }

    private p b(int i) throws m {
        int i2 = i + 7;
        if (i2 > this.f14556a.a()) {
            int a2 = a(i, 4);
            if (a2 == 0) {
                return new p(this.f14556a.a(), 10, 10);
            }
            return new p(this.f14556a.a(), a2 - 1, 10);
        }
        int a3 = a(i, 7) - 8;
        return new p(i2, a3 / 11, a3 % 11);
    }

    /* access modifiers changed from: package-private */
    public int a(int i, int i2) {
        return a(this.f14556a, i, i2);
    }

    static int a(a aVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (aVar.a(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public o a(int i, String str) throws m {
        this.f14558c.setLength(0);
        if (str != null) {
            this.f14558c.append(str);
        }
        this.f14557b.a(i);
        o a2 = a();
        if (a2 == null || !a2.b()) {
            return new o(this.f14557b.a(), this.f14558c.toString());
        }
        return new o(this.f14557b.a(), this.f14558c.toString(), a2.c());
    }

    private o a() throws m {
        boolean z;
        l lVar;
        do {
            int a2 = this.f14557b.a();
            if (this.f14557b.b()) {
                lVar = d();
                z = lVar.b();
            } else if (this.f14557b.c()) {
                lVar = c();
                z = lVar.b();
            } else {
                lVar = b();
                z = lVar.b();
            }
            if (!(a2 != this.f14557b.a()) && !z) {
                break;
            }
        } while (!z);
        return lVar.a();
    }

    private l b() throws m {
        o oVar;
        while (a(this.f14557b.a())) {
            p b2 = b(this.f14557b.a());
            this.f14557b.a(b2.e());
            if (b2.c()) {
                if (b2.d()) {
                    oVar = new o(this.f14557b.a(), this.f14558c.toString());
                } else {
                    oVar = new o(this.f14557b.a(), this.f14558c.toString(), b2.b());
                }
                return new l(oVar, true);
            }
            this.f14558c.append(b2.a());
            if (b2.d()) {
                return new l(new o(this.f14557b.a(), this.f14558c.toString()), true);
            }
            this.f14558c.append(b2.b());
        }
        if (i(this.f14557b.a())) {
            this.f14557b.e();
            this.f14557b.b(4);
        }
        return new l(false);
    }

    private l c() throws m {
        while (c(this.f14557b.a())) {
            n d2 = d(this.f14557b.a());
            this.f14557b.a(d2.e());
            if (d2.b()) {
                return new l(new o(this.f14557b.a(), this.f14558c.toString()), true);
            }
            this.f14558c.append(d2.a());
        }
        if (h(this.f14557b.a())) {
            this.f14557b.b(3);
            this.f14557b.d();
        } else if (g(this.f14557b.a())) {
            if (this.f14557b.a() + 5 < this.f14556a.a()) {
                this.f14557b.b(5);
            } else {
                this.f14557b.a(this.f14556a.a());
            }
            this.f14557b.e();
        }
        return new l(false);
    }

    private l d() {
        while (e(this.f14557b.a())) {
            n f2 = f(this.f14557b.a());
            this.f14557b.a(f2.e());
            if (f2.b()) {
                return new l(new o(this.f14557b.a(), this.f14558c.toString()), true);
            }
            this.f14558c.append(f2.a());
        }
        if (h(this.f14557b.a())) {
            this.f14557b.b(3);
            this.f14557b.d();
        } else if (g(this.f14557b.a())) {
            if (this.f14557b.a() + 5 < this.f14556a.a()) {
                this.f14557b.b(5);
            } else {
                this.f14557b.a(this.f14556a.a());
            }
            this.f14557b.f();
        }
        return new l(false);
    }

    private boolean c(int i) {
        if (i + 5 > this.f14556a.a()) {
            return false;
        }
        int a2 = a(i, 5);
        if (a2 >= 5 && a2 < 16) {
            return true;
        }
        if (i + 7 > this.f14556a.a()) {
            return false;
        }
        int a3 = a(i, 7);
        if (a3 >= 64 && a3 < 116) {
            return true;
        }
        if (i + 8 > this.f14556a.a()) {
            return false;
        }
        int a4 = a(i, 8);
        if (a4 < 232 || a4 >= 253) {
            return false;
        }
        return true;
    }

    private n d(int i) throws m {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 7);
        if (a3 >= 64 && a3 < 90) {
            return new n(i + 7, (char) (a3 + 1));
        }
        if (a3 >= 90 && a3 < 116) {
            return new n(i + 7, (char) (a3 + 7));
        }
        switch (a(i, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = '\"';
                break;
            case 234:
                c2 = '%';
                break;
            case 235:
                c2 = '&';
                break;
            case 236:
                c2 = '\'';
                break;
            case 237:
                c2 = '(';
                break;
            case 238:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case 240:
                c2 = '+';
                break;
            case 241:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /*244*/:
                c2 = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            case 245:
                c2 = ':';
                break;
            case 246:
                c2 = ';';
                break;
            case 247:
                c2 = '<';
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = '>';
                break;
            case 250:
                c2 = '?';
                break;
            case 251:
                c2 = '_';
                break;
            case 252:
                c2 = ' ';
                break;
            default:
                throw m.a();
        }
        return new n(i + 8, c2);
    }

    private boolean e(int i) {
        if (i + 5 > this.f14556a.a()) {
            return false;
        }
        int a2 = a(i, 5);
        if (a2 >= 5 && a2 < 16) {
            return true;
        }
        if (i + 6 > this.f14556a.a()) {
            return false;
        }
        int a3 = a(i, 6);
        if (a3 < 16 || a3 >= 63) {
            return false;
        }
        return true;
    }

    private n f(int i) {
        char c2;
        int a2 = a(i, 5);
        if (a2 == 15) {
            return new n(i + 5, '$');
        }
        if (a2 >= 5 && a2 < 15) {
            return new n(i + 5, (char) ((a2 + 48) - 5));
        }
        int a3 = a(i, 6);
        if (a3 >= 32 && a3 < 58) {
            return new n(i + 6, (char) (a3 + 33));
        }
        switch (a3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a3);
        }
        return new n(i + 6, c2);
    }

    private boolean g(int i) {
        if (i + 1 > this.f14556a.a()) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            if (i3 >= this.f14556a.a()) {
                return true;
            }
            if (i2 == 2) {
                if (!this.f14556a.a(i + 2)) {
                    return false;
                }
            } else if (this.f14556a.a(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.f14556a.a()) {
            return false;
        }
        while (i < i2) {
            if (this.f14556a.a(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean i(int i) {
        if (i + 1 > this.f14556a.a()) {
            return false;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 + i;
            if (i3 >= this.f14556a.a()) {
                return true;
            }
            if (this.f14556a.a(i3)) {
                return false;
            }
        }
        return true;
    }
}
