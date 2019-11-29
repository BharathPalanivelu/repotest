package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TargetItemId extends Message {
    public static final String DEFAULT_ITEMID = "";
    public static final String DEFAULT_SHOPID = "";
    public static final Integer DEFAULT_SOURCE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String itemid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String shopid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer source;

    public TargetItemId(Integer num, String str, String str2) {
        this.source = num;
        this.itemid = str;
        this.shopid = str2;
    }

    private TargetItemId(Builder builder) {
        this(builder.source, builder.itemid, builder.shopid);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TargetItemId)) {
            return false;
        }
        TargetItemId targetItemId = (TargetItemId) obj;
        if (!equals((Object) this.source, (Object) targetItemId.source) || !equals((Object) this.itemid, (Object) targetItemId.itemid) || !equals((Object) this.shopid, (Object) targetItemId.shopid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.source;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.itemid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.shopid;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TargetItemId> {
        public String itemid;
        public String shopid;
        public Integer source;

        public Builder() {
        }

        public Builder(TargetItemId targetItemId) {
            super(targetItemId);
            if (targetItemId != null) {
                this.source = targetItemId.source;
                this.itemid = targetItemId.itemid;
                this.shopid = targetItemId.shopid;
            }
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public Builder itemid(String str) {
            this.itemid = str;
            return this;
        }

        public Builder shopid(String str) {
            this.shopid = str;
            return this;
        }

        public TargetItemId build() {
            return new TargetItemId(this);
        }
    }
}
