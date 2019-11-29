package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {

    public interface a {
    }

    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.core.e.a f1642a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1643b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1644c;

        public d(androidx.core.e.a aVar, int i, int i2) {
            this.f1642a = aVar;
            this.f1644c = i;
            this.f1643b = i2;
        }

        public androidx.core.e.a a() {
            return this.f1642a;
        }

        public int b() {
            return this.f1644c;
        }

        public int c() {
            return this.f1643b;
        }
    }

    /* renamed from: androidx.core.content.a.c$c  reason: collision with other inner class name */
    public static final class C0030c {

        /* renamed from: a  reason: collision with root package name */
        private final String f1636a;

        /* renamed from: b  reason: collision with root package name */
        private int f1637b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1638c;

        /* renamed from: d  reason: collision with root package name */
        private String f1639d;

        /* renamed from: e  reason: collision with root package name */
        private int f1640e;

        /* renamed from: f  reason: collision with root package name */
        private int f1641f;

        public C0030c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1636a = str;
            this.f1637b = i;
            this.f1638c = z;
            this.f1639d = str2;
            this.f1640e = i2;
            this.f1641f = i3;
        }

        public String a() {
            return this.f1636a;
        }

        public int b() {
            return this.f1637b;
        }

        public boolean c() {
            return this.f1638c;
        }

        public String d() {
            return this.f1639d;
        }

        public int e() {
            return this.f1640e;
        }

        public int f() {
            return this.f1641f;
        }
    }

    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0030c[] f1635a;

        public b(C0030c[] cVarArr) {
            this.f1635a = cVarArr;
        }

        public C0030c[] a() {
            return this.f1635a;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.d.FontFamily);
        String string = obtainAttributes.getString(a.d.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(a.d.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(a.d.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(a.d.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(a.d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(a.d.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(d(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0030c[]) arrayList.toArray(new C0030c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new d(new androidx.core.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static C0030c d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.d.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(a.d.FontFamilyFont_fontWeight) ? a.d.FontFamilyFont_fontWeight : a.d.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(a.d.FontFamilyFont_fontStyle) ? a.d.FontFamilyFont_fontStyle : a.d.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(a.d.FontFamilyFont_ttcIndex) ? a.d.FontFamilyFont_ttcIndex : a.d.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(a.d.FontFamilyFont_fontVariationSettings) ? a.d.FontFamilyFont_fontVariationSettings : a.d.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(a.d.FontFamilyFont_font) ? a.d.FontFamilyFont_font : a.d.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0030c(string2, i, z, string, i3, resourceId);
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
