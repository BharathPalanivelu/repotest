package com.google.android.libraries.places.internal;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

final /* synthetic */ class ab implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    private final u f12326a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicLong f12327b;

    /* renamed from: c  reason: collision with root package name */
    private final FindCurrentPlaceRequest f12328c;

    ab(u uVar, AtomicLong atomicLong, FindCurrentPlaceRequest findCurrentPlaceRequest) {
        this.f12326a = uVar;
        this.f12327b = atomicLong;
        this.f12328c = findCurrentPlaceRequest;
    }

    public final Task then(Object obj) {
        ha haVar;
        boolean z;
        u uVar = this.f12326a;
        AtomicLong atomicLong = this.f12327b;
        FindCurrentPlaceRequest findCurrentPlaceRequest = this.f12328c;
        Location location = (Location) obj;
        atomicLong.set(uVar.f13069d.a());
        fw fwVar = uVar.f13066a;
        j jVar = uVar.f13067b;
        if (Build.VERSION.SDK_INT < 17) {
            haVar = ha.g();
        } else if (jVar.f12797b == null || !jVar.f12797b.isWifiEnabled()) {
            haVar = ha.g();
        } else {
            List<ScanResult> scanResults = jVar.f12797b.getScanResults();
            if (scanResults == null) {
                haVar = ha.g();
            } else {
                ArrayList arrayList = new ArrayList();
                WifiInfo connectionInfo = jVar.f12797b.getConnectionInfo();
                for (ScanResult next : scanResults) {
                    boolean z2 = false;
                    if (Build.VERSION.SDK_INT >= 17 && next != null && !TextUtils.isEmpty(next.SSID)) {
                        boolean z3 = (jVar.f12798c.a() * 1000) - next.timestamp > j.f12796a;
                        String str = next.SSID;
                        if (str != null) {
                            if (str.indexOf(95) >= 0) {
                                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                                if (lowerCase.contains("_nomap") || lowerCase.contains("_optout")) {
                                    z = true;
                                    if (!z3 && !z) {
                                        z2 = true;
                                    }
                                }
                            }
                            z = false;
                            z2 = true;
                        } else {
                            throw new IllegalArgumentException("Null SSID.");
                        }
                    }
                    if (z2) {
                        arrayList.add(new fu(connectionInfo, next));
                    }
                }
                haVar = ha.a(arrayList);
            }
        }
        return fwVar.a(findCurrentPlaceRequest, location, haVar);
    }
}
