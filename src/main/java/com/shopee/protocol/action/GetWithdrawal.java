package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class GetWithdrawal extends Message {
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final List<Long> DEFAULT_WITHDRALAL_ID = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4)
    public final BackendParam bparam;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> withdralal_id;

    public GetWithdrawal(String str, String str2, List<Long> list, BackendParam backendParam) {
        this.requestid = str;
        this.token = str2;
        this.withdralal_id = immutableCopyOf(list);
        this.bparam = backendParam;
    }

    private GetWithdrawal(Builder builder) {
        this(builder.requestid, builder.token, builder.withdralal_id, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetWithdrawal)) {
            return false;
        }
        GetWithdrawal getWithdrawal = (GetWithdrawal) obj;
        if (!equals((Object) this.requestid, (Object) getWithdrawal.requestid) || !equals((Object) this.token, (Object) getWithdrawal.token) || !equals((List<?>) this.withdralal_id, (List<?>) getWithdrawal.withdralal_id) || !equals((Object) this.bparam, (Object) getWithdrawal.bparam)) {
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
        List<Long> list = this.withdralal_id;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GetWithdrawal> {
        public BackendParam bparam;
        public String requestid;
        public String token;
        public List<Long> withdralal_id;

        public Builder() {
        }

        public Builder(GetWithdrawal getWithdrawal) {
            super(getWithdrawal);
            if (getWithdrawal != null) {
                this.requestid = getWithdrawal.requestid;
                this.token = getWithdrawal.token;
                this.withdralal_id = GetWithdrawal.copyOf(getWithdrawal.withdralal_id);
                this.bparam = getWithdrawal.bparam;
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

        public Builder withdralal_id(List<Long> list) {
            this.withdralal_id = checkForNulls(list);
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public GetWithdrawal build() {
            return new GetWithdrawal(this);
        }
    }
}
