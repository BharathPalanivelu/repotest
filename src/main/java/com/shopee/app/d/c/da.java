package com.shopee.app.d.c;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.h.l;
import com.shopee.app.h.o;
import com.shopee.app.network.g;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.VideoRunnable;
import com.shopee.app.upload.data.UploadVideo;
import com.shopee.app.util.g.d;
import com.shopee.app.util.n;
import com.shopee.app.web.WebRegister;

public class da extends a {

    /* renamed from: c  reason: collision with root package name */
    private final UploadManager f16769c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16770d;

    /* renamed from: e  reason: collision with root package name */
    private String f16771e;

    /* renamed from: f  reason: collision with root package name */
    private final JobManager f16772f;

    /* renamed from: g  reason: collision with root package name */
    private SettingConfigStore f16773g;
    private String h;
    private long i;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f16774a;

        /* renamed from: b  reason: collision with root package name */
        public String f16775b;

        /* renamed from: c  reason: collision with root package name */
        public int f16776c;

        /* renamed from: d  reason: collision with root package name */
        public int f16777d;
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "PrepareProductImageInteractor";
    }

    protected da(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore, UserInfo userInfo, UploadManager uploadManager) {
        super(nVar);
        this.f16772f = jobManager;
        this.f16773g = settingConfigStore;
        this.f16770d = userInfo;
        this.f16769c = uploadManager;
    }

    public void a(long j, String str, String str2) {
        this.f16771e = str;
        this.i = j;
        this.h = str2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        Uri parse = Uri.parse(this.f16771e);
        ImageConfig productImageConfig = this.f16773g.getProductImageConfig();
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(parse.getPath(), 2);
        if (createVideoThumbnail == null) {
            this.f16402a.a("ON_VIDEO_SELECTED_FAIL", new com.garena.android.appkit.b.a());
            return;
        }
        String a2 = com.shopee.app.h.b.a.a().a(l.a().a(createVideoThumbnail, productImageConfig.getFullImageQuality()));
        com.shopee.app.h.b.a.a().a(a2, l.a().a(l.b(createVideoThumbnail, productImageConfig.getThumbImageWidth(), productImageConfig.getThumbImageHeight()), productImageConfig.getThumbImageQuality()));
        o.a().b(a2, 1);
        this.f16772f.addJobInBackground(new d(a2));
        JobManager jobManager = this.f16772f;
        jobManager.addJobInBackground(new d(a2 + "_tn"));
        if (createVideoThumbnail != null && !createVideoThumbnail.isRecycled()) {
            createVideoThumbnail.recycle();
        }
        String a3 = new g().a();
        UploadVideo uploadVideo = (UploadVideo) WebRegister.GSON.a(this.h, UploadVideo.class);
        uploadVideo.setItemId(this.i);
        uploadVideo.setThumb(a2);
        uploadVideo.setKey(a3);
        a aVar = new a();
        aVar.f16777d = (int) uploadVideo.getStartTime();
        aVar.f16776c = uploadVideo.getDuration();
        aVar.f16774a = a2;
        aVar.f16775b = this.f16771e;
        VideoRunnable cachedJob = this.f16769c.getCachedJob();
        if (cachedJob != null) {
            cachedJob.discard();
        }
        VideoRunnable videoRunnable = new VideoRunnable(this.f16402a, this.f16770d, uploadVideo);
        org.a.a.a.a((Runnable) videoRunnable);
        this.f16769c.cacheJob(videoRunnable);
        this.f16402a.a("ON_VIDEO_SELECTED", new com.garena.android.appkit.b.a(aVar));
    }
}
