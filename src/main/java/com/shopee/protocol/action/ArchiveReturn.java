package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ArchiveReturn extends Message {
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final String DEFAULT_REQUESTID = "";
    public static final Long DEFAULT_RETURN_ID = 0L;
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long return_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String token;

    public ArchiveReturn(String str, Long l, Boolean bool, Integer num, String str2) {
        this.requestid = str;
        this.return_id = l;
        this.is_seller = bool;
        this.archive = num;
        this.token = str2;
    }

    private ArchiveReturn(Builder builder) {
        this(builder.requestid, builder.return_id, builder.is_seller, builder.archive, builder.token);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArchiveReturn)) {
            return false;
        }
        ArchiveReturn archiveReturn = (ArchiveReturn) obj;
        if (!equals((Object) this.requestid, (Object) archiveReturn.requestid) || !equals((Object) this.return_id, (Object) archiveReturn.return_id) || !equals((Object) this.is_seller, (Object) archiveReturn.is_seller) || !equals((Object) this.archive, (Object) archiveReturn.archive) || !equals((Object) this.token, (Object) archiveReturn.token)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.return_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.is_seller;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.archive;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.token;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ArchiveReturn> {
        public Integer archive;
        public Boolean is_seller;
        public String requestid;
        public Long return_id;
        public String token;

        public Builder() {
        }

        public Builder(ArchiveReturn archiveReturn) {
            super(archiveReturn);
            if (archiveReturn != null) {
                this.requestid = archiveReturn.requestid;
                this.return_id = archiveReturn.return_id;
                this.is_seller = archiveReturn.is_seller;
                this.archive = archiveReturn.archive;
                this.token = archiveReturn.token;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder return_id(Long l) {
            this.return_id = l;
            return this;
        }

        public Builder is_seller(Boolean bool) {
            this.is_seller = bool;
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public ArchiveReturn build() {
            return new ArchiveReturn(this);
        }
    }
}
