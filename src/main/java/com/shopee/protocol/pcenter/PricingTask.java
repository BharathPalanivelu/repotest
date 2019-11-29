package com.shopee.protocol.pcenter;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class PricingTask extends Message {
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_OPERATOR = "";
    public static final String DEFAULT_SIGNATURE = "";
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final f DEFAULT_TASK_ITEMS = f.f32736b;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String operator;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String signature;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f task_items;

    public PricingTask(Long l, String str, String str2, f fVar, String str3, Integer num, Integer num2) {
        this.id = l;
        this.operator = str;
        this.country = str2;
        this.task_items = fVar;
        this.signature = str3;
        this.status = num;
        this.source = num2;
    }

    private PricingTask(Builder builder) {
        this(builder.id, builder.operator, builder.country, builder.task_items, builder.signature, builder.status, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PricingTask)) {
            return false;
        }
        PricingTask pricingTask = (PricingTask) obj;
        if (!equals((Object) this.id, (Object) pricingTask.id) || !equals((Object) this.operator, (Object) pricingTask.operator) || !equals((Object) this.country, (Object) pricingTask.country) || !equals((Object) this.task_items, (Object) pricingTask.task_items) || !equals((Object) this.signature, (Object) pricingTask.signature) || !equals((Object) this.status, (Object) pricingTask.status) || !equals((Object) this.source, (Object) pricingTask.source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.operator;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.task_items;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str3 = this.signature;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.status;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.source;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PricingTask> {
        public String country;
        public Long id;
        public String operator;
        public String signature;
        public Integer source;
        public Integer status;
        public f task_items;

        public Builder() {
        }

        public Builder(PricingTask pricingTask) {
            super(pricingTask);
            if (pricingTask != null) {
                this.id = pricingTask.id;
                this.operator = pricingTask.operator;
                this.country = pricingTask.country;
                this.task_items = pricingTask.task_items;
                this.signature = pricingTask.signature;
                this.status = pricingTask.status;
                this.source = pricingTask.source;
            }
        }

        public Builder id(Long l) {
            this.id = l;
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

        public Builder task_items(f fVar) {
            this.task_items = fVar;
            return this;
        }

        public Builder signature(String str) {
            this.signature = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public PricingTask build() {
            return new PricingTask(this);
        }
    }
}
