package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActBackEvent extends Message {
    public static final String DEFAULT_SOURCEURL = "";
    public static final String DEFAULT_TARGETURL = "";
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sourceURL;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String targetURL;
    @ProtoField(tag = 1, type = Message.Datatype.DOUBLE)
    public final Double timestamp;

    public ActBackEvent(Double d2, String str, String str2) {
        this.timestamp = d2;
        this.sourceURL = str;
        this.targetURL = str2;
    }

    private ActBackEvent(Builder builder) {
        this(builder.timestamp, builder.sourceURL, builder.targetURL);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActBackEvent)) {
            return false;
        }
        ActBackEvent actBackEvent = (ActBackEvent) obj;
        if (!equals((Object) this.timestamp, (Object) actBackEvent.timestamp) || !equals((Object) this.sourceURL, (Object) actBackEvent.sourceURL) || !equals((Object) this.targetURL, (Object) actBackEvent.targetURL)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d2 = this.timestamp;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 37;
        String str = this.sourceURL;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.targetURL;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActBackEvent> {
        public String sourceURL;
        public String targetURL;
        public Double timestamp;

        public Builder() {
        }

        public Builder(ActBackEvent actBackEvent) {
            super(actBackEvent);
            if (actBackEvent != null) {
                this.timestamp = actBackEvent.timestamp;
                this.sourceURL = actBackEvent.sourceURL;
                this.targetURL = actBackEvent.targetURL;
            }
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public Builder sourceURL(String str) {
            this.sourceURL = str;
            return this;
        }

        public Builder targetURL(String str) {
            this.targetURL = str;
            return this;
        }

        public ActBackEvent build() {
            return new ActBackEvent(this);
        }
    }
}
