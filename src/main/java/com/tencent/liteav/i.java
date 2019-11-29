package com.tencent.liteav;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f31641a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f31642b = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f31643c = "";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f31644d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public long f31645e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f31646f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public long f31647g = 0;

    public interface a {
        void a(long j);
    }

    public i(Context context) {
    }

    public long a() {
        this.f31647g = System.currentTimeMillis() - this.f31645e;
        return this.f31647g;
    }

    public String a(long j) {
        return String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[]{this.f31641a, this.f31643c, this.f31642b, new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.f31645e + (j * 1000))), this.f31644d});
    }

    public int a(String str, String str2, int i, a aVar) {
        if (str == null || str.isEmpty()) {
            return -1;
        }
        this.f31644d = TXCCommonUtil.getAppID();
        if (TextUtils.isEmpty(this.f31644d)) {
            return -2;
        }
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final a aVar2 = aVar;
        AsyncTask.execute(new Runnable() {
            public void run() {
                long unused = i.this.f31646f = 0;
                long unused2 = i.this.f31645e = 0;
                long unused3 = i.this.f31647g = 0;
                String str = "";
                String unused4 = i.this.f31642b = str;
                String unused5 = i.this.f31643c = str;
                int i = i2;
                if (i > 0) {
                    String unused6 = i.this.f31643c = String.valueOf(i);
                }
                String unused7 = i.this.f31641a = str3;
                String unused8 = i.this.f31642b = TXCCommonUtil.getStreamIDByStreamUrl(str4);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(String.format("http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0", new Object[]{i.this.f31641a, i.this.f31643c, i.this.f31642b, i.this.f31644d})).openConnection()));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Charsert", "UTF-8");
                    httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, "text/plain;");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + readLine;
                    }
                    TXCLog.e("TXCTimeShiftUtil", "prepareSeekTime: receive response, strResponse = " + str);
                    String d2 = i.this.a(str);
                    long parseLong = Long.parseLong(d2);
                    long currentTimeMillis = System.currentTimeMillis();
                    TXCLog.i("TXCTimeShiftUtil", "time:" + d2 + ",currentTime:" + currentTimeMillis + ",diff:" + (currentTimeMillis - parseLong));
                    long unused9 = i.this.f31645e = parseLong * 1000;
                    long unused10 = i.this.f31647g = currentTimeMillis - i.this.f31645e;
                    if (aVar2 != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                aVar2.a(i.this.f31647g);
                            }
                        });
                    }
                } catch (Exception e2) {
                    long unused11 = i.this.f31645e = 0;
                    e2.printStackTrace();
                }
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        if (!str.contains("#EXT-TX-TS-START-TIME")) {
            return null;
        }
        int indexOf = str.indexOf("#EXT-TX-TS-START-TIME:") + 22;
        if (indexOf <= 0) {
            return null;
        }
        String substring = str.substring(indexOf);
        int indexOf2 = substring.indexOf("#");
        if (indexOf2 > 0) {
            return substring.substring(0, indexOf2).replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "");
        }
        return null;
    }
}
