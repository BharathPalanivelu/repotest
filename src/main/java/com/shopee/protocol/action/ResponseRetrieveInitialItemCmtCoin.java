package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ResponseRetrieveInitialItemCmtCoin extends Message {
    public static final Long DEFAULT_CMTID = 0L;
    public static final Long DEFAULT_COINS_RETRIEVED = 0L;
    public static final Integer DEFAULT_COIN_STATUS = 0;
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long cmtid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer coin_status;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long coins_retrieved;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseRetrieveInitialItemCmtCoin(String str, String str2, Integer num, Long l, Long l2, Integer num2) {
        this.requestid = str;
        this.debug_msg = str2;
        this.errcode = num;
        this.cmtid = l;
        this.coins_retrieved = l2;
        this.coin_status = num2;
    }

    private ResponseRetrieveInitialItemCmtCoin(Builder builder) {
        this(builder.requestid, builder.debug_msg, builder.errcode, builder.cmtid, builder.coins_retrieved, builder.coin_status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseRetrieveInitialItemCmtCoin)) {
            return false;
        }
        ResponseRetrieveInitialItemCmtCoin responseRetrieveInitialItemCmtCoin = (ResponseRetrieveInitialItemCmtCoin) obj;
        if (!equals((Object) this.requestid, (Object) responseRetrieveInitialItemCmtCoin.requestid) || !equals((Object) this.debug_msg, (Object) responseRetrieveInitialItemCmtCoin.debug_msg) || !equals((Object) this.errcode, (Object) responseRetrieveInitialItemCmtCoin.errcode) || !equals((Object) this.cmtid, (Object) responseRetrieveInitialItemCmtCoin.cmtid) || !equals((Object) this.coins_retrieved, (Object) responseRetrieveInitialItemCmtCoin.coins_retrieved) || !equals((Object) this.coin_status, (Object) responseRetrieveInitialItemCmtCoin.coin_status)) {
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
        String str2 = this.debug_msg;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.errcode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.cmtid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.coins_retrieved;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.coin_status;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseRetrieveInitialItemCmtCoin> {
        public Long cmtid;
        public Integer coin_status;
        public Long coins_retrieved;
        public String debug_msg;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseRetrieveInitialItemCmtCoin responseRetrieveInitialItemCmtCoin) {
            super(responseRetrieveInitialItemCmtCoin);
            if (responseRetrieveInitialItemCmtCoin != null) {
                this.requestid = responseRetrieveInitialItemCmtCoin.requestid;
                this.debug_msg = responseRetrieveInitialItemCmtCoin.debug_msg;
                this.errcode = responseRetrieveInitialItemCmtCoin.errcode;
                this.cmtid = responseRetrieveInitialItemCmtCoin.cmtid;
                this.coins_retrieved = responseRetrieveInitialItemCmtCoin.coins_retrieved;
                this.coin_status = responseRetrieveInitialItemCmtCoin.coin_status;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder cmtid(Long l) {
            this.cmtid = l;
            return this;
        }

        public Builder coins_retrieved(Long l) {
            this.coins_retrieved = l;
            return this;
        }

        public Builder coin_status(Integer num) {
            this.coin_status = num;
            return this;
        }

        public ResponseRetrieveInitialItemCmtCoin build() {
            return new ResponseRetrieveInitialItemCmtCoin(this);
        }
    }
}
