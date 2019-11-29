package d.c;

class h extends g {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        d.c.b.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(java.io.File r2, byte[] r3) {
        /*
            java.lang.String r0 = "$this$writeBytes"
            d.d.b.j.b(r2, r0)
            java.lang.String r0 = "array"
            d.d.b.j.b(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r2)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ Throwable -> 0x0022 }
            r1.write(r3)     // Catch:{ Throwable -> 0x0022 }
            d.p r3 = d.p.f32714a     // Catch:{ Throwable -> 0x0022 }
            d.c.b.a(r0, r2)
            return
        L_0x0020:
            r3 = move-exception
            goto L_0x0024
        L_0x0022:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0020 }
        L_0x0024:
            d.c.b.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.c.h.a(java.io.File, byte[]):void");
    }
}
