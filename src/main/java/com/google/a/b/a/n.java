package com.google.a.b.a;

import com.google.a.b.g;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.i;
import com.google.a.l;
import com.google.a.m;
import com.google.a.o;
import com.google.a.r;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.slf4j.Marker;

public final class n {
    public static final w<String> A = new w<String>() {
        /* renamed from: a */
        public String read(com.google.a.d.a aVar) throws IOException {
            b f2 = aVar.f();
            if (f2 == b.NULL) {
                aVar.j();
                return null;
            } else if (f2 == b.BOOLEAN) {
                return Boolean.toString(aVar.i());
            } else {
                return aVar.h();
            }
        }

        /* renamed from: a */
        public void write(c cVar, String str) throws IOException {
            cVar.b(str);
        }
    };
    public static final w<BigDecimal> B = new w<BigDecimal>() {
        /* renamed from: a */
        public BigDecimal read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigDecimal(aVar.h());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, BigDecimal bigDecimal) throws IOException {
            cVar.a((Number) bigDecimal);
        }
    };
    public static final w<BigInteger> C = new w<BigInteger>() {
        /* renamed from: a */
        public BigInteger read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return new BigInteger(aVar.h());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, BigInteger bigInteger) throws IOException {
            cVar.a((Number) bigInteger);
        }
    };
    public static final x D = a(String.class, A);
    public static final w<StringBuilder> E = new w<StringBuilder>() {
        /* renamed from: a */
        public StringBuilder read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return new StringBuilder(aVar.h());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, StringBuilder sb) throws IOException {
            cVar.b(sb == null ? null : sb.toString());
        }
    };
    public static final x F = a(StringBuilder.class, E);
    public static final w<StringBuffer> G = new w<StringBuffer>() {
        /* renamed from: a */
        public StringBuffer read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return new StringBuffer(aVar.h());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, StringBuffer stringBuffer) throws IOException {
            cVar.b(stringBuffer == null ? null : stringBuffer.toString());
        }
    };
    public static final x H = a(StringBuffer.class, G);
    public static final w<URL> I = new w<URL>() {
        /* renamed from: a */
        public URL read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            if ("null".equals(h)) {
                return null;
            }
            return new URL(h);
        }

        /* renamed from: a */
        public void write(c cVar, URL url) throws IOException {
            cVar.b(url == null ? null : url.toExternalForm());
        }
    };
    public static final x J = a(URL.class, I);
    public static final w<URI> K = new w<URI>() {
        /* renamed from: a */
        public URI read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                String h = aVar.h();
                if ("null".equals(h)) {
                    return null;
                }
                return new URI(h);
            } catch (URISyntaxException e2) {
                throw new m((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, URI uri) throws IOException {
            cVar.b(uri == null ? null : uri.toASCIIString());
        }
    };
    public static final x L = a(URI.class, K);
    public static final w<InetAddress> M = new w<InetAddress>() {
        /* renamed from: a */
        public InetAddress read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return InetAddress.getByName(aVar.h());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, InetAddress inetAddress) throws IOException {
            cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    };
    public static final x N = b(InetAddress.class, M);
    public static final w<UUID> O = new w<UUID>() {
        /* renamed from: a */
        public UUID read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return UUID.fromString(aVar.h());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, UUID uuid) throws IOException {
            cVar.b(uuid == null ? null : uuid.toString());
        }
    };
    public static final x P = a(UUID.class, O);
    public static final w<Currency> Q = new w<Currency>() {
        /* renamed from: a */
        public Currency read(com.google.a.d.a aVar) throws IOException {
            return Currency.getInstance(aVar.h());
        }

        /* renamed from: a */
        public void write(c cVar, Currency currency) throws IOException {
            cVar.b(currency.getCurrencyCode());
        }
    }.nullSafe();
    public static final x R = a(Currency.class, Q);
    public static final x S = new x() {
        public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
            if (aVar.getRawType() != Timestamp.class) {
                return null;
            }
            final w<Date> a2 = fVar.a(Date.class);
            return new w<Timestamp>() {
                /* renamed from: a */
                public Timestamp read(com.google.a.d.a aVar) throws IOException {
                    Date date = (Date) a2.read(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                /* renamed from: a */
                public void write(c cVar, Timestamp timestamp) throws IOException {
                    a2.write(cVar, timestamp);
                }
            };
        }
    };
    public static final w<Calendar> T = new w<Calendar>() {
        /* renamed from: a */
        public Calendar read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            aVar.c();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (aVar.f() != b.END_OBJECT) {
                String g2 = aVar.g();
                int m = aVar.m();
                if ("year".equals(g2)) {
                    i = m;
                } else if ("month".equals(g2)) {
                    i2 = m;
                } else if ("dayOfMonth".equals(g2)) {
                    i3 = m;
                } else if ("hourOfDay".equals(g2)) {
                    i4 = m;
                } else if ("minute".equals(g2)) {
                    i5 = m;
                } else if ("second".equals(g2)) {
                    i6 = m;
                }
            }
            aVar.d();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        /* renamed from: a */
        public void write(c cVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                cVar.f();
                return;
            }
            cVar.d();
            cVar.a("year");
            cVar.a((long) calendar.get(1));
            cVar.a("month");
            cVar.a((long) calendar.get(2));
            cVar.a("dayOfMonth");
            cVar.a((long) calendar.get(5));
            cVar.a("hourOfDay");
            cVar.a((long) calendar.get(11));
            cVar.a("minute");
            cVar.a((long) calendar.get(12));
            cVar.a("second");
            cVar.a((long) calendar.get(13));
            cVar.e();
        }
    };
    public static final x U = b(Calendar.class, GregorianCalendar.class, T);
    public static final w<Locale> V = new w<Locale>() {
        /* renamed from: a */
        public Locale read(com.google.a.d.a aVar) throws IOException {
            String str = null;
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.h(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            }
            if (nextToken2 == null && str == null) {
                return new Locale(nextToken);
            }
            if (str == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, str);
        }

        /* renamed from: a */
        public void write(c cVar, Locale locale) throws IOException {
            cVar.b(locale == null ? null : locale.toString());
        }
    };
    public static final x W = a(Locale.class, V);
    public static final w<l> X = new w<l>() {
        /* renamed from: a */
        public l read(com.google.a.d.a aVar) throws IOException {
            switch (AnonymousClass30.f8823a[aVar.f().ordinal()]) {
                case 1:
                    return new r((Number) new g(aVar.h()));
                case 2:
                    return new r(Boolean.valueOf(aVar.i()));
                case 3:
                    return new r(aVar.h());
                case 4:
                    aVar.j();
                    return com.google.a.n.f8933a;
                case 5:
                    i iVar = new i();
                    aVar.a();
                    while (aVar.e()) {
                        iVar.a(read(aVar));
                    }
                    aVar.b();
                    return iVar;
                case 6:
                    o oVar = new o();
                    aVar.c();
                    while (aVar.e()) {
                        oVar.a(aVar.g(), read(aVar));
                    }
                    aVar.d();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* renamed from: a */
        public void write(c cVar, l lVar) throws IOException {
            if (lVar == null || lVar.l()) {
                cVar.f();
            } else if (lVar.k()) {
                r o = lVar.o();
                if (o.q()) {
                    cVar.a(o.b());
                } else if (o.a()) {
                    cVar.a(o.h());
                } else {
                    cVar.b(o.c());
                }
            } else if (lVar.i()) {
                cVar.b();
                Iterator<l> it = lVar.n().iterator();
                while (it.hasNext()) {
                    write(cVar, it.next());
                }
                cVar.c();
            } else if (lVar.j()) {
                cVar.d();
                for (Map.Entry next : lVar.m().a()) {
                    cVar.a((String) next.getKey());
                    write(cVar, (l) next.getValue());
                }
                cVar.e();
            } else {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
        }
    };
    public static final x Y = b(l.class, X);
    public static final x Z = new x() {
        /* JADX WARNING: type inference failed for: r2v0, types: [com.google.a.c.a<T>, com.google.a.c.a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> com.google.a.w<T> create(com.google.a.f r1, com.google.a.c.a<T> r2) {
            /*
                r0 = this;
                java.lang.Class r1 = r2.getRawType()
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                boolean r2 = r2.isAssignableFrom(r1)
                if (r2 == 0) goto L_0x0021
                java.lang.Class<java.lang.Enum> r2 = java.lang.Enum.class
                if (r1 != r2) goto L_0x0011
                goto L_0x0021
            L_0x0011:
                boolean r2 = r1.isEnum()
                if (r2 != 0) goto L_0x001b
                java.lang.Class r1 = r1.getSuperclass()
            L_0x001b:
                com.google.a.b.a.n$a r2 = new com.google.a.b.a.n$a
                r2.<init>(r1)
                return r2
            L_0x0021:
                r1 = 0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.n.AnonymousClass24.create(com.google.a.f, com.google.a.c.a):com.google.a.w");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final w<Class> f8800a = new w<Class>() {
        /* renamed from: a */
        public void write(c cVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }

        /* renamed from: a */
        public Class read(com.google.a.d.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }.nullSafe();

    /* renamed from: b  reason: collision with root package name */
    public static final x f8801b = a(Class.class, f8800a);

    /* renamed from: c  reason: collision with root package name */
    public static final w<BitSet> f8802c = new w<BitSet>() {
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
            if (r8.m() != 0) goto L_0x0069;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.BitSet read(com.google.a.d.a r8) throws java.io.IOException {
            /*
                r7 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r8.a()
                com.google.a.d.b r1 = r8.f()
                r2 = 0
                r3 = 0
            L_0x000e:
                com.google.a.d.b r4 = com.google.a.d.b.END_ARRAY
                if (r1 == r4) goto L_0x0075
                int[] r4 = com.google.a.b.a.n.AnonymousClass30.f8823a
                int r5 = r1.ordinal()
                r4 = r4[r5]
                r5 = 1
                if (r4 == r5) goto L_0x0063
                r6 = 2
                if (r4 == r6) goto L_0x005e
                r6 = 3
                if (r4 != r6) goto L_0x0047
                java.lang.String r1 = r8.h()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                goto L_0x0069
            L_0x002e:
                r5 = 0
                goto L_0x0069
            L_0x0030:
                com.google.a.u r8 = new com.google.a.u
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Error: Expecting: bitset number value (1, 0), Found: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>((java.lang.String) r0)
                throw r8
            L_0x0047:
                com.google.a.u r8 = new com.google.a.u
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>((java.lang.String) r0)
                throw r8
            L_0x005e:
                boolean r5 = r8.i()
                goto L_0x0069
            L_0x0063:
                int r1 = r8.m()
                if (r1 == 0) goto L_0x002e
            L_0x0069:
                if (r5 == 0) goto L_0x006e
                r0.set(r3)
            L_0x006e:
                int r3 = r3 + 1
                com.google.a.d.b r1 = r8.f()
                goto L_0x000e
            L_0x0075:
                r8.b()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.n.AnonymousClass12.read(com.google.a.d.a):java.util.BitSet");
        }

        /* renamed from: a */
        public void write(c cVar, BitSet bitSet) throws IOException {
            cVar.b();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                cVar.a(bitSet.get(i) ? 1 : 0);
            }
            cVar.c();
        }
    }.nullSafe();

    /* renamed from: d  reason: collision with root package name */
    public static final x f8803d = a(BitSet.class, f8802c);

    /* renamed from: e  reason: collision with root package name */
    public static final w<Boolean> f8804e = new w<Boolean>() {
        /* renamed from: a */
        public Boolean read(com.google.a.d.a aVar) throws IOException {
            b f2 = aVar.f();
            if (f2 == b.NULL) {
                aVar.j();
                return null;
            } else if (f2 == b.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.h()));
            } else {
                return Boolean.valueOf(aVar.i());
            }
        }

        /* renamed from: a */
        public void write(c cVar, Boolean bool) throws IOException {
            cVar.a(bool);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final w<Boolean> f8805f = new w<Boolean>() {
        /* renamed from: a */
        public Boolean read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.h());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, Boolean bool) throws IOException {
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final x f8806g = a(Boolean.TYPE, Boolean.class, f8804e);
    public static final w<Number> h = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.m());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x i = a(Byte.TYPE, Byte.class, h);
    public static final w<Number> j = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.m());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x k = a(Short.TYPE, Short.class, j);
    public static final w<Number> l = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Integer.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x m = a(Integer.TYPE, Integer.class, l);
    public static final w<AtomicInteger> n = new w<AtomicInteger>() {
        /* renamed from: a */
        public AtomicInteger read(com.google.a.d.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.m());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, AtomicInteger atomicInteger) throws IOException {
            cVar.a((long) atomicInteger.get());
        }
    }.nullSafe();
    public static final x o = a(AtomicInteger.class, n);
    public static final w<AtomicBoolean> p = new w<AtomicBoolean>() {
        /* renamed from: a */
        public AtomicBoolean read(com.google.a.d.a aVar) throws IOException {
            return new AtomicBoolean(aVar.i());
        }

        /* renamed from: a */
        public void write(c cVar, AtomicBoolean atomicBoolean) throws IOException {
            cVar.a(atomicBoolean.get());
        }
    }.nullSafe();
    public static final x q = a(AtomicBoolean.class, p);
    public static final w<AtomicIntegerArray> r = new w<AtomicIntegerArray>() {
        /* renamed from: a */
        public AtomicIntegerArray read(com.google.a.d.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.e()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.m()));
                } catch (NumberFormatException e2) {
                    throw new u((Throwable) e2);
                }
            }
            aVar.b();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        /* renamed from: a */
        public void write(c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            cVar.b();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                cVar.a((long) atomicIntegerArray.get(i));
            }
            cVar.c();
        }
    }.nullSafe();
    public static final x s = a(AtomicIntegerArray.class, r);
    public static final w<Number> t = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            try {
                return Long.valueOf(aVar.l());
            } catch (NumberFormatException e2) {
                throw new u((Throwable) e2);
            }
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w<Number> u = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.k());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w<Number> v = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.k());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final w<Number> w = new w<Number>() {
        /* renamed from: a */
        public Number read(com.google.a.d.a aVar) throws IOException {
            b f2 = aVar.f();
            int i = AnonymousClass30.f8823a[f2.ordinal()];
            if (i == 1 || i == 3) {
                return new g(aVar.h());
            }
            if (i == 4) {
                aVar.j();
                return null;
            }
            throw new u("Expecting number, got: " + f2);
        }

        /* renamed from: a */
        public void write(c cVar, Number number) throws IOException {
            cVar.a(number);
        }
    };
    public static final x x = a(Number.class, w);
    public static final w<Character> y = new w<Character>() {
        /* renamed from: a */
        public Character read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.j();
                return null;
            }
            String h = aVar.h();
            if (h.length() == 1) {
                return Character.valueOf(h.charAt(0));
            }
            throw new u("Expecting character, got: " + h);
        }

        /* renamed from: a */
        public void write(c cVar, Character ch) throws IOException {
            cVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final x z = a(Character.TYPE, Character.class, y);

    /* renamed from: com.google.a.b.a.n$30  reason: invalid class name */
    static /* synthetic */ class AnonymousClass30 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8823a = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.google.a.d.b[] r0 = com.google.a.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8823a = r0
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.a.d.b r1 = com.google.a.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.a.d.b r1 = com.google.a.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.a.d.b r1 = com.google.a.d.b.STRING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.a.d.b r1 = com.google.a.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.a.d.b r1 = com.google.a.d.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.a.d.b r1 = com.google.a.d.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.a.d.b r1 = com.google.a.d.b.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.a.d.b r1 = com.google.a.d.b.NAME     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.a.d.b r1 = com.google.a.d.b.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f8823a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.a.d.b r1 = com.google.a.d.b.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x007a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.a.n.AnonymousClass30.<clinit>():void");
        }
    }

    private static final class a<T extends Enum<T>> extends w<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, T> f8824a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map<T, String> f8825b = new HashMap();

        public a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    com.google.a.a.c cVar = (com.google.a.a.c) cls.getField(name).getAnnotation(com.google.a.a.c.class);
                    if (cVar != null) {
                        name = cVar.a();
                        for (String put : cVar.b()) {
                            this.f8824a.put(put, enumR);
                        }
                    }
                    this.f8824a.put(name, enumR);
                    this.f8825b.put(enumR, name);
                }
            } catch (NoSuchFieldException e2) {
                throw new AssertionError(e2);
            }
        }

        /* renamed from: a */
        public T read(com.google.a.d.a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return (Enum) this.f8824a.get(aVar.h());
            }
            aVar.j();
            return null;
        }

        /* renamed from: a */
        public void write(c cVar, T t) throws IOException {
            cVar.b(t == null ? null : this.f8825b.get(t));
        }
    }

    public static <TT> x a(final com.google.a.c.a<TT> aVar, final w<TT> wVar) {
        return new x() {
            public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
                if (aVar.equals(aVar)) {
                    return wVar;
                }
                return null;
            }
        };
    }

    public static <TT> x a(final Class<TT> cls, final w<TT> wVar) {
        return new x() {
            public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return wVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> x a(final Class<TT> cls, final Class<TT> cls2, final w<? super TT> wVar) {
        return new x() {
            public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return wVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <TT> x b(final Class<TT> cls, final Class<? extends TT> cls2, final w<? super TT> wVar) {
        return new x() {
            public <T> w<T> create(f fVar, com.google.a.c.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return wVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls2.getName() + ",adapter=" + wVar + "]";
            }
        };
    }

    public static <T1> x b(final Class<T1> cls, final w<T1> wVar) {
        return new x() {
            public <T2> w<T2> create(f fVar, com.google.a.c.a<T2> aVar) {
                final Class<? super T2> rawType = aVar.getRawType();
                if (!cls.isAssignableFrom(rawType)) {
                    return null;
                }
                return new w<T1>() {
                    public void write(c cVar, T1 t1) throws IOException {
                        wVar.write(cVar, t1);
                    }

                    public T1 read(com.google.a.d.a aVar) throws IOException {
                        T1 read = wVar.read(aVar);
                        if (read == null || rawType.isInstance(read)) {
                            return read;
                        }
                        throw new u("Expected a " + rawType.getName() + " but was " + read.getClass().getName());
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + wVar + "]";
            }
        };
    }
}
