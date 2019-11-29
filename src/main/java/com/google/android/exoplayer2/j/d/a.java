package com.google.android.exoplayer2.j.d;

import android.util.Log;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.j.b;
import com.google.android.exoplayer2.j.f;
import com.google.android.exoplayer2.n.u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10533a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f10534b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f10535c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f10536d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: e  reason: collision with root package name */
    private static final C0176a f10537e = new C0176a(30.0f, 1, 1);

    /* renamed from: f  reason: collision with root package name */
    private final XmlPullParserFactory f10538f;

    public a() {
        super("TtmlDecoder");
        try {
            this.f10538f = XmlPullParserFactory.newInstance();
            this.f10538f.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public f a(byte[] bArr, int i, boolean z) throws f {
        try {
            XmlPullParser newPullParser = this.f10538f.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            f fVar = null;
            hashMap2.put("", new c((String) null));
            int i2 = 0;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), (String) null);
            LinkedList linkedList = new LinkedList();
            C0176a aVar = f10537e;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                b bVar = (b) linkedList.peekLast();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            aVar = a(newPullParser);
                        }
                        if (!b(name)) {
                            Log.i("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                        } else if ("head".equals(name)) {
                            a(newPullParser, (Map<String, e>) hashMap, (Map<String, c>) hashMap2);
                        } else {
                            try {
                                b a2 = a(newPullParser, bVar, hashMap2, aVar);
                                linkedList.addLast(a2);
                                if (bVar != null) {
                                    bVar.a(a2);
                                }
                            } catch (f e2) {
                                Log.w("TtmlDecoder", "Suppressing parser error", e2);
                            }
                        }
                    } else if (eventType == 4) {
                        bVar.a(b.a(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            fVar = new f((b) linkedList.getLast(), hashMap, hashMap2);
                        }
                        linkedList.removeLast();
                    }
                    newPullParser.next();
                } else if (eventType != 2) {
                    if (eventType == 3) {
                        i2--;
                    }
                    newPullParser.next();
                }
                i2++;
                newPullParser.next();
            }
            return fVar;
        } catch (XmlPullParserException e3) {
            throw new f("Unable to decode source", e3);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        }
    }

    private C0176a a(XmlPullParser xmlPullParser) throws f {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f2 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split(SQLBuilder.BLANK);
            if (split.length == 2) {
                f2 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new f("frameRateMultiplier doesn't have 2 parts");
            }
        }
        int i = f10537e.f10540b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = f10537e.f10541c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new C0176a(((float) parseInt) * f2, i, i2);
    }

    private Map<String, e> a(XmlPullParser xmlPullParser, Map<String, e> map, Map<String, c> map2) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                String c2 = u.c(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                e a2 = a(xmlPullParser, new e());
                if (c2 != null) {
                    for (String str : a(c2)) {
                        a2.a(map.get(str));
                    }
                }
                if (a2.i() != null) {
                    map.put(a2.i(), a2);
                }
            } else if (u.b(xmlPullParser, "region")) {
                c b2 = b(xmlPullParser);
                if (b2 != null) {
                    map2.put(b2.f10549a, b2);
                }
            }
        } while (!u.a(xmlPullParser, "head"));
        return map;
    }

    private c b(XmlPullParser xmlPullParser) {
        float f2;
        float f3;
        int i;
        float f4;
        String c2 = u.c(xmlPullParser, "id");
        if (c2 == null) {
            return null;
        }
        String c3 = u.c(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.ORIGIN);
        float f5 = BitmapDescriptorFactory.HUE_RED;
        if (c3 != null) {
            Matcher matcher = f10536d.matcher(c3);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    f2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    f5 = parseFloat;
                } catch (NumberFormatException unused) {
                    Log.w("TtmlDecoder", "Ignoring region with malformed origin: " + c3);
                    return null;
                }
            } else {
                Log.w("TtmlDecoder", "Ignoring region with unsupported origin: " + c3);
                return null;
            }
        } else {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        String c4 = u.c(xmlPullParser, "extent");
        float f6 = 1.0f;
        if (c4 != null) {
            Matcher matcher2 = f10536d.matcher(c4);
            if (matcher2.matches()) {
                try {
                    f6 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                    f3 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                } catch (NumberFormatException unused2) {
                    Log.w("TtmlDecoder", "Ignoring region with malformed extent: " + c3);
                    return null;
                }
            } else {
                Log.w("TtmlDecoder", "Ignoring region with unsupported extent: " + c3);
                return null;
            }
        } else {
            f3 = 1.0f;
        }
        String c5 = u.c(xmlPullParser, "displayAlign");
        if (c5 != null) {
            String lowerCase = c5.toLowerCase();
            char c6 = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode == 92734940 && lowerCase.equals("after")) {
                    c6 = 1;
                }
            } else if (lowerCase.equals("center")) {
                c6 = 0;
            }
            if (c6 == 0) {
                f4 = f2 + (f3 / 2.0f);
                i = 1;
            } else if (c6 == 1) {
                f4 = f2 + f3;
                i = 2;
            }
            return new c(c2, f5, f4, 0, i, f6);
        }
        f4 = f2;
        i = 0;
        return new c(c2, f5, f4, 0, i, f6);
    }

    private String[] a(String str) {
        return str.split("\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.j.d.e a(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.j.d.e r13) {
        /*
            r11 = this;
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = r13
            r13 = 0
        L_0x0007:
            if (r13 >= r0) goto L_0x020c
            java.lang.String r3 = r12.getAttributeValue(r13)
            java.lang.String r4 = r12.getAttributeName(r13)
            int r5 = r4.hashCode()
            r6 = 4
            r7 = -1
            r8 = 2
            r9 = 3
            r10 = 1
            switch(r5) {
                case -1550943582: goto L_0x006f;
                case -1224696685: goto L_0x0065;
                case -1065511464: goto L_0x005b;
                case -879295043: goto L_0x0050;
                case -734428249: goto L_0x0046;
                case 3355: goto L_0x003c;
                case 94842723: goto L_0x0032;
                case 365601008: goto L_0x0028;
                case 1287124693: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0079
        L_0x001e:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 1
            goto L_0x007a
        L_0x0028:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 4
            goto L_0x007a
        L_0x0032:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 2
            goto L_0x007a
        L_0x003c:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 0
            goto L_0x007a
        L_0x0046:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 5
            goto L_0x007a
        L_0x0050:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 8
            goto L_0x007a
        L_0x005b:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 7
            goto L_0x007a
        L_0x0065:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 3
            goto L_0x007a
        L_0x006f:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0079
            r4 = 6
            goto L_0x007a
        L_0x0079:
            r4 = -1
        L_0x007a:
            java.lang.String r5 = "TtmlDecoder"
            switch(r4) {
                case 0: goto L_0x01f4;
                case 1: goto L_0x01d3;
                case 2: goto L_0x01b2;
                case 3: goto L_0x01a9;
                case 4: goto L_0x018b;
                case 5: goto L_0x017b;
                case 6: goto L_0x016b;
                case 7: goto L_0x00e6;
                case 8: goto L_0x0081;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0208
        L_0x0081:
            java.lang.String r3 = com.google.android.exoplayer2.n.t.d(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x00ab;
                case -1026963764: goto L_0x00a1;
                case 913457136: goto L_0x0097;
                case 1679736913: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x00b4
        L_0x008d:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b4
            r7 = 0
            goto L_0x00b4
        L_0x0097:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b4
            r7 = 1
            goto L_0x00b4
        L_0x00a1:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b4
            r7 = 2
            goto L_0x00b4
        L_0x00ab:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b4
            r7 = 3
        L_0x00b4:
            if (r7 == 0) goto L_0x00dc
            if (r7 == r10) goto L_0x00d2
            if (r7 == r8) goto L_0x00c8
            if (r7 == r9) goto L_0x00be
            goto L_0x0208
        L_0x00be:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            com.google.android.exoplayer2.j.d.e r2 = r2.b((boolean) r1)
            goto L_0x0208
        L_0x00c8:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            com.google.android.exoplayer2.j.d.e r2 = r2.b((boolean) r10)
            goto L_0x0208
        L_0x00d2:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            com.google.android.exoplayer2.j.d.e r2 = r2.a((boolean) r1)
            goto L_0x0208
        L_0x00dc:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            com.google.android.exoplayer2.j.d.e r2 = r2.a((boolean) r10)
            goto L_0x0208
        L_0x00e6:
            java.lang.String r3 = com.google.android.exoplayer2.n.t.d(r3)
            int r4 = r3.hashCode()
            switch(r4) {
                case -1364013995: goto L_0x011a;
                case 100571: goto L_0x0110;
                case 3317767: goto L_0x0106;
                case 108511772: goto L_0x00fc;
                case 109757538: goto L_0x00f2;
                default: goto L_0x00f1;
            }
        L_0x00f1:
            goto L_0x0123
        L_0x00f2:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0123
            r7 = 1
            goto L_0x0123
        L_0x00fc:
            java.lang.String r4 = "right"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0123
            r7 = 2
            goto L_0x0123
        L_0x0106:
            java.lang.String r4 = "left"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0123
            r7 = 0
            goto L_0x0123
        L_0x0110:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0123
            r7 = 3
            goto L_0x0123
        L_0x011a:
            java.lang.String r4 = "center"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0123
            r7 = 4
        L_0x0123:
            if (r7 == 0) goto L_0x015f
            if (r7 == r10) goto L_0x0153
            if (r7 == r8) goto L_0x0147
            if (r7 == r9) goto L_0x013b
            if (r7 == r6) goto L_0x012f
            goto L_0x0208
        L_0x012f:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
            com.google.android.exoplayer2.j.d.e r2 = r2.a((android.text.Layout.Alignment) r3)
            goto L_0x0208
        L_0x013b:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            com.google.android.exoplayer2.j.d.e r2 = r2.a((android.text.Layout.Alignment) r3)
            goto L_0x0208
        L_0x0147:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            com.google.android.exoplayer2.j.d.e r2 = r2.a((android.text.Layout.Alignment) r3)
            goto L_0x0208
        L_0x0153:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            com.google.android.exoplayer2.j.d.e r2 = r2.a((android.text.Layout.Alignment) r3)
            goto L_0x0208
        L_0x015f:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            com.google.android.exoplayer2.j.d.e r2 = r2.a((android.text.Layout.Alignment) r3)
            goto L_0x0208
        L_0x016b:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.j.d.e r2 = r2.d(r3)
            goto L_0x0208
        L_0x017b:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            com.google.android.exoplayer2.j.d.e r2 = r2.c((boolean) r3)
            goto L_0x0208
        L_0x018b:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)     // Catch:{ f -> 0x0194 }
            a((java.lang.String) r3, (com.google.android.exoplayer2.j.d.e) r2)     // Catch:{ f -> 0x0194 }
            goto L_0x0208
        L_0x0194:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing fontSize value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r5, r3)
            goto L_0x0208
        L_0x01a9:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            com.google.android.exoplayer2.j.d.e r2 = r2.a((java.lang.String) r3)
            goto L_0x0208
        L_0x01b2:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            int r4 = com.google.android.exoplayer2.n.c.a(r3)     // Catch:{ IllegalArgumentException -> 0x01be }
            r2.a((int) r4)     // Catch:{ IllegalArgumentException -> 0x01be }
            goto L_0x0208
        L_0x01be:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing color value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r5, r3)
            goto L_0x0208
        L_0x01d3:
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            int r4 = com.google.android.exoplayer2.n.c.a(r3)     // Catch:{ IllegalArgumentException -> 0x01df }
            r2.b((int) r4)     // Catch:{ IllegalArgumentException -> 0x01df }
            goto L_0x0208
        L_0x01df:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Failed parsing background value: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            android.util.Log.w(r5, r3)
            goto L_0x0208
        L_0x01f4:
            java.lang.String r4 = r12.getName()
            java.lang.String r5 = "style"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0208
            com.google.android.exoplayer2.j.d.e r2 = r11.a((com.google.android.exoplayer2.j.d.e) r2)
            com.google.android.exoplayer2.j.d.e r2 = r2.b((java.lang.String) r3)
        L_0x0208:
            int r13 = r13 + 1
            goto L_0x0007
        L_0x020c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.d.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.j.d.e):com.google.android.exoplayer2.j.d.e");
    }

    private e a(e eVar) {
        return eVar == null ? new e() : eVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.j.d.b a(org.xmlpull.v1.XmlPullParser r20, com.google.android.exoplayer2.j.d.b r21, java.util.Map<java.lang.String, com.google.android.exoplayer2.j.d.c> r22, com.google.android.exoplayer2.j.d.a.C0176a r23) throws com.google.android.exoplayer2.j.f {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            int r4 = r20.getAttributeCount()
            r5 = 0
            com.google.android.exoplayer2.j.d.e r11 = r0.a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.j.d.e) r5)
            java.lang.String r9 = ""
            r17 = r5
            r16 = r9
            r5 = 0
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0027:
            if (r5 >= r4) goto L_0x00af
            java.lang.String r6 = r1.getAttributeName(r5)
            java.lang.String r7 = r1.getAttributeValue(r5)
            int r18 = r6.hashCode()
            switch(r18) {
                case -934795532: goto L_0x0061;
                case 99841: goto L_0x0057;
                case 100571: goto L_0x004d;
                case 93616297: goto L_0x0043;
                case 109780401: goto L_0x0039;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x006b
        L_0x0039:
            java.lang.String r8 = "style"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x006b
            r6 = 3
            goto L_0x006c
        L_0x0043:
            java.lang.String r8 = "begin"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x006b
            r6 = 0
            goto L_0x006c
        L_0x004d:
            java.lang.String r8 = "end"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x006b
            r6 = 1
            goto L_0x006c
        L_0x0057:
            java.lang.String r8 = "dur"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x006b
            r6 = 2
            goto L_0x006c
        L_0x0061:
            java.lang.String r8 = "region"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x006b
            r6 = 4
            goto L_0x006c
        L_0x006b:
            r6 = -1
        L_0x006c:
            if (r6 == 0) goto L_0x00a4
            r8 = 1
            if (r6 == r8) goto L_0x009c
            r8 = 2
            if (r6 == r8) goto L_0x0094
            r8 = 3
            if (r6 == r8) goto L_0x0088
            r8 = 4
            if (r6 == r8) goto L_0x007d
            r6 = r22
            goto L_0x00ab
        L_0x007d:
            r6 = r22
            boolean r8 = r6.containsKey(r7)
            if (r8 == 0) goto L_0x00ab
            r16 = r7
            goto L_0x00ab
        L_0x0088:
            r6 = r22
            java.lang.String[] r7 = r0.a((java.lang.String) r7)
            int r8 = r7.length
            if (r8 <= 0) goto L_0x00ab
            r17 = r7
            goto L_0x00ab
        L_0x0094:
            r6 = r22
            long r7 = a((java.lang.String) r7, (com.google.android.exoplayer2.j.d.a.C0176a) r3)
            r14 = r7
            goto L_0x00ab
        L_0x009c:
            r6 = r22
            long r7 = a((java.lang.String) r7, (com.google.android.exoplayer2.j.d.a.C0176a) r3)
            r12 = r7
            goto L_0x00ab
        L_0x00a4:
            r6 = r22
            long r7 = a((java.lang.String) r7, (com.google.android.exoplayer2.j.d.a.C0176a) r3)
            r9 = r7
        L_0x00ab:
            int r5 = r5 + 1
            goto L_0x0027
        L_0x00af:
            if (r2 == 0) goto L_0x00cb
            long r3 = r2.f10545d
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00d0
            int r3 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00c3
            long r3 = r2.f10545d
            long r9 = r9 + r3
        L_0x00c3:
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00d0
            long r3 = r2.f10545d
            long r12 = r12 + r3
            goto L_0x00d0
        L_0x00cb:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00d0:
            r7 = r9
            int r3 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x00e8
            int r3 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00dc
            long r14 = r14 + r7
            r9 = r14
            goto L_0x00e9
        L_0x00dc:
            if (r2 == 0) goto L_0x00e8
            long r3 = r2.f10546e
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x00e8
            long r2 = r2.f10546e
            r9 = r2
            goto L_0x00e9
        L_0x00e8:
            r9 = r12
        L_0x00e9:
            java.lang.String r6 = r20.getName()
            r12 = r17
            r13 = r16
            com.google.android.exoplayer2.j.d.b r1 = com.google.android.exoplayer2.j.d.b.a(r6, r7, r9, r11, r12, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.d.a.a(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.j.d.b, java.util.Map, com.google.android.exoplayer2.j.d.a$a):com.google.android.exoplayer2.j.d.b");
    }

    private static boolean b(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("smpte:image") || str.equals("smpte:data") || str.equals("smpte:information");
    }

    private static void a(String str, e eVar) throws f {
        Matcher matcher;
        String[] split = str.split("\\s+");
        if (split.length == 1) {
            matcher = f10535c.matcher(str);
        } else if (split.length == 2) {
            matcher = f10535c.matcher(split[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new f("Invalid number of entries for fontSize: " + split.length + ".");
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            char c2 = 65535;
            int hashCode = group.hashCode();
            if (hashCode != 37) {
                if (hashCode != 3240) {
                    if (hashCode == 3592 && group.equals("px")) {
                        c2 = 0;
                    }
                } else if (group.equals(UserDataStore.EMAIL)) {
                    c2 = 1;
                }
            } else if (group.equals("%")) {
                c2 = 2;
            }
            if (c2 == 0) {
                eVar.c(1);
            } else if (c2 == 1) {
                eVar.c(2);
            } else if (c2 == 2) {
                eVar.c(3);
            } else {
                throw new f("Invalid unit for fontSize: '" + group + "'.");
            }
            eVar.a(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new f("Invalid expression for fontSize: '" + str + "'.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.lang.String r14, com.google.android.exoplayer2.j.d.a.C0176a r15) throws com.google.android.exoplayer2.j.f {
        /*
            java.util.regex.Pattern r0 = f10533a
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0088
            java.lang.String r14 = r0.group(r8)
            long r8 = java.lang.Long.parseLong(r14)
            r10 = 3600(0xe10, double:1.7786E-320)
            long r8 = r8 * r10
            double r8 = (double) r8
            java.lang.String r14 = r0.group(r7)
            long r10 = java.lang.Long.parseLong(r14)
            r12 = 60
            long r10 = r10 * r12
            double r10 = (double) r10
            java.lang.Double.isNaN(r8)
            java.lang.Double.isNaN(r10)
            double r8 = r8 + r10
            java.lang.String r14 = r0.group(r6)
            long r6 = java.lang.Long.parseLong(r14)
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r8 = r8 + r6
            java.lang.String r14 = r0.group(r5)
            r5 = 0
            if (r14 == 0) goto L_0x0051
            double r10 = java.lang.Double.parseDouble(r14)
            goto L_0x0052
        L_0x0051:
            r10 = r5
        L_0x0052:
            double r8 = r8 + r10
            java.lang.String r14 = r0.group(r4)
            if (r14 == 0) goto L_0x0063
            long r10 = java.lang.Long.parseLong(r14)
            float r14 = (float) r10
            float r1 = r15.f10539a
            float r14 = r14 / r1
            double r10 = (double) r14
            goto L_0x0064
        L_0x0063:
            r10 = r5
        L_0x0064:
            double r8 = r8 + r10
            r14 = 6
            java.lang.String r14 = r0.group(r14)
            if (r14 == 0) goto L_0x0083
            long r0 = java.lang.Long.parseLong(r14)
            double r0 = (double) r0
            int r14 = r15.f10540b
            double r4 = (double) r14
            java.lang.Double.isNaN(r0)
            java.lang.Double.isNaN(r4)
            double r0 = r0 / r4
            float r14 = r15.f10539a
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            double r5 = r0 / r14
        L_0x0083:
            double r8 = r8 + r5
            double r8 = r8 * r2
            long r14 = (long) r8
            return r14
        L_0x0088:
            java.util.regex.Pattern r0 = f10534b
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x012b
            java.lang.String r14 = r0.group(r8)
            double r9 = java.lang.Double.parseDouble(r14)
            java.lang.String r14 = r0.group(r7)
            r0 = -1
            int r1 = r14.hashCode()
            r11 = 102(0x66, float:1.43E-43)
            if (r1 == r11) goto L_0x00f0
            r11 = 104(0x68, float:1.46E-43)
            if (r1 == r11) goto L_0x00e6
            r11 = 109(0x6d, float:1.53E-43)
            if (r1 == r11) goto L_0x00dc
            r11 = 3494(0xda6, float:4.896E-42)
            if (r1 == r11) goto L_0x00d2
            r11 = 115(0x73, float:1.61E-43)
            if (r1 == r11) goto L_0x00c8
            r11 = 116(0x74, float:1.63E-43)
            if (r1 == r11) goto L_0x00be
            goto L_0x00fa
        L_0x00be:
            java.lang.String r1 = "t"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00fa
            r14 = 5
            goto L_0x00fb
        L_0x00c8:
            java.lang.String r1 = "s"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00fa
            r14 = 2
            goto L_0x00fb
        L_0x00d2:
            java.lang.String r1 = "ms"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00fa
            r14 = 3
            goto L_0x00fb
        L_0x00dc:
            java.lang.String r1 = "m"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00fa
            r14 = 1
            goto L_0x00fb
        L_0x00e6:
            java.lang.String r1 = "h"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00fa
            r14 = 0
            goto L_0x00fb
        L_0x00f0:
            java.lang.String r1 = "f"
            boolean r14 = r14.equals(r1)
            if (r14 == 0) goto L_0x00fa
            r14 = 4
            goto L_0x00fb
        L_0x00fa:
            r14 = -1
        L_0x00fb:
            if (r14 == 0) goto L_0x0120
            if (r14 == r8) goto L_0x011d
            if (r14 == r7) goto L_0x0127
            if (r14 == r6) goto L_0x0116
            if (r14 == r5) goto L_0x010f
            if (r14 == r4) goto L_0x0108
            goto L_0x0127
        L_0x0108:
            int r14 = r15.f10541c
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            goto L_0x011b
        L_0x010f:
            float r14 = r15.f10539a
            double r14 = (double) r14
            java.lang.Double.isNaN(r14)
            goto L_0x011b
        L_0x0116:
            r14 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x011b:
            double r9 = r9 / r14
            goto L_0x0127
        L_0x011d:
            r14 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x0125
        L_0x0120:
            r14 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x0125:
            double r9 = r9 * r14
        L_0x0127:
            double r9 = r9 * r2
            long r14 = (long) r9
            return r14
        L_0x012b:
            com.google.android.exoplayer2.j.f r15 = new com.google.android.exoplayer2.j.f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Malformed time expression: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.<init>(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.d.a.a(java.lang.String, com.google.android.exoplayer2.j.d.a$a):long");
    }

    /* renamed from: com.google.android.exoplayer2.j.d.a$a  reason: collision with other inner class name */
    private static final class C0176a {

        /* renamed from: a  reason: collision with root package name */
        final float f10539a;

        /* renamed from: b  reason: collision with root package name */
        final int f10540b;

        /* renamed from: c  reason: collision with root package name */
        final int f10541c;

        C0176a(float f2, int i, int i2) {
            this.f10539a = f2;
            this.f10540b = i;
            this.f10541c = i2;
        }
    }
}
