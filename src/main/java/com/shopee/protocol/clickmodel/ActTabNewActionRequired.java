package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTabNewActionRequired extends Message {
    public static final Long DEFAULT_ACTIONID = 0L;
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long actionID;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double timestamp;

    public ActTabNewActionRequired(Long l, Double d2) {
        this.actionID = l;
        this.timestamp = d2;
    }

    private ActTabNewActionRequired(Builder builder) {
        this(builder.actionID, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTabNewActionRequired)) {
            return false;
        }
        ActTabNewActionRequired actTabNewActionRequired = (ActTabNewActionRequired) obj;
        if (!equals((Object) this.actionID, (Object) actTabNewActionRequired.actionID) || !equals((Object) this.timestamp, (Object) actTabNewActionRequired.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.actionID;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Double d2 = this.timestamp;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTabNewActionRequired> {
        public Long actionID;
        public Double timestamp;

        public Builder() {
        }

        public Builder(ActTabNewActionRequired actTabNewActionRequired) {
            super(actTabNewActionRequired);
            if (actTabNewActionRequired != null) {
                this.actionID = actTabNewActionRequired.actionID;
                this.timestamp = actTabNewActionRequired.timestamp;
            }
        }

        public Builder actionID(Long l) {
            this.actionID = l;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public ActTabNewActionRequired build() {
            return new ActTabNewActionRequired(this);
        }
    }
}
