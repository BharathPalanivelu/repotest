package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ShopCIRAudit extends Message {
    public static final Integer DEFAULT_AUDIT_EVENT = 0;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_NEW_DATA = f.f32736b;
    public static final f DEFAULT_OLD_DATA = f.f32736b;
    public static final Long DEFAULT_SHOPID = 0L;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer audit_event;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f new_data;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f old_data;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long userid;

    public ShopCIRAudit(Long l, Long l2, Integer num, f fVar, f fVar2, Long l3, Long l4, String str) {
        this.id = l;
        this.shopid = l2;
        this.audit_event = num;
        this.old_data = fVar;
        this.new_data = fVar2;
        this.timestamp = l3;
        this.userid = l4;
        this.client_ip = str;
    }

    private ShopCIRAudit(Builder builder) {
        this(builder.id, builder.shopid, builder.audit_event, builder.old_data, builder.new_data, builder.timestamp, builder.userid, builder.client_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ShopCIRAudit)) {
            return false;
        }
        ShopCIRAudit shopCIRAudit = (ShopCIRAudit) obj;
        if (!equals((Object) this.id, (Object) shopCIRAudit.id) || !equals((Object) this.shopid, (Object) shopCIRAudit.shopid) || !equals((Object) this.audit_event, (Object) shopCIRAudit.audit_event) || !equals((Object) this.old_data, (Object) shopCIRAudit.old_data) || !equals((Object) this.new_data, (Object) shopCIRAudit.new_data) || !equals((Object) this.timestamp, (Object) shopCIRAudit.timestamp) || !equals((Object) this.userid, (Object) shopCIRAudit.userid) || !equals((Object) this.client_ip, (Object) shopCIRAudit.client_ip)) {
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
        Long l2 = this.shopid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.audit_event;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        f fVar = this.old_data;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.new_data;
        int hashCode5 = (hashCode4 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Long l3 = this.timestamp;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.userid;
        int hashCode7 = (hashCode6 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.client_ip;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ShopCIRAudit> {
        public Integer audit_event;
        public String client_ip;
        public Long id;
        public f new_data;
        public f old_data;
        public Long shopid;
        public Long timestamp;
        public Long userid;

        public Builder() {
        }

        public Builder(ShopCIRAudit shopCIRAudit) {
            super(shopCIRAudit);
            if (shopCIRAudit != null) {
                this.id = shopCIRAudit.id;
                this.shopid = shopCIRAudit.shopid;
                this.audit_event = shopCIRAudit.audit_event;
                this.old_data = shopCIRAudit.old_data;
                this.new_data = shopCIRAudit.new_data;
                this.timestamp = shopCIRAudit.timestamp;
                this.userid = shopCIRAudit.userid;
                this.client_ip = shopCIRAudit.client_ip;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder shopid(Long l) {
            this.shopid = l;
            return this;
        }

        public Builder audit_event(Integer num) {
            this.audit_event = num;
            return this;
        }

        public Builder old_data(f fVar) {
            this.old_data = fVar;
            return this;
        }

        public Builder new_data(f fVar) {
            this.new_data = fVar;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder userid(Long l) {
            this.userid = l;
            return this;
        }

        public Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public ShopCIRAudit build() {
            return new ShopCIRAudit(this);
        }
    }
}
