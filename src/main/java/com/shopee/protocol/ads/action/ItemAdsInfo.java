package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ItemAdsInfo extends Message {
    public static final List<AdsInfo> DEFAULT_INFO = Collections.emptyList();
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = AdsInfo.class, tag = 3)
    public final List<AdsInfo> info;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ItemAdsInfo(Long l, Integer num, List<AdsInfo> list) {
        this.itemid = l;
        this.userid = num;
        this.info = immutableCopyOf(list);
    }

    private ItemAdsInfo(Builder builder) {
        this(builder.itemid, builder.userid, builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemAdsInfo)) {
            return false;
        }
        ItemAdsInfo itemAdsInfo = (ItemAdsInfo) obj;
        if (!equals((Object) this.itemid, (Object) itemAdsInfo.itemid) || !equals((Object) this.userid, (Object) itemAdsInfo.userid) || !equals((List<?>) this.info, (List<?>) itemAdsInfo.info)) {
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
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<AdsInfo> list = this.info;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ItemAdsInfo> {
        public List<AdsInfo> info;
        public Long itemid;
        public Integer userid;

        public Builder() {
        }

        public Builder(ItemAdsInfo itemAdsInfo) {
            super(itemAdsInfo);
            if (itemAdsInfo != null) {
                this.itemid = itemAdsInfo.itemid;
                this.userid = itemAdsInfo.userid;
                this.info = ItemAdsInfo.copyOf(itemAdsInfo.info);
            }
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder info(List<AdsInfo> list) {
            this.info = checkForNulls(list);
            return this;
        }

        public ItemAdsInfo build() {
            return new ItemAdsInfo(this);
        }
    }
}
