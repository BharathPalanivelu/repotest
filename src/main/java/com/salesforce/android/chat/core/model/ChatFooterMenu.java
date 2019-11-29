package com.salesforce.android.chat.core.model;

public interface ChatFooterMenu {

    public interface MenuItem {
        String getDialogId();

        int getIndex();

        String getText();
    }

    MenuItem[] getMenuItems();
}
