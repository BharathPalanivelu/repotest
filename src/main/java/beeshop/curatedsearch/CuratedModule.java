package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CuratedModule extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final Long DEFAULT_CTIME = 0L;
    public static final f DEFAULT_DATA = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_META = f.f32736b;
    public static final Long DEFAULT_MTIME = 0L;
    public static final Long DEFAULT_SCHEMA_ID = 0L;
    public static final Long DEFAULT_STATUS = 0L;
    public static final Long DEFAULT_VERSION = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long activity_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 8, type = Message.Datatype.BYTES)
    public final f data;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 7, type = Message.Datatype.BYTES)
    public final f meta;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long schema_id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long status;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long version;

    public CuratedModule(Long l, Long l2, Long l3, Long l4, Long l5, Long l6, f fVar, f fVar2, Long l7, f fVar3) {
        this.id = l;
        this.activity_id = l2;
        this.schema_id = l3;
        this.ctime = l4;
        this.mtime = l5;
        this.status = l6;
        this.meta = fVar;
        this.data = fVar2;
        this.version = l7;
        this.extinfo = fVar3;
    }

    private CuratedModule(Builder builder) {
        this(builder.id, builder.activity_id, builder.schema_id, builder.ctime, builder.mtime, builder.status, builder.meta, builder.data, builder.version, builder.extinfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedModule)) {
            return false;
        }
        CuratedModule curatedModule = (CuratedModule) obj;
        if (!equals((Object) this.id, (Object) curatedModule.id) || !equals((Object) this.activity_id, (Object) curatedModule.activity_id) || !equals((Object) this.schema_id, (Object) curatedModule.schema_id) || !equals((Object) this.ctime, (Object) curatedModule.ctime) || !equals((Object) this.mtime, (Object) curatedModule.mtime) || !equals((Object) this.status, (Object) curatedModule.status) || !equals((Object) this.meta, (Object) curatedModule.meta) || !equals((Object) this.data, (Object) curatedModule.data) || !equals((Object) this.version, (Object) curatedModule.version) || !equals((Object) this.extinfo, (Object) curatedModule.extinfo)) {
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
        Long l2 = this.activity_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.schema_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.ctime;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.mtime;
        int hashCode5 = (hashCode4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.status;
        int hashCode6 = (hashCode5 + (l6 != null ? l6.hashCode() : 0)) * 37;
        f fVar = this.meta;
        int hashCode7 = (hashCode6 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.data;
        int hashCode8 = (hashCode7 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Long l7 = this.version;
        int hashCode9 = (hashCode8 + (l7 != null ? l7.hashCode() : 0)) * 37;
        f fVar3 = this.extinfo;
        if (fVar3 != null) {
            i2 = fVar3.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CuratedModule> {
        public Long activity_id;
        public Long ctime;
        public f data;
        public f extinfo;
        public Long id;
        public f meta;
        public Long mtime;
        public Long schema_id;
        public Long status;
        public Long version;

        public Builder() {
        }

        public Builder(CuratedModule curatedModule) {
            super(curatedModule);
            if (curatedModule != null) {
                this.id = curatedModule.id;
                this.activity_id = curatedModule.activity_id;
                this.schema_id = curatedModule.schema_id;
                this.ctime = curatedModule.ctime;
                this.mtime = curatedModule.mtime;
                this.status = curatedModule.status;
                this.meta = curatedModule.meta;
                this.data = curatedModule.data;
                this.version = curatedModule.version;
                this.extinfo = curatedModule.extinfo;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder schema_id(Long l) {
            this.schema_id = l;
            return this;
        }

        public Builder ctime(Long l) {
            this.ctime = l;
            return this;
        }

        public Builder mtime(Long l) {
            this.mtime = l;
            return this;
        }

        public Builder status(Long l) {
            this.status = l;
            return this;
        }

        public Builder meta(f fVar) {
            this.meta = fVar;
            return this;
        }

        public Builder data(f fVar) {
            this.data = fVar;
            return this;
        }

        public Builder version(Long l) {
            this.version = l;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public CuratedModule build() {
            return new CuratedModule(this);
        }
    }
}
