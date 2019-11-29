package com.shopee.app.application;

import b.a.b;
import b.a.c;
import com.path.android.jobqueue.JobManager;
import com.shopee.app.util.am;
import javax.inject.Provider;

public final class t implements b<JobManager> {

    /* renamed from: a  reason: collision with root package name */
    private final c f15905a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<am> f15906b;

    public t(c cVar, Provider<am> provider) {
        this.f15905a = cVar;
        this.f15906b = provider;
    }

    /* renamed from: a */
    public JobManager get() {
        return (JobManager) c.a(this.f15905a.a(this.f15906b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static t a(c cVar, Provider<am> provider) {
        return new t(cVar, provider);
    }
}
