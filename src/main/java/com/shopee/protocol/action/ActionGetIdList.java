package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ActionGetIdList extends Message {
    public static final Integer DEFAULT_ACTION_CATE = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_LAST_ACTION_ID = 0L;
    public static final Boolean DEFAULT_NEED_GROUPED = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_REQUEST_NUMBER = 0;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer action_cate;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long groupid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long last_action_id;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean need_grouped;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer request_number;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public ActionGetIdList(String str, Long l, Integer num, Integer num2, String str2, Boolean bool, Long l2) {
        this.requestid = str;
        this.last_action_id = l;
        this.request_number = num;
        this.action_cate = num2;
        this.token = str2;
        this.need_grouped = bool;
        this.groupid = l2;
    }

    private ActionGetIdList(Builder builder) {
        this(builder.requestid, builder.last_action_id, builder.request_number, builder.action_cate, builder.token, builder.need_grouped, builder.groupid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ActionGetIdList)) {
            return false;
        }
        ActionGetIdList actionGetIdList = (ActionGetIdList) obj;
        if (!equals((Object) this.requestid, (Object) actionGetIdList.requestid) || !equals((Object) this.last_action_id, (Object) actionGetIdList.last_action_id) || !equals((Object) this.request_number, (Object) actionGetIdList.request_number) || !equals((Object) this.action_cate, (Object) actionGetIdList.action_cate) || !equals((Object) this.token, (Object) actionGetIdList.token) || !equals((Object) this.need_grouped, (Object) actionGetIdList.need_grouped) || !equals((Object) this.groupid, (Object) actionGetIdList.groupid)) {
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
        Long l = this.last_action_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.request_number;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.action_cate;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.need_grouped;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l2 = this.groupid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ActionGetIdList> {
        public Integer action_cate;
        public Long groupid;
        public Long last_action_id;
        public Boolean need_grouped;
        public Integer request_number;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(ActionGetIdList actionGetIdList) {
            super(actionGetIdList);
            if (actionGetIdList != null) {
                this.requestid = actionGetIdList.requestid;
                this.last_action_id = actionGetIdList.last_action_id;
                this.request_number = actionGetIdList.request_number;
                this.action_cate = actionGetIdList.action_cate;
                this.token = actionGetIdList.token;
                this.need_grouped = actionGetIdList.need_grouped;
                this.groupid = actionGetIdList.groupid;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder last_action_id(Long l) {
            this.last_action_id = l;
            return this;
        }

        public Builder request_number(Integer num) {
            this.request_number = num;
            return this;
        }

        public Builder action_cate(Integer num) {
            this.action_cate = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder need_grouped(Boolean bool) {
            this.need_grouped = bool;
            return this;
        }

        public Builder groupid(Long l) {
            this.groupid = l;
            return this;
        }

        public ActionGetIdList build() {
            return new ActionGetIdList(this);
        }
    }
}
