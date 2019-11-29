package com.shopee.app.upload.data;

import android.util.Base64;
import com.shopee.app.network.f;
import com.shopee.protocol.shop.ItemModel;

public class UploadModel {
    public String serializedModel;

    public UploadModel(ItemModel itemModel) {
        this.serializedModel = Base64.encodeToString(itemModel.toByteArray(), 0);
    }

    public ItemModel getModel() {
        try {
            return (ItemModel) f.f18486a.parseFrom(Base64.decode(this.serializedModel, 0), ItemModel.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
