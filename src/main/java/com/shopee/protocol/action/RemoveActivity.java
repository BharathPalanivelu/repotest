package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RemoveActivity extends Message {
    public static final Long DEFAULT_ACTION_ID = 0L;
    public static final Integer DEFAULT_ACTIVITY_ID = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long action_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer activity_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public RemoveActivity(String str, String str2, Integer num, Long l, Long l2) {
        this.requestid = str;
        this.token = str2;
        this.activity_id = num;
        this.action_id = l;
        this.groupid = l2;
    }

    private RemoveActivity(Builder builder) {
        this(builder.requestid, builder.token, builder.activity_id, builder.action_id, builder.groupid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemoveActivity)) {
            return false;
        }
        RemoveActivity removeActivity = (RemoveActivity) obj;
        if (!equals((Object) this.requestid, (Object) removeActivity.requestid) || !equals((Object) this.token, (Object) removeActivity.token) || !equals((Object) this.activity_id, (Object) removeActivity.activity_id) || !equals((Object) this.action_id, (Object) removeActivity.action_id) || !equals((Object) this.groupid, (Object) removeActivity.groupid)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.activity_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.action_id;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.groupid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RemoveActivity> {
        public Long action_id;
        public Integer activity_id;
        public Long groupid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(RemoveActivity removeActivity) {
            super(removeActivity);
            if (removeActivity != null) {
                this.requestid = removeActivity.requestid;
                this.token = removeActivity.token;
                this.activity_id = removeActivity.activity_id;
                this.action_id = removeActivity.action_id;
                this.groupid = removeActivity.groupid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder activity_id(Integer num) {
            this.activity_id = num;
            return this;
        }

        public Builder action_id(Long l) {
            this.action_id = l;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public RemoveActivity build() {
            checkRequiredFields();
            return new RemoveActivity(this);
        }
    }
}
