package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class WhitelistUserModel extends Message {
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_OPERATOR = "";
    public static final Integer DEFAULT_STATUS = 1;
    public static final Integer DEFAULT_TYPE = 9;
    public static final Long DEFAULT_USERID = 0L;
    public static final String DEFAULT_USERNAME = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String username;

    public WhitelistUserModel(Long l, Long l2, String str, String str2, Long l3, Long l4, Integer num, Integer num2) {
        this.id = l;
        this.userid = l2;
        this.username = str;
        this.operator = str2;
        this.ctime = l3;
        this.mtime = l4;
        this.status = num;
        this.type = num2;
    }

    private WhitelistUserModel(Builder builder) {
        this(builder.id, builder.userid, builder.username, builder.operator, builder.ctime, builder.mtime, builder.status, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WhitelistUserModel)) {
            return false;
        }
        WhitelistUserModel whitelistUserModel = (WhitelistUserModel) obj;
        if (!equals((Object) this.id, (Object) whitelistUserModel.id) || !equals((Object) this.userid, (Object) whitelistUserModel.userid) || !equals((Object) this.username, (Object) whitelistUserModel.username) || !equals((Object) this.operator, (Object) whitelistUserModel.operator) || !equals((Object) this.ctime, (Object) whitelistUserModel.ctime) || !equals((Object) this.mtime, (Object) whitelistUserModel.mtime) || !equals((Object) this.status, (Object) whitelistUserModel.status) || !equals((Object) this.type, (Object) whitelistUserModel.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.userid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.username;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.operator;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l3 = this.ctime;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.mtime;
        int hashCode6 = (hashCode5 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.type;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WhitelistUserModel> {
        public Long ctime;
        public Long id;
        public Long mtime;
        public String operator;
        public Integer status;
        public Integer type;
        public Long userid;
        public String username;

        public Builder() {
        }

        public Builder(WhitelistUserModel whitelistUserModel) {
            super(whitelistUserModel);
            if (whitelistUserModel != null) {
                this.id = whitelistUserModel.id;
                this.userid = whitelistUserModel.userid;
                this.username = whitelistUserModel.username;
                this.operator = whitelistUserModel.operator;
                this.ctime = whitelistUserModel.ctime;
                this.mtime = whitelistUserModel.mtime;
                this.status = whitelistUserModel.status;
                this.type = whitelistUserModel.type;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public WhitelistUserModel build() {
            return new WhitelistUserModel(this);
        }
    }
}
