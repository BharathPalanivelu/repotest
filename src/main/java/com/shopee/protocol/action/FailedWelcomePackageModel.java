package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FailedWelcomePackageModel extends Message {
    public static final Long DEFAULT_MODELID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long modelid;

    public FailedWelcomePackageModel(Long l) {
        this.modelid = l;
    }

    private FailedWelcomePackageModel(Builder builder) {
        this(builder.modelid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FailedWelcomePackageModel)) {
            return false;
        }
        return equals((Object) this.modelid, (Object) ((FailedWelcomePackageModel) obj).modelid);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.modelid;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<FailedWelcomePackageModel> {
        public Long modelid;

        public Builder() {
        }

        public Builder(FailedWelcomePackageModel failedWelcomePackageModel) {
            super(failedWelcomePackageModel);
            if (failedWelcomePackageModel != null) {
                this.modelid = failedWelcomePackageModel.modelid;
            }
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public FailedWelcomePackageModel build() {
            return new FailedWelcomePackageModel(this);
        }
    }
}
