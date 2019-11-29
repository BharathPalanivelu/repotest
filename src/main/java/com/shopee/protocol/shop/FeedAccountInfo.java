package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FeedAccountInfo extends Message {
    public static final Boolean DEFAULT_CAN_POST_FEED = false;
    public static final Boolean DEFAULT_IS_KOL = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean can_post_feed;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean is_kol;

    public FeedAccountInfo(Boolean bool, Boolean bool2) {
        this.is_kol = bool;
        this.can_post_feed = bool2;
    }

    private FeedAccountInfo(Builder builder) {
        this(builder.is_kol, builder.can_post_feed);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedAccountInfo)) {
            return false;
        }
        FeedAccountInfo feedAccountInfo = (FeedAccountInfo) obj;
        if (!equals((Object) this.is_kol, (Object) feedAccountInfo.is_kol) || !equals((Object) this.can_post_feed, (Object) feedAccountInfo.can_post_feed)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.is_kol;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Boolean bool2 = this.can_post_feed;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FeedAccountInfo> {
        public Boolean can_post_feed;
        public Boolean is_kol;

        public Builder() {
        }

        public Builder(FeedAccountInfo feedAccountInfo) {
            super(feedAccountInfo);
            if (feedAccountInfo != null) {
                this.is_kol = feedAccountInfo.is_kol;
                this.can_post_feed = feedAccountInfo.can_post_feed;
            }
        }

        public Builder is_kol(Boolean bool) {
            this.is_kol = bool;
            return this;
        }

        public Builder can_post_feed(Boolean bool) {
            this.can_post_feed = bool;
            return this;
        }

        public FeedAccountInfo build() {
            return new FeedAccountInfo(this);
        }
    }
}
