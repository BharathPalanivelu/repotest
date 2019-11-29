package com.shopee.app.upload;

import b.b;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ShareConfigStore;
import com.shopee.app.data.store.be;
import com.shopee.app.ui.product.add.aj;
import com.shopee.app.ui.product.twitter.e;
import com.shopee.app.util.bi;
import com.shopee.app.util.f.a;
import com.shopee.app.util.n;
import com.shopee.app.util.q;
import javax.inject.Provider;

public final class UploadJob_MembersInjector implements b<UploadJob> {
    private final Provider<q> fabricClientProvider;
    private final Provider<n> mEventBusProvider;
    private final Provider<a> mFileUploaderProvider;
    private final Provider<e> mTwitterClientProvider;
    private final Provider<be> mUIStoreProvider;
    private final Provider<UploadManager> mUploadMangerProvider;
    private final Provider<UploadStore> mUploadStoreProvider;
    private final Provider<UserInfo> mUserProvider;
    private final Provider<aj> postToFacebookPageInteractorProvider;
    private final Provider<ShareConfigStore> shareConfigStoreProvider;
    private final Provider<bi> uiEventBusProvider;

    public UploadJob_MembersInjector(Provider<n> provider, Provider<bi> provider2, Provider<a> provider3, Provider<UploadStore> provider4, Provider<be> provider5, Provider<e> provider6, Provider<UploadManager> provider7, Provider<UserInfo> provider8, Provider<ShareConfigStore> provider9, Provider<aj> provider10, Provider<q> provider11) {
        this.mEventBusProvider = provider;
        this.uiEventBusProvider = provider2;
        this.mFileUploaderProvider = provider3;
        this.mUploadStoreProvider = provider4;
        this.mUIStoreProvider = provider5;
        this.mTwitterClientProvider = provider6;
        this.mUploadMangerProvider = provider7;
        this.mUserProvider = provider8;
        this.shareConfigStoreProvider = provider9;
        this.postToFacebookPageInteractorProvider = provider10;
        this.fabricClientProvider = provider11;
    }

    public static b<UploadJob> create(Provider<n> provider, Provider<bi> provider2, Provider<a> provider3, Provider<UploadStore> provider4, Provider<be> provider5, Provider<e> provider6, Provider<UploadManager> provider7, Provider<UserInfo> provider8, Provider<ShareConfigStore> provider9, Provider<aj> provider10, Provider<q> provider11) {
        return new UploadJob_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public void injectMembers(UploadJob uploadJob) {
        injectMEventBus(uploadJob, this.mEventBusProvider.get());
        injectUiEventBus(uploadJob, this.uiEventBusProvider.get());
        injectMFileUploader(uploadJob, this.mFileUploaderProvider.get());
        injectMUploadStore(uploadJob, this.mUploadStoreProvider.get());
        injectMUIStore(uploadJob, this.mUIStoreProvider.get());
        injectMTwitterClient(uploadJob, this.mTwitterClientProvider.get());
        injectMUploadManger(uploadJob, this.mUploadMangerProvider.get());
        injectMUser(uploadJob, this.mUserProvider.get());
        injectShareConfigStore(uploadJob, this.shareConfigStoreProvider.get());
        injectPostToFacebookPageInteractor(uploadJob, this.postToFacebookPageInteractorProvider.get());
        injectFabricClient(uploadJob, this.fabricClientProvider.get());
    }

    public static void injectMEventBus(UploadJob uploadJob, n nVar) {
        uploadJob.mEventBus = nVar;
    }

    public static void injectUiEventBus(UploadJob uploadJob, bi biVar) {
        uploadJob.uiEventBus = biVar;
    }

    public static void injectMFileUploader(UploadJob uploadJob, a aVar) {
        uploadJob.mFileUploader = aVar;
    }

    public static void injectMUploadStore(UploadJob uploadJob, UploadStore uploadStore) {
        uploadJob.mUploadStore = uploadStore;
    }

    public static void injectMUIStore(UploadJob uploadJob, be beVar) {
        uploadJob.mUIStore = beVar;
    }

    public static void injectMTwitterClient(UploadJob uploadJob, e eVar) {
        uploadJob.mTwitterClient = eVar;
    }

    public static void injectMUploadManger(UploadJob uploadJob, UploadManager uploadManager) {
        uploadJob.mUploadManger = uploadManager;
    }

    public static void injectMUser(UploadJob uploadJob, UserInfo userInfo) {
        uploadJob.mUser = userInfo;
    }

    public static void injectShareConfigStore(UploadJob uploadJob, ShareConfigStore shareConfigStore) {
        uploadJob.shareConfigStore = shareConfigStore;
    }

    public static void injectPostToFacebookPageInteractor(UploadJob uploadJob, aj ajVar) {
        uploadJob.postToFacebookPageInteractor = ajVar;
    }

    public static void injectFabricClient(UploadJob uploadJob, q qVar) {
        uploadJob.fabricClient = qVar;
    }
}
