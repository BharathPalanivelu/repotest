package com.salesforce.android.service.common.utilities.hashing;

public class SalesforceIdConverter {
    public static String convert15to18(String str) {
        if (str.length() == 18) {
            return str;
        }
        if (str.length() == 15) {
            String str2 = "";
            for (int i = 0; i < 3; i++) {
                int i2 = 0;
                for (int i3 = 0; i3 < 5; i3++) {
                    int i4 = (i * 5) + i3;
                    String substring = str.substring(i4, i4 + 1);
                    if (substring.compareTo("A") >= 0 && substring.compareTo("Z") <= 0) {
                        i2 += 1 << i3;
                    }
                }
                if (i2 <= 25) {
                    str2 = str2 + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i2, i2 + 1);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    int i5 = i2 - 26;
                    sb.append("012345".substring(i5, i5 + 1));
                    str2 = sb.toString();
                }
            }
            return str + str2;
        }
        throw new IllegalArgumentException("salesforceId must be 15 characters in length to be converted.");
    }
}
