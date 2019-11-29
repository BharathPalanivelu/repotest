package com.shopee.protocol.action;

import com.shopee.protocol.search.action.ResponseHeader;
import com.shopee.protocol.shop.MarketPushnoti;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCreateMarketPN extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 5)
    public final ResponseHeader header;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final MarketPushnoti market_pushnoti;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCreateMarketPN(String str, Integer num, MarketPushnoti marketPushnoti, ResponseHeader responseHeader) {
        this.requestid = str;
        this.errcode = num;
        this.market_pushnoti = marketPushnoti;
        this.header = responseHeader;
    }

    private ResponseCreateMarketPN(Builder builder) {
        this(builder.requestid, builder.errcode, builder.market_pushnoti, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCreateMarketPN)) {
            return false;
        }
        ResponseCreateMarketPN responseCreateMarketPN = (ResponseCreateMarketPN) obj;
        if (!equals((Object) this.requestid, (Object) responseCreateMarketPN.requestid) || !equals((Object) this.errcode, (Object) responseCreateMarketPN.errcode) || !equals((Object) this.market_pushnoti, (Object) responseCreateMarketPN.market_pushnoti) || !equals((Object) this.header, (Object) responseCreateMarketPN.header)) {
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
        MarketPushnoti marketPushnoti = this.market_pushnoti;
        int hashCode3 = (hashCode2 + (marketPushnoti != null ? marketPushnoti.hashCode() : 0)) * 37;
        ResponseHeader responseHeader = this.header;
        if (responseHeader != null) {
            i2 = responseHeader.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCreateMarketPN> {
        public Integer errcode;
        public ResponseHeader header;
        public MarketPushnoti market_pushnoti;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCreateMarketPN responseCreateMarketPN) {
            super(responseCreateMarketPN);
            if (responseCreateMarketPN != null) {
                this.requestid = responseCreateMarketPN.requestid;
                this.errcode = responseCreateMarketPN.errcode;
                this.market_pushnoti = responseCreateMarketPN.market_pushnoti;
                this.header = responseCreateMarketPN.header;
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

        public Builder market_pushnoti(MarketPushnoti marketPushnoti) {
            this.market_pushnoti = marketPushnoti;
            return this;
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public ResponseCreateMarketPN build() {
            checkRequiredFields();
            return new ResponseCreateMarketPN(this);
        }
    }
}
