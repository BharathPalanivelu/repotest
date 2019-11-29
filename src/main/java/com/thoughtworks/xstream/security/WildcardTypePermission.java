package com.thoughtworks.xstream.security;

import com.tencent.qcloud.core.util.IOUtils;

public class WildcardTypePermission extends RegExpTypePermission {
    public WildcardTypePermission(String[] strArr) {
        super(getRegExpPatterns(strArr));
    }

    private static String[] getRegExpPatterns(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            StringBuffer stringBuffer = new StringBuffer(str.length() * 2);
            stringBuffer.append("(?u)");
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (!(charAt == '$' || charAt == '.')) {
                    if (charAt != '?') {
                        if (charAt != '|') {
                            switch (charAt) {
                                case '(':
                                case ')':
                                case '+':
                                    break;
                                case '*':
                                    int i3 = i2 + 1;
                                    if (i3 < length && str.charAt(i3) == '*') {
                                        stringBuffer.append("[\\P{C}]*");
                                        i2 = i3;
                                        break;
                                    } else {
                                        stringBuffer.append("[\\P{C}&&[^");
                                        stringBuffer.append('.');
                                        stringBuffer.append("]]*");
                                        break;
                                    }
                                default:
                                    switch (charAt) {
                                        case '[':
                                        case '\\':
                                        case ']':
                                        case '^':
                                            break;
                                        default:
                                            stringBuffer.append(charAt);
                                            break;
                                    }
                            }
                        }
                    } else {
                        stringBuffer.append('.');
                    }
                    i2++;
                }
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                stringBuffer.append(charAt);
                i2++;
            }
            strArr2[i] = stringBuffer.toString();
        }
        return strArr2;
    }
}
