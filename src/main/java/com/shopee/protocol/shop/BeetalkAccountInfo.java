package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BeetalkAccountInfo extends Message {
    public static final Integer DEFAULT_BEETALK_USERID = 0;
    public static final Integer DEFAULT_BIRTHDAY = 0;
    public static final Integer DEFAULT_BUDDY_COUNT = 0;
    public static final Integer DEFAULT_BUDDY_SYNC_TIME = 0;
    public static final Integer DEFAULT_GENDER = 0;
    public static final Long DEFAULT_ICON = 0L;
    public static final Integer DEFAULT_INFO_SYNC_TIME = 0;
    public static final String DEFAULT_MOBILE = "";
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_UNIQUEID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer beetalk_userid;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer birthday;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer buddy_count;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer buddy_sync_time;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer gender;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long icon;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer info_sync_time;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String mobile;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String nickname;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String uniqueid;

    public BeetalkAccountInfo(Integer num, String str, String str2, String str3, Long l, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.beetalk_userid = num;
        this.uniqueid = str;
        this.mobile = str2;
        this.nickname = str3;
        this.icon = l;
        this.gender = num2;
        this.birthday = num3;
        this.buddy_count = num4;
        this.info_sync_time = num5;
        this.buddy_sync_time = num6;
    }

    private BeetalkAccountInfo(Builder builder) {
        this(builder.beetalk_userid, builder.uniqueid, builder.mobile, builder.nickname, builder.icon, builder.gender, builder.birthday, builder.buddy_count, builder.info_sync_time, builder.buddy_sync_time);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BeetalkAccountInfo)) {
            return false;
        }
        BeetalkAccountInfo beetalkAccountInfo = (BeetalkAccountInfo) obj;
        if (!equals((Object) this.beetalk_userid, (Object) beetalkAccountInfo.beetalk_userid) || !equals((Object) this.uniqueid, (Object) beetalkAccountInfo.uniqueid) || !equals((Object) this.mobile, (Object) beetalkAccountInfo.mobile) || !equals((Object) this.nickname, (Object) beetalkAccountInfo.nickname) || !equals((Object) this.icon, (Object) beetalkAccountInfo.icon) || !equals((Object) this.gender, (Object) beetalkAccountInfo.gender) || !equals((Object) this.birthday, (Object) beetalkAccountInfo.birthday) || !equals((Object) this.buddy_count, (Object) beetalkAccountInfo.buddy_count) || !equals((Object) this.info_sync_time, (Object) beetalkAccountInfo.info_sync_time) || !equals((Object) this.buddy_sync_time, (Object) beetalkAccountInfo.buddy_sync_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.beetalk_userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.uniqueid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.mobile;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.nickname;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.icon;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.gender;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.birthday;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.buddy_count;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.info_sync_time;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.buddy_sync_time;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BeetalkAccountInfo> {
        public Integer beetalk_userid;
        public Integer birthday;
        public Integer buddy_count;
        public Integer buddy_sync_time;
        public Integer gender;
        public Long icon;
        public Integer info_sync_time;
        public String mobile;
        public String nickname;
        public String uniqueid;

        public Builder() {
        }

        public Builder(BeetalkAccountInfo beetalkAccountInfo) {
            super(beetalkAccountInfo);
            if (beetalkAccountInfo != null) {
                this.beetalk_userid = beetalkAccountInfo.beetalk_userid;
                this.uniqueid = beetalkAccountInfo.uniqueid;
                this.mobile = beetalkAccountInfo.mobile;
                this.nickname = beetalkAccountInfo.nickname;
                this.icon = beetalkAccountInfo.icon;
                this.gender = beetalkAccountInfo.gender;
                this.birthday = beetalkAccountInfo.birthday;
                this.buddy_count = beetalkAccountInfo.buddy_count;
                this.info_sync_time = beetalkAccountInfo.info_sync_time;
                this.buddy_sync_time = beetalkAccountInfo.buddy_sync_time;
            }
        }

        public Builder beetalk_userid(Integer num) {
            this.beetalk_userid = num;
            return this;
        }

        public Builder uniqueid(String str) {
            this.uniqueid = str;
            return this;
        }

        public Builder mobile(String str) {
            this.mobile = str;
            return this;
        }

        public Builder nickname(String str) {
            this.nickname = str;
            return this;
        }

        public Builder icon(Long l) {
            this.icon = l;
            return this;
        }

        public Builder gender(Integer num) {
            this.gender = num;
            return this;
        }

        public Builder birthday(Integer num) {
            this.birthday = num;
            return this;
        }

        public Builder buddy_count(Integer num) {
            this.buddy_count = num;
            return this;
        }

        public Builder info_sync_time(Integer num) {
            this.info_sync_time = num;
            return this;
        }

        public Builder buddy_sync_time(Integer num) {
            this.buddy_sync_time = num;
            return this;
        }

        public BeetalkAccountInfo build() {
            return new BeetalkAccountInfo(this);
        }
    }
}
