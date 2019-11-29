package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Activity extends Message {
    public static final Integer DEFAULT_ACTIVITY_ID = 0;
    public static final String DEFAULT_ACTIVITY_PROTO = "";
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer activity_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String activity_proto;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer createtime;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Activity(Integer num, Integer num2, Integer num3, Integer num4, String str, Integer num5) {
        this.activity_id = num;
        this.userid = num2;
        this.type = num3;
        this.createtime = num4;
        this.activity_proto = str;
        this.status = num5;
    }

    private Activity(Builder builder) {
        this(builder.activity_id, builder.userid, builder.type, builder.createtime, builder.activity_proto, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) obj;
        if (!equals((Object) this.activity_id, (Object) activity.activity_id) || !equals((Object) this.userid, (Object) activity.userid) || !equals((Object) this.type, (Object) activity.type) || !equals((Object) this.createtime, (Object) activity.createtime) || !equals((Object) this.activity_proto, (Object) activity.activity_proto) || !equals((Object) this.status, (Object) activity.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.activity_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.createtime;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str = this.activity_proto;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Activity> {
        public Integer activity_id;
        public String activity_proto;
        public Integer createtime;
        public Integer status;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(Activity activity) {
            super(activity);
            if (activity != null) {
                this.activity_id = activity.activity_id;
                this.userid = activity.userid;
                this.type = activity.type;
                this.createtime = activity.createtime;
                this.activity_proto = activity.activity_proto;
                this.status = activity.status;
            }
        }

        public Builder activity_id(Integer num) {
            this.activity_id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder createtime(Integer num) {
            this.createtime = num;
            return this;
        }

        public Builder activity_proto(String str) {
            this.activity_proto = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Activity build() {
            return new Activity(this);
        }
    }
}
