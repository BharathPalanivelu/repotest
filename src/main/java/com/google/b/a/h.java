package com.google.b.a;

import com.facebook.appevents.AppEventsConstants;
import com.google.b.a.g;
import com.google.b.a.i;
import com.google.b.a.j;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h {

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f13593a = Pattern.compile("[+＋]+");

    /* renamed from: b  reason: collision with root package name */
    static final Pattern f13594b = Pattern.compile("[\\\\/] *x");

    /* renamed from: c  reason: collision with root package name */
    static final Pattern f13595c = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");

    /* renamed from: d  reason: collision with root package name */
    static final String f13596d = d("xｘ#＃~～");

    /* renamed from: e  reason: collision with root package name */
    static final Pattern f13597e = Pattern.compile("(\\D+)");

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f13598f = Logger.getLogger(h.class.getName());

    /* renamed from: g  reason: collision with root package name */
    private static final Map<Integer, String> f13599g;
    private static final Set<Integer> h;
    private static final Set<Integer> i;
    private static final Map<Character, Character> j;
    private static final Map<Character, Character> k;
    private static final Map<Character, Character> l;
    private static final Map<Character, Character> m;
    private static final Pattern n = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
    private static final String o = (Arrays.toString(k.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(k.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
    private static final Pattern p = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    private static final Pattern q = Pattern.compile("(\\p{Nd})");
    private static final Pattern r = Pattern.compile("[+＋\\p{Nd}]");
    private static final Pattern s = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    private static final String t = ("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*" + o + "\\p{Nd}" + "]*");
    private static final String u;
    private static final Pattern v = Pattern.compile("(?:" + u + ")$", 66);
    private static final Pattern w = Pattern.compile(t + "(?:" + u + ")?", 66);
    private static final Pattern x = Pattern.compile("(\\$\\d)");
    private static final Pattern y = Pattern.compile("\\(?\\$1\\)?");
    private static h z = null;
    private final e A;
    private final Map<Integer, List<String>> B;
    private final com.google.b.a.a.a C = com.google.b.a.a.b.a();
    private final Set<String> D = new HashSet(35);
    private final com.google.b.a.a.c E = new com.google.b.a.a.c(100);
    private final Set<String> F = new HashSet(320);
    private final Set<Integer> G = new HashSet();

    public enum a {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum b {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum c {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(54, "9");
        f13599g = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        h = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        i = Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        k = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(k);
        hashMap4.putAll(hashMap2);
        l = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        j = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character charValue : k.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap6.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put(65293, '-');
        hashMap6.put(8208, '-');
        hashMap6.put(8209, '-');
        hashMap6.put(8210, '-');
        hashMap6.put(8211, '-');
        hashMap6.put(8212, '-');
        hashMap6.put(8213, '-');
        hashMap6.put(8722, '-');
        hashMap6.put(Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX), Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX));
        hashMap6.put(65295, Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX));
        hashMap6.put(' ', ' ');
        hashMap6.put(12288, ' ');
        hashMap6.put(8288, ' ');
        hashMap6.put('.', '.');
        hashMap6.put(65294, '.');
        m = Collections.unmodifiableMap(hashMap6);
        StringBuilder sb = new StringBuilder();
        sb.append(",;");
        sb.append("xｘ#＃~～");
        u = d(sb.toString());
    }

    private static String d(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*" + "(\\p{Nd}{1,7})" + "#?|[- ]+(" + "\\p{Nd}" + "{1,5})#";
    }

    h(e eVar, Map<Integer, List<String>> map) {
        this.A = eVar;
        this.B = map;
        for (Map.Entry next : map.entrySet()) {
            List list = (List) next.getValue();
            if (list.size() != 1 || !"001".equals(list.get(0))) {
                this.F.addAll(list);
            } else {
                this.G.add(next.getKey());
            }
        }
        if (this.F.remove("001")) {
            f13598f.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.D.addAll(map.get(1));
    }

    static CharSequence a(CharSequence charSequence) {
        Matcher matcher = r.matcher(charSequence);
        if (!matcher.find()) {
            return "";
        }
        CharSequence subSequence = charSequence.subSequence(matcher.start(), charSequence.length());
        Matcher matcher2 = f13595c.matcher(subSequence);
        if (matcher2.find()) {
            subSequence = subSequence.subSequence(0, matcher2.start());
        }
        Matcher matcher3 = f13594b.matcher(subSequence);
        return matcher3.find() ? subSequence.subSequence(0, matcher3.start()) : subSequence;
    }

    static boolean b(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return w.matcher(charSequence).matches();
    }

    static StringBuilder a(StringBuilder sb) {
        if (s.matcher(sb).matches()) {
            sb.replace(0, sb.length(), a((CharSequence) sb, l, true));
        } else {
            sb.replace(0, sb.length(), c((CharSequence) sb));
        }
        return sb;
    }

    public static String c(CharSequence charSequence) {
        return a(charSequence, false).toString();
    }

    static StringBuilder a(CharSequence charSequence, boolean z2) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z2) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public static String d(CharSequence charSequence) {
        return a(charSequence, j, true);
    }

    private static String a(CharSequence charSequence, Map<Character, Character> map, boolean z2) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z2) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    static synchronized void a(h hVar) {
        synchronized (h.class) {
            z = hVar;
        }
    }

    private static boolean a(i.d dVar) {
        return (dVar.c() == 1 && dVar.a(0) == -1) ? false : true;
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (z == null) {
                a(a(d.f13583a));
            }
            hVar = z;
        }
        return hVar;
    }

    public static h a(c cVar) {
        if (cVar != null) {
            return a((e) new f(cVar));
        }
        throw new IllegalArgumentException("metadataLoader could not be null.");
    }

    private static h a(e eVar) {
        if (eVar != null) {
            return new h(eVar, b.a());
        }
        throw new IllegalArgumentException("metadataSource could not be null.");
    }

    private boolean e(String str) {
        return str != null && this.F.contains(str);
    }

    private boolean c(int i2) {
        return this.B.containsKey(Integer.valueOf(i2));
    }

    public String a(j.a aVar, a aVar2) {
        if (aVar.b() == 0 && aVar.i()) {
            String j2 = aVar.j();
            if (j2.length() > 0) {
                return j2;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        a(aVar, aVar2, sb);
        return sb.toString();
    }

    public void a(j.a aVar, a aVar2, StringBuilder sb) {
        sb.setLength(0);
        int a2 = aVar.a();
        String a3 = a(aVar);
        if (aVar2 == a.E164) {
            sb.append(a3);
            a(a2, a.E164, sb);
        } else if (!c(a2)) {
            sb.append(a3);
        } else {
            i.b a4 = a(a2, b(a2));
            sb.append(a(a3, a4, aVar2));
            a(aVar, a4, aVar2, sb);
            a(a2, aVar2, sb);
        }
    }

    public String a(j.a aVar, a aVar2, List<i.a> list) {
        int a2 = aVar.a();
        String a3 = a(aVar);
        if (!c(a2)) {
            return a3;
        }
        i.b a4 = a(a2, b(a2));
        StringBuilder sb = new StringBuilder(20);
        i.a a5 = a(list, a3);
        if (a5 == null) {
            sb.append(a3);
        } else {
            i.a.C0221a a6 = i.a.a();
            a6.a(a5);
            String h2 = a5.h();
            if (h2.length() > 0) {
                String p2 = a4.p();
                if (p2.length() > 0) {
                    a6.d(h2.replace("$NP", p2).replace("$FG", "$1"));
                } else {
                    a6.i();
                }
            }
            sb.append(a(a3, (i.a) a6, aVar2));
        }
        a(aVar, a4, aVar2, sb);
        a(a2, aVar2, sb);
        return sb.toString();
    }

    private i.b a(int i2, String str) {
        if ("001".equals(str)) {
            return a(i2);
        }
        return a(str);
    }

    public String a(j.a aVar, String str) {
        if (!e(str)) {
            Logger logger = f13598f;
            Level level = Level.WARNING;
            logger.log(level, "Trying to format number from invalid region " + str + ". International formatting applied.");
            return a(aVar, a.INTERNATIONAL);
        }
        int a2 = aVar.a();
        String a3 = a(aVar);
        if (!c(a2)) {
            return a3;
        }
        if (a2 == 1) {
            if (c(str)) {
                return a2 + SQLBuilder.BLANK + a(aVar, a.NATIONAL);
            }
        } else if (a2 == f(str)) {
            return a(aVar, a.NATIONAL);
        }
        i.b a4 = a(str);
        String m2 = a4.m();
        if (!n.matcher(m2).matches()) {
            m2 = a4.n() ? a4.o() : "";
        }
        i.b a5 = a(a2, b(a2));
        StringBuilder sb = new StringBuilder(a(a3, a5, a.INTERNATIONAL));
        a(aVar, a5, a.INTERNATIONAL, sb);
        if (m2.length() > 0) {
            sb.insert(0, SQLBuilder.BLANK).insert(0, a2).insert(0, SQLBuilder.BLANK).insert(0, m2);
        } else {
            a(a2, a.INTERNATIONAL, sb);
        }
        return sb.toString();
    }

    public String b(j.a aVar, String str) {
        String str2;
        if (aVar.i() && !d(aVar)) {
            return aVar.j();
        }
        if (!aVar.k()) {
            return a(aVar, a.NATIONAL);
        }
        int i2 = AnonymousClass1.f13600a[aVar.l().ordinal()];
        if (i2 == 1) {
            str2 = a(aVar, a.INTERNATIONAL);
        } else if (i2 == 2) {
            str2 = a(aVar, str);
        } else if (i2 != 3) {
            String b2 = b(aVar.a());
            String a2 = a(b2, true);
            str2 = a(aVar, a.NATIONAL);
            if (!(a2 == null || a2.length() == 0 || a(aVar.j(), a2, b2))) {
                i.a a3 = a(a(b2).v(), a(aVar));
                if (a3 != null) {
                    String h2 = a3.h();
                    int indexOf = h2.indexOf("$1");
                    if (indexOf > 0 && c((CharSequence) h2.substring(0, indexOf)).length() != 0) {
                        i.a.C0221a a4 = i.a.a();
                        a4.a(a3);
                        a4.i();
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(a4);
                        str2 = a(aVar, a.NATIONAL, (List<i.a>) arrayList);
                    }
                }
            }
        } else {
            str2 = a(aVar, a.INTERNATIONAL).substring(1);
        }
        String j2 = aVar.j();
        return (str2 == null || j2.length() <= 0 || d((CharSequence) str2).equals(d((CharSequence) j2))) ? str2 : j2;
    }

    private boolean a(String str, String str2, String str3) {
        String c2 = c((CharSequence) str);
        if (c2.startsWith(str2)) {
            try {
                return b(a((CharSequence) c2.substring(str2.length()), str3));
            } catch (g unused) {
            }
        }
        return false;
    }

    private boolean d(j.a aVar) {
        int a2 = aVar.a();
        i.b a3 = a(a2, b(a2));
        if (a3 == null) {
            return false;
        }
        if (a(a3.v(), a(aVar)) != null) {
            return true;
        }
        return false;
    }

    public String a(j.a aVar) {
        StringBuilder sb = new StringBuilder();
        if (aVar.f() && aVar.h() > 0) {
            char[] cArr = new char[aVar.h()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(aVar.b());
        return sb.toString();
    }

    private void a(int i2, a aVar, StringBuilder sb) {
        int i3 = AnonymousClass1.f13601b[aVar.ordinal()];
        if (i3 == 1) {
            sb.insert(0, i2).insert(0, '+');
        } else if (i3 == 2) {
            sb.insert(0, SQLBuilder.BLANK).insert(0, i2).insert(0, '+');
        } else if (i3 == 3) {
            sb.insert(0, "-").insert(0, i2).insert(0, '+').insert(0, "tel:");
        }
    }

    private String a(String str, i.b bVar, a aVar) {
        return a(str, bVar, aVar, (CharSequence) null);
    }

    private String a(String str, i.b bVar, a aVar, CharSequence charSequence) {
        List<i.a> list;
        if (bVar.x().size() == 0 || aVar == a.NATIONAL) {
            list = bVar.v();
        } else {
            list = bVar.x();
        }
        i.a a2 = a(list, str);
        return a2 == null ? str : a(str, a2, aVar, charSequence);
    }

    /* access modifiers changed from: package-private */
    public i.a a(List<i.a> list, String str) {
        for (i.a next : list) {
            int f2 = next.f();
            if ((f2 == 0 || this.E.a(next.a(f2 - 1)).matcher(str).lookingAt()) && this.E.a(next.c()).matcher(str).matches()) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public String a(String str, i.a aVar, a aVar2) {
        return a(str, aVar, aVar2, (CharSequence) null);
    }

    private String a(String str, i.a aVar, a aVar2, CharSequence charSequence) {
        String str2;
        String e2 = aVar.e();
        Matcher matcher = this.E.a(aVar.c()).matcher(str);
        if (aVar2 != a.NATIONAL || charSequence == null || charSequence.length() <= 0 || aVar.m().length() <= 0) {
            String h2 = aVar.h();
            if (aVar2 != a.NATIONAL || h2 == null || h2.length() <= 0) {
                str2 = matcher.replaceAll(e2);
            } else {
                str2 = matcher.replaceAll(x.matcher(e2).replaceFirst(h2));
            }
        } else {
            str2 = matcher.replaceAll(x.matcher(e2).replaceFirst(aVar.m().replace("$CC", charSequence)));
        }
        if (aVar2 != a.RFC3966) {
            return str2;
        }
        Matcher matcher2 = p.matcher(str2);
        if (matcher2.lookingAt()) {
            str2 = matcher2.replaceFirst("");
        }
        return matcher2.reset(str2).replaceAll("-");
    }

    private void a(j.a aVar, i.b bVar, a aVar2, StringBuilder sb) {
        if (aVar.c() && aVar.d().length() > 0) {
            if (aVar2 == a.RFC3966) {
                sb.append(";ext=");
                sb.append(aVar.d());
            } else if (bVar.q()) {
                sb.append(bVar.r());
                sb.append(aVar.d());
            } else {
                sb.append(" ext. ");
                sb.append(aVar.d());
            }
        }
    }

    /* renamed from: com.google.b.a.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13600a = new int[j.a.C0222a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f13601b = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|(2:37|38)|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00ca */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00d4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00de */
        static {
            /*
                com.google.b.a.h$b[] r0 = com.google.b.a.h.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13602c = r0
                r0 = 1
                int[] r1 = f13602c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.google.b.a.h$b r2 = com.google.b.a.h.b.PREMIUM_RATE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f13602c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.google.b.a.h$b r3 = com.google.b.a.h.b.TOLL_FREE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f13602c     // Catch:{ NoSuchFieldError -> 0x002a }
                com.google.b.a.h$b r4 = com.google.b.a.h.b.MOBILE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.FIXED_LINE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.FIXED_LINE_OR_MOBILE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x004b }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.SHARED_COST     // Catch:{ NoSuchFieldError -> 0x004b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.VOIP     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.PERSONAL_NUMBER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x006e }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.PAGER     // Catch:{ NoSuchFieldError -> 0x006e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r6 = 9
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x007a }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.UAN     // Catch:{ NoSuchFieldError -> 0x007a }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r6 = 10
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r4 = f13602c     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.google.b.a.h$b r5 = com.google.b.a.h.b.VOICEMAIL     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r6 = 11
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                com.google.b.a.h$a[] r4 = com.google.b.a.h.a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f13601b = r4
                int[] r4 = f13601b     // Catch:{ NoSuchFieldError -> 0x0099 }
                com.google.b.a.h$a r5 = com.google.b.a.h.a.E164     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r4 = f13601b     // Catch:{ NoSuchFieldError -> 0x00a3 }
                com.google.b.a.h$a r5 = com.google.b.a.h.a.INTERNATIONAL     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r4 = f13601b     // Catch:{ NoSuchFieldError -> 0x00ad }
                com.google.b.a.h$a r5 = com.google.b.a.h.a.RFC3966     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r4 = f13601b     // Catch:{ NoSuchFieldError -> 0x00b7 }
                com.google.b.a.h$a r5 = com.google.b.a.h.a.NATIONAL     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                com.google.b.a.j$a$a[] r4 = com.google.b.a.j.a.C0222a.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f13600a = r4
                int[] r4 = f13600a     // Catch:{ NoSuchFieldError -> 0x00ca }
                com.google.b.a.j$a$a r5 = com.google.b.a.j.a.C0222a.FROM_NUMBER_WITH_PLUS_SIGN     // Catch:{ NoSuchFieldError -> 0x00ca }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ca }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00ca }
            L_0x00ca:
                int[] r0 = f13600a     // Catch:{ NoSuchFieldError -> 0x00d4 }
                com.google.b.a.j$a$a r4 = com.google.b.a.j.a.C0222a.FROM_NUMBER_WITH_IDD     // Catch:{ NoSuchFieldError -> 0x00d4 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d4 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00d4 }
            L_0x00d4:
                int[] r0 = f13600a     // Catch:{ NoSuchFieldError -> 0x00de }
                com.google.b.a.j$a$a r1 = com.google.b.a.j.a.C0222a.FROM_NUMBER_WITHOUT_PLUS_SIGN     // Catch:{ NoSuchFieldError -> 0x00de }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00de }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00de }
            L_0x00de:
                int[] r0 = f13600a     // Catch:{ NoSuchFieldError -> 0x00e8 }
                com.google.b.a.j$a$a r1 = com.google.b.a.j.a.C0222a.FROM_DEFAULT_COUNTRY     // Catch:{ NoSuchFieldError -> 0x00e8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e8 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e8 }
            L_0x00e8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.b.a.h.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public i.d a(i.b bVar, b bVar2) {
        switch (bVar2) {
            case PREMIUM_RATE:
                return bVar.e();
            case TOLL_FREE:
                return bVar.d();
            case MOBILE:
                return bVar.c();
            case FIXED_LINE:
            case FIXED_LINE_OR_MOBILE:
                return bVar.b();
            case SHARED_COST:
                return bVar.f();
            case VOIP:
                return bVar.h();
            case PERSONAL_NUMBER:
                return bVar.g();
            case PAGER:
                return bVar.i();
            case UAN:
                return bVar.j();
            case VOICEMAIL:
                return bVar.k();
            default:
                return bVar.a();
        }
    }

    private b a(String str, i.b bVar) {
        if (!a(str, bVar.a())) {
            return b.UNKNOWN;
        }
        if (a(str, bVar.e())) {
            return b.PREMIUM_RATE;
        }
        if (a(str, bVar.d())) {
            return b.TOLL_FREE;
        }
        if (a(str, bVar.f())) {
            return b.SHARED_COST;
        }
        if (a(str, bVar.h())) {
            return b.VOIP;
        }
        if (a(str, bVar.g())) {
            return b.PERSONAL_NUMBER;
        }
        if (a(str, bVar.i())) {
            return b.PAGER;
        }
        if (a(str, bVar.j())) {
            return b.UAN;
        }
        if (a(str, bVar.k())) {
            return b.VOICEMAIL;
        }
        if (a(str, bVar.b())) {
            if (bVar.u()) {
                return b.FIXED_LINE_OR_MOBILE;
            }
            if (a(str, bVar.c())) {
                return b.FIXED_LINE_OR_MOBILE;
            }
            return b.FIXED_LINE;
        } else if (bVar.u() || !a(str, bVar.c())) {
            return b.UNKNOWN;
        } else {
            return b.MOBILE;
        }
    }

    /* access modifiers changed from: package-private */
    public i.b a(String str) {
        if (!e(str)) {
            return null;
        }
        return this.A.a(str);
    }

    /* access modifiers changed from: package-private */
    public i.b a(int i2) {
        if (!this.B.containsKey(Integer.valueOf(i2))) {
            return null;
        }
        return this.A.a(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, i.d dVar) {
        int length = str.length();
        List<Integer> b2 = dVar.b();
        if (b2.size() <= 0 || b2.contains(Integer.valueOf(length))) {
            return this.C.a(str, dVar, false);
        }
        return false;
    }

    public boolean b(j.a aVar) {
        return c(aVar, c(aVar));
    }

    public boolean c(j.a aVar, String str) {
        int a2 = aVar.a();
        i.b a3 = a(a2, str);
        if (a3 == null) {
            return false;
        }
        if (("001".equals(str) || a2 == f(str)) && a(a(aVar), a3) != b.UNKNOWN) {
            return true;
        }
        return false;
    }

    public String c(j.a aVar) {
        int a2 = aVar.a();
        List list = this.B.get(Integer.valueOf(a2));
        if (list == null) {
            Logger logger = f13598f;
            Level level = Level.INFO;
            logger.log(level, "Missing/invalid country_code (" + a2 + SQLBuilder.PARENTHESES_RIGHT);
            return null;
        } else if (list.size() == 1) {
            return (String) list.get(0);
        } else {
            return a(aVar, (List<String>) list);
        }
    }

    private String a(j.a aVar, List<String> list) {
        String a2 = a(aVar);
        for (String next : list) {
            i.b a3 = a(next);
            if (a3.z()) {
                if (this.E.a(a3.A()).matcher(a2).lookingAt()) {
                    return next;
                }
            } else if (a(a2, a3) != b.UNKNOWN) {
                return next;
            }
        }
        return null;
    }

    public String b(int i2) {
        List list = this.B.get(Integer.valueOf(i2));
        if (list == null) {
            return "ZZ";
        }
        return (String) list.get(0);
    }

    public int b(String str) {
        if (e(str)) {
            return f(str);
        }
        Logger logger = f13598f;
        Level level = Level.WARNING;
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid or missing region code (");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(") provided.");
        logger.log(level, sb.toString());
        return 0;
    }

    private int f(String str) {
        i.b a2 = a(str);
        if (a2 != null) {
            return a2.l();
        }
        throw new IllegalArgumentException("Invalid region code: " + str);
    }

    public String a(String str, boolean z2) {
        i.b a2 = a(str);
        if (a2 == null) {
            Logger logger = f13598f;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger.log(level, sb.toString());
            return null;
        }
        String p2 = a2.p();
        if (p2.length() == 0) {
            return null;
        }
        return z2 ? p2.replace("~", "") : p2;
    }

    public boolean c(String str) {
        return this.D.contains(str);
    }

    private c a(CharSequence charSequence, i.b bVar) {
        return a(charSequence, bVar, b.UNKNOWN);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.b.a.h.c a(java.lang.CharSequence r4, com.google.b.a.i.b r5, com.google.b.a.h.b r6) {
        /*
            r3 = this;
            com.google.b.a.i$d r0 = r3.a((com.google.b.a.i.b) r5, (com.google.b.a.h.b) r6)
            java.util.List r1 = r0.b()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0017
            com.google.b.a.i$d r1 = r5.a()
            java.util.List r1 = r1.b()
            goto L_0x001b
        L_0x0017:
            java.util.List r1 = r0.b()
        L_0x001b:
            java.util.List r0 = r0.d()
            com.google.b.a.h$b r2 = com.google.b.a.h.b.FIXED_LINE_OR_MOBILE
            if (r6 != r2) goto L_0x0080
            com.google.b.a.h$b r6 = com.google.b.a.h.b.FIXED_LINE
            com.google.b.a.i$d r6 = r3.a((com.google.b.a.i.b) r5, (com.google.b.a.h.b) r6)
            boolean r6 = a((com.google.b.a.i.d) r6)
            if (r6 != 0) goto L_0x0036
            com.google.b.a.h$b r6 = com.google.b.a.h.b.MOBILE
            com.google.b.a.h$c r4 = r3.a((java.lang.CharSequence) r4, (com.google.b.a.i.b) r5, (com.google.b.a.h.b) r6)
            return r4
        L_0x0036:
            com.google.b.a.h$b r6 = com.google.b.a.h.b.MOBILE
            com.google.b.a.i$d r6 = r3.a((com.google.b.a.i.b) r5, (com.google.b.a.h.b) r6)
            boolean r2 = a((com.google.b.a.i.d) r6)
            if (r2 == 0) goto L_0x0080
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.List r1 = r6.b()
            int r1 = r1.size()
            if (r1 != 0) goto L_0x005a
            com.google.b.a.i$d r5 = r5.a()
            java.util.List r5 = r5.b()
            goto L_0x005e
        L_0x005a:
            java.util.List r5 = r6.b()
        L_0x005e:
            r2.addAll(r5)
            java.util.Collections.sort(r2)
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x006f
            java.util.List r0 = r6.d()
            goto L_0x0081
        L_0x006f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r0)
            java.util.List r6 = r6.d()
            r5.addAll(r6)
            java.util.Collections.sort(r5)
            r0 = r5
            goto L_0x0081
        L_0x0080:
            r2 = r1
        L_0x0081:
            r5 = 0
            java.lang.Object r6 = r2.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r1 = -1
            if (r6 != r1) goto L_0x0092
            com.google.b.a.h$c r4 = com.google.b.a.h.c.INVALID_LENGTH
            return r4
        L_0x0092:
            int r4 = r4.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto L_0x00a3
            com.google.b.a.h$c r4 = com.google.b.a.h.c.IS_POSSIBLE_LOCAL_ONLY
            return r4
        L_0x00a3:
            java.lang.Object r5 = r2.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 != r4) goto L_0x00b2
            com.google.b.a.h$c r4 = com.google.b.a.h.c.IS_POSSIBLE
            return r4
        L_0x00b2:
            if (r5 <= r4) goto L_0x00b7
            com.google.b.a.h$c r4 = com.google.b.a.h.c.TOO_SHORT
            return r4
        L_0x00b7:
            int r5 = r2.size()
            r6 = 1
            int r5 = r5 - r6
            java.lang.Object r5 = r2.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 >= r4) goto L_0x00cc
            com.google.b.a.h$c r4 = com.google.b.a.h.c.TOO_LONG
            return r4
        L_0x00cc:
            int r5 = r2.size()
            java.util.List r5 = r2.subList(r6, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x00e1
            com.google.b.a.h$c r4 = com.google.b.a.h.c.IS_POSSIBLE
            goto L_0x00e3
        L_0x00e1:
            com.google.b.a.h$c r4 = com.google.b.a.h.c.INVALID_LENGTH
        L_0x00e3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.a.h.a(java.lang.CharSequence, com.google.b.a.i$b, com.google.b.a.h$b):com.google.b.a.h$c");
    }

    /* access modifiers changed from: package-private */
    public int a(StringBuilder sb, StringBuilder sb2) {
        if (!(sb.length() == 0 || sb.charAt(0) == '0')) {
            int length = sb.length();
            int i2 = 1;
            while (i2 <= 3 && i2 <= length) {
                int parseInt = Integer.parseInt(sb.substring(0, i2));
                if (this.B.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i2));
                    return parseInt;
                }
                i2++;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int a(CharSequence charSequence, i.b bVar, StringBuilder sb, boolean z2, j.a aVar) throws g {
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        j.a.C0222a a2 = a(sb2, bVar != null ? bVar.m() : "NonMatch");
        if (z2) {
            aVar.a(a2);
        }
        if (a2 == j.a.C0222a.FROM_DEFAULT_COUNTRY) {
            if (bVar != null) {
                int l2 = bVar.l();
                String valueOf = String.valueOf(l2);
                String sb3 = sb2.toString();
                if (sb3.startsWith(valueOf)) {
                    StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                    i.d a3 = bVar.a();
                    a(sb4, bVar, (StringBuilder) null);
                    if ((!this.C.a(sb2, a3, false) && this.C.a(sb4, a3, false)) || a((CharSequence) sb2, bVar) == c.TOO_LONG) {
                        sb.append(sb4);
                        if (z2) {
                            aVar.a(j.a.C0222a.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        aVar.a(l2);
                        return l2;
                    }
                }
            }
            aVar.a(0);
            return 0;
        } else if (sb2.length() > 2) {
            int a4 = a(sb2, sb);
            if (a4 != 0) {
                aVar.a(a4);
                return a4;
            }
            throw new g(g.a.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        } else {
            throw new g(g.a.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
    }

    private boolean a(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (!matcher.lookingAt()) {
            return false;
        }
        int end = matcher.end();
        Matcher matcher2 = q.matcher(sb.substring(end));
        if (matcher2.find() && c((CharSequence) matcher2.group(1)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return false;
        }
        sb.delete(0, end);
        return true;
    }

    /* access modifiers changed from: package-private */
    public j.a.C0222a a(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return j.a.C0222a.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = f13593a.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            a(sb);
            return j.a.C0222a.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern a2 = this.E.a(str);
        a(sb);
        if (a(a2, sb)) {
            return j.a.C0222a.FROM_NUMBER_WITH_IDD;
        }
        return j.a.C0222a.FROM_DEFAULT_COUNTRY;
    }

    /* access modifiers changed from: package-private */
    public boolean a(StringBuilder sb, i.b bVar, StringBuilder sb2) {
        int length = sb.length();
        String s2 = bVar.s();
        if (!(length == 0 || s2.length() == 0)) {
            Matcher matcher = this.E.a(s2).matcher(sb);
            if (matcher.lookingAt()) {
                i.d a2 = bVar.a();
                boolean a3 = this.C.a(sb, a2, false);
                int groupCount = matcher.groupCount();
                String t2 = bVar.t();
                if (t2 != null && t2.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(t2));
                    if (a3 && !this.C.a(sb3.toString(), a2, false)) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                } else if (a3 && !this.C.a(sb.substring(matcher.end()), a2, false)) {
                    return false;
                } else {
                    if (!(sb2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String b(StringBuilder sb) {
        Matcher matcher = v.matcher(sb);
        if (!matcher.find() || !b((CharSequence) sb.substring(0, matcher.start()))) {
            return "";
        }
        int groupCount = matcher.groupCount();
        for (int i2 = 1; i2 <= groupCount; i2++) {
            if (matcher.group(i2) != null) {
                String group = matcher.group(i2);
                sb.delete(matcher.start(), sb.length());
                return group;
            }
        }
        return "";
    }

    private boolean b(CharSequence charSequence, String str) {
        if (!e(str)) {
            return (charSequence == null || charSequence.length() == 0 || !f13593a.matcher(charSequence).lookingAt()) ? false : true;
        }
        return true;
    }

    public j.a a(CharSequence charSequence, String str) throws g {
        j.a aVar = new j.a();
        a(charSequence, str, aVar);
        return aVar;
    }

    public void a(CharSequence charSequence, String str, j.a aVar) throws g {
        a(charSequence, str, false, true, aVar);
    }

    static void a(CharSequence charSequence, j.a aVar) {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '0') {
            aVar.a(true);
            int i2 = 1;
            while (i2 < charSequence.length() - 1 && charSequence.charAt(i2) == '0') {
                i2++;
            }
            if (i2 != 1) {
                aVar.b(i2);
            }
        }
    }

    private void a(CharSequence charSequence, String str, boolean z2, boolean z3, j.a aVar) throws g {
        int i2;
        if (charSequence == null) {
            throw new g(g.a.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (charSequence.length() <= 250) {
            StringBuilder sb = new StringBuilder();
            String charSequence2 = charSequence.toString();
            a(charSequence2, sb);
            if (!b((CharSequence) sb)) {
                throw new g(g.a.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            } else if (!z3 || b((CharSequence) sb, str)) {
                if (z2) {
                    aVar.b(charSequence2);
                }
                String b2 = b(sb);
                if (b2.length() > 0) {
                    aVar.a(b2);
                }
                i.b a2 = a(str);
                StringBuilder sb2 = new StringBuilder();
                try {
                    i2 = a((CharSequence) sb, a2, sb2, z2, aVar);
                } catch (g e2) {
                    Matcher matcher = f13593a.matcher(sb);
                    if (e2.a() != g.a.INVALID_COUNTRY_CODE || !matcher.lookingAt()) {
                        throw new g(e2.a(), e2.getMessage());
                    }
                    i2 = a((CharSequence) sb.substring(matcher.end()), a2, sb2, z2, aVar);
                    if (i2 == 0) {
                        throw new g(g.a.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                    }
                }
                if (i2 != 0) {
                    String b3 = b(i2);
                    if (!b3.equals(str)) {
                        a2 = a(i2, b3);
                    }
                } else {
                    sb2.append(a(sb));
                    if (str != null) {
                        aVar.a(a2.l());
                    } else if (z2) {
                        aVar.m();
                    }
                }
                if (sb2.length() >= 2) {
                    if (a2 != null) {
                        StringBuilder sb3 = new StringBuilder();
                        StringBuilder sb4 = new StringBuilder(sb2);
                        a(sb4, a2, sb3);
                        c a3 = a((CharSequence) sb4, a2);
                        if (!(a3 == c.TOO_SHORT || a3 == c.IS_POSSIBLE_LOCAL_ONLY || a3 == c.INVALID_LENGTH)) {
                            if (z2 && sb3.length() > 0) {
                                aVar.c(sb3.toString());
                            }
                            sb2 = sb4;
                        }
                    }
                    int length = sb2.length();
                    if (length < 2) {
                        throw new g(g.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                    } else if (length <= 17) {
                        a((CharSequence) sb2, aVar);
                        aVar.a(Long.parseLong(sb2.toString()));
                    } else {
                        throw new g(g.a.TOO_LONG, "The string supplied is too long to be a phone number.");
                    }
                } else {
                    throw new g(g.a.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                }
            } else {
                throw new g(g.a.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
            }
        } else {
            throw new g(g.a.TOO_LONG, "The string supplied was too long to parse.");
        }
    }

    private void a(String str, StringBuilder sb) {
        int indexOf = str.indexOf(";phone-context=");
        if (indexOf >= 0) {
            int i2 = indexOf + 15;
            if (i2 < str.length() - 1 && str.charAt(i2) == '+') {
                int indexOf2 = str.indexOf(59, i2);
                if (indexOf2 > 0) {
                    sb.append(str.substring(i2, indexOf2));
                } else {
                    sb.append(str.substring(i2));
                }
            }
            int indexOf3 = str.indexOf("tel:");
            sb.append(str.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf));
        } else {
            sb.append(a((CharSequence) str));
        }
        int indexOf4 = sb.indexOf(";isub=");
        if (indexOf4 > 0) {
            sb.delete(indexOf4, sb.length());
        }
    }
}
