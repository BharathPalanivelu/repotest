package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCollectionList extends Message {
    public static final List<CollectionInfo> DEFAULT_COLLECTION_LIST = Collections.emptyList();
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_HASMORE = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CollectionInfo.class, tag = 3)
    public final List<CollectionInfo> collection_list;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean hasMore;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCollectionList(String str, Integer num, List<CollectionInfo> list, Boolean bool, String str2) {
        this.requestid = str;
        this.errcode = num;
        this.collection_list = immutableCopyOf(list);
        this.hasMore = bool;
        this.debug_msg = str2;
    }

    private ResponseCollectionList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.collection_list, builder.hasMore, builder.debug_msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCollectionList)) {
            return false;
        }
        ResponseCollectionList responseCollectionList = (ResponseCollectionList) obj;
        if (!equals((Object) this.requestid, (Object) responseCollectionList.requestid) || !equals((Object) this.errcode, (Object) responseCollectionList.errcode) || !equals((List<?>) this.collection_list, (List<?>) responseCollectionList.collection_list) || !equals((Object) this.hasMore, (Object) responseCollectionList.hasMore) || !equals((Object) this.debug_msg, (Object) responseCollectionList.debug_msg)) {
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
        Integer num = this.errcode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<CollectionInfo> list = this.collection_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.hasMore;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCollectionList> {
        public List<CollectionInfo> collection_list;
        public String debug_msg;
        public Integer errcode;
        public Boolean hasMore;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCollectionList responseCollectionList) {
            super(responseCollectionList);
            if (responseCollectionList != null) {
                this.requestid = responseCollectionList.requestid;
                this.errcode = responseCollectionList.errcode;
                this.collection_list = ResponseCollectionList.copyOf(responseCollectionList.collection_list);
                this.hasMore = responseCollectionList.hasMore;
                this.debug_msg = responseCollectionList.debug_msg;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder collection_list(List<CollectionInfo> list) {
            this.collection_list = checkForNulls(list);
            return this;
        }

        public Builder hasMore(Boolean bool) {
            this.hasMore = bool;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public ResponseCollectionList build() {
            return new ResponseCollectionList(this);
        }
    }
}
