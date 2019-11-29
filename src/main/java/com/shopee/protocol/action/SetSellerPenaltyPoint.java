package com.shopee.protocol.action;

import com.shopee.protocol.shop.ShopPenaltyHistoricalLog;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetSellerPenaltyPoint extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(tag = 3)
    public final ShopPenaltyHistoricalLog record;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetSellerPenaltyPoint(String str, BackendParam backendParam, ShopPenaltyHistoricalLog shopPenaltyHistoricalLog) {
        this.requestid = str;
        this.bparam = backendParam;
        this.record = shopPenaltyHistoricalLog;
    }

    private SetSellerPenaltyPoint(Builder builder) {
        this(builder.requestid, builder.bparam, builder.record);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetSellerPenaltyPoint)) {
            return false;
        }
        SetSellerPenaltyPoint setSellerPenaltyPoint = (SetSellerPenaltyPoint) obj;
        if (!equals((Object) this.requestid, (Object) setSellerPenaltyPoint.requestid) || !equals((Object) this.bparam, (Object) setSellerPenaltyPoint.bparam) || !equals((Object) this.record, (Object) setSellerPenaltyPoint.record)) {
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
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        ShopPenaltyHistoricalLog shopPenaltyHistoricalLog = this.record;
        if (shopPenaltyHistoricalLog != null) {
            i2 = shopPenaltyHistoricalLog.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetSellerPenaltyPoint> {
        public BackendParam bparam;
        public ShopPenaltyHistoricalLog record;
        public String requestid;

        public Builder() {
        }

        public Builder(SetSellerPenaltyPoint setSellerPenaltyPoint) {
            super(setSellerPenaltyPoint);
            if (setSellerPenaltyPoint != null) {
                this.requestid = setSellerPenaltyPoint.requestid;
                this.bparam = setSellerPenaltyPoint.bparam;
                this.record = setSellerPenaltyPoint.record;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder record(ShopPenaltyHistoricalLog shopPenaltyHistoricalLog) {
            this.record = shopPenaltyHistoricalLog;
            return this;
        }

        public SetSellerPenaltyPoint build() {
            return new SetSellerPenaltyPoint(this);
        }
    }
}
