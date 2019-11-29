package com.shopee.protocol.action;

import com.shopee.protocol.shop.ItemSimpleInfo;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HashTagSearchInfo extends Message {
    public static final Long DEFAULT_HASHTAG_ID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long hashtag_id;
    @ProtoField(tag = 1)
    public final ItemSimpleInfo simple_item;
    @ProtoField(tag = 2)
    public final UserBrief user;

    public HashTagSearchInfo(ItemSimpleInfo itemSimpleInfo, UserBrief userBrief, Long l) {
        this.simple_item = itemSimpleInfo;
        this.user = userBrief;
        this.hashtag_id = l;
    }

    private HashTagSearchInfo(Builder builder) {
        this(builder.simple_item, builder.user, builder.hashtag_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HashTagSearchInfo)) {
            return false;
        }
        HashTagSearchInfo hashTagSearchInfo = (HashTagSearchInfo) obj;
        if (!equals((Object) this.simple_item, (Object) hashTagSearchInfo.simple_item) || !equals((Object) this.user, (Object) hashTagSearchInfo.user) || !equals((Object) this.hashtag_id, (Object) hashTagSearchInfo.hashtag_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ItemSimpleInfo itemSimpleInfo = this.simple_item;
        int i2 = 0;
        int hashCode = (itemSimpleInfo != null ? itemSimpleInfo.hashCode() : 0) * 37;
        UserBrief userBrief = this.user;
        int hashCode2 = (hashCode + (userBrief != null ? userBrief.hashCode() : 0)) * 37;
        Long l = this.hashtag_id;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HashTagSearchInfo> {
        public Long hashtag_id;
        public ItemSimpleInfo simple_item;
        public UserBrief user;

        public Builder() {
        }

        public Builder(HashTagSearchInfo hashTagSearchInfo) {
            super(hashTagSearchInfo);
            if (hashTagSearchInfo != null) {
                this.simple_item = hashTagSearchInfo.simple_item;
                this.user = hashTagSearchInfo.user;
                this.hashtag_id = hashTagSearchInfo.hashtag_id;
            }
        }

        public Builder simple_item(ItemSimpleInfo itemSimpleInfo) {
            this.simple_item = itemSimpleInfo;
            return this;
        }

        public Builder user(UserBrief userBrief) {
            this.user = userBrief;
            return this;
        }

        public Builder hashtag_id(Long l) {
            this.hashtag_id = l;
            return this;
        }

        public HashTagSearchInfo build() {
            return new HashTagSearchInfo(this);
        }
    }
}
