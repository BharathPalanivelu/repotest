package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.net.Uri;
import com.garena.android.appkit.b.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.h.l;
import com.shopee.app.h.o;
import com.shopee.app.util.g.d;
import com.shopee.app.util.n;
import java.util.List;

public class cy extends a {

    /* renamed from: c  reason: collision with root package name */
    private List<String> f16750c;

    /* renamed from: d  reason: collision with root package name */
    private List<Integer> f16751d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f16752e;

    /* renamed from: f  reason: collision with root package name */
    private SettingConfigStore f16753f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16754g;

    /* access modifiers changed from: protected */
    public String d() {
        return "PrepareProductImageInteractor";
    }

    protected cy(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f16752e = jobManager;
        this.f16753f = settingConfigStore;
    }

    public void a(List<Integer> list, List<String> list2, boolean z) {
        this.f16751d = list;
        this.f16750c = list2;
        this.f16754g = z;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        ImageConfig imageConfig;
        int i = 0;
        for (String parse : this.f16750c) {
            Uri parse2 = Uri.parse(parse);
            if (this.f16754g) {
                imageConfig = this.f16753f.getProductImageConfig();
            } else {
                imageConfig = this.f16753f.getShopBannerImageConfig();
            }
            Bitmap a2 = l.a().a(parse2, imageConfig.getFullImageWidth(), imageConfig.getFullImageHeight());
            if (a2 == null) {
                this.f16402a.a("ON_IMAGE_SELECTED_FAIL", new a());
                return;
            }
            String a3 = com.shopee.app.h.b.a.a().a(l.a().a(a2, imageConfig.getFullImageQuality()));
            com.shopee.app.h.b.a.a().a(a3, l.a().a(l.b(a2, imageConfig.getThumbImageWidth(), imageConfig.getThumbImageHeight()), imageConfig.getThumbImageQuality()));
            o.a().b(a3, 1);
            this.f16752e.addJobInBackground(new d(a3));
            JobManager jobManager = this.f16752e;
            jobManager.addJobInBackground(new d(a3 + "_tn"));
            if (a2 != null && !a2.isRecycled()) {
                a2.recycle();
            }
            this.f16402a.a("ON_IMAGE_SELECTED", (a) new ct(this.f16751d.get(i).intValue(), a3));
            i++;
        }
        this.f16402a.a("ON_IMAGE_SELECTED_DONE", new a());
    }
}
