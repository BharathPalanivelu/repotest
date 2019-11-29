package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetVoucherPromotion extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final List<VoucherIdentity> DEFAULT_VOUCHER_IDENTITIES = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, messageType = VoucherIdentity.class, tag = 2)
    public final List<VoucherIdentity> voucher_identities;

    public GetVoucherPromotion(String str, List<VoucherIdentity> list) {
        this.requestid = str;
        this.voucher_identities = immutableCopyOf(list);
    }

    private GetVoucherPromotion(Builder builder) {
        this(builder.requestid, builder.voucher_identities);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetVoucherPromotion)) {
            return false;
        }
        GetVoucherPromotion getVoucherPromotion = (GetVoucherPromotion) obj;
        if (!equals((Object) this.requestid, (Object) getVoucherPromotion.requestid) || !equals((List<?>) this.voucher_identities, (List<?>) getVoucherPromotion.voucher_identities)) {
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
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<VoucherIdentity> list = this.voucher_identities;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetVoucherPromotion> {
        public String requestid;
        public List<VoucherIdentity> voucher_identities;

        public Builder() {
        }

        public Builder(GetVoucherPromotion getVoucherPromotion) {
            super(getVoucherPromotion);
            if (getVoucherPromotion != null) {
                this.requestid = getVoucherPromotion.requestid;
                this.voucher_identities = GetVoucherPromotion.copyOf(getVoucherPromotion.voucher_identities);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder voucher_identities(List<VoucherIdentity> list) {
            this.voucher_identities = checkForNulls(list);
            return this;
        }

        public GetVoucherPromotion build() {
            return new GetVoucherPromotion(this);
        }
    }
}
