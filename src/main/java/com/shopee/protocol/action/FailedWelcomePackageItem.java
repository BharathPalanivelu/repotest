package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class FailedWelcomePackageItem extends Message {
    public static final Long DEFAULT_ITEMID = 0L;
    public static final List<FailedWelcomePackageModel> DEFAULT_MODELS = Collections.emptyList();
    public static final Integer DEFAULT_SHOPID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(label = Message.Label.REPEATED, messageType = FailedWelcomePackageModel.class, tag = 3)
    public final List<FailedWelcomePackageModel> models;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer shopid;

    public FailedWelcomePackageItem(Integer num, Long l, List<FailedWelcomePackageModel> list) {
        this.shopid = num;
        this.itemid = l;
        this.models = immutableCopyOf(list);
    }

    private FailedWelcomePackageItem(Builder builder) {
        this(builder.shopid, builder.itemid, builder.models);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FailedWelcomePackageItem)) {
            return false;
        }
        FailedWelcomePackageItem failedWelcomePackageItem = (FailedWelcomePackageItem) obj;
        if (!equals((Object) this.shopid, (Object) failedWelcomePackageItem.shopid) || !equals((Object) this.itemid, (Object) failedWelcomePackageItem.itemid) || !equals((List<?>) this.models, (List<?>) failedWelcomePackageItem.models)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.shopid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.itemid;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        List<FailedWelcomePackageModel> list = this.models;
        int hashCode2 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<FailedWelcomePackageItem> {
        public Long itemid;
        public List<FailedWelcomePackageModel> models;
        public Integer shopid;

        public Builder() {
        }

        public Builder(FailedWelcomePackageItem failedWelcomePackageItem) {
            super(failedWelcomePackageItem);
            if (failedWelcomePackageItem != null) {
                this.shopid = failedWelcomePackageItem.shopid;
                this.itemid = failedWelcomePackageItem.itemid;
                this.models = FailedWelcomePackageItem.copyOf(failedWelcomePackageItem.models);
            }
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder models(List<FailedWelcomePackageModel> list) {
            this.models = checkForNulls(list);
            return this;
        }

        public FailedWelcomePackageItem build() {
            return new FailedWelcomePackageItem(this);
        }
    }
}
