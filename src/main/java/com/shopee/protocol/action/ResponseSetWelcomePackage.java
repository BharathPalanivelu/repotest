package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseSetWelcomePackage extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<FailedWelcomePackageItem> DEFAULT_FAILED_ITEMS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, messageType = FailedWelcomePackageItem.class, tag = 4)
    public final List<FailedWelcomePackageItem> failed_items;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseSetWelcomePackage(String str, Integer num, String str2, List<FailedWelcomePackageItem> list) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.failed_items = immutableCopyOf(list);
    }

    private ResponseSetWelcomePackage(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.failed_items);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseSetWelcomePackage)) {
            return false;
        }
        ResponseSetWelcomePackage responseSetWelcomePackage = (ResponseSetWelcomePackage) obj;
        if (!equals((Object) this.requestid, (Object) responseSetWelcomePackage.requestid) || !equals((Object) this.errcode, (Object) responseSetWelcomePackage.errcode) || !equals((Object) this.debug_msg, (Object) responseSetWelcomePackage.debug_msg) || !equals((List<?>) this.failed_items, (List<?>) responseSetWelcomePackage.failed_items)) {
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
        String str2 = this.debug_msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<FailedWelcomePackageItem> list = this.failed_items;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseSetWelcomePackage> {
        public String debug_msg;
        public Integer errcode;
        public List<FailedWelcomePackageItem> failed_items;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseSetWelcomePackage responseSetWelcomePackage) {
            super(responseSetWelcomePackage);
            if (responseSetWelcomePackage != null) {
                this.requestid = responseSetWelcomePackage.requestid;
                this.errcode = responseSetWelcomePackage.errcode;
                this.debug_msg = responseSetWelcomePackage.debug_msg;
                this.failed_items = ResponseSetWelcomePackage.copyOf(responseSetWelcomePackage.failed_items);
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

        public Builder debug_msg(String str) {
            this.debug_msg = str;
            return this;
        }

        public Builder failed_items(List<FailedWelcomePackageItem> list) {
            this.failed_items = checkForNulls(list);
            return this;
        }

        public ResponseSetWelcomePackage build() {
            return new ResponseSetWelcomePackage(this);
        }
    }
}
