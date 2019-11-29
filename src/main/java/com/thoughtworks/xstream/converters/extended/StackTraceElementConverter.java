package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackTraceElementConverter extends AbstractSingleValueConverter {
    private static final StackTraceElementFactory FACTORY;
    private static final Pattern PATTERN = Pattern.compile("^(.+)\\.([^\\(]+)\\(([^:]*)(:(\\d+))?\\)$");

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0020  */
    static {
        /*
            java.lang.String r0 = "^(.+)\\.([^\\(]+)\\(([^:]*)(:(\\d+))?\\)$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            PATTERN = r0
            boolean r0 = com.thoughtworks.xstream.core.JVM.is15()
            r1 = 0
            if (r0 == 0) goto L_0x001d
            r0 = 0
            java.lang.String r2 = "com.thoughtworks.xstream.converters.extended.StackTraceElementFactory15"
            java.lang.Class r0 = com.thoughtworks.xstream.core.JVM.loadClassForName(r2, r0)
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception | LinkageError -> 0x001d }
            com.thoughtworks.xstream.converters.extended.StackTraceElementFactory r0 = (com.thoughtworks.xstream.converters.extended.StackTraceElementFactory) r0     // Catch:{ Exception | LinkageError -> 0x001d }
            goto L_0x001e
        L_0x001d:
            r0 = r1
        L_0x001e:
            if (r0 != 0) goto L_0x0025
            com.thoughtworks.xstream.converters.extended.StackTraceElementFactory r0 = new com.thoughtworks.xstream.converters.extended.StackTraceElementFactory
            r0.<init>()
        L_0x0025:
            java.lang.String r2 = "a"
            java.lang.String r3 = "b"
            r0.unknownSourceElement(r2, r3)     // Catch:{ Exception | NoClassDefFoundError -> 0x002d }
            r1 = r0
        L_0x002d:
            FACTORY = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.extended.StackTraceElementConverter.<clinit>():void");
    }

    public boolean canConvert(Class cls) {
        return StackTraceElement.class.equals(cls) && FACTORY != null;
    }

    public String toString(Object obj) {
        return super.toString(obj).replaceFirst(":\\?\\?\\?", "");
    }

    public Object fromString(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            if (group3.equals("Unknown Source")) {
                return FACTORY.unknownSourceElement(group, group2);
            }
            if (group3.equals("Native Method")) {
                return FACTORY.nativeMethodElement(group, group2);
            }
            if (matcher.group(4) == null) {
                return FACTORY.element(group, group2, group3);
            }
            return FACTORY.element(group, group2, group3, Integer.parseInt(matcher.group(5)));
        }
        throw new ConversionException("Could not parse StackTraceElement : " + str);
    }
}
