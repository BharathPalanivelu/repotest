package com.salesforce.android.service.common.ui.internal.messaging;

public interface MessageFeedModel {
    void add(Object obj, int i);

    int indexOfItem(Object obj);

    boolean isAtBottomPosition();

    void notifyItemChanged(Object obj);

    void scrollToBottom();
}
