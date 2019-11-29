package com.salesforce.android.chat.ui;

import android.app.Activity;
import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.service.common.utilities.control.Async;

public interface ChatUIClient {
    ChatUIClient addPreChatUIListener(PreChatUIListener preChatUIListener);

    ChatUIClient addSessionStateListener(SessionStateListener sessionStateListener);

    void endChatSession();

    ChatSessionState getCurrentSessionState();

    ChatUIClient removePreChatUIListener(PreChatUIListener preChatUIListener);

    ChatUIClient removeSessionStateListener(SessionStateListener sessionStateListener);

    Async<Boolean> startChatSession(Activity activity);
}
