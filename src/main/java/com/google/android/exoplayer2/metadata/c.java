package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;

public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f10835a = new c() {
        public boolean a(Format format) {
            String str = format.f8958f;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.metadata.a b(com.google.android.exoplayer2.Format r5) {
            /*
                r4 = this;
                java.lang.String r5 = r5.f8958f
                int r0 = r5.hashCode()
                r1 = -1248341703(0xffffffffb597d139, float:-1.1311269E-6)
                r2 = 2
                r3 = 1
                if (r0 == r1) goto L_0x002c
                r1 = 1154383568(0x44ce7ed0, float:1651.9629)
                if (r0 == r1) goto L_0x0022
                r1 = 1652648887(0x62816bb7, float:1.1936958E21)
                if (r0 == r1) goto L_0x0018
                goto L_0x0036
            L_0x0018:
                java.lang.String r0 = "application/x-scte35"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0036
                r5 = 2
                goto L_0x0037
            L_0x0022:
                java.lang.String r0 = "application/x-emsg"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0036
                r5 = 1
                goto L_0x0037
            L_0x002c:
                java.lang.String r0 = "application/id3"
                boolean r5 = r5.equals(r0)
                if (r5 == 0) goto L_0x0036
                r5 = 0
                goto L_0x0037
            L_0x0036:
                r5 = -1
            L_0x0037:
                if (r5 == 0) goto L_0x0051
                if (r5 == r3) goto L_0x004b
                if (r5 != r2) goto L_0x0043
                com.google.android.exoplayer2.metadata.scte35.a r5 = new com.google.android.exoplayer2.metadata.scte35.a
                r5.<init>()
                return r5
            L_0x0043:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Attempted to create decoder for unsupported format"
                r5.<init>(r0)
                throw r5
            L_0x004b:
                com.google.android.exoplayer2.metadata.emsg.a r5 = new com.google.android.exoplayer2.metadata.emsg.a
                r5.<init>()
                return r5
            L_0x0051:
                com.google.android.exoplayer2.metadata.id3.a r5 = new com.google.android.exoplayer2.metadata.id3.a
                r5.<init>()
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.c.AnonymousClass1.b(com.google.android.exoplayer2.Format):com.google.android.exoplayer2.metadata.a");
        }
    };

    boolean a(Format format);

    a b(Format format);
}
