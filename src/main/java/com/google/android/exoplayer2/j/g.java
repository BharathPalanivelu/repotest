package com.google.android.exoplayer2.j;

import com.google.android.exoplayer2.j;

public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f10620a = new g() {
        public boolean a(j jVar) {
            String str = jVar.f10427f;
            return "text/vtt".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.j.e b(com.google.android.exoplayer2.j r3) {
            /*
                r2 = this;
                java.lang.String r0 = r3.f10427f
                int r1 = r0.hashCode()
                switch(r1) {
                    case -1351681404: goto L_0x005a;
                    case -1026075066: goto L_0x0050;
                    case -1004728940: goto L_0x0046;
                    case 691401887: goto L_0x003c;
                    case 930165504: goto L_0x0032;
                    case 1566015601: goto L_0x0028;
                    case 1566016562: goto L_0x001e;
                    case 1668750253: goto L_0x0014;
                    case 1693976202: goto L_0x000a;
                    default: goto L_0x0009;
                }
            L_0x0009:
                goto L_0x0065
            L_0x000a:
                java.lang.String r1 = "application/ttml+xml"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 2
                goto L_0x0066
            L_0x0014:
                java.lang.String r1 = "application/x-subrip"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 3
                goto L_0x0066
            L_0x001e:
                java.lang.String r1 = "application/cea-708"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 7
                goto L_0x0066
            L_0x0028:
                java.lang.String r1 = "application/cea-608"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 5
                goto L_0x0066
            L_0x0032:
                java.lang.String r1 = "application/x-mp4-cea-608"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 6
                goto L_0x0066
            L_0x003c:
                java.lang.String r1 = "application/x-quicktime-tx3g"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 4
                goto L_0x0066
            L_0x0046:
                java.lang.String r1 = "text/vtt"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 0
                goto L_0x0066
            L_0x0050:
                java.lang.String r1 = "application/x-mp4-vtt"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 1
                goto L_0x0066
            L_0x005a:
                java.lang.String r1 = "application/dvbsubs"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0065
                r0 = 8
                goto L_0x0066
            L_0x0065:
                r0 = -1
            L_0x0066:
                switch(r0) {
                    case 0: goto L_0x00a5;
                    case 1: goto L_0x009f;
                    case 2: goto L_0x0099;
                    case 3: goto L_0x0093;
                    case 4: goto L_0x008b;
                    case 5: goto L_0x0081;
                    case 6: goto L_0x0081;
                    case 7: goto L_0x0079;
                    case 8: goto L_0x0071;
                    default: goto L_0x0069;
                }
            L_0x0069:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Attempted to create decoder for unsupported format"
                r3.<init>(r0)
                throw r3
            L_0x0071:
                com.google.android.exoplayer2.j.b.a r0 = new com.google.android.exoplayer2.j.b.a
                java.util.List<byte[]> r3 = r3.h
                r0.<init>(r3)
                return r0
            L_0x0079:
                com.google.android.exoplayer2.j.a.c r0 = new com.google.android.exoplayer2.j.a.c
                int r3 = r3.z
                r0.<init>(r3)
                return r0
            L_0x0081:
                com.google.android.exoplayer2.j.a.a r0 = new com.google.android.exoplayer2.j.a.a
                java.lang.String r1 = r3.f10427f
                int r3 = r3.z
                r0.<init>(r1, r3)
                return r0
            L_0x008b:
                com.google.android.exoplayer2.j.e.a r0 = new com.google.android.exoplayer2.j.e.a
                java.util.List<byte[]> r3 = r3.h
                r0.<init>(r3)
                return r0
            L_0x0093:
                com.google.android.exoplayer2.j.c.a r3 = new com.google.android.exoplayer2.j.c.a
                r3.<init>()
                return r3
            L_0x0099:
                com.google.android.exoplayer2.j.d.a r3 = new com.google.android.exoplayer2.j.d.a
                r3.<init>()
                return r3
            L_0x009f:
                com.google.android.exoplayer2.j.f.b r3 = new com.google.android.exoplayer2.j.f.b
                r3.<init>()
                return r3
            L_0x00a5:
                com.google.android.exoplayer2.j.f.g r3 = new com.google.android.exoplayer2.j.f.g
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.j.g.AnonymousClass1.b(com.google.android.exoplayer2.j):com.google.android.exoplayer2.j.e");
        }
    };

    boolean a(j jVar);

    e b(j jVar);
}
