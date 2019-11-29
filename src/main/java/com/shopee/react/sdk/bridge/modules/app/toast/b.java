package com.shopee.react.sdk.bridge.modules.app.toast;

import android.app.Activity;
import android.widget.Toast;
import com.shopee.react.sdk.bridge.protocol.ToastData;

public class b implements a {
    public void a(Activity activity, ToastData toastData) {
        Toast.makeText(activity, toastData.getMessage(), 0).show();
    }
}
