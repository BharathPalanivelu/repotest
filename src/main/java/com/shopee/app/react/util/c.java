package com.shopee.app.react.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.h.r;
import com.shopee.id.R;

public class c {
    public static void a(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23 && z) {
            try {
                if (!Settings.canDrawOverlays(activity)) {
                    activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), -1010101);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Activity activity, int i, boolean z) {
        if (i == -1010101 && z && Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(activity)) {
            r.a().a("Please grant overlay permission.");
        }
    }

    public static View a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(R.drawable.gray_circle_bg);
        imageView.setImageResource(R.drawable.com_garena_shopee_ic_add_product_category);
        imageView.setPadding(b.a.f7693d, b.a.f7693d, b.a.f7693d, b.a.f7693d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b.a.m, b.a.m);
        layoutParams.leftMargin = b.a.f7696g;
        layoutParams.gravity = 8388629;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
