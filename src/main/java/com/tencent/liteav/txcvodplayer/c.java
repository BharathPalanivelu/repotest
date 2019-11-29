package com.tencent.liteav.txcvodplayer;

import android.view.View;
import java.lang.ref.WeakReference;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f32066a;

    /* renamed from: b  reason: collision with root package name */
    private int f32067b;

    /* renamed from: c  reason: collision with root package name */
    private int f32068c;

    /* renamed from: d  reason: collision with root package name */
    private int f32069d;

    /* renamed from: e  reason: collision with root package name */
    private int f32070e;

    /* renamed from: f  reason: collision with root package name */
    private int f32071f;

    /* renamed from: g  reason: collision with root package name */
    private int f32072g;
    private int h;
    private int i = 0;

    public c(View view) {
        this.f32066a = new WeakReference<>(view);
    }

    public void a(int i2, int i3) {
        this.f32067b = i2;
        this.f32068c = i3;
    }

    public void b(int i2, int i3) {
        this.f32069d = i2;
        this.f32070e = i3;
    }

    public void a(int i2) {
        this.f32071f = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ae, code lost:
        if (r4 != false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b1, code lost:
        if (r4 != false) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b3, code lost:
        r12 = (int) (r0 / r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b7, code lost:
        r11 = (int) (r3 * r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f7, code lost:
        if (r1 > r11) goto L_0x0117;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r11, int r12) {
        /*
            r10 = this;
            int r0 = r10.f32071f
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r0 == r2) goto L_0x000a
            if (r0 != r1) goto L_0x000d
        L_0x000a:
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x000d:
            int r0 = r10.f32067b
            int r0 = android.view.View.getDefaultSize(r0, r11)
            int r3 = r10.f32068c
            int r3 = android.view.View.getDefaultSize(r3, r12)
            int r4 = r10.i
            r5 = 3
            if (r4 != r5) goto L_0x0020
            goto L_0x0117
        L_0x0020:
            int r4 = r10.f32067b
            if (r4 <= 0) goto L_0x0115
            int r4 = r10.f32068c
            if (r4 <= 0) goto L_0x0115
            int r0 = android.view.View.MeasureSpec.getMode(r11)
            int r11 = android.view.View.MeasureSpec.getSize(r11)
            int r3 = android.view.View.MeasureSpec.getMode(r12)
            int r12 = android.view.View.MeasureSpec.getSize(r12)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r4) goto L_0x00bc
            if (r3 != r4) goto L_0x00bc
            float r0 = (float) r11
            float r3 = (float) r12
            float r4 = r0 / r3
            int r5 = r10.i
            r6 = 5
            r7 = 4
            if (r5 == r7) goto L_0x0070
            if (r5 == r6) goto L_0x005f
            int r1 = r10.f32067b
            float r1 = (float) r1
            int r2 = r10.f32068c
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r10.f32069d
            if (r2 <= 0) goto L_0x0080
            int r5 = r10.f32070e
            if (r5 <= 0) goto L_0x0080
            float r2 = (float) r2
            float r1 = r1 * r2
            float r2 = (float) r5
            float r1 = r1 / r2
            goto L_0x0080
        L_0x005f:
            r5 = 1068149419(0x3faaaaab, float:1.3333334)
            int r8 = r10.f32071f
            if (r8 == r2) goto L_0x006d
            if (r8 != r1) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            r1 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L_0x0080
        L_0x006d:
            r1 = 1061158912(0x3f400000, float:0.75)
            goto L_0x0080
        L_0x0070:
            r5 = 1071877689(0x3fe38e39, float:1.7777778)
            int r8 = r10.f32071f
            if (r8 == r2) goto L_0x007e
            if (r8 != r1) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            r1 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L_0x0080
        L_0x007e:
            r1 = 1058013184(0x3f100000, float:0.5625)
        L_0x0080:
            r2 = 1
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0087
            r4 = 1
            goto L_0x0088
        L_0x0087:
            r4 = 0
        L_0x0088:
            int r5 = r10.i
            if (r5 == 0) goto L_0x00b1
            if (r5 == r2) goto L_0x00ae
            if (r5 == r7) goto L_0x00b1
            if (r5 == r6) goto L_0x00b1
            if (r4 == 0) goto L_0x009f
            int r12 = r10.f32067b
            int r11 = java.lang.Math.min(r12, r11)
            float r12 = (float) r11
            float r12 = r12 / r1
            int r12 = (int) r12
            goto L_0x0117
        L_0x009f:
            int r11 = r10.f32068c
            int r11 = java.lang.Math.min(r11, r12)
            float r12 = (float) r11
            float r12 = r12 * r1
            int r12 = (int) r12
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x0117
        L_0x00ae:
            if (r4 == 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b1:
            if (r4 == 0) goto L_0x00b7
        L_0x00b3:
            float r0 = r0 / r1
            int r12 = (int) r0
            goto L_0x0117
        L_0x00b7:
            float r3 = r3 * r1
            int r11 = (int) r3
            goto L_0x0117
        L_0x00bc:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L_0x00dc
            if (r3 != r1) goto L_0x00dc
            int r0 = r10.f32067b
            int r1 = r0 * r12
            int r2 = r10.f32068c
            int r3 = r11 * r2
            if (r1 >= r3) goto L_0x00d1
            int r0 = r0 * r12
            int r11 = r0 / r2
            goto L_0x0117
        L_0x00d1:
            int r1 = r0 * r12
            int r3 = r11 * r2
            if (r1 <= r3) goto L_0x0117
            int r2 = r2 * r11
            int r12 = r2 / r0
            goto L_0x0117
        L_0x00dc:
            if (r0 != r1) goto L_0x00ec
            int r0 = r10.f32068c
            int r0 = r0 * r11
            int r1 = r10.f32067b
            int r0 = r0 / r1
            if (r3 != r4) goto L_0x00ea
            if (r0 <= r12) goto L_0x00ea
            goto L_0x0117
        L_0x00ea:
            r12 = r0
            goto L_0x0117
        L_0x00ec:
            if (r3 != r1) goto L_0x00fc
            int r1 = r10.f32067b
            int r1 = r1 * r12
            int r2 = r10.f32068c
            int r1 = r1 / r2
            if (r0 != r4) goto L_0x00fa
            if (r1 <= r11) goto L_0x00fa
            goto L_0x0117
        L_0x00fa:
            r11 = r1
            goto L_0x0117
        L_0x00fc:
            int r1 = r10.f32067b
            int r2 = r10.f32068c
            if (r3 != r4) goto L_0x0108
            if (r2 <= r12) goto L_0x0108
            int r1 = r1 * r12
            int r1 = r1 / r2
            goto L_0x0109
        L_0x0108:
            r12 = r2
        L_0x0109:
            if (r0 != r4) goto L_0x00fa
            if (r1 <= r11) goto L_0x00fa
            int r12 = r10.f32068c
            int r12 = r12 * r11
            int r0 = r10.f32067b
            int r12 = r12 / r0
            goto L_0x0117
        L_0x0115:
            r11 = r0
            r12 = r3
        L_0x0117:
            r10.f32072g = r11
            r10.h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.c.c(int, int):void");
    }

    public int a() {
        return this.f32072g;
    }

    public int b() {
        return this.h;
    }

    public void b(int i2) {
        this.i = i2;
    }
}
