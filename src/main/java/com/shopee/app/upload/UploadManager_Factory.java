package com.shopee.app.upload;

import b.a.b;
import javax.inject.Provider;

public final class UploadManager_Factory implements b<UploadManager> {
    private final Provider<UploadStore> uploadStoreProvider;

    public UploadManager_Factory(Provider<UploadStore> provider) {
        this.uploadStoreProvider = provider;
    }

    public UploadManager get() {
        return new UploadManager(this.uploadStoreProvider.get());
    }

    public static UploadManager_Factory create(Provider<UploadStore> provider) {
        return new UploadManager_Factory(provider);
    }
}
