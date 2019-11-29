package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class BundleDealExtInfo extends Message {
    public static final List<Long> DEFAULT_ITEMID_LIST = Collections.emptyList();
    public static final List<MultiLangTxt> DEFAULT_LABELS = Collections.emptyList();
    public static final String DEFAULT_NAME = "";
    public static final List<Integer> DEFAULT_SHOPID_LIST = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.INT64)
    public final List<Long> itemid_list;
    @ProtoField(label = Message.Label.REPEATED, messageType = MultiLangTxt.class, tag = 2)
    public final List<MultiLangTxt> labels;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(label = Message.Label.REPEATED, tag = 4, type = Message.Datatype.INT32)
    public final List<Integer> shopid_list;

    public BundleDealExtInfo(String str, List<MultiLangTxt> list, List<Long> list2, List<Integer> list3) {
        this.name = str;
        this.labels = immutableCopyOf(list);
        this.itemid_list = immutableCopyOf(list2);
        this.shopid_list = immutableCopyOf(list3);
    }

    private BundleDealExtInfo(Builder builder) {
        this(builder.name, builder.labels, builder.itemid_list, builder.shopid_list);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BundleDealExtInfo)) {
            return false;
        }
        BundleDealExtInfo bundleDealExtInfo = (BundleDealExtInfo) obj;
        if (!equals((Object) this.name, (Object) bundleDealExtInfo.name) || !equals((List<?>) this.labels, (List<?>) bundleDealExtInfo.labels) || !equals((List<?>) this.itemid_list, (List<?>) bundleDealExtInfo.itemid_list) || !equals((List<?>) this.shopid_list, (List<?>) bundleDealExtInfo.shopid_list)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<MultiLangTxt> list = this.labels;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Long> list2 = this.itemid_list;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 1)) * 37;
        List<Integer> list3 = this.shopid_list;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BundleDealExtInfo> {
        public List<Long> itemid_list;
        public List<MultiLangTxt> labels;
        public String name;
        public List<Integer> shopid_list;

        public Builder() {
        }

        public Builder(BundleDealExtInfo bundleDealExtInfo) {
            super(bundleDealExtInfo);
            if (bundleDealExtInfo != null) {
                this.name = bundleDealExtInfo.name;
                this.labels = BundleDealExtInfo.copyOf(bundleDealExtInfo.labels);
                this.itemid_list = BundleDealExtInfo.copyOf(bundleDealExtInfo.itemid_list);
                this.shopid_list = BundleDealExtInfo.copyOf(bundleDealExtInfo.shopid_list);
            }
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder labels(List<MultiLangTxt> list) {
            this.labels = checkForNulls(list);
            return this;
        }

        public Builder itemid_list(List<Long> list) {
            this.itemid_list = checkForNulls(list);
            return this;
        }

        public Builder shopid_list(List<Integer> list) {
            this.shopid_list = checkForNulls(list);
            return this;
        }

        public BundleDealExtInfo build() {
            return new BundleDealExtInfo(this);
        }
    }
}
