package com.salesforce.android.chat.ui.internal.presenter;

import androidx.b.h;
import com.salesforce.android.chat.ui.internal.chatfeed.ChatFeed;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.minimize.presenter.ConnectingMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.minimize.presenter.InSessionMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.minimize.presenter.PostSessionMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.minimize.presenter.QueuedMinimizedPresenter;
import com.salesforce.android.chat.ui.internal.prechat.PreChatUI;
import com.salesforce.android.chat.ui.internal.util.SparseArrayUtil;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class PresenterManager {
    private final InternalChatUIClient mChatUIClient;
    private h<PresenterBuilder> mPresenterBuilders;
    private h<Presenter> mPresenterCache;

    private PresenterManager(Builder builder) {
        this.mPresenterCache = new h<>();
        this.mChatUIClient = builder.mChatUIClient;
        this.mPresenterBuilders = SparseArrayUtil.asSparseArray(builder.mPresenterBuilders, PresenterBuilder.class);
    }

    public Presenter getPresenter(int i) {
        Presenter a2 = this.mPresenterCache.a(i);
        if (a2 == null) {
            PresenterBuilder a3 = this.mPresenterBuilders.a(i);
            Arguments.checkNotNull(a3);
            a2 = a3.internalChatUIClient(this.mChatUIClient).build();
            a2.onCreate();
            this.mPresenterCache.b(i, a2);
        }
        Arguments.checkNotNull(a2);
        return a2;
    }

    public void destroyPresenter(int i) {
        Presenter a2 = this.mPresenterCache.a(i);
        if (a2 != null) {
            this.mPresenterCache.b(i);
            a2.onDestroy();
        }
    }

    public void destroyAllPresenters() {
        for (int i = 0; i < this.mPresenterCache.b(); i++) {
            this.mPresenterCache.d(i).onDestroy();
        }
        this.mPresenterCache.c();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public InternalChatUIClient mChatUIClient;
        /* access modifiers changed from: private */
        public PresenterBuilder<? extends Presenter>[] mPresenterBuilders;

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mChatUIClient = internalChatUIClient;
            return this;
        }

        /* access modifiers changed from: package-private */
        @SafeVarargs
        public final Builder presenterBuilders(PresenterBuilder<? extends Presenter>... presenterBuilderArr) {
            this.mPresenterBuilders = presenterBuilderArr;
            return this;
        }

        public PresenterManager build() {
            if (this.mPresenterBuilders == null) {
                presenterBuilders(new ChatFeed.Builder(), new ConnectingMinimizedPresenter.Builder(), new QueuedMinimizedPresenter.Builder(), new InSessionMinimizedPresenter.Builder(), new PostSessionMinimizedPresenter.Builder(), new PreChatUI.Builder());
            }
            Arguments.checkNotNull(this.mChatUIClient);
            Arguments.checkNotNull(this.mPresenterBuilders);
            return new PresenterManager(this);
        }
    }
}
