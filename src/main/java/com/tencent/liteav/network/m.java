package com.tencent.liteav.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.b;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {

    /* renamed from: a  reason: collision with root package name */
    protected static m f31834a = new m();

    /* renamed from: b  reason: collision with root package name */
    private Context f31835b = null;

    /* renamed from: c  reason: collision with root package name */
    private long f31836c = 3;

    public static m a() {
        return f31834a;
    }

    protected m() {
    }

    public void a(Context context) {
        if (this.f31835b == null) {
            this.f31835b = context.getApplicationContext();
        }
    }

    public String b() {
        try {
            if (this.f31835b != null) {
                int d2 = b.d(this.f31835b);
                if (d2 == 0) {
                    return "";
                }
                if (d2 == 1) {
                    WifiManager wifiManager = (WifiManager) this.f31835b.getSystemService("wifi");
                    if (wifiManager != null) {
                        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                        if (connectionInfo != null) {
                            return "wifi:" + connectionInfo.getSSID();
                        }
                    }
                } else if (d2 == 2) {
                    return "4g:";
                } else {
                    if (d2 == 3) {
                        return "3g:";
                    }
                    if (d2 == 4) {
                        return "2g:";
                    }
                    return d2 == 5 ? "ethernet:" : "xg:";
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public void a(String str, long j, long j2, long j3, float f2, float f3, float f4) {
        String str2 = str;
        if (com.tencent.liteav.basic.e.b.a().a("Network", "QualityDataCacheCount") > 0) {
            TXCLog.e("UploadQualityData", String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", new Object[]{str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}));
            if (!b(str)) {
                try {
                    SharedPreferences sharedPreferences = this.f31835b.getSharedPreferences("com.tencent.liteav.network", 0);
                    JSONObject c2 = c(sharedPreferences.getString("34238512-C08C-4931-A000-40E1D8B5BA5B", ""));
                    JSONObject optJSONObject = c2.optJSONObject(str);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = j == 3 ? "DomainArrayData" : "OriginArrayData";
                    JSONArray optJSONArray = optJSONObject.optJSONArray(str3);
                    if (optJSONArray == null) {
                        optJSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("totalTime", j2);
                    jSONObject.put("networkRTT", j3);
                    jSONObject.put("avgBlockCnt", (double) f2);
                    jSONObject.put("avgVideoQue", (double) f3);
                    jSONObject.put("avgAudioQue", (double) f4);
                    optJSONArray.put(jSONObject);
                    int length = optJSONArray.length();
                    long j4 = (long) length;
                    if (j4 > this.f31836c) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i = (int) (j4 - this.f31836c); i < length; i++) {
                            jSONArray.put(optJSONArray.get(i));
                        }
                        optJSONArray = jSONArray;
                    }
                    optJSONObject.put(str3, optJSONArray);
                    c2.put(str, optJSONObject);
                    sharedPreferences.edit().putString("34238512-C08C-4931-A000-40E1D8B5BA5B", c2.toString()).commit();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean c() {
        d();
        String b2 = b();
        String str = "isDomainAddressBetter: accessID = " + b2 + " minQualityDataCount = " + this.f31836c;
        a a2 = a(b2, true);
        a a3 = a(b2, false);
        if (a2 != null) {
            str = String.format("%s \n isDomainAddressBetter：domainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str, Long.valueOf(a2.f31841e), Float.valueOf(a2.f31837a), Float.valueOf(a2.f31838b), Float.valueOf(a2.f31839c), Float.valueOf(a2.f31840d)});
        }
        if (a3 != null) {
            str = String.format("%s \n isDomainAddressBetter：originQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str, Long.valueOf(a3.f31841e), Float.valueOf(a3.f31837a), Float.valueOf(a3.f31838b), Float.valueOf(a3.f31839c), Float.valueOf(a3.f31840d)});
        }
        TXCLog.e("UploadQualityData", str);
        if (a2 == null || a2.f31841e < this.f31836c || a3 == null || a3.f31841e < this.f31836c || a2.f31838b >= a3.f31838b || a2.f31839c >= a3.f31839c || a2.f31840d >= a3.f31840d) {
            return false;
        }
        return true;
    }

    protected class a {

        /* renamed from: a  reason: collision with root package name */
        public float f31837a = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: b  reason: collision with root package name */
        public float f31838b = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: c  reason: collision with root package name */
        public float f31839c = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: d  reason: collision with root package name */
        public float f31840d = BitmapDescriptorFactory.HUE_RED;

        /* renamed from: e  reason: collision with root package name */
        public long f31841e = 0;

        protected a() {
        }
    }

    private a a(String str, boolean z) {
        if (b(str)) {
            return null;
        }
        try {
            String string = this.f31835b.getSharedPreferences("com.tencent.liteav.network", 0).getString("34238512-C08C-4931-A000-40E1D8B5BA5B", "");
            if (b(string)) {
                return null;
            }
            JSONObject optJSONObject = new JSONObject(string).optJSONObject(str);
            if (optJSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray(z ? "DomainArrayData" : "OriginArrayData");
            if (optJSONArray == null) {
                return null;
            }
            long length = (long) optJSONArray.length();
            if (length == 0) {
                return null;
            }
            String str2 = "";
            float f2 = BitmapDescriptorFactory.HUE_RED;
            int i = 0;
            float f3 = BitmapDescriptorFactory.HUE_RED;
            float f4 = BitmapDescriptorFactory.HUE_RED;
            float f5 = BitmapDescriptorFactory.HUE_RED;
            while (((long) i) < length) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                long j = length;
                float optLong = f2 + ((float) jSONObject.optLong("networkRTT"));
                double d2 = (double) f3;
                double optDouble = jSONObject.optDouble("avgBlockCnt");
                Double.isNaN(d2);
                f3 = (float) (d2 + optDouble);
                double d3 = (double) f4;
                double optDouble2 = jSONObject.optDouble("avgVideoQue");
                Double.isNaN(d3);
                f4 = (float) (d3 + optDouble2);
                double d4 = (double) f5;
                double optDouble3 = jSONObject.optDouble("avgAudioQue");
                Double.isNaN(d4);
                f5 = (float) (d4 + optDouble3);
                str2 = String.format("%s \n isDomainAddressBetter：itemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", new Object[]{str2, Boolean.valueOf(z), Long.valueOf(jSONObject.optLong("networkRTT")), Double.valueOf(jSONObject.optDouble("avgBlockCnt")), Double.valueOf(jSONObject.optDouble("avgVideoQue")), Double.valueOf(jSONObject.optDouble("avgAudioQue"))});
                i++;
                f2 = optLong;
                length = j;
            }
            long j2 = length;
            float f6 = (float) j2;
            float f7 = f2 / f6;
            float f8 = f3 / f6;
            float f9 = f4 / f6;
            float f10 = f5 / f6;
            a aVar = new a();
            aVar.f31837a = f7;
            aVar.f31838b = f8;
            aVar.f31839c = f9;
            aVar.f31840d = f10;
            aVar.f31841e = j2;
            return aVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private boolean b(String str) {
        return str == null || str.length() == 0;
    }

    private JSONObject c(String str) {
        if (!b(str)) {
            try {
                return new JSONObject(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return new JSONObject();
    }

    private void d() {
        this.f31836c = com.tencent.liteav.basic.e.b.a().a("Network", "QualityDataCacheCount");
        long j = this.f31836c;
        if (j == -1 || j < 3) {
            this.f31836c = 3;
        }
    }

    public long a(String str) {
        Context context = this.f31835b;
        if (context != null) {
            return context.getSharedPreferences("com.tencent.liteav.network", 0).getLong(str, 0);
        }
        return 0;
    }

    public void a(String str, long j) {
        Context context = this.f31835b;
        if (context != null) {
            context.getSharedPreferences("com.tencent.liteav.network", 0).edit().putLong(str, j).commit();
        }
    }
}
