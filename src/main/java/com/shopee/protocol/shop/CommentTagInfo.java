package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CommentTagInfo extends Message {
    public static final Long DEFAULT_INFOID = 0L;
    public static final Integer DEFAULT_LENGTH = 0;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long infoid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer length;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    public CommentTagInfo(Integer num, Integer num2, Long l, Integer num3) {
        this.offset = num;
        this.length = num2;
        this.infoid = l;
        this.type = num3;
    }

    private CommentTagInfo(Builder builder) {
        this(builder.offset, builder.length, builder.infoid, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommentTagInfo)) {
            return false;
        }
        CommentTagInfo commentTagInfo = (CommentTagInfo) obj;
        if (!equals((Object) this.offset, (Object) commentTagInfo.offset) || !equals((Object) this.length, (Object) commentTagInfo.length) || !equals((Object) this.infoid, (Object) commentTagInfo.infoid) || !equals((Object) this.type, (Object) commentTagInfo.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.offset;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.length;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.infoid;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.type;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CommentTagInfo> {
        public Long infoid;
        public Integer length;
        public Integer offset;
        public Integer type;

        public Builder() {
        }

        public Builder(CommentTagInfo commentTagInfo) {
            super(commentTagInfo);
            if (commentTagInfo != null) {
                this.offset = commentTagInfo.offset;
                this.length = commentTagInfo.length;
                this.infoid = commentTagInfo.infoid;
                this.type = commentTagInfo.type;
            }
        }

        public Builder offset(Integer num) {
            this.offset = num;
            return this;
        }

        public Builder length(Integer num) {
            this.length = num;
            return this;
        }

        public Builder infoid(Long l) {
            this.infoid = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public CommentTagInfo build() {
            return new CommentTagInfo(this);
        }
    }
}
