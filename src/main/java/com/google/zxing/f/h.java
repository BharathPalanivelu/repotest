package com.google.zxing.f;

import com.google.zxing.w;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h extends q {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f14730a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    /* renamed from: a */
    public g b(w wVar) {
        Matcher matcher = f14730a.matcher(c(wVar));
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(4);
        try {
            double parseDouble = Double.parseDouble(matcher.group(1));
            if (parseDouble <= 90.0d) {
                if (parseDouble >= -90.0d) {
                    double parseDouble2 = Double.parseDouble(matcher.group(2));
                    if (parseDouble2 <= 180.0d) {
                        if (parseDouble2 >= -180.0d) {
                            double d2 = 0.0d;
                            if (matcher.group(3) != null) {
                                double parseDouble3 = Double.parseDouble(matcher.group(3));
                                if (parseDouble3 < 0.0d) {
                                    return null;
                                }
                                d2 = parseDouble3;
                            }
                            return new g(parseDouble, parseDouble2, d2, group);
                        }
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }
}
