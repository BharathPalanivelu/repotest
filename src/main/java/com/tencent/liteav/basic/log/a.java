package com.tencent.liteav.basic.log;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.share.Constants;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.imsdk.BaseConstants;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31376a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static a f31377b;

    /* renamed from: c  reason: collision with root package name */
    private int f31378c = 1253488539;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f31379d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private Map<String, C0487a> f31380e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private C0487a f31381f;

    /* renamed from: g  reason: collision with root package name */
    private Set<String> f31382g = new HashSet();
    private Handler h;
    private Context i;
    private String j = "";
    private String k;
    private int l;
    private long m;
    private boolean n;
    private boolean o;

    static class b {

        /* renamed from: a  reason: collision with root package name */
        int f31388a;

        /* renamed from: b  reason: collision with root package name */
        String f31389b;

        /* renamed from: c  reason: collision with root package name */
        String f31390c;

        /* renamed from: d  reason: collision with root package name */
        String f31391d;

        /* renamed from: e  reason: collision with root package name */
        String f31392e;

        /* renamed from: f  reason: collision with root package name */
        String f31393f;

        /* renamed from: g  reason: collision with root package name */
        String f31394g;
        String h;

        b() {
        }
    }

    /* renamed from: com.tencent.liteav.basic.log.a$a  reason: collision with other inner class name */
    static class C0487a {

        /* renamed from: a  reason: collision with root package name */
        Set<String> f31385a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        String f31386b;

        /* renamed from: c  reason: collision with root package name */
        int f31387c;

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (String next : this.f31385a) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(next);
            }
            return sb.toString();
        }

        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (String add : str.split(",")) {
                    this.f31385a.add(add);
                }
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (f31377b == null) {
            synchronized (a.class) {
                if (f31377b == null) {
                    f31377b = new a();
                }
            }
        }
        return f31377b;
    }

    public synchronized void b() {
        f();
        this.h.postDelayed(new Runnable() {
            public void run() {
                a.this.c();
            }
        }, BaseConstants.DEFAULT_MSG_TIMEOUT);
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            if (this.n) {
                this.o = true;
                TXCLog.w(f31376a, " user is in room delay upload after exit room");
            } else if (this.f31380e.isEmpty()) {
                TXCLog.w(f31376a, " log record is empty ignore start upload");
            } else {
                String str = f31376a;
                TXCLog.w(str, "start log upload " + this.l);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AppsFlyerProperties.APP_ID, this.f31378c);
                jSONObject.put("sdkappid", this.l);
                String a2 = a("https://avc.qcloud.com/log/appsign.php", (Map<String, String>) null, jSONObject.toString().getBytes("utf-8"));
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    b bVar = new b();
                    bVar.f31388a = jSONObject2.getInt("retcode");
                    bVar.f31389b = jSONObject2.getString("errmsg");
                    bVar.f31390c = jSONObject2.getString("logkey");
                    bVar.f31391d = jSONObject2.getString("sign");
                    bVar.f31393f = jSONObject2.getString("bucket");
                    bVar.f31392e = jSONObject2.getString("path");
                    bVar.h = jSONObject2.getString("region");
                    bVar.f31394g = jSONObject2.getString("cosAppid");
                    String str2 = f31376a;
                    TXCLog.i(str2, "requestUploadSig->rsp  " + jSONObject2.toString());
                    if (bVar.f31388a == 0) {
                        this.j = bVar.f31390c;
                        a(bVar);
                        return;
                    }
                    a("requestUploadSig", bVar.f31389b);
                    return;
                }
                a("requestUploadSig", "upload sign failed");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            a("uploadLogFiles", e2.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x012e A[SYNTHETIC, Splitter:B:23:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0134 A[SYNTHETIC, Splitter:B:27:0x0134] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.liteav.basic.log.a.b r11) {
        /*
            r10 = this;
            java.lang.String r0 = "uploadLogFiles"
            r1 = 0
            java.lang.String r2 = "https://%s.file.myqcloud.com/files/v2/%s/%s/%s/%s.zip"
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0121 }
            java.lang.String r4 = r11.h     // Catch:{ Exception -> 0x0121 }
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x0121 }
            r4 = 1
            java.lang.String r6 = r11.f31394g     // Catch:{ Exception -> 0x0121 }
            r3[r4] = r6     // Catch:{ Exception -> 0x0121 }
            java.lang.String r4 = r11.f31393f     // Catch:{ Exception -> 0x0121 }
            r6 = 2
            r3[r6] = r4     // Catch:{ Exception -> 0x0121 }
            r4 = 3
            java.lang.String r7 = r11.f31392e     // Catch:{ Exception -> 0x0121 }
            r3[r4] = r7     // Catch:{ Exception -> 0x0121 }
            r4 = 4
            java.lang.String r7 = r11.f31390c     // Catch:{ Exception -> 0x0121 }
            r3[r4] = r7     // Catch:{ Exception -> 0x0121 }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ Exception -> 0x0121 }
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0121 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0121 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0121 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r6 = "Authorization"
            java.lang.String r7 = r11.f31391d     // Catch:{ Exception -> 0x0121 }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r6 = "Content-Type"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0121 }
            r7.<init>()     // Catch:{ Exception -> 0x0121 }
            java.lang.String r8 = "multipart/form-data; boundary="
            r7.append(r8)     // Catch:{ Exception -> 0x0121 }
            r7.append(r3)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0121 }
            r4.put(r6, r7)     // Catch:{ Exception -> 0x0121 }
            java.lang.String r6 = r11.f31390c     // Catch:{ Exception -> 0x0121 }
            java.lang.String r6 = r10.b((java.lang.String) r6)     // Catch:{ Exception -> 0x0121 }
            if (r6 != 0) goto L_0x005f
            java.lang.String r11 = "zipLogFiles"
            java.lang.String r2 = "has no log files"
            r10.a((java.lang.String) r11, (java.lang.String) r2)     // Catch:{ Exception -> 0x0121 }
            return
        L_0x005f:
            r10.k = r6     // Catch:{ Exception -> 0x0121 }
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0121 }
            java.lang.String r7 = r10.k     // Catch:{ Exception -> 0x0121 }
            java.lang.String r8 = "r"
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x0121 }
            long r7 = r6.length()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r1 = (int) r7     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r6.readFully(r1)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r7 = "op"
            java.lang.String r8 = "upload"
            byte[] r7 = r10.a((java.lang.String) r3, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r8 = "filecontent"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r9.<init>()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r11 = r11.f31390c     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r9.append(r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r11 = ".zip"
            r9.append(r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r11 = r9.toString()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            byte[] r11 = r10.a(r3, r8, r11, r1)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r1.<init>()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r8 = "--"
            r1.append(r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r1.append(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r3 = "--\r\n"
            r1.append(r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r3 = r11.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r8 = r7.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r3 = r3 + r8
            int r8 = r1.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r3 = r3 + r8
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r8 = r7.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.System.arraycopy(r7, r5, r3, r5, r8)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r8 = r7.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r9 = r11.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.System.arraycopy(r11, r5, r3, r8, r9)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r11 = r11.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r7 = r7.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            int r11 = r11 + r7
            int r7 = r1.length     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.System.arraycopy(r1, r5, r3, r11, r7)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r11 = r10.a((java.lang.String) r2, (java.util.Map<java.lang.String, java.lang.String>) r4, (byte[]) r3)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r1.<init>(r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r11 = "code"
            int r11 = r1.getInt(r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r2 = "data"
            org.json.JSONObject r2 = r1.getJSONObject(r2)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r3 = f31376a     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r4.<init>()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r5 = "uploadLogFiles->rsp  "
            r4.append(r5)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r4.append(r1)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            com.tencent.liteav.basic.log.TXCLog.i(r3, r1)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            if (r11 != 0) goto L_0x0101
            java.lang.String r11 = "source_url"
            java.lang.String r11 = r2.getString(r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r10.a((java.lang.String) r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            goto L_0x0115
        L_0x0101:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r1.<init>()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r2 = ""
            r1.append(r2)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r1.append(r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
            r10.a((java.lang.String) r0, (java.lang.String) r11)     // Catch:{ Exception -> 0x011b, all -> 0x0119 }
        L_0x0115:
            r6.close()     // Catch:{ Exception -> 0x0131 }
            goto L_0x0131
        L_0x0119:
            r11 = move-exception
            goto L_0x0132
        L_0x011b:
            r11 = move-exception
            r1 = r6
            goto L_0x0122
        L_0x011e:
            r11 = move-exception
            r6 = r1
            goto L_0x0132
        L_0x0121:
            r11 = move-exception
        L_0x0122:
            r11.printStackTrace()     // Catch:{ all -> 0x011e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x011e }
            r10.a((java.lang.String) r0, (java.lang.String) r11)     // Catch:{ all -> 0x011e }
            if (r1 == 0) goto L_0x0131
            r1.close()     // Catch:{ Exception -> 0x0131 }
        L_0x0131:
            return
        L_0x0132:
            if (r6 == 0) goto L_0x0137
            r6.close()     // Catch:{ Exception -> 0x0137 }
        L_0x0137:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.log.a.a(com.tencent.liteav.basic.log.a$b):void");
    }

    private void a(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.f31379d.size(); i2++) {
                if (i2 != this.f31379d.size() - 1) {
                    sb.append(this.f31379d.get(i2));
                    sb.append(",");
                } else {
                    sb.append(this.f31379d.get(i2));
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (String next : this.f31382g) {
                if (sb2.length() != 0) {
                    sb2.append(",");
                }
                sb2.append(next);
            }
            String format = String.format("Android:%s :%s :%s", new Object[]{TXCCommonUtil.getSDKVersionStr(), com.tencent.liteav.basic.util.b.c(), com.tencent.liteav.basic.util.b.d()});
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AppsFlyerProperties.APP_ID, this.f31378c);
            jSONObject.put("sdkappid", this.l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileurl", str);
            jSONObject2.put("desc", format);
            jSONObject2.put("userid", sb2);
            jSONObject2.put("logkey", this.j);
            jSONObject2.put("file_list", sb.toString());
            jSONObject.put("data", jSONObject2);
            JSONObject jSONObject3 = new JSONObject(a("https://avc.qcloud.com/log/report.php", (Map<String, String>) null, jSONObject.toString().getBytes("utf-8")));
            String str2 = f31376a;
            TXCLog.i(str2, "reportUploadResult->rsp  " + jSONObject3.toString());
            this.m = System.currentTimeMillis();
            this.f31380e.clear();
            if (!(this.f31381f == null || this.f31381f.f31386b == null)) {
                this.f31380e.put(this.f31381f.f31386b, this.f31381f);
            }
            d();
            new File(this.k).delete();
        } catch (Exception e2) {
            e2.printStackTrace();
            a("reportUploadResult", e2.toString());
        }
    }

    private String a(String str, Map<String, String> map, byte[] bArr) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setConnectTimeout(5000);
            httpsURLConnection.setReadTimeout(5000);
            httpsURLConnection.setRequestMethod("POST");
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    httpsURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
                }
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            String str2 = f31376a;
            TXCLog.i(str2, "postDataThroughHttps->response code: " + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr2, 0, bArr2.length);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        inputStream.close();
                        httpsURLConnection.disconnect();
                        return byteArrayOutputStream.toString();
                    }
                }
            } else {
                throw new Exception("response: " + responseCode);
            }
        } catch (Exception e2) {
            TXCLog.i(f31376a, "postDataThroughHttps->response exception: ");
            e2.printStackTrace();
            return "";
        }
    }

    private boolean a(File file) {
        try {
            String logFilePath = TXCLog.getLogFilePath();
            String absolutePath = file.getAbsolutePath();
            if (!file.isFile() || this.m >= file.lastModified() || absolutePath.equalsIgnoreCase(logFilePath)) {
                return false;
            }
            String name = file.getName();
            String substring = name.substring(name.lastIndexOf(".") + 1);
            if (substring == null || !substring.equalsIgnoreCase("xlog")) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private String b(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry next : this.f31380e.entrySet()) {
            String str2 = (String) next.getKey();
            TXCLog.d(f31376a, "ready to upload : " + this.m + ", " + str2 + "\n");
            File file = new File(str2);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        TXCLog.d(f31376a, "ready to upload : " + file2.lastModified() + ", " + file2.getAbsolutePath() + "\n");
                        if (a(file2)) {
                            this.f31379d.add(file2.getName());
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                    this.f31382g.addAll(((C0487a) next.getValue()).f31385a);
                }
            }
        }
        for (String str3 : arrayList) {
            TXCLog.d(f31376a, "finally upload : " + str3 + "\n");
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        String str4 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/log/tencent/temp/";
        File file3 = new File(str4);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        String str5 = str4 + Constants.URL_PATH_DELIMITER + str + ".zip";
        a((List<String>) arrayList, str5);
        return str5;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v9, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:46|47|48|49|62) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0079, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007a, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.tencent.liteav.basic.log.TXCLog.w(f31376a, "zip log error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x007c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.List<java.lang.String> r6, java.lang.String r7) {
        /*
            r5 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r7 = 0
            java.util.zip.ZipOutputStream r1 = new java.util.zip.ZipOutputStream     // Catch:{ FileNotFoundException -> 0x007c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x007c }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x007c }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x007c }
            java.lang.String r0 = "LiteAV log"
            r1.setComment(r0)     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
        L_0x0019:
            boolean r0 = r6.hasNext()     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
            if (r0 == 0) goto L_0x0071
            java.lang.Object r0 = r6.next()     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.util.zip.ZipEntry r7 = new java.util.zip.ZipEntry     // Catch:{ Exception -> 0x0051 }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0051 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x0051 }
            r1.putNextEntry(r7)     // Catch:{ Exception -> 0x0051 }
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x0051 }
        L_0x003f:
            int r2 = r0.read(r7)     // Catch:{ Exception -> 0x0051 }
            r3 = -1
            if (r2 == r3) goto L_0x004b
            r3 = 0
            r1.write(r7, r3, r2)     // Catch:{ Exception -> 0x0051 }
            goto L_0x003f
        L_0x004b:
            r0.close()     // Catch:{ Exception -> 0x004f }
            goto L_0x0065
        L_0x004f:
            r7 = move-exception
            goto L_0x0062
        L_0x0051:
            r7 = move-exception
            goto L_0x005a
        L_0x0053:
            r6 = move-exception
            r0 = r7
            goto L_0x0068
        L_0x0056:
            r0 = move-exception
            r4 = r0
            r0 = r7
            r7 = r4
        L_0x005a:
            r7.printStackTrace()     // Catch:{ all -> 0x0067 }
            r0.close()     // Catch:{ Exception -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r7 = move-exception
        L_0x0062:
            r7.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
        L_0x0065:
            r7 = r0
            goto L_0x0019
        L_0x0067:
            r6 = move-exception
        L_0x0068:
            r0.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
        L_0x0070:
            throw r6     // Catch:{ FileNotFoundException -> 0x0077, all -> 0x0075 }
        L_0x0071:
            r1.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0075:
            r6 = move-exception
            goto L_0x008c
        L_0x0077:
            r7 = r1
            goto L_0x007c
        L_0x0079:
            r6 = move-exception
            r1 = r7
            goto L_0x008c
        L_0x007c:
            java.lang.String r6 = f31376a     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = "zip log error"
            com.tencent.liteav.basic.log.TXCLog.w(r6, r0)     // Catch:{ all -> 0x0079 }
            r7.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008b:
            return
        L_0x008c:
            r1.close()     // Catch:{ Exception -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0094:
            goto L_0x0096
        L_0x0095:
            throw r6
        L_0x0096:
            goto L_0x0095
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.basic.log.a.a(java.util.List, java.lang.String):void");
    }

    private byte[] a(String str, String str2, String str3) {
        return ("--" + str + "\r\nContent-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + str3 + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes();
    }

    private byte[] a(String str, String str2, String str3, byte[] bArr) {
        byte[] bytes = ("--" + str + "\r\nContent-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\nContent-Type: application/octet-stream\"\r\n\r\n").getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length + 2)];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        System.arraycopy(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes(), 0, bArr2, bytes.length + bArr.length, 2);
        return bArr2;
    }

    private void a(String str, String str2) {
        String str3 = f31376a;
        TXCLog.w(str3, "log upload " + str + " catch error " + str2);
    }

    private void d() {
        if (this.i != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, C0487a> value : this.f31380e.entrySet()) {
                    C0487a aVar = (C0487a) value.getValue();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("logPath", aVar.f31386b);
                    jSONObject.put("roomId", aVar.f31387c);
                    jSONObject.put("userList", aVar.a());
                    jSONArray.put(jSONObject);
                }
                SharedPreferences.Editor edit = this.i.getSharedPreferences("liteav_log_upload_config", 0).edit();
                edit.putString("liteav_log_upload_record", jSONArray.toString());
                edit.putInt("liteav_log_upload_appid", this.l);
                edit.putLong("liteav_log_upload_time", this.m);
                edit.commit();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        try {
            if (this.i != null) {
                SharedPreferences sharedPreferences = this.i.getSharedPreferences("liteav_log_upload_config", 0);
                this.l = sharedPreferences.getInt("liteav_log_upload_appid", 0);
                this.m = sharedPreferences.getLong("liteav_log_upload_time", 0);
                String string = sharedPreferences.getString("liteav_log_upload_record", "");
                if (!TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        C0487a aVar = new C0487a();
                        aVar.f31387c = jSONObject.optInt("roomId", 0);
                        aVar.f31386b = jSONObject.optString("logPath");
                        aVar.a(jSONObject.optString("userList"));
                        if (!TextUtils.isEmpty(aVar.f31386b)) {
                            this.f31380e.put(aVar.f31386b, aVar);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        if (this.h == null) {
            HandlerThread handlerThread = new HandlerThread("logThread");
            handlerThread.start();
            this.h = new Handler(handlerThread.getLooper());
            this.h.post(new Runnable() {
                public void run() {
                    a.this.e();
                }
            });
        }
    }
}
