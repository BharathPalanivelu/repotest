package com.salesforce.android.chat.ui.internal.presenter;

import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import com.salesforce.android.chat.ui.internal.util.SparseArrayEntry;

public interface PresenterBuilder<P extends Presenter> extends SparseArrayEntry {
    P build();

    int getKey();

    PresenterBuilder<P> internalChatUIClient(InternalChatUIClient internalChatUIClient);
}
