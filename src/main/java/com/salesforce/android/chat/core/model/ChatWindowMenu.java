package com.salesforce.android.chat.core.model;

import java.util.Date;

public interface ChatWindowMenu {

    public interface MenuItem {
        int getIndex();

        String getLabel();

        String getValue();
    }

    String getHeaderText();

    MenuItem[] getMenuItems();

    Date getTimestamp();
}
