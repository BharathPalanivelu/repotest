package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PListSetBoost extends Message {
    public static final List<PListBoostMeta> DEFAULT_META_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListBoostMeta.class, tag = 2)
    public final List<PListBoostMeta> meta_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PListSetBoost(String str, List<PListBoostMeta> list, RequestHeader requestHeader) {
        this.requestid = str;
        this.meta_list = immutableCopyOf(list);
        this.header = requestHeader;
    }

    private PListSetBoost(Builder builder) {
        this(builder.requestid, builder.meta_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListSetBoost)) {
            return false;
        }
        PListSetBoost pListSetBoost = (PListSetBoost) obj;
        if (!equals((Object) this.requestid, (Object) pListSetBoost.requestid) || !equals((List<?>) this.meta_list, (List<?>) pListSetBoost.meta_list) || !equals((Object) this.header, (Object) pListSetBoost.header)) {
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
        List<PListBoostMeta> list = this.meta_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PListSetBoost> {
        public RequestHeader header;
        public List<PListBoostMeta> meta_list;
        public String requestid;

        public Builder() {
        }

        public Builder(PListSetBoost pListSetBoost) {
            super(pListSetBoost);
            if (pListSetBoost != null) {
                this.requestid = pListSetBoost.requestid;
                this.meta_list = PListSetBoost.copyOf(pListSetBoost.meta_list);
                this.header = pListSetBoost.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder meta_list(List<PListBoostMeta> list) {
            this.meta_list = checkForNulls(list);
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public PListSetBoost build() {
            return new PListSetBoost(this);
        }
    }
}
