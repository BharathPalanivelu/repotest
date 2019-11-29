package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetContacts extends Message {
    public static final List<ContactBrief> DEFAULT_CONTACTS = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_TOTAL_COUNT = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = ContactBrief.class, tag = 3)
    public final List<ContactBrief> contacts;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer total_count;

    public ResponseGetContacts(String str, Integer num, List<ContactBrief> list, Integer num2) {
        this.requestid = str;
        this.errcode = num;
        this.contacts = immutableCopyOf(list);
        this.total_count = num2;
    }

    private ResponseGetContacts(Builder builder) {
        this(builder.requestid, builder.errcode, builder.contacts, builder.total_count);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetContacts)) {
            return false;
        }
        ResponseGetContacts responseGetContacts = (ResponseGetContacts) obj;
        if (!equals((Object) this.requestid, (Object) responseGetContacts.requestid) || !equals((Object) this.errcode, (Object) responseGetContacts.errcode) || !equals((List<?>) this.contacts, (List<?>) responseGetContacts.contacts) || !equals((Object) this.total_count, (Object) responseGetContacts.total_count)) {
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
        List<ContactBrief> list = this.contacts;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.total_count;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetContacts> {
        public List<ContactBrief> contacts;
        public Integer errcode;
        public String requestid;
        public Integer total_count;

        public Builder() {
        }

        public Builder(ResponseGetContacts responseGetContacts) {
            super(responseGetContacts);
            if (responseGetContacts != null) {
                this.requestid = responseGetContacts.requestid;
                this.errcode = responseGetContacts.errcode;
                this.contacts = ResponseGetContacts.copyOf(responseGetContacts.contacts);
                this.total_count = responseGetContacts.total_count;
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

        public Builder contacts(List<ContactBrief> list) {
            this.contacts = checkForNulls(list);
            return this;
        }

        public Builder total_count(Integer num) {
            this.total_count = num;
            return this;
        }

        public ResponseGetContacts build() {
            checkRequiredFields();
            return new ResponseGetContacts(this);
        }
    }
}
