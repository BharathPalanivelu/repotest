package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.garena.android.gpns.utility.CONSTANT;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f31594a = "TXCDataReport";
    /* access modifiers changed from: private */
    public static HashMap<String, a> w = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f31595b = new HashMap(100);

    /* renamed from: c  reason: collision with root package name */
    private String f31596c;

    /* renamed from: d  reason: collision with root package name */
    private int f31597d;

    /* renamed from: e  reason: collision with root package name */
    private int f31598e;

    /* renamed from: f  reason: collision with root package name */
    private int f31599f;

    /* renamed from: g  reason: collision with root package name */
    private int f31600g;
    private Context h;
    private String i;
    private long j;
    private int k;
    private long l;
    private boolean m;
    private long n;
    private int o;
    private boolean p = false;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private String v;
    private String x = "";

    enum a {
        PENDING,
        CONFIRM,
        NEGATIVE
    }

    public d(Context context) {
        this.h = context.getApplicationContext();
        this.i = TXCCommonUtil.getAppVersion();
        this.o = 5000;
        this.u = 0;
    }

    public void a() {
        r();
        this.l = -1;
        this.q = System.currentTimeMillis();
    }

    public void b() {
        if (this.m) {
            p();
            return;
        }
        String str = f31594a;
        TXCLog.e(str, "push " + this.f31596c + " failed!");
        n();
    }

    public void c() {
        if (!this.m) {
            String str = f31594a;
            TXCLog.e(str, "play " + this.f31596c + " failed");
            if (this.p) {
                b(false);
            } else {
                j();
            }
        } else if (this.p) {
            s();
        } else {
            k();
        }
        if (this.p) {
            m();
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void a(String str) {
        this.f31596c = str;
        b(str);
    }

    public void b(String str) {
        if (str != null) {
            this.v = str;
        }
    }

    /* access modifiers changed from: protected */
    public a d() {
        try {
            Uri parse = Uri.parse(this.v);
            if (parse == null) {
                return a.PENDING;
            }
            final String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                return a.PENDING;
            }
            String scheme = parse.getScheme();
            if (scheme == null) {
                return a.PENDING;
            }
            if (!scheme.equals("rtmp") && !scheme.equals("http") && !scheme.equals("https")) {
                return a.PENDING;
            }
            if (c(host)) {
                return a.CONFIRM;
            }
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && (queryParameterNames.contains("bizid") || queryParameterNames.contains("txTime") || queryParameterNames.contains("txSecret"))) {
                return a.CONFIRM;
            }
            if (w.containsKey(host)) {
                return w.get(host);
            }
            w.put(host, a.PENDING);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        e[] a2 = com.tencent.liteav.network.a.a.a.c().a(new b(host, true), (com.tencent.liteav.network.a.d) null);
                        int length = a2.length;
                        boolean z = false;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            e eVar = a2[i];
                            if (eVar.a() && d.c(eVar.f31744a)) {
                                z = true;
                                break;
                            }
                            i++;
                        }
                        d.w.put(host, z ? a.CONFIRM : a.NEGATIVE);
                        String h = d.f31594a;
                        TXCLog.d(h, host + " isTencent " + z);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
            return a.PENDING;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected static boolean c(String str) {
        if (str == null || !str.contains("myqcloud")) {
            return com.tencent.liteav.basic.e.b.a().a(str);
        }
        return true;
    }

    public void d(String str) {
        this.x = str;
    }

    public void a(int i2, int i3) {
        this.f31597d = i2;
        this.f31598e = i3;
    }

    public void a(int i2) {
        this.f31599f = i2;
    }

    public void b(int i2) {
        this.f31600g = i2;
    }

    public void e() {
        if (!this.m && !TextUtils.isEmpty(TXCStatus.b(this.x, 7012))) {
            o();
            this.m = true;
        }
        if (this.n <= 0) {
            this.n = TXCTimeUtil.getTimeTick();
        }
        if (this.m && TXCTimeUtil.getTimeTick() - this.n > 5000) {
            q();
            this.n = TXCTimeUtil.getTimeTick();
        }
    }

    public void f() {
        if (!this.m) {
            long a2 = TXCStatus.a(this.x, BaseConstants.ERR_PARSE_RESPONSE_FAILED);
            long a3 = TXCStatus.a(this.x, 7104);
            if (!(a2 == 0 && a3 == 0)) {
                if (this.p) {
                    b(true);
                } else {
                    i();
                }
                this.o = 5000;
                this.m = true;
            }
            String b2 = TXCStatus.b(this.x, 7119);
            if (b2 != null) {
                b(b2);
            }
        }
        if (this.n <= 0) {
            this.n = TXCTimeUtil.getTimeTick();
        }
        if (this.m && TXCTimeUtil.getTimeTick() > this.n + ((long) this.o)) {
            if (this.p) {
                t();
                this.o = 5000;
            } else if (d() != a.NEGATIVE) {
                l();
                this.o = TXCDRApi.getStatusReportInterval();
                if (this.o < 5000) {
                    this.o = 5000;
                }
                if (this.o > 300000) {
                    this.o = CONSTANT.TIME.MIN_5;
                }
            } else {
                return;
            }
            this.l = TXCStatus.a(this.x, BaseConstants.ERR_INVALID_CONVERSATION);
            this.n = TXCTimeUtil.getTimeTick();
        }
    }

    private void i() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.U, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_network_type", (long) e("u32_network_type"));
        long a2 = TXCStatus.a(this.x, 7107);
        long a3 = TXCStatus.a(this.x, 7108);
        if (a3 != -1) {
            a3 -= a2;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_dns_time", a3);
        String b2 = TXCStatus.b(this.x, 7110);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_server_ip", b2);
        long a4 = TXCStatus.a(this.x, 7109);
        String str2 = "u32_server_ip";
        if (a4 != -1) {
            a4 -= a2;
        }
        long j2 = a4;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_connect_server_time", j2);
        long j3 = a3;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_stream_begin", -1);
        this.j = TXCStatus.a(this.x, BaseConstants.ERR_PARSE_RESPONSE_FAILED) - a2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_i_frame", this.j);
        long a5 = TXCStatus.a(this.x, 7103) - a2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_frame_down", a5);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_user_id", (String) this.f31595b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_package_name", (String) this.f31595b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.U);
        String str3 = f31594a;
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40101: token=");
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(utcTimeTick);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_device_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get("str_device_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_network_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(e("u32_network_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_dns_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j3);
        sb.append(SQLBuilder.BLANK);
        sb.append(str2);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_connect_server_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_stream_begin");
        sb.append("=-1 ");
        sb.append("u32_first_i_frame");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.j);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_first_frame_down");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a5);
        sb.append(SQLBuilder.BLANK);
        String str4 = "str_user_id";
        sb.append(str4);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str4));
        sb.append(SQLBuilder.BLANK);
        String str5 = "str_package_name";
        sb.append(str5);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str5));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_app_version");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.i);
        sb.append(SQLBuilder.BLANK);
        sb.append("dev_uuid");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get("dev_uuid"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_isp2p");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.k);
        TXCLog.d(str3, sb.toString());
    }

    private void j() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.U, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_dns_time", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_stream_begin", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_i_frame", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_first_frame_down", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_user_id", (String) this.f31595b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_package_name", (String) this.f31595b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.U, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.U, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.U);
        String str2 = f31594a;
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40101: token=");
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(utcTimeTick);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_device_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get("str_device_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_network_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(e("u32_network_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_dns_time");
        sb.append("=-1 ");
        sb.append("u32_server_ip");
        sb.append("= ");
        sb.append("u32_connect_server_time");
        sb.append("=-1 ");
        sb.append("u32_stream_begin");
        sb.append("=-1 ");
        sb.append("u32_first_i_frame");
        sb.append("=-1 ");
        sb.append("u32_first_frame_down");
        sb.append("=-1 ");
        sb.append("str_user_id");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get("str_user_id"));
        sb.append(SQLBuilder.BLANK);
        String str3 = "str_package_name";
        sb.append(str3);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str3));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_app_version");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.i);
        sb.append(SQLBuilder.BLANK);
        String str4 = "dev_uuid";
        sb.append(str4);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str4));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_isp2p");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.k);
        TXCLog.d(str2, sb.toString());
    }

    private void k() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.W, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u64_timestamp", utcTimeTick);
        long timeTick = (TXCTimeUtil.getTimeTick() - TXCStatus.a(this.x, 7107)) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_result", timeTick);
        long a2 = TXCStatus.a(this.x, BaseConstants.ERR_NO_SUCC_RESULT);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_avg_block_time", a2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.W, "str_app_version", this.i);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_isp2p", (long) this.k);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_avg_load", TXCStatus.a(this.x, 2001));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_load_cnt", TXCStatus.a(this.x, 2002));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_max_load", TXCStatus.a(this.x, 2003));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_first_i_frame", this.j);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_speed_cnt", TXCStatus.a(this.x, 2004));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_nodata_cnt", TXCStatus.a(this.x, 2005));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_avg_cache_time", TXCStatus.a(this.x, 2008));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.W, "u32_is_real_time", TXCStatus.a(this.x, 2009));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.W);
        String str2 = f31594a;
        TXCLog.d(str2, "report evt 40102: token=" + str + SQLBuilder.BLANK + "str_stream_url" + SimpleComparison.EQUAL_TO_OPERATION + this.f31596c + SQLBuilder.BLANK + "u64_timestamp" + SimpleComparison.EQUAL_TO_OPERATION + utcTimeTick + SQLBuilder.BLANK + "u32_result" + SimpleComparison.EQUAL_TO_OPERATION + timeTick + SQLBuilder.BLANK + "u32_avg_block_time" + SimpleComparison.EQUAL_TO_OPERATION + a2 + SQLBuilder.BLANK + "str_app_version" + SimpleComparison.EQUAL_TO_OPERATION + this.i + SQLBuilder.BLANK + "u32_isp2p" + SimpleComparison.EQUAL_TO_OPERATION + this.k + SQLBuilder.BLANK + "u32_avg_load" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2001) + SQLBuilder.BLANK + "u32_load_cnt" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2002) + SQLBuilder.BLANK + "u32_max_load" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2003) + SQLBuilder.BLANK + "u32_first_i_frame" + SimpleComparison.EQUAL_TO_OPERATION + this.j + SQLBuilder.BLANK + "u32_speed_cnt" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2004) + SQLBuilder.BLANK + "u32_nodata_cnt" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2005) + SQLBuilder.BLANK + "u32_avg_cache_time" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2008) + SQLBuilder.BLANK + "u32_is_real_time" + SimpleComparison.EQUAL_TO_OPERATION + TXCStatus.a(this.x, 2009));
    }

    private void l() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.V, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_net_speed", (long) (TXCStatus.c(this.x, 7102) + TXCStatus.c(this.x, 7101)));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_fps", (long) ((int) TXCStatus.d(this.x, BaseConstants.ERR_SERIALIZE_REQ_FAILED)));
        long a2 = TXCStatus.a(this.x, BaseConstants.ERR_INVALID_CONVERSATION);
        long j2 = this.l;
        if (j2 == -1) {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_block_count", 0);
        } else if (a2 >= j2) {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_block_count", a2 - this.l);
        } else {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_block_count", 0);
        }
        this.l = a2;
        int[] a3 = com.tencent.liteav.basic.util.b.a();
        int b2 = com.tencent.liteav.basic.util.b.b();
        long a4 = TXCStatus.a(this.x, BaseConstants.ERR_FILE_TRANS_UPLOAD_FAILED);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_avg_cache_count", a4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_cpu_usage", (long) a3[1]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_app_cpu_usage", (long) a3[0]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_app_mem_usage", (long) b2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.V, "str_app_version", this.i);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.V, "u32_isp2p", (long) this.k);
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.V);
        if (this.p) {
            this.t++;
            this.s += a4;
            if (a4 > this.r) {
                this.r = a4;
            }
        }
    }

    private void m() {
        HashMap hashMap = new HashMap();
        String b2 = TXCStatus.b(this.x, 7116);
        String b3 = TXCStatus.b(this.x, 7117);
        String b4 = TXCStatus.b(this.x, 7118);
        int c2 = TXCStatus.c(this.x, 7105);
        String b5 = TXCStatus.b(this.x, 7106);
        int c3 = TXCStatus.c(this.x, 7111);
        hashMap.put("stream_url", b2);
        hashMap.put("stream_id", b3);
        hashMap.put("bizid", b4);
        hashMap.put("err_code", String.valueOf(c2));
        hashMap.put("err_info", b5);
        hashMap.put("channel_type", String.valueOf(c3));
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.q;
        hashMap.put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.q)));
        hashMap.put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(currentTimeMillis)));
        hashMap.put("total_time", String.valueOf(j2));
        long a2 = TXCStatus.a(this.x, BaseConstants.ERR_NO_SUCC_RESULT);
        long a3 = TXCStatus.a(this.x, BaseConstants.ERR_FILE_TRANS_AUTH_FAILED);
        long a4 = TXCStatus.a(this.x, BaseConstants.ERR_LOADMSG_FAILED);
        long j3 = a2 != 0 ? a3 / a2 : 0;
        hashMap.put("block_count", String.valueOf(a2));
        hashMap.put("block_duration_max", String.valueOf(a4));
        hashMap.put("block_duration_avg", String.valueOf(j3));
        long j4 = this.t;
        long j5 = j4 != 0 ? this.s / j4 : 0;
        hashMap.put("jitter_cache_max", String.valueOf(this.r));
        hashMap.put("jitter_cache_avg", String.valueOf(j5));
        String txCreateToken = TXCDRApi.txCreateToken();
        int i2 = com.tencent.liteav.basic.datareport.a.af;
        int i3 = com.tencent.liteav.basic.datareport.a.al;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.h, txCreateToken, i2, i3, tXCDRExtInfo);
        String str = f31594a;
        TXCLog.d(str, "report evt 40402: token=" + txCreateToken);
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            String str4 = f31594a;
            TXCLog.e(str4, "RealTimePlayStatisticInfo: " + str2 + " = " + str3);
            if (!(str2 == null || str2.length() <= 0 || str3 == null)) {
                TXCDRApi.txSetEventValue(txCreateToken, i2, str2, str3);
            }
        }
        TXCDRApi.nativeReportEvent(txCreateToken, i2);
        this.p = false;
        this.q = 0;
        this.t = 0;
        this.s = 0;
        this.r = 0;
    }

    private void n() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f31596c;
        long a2 = TXCStatus.a(this.x, 7013);
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_dns_time", -1);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_connect_server_time", -1);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_server_ip", "");
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_resolution", (long) ((this.f31597d << 16) | this.f31598e));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_audio_samplerate", (long) this.f31600g);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_bitrate", (long) this.f31599f);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_user_id", (String) this.f31595b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_package_name", (String) this.f31595b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_channel_type", a2);
        long j2 = a2;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.P);
        String str2 = f31594a;
        TXCLog.d(str2, "report evt 40001: token=" + str + SQLBuilder.BLANK + "str_stream_url" + SimpleComparison.EQUAL_TO_OPERATION + this.f31596c + SQLBuilder.BLANK + "u64_timestamp" + SimpleComparison.EQUAL_TO_OPERATION + utcTimeTick + SQLBuilder.BLANK + "str_device_type" + SimpleComparison.EQUAL_TO_OPERATION + this.f31595b.get("str_device_type") + SQLBuilder.BLANK + "u32_network_type" + SimpleComparison.EQUAL_TO_OPERATION + e("u32_network_type") + SQLBuilder.BLANK + "u32_dns_time" + "=-1 " + "u32_connect_server_time" + "=-1 " + "u32_server_ip" + "= " + "u32_video_resolution" + SimpleComparison.EQUAL_TO_OPERATION + ((this.f31597d << 16) | this.f31598e) + SQLBuilder.BLANK + "u32_audio_samplerate" + SimpleComparison.EQUAL_TO_OPERATION + this.f31600g + SQLBuilder.BLANK + "u32_video_bitrate" + SimpleComparison.EQUAL_TO_OPERATION + this.f31599f + SQLBuilder.BLANK + "str_user_id" + SimpleComparison.EQUAL_TO_OPERATION + this.f31595b.get("str_user_id") + SQLBuilder.BLANK + "str_package_name" + SimpleComparison.EQUAL_TO_OPERATION + this.f31595b.get("str_package_name") + SQLBuilder.BLANK + "u32_channel_type" + SimpleComparison.EQUAL_TO_OPERATION + j2 + SQLBuilder.BLANK + "str_app_version" + SimpleComparison.EQUAL_TO_OPERATION + this.f31595b.get("dev_uuid") + SQLBuilder.BLANK + "dev_uuid" + SimpleComparison.EQUAL_TO_OPERATION + e("u32_max_load"));
    }

    private void o() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f31596c;
        String b2 = TXCStatus.b(this.x, 7012);
        long a2 = TXCStatus.a(this.x, 7009);
        long a3 = TXCStatus.a(this.x, 7010);
        if (a3 != -1) {
            a3 -= a2;
        }
        long a4 = TXCStatus.a(this.x, 7011);
        if (a4 != -1) {
            a4 -= a2;
        }
        long a5 = TXCStatus.a(this.x, 7013);
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.P, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u64_timestamp", utcTimeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_dns_time", a3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_connect_server_time", a4);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_server_ip", b2);
        String str2 = b2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_resolution", (long) (this.f31598e | (this.f31597d << 16)));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_audio_samplerate", (long) this.f31600g);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_video_bitrate", (long) this.f31599f);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_user_id", (String) this.f31595b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_package_name", (String) this.f31595b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.P, "u32_channel_type", a5);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.P, "str_nearest_ip_list", TXCStatus.b(this.x, 7019));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.P);
        String str3 = f31594a;
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40001: token=");
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_stream_url");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        String str4 = str3;
        sb.append(this.f31596c);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(utcTimeTick);
        sb.append(SQLBuilder.BLANK);
        String str5 = "str_device_type";
        sb.append(str5);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get(str5));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_network_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(e("u32_network_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_dns_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a3);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_connect_server_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a4);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_server_ip");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(str2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_video_resolution");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((this.f31597d << 16) | this.f31598e);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_audio_samplerate");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31600g);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_video_bitrate");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31599f);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_user_id");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get("str_user_id"));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_package_name");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get("str_package_name"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_channel_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a5);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_app_version");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get("dev_uuid"));
        sb.append(SQLBuilder.BLANK);
        sb.append("dev_uuid");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(e("u32_max_load"));
        TXCLog.d(str4, sb.toString());
    }

    private void p() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        tXCDRExtInfo.url = this.f31596c;
        long a2 = TXCStatus.a(this.x, 7009);
        long a3 = TXCStatus.a(this.x, 7013);
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.R, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u64_timestamp", utcTimeTick);
        long timeTick = (TXCTimeUtil.getTimeTick() - a2) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_result", timeTick);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_user_id", (String) this.f31595b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_package_name", (String) this.f31595b.get("str_package_name"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_channel_type", a3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_ip_count_quic", String.valueOf(TXCStatus.c(this.x, 7016)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_quic", String.valueOf(TXCStatus.c(this.x, 7017)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.R, "u32_connect_count_tcp", String.valueOf(TXCStatus.c(this.x, 7018)));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.R);
        String str2 = f31594a;
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40002: token=");
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_stream_url");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        String str3 = str2;
        sb.append(this.f31596c);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(utcTimeTick);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_result");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(timeTick);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_user_id");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get("str_user_id"));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_package_name");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get("str_package_name"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_channel_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a3);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_app_version");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.i);
        sb.append(SQLBuilder.BLANK);
        String str4 = "dev_uuid";
        sb.append(str4);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31595b.get(str4));
        TXCLog.d(str3, sb.toString());
    }

    private void q() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        tXCDRExtInfo.url = this.f31596c;
        int[] a2 = com.tencent.liteav.basic.util.b.a();
        int i2 = a2[0];
        int i3 = a2[1];
        int b2 = com.tencent.liteav.basic.util.b.b();
        long a3 = TXCStatus.a(this.x, 7013);
        int c2 = TXCStatus.c(this.x, 7004);
        int c3 = TXCStatus.c(this.x, 7003);
        double d2 = TXCStatus.d(this.x, 4001);
        int c4 = TXCStatus.c(this.x, 7005);
        int c5 = TXCStatus.c(this.x, 7002);
        int c6 = TXCStatus.c(this.x, 7001);
        int c7 = TXCStatus.c(this.x, 4007);
        String b3 = TXCStatus.b(this.x, 7012);
        String b4 = TXCStatus.b(this.x, 7014);
        String b5 = TXCStatus.b(this.x, 7015);
        String b6 = TXCStatus.b(this.x, 3001);
        long j2 = a3;
        long a4 = TXCStatus.a(this.x, 3002);
        double d3 = TXCStatus.d(this.x, 3003);
        int c8 = TXCStatus.c(this.x, 7020);
        double d4 = d3;
        String str = (String) this.f31595b.get("token");
        int i4 = c8;
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Q, com.tencent.liteav.basic.datareport.a.al, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_audio_bitrate", (long) c5);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_video_bitrate", (long) c6);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_net_speed", (long) (c3 + c2));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_fps", (long) ((int) d2));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_avg_cache_size", (long) c4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_cpu_usage", (long) i3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_app_cpu_usage", (long) i2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_app_mem_usage", (long) b2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_channel_type", j2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_hw_enc", (long) c7);
        try {
            if (this.h != null && com.tencent.liteav.basic.util.b.d(this.h) == 1) {
                WifiManager wifiManager = (WifiManager) this.h.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_wifi_ssid", connectionInfo.getSSID());
                        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_wifi_signal_strength", (long) WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 32));
                        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_wifi_link_speed", (long) connectionInfo.getLinkSpeed());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_server_ip", b3);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_id", b4);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_quic_connection_stats", b5);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Q, "str_beauty_stats", b6);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_send_strategy", (long) i4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_timecost", a4);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Q, "u32_preprocess_fps_out", (long) ((int) d4));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Q);
    }

    private int e(String str) {
        Number number = (Number) this.f31595b.get(str);
        if (number != null) {
            return number.intValue();
        }
        return 0;
    }

    private void r() {
        this.m = false;
        this.n = 0;
        this.f31595b.put("str_user_id", com.tencent.liteav.basic.util.b.b(this.h));
        this.f31595b.put("str_device_type", com.tencent.liteav.basic.util.b.c());
        this.f31595b.put("str_device_type", com.tencent.liteav.basic.util.b.c());
        this.f31595b.put("u32_network_type", Integer.valueOf(com.tencent.liteav.basic.util.b.d(this.h)));
        this.f31595b.put("token", com.tencent.liteav.basic.util.b.e());
        this.f31595b.put("str_package_name", com.tencent.liteav.basic.util.b.c(this.h));
        this.f31595b.put("dev_uuid", com.tencent.liteav.basic.util.b.e(this.h));
    }

    private void b(boolean z) {
        long j2;
        long j3;
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.X, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        this.u = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u64_timestamp", String.valueOf(this.u));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_network_type", (long) e("u32_network_type"));
        long a2 = TXCStatus.a(this.x, 7107);
        long a3 = TXCStatus.a(this.x, 7108);
        if (a3 != -1) {
            a3 -= a2;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_dns_time", z ? a3 : -1);
        String b2 = TXCStatus.b(this.x, 7110);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_server_ip", z ? b2 : "");
        long a4 = TXCStatus.a(this.x, 7109);
        if (a4 != -1) {
            a4 -= a2;
        }
        int i2 = com.tencent.liteav.basic.datareport.a.X;
        if (z) {
            j2 = a4;
            j3 = j2;
        } else {
            j2 = a4;
            j3 = -1;
        }
        TXCDRApi.txSetEventIntValue(str, i2, "u32_connect_server_time", j3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_stream_begin", -1);
        this.j = TXCStatus.a(this.x, BaseConstants.ERR_PARSE_RESPONSE_FAILED) - a2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_first_i_frame", this.j);
        long a5 = TXCStatus.a(this.x, 7103) - a2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_first_frame_down", a5);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "str_user_id", (String) this.f31595b.get("str_user_id"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "str_package_name", (String) this.f31595b.get("str_package_name"));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        int c2 = TXCStatus.c(this.x, 2013);
        int i3 = c2;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_max_cache_time", String.valueOf(c2));
        int c3 = TXCStatus.c(this.x, 2012);
        int i4 = c3;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_min_cache_time", String.valueOf(c3));
        int c4 = TXCStatus.c(this.x, 7105);
        int i5 = c4;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u64_err_code", String.valueOf(c4));
        String b3 = TXCStatus.b(this.x, 7106);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "str_err_info", b3);
        int c5 = TXCStatus.c(this.x, 7112);
        String str2 = b3;
        int i6 = c5;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_link_type", String.valueOf(c5));
        int c6 = TXCStatus.c(this.x, 7111);
        int i7 = c6;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.X, "u32_channel_type", String.valueOf(c6));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.X);
        String str3 = f31594a;
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40501: token=");
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.u);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_device_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get("str_device_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_network_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(e("u32_network_type"));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_dns_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a3);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_server_ip");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(b2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_connect_server_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_stream_begin");
        sb.append("=-1 ");
        sb.append("u32_first_i_frame");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.j);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_first_frame_down");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a5);
        sb.append(SQLBuilder.BLANK);
        String str4 = "str_user_id";
        sb.append(str4);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str4));
        sb.append(SQLBuilder.BLANK);
        String str5 = "str_package_name";
        sb.append(str5);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str5));
        sb.append(SQLBuilder.BLANK);
        sb.append("str_app_version");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.i);
        sb.append(SQLBuilder.BLANK);
        String str6 = "dev_uuid";
        sb.append(str6);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str6));
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_max_cache_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(i3);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_min_cache_time");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(i4);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_err_code");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(i5);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_err_info");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(str2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_link_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(i6);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_channel_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(i7);
        TXCLog.d(str3, sb.toString());
    }

    private void s() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = false;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Z, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_begin_timestamp", String.valueOf(this.u));
        long utcTimeTick = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_end_timestamp", utcTimeTick);
        long j2 = (utcTimeTick - this.u) / 1000;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_playtime", j2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_device_type", (String) this.f31595b.get("str_device_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_network_type", (long) e("u32_network_type"));
        String b2 = TXCStatus.b(this.x, 7110);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_server_ip", b2);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_user_id", (String) this.f31595b.get("str_user_id"));
        String str2 = "str_user_id";
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_package_name", (String) this.f31595b.get("str_package_name"));
        String str3 = "str_package_name";
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "str_app_version", this.i);
        String str4 = "str_app_version";
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "dev_uuid", (String) this.f31595b.get("dev_uuid"));
        String str5 = "dev_uuid";
        long a2 = TXCStatus.a(this.x, BaseConstants.ERR_NO_SUCC_RESULT);
        String str6 = b2;
        String str7 = "u32_server_ip";
        long a3 = TXCStatus.a(this.x, BaseConstants.ERR_LOADMSG_FAILED);
        String str8 = "u32_network_type";
        long a4 = TXCStatus.a(this.x, BaseConstants.ERR_FILE_TRANS_AUTH_FAILED);
        long j3 = 0;
        if (a2 > 0) {
            j3 = a4 / a2;
        }
        long j4 = j3;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_block_count", a2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_block_duration_max", a3);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_block_duration_avg", j4);
        long j5 = j4;
        long a5 = TXCStatus.a(this.x, BaseConstants.ERR_FILE_TRANS_DOWNLOAD_FAILED);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_jitter_cache_max", a5);
        long j6 = a5;
        long a6 = TXCStatus.a(this.x, BaseConstants.ERR_FILE_TRANS_UPLOAD_FAILED);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_jitter_cache_avg", a6);
        long j7 = a6;
        long a7 = TXCStatus.a(this.x, 2008);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Z, "u64_audio_cache_avg", a7);
        int c2 = TXCStatus.c(this.x, 7112);
        long j8 = a7;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_link_type", String.valueOf(c2));
        long c3 = (long) TXCStatus.c(this.x, 2001);
        int i2 = c2;
        long j9 = c3;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_avg_load", String.valueOf(c3));
        long c4 = (long) TXCStatus.c(this.x, 2002);
        long j10 = c4;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_load_cnt", String.valueOf(c4));
        long c5 = (long) TXCStatus.c(this.x, 2003);
        long j11 = c5;
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_max_load", String.valueOf(c5));
        int c6 = TXCStatus.c(this.x, 7111);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_channel_type", String.valueOf(c6));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_ip_count_quic", String.valueOf(TXCStatus.c(this.x, 7113)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_connect_count_quic", String.valueOf(TXCStatus.c(this.x, 7114)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Z, "u32_connect_count_tcp", String.valueOf(TXCStatus.c(this.x, 7115)));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Z);
        String str9 = f31594a;
        StringBuilder sb = new StringBuilder();
        sb.append("report evt 40502: token=");
        sb.append(str);
        sb.append(SQLBuilder.BLANK);
        sb.append("str_stream_url");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.f31596c);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_begin_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.u);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_end_timestamp");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(utcTimeTick);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_playtime");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j2);
        sb.append(SQLBuilder.BLANK);
        String str10 = "str_device_type";
        sb.append(str10);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str10));
        sb.append(SQLBuilder.BLANK);
        String str11 = str8;
        sb.append(str11);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(e(str11));
        sb.append(SQLBuilder.BLANK);
        sb.append(str7);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(str6);
        sb.append(SQLBuilder.BLANK);
        String str12 = str2;
        sb.append(str12);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str12));
        sb.append(SQLBuilder.BLANK);
        String str13 = str3;
        sb.append(str13);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str13));
        sb.append(SQLBuilder.BLANK);
        sb.append(str4);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(this.i);
        sb.append(SQLBuilder.BLANK);
        String str14 = str5;
        sb.append(str14);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append((String) this.f31595b.get(str14));
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_block_count");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_block_duration_max");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(a3);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_block_duration_avg");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j5);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_jitter_cache_max");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j6);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_jitter_cache_avg");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j7);
        sb.append(SQLBuilder.BLANK);
        sb.append("u64_audio_cache_avg");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j8);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_link_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(i2);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_avg_load");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j9);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_load_cnt");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j10);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_max_load");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(j11);
        sb.append(SQLBuilder.BLANK);
        sb.append("u32_channel_type");
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(c6);
        TXCLog.d(str9, sb.toString());
    }

    private void t() {
        TXCDRExtInfo tXCDRExtInfo = new TXCDRExtInfo();
        tXCDRExtInfo.url = this.f31596c;
        tXCDRExtInfo.report_common = false;
        tXCDRExtInfo.report_status = true;
        String str = (String) this.f31595b.get("token");
        TXCDRApi.InitEvent(this.h, str, com.tencent.liteav.basic.datareport.a.Y, com.tencent.liteav.basic.datareport.a.am, tXCDRExtInfo);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_net_speed", (long) (TXCStatus.c(this.x, 7102) + TXCStatus.c(this.x, 7101)));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_fps", (long) ((int) TXCStatus.d(this.x, BaseConstants.ERR_SERIALIZE_REQ_FAILED)));
        long a2 = TXCStatus.a(this.x, BaseConstants.ERR_INVALID_CONVERSATION);
        long j2 = this.l;
        if (j2 == -1) {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_block_count", 0);
        } else if (a2 >= j2) {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_block_count", a2 - this.l);
        } else {
            TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_block_count", 0);
        }
        this.l = a2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_cache_count", TXCStatus.a(this.x, BaseConstants.ERR_FILE_TRANS_UPLOAD_FAILED));
        int[] a3 = com.tencent.liteav.basic.util.b.a();
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_cpu_usage", (long) a3[1]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_app_cpu_usage", (long) a3[0]);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_app_mem_usage", (long) com.tencent.liteav.basic.util.b.b());
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "str_app_version", this.i);
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "str_device_type", (String) this.f31595b.get("str_device_type"));
        int i2 = 2;
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_decode_type", (long) (TXCStatus.c(this.x, 5002) == 0 ? 2 : 1));
        if (TXCStatus.c(this.x, 2015) != 0) {
            i2 = 1;
        }
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_decode_type", (long) i2);
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_network_type", (long) e("u32_network_type"));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_video_cache_time", (long) TXCStatus.c(this.x, BaseConstants.ERR_FILE_TRANS_NO_SERVER));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_cache_time", (long) TXCStatus.c(this.x, 2010));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_jitter", (long) TXCStatus.c(this.x, 2011));
        TXCDRApi.txSetEventIntValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_audio_drop", (long) TXCStatus.c(this.x, 2014));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.u) / 1000));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_link_type", String.valueOf(TXCStatus.c(this.x, 7112)));
        TXCDRApi.txSetEventValue(str, com.tencent.liteav.basic.datareport.a.Y, "u32_channel_type", String.valueOf(TXCStatus.c(this.x, 7111)));
        TXCDRApi.nativeReportEvent(str, com.tencent.liteav.basic.datareport.a.Y);
    }
}
