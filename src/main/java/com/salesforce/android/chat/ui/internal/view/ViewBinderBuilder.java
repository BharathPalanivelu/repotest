package com.salesforce.android.chat.ui.internal.view;

import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import com.salesforce.android.chat.ui.internal.util.SparseArrayEntry;
import com.salesforce.android.chat.ui.internal.view.ViewBinder;

public interface ViewBinderBuilder<V extends ViewBinder, P extends Presenter> extends SparseArrayEntry {
    V build();

    int getKey();

    ViewBinderBuilder<V, P> setPresenter(P p);
}
