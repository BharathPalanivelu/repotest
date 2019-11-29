package com.salesforce.android.chat.ui.internal.model;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.salesforce.android.chat.core.ChatClient;
import com.salesforce.android.chat.core.model.ChatSessionState;

public interface ViewStateHandler {
    void attachTo(Activity activity);

    ChatClient getChatClient();

    int getCurrentPresenter();

    ChatSessionState getCurrentState();

    void onCreate(ViewGroup viewGroup, Context context);

    void onMinimizePressed();

    void setChatClient(ChatClient chatClient);

    void show();

    void teardown();
}
