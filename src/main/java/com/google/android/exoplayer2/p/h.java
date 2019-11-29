package com.google.android.exoplayer2.p;

import com.google.android.exoplayer2.Format;

public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f11225a = new h() {
        public boolean a(Format format) {
            String str = format.f8958f;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.p.f b(com.google.android.exoplayer2.Format r3) {
            /*
                r2 = this;
                java.lang.String r0 = r3.f8958f
                int r1 = r0.hashCode()
                switch(r1) {
                    case -1351681404: goto L_0x0066;
                    case -1026075066: goto L_0x005c;
                    case -1004728940: goto L_0x0052;
                    case 691401887: goto L_0x0048;
                    case 822864842: goto L_0x003e;
                    case 930165504: goto L_0x0034;
                    case 1566015601: goto L_0x002a;
                    case 1566016562: goto L_0x001f;
                    case 1668750253: goto L_0x0015;
                    case 1693976202: goto L_0x000b;
                    default: goto L_0x0009;
                }
            L_0x0009:
                goto L_0x0071
            L_0x000b:
                java.lang.String r1 = "application/ttml+xml"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 3
                goto L_0x0072
            L_0x0015:
                java.lang.String r1 = "application/x-subrip"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 4
                goto L_0x0072
            L_0x001f:
                java.lang.String r1 = "application/cea-708"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 8
                goto L_0x0072
            L_0x002a:
                java.lang.String r1 = "application/cea-608"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 6
                goto L_0x0072
            L_0x0034:
                java.lang.String r1 = "application/x-mp4-cea-608"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 7
                goto L_0x0072
            L_0x003e:
                java.lang.String r1 = "text/x-ssa"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 1
                goto L_0x0072
            L_0x0048:
                java.lang.String r1 = "application/x-quicktime-tx3g"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 5
                goto L_0x0072
            L_0x0052:
                java.lang.String r1 = "text/vtt"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 0
                goto L_0x0072
            L_0x005c:
                java.lang.String r1 = "application/x-mp4-vtt"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 2
                goto L_0x0072
            L_0x0066:
                java.lang.String r1 = "application/dvbsubs"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0071
                r0 = 9
                goto L_0x0072
            L_0x0071:
                r0 = -1
            L_0x0072:
                switch(r0) {
                    case 0: goto L_0x00b9;
                    case 1: goto L_0x00b1;
                    case 2: goto L_0x00ab;
                    case 3: goto L_0x00a5;
                    case 4: goto L_0x009f;
                    case 5: goto L_0x0097;
                    case 6: goto L_0x008d;
                    case 7: goto L_0x008d;
                    case 8: goto L_0x0085;
                    case 9: goto L_0x007d;
                    default: goto L_0x0075;
                }
            L_0x0075:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Attempted to create decoder for unsupported format"
                r3.<init>(r0)
                throw r3
            L_0x007d:
                com.google.android.exoplayer2.p.b.a r0 = new com.google.android.exoplayer2.p.b.a
                java.util.List<byte[]> r3 = r3.h
                r0.<init>(r3)
                return r0
            L_0x0085:
                com.google.android.exoplayer2.p.a.c r0 = new com.google.android.exoplayer2.p.a.c
                int r3 = r3.z
                r0.<init>(r3)
                return r0
            L_0x008d:
                com.google.android.exoplayer2.p.a.a r0 = new com.google.android.exoplayer2.p.a.a
                java.lang.String r1 = r3.f8958f
                int r3 = r3.z
                r0.<init>(r1, r3)
                return r0
            L_0x0097:
                com.google.android.exoplayer2.p.f.a r0 = new com.google.android.exoplayer2.p.f.a
                java.util.List<byte[]> r3 = r3.h
                r0.<init>(r3)
                return r0
            L_0x009f:
                com.google.android.exoplayer2.p.d.a r3 = new com.google.android.exoplayer2.p.d.a
                r3.<init>()
                return r3
            L_0x00a5:
                com.google.android.exoplayer2.p.e.a r3 = new com.google.android.exoplayer2.p.e.a
                r3.<init>()
                return r3
            L_0x00ab:
                com.google.android.exoplayer2.p.g.b r3 = new com.google.android.exoplayer2.p.g.b
                r3.<init>()
                return r3
            L_0x00b1:
                com.google.android.exoplayer2.p.c.a r0 = new com.google.android.exoplayer2.p.c.a
                java.util.List<byte[]> r3 = r3.h
                r0.<init>(r3)
                return r0
            L_0x00b9:
                com.google.android.exoplayer2.p.g.g r3 = new com.google.android.exoplayer2.p.g.g
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.h.AnonymousClass1.b(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.p.f");
        }
    };

    boolean a(Format format);

    f b(Format format);
}
