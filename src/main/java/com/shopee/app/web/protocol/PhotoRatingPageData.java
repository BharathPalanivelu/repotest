package com.shopee.app.web.protocol;

import com.google.a.a.c;

public class PhotoRatingPageData {
    @c(a = "commentIndex")
    public int commentIndex;
    @c(a = "imageIndex")
    public int imageIndex;
    @c(a = "itemID")
    public long itemID;
    @c(a = "shopID")
    public int shopID;
    @c(a = "type")
    public int type;

    public long getItemID() {
        return this.itemID;
    }

    public int getShopID() {
        return this.shopID;
    }

    public int getCommentIndex() {
        return this.commentIndex;
    }

    public int getImageIndex() {
        return this.imageIndex;
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
