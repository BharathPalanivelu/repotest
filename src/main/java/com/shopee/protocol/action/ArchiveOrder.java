package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ArchiveOrder extends Message {
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Boolean DEFAULT_IS_SELLER = false;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 3, type = Message.Datatype.BOOL)
    public final Boolean is_seller;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public ArchiveOrder(String str, Long l, Boolean bool, Integer num) {
        this.requestid = str;
        this.orderid = l;
        this.is_seller = bool;
        this.archive = num;
    }

    private ArchiveOrder(Builder builder) {
        this(builder.requestid, builder.orderid, builder.is_seller, builder.archive);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArchiveOrder)) {
            return false;
        }
        ArchiveOrder archiveOrder = (ArchiveOrder) obj;
        if (!equals((Object) this.requestid, (Object) archiveOrder.requestid) || !equals((Object) this.orderid, (Object) archiveOrder.orderid) || !equals((Object) this.is_seller, (Object) archiveOrder.is_seller) || !equals((Object) this.archive, (Object) archiveOrder.archive)) {
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
        Long l = this.orderid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.is_seller;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.archive;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ArchiveOrder> {
        public Integer archive;
        public Boolean is_seller;
        public Long orderid;
        public String requestid;

        public Builder() {
        }

        public Builder(ArchiveOrder archiveOrder) {
            super(archiveOrder);
            if (archiveOrder != null) {
                this.requestid = archiveOrder.requestid;
                this.orderid = archiveOrder.orderid;
                this.is_seller = archiveOrder.is_seller;
                this.archive = archiveOrder.archive;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
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

        public ArchiveOrder build() {
            return new ArchiveOrder(this);
        }
    }
}
