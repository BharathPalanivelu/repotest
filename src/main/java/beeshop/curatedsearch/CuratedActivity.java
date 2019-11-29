package beeshop.curatedsearch;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CuratedActivity extends Message {
    public static final f DEFAULT_CONDITION = f.f32736b;
    public static final String DEFAULT_COUNTRY = "";
    public static final Long DEFAULT_CTIME = 0L;
    public static final Long DEFAULT_ID = 0L;
    public static final Long DEFAULT_MTIME = 0L;
    public static final String DEFAULT_NAME = "";
    public static final Long DEFAULT_STATUS = 0L;
    public static final Long DEFAULT_VERSION = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f condition;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long mtime;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long status;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long version;

    public CuratedActivity(Long l, String str, String str2, f fVar, Long l2, Long l3, Long l4, Long l5) {
        this.id = l;
        this.name = str;
        this.country = str2;
        this.condition = fVar;
        this.ctime = l2;
        this.mtime = l3;
        this.status = l4;
        this.version = l5;
    }

    private CuratedActivity(Builder builder) {
        this(builder.id, builder.name, builder.country, builder.condition, builder.ctime, builder.mtime, builder.status, builder.version);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CuratedActivity)) {
            return false;
        }
        CuratedActivity curatedActivity = (CuratedActivity) obj;
        if (!equals((Object) this.id, (Object) curatedActivity.id) || !equals((Object) this.name, (Object) curatedActivity.name) || !equals((Object) this.country, (Object) curatedActivity.country) || !equals((Object) this.condition, (Object) curatedActivity.condition) || !equals((Object) this.ctime, (Object) curatedActivity.ctime) || !equals((Object) this.mtime, (Object) curatedActivity.mtime) || !equals((Object) this.status, (Object) curatedActivity.status) || !equals((Object) this.version, (Object) curatedActivity.version)) {
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
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.country;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.condition;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Long l2 = this.ctime;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.mtime;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.status;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.version;
        if (l5 != null) {
            i2 = l5.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CuratedActivity> {
        public f condition;
        public String country;
        public Long ctime;
        public Long id;
        public Long mtime;
        public String name;
        public Long status;
        public Long version;

        public Builder() {
        }

        public Builder(CuratedActivity curatedActivity) {
            super(curatedActivity);
            if (curatedActivity != null) {
                this.id = curatedActivity.id;
                this.name = curatedActivity.name;
                this.country = curatedActivity.country;
                this.condition = curatedActivity.condition;
                this.ctime = curatedActivity.ctime;
                this.mtime = curatedActivity.mtime;
                this.status = curatedActivity.status;
                this.version = curatedActivity.version;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder condition(f fVar) {
            this.condition = fVar;
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

        public Builder version(Long l) {
            this.version = l;
            return this;
        }

        public CuratedActivity build() {
            return new CuratedActivity(this);
        }
    }
}
