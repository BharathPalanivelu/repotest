package com.shopee.app.data.viewmodel;

import b.b;
import com.shopee.app.data.store.bf;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class ActivityCounter_MembersInjector implements b<ActivityCounter> {
    private final Provider<n> mEventBusProvider;
    private final Provider<bf> mStoreProvider;

    public ActivityCounter_MembersInjector(Provider<bf> provider, Provider<n> provider2) {
        this.mStoreProvider = provider;
        this.mEventBusProvider = provider2;
    }

    public static b<ActivityCounter> create(Provider<bf> provider, Provider<n> provider2) {
        return new ActivityCounter_MembersInjector(provider, provider2);
    }

    public void injectMembers(ActivityCounter activityCounter) {
        injectMStore(activityCounter, this.mStoreProvider.get());
        injectMEventBus(activityCounter, this.mEventBusProvider.get());
    }

    public static void injectMStore(ActivityCounter activityCounter, bf bfVar) {
        activityCounter.mStore = bfVar;
    }

    public static void injectMEventBus(ActivityCounter activityCounter, n nVar) {
        activityCounter.mEventBus = nVar;
    }
}
