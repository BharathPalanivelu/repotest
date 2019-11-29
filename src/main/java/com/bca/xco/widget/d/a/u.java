package com.bca.xco.widget.d.a;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f5156a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f5157b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    private final String f5158c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5159d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5160e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5161f;

    private u(String str, String str2, String str3, String str4) {
        this.f5158c = str;
        this.f5159d = str2;
        this.f5160e = str3;
        this.f5161f = str4;
    }

    public static u a(String str) {
        Matcher matcher = f5156a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f5157b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 == null) {
                    group2 = matcher2.group(3);
                } else if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                    group2 = group2.substring(1, group2.length() - 1);
                }
                if (str2 == null || group2.equalsIgnoreCase(str2)) {
                    str2 = group2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
            }
        }
        return new u(str, lowerCase, lowerCase2, str2);
    }

    public Charset a() {
        String str = this.f5161f;
        if (str != null) {
            return Charset.forName(str);
        }
        return null;
    }

    public Charset a(Charset charset) {
        String str = this.f5161f;
        return str != null ? Charset.forName(str) : charset;
    }

    public String toString() {
        return this.f5158c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && ((u) obj).f5158c.equals(this.f5158c);
    }

    public int hashCode() {
        return this.f5158c.hashCode();
    }
}
