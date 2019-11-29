package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.shopee.protocol.shop.ItemAttribute;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetItemAttribute extends Message {
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final ItemAttribute attr;
    @ProtoField(tag = 2)
    public final RequestHeader header;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetItemAttribute(String str, RequestHeader requestHeader, ItemAttribute itemAttribute, String str2) {
        this.requestid = str;
        this.header = requestHeader;
        this.attr = itemAttribute;
        this.operator = str2;
    }

    private SetItemAttribute(Builder builder) {
        this(builder.requestid, builder.header, builder.attr, builder.operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetItemAttribute)) {
            return false;
        }
        SetItemAttribute setItemAttribute = (SetItemAttribute) obj;
        if (!equals((Object) this.requestid, (Object) setItemAttribute.requestid) || !equals((Object) this.header, (Object) setItemAttribute.header) || !equals((Object) this.attr, (Object) setItemAttribute.attr) || !equals((Object) this.operator, (Object) setItemAttribute.operator)) {
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
        RequestHeader requestHeader = this.header;
        int hashCode2 = (hashCode + (requestHeader != null ? requestHeader.hashCode() : 0)) * 37;
        ItemAttribute itemAttribute = this.attr;
        int hashCode3 = (hashCode2 + (itemAttribute != null ? itemAttribute.hashCode() : 0)) * 37;
        String str2 = this.operator;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetItemAttribute> {
        public ItemAttribute attr;
        public RequestHeader header;
        public String operator;
        public String requestid;

        public Builder() {
        }

        public Builder(SetItemAttribute setItemAttribute) {
            super(setItemAttribute);
            if (setItemAttribute != null) {
                this.requestid = setItemAttribute.requestid;
                this.header = setItemAttribute.header;
                this.attr = setItemAttribute.attr;
                this.operator = setItemAttribute.operator;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder attr(ItemAttribute itemAttribute) {
            this.attr = itemAttribute;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public SetItemAttribute build() {
            return new SetItemAttribute(this);
        }
    }
}
