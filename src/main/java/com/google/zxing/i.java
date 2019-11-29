package com.google.zxing;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;

final class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14762a = "i";

    /* renamed from: b  reason: collision with root package name */
    private final BBQRScannerControl f14763b;

    /* renamed from: c  reason: collision with root package name */
    private final o f14764c = new o();

    /* renamed from: d  reason: collision with root package name */
    private boolean f14765d = true;

    i(BBQRScannerControl bBQRScannerControl, Map<j, Object> map) {
        this.f14764c.a((Map<j, ?>) map);
        this.f14763b = bBQRScannerControl;
    }

    public void handleMessage(Message message) {
        if (this.f14765d) {
            int i = message.what;
            if (i == 10) {
                a((byte[]) message.obj, message.arg1, message.arg2);
            } else if (i == 12) {
                this.f14765d = false;
                Looper.myLooper().quit();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(byte[] r12, int r13, int r14) {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.google.zxing.BBQRScannerControl r2 = r11.f14763b
            int r2 = r2.getOrientation()
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0016
            com.google.zxing.BBQRScannerControl r2 = r11.f14763b
            int r2 = r2.getOrientation()
            if (r2 != r3) goto L_0x0036
        L_0x0016:
            int r2 = r12.length
            byte[] r2 = new byte[r2]
            r5 = 0
            r6 = 0
        L_0x001b:
            if (r6 >= r14) goto L_0x0032
            r7 = 0
        L_0x001e:
            if (r7 >= r13) goto L_0x002f
            int r8 = r7 * r14
            int r8 = r8 + r14
            int r8 = r8 - r6
            int r8 = r8 - r4
            int r9 = r6 * r13
            int r9 = r9 + r7
            byte r9 = r12[r9]
            r2[r8] = r9
            int r7 = r7 + 1
            goto L_0x001e
        L_0x002f:
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0032:
            r12 = r2
            r10 = r14
            r14 = r13
            r13 = r10
        L_0x0036:
            com.google.zxing.BBQRScannerControl r2 = r11.f14763b
            com.google.zxing.b.c r2 = r2.getCameraManager()
            com.google.zxing.n r12 = r2.a(r12, r13, r14)
            if (r12 == 0) goto L_0x0064
            com.google.zxing.e r13 = new com.google.zxing.e
            com.google.zxing.c.j r14 = new com.google.zxing.c.j
            r14.<init>(r12)
            r13.<init>(r14)
            com.google.zxing.o r12 = r11.f14764c     // Catch:{ v -> 0x005f, all -> 0x0058 }
            com.google.zxing.w r12 = r12.a((com.google.zxing.e) r13)     // Catch:{ v -> 0x005f, all -> 0x0058 }
            com.google.zxing.o r13 = r11.f14764c
            r13.a()
            goto L_0x0065
        L_0x0058:
            r12 = move-exception
            com.google.zxing.o r13 = r11.f14764c
            r13.a()
            throw r12
        L_0x005f:
            com.google.zxing.o r12 = r11.f14764c
            r12.a()
        L_0x0064:
            r12 = 0
        L_0x0065:
            com.google.zxing.BBQRScannerControl r13 = r11.f14763b
            android.os.Handler r13 = r13.getDecodeHandler()
            if (r12 == 0) goto L_0x009f
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r14 = f14762a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Found barcode in "
            r5.append(r6)
            long r2 = r2 - r0
            r5.append(r2)
            java.lang.String r0 = " ms"
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.util.Log.d(r14, r0)
            if (r13 == 0) goto L_0x00a8
            android.os.Message r12 = android.os.Message.obtain(r13, r4, r12)
            android.os.Bundle r13 = new android.os.Bundle
            r13.<init>()
            r12.setData(r13)
            r12.sendToTarget()
            goto L_0x00a8
        L_0x009f:
            if (r13 == 0) goto L_0x00a8
            android.os.Message r12 = android.os.Message.obtain(r13, r3)
            r12.sendToTarget()
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.i.a(byte[], int, int):void");
    }
}
