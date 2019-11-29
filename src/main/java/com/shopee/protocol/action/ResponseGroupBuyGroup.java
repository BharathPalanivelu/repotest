package com.shopee.protocol.action;

import com.shopee.protocol.shop.GroupBuyGroup;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGroupBuyGroup extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<GroupBuyGroup> DEFAULT_GROUPS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TOTAL_GROUPS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = GroupBuyGroup.class, tag = 3)
    public final List<GroupBuyGroup> groups;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total_groups;

    public ResponseGroupBuyGroup(String str, Integer num, List<GroupBuyGroup> list, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.groups = immutableCopyOf(list);
        this.total_groups = num2;
    }

    private ResponseGroupBuyGroup(Builder builder) {
        this(builder.requestid, builder.errcode, builder.groups, builder.total_groups);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGroupBuyGroup)) {
            return false;
        }
        ResponseGroupBuyGroup responseGroupBuyGroup = (ResponseGroupBuyGroup) obj;
        if (!equals((Object) this.requestid, (Object) responseGroupBuyGroup.requestid) || !equals((Object) this.errcode, (Object) responseGroupBuyGroup.errcode) || !equals((List<?>) this.groups, (List<?>) responseGroupBuyGroup.groups) || !equals((Object) this.total_groups, (Object) responseGroupBuyGroup.total_groups)) {
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
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<GroupBuyGroup> list = this.groups;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total_groups;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGroupBuyGroup> {
        public Integer errcode;
        public List<GroupBuyGroup> groups;
        public String requestid;
        public Integer total_groups;

        public Builder() {
        }

        public Builder(ResponseGroupBuyGroup responseGroupBuyGroup) {
            super(responseGroupBuyGroup);
            if (responseGroupBuyGroup != null) {
                this.requestid = responseGroupBuyGroup.requestid;
                this.errcode = responseGroupBuyGroup.errcode;
                this.groups = ResponseGroupBuyGroup.copyOf(responseGroupBuyGroup.groups);
                this.total_groups = responseGroupBuyGroup.total_groups;
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

        public Builder groups(List<GroupBuyGroup> list) {
            this.groups = checkForNulls(list);
            return this;
        }

        public Builder total_groups(Integer num) {
            this.total_groups = num;
            return this;
        }

        public ResponseGroupBuyGroup build() {
            return new ResponseGroupBuyGroup(this);
        }
    }
}
