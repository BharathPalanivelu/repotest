package com.shopee.react.sdk.bridge.modules.ui.imagepicker;

import android.app.Activity;
import android.content.Intent;
import com.shopee.react.sdk.bridge.modules.base.c;
import com.shopee.react.sdk.bridge.modules.base.d;
import com.shopee.react.sdk.bridge.protocol.DataResponse;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageRequest;
import com.shopee.react.sdk.bridge.protocol.GetRecentImageResponse;
import com.shopee.react.sdk.bridge.protocol.ImagePickerData;
import com.shopee.react.sdk.bridge.protocol.ImagePickerResult;

public abstract class a extends d {
    public abstract void a(int i, int i2, Intent intent);

    public abstract void a(Activity activity, GetRecentImageRequest getRecentImageRequest, c<DataResponse<GetRecentImageResponse>> cVar);

    public abstract void a(Activity activity, boolean z, ImagePickerData imagePickerData, c<ImagePickerResult> cVar);
}
