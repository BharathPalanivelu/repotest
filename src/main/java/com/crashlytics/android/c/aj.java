package com.crashlytics.android.c;

import io.a.a.a.c;
import io.a.a.a.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class aj {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f6416a = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.*)");

    public static ai a(String str) {
        Matcher matcher = f6416a.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        try {
            long longValue = Long.valueOf(matcher.group(1), 16).longValue();
            return new ai(longValue, Long.valueOf(matcher.group(2), 16).longValue() - longValue, matcher.group(3), matcher.group(4));
        } catch (Exception unused) {
            l h = c.h();
            h.a("CrashlyticsCore", "Could not parse map entry: " + str);
            return null;
        }
    }
}
