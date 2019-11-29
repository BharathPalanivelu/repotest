package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PListSetWeight extends Message {
    public static final List<PListWeightMeta> DEFAULT_META_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListWeightMeta.class, tag = 2)
    public final List<PListWeightMeta> meta_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PListSetWeight(String str, List<PListWeightMeta> list, RequestHeader requestHeader) {
        this.requestid = str;
        this.meta_list = immutableCopyOf(list);
        this.header = requestHeader;
    }

    private PListSetWeight(Builder builder) {
        this(builder.requestid, builder.meta_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListSetWeight)) {
            return false;
        }
        PListSetWeight pListSetWeight = (PListSetWeight) obj;
        if (!equals((Object) this.requestid, (Object) pListSetWeight.requestid) || !equals((List<?>) this.meta_list, (List<?>) pListSetWeight.meta_list) || !equals((Object) this.header, (Object) pListSetWeight.header)) {
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
        List<PListWeightMeta> list = this.meta_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListSetWeight> {
        public RequestHeader header;
        public List<PListWeightMeta> meta_list;
        public String requestid;

        public Builder() {
        }

        public Builder(PListSetWeight pListSetWeight) {
            super(pListSetWeight);
            if (pListSetWeight != null) {
                this.requestid = pListSetWeight.requestid;
                this.meta_list = PListSetWeight.copyOf(pListSetWeight.meta_list);
                this.header = pListSetWeight.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder meta_list(List<PListWeightMeta> list) {
            this.meta_list = checkForNulls(list);
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public PListSetWeight build() {
            return new PListSetWeight(this);
        }
    }
}
