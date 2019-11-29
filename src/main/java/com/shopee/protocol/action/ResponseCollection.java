package com.shopee.protocol.action;

import com.shopee.protocol.shop.ClusterRecord;
import com.shopee.protocol.shop.Collection;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCollection extends Message {
    public static final List<ClusterRecord> DEFAULT_CLUSTER_INFO = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ClusterRecord.class, tag = 4)
    public final List<ClusterRecord> cluster_info;
    @ProtoField(tag = 3)
    public final Collection collection;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCollection(String str, Integer num, Collection collection2, List<ClusterRecord> list) {
        this.requestid = str;
        this.errcode = num;
        this.collection = collection2;
        this.cluster_info = immutableCopyOf(list);
    }

    private ResponseCollection(Builder builder) {
        this(builder.requestid, builder.errcode, builder.collection, builder.cluster_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCollection)) {
            return false;
        }
        ResponseCollection responseCollection = (ResponseCollection) obj;
        if (!equals((Object) this.requestid, (Object) responseCollection.requestid) || !equals((Object) this.errcode, (Object) responseCollection.errcode) || !equals((Object) this.collection, (Object) responseCollection.collection) || !equals((List<?>) this.cluster_info, (List<?>) responseCollection.cluster_info)) {
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
        Collection collection2 = this.collection;
        if (collection2 != null) {
            i2 = collection2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<ClusterRecord> list = this.cluster_info;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseCollection> {
        public List<ClusterRecord> cluster_info;
        public Collection collection;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCollection responseCollection) {
            super(responseCollection);
            if (responseCollection != null) {
                this.requestid = responseCollection.requestid;
                this.errcode = responseCollection.errcode;
                this.collection = responseCollection.collection;
                this.cluster_info = ResponseCollection.copyOf(responseCollection.cluster_info);
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

        public Builder collection(Collection collection2) {
            this.collection = collection2;
            return this;
        }

        public Builder cluster_info(List<ClusterRecord> list) {
            this.cluster_info = checkForNulls(list);
            return this;
        }

        public ResponseCollection build() {
            checkRequiredFields();
            return new ResponseCollection(this);
        }
    }
}
