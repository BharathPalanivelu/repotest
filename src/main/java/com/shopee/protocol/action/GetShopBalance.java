package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GetShopBalance extends Message {
    public static final Boolean DEFAULT_NEED_WEEK_INCOME = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean need_week_income;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetShopBalance(String str, String str2, Boolean bool, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.need_week_income = bool;
        this.bparam = backendParam;
    }

    private GetShopBalance(Builder builder) {
        this(builder.requestid, builder.token, builder.need_week_income, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetShopBalance)) {
            return false;
        }
        GetShopBalance getShopBalance = (GetShopBalance) obj;
        if (!equals((Object) this.requestid, (Object) getShopBalance.requestid) || !equals((Object) this.token, (Object) getShopBalance.token) || !equals((Object) this.need_week_income, (Object) getShopBalance.need_week_income) || !equals((Object) this.bparam, (Object) getShopBalance.bparam)) {
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
        Boolean bool = this.need_week_income;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetShopBalance> {
        public BackendParam bparam;
        public Boolean need_week_income;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetShopBalance getShopBalance) {
            super(getShopBalance);
            if (getShopBalance != null) {
                this.requestid = getShopBalance.requestid;
                this.token = getShopBalance.token;
                this.need_week_income = getShopBalance.need_week_income;
                this.bparam = getShopBalance.bparam;
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

        public Builder need_week_income(Boolean bool) {
            this.need_week_income = bool;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetShopBalance build() {
            return new GetShopBalance(this);
        }
    }
}
