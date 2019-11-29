package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UndeleteModel extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3)
    public final BackendParam bparam;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public UndeleteModel(String str, String str2, BackendParam backendParam, Long l, Long l2) {
        this.requestid = str;
        this.token = str2;
        this.bparam = backendParam;
        this.itemid = l;
        this.modelid = l2;
    }

    private UndeleteModel(Builder builder) {
        this(builder.requestid, builder.token, builder.bparam, builder.itemid, builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UndeleteModel)) {
            return false;
        }
        UndeleteModel undeleteModel = (UndeleteModel) obj;
        if (!equals((Object) this.requestid, (Object) undeleteModel.requestid) || !equals((Object) this.token, (Object) undeleteModel.token) || !equals((Object) this.bparam, (Object) undeleteModel.bparam) || !equals((Object) this.itemid, (Object) undeleteModel.itemid) || !equals((Object) this.modelid, (Object) undeleteModel.modelid)) {
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
        int hashCode3 = (hashCode2 + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        Long l = this.itemid;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.modelid;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UndeleteModel> {
        public BackendParam bparam;
        public Long itemid;
        public Long modelid;
        public String requestid;
        public String token;

        public Builder() {
        }

        public Builder(UndeleteModel undeleteModel) {
            super(undeleteModel);
            if (undeleteModel != null) {
                this.requestid = undeleteModel.requestid;
                this.token = undeleteModel.token;
                this.bparam = undeleteModel.bparam;
                this.itemid = undeleteModel.itemid;
                this.modelid = undeleteModel.modelid;
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

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public UndeleteModel build() {
            return new UndeleteModel(this);
        }
    }
}
