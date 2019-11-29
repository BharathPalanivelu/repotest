package com.shopee.protocol.action;

import com.shopee.protocol.shop.CoinReject;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class SetCoinReject extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final List<CoinReject> DEFAULT_DATA = Collections.emptyList();
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(label = Message.Label.REPEATED, messageType = CoinReject.class, tag = 2)
    public final List<CoinReject> data;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public SetCoinReject(String str, List<CoinReject> list, String str2, String str3) {
        this.requestid = str;
        this.data = immutableCopyOf(list);
        this.operator = str2;
        this.country = str3;
    }

    private SetCoinReject(Builder builder) {
        this(builder.requestid, builder.data, builder.operator, builder.country);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SetCoinReject)) {
            return false;
        }
        SetCoinReject setCoinReject = (SetCoinReject) obj;
        if (!equals((Object) this.requestid, (Object) setCoinReject.requestid) || !equals((List<?>) this.data, (List<?>) setCoinReject.data) || !equals((Object) this.operator, (Object) setCoinReject.operator) || !equals((Object) this.country, (Object) setCoinReject.country)) {
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
        List<CoinReject> list = this.data;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.operator;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SetCoinReject> {
        public String country;
        public List<CoinReject> data;
        public String operator;
        public String requestid;

        public Builder() {
        }

        public Builder(SetCoinReject setCoinReject) {
            super(setCoinReject);
            if (setCoinReject != null) {
                this.requestid = setCoinReject.requestid;
                this.data = SetCoinReject.copyOf(setCoinReject.data);
                this.operator = setCoinReject.operator;
                this.country = setCoinReject.country;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder data(List<CoinReject> list) {
            this.data = checkForNulls(list);
            return this;
        }

        public Builder operator(String str) {
            this.operator = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public SetCoinReject build() {
            return new SetCoinReject(this);
        }
    }
}
