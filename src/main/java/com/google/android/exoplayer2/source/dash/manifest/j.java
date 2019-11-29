package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f12046a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f12047b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f12048c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12049d;

    public static j a(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new j(strArr, iArr, strArr2, a(str, strArr, iArr, strArr2));
    }

    private j(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f12046a = strArr;
        this.f12047b = iArr;
        this.f12048c = strArr2;
        this.f12049d = i;
    }

    public String a(String str, int i, int i2, long j) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (true) {
            int i4 = this.f12049d;
            if (i3 < i4) {
                sb.append(this.f12046a[i3]);
                int[] iArr = this.f12047b;
                if (iArr[i3] == 1) {
                    sb.append(str);
                } else if (iArr[i3] == 2) {
                    sb.append(String.format(Locale.US, this.f12048c[i3], new Object[]{Integer.valueOf(i)}));
                } else if (iArr[i3] == 3) {
                    sb.append(String.format(Locale.US, this.f12048c[i3], new Object[]{Integer.valueOf(i2)}));
                } else if (iArr[i3] == 4) {
                    sb.append(String.format(Locale.US, this.f12048c[i3], new Object[]{Long.valueOf(j)}));
                }
                i3++;
            } else {
                sb.append(this.f12046a[i4]);
                return sb.toString();
            }
        }
    }

    private static int a(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = "";
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            char c2 = 65535;
            if (indexOf == -1) {
                strArr[i2] = strArr[i2] + str.substring(i);
                i = str.length();
            } else if (indexOf != i) {
                strArr[i2] = strArr[i2] + str.substring(i, indexOf);
                i = indexOf;
            } else if (str.startsWith("$$", i)) {
                strArr[i2] = strArr[i2] + "$";
                i += 2;
            } else {
                int i3 = i + 1;
                int indexOf2 = str.indexOf("$", i3);
                String substring = str.substring(i3, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i2] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    int hashCode = substring.hashCode();
                    if (hashCode != -1950496919) {
                        if (hashCode != 2606829) {
                            if (hashCode == 38199441 && substring.equals("Bandwidth")) {
                                c2 = 1;
                            }
                        } else if (substring.equals("Time")) {
                            c2 = 2;
                        }
                    } else if (substring.equals("Number")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        iArr[i2] = 2;
                    } else if (c2 == 1) {
                        iArr[i2] = 3;
                    } else if (c2 == 2) {
                        iArr[i2] = 4;
                    } else {
                        throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i2] = str2;
                }
                i2++;
                strArr[i2] = "";
                i = indexOf2 + 1;
            }
        }
        return i2;
    }
}
