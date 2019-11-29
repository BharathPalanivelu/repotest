package com.google.zxing.f;

import com.google.zxing.w;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class z extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14754a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f14755b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    /* renamed from: a */
    public y b(w wVar) {
        String c2 = c(wVar);
        if (c2.startsWith("URL:") || c2.startsWith("URI:")) {
            return new y(c2.substring(4).trim(), (String) null);
        }
        String trim = c2.trim();
        if (e(trim)) {
            return new y(trim, (String) null);
        }
        return null;
    }

    static boolean e(String str) {
        if (str.contains(SQLBuilder.BLANK)) {
            return false;
        }
        Matcher matcher = f14754a.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f14755b.matcher(str);
        if (!matcher2.find() || matcher2.start() != 0) {
            return false;
        }
        return true;
    }
}
