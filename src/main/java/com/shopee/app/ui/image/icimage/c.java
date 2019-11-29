package com.shopee.app.ui.image.icimage;

import android.app.Activity;
import android.content.Intent;
import com.shopee.app.data.viewmodel.camera.IcCamera3Info;
import com.shopee.app.data.viewmodel.camera.PhotoFrameInfo;
import com.shopee.app.ui.photo.PhotoProxyActivity_;
import com.shopee.app.util.af;
import java.util.ArrayList;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f22989a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22990b;

    /* renamed from: c  reason: collision with root package name */
    private a f22991c;

    /* renamed from: d  reason: collision with root package name */
    private int f22992d = 2000000;

    /* renamed from: e  reason: collision with root package name */
    private PhotoFrameInfo f22993e;

    /* renamed from: f  reason: collision with root package name */
    private IcCamera3Info f22994f;

    public interface a {
        void onResult(String str, int i);
    }

    private c(a aVar, int i, int i2) {
        this.f22991c = aVar;
        this.f22989a = i;
        this.f22990b = i2;
    }

    public static c a(a aVar) {
        return new c(aVar, 5263, 5257);
    }

    public static c b(a aVar) {
        return new c(aVar, 5262, 5256);
    }

    public static c c(a aVar) {
        return new c(aVar, 5264, 5258);
    }

    public static c d(a aVar) {
        return new c(aVar, 5265, 5259);
    }

    public static c e(a aVar) {
        return new c(aVar, 5266, 5260);
    }

    public void a(int i) {
        this.f22992d = i;
    }

    public void a(PhotoFrameInfo photoFrameInfo) {
        this.f22993e = photoFrameInfo;
    }

    public void a(IcCamera3Info icCamera3Info) {
        this.f22994f = icCamera3Info;
    }

    public void a(Activity activity) {
        PhotoProxyActivity_.a(activity).a(true).i(true).a(this.f22993e).j(true).j(this.f22992d).a(this.f22994f).a(this.f22989a);
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        if (i == this.f22989a) {
            a(activity, i2, intent);
        } else if (i == this.f22990b) {
            b(activity, i2, intent);
        }
    }

    private void a(Activity activity, int i, Intent intent) {
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            if (!af.a(stringArrayListExtra)) {
                String str = stringArrayListExtra.get(0);
                boolean booleanExtra = intent.getBooleanExtra("add_product_image_source", false);
                int intExtra = intent.getIntExtra("PHOTO_ORIENTATION", 0);
                if (booleanExtra) {
                    IcImagePreviewActivity_.a(activity).a(str).a(this.f22993e).a(this.f22994f).b(intExtra).a(this.f22990b);
                    activity.overridePendingTransition(0, 0);
                    return;
                }
                return;
            }
            return;
        }
        this.f22991c.onResult("", 0);
    }

    private void b(Activity activity, int i, Intent intent) {
        if (i == -1) {
            this.f22991c.onResult(intent.getStringExtra("PHOTO_SOURCE"), intent.getIntExtra("PHOTO_ORIENTATION", 0));
            return;
        }
        a(activity);
    }
}
