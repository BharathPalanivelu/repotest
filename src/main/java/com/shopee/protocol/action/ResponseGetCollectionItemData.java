package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetCollectionItemData extends Message {
    public static final List<CollectionItemData> DEFAULT_COLLECTION_ITEM_DATA_LIST = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CollectionItemData.class, tag = 2)
    public final List<CollectionItemData> collection_item_data_list;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetCollectionItemData(String str, List<CollectionItemData> list, Integer num) {
        this.requestid = str;
        this.collection_item_data_list = immutableCopyOf(list);
        this.errcode = num;
    }

    private ResponseGetCollectionItemData(Builder builder) {
        this(builder.requestid, builder.collection_item_data_list, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetCollectionItemData)) {
            return false;
        }
        ResponseGetCollectionItemData responseGetCollectionItemData = (ResponseGetCollectionItemData) obj;
        if (!equals((Object) this.requestid, (Object) responseGetCollectionItemData.requestid) || !equals((List<?>) this.collection_item_data_list, (List<?>) responseGetCollectionItemData.collection_item_data_list) || !equals((Object) this.errcode, (Object) responseGetCollectionItemData.errcode)) {
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
        List<CollectionItemData> list = this.collection_item_data_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetCollectionItemData> {
        public List<CollectionItemData> collection_item_data_list;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetCollectionItemData responseGetCollectionItemData) {
            super(responseGetCollectionItemData);
            if (responseGetCollectionItemData != null) {
                this.requestid = responseGetCollectionItemData.requestid;
                this.collection_item_data_list = ResponseGetCollectionItemData.copyOf(responseGetCollectionItemData.collection_item_data_list);
                this.errcode = responseGetCollectionItemData.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder collection_item_data_list(List<CollectionItemData> list) {
            this.collection_item_data_list = checkForNulls(list);
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseGetCollectionItemData build() {
            return new ResponseGetCollectionItemData(this);
        }
    }
}
