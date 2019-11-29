package com.salesforce.android.chat.core.model;

public interface ChatWindowButtonMenu {

    public interface Button {
        int getIndex();

        String getLabel();
    }

    Button[] getButtons();
}
