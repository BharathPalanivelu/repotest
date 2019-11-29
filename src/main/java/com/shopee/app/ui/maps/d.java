package com.shopee.app.ui.maps;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class d {
    public static a a(Context context, int i) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new c(context, i);
        }
        return new b(context);
    }
}
