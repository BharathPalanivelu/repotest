package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCollectionItem extends Message {
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCollectionItem(String str, Integer num, Integer num2, Integer num3) {
        this.requestid = str;
        this.collection_id = num;
        this.offset = num2;
        this.limit = num3;
    }

    private GetCollectionItem(Builder builder) {
        this(builder.requestid, builder.collection_id, builder.offset, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCollectionItem)) {
            return false;
        }
        GetCollectionItem getCollectionItem = (GetCollectionItem) obj;
        if (!equals((Object) this.requestid, (Object) getCollectionItem.requestid) || !equals((Object) this.collection_id, (Object) getCollectionItem.collection_id) || !equals((Object) this.offset, (Object) getCollectionItem.offset) || !equals((Object) this.limit, (Object) getCollectionItem.limit)) {
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
        Integer num = this.collection_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCollectionItem> {
        public Integer collection_id;
        public Integer limit;
        public Integer offset;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCollectionItem getCollectionItem) {
            super(getCollectionItem);
            if (getCollectionItem != null) {
                this.requestid = getCollectionItem.requestid;
                this.collection_id = getCollectionItem.collection_id;
                this.offset = getCollectionItem.offset;
                this.limit = getCollectionItem.limit;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public GetCollectionItem build() {
            checkRequiredFields();
            return new GetCollectionItem(this);
        }
    }
}
