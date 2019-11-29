package com.shopee.app.d.c;

import b.a.b;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class db implements b<da> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16778a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<JobManager> f16779b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16780c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserInfo> f16781d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UploadManager> f16782e;

    /* renamed from: a */
    public da get() {
        return new da(this.f16778a.get(), this.f16779b.get(), this.f16780c.get(), this.f16781d.get(), this.f16782e.get());
    }

    public static da a(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore, UserInfo userInfo, UploadManager uploadManager) {
        return new da(nVar, jobManager, settingConfigStore, userInfo, uploadManager);
    }
}
