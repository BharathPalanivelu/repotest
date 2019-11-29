package com.salesforce.android.chat.ui.internal.view;

import androidx.b.h;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.ConnectingMinimizedView;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.InSessionMinimizedView;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.PostSessionMinimizedView;
import com.salesforce.android.chat.ui.internal.minimize.viewbinder.QueuedMinimizedView;
import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.util.SparseArrayUtil;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ViewFactory {
    private final AvatarCache mAvatarCache;
    private h<ViewBinderBuilder> mViewBinderBuilders;

    private ViewFactory(Builder builder) {
        this.mAvatarCache = builder.mAvatarCache;
        this.mViewBinderBuilders = SparseArrayUtil.asSparseArray(builder.mViewBinderBuilders, ViewBinderBuilder.class);
    }

    public ViewBinder createViewBinder(int i, Presenter presenter) {
        ViewBinderBuilder a2 = this.mViewBinderBuilders.a(i);
        if (a2 != null) {
            a2.setPresenter(presenter);
            if (a2 instanceof AvatarViewBinderBuilder) {
                ((AvatarViewBinderBuilder) a2).avatarCache(this.mAvatarCache);
            }
            return a2.build();
        }
        throw new IllegalStateException("Unknown ViewBinder Type for Presenter: " + presenter.getClass().getSimpleName());
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public AvatarCache mAvatarCache;
        /* access modifiers changed from: private */
        public ViewBinderBuilder<? extends ViewBinder, ? extends Presenter>[] mViewBinderBuilders;

        public Builder avatarCache(AvatarCache avatarCache) {
            this.mAvatarCache = avatarCache;
            return this;
        }

        /* access modifiers changed from: package-private */
        @SafeVarargs
        public final Builder setViewBinderBuilders(ViewBinderBuilder<? extends ViewBinder, ? extends Presenter>... viewBinderBuilderArr) {
            this.mViewBinderBuilders = viewBinderBuilderArr;
            return this;
        }

        public ViewFactory build() {
            if (this.mViewBinderBuilders == null) {
                setViewBinderBuilders(new ConnectingMinimizedView.Builder(), new QueuedMinimizedView.Builder(), new InSessionMinimizedView.Builder(), new PostSessionMinimizedView.Builder());
            }
            Arguments.checkNotNull(this.mViewBinderBuilders);
            return new ViewFactory(this);
        }
    }
}
