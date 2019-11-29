package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActOpenAppViaDeepLink extends Message {
    public static final String DEFAULT_PARAM = "";
    public static final String DEFAULT_SCREENNAME = "";
    public static final Double DEFAULT_TIMESTAMP = Double.valueOf(0.0d);
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String param;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String screenName;
    @ProtoField(tag = 3, type = Message.Datatype.DOUBLE)
    public final Double timestamp;

    public ActOpenAppViaDeepLink(String str, String str2, Double d2) {
        this.param = str;
        this.screenName = str2;
        this.timestamp = d2;
    }

    private ActOpenAppViaDeepLink(Builder builder) {
        this(builder.param, builder.screenName, builder.timestamp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActOpenAppViaDeepLink)) {
            return false;
        }
        ActOpenAppViaDeepLink actOpenAppViaDeepLink = (ActOpenAppViaDeepLink) obj;
        if (!equals((Object) this.param, (Object) actOpenAppViaDeepLink.param) || !equals((Object) this.screenName, (Object) actOpenAppViaDeepLink.screenName) || !equals((Object) this.timestamp, (Object) actOpenAppViaDeepLink.timestamp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.param;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.screenName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Double d2 = this.timestamp;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActOpenAppViaDeepLink> {
        public String param;
        public String screenName;
        public Double timestamp;

        public Builder() {
        }

        public Builder(ActOpenAppViaDeepLink actOpenAppViaDeepLink) {
            super(actOpenAppViaDeepLink);
            if (actOpenAppViaDeepLink != null) {
                this.param = actOpenAppViaDeepLink.param;
                this.screenName = actOpenAppViaDeepLink.screenName;
                this.timestamp = actOpenAppViaDeepLink.timestamp;
            }
        }

        public Builder param(String str) {
            this.param = str;
            return this;
        }

        public Builder screenName(String str) {
            this.screenName = str;
            return this;
        }

        public Builder timestamp(Double d2) {
            this.timestamp = d2;
            return this;
        }

        public ActOpenAppViaDeepLink build() {
            return new ActOpenAppViaDeepLink(this);
        }
    }
}
