package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetAddress extends Message {
    public static final List<Integer> DEFAULT_FILTER_IDS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> filter_ids;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public GetAddress(String str, String str2, BackendParam backendParam, List<Integer> list) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.filter_ids = immutableCopyOf(list);
    }

    private GetAddress(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.filter_ids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetAddress)) {
            return false;
        }
        GetAddress getAddress = (GetAddress) obj;
        if (!equals((Object) this.requestid, (Object) getAddress.requestid) || !equals((Object) this.token, (Object) getAddress.token) || !equals((Object) this.bparam, (Object) getAddress.bparam) || !equals((List<?>) this.filter_ids, (List<?>) getAddress.filter_ids)) {
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
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<Integer> list = this.filter_ids;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public static final class Builder extends Message.Builder<GetAddress> {
        public BackendParam bparam;
        public List<Integer> filter_ids;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(GetAddress getAddress) {
            super(getAddress);
            if (getAddress != null) {
                this.requestid = getAddress.requestid;
                this.token = getAddress.token;
                this.bparam = getAddress.bparam;
                this.filter_ids = GetAddress.copyOf(getAddress.filter_ids);
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

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder filter_ids(List<Integer> list) {
            this.filter_ids = checkForNulls(list);
            return this;
        }

        public GetAddress build() {
            return new GetAddress(this);
        }
    }
}
