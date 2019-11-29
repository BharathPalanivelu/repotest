package com.shopee.protocol.action;

import com.shopee.protocol.shop.PenaltyReason;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetPenaltyReason extends Message {
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final PenaltyReason reason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetPenaltyReason(String str, PenaltyReason penaltyReason) {
        this.requestid = str;
        this.reason = penaltyReason;
    }

    private SetPenaltyReason(Builder builder) {
        this(builder.requestid, builder.reason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetPenaltyReason)) {
            return false;
        }
        SetPenaltyReason setPenaltyReason = (SetPenaltyReason) obj;
        if (!equals((Object) this.requestid, (Object) setPenaltyReason.requestid) || !equals((Object) this.reason, (Object) setPenaltyReason.reason)) {
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
        PenaltyReason penaltyReason = this.reason;
        if (penaltyReason != null) {
            i2 = penaltyReason.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetPenaltyReason> {
        public PenaltyReason reason;
        public String requestid;

        public Builder() {
        }

        public Builder(SetPenaltyReason setPenaltyReason) {
            super(setPenaltyReason);
            if (setPenaltyReason != null) {
                this.requestid = setPenaltyReason.requestid;
                this.reason = setPenaltyReason.reason;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder reason(PenaltyReason penaltyReason) {
            this.reason = penaltyReason;
            return this;
        }

        public SetPenaltyReason build() {
            return new SetPenaltyReason(this);
        }
    }
}
