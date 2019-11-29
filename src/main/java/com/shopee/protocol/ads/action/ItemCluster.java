package com.shopee.protocol.ads.action;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

public final class ItemCluster extends Message {
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final String DEFAULT_FROM = "";
    public static final String DEFAULT_ITEM_ID = "";
    public static final Float DEFAULT_SCORE = Float.valueOf(BitmapDescriptorFactory.HUE_RED);
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cluster_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String from;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String item_id;
    @ProtoField(tag = 3, type = Message.Datatype.FLOAT)
    public final Float score;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public ItemCluster(Integer num, String str, Float f2, String str2, String str3) {
        this.type = num;
        this.cluster_id = str;
        this.score = f2;
        this.item_id = str2;
        this.from = str3;
    }

    private ItemCluster(Builder builder) {
        this(builder.type, builder.cluster_id, builder.score, builder.item_id, builder.from);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemCluster)) {
            return false;
        }
        ItemCluster itemCluster = (ItemCluster) obj;
        if (!equals((Object) this.type, (Object) itemCluster.type) || !equals((Object) this.cluster_id, (Object) itemCluster.cluster_id) || !equals((Object) this.score, (Object) itemCluster.score) || !equals((Object) this.item_id, (Object) itemCluster.item_id) || !equals((Object) this.from, (Object) itemCluster.from)) {
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
        String str = this.cluster_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Float f2 = this.score;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        String str2 = this.item_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.from;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ItemCluster> {
        public String cluster_id;
        public String from;
        public String item_id;
        public Float score;
        public Integer type;

        public Builder() {
        }

        public Builder(ItemCluster itemCluster) {
            super(itemCluster);
            if (itemCluster != null) {
                this.type = itemCluster.type;
                this.cluster_id = itemCluster.cluster_id;
                this.score = itemCluster.score;
                this.item_id = itemCluster.item_id;
                this.from = itemCluster.from;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder cluster_id(String str) {
            this.cluster_id = str;
            return this;
        }

        public Builder score(Float f2) {
            this.score = f2;
            return this;
        }

        public Builder item_id(String str) {
            this.item_id = str;
            return this;
        }

        public Builder from(String str) {
            this.from = str;
            return this;
        }

        public ItemCluster build() {
            return new ItemCluster(this);
        }
    }

    public enum LevelType implements ProtoEnum {
        L0(0),
        L1(1);
        
        private final int value;

        private LevelType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
