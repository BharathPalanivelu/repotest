package com.tencent.liteav;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.b;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final String f31654a = "TXCVodPlayCollection";

    /* renamed from: b  reason: collision with root package name */
    private Context f31655b;

    /* renamed from: c  reason: collision with root package name */
    private String f31656c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f31657d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f31658e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31659f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f31660g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m;
    private String n;
    private boolean o = false;
    private boolean p = false;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v;
    private int w;
    private int x;
    private String y;

    public j(Context context) {
        this.f31655b = context;
        this.n = TXCCommonUtil.getAppVersion();
    }

    public void a(String str) {
        this.f31656c = str;
    }

    public String a() {
        Context context = this.f31655b;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i2 = applicationInfo.labelRes;
        return i2 == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i2);
    }

    private void m() {
        String str;
        long j2;
        String e2 = b.e();
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f31656c;
        TXCDRApi.InitEvent(this.f31655b, e2, a.ad, a.as, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_timeuse", (long) this.h);
        TXCDRApi.txSetEventValue(e2, a.ad, "str_stream_url", this.f31656c);
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_videotime", (long) this.f31660g);
        TXCDRApi.txSetEventValue(e2, a.ad, "str_device_type", b.c());
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_network_type", (long) b.d(this.f31655b));
        TXCDRApi.txSetEventValue(e2, a.ad, "str_user_id", b.b(this.f31655b));
        TXCDRApi.txSetEventValue(e2, a.ad, "str_package_name", b.c(this.f31655b));
        TXCDRApi.txSetEventValue(e2, a.ad, "str_app_version", this.n);
        TXCDRApi.txSetEventValue(e2, a.ad, "dev_uuid", b.e(this.f31655b));
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_first_i_frame", (long) this.i);
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_isp2p", (long) this.j);
        int i2 = a.ad;
        int i3 = this.k;
        TXCDRApi.txSetEventIntValue(e2, i2, "u32_avg_load", i3 == 0 ? 0 : (long) (this.l / i3));
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_load_cnt", (long) this.k);
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_max_load", (long) this.m);
        TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_player_type", (long) this.r);
        TXCDRApi.txSetEventValue(e2, a.ad, "str_app_name", a());
        if (this.t > 0) {
            str = "u32_videotime";
            TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_dns_time", (long) this.t);
        } else {
            str = "u32_videotime";
            TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_dns_time", -1);
        }
        if (this.s > 0) {
            TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_tcp_did_connect", (long) this.s);
            j2 = -1;
        } else {
            j2 = -1;
            TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_tcp_did_connect", -1);
        }
        if (this.u > 0) {
            TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_first_video_packet", (long) this.u);
        } else {
            TXCDRApi.txSetEventIntValue(e2, a.ad, "u32_first_video_packet", j2);
        }
        TXCDRApi.txSetEventValue(e2, a.ad, "u32_server_ip", this.y);
        TXCDRApi.nativeReportEvent(e2, a.ad);
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40301: token=");
        sb.append(e2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_timeuse");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.h);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_stream_url");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31656c);
        sb.append(SQLBuilder.BLANK);
        sb.append(str);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31660g);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_device_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b.c());
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_network_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b.d(this.f31655b));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_user_id");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b.b(this.f31655b));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_package_name");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b.c(this.f31655b));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_app_version");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.n);
        sb.append(SQLBuilder.BLANK);
        sb.append("dev_uuid");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b.e(this.f31655b));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_first_i_frame");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.i);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_isp2p");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.j);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_avg_load");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        int i4 = this.k;
        sb.append(i4 == 0 ? 0 : this.l / i4);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_load_cnt");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.k);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_max_load");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.m);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_player_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.r);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_dns_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.t);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_tcp_did_connect");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.s);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_first_video_packet");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.u);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_server_ip");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.y);
        TXCLog.w("TXCVodPlayCollection", sb.toString());
    }

    public void a(int i2) {
        this.f31660g = i2;
    }

    public void b() {
        this.f31659f = true;
        this.f31657d = System.currentTimeMillis();
    }

    public void c() {
        if (this.f31659f) {
            this.h = (int) ((System.currentTimeMillis() - this.f31657d) / 1000);
            m();
            this.f31659f = false;
        }
        this.o = false;
        this.p = false;
    }

    public void d() {
        if (this.i != 0 && this.p) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.f31658e);
            this.l += currentTimeMillis;
            this.k++;
            if (this.m < currentTimeMillis) {
                this.m = currentTimeMillis;
            }
            this.p = false;
        }
        if (this.o) {
            this.o = false;
        }
    }

    public void e() {
        if (this.i == 0) {
            this.i = (int) (System.currentTimeMillis() - this.f31657d);
        }
    }

    public void f() {
        if (this.s == 0) {
            this.s = (int) (System.currentTimeMillis() - this.f31657d);
        }
    }

    public void g() {
        if (this.t == 0) {
            this.t = (int) (System.currentTimeMillis() - this.f31657d);
        }
    }

    public void h() {
        if (this.u == 0) {
            this.u = (int) (System.currentTimeMillis() - this.f31657d);
        }
    }

    public void i() {
        this.f31658e = System.currentTimeMillis();
        this.p = true;
    }

    public void j() {
        this.o = true;
        this.q++;
        TXCDRApi.txReportDAU(this.f31655b, a.bv);
    }

    public void b(int i2) {
        this.r = i2;
    }

    public void a(boolean z) {
        if (z) {
            this.v = 1;
            TXCDRApi.txReportDAU(this.f31655b, a.bx);
            return;
        }
        this.v = 0;
    }

    public void k() {
        this.x++;
        TXCDRApi.txReportDAU(this.f31655b, a.by);
    }

    public void l() {
        this.w++;
        TXCDRApi.txReportDAU(this.f31655b, a.bw);
    }

    public void b(String str) {
        this.y = str;
    }
}
