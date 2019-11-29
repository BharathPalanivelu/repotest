package com.salesforce.android.chat.core.internal.chatbot.response.message;

import com.google.a.a.c;
import com.salesforce.android.chat.core.model.ChatWindowButtonMenu;
import java.util.ArrayList;
import java.util.List;

public class ChatWindowButtonMenuMessage implements ChatWindowButtonMenu {
    public static final String TYPE = "ChatWindowButton";
    private transient List<Button> mButtons = new ArrayList();

    public void addButton(Button button) {
        this.mButtons.add(button);
    }

    public Button[] getButtons() {
        return (Button[]) this.mButtons.toArray(new Button[0]);
    }

    public String toString() {
        return String.format("ChatWindowButtonMenu %s", new Object[]{this.mButtons});
    }

    public static class Button implements ChatWindowButtonMenu.Button {
        private transient int mIndex;
        @c(a = "text")
        private String mLabel;

        public Button(int i, String str) {
            this.mIndex = i;
            this.mLabel = str;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public int getIndex() {
            return this.mIndex;
        }
    }
}
