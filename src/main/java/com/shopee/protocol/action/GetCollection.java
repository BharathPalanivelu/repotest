package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetCollection extends Message {
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Boolean DEFAULT_NEED_DATA = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean need_data;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCollection(String str, Integer num, Boolean bool) {
        this.requestid = str;
        this.collection_id = num;
        this.need_data = bool;
    }

    private GetCollection(Builder builder) {
        this(builder.requestid, builder.collection_id, builder.need_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCollection)) {
            return false;
        }
        GetCollection getCollection = (GetCollection) obj;
        if (!equals((Object) this.requestid, (Object) getCollection.requestid) || !equals((Object) this.collection_id, (Object) getCollection.collection_id) || !equals((Object) this.need_data, (Object) getCollection.need_data)) {
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
        Boolean bool = this.need_data;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCollection> {
        public Integer collection_id;
        public Boolean need_data;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCollection getCollection) {
            super(getCollection);
            if (getCollection != null) {
                this.requestid = getCollection.requestid;
                this.collection_id = getCollection.collection_id;
                this.need_data = getCollection.need_data;
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

        public Builder need_data(Boolean bool) {
            this.need_data = bool;
            return this;
        }

        public GetCollection build() {
            checkRequiredFields();
            return new GetCollection(this);
        }
    }
}
