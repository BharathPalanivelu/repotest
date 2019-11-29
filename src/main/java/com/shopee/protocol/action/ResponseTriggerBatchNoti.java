package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseTriggerBatchNoti extends Message {
    public static final String DEFAULT_DEBUG_MSG = "";
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final List<Integer> DEFAULT_FAILED_USERID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String debug_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> failed_userid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseTriggerBatchNoti(String str, Integer num, String str2, List<Integer> list) {
        this.requestid = str;
        this.errcode = num;
        this.debug_msg = str2;
        this.failed_userid = immutableCopyOf(list);
    }

    private ResponseTriggerBatchNoti(Builder builder) {
        this(builder.requestid, builder.errcode, builder.debug_msg, builder.failed_userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseTriggerBatchNoti)) {
            return false;
        }
        ResponseTriggerBatchNoti responseTriggerBatchNoti = (ResponseTriggerBatchNoti) obj;
        if (!equals((Object) this.requestid, (Object) responseTriggerBatchNoti.requestid) || !equals((Object) this.errcode, (Object) responseTriggerBatchNoti.errcode) || !equals((Object) this.debug_msg, (Object) responseTriggerBatchNoti.debug_msg) || !equals((List<?>) this.failed_userid, (List<?>) responseTriggerBatchNoti.failed_userid)) {
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
        List<Integer> list = this.failed_userid;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<ResponseTriggerBatchNoti> {
        public String debug_msg;
        public Integer errcode;
        public List<Integer> failed_userid;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseTriggerBatchNoti responseTriggerBatchNoti) {
            super(responseTriggerBatchNoti);
            if (responseTriggerBatchNoti != null) {
                this.requestid = responseTriggerBatchNoti.requestid;
                this.errcode = responseTriggerBatchNoti.errcode;
                this.debug_msg = responseTriggerBatchNoti.debug_msg;
                this.failed_userid = ResponseTriggerBatchNoti.copyOf(responseTriggerBatchNoti.failed_userid);
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

        public Builder failed_userid(List<Integer> list) {
            this.failed_userid = checkForNulls(list);
            return this;
        }

        public ResponseTriggerBatchNoti build() {
            checkRequiredFields();
            return new ResponseTriggerBatchNoti(this);
        }
    }
}
