package org.apache.commons.c.a;

import com.facebook.common.time.Clock;
import java.util.ArrayList;
import org.apache.commons.c.d;
import org.apache.commons.c.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static final Object f33844a = "y";

    /* renamed from: b  reason: collision with root package name */
    static final Object f33845b = "M";

    /* renamed from: c  reason: collision with root package name */
    static final Object f33846c = "d";

    /* renamed from: d  reason: collision with root package name */
    static final Object f33847d = "H";

    /* renamed from: e  reason: collision with root package name */
    static final Object f33848e = "m";

    /* renamed from: f  reason: collision with root package name */
    static final Object f33849f = "s";

    /* renamed from: g  reason: collision with root package name */
    static final Object f33850g = "S";

    public static String a(long j, String str) {
        return a(j, str, true);
    }

    public static String a(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        e.a(0, Clock.MAX_TIME, j, "durationMillis must not be negative");
        C0533a[] a2 = a(str);
        if (C0533a.a(a2, f33846c)) {
            long j8 = j / 86400000;
            j3 = j - (86400000 * j8);
            j2 = j8;
        } else {
            j3 = j;
            j2 = 0;
        }
        if (C0533a.a(a2, f33847d)) {
            long j9 = j3 / 3600000;
            j3 -= 3600000 * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (C0533a.a(a2, f33848e)) {
            long j10 = j3 / 60000;
            j3 -= 60000 * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (C0533a.a(a2, f33849f)) {
            long j11 = j3 / 1000;
            j6 = j3 - (1000 * j11);
            j7 = j11;
        } else {
            j7 = 0;
            j6 = j3;
        }
        return a(a2, 0, 0, j2, j4, j5, j7, j6, z);
    }

    static String a(C0533a[] aVarArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        C0533a[] aVarArr2 = aVarArr;
        long j8 = j7;
        boolean z2 = z;
        StringBuilder sb = new StringBuilder();
        int length = aVarArr2.length;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < length) {
            C0533a aVar = aVarArr2[i3];
            Object c2 = aVar.c();
            int b2 = aVar.b();
            if (c2 instanceof StringBuilder) {
                sb.append(c2.toString());
                long j9 = j4;
                long j10 = j5;
                i2 = length;
                i = i3;
            } else {
                if (c2 == f33844a) {
                    sb.append(a(j, z2, b2));
                    long j11 = j4;
                    long j12 = j5;
                    i2 = length;
                    i = i3;
                } else {
                    long j13 = j;
                    if (c2 == f33845b) {
                        i = i3;
                        sb.append(a(j2, z2, b2));
                    } else {
                        i = i3;
                        long j14 = j2;
                        if (c2 == f33846c) {
                            sb.append(a(j3, z2, b2));
                        } else {
                            long j15 = j3;
                            if (c2 == f33847d) {
                                sb.append(a(j4, z2, b2));
                                long j16 = j5;
                                i2 = length;
                            } else {
                                long j17 = j4;
                                if (c2 == f33848e) {
                                    sb.append(a(j5, z2, b2));
                                    i2 = length;
                                } else {
                                    long j18 = j5;
                                    if (c2 == f33849f) {
                                        i2 = length;
                                        sb.append(a(j6, z2, b2));
                                        z3 = true;
                                    } else {
                                        i2 = length;
                                        long j19 = j6;
                                        if (c2 == f33850g) {
                                            if (z3) {
                                                int i4 = 3;
                                                if (z2) {
                                                    i4 = Math.max(3, b2);
                                                }
                                                sb.append(a(j8, true, i4));
                                            } else {
                                                sb.append(a(j8, z2, b2));
                                            }
                                            z3 = false;
                                        }
                                    }
                                    i3 = i + 1;
                                    length = i2;
                                    aVarArr2 = aVarArr;
                                }
                            }
                        }
                    }
                    long j20 = j4;
                    long j162 = j5;
                    i2 = length;
                }
                z3 = false;
            }
            long j21 = j6;
            i3 = i + 1;
            length = i2;
            aVarArr2 = aVarArr;
        }
        return sb.toString();
    }

    private static String a(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? d.a(l, i, '0') : l;
    }

    static C0533a[] a(String str) {
        Object obj;
        ArrayList arrayList = new ArrayList(str.length());
        StringBuilder sb = null;
        C0533a aVar = null;
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!z || charAt == '\'') {
                if (charAt != '\'') {
                    if (charAt == 'H') {
                        obj = f33847d;
                    } else if (charAt == 'M') {
                        obj = f33845b;
                    } else if (charAt == 'S') {
                        obj = f33850g;
                    } else if (charAt == 'd') {
                        obj = f33846c;
                    } else if (charAt == 'm') {
                        obj = f33848e;
                    } else if (charAt == 's') {
                        obj = f33849f;
                    } else if (charAt != 'y') {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new C0533a(sb));
                        }
                        sb.append(charAt);
                        obj = null;
                    } else {
                        obj = f33844a;
                    }
                } else if (z) {
                    sb = null;
                    obj = null;
                    z = false;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    arrayList.add(new C0533a(sb2));
                    obj = null;
                    sb = sb2;
                    z = true;
                }
                if (obj != null) {
                    if (aVar == null || aVar.c() != obj) {
                        aVar = new C0533a(obj);
                        arrayList.add(aVar);
                    } else {
                        aVar.a();
                    }
                    sb = null;
                }
            } else {
                sb.append(charAt);
            }
        }
        if (!z) {
            return (C0533a[]) arrayList.toArray(new C0533a[arrayList.size()]);
        }
        throw new IllegalArgumentException("Unmatched quote in format: " + str);
    }

    /* renamed from: org.apache.commons.c.a.a$a  reason: collision with other inner class name */
    static class C0533a {

        /* renamed from: a  reason: collision with root package name */
        private final Object f33851a;

        /* renamed from: b  reason: collision with root package name */
        private int f33852b = 1;

        static boolean a(C0533a[] aVarArr, Object obj) {
            for (C0533a c2 : aVarArr) {
                if (c2.c() == obj) {
                    return true;
                }
            }
            return false;
        }

        C0533a(Object obj) {
            this.f33851a = obj;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f33852b++;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f33852b;
        }

        /* access modifiers changed from: package-private */
        public Object c() {
            return this.f33851a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0533a)) {
                return false;
            }
            C0533a aVar = (C0533a) obj;
            if (this.f33851a.getClass() != aVar.f33851a.getClass() || this.f33852b != aVar.f33852b) {
                return false;
            }
            Object obj2 = this.f33851a;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(aVar.f33851a.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(aVar.f33851a);
            }
            if (obj2 == aVar.f33851a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f33851a.hashCode();
        }

        public String toString() {
            return d.a(this.f33851a.toString(), this.f33852b);
        }
    }
}
