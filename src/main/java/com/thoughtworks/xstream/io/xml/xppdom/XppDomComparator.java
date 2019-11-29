package com.thoughtworks.xstream.io.xml.xppdom;

import com.appsflyer.share.Constants;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class XppDomComparator implements Comparator {
    private final ThreadLocal xpath;

    public XppDomComparator() {
        this((ThreadLocal) null);
    }

    public XppDomComparator(ThreadLocal threadLocal) {
        this.xpath = threadLocal;
    }

    public int compare(Object obj, Object obj2) {
        StringBuffer stringBuffer = new StringBuffer(Constants.URL_PATH_DELIMITER);
        int compareInternal = compareInternal((XppDom) obj, (XppDom) obj2, stringBuffer, -1);
        ThreadLocal threadLocal = this.xpath;
        if (threadLocal != null) {
            if (compareInternal != 0) {
                threadLocal.set(stringBuffer.toString());
            } else {
                threadLocal.set((Object) null);
            }
        }
        return compareInternal;
    }

    private int compareInternal(XppDom xppDom, XppDom xppDom2, StringBuffer stringBuffer, int i) {
        int i2;
        int i3;
        XppDom xppDom3 = xppDom;
        XppDom xppDom4 = xppDom2;
        StringBuffer stringBuffer2 = stringBuffer;
        int length = stringBuffer.length();
        String name = xppDom.getName();
        int compareTo = name.compareTo(xppDom2.getName());
        stringBuffer2.append(name);
        if (i >= 0) {
            stringBuffer2.append('[');
            stringBuffer.append(i);
            stringBuffer2.append(']');
        }
        if (compareTo != 0) {
            stringBuffer2.append('?');
            return compareTo;
        }
        String[] attributeNames = xppDom.getAttributeNames();
        String[] attributeNames2 = xppDom2.getAttributeNames();
        int length2 = attributeNames.length;
        int length3 = attributeNames2.length - length2;
        int i4 = 1;
        if (length3 != 0) {
            stringBuffer2.append("::count(@*)");
            if (length3 < 0) {
                return 1;
            }
            return -1;
        }
        Arrays.sort(attributeNames);
        Arrays.sort(attributeNames2);
        int i5 = 0;
        for (int i6 = 0; i6 < length2; i6++) {
            String str = attributeNames[i6];
            int compareTo2 = str.compareTo(attributeNames2[i6]);
            if (compareTo2 != 0) {
                stringBuffer2.append("[@");
                stringBuffer2.append(str);
                stringBuffer2.append("?]");
                return compareTo2;
            }
            int compareTo3 = xppDom3.getAttribute(str).compareTo(xppDom4.getAttribute(str));
            if (compareTo3 != 0) {
                stringBuffer2.append("[@");
                stringBuffer2.append(str);
                stringBuffer2.append(']');
                return compareTo3;
            }
        }
        int childCount = xppDom.getChildCount();
        int childCount2 = xppDom2.getChildCount() - childCount;
        if (childCount2 != 0) {
            stringBuffer2.append("::count(*)");
            if (childCount2 < 0) {
                return 1;
            }
            return -1;
        }
        if (childCount <= 0) {
            String value = xppDom2.getValue();
            String value2 = xppDom.getValue();
            if (value2 == null) {
                if (value != null) {
                    i5 = -1;
                }
                i3 = i5;
            } else {
                if (value != null) {
                    i4 = value2.compareTo(value);
                }
                i3 = i4;
            }
            if (i2 != 0) {
                stringBuffer2.append("::text()");
                return i2;
            }
        } else if (xppDom.getValue() == null && xppDom2.getValue() == null) {
            stringBuffer2.append(IOUtils.DIR_SEPARATOR_UNIX);
            HashMap hashMap = new HashMap();
            i2 = childCount2;
            for (int i7 = 0; i7 < childCount; i7++) {
                XppDom child = xppDom3.getChild(i7);
                XppDom child2 = xppDom4.getChild(i7);
                String name2 = child.getName();
                if (!hashMap.containsKey(name2)) {
                    hashMap.put(name2, new int[1]);
                }
                int[] iArr = (int[]) hashMap.get(name2);
                int i8 = iArr[0];
                iArr[0] = i8 + 1;
                i2 = compareInternal(child, child2, stringBuffer2, i8);
                if (i2 != 0) {
                    return i2;
                }
            }
        } else {
            throw new IllegalArgumentException("XppDom cannot handle mixed mode at " + stringBuffer2 + "::text()");
        }
        stringBuffer2.setLength(length);
        return i2;
    }
}
