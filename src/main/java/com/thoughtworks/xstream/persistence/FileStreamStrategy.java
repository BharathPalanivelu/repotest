package com.thoughtworks.xstream.persistence;

import com.thoughtworks.xstream.XStream;
import java.io.File;

public class FileStreamStrategy extends AbstractFilePersistenceStrategy implements StreamStrategy {
    public FileStreamStrategy(File file) {
        this(file, new XStream());
    }

    public FileStreamStrategy(File file, XStream xStream) {
        super(file, xStream, (String) null);
    }

    /* access modifiers changed from: protected */
    public Object extractKey(String str) {
        String unescape = unescape(str.substring(0, str.length() - 4));
        if (unescape.equals("\u0000")) {
            return null;
        }
        return unescape;
    }

    /* access modifiers changed from: protected */
    public String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = -1;
        char c2 = 65535;
        while (i < charArray.length) {
            char c3 = charArray[i];
            if (c3 == '_' && i2 != -1) {
                if (c2 == '_') {
                    stringBuffer.append('_');
                } else {
                    stringBuffer.append((char) i2);
                }
                i2 = -1;
            } else if (c3 == '_') {
                i2 = 0;
            } else if (i2 != -1) {
                i2 = (i2 * 16) + Integer.parseInt(String.valueOf(c3), 16);
            } else {
                stringBuffer.append(c3);
            }
            i++;
            c2 = c3;
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public String getName(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(escape(obj == null ? "\u0000" : obj.toString()));
        sb.append(".xml");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (Character.isDigit(c2) || ((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z'))) {
                stringBuffer.append(c2);
            } else if (c2 == '_') {
                stringBuffer.append("__");
            } else {
                stringBuffer.append("_" + Integer.toHexString(c2) + "_");
            }
        }
        return stringBuffer.toString();
    }
}
