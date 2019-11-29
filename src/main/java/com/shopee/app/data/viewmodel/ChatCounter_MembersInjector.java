package com.shopee.app.data.viewmodel;

import b.b;
import com.shopee.app.data.store.bf;
import javax.inject.Provider;

public final class ChatCounter_MembersInjector implements b<ChatCounter> {
    private final Provider<bf> mStoreProvider;

    public ChatCounter_MembersInjector(Provider<bf> provider) {
        this.mStoreProvider = provider;
    }

    public static b<ChatCounter> create(Provider<bf> provider) {
        return new ChatCounter_MembersInjector(provider);
    }

    public void injectMembers(ChatCounter chatCounter) {
        injectMStore(chatCounter, this.mStoreProvider.get());
    }

    public static void injectMStore(ChatCounter chatCounter, bf bfVar) {
        chatCounter.mStore = bfVar;
    }
}
