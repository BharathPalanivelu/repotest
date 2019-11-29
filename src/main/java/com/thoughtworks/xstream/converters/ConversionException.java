package com.thoughtworks.xstream.converters;

import com.facebook.share.internal.ShareConstants;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.core.util.OrderRetainingMap;
import java.util.Iterator;
import java.util.Map;

public class ConversionException extends XStreamException implements ErrorWriter {
    private static final String SEPARATOR = "\n-------------------------------";
    private Map stuff;

    public ConversionException(String str, Throwable th) {
        super(str, th);
        this.stuff = new OrderRetainingMap();
        if (str != null) {
            add(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
        }
        if (th != null) {
            add("cause-exception", th.getClass().getName());
            add("cause-message", th instanceof ConversionException ? ((ConversionException) th).getShortMessage() : th.getMessage());
        }
    }

    public ConversionException(String str) {
        super(str);
        this.stuff = new OrderRetainingMap();
    }

    public ConversionException(Throwable th) {
        this(th.getMessage(), th);
    }

    public String get(String str) {
        return (String) this.stuff.get(str);
    }

    public void add(String str, String str2) {
        String str3 = str;
        int i = 0;
        while (this.stuff.containsKey(str3)) {
            if (!str2.equals((String) this.stuff.get(str3))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("[");
                i++;
                sb.append(i);
                sb.append("]");
                str3 = sb.toString();
            } else {
                return;
            }
        }
        this.stuff.put(str3, str2);
    }

    public void set(String str, String str2) {
        this.stuff.put(str, str2);
        String str3 = str;
        int i = 0;
        while (this.stuff.containsKey(str3)) {
            if (i != 0) {
                this.stuff.remove(str3);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("[");
            i++;
            sb.append(i);
            sb.append("]");
            str3 = sb.toString();
        }
    }

    public Iterator keys() {
        return this.stuff.keySet().iterator();
    }

    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        if (super.getMessage() != null) {
            stringBuffer.append(super.getMessage());
        }
        if (!stringBuffer.toString().endsWith(SEPARATOR)) {
            stringBuffer.append("\n---- Debugging information ----");
        }
        Iterator keys = keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            String str2 = get(str);
            stringBuffer.append(10);
            stringBuffer.append(str);
            stringBuffer.append("                    ".substring(Math.min(20, str.length())));
            stringBuffer.append(": ");
            stringBuffer.append(str2);
        }
        stringBuffer.append(SEPARATOR);
        return stringBuffer.toString();
    }

    public String getShortMessage() {
        return super.getMessage();
    }
}
