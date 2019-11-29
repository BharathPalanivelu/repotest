package com.shopee.protocol.action;

import com.shopee.protocol.shop.BuyerAddress;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AddAddress extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final BuyerAddress address;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public AddAddress(String str, String str2, BuyerAddress buyerAddress, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.address = buyerAddress;
        this.bparam = backendParam;
    }

    private AddAddress(Builder builder) {
        this(builder.requestid, builder.token, builder.address, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddAddress)) {
            return false;
        }
        AddAddress addAddress = (AddAddress) obj;
        if (!equals((Object) this.requestid, (Object) addAddress.requestid) || !equals((Object) this.token, (Object) addAddress.token) || !equals((Object) this.address, (Object) addAddress.address) || !equals((Object) this.bparam, (Object) addAddress.bparam)) {
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
        BuyerAddress buyerAddress = this.address;
        int hashCode3 = (hashCode2 + (buyerAddress != null ? buyerAddress.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AddAddress> {
        public BuyerAddress address;
        public BackendParam bparam;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(AddAddress addAddress) {
            super(addAddress);
            if (addAddress != null) {
                this.requestid = addAddress.requestid;
                this.token = addAddress.token;
                this.address = addAddress.address;
                this.bparam = addAddress.bparam;
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

        public Builder address(BuyerAddress buyerAddress) {
            this.address = buyerAddress;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public AddAddress build() {
            checkRequiredFields();
            return new AddAddress(this);
        }
    }
}
