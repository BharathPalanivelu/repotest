package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActivityInfo extends Message {
    public static final Integer DEFAULT_ACCTYPE = 0;
    public static final Long DEFAULT_COMMENTID = 0L;
    public static final String DEFAULT_COMMENT_CONTENT = "";
    public static final String DEFAULT_CONTACT_NAME = "";
    public static final Long DEFAULT_FEEDID = 0L;
    public static final Integer DEFAULT_FROM_SHOPID = 0;
    public static final Integer DEFAULT_FROM_USERID = 0;
    public static final String DEFAULT_FROM_USER_AVATAR = "";
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_UPDATE_TYPE = 0;
    public static final String DEFAULT_USER_NAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer acctype;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String comment_content;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long commentid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String contact_name;
    @ProtoField(tag = 10)
    public final CustomizeActivityMeta customized_meta;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long feedid;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer from_shopid;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String from_user_avatar;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer from_userid;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer update_type;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String user_name;

    public ActivityInfo(Integer num, Integer num2, Long l, Long l2, Integer num3, String str, String str2, Integer num4, String str3, CustomizeActivityMeta customizeActivityMeta, Long l3, Integer num5, String str4) {
        this.from_userid = num;
        this.shopid = num2;
        this.itemid = l;
        this.commentid = l2;
        this.update_type = num3;
        this.comment_content = str;
        this.contact_name = str2;
        this.acctype = num4;
        this.user_name = str3;
        this.customized_meta = customizeActivityMeta;
        this.feedid = l3;
        this.from_shopid = num5;
        this.from_user_avatar = str4;
    }

    private ActivityInfo(Builder builder) {
        this(builder.from_userid, builder.shopid, builder.itemid, builder.commentid, builder.update_type, builder.comment_content, builder.contact_name, builder.acctype, builder.user_name, builder.customized_meta, builder.feedid, builder.from_shopid, builder.from_user_avatar);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityInfo)) {
            return false;
        }
        ActivityInfo activityInfo = (ActivityInfo) obj;
        if (!equals((Object) this.from_userid, (Object) activityInfo.from_userid) || !equals((Object) this.shopid, (Object) activityInfo.shopid) || !equals((Object) this.itemid, (Object) activityInfo.itemid) || !equals((Object) this.commentid, (Object) activityInfo.commentid) || !equals((Object) this.update_type, (Object) activityInfo.update_type) || !equals((Object) this.comment_content, (Object) activityInfo.comment_content) || !equals((Object) this.contact_name, (Object) activityInfo.contact_name) || !equals((Object) this.acctype, (Object) activityInfo.acctype) || !equals((Object) this.user_name, (Object) activityInfo.user_name) || !equals((Object) this.customized_meta, (Object) activityInfo.customized_meta) || !equals((Object) this.feedid, (Object) activityInfo.feedid) || !equals((Object) this.from_shopid, (Object) activityInfo.from_shopid) || !equals((Object) this.from_user_avatar, (Object) activityInfo.from_user_avatar)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.from_userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.commentid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.update_type;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.comment_content;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.contact_name;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.acctype;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.user_name;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        CustomizeActivityMeta customizeActivityMeta = this.customized_meta;
        int hashCode10 = (hashCode9 + (customizeActivityMeta != null ? customizeActivityMeta.hashCode() : 0)) * 37;
        Long l3 = this.feedid;
        int hashCode11 = (hashCode10 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num5 = this.from_shopid;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str4 = this.from_user_avatar;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActivityInfo> {
        public Integer acctype;
        public String comment_content;
        public Long commentid;
        public String contact_name;
        public CustomizeActivityMeta customized_meta;
        public Long feedid;
        public Integer from_shopid;
        public String from_user_avatar;
        public Integer from_userid;
        public Long itemid;
        public Integer shopid;
        public Integer update_type;
        public String user_name;

        public Builder() {
        }

        public Builder(ActivityInfo activityInfo) {
            super(activityInfo);
            if (activityInfo != null) {
                this.from_userid = activityInfo.from_userid;
                this.shopid = activityInfo.shopid;
                this.itemid = activityInfo.itemid;
                this.commentid = activityInfo.commentid;
                this.update_type = activityInfo.update_type;
                this.comment_content = activityInfo.comment_content;
                this.contact_name = activityInfo.contact_name;
                this.acctype = activityInfo.acctype;
                this.user_name = activityInfo.user_name;
                this.customized_meta = activityInfo.customized_meta;
                this.feedid = activityInfo.feedid;
                this.from_shopid = activityInfo.from_shopid;
                this.from_user_avatar = activityInfo.from_user_avatar;
            }
        }

        public Builder from_userid(Integer num) {
            this.from_userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder commentid(Long l) {
            this.commentid = l;
            return this;
        }

        public Builder update_type(Integer num) {
            this.update_type = num;
            return this;
        }

        public Builder comment_content(String str) {
            this.comment_content = str;
            return this;
        }

        public Builder contact_name(String str) {
            this.contact_name = str;
            return this;
        }

        public Builder acctype(Integer num) {
            this.acctype = num;
            return this;
        }

        public Builder user_name(String str) {
            this.user_name = str;
            return this;
        }

        public Builder customized_meta(CustomizeActivityMeta customizeActivityMeta) {
            this.customized_meta = customizeActivityMeta;
            return this;
        }

        public Builder feedid(Long l) {
            this.feedid = l;
            return this;
        }

        public Builder from_shopid(Integer num) {
            this.from_shopid = num;
            return this;
        }

        public Builder from_user_avatar(String str) {
            this.from_user_avatar = str;
            return this;
        }

        public ActivityInfo build() {
            return new ActivityInfo(this);
        }
    }
}
