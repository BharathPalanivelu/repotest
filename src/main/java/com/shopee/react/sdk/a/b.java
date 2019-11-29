package com.shopee.react.sdk.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.react.uimanager.PixelUtil;
import com.shopee.react.sdk.a;

public class b {
    public static View a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(a.C0464a.gray_circle_bg);
        imageView.setImageResource(a.C0464a.debug_icon2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) PixelUtil.toPixelFromDIP(24.0f), (int) PixelUtil.toPixelFromDIP(24.0f));
        layoutParams.gravity = 8388629;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
