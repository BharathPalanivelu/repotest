package com.shopee.protocol.action;

import com.shopee.protocol.shop.Account;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseUserList extends Message {
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_NEED_CONVERT_PHONE = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Account> DEFAULT_USER = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean need_convert_phone;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = Account.class, tag = 3)
    public final List<Account> user;

    public ResponseUserList(String str, Integer num, List<Account> list, Boolean bool) {
        this.requestid = str;
        this.errcode = num;
        this.user = immutableCopyOf(list);
        this.need_convert_phone = bool;
    }

    private ResponseUserList(Builder builder) {
        this(builder.requestid, builder.errcode, builder.user, builder.need_convert_phone);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseUserList)) {
            return false;
        }
        ResponseUserList responseUserList = (ResponseUserList) obj;
        if (!equals((Object) this.requestid, (Object) responseUserList.requestid) || !equals((Object) this.errcode, (Object) responseUserList.errcode) || !equals((List<?>) this.user, (List<?>) responseUserList.user) || !equals((Object) this.need_convert_phone, (Object) responseUserList.need_convert_phone)) {
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
        List<Account> list = this.user;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.need_convert_phone;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseUserList> {
        public Integer errcode;
        public Boolean need_convert_phone;
        public String requestid;
        public List<Account> user;

        public Builder() {
        }

        public Builder(ResponseUserList responseUserList) {
            super(responseUserList);
            if (responseUserList != null) {
                this.requestid = responseUserList.requestid;
                this.errcode = responseUserList.errcode;
                this.user = ResponseUserList.copyOf(responseUserList.user);
                this.need_convert_phone = responseUserList.need_convert_phone;
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

        public Builder user(List<Account> list) {
            this.user = checkForNulls(list);
            return this;
        }

        public Builder need_convert_phone(Boolean bool) {
            this.need_convert_phone = bool;
            return this;
        }

        public ResponseUserList build() {
            checkRequiredFields();
            return new ResponseUserList(this);
        }
    }
}
