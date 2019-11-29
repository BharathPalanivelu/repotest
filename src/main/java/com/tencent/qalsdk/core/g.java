package com.tencent.qalsdk.core;

import com.tencent.qalsdk.util.ALog;
import com.tencent.qalsdk.util.QLog;

final class g extends Thread {
    g() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r13) {
        /*
            r12 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r13)
            boolean r13 = r0.exists()
            r1 = 14
            r2 = 6
            r3 = 0
            if (r13 == 0) goto L_0x009d
            java.io.File[] r13 = r0.listFiles()
            if (r13 == 0) goto L_0x009c
            int r0 = r13.length
            if (r0 != 0) goto L_0x001a
            goto L_0x009c
        L_0x001a:
            com.tencent.qalsdk.core.h r0 = new com.tencent.qalsdk.core.h
            r0.<init>(r12)
            java.util.Arrays.sort(r13, r0)
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            r4 = 3
            java.lang.String r5 = qalsdk.a.a()     // Catch:{ Exception -> 0x0038 }
            if (r5 == 0) goto L_0x003c
            int r6 = r5.length()     // Catch:{ Exception -> 0x0038 }
            if (r6 <= 0) goto L_0x003c
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0038 }
            goto L_0x003d
        L_0x0038:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003c:
            r5 = 3
        L_0x003d:
            if (r5 <= 0) goto L_0x0043
            if (r5 <= r1) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r4 = r5
        L_0x0043:
            int r5 = r4 << 1
            int r4 = r4 - r5
            r0.add(r2, r4)
            long r4 = r0.getTimeInMillis()
            int r0 = r13.length
            r6 = 0
        L_0x004f:
            if (r6 >= r0) goto L_0x009d
            r7 = r13[r6]
            boolean r8 = com.tencent.qalsdk.util.QLog.isColorLevel()
            r9 = 2
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = com.tencent.qalsdk.core.e.f32177a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "found log file "
            r10.<init>(r11)
            java.lang.String r11 = r7.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.tencent.qalsdk.util.QLog.d(r8, r9, r10)
        L_0x0071:
            long r10 = r7.lastModified()
            int r8 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x0099
            r7.delete()
            boolean r8 = com.tencent.qalsdk.util.QLog.isColorLevel()
            if (r8 == 0) goto L_0x0099
            java.lang.String r8 = com.tencent.qalsdk.core.e.f32177a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "del expires log "
            r10.<init>(r11)
            java.lang.String r7 = r7.getName()
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            com.tencent.qalsdk.util.QLog.d(r8, r9, r7)
        L_0x0099:
            int r6 = r6 + 1
            goto L_0x004f
        L_0x009c:
            return
        L_0x009d:
            java.util.Calendar r13 = java.util.Calendar.getInstance()
            int r0 = r13.get(r2)
            int r0 = r0 + -7
            r13.set(r2, r0)
            r0 = 11
            r13.set(r0, r3)
            r0 = 12
            r13.set(r0, r3)
            r0 = 13
            r13.set(r0, r3)
            r13.set(r1, r3)
            r13.getTimeInMillis()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qalsdk.core.g.a(java.lang.String):void");
    }

    public final void run() {
        a(ALog.getFilePath());
        a(QLog.getFilePath());
    }
}
