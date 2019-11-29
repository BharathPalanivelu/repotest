package com.shopee.protocol.search.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSearchSpu extends Message {
    public static final List<ResultSpu> DEFAULT_SPU = Collections.emptyList();
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REPEATED, messageType = ResultSpu.class, tag = 2)
    public final List<ResultSpu> spu;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer total_count;

    public ResponseSearchSpu(ResponseHeader responseHeader, List<ResultSpu> list, Integer num) {
        this.header = responseHeader;
        this.spu = immutableCopyOf(list);
        this.total_count = num;
    }

    private ResponseSearchSpu(Builder builder) {
        this(builder.header, builder.spu, builder.total_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSearchSpu)) {
            return false;
        }
        ResponseSearchSpu responseSearchSpu = (ResponseSearchSpu) obj;
        if (!equals((Object) this.header, (Object) responseSearchSpu.header) || !equals((List<?>) this.spu, (List<?>) responseSearchSpu.spu) || !equals((Object) this.total_count, (Object) responseSearchSpu.total_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ResponseHeader responseHeader = this.header;
        int i2 = 0;
        int hashCode = (responseHeader != null ? responseHeader.hashCode() : 0) * 37;
        List<ResultSpu> list = this.spu;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.total_count;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseSearchSpu> {
        public ResponseHeader header;
        public List<ResultSpu> spu;
        public Integer total_count;

        public Builder() {
        }

        public Builder(ResponseSearchSpu responseSearchSpu) {
            super(responseSearchSpu);
            if (responseSearchSpu != null) {
                this.header = responseSearchSpu.header;
                this.spu = ResponseSearchSpu.copyOf(responseSearchSpu.spu);
                this.total_count = responseSearchSpu.total_count;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder spu(List<ResultSpu> list) {
            this.spu = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public ResponseSearchSpu build() {
            return new ResponseSearchSpu(this);
        }
    }
}
