package com.shopee.app.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import com.garena.android.appkit.d.a;
import com.shopee.app.react.ReactActivity_;
import com.shopee.app.react.protocol.PopData;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.ui.image.SearchPreviewActivity_;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.ImageSearchData;
import java.util.ArrayList;

public class c {
    private static void c(Activity activity, int i, Intent intent) {
    }

    public static void a(Context context) {
        PhotoProxyActivity_.a(context).a(true).i(true).b("FILTER_IMAGE_SEARCH").a(5261);
    }

    public static void a(Context context, ImageSearchData imageSearchData) {
        int i = imageSearchData.boundBox[0];
        int i2 = imageSearchData.boundBox[1];
        SearchPreviewActivity_.a(context).b(imageSearchData.imageId).a(new Rect(i, i2, imageSearchData.boundBox[2] + i, imageSearchData.boundBox[3] + i2)).a(imageSearchData.bigImageUri).a(imageSearchData.scale).a(false).b(imageSearchData.isFromHint).c(true).a(11028);
    }

    public static void a(Context context, ImageSearchData imageSearchData, boolean z) {
        SearchPreviewActivity_.a(context).a(imageSearchData.bigImageUri).a(true).c(false).b(imageSearchData.isFromHint).d(z).a(5255);
    }

    public static void a(Activity activity, int i, int i2, Intent intent) {
        if (i == 5255) {
            b(activity, i2, intent);
        } else if (i == 5261) {
            a(activity, i2, intent);
        } else if (i == 11028) {
            c(activity, i2, intent);
        }
    }

    private static void a(Activity activity, int i, Intent intent) {
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            if (!af.a(stringArrayListExtra)) {
                ImageSearchData imageSearchData = new ImageSearchData();
                imageSearchData.bigImageUri = stringArrayListExtra.get(0);
                a((Context) activity, imageSearchData, intent.getBooleanExtra("add_product_image_source", false));
            }
        }
    }

    private static void b(Activity activity, int i, Intent intent) {
        if (i == -1) {
            String stringExtra = intent.getStringExtra("popData");
            a.b("image_search popDataString %s", stringExtra);
            ReactActivity_.a(activity).a("IMAGE_SEARCH_RESULT").c(WebRegister.GSON.b((Object) new PushData(((PopData) WebRegister.GSON.a(stringExtra, PopData.class)).getData()))).b("").b(0).a(9281);
        } else if (intent == null || !intent.getBooleanExtra("isFromHint", false)) {
            PhotoProxyActivity_.a(activity).a(true).i(true).b("FILTER_IMAGE_SEARCH").a(5261);
        }
    }
}
