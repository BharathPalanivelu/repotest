package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.util.b;
import java.util.regex.Pattern;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private Context f31843a;

    /* renamed from: b  reason: collision with root package name */
    private String f31844b;

    /* renamed from: c  reason: collision with root package name */
    private String f31845c;

    /* renamed from: d  reason: collision with root package name */
    private String f31846d;

    /* renamed from: e  reason: collision with root package name */
    private String f31847e;

    /* renamed from: f  reason: collision with root package name */
    private long f31848f;

    /* renamed from: g  reason: collision with root package name */
    private long f31849g;
    private String h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private boolean w = true;

    public n(Context context) {
        this.f31843a = context.getApplicationContext();
        this.f31844b = b.b(this.f31843a);
        this.f31846d = "Android";
        m.a().a(this.f31843a);
        a();
    }

    public void a() {
        this.f31845c = "";
        this.f31848f = 0;
        this.f31849g = -1;
        this.h = "";
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.f31847e = "";
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = true;
    }

    private void e() {
        long j2 = this.p;
        long j3 = this.q;
        a();
        this.n = j2;
        this.o = j3;
    }

    public void b() {
        this.f31848f = System.currentTimeMillis();
        this.f31845c = m.a().b();
    }

    public void c() {
        f();
        e();
    }

    public void a(boolean z) {
        this.l = z ? 2 : 1;
        if (z) {
            this.w = false;
        }
    }

    public void a(String str) {
        this.f31847e = str;
    }

    public void a(boolean z, String str) {
        this.h = str;
        if (z) {
            this.f31849g = 1;
        } else if (str != null) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            if (str != null) {
                for (String c2 : str.split("[.]")) {
                    if (!c(c2)) {
                        this.f31849g = 3;
                        return;
                    }
                }
                this.f31849g = 2;
            }
        }
    }

    public void a(long j2, long j3, long j4) {
        this.i = j2;
        this.j = j3;
        this.k = j4;
    }

    public void d() {
        this.m++;
    }

    public void a(long j2, long j3) {
        this.p = j2;
        this.q = j3;
    }

    public void b(long j2, long j3) {
        this.v++;
        this.r += j2;
        this.s += j3;
        if (j2 > this.t) {
            this.t = j2;
        }
        if (j3 > this.u) {
            this.u = j3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f() {
        /*
            r21 = this;
            r0 = r21
            long r1 = r0.f31848f
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0171
            java.lang.String r1 = r0.f31844b
            boolean r1 = r0.b(r1)
            if (r1 != 0) goto L_0x0171
            java.lang.String r1 = r0.f31847e
            boolean r1 = r0.b(r1)
            if (r1 == 0) goto L_0x001c
            goto L_0x0171
        L_0x001c:
            java.lang.String r1 = r0.f31847e
            java.lang.String r1 = com.tencent.liteav.basic.util.TXCCommonUtil.getStreamIDByStreamUrl(r1)
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.f31848f
            long r13 = r5 - r7
            long r5 = r0.p
            long r7 = r0.n
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0034
            long r5 = r5 - r7
            goto L_0x0035
        L_0x0034:
            r5 = r3
        L_0x0035:
            long r7 = r0.q
            long r9 = r0.o
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x003f
            long r7 = r7 - r9
            goto L_0x0040
        L_0x003f:
            r7 = r3
        L_0x0040:
            long r9 = r0.v
            int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x004d
            long r11 = r0.r
            long r11 = r11 / r9
            long r3 = r0.s
            long r3 = r3 / r9
            goto L_0x0051
        L_0x004d:
            r3 = 0
            r11 = 0
        L_0x0051:
            java.lang.String r2 = com.tencent.liteav.basic.datareport.TXCDRApi.txCreateToken()
            com.tencent.liteav.basic.datareport.TXCDRExtInfo r9 = new com.tencent.liteav.basic.datareport.TXCDRExtInfo
            r9.<init>()
            r10 = 0
            r9.report_common = r10
            r9.report_status = r10
            java.lang.String r10 = r0.f31847e
            r9.url = r10
            android.content.Context r10 = r0.f31843a
            int r15 = com.tencent.liteav.basic.datareport.a.T
            r19 = r3
            int r3 = com.tencent.liteav.basic.datareport.a.al
            com.tencent.liteav.basic.datareport.TXCDRApi.InitEvent(r10, r2, r15, r3, r9)
            int r3 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r4 = r0.f31844b
            java.lang.String r9 = "str_user_id"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventValue(r2, r3, r9, r4)
            int r3 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r4 = "str_stream_id"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventValue(r2, r3, r4, r1)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = r0.f31845c
            java.lang.String r4 = "str_access_id"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventValue(r2, r1, r4, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = r0.f31846d
            java.lang.String r4 = "str_platform"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventValue(r2, r1, r4, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.f31849g
            java.lang.String r9 = "u32_server_type"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r9, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = r0.h
            java.lang.String r4 = "str_server_addr"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventValue(r2, r1, r4, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.i
            java.lang.String r9 = "u32_dns_timecost"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r9, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.j
            java.lang.String r9 = "u32_connect_timecost"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r9, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.k
            java.lang.String r9 = "u32_handshake_timecost"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r9, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.l
            java.lang.String r9 = "u32_push_type"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r9, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = "u32_totaltime"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r3, r13)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.m
            java.lang.String r9 = "u32_block_count"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r9, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = "u32_video_drop"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r3, r5)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = "u32_audio_drop"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r3, r7)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = "u32_video_que_avg"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r3, r11)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            java.lang.String r3 = "u32_audio_que_avg"
            r4 = r19
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r3, r4)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.t
            java.lang.String r5 = "u32_video_que_max"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r5, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            long r3 = r0.u
            java.lang.String r5 = "u32_audio_que_max"
            com.tencent.liteav.basic.datareport.TXCDRApi.txSetEventIntValue(r2, r1, r5, r3)
            int r1 = com.tencent.liteav.basic.datareport.a.T
            com.tencent.liteav.basic.datareport.TXCDRApi.nativeReportEvent(r2, r1)
            r1 = 0
            r2 = 0
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0124
            long r4 = r0.m
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0119
            goto L_0x0124
        L_0x0119:
            float r4 = (float) r4
            r5 = 1198153728(0x476a6000, float:60000.0)
            float r4 = r4 * r5
            float r5 = (float) r13
            float r4 = r4 / r5
            r17 = r4
            goto L_0x0126
        L_0x0124:
            r17 = 0
        L_0x0126:
            long r4 = r0.v
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x014b
            long r6 = r0.r
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x0134
            r4 = 0
            goto L_0x0138
        L_0x0134:
            float r6 = (float) r6
            float r4 = (float) r4
            float r4 = r6 / r4
        L_0x0138:
            long r5 = r0.s
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0141
            r18 = r4
            goto L_0x014d
        L_0x0141:
            float r1 = (float) r5
            long r2 = r0.v
            float r2 = (float) r2
            float r1 = r1 / r2
            r19 = r1
            r18 = r4
            goto L_0x014f
        L_0x014b:
            r18 = 0
        L_0x014d:
            r19 = 0
        L_0x014f:
            boolean r1 = r0.w
            if (r1 == 0) goto L_0x0171
            java.lang.String r1 = r0.f31845c
            boolean r1 = r0.b(r1)
            if (r1 != 0) goto L_0x0171
            long r1 = r0.k
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0171
            com.tencent.liteav.network.m r9 = com.tencent.liteav.network.m.a()
            java.lang.String r10 = r0.f31845c
            long r11 = r0.f31849g
            long r1 = r0.k
            r15 = r1
            r9.a(r10, r11, r13, r15, r17, r18, r19)
        L_0x0171:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.network.n.f():void");
    }

    private boolean b(String str) {
        return str == null || str.length() == 0;
    }

    private boolean c(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
