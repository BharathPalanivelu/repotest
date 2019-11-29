package com.shopee.f.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.location.places.Place;
import com.salesforce.android.service.common.liveagentlogging.event.ErrorEvent;
import com.shopee.f.a.a.a.l;
import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.transfer.UploadService;
import com.tencent.imsdk.BaseConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private long A = 0;
    private String B = "";
    /* access modifiers changed from: private */
    public CosXmlService C;
    /* access modifiers changed from: private */
    public UploadService D;
    private SharedPreferences E;
    private SharedPreferences.Editor F;
    /* access modifiers changed from: private */
    public String G = null;
    private long H = 0;
    private boolean I = true;
    private boolean J = false;
    private l.a K;
    private TimerTask L = null;
    private Timer M;
    /* access modifiers changed from: private */
    public int N = 0;
    /* access modifiers changed from: private */
    public boolean O = false;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f27167a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f27168b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f27169c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f27170d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public g f27171e;

    /* renamed from: f  reason: collision with root package name */
    private k f27172f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public h f27173g;
    private int h;
    private int i;
    private String j = "";
    /* access modifiers changed from: private */
    public String k;
    private String l = "";
    private String m = "";
    private String n = "";
    /* access modifiers changed from: private */
    public long o;
    /* access modifiers changed from: private */
    public long p = 0;
    /* access modifiers changed from: private */
    public String q;
    private String r;
    private String s;
    /* access modifiers changed from: private */
    public boolean t = false;
    private String u = "";
    private String v = "";
    private String w;
    /* access modifiers changed from: private */
    public String x = "";
    /* access modifiers changed from: private */
    public String y = null;
    /* access modifiers changed from: private */
    public long z = 0;

    public b(Context context, String str, String str2, boolean z2, boolean z3, int i2) {
        j.a().a(str2);
        this.f27167a = context.getApplicationContext();
        this.f27172f = k.a(str2, i2);
        this.f27168b = new Handler(context.getMainLooper());
        this.E = context.getSharedPreferences("TVCSession", 0);
        this.F = this.E.edit();
        this.I = z2;
        this.J = z3;
        this.B = str;
        this.K = new l.a();
        b();
    }

    private void b() {
        SharedPreferences sharedPreferences = this.E;
        if (sharedPreferences != null) {
            try {
                for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                    if (new JSONObject((String) next.getValue()).optLong("expiredTime", 0) < System.currentTimeMillis() / 1000) {
                        this.F.remove((String) next.getKey());
                        this.F.commit();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        Timer timer = this.M;
        if (timer != null) {
            timer.cancel();
            this.M = null;
        }
        if (this.L != null) {
            this.L = null;
        }
        if (this.L == null) {
            this.L = new TimerTask() {
                public void run() {
                    b.this.e();
                }
            };
        }
        this.M = new Timer();
        this.M.schedule(this.L, 200, 200);
    }

    /* access modifiers changed from: private */
    public void d() {
        Timer timer = this.M;
        if (timer != null) {
            timer.cancel();
            this.M = null;
        }
        if (this.L != null) {
            this.L = null;
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        g gVar = this.f27171e;
        if (gVar != null) {
            long h2 = gVar.h() + (this.f27171e.e() ? this.f27171e.i() : 0);
            this.N++;
            a((((long) this.N) * h2) / 100, h2);
        }
    }

    private void a(String str, String str2, String str3) {
        j.a().e(this.f27171e.b());
        final long h2 = this.f27171e.h() + (this.f27171e.e() ? this.f27171e.i() : 0);
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        this.f27168b.post(new Runnable() {
            public void run() {
                h b2 = b.this.f27173g;
                long j = h2;
                b2.a(j, j);
                b.this.f27173g.a(str4, str5, str6);
            }
        });
        d();
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final String str) {
        j.a().e(this.f27171e.b());
        this.f27168b.post(new Runnable() {
            public void run() {
                b.this.f27173g.a(i2, str);
            }
        });
        d();
    }

    /* access modifiers changed from: private */
    public void a(long j2, long j3) {
        final long j4 = j2;
        final long j5 = j3;
        this.f27168b.post(new Runnable() {
            public void run() {
                b.this.f27173g.a(j4, j5);
            }
        });
    }

    public int a(g gVar, h hVar) {
        g gVar2 = gVar;
        if (this.f27169c) {
            return 1007;
        }
        this.f27169c = true;
        this.f27171e = gVar2;
        this.f27173g = hVar;
        String f2 = gVar.f();
        Log.d("TVC-Client", "fileName = " + f2);
        if (f2 != null && f2.getBytes().length > 200) {
            this.f27173g.a((int) Place.TYPE_POSTAL_CODE, "file name too long");
            a(c.f27195b, Place.TYPE_POSTAL_CODE, 0, "", "file name too long", System.currentTimeMillis(), 0, this.f27171e.h(), this.f27171e.a(), this.f27171e.f(), "");
            return Place.TYPE_POSTAL_CODE;
        } else if (gVar2.a(f2)) {
            this.f27173g.a((int) Place.TYPE_POSTAL_CODE, "file name contains special character / : * ? \" < >");
            a(c.f27195b, Place.TYPE_POSTAL_CODE, 0, "", "file name contains special character / : * ? \" < >", System.currentTimeMillis(), 0, this.f27171e.h(), this.f27171e.a(), this.f27171e.f(), "");
            return Place.TYPE_POSTAL_CODE;
        } else {
            if (!j.a().f(gVar.b()) && this.I) {
                e(gVar.b());
            }
            j.a().d(gVar.b());
            a(gVar2, this.y);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public void a(g gVar, String str) {
        c();
        this.z = System.currentTimeMillis();
        this.A = this.z;
        this.f27172f.a(gVar, this.B, str, (Callback) new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Log.e("TVC-Client", "initUploadUGC->onFailure: " + iOException.toString());
                b.this.a(1001, iOException.toString());
                b.this.a(c.f27195b, 1001, 1, "", iOException.toString(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    b.this.b(response.body().string());
                    return;
                }
                b bVar = b.this;
                bVar.a(1001, "HTTP Code:" + response.code());
                b bVar2 = b.this;
                int i = c.f27195b;
                int code = response.code();
                bVar2.a(i, 1001, code, "", "HTTP Code:" + response.code(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                b bVar3 = b.this;
                bVar3.b(bVar3.f27171e.b(), "", "");
                Log.e("TVC-Client", "initUploadUGC->http code: " + response.code());
                throw new IOException("" + response);
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: com.shopee.f.a.a.a.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: com.shopee.f.a.a.a.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v23, resolved type: com.shopee.f.a.a.a.b} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r30) {
        /*
            r29 = this;
            r15 = r29
            r0 = r30
            java.lang.String r1 = "domain"
            java.lang.String r2 = "storagePath"
            java.lang.String r3 = "|"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "parseInitRsp: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.String r14 = "TVC-Client"
            android.util.Log.i(r14, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r30)
            r13 = 1002(0x3ea, float:1.404E-42)
            java.lang.String r11 = ""
            if (r4 == 0) goto L_0x0074
            java.lang.String r0 = "parseInitRsp->response is empty!"
            android.util.Log.e(r14, r0)
            java.lang.String r0 = "init response is empty"
            r15.a((int) r13, (java.lang.String) r0)
            int r2 = com.shopee.f.a.a.a.c.f27195b
            r3 = 1001(0x3e9, float:1.403E-42)
            r4 = 2
            long r7 = r15.z
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r15.z
            long r9 = r0 - r5
            com.shopee.f.a.a.a.g r0 = r15.f27171e
            long r12 = r0.h()
            com.shopee.f.a.a.a.g r0 = r15.f27171e
            java.lang.String r0 = r0.a()
            com.shopee.f.a.a.a.g r1 = r15.f27171e
            java.lang.String r14 = r1.f()
            java.lang.String r5 = ""
            java.lang.String r6 = "init response is empty"
            java.lang.String r16 = ""
            r1 = r29
            r17 = r11
            r11 = r12
            r13 = r0
            r15 = r16
            r1.a(r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            r15 = r29
            com.shopee.f.a.a.a.g r0 = r15.f27171e
            java.lang.String r0 = r0.b()
            r11 = r17
            r15.b(r0, r11, r11)
            return
        L_0x0074:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            java.lang.String r0 = "code"
            r6 = -1
            int r6 = r4.optInt(r0, r6)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r0.<init>()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r0.append(r5)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r0.append(r6)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            android.util.Log.i(r14, r0)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x00a6 }
            java.lang.String r5 = "message"
            java.lang.String r5 = r4.optString(r5, r11)     // Catch:{ UnsupportedEncodingException -> 0x00a6 }
            java.lang.String r7 = "UTF-8"
            byte[] r5 = r5.getBytes(r7)     // Catch:{ UnsupportedEncodingException -> 0x00a6 }
            java.lang.String r7 = "utf-8"
            r0.<init>(r5, r7)     // Catch:{ UnsupportedEncodingException -> 0x00a6 }
            goto L_0x00ab
        L_0x00a6:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r0 = r11
        L_0x00ab:
            if (r6 == 0) goto L_0x0130
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.<init>()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.append(r6)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.append(r3)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.append(r0)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r15.a((int) r13, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            int r2 = com.shopee.f.a.a.a.c.f27195b     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r4 = 1001(0x3e9, float:1.403E-42)
            java.lang.String r5 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.<init>()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.append(r6)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.append(r3)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r1.append(r0)     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            java.lang.String r0 = r1.toString()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            long r7 = r15.z     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0383, CosXmlClientException -> 0x034d }
            r16 = r14
            long r13 = r15.z     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            long r9 = r9 - r13
            com.shopee.f.a.a.a.g r1 = r15.f27171e     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            long r12 = r1.h()     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            com.shopee.f.a.a.a.g r1 = r15.f27171e     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            java.lang.String r14 = r1.a()     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            com.shopee.f.a.a.a.g r1 = r15.f27171e     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            java.lang.String r18 = r1.f()     // Catch:{ JSONException -> 0x012b, CosXmlClientException -> 0x0126 }
            java.lang.String r19 = ""
            r1 = r29
            r3 = r4
            r4 = r6
            r6 = r0
            r20 = r11
            r11 = r12
            r13 = r14
            r21 = r16
            r14 = r18
            r15 = r19
            r1.a(r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)     // Catch:{ JSONException -> 0x0121, CosXmlClientException -> 0x011c }
            r0 = 0
            r15 = r29
            r15.y = r0     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            com.shopee.f.a.a.a.g r0 = r15.f27171e     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r0 = r0.b()     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r3 = r20
            r15.b(r0, r3, r3)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            return
        L_0x011c:
            r0 = move-exception
            r15 = r29
            goto L_0x0346
        L_0x0121:
            r0 = move-exception
            r15 = r29
            goto L_0x034a
        L_0x0126:
            r0 = move-exception
            r9 = r16
            goto L_0x034f
        L_0x012b:
            r0 = move-exception
            r9 = r16
            goto L_0x0385
        L_0x0130:
            r3 = r11
            r21 = r14
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r4.getJSONObject(r0)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r4 = "video"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r4 = r4.getString(r2)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r15.q = r4     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r4 = "tempCertificate"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r5 = "secretId"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r15.l = r5     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r5 = "secretKey"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r15.m = r5     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r5 = "token"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r15.n = r5     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r5 = "expiredTime"
            long r4 = r4.optLong(r5)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r15.o = r4     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r4 = "timestamp"
            r5 = 0
            long r7 = r0.optLong(r4, r5)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r4.<init>()     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r9 = "isNeedCover:"
            r4.append(r9)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            com.shopee.f.a.a.a.g r9 = r15.f27171e     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            boolean r9 = r9.e()     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r4.append(r9)     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0349, CosXmlClientException -> 0x0345 }
            r9 = r21
            android.util.Log.d(r9, r4)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.shopee.f.a.a.a.g r4 = r15.f27171e     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            boolean r4 = r4.e()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            if (r4 == 0) goto L_0x01a3
            java.lang.String r4 = "cover"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = r4.getString(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.s = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
        L_0x01a3:
            java.lang.String r2 = "storageAppId"
            int r2 = r0.getInt(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.h = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = "storageBucket"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.k = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = "storageRegionV5"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.j = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = r0.getString(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.w = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = "vodSessionKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.y = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = "appId"
            int r2 = r0.getInt(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.i = r2     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = "cosAcc"
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r2 = 1
            if (r0 == 0) goto L_0x01ed
            java.lang.String r4 = "isOpen"
            r10 = 0
            int r4 = r0.optInt(r4, r10)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            if (r4 != 0) goto L_0x01e4
            goto L_0x01e5
        L_0x01e4:
            r10 = 1
        L_0x01e5:
            r15.t = r10     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.optString(r1, r3)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.u = r0     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
        L_0x01ed:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "cosVideoPath="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.q     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "cosCoverPath="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.s     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "cosAppId="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            int r1 = r15.h     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "cosBucket="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.k     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "uploadRegion="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.j     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "domain="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.w     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "vodSessionKey="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.y     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "cosAcc.isOpen="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            boolean r1 = r15.t     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = "cosAcc.domain="
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.u     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.append(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.util.Log.d(r9, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r15.j     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r0 = r15.c((java.lang.String) r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.v = r0     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.tencent.cos.xml.CosXmlServiceConfig$Builder r0 = new com.tencent.cos.xml.CosXmlServiceConfig$Builder     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r0.<init>()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            int r1 = r15.h     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r3 = r15.j     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.tencent.cos.xml.CosXmlServiceConfig$Builder r0 = r0.setAppidAndRegion(r1, r3)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.tencent.cos.xml.CosXmlServiceConfig$Builder r0 = r0.setDebuggable(r2)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            boolean r1 = r15.J     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.tencent.cos.xml.CosXmlServiceConfig$Builder r0 = r0.isHttps(r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.tencent.cos.xml.CosXmlServiceConfig r0 = r0.builder()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x02f4
            long r3 = r1 - r7
            r5 = 300(0x12c, double:1.48E-321)
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x02f2
            long r7 = r7 - r1
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x02f4
        L_0x02f2:
            r15.p = r3     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
        L_0x02f4:
            com.tencent.cos.xml.CosXmlService r3 = new com.tencent.cos.xml.CosXmlService     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            android.content.Context r4 = r15.f27167a     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.shopee.f.a.a.a.d r5 = new com.shopee.f.a.a.a.d     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r6 = r15.l     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r7 = r15.m     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r8 = r15.n     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            long r10 = r15.p     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            long r25 = r1 - r10
            long r1 = r15.o     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r27 = r1
            r21.<init>(r22, r23, r24, r25, r27)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r3.<init>(r4, r0, r5)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r15.C = r3     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            com.shopee.f.a.a.a.j r0 = com.shopee.f.a.a.a.j.a()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r1 = r15.v     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.util.List r0 = r0.c((java.lang.String) r1)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            if (r0 == 0) goto L_0x033d
            int r1 = r0.size()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            if (r1 <= 0) goto L_0x033d
            com.tencent.cos.xml.CosXmlService r1 = r15.C     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String r2 = r15.v     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            int r3 = r0.size()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            java.lang.String[] r0 = (java.lang.String[]) r0     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            r1.addCustomerDNS(r2, r0)     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
        L_0x033d:
            r29.g()     // Catch:{ JSONException -> 0x0343, CosXmlClientException -> 0x0341 }
            goto L_0x0356
        L_0x0341:
            r0 = move-exception
            goto L_0x034f
        L_0x0343:
            r0 = move-exception
            goto L_0x0385
        L_0x0345:
            r0 = move-exception
        L_0x0346:
            r9 = r21
            goto L_0x034f
        L_0x0349:
            r0 = move-exception
        L_0x034a:
            r9 = r21
            goto L_0x0385
        L_0x034d:
            r0 = move-exception
            r9 = r14
        L_0x034f:
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r9, r0)
        L_0x0356:
            int r2 = com.shopee.f.a.a.a.c.f27195b
            r3 = 0
            r4 = 0
            long r7 = r15.z
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r15.z
            long r9 = r0 - r5
            com.shopee.f.a.a.a.g r0 = r15.f27171e
            long r11 = r0.h()
            com.shopee.f.a.a.a.g r0 = r15.f27171e
            java.lang.String r13 = r0.a()
            com.shopee.f.a.a.a.g r0 = r15.f27171e
            java.lang.String r14 = r0.f()
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r0 = ""
            r1 = r29
            r15 = r0
            r1.a(r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            return
        L_0x0383:
            r0 = move-exception
            r9 = r14
        L_0x0385:
            java.lang.String r1 = r0.toString()
            android.util.Log.e(r9, r1)
            int r2 = com.shopee.f.a.a.a.c.f27195b
            r3 = 1002(0x3ea, float:1.404E-42)
            r4 = 3
            java.lang.String r6 = r0.toString()
            r15 = r29
            long r7 = r15.z
            long r9 = java.lang.System.currentTimeMillis()
            long r11 = r15.z
            long r9 = r9 - r11
            com.shopee.f.a.a.a.g r1 = r15.f27171e
            long r11 = r1.h()
            com.shopee.f.a.a.a.g r1 = r15.f27171e
            java.lang.String r13 = r1.a()
            com.shopee.f.a.a.a.g r1 = r15.f27171e
            java.lang.String r14 = r1.f()
            java.lang.String r5 = ""
            java.lang.String r16 = ""
            r1 = r29
            r15 = r16
            r1.a(r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15)
            java.lang.String r0 = r0.toString()
            r2 = 1002(0x3ea, float:1.404E-42)
            r1.a((int) r2, (java.lang.String) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.f.a.a.a.b.b(java.lang.String):void");
    }

    private String c(String str) {
        final String host = new PutObjectRequest(this.k, this.s, this.f27171e.d()).getHost(String.valueOf(this.h), str, this.t);
        new Thread(new Runnable() {
            public void run() {
                try {
                    String unused = b.this.x = InetAddress.getByName(host).getHostAddress();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }).start();
        return host;
    }

    private void f() {
        this.z = System.currentTimeMillis();
        PutObjectRequest putObjectRequest = new PutObjectRequest(this.k, this.s, this.f27171e.d());
        putObjectRequest.setProgressListener(new CosXmlProgressListener() {
            public void onProgress(long j, long j2) {
                Log.d("TVC-Client", "uploadCosCover->progress: " + j + Constants.URL_PATH_DELIMITER + j2);
                if (j >= j2) {
                    int unused = b.this.N = 90;
                    b.this.c();
                    return;
                }
                long h = j2 + b.this.f27171e.h();
                b bVar = b.this;
                bVar.a((((j + bVar.f27171e.h()) * 80) / 100) + ((10 * h) / 100), h);
            }
        });
        putObjectRequest.setSign((this.z / 1000) - this.p, this.o);
        putObjectRequest.isSupportAccelerate(this.t);
        this.C.putObjectAsync(putObjectRequest, new CosXmlResultListener() {
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                b.this.a(c.f27196c, 0, 0, "", "", b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.i(), b.this.f27171e.c(), b.this.f27171e.g(), "");
                b.this.b(cosXmlResult);
            }

            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                String str;
                StringBuilder sb = new StringBuilder();
                if (cosXmlClientException != null) {
                    sb.append(cosXmlClientException.getMessage());
                    str = "CosXmlClientException";
                } else {
                    sb.append(cosXmlServiceException.toString());
                    str = cosXmlServiceException.getErrorCode();
                }
                String str2 = str;
                b bVar = b.this;
                bVar.a(1004, "cos upload error:" + sb.toString());
                b.this.a(c.f27196c, 1004, 0, str2, sb.toString(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.i(), b.this.f27171e.c(), b.this.f27171e.g(), "");
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(CosXmlResult cosXmlResult) {
        if (this.f27171e.e()) {
            f();
        } else {
            b(cosXmlResult);
        }
    }

    private void g() {
        new Thread() {
            public void run() {
                int i;
                long unused = b.this.z = System.currentTimeMillis();
                Log.i("TVC-Client", "uploadCosVideo begin :  cosBucket " + b.this.k + " cosVideoPath: " + b.this.q + "  path " + b.this.f27171e.b());
                try {
                    UploadService.ResumeData resumeData = new UploadService.ResumeData();
                    resumeData.bucket = b.this.k;
                    resumeData.cosPath = b.this.q;
                    resumeData.srcPath = b.this.f27171e.b();
                    resumeData.sliceSize = BaseConstants.MEGA;
                    if (b.this.a()) {
                        resumeData.uploadId = b.this.G;
                    } else {
                        InitMultipartUploadRequest initMultipartUploadRequest = new InitMultipartUploadRequest(b.this.k, b.this.q);
                        initMultipartUploadRequest.isSupportAccelerate(b.this.t);
                        initMultipartUploadRequest.setSign((b.this.z / 1000) - b.this.p, b.this.o);
                        String unused2 = b.this.G = b.this.C.initMultipartUpload(initMultipartUploadRequest).initMultipartUpload.uploadId;
                        b.this.b(b.this.f27171e.b(), b.this.y, b.this.G);
                        resumeData.uploadId = b.this.G;
                    }
                    UploadService unused3 = b.this.D = new UploadService(b.this.C, resumeData);
                    b.this.D.setProgressListener(new CosXmlProgressListener() {
                        public void onProgress(long j, long j2) {
                            if (b.this.f27171e.e()) {
                                j2 += b.this.f27171e.i();
                            }
                            if (!b.this.O) {
                                b.this.d();
                                boolean unused = b.this.O = true;
                            }
                            if (j >= j2) {
                                int unused2 = b.this.N = 90;
                                b.this.c();
                                return;
                            }
                            b.this.a(((j * 80) / 100) + ((10 * j2) / 100), j2);
                        }
                    });
                    b.this.D.setSign((b.this.z / 1000) - b.this.p, b.this.o);
                    b.this.D.isSupportAccelerate(b.this.t);
                    CosXmlResult resume = b.this.D.resume(resumeData);
                    b.this.b(b.this.f27171e.b(), "", "");
                    b.this.a(c.f27196c, 0, 0, "", "", b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                    Log.w("TVC-Client", resume.accessUrl);
                    Log.i("TVC-Client", "uploadCosVideo finish:  cosBucket " + b.this.k + " cosVideoPath: " + b.this.q + "  path: " + b.this.f27171e.b() + "  size: " + b.this.f27171e.h());
                    b.this.a(resume);
                } catch (CosXmlClientException e2) {
                    Log.w("TVC-Client", "CosXmlClientException = " + e2.getMessage());
                    if (!i.f(b.this.f27167a)) {
                        b.this.a(1003, "cos upload video error: network unreachable");
                    } else if (!b.this.f27170d) {
                        b bVar = b.this;
                        bVar.a(1003, "cos upload video error:" + e2.getMessage());
                        b bVar2 = b.this;
                        bVar2.b(bVar2.f27171e.b(), "", "");
                        if (b.this.f27170d || !e2.getMessage().contains("request is cancelled by manual pause")) {
                            i = 1003;
                        } else {
                            boolean unused4 = b.this.f27169c = false;
                            boolean unused5 = b.this.f27170d = false;
                            b.this.a((int) Place.TYPE_POSTAL_TOWN, "request is cancelled by manual pause");
                            i = Place.TYPE_POSTAL_TOWN;
                        }
                        b bVar3 = b.this;
                        int i2 = c.f27196c;
                        bVar3.a(i2, i, 0, "CosXmlClientException", "CosXmlClientException:" + e2.getMessage(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                    }
                    if (b.this.f27170d) {
                    }
                    i = 1003;
                    b bVar32 = b.this;
                    int i22 = c.f27196c;
                    bVar32.a(i22, i, 0, "CosXmlClientException", "CosXmlClientException:" + e2.getMessage(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                } catch (CosXmlServiceException e3) {
                    Log.w("TVC-Client", "CosXmlServiceException =" + e3.toString());
                    b bVar4 = b.this;
                    int i3 = c.f27196c;
                    String errorCode = e3.getErrorCode();
                    bVar4.a(i3, 1003, 0, errorCode, "CosXmlServiceException:" + e3.getMessage(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                    if (e3.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) {
                        b bVar5 = b.this;
                        bVar5.a(bVar5.f27171e, b.this.y);
                        return;
                    }
                    b bVar6 = b.this;
                    bVar6.a(1003, "cos upload video error:" + e3.getMessage());
                    b bVar7 = b.this;
                    bVar7.b(bVar7.f27171e.b(), "", "");
                } catch (Exception e4) {
                    Log.w("TVC-Client", "Exception =" + e4.toString());
                    b bVar8 = b.this;
                    int i4 = c.f27196c;
                    bVar8.a(i4, 1003, 0, "Exception", "HTTP Code:" + e4.getMessage(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                    b bVar9 = b.this;
                    bVar9.a(1003, "cos upload video error:" + e4.getMessage());
                    b bVar10 = b.this;
                    bVar10.b(bVar10.f27171e.b(), "", "");
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void b(CosXmlResult cosXmlResult) {
        String str = cosXmlResult.accessUrl;
        Log.i("TVC-Client", "startFinishUploadUGC: " + str);
        this.z = System.currentTimeMillis();
        this.f27172f.a(this.w, this.B, this.y, (Callback) new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Log.i("TVC-Client", "FinishUploadUGC: fail" + iOException.toString());
                b.this.a(1005, iOException.toString());
                b.this.a(c.f27197d, 1005, 1, "", iOException.toString(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.i("TVC-Client", "FinishUploadUGC Suc onResponse body : " + response.body().toString());
                    b.this.d(response.body().string());
                    return;
                }
                b bVar = b.this;
                bVar.a(1005, "HTTP Code:" + response.code());
                Log.e("TVC-Client", "FinishUploadUGC->http code: " + response.code());
                b bVar2 = b.this;
                int i = c.f27197d;
                int code = response.code();
                bVar2.a(i, 1005, code, "", "HTTP Code:" + response.code(), b.this.z, System.currentTimeMillis() - b.this.z, b.this.f27171e.h(), b.this.f27171e.a(), b.this.f27171e.f(), "");
                throw new IOException("" + response);
            }
        });
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        b bVar;
        String str2 = str;
        String str3 = "";
        Log.i("TVC-Client", "parseFinishRsp: " + str2);
        if (TextUtils.isEmpty(str)) {
            Log.e("TVC-Client", "parseFinishRsp->response is empty!");
            a(1006, "finish response is empty");
            a(c.f27197d, 1006, 2, "", "finish response is empty", this.z, System.currentTimeMillis() - this.z, this.f27171e.h(), this.f27171e.a(), this.f27171e.f(), "");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("code", -1);
            String optString = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str3);
            if (optInt != 0) {
                a(1006, optInt + "|" + optString);
                int i2 = c.f27197d;
                a(i2, 1006, optInt, "", optInt + "|" + optString, this.z, System.currentTimeMillis() - this.z, this.f27171e.h(), this.f27171e.a(), this.f27171e.f(), "");
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            bVar = this;
            try {
                if (bVar.f27171e.e()) {
                    str3 = jSONObject2.getJSONObject(PlaceFields.COVER).getString("url");
                    if (bVar.J) {
                        str3 = str3.replace("http", "https");
                    }
                }
                String str4 = str3;
                String string = jSONObject2.getJSONObject("video").getString("url");
                if (bVar.J) {
                    string = string.replace("http", "https");
                }
                String str5 = string;
                bVar.r = jSONObject2.getString("fileId");
                bVar.a(bVar.r, str5, str4);
                int i3 = c.f27197d;
                long j2 = bVar.z;
                long currentTimeMillis = System.currentTimeMillis() - bVar.z;
                long h2 = bVar.f27171e.h();
                String a2 = bVar.f27171e.a();
                String str6 = str5;
                String str7 = str4;
                String str8 = a2;
                String str9 = "TVC-Client";
                a(i3, 0, 0, "", "", j2, currentTimeMillis, h2, str8, bVar.f27171e.f(), bVar.r);
                Log.d(str9, "playUrl:" + str6);
                Log.d(str9, "coverUrl: " + str7);
                StringBuilder sb = new StringBuilder();
                sb.append("videoFileId: ");
                bVar = this;
                sb.append(bVar.r);
                Log.d(str9, sb.toString());
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            e = e3;
            bVar = this;
            bVar.a(1006, e.toString());
            a(c.f27197d, 1006, 3, "", e.toString(), bVar.z, System.currentTimeMillis() - bVar.z, bVar.f27171e.h(), bVar.f27171e.a(), bVar.f27171e.f(), "");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, String str, String str2, long j2, long j3, long j4, String str3, String str4, String str5) {
        l.a aVar = this.K;
        aVar.f27260a = i2;
        aVar.f27261b = i3;
        aVar.f27264e = str2;
        aVar.f27265f = j2;
        aVar.f27266g = j3;
        aVar.h = j4;
        aVar.i = str3;
        aVar.j = str4;
        aVar.k = str5;
        aVar.l = this.i;
        aVar.f27262c = i4;
        aVar.f27263d = str;
        aVar.r = this.j;
        if (i2 == c.f27196c) {
            this.K.n = j.a().b(this.v) ? 1 : 0;
            l.a aVar2 = this.K;
            aVar2.m = this.x;
            aVar2.t = 0;
            aVar2.u = 0;
        } else {
            this.K.n = j.a().b(c.f27194a) ? 1 : 0;
            this.K.m = this.f27172f.a();
            this.K.t = this.f27172f.b();
            this.K.u = this.f27172f.c();
        }
        l.a aVar3 = this.K;
        aVar3.s = this.t ? 1 : 0;
        aVar3.o = this.B;
        aVar3.p = String.valueOf(this.f27171e.j()) + ";" + String.valueOf(this.A);
        this.K.q = this.y;
        l.a(this.f27167a).a(this.K);
        if ((i3 == 0 && i2 == c.f27197d) || i3 != 0) {
            l.a aVar4 = new l.a(this.K);
            aVar4.f27260a = c.f27199f;
            l.a(this.f27167a).a(aVar4);
        }
    }

    private void e(String str) {
        this.y = null;
        this.G = null;
        this.H = 0;
        if (!TextUtils.isEmpty(str) && this.I) {
            SharedPreferences sharedPreferences = this.E;
            if (sharedPreferences != null && sharedPreferences.contains(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.E.getString(str, ""));
                    if (jSONObject.optLong("expiredTime", 0) > System.currentTimeMillis() / 1000) {
                        this.y = jSONObject.optString(ErrorEvent.OPENTOK_DOMAIN_SESSION, "");
                        this.G = jSONObject.optString("uploadId", "");
                        this.H = jSONObject.optLong("fileLastModTime", 0);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        if (str != null && !str.isEmpty() && this.E != null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str3)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ErrorEvent.OPENTOK_DOMAIN_SESSION, str2);
                        jSONObject.put("uploadId", str3);
                        jSONObject.put("expiredTime", (System.currentTimeMillis() / 1000) + 86400);
                        jSONObject.put("fileLastModTime", this.f27171e.j());
                        this.F.putString(str, jSONObject.toString());
                        this.F.commit();
                        return;
                    }
                }
                this.F.remove(str);
                this.F.commit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean a() {
        if (!this.I || TextUtils.isEmpty(this.G)) {
            return false;
        }
        g gVar = this.f27171e;
        if (gVar == null) {
            return false;
        }
        long j2 = this.H;
        return j2 != 0 && j2 == gVar.j();
    }

    public void a(String str) {
        k kVar = this.f27172f;
        if (kVar != null) {
            kVar.a(str);
        }
    }
}
