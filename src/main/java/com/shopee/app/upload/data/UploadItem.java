package com.shopee.app.upload.data;

import android.util.Base64;
import com.shopee.app.network.f;
import com.shopee.protocol.shop.Item;

public class UploadItem {
    public String serializedItem;

    public UploadItem(Item item) {
        this.serializedItem = Base64.encodeToString(item.toByteArray(), 0);
    }

    public Item getItem() {
        try {
            return (Item) f.f18486a.parseFrom(Base64.decode(this.serializedItem, 0), Item.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
