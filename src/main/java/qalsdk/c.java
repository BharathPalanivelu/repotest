package qalsdk;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.core.j;
import com.tencent.qalsdk.core.l;
import com.tencent.qalsdk.core.m;
import com.tencent.qalsdk.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> f34119a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> f34120b;

    /* renamed from: c  reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> f34121c;

    /* renamed from: d  reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> f34122d;

    /* renamed from: e  reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> f34123e;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> f34124f;

    /* renamed from: g  reason: collision with root package name */
    private j f34125g;
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> h = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> i = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<com.tencent.qalsdk.core.c> j = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, Object> k = new ConcurrentHashMap<>();
    private boolean l = false;

    public c(j jVar) {
        this.f34125g = jVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a() {
        /*
            java.lang.Class<qalsdk.c> r0 = qalsdk.c.class
            monitor-enter(r0)
            com.tencent.qalsdk.core.j r1 = com.tencent.qalsdk.core.j.a()     // Catch:{ all -> 0x0061 }
            android.content.Context r1 = r1.k     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ all -> 0x0061 }
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1     // Catch:{ all -> 0x0061 }
            r2 = 0
            if (r1 == 0) goto L_0x005f
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x005d
            int r3 = r1.getType()     // Catch:{ all -> 0x0061 }
            if (r3 != 0) goto L_0x005d
            boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x0061 }
            r3 = 2
            if (r2 == 0) goto L_0x003e
            java.lang.String r2 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "connect to mobile network "
            r4.<init>(r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r1.getSubtypeName()     // Catch:{ all -> 0x0061 }
            r4.append(r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0061 }
            com.tencent.qalsdk.util.QLog.d(r2, r3, r4)     // Catch:{ all -> 0x0061 }
        L_0x003e:
            java.lang.String r1 = r1.getExtraInfo()     // Catch:{ all -> 0x0061 }
            boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x005b
            java.lang.String r2 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "current apn:"
            r4.<init>(r5)     // Catch:{ all -> 0x0061 }
            r4.append(r1)     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0061 }
            com.tencent.qalsdk.util.QLog.d(r2, r3, r4)     // Catch:{ all -> 0x0061 }
        L_0x005b:
            monitor-exit(r0)
            return r1
        L_0x005d:
            monitor-exit(r0)
            return r2
        L_0x005f:
            monitor-exit(r0)
            return r2
        L_0x0061:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.a():java.lang.String");
    }

    public static synchronized int b() {
        int i2;
        synchronized (c.class) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.a().k.getSystemService("connectivity")).getActiveNetworkInfo();
            i2 = 100;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (subtype == 7) {
                        i2 = 107;
                    } else if (subtype == 4) {
                        i2 = 104;
                    } else if (subtype == 2) {
                        i2 = 102;
                    } else if (subtype == 14) {
                        i2 = 114;
                    } else if (subtype == 5) {
                        i2 = 105;
                    } else if (subtype == 6) {
                        i2 = 106;
                    } else if (subtype == 12) {
                        i2 = 112;
                    } else if (subtype == 1) {
                        i2 = 101;
                    } else if (subtype == 8) {
                        i2 = 108;
                    } else if (subtype == 10) {
                        i2 = 110;
                    } else if (subtype == 15) {
                        i2 = 115;
                    } else if (subtype == 9) {
                        i2 = 109;
                    } else if (subtype == 11) {
                        i2 = 111;
                    } else if (subtype == 13) {
                        i2 = 113;
                    } else if (subtype == 3) {
                        i2 = 103;
                    }
                }
            }
        }
        return i2;
    }

    public static synchronized String c() {
        synchronized (c.class) {
            WifiInfo connectionInfo = ((WifiManager) j.a().k.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo.getSSID() == null) {
                return null;
            }
            String replaceAll = connectionInfo.getSSID().replaceAll("\"", "");
            if (replaceAll.equals("<unknown ssid>")) {
                return null;
            }
            return replaceAll;
        }
    }

    public static synchronized ak d() {
        synchronized (c.class) {
            ak akVar = new ak();
            akVar.f34097a = "wifi";
            WifiInfo connectionInfo = ((WifiManager) j.a().k.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return akVar;
            }
            if (!(connectionInfo.getSupplicantState() == null || connectionInfo.getSupplicantState().toString() == null)) {
                akVar.f34098b = connectionInfo.getSupplicantState().toString();
            }
            if (connectionInfo.getSSID() != null) {
                akVar.f34099c = connectionInfo.getSSID().replaceAll("\"", "");
            }
            if (connectionInfo.getBSSID() != null) {
                akVar.f34100d = connectionInfo.getBSSID();
            }
            akVar.f34101e = connectionInfo.getRssi();
            return akVar;
        }
    }

    public final void e() {
        this.f34119a = new CopyOnWriteArrayList<>();
        this.f34120b = new CopyOnWriteArrayList<>();
        this.f34119a.add(com.tencent.qalsdk.core.c.a("socket://openmsf.3g.qq.com:443#00000:0:1"));
        this.f34119a.add(com.tencent.qalsdk.core.c.a("socket://59.37.116.121:8080#00000:0:1"));
        this.f34119a.add(com.tencent.qalsdk.core.c.a("socket://111.30.144.145:14000#00000:0:1"));
        this.f34119a.add(com.tencent.qalsdk.core.c.a("socket://223.167.154.46:80#00000:0:1"));
        this.f34119a.add(com.tencent.qalsdk.core.c.a("socket://123.151.137.108:80#00000:0:1"));
        this.f34119a.add(com.tencent.qalsdk.core.c.a("socket://183.232.96.17:443#00000:0:1"));
        this.f34121c = new CopyOnWriteArrayList<>();
        this.f34122d = new CopyOnWriteArrayList<>();
        this.f34123e = new CopyOnWriteArrayList<>();
        this.f34124f = new CopyOnWriteArrayList<>();
        this.f34121c.add(com.tencent.qalsdk.core.c.a("socket://183.232.96.17:14000#46000_46002:0:1"));
        this.f34121c.add(com.tencent.qalsdk.core.c.a("socket://111.30.144.145:80#46000_46002:0:1"));
        this.f34121c.add(com.tencent.qalsdk.core.c.a("socket://openmsf.3g.qq.com:8080#46000_46002:0:1"));
        this.f34121c.add(com.tencent.qalsdk.core.c.a("socket://117.135.172.198:443#46000_46002:0:1"));
        this.f34121c.add(com.tencent.qalsdk.core.c.a("socket://59.37.116.121:14000#46000_46002:0:1"));
        this.f34122d.add(com.tencent.qalsdk.core.c.a("socket://163.177.56.123:14000#46001:0:1"));
        this.f34122d.add(com.tencent.qalsdk.core.c.a("socket://123.126.122.69:80#46001:0:1"));
        this.f34122d.add(com.tencent.qalsdk.core.c.a("socket://openmsf.3g.qq.com:8080#46001:0:1"));
        this.f34122d.add(com.tencent.qalsdk.core.c.a("socket://223.167.154.46:443#46001:0:1"));
        this.f34122d.add(com.tencent.qalsdk.core.c.a("socket://59.37.116.121:14000#46001:0:1"));
        this.f34123e.add(com.tencent.qalsdk.core.c.a("socket://59.37.116.121:14000#46003:0:1"));
        this.f34123e.add(com.tencent.qalsdk.core.c.a("socket://123.151.137.108:80#46003:0:1"));
        this.f34123e.add(com.tencent.qalsdk.core.c.a("socket://openmsf.3g.qq.com:8080#46003:0:1"));
        this.f34123e.add(com.tencent.qalsdk.core.c.a("socket://101.226.233.199:443#46003:0:1"));
        this.f34123e.add(com.tencent.qalsdk.core.c.a("socket://163.177.56.123:14000#46003:0:1"));
        this.f34124f.add(com.tencent.qalsdk.core.c.a("socket://203.205.151.207:14000#00000:0:1"));
        this.f34124f.add(com.tencent.qalsdk.core.c.a("socket://openmsf.3g.qq.com:8080#00000:0:1"));
        this.f34124f.add(com.tencent.qalsdk.core.c.a("socket://59.37.116.121:80#00000:0:1"));
        m();
        k();
        o();
        l();
        a(c());
    }

    private synchronized void k() {
        SharedPreferences sharedPreferences = this.f34125g.k.getSharedPreferences("wifiused", 0);
        int i2 = sharedPreferences.getInt("wifiUsedCount", 0);
        for (int i3 = 0; i3 < i2; i3++) {
            String string = sharedPreferences.getString("wifiname" + i3, "");
            long j2 = sharedPreferences.getLong("wifitime" + i3, 0);
            if (string != null && j2 > 0) {
                this.k.put(string, Long.valueOf(j2));
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.SsoListManager", 2, "get a ssid " + string + " time = " + j2);
                }
            }
        }
    }

    private synchronized void a(String str) {
        if (str != null) {
            int i2 = 0;
            SharedPreferences sharedPreferences = this.f34125g.k.getSharedPreferences("wifiused", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.k.containsKey(str)) {
                this.k.put(str, Long.valueOf(currentTimeMillis));
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.SsoListManager", 2, "find ssid: " + str + " update time = " + currentTimeMillis);
                }
            } else {
                int size = this.k.size();
                long currentTimeMillis2 = System.currentTimeMillis();
                String str2 = null;
                if (size >= 10) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.SsoListManager", 2, "too much ssid need to delete one find Least Recently Used now...");
                    }
                    for (Map.Entry next : this.k.entrySet()) {
                        if (next != null) {
                            long longValue = ((Long) next.getValue()).longValue();
                            if (longValue < currentTimeMillis2) {
                                str2 = (String) next.getKey();
                                currentTimeMillis2 = longValue;
                            }
                        }
                    }
                    if (str2 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.SsoListManager", 2, "Least Recently Used ssid find delete now: " + str2);
                        }
                        this.k.remove(str2);
                        l.a().n_removeConfig("__loginSdk_ssoWifilist_" + str2);
                    }
                }
                this.k.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("wifiUsedCount", this.k.size());
            for (Map.Entry next2 : this.k.entrySet()) {
                if (next2 != null) {
                    long longValue2 = ((Long) next2.getValue()).longValue();
                    String str3 = (String) next2.getKey();
                    if (str3 != null) {
                        edit.putString("wifiname" + i2, str3);
                        edit.putLong("wifitime" + i2, longValue2);
                        i2++;
                    }
                }
            }
            edit.commit();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0129 }
            r0.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r1 = a()     // Catch:{ all -> 0x0129 }
            if (r1 != 0) goto L_0x000e
            monitor-exit(r8)
            return
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = "__loginSdk_ssoMobilelist_"
            r2.<init>(r3)     // Catch:{ all -> 0x0129 }
            r2.append(r1)     // Catch:{ all -> 0x0129 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.config.NativeConfigStore r2 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = r2.getConfig(r1)     // Catch:{ all -> 0x0129 }
            r3 = 0
            r4 = 2
            if (r2 == 0) goto L_0x005d
            int r5 = r2.length()     // Catch:{ all -> 0x0129 }
            if (r5 != 0) goto L_0x002f
            goto L_0x005d
        L_0x002f:
            boolean r5 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x0050
            java.lang.String r5 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            java.lang.String r7 = "a old apn loadSsoStoreForCurrentAPN mobile: "
            r6.<init>(r7)     // Catch:{ all -> 0x0129 }
            r6.append(r1)     // Catch:{ all -> 0x0129 }
            java.lang.String r7 = " "
            r6.append(r7)     // Catch:{ all -> 0x0129 }
            r6.append(r2)     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.util.QLog.d(r5, r4, r6)     // Catch:{ all -> 0x0129 }
        L_0x0050:
            if (r2 == 0) goto L_0x00d7
            int r4 = r2.length()     // Catch:{ all -> 0x0129 }
            if (r4 <= 0) goto L_0x00d7
            r8.a((java.lang.String) r2, (java.util.ArrayList<com.tencent.qalsdk.core.c>) r0)     // Catch:{ all -> 0x0129 }
            goto L_0x00d7
        L_0x005d:
            com.tencent.qalsdk.config.NativeConfigStore r2 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = "__loginSdk_ssolist"
            java.lang.String r2 = r2.getConfig(r3)     // Catch:{ all -> 0x0129 }
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x0129 }
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = "loadSsoStoreForCurrentAPN get a new apn, ssoStore from __loginSdk_ssolist "
            r5.<init>(r6)     // Catch:{ all -> 0x0129 }
            r5.append(r2)     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.util.QLog.d(r3, r4, r5)     // Catch:{ all -> 0x0129 }
        L_0x0080:
            if (r2 == 0) goto L_0x00ae
            int r3 = r2.length()     // Catch:{ all -> 0x0129 }
            if (r3 <= 0) goto L_0x00ae
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0129 }
            r3.<init>()     // Catch:{ all -> 0x0129 }
            r8.a((java.lang.String) r2, (java.util.ArrayList<com.tencent.qalsdk.core.c>) r3)     // Catch:{ all -> 0x0129 }
            java.util.Iterator r2 = r3.iterator()     // Catch:{ all -> 0x0129 }
        L_0x0094:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0129 }
            if (r3 == 0) goto L_0x00d6
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.core.c r3 = (com.tencent.qalsdk.core.c) r3     // Catch:{ all -> 0x0129 }
            java.lang.String r4 = r3.f32171c     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = "00000"
            int r4 = r4.indexOf(r5)     // Catch:{ all -> 0x0129 }
            if (r4 >= 0) goto L_0x0094
            r0.add(r3)     // Catch:{ all -> 0x0129 }
            goto L_0x0094
        L_0x00ae:
            boolean r2 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = "loadSsoStoreForCurrentAPN a new apn get from defaultMobileSso mobile: "
            r3.<init>(r5)     // Catch:{ all -> 0x0129 }
            r3.append(r1)     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = " "
            r3.append(r5)     // Catch:{ all -> 0x0129 }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r5 = r8.f34120b     // Catch:{ all -> 0x0129 }
            r3.append(r5)     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.util.QLog.d(r2, r4, r3)     // Catch:{ all -> 0x0129 }
        L_0x00d1:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r2 = r8.f34120b     // Catch:{ all -> 0x0129 }
            r0.addAll(r2)     // Catch:{ all -> 0x0129 }
        L_0x00d6:
            r3 = 1
        L_0x00d7:
            int r2 = r0.size()     // Catch:{ all -> 0x0129 }
            if (r2 <= 0) goto L_0x00e7
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r2 = r8.i     // Catch:{ all -> 0x0129 }
            r2.clear()     // Catch:{ all -> 0x0129 }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r2 = r8.i     // Catch:{ all -> 0x0129 }
            r2.addAll(r0)     // Catch:{ all -> 0x0129 }
        L_0x00e7:
            if (r3 == 0) goto L_0x0124
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x0129 }
            r0.<init>()     // Catch:{ all -> 0x0129 }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r2 = r8.i     // Catch:{ all -> 0x0129 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0129 }
        L_0x00f4:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0129 }
            if (r3 == 0) goto L_0x0119
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.core.c r3 = (com.tencent.qalsdk.core.c) r3     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r4.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0129 }
            r4.append(r3)     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = ";"
            r4.append(r3)     // Catch:{ all -> 0x0129 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0129 }
            r0.append(r3)     // Catch:{ all -> 0x0129 }
            goto L_0x00f4
        L_0x0119:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0129 }
            com.tencent.qalsdk.config.NativeConfigStore r2 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x0129 }
            r2.n_setConfig(r1, r0)     // Catch:{ all -> 0x0129 }
        L_0x0124:
            r8.m()     // Catch:{ all -> 0x0129 }
            monitor-exit(r8)
            return
        L_0x0129:
            r0 = move-exception
            monitor-exit(r8)
            goto L_0x012d
        L_0x012c:
            throw r0
        L_0x012d:
            goto L_0x012c
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.f():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void g() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x011f }
            r0.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r1 = c()     // Catch:{ all -> 0x011f }
            if (r1 != 0) goto L_0x000e
            monitor-exit(r9)
            return
        L_0x000e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r3 = "__loginSdk_ssoWifilist_"
            r2.<init>(r3)     // Catch:{ all -> 0x011f }
            r2.append(r1)     // Catch:{ all -> 0x011f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.config.NativeConfigStore r3 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r3.getConfig(r2)     // Catch:{ all -> 0x011f }
            r4 = 0
            r5 = 2
            if (r3 == 0) goto L_0x0058
            int r6 = r3.length()     // Catch:{ all -> 0x011f }
            if (r6 != 0) goto L_0x002f
            goto L_0x0058
        L_0x002f:
            boolean r6 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x011f }
            if (r6 == 0) goto L_0x004b
            java.lang.String r6 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r8 = "a old ssid loadSsoStoreForCurrentSSID wifi: "
            r7.<init>(r8)     // Catch:{ all -> 0x011f }
            r7.append(r2)     // Catch:{ all -> 0x011f }
            r7.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.util.QLog.d(r6, r5, r7)     // Catch:{ all -> 0x011f }
        L_0x004b:
            if (r3 == 0) goto L_0x00cd
            int r5 = r3.length()     // Catch:{ all -> 0x011f }
            if (r5 <= 0) goto L_0x00cd
            r9.a((java.lang.String) r3, (java.util.ArrayList<com.tencent.qalsdk.core.c>) r0)     // Catch:{ all -> 0x011f }
            goto L_0x00cd
        L_0x0058:
            com.tencent.qalsdk.config.NativeConfigStore r3 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "__loginSdk_ssolist"
            java.lang.String r3 = r3.getConfig(r4)     // Catch:{ all -> 0x011f }
            boolean r4 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x007b
            java.lang.String r4 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r7 = "loadSsoStoreForCurrentSSID get a new ssid, ssoStore from __loginSdk_ssolist"
            r6.<init>(r7)     // Catch:{ all -> 0x011f }
            r6.append(r3)     // Catch:{ all -> 0x011f }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.util.QLog.d(r4, r5, r6)     // Catch:{ all -> 0x011f }
        L_0x007b:
            if (r3 == 0) goto L_0x00a9
            int r4 = r3.length()     // Catch:{ all -> 0x011f }
            if (r4 <= 0) goto L_0x00a9
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x011f }
            r4.<init>()     // Catch:{ all -> 0x011f }
            r9.a((java.lang.String) r3, (java.util.ArrayList<com.tencent.qalsdk.core.c>) r4)     // Catch:{ all -> 0x011f }
            java.util.Iterator r3 = r4.iterator()     // Catch:{ all -> 0x011f }
        L_0x008f:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x00cc
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.core.c r4 = (com.tencent.qalsdk.core.c) r4     // Catch:{ all -> 0x011f }
            java.lang.String r5 = r4.f32171c     // Catch:{ all -> 0x011f }
            java.lang.String r6 = "00000"
            int r5 = r5.indexOf(r6)     // Catch:{ all -> 0x011f }
            if (r5 < 0) goto L_0x008f
            r0.add(r4)     // Catch:{ all -> 0x011f }
            goto L_0x008f
        L_0x00a9:
            boolean r3 = com.tencent.qalsdk.util.QLog.isColorLevel()     // Catch:{ all -> 0x011f }
            if (r3 == 0) goto L_0x00c7
            java.lang.String r3 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r6 = "loadSsoStoreForCurrentSSID a new ssid get from defaultWifiSso wifi: "
            r4.<init>(r6)     // Catch:{ all -> 0x011f }
            r4.append(r2)     // Catch:{ all -> 0x011f }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r6 = r9.f34119a     // Catch:{ all -> 0x011f }
            r4.append(r6)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.util.QLog.d(r3, r5, r4)     // Catch:{ all -> 0x011f }
        L_0x00c7:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r3 = r9.f34119a     // Catch:{ all -> 0x011f }
            r0.addAll(r3)     // Catch:{ all -> 0x011f }
        L_0x00cc:
            r4 = 1
        L_0x00cd:
            int r3 = r0.size()     // Catch:{ all -> 0x011f }
            if (r3 <= 0) goto L_0x00dd
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r3 = r9.h     // Catch:{ all -> 0x011f }
            r3.clear()     // Catch:{ all -> 0x011f }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r3 = r9.h     // Catch:{ all -> 0x011f }
            r3.addAll(r0)     // Catch:{ all -> 0x011f }
        L_0x00dd:
            if (r4 == 0) goto L_0x011a
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x011f }
            r0.<init>()     // Catch:{ all -> 0x011f }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r3 = r9.h     // Catch:{ all -> 0x011f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x011f }
        L_0x00ea:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x010f
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.core.c r4 = (com.tencent.qalsdk.core.c) r4     // Catch:{ all -> 0x011f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            r5.<init>()     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x011f }
            r5.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = ";"
            r5.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x011f }
            r0.append(r4)     // Catch:{ all -> 0x011f }
            goto L_0x00ea
        L_0x010f:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011f }
            com.tencent.qalsdk.config.NativeConfigStore r3 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x011f }
            r3.n_setConfig(r2, r0)     // Catch:{ all -> 0x011f }
        L_0x011a:
            r9.a((java.lang.String) r1)     // Catch:{ all -> 0x011f }
            monitor-exit(r9)
            return
        L_0x011f:
            r0 = move-exception
            monitor-exit(r9)
            goto L_0x0123
        L_0x0122:
            throw r0
        L_0x0123:
            goto L_0x0122
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.g():void");
    }

    private synchronized void l() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = "__loginSdk_ssoWifilist";
        String c2 = c();
        if (c2 != null) {
            str = (str + "_") + c2;
        }
        String config = l.a().getConfig(str);
        String str2 = "__loginSdk_ssoMobilelist";
        String a2 = a();
        if (a2 != null) {
            str2 = str2 + "_" + a2;
        }
        String config2 = l.a().getConfig(str2);
        if (config == null || config.length() == 0) {
            if (config2 != null) {
                if (config2.length() == 0) {
                }
            }
            String config3 = l.a().getConfig("__loginSdk_ssolist");
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SsoListManager", 2, "load ssoStore " + config3);
            }
            if (config3 != null && config3.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                a(config3, (ArrayList<com.tencent.qalsdk.core.c>) arrayList3);
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    com.tencent.qalsdk.core.c cVar = (com.tencent.qalsdk.core.c) it.next();
                    if (cVar.f32171c.indexOf("00000") >= 0) {
                        arrayList.add(cVar);
                    } else {
                        arrayList2.add(cVar);
                    }
                }
            }
            this.h.addAll(arrayList);
            this.i.addAll(arrayList2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.SsoListManager", 2, "load wifiStore wifi: " + str + ":" + config);
            QLog.d("MSF.C.SsoListManager", 2, "load mobileStore " + str2 + ":" + config2);
        }
        if (config != null && config.length() > 0) {
            a(config, (ArrayList<com.tencent.qalsdk.core.c>) arrayList);
        }
        if (config2 != null && config2.length() > 0) {
            a(config2, (ArrayList<com.tencent.qalsdk.core.c>) arrayList2);
        }
        this.h.addAll(arrayList);
        this.i.addAll(arrayList2);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x00a2=Splitter:B:43:0x00a2, B:51:0x00b4=Splitter:B:51:0x00b4, B:39:0x0099=Splitter:B:39:0x0099} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00bd }
            r2 = 23
            if (r1 < r2) goto L_0x0012
            android.content.Context r1 = com.tencent.qalsdk.service.QalService.context     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            int r1 = r1.checkCallingOrSelfPermission(r2)     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x0022
        L_0x0012:
            com.tencent.qalsdk.core.j r0 = r6.f34125g     // Catch:{ all -> 0x00bd }
            android.content.Context r0 = r0.k     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00bd }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ all -> 0x00bd }
            java.lang.String r0 = r0.getSubscriberId()     // Catch:{ all -> 0x00bd }
        L_0x0022:
            if (r0 == 0) goto L_0x00b4
            int r1 = r0.length()     // Catch:{ all -> 0x00bd }
            r2 = 5
            if (r1 >= r2) goto L_0x002d
            goto L_0x00b4
        L_0x002d:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r6.f34120b     // Catch:{ all -> 0x00bd }
            r1.clear()     // Catch:{ all -> 0x00bd }
            r1 = 1
            java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x00bd }
            int r1 = r0.length()     // Catch:{ all -> 0x00bd }
            r3 = 0
            r4 = 3
            if (r1 < r4) goto L_0x0043
            java.lang.String r4 = r0.substring(r3, r4)     // Catch:{ all -> 0x00bd }
            goto L_0x0045
        L_0x0043:
            java.lang.String r4 = ""
        L_0x0045:
            java.lang.String r5 = "460"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00bd }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00bd }
            if (r1 < r2) goto L_0x0056
            java.lang.String r0 = r0.substring(r3, r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0058
        L_0x0056:
            java.lang.String r0 = ""
        L_0x0058:
            boolean r1 = r4.booleanValue()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00ab
            java.lang.String r1 = "46001"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = "46006"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x00a2
            java.lang.String r1 = "46010"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x0077
            goto L_0x00a2
        L_0x0077:
            java.lang.String r1 = "46003"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x0099
            java.lang.String r1 = "46005"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x0099
            java.lang.String r1 = "46011"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0090
            goto L_0x0099
        L_0x0090:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r0 = r6.f34120b     // Catch:{ all -> 0x00bd }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r6.f34121c     // Catch:{ all -> 0x00bd }
            r0.addAll(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r6)
            return
        L_0x0099:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r0 = r6.f34120b     // Catch:{ all -> 0x00bd }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r6.f34123e     // Catch:{ all -> 0x00bd }
            r0.addAll(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r6)
            return
        L_0x00a2:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r0 = r6.f34120b     // Catch:{ all -> 0x00bd }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r6.f34122d     // Catch:{ all -> 0x00bd }
            r0.addAll(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r6)
            return
        L_0x00ab:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r0 = r6.f34120b     // Catch:{ all -> 0x00bd }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r6.f34124f     // Catch:{ all -> 0x00bd }
            r0.addAll(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r6)
            return
        L_0x00b4:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r0 = r6.f34120b     // Catch:{ all -> 0x00bd }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r6.f34119a     // Catch:{ all -> 0x00bd }
            r0.addAll(r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r6)
            return
        L_0x00bd:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.m():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r7.length() == 0) goto L_0x0009;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.lang.String r7, java.util.ArrayList<com.tencent.qalsdk.core.c> r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 == 0) goto L_0x0009
            int r0 = r7.length()     // Catch:{ all -> 0x0058 }
            if (r0 != 0) goto L_0x000b
        L_0x0009:
            java.lang.String r7 = ""
        L_0x000b:
            java.lang.String r0 = ";"
            java.lang.String[] r7 = r7.split(r0)     // Catch:{ all -> 0x0058 }
            int r0 = r7.length     // Catch:{ all -> 0x0058 }
            r1 = 0
        L_0x0013:
            if (r1 >= r0) goto L_0x0056
            r2 = r7[r1]     // Catch:{ all -> 0x0058 }
            int r3 = r2.length()     // Catch:{ all -> 0x0058 }
            if (r3 <= 0) goto L_0x0053
            com.tencent.qalsdk.core.c r2 = com.tencent.qalsdk.core.c.a((java.lang.String) r2)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = r2.c()     // Catch:{ all -> 0x0058 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0058 }
            if (r3 != 0) goto L_0x003b
            java.lang.String r3 = "null"
            java.lang.String r4 = r2.c()     // Catch:{ all -> 0x0058 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0058 }
            if (r3 != 0) goto L_0x003b
            r8.add(r2)     // Catch:{ all -> 0x0058 }
            goto L_0x0053
        L_0x003b:
            java.lang.String r3 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            java.lang.String r5 = "found invalid endpoint: "
            r4.<init>(r5)     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0058 }
            r4.append(r2)     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0058 }
            r4 = 1
            com.tencent.qalsdk.util.QLog.d(r3, r4, r2)     // Catch:{ all -> 0x0058 }
        L_0x0053:
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0056:
            monitor-exit(r6)
            return
        L_0x0058:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x005c
        L_0x005b:
            throw r7
        L_0x005c:
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.a(java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00be, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.ArrayList<com.tencent.qalsdk.core.c> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.tencent.qalsdk.core.j r0 = r6.f34125g     // Catch:{ all -> 0x00bf }
            com.tencent.qalsdk.core.n r0 = r0.f32187c     // Catch:{ all -> 0x00bf }
            qalsdk.k r0 = r0.k     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r0.i()     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00af
            boolean r0 = com.tencent.qalsdk.base.a.f32149c     // Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x0019
            goto L_0x00af
        L_0x0019:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r0 = r6.h     // Catch:{ all -> 0x00bf }
            r0.clear()     // Catch:{ all -> 0x00bf }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x00bf }
            r0.<init>()     // Catch:{ all -> 0x00bf }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00bf }
        L_0x0027:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x008c
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00bf }
            com.tencent.qalsdk.core.c r1 = (com.tencent.qalsdk.core.c) r1     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x0069
            java.lang.String r2 = r1.c()     // Catch:{ all -> 0x00bf }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00bf }
            if (r2 != 0) goto L_0x0069
            java.lang.String r2 = "null"
            java.lang.String r3 = r1.c()     // Catch:{ all -> 0x00bf }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00bf }
            if (r2 != 0) goto L_0x0069
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r2.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x00bf }
            r2.append(r3)     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = ";"
            r2.append(r3)     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00bf }
            r0.append(r2)     // Catch:{ all -> 0x00bf }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r2 = r6.h     // Catch:{ all -> 0x00bf }
            r2.add(r1)     // Catch:{ all -> 0x00bf }
            goto L_0x0027
        L_0x0069:
            r2 = 1
            if (r1 != 0) goto L_0x0074
            java.lang.String r1 = "MSF.C.SsoListManager"
            java.lang.String r3 = "found invalid wifi endpoint: null"
            com.tencent.qalsdk.util.QLog.d(r1, r2, r3)     // Catch:{ all -> 0x00bf }
            goto L_0x0027
        L_0x0074:
            java.lang.String r3 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = "found invalid wifi endpoint: "
            r4.<init>(r5)     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00bf }
            r4.append(r1)     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x00bf }
            com.tencent.qalsdk.util.QLog.d(r3, r2, r1)     // Catch:{ all -> 0x00bf }
            goto L_0x0027
        L_0x008c:
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = c()     // Catch:{ all -> 0x00bf }
            if (r0 != 0) goto L_0x0098
            monitor-exit(r6)
            return
        L_0x0098:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = "__loginSdk_ssoWifilist_"
            r1.<init>(r2)     // Catch:{ all -> 0x00bf }
            r1.append(r0)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00bf }
            com.tencent.qalsdk.config.NativeConfigStore r1 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x00bf }
            r1.n_setConfig(r0, r7)     // Catch:{ all -> 0x00bf }
            monitor-exit(r6)
            return
        L_0x00af:
            boolean r7 = com.tencent.qalsdk.util.QLog.isDevelopLevel()     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x00bd
            java.lang.String r7 = "MSF.C.SsoListManager"
            r0 = 4
            java.lang.String r1 = "debug mode, skip store sso "
            com.tencent.qalsdk.util.QLog.d(r7, r0, r1)     // Catch:{ all -> 0x00bf }
        L_0x00bd:
            monitor-exit(r6)
            return
        L_0x00bf:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x00c3
        L_0x00c2:
            throw r7
        L_0x00c3:
            goto L_0x00c2
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.a(java.util.ArrayList):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.util.ArrayList<com.tencent.qalsdk.core.c> r6, boolean r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.tencent.qalsdk.core.j r7 = r5.f34125g     // Catch:{ all -> 0x00da }
            com.tencent.qalsdk.core.n r7 = r7.f32187c     // Catch:{ all -> 0x00da }
            qalsdk.k r7 = r7.k     // Catch:{ all -> 0x00da }
            java.lang.String r7 = r7.i()     // Catch:{ all -> 0x00da }
            java.lang.String r0 = ""
            boolean r7 = r7.equals(r0)     // Catch:{ all -> 0x00da }
            if (r7 == 0) goto L_0x00ca
            boolean r7 = com.tencent.qalsdk.base.a.f32149c     // Catch:{ all -> 0x00da }
            if (r7 == 0) goto L_0x0019
            goto L_0x00ca
        L_0x0019:
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r7 = r5.i     // Catch:{ all -> 0x00da }
            r7.clear()     // Catch:{ all -> 0x00da }
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ all -> 0x00da }
            r7.<init>()     // Catch:{ all -> 0x00da }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00da }
        L_0x0027:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x00da }
            r1 = 1
            if (r0 == 0) goto L_0x008c
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x00da }
            com.tencent.qalsdk.core.c r0 = (com.tencent.qalsdk.core.c) r0     // Catch:{ all -> 0x00da }
            if (r0 == 0) goto L_0x006a
            java.lang.String r2 = r0.c()     // Catch:{ all -> 0x00da }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00da }
            if (r2 != 0) goto L_0x006a
            java.lang.String r2 = "null"
            java.lang.String r3 = r0.c()     // Catch:{ all -> 0x00da }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00da }
            if (r2 != 0) goto L_0x006a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            r1.<init>()     // Catch:{ all -> 0x00da }
            java.lang.String r2 = r0.toString()     // Catch:{ all -> 0x00da }
            r1.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r2 = ";"
            r1.append(r2)     // Catch:{ all -> 0x00da }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00da }
            r7.append(r1)     // Catch:{ all -> 0x00da }
            java.util.concurrent.CopyOnWriteArrayList<com.tencent.qalsdk.core.c> r1 = r5.i     // Catch:{ all -> 0x00da }
            r1.add(r0)     // Catch:{ all -> 0x00da }
            goto L_0x0027
        L_0x006a:
            if (r0 != 0) goto L_0x0074
            java.lang.String r0 = "MSF.C.SsoListManager"
            java.lang.String r2 = "found invalid mobile endpoint: null"
            com.tencent.qalsdk.util.QLog.d(r0, r1, r2)     // Catch:{ all -> 0x00da }
            goto L_0x0027
        L_0x0074:
            java.lang.String r2 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            java.lang.String r4 = "found invalid mobile endpoint: "
            r3.<init>(r4)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00da }
            r3.append(r0)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00da }
            com.tencent.qalsdk.util.QLog.d(r2, r1, r0)     // Catch:{ all -> 0x00da }
            goto L_0x0027
        L_0x008c:
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00da }
            java.lang.String r7 = a()     // Catch:{ all -> 0x00da }
            if (r7 != 0) goto L_0x0098
            monitor-exit(r5)
            return
        L_0x0098:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            java.lang.String r2 = "__loginSdk_ssoMobilelist_"
            r0.<init>(r2)     // Catch:{ all -> 0x00da }
            r0.append(r7)     // Catch:{ all -> 0x00da }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x00da }
            com.tencent.qalsdk.config.NativeConfigStore r0 = com.tencent.qalsdk.core.l.a()     // Catch:{ all -> 0x00da }
            r0.n_setConfig(r7, r6)     // Catch:{ all -> 0x00da }
            java.lang.String r0 = "MSF.C.SsoListManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00da }
            java.lang.String r3 = "save http mobilesso for "
            r2.<init>(r3)     // Catch:{ all -> 0x00da }
            r2.append(r7)     // Catch:{ all -> 0x00da }
            java.lang.String r7 = " "
            r2.append(r7)     // Catch:{ all -> 0x00da }
            r2.append(r6)     // Catch:{ all -> 0x00da }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x00da }
            com.tencent.qalsdk.util.QLog.d(r0, r1, r6)     // Catch:{ all -> 0x00da }
            monitor-exit(r5)
            return
        L_0x00ca:
            boolean r6 = com.tencent.qalsdk.util.QLog.isDevelopLevel()     // Catch:{ all -> 0x00da }
            if (r6 == 0) goto L_0x00d8
            java.lang.String r6 = "MSF.C.SsoListManager"
            r7 = 4
            java.lang.String r0 = "debug mode, skip store sso "
            com.tencent.qalsdk.util.QLog.d(r6, r7, r0)     // Catch:{ all -> 0x00da }
        L_0x00d8:
            monitor-exit(r5)
            return
        L_0x00da:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x00de
        L_0x00dd:
            throw r6
        L_0x00de:
            goto L_0x00dd
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.a(java.util.ArrayList, boolean):void");
    }

    public final CopyOnWriteArrayList<com.tencent.qalsdk.core.c> h() {
        if (n()) {
            String[] split = TextUtils.split(l.a().getConfig("__loginSdk_proxyListEnv"), ";");
            if (split[0].equals("wifi") && split[1].equals(c())) {
                QLog.i("MSF.C.SsoListManager", 1, "ProxyList Enabled, proxyList: " + this.j);
                return this.j;
            }
        }
        if (this.h.size() == 0) {
            return this.f34119a;
        }
        return this.h;
    }

    public final CopyOnWriteArrayList<com.tencent.qalsdk.core.c> i() {
        if (n()) {
            String[] split = TextUtils.split(l.a().getConfig("__loginSdk_proxyListEnv"), ";");
            if (split[0].equals("xg") && split[1].equals(p())) {
                QLog.i("MSF.C.SsoListManager", 1, "ProxyList Enabled, proxyList: " + this.j);
                return this.j;
            }
        }
        if (this.i.size() == 0) {
            return this.f34120b;
        }
        return this.i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.tencent.qalsdk.core.c r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = com.tencent.qalsdk.core.m.d()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0012
            boolean r0 = r1.b(r2)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0029
            r1.c(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r1)
            return
        L_0x0012:
            boolean r0 = com.tencent.qalsdk.core.m.e()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0023
            boolean r0 = r1.c(r2)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0029
            r1.b(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r1)
            return
        L_0x0023:
            r1.b(r2)     // Catch:{ all -> 0x002b }
            r1.c(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r1)
            return
        L_0x002b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: qalsdk.c.a(com.tencent.qalsdk.core.c):void");
    }

    private boolean b(com.tencent.qalsdk.core.c cVar) {
        if (this.h.remove(cVar)) {
            this.h.add(cVar);
            QLog.d("MSF.C.SsoListManager", 1, " set " + cVar + " at wifiList last.");
            return true;
        }
        QLog.d("MSF.C.SsoListManager", 1, " not found " + cVar + " at wifiList.");
        return false;
    }

    private boolean c(com.tencent.qalsdk.core.c cVar) {
        if (this.i.remove(cVar)) {
            this.i.add(cVar);
            QLog.d("MSF.C.SsoListManager", 1, " set " + cVar + " at mobileList last.");
            return true;
        }
        QLog.d("MSF.C.SsoListManager", 1, " not found " + cVar + " at mobileList.");
        return false;
    }

    public final synchronized boolean a(String[] strArr) {
        if (strArr.length == 0) {
            return false;
        }
        String p = p();
        this.j.clear();
        StringBuilder sb = new StringBuilder();
        Pattern compile = Pattern.compile("([a-zA-Z0-9.]+):([0-9]+):([0-9]+)");
        for (String matcher : strArr) {
            Matcher matcher2 = compile.matcher(matcher);
            if (!matcher2.matches()) {
                return false;
            }
            if (sb.length() > 0) {
                sb.append(";");
            }
            sb.append("socket://");
            sb.append(matcher2.group(1));
            sb.append(":");
            sb.append(matcher2.group(2));
            sb.append("#");
            sb.append(p);
            sb.append(":0");
            sb.append(matcher2.group(3));
            com.tencent.qalsdk.core.c cVar = new com.tencent.qalsdk.core.c();
            cVar.c(matcher2.group(1));
            cVar.a(Integer.parseInt(matcher2.group(2)));
            cVar.b(Integer.parseInt(matcher2.group(3)) * 1000);
            cVar.b("socket");
            cVar.a(false);
            m.d();
            this.j.add(cVar);
        }
        String sb2 = sb.toString();
        QLog.i("MSF.C.SsoListManager", 1, "strProxyList: " + sb2);
        l.a().setConfig("__loginSdk_proxyListKey", sb2);
        String str = null;
        if (m.e()) {
            str = "xg;" + p;
        } else if (m.d()) {
            str = "wifi;" + c();
        }
        QLog.i("MSF.C.SsoListManager", 4, "proxyListEnv: " + str);
        l.a().setConfig("__loginSdk_proxyListEnv", str);
        l.a().setConfig("__loginSdk_proxyListEnabled", "1");
        this.l = true;
        j.a().f32187c.k.a(CloseConnReason.closeForOtherReason);
        return true;
    }

    public final synchronized boolean j() {
        this.l = false;
        this.j.clear();
        l.a().setConfig("__loginSdk_proxyListEnabled", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        j.a().f32187c.k.a(CloseConnReason.closeForOtherReason);
        return true;
    }

    private synchronized boolean n() {
        return this.l;
    }

    private void o() {
        String config = l.a().getConfig("__loginSdk_proxyListEnabled");
        if (config == null || config.equals("")) {
            this.l = false;
            return;
        }
        this.l = config.equals("1");
        this.j.clear();
        if (this.l) {
            for (String a2 : l.a().getConfig("__loginSdk_proxyListKey").split(";")) {
                this.j.add(com.tencent.qalsdk.core.c.a(a2));
            }
        }
    }

    private String p() {
        String str;
        if (Build.VERSION.SDK_INT < 23 || this.f34125g.k.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            str = ((TelephonyManager) this.f34125g.k.getSystemService("phone")).getSubscriberId();
        } else {
            str = null;
        }
        return str == null ? "00000" : str;
    }
}
