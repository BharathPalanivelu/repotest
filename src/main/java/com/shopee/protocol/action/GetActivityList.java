package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetActivityList extends Message {
    public static final List<Integer> DEFAULT_ACTIVITY_TYPE_LIST = Collections.emptyList();
    public static final Integer DEFAULT_LAST_ACTIVITY_ID = 0;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> activity_type_list;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer last_activity_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetActivityList(String str, String str2, Integer num, Integer num2, List<Integer> list) {
        this.requestid = str;
        this.token = str2;
        this.last_activity_id = num;
        this.limit = num2;
        this.activity_type_list = immutableCopyOf(list);
    }

    private GetActivityList(Builder builder) {
        this(builder.requestid, builder.token, builder.last_activity_id, builder.limit, builder.activity_type_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetActivityList)) {
            return false;
        }
        GetActivityList getActivityList = (GetActivityList) obj;
        if (!equals((Object) this.requestid, (Object) getActivityList.requestid) || !equals((Object) this.token, (Object) getActivityList.token) || !equals((Object) this.last_activity_id, (Object) getActivityList.last_activity_id) || !equals((Object) this.limit, (Object) getActivityList.limit) || !equals((List<?>) this.activity_type_list, (List<?>) getActivityList.activity_type_list)) {
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
        Integer num = this.last_activity_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.limit;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = (hashCode3 + i2) * 37;
        List<Integer> list = this.activity_type_list;
        int hashCode4 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode4;
        return hashCode4;
    }

    public static final class Builder extends Message.Builder<GetActivityList> {
        public List<Integer> activity_type_list;
        public Integer last_activity_id;
        public Integer limit;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetActivityList getActivityList) {
            super(getActivityList);
            if (getActivityList != null) {
                this.requestid = getActivityList.requestid;
                this.token = getActivityList.token;
                this.last_activity_id = getActivityList.last_activity_id;
                this.limit = getActivityList.limit;
                this.activity_type_list = GetActivityList.copyOf(getActivityList.activity_type_list);
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

        public Builder last_activity_id(Integer num) {
            this.last_activity_id = num;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder activity_type_list(List<Integer> list) {
            this.activity_type_list = checkForNulls(list);
            return this;
        }

        public GetActivityList build() {
            return new GetActivityList(this);
        }
    }
}
