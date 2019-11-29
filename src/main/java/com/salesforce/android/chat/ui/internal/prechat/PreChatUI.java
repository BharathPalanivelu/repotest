package com.salesforce.android.chat.ui.internal.prechat;

import android.content.Context;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.core.model.PreChatField;
import com.salesforce.android.chat.ui.internal.client.InternalChatUIClient;
import com.salesforce.android.chat.ui.internal.model.PreChatInput;
import com.salesforce.android.chat.ui.internal.presenter.PresenterBuilder;
import java.util.Iterator;
import java.util.List;

public class PreChatUI implements PreChatPresenter {
    private boolean mAllFieldsSatisfied;
    private final InternalChatUIClient mChatUIClient;
    private List<? extends ChatUserData> mPreChatInputs;
    private PreChatView mPreChatView;

    public void onCreate() {
    }

    public void onDestroy() {
    }

    private PreChatUI(Builder builder) {
        this.mChatUIClient = builder.mChatUIClient;
    }

    public void onViewCreated(PreChatView preChatView) {
        this.mPreChatView = preChatView;
        this.mPreChatView.onSatisfiedUpdated(Boolean.valueOf(this.mAllFieldsSatisfied));
    }

    public void onViewDestroyed(PreChatView preChatView) {
        this.mPreChatView = null;
    }

    public Context getApplicationContext() {
        return this.mChatUIClient.getApplicationContext();
    }

    public void setPreChatInputs(List<? extends ChatUserData> list) {
        this.mPreChatInputs = list;
        refreshSatisfied();
    }

    public void refreshSatisfied() {
        boolean z;
        List<? extends ChatUserData> list = this.mPreChatInputs;
        if (list != null) {
            Iterator<? extends ChatUserData> it = list.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                ChatUserData chatUserData = (ChatUserData) it.next();
                boolean z3 = (chatUserData instanceof PreChatInput) && !((PreChatInput) chatUserData).isSatisfied();
                if (!(chatUserData instanceof PreChatField) || ((PreChatField) chatUserData).isSatisfied().booleanValue()) {
                    z2 = false;
                }
                if (!z3) {
                    if (z2) {
                        break;
                    }
                } else {
                    break;
                }
            }
            this.mAllFieldsSatisfied = z;
            PreChatView preChatView = this.mPreChatView;
            if (preChatView != null) {
                preChatView.onSatisfiedUpdated(Boolean.valueOf(this.mAllFieldsSatisfied));
            }
        }
    }

    public boolean isAllFieldsSatisfied() {
        return this.mAllFieldsSatisfied;
    }

    public void onPreChatFieldUpdate(ChatUserData chatUserData) {
        refreshSatisfied();
    }

    public static class Builder implements PresenterBuilder<PreChatPresenter> {
        /* access modifiers changed from: private */
        public InternalChatUIClient mChatUIClient;

        public int getKey() {
            return 6;
        }

        public Builder internalChatUIClient(InternalChatUIClient internalChatUIClient) {
            this.mChatUIClient = internalChatUIClient;
            return this;
        }

        public PreChatUI build() {
            return new PreChatUI(this);
        }
    }
}
