package org.apache.commons.c;

public class b {
    static boolean a(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return true;
                }
                int i5 = i + 1;
                char charAt = charSequence.charAt(i);
                int i6 = i2 + 1;
                char charAt2 = charSequence2.charAt(i2);
                if (charAt != charAt2) {
                    if (!z) {
                        return false;
                    }
                    if (!(Character.toUpperCase(charAt) == Character.toUpperCase(charAt2) || Character.toLowerCase(charAt) == Character.toLowerCase(charAt2))) {
                        return false;
                    }
                }
                i = i5;
                i3 = i4;
                i2 = i6;
            }
        } else {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
    }
}
