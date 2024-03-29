package com.google.android.gms.internal.gtm;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Locale;

@ShowFirstParty
public final class zzdp {
    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            if ((b2 & 240) == 0) {
                sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            sb.append(Integer.toHexString(b2 & 255));
        }
        return sb.toString().toUpperCase(Locale.ENGLISH);
    }

    public static byte[] decode(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 16);
                int digit2 = Character.digit(str.charAt(i + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("purported base16 string has illegal char");
                }
                bArr[i / 2] = (byte) ((digit << 4) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("purported base16 string has odd number of characters");
    }
}
