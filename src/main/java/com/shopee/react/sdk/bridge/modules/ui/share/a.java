package com.shopee.react.sdk.bridge.modules.ui.share;

import android.app.Activity;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.SharePanelResult;
import com.shopee.react.sdk.bridge.protocol.ShareResult;
import com.shopee.react.sdk.bridge.protocol.SharingDataMessage;
import com.shopee.react.sdk.bridge.protocol.ShowSharingPanelMessage;

public abstract class a extends d {
    public abstract void a(Activity activity, SharingDataMessage sharingDataMessage, c<SharePanelResult> cVar);

    public abstract void a(Activity activity, ShowSharingPanelMessage showSharingPanelMessage, c<ShareResult> cVar);
}
