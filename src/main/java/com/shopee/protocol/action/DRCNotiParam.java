package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DRCNotiParam extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_MESSAGE_CONTENT = "";
    public static final Integer DEFAULT_OFFER_DUE_DATE = 0;
    public static final String DEFAULT_RECIPIENT = "";
    public static final Long DEFAULT_REFUND_AMOUNT = 0L;
    public static final Integer DEFAULT_RETURN_SOLUTION = 0;
    public static final String DEFAULT_SENDER = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String message_content;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer offer_due_date;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String recipient;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long refund_amount;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer return_solution;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String sender;

    public DRCNotiParam(String str, String str2, Integer num, Integer num2, Long l, Integer num3, String str3) {
        this.recipient = str;
        this.sender = str2;
        this.ctime = num;
        this.return_solution = num2;
        this.refund_amount = l;
        this.offer_due_date = num3;
        this.message_content = str3;
    }

    private DRCNotiParam(Builder builder) {
        this(builder.recipient, builder.sender, builder.ctime, builder.return_solution, builder.refund_amount, builder.offer_due_date, builder.message_content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DRCNotiParam)) {
            return false;
        }
        DRCNotiParam dRCNotiParam = (DRCNotiParam) obj;
        if (!equals((Object) this.recipient, (Object) dRCNotiParam.recipient) || !equals((Object) this.sender, (Object) dRCNotiParam.sender) || !equals((Object) this.ctime, (Object) dRCNotiParam.ctime) || !equals((Object) this.return_solution, (Object) dRCNotiParam.return_solution) || !equals((Object) this.refund_amount, (Object) dRCNotiParam.refund_amount) || !equals((Object) this.offer_due_date, (Object) dRCNotiParam.offer_due_date) || !equals((Object) this.message_content, (Object) dRCNotiParam.message_content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.recipient;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.sender;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ctime;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.return_solution;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.refund_amount;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.offer_due_date;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.message_content;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DRCNotiParam> {
        public Integer ctime;
        public String message_content;
        public Integer offer_due_date;
        public String recipient;
        public Long refund_amount;
        public Integer return_solution;
        public String sender;

        public Builder() {
        }

        public Builder(DRCNotiParam dRCNotiParam) {
            super(dRCNotiParam);
            if (dRCNotiParam != null) {
                this.recipient = dRCNotiParam.recipient;
                this.sender = dRCNotiParam.sender;
                this.ctime = dRCNotiParam.ctime;
                this.return_solution = dRCNotiParam.return_solution;
                this.refund_amount = dRCNotiParam.refund_amount;
                this.offer_due_date = dRCNotiParam.offer_due_date;
                this.message_content = dRCNotiParam.message_content;
            }
        }

        public Builder recipient(String str) {
            this.recipient = str;
            return this;
        }

        public Builder sender(String str) {
            this.sender = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder return_solution(Integer num) {
            this.return_solution = num;
            return this;
        }

        public Builder refund_amount(Long l) {
            this.refund_amount = l;
            return this;
        }

        public Builder offer_due_date(Integer num) {
            this.offer_due_date = num;
            return this;
        }

        public Builder message_content(String str) {
            this.message_content = str;
            return this;
        }

        public DRCNotiParam build() {
            return new DRCNotiParam(this);
        }
    }
}
