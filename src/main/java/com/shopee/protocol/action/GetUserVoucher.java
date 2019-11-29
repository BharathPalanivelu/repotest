package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetUserVoucher extends Message {
    public static final Boolean DEFAULT_FROM_VOUCHER_WALLET = false;
    public static final List<Long> DEFAULT_PROMOTIONIDS = Collections.emptyList();
    public static final Boolean DEFAULT_PROMOTIONID_ONLY = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean from_voucher_wallet;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean promotionid_only;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> promotionids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetUserVoucher(String str, String str2, List<Long> list, Boolean bool, Boolean bool2) {
        this.requestid = str;
        this.token = str2;
        this.promotionids = immutableCopyOf(list);
        this.from_voucher_wallet = bool;
        this.promotionid_only = bool2;
    }

    private GetUserVoucher(Builder builder) {
        this(builder.requestid, builder.token, builder.promotionids, builder.from_voucher_wallet, builder.promotionid_only);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetUserVoucher)) {
            return false;
        }
        GetUserVoucher getUserVoucher = (GetUserVoucher) obj;
        if (!equals((Object) this.requestid, (Object) getUserVoucher.requestid) || !equals((Object) this.token, (Object) getUserVoucher.token) || !equals((List<?>) this.promotionids, (List<?>) getUserVoucher.promotionids) || !equals((Object) this.from_voucher_wallet, (Object) getUserVoucher.from_voucher_wallet) || !equals((Object) this.promotionid_only, (Object) getUserVoucher.promotionid_only)) {
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
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<Long> list = this.promotionids;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.from_voucher_wallet;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.promotionid_only;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetUserVoucher> {
        public Boolean from_voucher_wallet;
        public Boolean promotionid_only;
        public List<Long> promotionids;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetUserVoucher getUserVoucher) {
            super(getUserVoucher);
            if (getUserVoucher != null) {
                this.requestid = getUserVoucher.requestid;
                this.token = getUserVoucher.token;
                this.promotionids = GetUserVoucher.copyOf(getUserVoucher.promotionids);
                this.from_voucher_wallet = getUserVoucher.from_voucher_wallet;
                this.promotionid_only = getUserVoucher.promotionid_only;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder promotionids(List<Long> list) {
            this.promotionids = checkForNulls(list);
            return this;
        }

        public Builder from_voucher_wallet(Boolean bool) {
            this.from_voucher_wallet = bool;
            return this;
        }

        public Builder promotionid_only(Boolean bool) {
            this.promotionid_only = bool;
            return this;
        }

        public GetUserVoucher build() {
            return new GetUserVoucher(this);
        }
    }
}
