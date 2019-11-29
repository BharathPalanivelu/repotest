package com.shopee.feeds.feedlibrary.data.entity;

import com.shopee.sdk.b.a;
import java.util.List;

public class PostPictureTagEntity extends a {
    public List<ItemTag> item_tags;
    public String url;
    public List<UserTag> user_tags;

    public PostPictureTagEntity() {
    }

    public PostPictureTagEntity(String str, List<ItemTag> list, List<UserTag> list2) {
        this.url = str;
        this.item_tags = list;
        this.user_tags = list2;
    }

    public static class ItemTag extends a {
        public String item_id;
        public float pos_x;
        public float pos_y;
        public int shop_id;

        public ItemTag(String str, int i, float f2, float f3) {
            this.item_id = str;
            this.shop_id = i;
            this.pos_x = f2;
            this.pos_y = f3;
        }
    }

    public static class UserTag extends a {
        public float pos_x;
        public float pos_y;
        public int user_id;

        public UserTag(int i, float f2, float f3) {
            this.user_id = i;
            this.pos_x = f2;
            this.pos_y = f3;
        }
    }
}
