package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CategoryExtInfo extends Message {
    public static final List<Integer> DEFAULT_BLOCK_BUYER_PLATFORM = Collections.emptyList();
    public static final Boolean DEFAULT_BLOCK_CB = false;
    public static final List<Long> DEFAULT_DEFAULT_ATTRID = Collections.emptyList();
    public static final Boolean DEFAULT_ENABLE_SIZE_CHART = false;
    public static final Integer DEFAULT_FREE_RETURN_DAY = 0;
    public static final Boolean DEFAULT_IS_3C = false;
    public static final Integer DEFAULT_LOW_STOCK_VALUE = 0;
    public static final List<CategoryNameInfo> DEFAULT_NAMES = Collections.emptyList();
    public static final Boolean DEFAULT_PLACEHOLDER = false;
    public static final List<Integer> DEFAULT_RETURN_REASON_BL_AFTER_FRD = Collections.emptyList();
    public static final List<Integer> DEFAULT_RETURN_REASON_BL_BEFORE_FRD = Collections.emptyList();
    public static final Integer DEFAULT_RETURN_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 12, type = Message.Datatype.INT32)
    public final List<Integer> block_buyer_platform;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean block_cb;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT64)
    public final List<Long> default_attrid;
    @ProtoField(tag = 10, type = Message.Datatype.BOOL)
    public final Boolean enable_size_chart;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer free_return_day;
    @ProtoField(tag = 9, type = Message.Datatype.BOOL)
    public final Boolean is_3c;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer low_stock_value;
    @ProtoField(label = Message.Label.REPEATED, messageType = CategoryNameInfo.class, tag = 1)
    public final List<CategoryNameInfo> names;
    @ProtoField(tag = 8, type = Message.Datatype.BOOL)
    public final Boolean placeholder;
    @ProtoField(label = Message.Label.REPEATED, tag = 6, type = Message.Datatype.INT32)
    public final List<Integer> return_reason_bl_after_frd;
    @ProtoField(label = Message.Label.REPEATED, tag = 5, type = Message.Datatype.INT32)
    public final List<Integer> return_reason_bl_before_frd;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer return_type;

    public CategoryExtInfo(List<CategoryNameInfo> list, List<Long> list2, Integer num, Integer num2, List<Integer> list3, List<Integer> list4, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num3, List<Integer> list5) {
        this.names = immutableCopyOf(list);
        this.default_attrid = immutableCopyOf(list2);
        this.return_type = num;
        this.free_return_day = num2;
        this.return_reason_bl_before_frd = immutableCopyOf(list3);
        this.return_reason_bl_after_frd = immutableCopyOf(list4);
        this.block_cb = bool;
        this.placeholder = bool2;
        this.is_3c = bool3;
        this.enable_size_chart = bool4;
        this.low_stock_value = num3;
        this.block_buyer_platform = immutableCopyOf(list5);
    }

    private CategoryExtInfo(Builder builder) {
        this(builder.names, builder.default_attrid, builder.return_type, builder.free_return_day, builder.return_reason_bl_before_frd, builder.return_reason_bl_after_frd, builder.block_cb, builder.placeholder, builder.is_3c, builder.enable_size_chart, builder.low_stock_value, builder.block_buyer_platform);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryExtInfo)) {
            return false;
        }
        CategoryExtInfo categoryExtInfo = (CategoryExtInfo) obj;
        if (!equals((List<?>) this.names, (List<?>) categoryExtInfo.names) || !equals((List<?>) this.default_attrid, (List<?>) categoryExtInfo.default_attrid) || !equals((Object) this.return_type, (Object) categoryExtInfo.return_type) || !equals((Object) this.free_return_day, (Object) categoryExtInfo.free_return_day) || !equals((List<?>) this.return_reason_bl_before_frd, (List<?>) categoryExtInfo.return_reason_bl_before_frd) || !equals((List<?>) this.return_reason_bl_after_frd, (List<?>) categoryExtInfo.return_reason_bl_after_frd) || !equals((Object) this.block_cb, (Object) categoryExtInfo.block_cb) || !equals((Object) this.placeholder, (Object) categoryExtInfo.placeholder) || !equals((Object) this.is_3c, (Object) categoryExtInfo.is_3c) || !equals((Object) this.enable_size_chart, (Object) categoryExtInfo.enable_size_chart) || !equals((Object) this.low_stock_value, (Object) categoryExtInfo.low_stock_value) || !equals((List<?>) this.block_buyer_platform, (List<?>) categoryExtInfo.block_buyer_platform)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<CategoryNameInfo> list = this.names;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Long> list2 = this.default_attrid;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num = this.return_type;
        int i3 = 0;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.free_return_day;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        List<Integer> list3 = this.return_reason_bl_before_frd;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 1)) * 37;
        List<Integer> list4 = this.return_reason_bl_after_frd;
        int hashCode6 = (hashCode5 + (list4 != null ? list4.hashCode() : 1)) * 37;
        Boolean bool = this.block_cb;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.placeholder;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.is_3c;
        int hashCode9 = (hashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.enable_size_chart;
        int hashCode10 = (hashCode9 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num3 = this.low_stock_value;
        if (num3 != null) {
            i3 = num3.hashCode();
        }
        int i4 = (hashCode10 + i3) * 37;
        List<Integer> list5 = this.block_buyer_platform;
        if (list5 != null) {
            i2 = list5.hashCode();
        }
        int i5 = i4 + i2;
        this.hashCode = i5;
        return i5;
    }

    public static final class Builder extends Message.Builder<CategoryExtInfo> {
        public List<Integer> block_buyer_platform;
        public Boolean block_cb;
        public List<Long> default_attrid;
        public Boolean enable_size_chart;
        public Integer free_return_day;
        public Boolean is_3c;
        public Integer low_stock_value;
        public List<CategoryNameInfo> names;
        public Boolean placeholder;
        public List<Integer> return_reason_bl_after_frd;
        public List<Integer> return_reason_bl_before_frd;
        public Integer return_type;

        public Builder() {
        }

        public Builder(CategoryExtInfo categoryExtInfo) {
            super(categoryExtInfo);
            if (categoryExtInfo != null) {
                this.names = CategoryExtInfo.copyOf(categoryExtInfo.names);
                this.default_attrid = CategoryExtInfo.copyOf(categoryExtInfo.default_attrid);
                this.return_type = categoryExtInfo.return_type;
                this.free_return_day = categoryExtInfo.free_return_day;
                this.return_reason_bl_before_frd = CategoryExtInfo.copyOf(categoryExtInfo.return_reason_bl_before_frd);
                this.return_reason_bl_after_frd = CategoryExtInfo.copyOf(categoryExtInfo.return_reason_bl_after_frd);
                this.block_cb = categoryExtInfo.block_cb;
                this.placeholder = categoryExtInfo.placeholder;
                this.is_3c = categoryExtInfo.is_3c;
                this.enable_size_chart = categoryExtInfo.enable_size_chart;
                this.low_stock_value = categoryExtInfo.low_stock_value;
                this.block_buyer_platform = CategoryExtInfo.copyOf(categoryExtInfo.block_buyer_platform);
            }
        }

        public Builder names(List<CategoryNameInfo> list) {
            this.names = checkForNulls(list);
            return this;
        }

        public Builder default_attrid(List<Long> list) {
            this.default_attrid = checkForNulls(list);
            return this;
        }

        public Builder return_type(Integer num) {
            this.return_type = num;
            return this;
        }

        public Builder free_return_day(Integer num) {
            this.free_return_day = num;
            return this;
        }

        public Builder return_reason_bl_before_frd(List<Integer> list) {
            this.return_reason_bl_before_frd = checkForNulls(list);
            return this;
        }

        public Builder return_reason_bl_after_frd(List<Integer> list) {
            this.return_reason_bl_after_frd = checkForNulls(list);
            return this;
        }

        public Builder block_cb(Boolean bool) {
            this.block_cb = bool;
            return this;
        }

        public Builder placeholder(Boolean bool) {
            this.placeholder = bool;
            return this;
        }

        public Builder is_3c(Boolean bool) {
            this.is_3c = bool;
            return this;
        }

        public Builder enable_size_chart(Boolean bool) {
            this.enable_size_chart = bool;
            return this;
        }

        public Builder low_stock_value(Integer num) {
            this.low_stock_value = num;
            return this;
        }

        public Builder block_buyer_platform(List<Integer> list) {
            this.block_buyer_platform = checkForNulls(list);
            return this;
        }

        public CategoryExtInfo build() {
            return new CategoryExtInfo(this);
        }
    }
}
