package d.a;

import com.facebook.share.internal.ShareConstants;
import d.d.a.b;
import d.d.b.j;
import java.util.Collection;
import java.util.NoSuchElementException;

class h extends g {
    public static final <T> boolean a(T[] tArr, T t) {
        j.b(tArr, "$this$contains");
        return d.b(tArr, t) >= 0;
    }

    public static final boolean a(boolean[] zArr, boolean z) {
        j.b(zArr, "$this$contains");
        return d.b(zArr, z) >= 0;
    }

    public static final <T> T a(T[] tArr, int i) {
        j.b(tArr, "$this$getOrNull");
        if (i < 0 || i > d.c(tArr)) {
            return null;
        }
        return tArr[i];
    }

    public static final <T> int b(T[] tArr, T t) {
        j.b(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (j.a((Object) t, (Object) tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final int b(boolean[] zArr, boolean z) {
        j.b(zArr, "$this$indexOf");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int c(boolean[] zArr, boolean z) {
        j.b(zArr, "$this$lastIndexOf");
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (z == zArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final char a(char[] cArr) {
        j.b(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <T> T b(T[] tArr) {
        j.b(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> int c(T[] tArr) {
        j.b(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c2) {
        j.b(tArr, "$this$toCollection");
        j.b(c2, ShareConstants.DESTINATION);
        for (T add : tArr) {
            c2.add(add);
        }
        return c2;
    }

    public static final <A extends Appendable> A a(byte[] bArr, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b<? super Byte, ? extends CharSequence> bVar) {
        j.b(bArr, "$this$joinTo");
        j.b(a2, "buffer");
        j.b(charSequence, "separator");
        j.b(charSequence2, "prefix");
        j.b(charSequence3, "postfix");
        j.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (byte b2 : bArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (bVar != null) {
                a2.append((CharSequence) bVar.a(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf(b2));
            }
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        CharSequence charSequence6 = charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar = null;
        }
        return d.a(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final String a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, b<? super Byte, ? extends CharSequence> bVar) {
        j.b(bArr, "$this$joinToString");
        j.b(charSequence, "separator");
        j.b(charSequence2, "prefix");
        j.b(charSequence3, "postfix");
        j.b(charSequence4, "truncated");
        String sb = ((StringBuilder) d.a(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        j.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
