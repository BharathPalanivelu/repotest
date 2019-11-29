package com.shopee.protocol.clickmodel;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActPageView extends Message {
    public static final Integer DEFAULT_NO_DATA = 0;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer no_data;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String url;

    public ActPageView(String str, Integer num) {
        this.url = str;
        this.no_data = num;
    }

    private ActPageView(Builder builder) {
        this(builder.url, builder.no_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActPageView)) {
            return false;
        }
        ActPageView actPageView = (ActPageView) obj;
        if (!equals((Object) this.url, (Object) actPageView.url) || !equals((Object) this.no_data, (Object) actPageView.no_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.no_data;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActPageView> {
        public Integer no_data;
        public String url;

        public Builder() {
        }

        public Builder(ActPageView actPageView) {
            super(actPageView);
            if (actPageView != null) {
                this.url = actPageView.url;
                this.no_data = actPageView.no_data;
            }
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder no_data(Integer num) {
            this.no_data = num;
            return this;
        }

        public ActPageView build() {
            return new ActPageView(this);
        }
    }
}
