package com.airbnb.lottie.e;

import android.graphics.Rect;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.j;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.a.l;
import com.airbnb.lottie.c.c.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Collections;
import java.util.List;

public class s {
    public static d a(com.airbnb.lottie.d dVar) {
        Rect b2 = dVar.b();
        List emptyList = Collections.emptyList();
        d.a aVar = d.a.PreComp;
        List emptyList2 = Collections.emptyList();
        l lVar = r4;
        l lVar2 = new l();
        return new d(emptyList, dVar, "__container", -1, aVar, -1, (String) null, emptyList2, lVar, 0, 0, 0, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, b2.width(), b2.height(), (j) null, (k) null, Collections.emptyList(), d.b.None, (b) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0270  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.c.c.d a(android.util.JsonReader r38, com.airbnb.lottie.d r39) throws java.io.IOException {
        /*
            r7 = r39
            com.airbnb.lottie.c.c.d$b r0 = com.airbnb.lottie.c.c.d.b.None
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r38.beginObject()
            r1 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r9 = java.lang.Float.valueOf(r1)
            r2 = 0
            r11 = 0
            java.lang.Float r12 = java.lang.Float.valueOf(r11)
            r3 = 0
            java.lang.String r4 = "UNSET"
            r5 = 0
            r13 = -1
            r28 = r0
            r16 = r2
            r17 = r16
            r29 = r17
            r30 = r29
            r31 = r30
            r32 = r31
            r18 = r5
            r25 = r13
            r0 = 0
            r1 = 0
            r15 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r27 = 0
            r14 = r32
            r13 = r4
        L_0x0049:
            boolean r2 = r38.hasNext()
            if (r2 == 0) goto L_0x032c
            java.lang.String r2 = r38.nextName()
            int r4 = r2.hashCode()
            java.lang.String r5 = "nm"
            r6 = 1
            r33 = -1
            switch(r4) {
                case -995424086: goto L_0x014c;
                case -903568142: goto L_0x0141;
                case 104: goto L_0x0136;
                case 116: goto L_0x012b;
                case 119: goto L_0x0120;
                case 3177: goto L_0x0115;
                case 3233: goto L_0x010a;
                case 3367: goto L_0x00ff;
                case 3432: goto L_0x00f4;
                case 3519: goto L_0x00eb;
                case 3553: goto L_0x00df;
                case 3664: goto L_0x00d4;
                case 3669: goto L_0x00c9;
                case 3679: goto L_0x00bd;
                case 3681: goto L_0x00b1;
                case 3684: goto L_0x00a6;
                case 3705: goto L_0x009a;
                case 3712: goto L_0x008e;
                case 3717: goto L_0x0083;
                case 104415: goto L_0x0078;
                case 108390670: goto L_0x006d;
                case 1441620890: goto L_0x0061;
                default: goto L_0x005f;
            }
        L_0x005f:
            goto L_0x0156
        L_0x0061:
            java.lang.String r4 = "masksProperties"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 10
            goto L_0x0157
        L_0x006d:
            java.lang.String r4 = "refId"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 2
            goto L_0x0157
        L_0x0078:
            java.lang.String r4 = "ind"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 1
            goto L_0x0157
        L_0x0083:
            java.lang.String r4 = "ty"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 3
            goto L_0x0157
        L_0x008e:
            java.lang.String r4 = "tt"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 9
            goto L_0x0157
        L_0x009a:
            java.lang.String r4 = "tm"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 20
            goto L_0x0157
        L_0x00a6:
            java.lang.String r4 = "sw"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 5
            goto L_0x0157
        L_0x00b1:
            java.lang.String r4 = "st"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 15
            goto L_0x0157
        L_0x00bd:
            java.lang.String r4 = "sr"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 14
            goto L_0x0157
        L_0x00c9:
            java.lang.String r4 = "sh"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 6
            goto L_0x0157
        L_0x00d4:
            java.lang.String r4 = "sc"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 7
            goto L_0x0157
        L_0x00df:
            java.lang.String r4 = "op"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 19
            goto L_0x0157
        L_0x00eb:
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0156
            r2 = 0
            goto L_0x0157
        L_0x00f4:
            java.lang.String r4 = "ks"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 8
            goto L_0x0157
        L_0x00ff:
            java.lang.String r4 = "ip"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 18
            goto L_0x0157
        L_0x010a:
            java.lang.String r4 = "ef"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 13
            goto L_0x0157
        L_0x0115:
            java.lang.String r4 = "cl"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 21
            goto L_0x0157
        L_0x0120:
            java.lang.String r4 = "w"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 16
            goto L_0x0157
        L_0x012b:
            java.lang.String r4 = "t"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 12
            goto L_0x0157
        L_0x0136:
            java.lang.String r4 = "h"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 17
            goto L_0x0157
        L_0x0141:
            java.lang.String r4 = "shapes"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 11
            goto L_0x0157
        L_0x014c:
            java.lang.String r4 = "parent"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0156
            r2 = 4
            goto L_0x0157
        L_0x0156:
            r2 = -1
        L_0x0157:
            switch(r2) {
                case 0: goto L_0x0322;
                case 1: goto L_0x0318;
                case 2: goto L_0x0311;
                case 3: goto L_0x02f9;
                case 4: goto L_0x02ef;
                case 5: goto L_0x02de;
                case 6: goto L_0x02cd;
                case 7: goto L_0x02c2;
                case 8: goto L_0x02ba;
                case 9: goto L_0x02ac;
                case 10: goto L_0x0294;
                case 11: goto L_0x027a;
                case 12: goto L_0x021a;
                case 13: goto L_0x01bc;
                case 14: goto L_0x01b3;
                case 15: goto L_0x01a8;
                case 16: goto L_0x0196;
                case 17: goto L_0x0184;
                case 18: goto L_0x017b;
                case 19: goto L_0x0172;
                case 20: goto L_0x016a;
                case 21: goto L_0x0161;
                default: goto L_0x015a;
            }
        L_0x015a:
            r2 = r38
            r38.skipValue()
            goto L_0x0328
        L_0x0161:
            java.lang.String r2 = r38.nextString()
            r14 = r2
            r2 = r38
            goto L_0x0328
        L_0x016a:
            r2 = r38
            com.airbnb.lottie.c.a.b r32 = com.airbnb.lottie.e.d.a((android.util.JsonReader) r2, (com.airbnb.lottie.d) r7, (boolean) r3)
            goto L_0x0328
        L_0x0172:
            r2 = r38
            double r4 = r38.nextDouble()
            float r1 = (float) r4
            goto L_0x0328
        L_0x017b:
            r2 = r38
            double r4 = r38.nextDouble()
            float r0 = (float) r4
            goto L_0x0328
        L_0x0184:
            r2 = r38
            int r4 = r38.nextInt()
            float r4 = (float) r4
            float r5 = com.airbnb.lottie.f.f.a()
            float r4 = r4 * r5
            int r4 = (int) r4
            r24 = r4
            goto L_0x0328
        L_0x0196:
            r2 = r38
            int r4 = r38.nextInt()
            float r4 = (float) r4
            float r5 = com.airbnb.lottie.f.f.a()
            float r4 = r4 * r5
            int r4 = (int) r4
            r23 = r4
            goto L_0x0328
        L_0x01a8:
            r2 = r38
            double r4 = r38.nextDouble()
            float r4 = (float) r4
            r27 = r4
            goto L_0x0328
        L_0x01b3:
            r2 = r38
            double r4 = r38.nextDouble()
            float r15 = (float) r4
            goto L_0x0328
        L_0x01bc:
            r2 = r38
            r38.beginArray()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x01c6:
            boolean r6 = r38.hasNext()
            if (r6 == 0) goto L_0x0201
            r38.beginObject()
        L_0x01cf:
            boolean r6 = r38.hasNext()
            if (r6 == 0) goto L_0x01fb
            java.lang.String r6 = r38.nextName()
            int r3 = r6.hashCode()
            r11 = 3519(0xdbf, float:4.931E-42)
            if (r3 == r11) goto L_0x01e2
            goto L_0x01ea
        L_0x01e2:
            boolean r3 = r6.equals(r5)
            if (r3 == 0) goto L_0x01ea
            r3 = 0
            goto L_0x01eb
        L_0x01ea:
            r3 = -1
        L_0x01eb:
            if (r3 == 0) goto L_0x01f1
            r38.skipValue()
            goto L_0x01f8
        L_0x01f1:
            java.lang.String r3 = r38.nextString()
            r4.add(r3)
        L_0x01f8:
            r3 = 0
            r11 = 0
            goto L_0x01cf
        L_0x01fb:
            r38.endObject()
            r3 = 0
            r11 = 0
            goto L_0x01c6
        L_0x0201:
            r38.endArray()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.a((java.lang.String) r3)
            goto L_0x0328
        L_0x021a:
            r2 = r38
            r38.beginObject()
        L_0x021f:
            boolean r3 = r38.hasNext()
            if (r3 == 0) goto L_0x0275
            java.lang.String r3 = r38.nextName()
            int r4 = r3.hashCode()
            r5 = 97
            if (r4 == r5) goto L_0x0240
            r5 = 100
            if (r4 == r5) goto L_0x0236
            goto L_0x024a
        L_0x0236:
            java.lang.String r4 = "d"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x024a
            r3 = 0
            goto L_0x024b
        L_0x0240:
            java.lang.String r4 = "a"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x024a
            r3 = 1
            goto L_0x024b
        L_0x024a:
            r3 = -1
        L_0x024b:
            if (r3 == 0) goto L_0x0270
            if (r3 == r6) goto L_0x0253
            r38.skipValue()
            goto L_0x021f
        L_0x0253:
            r38.beginArray()
            boolean r3 = r38.hasNext()
            if (r3 == 0) goto L_0x0262
            com.airbnb.lottie.c.a.k r3 = com.airbnb.lottie.e.b.a(r38, r39)
            r31 = r3
        L_0x0262:
            boolean r3 = r38.hasNext()
            if (r3 == 0) goto L_0x026c
            r38.skipValue()
            goto L_0x0262
        L_0x026c:
            r38.endArray()
            goto L_0x021f
        L_0x0270:
            com.airbnb.lottie.c.a.j r30 = com.airbnb.lottie.e.d.f(r38, r39)
            goto L_0x021f
        L_0x0275:
            r38.endObject()
            goto L_0x0328
        L_0x027a:
            r2 = r38
            r38.beginArray()
        L_0x027f:
            boolean r3 = r38.hasNext()
            if (r3 == 0) goto L_0x028f
            com.airbnb.lottie.c.b.b r3 = com.airbnb.lottie.e.g.a(r38, r39)
            if (r3 == 0) goto L_0x027f
            r8.add(r3)
            goto L_0x027f
        L_0x028f:
            r38.endArray()
            goto L_0x0328
        L_0x0294:
            r2 = r38
            r38.beginArray()
        L_0x0299:
            boolean r3 = r38.hasNext()
            if (r3 == 0) goto L_0x02a7
            com.airbnb.lottie.c.b.g r3 = com.airbnb.lottie.e.u.a(r38, r39)
            r10.add(r3)
            goto L_0x0299
        L_0x02a7:
            r38.endArray()
            goto L_0x0328
        L_0x02ac:
            r2 = r38
            com.airbnb.lottie.c.c.d$b[] r3 = com.airbnb.lottie.c.c.d.b.values()
            int r4 = r38.nextInt()
            r28 = r3[r4]
            goto L_0x0328
        L_0x02ba:
            r2 = r38
            com.airbnb.lottie.c.a.l r29 = com.airbnb.lottie.e.c.a(r38, r39)
            goto L_0x0328
        L_0x02c2:
            r2 = r38
            java.lang.String r3 = r38.nextString()
            int r22 = android.graphics.Color.parseColor(r3)
            goto L_0x0328
        L_0x02cd:
            r2 = r38
            int r3 = r38.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.f.f.a()
            float r3 = r3 * r4
            int r3 = (int) r3
            r21 = r3
            goto L_0x0328
        L_0x02de:
            r2 = r38
            int r3 = r38.nextInt()
            float r3 = (float) r3
            float r4 = com.airbnb.lottie.f.f.a()
            float r3 = r3 * r4
            int r3 = (int) r3
            r20 = r3
            goto L_0x0328
        L_0x02ef:
            r2 = r38
            int r3 = r38.nextInt()
            long r3 = (long) r3
            r25 = r3
            goto L_0x0328
        L_0x02f9:
            r2 = r38
            int r3 = r38.nextInt()
            com.airbnb.lottie.c.c.d$a r4 = com.airbnb.lottie.c.c.d.a.Unknown
            int r4 = r4.ordinal()
            if (r3 >= r4) goto L_0x030e
            com.airbnb.lottie.c.c.d$a[] r4 = com.airbnb.lottie.c.c.d.a.values()
            r16 = r4[r3]
            goto L_0x0328
        L_0x030e:
            com.airbnb.lottie.c.c.d$a r16 = com.airbnb.lottie.c.c.d.a.Unknown
            goto L_0x0328
        L_0x0311:
            r2 = r38
            java.lang.String r17 = r38.nextString()
            goto L_0x0328
        L_0x0318:
            r2 = r38
            int r3 = r38.nextInt()
            long r3 = (long) r3
            r18 = r3
            goto L_0x0328
        L_0x0322:
            r2 = r38
            java.lang.String r13 = r38.nextString()
        L_0x0328:
            r3 = 0
            r11 = 0
            goto L_0x0049
        L_0x032c:
            r2 = r38
            r38.endObject()
            float r11 = r0 / r15
            float r33 = r1 / r15
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0 = 0
            int r1 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x035f
            com.airbnb.lottie.g.a r5 = new com.airbnb.lottie.g.a
            r4 = 0
            r34 = 0
            java.lang.Float r36 = java.lang.Float.valueOf(r11)
            r0 = r5
            r1 = r39
            r2 = r12
            r3 = r12
            r37 = r5
            r5 = r34
            r34 = r15
            r15 = r6
            r6 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = r37
            r15.add(r0)
            goto L_0x0362
        L_0x035f:
            r34 = r15
            r15 = r6
        L_0x0362:
            r0 = 0
            int r0 = (r33 > r0 ? 1 : (r33 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0368
            goto L_0x036e
        L_0x0368:
            float r0 = r39.e()
            r33 = r0
        L_0x036e:
            com.airbnb.lottie.g.a r6 = new com.airbnb.lottie.g.a
            r4 = 0
            java.lang.Float r35 = java.lang.Float.valueOf(r33)
            r0 = r6
            r1 = r39
            r2 = r9
            r3 = r9
            r5 = r11
            r9 = r6
            r6 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r9)
            com.airbnb.lottie.g.a r9 = new com.airbnb.lottie.g.a
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
            java.lang.Float r6 = java.lang.Float.valueOf(r0)
            r0 = r9
            r2 = r12
            r3 = r12
            r5 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r15.add(r9)
            java.lang.String r0 = ".ai"
            boolean r0 = r13.endsWith(r0)
            if (r0 != 0) goto L_0x03a8
            java.lang.String r0 = "ai"
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x03ad
        L_0x03a8:
            java.lang.String r0 = "Convert your Illustrator layers to shape layers."
            r7.a((java.lang.String) r0)
        L_0x03ad:
            com.airbnb.lottie.c.c.d r33 = new com.airbnb.lottie.c.c.d
            r0 = r33
            r1 = r8
            r2 = r39
            r3 = r13
            r4 = r18
            r6 = r16
            r7 = r25
            r9 = r17
            r11 = r29
            r12 = r20
            r13 = r21
            r14 = r22
            r21 = r15
            r15 = r34
            r16 = r27
            r17 = r23
            r18 = r24
            r19 = r30
            r20 = r31
            r22 = r28
            r23 = r32
            r0.<init>(r1, r2, r3, r4, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.s.a(android.util.JsonReader, com.airbnb.lottie.d):com.airbnb.lottie.c.c.d");
    }
}
