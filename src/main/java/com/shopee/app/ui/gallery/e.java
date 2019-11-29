package com.shopee.app.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.x;
import com.shopee.id.R;
import java.util.ArrayList;

public class e extends b implements x<m> {

    /* renamed from: a  reason: collision with root package name */
    int f21882a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f21883b = 1;

    /* renamed from: c  reason: collision with root package name */
    int f21884c = 1;

    /* renamed from: d  reason: collision with root package name */
    String f21885d = "";

    /* renamed from: e  reason: collision with root package name */
    private m f21886e;

    /* renamed from: f  reason: collision with root package name */
    private s f21887f;

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f21887f = new s(this, this.f21882a, this.f21883b, this.f21884c, this.f21885d);
        a((View) this.f21887f);
        v().setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.secondary_dark));
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).c((int) R.color.white).a(com.garena.android.appkit.tools.b.e(R.string.sp_label_gallery));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f21887f.b();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f21887f.c();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f21887f.d();
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f21886e = d.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f21886e.a(this);
    }

    /* renamed from: c */
    public m b() {
        return this.f21886e;
    }

    /* access modifiers changed from: package-private */
    public void a(ArrayList<GalleryData> arrayList, boolean z) {
        this.f21887f.a(arrayList, z);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i, Intent intent) {
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("add_product_video_uri_list");
            String stringExtra = intent.getStringExtra("add_product_trim_video_data");
            Intent intent2 = new Intent();
            intent2.putStringArrayListExtra("imageList", stringArrayListExtra);
            intent2.putStringArrayListExtra("videoList", stringArrayListExtra2);
            intent2.putExtra("trimVideoData", stringExtra);
            intent2.putExtra("trimDone", true);
            setResult(-1, intent2);
            finish();
        }
    }
}
