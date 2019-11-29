package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class ESAggOption extends Message {
    public static final ESAggByField DEFAULT_AGG_FIELD = ESAggByField.ItemID;
    public static final Integer DEFAULT_INTERVAL = 0;
    public static final ESAggMode DEFAULT_MODE = ESAggMode.AggByInterval;
    public static final List<ESAggSumField> DEFAULT_SUM_FIELDS = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.ENUM)
    public final ESAggByField agg_field;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer interval;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final ESAggMode mode;
    @ProtoField(enumType = ESAggSumField.class, label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.ENUM)
    public final List<ESAggSumField> sum_fields;

    public ESAggOption(ESAggMode eSAggMode, List<ESAggSumField> list, ESAggByField eSAggByField, Integer num) {
        this.mode = eSAggMode;
        this.sum_fields = immutableCopyOf(list);
        this.agg_field = eSAggByField;
        this.interval = num;
    }

    private ESAggOption(Builder builder) {
        this(builder.mode, builder.sum_fields, builder.agg_field, builder.interval);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ESAggOption)) {
            return false;
        }
        ESAggOption eSAggOption = (ESAggOption) obj;
        if (!equals((Object) this.mode, (Object) eSAggOption.mode) || !equals((List<?>) this.sum_fields, (List<?>) eSAggOption.sum_fields) || !equals((Object) this.agg_field, (Object) eSAggOption.agg_field) || !equals((Object) this.interval, (Object) eSAggOption.interval)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ESAggMode eSAggMode = this.mode;
        int i2 = 0;
        int hashCode = (eSAggMode != null ? eSAggMode.hashCode() : 0) * 37;
        List<ESAggSumField> list = this.sum_fields;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        ESAggByField eSAggByField = this.agg_field;
        int hashCode3 = (hashCode2 + (eSAggByField != null ? eSAggByField.hashCode() : 0)) * 37;
        Integer num = this.interval;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ESAggOption> {
        public ESAggByField agg_field;
        public Integer interval;
        public ESAggMode mode;
        public List<ESAggSumField> sum_fields;

        public Builder() {
        }

        public Builder(ESAggOption eSAggOption) {
            super(eSAggOption);
            if (eSAggOption != null) {
                this.mode = eSAggOption.mode;
                this.sum_fields = ESAggOption.copyOf(eSAggOption.sum_fields);
                this.agg_field = eSAggOption.agg_field;
                this.interval = eSAggOption.interval;
            }
        }

        public Builder mode(ESAggMode eSAggMode) {
            this.mode = eSAggMode;
            return this;
        }

        public Builder sum_fields(List<ESAggSumField> list) {
            this.sum_fields = checkForNulls(list);
            return this;
        }

        public Builder agg_field(ESAggByField eSAggByField) {
            this.agg_field = eSAggByField;
            return this;
        }

        public Builder interval(Integer num) {
            this.interval = num;
            return this;
        }

        public ESAggOption build() {
            return new ESAggOption(this);
        }
    }
}
