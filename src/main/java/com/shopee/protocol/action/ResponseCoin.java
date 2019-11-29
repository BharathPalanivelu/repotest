package com.shopee.protocol.action;

import com.shopee.protocol.shop.Coin;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseCoin extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Integer DEFAULT_MONTHS_TO_EXPIRE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final Coin coin;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer months_to_expire;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCoin(String str, Integer num, Coin coin2, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.coin = coin2;
        this.months_to_expire = num2;
    }

    private ResponseCoin(Builder builder) {
        this(builder.requestid, builder.errcode, builder.coin, builder.months_to_expire);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCoin)) {
            return false;
        }
        ResponseCoin responseCoin = (ResponseCoin) obj;
        if (!equals((Object) this.requestid, (Object) responseCoin.requestid) || !equals((Object) this.errcode, (Object) responseCoin.errcode) || !equals((Object) this.coin, (Object) responseCoin.coin) || !equals((Object) this.months_to_expire, (Object) responseCoin.months_to_expire)) {
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
        Coin coin2 = this.coin;
        int hashCode3 = (hashCode2 + (coin2 != null ? coin2.hashCode() : 0)) * 37;
        Integer num2 = this.months_to_expire;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseCoin> {
        public Coin coin;
        public Integer errcode;
        public Integer months_to_expire;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCoin responseCoin) {
            super(responseCoin);
            if (responseCoin != null) {
                this.requestid = responseCoin.requestid;
                this.errcode = responseCoin.errcode;
                this.coin = responseCoin.coin;
                this.months_to_expire = responseCoin.months_to_expire;
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

        public Builder coin(Coin coin2) {
            this.coin = coin2;
            return this;
        }

        public Builder months_to_expire(Integer num) {
            this.months_to_expire = num;
            return this;
        }

        public ResponseCoin build() {
            return new ResponseCoin(this);
        }
    }
}
