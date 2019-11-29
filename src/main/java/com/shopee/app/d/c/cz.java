package com.shopee.app.d.c;

import b.a.b;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class cz implements b<cy> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<n> f16755a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<JobManager> f16756b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SettingConfigStore> f16757c;

    /* renamed from: a */
    public cy get() {
        return new cy(this.f16755a.get(), this.f16756b.get(), this.f16757c.get());
    }

    public static cy a(n nVar, JobManager jobManager, SettingConfigStore settingConfigStore) {
        return new cy(nVar, jobManager, settingConfigStore);
    }
}
