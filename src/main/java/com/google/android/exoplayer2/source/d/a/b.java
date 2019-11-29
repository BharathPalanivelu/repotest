package com.google.android.exoplayer2.source.d.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.appsflyer.share.Constants;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.e.d.h;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.t;
import com.google.android.exoplayer2.source.d.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class b implements t.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f11800a;

    public b() {
        try {
            this.f11800a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* renamed from: b */
    public a a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f11800a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            return (a) new e((a) null, uri.toString()).a(newPullParser);
        } catch (XmlPullParserException e2) {
            throw new ak((Throwable) e2);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.d.a.b$b  reason: collision with other inner class name */
    public static class C0192b extends ak {
        public C0192b(String str) {
            super("Missing required field: " + str);
        }
    }

    private static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f11801a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11802b;

        /* renamed from: c  reason: collision with root package name */
        private final a f11803c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Pair<String, Object>> f11804d = new LinkedList();

        /* access modifiers changed from: protected */
        public abstract Object a();

        /* access modifiers changed from: protected */
        public void a(Object obj) {
        }

        /* access modifiers changed from: protected */
        public void b(XmlPullParser xmlPullParser) throws ak {
        }

        /* access modifiers changed from: protected */
        public boolean b(String str) {
            return false;
        }

        /* access modifiers changed from: protected */
        public void c(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public void d(XmlPullParser xmlPullParser) {
        }

        public a(a aVar, String str, String str2) {
            this.f11803c = aVar;
            this.f11801a = str;
            this.f11802b = str2;
        }

        public final Object a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f11802b.equals(name)) {
                        b(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (b(name)) {
                            b(xmlPullParser);
                        } else {
                            a a2 = a(this, name, this.f11801a);
                            if (a2 == null) {
                                i = 1;
                            } else {
                                a(a2.a(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        c(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name2 = xmlPullParser.getName();
                    d(xmlPullParser);
                    if (!b(name2)) {
                        return a();
                    }
                }
                xmlPullParser.next();
            }
        }

        private a a(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new d(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new c(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new f(aVar, str2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final void a(String str, Object obj) {
            this.f11804d.add(Pair.create(str, obj));
        }

        /* access modifiers changed from: protected */
        public final Object a(String str) {
            for (int i = 0; i < this.f11804d.size(); i++) {
                Pair pair = this.f11804d.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f11803c;
            if (aVar == null) {
                return null;
            }
            return aVar.a(str);
        }

        /* access modifiers changed from: protected */
        public final String a(XmlPullParser xmlPullParser, String str) throws C0192b {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new C0192b(str);
        }

        /* access modifiers changed from: protected */
        public final int a(XmlPullParser xmlPullParser, String str, int i) throws ak {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return i;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw new ak((Throwable) e2);
            }
        }

        /* access modifiers changed from: protected */
        public final int b(XmlPullParser xmlPullParser, String str) throws ak {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw new ak((Throwable) e2);
                }
            } else {
                throw new C0192b(str);
            }
        }

        /* access modifiers changed from: protected */
        public final long a(XmlPullParser xmlPullParser, String str, long j) throws ak {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return j;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw new ak((Throwable) e2);
            }
        }

        /* access modifiers changed from: protected */
        public final long c(XmlPullParser xmlPullParser, String str) throws ak {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw new ak((Throwable) e2);
                }
            } else {
                throw new C0192b(str);
            }
        }

        /* access modifiers changed from: protected */
        public final boolean a(XmlPullParser xmlPullParser, String str, boolean z) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
        }
    }

    private static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private final List<a.b> f11809a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        private int f11810b;

        /* renamed from: c  reason: collision with root package name */
        private int f11811c;

        /* renamed from: d  reason: collision with root package name */
        private long f11812d;

        /* renamed from: e  reason: collision with root package name */
        private long f11813e;

        /* renamed from: f  reason: collision with root package name */
        private long f11814f;

        /* renamed from: g  reason: collision with root package name */
        private int f11815g = -1;
        private boolean h;
        private a.C0191a i = null;

        public e(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
        }

        public void b(XmlPullParser xmlPullParser) throws ak {
            this.f11810b = b(xmlPullParser, "MajorVersion");
            this.f11811c = b(xmlPullParser, "MinorVersion");
            this.f11812d = a(xmlPullParser, "TimeScale", 10000000);
            this.f11813e = c(xmlPullParser, "Duration");
            this.f11814f = a(xmlPullParser, "DVRWindowLength", 0);
            this.f11815g = a(xmlPullParser, "LookaheadCount", -1);
            this.h = a(xmlPullParser, "IsLive", false);
            a("TimeScale", (Object) Long.valueOf(this.f11812d));
        }

        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f11809a.add((a.b) obj);
            } else if (obj instanceof a.C0191a) {
                com.google.android.exoplayer2.n.a.b(this.i == null);
                this.i = (a.C0191a) obj;
            }
        }

        public Object a() {
            a.b[] bVarArr = new a.b[this.f11809a.size()];
            this.f11809a.toArray(bVarArr);
            a.C0191a aVar = this.i;
            if (aVar != null) {
                com.google.android.exoplayer2.c.a aVar2 = new com.google.android.exoplayer2.c.a(new a.C0159a(aVar.f11791a, "video/mp4", this.i.f11792b));
                for (a.b bVar : bVarArr) {
                    for (int i2 = 0; i2 < bVar.j.length; i2++) {
                        bVar.j[i2] = bVar.j[i2].a(aVar2);
                    }
                }
            }
            return new a(this.f11810b, this.f11811c, this.f11812d, this.f11813e, this.f11814f, this.f11815g, this.h, this.i, bVarArr);
        }
    }

    private static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11805a;

        /* renamed from: b  reason: collision with root package name */
        private UUID f11806b;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f11807c;

        public c(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        public boolean b(String str) {
            return "ProtectionHeader".equals(str);
        }

        public void b(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f11805a = true;
                this.f11806b = UUID.fromString(c(xmlPullParser.getAttributeValue((String) null, "SystemID")));
            }
        }

        public void c(XmlPullParser xmlPullParser) {
            if (this.f11805a) {
                this.f11807c = Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        public void d(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f11805a = false;
            }
        }

        public Object a() {
            UUID uuid = this.f11806b;
            return new a.C0191a(uuid, h.a(uuid, this.f11807c));
        }

        private static String c(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }
    }

    private static class f extends a {

        /* renamed from: a  reason: collision with root package name */
        private final String f11816a;

        /* renamed from: b  reason: collision with root package name */
        private final List<j> f11817b = new LinkedList();

        /* renamed from: c  reason: collision with root package name */
        private int f11818c;

        /* renamed from: d  reason: collision with root package name */
        private String f11819d;

        /* renamed from: e  reason: collision with root package name */
        private long f11820e;

        /* renamed from: f  reason: collision with root package name */
        private String f11821f;

        /* renamed from: g  reason: collision with root package name */
        private String f11822g;
        private int h;
        private int i;
        private int j;
        private int k;
        private String l;
        private ArrayList<Long> m;
        private long n;

        public f(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f11816a = str;
        }

        public boolean b(String str) {
            return Constants.URL_CAMPAIGN.equals(str);
        }

        public void b(XmlPullParser xmlPullParser) throws ak {
            if (Constants.URL_CAMPAIGN.equals(xmlPullParser.getName())) {
                e(xmlPullParser);
            } else {
                f(xmlPullParser);
            }
        }

        private void e(XmlPullParser xmlPullParser) throws ak {
            int size = this.m.size();
            long a2 = a(xmlPullParser, "t", -9223372036854775807L);
            int i2 = 1;
            if (a2 == -9223372036854775807L) {
                if (size == 0) {
                    a2 = 0;
                } else if (this.n != -1) {
                    a2 = this.m.get(size - 1).longValue() + this.n;
                } else {
                    throw new ak("Unable to infer start time");
                }
            }
            this.m.add(Long.valueOf(a2));
            this.n = a(xmlPullParser, "d", -9223372036854775807L);
            long a3 = a(xmlPullParser, "r", 1);
            if (a3 <= 1 || this.n != -9223372036854775807L) {
                while (true) {
                    long j2 = (long) i2;
                    if (j2 < a3) {
                        this.m.add(Long.valueOf((this.n * j2) + a2));
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                throw new ak("Repeated chunk with unspecified duration");
            }
        }

        private void f(XmlPullParser xmlPullParser) throws ak {
            this.f11818c = g(xmlPullParser);
            a("Type", (Object) Integer.valueOf(this.f11818c));
            if (this.f11818c == 3) {
                this.f11819d = a(xmlPullParser, "Subtype");
            } else {
                this.f11819d = xmlPullParser.getAttributeValue((String) null, "Subtype");
            }
            this.f11821f = xmlPullParser.getAttributeValue((String) null, "Name");
            this.f11822g = a(xmlPullParser, "Url");
            this.h = a(xmlPullParser, "MaxWidth", -1);
            this.i = a(xmlPullParser, "MaxHeight", -1);
            this.j = a(xmlPullParser, "DisplayWidth", -1);
            this.k = a(xmlPullParser, "DisplayHeight", -1);
            this.l = xmlPullParser.getAttributeValue((String) null, "Language");
            a("Language", (Object) this.l);
            this.f11820e = (long) a(xmlPullParser, "TimeScale", -1);
            if (this.f11820e == -1) {
                this.f11820e = ((Long) a("TimeScale")).longValue();
            }
            this.m = new ArrayList<>();
        }

        private int g(XmlPullParser xmlPullParser) throws ak {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "Type");
            if (attributeValue == null) {
                throw new C0192b("Type");
            } else if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            } else {
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw new ak("Invalid key value[" + attributeValue + "]");
            }
        }

        public void a(Object obj) {
            if (obj instanceof j) {
                this.f11817b.add((j) obj);
            }
        }

        public Object a() {
            j[] jVarArr = new j[this.f11817b.size()];
            this.f11817b.toArray(jVarArr);
            a.b bVar = r2;
            a.b bVar2 = new a.b(this.f11816a, this.f11822g, this.f11818c, this.f11819d, this.f11820e, this.f11821f, this.h, this.i, this.j, this.k, this.l, jVarArr, this.m, this.n);
            return bVar;
        }
    }

    private static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private j f11808a;

        public d(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        public void b(XmlPullParser xmlPullParser) throws ak {
            int intValue = ((Integer) a("Type")).intValue();
            String attributeValue = xmlPullParser.getAttributeValue((String) null, "Index");
            int b2 = b(xmlPullParser, "Bitrate");
            String d2 = d(a(xmlPullParser, "FourCC"));
            if (intValue == 2) {
                this.f11808a = j.a(attributeValue, "video/mp4", d2, (String) null, b2, b(xmlPullParser, "MaxWidth"), b(xmlPullParser, "MaxHeight"), -1.0f, c(xmlPullParser.getAttributeValue((String) null, "CodecPrivateData")), 0);
            } else if (intValue == 1) {
                if (d2 == null) {
                    d2 = "audio/mp4a-latm";
                }
                int b3 = b(xmlPullParser, "Channels");
                int b4 = b(xmlPullParser, "SamplingRate");
                List<byte[]> c2 = c(xmlPullParser.getAttributeValue((String) null, "CodecPrivateData"));
                if (c2.isEmpty() && "audio/mp4a-latm".equals(d2)) {
                    c2 = Collections.singletonList(com.google.android.exoplayer2.n.b.a(b4, b3));
                }
                this.f11808a = j.a(attributeValue, "audio/mp4", d2, (String) null, b2, b3, b4, c2, 0, (String) a("Language"));
            } else if (intValue == 3) {
                this.f11808a = j.a(attributeValue, "application/mp4", d2, (String) null, b2, 0, (String) a("Language"));
            } else {
                this.f11808a = j.b(attributeValue, "application/mp4", d2, (String) null, b2, 0, (String) null);
            }
        }

        public Object a() {
            return this.f11808a;
        }

        private static List<byte[]> c(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] h = com.google.android.exoplayer2.n.t.h(str);
                byte[][] b2 = com.google.android.exoplayer2.n.b.b(h);
                if (b2 == null) {
                    arrayList.add(h);
                } else {
                    Collections.addAll(arrayList, b2);
                }
            }
            return arrayList;
        }

        private static String d(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }
    }
}
