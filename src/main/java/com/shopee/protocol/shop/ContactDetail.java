package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ContactDetail extends Message {
    public static final String DEFAULT_ACCOUNT = "";
    public static final Integer DEFAULT_ACCTYPE = 0;
    public static final Integer DEFAULT_ACC_SHOPID = 0;
    public static final Integer DEFAULT_ACC_USERID = 0;
    public static final String DEFAULT_DATA_HASH_ID = "";
    public static final f DEFAULT_DEVICEID = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final f DEFAULT_HASHED_FINGERPRINT = f.f32736b;
    public static final Long DEFAULT_ID = 0L;
    public static final String DEFAULT_ITEMID = "";
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_PLATFORM_TYPE = 0;
    public static final Integer DEFAULT_REPORT_TIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer acc_shopid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer acc_userid;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String account;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer acctype;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String data_hash_id;
    @ProtoField(tag = 9, type = Message.Datatype.BYTES)
    public final f deviceid;
    @ProtoField(tag = 12, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 10, type = Message.Datatype.BYTES)
    public final f hashed_fingerprint;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String itemid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer platform_type;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer report_time;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ContactDetail(Long l, Integer num, String str, Integer num2, Integer num3, Integer num4, Integer num5, String str2, f fVar, f fVar2, Integer num6, f fVar3, String str3, String str4, Integer num7) {
        this.id = l;
        this.userid = num;
        this.account = str;
        this.acctype = num2;
        this.acc_userid = num3;
        this.acc_shopid = num4;
        this.status = num5;
        this.name = str2;
        this.deviceid = fVar;
        this.hashed_fingerprint = fVar2;
        this.report_time = num6;
        this.extinfo = fVar3;
        this.itemid = str3;
        this.data_hash_id = str4;
        this.platform_type = num7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ContactDetail(com.shopee.protocol.shop.ContactDetail.Builder r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.Long r2 = r0.id
            java.lang.Integer r3 = r0.userid
            java.lang.String r4 = r0.account
            java.lang.Integer r5 = r0.acctype
            java.lang.Integer r6 = r0.acc_userid
            java.lang.Integer r7 = r0.acc_shopid
            java.lang.Integer r8 = r0.status
            java.lang.String r9 = r0.name
            e.f r10 = r0.deviceid
            e.f r11 = r0.hashed_fingerprint
            java.lang.Integer r12 = r0.report_time
            e.f r13 = r0.extinfo
            java.lang.String r14 = r0.itemid
            java.lang.String r15 = r0.data_hash_id
            java.lang.Integer r1 = r0.platform_type
            r16 = r1
            r1 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r17.setBuilder(r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.ContactDetail.<init>(com.shopee.protocol.shop.ContactDetail$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContactDetail)) {
            return false;
        }
        ContactDetail contactDetail = (ContactDetail) obj;
        if (!equals((Object) this.id, (Object) contactDetail.id) || !equals((Object) this.userid, (Object) contactDetail.userid) || !equals((Object) this.account, (Object) contactDetail.account) || !equals((Object) this.acctype, (Object) contactDetail.acctype) || !equals((Object) this.acc_userid, (Object) contactDetail.acc_userid) || !equals((Object) this.acc_shopid, (Object) contactDetail.acc_shopid) || !equals((Object) this.status, (Object) contactDetail.status) || !equals((Object) this.name, (Object) contactDetail.name) || !equals((Object) this.deviceid, (Object) contactDetail.deviceid) || !equals((Object) this.hashed_fingerprint, (Object) contactDetail.hashed_fingerprint) || !equals((Object) this.report_time, (Object) contactDetail.report_time) || !equals((Object) this.extinfo, (Object) contactDetail.extinfo) || !equals((Object) this.itemid, (Object) contactDetail.itemid) || !equals((Object) this.data_hash_id, (Object) contactDetail.data_hash_id) || !equals((Object) this.platform_type, (Object) contactDetail.platform_type)) {
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
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.account;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.acctype;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.acc_userid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.acc_shopid;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.status;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str2 = this.name;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        f fVar = this.deviceid;
        int hashCode9 = (hashCode8 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.hashed_fingerprint;
        int hashCode10 = (hashCode9 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Integer num6 = this.report_time;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        f fVar3 = this.extinfo;
        int hashCode12 = (hashCode11 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        String str3 = this.itemid;
        int hashCode13 = (hashCode12 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.data_hash_id;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num7 = this.platform_type;
        if (num7 != null) {
            i2 = num7.hashCode();
        }
        int i3 = hashCode14 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ContactDetail> {
        public Integer acc_shopid;
        public Integer acc_userid;
        public String account;
        public Integer acctype;
        public String data_hash_id;
        public f deviceid;
        public f extinfo;
        public f hashed_fingerprint;
        public Long id;
        public String itemid;
        public String name;
        public Integer platform_type;
        public Integer report_time;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ContactDetail contactDetail) {
            super(contactDetail);
            if (contactDetail != null) {
                this.id = contactDetail.id;
                this.userid = contactDetail.userid;
                this.account = contactDetail.account;
                this.acctype = contactDetail.acctype;
                this.acc_userid = contactDetail.acc_userid;
                this.acc_shopid = contactDetail.acc_shopid;
                this.status = contactDetail.status;
                this.name = contactDetail.name;
                this.deviceid = contactDetail.deviceid;
                this.hashed_fingerprint = contactDetail.hashed_fingerprint;
                this.report_time = contactDetail.report_time;
                this.extinfo = contactDetail.extinfo;
                this.itemid = contactDetail.itemid;
                this.data_hash_id = contactDetail.data_hash_id;
                this.platform_type = contactDetail.platform_type;
            }
        }

        public Builder id(Long l) {
            this.id = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder account(String str) {
            this.account = str;
            return this;
        }

        public Builder acctype(Integer num) {
            this.acctype = num;
            return this;
        }

        public Builder acc_userid(Integer num) {
            this.acc_userid = num;
            return this;
        }

        public Builder acc_shopid(Integer num) {
            this.acc_shopid = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder deviceid(f fVar) {
            this.deviceid = fVar;
            return this;
        }

        public Builder hashed_fingerprint(f fVar) {
            this.hashed_fingerprint = fVar;
            return this;
        }

        public Builder report_time(Integer num) {
            this.report_time = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder itemid(String str) {
            this.itemid = str;
            return this;
        }

        public Builder data_hash_id(String str) {
            this.data_hash_id = str;
            return this;
        }

        public Builder platform_type(Integer num) {
            this.platform_type = num;
            return this;
        }

        public ContactDetail build() {
            return new ContactDetail(this);
        }
    }
}
