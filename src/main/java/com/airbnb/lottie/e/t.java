package com.airbnb.lottie.e;

import android.util.JsonReader;
import androidx.b.h;
import com.airbnb.lottie.c;
import com.airbnb.lottie.c.c.d;
import com.airbnb.lottie.d;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class t {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.airbnb.lottie.d a(android.util.JsonReader r26) throws java.io.IOException {
        /*
            r0 = r26
            float r1 = com.airbnb.lottie.f.f.a()
            androidx.b.d r8 = new androidx.b.d
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            androidx.b.h r11 = new androidx.b.h
            r11.<init>()
            com.airbnb.lottie.d r13 = new com.airbnb.lottie.d
            r13.<init>()
            r26.beginObject()
            r2 = 0
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r14 = 0
        L_0x0032:
            boolean r15 = r26.hasNext()
            if (r15 == 0) goto L_0x0131
            java.lang.String r15 = r26.nextName()
            r16 = -1
            int r17 = r15.hashCode()
            r18 = 2
            r19 = 1
            switch(r17) {
                case -1408207997: goto L_0x00a7;
                case -1109732030: goto L_0x009d;
                case 104: goto L_0x0093;
                case 118: goto L_0x0089;
                case 119: goto L_0x007f;
                case 3276: goto L_0x0075;
                case 3367: goto L_0x006b;
                case 3553: goto L_0x0061;
                case 94623709: goto L_0x0056;
                case 97615364: goto L_0x004b;
                default: goto L_0x0049;
            }
        L_0x0049:
            goto L_0x00b1
        L_0x004b:
            java.lang.String r3 = "fonts"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 8
            goto L_0x00b2
        L_0x0056:
            java.lang.String r3 = "chars"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 9
            goto L_0x00b2
        L_0x0061:
            java.lang.String r3 = "op"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 3
            goto L_0x00b2
        L_0x006b:
            java.lang.String r3 = "ip"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 2
            goto L_0x00b2
        L_0x0075:
            java.lang.String r3 = "fr"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 4
            goto L_0x00b2
        L_0x007f:
            java.lang.String r3 = "w"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 0
            goto L_0x00b2
        L_0x0089:
            java.lang.String r3 = "v"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 5
            goto L_0x00b2
        L_0x0093:
            java.lang.String r3 = "h"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 1
            goto L_0x00b2
        L_0x009d:
            java.lang.String r3 = "layers"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 6
            goto L_0x00b2
        L_0x00a7:
            java.lang.String r3 = "assets"
            boolean r3 = r15.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 7
            goto L_0x00b2
        L_0x00b1:
            r3 = -1
        L_0x00b2:
            switch(r3) {
                case 0: goto L_0x0125;
                case 1: goto L_0x011c;
                case 2: goto L_0x0113;
                case 3: goto L_0x0105;
                case 4: goto L_0x00fc;
                case 5: goto L_0x00cd;
                case 6: goto L_0x00c9;
                case 7: goto L_0x00c5;
                case 8: goto L_0x00c1;
                case 9: goto L_0x00bd;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            r16 = r11
            r15 = r12
            r26.skipValue()
            goto L_0x012c
        L_0x00bd:
            a(r0, r13, r11)
            goto L_0x0101
        L_0x00c1:
            a(r0, r12)
            goto L_0x0101
        L_0x00c5:
            a((android.util.JsonReader) r0, (com.airbnb.lottie.d) r13, (java.util.Map<java.lang.String, java.util.List<com.airbnb.lottie.c.c.d>>) r9, (java.util.Map<java.lang.String, com.airbnb.lottie.g>) r10)
            goto L_0x0101
        L_0x00c9:
            a((android.util.JsonReader) r0, (com.airbnb.lottie.d) r13, (java.util.List<com.airbnb.lottie.c.c.d>) r7, (androidx.b.d<com.airbnb.lottie.c.c.d>) r8)
            goto L_0x0101
        L_0x00cd:
            java.lang.String r3 = r26.nextString()
            java.lang.String r15 = "\\."
            java.lang.String[] r3 = r3.split(r15)
            r15 = 0
            r16 = r3[r15]
            int r20 = java.lang.Integer.parseInt(r16)
            r15 = r3[r19]
            int r21 = java.lang.Integer.parseInt(r15)
            r3 = r3[r18]
            int r22 = java.lang.Integer.parseInt(r3)
            r23 = 4
            r24 = 4
            r25 = 0
            boolean r3 = com.airbnb.lottie.f.f.a(r20, r21, r22, r23, r24, r25)
            if (r3 != 0) goto L_0x0101
            java.lang.String r3 = "Lottie only supports bodymovin >= 4.4.0"
            r13.a((java.lang.String) r3)
            goto L_0x0101
        L_0x00fc:
            double r14 = r26.nextDouble()
            float r14 = (float) r14
        L_0x0101:
            r16 = r11
            r15 = r12
            goto L_0x012c
        L_0x0105:
            r16 = r11
            r15 = r12
            double r11 = r26.nextDouble()
            float r3 = (float) r11
            r6 = 1008981770(0x3c23d70a, float:0.01)
            float r6 = r3 - r6
            goto L_0x012c
        L_0x0113:
            r16 = r11
            r15 = r12
            double r11 = r26.nextDouble()
            float r5 = (float) r11
            goto L_0x012c
        L_0x011c:
            r16 = r11
            r15 = r12
            int r3 = r26.nextInt()
            r4 = r3
            goto L_0x012c
        L_0x0125:
            r16 = r11
            r15 = r12
            int r2 = r26.nextInt()
        L_0x012c:
            r12 = r15
            r11 = r16
            goto L_0x0032
        L_0x0131:
            r16 = r11
            r15 = r12
            r26.endObject()
            float r0 = (float) r2
            float r0 = r0 * r1
            int r0 = (int) r0
            float r2 = (float) r4
            float r2 = r2 * r1
            int r1 = (int) r2
            android.graphics.Rect r3 = new android.graphics.Rect
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            r2 = r13
            r4 = r5
            r5 = r6
            r6 = r14
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.t.a(android.util.JsonReader):com.airbnb.lottie.d");
    }

    private static void a(JsonReader jsonReader, d dVar, List<com.airbnb.lottie.c.c.d> list, androidx.b.d<com.airbnb.lottie.c.c.d> dVar2) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.c.c.d a2 = s.a(jsonReader, dVar);
            if (a2.k() == d.a.Image) {
                i++;
            }
            list.add(a2);
            dVar2.b(a2.e(), a2);
            if (i > 4) {
                c.b("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, com.airbnb.lottie.d dVar, Map<String, List<com.airbnb.lottie.c.c.d>> map, Map<String, g> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            androidx.b.d dVar2 = new androidx.b.d();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -1109732030) {
                    if (hashCode != 104) {
                        if (hashCode != 112) {
                            if (hashCode != 117) {
                                if (hashCode != 119) {
                                    if (hashCode == 3355 && nextName.equals("id")) {
                                        c2 = 0;
                                    }
                                } else if (nextName.equals("w")) {
                                    c2 = 2;
                                }
                            } else if (nextName.equals("u")) {
                                c2 = 5;
                            }
                        } else if (nextName.equals("p")) {
                            c2 = 4;
                        }
                    } else if (nextName.equals("h")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("layers")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    str = jsonReader.nextString();
                } else if (c2 == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.airbnb.lottie.c.c.d a2 = s.a(jsonReader, dVar);
                        dVar2.b(a2.e(), a2);
                        arrayList.add(a2);
                    }
                    jsonReader.endArray();
                } else if (c2 == 2) {
                    i = jsonReader.nextInt();
                } else if (c2 == 3) {
                    i2 = jsonReader.nextInt();
                } else if (c2 == 4) {
                    str2 = jsonReader.nextString();
                } else if (c2 != 5) {
                    jsonReader.skipValue();
                } else {
                    str3 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                g gVar = new g(i, i2, str, str2, str3);
                map2.put(gVar.a(), gVar);
                Map<String, List<com.airbnb.lottie.c.c.d>> map3 = map;
            } else {
                Map<String, g> map4 = map2;
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void a(JsonReader jsonReader, Map<String, com.airbnb.lottie.c.c> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 3322014 && nextName.equals("list")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.airbnb.lottie.c.c a2 = k.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void a(JsonReader jsonReader, com.airbnb.lottie.d dVar, h<com.airbnb.lottie.c.d> hVar) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.airbnb.lottie.c.d a2 = j.a(jsonReader, dVar);
            hVar.b(a2.hashCode(), a2);
        }
        jsonReader.endArray();
    }
}
