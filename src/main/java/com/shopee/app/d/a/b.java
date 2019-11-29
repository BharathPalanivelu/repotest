package com.shopee.app.d.a;

import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.web.protocol.notification.UpdateItemShippingMessage;
import com.shopee.protocol.shop.ItemDimensions;
import io.b.d.c;
import io.b.d.g;

public class b implements c<ItemDimensions, String, AddProductInfo.Dimension>, g<AddProductInfo.Dimension, ItemDimensions> {
    public AddProductInfo.Dimension a(ItemDimensions itemDimensions, String str) {
        ItemDimensions itemDimensions2 = itemDimensions;
        if (itemDimensions2 == null) {
            return new AddProductInfo.Dimension(-1, -1, -1, -1, "");
        }
        return new AddProductInfo.Dimension(com.shopee.app.d.b.b.a(itemDimensions2.width), com.shopee.app.d.b.b.a(itemDimensions2.length), com.shopee.app.d.b.b.a(itemDimensions2.height), com.shopee.app.d.b.b.a(itemDimensions2.unit), str);
    }

    /* renamed from: a */
    public ItemDimensions apply(AddProductInfo.Dimension dimension) {
        return new ItemDimensions(Long.valueOf(dimension.width), Long.valueOf(dimension.length), Long.valueOf(dimension.height), Integer.valueOf(dimension.unit));
    }

    public AddProductInfo.Dimension a(UpdateItemShippingMessage updateItemShippingMessage) {
        return new AddProductInfo.Dimension(updateItemShippingMessage.getWidth(), updateItemShippingMessage.getLength(), updateItemShippingMessage.getHeight(), updateItemShippingMessage.getUnit(), updateItemShippingMessage.getDisplayDimension());
    }
}
