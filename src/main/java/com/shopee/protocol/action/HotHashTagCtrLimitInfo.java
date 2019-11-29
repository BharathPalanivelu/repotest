package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class HotHashTagCtrLimitInfo extends Message {
    public static final Integer DEFAULT_LIMIT_SEARCH_POP = 0;
    public static final Integer DEFAULT_LIMIT_SEARCH_TREND = 0;
    public static final Integer DEFAULT_LIMIT_SHOW_MANUAL = 0;
    public static final Integer DEFAULT_LIMIT_SHOW_POP = 0;
    public static final Integer DEFAULT_LIMIT_SHOW_TREND = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer limit_search_pop;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer limit_search_trend;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer limit_show_manual;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer limit_show_pop;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer limit_show_trend;

    public HotHashTagCtrLimitInfo(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.limit_show_pop = num;
        this.limit_search_pop = num2;
        this.limit_show_trend = num3;
        this.limit_search_trend = num4;
        this.limit_show_manual = num5;
    }

    private HotHashTagCtrLimitInfo(Builder builder) {
        this(builder.limit_show_pop, builder.limit_search_pop, builder.limit_show_trend, builder.limit_search_trend, builder.limit_show_manual);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotHashTagCtrLimitInfo)) {
            return false;
        }
        HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo = (HotHashTagCtrLimitInfo) obj;
        if (!equals((Object) this.limit_show_pop, (Object) hotHashTagCtrLimitInfo.limit_show_pop) || !equals((Object) this.limit_search_pop, (Object) hotHashTagCtrLimitInfo.limit_search_pop) || !equals((Object) this.limit_show_trend, (Object) hotHashTagCtrLimitInfo.limit_show_trend) || !equals((Object) this.limit_search_trend, (Object) hotHashTagCtrLimitInfo.limit_search_trend) || !equals((Object) this.limit_show_manual, (Object) hotHashTagCtrLimitInfo.limit_show_manual)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.limit_show_pop;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.limit_search_pop;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.limit_show_trend;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.limit_search_trend;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.limit_show_manual;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<HotHashTagCtrLimitInfo> {
        public Integer limit_search_pop;
        public Integer limit_search_trend;
        public Integer limit_show_manual;
        public Integer limit_show_pop;
        public Integer limit_show_trend;

        public Builder() {
        }

        public Builder(HotHashTagCtrLimitInfo hotHashTagCtrLimitInfo) {
            super(hotHashTagCtrLimitInfo);
            if (hotHashTagCtrLimitInfo != null) {
                this.limit_show_pop = hotHashTagCtrLimitInfo.limit_show_pop;
                this.limit_search_pop = hotHashTagCtrLimitInfo.limit_search_pop;
                this.limit_show_trend = hotHashTagCtrLimitInfo.limit_show_trend;
                this.limit_search_trend = hotHashTagCtrLimitInfo.limit_search_trend;
                this.limit_show_manual = hotHashTagCtrLimitInfo.limit_show_manual;
            }
        }

        public Builder limit_show_pop(Integer num) {
            this.limit_show_pop = num;
            return this;
        }

        public Builder limit_search_pop(Integer num) {
            this.limit_search_pop = num;
            return this;
        }

        public Builder limit_show_trend(Integer num) {
            this.limit_show_trend = num;
            return this;
        }

        public Builder limit_search_trend(Integer num) {
            this.limit_search_trend = num;
            return this;
        }

        public Builder limit_show_manual(Integer num) {
            this.limit_show_manual = num;
            return this;
        }

        public HotHashTagCtrLimitInfo build() {
            return new HotHashTagCtrLimitInfo(this);
        }
    }
}
