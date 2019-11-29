package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetCheckout extends Message {
    public static final List<Long> DEFAULT_CHECKOUTID = Collections.emptyList();
    public static final Boolean DEFAULT_IS_SHADOW = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> checkoutid;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_shadow;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public GetCheckout(String str, List<Long> list, String str2, BackendParam backendParam, Boolean bool) {
        this.requestid = str;
        this.checkoutid = immutableCopyOf(list);
        this.token = str2;
        this.bparam = backendParam;
        this.is_shadow = bool;
    }

    private GetCheckout(Builder builder) {
        this(builder.requestid, builder.checkoutid, builder.token, builder.bparam, builder.is_shadow);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetCheckout)) {
            return false;
        }
        GetCheckout getCheckout = (GetCheckout) obj;
        if (!equals((Object) this.requestid, (Object) getCheckout.requestid) || !equals((List<?>) this.checkoutid, (List<?>) getCheckout.checkoutid) || !equals((Object) this.token, (Object) getCheckout.token) || !equals((Object) this.bparam, (Object) getCheckout.bparam) || !equals((Object) this.is_shadow, (Object) getCheckout.is_shadow)) {
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
        List<Long> list = this.checkoutid;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.token;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode4 = (hashCode3 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Boolean bool = this.is_shadow;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetCheckout> {
        public BackendParam bparam;
        public List<Long> checkoutid;
        public Boolean is_shadow;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetCheckout getCheckout) {
            super(getCheckout);
            if (getCheckout != null) {
                this.requestid = getCheckout.requestid;
                this.checkoutid = GetCheckout.copyOf(getCheckout.checkoutid);
                this.token = getCheckout.token;
                this.bparam = getCheckout.bparam;
                this.is_shadow = getCheckout.is_shadow;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder checkoutid(List<Long> list) {
            this.checkoutid = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder is_shadow(Boolean bool) {
            this.is_shadow = bool;
            return this;
        }

        public GetCheckout build() {
            return new GetCheckout(this);
        }
    }
}
