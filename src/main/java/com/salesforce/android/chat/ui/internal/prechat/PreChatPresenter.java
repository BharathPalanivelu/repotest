package com.salesforce.android.chat.ui.internal.prechat;

import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.ui.internal.prechat.viewholder.PreChatViewHolder;
import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import java.util.List;

public interface PreChatPresenter extends PreChatViewHolder.OnUpdateListener, Presenter<PreChatView> {
    boolean isAllFieldsSatisfied();

    void refreshSatisfied();

    void setPreChatInputs(List<? extends ChatUserData> list);
}
