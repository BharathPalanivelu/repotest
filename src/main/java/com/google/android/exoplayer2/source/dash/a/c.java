package com.google.android.exoplayer2.source.dash.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.ak;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.m.t;
import com.google.android.exoplayer2.n.s;
import com.google.android.exoplayer2.n.u;
import com.google.android.exoplayer2.source.dash.a.h;
import com.google.android.exoplayer2.z;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class c extends DefaultHandler implements t.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11849a = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11850b = Pattern.compile("CC([1-4])=.*");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11851c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: d  reason: collision with root package name */
    private final String f11852d;

    /* renamed from: e  reason: collision with root package name */
    private final XmlPullParserFactory f11853e;

    /* access modifiers changed from: protected */
    public void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
    }

    public c() {
        this((String) null);
    }

    public c(String str) {
        this.f11852d = str;
        try {
            this.f11853e = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* renamed from: b */
    public b a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f11853e.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return a(newPullParser, uri.toString());
            }
            throw new ak("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e2) {
            throw new ak((Throwable) e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015c A[LOOP:0: B:20:0x0064->B:63:0x015c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.a.b a(org.xmlpull.v1.XmlPullParser r30, java.lang.String r31) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r29 = this;
            r0 = r30
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.lang.String r3 = "availabilityStartTime"
            long r5 = c(r0, r3, r1)
            java.lang.String r3 = "mediaPresentationDuration"
            long r3 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r3, (long) r1)
            java.lang.String r7 = "minBufferTime"
            long r9 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r7, (long) r1)
            r7 = 0
            java.lang.String r8 = "type"
            java.lang.String r8 = r0.getAttributeValue(r7, r8)
            r12 = 0
            if (r8 == 0) goto L_0x002d
            java.lang.String r13 = "dynamic"
            boolean r8 = r8.equals(r13)
            if (r8 == 0) goto L_0x002d
            r13 = 1
            goto L_0x002e
        L_0x002d:
            r13 = 0
        L_0x002e:
            if (r13 == 0) goto L_0x0037
            java.lang.String r8 = "minimumUpdatePeriod"
            long r14 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r8, (long) r1)
            goto L_0x0038
        L_0x0037:
            r14 = r1
        L_0x0038:
            if (r13 == 0) goto L_0x0041
            java.lang.String r8 = "timeShiftBufferDepth"
            long r16 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r8, (long) r1)
            goto L_0x0043
        L_0x0041:
            r16 = r1
        L_0x0043:
            if (r13 == 0) goto L_0x004c
            java.lang.String r8 = "suggestedPresentationDelay"
            long r18 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r8, (long) r1)
            goto L_0x004e
        L_0x004c:
            r18 = r1
        L_0x004e:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            if (r13 == 0) goto L_0x0058
            r20 = r1
            goto L_0x005a
        L_0x0058:
            r20 = 0
        L_0x005a:
            r23 = r7
            r24 = r23
            r1 = r20
            r20 = 0
            r7 = r31
        L_0x0064:
            r30.next()
            java.lang.String r11 = "BaseURL"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x0082
            if (r12 != 0) goto L_0x007a
            java.lang.String r7 = c((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r7)
            r27 = r14
            r12 = 1
            goto L_0x0115
        L_0x007a:
            r25 = r1
            r31 = r12
            r27 = r14
            goto L_0x0111
        L_0x0082:
            java.lang.String r11 = "UTCTiming"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x0094
            com.google.android.exoplayer2.source.dash.a.k r11 = r29.a((org.xmlpull.v1.XmlPullParser) r30)
            r23 = r11
        L_0x0090:
            r27 = r14
            goto L_0x0115
        L_0x0094:
            java.lang.String r11 = "Location"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x00a7
            java.lang.String r11 = r30.nextText()
            android.net.Uri r11 = android.net.Uri.parse(r11)
            r24 = r11
            goto L_0x0090
        L_0x00a7:
            java.lang.String r11 = "Period"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x007a
            if (r20 != 0) goto L_0x007a
            r11 = r29
            r31 = r12
            android.util.Pair r12 = r11.a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r7, (long) r1)
            r25 = r1
            java.lang.Object r1 = r12.first
            com.google.android.exoplayer2.source.dash.a.d r1 = (com.google.android.exoplayer2.source.dash.a.d) r1
            r27 = r14
            long r14 = r1.f11860b
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x00f0
            if (r13 == 0) goto L_0x00d5
            r12 = r31
            r1 = r25
            r20 = 1
            goto L_0x0115
        L_0x00d5:
            com.google.android.exoplayer2.ak r0 = new com.google.android.exoplayer2.ak
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to determine start of period "
            r1.append(r2)
            int r2 = r8.size()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x00f0:
            java.lang.Object r2 = r12.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r14 = r2.longValue()
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x0107
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x010a
        L_0x0107:
            long r11 = r1.f11860b
            long r11 = r11 + r14
        L_0x010a:
            r8.add(r1)
            r1 = r11
            r12 = r31
            goto L_0x0115
        L_0x0111:
            r12 = r31
            r1 = r25
        L_0x0115:
            java.lang.String r11 = "MPD"
            boolean r11 = com.google.android.exoplayer2.n.u.a(r0, r11)
            if (r11 == 0) goto L_0x015c
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0136
            int r0 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x012b
            goto L_0x0137
        L_0x012b:
            if (r13 == 0) goto L_0x012e
            goto L_0x0136
        L_0x012e:
            com.google.android.exoplayer2.ak r0 = new com.google.android.exoplayer2.ak
            java.lang.String r1 = "Unable to determine duration of static manifest."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0136:
            r1 = r3
        L_0x0137:
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0154
            r4 = r29
            r21 = r8
            r7 = r1
            r11 = r13
            r12 = r27
            r14 = r16
            r16 = r18
            r18 = r23
            r19 = r24
            r20 = r21
            com.google.android.exoplayer2.source.dash.a.b r0 = r4.a(r5, r7, r9, r11, r12, r14, r16, r18, r19, r20)
            return r0
        L_0x0154:
            com.google.android.exoplayer2.ak r0 = new com.google.android.exoplayer2.ak
            java.lang.String r1 = "No periods found."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x015c:
            r14 = r27
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(org.xmlpull.v1.XmlPullParser, java.lang.String):com.google.android.exoplayer2.source.dash.a.b");
    }

    /* access modifiers changed from: protected */
    public b a(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<d> list) {
        return new b(j, j2, j3, z, j4, j5, j6, kVar, uri, list);
    }

    /* access modifiers changed from: protected */
    public k a(XmlPullParser xmlPullParser) {
        return a(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    /* access modifiers changed from: protected */
    public k a(String str, String str2) {
        return new k(str, str2);
    }

    /* access modifiers changed from: protected */
    public Pair<d, Long> a(XmlPullParser xmlPullParser, String str, long j) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "id");
        long b2 = b(xmlPullParser, ViewProps.START, j);
        long b3 = b(xmlPullParser, "duration", -9223372036854775807L);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        h hVar = null;
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser, "BaseURL")) {
                if (!z) {
                    str = c(xmlPullParser, str);
                    z = true;
                }
            } else if (u.b(xmlPullParser, "AdaptationSet")) {
                arrayList.add(a(xmlPullParser, str, hVar));
            } else if (u.b(xmlPullParser, "SegmentBase")) {
                hVar = a(xmlPullParser, (h.e) null);
            } else if (u.b(xmlPullParser, "SegmentList")) {
                hVar = a(xmlPullParser, (h.b) null);
            } else if (u.b(xmlPullParser, "SegmentTemplate")) {
                hVar = a(xmlPullParser, (h.c) null);
            }
        } while (!u.a(xmlPullParser, "Period"));
        return Pair.create(a(attributeValue, b2, (List<a>) arrayList), Long.valueOf(b3));
    }

    /* access modifiers changed from: protected */
    public d a(String str, long j, List<a> list) {
        return new d(str, j, list);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f6 A[LOOP:0: B:1:0x005c->B:53:0x01f6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01c9 A[EDGE_INSN: B:54:0x01c9->B:47:0x01c9 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.a.a a(org.xmlpull.v1.XmlPullParser r36, java.lang.String r37, com.google.android.exoplayer2.source.dash.a.h r38) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r14 = r35
            r15 = r36
            r0 = -1
            java.lang.String r1 = "id"
            int r13 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r1, (int) r0)
            int r1 = r35.b((org.xmlpull.v1.XmlPullParser) r36)
            r12 = 0
            java.lang.String r2 = "mimeType"
            java.lang.String r16 = r15.getAttributeValue(r12, r2)
            java.lang.String r2 = "codecs"
            java.lang.String r17 = r15.getAttributeValue(r12, r2)
            java.lang.String r2 = "width"
            int r18 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r2, (int) r0)
            java.lang.String r2 = "height"
            int r19 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r2, (int) r0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r20 = a((org.xmlpull.v1.XmlPullParser) r15, (float) r2)
            java.lang.String r2 = "audioSamplingRate"
            int r21 = a((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r2, (int) r0)
            java.lang.String r11 = "lang"
            java.lang.String r2 = r15.getAttributeValue(r12, r11)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r22 = 0
            r6 = r37
            r26 = r38
            r4 = r1
            r5 = r2
            r23 = 0
            r24 = 0
            r25 = -1
        L_0x005c:
            r36.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x0095
            if (r23 != 0) goto L_0x0081
            java.lang.String r0 = c((org.xmlpull.v1.XmlPullParser) r15, (java.lang.String) r6)
            r1 = 1
            r6 = r0
            r3 = r4
            r2 = r7
            r37 = r8
            r4 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r1 = r15
            r23 = 1
            goto L_0x01c1
        L_0x0081:
            r3 = r4
            r27 = r5
            r28 = r6
            r2 = r7
            r37 = r8
            r4 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r1 = r15
            goto L_0x01bd
        L_0x0095:
            java.lang.String r0 = "ContentProtection"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x00a7
            com.google.android.exoplayer2.c.a$a r0 = r35.c(r36)
            if (r0 == 0) goto L_0x0081
            r10.add(r0)
            goto L_0x0081
        L_0x00a7:
            java.lang.String r0 = "ContentComponent"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = r15.getAttributeValue(r12, r11)
            java.lang.String r5 = c((java.lang.String) r5, (java.lang.String) r0)
            int r0 = r35.b((org.xmlpull.v1.XmlPullParser) r36)
            int r0 = a((int) r4, (int) r0)
            r3 = r0
        L_0x00c0:
            r2 = r7
            r37 = r8
            r4 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r1 = r15
            goto L_0x01c1
        L_0x00cf:
            java.lang.String r0 = "Role"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x00df
            int r0 = r35.f(r36)
            r24 = r24 | r0
        L_0x00dd:
            r3 = r4
            goto L_0x00c0
        L_0x00df:
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x00ec
            int r25 = r35.k(r36)
            goto L_0x00dd
        L_0x00ec:
            java.lang.String r0 = "Accessibility"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x00fc
            com.google.android.exoplayer2.source.dash.a.g r0 = r35.e(r36)
            r8.add(r0)
            goto L_0x0081
        L_0x00fc:
            java.lang.String r0 = "Representation"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r15, r0)
            if (r0 == 0) goto L_0x0150
            r0 = r35
            r1 = r36
            r2 = r6
            r3 = r16
            r15 = r4
            r4 = r17
            r27 = r5
            r5 = r18
            r28 = r6
            r6 = r19
            r29 = r7
            r7 = r20
            r37 = r8
            r8 = r25
            r30 = r9
            r9 = r21
            r31 = r10
            r10 = r27
            r32 = r11
            r11 = r24
            r33 = r12
            r12 = r37
            r34 = r13
            r13 = r26
            com.google.android.exoplayer2.source.dash.a.c$a r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.google.android.exoplayer2.j r1 = r0.f11854a
            int r1 = r14.a((com.google.android.exoplayer2.j) r1)
            int r1 = a((int) r15, (int) r1)
            r2 = r29
            r2.add(r0)
            r3 = r1
            r5 = r27
            r6 = r28
            r4 = r30
            r1 = r36
            goto L_0x01c1
        L_0x0150:
            r15 = r4
            r27 = r5
            r28 = r6
            r2 = r7
            r37 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            java.lang.String r0 = "SegmentBase"
            r1 = r36
            r3 = r15
            boolean r0 = com.google.android.exoplayer2.n.u.b(r1, r0)
            if (r0 == 0) goto L_0x017e
            r0 = r26
            com.google.android.exoplayer2.source.dash.a.h$e r0 = (com.google.android.exoplayer2.source.dash.a.h.e) r0
            com.google.android.exoplayer2.source.dash.a.h$e r0 = r14.a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.source.dash.a.h.e) r0)
        L_0x0175:
            r26 = r0
            r5 = r27
            r6 = r28
            r4 = r30
            goto L_0x01c1
        L_0x017e:
            java.lang.String r0 = "SegmentList"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r1, r0)
            if (r0 == 0) goto L_0x018f
            r0 = r26
            com.google.android.exoplayer2.source.dash.a.h$b r0 = (com.google.android.exoplayer2.source.dash.a.h.b) r0
            com.google.android.exoplayer2.source.dash.a.h$b r0 = r14.a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.source.dash.a.h.b) r0)
            goto L_0x0175
        L_0x018f:
            java.lang.String r0 = "SegmentTemplate"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r1, r0)
            if (r0 == 0) goto L_0x01a0
            r0 = r26
            com.google.android.exoplayer2.source.dash.a.h$c r0 = (com.google.android.exoplayer2.source.dash.a.h.c) r0
            com.google.android.exoplayer2.source.dash.a.h$c r0 = r14.a((org.xmlpull.v1.XmlPullParser) r1, (com.google.android.exoplayer2.source.dash.a.h.c) r0)
            goto L_0x0175
        L_0x01a0:
            java.lang.String r0 = "InbandEventStream"
            boolean r0 = com.google.android.exoplayer2.n.u.b(r1, r0)
            if (r0 == 0) goto L_0x01b2
            com.google.android.exoplayer2.source.dash.a.g r0 = r35.d(r36)
            r4 = r30
            r4.add(r0)
            goto L_0x01bd
        L_0x01b2:
            r4 = r30
            boolean r0 = com.google.android.exoplayer2.n.u.b(r36)
            if (r0 == 0) goto L_0x01bd
            r35.g(r36)
        L_0x01bd:
            r5 = r27
            r6 = r28
        L_0x01c1:
            java.lang.String r0 = "AdaptationSet"
            boolean r0 = com.google.android.exoplayer2.n.u.a(r1, r0)
            if (r0 == 0) goto L_0x01f6
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r2.size()
            r0.<init>(r1)
            r1 = 0
        L_0x01d3:
            int r5 = r2.size()
            if (r1 >= r5) goto L_0x01ed
            java.lang.Object r5 = r2.get(r1)
            com.google.android.exoplayer2.source.dash.a.c$a r5 = (com.google.android.exoplayer2.source.dash.a.c.a) r5
            java.lang.String r6 = r14.f11852d
            r7 = r31
            com.google.android.exoplayer2.source.dash.a.f r5 = r14.a((com.google.android.exoplayer2.source.dash.a.c.a) r5, (java.lang.String) r6, (java.util.ArrayList<com.google.android.exoplayer2.c.a.C0159a>) r7, (java.util.ArrayList<com.google.android.exoplayer2.source.dash.a.g>) r4)
            r0.add(r5)
            int r1 = r1 + 1
            goto L_0x01d3
        L_0x01ed:
            r9 = r37
            r8 = r34
            com.google.android.exoplayer2.source.dash.a.a r0 = r14.a((int) r8, (int) r3, (java.util.List<com.google.android.exoplayer2.source.dash.a.f>) r0, (java.util.List<com.google.android.exoplayer2.source.dash.a.g>) r9)
            return r0
        L_0x01f6:
            r8 = r37
            r15 = r1
            r7 = r2
            r9 = r4
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r4 = r3
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(org.xmlpull.v1.XmlPullParser, java.lang.String, com.google.android.exoplayer2.source.dash.a.h):com.google.android.exoplayer2.source.dash.a.a");
    }

    /* access modifiers changed from: protected */
    public a a(int i, int i2, List<f> list, List<g> list2) {
        return new a(i, i2, list, list2);
    }

    /* access modifiers changed from: protected */
    public int b(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int a(j jVar) {
        String str = jVar.f10427f;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (com.google.android.exoplayer2.n.h.b(str)) {
            return 2;
        }
        if (com.google.android.exoplayer2.n.h.a(str)) {
            return 1;
        }
        if (a(str)) {
            return 3;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public a.C0159a c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean equals = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95".equals(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"));
        byte[] bArr = null;
        UUID uuid = null;
        boolean z = false;
        do {
            xmlPullParser.next();
            if (bArr == null && u.b(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                bArr = Base64.decode(xmlPullParser.getText(), 0);
                uuid = com.google.android.exoplayer2.e.d.h.a(bArr);
                if (uuid == null) {
                    Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                    bArr = null;
                }
            } else if (bArr == null && equals && u.b(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                bArr = com.google.android.exoplayer2.e.d.h.a(z.f12319e, Base64.decode(xmlPullParser.getText(), 0));
                uuid = z.f12319e;
            } else if (u.b(xmlPullParser, "widevine:license")) {
                String attributeValue = xmlPullParser.getAttributeValue((String) null, "robustness_level");
                z = attributeValue != null && attributeValue.startsWith("HW");
            }
        } while (!u.a(xmlPullParser, "ContentProtection"));
        if (bArr != null) {
            return new a.C0159a(uuid, "video/mp4", bArr, z);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public g d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return b(xmlPullParser, "InbandEventStream");
    }

    /* access modifiers changed from: protected */
    public g e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return b(xmlPullParser, "Accessibility");
    }

    /* access modifiers changed from: protected */
    public int f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String b2 = b(xmlPullParser, "schemeIdUri", (String) null);
        String b3 = b(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) null);
        do {
            xmlPullParser.next();
        } while (!u.a(xmlPullParser, "Role"));
        return (!"urn:mpeg:dash:role:2011".equals(b2) || !"main".equals(b3)) ? 0 : 1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff A[LOOP:0: B:1:0x0051->B:35:0x00ff, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d6 A[EDGE_INSN: B:36:0x00d6->B:29:0x00d6 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.source.dash.a.c.a a(org.xmlpull.v1.XmlPullParser r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, int r24, float r25, int r26, int r27, java.lang.String r28, int r29, java.util.List<com.google.android.exoplayer2.source.dash.a.g> r30, com.google.android.exoplayer2.source.dash.a.h r31) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r18 = this;
            r13 = r18
            r0 = r19
            r1 = 0
            java.lang.String r2 = "id"
            java.lang.String r1 = r0.getAttributeValue(r1, r2)
            java.lang.String r2 = "bandwidth"
            r3 = -1
            int r8 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r2, (int) r3)
            java.lang.String r2 = "mimeType"
            r3 = r21
            java.lang.String r2 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r2, (java.lang.String) r3)
            java.lang.String r3 = "codecs"
            r4 = r22
            java.lang.String r12 = b((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r3, (java.lang.String) r4)
            java.lang.String r3 = "width"
            r4 = r23
            int r3 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r3, (int) r4)
            java.lang.String r4 = "height"
            r5 = r24
            int r4 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r4, (int) r5)
            r5 = r25
            float r5 = a((org.xmlpull.v1.XmlPullParser) r0, (float) r5)
            java.lang.String r6 = "audioSamplingRate"
            r7 = r27
            int r7 = a((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r6, (int) r7)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r6 = 0
            r9 = r20
            r11 = r26
            r10 = r31
        L_0x0051:
            r19.next()
            r20 = r11
            java.lang.String r11 = "BaseURL"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x006d
            if (r6 != 0) goto L_0x00c8
            java.lang.String r6 = c((org.xmlpull.v1.XmlPullParser) r0, (java.lang.String) r9)
            r9 = 1
            r11 = r20
            r16 = r6
            r17 = r10
            r6 = 1
            goto L_0x00ce
        L_0x006d:
            java.lang.String r11 = "AudioChannelConfiguration"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x007a
            int r11 = r18.k(r19)
            goto L_0x00ca
        L_0x007a:
            java.lang.String r11 = "SegmentBase"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x0089
            com.google.android.exoplayer2.source.dash.a.h$e r10 = (com.google.android.exoplayer2.source.dash.a.h.e) r10
            com.google.android.exoplayer2.source.dash.a.h$e r10 = r13.a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.source.dash.a.h.e) r10)
            goto L_0x00c8
        L_0x0089:
            java.lang.String r11 = "SegmentList"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x0098
            com.google.android.exoplayer2.source.dash.a.h$b r10 = (com.google.android.exoplayer2.source.dash.a.h.b) r10
            com.google.android.exoplayer2.source.dash.a.h$b r10 = r13.a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.source.dash.a.h.b) r10)
            goto L_0x00c8
        L_0x0098:
            java.lang.String r11 = "SegmentTemplate"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x00a7
            com.google.android.exoplayer2.source.dash.a.h$c r10 = (com.google.android.exoplayer2.source.dash.a.h.c) r10
            com.google.android.exoplayer2.source.dash.a.h$c r10 = r13.a((org.xmlpull.v1.XmlPullParser) r0, (com.google.android.exoplayer2.source.dash.a.h.c) r10)
            goto L_0x00c8
        L_0x00a7:
            java.lang.String r11 = "ContentProtection"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x00b9
            com.google.android.exoplayer2.c.a$a r11 = r18.c(r19)
            if (r11 == 0) goto L_0x00c8
            r14.add(r11)
            goto L_0x00c8
        L_0x00b9:
            java.lang.String r11 = "InbandEventStream"
            boolean r11 = com.google.android.exoplayer2.n.u.b(r0, r11)
            if (r11 == 0) goto L_0x00c8
            com.google.android.exoplayer2.source.dash.a.g r11 = r18.d(r19)
            r15.add(r11)
        L_0x00c8:
            r11 = r20
        L_0x00ca:
            r16 = r9
            r17 = r10
        L_0x00ce:
            java.lang.String r9 = "Representation"
            boolean r9 = com.google.android.exoplayer2.n.u.a(r0, r9)
            if (r9 == 0) goto L_0x00ff
            r0 = r18
            r6 = r11
            r9 = r28
            r10 = r29
            r11 = r30
            com.google.android.exoplayer2.j r0 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r17 == 0) goto L_0x00e8
            r1 = r17
            goto L_0x00ed
        L_0x00e8:
            com.google.android.exoplayer2.source.dash.a.h$e r1 = new com.google.android.exoplayer2.source.dash.a.h$e
            r1.<init>()
        L_0x00ed:
            com.google.android.exoplayer2.source.dash.a.c$a r2 = new com.google.android.exoplayer2.source.dash.a.c$a
            r19 = r2
            r20 = r0
            r21 = r16
            r22 = r1
            r23 = r14
            r24 = r15
            r19.<init>(r20, r21, r22, r23, r24)
            return r2
        L_0x00ff:
            r9 = r16
            r10 = r17
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.a.c.a(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, int, java.util.List, com.google.android.exoplayer2.source.dash.a.h):com.google.android.exoplayer2.source.dash.a.c$a");
    }

    /* access modifiers changed from: protected */
    public j a(String str, String str2, int i, int i2, float f2, int i3, int i4, int i5, String str3, int i6, List<g> list, String str4) {
        int i7;
        int b2;
        String str5 = str2;
        String b3 = b(str2, str4);
        if (b3 != null) {
            if (com.google.android.exoplayer2.n.h.b(b3)) {
                return j.a(str, str2, b3, str4, i5, i, i2, f2, (List<byte[]>) null, i6);
            }
            if (com.google.android.exoplayer2.n.h.a(b3)) {
                return j.a(str, str2, b3, str4, i5, i3, i4, (List<byte[]>) null, i6, str3);
            }
            if (a(b3)) {
                if ("application/cea-608".equals(b3)) {
                    b2 = a(list);
                } else if ("application/cea-708".equals(b3)) {
                    b2 = b(list);
                } else {
                    i7 = -1;
                    return j.a(str, str2, b3, str4, i5, i6, str3, i7);
                }
                i7 = b2;
                return j.a(str, str2, b3, str4, i5, i6, str3, i7);
            }
        }
        return j.b(str, str2, b3, str4, i5, i6, str3);
    }

    /* access modifiers changed from: protected */
    public f a(a aVar, String str, ArrayList<a.C0159a> arrayList, ArrayList<g> arrayList2) {
        j jVar = aVar.f11854a;
        ArrayList<a.C0159a> arrayList3 = aVar.f11857d;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            jVar = jVar.a(new com.google.android.exoplayer2.c.a((List<a.C0159a>) arrayList3));
        }
        ArrayList<g> arrayList4 = aVar.f11858e;
        arrayList4.addAll(arrayList2);
        return f.a(str, -1, jVar, aVar.f11855b, aVar.f11856c, arrayList4);
    }

    /* access modifiers changed from: protected */
    public h.e a(XmlPullParser xmlPullParser, h.e eVar) throws XmlPullParserException, IOException {
        long j;
        long j2;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        h.e eVar2 = eVar;
        long d2 = d(xmlPullParser2, "timescale", eVar2 != null ? eVar2.f11878b : 1);
        long j3 = 0;
        long d3 = d(xmlPullParser2, "presentationTimeOffset", eVar2 != null ? eVar2.f11879c : 0);
        long j4 = eVar2 != null ? eVar2.f11887d : 0;
        if (eVar2 != null) {
            j3 = eVar2.f11888e;
        }
        e eVar3 = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - parseLong) + 1;
            j2 = parseLong;
        } else {
            j = j3;
            j2 = j4;
        }
        if (eVar2 != null) {
            eVar3 = eVar2.f11877a;
        }
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser2, "Initialization")) {
                eVar3 = i(xmlPullParser);
            }
        } while (!u.a(xmlPullParser2, "SegmentBase"));
        return a(eVar3, d2, d3, j2, j);
    }

    /* access modifiers changed from: protected */
    public h.e a(e eVar, long j, long j2, long j3, long j4) {
        return new h.e(eVar, j, j2, j3, j4);
    }

    /* access modifiers changed from: protected */
    public h.b a(XmlPullParser xmlPullParser, h.b bVar) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        h.b bVar2 = bVar;
        long d2 = d(xmlPullParser2, "timescale", bVar2 != null ? bVar2.f11878b : 1);
        long d3 = d(xmlPullParser2, "presentationTimeOffset", bVar2 != null ? bVar2.f11879c : 0);
        long d4 = d(xmlPullParser2, "duration", bVar2 != null ? bVar2.f11881e : -9223372036854775807L);
        int a2 = a(xmlPullParser2, "startNumber", bVar2 != null ? bVar2.f11880d : 1);
        List list = null;
        e eVar = null;
        List<h.d> list2 = null;
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser2, "Initialization")) {
                eVar = i(xmlPullParser);
            } else if (u.b(xmlPullParser2, "SegmentTimeline")) {
                list2 = h(xmlPullParser);
            } else if (u.b(xmlPullParser2, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(j(xmlPullParser));
            }
        } while (!u.a(xmlPullParser2, "SegmentList"));
        if (bVar2 != null) {
            if (eVar == null) {
                eVar = bVar2.f11877a;
            }
            if (list2 == null) {
                list2 = bVar2.f11882f;
            }
            if (list == null) {
                list = bVar2.f11883g;
            }
        }
        return a(eVar, d2, d3, a2, d4, list2, list);
    }

    /* access modifiers changed from: protected */
    public h.b a(e eVar, long j, long j2, int i, long j3, List<h.d> list, List<e> list2) {
        return new h.b(eVar, j, j2, i, j3, list, list2);
    }

    /* access modifiers changed from: protected */
    public h.c a(XmlPullParser xmlPullParser, h.c cVar) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        h.c cVar2 = cVar;
        long d2 = d(xmlPullParser2, "timescale", cVar2 != null ? cVar2.f11878b : 1);
        long d3 = d(xmlPullParser2, "presentationTimeOffset", cVar2 != null ? cVar2.f11879c : 0);
        long d4 = d(xmlPullParser2, "duration", cVar2 != null ? cVar2.f11881e : -9223372036854775807L);
        int a2 = a(xmlPullParser2, "startNumber", cVar2 != null ? cVar2.f11880d : 1);
        e eVar = null;
        j a3 = a(xmlPullParser2, "media", cVar2 != null ? cVar2.h : null);
        j a4 = a(xmlPullParser2, "initialization", cVar2 != null ? cVar2.f11884g : null);
        List<h.d> list = null;
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser2, "Initialization")) {
                eVar = i(xmlPullParser);
            } else if (u.b(xmlPullParser2, "SegmentTimeline")) {
                list = h(xmlPullParser);
            }
        } while (!u.a(xmlPullParser2, "SegmentTemplate"));
        if (cVar2 != null) {
            if (eVar == null) {
                eVar = cVar2.f11877a;
            }
            if (list == null) {
                list = cVar2.f11882f;
            }
        }
        return a(eVar, d2, d3, a2, d4, list, a4, a3);
    }

    /* access modifiers changed from: protected */
    public h.c a(e eVar, long j, long j2, int i, long j3, List<h.d> list, j jVar, j jVar2) {
        return new h.c(eVar, j, j2, i, j3, list, jVar, jVar2);
    }

    /* access modifiers changed from: protected */
    public List<h.d> h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (u.b(xmlPullParser, "S")) {
                j = d(xmlPullParser, "t", j);
                long d2 = d(xmlPullParser, "d", -9223372036854775807L);
                int a2 = a(xmlPullParser, "r", 0) + 1;
                for (int i = 0; i < a2; i++) {
                    arrayList.add(a(j, d2));
                    j += d2;
                }
            }
        } while (!u.a(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public h.d a(long j, long j2) {
        return new h.d(j, j2);
    }

    /* access modifiers changed from: protected */
    public j a(XmlPullParser xmlPullParser, String str, j jVar) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? j.a(attributeValue) : jVar;
    }

    /* access modifiers changed from: protected */
    public e i(XmlPullParser xmlPullParser) {
        return a(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    public e j(XmlPullParser xmlPullParser) {
        return a(xmlPullParser, "media", "mediaRange");
    }

    /* access modifiers changed from: protected */
    public e a(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j = (Long.parseLong(split[1]) - j2) + 1;
                return a(attributeValue, j2, j);
            }
        } else {
            j2 = 0;
        }
        j = -1;
        return a(attributeValue, j2, j);
    }

    /* access modifiers changed from: protected */
    public e a(String str, long j, long j2) {
        return new e(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public int k(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(b(xmlPullParser, "schemeIdUri", (String) null))) {
            i = a(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        }
        do {
            xmlPullParser.next();
        } while (!u.a(xmlPullParser, "AudioChannelConfiguration"));
        return i;
    }

    private static String b(String str, String str2) {
        if (com.google.android.exoplayer2.n.h.a(str)) {
            return com.google.android.exoplayer2.n.h.e(str2);
        }
        if (com.google.android.exoplayer2.n.h.b(str)) {
            return com.google.android.exoplayer2.n.h.d(str2);
        }
        if (a(str)) {
            return str;
        }
        if ("application/mp4".equals(str)) {
            if ("stpp".equals(str2)) {
                return "application/ttml+xml";
            }
            if ("wvtt".equals(str2)) {
                return "application/x-mp4-vtt";
            }
        } else if ("application/x-rawcc".equals(str) && str2 != null) {
            if (str2.contains("cea708")) {
                return "application/cea-708";
            }
            if (str2.contains("eia608") || str2.contains("cea608")) {
                return "application/cea-608";
            }
        }
        return null;
    }

    private static boolean a(String str) {
        return com.google.android.exoplayer2.n.h.c(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private static String c(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.n.a.b(str.equals(str2));
        return str;
    }

    private static int a(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        com.google.android.exoplayer2.n.a.b(i == i2);
        return i;
    }

    protected static g b(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String b2 = b(xmlPullParser, "schemeIdUri", (String) null);
        String b3 = b(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) null);
        do {
            xmlPullParser.next();
        } while (!u.a(xmlPullParser, str));
        return new g(b2, b3);
    }

    protected static int a(List<g> list) {
        for (int i = 0; i < list.size(); i++) {
            g gVar = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(gVar.f11875a) && gVar.f11876b != null) {
                Matcher matcher = f11850b.matcher(gVar.f11876b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-608 channel number from: " + gVar.f11876b);
            }
        }
        return -1;
    }

    protected static int b(List<g> list) {
        for (int i = 0; i < list.size(); i++) {
            g gVar = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(gVar.f11875a) && gVar.f11876b != null) {
                Matcher matcher = f11851c.matcher(gVar.f11876b);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.w("MpdParser", "Unable to parse CEA-708 service block number from: " + gVar.f11876b);
            }
        }
        return -1;
    }

    protected static float a(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = f11849a.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        return !TextUtils.isEmpty(group) ? ((float) parseInt) / ((float) Integer.parseInt(group)) : (float) parseInt;
    }

    protected static long b(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return com.google.android.exoplayer2.n.t.e(attributeValue);
    }

    protected static long c(XmlPullParser xmlPullParser, String str, long j) throws ak {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        if (attributeValue == null) {
            return j;
        }
        return com.google.android.exoplayer2.n.t.f(attributeValue);
    }

    protected static String c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return s.b(str, xmlPullParser.getText());
    }

    protected static int a(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    protected static long d(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    protected static String b(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f11854a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11855b;

        /* renamed from: c  reason: collision with root package name */
        public final h f11856c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList<a.C0159a> f11857d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList<g> f11858e;

        public a(j jVar, String str, h hVar, ArrayList<a.C0159a> arrayList, ArrayList<g> arrayList2) {
            this.f11854a = jVar;
            this.f11855b = str;
            this.f11856c = hVar;
            this.f11857d = arrayList;
            this.f11858e = arrayList2;
        }
    }
}
