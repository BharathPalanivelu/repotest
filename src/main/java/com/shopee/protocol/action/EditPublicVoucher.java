package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class EditPublicVoucher extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_PROMOTIONID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_USAGE_LIMIT = 0;
    public static final List<String> DEFAULT_VOUCHER_CODE = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long promotionid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer usage_limit;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> voucher_code;

    public EditPublicVoucher(String str, Long l, List<String> list, Integer num, Integer num2, String str2, String str3) {
        this.requestid = str;
        this.promotionid = l;
        this.voucher_code = immutableCopyOf(list);
        this.status = num;
        this.usage_limit = num2;
        this.country = str2;
        this.token = str3;
    }

    private EditPublicVoucher(Builder builder) {
        this(builder.requestid, builder.promotionid, builder.voucher_code, builder.status, builder.usage_limit, builder.country, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EditPublicVoucher)) {
            return false;
        }
        EditPublicVoucher editPublicVoucher = (EditPublicVoucher) obj;
        if (!equals((Object) this.requestid, (Object) editPublicVoucher.requestid) || !equals((Object) this.promotionid, (Object) editPublicVoucher.promotionid) || !equals((List<?>) this.voucher_code, (List<?>) editPublicVoucher.voucher_code) || !equals((Object) this.status, (Object) editPublicVoucher.status) || !equals((Object) this.usage_limit, (Object) editPublicVoucher.usage_limit) || !equals((Object) this.country, (Object) editPublicVoucher.country) || !equals((Object) this.token, (Object) editPublicVoucher.token)) {
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
        Long l = this.promotionid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        List<String> list = this.voucher_code;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num = this.status;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.usage_limit;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<EditPublicVoucher> {
        public String country;
        public Long promotionid;
        public String requestid;
        public Integer status;
        public String token;
        public Integer usage_limit;
        public List<String> voucher_code;

        public Builder() {
        }

        public Builder(EditPublicVoucher editPublicVoucher) {
            super(editPublicVoucher);
            if (editPublicVoucher != null) {
                this.requestid = editPublicVoucher.requestid;
                this.promotionid = editPublicVoucher.promotionid;
                this.voucher_code = EditPublicVoucher.copyOf(editPublicVoucher.voucher_code);
                this.status = editPublicVoucher.status;
                this.usage_limit = editPublicVoucher.usage_limit;
                this.country = editPublicVoucher.country;
                this.token = editPublicVoucher.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder promotionid(Long l) {
            this.promotionid = l;
            return this;
        }

        public Builder voucher_code(List<String> list) {
            this.voucher_code = checkForNulls(list);
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder usage_limit(Integer num) {
            this.usage_limit = num;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public EditPublicVoucher build() {
            return new EditPublicVoucher(this);
        }
    }
}
