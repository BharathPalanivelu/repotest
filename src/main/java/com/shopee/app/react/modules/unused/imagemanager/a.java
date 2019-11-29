package com.shopee.app.react.modules.unused.imagemanager;

import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.garena.android.appkit.b.i;
import com.shopee.app.d.c.dl;
import com.shopee.app.g.d;
import com.shopee.app.react.c;
import com.shopee.app.react.modules.base.b;
import com.shopee.app.ui.image.ImageBrowserActivity_;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.image.j;
import com.shopee.id.R;
import java.util.ArrayList;

public class a extends b implements com.shopee.app.react.util.a {

    /* renamed from: d  reason: collision with root package name */
    private static String[] f18997d = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with root package name */
    dl f18998a;

    /* renamed from: b  reason: collision with root package name */
    private i f18999b = com.garena.a.a.a.b.a(this);

    /* renamed from: c  reason: collision with root package name */
    private Promise f19000c;

    public a(c cVar) {
        cVar.c().a(this);
    }

    public void a() {
        this.f18999b.a();
    }

    public void b() {
        this.f18999b.c();
    }

    public void c() {
        this.f18999b.d();
    }

    public void d() {
        this.f18999b.b();
    }

    /* access modifiers changed from: package-private */
    public void a(Pair<Boolean, Boolean> pair) {
        boolean booleanValue = ((Boolean) pair.first).booleanValue();
        boolean booleanValue2 = ((Boolean) pair.second).booleanValue();
        Promise promise = this.f19000c;
        if (promise != null && !booleanValue) {
            if (booleanValue2) {
                promise.resolve(1);
            } else {
                promise.reject((Throwable) new Exception("Image failed to save in the background task."));
            }
        }
    }

    public void a(Activity activity, String str, String str2, Promise promise) {
        this.f19000c = promise;
        if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(activity)) {
            this.f18998a.a(str, str2, false);
        } else {
            a(activity, str, str2);
        }
    }

    private void a(Activity activity, final String str, final String str2) {
        d.a(activity, f18997d, 512, 0, R.string.msg_permission_gallery, R.string.sp_no_storage_access, R.string.sp_to_allow_gallery_hint, new d.a() {
            public void b() {
            }

            public void c() {
            }

            public void a() {
                a.this.f18998a.a(str, str2, false);
            }
        });
    }

    public void a(Activity activity, ReadableArray readableArray, int i, Promise promise) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(MediaData.newImageData(readableArray.getString(i2)));
        }
        j.f23021a = arrayList;
        ImageBrowserActivity_.a(activity).b(i).a();
        promise.resolve(1);
    }
}
