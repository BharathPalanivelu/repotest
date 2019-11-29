package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TrackingCartItem extends Message {
    public static final List<String> DEFAULT_REFER_URLS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.STRING)
    public final List<String> refer_urls;

    public TrackingCartItem(List<String> list) {
        this.refer_urls = immutableCopyOf(list);
    }

    private TrackingCartItem(Builder builder) {
        this(builder.refer_urls);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TrackingCartItem)) {
            return false;
        }
        return equals((List<?>) this.refer_urls, (List<?>) ((TrackingCartItem) obj).refer_urls);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<String> list = this.refer_urls;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TrackingCartItem> {
        public List<String> refer_urls;

        public Builder() {
        }

        public Builder(TrackingCartItem trackingCartItem) {
            super(trackingCartItem);
            if (trackingCartItem != null) {
                this.refer_urls = TrackingCartItem.copyOf(trackingCartItem.refer_urls);
            }
        }

        public Builder refer_urls(List<String> list) {
            this.refer_urls = checkForNulls(list);
            return this;
        }

        public TrackingCartItem build() {
            return new TrackingCartItem(this);
        }
    }
}
