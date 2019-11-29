package com.shopee.protocol.action;

import com.shopee.protocol.shop.ClusterRecord;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetClusterData extends Message {
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final List<ClusterRecord> DEFAULT_CLUSTER_INFO = Collections.emptyList();
    public static final List<CollectionItemData> DEFAULT_COLLECTION_ITEM_DATA_LIST = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SOURCE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cluster_id;
    @ProtoField(label = Message.Label.REPEATED, messageType = ClusterRecord.class, tag = 3)
    public final List<ClusterRecord> cluster_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = CollectionItemData.class, tag = 4)
    public final List<CollectionItemData> collection_item_data_list;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer source;

    public SetClusterData(String str, String str2, List<ClusterRecord> list, List<CollectionItemData> list2, String str3, Integer num) {
        this.requestid = str;
        this.cluster_id = str2;
        this.cluster_info = immutableCopyOf(list);
        this.collection_item_data_list = immutableCopyOf(list2);
        this.country = str3;
        this.source = num;
    }

    private SetClusterData(Builder builder) {
        this(builder.requestid, builder.cluster_id, builder.cluster_info, builder.collection_item_data_list, builder.country, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetClusterData)) {
            return false;
        }
        SetClusterData setClusterData = (SetClusterData) obj;
        if (!equals((Object) this.requestid, (Object) setClusterData.requestid) || !equals((Object) this.cluster_id, (Object) setClusterData.cluster_id) || !equals((List<?>) this.cluster_info, (List<?>) setClusterData.cluster_info) || !equals((List<?>) this.collection_item_data_list, (List<?>) setClusterData.collection_item_data_list) || !equals((Object) this.country, (Object) setClusterData.country) || !equals((Object) this.source, (Object) setClusterData.source)) {
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
        String str2 = this.cluster_id;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<ClusterRecord> list = this.cluster_info;
        int i3 = 1;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        List<CollectionItemData> list2 = this.collection_item_data_list;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode3 + i3) * 37;
        String str3 = this.country;
        int hashCode4 = (i4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.source;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i5 = hashCode4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<SetClusterData> {
        public String cluster_id;
        public List<ClusterRecord> cluster_info;
        public List<CollectionItemData> collection_item_data_list;
        public String country;
        public String requestid;
        public Integer source;

        public Builder() {
        }

        public Builder(SetClusterData setClusterData) {
            super(setClusterData);
            if (setClusterData != null) {
                this.requestid = setClusterData.requestid;
                this.cluster_id = setClusterData.cluster_id;
                this.cluster_info = SetClusterData.copyOf(setClusterData.cluster_info);
                this.collection_item_data_list = SetClusterData.copyOf(setClusterData.collection_item_data_list);
                this.country = setClusterData.country;
                this.source = setClusterData.source;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder cluster_id(String str) {
            this.cluster_id = str;
            return this;
        }

        public Builder cluster_info(List<ClusterRecord> list) {
            this.cluster_info = checkForNulls(list);
            return this;
        }

        public Builder collection_item_data_list(List<CollectionItemData> list) {
            this.collection_item_data_list = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public SetClusterData build() {
            return new SetClusterData(this);
        }
    }
}
