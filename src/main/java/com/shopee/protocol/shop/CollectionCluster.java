package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CollectionCluster extends Message {
    public static final String DEFAULT_CLUSTER_ID = "";
    public static final Integer DEFAULT_COLLECTION_ID = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_SOURCE = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String cluster_id;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer collection_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer source;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer status;

    public CollectionCluster(Integer num, String str, Integer num2, Integer num3, Integer num4, f fVar, Integer num5) {
        this.collection_id = num;
        this.cluster_id = str;
        this.status = num2;
        this.mtime = num3;
        this.ctime = num4;
        this.extinfo = fVar;
        this.source = num5;
    }

    private CollectionCluster(Builder builder) {
        this(builder.collection_id, builder.cluster_id, builder.status, builder.mtime, builder.ctime, builder.extinfo, builder.source);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CollectionCluster)) {
            return false;
        }
        CollectionCluster collectionCluster = (CollectionCluster) obj;
        if (!equals((Object) this.collection_id, (Object) collectionCluster.collection_id) || !equals((Object) this.cluster_id, (Object) collectionCluster.cluster_id) || !equals((Object) this.status, (Object) collectionCluster.status) || !equals((Object) this.mtime, (Object) collectionCluster.mtime) || !equals((Object) this.ctime, (Object) collectionCluster.ctime) || !equals((Object) this.extinfo, (Object) collectionCluster.extinfo) || !equals((Object) this.source, (Object) collectionCluster.source)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.collection_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.cluster_id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.status;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode6 = (hashCode5 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num5 = this.source;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CollectionCluster> {
        public String cluster_id;
        public Integer collection_id;
        public Integer ctime;
        public f extinfo;
        public Integer mtime;
        public Integer source;
        public Integer status;

        public Builder() {
        }

        public Builder(CollectionCluster collectionCluster) {
            super(collectionCluster);
            if (collectionCluster != null) {
                this.collection_id = collectionCluster.collection_id;
                this.cluster_id = collectionCluster.cluster_id;
                this.status = collectionCluster.status;
                this.mtime = collectionCluster.mtime;
                this.ctime = collectionCluster.ctime;
                this.extinfo = collectionCluster.extinfo;
                this.source = collectionCluster.source;
            }
        }

        public Builder collection_id(Integer num) {
            this.collection_id = num;
            return this;
        }

        public Builder cluster_id(String str) {
            this.cluster_id = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder source(Integer num) {
            this.source = num;
            return this;
        }

        public CollectionCluster build() {
            return new CollectionCluster(this);
        }
    }
}
