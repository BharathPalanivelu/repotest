package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTabPushNoti extends Message {
    public static final Long DEFAULT_TASKID = 0L;
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long taskID;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double timestamp;

    public ActTabPushNoti(Long l, Double d2) {
        this.taskID = l;
        this.timestamp = d2;
    }

    private ActTabPushNoti(Builder builder) {
        this(builder.taskID, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTabPushNoti)) {
            return false;
        }
        ActTabPushNoti actTabPushNoti = (ActTabPushNoti) obj;
        if (!equals((Object) this.taskID, (Object) actTabPushNoti.taskID) || !equals((Object) this.timestamp, (Object) actTabPushNoti.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.taskID;
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

    public static final class Builder extends Message.Builder<ActTabPushNoti> {
        public Long taskID;
        public Double timestamp;

        public Builder() {
        }

        public Builder(ActTabPushNoti actTabPushNoti) {
            super(actTabPushNoti);
            if (actTabPushNoti != null) {
                this.taskID = actTabPushNoti.taskID;
                this.timestamp = actTabPushNoti.timestamp;
            }
        }

        public Builder taskID(Long l) {
            this.taskID = l;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public ActTabPushNoti build() {
            return new ActTabPushNoti(this);
        }
    }
}
