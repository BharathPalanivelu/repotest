package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.a.c;
import com.salesforce.android.chat.core.model.ChatFooterMenu;
import java.util.ArrayList;
import java.util.List;

public class ChatFooterMenuMessage implements ChatFooterMenu {
    private List<ChatFooterMenu.MenuItem> mItems = new ArrayList();

    public void addMenuItem(Item item) {
        this.mItems.add(item);
    }

    public ChatFooterMenu.MenuItem[] getMenuItems() {
        return (ChatFooterMenu.MenuItem[]) this.mItems.toArray(new ChatFooterMenu.MenuItem[0]);
    }

    public String toString() {
        return String.format("ChatFooterMenu %s", new Object[]{this.mItems});
    }

    public static class Item implements ChatFooterMenu.MenuItem {
        public static final String TYPE = "ChatWindowFooterMenu";
        @c(a = "dialogId")
        private String mDialogId;
        @c(a = "id")
        private String mId;
        private transient int mIndex;
        @c(a = "text")
        private String mText;
        @c(a = "value")
        private String mValue;

        public Item(int i, String str, String str2) {
            this.mIndex = i;
            this.mDialogId = str;
            this.mText = str2;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public String getDialogId() {
            return this.mDialogId;
        }

        public String getText() {
            return this.mText;
        }

        public String toString() {
            return String.format("%s (%s)", new Object[]{this.mText, this.mDialogId});
        }
    }
}
