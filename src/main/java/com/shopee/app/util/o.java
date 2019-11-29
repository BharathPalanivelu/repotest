package com.shopee.app.util;

import android.text.TextUtils;
import android.util.Patterns;

public class o {
    public static boolean a(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    public static String a(String str) {
        int indexOf = str.indexOf(64);
        if (TextUtils.isEmpty(str) || indexOf == -1) {
            return str;
        }
        String substring = str.substring(0, indexOf);
        StringBuilder sb = new StringBuilder();
        if (substring.length() == 1) {
            sb.append(str.charAt(0));
        } else {
            sb.append(str.substring(0, 2));
        }
        sb.append("*****");
        sb.append(str.substring(indexOf));
        return sb.toString();
    }
}
