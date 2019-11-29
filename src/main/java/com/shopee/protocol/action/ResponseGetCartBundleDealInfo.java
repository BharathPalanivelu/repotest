package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ResponseGetCartBundleDealInfo extends Message {
    public static final List<CartBundle> DEFAULT_BUNDLE_LIST = Collections.emptyList();
    public static final Boolean DEFAULT_CART_HIT_LIMIT = false;
    public static final Integer DEFAULT_ERRCODE = 0;
    public static final Boolean DEFAULT_HIT_LIMIT = false;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = CartBundle.class, tag = 5)
    public final List<CartBundle> bundle_list;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean cart_hit_limit;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer errcode;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean hit_limit;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3)
    public final BundleDealStats stats;

    public ResponseGetCartBundleDealInfo(String str, Integer num, BundleDealStats bundleDealStats, Boolean bool, List<CartBundle> list, Boolean bool2) {
        this.requestid = str;
        this.errcode = num;
        this.stats = bundleDealStats;
        this.hit_limit = bool;
        this.bundle_list = immutableCopyOf(list);
        this.cart_hit_limit = bool2;
    }

    private ResponseGetCartBundleDealInfo(Builder builder) {
        this(builder.requestid, builder.errcode, builder.stats, builder.hit_limit, builder.bundle_list, builder.cart_hit_limit);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseGetCartBundleDealInfo)) {
            return false;
        }
        ResponseGetCartBundleDealInfo responseGetCartBundleDealInfo = (ResponseGetCartBundleDealInfo) obj;
        if (!equals((Object) this.requestid, (Object) responseGetCartBundleDealInfo.requestid) || !equals((Object) this.errcode, (Object) responseGetCartBundleDealInfo.errcode) || !equals((Object) this.stats, (Object) responseGetCartBundleDealInfo.stats) || !equals((Object) this.hit_limit, (Object) responseGetCartBundleDealInfo.hit_limit) || !equals((List<?>) this.bundle_list, (List<?>) responseGetCartBundleDealInfo.bundle_list) || !equals((Object) this.cart_hit_limit, (Object) responseGetCartBundleDealInfo.cart_hit_limit)) {
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
        BundleDealStats bundleDealStats = this.stats;
        int hashCode3 = (hashCode2 + (bundleDealStats != null ? bundleDealStats.hashCode() : 0)) * 37;
        Boolean bool = this.hit_limit;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        List<CartBundle> list = this.bundle_list;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool2 = this.cart_hit_limit;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ResponseGetCartBundleDealInfo> {
        public List<CartBundle> bundle_list;
        public Boolean cart_hit_limit;
        public Integer errcode;
        public Boolean hit_limit;
        public String requestid;
        public BundleDealStats stats;

        public Builder() {
        }

        public Builder(ResponseGetCartBundleDealInfo responseGetCartBundleDealInfo) {
            super(responseGetCartBundleDealInfo);
            if (responseGetCartBundleDealInfo != null) {
                this.requestid = responseGetCartBundleDealInfo.requestid;
                this.errcode = responseGetCartBundleDealInfo.errcode;
                this.stats = responseGetCartBundleDealInfo.stats;
                this.hit_limit = responseGetCartBundleDealInfo.hit_limit;
                this.bundle_list = ResponseGetCartBundleDealInfo.copyOf(responseGetCartBundleDealInfo.bundle_list);
                this.cart_hit_limit = responseGetCartBundleDealInfo.cart_hit_limit;
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

        public Builder stats(BundleDealStats bundleDealStats) {
            this.stats = bundleDealStats;
            return this;
        }

        public Builder hit_limit(Boolean bool) {
            this.hit_limit = bool;
            return this;
        }

        public Builder bundle_list(List<CartBundle> list) {
            this.bundle_list = checkForNulls(list);
            return this;
        }

        public Builder cart_hit_limit(Boolean bool) {
            this.cart_hit_limit = bool;
            return this;
        }

        public ResponseGetCartBundleDealInfo build() {
            return new ResponseGetCartBundleDealInfo(this);
        }
    }
}
