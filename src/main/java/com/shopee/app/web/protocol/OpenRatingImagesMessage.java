package com.shopee.app.web.protocol;

public class OpenRatingImagesMessage {
    private int commentIndex;
    private String eventID;
    private int imageIndex;
    private long itemID;
    private int shopID;
    private int type = 0;

    public int getShopID() {
        return this.shopID;
    }

    public long getItemID() {
        return this.itemID;
    }

    public int getCommentIndex() {
        return this.commentIndex;
    }

    public int getImageIndex() {
        return this.imageIndex;
    }

    public String getEventID() {
        return this.eventID;
    }

    public int getType() {
        int i = this.type;
        if (i > 5) {
            return 0;
        }
        return i;
    }

    public boolean withCommentsOnly() {
        return this.type == 6;
    }
}
