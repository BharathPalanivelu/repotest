package com.salesforce.android.chat.ui.internal.view;

import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import com.salesforce.android.chat.ui.internal.state.AvatarCache;
import com.salesforce.android.chat.ui.internal.view.ViewBinder;

public interface AvatarViewBinderBuilder<V extends ViewBinder, P extends Presenter> extends ViewBinderBuilder<V, P> {
    AvatarViewBinderBuilder<V, P> avatarCache(AvatarCache avatarCache);
}
