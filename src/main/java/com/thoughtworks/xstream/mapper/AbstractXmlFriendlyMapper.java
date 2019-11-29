package com.thoughtworks.xstream.mapper;

public class AbstractXmlFriendlyMapper extends MapperWrapper {
    private char dollarReplacementInClass = '-';
    private String dollarReplacementInField = "_DOLLAR_";
    private String noPackagePrefix = "default";
    private String underscoreReplacementInField = "__";

    protected AbstractXmlFriendlyMapper(Mapper mapper) {
        super(mapper);
    }

    /* access modifiers changed from: protected */
    public String escapeClassName(String str) {
        String replace = str.replace('$', this.dollarReplacementInClass);
        if (replace.charAt(0) != this.dollarReplacementInClass) {
            return replace;
        }
        return this.noPackagePrefix + replace;
    }

    /* access modifiers changed from: protected */
    public String unescapeClassName(String str) {
        if (str.startsWith(this.noPackagePrefix + this.dollarReplacementInClass)) {
            str = str.substring(this.noPackagePrefix.length());
        }
        return str.replace(this.dollarReplacementInClass, '$');
    }

    /* access modifiers changed from: protected */
    public String escapeFieldName(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '$') {
                stringBuffer.append(this.dollarReplacementInField);
            } else if (charAt == '_') {
                stringBuffer.append(this.underscoreReplacementInField);
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public String unescapeFieldName(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (stringFoundAt(str, i, this.underscoreReplacementInField)) {
                i += this.underscoreReplacementInField.length() - 1;
                stringBuffer.append('_');
            } else if (stringFoundAt(str, i, this.dollarReplacementInField)) {
                i += this.dollarReplacementInField.length() - 1;
                stringBuffer.append('$');
            } else {
                stringBuffer.append(charAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private boolean stringFoundAt(String str, int i, String str2) {
        return str.length() >= str2.length() + i && str.substring(i, str2.length() + i).equals(str2);
    }
}
