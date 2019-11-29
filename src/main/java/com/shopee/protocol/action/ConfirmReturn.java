package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConfirmReturn extends Message {
    public static final Boolean DEFAULT_ACCEPT = false;
    public static final Boolean DEFAULT_CONFIRM_REFUND = false;
    public static final Integer DEFAULT_DISPUTE_REASON = 0;
    public static final String DEFAULT_DISPUTE_TEXT_REASON = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_IMAGES = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean accept;
    @ProtoField(tag = 11)
    public final BackendParam bparam;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean confirm_refund;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer dispute_reason;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String dispute_text_reason;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String images;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 10)
    public final BuyerAddress return_delivery_address;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public ConfirmReturn(String str, Long l, Boolean bool, String str2, String str3, Integer num, String str4, String str5, Boolean bool2, BuyerAddress buyerAddress, BackendParam backendParam) {
        this.requestid = str;
        this.return_id = l;
        this.accept = bool;
        this.email = str2;
        this.token = str3;
        this.dispute_reason = num;
        this.dispute_text_reason = str4;
        this.images = str5;
        this.confirm_refund = bool2;
        this.return_delivery_address = buyerAddress;
        this.bparam = backendParam;
    }

    private ConfirmReturn(Builder builder) {
        this(builder.requestid, builder.return_id, builder.accept, builder.email, builder.token, builder.dispute_reason, builder.dispute_text_reason, builder.images, builder.confirm_refund, builder.return_delivery_address, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConfirmReturn)) {
            return false;
        }
        ConfirmReturn confirmReturn = (ConfirmReturn) obj;
        if (!equals((Object) this.requestid, (Object) confirmReturn.requestid) || !equals((Object) this.return_id, (Object) confirmReturn.return_id) || !equals((Object) this.accept, (Object) confirmReturn.accept) || !equals((Object) this.email, (Object) confirmReturn.email) || !equals((Object) this.token, (Object) confirmReturn.token) || !equals((Object) this.dispute_reason, (Object) confirmReturn.dispute_reason) || !equals((Object) this.dispute_text_reason, (Object) confirmReturn.dispute_text_reason) || !equals((Object) this.images, (Object) confirmReturn.images) || !equals((Object) this.confirm_refund, (Object) confirmReturn.confirm_refund) || !equals((Object) this.return_delivery_address, (Object) confirmReturn.return_delivery_address) || !equals((Object) this.bparam, (Object) confirmReturn.bparam)) {
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
        Long l = this.return_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.accept;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.email;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.dispute_reason;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        String str4 = this.dispute_text_reason;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.images;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool2 = this.confirm_refund;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        BuyerAddress buyerAddress = this.return_delivery_address;
        int hashCode10 = (hashCode9 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConfirmReturn> {
        public Boolean accept;
        public BackendParam bparam;
        public Boolean confirm_refund;
        public Integer dispute_reason;
        public String dispute_text_reason;
        public String email;
        public String images;
        public String requestid;
        public BuyerAddress return_delivery_address;
        public Long return_id;
        public String token;

        public Builder() {
        }

        public Builder(ConfirmReturn confirmReturn) {
            super(confirmReturn);
            if (confirmReturn != null) {
                this.requestid = confirmReturn.requestid;
                this.return_id = confirmReturn.return_id;
                this.accept = confirmReturn.accept;
                this.email = confirmReturn.email;
                this.token = confirmReturn.token;
                this.dispute_reason = confirmReturn.dispute_reason;
                this.dispute_text_reason = confirmReturn.dispute_text_reason;
                this.images = confirmReturn.images;
                this.confirm_refund = confirmReturn.confirm_refund;
                this.return_delivery_address = confirmReturn.return_delivery_address;
                this.bparam = confirmReturn.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder accept(Boolean bool) {
            this.accept = bool;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder dispute_reason(Integer num) {
            this.dispute_reason = num;
            return this;
        }

        public Builder dispute_text_reason(String str) {
            this.dispute_text_reason = str;
            return this;
        }

        public Builder images(String str) {
            this.images = str;
            return this;
        }

        public Builder confirm_refund(Boolean bool) {
            this.confirm_refund = bool;
            return this;
        }

        public Builder return_delivery_address(BuyerAddress buyerAddress) {
            this.return_delivery_address = buyerAddress;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public ConfirmReturn build() {
            return new ConfirmReturn(this);
        }
    }
}
