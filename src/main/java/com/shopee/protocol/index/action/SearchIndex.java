package com.shopee.protocol.index.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class SearchIndex extends Message {
    public static final Integer DEFAULT_CMD = 0;
    public static final String DEFAULT_COUNTRY = "";
    public static final Boolean DEFAULT_FORCE_UPDATE = false;
    public static final f DEFAULT_NEW = f.f32736b;
    public static final f DEFAULT_OLD = f.f32736b;
    public static final String DEFAULT_PARTITIONID = "";
    public static final f DEFAULT_RAW_CTX = f.f32736b;
    public static final String DEFAULT_SUB_PARTITIONID = "";
    public static final Integer DEFAULT_SUB_TYPE = 0;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f _new;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 12)
    public final SearchIndexExtInfo extinfo;
    @ProtoField(tag = 6, type = Message.Datatype.BOOL)
    public final Boolean force_update;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f old;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String partitionid;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f raw_ctx;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String sub_partitionid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer sub_type;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public SearchIndex(String str, Integer num, Integer num2, f fVar, f fVar2, Boolean bool, Long l, f fVar3, String str2, Integer num3, String str3, SearchIndexExtInfo searchIndexExtInfo) {
        this.partitionid = str;
        this.type = num;
        this.cmd = num2;
        this.old = fVar;
        this._new = fVar2;
        this.force_update = bool;
        this.timestamp = l;
        this.raw_ctx = fVar3;
        this.country = str2;
        this.sub_type = num3;
        this.sub_partitionid = str3;
        this.extinfo = searchIndexExtInfo;
    }

    private SearchIndex(Builder builder) {
        this(builder.partitionid, builder.type, builder.cmd, builder.old, builder._new, builder.force_update, builder.timestamp, builder.raw_ctx, builder.country, builder.sub_type, builder.sub_partitionid, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchIndex)) {
            return false;
        }
        SearchIndex searchIndex = (SearchIndex) obj;
        if (!equals((Object) this.partitionid, (Object) searchIndex.partitionid) || !equals((Object) this.type, (Object) searchIndex.type) || !equals((Object) this.cmd, (Object) searchIndex.cmd) || !equals((Object) this.old, (Object) searchIndex.old) || !equals((Object) this._new, (Object) searchIndex._new) || !equals((Object) this.force_update, (Object) searchIndex.force_update) || !equals((Object) this.timestamp, (Object) searchIndex.timestamp) || !equals((Object) this.raw_ctx, (Object) searchIndex.raw_ctx) || !equals((Object) this.country, (Object) searchIndex.country) || !equals((Object) this.sub_type, (Object) searchIndex.sub_type) || !equals((Object) this.sub_partitionid, (Object) searchIndex.sub_partitionid) || !equals((Object) this.extinfo, (Object) searchIndex.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.partitionid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.cmd;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.old;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this._new;
        int hashCode5 = (hashCode4 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Boolean bool = this.force_update;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 37;
        f fVar3 = this.raw_ctx;
        int hashCode8 = (hashCode7 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.sub_type;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str3 = this.sub_partitionid;
        int hashCode11 = (hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 37;
        SearchIndexExtInfo searchIndexExtInfo = this.extinfo;
        if (searchIndexExtInfo != null) {
            i2 = searchIndexExtInfo.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SearchIndex> {
        public f _new;
        public Integer cmd;
        public String country;
        public SearchIndexExtInfo extinfo;
        public Boolean force_update;
        public f old;
        public String partitionid;
        public f raw_ctx;
        public String sub_partitionid;
        public Integer sub_type;
        public Long timestamp;
        public Integer type;

        public Builder() {
        }

        public Builder(SearchIndex searchIndex) {
            super(searchIndex);
            if (searchIndex != null) {
                this.partitionid = searchIndex.partitionid;
                this.type = searchIndex.type;
                this.cmd = searchIndex.cmd;
                this.old = searchIndex.old;
                this._new = searchIndex._new;
                this.force_update = searchIndex.force_update;
                this.timestamp = searchIndex.timestamp;
                this.raw_ctx = searchIndex.raw_ctx;
                this.country = searchIndex.country;
                this.sub_type = searchIndex.sub_type;
                this.sub_partitionid = searchIndex.sub_partitionid;
                this.extinfo = searchIndex.extinfo;
            }
        }

        public Builder partitionid(String str) {
            this.partitionid = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder cmd(Integer num) {
            this.cmd = num;
            return this;
        }

        public Builder old(f fVar) {
            this.old = fVar;
            return this;
        }

        public Builder _new(f fVar) {
            this._new = fVar;
            return this;
        }

        public Builder force_update(Boolean bool) {
            this.force_update = bool;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder raw_ctx(f fVar) {
            this.raw_ctx = fVar;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder sub_type(Integer num) {
            this.sub_type = num;
            return this;
        }

        public Builder sub_partitionid(String str) {
            this.sub_partitionid = str;
            return this;
        }

        public Builder extinfo(SearchIndexExtInfo searchIndexExtInfo) {
            this.extinfo = searchIndexExtInfo;
            return this;
        }

        public SearchIndex build() {
            return new SearchIndex(this);
        }
    }
}
