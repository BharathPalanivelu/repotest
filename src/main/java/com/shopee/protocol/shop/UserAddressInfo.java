package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UserAddressInfo extends Message {
    public static final Boolean DEFAULT_IN_WHITE_LIST = false;
    public static final Integer DEFAULT_MCOUNT = 0;
    public static final Integer DEFAULT_MCOUNT_CTIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean in_white_list;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer mcount;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer mcount_ctime;

    public UserAddressInfo(Integer num, Integer num2, Boolean bool) {
        this.mcount = num;
        this.mcount_ctime = num2;
        this.in_white_list = bool;
    }

    private UserAddressInfo(Builder builder) {
        this(builder.mcount, builder.mcount_ctime, builder.in_white_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAddressInfo)) {
            return false;
        }
        UserAddressInfo userAddressInfo = (UserAddressInfo) obj;
        if (!equals((Object) this.mcount, (Object) userAddressInfo.mcount) || !equals((Object) this.mcount_ctime, (Object) userAddressInfo.mcount_ctime) || !equals((Object) this.in_white_list, (Object) userAddressInfo.in_white_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.mcount;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.mcount_ctime;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.in_white_list;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserAddressInfo> {
        public Boolean in_white_list;
        public Integer mcount;
        public Integer mcount_ctime;

        public Builder() {
        }

        public Builder(UserAddressInfo userAddressInfo) {
            super(userAddressInfo);
            if (userAddressInfo != null) {
                this.mcount = userAddressInfo.mcount;
                this.mcount_ctime = userAddressInfo.mcount_ctime;
                this.in_white_list = userAddressInfo.in_white_list;
            }
        }

        public Builder mcount(Integer num) {
            this.mcount = num;
            return this;
        }

        public Builder mcount_ctime(Integer num) {
            this.mcount_ctime = num;
            return this;
        }

        public Builder in_white_list(Boolean bool) {
            this.in_white_list = bool;
            return this;
        }

        public UserAddressInfo build() {
            return new UserAddressInfo(this);
        }
    }
}
