package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BlockUser extends Message {
    public static final Boolean DEFAULT_BLOCK = false;
    public static final Boolean DEFAULT_BLOCK_ADS = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean block;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean block_ads;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public BlockUser(String str, Integer num, Boolean bool, String str2, Boolean bool2) {
        this.requestid = str;
        this.userid = num;
        this.block = bool;
        this.token = str2;
        this.block_ads = bool2;
    }

    private BlockUser(Builder builder) {
        this(builder.requestid, builder.userid, builder.block, builder.token, builder.block_ads);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BlockUser)) {
            return false;
        }
        BlockUser blockUser = (BlockUser) obj;
        if (!equals((Object) this.requestid, (Object) blockUser.requestid) || !equals((Object) this.userid, (Object) blockUser.userid) || !equals((Object) this.block, (Object) blockUser.block) || !equals((Object) this.token, (Object) blockUser.token) || !equals((Object) this.block_ads, (Object) blockUser.block_ads)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.block;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool2 = this.block_ads;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BlockUser> {
        public Boolean block;
        public Boolean block_ads;
        public String requestid;
        public String token;
        public Integer userid;

        public Builder() {
        }

        public Builder(BlockUser blockUser) {
            super(blockUser);
            if (blockUser != null) {
                this.requestid = blockUser.requestid;
                this.userid = blockUser.userid;
                this.block = blockUser.block;
                this.token = blockUser.token;
                this.block_ads = blockUser.block_ads;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder block(Boolean bool) {
            this.block = bool;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder block_ads(Boolean bool) {
            this.block_ads = bool;
            return this;
        }

        public BlockUser build() {
            return new BlockUser(this);
        }
    }
}
