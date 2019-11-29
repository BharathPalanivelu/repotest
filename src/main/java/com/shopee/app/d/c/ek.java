package com.shopee.app.d.c;

import b.a.b;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ek implements b<ej> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16926a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<JobManager> f16927b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16928c;

    /* renamed from: a */
    public ej get() {
        return new ej(this.f16926a.get(), this.f16927b.get(), this.f16928c.get());
    }

    public static ej a(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore) {
        return new ej(nVar, jobManager, settingConfigStore);
    }
}
