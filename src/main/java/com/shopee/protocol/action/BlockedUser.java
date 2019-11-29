package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BlockedUser extends Message {
    public static final Boolean DEFAULT_BLOCKED = false;
    public static final Boolean DEFAULT_BLOCKED_ADS = false;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.BOOL)
    public final Boolean blocked;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean blocked_ads;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public BlockedUser(Integer num, Boolean bool, Boolean bool2) {
        this.userid = num;
        this.blocked = bool;
        this.blocked_ads = bool2;
    }

    private BlockedUser(Builder builder) {
        this(builder.userid, builder.blocked, builder.blocked_ads);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockedUser)) {
            return false;
        }
        BlockedUser blockedUser = (BlockedUser) obj;
        if (!equals((Object) this.userid, (Object) blockedUser.userid) || !equals((Object) this.blocked, (Object) blockedUser.blocked) || !equals((Object) this.blocked_ads, (Object) blockedUser.blocked_ads)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Boolean bool = this.blocked;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.blocked_ads;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BlockedUser> {
        public Boolean blocked;
        public Boolean blocked_ads;
        public Integer userid;

        public Builder() {
        }

        public Builder(BlockedUser blockedUser) {
            super(blockedUser);
            if (blockedUser != null) {
                this.userid = blockedUser.userid;
                this.blocked = blockedUser.blocked;
                this.blocked_ads = blockedUser.blocked_ads;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder blocked(Boolean bool) {
            this.blocked = bool;
            return this;
        }

        public Builder blocked_ads(Boolean bool) {
            this.blocked_ads = bool;
            return this;
        }

        public BlockedUser build() {
            return new BlockedUser(this);
        }
    }
}
