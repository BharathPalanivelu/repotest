package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetCollectionList extends Message {
    public static final Integer DEFAULT_COLLECTION_LIST_TYPE = 0;
    public static final Integer DEFAULT_COUNT = 0;
    public static final List<Filter> DEFAULT_FILTERS = Collections.emptyList();
    public static final Boolean DEFAULT_GET_CLUSTER_INFO = false;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer collection_list_type;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer count;
    @ProtoField(label = Message.Label.REPEATED, messageType = Filter.class, tag = 6)
    public final List<Filter> filters;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean get_cluster_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public GetCollectionList(String str, Integer num, Integer num2, Integer num3, Boolean bool, List<Filter> list) {
        this.requestid = str;
        this.collection_list_type = num;
        this.offset = num2;
        this.count = num3;
        this.get_cluster_info = bool;
        this.filters = immutableCopyOf(list);
    }

    private GetCollectionList(Builder builder) {
        this(builder.requestid, builder.collection_list_type, builder.offset, builder.count, builder.get_cluster_info, builder.filters);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCollectionList)) {
            return false;
        }
        GetCollectionList getCollectionList = (GetCollectionList) obj;
        if (!equals((Object) this.requestid, (Object) getCollectionList.requestid) || !equals((Object) this.collection_list_type, (Object) getCollectionList.collection_list_type) || !equals((Object) this.offset, (Object) getCollectionList.offset) || !equals((Object) this.count, (Object) getCollectionList.count) || !equals((Object) this.get_cluster_info, (Object) getCollectionList.get_cluster_info) || !equals((List<?>) this.filters, (List<?>) getCollectionList.filters)) {
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
        Integer num = this.collection_list_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.offset;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.count;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.get_cluster_info;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = (hashCode4 + i2) * 37;
        List<Filter> list = this.filters;
        int hashCode5 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    public static final class Builder extends Message.Builder<GetCollectionList> {
        public Integer collection_list_type;
        public Integer count;
        public List<Filter> filters;
        public Boolean get_cluster_info;
        public Integer offset;
        public String requestid;

        public Builder() {
        }

        public Builder(GetCollectionList getCollectionList) {
            super(getCollectionList);
            if (getCollectionList != null) {
                this.requestid = getCollectionList.requestid;
                this.collection_list_type = getCollectionList.collection_list_type;
                this.offset = getCollectionList.offset;
                this.count = getCollectionList.count;
                this.get_cluster_info = getCollectionList.get_cluster_info;
                this.filters = GetCollectionList.copyOf(getCollectionList.filters);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder collection_list_type(Integer num) {
            this.collection_list_type = num;
            return this;
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder count(Integer num) {
            this.count = num;
            return this;
        }

        public Builder get_cluster_info(Boolean bool) {
            this.get_cluster_info = bool;
            return this;
        }

        public Builder filters(List<Filter> list) {
            this.filters = checkForNulls(list);
            return this;
        }

        public GetCollectionList build() {
            return new GetCollectionList(this);
        }
    }
}
