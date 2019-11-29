package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetCollectionItemData extends Message {
    public static final List<CollectionItemId> DEFAULT_COLLECTION_ITEM_ID_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CollectionItemId.class, tag = 2)
    public final List<CollectionItemId> collection_item_id_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCollectionItemData(String str, List<CollectionItemId> list) {
        this.requestid = str;
        this.collection_item_id_list = immutableCopyOf(list);
    }

    private GetCollectionItemData(Builder builder) {
        this(builder.requestid, builder.collection_item_id_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCollectionItemData)) {
            return false;
        }
        GetCollectionItemData getCollectionItemData = (GetCollectionItemData) obj;
        if (!equals((Object) this.requestid, (Object) getCollectionItemData.requestid) || !equals((List<?>) this.collection_item_id_list, (List<?>) getCollectionItemData.collection_item_id_list)) {
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
        List<CollectionItemId> list = this.collection_item_id_list;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetCollectionItemData> {
        public List<CollectionItemId> collection_item_id_list;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCollectionItemData getCollectionItemData) {
            super(getCollectionItemData);
            if (getCollectionItemData != null) {
                this.requestid = getCollectionItemData.requestid;
                this.collection_item_id_list = GetCollectionItemData.copyOf(getCollectionItemData.collection_item_id_list);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder collection_item_id_list(List<CollectionItemId> list) {
            this.collection_item_id_list = checkForNulls(list);
            return this;
        }

        public GetCollectionItemData build() {
            return new GetCollectionItemData(this);
        }
    }
}
