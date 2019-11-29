package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BatchSetItemFlag extends Message {
    public static final List<ItemFlag> DEFAULT_ITEMFLAGS = Collections.emptyList();
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REPEATED, messageType = ItemFlag.class, tag = 3)
    public final List<ItemFlag> itemflags;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public BatchSetItemFlag(String str, BackendParam backendParam, List<ItemFlag> list) {
        this.requestid = str;
        this.bparam = backendParam;
        this.itemflags = immutableCopyOf(list);
    }

    private BatchSetItemFlag(Builder builder) {
        this(builder.requestid, builder.bparam, builder.itemflags);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchSetItemFlag)) {
            return false;
        }
        BatchSetItemFlag batchSetItemFlag = (BatchSetItemFlag) obj;
        if (!equals((Object) this.requestid, (Object) batchSetItemFlag.requestid) || !equals((Object) this.bparam, (Object) batchSetItemFlag.bparam) || !equals((List<?>) this.itemflags, (List<?>) batchSetItemFlag.itemflags)) {
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
        BackendParam backendParam = this.bparam;
        if (backendParam != null) {
            i2 = backendParam.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<ItemFlag> list = this.itemflags;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<BatchSetItemFlag> {
        public BackendParam bparam;
        public List<ItemFlag> itemflags;
        public String requestid;

        public Builder() {
        }

        public Builder(BatchSetItemFlag batchSetItemFlag) {
            super(batchSetItemFlag);
            if (batchSetItemFlag != null) {
                this.requestid = batchSetItemFlag.requestid;
                this.bparam = batchSetItemFlag.bparam;
                this.itemflags = BatchSetItemFlag.copyOf(batchSetItemFlag.itemflags);
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder itemflags(List<ItemFlag> list) {
            this.itemflags = checkForNulls(list);
            return this;
        }

        public BatchSetItemFlag build() {
            return new BatchSetItemFlag(this);
        }
    }
}
