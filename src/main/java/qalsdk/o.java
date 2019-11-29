package qalsdk;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.qalsdk.sdk.MsfSdkUtils;
import com.tencent.qalsdk.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import qalsdk.n;

public final class o extends n {

    /* renamed from: b  reason: collision with root package name */
    private String f34174b;

    /* renamed from: c  reason: collision with root package name */
    private URL f34175c;

    /* renamed from: d  reason: collision with root package name */
    private String f34176d;

    /* renamed from: e  reason: collision with root package name */
    private int f34177e = 10000;

    /* renamed from: f  reason: collision with root package name */
    private HttpURLConnection f34178f;

    /* renamed from: g  reason: collision with root package name */
    private int f34179g;
    private String h;

    public o(int i, String str, String str2, int i2, n.a aVar) {
        super(i, aVar);
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        Random random = new Random(System.currentTimeMillis());
        String str4 = "r=" + String.valueOf(random.nextInt(100000));
        if (!str.contains("?")) {
            str3 = "?" + str4;
        } else if (str.endsWith("?")) {
            str3 = str + str4;
        } else {
            str3 = str4 + "&" + str4;
        }
        sb.append(str3);
        this.f34174b = sb.toString();
        this.f34174b = MsfSdkUtils.insertMtype("netdetect", this.f34174b);
        this.f34176d = str2;
        this.f34177e = 10000;
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " try connect " + this.f34174b);
            }
            this.f34175c = new URL(this.f34174b);
            this.f34178f = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(this.f34175c.openConnection()));
            this.f34178f.setRequestMethod("GET");
            this.f34178f.setDoInput(true);
            this.f34178f.setUseCaches(false);
            this.f34178f.setConnectTimeout(this.f34177e);
            this.f34178f.setReadTimeout(10000);
            this.f34178f.connect();
            if (QLog.isColorLevel()) {
                QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " connect " + this.f34174b + " succ.");
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " connect " + this.f34174b + " failed.");
            }
            HttpURLConnection httpURLConnection = this.f34178f;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (QLog.isColorLevel()) {
            QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " disconnect " + this.f34174b);
        }
        HttpURLConnection httpURLConnection = this.f34178f;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final String c() {
        try {
            this.f34179g = this.f34178f.getResponseCode();
            this.h = this.f34178f.getURL().getHost();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f34178f.getInputStream()));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str = str + readLine;
            }
            bufferedReader.close();
            if (QLog.isColorLevel()) {
                StringBuilder sb = new StringBuilder("WIFI detect, HttpEchoTask ");
                sb.append(this.f34172a);
                sb.append(" echo content: ");
                sb.append(str.length() > 10 ? str.substring(0, 10) : str);
                QLog.d("HttpEchoTask", 2, sb.toString());
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " echo failed");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final int a(String str) {
        if (this.f34179g != 200 || !this.f34175c.getHost().equals(this.h) || TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " valid failed.");
            }
            int i = this.f34179g;
            if (i == 302 || i == 301) {
                return -3;
            }
            QLog.i("HttpEchoTask", "wifi detect response:" + this.f34179g);
            return -2;
        } else if (!str.equals(this.f34176d)) {
            return -3;
        } else {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.f34172a + " valid succ");
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final Object d() {
        return this.f34174b;
    }
}
