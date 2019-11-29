package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AuditItem extends Message {
    public static final Integer DEFAULT_ACTION = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer action;
    @ProtoField(tag = 5)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;

    public AuditItem(String str, Long l, Integer num, Integer num2, BackendParam backendParam) {
        this.requestid = str;
        this.itemid = l;
        this.shopid = num;
        this.action = num2;
        this.bparam = backendParam;
    }

    private AuditItem(Builder builder) {
        this(builder.requestid, builder.itemid, builder.shopid, builder.action, builder.bparam);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuditItem)) {
            return false;
        }
        AuditItem auditItem = (AuditItem) obj;
        if (!equals((Object) this.requestid, (Object) auditItem.requestid) || !equals((Object) this.itemid, (Object) auditItem.itemid) || !equals((Object) this.shopid, (Object) auditItem.shopid) || !equals((Object) this.action, (Object) auditItem.action) || !equals((Object) this.bparam, (Object) auditItem.bparam)) {
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
        Long l = this.itemid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.shopid;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.action;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AuditItem> {
        public Integer action;
        public BackendParam bparam;
        public Long itemid;
        public String requestid;
        public Integer shopid;

        public Builder() {
        }

        public Builder(AuditItem auditItem) {
            super(auditItem);
            if (auditItem != null) {
                this.requestid = auditItem.requestid;
                this.itemid = auditItem.itemid;
                this.shopid = auditItem.shopid;
                this.action = auditItem.action;
                this.bparam = auditItem.bparam;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder action(Integer num) {
            this.action = num;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public AuditItem build() {
            checkRequiredFields();
            return new AuditItem(this);
        }
    }
}
