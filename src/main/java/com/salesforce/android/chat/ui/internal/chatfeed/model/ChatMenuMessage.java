package com.salesforce.android.chat.ui.internal.chatfeed.model;

import com.salesforce.android.chat.core.model.ChatWindowMenu;
import com.salesforce.android.service.common.ui.internal.messaging.MultiActorMessage;
import java.util.Date;

public class ChatMenuMessage implements MultiActorMessage {
    private final String mAgentId;
    private final String mHeaderText;
    private boolean mIsEnabled = true;
    private final ChatWindowMenu.MenuItem[] mMenuItems;
    private OnMenuItemSelectedListener mOnMenuItemSelectedListener;
    private final Date mTimestamp;

    public interface OnMenuItemSelectedListener {
        void onMenuItemSelected(ChatMenuMessage chatMenuMessage, ChatWindowMenu.MenuItem menuItem);
    }

    ChatMenuMessage(String str, String str2, Date date, ChatWindowMenu.MenuItem... menuItemArr) {
        this.mAgentId = str;
        this.mHeaderText = str2;
        this.mTimestamp = date;
        this.mMenuItems = menuItemArr;
    }

    public String getId() {
        return this.mAgentId;
    }

    public String getHeaderText() {
        return this.mHeaderText;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public ChatWindowMenu.MenuItem[] getMenuItems() {
        return this.mMenuItems;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public void setEnabled(boolean z) {
        this.mIsEnabled = z;
    }

    public void setSelectedMenuItem(ChatWindowMenu.MenuItem menuItem) {
        setEnabled(false);
        OnMenuItemSelectedListener onMenuItemSelectedListener = this.mOnMenuItemSelectedListener;
        if (onMenuItemSelectedListener != null) {
            onMenuItemSelectedListener.onMenuItemSelected(this, menuItem);
            this.mOnMenuItemSelectedListener = null;
        }
    }

    public void setOnMenuItemSelectedListener(OnMenuItemSelectedListener onMenuItemSelectedListener) {
        if (isEnabled()) {
            this.mOnMenuItemSelectedListener = onMenuItemSelectedListener;
        }
    }
}
