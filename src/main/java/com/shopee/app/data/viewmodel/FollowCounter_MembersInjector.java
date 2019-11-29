package com.shopee.app.data.viewmodel;

import b.b;
import com.shopee.app.data.store.bf;
import javax.inject.Provider;

public final class FollowCounter_MembersInjector implements b<FollowCounter> {
    private final Provider<bf> mStoreProvider;

    public FollowCounter_MembersInjector(Provider<bf> provider) {
        this.mStoreProvider = provider;
    }

    public static b<FollowCounter> create(Provider<bf> provider) {
        return new FollowCounter_MembersInjector(provider);
    }

    public void injectMembers(FollowCounter followCounter) {
        injectMStore(followCounter, this.mStoreProvider.get());
    }

    public static void injectMStore(FollowCounter followCounter, bf bfVar) {
        followCounter.mStore = bfVar;
    }
}
