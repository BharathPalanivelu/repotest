package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetBundleDealUsage extends Message {
    public static final List<Long> DEFAULT_BUNDLE_DEAL_ID = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> bundle_deal_id;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetBundleDealUsage(String str, String str2, List<Long> list) {
        this.requestid = str;
        this.token = str2;
        this.bundle_deal_id = immutableCopyOf(list);
    }

    private GetBundleDealUsage(Builder builder) {
        this(builder.requestid, builder.token, builder.bundle_deal_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetBundleDealUsage)) {
            return false;
        }
        GetBundleDealUsage getBundleDealUsage = (GetBundleDealUsage) obj;
        if (!equals((Object) this.requestid, (Object) getBundleDealUsage.requestid) || !equals((Object) this.token, (Object) getBundleDealUsage.token) || !equals((List<?>) this.bundle_deal_id, (List<?>) getBundleDealUsage.bundle_deal_id)) {
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
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<Long> list = this.bundle_deal_id;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<GetBundleDealUsage> {
        public List<Long> bundle_deal_id;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetBundleDealUsage getBundleDealUsage) {
            super(getBundleDealUsage);
            if (getBundleDealUsage != null) {
                this.requestid = getBundleDealUsage.requestid;
                this.token = getBundleDealUsage.token;
                this.bundle_deal_id = GetBundleDealUsage.copyOf(getBundleDealUsage.bundle_deal_id);
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

        public Builder bundle_deal_id(List<Long> list) {
            this.bundle_deal_id = checkForNulls(list);
            return this;
        }

        public GetBundleDealUsage build() {
            return new GetBundleDealUsage(this);
        }
    }
}
