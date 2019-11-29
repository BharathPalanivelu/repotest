package com.salesforce.android.chat.ui.internal.chatfeed;

import android.net.Uri;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import com.salesforce.android.chat.core.model.ChatSessionState;
import com.salesforce.android.chat.ui.internal.presenter.Presenter;
import java.io.FileNotFoundException;

interface ChatFeedPresenter extends Presenter<ChatFeedView> {
    Uri createNewImageContent();

    void endSession();

    String getCachedMessageInput();

    ChatSessionState getCurrentSessionState();

    Uri getLastPhotoTaken() throws FileNotFoundException;

    void hideChatBanner();

    void onMinimizePressed();

    void sendFooterMenuSelection(ChatFooterMenu.MenuItem menuItem);

    void sendMessage(String str);

    void sendSneakPeekMessage(String str);

    void setCachedMessageInput(String str);

    void setIsUserTyping(boolean z);

    void showChatBanner();

    void transferImage(Uri uri);

    void transferNewImageContent();
}
