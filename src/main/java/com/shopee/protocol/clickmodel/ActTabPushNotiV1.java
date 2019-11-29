package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActTabPushNotiV1 extends Message {
    public static final String DEFAULT_TASKID = "";
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String taskID;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double timestamp;

    public ActTabPushNotiV1(String str, Double d2) {
        this.taskID = str;
        this.timestamp = d2;
    }

    private ActTabPushNotiV1(Builder builder) {
        this(builder.taskID, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActTabPushNotiV1)) {
            return false;
        }
        ActTabPushNotiV1 actTabPushNotiV1 = (ActTabPushNotiV1) obj;
        if (!equals((Object) this.taskID, (Object) actTabPushNotiV1.taskID) || !equals((Object) this.timestamp, (Object) actTabPushNotiV1.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.taskID;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Double d2 = this.timestamp;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActTabPushNotiV1> {
        public String taskID;
        public Double timestamp;

        public Builder() {
        }

        public Builder(ActTabPushNotiV1 actTabPushNotiV1) {
            super(actTabPushNotiV1);
            if (actTabPushNotiV1 != null) {
                this.taskID = actTabPushNotiV1.taskID;
                this.timestamp = actTabPushNotiV1.timestamp;
            }
        }

        public Builder taskID(String str) {
            this.taskID = str;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public ActTabPushNotiV1 build() {
            return new ActTabPushNotiV1(this);
        }
    }
}
