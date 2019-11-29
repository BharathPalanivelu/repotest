package com.shopee.app.ui.common;

import android.util.Pair;
import com.garena.a.a.a.b;
import com.garena.android.appkit.b.i;
import com.garena.android.appkit.d.a;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.be;
import com.shopee.app.ui.a.q;
import com.shopee.app.upload.IUploadView;
import com.shopee.app.upload.ProgressState;
import com.shopee.app.upload.UploadJob;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadRunnable;
import com.shopee.app.upload.UploadState;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.upload.VideoState;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.af;
import com.shopee.app.util.am;
import com.shopee.app.util.bi;
import java.util.List;

public class y extends q<IUploadView> {

    /* renamed from: a  reason: collision with root package name */
    private final be f21361a;

    /* renamed from: c  reason: collision with root package name */
    private final i f21362c = b.a(this);

    /* renamed from: d  reason: collision with root package name */
    private final UploadStore f21363d;

    /* renamed from: e  reason: collision with root package name */
    private final JobManager f21364e;

    /* renamed from: f  reason: collision with root package name */
    private final bi f21365f;

    /* renamed from: g  reason: collision with root package name */
    private final UploadManager f21366g;
    private final am h;
    private ProgressState i;

    public y(bi biVar, JobManager jobManager, be beVar, UploadManager uploadManager, am amVar, UploadStore uploadStore) {
        this.f21364e = jobManager;
        this.f21361a = beVar;
        this.f21363d = uploadStore;
        this.h = amVar;
        this.f21366g = uploadManager;
        this.f21365f = biVar;
    }

    public void a() {
        this.f21362c.a();
    }

    public void b() {
        this.f21362c.b();
    }

    /* access modifiers changed from: package-private */
    public void a(ProgressState progressState) {
        this.i = progressState;
        a.a("on start...", new Object[0]);
        ((IUploadView) this.f19220b).show();
        ((IUploadView) this.f19220b).setLabel(progressState.getLabel());
        ((IUploadView) this.f19220b).setVideo(progressState.hasVideo());
        ((IUploadView) this.f19220b).setImage(progressState.getImageId());
        ((IUploadView) this.f19220b).setStateInProgress();
        ((IUploadView) this.f19220b).setProgress(0);
    }

    /* access modifiers changed from: package-private */
    public void b(ProgressState progressState) {
        this.i = progressState;
        a.a("on progress...", new Object[0]);
        ((IUploadView) this.f19220b).show();
        ((IUploadView) this.f19220b).setLabel(progressState.getLabel());
        ((IUploadView) this.f19220b).setVideo(progressState.hasVideo());
        ((IUploadView) this.f19220b).setImage(progressState.getImageId());
        ((IUploadView) this.f19220b).setStateInProgress();
        ((IUploadView) this.f19220b).setProgress((int) (progressState.getProgress() * 100.0d));
    }

    /* access modifiers changed from: package-private */
    public void c(ProgressState progressState) {
        this.i = progressState;
        a.a("on fail...", new Object[0]);
        ((IUploadView) this.f19220b).show();
        ((IUploadView) this.f19220b).setLabel(progressState.getLabel());
        ((IUploadView) this.f19220b).setVideo(progressState.hasVideo());
        ((IUploadView) this.f19220b).setImage(progressState.getImageId());
        ((IUploadView) this.f19220b).setStateFailed(progressState.getErrorMessage());
    }

    /* access modifiers changed from: package-private */
    public void d(ProgressState progressState) {
        this.i = progressState;
        ((IUploadView) this.f19220b).hide();
        this.f21365f.a("PRODUCT_UPLOAD_SUCCESS", new com.garena.android.appkit.b.a());
    }

    /* access modifiers changed from: package-private */
    public void e(ProgressState progressState) {
        this.i = progressState;
        ((IUploadView) this.f19220b).hide();
    }

    /* access modifiers changed from: package-private */
    public void a(VideoState videoState) {
        if (((IUploadView) this.f19220b).isShown()) {
            ((IUploadView) this.f19220b).setStateInProgress();
            ((IUploadView) this.f19220b).setProgress((int) (videoState.progress * 100.0d));
        }
    }

    public void e() {
        ((IUploadView) this.f19220b).hide();
        this.f21363d.delete(((UploadState) this.i).product);
        this.f21364e.clear();
        if (this.i.getRunnable() != null) {
            this.i.getRunnable().discard();
        }
    }

    public void f() {
        a(true);
    }

    public void g() {
        this.i.getRunnable().pause();
    }

    public void h() {
        this.i.getRunnable().resume();
    }

    public void i() {
        Pair<UploadGroup, UploadRunnable> current = this.f21366g.getCurrent();
        if (current != null && !((IUploadView) this.f19220b).isShown()) {
            UploadState uploadState = new UploadState();
            uploadState.runnable = (UploadRunnable) current.second;
            uploadState.product = (UploadGroup) current.first;
            uploadState.progress = 0.0d;
            a((ProgressState) uploadState);
        }
        a(false);
    }

    private void a(boolean z) {
        List<UploadGroup> all = this.f21363d.getAll();
        if (!af.a(all)) {
            UploadGroup uploadGroup = all.get(0);
            if (uploadGroup.isNew()) {
                uploadGroup.setStatus(1);
                uploadGroup.setTimestamp(com.garena.android.appkit.tools.a.a.a());
                this.f21363d.update(uploadGroup);
                this.f21364e.addJobInBackground(new UploadJob(uploadGroup.getRequestId()));
            } else if (uploadGroup.hasFailed()) {
                if (uploadGroup.canAutoRetry()) {
                    uploadGroup.setStatus(1);
                    this.f21363d.update(uploadGroup);
                    this.f21364e.addJobInBackground(new UploadJob(uploadGroup.getRequestId()));
                } else if (z) {
                    uploadGroup.setStatus(1);
                    uploadGroup.setTimestamp(com.garena.android.appkit.tools.a.a.a());
                    this.f21363d.update(uploadGroup);
                    this.f21364e.addJobInBackground(new UploadJob(uploadGroup.getRequestId()));
                } else {
                    UploadState uploadState = new UploadState();
                    uploadState.product = uploadGroup;
                    c(uploadState);
                }
            } else if (this.i == null) {
                this.f21364e.start();
                this.h.a();
                UploadState uploadState2 = new UploadState();
                uploadState2.product = uploadGroup;
                a((ProgressState) uploadState2);
            }
        }
    }
}
