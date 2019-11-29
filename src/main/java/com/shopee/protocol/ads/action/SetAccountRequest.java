package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SetAccountRequest extends Message {
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final AdsAccount account;
    @ProtoField(tag = 1)
    public final RequestHeader header;

    public SetAccountRequest(RequestHeader requestHeader, AdsAccount adsAccount) {
        this.header = requestHeader;
        this.account = adsAccount;
    }

    private SetAccountRequest(Builder builder) {
        this(builder.header, builder.account);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetAccountRequest)) {
            return false;
        }
        SetAccountRequest setAccountRequest = (SetAccountRequest) obj;
        if (!equals((Object) this.header, (Object) setAccountRequest.header) || !equals((Object) this.account, (Object) setAccountRequest.account)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RequestHeader requestHeader = this.header;
        int i2 = 0;
        int hashCode = (requestHeader != null ? requestHeader.hashCode() : 0) * 37;
        AdsAccount adsAccount = this.account;
        if (adsAccount != null) {
            i2 = adsAccount.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetAccountRequest> {
        public AdsAccount account;
        public RequestHeader header;

        public Builder() {
        }

        public Builder(SetAccountRequest setAccountRequest) {
            super(setAccountRequest);
            if (setAccountRequest != null) {
                this.header = setAccountRequest.header;
                this.account = setAccountRequest.account;
            }
        }

        public Builder header(RequestHeader requestHeader) {
            this.header = requestHeader;
            return this;
        }

        public Builder account(AdsAccount adsAccount) {
            this.account = adsAccount;
            return this;
        }

        public SetAccountRequest build() {
            return new SetAccountRequest(this);
        }
    }
}
