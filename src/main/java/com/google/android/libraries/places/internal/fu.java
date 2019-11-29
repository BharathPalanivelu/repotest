package com.google.android.libraries.places.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.libraries.places.R;

public class fu implements ny {

    /* renamed from: a  reason: collision with root package name */
    public final String f12582a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12583b;

    /* renamed from: c  reason: collision with root package name */
    public final i f12584c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12585d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12586e;

    public static void a(Drawable drawable, int i) {
        drawable.mutate().setColorFilter(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)), PorterDuff.Mode.SRC_ATOP);
        drawable.setAlpha(Color.alpha(i));
    }

    public static Toolbar a(Activity activity) {
        try {
            Toolbar toolbar = (Toolbar) activity.findViewById(R.id.places_autocomplete_action_bar);
            if (toolbar != null) {
                return toolbar;
            }
            if (Log.isLoggable("ColorUtil", 6)) {
                Log.e("ColorUtil", "Failed to get action bar; couldn't get view.");
            }
            return null;
        } catch (ClassCastException e2) {
            if (Log.isLoggable("ColorUtil", 6)) {
                Log.e("ColorUtil", "Failed to get action bar; View is wrong class.", e2);
            }
            return null;
        }
    }

    public static FusedLocationProviderClient a(Context context) {
        return LocationServices.getFusedLocationProviderClient(context);
    }

    public static WifiManager b(Context context) {
        return (WifiManager) context.getSystemService("wifi");
    }

    public static a a() {
        return new c();
    }

    public static d a(FusedLocationProviderClient fusedLocationProviderClient, fv fvVar) {
        return new d(fusedLocationProviderClient, fvVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public fu(WifiInfo wifiInfo, ScanResult scanResult) {
        this(wifiInfo, scanResult.BSSID, scanResult.capabilities, scanResult.level, scanResult.frequency);
    }

    public fu(WifiInfo wifiInfo, String str, String str2, int i, int i2) {
        this(str, i, a(str2), a(wifiInfo, str), i2);
    }

    public fu(String str, int i, i iVar, boolean z, int i2) {
        this.f12582a = str;
        this.f12583b = i;
        this.f12584c = iVar;
        this.f12585d = z;
        this.f12586e = i2;
    }

    public static i a(String str) {
        if (TextUtils.isEmpty(str)) {
            return i.OTHER;
        }
        String upperCase = str.toUpperCase();
        if (upperCase.equals("[ESS]") || upperCase.equals("[IBSS]")) {
            return i.NONE;
        }
        if (upperCase.matches(".*WPA[0-9]*-PSK.*")) {
            return i.PSK;
        }
        if (upperCase.matches(".*WPA[0-9]*-EAP.*")) {
            return i.EAP;
        }
        return i.OTHER;
    }

    public static boolean a(WifiInfo wifiInfo, String str) {
        return wifiInfo != null && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(wifiInfo.getBSSID());
    }

    public String c() {
        return this.f12582a;
    }

    public int d() {
        return this.f12583b;
    }

    public i e() {
        return this.f12584c;
    }

    public boolean f() {
        return this.f12585d;
    }

    public int g() {
        return this.f12586e;
    }
}
