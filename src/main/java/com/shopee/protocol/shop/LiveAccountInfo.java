package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class LiveAccountInfo extends Message {
    public static final Boolean DEFAULT_IS_BANNED = false;
    public static final Boolean DEFAULT_IS_HOST = false;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean is_banned;
    @ProtoField(tag = 1, type = Message.Datatype.BOOL)
    public final Boolean is_host;

    public LiveAccountInfo(Boolean bool, Boolean bool2) {
        this.is_host = bool;
        this.is_banned = bool2;
    }

    private LiveAccountInfo(Builder builder) {
        this(builder.is_host, builder.is_banned);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiveAccountInfo)) {
            return false;
        }
        LiveAccountInfo liveAccountInfo = (LiveAccountInfo) obj;
        if (!equals((Object) this.is_host, (Object) liveAccountInfo.is_host) || !equals((Object) this.is_banned, (Object) liveAccountInfo.is_banned)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Boolean bool = this.is_host;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 37;
        Boolean bool2 = this.is_banned;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<LiveAccountInfo> {
        public Boolean is_banned;
        public Boolean is_host;

        public Builder() {
        }

        public Builder(LiveAccountInfo liveAccountInfo) {
            super(liveAccountInfo);
            if (liveAccountInfo != null) {
                this.is_host = liveAccountInfo.is_host;
                this.is_banned = liveAccountInfo.is_banned;
            }
        }

        public Builder is_host(Boolean bool) {
            this.is_host = bool;
            return this;
        }

        public Builder is_banned(Boolean bool) {
            this.is_banned = bool;
            return this;
        }

        public LiveAccountInfo build() {
            return new LiveAccountInfo(this);
        }
    }
}
