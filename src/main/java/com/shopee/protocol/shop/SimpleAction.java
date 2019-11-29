package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SimpleAction extends Message {
    public static final Long DEFAULT_ACTION_ID = 0L;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Integer DEFAULT_GROUPED_COUNT = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long action_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer createtime;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer grouped_count;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer userid;

    public SimpleAction(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4) {
        this.action_id = l;
        this.createtime = num;
        this.status = num2;
        this.groupid = l2;
        this.grouped_count = num3;
        this.userid = num4;
    }

    private SimpleAction(Builder builder) {
        this(builder.action_id, builder.createtime, builder.status, builder.groupid, builder.grouped_count, builder.userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleAction)) {
            return false;
        }
        SimpleAction simpleAction = (SimpleAction) obj;
        if (!equals((Object) this.action_id, (Object) simpleAction.action_id) || !equals((Object) this.createtime, (Object) simpleAction.createtime) || !equals((Object) this.status, (Object) simpleAction.status) || !equals((Object) this.groupid, (Object) simpleAction.groupid) || !equals((Object) this.grouped_count, (Object) simpleAction.grouped_count) || !equals((Object) this.userid, (Object) simpleAction.userid)) {
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
        Integer num = this.createtime;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.groupid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.grouped_count;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.userid;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SimpleAction> {
        public Long action_id;
        public Integer createtime;
        public Integer grouped_count;
        public Long groupid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(SimpleAction simpleAction) {
            super(simpleAction);
            if (simpleAction != null) {
                this.action_id = simpleAction.action_id;
                this.createtime = simpleAction.createtime;
                this.status = simpleAction.status;
                this.groupid = simpleAction.groupid;
                this.grouped_count = simpleAction.grouped_count;
                this.userid = simpleAction.userid;
            }
        }

        public Builder action_id(Long l) {
            this.action_id = l;
            return this;
        }

        public Builder createtime(Integer num) {
            this.createtime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
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

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public SimpleAction build() {
            return new SimpleAction(this);
        }
    }
}
