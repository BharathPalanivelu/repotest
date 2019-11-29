package com.shopee.app.g;

import com.google.android.gms.common.GoogleApiAvailability;
import com.shopee.app.application.ar;

public class q {
    public static boolean a() {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(ar.a()) == 0;
    }
}
