package com.shopee.app.web.protocol.notification;

import java.util.List;

public class ShowActionsMessage {
    private List<ActionSheetItem> items;
    private String sheetTitle = "";

    public static class ActionSheetItem {
        String title;
        int type;

        /* access modifiers changed from: private */
        public String getTitle() {
            return this.title;
        }
    }

    public CharSequence[] getActionString() {
        List<ActionSheetItem> list = this.items;
        if (list == null || list.isEmpty()) {
            return null;
        }
        CharSequence[] charSequenceArr = new CharSequence[this.items.size()];
        int i = 0;
        for (ActionSheetItem access$000 : this.items) {
            charSequenceArr[i] = access$000.getTitle();
            i++;
        }
        return charSequenceArr;
    }

    public String getSheetTitle() {
        return this.sheetTitle;
    }
}
