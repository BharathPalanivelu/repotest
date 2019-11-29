package com.shopee.feeds.feedlibrary.util;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

public class g implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private Pattern f28307a = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[🠀-🯿]|[℀-㋿]|[0-][⃐-⃿]|[-ÿ]");

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (a(charSequence)) {
            return "";
        }
        return null;
    }

    public static boolean a(CharSequence charSequence) {
        return Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66).matcher(charSequence).find();
    }
}
