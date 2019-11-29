package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetSlashPriceItemList extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<ItemShopId> DEFAULT_ITEMS = Collections.emptyList();
    public static final Boolean DEFAULT_NEED_HIDDEN = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemShopId.class, tag = 4)
    public final List<ItemShopId> items;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean need_hidden;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetSlashPriceItemList(String str, String str2, Boolean bool, List<ItemShopId> list) {
        this.requestid = str;
        this.country = str2;
        this.need_hidden = bool;
        this.items = immutableCopyOf(list);
    }

    private GetSlashPriceItemList(Builder builder) {
        this(builder.requestid, builder.country, builder.need_hidden, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSlashPriceItemList)) {
            return false;
        }
        GetSlashPriceItemList getSlashPriceItemList = (GetSlashPriceItemList) obj;
        if (!equals((Object) this.requestid, (Object) getSlashPriceItemList.requestid) || !equals((Object) this.country, (Object) getSlashPriceItemList.country) || !equals((Object) this.need_hidden, (Object) getSlashPriceItemList.need_hidden) || !equals((List<?>) this.items, (List<?>) getSlashPriceItemList.items)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.need_hidden;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<ItemShopId> list = this.items;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<GetSlashPriceItemList> {
        public String country;
        public List<ItemShopId> items;
        public Boolean need_hidden;
        public String requestid;

        public Builder() {
        }

        public Builder(GetSlashPriceItemList getSlashPriceItemList) {
            super(getSlashPriceItemList);
            if (getSlashPriceItemList != null) {
                this.requestid = getSlashPriceItemList.requestid;
                this.country = getSlashPriceItemList.country;
                this.need_hidden = getSlashPriceItemList.need_hidden;
                this.items = GetSlashPriceItemList.copyOf(getSlashPriceItemList.items);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder need_hidden(Boolean bool) {
            this.need_hidden = bool;
            return this;
        }

        public Builder items(List<ItemShopId> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public GetSlashPriceItemList build() {
            return new GetSlashPriceItemList(this);
        }
    }
}
