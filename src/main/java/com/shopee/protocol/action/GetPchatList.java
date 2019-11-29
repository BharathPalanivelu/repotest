package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetPchatList extends Message {
    public static final Integer DEFAULT_FROM_USERID = 0;
    public static final Boolean DEFAULT_FROM_WEBCHAT = false;
    public static final Integer DEFAULT_LAST_TIMESTAMP = 0;
    public static final Long DEFAULT_LAST_TIMESTAMP_NANO = 0L;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final List<Long> DEFAULT_PCHATID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final Boolean DEFAULT_START_FROM_OLD = false;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TO_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer from_userid;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean from_webchat;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer last_timestamp;
    @ProtoField(tag = 10, type = Message.Datatype.UINT64)
    public final Long last_timestamp_nano;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(label = Message.Label.REPEATED, tag = 9, type = Message.Datatype.INT64)
    public final List<Long> pchatid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean start_from_old;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer to_userid;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;

    public GetPchatList(String str, Integer num, Boolean bool, Boolean bool2, Integer num2, Integer num3, String str2, Integer num4, List<Long> list, Long l) {
        this.requestid = str;
        this.last_timestamp = num;
        this.start_from_old = bool;
        this.from_webchat = bool2;
        this.from_userid = num2;
        this.to_userid = num3;
        this.token = str2;
        this.limit = num4;
        this.pchatid = immutableCopyOf(list);
        this.last_timestamp_nano = l;
    }

    private GetPchatList(Builder builder) {
        this(builder.requestid, builder.last_timestamp, builder.start_from_old, builder.from_webchat, builder.from_userid, builder.to_userid, builder.token, builder.limit, builder.pchatid, builder.last_timestamp_nano);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetPchatList)) {
            return false;
        }
        GetPchatList getPchatList = (GetPchatList) obj;
        if (!equals((Object) this.requestid, (Object) getPchatList.requestid) || !equals((Object) this.last_timestamp, (Object) getPchatList.last_timestamp) || !equals((Object) this.start_from_old, (Object) getPchatList.start_from_old) || !equals((Object) this.from_webchat, (Object) getPchatList.from_webchat) || !equals((Object) this.from_userid, (Object) getPchatList.from_userid) || !equals((Object) this.to_userid, (Object) getPchatList.to_userid) || !equals((Object) this.token, (Object) getPchatList.token) || !equals((Object) this.limit, (Object) getPchatList.limit) || !equals((List<?>) this.pchatid, (List<?>) getPchatList.pchatid) || !equals((Object) this.last_timestamp_nano, (Object) getPchatList.last_timestamp_nano)) {
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
        Integer num = this.last_timestamp;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.start_from_old;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.from_webchat;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num2 = this.from_userid;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.to_userid;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str2 = this.token;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num4 = this.limit;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        List<Long> list = this.pchatid;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.last_timestamp_nano;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetPchatList> {
        public Integer from_userid;
        public Boolean from_webchat;
        public Integer last_timestamp;
        public Long last_timestamp_nano;
        public Integer limit;
        public List<Long> pchatid;
        public String requestid;
        public Boolean start_from_old;
        public Integer to_userid;
        public String token;

        public Builder() {
        }

        public Builder(GetPchatList getPchatList) {
            super(getPchatList);
            if (getPchatList != null) {
                this.requestid = getPchatList.requestid;
                this.last_timestamp = getPchatList.last_timestamp;
                this.start_from_old = getPchatList.start_from_old;
                this.from_webchat = getPchatList.from_webchat;
                this.from_userid = getPchatList.from_userid;
                this.to_userid = getPchatList.to_userid;
                this.token = getPchatList.token;
                this.limit = getPchatList.limit;
                this.pchatid = GetPchatList.copyOf(getPchatList.pchatid);
                this.last_timestamp_nano = getPchatList.last_timestamp_nano;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder last_timestamp(Integer num) {
            this.last_timestamp = num;
            return this;
        }

        public Builder start_from_old(Boolean bool) {
            this.start_from_old = bool;
            return this;
        }

        public Builder from_webchat(Boolean bool) {
            this.from_webchat = bool;
            return this;
        }

        public Builder from_userid(Integer num) {
            this.from_userid = num;
            return this;
        }

        public Builder to_userid(Integer num) {
            this.to_userid = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public Builder pchatid(List<Long> list) {
            this.pchatid = checkForNulls(list);
            return this;
        }

        public Builder last_timestamp_nano(Long l) {
            this.last_timestamp_nano = l;
            return this;
        }

        public GetPchatList build() {
            return new GetPchatList(this);
        }
    }
}
