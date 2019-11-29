package com.thoughtworks.xstream.security;

import java.util.regex.Pattern;

public class RegExpTypePermission implements TypePermission {
    private final Pattern[] patterns;

    public RegExpTypePermission(String[] strArr) {
        this(getPatterns(strArr));
    }

    public RegExpTypePermission(Pattern[] patternArr) {
        this.patterns = patternArr == null ? new Pattern[0] : patternArr;
    }

    public boolean allows(Class cls) {
        if (cls != null) {
            String name = cls.getName();
            int i = 0;
            while (true) {
                Pattern[] patternArr = this.patterns;
                if (i >= patternArr.length) {
                    break;
                } else if (patternArr[i].matcher(name).matches()) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private static Pattern[] getPatterns(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        Pattern[] patternArr = new Pattern[strArr.length];
        for (int i = 0; i < patternArr.length; i++) {
            patternArr[i] = Pattern.compile(strArr[i]);
        }
        return patternArr;
    }
}
