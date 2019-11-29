package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Pagination extends Message {
    public static final Long DEFAULT_CURRENT_OFFSET = 0L;
    public static final Integer DEFAULT_PAGE_SIZE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long current_offset;
    @ProtoField(tag = 1, type = Message.Datatype.UINT32)
    public final Integer page_size;

    public Pagination(Integer num, Long l) {
        this.page_size = num;
        this.current_offset = l;
    }

    private Pagination(Builder builder) {
        this(builder.page_size, builder.current_offset);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pagination)) {
            return false;
        }
        Pagination pagination = (Pagination) obj;
        if (!equals((Object) this.page_size, (Object) pagination.page_size) || !equals((Object) this.current_offset, (Object) pagination.current_offset)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.page_size;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.current_offset;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Pagination> {
        public Long current_offset;
        public Integer page_size;

        public Builder() {
        }

        public Builder(Pagination pagination) {
            super(pagination);
            if (pagination != null) {
                this.page_size = pagination.page_size;
                this.current_offset = pagination.current_offset;
            }
        }

        public Builder page_size(Integer num) {
            this.page_size = num;
            return this;
        }

        public Builder current_offset(Long l) {
            this.current_offset = l;
            return this;
        }

        public Pagination build() {
            return new Pagination(this);
        }
    }
}
