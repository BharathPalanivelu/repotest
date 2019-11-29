package com.shopee.protocol.action;

import com.shopee.protocol.search.action.ResponseHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponsePListUpdate extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<PListBoostMeta> DEFAULT_META_LIST = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = PListBoostMeta.class, tag = 3)
    public final List<PListBoostMeta> meta_list;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponsePListUpdate(String str, Integer num, List<PListBoostMeta> list, ResponseHeader responseHeader) {
        this.requestid = str;
        this.errcode = num;
        this.meta_list = immutableCopyOf(list);
        this.header = responseHeader;
    }

    private ResponsePListUpdate(Builder builder) {
        this(builder.requestid, builder.errcode, builder.meta_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponsePListUpdate)) {
            return false;
        }
        ResponsePListUpdate responsePListUpdate = (ResponsePListUpdate) obj;
        if (!equals((Object) this.requestid, (Object) responsePListUpdate.requestid) || !equals((Object) this.errcode, (Object) responsePListUpdate.errcode) || !equals((List<?>) this.meta_list, (List<?>) responsePListUpdate.meta_list) || !equals((Object) this.header, (Object) responsePListUpdate.header)) {
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
        List<PListBoostMeta> list = this.meta_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        ResponseHeader responseHeader = this.header;
        if (responseHeader != null) {
            i2 = responseHeader.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponsePListUpdate> {
        public Integer errcode;
        public ResponseHeader header;
        public List<PListBoostMeta> meta_list;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponsePListUpdate responsePListUpdate) {
            super(responsePListUpdate);
            if (responsePListUpdate != null) {
                this.requestid = responsePListUpdate.requestid;
                this.errcode = responsePListUpdate.errcode;
                this.meta_list = ResponsePListUpdate.copyOf(responsePListUpdate.meta_list);
                this.header = responsePListUpdate.header;
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

        public Builder meta_list(List<PListBoostMeta> list) {
            this.meta_list = checkForNulls(list);
            return this;
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public ResponsePListUpdate build() {
            checkRequiredFields();
            return new ResponsePListUpdate(this);
        }
    }
}
