package com.shopee.protocol.action;

import com.shopee.protocol.search.action.RequestHeader;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MarketPNControl extends Message {
    public static final Integer DEFAULT_AUTO_TYPE = 0;
    public static final String DEFAULT_COMMAND = "";
    public static final Boolean DEFAULT_HAS_PALCEHOLDER = false;
    public static final Boolean DEFAULT_IGNORE_CB = false;
    public static final Integer DEFAULT_MAX_USER_CTIME = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TASK_ID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer auto_type;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String command;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean has_palceholder;
    @ProtoField(tag = 5)
    public final RequestHeader header;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean ignore_cb;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer max_user_ctime;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer task_id;

    public MarketPNControl(String str, String str2, Integer num, Integer num2, RequestHeader requestHeader, Boolean bool, Integer num3, Boolean bool2) {
        this.requestid = str;
        this.command = str2;
        this.task_id = num;
        this.auto_type = num2;
        this.header = requestHeader;
        this.has_palceholder = bool;
        this.max_user_ctime = num3;
        this.ignore_cb = bool2;
    }

    private MarketPNControl(Builder builder) {
        this(builder.requestid, builder.command, builder.task_id, builder.auto_type, builder.header, builder.has_palceholder, builder.max_user_ctime, builder.ignore_cb);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPNControl)) {
            return false;
        }
        MarketPNControl marketPNControl = (MarketPNControl) obj;
        if (!equals((Object) this.requestid, (Object) marketPNControl.requestid) || !equals((Object) this.command, (Object) marketPNControl.command) || !equals((Object) this.task_id, (Object) marketPNControl.task_id) || !equals((Object) this.auto_type, (Object) marketPNControl.auto_type) || !equals((Object) this.header, (Object) marketPNControl.header) || !equals((Object) this.has_palceholder, (Object) marketPNControl.has_palceholder) || !equals((Object) this.max_user_ctime, (Object) marketPNControl.max_user_ctime) || !equals((Object) this.ignore_cb, (Object) marketPNControl.ignore_cb)) {
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
        String str2 = this.command;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.task_id;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.auto_type;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        RequestHeader requestHeader = this.header;
        int hashCode5 = (hashCode4 + (requestHeader != null ? requestHeader.hashCode() : 0)) * 37;
        Boolean bool = this.has_palceholder;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.max_user_ctime;
        int hashCode7 = (hashCode6 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.ignore_cb;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MarketPNControl> {
        public Integer auto_type;
        public String command;
        public Boolean has_palceholder;
        public RequestHeader header;
        public Boolean ignore_cb;
        public Integer max_user_ctime;
        public String requestid;
        public Integer task_id;

        public Builder() {
        }

        public Builder(MarketPNControl marketPNControl) {
            super(marketPNControl);
            if (marketPNControl != null) {
                this.requestid = marketPNControl.requestid;
                this.command = marketPNControl.command;
                this.task_id = marketPNControl.task_id;
                this.auto_type = marketPNControl.auto_type;
                this.header = marketPNControl.header;
                this.has_palceholder = marketPNControl.has_palceholder;
                this.max_user_ctime = marketPNControl.max_user_ctime;
                this.ignore_cb = marketPNControl.ignore_cb;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder command(String str) {
            this.command = str;
            return this;
        }

        public Builder task_id(Integer num) {
            this.task_id = num;
            return this;
        }

        public Builder auto_type(Integer num) {
            this.auto_type = num;
            return this;
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder has_palceholder(Boolean bool) {
            this.has_palceholder = bool;
            return this;
        }

        public Builder max_user_ctime(Integer num) {
            this.max_user_ctime = num;
            return this;
        }

        public Builder ignore_cb(Boolean bool) {
            this.ignore_cb = bool;
            return this;
        }

        public MarketPNControl build() {
            return new MarketPNControl(this);
        }
    }
}
