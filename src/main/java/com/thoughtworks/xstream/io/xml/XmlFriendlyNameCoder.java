package com.thoughtworks.xstream.io.xml;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.io.naming.NameCoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XmlFriendlyNameCoder implements NameCoder, Cloneable {
    private static final IntPair[] XML_NAME_CHAR_EXTRA_BOUNDS;
    private static final IntPair[] XML_NAME_START_CHAR_BOUNDS;
    private final String dollarReplacement;
    private transient Map escapeCache;
    private final String escapeCharReplacement;
    private final String hexPrefix;
    private transient Map unescapeCache;

    static {
        AnonymousClass1IntPairList r0 = new ArrayList() {
            /* access modifiers changed from: package-private */
            public void add(int i, int i2) {
                super.add(new IntPair(i, i2));
            }

            /* access modifiers changed from: package-private */
            public void add(char c2) {
                super.add(new IntPair(c2, c2));
            }
        };
        r0.add(':');
        r0.add(65, 90);
        r0.add(97, 122);
        r0.add('_');
        r0.add(JfifUtil.MARKER_SOFn, ModuleDescriptor.MODULE_VERSION);
        r0.add(216, 246);
        r0.add(248, 767);
        r0.add(880, 893);
        r0.add(895, 8191);
        r0.add(8204, 8205);
        r0.add(8304, 8591);
        r0.add(11264, 12271);
        r0.add(12289, 55295);
        r0.add(63744, 64975);
        r0.add(65008, 65533);
        r0.add(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 983039);
        XML_NAME_START_CHAR_BOUNDS = (IntPair[]) r0.toArray(new IntPair[r0.size()]);
        r0.clear();
        r0.add('-');
        r0.add('.');
        r0.add(48, 57);
        r0.add(183);
        r0.add(768, 879);
        r0.add(8255, 8256);
        XML_NAME_CHAR_EXTRA_BOUNDS = (IntPair[]) r0.toArray(new IntPair[r0.size()]);
    }

    public XmlFriendlyNameCoder() {
        this("_-", "__");
    }

    public XmlFriendlyNameCoder(String str, String str2) {
        this(str, str2, "_.");
    }

    public XmlFriendlyNameCoder(String str, String str2, String str3) {
        this.dollarReplacement = str;
        this.escapeCharReplacement = str2;
        this.hexPrefix = str3;
        readResolve();
    }

    public String decodeAttribute(String str) {
        return decodeName(str);
    }

    public String decodeNode(String str) {
        return decodeName(str);
    }

    public String encodeAttribute(String str) {
        return encodeName(str);
    }

    public String encodeNode(String str) {
        return encodeName(str);
    }

    private String encodeName(String str) {
        String str2 = (String) this.escapeCache.get(str);
        if (str2 != null) {
            return str2;
        }
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '$' || charAt == '_' || charAt <= 27 || charAt >= 127) {
                break;
            }
            i++;
        }
        if (i == length) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length + 8);
        if (i > 0) {
            stringBuffer.append(str.substring(0, i));
        }
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 == '$') {
                stringBuffer.append(this.dollarReplacement);
            } else if (charAt2 == '_') {
                stringBuffer.append(this.escapeCharReplacement);
            } else if ((i != 0 || isXmlNameStartChar(charAt2)) && (i <= 0 || isXmlNameChar(charAt2))) {
                stringBuffer.append(charAt2);
            } else {
                stringBuffer.append(this.hexPrefix);
                if (charAt2 < 16) {
                    stringBuffer.append("000");
                } else if (charAt2 < 256) {
                    stringBuffer.append("00");
                } else if (charAt2 < 4096) {
                    stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                stringBuffer.append(Integer.toHexString(charAt2));
            }
            i++;
        }
        String stringBuffer2 = stringBuffer.toString();
        this.escapeCache.put(str, stringBuffer2);
        return stringBuffer2;
    }

    private String decodeName(String str) {
        String str2 = (String) this.unescapeCache.get(str);
        if (str2 != null) {
            return str2;
        }
        char charAt = this.dollarReplacement.charAt(0);
        char charAt2 = this.escapeCharReplacement.charAt(0);
        char charAt3 = this.hexPrefix.charAt(0);
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt4 = str.charAt(i);
            if (charAt4 == charAt || charAt4 == charAt2 || charAt4 == charAt3) {
                break;
            }
            i++;
        }
        if (i == length) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(length + 8);
        if (i > 0) {
            stringBuffer.append(str.substring(0, i));
        }
        while (i < length) {
            char charAt5 = str.charAt(i);
            if (charAt5 == charAt && str.startsWith(this.dollarReplacement, i)) {
                i += this.dollarReplacement.length() - 1;
                stringBuffer.append('$');
            } else if (charAt5 == charAt3 && str.startsWith(this.hexPrefix, i)) {
                int length2 = i + this.hexPrefix.length();
                i = length2 + 3;
                stringBuffer.append((char) Integer.parseInt(str.substring(length2, length2 + 4), 16));
            } else if (charAt5 != charAt2 || !str.startsWith(this.escapeCharReplacement, i)) {
                stringBuffer.append(charAt5);
            } else {
                i += this.escapeCharReplacement.length() - 1;
                stringBuffer.append('_');
            }
            i++;
        }
        String stringBuffer2 = stringBuffer.toString();
        this.unescapeCache.put(str, stringBuffer2);
        return stringBuffer2;
    }

    public Object clone() {
        try {
            XmlFriendlyNameCoder xmlFriendlyNameCoder = (XmlFriendlyNameCoder) super.clone();
            xmlFriendlyNameCoder.readResolve();
            return xmlFriendlyNameCoder;
        } catch (CloneNotSupportedException e2) {
            throw new ObjectAccessException("Cannot clone XmlFriendlyNameCoder", e2);
        }
    }

    private Object readResolve() {
        this.escapeCache = createCacheMap();
        this.unescapeCache = createCacheMap();
        return this;
    }

    /* access modifiers changed from: protected */
    public Map createCacheMap() {
        return new HashMap();
    }

    private static class IntPair {
        int max;
        int min;

        public IntPair(int i, int i2) {
            this.min = i;
            this.max = i2;
        }
    }

    private static boolean isXmlNameStartChar(int i) {
        return isInNameCharBounds(i, XML_NAME_START_CHAR_BOUNDS);
    }

    private static boolean isXmlNameChar(int i) {
        if (isXmlNameStartChar(i)) {
            return true;
        }
        return isInNameCharBounds(i, XML_NAME_CHAR_EXTRA_BOUNDS);
    }

    private static boolean isInNameCharBounds(int i, IntPair[] intPairArr) {
        for (IntPair intPair : intPairArr) {
            if (i >= intPair.min && i <= intPair.max) {
                return true;
            }
        }
        return false;
    }
}
