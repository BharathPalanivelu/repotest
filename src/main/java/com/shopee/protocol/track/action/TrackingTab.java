package com.shopee.protocol.track.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TrackingTab extends Message {
    public static final Integer DEFAULT_TAB_ID = 0;
    public static final Integer DEFAULT_TAB_LOCATION = 0;
    public static final String DEFAULT_TAB_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer tab_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer tab_location;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String tab_name;

    public TrackingTab(String str, Integer num, Integer num2) {
        this.tab_name = str;
        this.tab_id = num;
        this.tab_location = num2;
    }

    private TrackingTab(Builder builder) {
        this(builder.tab_name, builder.tab_id, builder.tab_location);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingTab)) {
            return false;
        }
        TrackingTab trackingTab = (TrackingTab) obj;
        if (!equals((Object) this.tab_name, (Object) trackingTab.tab_name) || !equals((Object) this.tab_id, (Object) trackingTab.tab_id) || !equals((Object) this.tab_location, (Object) trackingTab.tab_location)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.tab_name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.tab_id;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.tab_location;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TrackingTab> {
        public Integer tab_id;
        public Integer tab_location;
        public String tab_name;

        public Builder() {
        }

        public Builder(TrackingTab trackingTab) {
            super(trackingTab);
            if (trackingTab != null) {
                this.tab_name = trackingTab.tab_name;
                this.tab_id = trackingTab.tab_id;
                this.tab_location = trackingTab.tab_location;
            }
        }

        public Builder tab_name(String str) {
            this.tab_name = str;
            return this;
        }

        public Builder tab_id(Integer num) {
            this.tab_id = num;
            return this;
        }

        public Builder tab_location(Integer num) {
            this.tab_location = num;
            return this;
        }

        public TrackingTab build() {
            return new TrackingTab(this);
        }
    }
}
