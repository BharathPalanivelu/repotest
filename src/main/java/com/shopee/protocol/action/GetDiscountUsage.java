package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetDiscountUsage extends Message {
    public static final List<ItemShopId> DEFAULT_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemShopId.class, tag = 3)
    public final List<ItemShopId> items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetDiscountUsage(String str, String str2, List<ItemShopId> list) {
        this.requestid = str;
        this.token = str2;
        this.items = immutableCopyOf(list);
    }

    private GetDiscountUsage(Builder builder) {
        this(builder.requestid, builder.token, builder.items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetDiscountUsage)) {
            return false;
        }
        GetDiscountUsage getDiscountUsage = (GetDiscountUsage) obj;
        if (!equals((Object) this.requestid, (Object) getDiscountUsage.requestid) || !equals((Object) this.token, (Object) getDiscountUsage.token) || !equals((List<?>) this.items, (List<?>) getDiscountUsage.items)) {
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
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ItemShopId> list = this.items;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetDiscountUsage> {
        public List<ItemShopId> items;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetDiscountUsage getDiscountUsage) {
            super(getDiscountUsage);
            if (getDiscountUsage != null) {
                this.requestid = getDiscountUsage.requestid;
                this.token = getDiscountUsage.token;
                this.items = GetDiscountUsage.copyOf(getDiscountUsage.items);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder items(List<ItemShopId> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public GetDiscountUsage build() {
            return new GetDiscountUsage(this);
        }
    }
}
