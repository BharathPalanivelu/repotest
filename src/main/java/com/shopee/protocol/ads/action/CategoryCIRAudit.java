package com.shopee.protocol.ads.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class CategoryCIRAudit extends Message {
    public static final Integer DEFAULT_AUDIT_EVENT = 0;
    public static final Long DEFAULT_CATEGORYID = 0L;
    public static final Integer DEFAULT_CATEGORY_LEVEL = 0;
    public static final String DEFAULT_CLIENT_IP = "";
    public static final Long DEFAULT_ID = 0L;
    public static final f DEFAULT_NEW_DATA = f.f32736b;
    public static final f DEFAULT_OLD_DATA = f.f32736b;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer audit_event;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer category_level;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long categoryid;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String client_ip;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 6, type = Message.Datatype.BYTES)
    public final f new_data;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final f old_data;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long timestamp;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long userid;

    public CategoryCIRAudit(Long l, Long l2, Integer num, Integer num2, f fVar, f fVar2, Long l3, Long l4, String str) {
        this.id = l;
        this.categoryid = l2;
        this.category_level = num;
        this.audit_event = num2;
        this.old_data = fVar;
        this.new_data = fVar2;
        this.timestamp = l3;
        this.userid = l4;
        this.client_ip = str;
    }

    private CategoryCIRAudit(Builder builder) {
        this(builder.id, builder.categoryid, builder.category_level, builder.audit_event, builder.old_data, builder.new_data, builder.timestamp, builder.userid, builder.client_ip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryCIRAudit)) {
            return false;
        }
        CategoryCIRAudit categoryCIRAudit = (CategoryCIRAudit) obj;
        if (!equals((Object) this.id, (Object) categoryCIRAudit.id) || !equals((Object) this.categoryid, (Object) categoryCIRAudit.categoryid) || !equals((Object) this.category_level, (Object) categoryCIRAudit.category_level) || !equals((Object) this.audit_event, (Object) categoryCIRAudit.audit_event) || !equals((Object) this.old_data, (Object) categoryCIRAudit.old_data) || !equals((Object) this.new_data, (Object) categoryCIRAudit.new_data) || !equals((Object) this.timestamp, (Object) categoryCIRAudit.timestamp) || !equals((Object) this.userid, (Object) categoryCIRAudit.userid) || !equals((Object) this.client_ip, (Object) categoryCIRAudit.client_ip)) {
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
        Long l2 = this.categoryid;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.category_level;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.audit_event;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.old_data;
        int hashCode5 = (hashCode4 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.new_data;
        int hashCode6 = (hashCode5 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Long l3 = this.timestamp;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.userid;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str = this.client_ip;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CategoryCIRAudit> {
        public Integer audit_event;
        public Integer category_level;
        public Long categoryid;
        public String client_ip;
        public Long id;
        public f new_data;
        public f old_data;
        public Long timestamp;
        public Long userid;

        public Builder() {
        }

        public Builder(CategoryCIRAudit categoryCIRAudit) {
            super(categoryCIRAudit);
            if (categoryCIRAudit != null) {
                this.id = categoryCIRAudit.id;
                this.categoryid = categoryCIRAudit.categoryid;
                this.category_level = categoryCIRAudit.category_level;
                this.audit_event = categoryCIRAudit.audit_event;
                this.old_data = categoryCIRAudit.old_data;
                this.new_data = categoryCIRAudit.new_data;
                this.timestamp = categoryCIRAudit.timestamp;
                this.userid = categoryCIRAudit.userid;
                this.client_ip = categoryCIRAudit.client_ip;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder categoryid(Long l) {
            this.categoryid = l;
            return this;
        }

        public Builder category_level(Integer num) {
            this.category_level = num;
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

        public CategoryCIRAudit build() {
            return new CategoryCIRAudit(this);
        }
    }
}
