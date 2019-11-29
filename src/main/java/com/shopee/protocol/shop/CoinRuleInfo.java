package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CoinRuleInfo extends Message {
    public static final List<Integer> DEFAULT_CAT_IDS = Collections.emptyList();
    public static final List<Integer> DEFAULT_COLLECTION_IDS = Collections.emptyList();
    public static final Boolean DEFAULT_DISPLAY_LABEL = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> cat_ids;
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.INT32)
    public final List<Integer> collection_ids;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean display_label;

    public CoinRuleInfo(List<Integer> list, List<Integer> list2, Boolean bool) {
        this.collection_ids = immutableCopyOf(list);
        this.cat_ids = immutableCopyOf(list2);
        this.display_label = bool;
    }

    private CoinRuleInfo(Builder builder) {
        this(builder.collection_ids, builder.cat_ids, builder.display_label);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinRuleInfo)) {
            return false;
        }
        CoinRuleInfo coinRuleInfo = (CoinRuleInfo) obj;
        if (!equals((List<?>) this.collection_ids, (List<?>) coinRuleInfo.collection_ids) || !equals((List<?>) this.cat_ids, (List<?>) coinRuleInfo.cat_ids) || !equals((Object) this.display_label, (Object) coinRuleInfo.display_label)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<Integer> list = this.collection_ids;
        int i2 = 1;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        List<Integer> list2 = this.cat_ids;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = (hashCode + i2) * 37;
        Boolean bool = this.display_label;
        int hashCode2 = i3 + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CoinRuleInfo> {
        public List<Integer> cat_ids;
        public List<Integer> collection_ids;
        public Boolean display_label;

        public Builder() {
        }

        public Builder(CoinRuleInfo coinRuleInfo) {
            super(coinRuleInfo);
            if (coinRuleInfo != null) {
                this.collection_ids = CoinRuleInfo.copyOf(coinRuleInfo.collection_ids);
                this.cat_ids = CoinRuleInfo.copyOf(coinRuleInfo.cat_ids);
                this.display_label = coinRuleInfo.display_label;
            }
        }

        public Builder collection_ids(List<Integer> list) {
            this.collection_ids = checkForNulls(list);
            return this;
        }

        public Builder cat_ids(List<Integer> list) {
            this.cat_ids = checkForNulls(list);
            return this;
        }

        public Builder display_label(Boolean bool) {
            this.display_label = bool;
            return this;
        }

        public CoinRuleInfo build() {
            return new CoinRuleInfo(this);
        }
    }
}
