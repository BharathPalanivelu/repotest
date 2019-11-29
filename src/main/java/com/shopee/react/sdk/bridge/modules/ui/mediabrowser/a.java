package com.shopee.react.sdk.bridge.modules.ui.mediabrowser;

import android.app.Activity;
import android.content.Intent;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.MediaBrowserData;
import com.shopee.react.sdk.bridge.protocol.MediaBrowserResult;

public abstract class a extends d {
    public abstract void a(int i, int i2, Intent intent);

    public abstract void a(Activity activity, MediaBrowserData mediaBrowserData, c<MediaBrowserResult> cVar);
}
