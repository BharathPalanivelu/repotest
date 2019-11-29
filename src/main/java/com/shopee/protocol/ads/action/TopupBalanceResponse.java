package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TopupBalanceResponse extends Message {
    public static final Long DEFAULT_BALANCE = 0L;
    public static final String DEFAULT_ERR_MESSAGE = "";
    public static final String DEFAULT_SIGNATURE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long balance;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String err_message;
    @ProtoField(tag = 1)
    public final ResponseHeader header;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String signature;

    public TopupBalanceResponse(ResponseHeader responseHeader, Long l, String str, String str2) {
        this.header = responseHeader;
        this.balance = l;
        this.err_message = str;
        this.signature = str2;
    }

    private TopupBalanceResponse(Builder builder) {
        this(builder.header, builder.balance, builder.err_message, builder.signature);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TopupBalanceResponse)) {
            return false;
        }
        TopupBalanceResponse topupBalanceResponse = (TopupBalanceResponse) obj;
        if (!equals((Object) this.header, (Object) topupBalanceResponse.header) || !equals((Object) this.balance, (Object) topupBalanceResponse.balance) || !equals((Object) this.err_message, (Object) topupBalanceResponse.err_message) || !equals((Object) this.signature, (Object) topupBalanceResponse.signature)) {
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
        Long l = this.balance;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.err_message;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.signature;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TopupBalanceResponse> {
        public Long balance;
        public String err_message;
        public ResponseHeader header;
        public String signature;

        public Builder() {
        }

        public Builder(TopupBalanceResponse topupBalanceResponse) {
            super(topupBalanceResponse);
            if (topupBalanceResponse != null) {
                this.header = topupBalanceResponse.header;
                this.balance = topupBalanceResponse.balance;
                this.err_message = topupBalanceResponse.err_message;
                this.signature = topupBalanceResponse.signature;
            }
        }

        public Builder header(ResponseHeader responseHeader) {
            this.header = responseHeader;
            return this;
        }

        public Builder balance(Long l) {
            this.balance = l;
            return this;
        }

        public Builder err_message(String str) {
            this.err_message = str;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public TopupBalanceResponse build() {
            return new TopupBalanceResponse(this);
        }
    }
}
