package com.shopee.app.data.viewmodel;

import b.b;
import com.shopee.app.data.store.bf;
import com.shopee.app.util.n;
import javax.inject.Provider;

public final class MeCounter_MembersInjector implements b<MeCounter> {
    private final Provider<n> mEventBusProvider;
    private final Provider<bf> mStoreProvider;

    public MeCounter_MembersInjector(Provider<bf> provider, Provider<n> provider2) {
        this.mStoreProvider = provider;
        this.mEventBusProvider = provider2;
    }

    public static b<MeCounter> create(Provider<bf> provider, Provider<n> provider2) {
        return new MeCounter_MembersInjector(provider, provider2);
    }

    public void injectMembers(MeCounter meCounter) {
        injectMStore(meCounter, this.mStoreProvider.get());
        injectMEventBus(meCounter, this.mEventBusProvider.get());
    }

    public static void injectMStore(MeCounter meCounter, bf bfVar) {
        meCounter.mStore = bfVar;
    }

    public static void injectMEventBus(MeCounter meCounter, n nVar) {
        meCounter.mEventBus = nVar;
    }
}
