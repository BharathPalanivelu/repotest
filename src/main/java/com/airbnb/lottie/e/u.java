package com.airbnb.lottie.e;

class u {
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0088, code lost:
        if (r0.equals("a") != false) goto L_0x008c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.c.b.g a(android.util.JsonReader r10, com.airbnb.lottie.d r11) throws java.io.IOException {
        /*
            r10.beginObject()
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0006:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L_0x00c2
            java.lang.String r3 = r10.nextName()
            int r4 = r3.hashCode()
            r5 = 111(0x6f, float:1.56E-43)
            r6 = 0
            r7 = -1
            r8 = 2
            r9 = 1
            if (r4 == r5) goto L_0x003a
            r5 = 3588(0xe04, float:5.028E-42)
            if (r4 == r5) goto L_0x0030
            r5 = 3357091(0x3339a3, float:4.704286E-39)
            if (r4 == r5) goto L_0x0026
            goto L_0x0044
        L_0x0026:
            java.lang.String r4 = "mode"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0044
            r4 = 0
            goto L_0x0045
        L_0x0030:
            java.lang.String r4 = "pt"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0044
            r4 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r4 = "o"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0044
            r4 = 2
            goto L_0x0045
        L_0x0044:
            r4 = -1
        L_0x0045:
            if (r4 == 0) goto L_0x0059
            if (r4 == r9) goto L_0x0054
            if (r4 == r8) goto L_0x004f
            r10.skipValue()
            goto L_0x0006
        L_0x004f:
            com.airbnb.lottie.c.a.d r2 = com.airbnb.lottie.e.d.b(r10, r11)
            goto L_0x0006
        L_0x0054:
            com.airbnb.lottie.c.a.h r1 = com.airbnb.lottie.e.d.e(r10, r11)
            goto L_0x0006
        L_0x0059:
            java.lang.String r0 = r10.nextString()
            int r4 = r0.hashCode()
            r5 = 97
            if (r4 == r5) goto L_0x0082
            r5 = 105(0x69, float:1.47E-43)
            if (r4 == r5) goto L_0x0078
            r5 = 115(0x73, float:1.61E-43)
            if (r4 == r5) goto L_0x006e
            goto L_0x008b
        L_0x006e:
            java.lang.String r4 = "s"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x008b
            r6 = 1
            goto L_0x008c
        L_0x0078:
            java.lang.String r4 = "i"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x008b
            r6 = 2
            goto L_0x008c
        L_0x0082:
            java.lang.String r4 = "a"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r6 = -1
        L_0x008c:
            if (r6 == 0) goto L_0x00be
            if (r6 == r9) goto L_0x00ba
            if (r6 == r8) goto L_0x00b1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Unknown mask mode "
            r0.append(r4)
            r0.append(r3)
            java.lang.String r3 = ". Defaulting to Add."
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "LOTTIE"
            android.util.Log.w(r3, r0)
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.c.b.g.a.MaskModeAdd
            goto L_0x0006
        L_0x00b1:
            java.lang.String r0 = "Animation contains intersect masks. They are not supported but will be treated like add masks."
            r11.a((java.lang.String) r0)
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.c.b.g.a.MaskModeIntersect
            goto L_0x0006
        L_0x00ba:
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.c.b.g.a.MaskModeSubtract
            goto L_0x0006
        L_0x00be:
            com.airbnb.lottie.c.b.g$a r0 = com.airbnb.lottie.c.b.g.a.MaskModeAdd
            goto L_0x0006
        L_0x00c2:
            r10.endObject()
            com.airbnb.lottie.c.b.g r10 = new com.airbnb.lottie.c.b.g
            r10.<init>(r0, r1, r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.u.a(android.util.JsonReader, com.airbnb.lottie.d):com.airbnb.lottie.c.b.g");
    }
}
