package com.google.android.exoplayer2.n;

import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.tencent.qcloud.core.util.IOUtils;

public final class s {
    public static Uri a(String str, String str2) {
        return Uri.parse(b(str, str2));
    }

    public static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] a2 = a(str2);
        if (a2[0] != -1) {
            sb.append(str2);
            a(sb, a2[1], a2[2]);
            return sb.toString();
        }
        int[] a3 = a(str);
        if (a2[3] == 0) {
            sb.append(str, 0, a3[3]);
            sb.append(str2);
            return sb.toString();
        } else if (a2[2] == 0) {
            sb.append(str, 0, a3[2]);
            sb.append(str2);
            return sb.toString();
        } else if (a2[1] != 0) {
            int i = a3[0] + 1;
            sb.append(str, 0, i);
            sb.append(str2);
            return a(sb, a2[1] + i, i + a2[2]);
        } else if (str2.charAt(a2[1]) == '/') {
            sb.append(str, 0, a3[1]);
            sb.append(str2);
            return a(sb, a3[1], a3[1] + a2[2]);
        } else if (a3[0] + 2 >= a3[1] || a3[1] != a3[2]) {
            int lastIndexOf = str.lastIndexOf(47, a3[2] - 1);
            int i2 = lastIndexOf == -1 ? a3[1] : lastIndexOf + 1;
            sb.append(str, 0, i2);
            sb.append(str2);
            return a(sb, a3[1], i2 + a2[2]);
        } else {
            sb.append(str, 0, a3[1]);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(str2);
            return a(sb, a3[1], a3[1] + a2[2] + 1);
        }
    }

    private static String a(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i5 = i;
        int i6 = i2;
        while (true) {
            int i7 = i5;
            while (i7 <= i6) {
                if (i7 == i6) {
                    i3 = i7;
                } else if (sb.charAt(i7) == '/') {
                    i3 = i7 + 1;
                } else {
                    i7++;
                }
                int i8 = i5 + 1;
                if (i7 == i8 && sb.charAt(i5) == '.') {
                    sb.delete(i5, i3);
                    i6 -= i3 - i5;
                } else {
                    if (i7 == i5 + 2 && sb.charAt(i5) == '.' && sb.charAt(i8) == '.') {
                        i4 = sb.lastIndexOf(Constants.URL_PATH_DELIMITER, i5 - 2) + 1;
                        int i9 = i4 > i ? i4 : i;
                        sb.delete(i9, i3);
                        i6 -= i3 - i9;
                    } else {
                        i4 = i7 + 1;
                    }
                    i5 = i4;
                }
            }
            return sb.toString();
        }
    }

    private static int[] a(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i2 = indexOf4 + 2;
        if (i2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i2) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }
}
