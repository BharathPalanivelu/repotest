package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetCollectionItemData extends Message {
    public static final List<CollectionItemData> DEFAULT_COLLECTION_ITEM_DATA_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CollectionItemData.class, tag = 2)
    public final List<CollectionItemData> collection_item_data_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetCollectionItemData(String str, List<CollectionItemData> list) {
        this.requestid = str;
        this.collection_item_data_list = immutableCopyOf(list);
    }

    private SetCollectionItemData(Builder builder) {
        this(builder.requestid, builder.collection_item_data_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCollectionItemData)) {
            return false;
        }
        SetCollectionItemData setCollectionItemData = (SetCollectionItemData) obj;
        if (!equals((Object) this.requestid, (Object) setCollectionItemData.requestid) || !equals((List<?>) this.collection_item_data_list, (List<?>) setCollectionItemData.collection_item_data_list)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<CollectionItemData> list = this.collection_item_data_list;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<SetCollectionItemData> {
        public List<CollectionItemData> collection_item_data_list;
        public String requestid;

        public Builder() {
        }

        public Builder(SetCollectionItemData setCollectionItemData) {
            super(setCollectionItemData);
            if (setCollectionItemData != null) {
                this.requestid = setCollectionItemData.requestid;
                this.collection_item_data_list = SetCollectionItemData.copyOf(setCollectionItemData.collection_item_data_list);
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

        public SetCollectionItemData build() {
            return new SetCollectionItemData(this);
        }
    }
}
