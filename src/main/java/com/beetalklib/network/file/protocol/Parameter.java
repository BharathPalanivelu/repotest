package com.beetalklib.network.file.protocol;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class Parameter extends Message {
    public static final Long DEFAULT_CS = 0L;
    public static final Long DEFAULT_FROM = 0L;
    public static final Integer DEFAULT_INDEX = 0;
    public static final f DEFAULT_REQUESTID = f.f32736b;
    public static final Boolean DEFAULT_THUMB = false;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long cs;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long from;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer index;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f requestId;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean thumb;

    public Parameter(Long l, Long l2, f fVar, Integer num, Boolean bool) {
        this.cs = l;
        this.from = l2;
        this.requestId = fVar;
        this.index = num;
        this.thumb = bool;
    }

    private Parameter(Builder builder) {
        this(builder.cs, builder.from, builder.requestId, builder.index, builder.thumb);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        if (!equals((Object) this.cs, (Object) parameter.cs) || !equals((Object) this.from, (Object) parameter.from) || !equals((Object) this.requestId, (Object) parameter.requestId) || !equals((Object) this.index, (Object) parameter.index) || !equals((Object) this.thumb, (Object) parameter.thumb)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.cs;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.from;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        f fVar = this.requestId;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num = this.index;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.thumb;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Parameter> {
        public Long cs;
        public Long from;
        public Integer index;
        public f requestId;
        public Boolean thumb;

        public Builder() {
        }

        public Builder(Parameter parameter) {
            super(parameter);
            if (parameter != null) {
                this.cs = parameter.cs;
                this.from = parameter.from;
                this.requestId = parameter.requestId;
                this.index = parameter.index;
                this.thumb = parameter.thumb;
            }
        }

        public Builder cs(Long l) {
            this.cs = l;
            return this;
        }

        public Builder from(Long l) {
            this.from = l;
            return this;
        }

        public Builder requestId(f fVar) {
            this.requestId = fVar;
            return this;
        }

        public Builder index(Integer num) {
            this.index = num;
            return this;
        }

        public Builder thumb(Boolean bool) {
            this.thumb = bool;
            return this;
        }

        public Parameter build() {
            checkRequiredFields();
            return new Parameter(this);
        }
    }
}
