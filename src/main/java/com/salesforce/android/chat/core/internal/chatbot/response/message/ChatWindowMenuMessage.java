package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.a.c;
import com.salesforce.android.chat.core.model.ChatWindowMenu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatWindowMenuMessage implements ChatWindowMenu {
    public static final String TYPE = "ChatWindowMenu";
    private String mHeaderText;
    private transient List<Item> mItems = new ArrayList();
    private transient Date mTimestamp = new Date();

    public ChatWindowMenuMessage(String str) {
        this.mHeaderText = str;
    }

    public Date getTimestamp() {
        return this.mTimestamp;
    }

    public String getHeaderText() {
        return this.mHeaderText;
    }

    public ChatWindowMenu.MenuItem[] getMenuItems() {
        return (ChatWindowMenu.MenuItem[]) this.mItems.toArray(new Item[0]);
    }

    public void addMenuItem(Item item) {
        this.mItems.add(item);
    }

    public String toString() {
        return String.format("ChatWindowMenu %s%s", new Object[]{this.mHeaderText, this.mItems});
    }

    public static class Item implements ChatWindowMenu.MenuItem {
        private transient int mIndex;
        @c(a = "text")
        private String mLabel;
        @c(a = "value")
        private String mValue;

        public Item(int i, String str, String str2) {
            this.mLabel = str;
            this.mValue = str2;
            this.mIndex = i;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public String getValue() {
            return this.mValue;
        }

        public String toString() {
            return this.mLabel;
        }
    }
}
