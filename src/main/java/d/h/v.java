package d.h;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.salesforce.android.chat.core.model.PreChatField;
import d.d.b.j;
import d.d.b.k;
import d.e.c;
import d.e.d;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class v extends u {
    public static final CharSequence a(CharSequence charSequence, int i, char c2) {
        j.b(charSequence, "$this$padStart");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static final String a(String str, int i, char c2) {
        j.b(str, "$this$padStart");
        return m.a((CharSequence) str, i, c2).toString();
    }

    public static final c c(CharSequence charSequence) {
        j.b(charSequence, "$this$indices");
        return new c(0, charSequence.length() - 1);
    }

    public static final int d(CharSequence charSequence) {
        j.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, c cVar) {
        j.b(charSequence, "$this$substring");
        j.b(cVar, "range");
        return charSequence.subSequence(cVar.f().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static final String a(String str, char c2, String str2) {
        j.b(str, "$this$substringAfterLast");
        j.b(str2, "missingDelimiterValue");
        int b2 = m.b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (b2 == -1) {
            return str2;
        }
        String substring = str.substring(b2 + 1, str.length());
        j.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String a(String str, CharSequence charSequence) {
        j.b(str, "$this$removePrefix");
        j.b(charSequence, "prefix");
        if (!m.a((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        j.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String b(String str, CharSequence charSequence) {
        j.b(str, "$this$removeSuffix");
        j.b(charSequence, "suffix");
        if (!m.b((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        j.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String a(String str, CharSequence charSequence, CharSequence charSequence2) {
        j.b(str, "$this$removeSurrounding");
        j.b(charSequence, "prefix");
        j.b(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length()) {
            return str;
        }
        CharSequence charSequence3 = str;
        if (!m.a(charSequence3, charSequence, false, 2, (Object) null) || !m.b(charSequence3, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        j.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String c(String str, CharSequence charSequence) {
        j.b(str, "$this$removeSurrounding");
        j.b(charSequence, "delimiter");
        return m.a(str, charSequence, charSequence);
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        j.b(charSequence, "$this$regionMatchesImpl");
        j.b(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!a.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m.a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        j.b(charSequence, "$this$startsWith");
        j.b(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return m.a((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return m.a(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean b(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m.b(charSequence, charSequence2, z);
    }

    public static final boolean b(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        j.b(charSequence, "$this$endsWith");
        j.b(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return m.b((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return m.a(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        j.b(charSequence, "$this$indexOfAny");
        j.b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int c2 = d.c(i, 0);
            int d2 = m.d(charSequence);
            if (c2 > d2) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(c2);
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (a.a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return c2;
                }
                if (c2 == d2) {
                    return -1;
                }
                c2++;
            }
        } else {
            return ((String) charSequence).indexOf(d.a.d.a(cArr), i);
        }
    }

    public static final int b(CharSequence charSequence, char[] cArr, int i, boolean z) {
        j.b(charSequence, "$this$lastIndexOfAny");
        j.b(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int d2 = d.d(i, m.d(charSequence)); d2 >= 0; d2--) {
                char charAt = charSequence.charAt(d2);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (a.a(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return d2;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(d.a.d.a(cArr), i);
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        d.e.a aVar;
        if (!z2) {
            aVar = new c(d.c(i, 0), d.d(i2, charSequence.length()));
        } else {
            aVar = d.a(d.d(i, m.d(charSequence)), d.c(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a2 = aVar.a();
            int b2 = aVar.b();
            int c2 = aVar.c();
            if (c2 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (true) {
                if (m.a(charSequence2, 0, charSequence, a2, charSequence2.length(), z)) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
        } else {
            int a3 = aVar.a();
            int b3 = aVar.b();
            int c3 = aVar.c();
            if (c3 >= 0) {
                if (a3 > b3) {
                    return -1;
                }
            } else if (a3 < b3) {
                return -1;
            }
            while (true) {
                if (m.a((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z)) {
                    return a3;
                }
                if (a3 == b3) {
                    return -1;
                }
                a3 += c3;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final d.j<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (z || collection.size() != 1) {
            d.e.a cVar = !z2 ? new c(d.c(i, 0), charSequence.length()) : d.a(d.d(i, m.d(charSequence)), 0);
            if (charSequence instanceof String) {
                int a2 = cVar.a();
                int b2 = cVar.b();
                int c2 = cVar.c();
                if (c2 < 0 ? a2 >= b2 : a2 <= b2) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (m.a(str, 0, (String) charSequence, a2, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (a2 == b2) {
                                break;
                            }
                            a2 += c2;
                        } else {
                            return l.a(Integer.valueOf(a2), str2);
                        }
                    }
                }
            } else {
                int a3 = cVar.a();
                int b3 = cVar.b();
                int c3 = cVar.c();
                if (c3 < 0 ? a3 >= b3 : a3 <= b3) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (m.a((CharSequence) str3, 0, charSequence, a3, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (a3 == b3) {
                                break;
                            }
                            a3 += c3;
                        } else {
                            return l.a(Integer.valueOf(a3), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) d.a.j.b(collection);
        int a4 = !z2 ? m.a(charSequence, str5, i, false, 4, (Object) null) : m.b(charSequence, str5, i, false, 4, (Object) null);
        if (a4 < 0) {
            return null;
        }
        return l.a(Integer.valueOf(a4), str5);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m.a(charSequence, c2, i, z);
    }

    public static final int a(CharSequence charSequence, char c2, int i, boolean z) {
        j.b(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i);
        }
        return m.a(charSequence, new char[]{c2}, i, z);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        j.b(charSequence, "$this$indexOf");
        j.b(str, PreChatField.STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return a(charSequence, str, i, charSequence.length(), z, false, 16, (Object) null);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m.d(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m.b(charSequence, c2, i, z);
    }

    public static final int b(CharSequence charSequence, char c2, int i, boolean z) {
        j.b(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i);
        }
        return m.b(charSequence, new char[]{c2}, i, z);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m.d(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        j.b(charSequence, "$this$lastIndexOf");
        j.b(str, PreChatField.STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    public static /* synthetic */ boolean c(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m.c(charSequence, charSequence2, z);
    }

    public static final boolean c(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        j.b(charSequence, "$this$contains");
        j.b(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            if (m.a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ d.g.a a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    private static final d.g.a<c> a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new e(charSequence, i, i2, new a(d.a.d.a((T[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    static final class a extends k implements d.d.a.c<CharSequence, Integer, d.j<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(List list, boolean z) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z;
        }

        public /* synthetic */ Object a(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }

        public final d.j<Integer, Integer> a(CharSequence charSequence, int i) {
            j.b(charSequence, "$receiver");
            d.j a2 = v.b(charSequence, (Collection<String>) this.$delimitersList, i, this.$ignoreCase, false);
            if (a2 != null) {
                return l.a(a2.a(), Integer.valueOf(((String) a2.b()).length()));
            }
            return null;
        }
    }

    static final class b extends k implements d.d.a.b<c, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        public final String a(c cVar) {
            j.b(cVar, "it");
            return m.a(this.$this_splitToSequence, cVar);
        }
    }

    public static /* synthetic */ d.g.a a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m.a(charSequence, strArr, z, i);
    }

    public static final d.g.a<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        j.b(charSequence, "$this$splitToSequence");
        j.b(strArr, "delimiters");
        return d.g.b.a(a(charSequence, strArr, 0, z, i, 2, (Object) null), new b(charSequence));
    }

    public static /* synthetic */ List b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m.b(charSequence, strArr, z, i);
    }

    public static final List<String> b(CharSequence charSequence, String[] strArr, boolean z, int i) {
        j.b(charSequence, "$this$split");
        j.b(strArr, "delimiters");
        if (strArr.length == 1) {
            boolean z2 = false;
            String str = strArr[0];
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable<c> a2 = d.g.b.a(a(charSequence, strArr, 0, z, i, 2, (Object) null));
        Collection arrayList = new ArrayList(d.a.j.a(a2, 10));
        for (c a3 : a2) {
            arrayList.add(m.a(charSequence, a3));
        }
        return (List) arrayList;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int a2 = m.a(charSequence, str, 0, z);
            if (a2 == -1 || i == 1) {
                return d.a.j.a(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = d.d(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, a2).toString());
                i2 = str.length() + a2;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                a2 = m.a(charSequence, str, i2, z);
            } while (a2 != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public static final CharSequence b(CharSequence charSequence) {
        j.b(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean a2 = a.a(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!a2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!a2) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }
}
