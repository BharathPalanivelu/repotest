package com.shopee.react.sdk.bridge.modules.ui.location;

import android.app.Activity;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.LocationData;
import com.shopee.react.sdk.bridge.protocol.LocationRequestParams;

public abstract class a extends d {
    public abstract void a(Activity activity, LocationRequestParams locationRequestParams, c<LocationData> cVar);
}
