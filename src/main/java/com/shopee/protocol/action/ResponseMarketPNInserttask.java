package com.shopee.protocol.action;

import com.shopee.protocol.search.action.ResponseHeader;
import com.shopee.protocol.shop.MarketPushnotiTasklist;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseMarketPNInserttask extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<MarketPushnotiTasklist> DEFAULT_TASK_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final ResponseHeader header;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = MarketPushnotiTasklist.class, tag = 3)
    public final List<MarketPushnotiTasklist> task_list;

    public ResponseMarketPNInserttask(String str, Integer num, List<MarketPushnotiTasklist> list, ResponseHeader responseHeader) {
        this.requestid = str;
        this.errcode = num;
        this.task_list = immutableCopyOf(list);
        this.header = responseHeader;
    }

    private ResponseMarketPNInserttask(Builder builder) {
        this(builder.requestid, builder.errcode, builder.task_list, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseMarketPNInserttask)) {
            return false;
        }
        ResponseMarketPNInserttask responseMarketPNInserttask = (ResponseMarketPNInserttask) obj;
        if (!equals((Object) this.requestid, (Object) responseMarketPNInserttask.requestid) || !equals((Object) this.errcode, (Object) responseMarketPNInserttask.errcode) || !equals((List<?>) this.task_list, (List<?>) responseMarketPNInserttask.task_list) || !equals((Object) this.header, (Object) responseMarketPNInserttask.header)) {
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
        List<MarketPushnotiTasklist> list = this.task_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        ResponseHeader responseHeader = this.header;
        if (responseHeader != null) {
            i2 = responseHeader.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseMarketPNInserttask> {
        public Integer errcode;
        public ResponseHeader header;
        public String requestid;
        public List<MarketPushnotiTasklist> task_list;

        public Builder() {
        }

        public Builder(ResponseMarketPNInserttask responseMarketPNInserttask) {
            super(responseMarketPNInserttask);
            if (responseMarketPNInserttask != null) {
                this.requestid = responseMarketPNInserttask.requestid;
                this.errcode = responseMarketPNInserttask.errcode;
                this.task_list = ResponseMarketPNInserttask.copyOf(responseMarketPNInserttask.task_list);
                this.header = responseMarketPNInserttask.header;
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

        public Builder task_list(List<MarketPushnotiTasklist> list) {
            this.task_list = checkForNulls(list);
            return this;
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public ResponseMarketPNInserttask build() {
            checkRequiredFields();
            return new ResponseMarketPNInserttask(this);
        }
    }
}
