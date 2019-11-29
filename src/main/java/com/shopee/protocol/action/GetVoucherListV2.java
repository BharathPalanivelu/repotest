package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetVoucherListV2 extends Message {
    public static final Boolean DEFAULT_EXCLUDE_CLAIMED = false;
    public static final Integer DEFAULT_LIMIT = 0;
    public static final String DEFAULT_REQUESTID = "";
    public static final List<Integer> DEFAULT_SHOPIDS = Collections.emptyList();
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_VOUCHER_LANDING_PAGE = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean exclude_claimed;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> shopids;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long voucher_landing_page;

    public GetVoucherListV2(String str, String str2, Long l, List<Integer> list, Boolean bool, Integer num) {
        this.requestid = str;
        this.token = str2;
        this.voucher_landing_page = l;
        this.shopids = immutableCopyOf(list);
        this.exclude_claimed = bool;
        this.limit = num;
    }

    private GetVoucherListV2(Builder builder) {
        this(builder.requestid, builder.token, builder.voucher_landing_page, builder.shopids, builder.exclude_claimed, builder.limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetVoucherListV2)) {
            return false;
        }
        GetVoucherListV2 getVoucherListV2 = (GetVoucherListV2) obj;
        if (!equals((Object) this.requestid, (Object) getVoucherListV2.requestid) || !equals((Object) this.token, (Object) getVoucherListV2.token) || !equals((Object) this.voucher_landing_page, (Object) getVoucherListV2.voucher_landing_page) || !equals((List<?>) this.shopids, (List<?>) getVoucherListV2.shopids) || !equals((Object) this.exclude_claimed, (Object) getVoucherListV2.exclude_claimed) || !equals((Object) this.limit, (Object) getVoucherListV2.limit)) {
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
        Long l = this.voucher_landing_page;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        List<Integer> list = this.shopids;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.exclude_claimed;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.limit;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetVoucherListV2> {
        public Boolean exclude_claimed;
        public Integer limit;
        public String requestid;
        public List<Integer> shopids;
        public String token;
        public Long voucher_landing_page;

        public Builder() {
        }

        public Builder(GetVoucherListV2 getVoucherListV2) {
            super(getVoucherListV2);
            if (getVoucherListV2 != null) {
                this.requestid = getVoucherListV2.requestid;
                this.token = getVoucherListV2.token;
                this.voucher_landing_page = getVoucherListV2.voucher_landing_page;
                this.shopids = GetVoucherListV2.copyOf(getVoucherListV2.shopids);
                this.exclude_claimed = getVoucherListV2.exclude_claimed;
                this.limit = getVoucherListV2.limit;
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

        public Builder voucher_landing_page(Long l) {
            this.voucher_landing_page = l;
            return this;
        }

        public Builder shopids(List<Integer> list) {
            this.shopids = checkForNulls(list);
            return this;
        }

        public Builder exclude_claimed(Boolean bool) {
            this.exclude_claimed = bool;
            return this;
        }

        public Builder limit(Integer num) {
            this.limit = num;
            return this;
        }

        public GetVoucherListV2 build() {
            return new GetVoucherListV2(this);
        }
    }
}
