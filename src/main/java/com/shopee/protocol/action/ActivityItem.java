package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActivityItem extends Message {
    public static final Integer DEFAULT_ACTIVITY_ID = 0;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer activity_id;
    @ProtoField(tag = 4)
    public final ActivityInfo activity_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer createtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public ActivityItem(Integer num, Integer num2, Integer num3, ActivityInfo activityInfo) {
        this.activity_id = num;
        this.type = num2;
        this.createtime = num3;
        this.activity_info = activityInfo;
    }

    private ActivityItem(Builder builder) {
        this(builder.activity_id, builder.type, builder.createtime, builder.activity_info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActivityItem)) {
            return false;
        }
        ActivityItem activityItem = (ActivityItem) obj;
        if (!equals((Object) this.activity_id, (Object) activityItem.activity_id) || !equals((Object) this.type, (Object) activityItem.type) || !equals((Object) this.createtime, (Object) activityItem.createtime) || !equals((Object) this.activity_info, (Object) activityItem.activity_info)) {
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
        Integer num2 = this.type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.createtime;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        ActivityInfo activityInfo = this.activity_info;
        if (activityInfo != null) {
            i2 = activityInfo.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActivityItem> {
        public Integer activity_id;
        public ActivityInfo activity_info;
        public Integer createtime;
        public Integer type;

        public Builder() {
        }

        public Builder(ActivityItem activityItem) {
            super(activityItem);
            if (activityItem != null) {
                this.activity_id = activityItem.activity_id;
                this.type = activityItem.type;
                this.createtime = activityItem.createtime;
                this.activity_info = activityItem.activity_info;
            }
        }

        public Builder activity_id(Integer num) {
            this.activity_id = num;
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

        public Builder activity_info(ActivityInfo activityInfo) {
            this.activity_info = activityInfo;
            return this;
        }

        public ActivityItem build() {
            return new ActivityItem(this);
        }
    }
}
