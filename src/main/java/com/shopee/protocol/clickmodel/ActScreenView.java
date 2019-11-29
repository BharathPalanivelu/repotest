package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActScreenView extends Message {
    public static final String DEFAULT_SCREENNAME = "";
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String screenName;
    @ProtoField(tag = 2, type = Message.Datatype.DOUBLE)
    public final Double timestamp;

    public ActScreenView(String str, Double d2) {
        this.screenName = str;
        this.timestamp = d2;
    }

    private ActScreenView(Builder builder) {
        this(builder.screenName, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActScreenView)) {
            return false;
        }
        ActScreenView actScreenView = (ActScreenView) obj;
        if (!equals((Object) this.screenName, (Object) actScreenView.screenName) || !equals((Object) this.timestamp, (Object) actScreenView.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.screenName;
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

    public static final class Builder extends Message.Builder<ActScreenView> {
        public String screenName;
        public Double timestamp;

        public Builder() {
        }

        public Builder(ActScreenView actScreenView) {
            super(actScreenView);
            if (actScreenView != null) {
                this.screenName = actScreenView.screenName;
                this.timestamp = actScreenView.timestamp;
            }
        }

        public Builder screenName(String str) {
            this.screenName = str;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public ActScreenView build() {
            return new ActScreenView(this);
        }
    }
}
