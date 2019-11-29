package com.shopee.react.sdk.bridge.modules.ui.dialog;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.PopupData;
import com.shopee.react.sdk.bridge.protocol.PopupResponse;

public abstract class a extends d {
    public abstract void a(Activity activity, ReactApplicationContext reactApplicationContext, int i, PopupData popupData, c<PopupResponse> cVar);
}
