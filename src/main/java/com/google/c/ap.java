package com.google.c;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.time.Clock;
import com.g.a.a.g;
import com.google.c.ar;
import com.google.c.at;
import com.google.c.j;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

public final class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f13650a = Logger.getLogger(ap.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final c f13651b = new c();

    /* renamed from: c  reason: collision with root package name */
    private static final c f13652c = new c().a(true);

    /* renamed from: d  reason: collision with root package name */
    private static final c f13653d = new c().b(false);

    /* renamed from: e  reason: collision with root package name */
    private static final b f13654e = b.a().a();

    private static boolean a(byte b2) {
        return 48 <= b2 && b2 <= 55;
    }

    private static boolean b(byte b2) {
        return (48 <= b2 && b2 <= 57) || (97 <= b2 && b2 <= 102) || (65 <= b2 && b2 <= 70);
    }

    private static int c(byte b2) {
        if (48 <= b2 && b2 <= 57) {
            return b2 - 48;
        }
        return ((97 > b2 || b2 > 122) ? b2 - 65 : b2 - 97) + 10;
    }

    private ap() {
    }

    public static void a(ag agVar, Appendable appendable) throws IOException {
        f13651b.a(agVar, new d(appendable));
    }

    public static void a(at atVar, Appendable appendable) throws IOException {
        f13651b.a(atVar, new d(appendable));
    }

    public static String a(ag agVar) {
        try {
            StringBuilder sb = new StringBuilder();
            a(agVar, (Appendable) sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String a(at atVar) {
        try {
            StringBuilder sb = new StringBuilder();
            a(atVar, (Appendable) sb);
            return sb.toString();
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static void b(int i, Object obj, d dVar) throws IOException {
        int a2 = ay.a(i);
        if (a2 == 0) {
            dVar.a(a(((Long) obj).longValue()));
        } else if (a2 == 1) {
            dVar.a(String.format((Locale) null, "0x%016x", new Object[]{(Long) obj}));
        } else if (a2 == 2) {
            dVar.a("\"");
            dVar.a(a((f) obj));
            dVar.a("\"");
        } else if (a2 == 3) {
            f13651b.a((at) obj, dVar);
        } else if (a2 == 5) {
            dVar.a(String.format((Locale) null, "0x%08x", new Object[]{(Integer) obj}));
        } else {
            throw new IllegalArgumentException("Bad tag: " + i);
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f13662a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13663b;

        private c() {
            this.f13662a = false;
            this.f13663b = true;
        }

        /* access modifiers changed from: private */
        public c a(boolean z) {
            this.f13662a = z;
            return this;
        }

        /* access modifiers changed from: private */
        public c b(boolean z) {
            this.f13663b = z;
            return this;
        }

        /* access modifiers changed from: private */
        public void a(ag agVar, d dVar) throws IOException {
            for (Map.Entry next : agVar.o_().entrySet()) {
                a((j.f) next.getKey(), next.getValue(), dVar);
            }
            a(agVar.f(), dVar);
        }

        private void a(j.f fVar, Object obj, d dVar) throws IOException {
            if (fVar.p()) {
                for (Object b2 : (List) obj) {
                    b(fVar, b2, dVar);
                }
                return;
            }
            b(fVar, obj, dVar);
        }

        private void b(j.f fVar, Object obj, d dVar) throws IOException {
            if (fVar.u()) {
                dVar.a("[");
                if (!fVar.v().e().i() || fVar.i() != j.f.b.MESSAGE || !fVar.o() || fVar.x() != fVar.y()) {
                    dVar.a(fVar.c());
                } else {
                    dVar.a(fVar.y().c());
                }
                dVar.a("]");
            } else if (fVar.i() == j.f.b.GROUP) {
                dVar.a(fVar.y().b());
            } else {
                dVar.a(fVar.b());
            }
            if (fVar.g() != j.f.a.MESSAGE) {
                dVar.a(": ");
            } else if (this.f13662a) {
                dVar.a(" { ");
            } else {
                dVar.a(" {\n");
                dVar.a();
            }
            c(fVar, obj, dVar);
            if (fVar.g() == j.f.a.MESSAGE) {
                if (this.f13662a) {
                    dVar.a("} ");
                    return;
                }
                dVar.b();
                dVar.a("}\n");
            } else if (this.f13662a) {
                dVar.a(SQLBuilder.BLANK);
            } else {
                dVar.a("\n");
            }
        }

        private void c(j.f fVar, Object obj, d dVar) throws IOException {
            String str;
            switch (fVar.i()) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    dVar.a(((Integer) obj).toString());
                    return;
                case INT64:
                case SINT64:
                case SFIXED64:
                    dVar.a(((Long) obj).toString());
                    return;
                case BOOL:
                    dVar.a(((Boolean) obj).toString());
                    return;
                case FLOAT:
                    dVar.a(((Float) obj).toString());
                    return;
                case DOUBLE:
                    dVar.a(((Double) obj).toString());
                    return;
                case UINT32:
                case FIXED32:
                    dVar.a(ap.a(((Integer) obj).intValue()));
                    return;
                case UINT64:
                case FIXED64:
                    dVar.a(ap.a(((Long) obj).longValue()));
                    return;
                case STRING:
                    dVar.a("\"");
                    if (this.f13663b) {
                        str = aq.a((String) obj);
                    } else {
                        str = ap.a((String) obj).replace("\n", "\\n");
                    }
                    dVar.a(str);
                    dVar.a("\"");
                    return;
                case BYTES:
                    dVar.a("\"");
                    if (obj instanceof f) {
                        dVar.a(ap.a((f) obj));
                    } else {
                        dVar.a(ap.a((byte[]) obj));
                    }
                    dVar.a("\"");
                    return;
                case ENUM:
                    dVar.a(((j.e) obj).b());
                    return;
                case MESSAGE:
                case GROUP:
                    a((ag) (ac) obj, dVar);
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: private */
        public void a(at atVar, d dVar) throws IOException {
            for (Map.Entry next : atVar.h().entrySet()) {
                int intValue = ((Integer) next.getKey()).intValue();
                at.b bVar = (at.b) next.getValue();
                a(intValue, 0, bVar.b(), dVar);
                a(intValue, 5, bVar.c(), dVar);
                a(intValue, 1, bVar.d(), dVar);
                a(intValue, 2, bVar.e(), dVar);
                for (at next2 : bVar.f()) {
                    dVar.a(((Integer) next.getKey()).toString());
                    if (this.f13662a) {
                        dVar.a(" { ");
                    } else {
                        dVar.a(" {\n");
                        dVar.a();
                    }
                    a(next2, dVar);
                    if (this.f13662a) {
                        dVar.a("} ");
                    } else {
                        dVar.b();
                        dVar.a("}\n");
                    }
                }
            }
        }

        private void a(int i, int i2, List<?> list, d dVar) throws IOException {
            for (Object next : list) {
                dVar.a(String.valueOf(i));
                dVar.a(": ");
                ap.b(i2, next, dVar);
                dVar.a(this.f13662a ? SQLBuilder.BLANK : "\n");
            }
        }
    }

    public static String a(int i) {
        if (i >= 0) {
            return Integer.toString(i);
        }
        return Long.toString(((long) i) & 4294967295L);
    }

    public static String a(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Clock.MAX_TIME).setBit(63).toString();
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f13664a;

        /* renamed from: b  reason: collision with root package name */
        private final StringBuilder f13665b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f13666c;

        private d(Appendable appendable) {
            this.f13665b = new StringBuilder();
            this.f13666c = true;
            this.f13664a = appendable;
        }

        public void a() {
            this.f13665b.append("  ");
        }

        public void b() {
            int length = this.f13665b.length();
            if (length != 0) {
                this.f13665b.delete(length - 2, length);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void a(CharSequence charSequence) throws IOException {
            int length = charSequence.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (charSequence.charAt(i2) == 10) {
                    int i3 = i2 + 1;
                    b(charSequence.subSequence(i, i3));
                    this.f13666c = true;
                    i = i3;
                }
            }
            b(charSequence.subSequence(i, length));
        }

        private void b(CharSequence charSequence) throws IOException {
            if (charSequence.length() != 0) {
                if (this.f13666c) {
                    this.f13666c = false;
                    this.f13664a.append(this.f13665b);
                }
                this.f13664a.append(charSequence);
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f13656a;

        /* renamed from: b  reason: collision with root package name */
        private final C0225b f13657b;

        /* renamed from: c  reason: collision with root package name */
        private ar.a f13658c;

        /* renamed from: com.google.c.ap$b$b  reason: collision with other inner class name */
        public enum C0225b {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        private b(boolean z, C0225b bVar, ar.a aVar) {
            this.f13656a = z;
            this.f13657b = bVar;
            this.f13658c = aVar;
        }

        public static a a() {
            return new a();
        }

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f13659a = false;

            /* renamed from: b  reason: collision with root package name */
            private C0225b f13660b = C0225b.ALLOW_SINGULAR_OVERWRITES;

            /* renamed from: c  reason: collision with root package name */
            private ar.a f13661c = null;

            public b a() {
                return new b(this.f13659a, this.f13660b, this.f13661c);
            }
        }
    }

    public static String a(f fVar) {
        return aq.a(fVar);
    }

    public static String a(byte[] bArr) {
        return aq.a(bArr);
    }

    public static f a(CharSequence charSequence) throws a {
        int i;
        int i2;
        int i3;
        f a2 = f.a(charSequence.toString());
        byte[] bArr = new byte[a2.b()];
        int i4 = 0;
        int i5 = 0;
        while (i < a2.b()) {
            byte a3 = a2.a(i);
            if (a3 == 92) {
                i++;
                if (i < a2.b()) {
                    byte a4 = a2.a(i);
                    if (a(a4)) {
                        int c2 = c(a4);
                        int i6 = i + 1;
                        if (i6 < a2.b() && a(a2.a(i6))) {
                            c2 = (c2 * 8) + c(a2.a(i6));
                            i = i6;
                        }
                        int i7 = i + 1;
                        if (i7 < a2.b() && a(a2.a(i7))) {
                            c2 = (c2 * 8) + c(a2.a(i7));
                            i = i7;
                        }
                        i2 = i5 + 1;
                        bArr[i5] = (byte) c2;
                    } else {
                        if (a4 == 34) {
                            i3 = i5 + 1;
                            bArr[i5] = 34;
                        } else if (a4 == 39) {
                            i3 = i5 + 1;
                            bArr[i5] = 39;
                        } else if (a4 == 92) {
                            i3 = i5 + 1;
                            bArr[i5] = 92;
                        } else if (a4 == 102) {
                            i3 = i5 + 1;
                            bArr[i5] = g.ZERO_TAG;
                        } else if (a4 == 110) {
                            i3 = i5 + 1;
                            bArr[i5] = 10;
                        } else if (a4 == 114) {
                            i3 = i5 + 1;
                            bArr[i5] = g.SIMPLE_LIST;
                        } else if (a4 == 116) {
                            i3 = i5 + 1;
                            bArr[i5] = 9;
                        } else if (a4 == 118) {
                            i3 = i5 + 1;
                            bArr[i5] = g.STRUCT_END;
                        } else if (a4 == 120) {
                            i++;
                            if (i >= a2.b() || !b(a2.a(i))) {
                                throw new a("Invalid escape sequence: '\\x' with no digits");
                            }
                            int c3 = c(a2.a(i));
                            int i8 = i + 1;
                            if (i8 < a2.b() && b(a2.a(i8))) {
                                c3 = (c3 * 16) + c(a2.a(i8));
                                i = i8;
                            }
                            bArr[i5] = (byte) c3;
                            i3 = i5 + 1;
                        } else if (a4 == 97) {
                            i3 = i5 + 1;
                            bArr[i5] = 7;
                        } else if (a4 == 98) {
                            i3 = i5 + 1;
                            bArr[i5] = 8;
                        } else {
                            throw new a("Invalid escape sequence: '\\" + ((char) a4) + '\'');
                        }
                        i5 = i3;
                        i4 = i + 1;
                    }
                } else {
                    throw new a("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                i2 = i5 + 1;
                bArr[i5] = a3;
            }
            i5 = i2;
            i4 = i + 1;
        }
        if (bArr.length == i5) {
            return f.b(bArr);
        }
        return f.a(bArr, 0, i5);
    }

    public static class a extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        a(String str) {
            super(str);
        }
    }

    public static String a(String str) {
        return aq.b(str);
    }

    static int b(String str) throws NumberFormatException {
        return (int) a(str, true, false);
    }

    static int c(String str) throws NumberFormatException {
        return (int) a(str, false, false);
    }

    static long d(String str) throws NumberFormatException {
        return a(str, true, true);
    }

    static long e(String str) throws NumberFormatException {
        return a(str, false, true);
    }

    private static long a(String str, boolean z, boolean z2) throws NumberFormatException {
        int i = 0;
        boolean z3 = true;
        if (!str.startsWith("-", 0)) {
            z3 = false;
        } else if (z) {
            i = 1;
        } else {
            throw new NumberFormatException("Number must be positive: " + str);
        }
        int i2 = 10;
        if (str.startsWith("0x", i)) {
            i += 2;
            i2 = 16;
        } else if (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO, i)) {
            i2 = 8;
        }
        String substring = str.substring(i);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i2);
            if (z3) {
                parseLong = -parseLong;
            }
            if (z2) {
                return parseLong;
            }
            if (z) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            } else if (parseLong < IjkMediaMeta.AV_CH_WIDE_RIGHT && parseLong >= 0) {
                return parseLong;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        } else {
            BigInteger bigInteger = new BigInteger(substring, i2);
            if (z3) {
                bigInteger = bigInteger.negate();
            }
            if (!z2) {
                if (z) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
                }
            } else if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
            }
            return bigInteger.longValue();
        }
    }
}
