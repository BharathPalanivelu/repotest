package com.shopee.app.upload;

import android.content.Intent;
import com.garena.android.appkit.tools.b;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.h.r;
import com.shopee.app.pushnotification.NotificationDataBuilder;
import com.shopee.app.pushnotification.c;
import com.shopee.app.ui.home.me.v3.MeTabView3;
import com.shopee.app.ui.product.add.aj;
import com.shopee.app.ui.product.add.t;
import com.shopee.app.ui.product.twitter.e;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.bi;
import com.shopee.app.util.f.a;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import com.shopee.app.web.protocol.ShareMessage;
import com.shopee.id.R;
import com.shopee.protocol.action.ResponseCommon;

public class UploadJob extends Job {
    public static final int PRIORITY = 2;
    transient q fabricClient;
    transient n mEventBus;
    transient a mFileUploader;
    private String mRequestId;
    transient e mTwitterClient;
    transient be mUIStore;
    transient UploadManager mUploadManger;
    transient UploadStore mUploadStore;
    transient UserInfo mUser;
    transient aj postToFacebookPageInteractor;
    transient ShareConfigStore shareConfigStore;
    transient bi uiEventBus;

    public void onAdded() {
    }

    public UploadJob(String str) {
        super(new Params(2).persist());
        this.mRequestId = str;
    }

    public void onRun() throws Throwable {
        UploadGroup uploading = this.mUploadManger.getUploading();
        if (this.mUser.isLoggedIn() && uploading != null && uploading.getRequestId().equals(this.mRequestId)) {
            UploadRunnable uploadRunnable = new UploadRunnable(this.mEventBus, this.mFileUploader, this.mUploadManger, this.mUIStore, this.mUploadStore, this.mUser, this.fabricClient, uploading);
            this.mUploadManger.put(uploading, uploadRunnable);
            uploadRunnable.run();
            this.mUploadManger.remove(uploading);
            this.mUploadStore.delete(uploading);
            ResponseCommon response = uploadRunnable.getResponse();
            if (response != null) {
                runAfterSuccessLogic(uploading, response);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        UploadGroup uploading = this.mUploadManger.getUploading();
        uploading.setStatus(2);
        this.mUploadStore.update(uploading);
        showNotification(uploading.getErrorMessage(), c.a(5));
    }

    /* access modifiers changed from: protected */
    public RetryConstraint shouldReRunOnThrowable(Throwable th, int i, int i2) {
        return RetryConstraint.CANCEL;
    }

    private void runAfterSuccessLogic(UploadGroup uploadGroup, ResponseCommon responseCommon) {
        ShareMessage o = this.mUIStore.o();
        t p = this.mUIStore.p();
        if (p != null) {
            try {
                this.postToFacebookPageInteractor.a(o.getUrl(), p);
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        if (responseCommon.errcode.intValue() == 0) {
            if (!uploadGroup.isEdit()) {
                showNotification(b.e(R.string.sp_product_success_noti_message), c.a());
            }
            uploadGroup.isShareToFB();
            if (uploadGroup.isShareToTwitter()) {
                this.mTwitterClient.a(o.getItemID(), getFirstImage(uploadGroup.getItem().getItem().images), uploadGroup.getItem().getItem().name, uploadGroup.getItem().getItem().price, o.getShopName(), o.getUsername(), this.shareConfigStore);
            }
            if (MeTabView3.j() && !uploadGroup.isEdit()) {
                this.uiEventBus.a("PRODUCT_UPLOAD_SUCCESS", new com.garena.android.appkit.b.a());
            }
            if (uploadGroup.isEdit()) {
                r.a().b((int) R.string.sp_item_edited);
            }
        }
    }

    private String getFirstImage(String str) {
        return str.split(",")[0];
    }

    private void showNotification(String str, Intent intent) {
        if (!MeTabView3.j()) {
            c.a(NotificationDataBuilder.notificationData().withId(102).ofType(102).withLaunchIntent(intent).withMessage(str).shouldKeepSilent(false).shouldStack(false).withMetadata("").build());
        }
    }
}
