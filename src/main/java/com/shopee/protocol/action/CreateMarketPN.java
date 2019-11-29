package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.shopee.protocol.shop.MarketPushnoti;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CreateMarketPN extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final MarketPushnoti market_pushnoti;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public CreateMarketPN(String str, MarketPushnoti marketPushnoti, RequestHeader requestHeader) {
        this.requestid = str;
        this.market_pushnoti = marketPushnoti;
        this.header = requestHeader;
    }

    private CreateMarketPN(Builder builder) {
        this(builder.requestid, builder.market_pushnoti, builder.header);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreateMarketPN)) {
            return false;
        }
        CreateMarketPN createMarketPN = (CreateMarketPN) obj;
        if (!equals((Object) this.requestid, (Object) createMarketPN.requestid) || !equals((Object) this.market_pushnoti, (Object) createMarketPN.market_pushnoti) || !equals((Object) this.header, (Object) createMarketPN.header)) {
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
        MarketPushnoti marketPushnoti = this.market_pushnoti;
        int hashCode2 = (hashCode + (marketPushnoti != null ? marketPushnoti.hashCode() : 0)) * 37;
        RequestHeader requestHeader = this.header;
        if (requestHeader != null) {
            i2 = requestHeader.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CreateMarketPN> {
        public RequestHeader header;
        public MarketPushnoti market_pushnoti;
        public String requestid;

        public Builder() {
        }

        public Builder(CreateMarketPN createMarketPN) {
            super(createMarketPN);
            if (createMarketPN != null) {
                this.requestid = createMarketPN.requestid;
                this.market_pushnoti = createMarketPN.market_pushnoti;
                this.header = createMarketPN.header;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder market_pushnoti(MarketPushnoti marketPushnoti) {
            this.market_pushnoti = marketPushnoti;
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public CreateMarketPN build() {
            checkRequiredFields();
            return new CreateMarketPN(this);
        }
    }
}
