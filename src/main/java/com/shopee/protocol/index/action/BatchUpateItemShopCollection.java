package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class BatchUpateItemShopCollection extends Message {
    public static final List<UpdateItemShopCollection> DEFAULT_ITEMS = Collections.emptyList();
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final String DEFAULT_SOURCE = "";
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = UpdateItemShopCollection.class, tag = 2)
    public final List<UpdateItemShopCollection> items;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String source;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public BatchUpateItemShopCollection(Integer num, List<UpdateItemShopCollection> list, String str, f fVar) {
        this.type = num;
        this.items = immutableCopyOf(list);
        this.source = str;
        this.raw_ctx = fVar;
    }

    private BatchUpateItemShopCollection(Builder builder) {
        this(builder.type, builder.items, builder.source, builder.raw_ctx);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchUpateItemShopCollection)) {
            return false;
        }
        BatchUpateItemShopCollection batchUpateItemShopCollection = (BatchUpateItemShopCollection) obj;
        if (!equals((Object) this.type, (Object) batchUpateItemShopCollection.type) || !equals((List<?>) this.items, (List<?>) batchUpateItemShopCollection.items) || !equals((Object) this.source, (Object) batchUpateItemShopCollection.source) || !equals((Object) this.raw_ctx, (Object) batchUpateItemShopCollection.raw_ctx)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<UpdateItemShopCollection> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.source;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.raw_ctx;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BatchUpateItemShopCollection> {
        public List<UpdateItemShopCollection> items;
        public f raw_ctx;
        public String source;
        public Integer type;

        public Builder() {
        }

        public Builder(BatchUpateItemShopCollection batchUpateItemShopCollection) {
            super(batchUpateItemShopCollection);
            if (batchUpateItemShopCollection != null) {
                this.type = batchUpateItemShopCollection.type;
                this.items = BatchUpateItemShopCollection.copyOf(batchUpateItemShopCollection.items);
                this.source = batchUpateItemShopCollection.source;
                this.raw_ctx = batchUpateItemShopCollection.raw_ctx;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder items(List<UpdateItemShopCollection> list) {
            this.items = checkForNulls(list);
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public BatchUpateItemShopCollection build() {
            return new BatchUpateItemShopCollection(this);
        }
    }
}
