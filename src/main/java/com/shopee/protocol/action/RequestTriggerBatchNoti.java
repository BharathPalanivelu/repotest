package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class RequestTriggerBatchNoti extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_TO_USERID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final TriggerNoti noti;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> to_userid;

    public RequestTriggerBatchNoti(String str, TriggerNoti triggerNoti, List<Integer> list) {
        this.requestid = str;
        this.noti = triggerNoti;
        this.to_userid = immutableCopyOf(list);
    }

    private RequestTriggerBatchNoti(Builder builder) {
        this(builder.requestid, builder.noti, builder.to_userid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestTriggerBatchNoti)) {
            return false;
        }
        RequestTriggerBatchNoti requestTriggerBatchNoti = (RequestTriggerBatchNoti) obj;
        if (!equals((Object) this.requestid, (Object) requestTriggerBatchNoti.requestid) || !equals((Object) this.noti, (Object) requestTriggerBatchNoti.noti) || !equals((List<?>) this.to_userid, (List<?>) requestTriggerBatchNoti.to_userid)) {
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
        TriggerNoti triggerNoti = this.noti;
        if (triggerNoti != null) {
            i2 = triggerNoti.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Integer> list = this.to_userid;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<RequestTriggerBatchNoti> {
        public TriggerNoti noti;
        public String requestid;
        public List<Integer> to_userid;

        public Builder() {
        }

        public Builder(RequestTriggerBatchNoti requestTriggerBatchNoti) {
            super(requestTriggerBatchNoti);
            if (requestTriggerBatchNoti != null) {
                this.requestid = requestTriggerBatchNoti.requestid;
                this.noti = requestTriggerBatchNoti.noti;
                this.to_userid = RequestTriggerBatchNoti.copyOf(requestTriggerBatchNoti.to_userid);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder noti(TriggerNoti triggerNoti) {
            this.noti = triggerNoti;
            return this;
        }

        public Builder to_userid(List<Integer> list) {
            this.to_userid = checkForNulls(list);
            return this;
        }

        public RequestTriggerBatchNoti build() {
            return new RequestTriggerBatchNoti(this);
        }
    }
}
