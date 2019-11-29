package com.thoughtworks.xstream.persistence;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;

public class FilePersistenceStrategy extends AbstractFilePersistenceStrategy {
    private final String illegalChars;

    public FilePersistenceStrategy(File file) {
        this(file, new XStream((HierarchicalStreamDriver) new DomDriver()));
    }

    public FilePersistenceStrategy(File file, XStream xStream) {
        this(file, xStream, "utf-8", "<>?:/\\\"|*%");
    }

    public FilePersistenceStrategy(File file, XStream xStream, String str, String str2) {
        super(file, xStream, str);
        this.illegalChars = str2;
    }

    /* access modifiers changed from: protected */
    public boolean isValid(File file, String str) {
        return super.isValid(file, str) && str.indexOf(64) > 0;
    }

    /* access modifiers changed from: protected */
    public Object extractKey(String str) {
        String unescape = unescape(str.substring(0, str.length() - 4));
        if ("null@null".equals(unescape)) {
            return null;
        }
        int indexOf = unescape.indexOf(64);
        if (indexOf >= 0) {
            Class realClass = getMapper().realClass(unescape.substring(0, indexOf));
            Converter lookupConverterForType = getConverterLookup().lookupConverterForType(realClass);
            if (lookupConverterForType instanceof SingleValueConverter) {
                return ((SingleValueConverter) lookupConverterForType).fromString(unescape.substring(indexOf + 1));
            }
            throw new StreamException("No SingleValueConverter for type " + realClass.getName() + " available");
        }
        throw new StreamException("Not a valid key: " + unescape);
    }

    /* access modifiers changed from: protected */
    public String unescape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int indexOf = str.indexOf(37);
            if (indexOf >= 0) {
                stringBuffer.append(str.substring(0, indexOf));
                int i = indexOf + 1;
                int i2 = indexOf + 3;
                stringBuffer.append((char) Integer.parseInt(str.substring(i, i2), 16));
                str = str.substring(i2);
            } else {
                stringBuffer.append(str);
                return stringBuffer.toString();
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getName(Object obj) {
        if (obj == null) {
            return "null@null.xml";
        }
        Class<?> cls = obj.getClass();
        Converter lookupConverterForType = getConverterLookup().lookupConverterForType(cls);
        if (lookupConverterForType instanceof SingleValueConverter) {
            return getMapper().serializedClass(cls) + '@' + escape(((SingleValueConverter) lookupConverterForType).toString(obj)) + ".xml";
        }
        throw new StreamException("No SingleValueConverter for type " + cls.getName() + " available");
    }

    /* access modifiers changed from: protected */
    public String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (c2 < ' ' || this.illegalChars.indexOf(c2) >= 0) {
                stringBuffer.append("%" + Integer.toHexString(c2).toUpperCase());
            } else {
                stringBuffer.append(c2);
            }
        }
        return stringBuffer.toString();
    }
}
