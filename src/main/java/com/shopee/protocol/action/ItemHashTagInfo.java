package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemHashTagInfo extends Message {
    public static final List<String> DEFAULT_HASHTAG_LIST = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> hashtag_list;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;

    public ItemHashTagInfo(Long l, List<String> list) {
        this.itemid = l;
        this.hashtag_list = immutableCopyOf(list);
    }

    private ItemHashTagInfo(Builder builder) {
        this(builder.itemid, builder.hashtag_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemHashTagInfo)) {
            return false;
        }
        ItemHashTagInfo itemHashTagInfo = (ItemHashTagInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemHashTagInfo.itemid) || !equals((List<?>) this.hashtag_list, (List<?>) itemHashTagInfo.hashtag_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.itemid;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<String> list = this.hashtag_list;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ItemHashTagInfo> {
        public List<String> hashtag_list;
        public Long itemid;

        public Builder() {
        }

        public Builder(ItemHashTagInfo itemHashTagInfo) {
            super(itemHashTagInfo);
            if (itemHashTagInfo != null) {
                this.itemid = itemHashTagInfo.itemid;
                this.hashtag_list = ItemHashTagInfo.copyOf(itemHashTagInfo.hashtag_list);
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder hashtag_list(List<String> list) {
            this.hashtag_list = checkForNulls(list);
            return this;
        }

        public ItemHashTagInfo build() {
            return new ItemHashTagInfo(this);
        }
    }
}
