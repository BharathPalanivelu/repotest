package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetBundleDeal extends Message {
    public static final List<Long> DEFAULT_BUNDLE_DEAL_IDS = Collections.emptyList();
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> bundle_deal_ids;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetBundleDeal(String str, String str2, List<Long> list, String str3) {
        this.requestid = str;
        this.token = str2;
        this.bundle_deal_ids = immutableCopyOf(list);
        this.country = str3;
    }

    private GetBundleDeal(Builder builder) {
        this(builder.requestid, builder.token, builder.bundle_deal_ids, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetBundleDeal)) {
            return false;
        }
        GetBundleDeal getBundleDeal = (GetBundleDeal) obj;
        if (!equals((Object) this.requestid, (Object) getBundleDeal.requestid) || !equals((Object) this.token, (Object) getBundleDeal.token) || !equals((List<?>) this.bundle_deal_ids, (List<?>) getBundleDeal.bundle_deal_ids) || !equals((Object) this.country, (Object) getBundleDeal.country)) {
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
        List<Long> list = this.bundle_deal_ids;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetBundleDeal> {
        public List<Long> bundle_deal_ids;
        public String country;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetBundleDeal getBundleDeal) {
            super(getBundleDeal);
            if (getBundleDeal != null) {
                this.requestid = getBundleDeal.requestid;
                this.token = getBundleDeal.token;
                this.bundle_deal_ids = GetBundleDeal.copyOf(getBundleDeal.bundle_deal_ids);
                this.country = getBundleDeal.country;
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

        public Builder bundle_deal_ids(List<Long> list) {
            this.bundle_deal_ids = checkForNulls(list);
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public GetBundleDeal build() {
            return new GetBundleDeal(this);
        }
    }
}
