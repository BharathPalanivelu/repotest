package com.shopee.app.d.c;

import b.a.b;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ei implements b<eh> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16920a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<JobManager> f16921b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16922c;

    /* renamed from: a */
    public eh get() {
        return new eh(this.f16920a.get(), this.f16921b.get(), this.f16922c.get());
    }

    public static eh a(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore) {
        return new eh(nVar, jobManager, settingConfigStore);
    }
}
