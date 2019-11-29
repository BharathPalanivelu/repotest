package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Action extends Message {
    public static final Integer DEFAULT_ACTION_CATE = 0;
    public static final Long DEFAULT_ACTION_ID = 0L;
    public static final String DEFAULT_ACTION_PROTO = "";
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_GROUPED_COUNT = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer action_cate;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long action_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String action_proto;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer createtime;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer grouped_count;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public Action(Long l, Integer num, Integer num2, Integer num3, String str, Integer num4, Integer num5, Long l2, Integer num6) {
        this.action_id = l;
        this.userid = num;
        this.type = num2;
        this.createtime = num3;
        this.action_proto = str;
        this.status = num4;
        this.action_cate = num5;
        this.groupid = l2;
        this.grouped_count = num6;
    }

    private Action(Builder builder) {
        this(builder.action_id, builder.userid, builder.type, builder.createtime, builder.action_proto, builder.status, builder.action_cate, builder.groupid, builder.grouped_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Action)) {
            return false;
        }
        Action action = (Action) obj;
        if (!equals((Object) this.action_id, (Object) action.action_id) || !equals((Object) this.userid, (Object) action.userid) || !equals((Object) this.type, (Object) action.type) || !equals((Object) this.createtime, (Object) action.createtime) || !equals((Object) this.action_proto, (Object) action.action_proto) || !equals((Object) this.status, (Object) action.status) || !equals((Object) this.action_cate, (Object) action.action_cate) || !equals((Object) this.groupid, (Object) action.groupid) || !equals((Object) this.grouped_count, (Object) action.grouped_count)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.action_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.createtime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.action_proto;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.action_cate;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l2 = this.groupid;
        int hashCode8 = (hashCode7 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num6 = this.grouped_count;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Action> {
        public Integer action_cate;
        public Long action_id;
        public String action_proto;
        public Integer createtime;
        public Integer grouped_count;
        public Long groupid;
        public Integer status;
        public Integer type;
        public Integer userid;

        public Builder() {
        }

        public Builder(Action action) {
            super(action);
            if (action != null) {
                this.action_id = action.action_id;
                this.userid = action.userid;
                this.type = action.type;
                this.createtime = action.createtime;
                this.action_proto = action.action_proto;
                this.status = action.status;
                this.action_cate = action.action_cate;
                this.groupid = action.groupid;
                this.grouped_count = action.grouped_count;
            }
        }

        public Builder action_id(Long l) {
            this.action_id = l;
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

        public Builder action_proto(String str) {
            this.action_proto = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder action_cate(Integer num) {
            this.action_cate = num;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public Builder grouped_count(Integer num) {
            this.grouped_count = num;
            return this;
        }

        public Action build() {
            return new Action(this);
        }
    }
}
