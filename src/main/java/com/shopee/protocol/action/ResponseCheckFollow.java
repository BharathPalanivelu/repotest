package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseCheckFollow extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<ShopFollowed> DEFAULT_FOLLOWED = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = ShopFollowed.class, tag = 3)
    public final List<ShopFollowed> followed;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseCheckFollow(String str, Integer num, List<ShopFollowed> list) {
        this.requestid = str;
        this.errcode = num;
        this.followed = immutableCopyOf(list);
    }

    private ResponseCheckFollow(Builder builder) {
        this(builder.requestid, builder.errcode, builder.followed);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseCheckFollow)) {
            return false;
        }
        ResponseCheckFollow responseCheckFollow = (ResponseCheckFollow) obj;
        if (!equals((Object) this.requestid, (Object) responseCheckFollow.requestid) || !equals((Object) this.errcode, (Object) responseCheckFollow.errcode) || !equals((List<?>) this.followed, (List<?>) responseCheckFollow.followed)) {
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
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ShopFollowed> list = this.followed;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<ResponseCheckFollow> {
        public Integer errcode;
        public List<ShopFollowed> followed;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseCheckFollow responseCheckFollow) {
            super(responseCheckFollow);
            if (responseCheckFollow != null) {
                this.requestid = responseCheckFollow.requestid;
                this.errcode = responseCheckFollow.errcode;
                this.followed = ResponseCheckFollow.copyOf(responseCheckFollow.followed);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public Builder followed(List<ShopFollowed> list) {
            this.followed = checkForNulls(list);
            return this;
        }

        public ResponseCheckFollow build() {
            return new ResponseCheckFollow(this);
        }
    }

    public static final class ShopFollowed extends Message {
        public static final Boolean DEFAULT_FOLLOWED = false;
        public static final Integer DEFAULT_LATEST_UNFOLLOW_TIME = 0;
        public static final Integer DEFAULT_SHOPID = 0;
        private static final long serialVersionUID = 0;
        @ProtoField(tag = 2, type = Message.Datatype.BOOL)
        public final Boolean followed;
        @ProtoField(tag = 3, type = Message.Datatype.INT32)
        public final Integer latest_unfollow_time;
        @ProtoField(tag = 1, type = Message.Datatype.INT32)
        public final Integer shopid;

        public ShopFollowed(Integer num, Boolean bool, Integer num2) {
            this.shopid = num;
            this.followed = bool;
            this.latest_unfollow_time = num2;
        }

        private ShopFollowed(Builder builder) {
            this(builder.shopid, builder.followed, builder.latest_unfollow_time);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShopFollowed)) {
                return false;
            }
            ShopFollowed shopFollowed = (ShopFollowed) obj;
            if (!equals((Object) this.shopid, (Object) shopFollowed.shopid) || !equals((Object) this.followed, (Object) shopFollowed.followed) || !equals((Object) this.latest_unfollow_time, (Object) shopFollowed.latest_unfollow_time)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            Integer num = this.shopid;
            int i2 = 0;
            int hashCode = (num != null ? num.hashCode() : 0) * 37;
            Boolean bool = this.followed;
            int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
            Integer num2 = this.latest_unfollow_time;
            if (num2 != null) {
                i2 = num2.hashCode();
            }
            int i3 = hashCode2 + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<ShopFollowed> {
            public Boolean followed;
            public Integer latest_unfollow_time;
            public Integer shopid;

            public Builder() {
            }

            public Builder(ShopFollowed shopFollowed) {
                super(shopFollowed);
                if (shopFollowed != null) {
                    this.shopid = shopFollowed.shopid;
                    this.followed = shopFollowed.followed;
                    this.latest_unfollow_time = shopFollowed.latest_unfollow_time;
                }
            }

            public Builder shopid(Integer num) {
                this.shopid = num;
                return this;
            }

            public Builder followed(Boolean bool) {
                this.followed = bool;
                return this;
            }

            public Builder latest_unfollow_time(Integer num) {
                this.latest_unfollow_time = num;
                return this;
            }

            public ShopFollowed build() {
                return new ShopFollowed(this);
            }
        }
    }
}
