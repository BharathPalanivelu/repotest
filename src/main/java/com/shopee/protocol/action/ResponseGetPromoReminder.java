package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetPromoReminder extends Message {
    public static final List<PromoReminderCount> DEFAULT_COUNTS = Collections.emptyList();
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = PromoReminderCount.class, tag = 2)
    public final List<PromoReminderCount> counts;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ResponseGetPromoReminder(String str, List<PromoReminderCount> list, Integer num) {
        this.requestid = str;
        this.counts = immutableCopyOf(list);
        this.errcode = num;
    }

    private ResponseGetPromoReminder(Builder builder) {
        this(builder.requestid, builder.counts, builder.errcode);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetPromoReminder)) {
            return false;
        }
        ResponseGetPromoReminder responseGetPromoReminder = (ResponseGetPromoReminder) obj;
        if (!equals((Object) this.requestid, (Object) responseGetPromoReminder.requestid) || !equals((List<?>) this.counts, (List<?>) responseGetPromoReminder.counts) || !equals((Object) this.errcode, (Object) responseGetPromoReminder.errcode)) {
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
        List<PromoReminderCount> list = this.counts;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.errcode;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetPromoReminder> {
        public List<PromoReminderCount> counts;
        public Integer errcode;
        public String requestid;

        public Builder() {
        }

        public Builder(ResponseGetPromoReminder responseGetPromoReminder) {
            super(responseGetPromoReminder);
            if (responseGetPromoReminder != null) {
                this.requestid = responseGetPromoReminder.requestid;
                this.counts = ResponseGetPromoReminder.copyOf(responseGetPromoReminder.counts);
                this.errcode = responseGetPromoReminder.errcode;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder counts(List<PromoReminderCount> list) {
            this.counts = checkForNulls(list);
            return this;
        }

        public Builder errcode(Integer num) {
            this.errcode = num;
            return this;
        }

        public ResponseGetPromoReminder build() {
            return new ResponseGetPromoReminder(this);
        }
    }
}
