package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.net.Uri;
import com.garena.android.appkit.b.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.h.l;
import com.shopee.app.util.g.d;
import com.shopee.app.util.n;

public class eh extends a {

    /* renamed from: c  reason: collision with root package name */
    private final JobManager f16917c;

    /* renamed from: d  reason: collision with root package name */
    private String f16918d;

    /* renamed from: e  reason: collision with root package name */
    private SettingConfigStore f16919e;

    /* access modifiers changed from: protected */
    public String d() {
        return "UploadAvatarInteractor";
    }

    protected eh(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore) {
        super(nVar);
        this.f16917c = jobManager;
        this.f16919e = settingConfigStore;
    }

    public void a(String str) {
        this.f16918d = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        Bitmap a2 = l.a().a(Uri.parse(this.f16918d), this.f16919e.getAvatarImageConfig().getFullImageWidth(), this.f16919e.getAvatarImageConfig().getFullImageHeight());
        if (a2 == null) {
            this.f16402a.a("AVATAR_SELECTED_FAIL", new a());
            return;
        }
        String a3 = com.shopee.app.h.b.a.a().a(l.a().a(a2, this.f16919e.getAvatarImageConfig().getFullImageQuality()));
        com.shopee.app.h.b.a.a().a(a3, l.a().a(l.b(a2, this.f16919e.getAvatarImageConfig().getThumbImageWidth(), this.f16919e.getAvatarImageConfig().getThumbImageHeight()), this.f16919e.getAvatarImageConfig().getThumbImageQuality()));
        if (!a2.isRecycled()) {
            a2.recycle();
        }
        this.f16917c.addJobInBackground(new d(a3));
        JobManager jobManager = this.f16917c;
        jobManager.addJobInBackground(new d(a3 + "_tn"));
        this.f16402a.a("AVATAR_SELECTED", new a(a3));
    }
}
