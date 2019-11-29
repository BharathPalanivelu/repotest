package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PListUpdate extends Message {
    public static final List<PListFactor> DEFAULT_FACTOR_LIST = Collections.emptyList();
    public static final List<PListUpdateMeta> DEFAULT_ITEM_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListFactor.class, tag = 4)
    public final List<PListFactor> factor_list;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListUpdateMeta.class, tag = 3)
    public final List<PListUpdateMeta> item_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PListUpdate(String str, List<PListUpdateMeta> list, List<PListFactor> list2, RequestHeader requestHeader) {
        this.requestid = str;
        this.item_list = immutableCopyOf(list);
        this.factor_list = immutableCopyOf(list2);
        this.header = requestHeader;
    }

    private PListUpdate(Builder builder) {
        this(builder.requestid, builder.item_list, builder.factor_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PListUpdate)) {
            return false;
        }
        PListUpdate pListUpdate = (PListUpdate) obj;
        if (!equals((Object) this.requestid, (Object) pListUpdate.requestid) || !equals((List<?>) this.item_list, (List<?>) pListUpdate.item_list) || !equals((List<?>) this.factor_list, (List<?>) pListUpdate.factor_list) || !equals((Object) this.header, (Object) pListUpdate.header)) {
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
        List<PListUpdateMeta> list = this.item_list;
        int i3 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<PListFactor> list2 = this.factor_list;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        int i4 = (hashCode2 + i3) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<PListUpdate> {
        public List<PListFactor> factor_list;
        public RequestHeader header;
        public List<PListUpdateMeta> item_list;
        public String requestid;

        public Builder() {
        }

        public Builder(PListUpdate pListUpdate) {
            super(pListUpdate);
            if (pListUpdate != null) {
                this.requestid = pListUpdate.requestid;
                this.item_list = PListUpdate.copyOf(pListUpdate.item_list);
                this.factor_list = PListUpdate.copyOf(pListUpdate.factor_list);
                this.header = pListUpdate.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder item_list(List<PListUpdateMeta> list) {
            this.item_list = checkForNulls(list);
            return this;
        }

        public Builder factor_list(List<PListFactor> list) {
            this.factor_list = checkForNulls(list);
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public PListUpdate build() {
            return new PListUpdate(this);
        }
    }
}
