package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class BuyerAddress extends Message {
    public static final String DEFAULT_ADDRESS = "";
    public static final String DEFAULT_CITY = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_DEFTIME = 0;
    public static final String DEFAULT_DISTRICT = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final String DEFAULT_FULL_ADDRESS = "";
    public static final String DEFAULT_ICNO = "";
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_LOGISTICS_STATUS = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_STATE = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final String DEFAULT_TOWN = "";
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_ZIPCODE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String address;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String city;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer deftime;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String district;
    @ProtoField(tag = 19, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String full_address;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String icno;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer logistics_status;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String state;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String town;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String zipcode;

    public BuyerAddress(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6, Integer num3, Integer num4, Integer num5, String str7, Integer num6, String str8, String str9, String str10, Integer num7, String str11, f fVar) {
        this.id = num;
        this.userid = num2;
        this.name = str;
        this.phone = str2;
        this.country = str3;
        this.state = str4;
        this.city = str5;
        this.address = str6;
        this.status = num3;
        this.ctime = num4;
        this.mtime = num5;
        this.zipcode = str7;
        this.deftime = num6;
        this.full_address = str8;
        this.district = str9;
        this.town = str10;
        this.logistics_status = num7;
        this.icno = str11;
        this.extinfo = fVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BuyerAddress(com.shopee.protocol.shop.BuyerAddress.Builder r23) {
        /*
            r22 = this;
            r0 = r23
            r1 = r22
            java.lang.Integer r2 = r0.id
            java.lang.Integer r3 = r0.userid
            java.lang.String r4 = r0.name
            java.lang.String r5 = r0.phone
            java.lang.String r6 = r0.country
            java.lang.String r7 = r0.state
            java.lang.String r8 = r0.city
            java.lang.String r9 = r0.address
            java.lang.Integer r10 = r0.status
            java.lang.Integer r11 = r0.ctime
            java.lang.Integer r12 = r0.mtime
            java.lang.String r13 = r0.zipcode
            java.lang.Integer r14 = r0.deftime
            java.lang.String r15 = r0.full_address
            r21 = r1
            java.lang.String r1 = r0.district
            r16 = r1
            java.lang.String r1 = r0.town
            r17 = r1
            java.lang.Integer r1 = r0.logistics_status
            r18 = r1
            java.lang.String r1 = r0.icno
            r19 = r1
            e.f r1 = r0.extinfo
            r20 = r1
            r1 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r22.setBuilder(r23)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.BuyerAddress.<init>(com.shopee.protocol.shop.BuyerAddress$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BuyerAddress)) {
            return false;
        }
        BuyerAddress buyerAddress = (BuyerAddress) obj;
        if (!equals((Object) this.id, (Object) buyerAddress.id) || !equals((Object) this.userid, (Object) buyerAddress.userid) || !equals((Object) this.name, (Object) buyerAddress.name) || !equals((Object) this.phone, (Object) buyerAddress.phone) || !equals((Object) this.country, (Object) buyerAddress.country) || !equals((Object) this.state, (Object) buyerAddress.state) || !equals((Object) this.city, (Object) buyerAddress.city) || !equals((Object) this.address, (Object) buyerAddress.address) || !equals((Object) this.status, (Object) buyerAddress.status) || !equals((Object) this.ctime, (Object) buyerAddress.ctime) || !equals((Object) this.mtime, (Object) buyerAddress.mtime) || !equals((Object) this.zipcode, (Object) buyerAddress.zipcode) || !equals((Object) this.deftime, (Object) buyerAddress.deftime) || !equals((Object) this.full_address, (Object) buyerAddress.full_address) || !equals((Object) this.district, (Object) buyerAddress.district) || !equals((Object) this.town, (Object) buyerAddress.town) || !equals((Object) this.logistics_status, (Object) buyerAddress.logistics_status) || !equals((Object) this.icno, (Object) buyerAddress.icno) || !equals((Object) this.extinfo, (Object) buyerAddress.extinfo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.userid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.phone;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.country;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.state;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.city;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.address;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num3 = this.status;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode10 = (hashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode11 = (hashCode10 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str7 = this.zipcode;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num6 = this.deftime;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str8 = this.full_address;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.district;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.town;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num7 = this.logistics_status;
        int hashCode17 = (hashCode16 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str11 = this.icno;
        int hashCode18 = (hashCode17 + (str11 != null ? str11.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode18 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BuyerAddress> {
        public String address;
        public String city;
        public String country;
        public Integer ctime;
        public Integer deftime;
        public String district;
        public f extinfo;
        public String full_address;
        public String icno;
        public Integer id;
        public Integer logistics_status;
        public Integer mtime;
        public String name;
        public String phone;
        public String state;
        public Integer status;
        public String town;
        public Integer userid;
        public String zipcode;

        public Builder() {
        }

        public Builder(BuyerAddress buyerAddress) {
            super(buyerAddress);
            if (buyerAddress != null) {
                this.id = buyerAddress.id;
                this.userid = buyerAddress.userid;
                this.name = buyerAddress.name;
                this.phone = buyerAddress.phone;
                this.country = buyerAddress.country;
                this.state = buyerAddress.state;
                this.city = buyerAddress.city;
                this.address = buyerAddress.address;
                this.status = buyerAddress.status;
                this.ctime = buyerAddress.ctime;
                this.mtime = buyerAddress.mtime;
                this.zipcode = buyerAddress.zipcode;
                this.deftime = buyerAddress.deftime;
                this.full_address = buyerAddress.full_address;
                this.district = buyerAddress.district;
                this.town = buyerAddress.town;
                this.logistics_status = buyerAddress.logistics_status;
                this.icno = buyerAddress.icno;
                this.extinfo = buyerAddress.extinfo;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder state(String str) {
            this.state = str;
            return this;
        }

        public Builder city(String str) {
            this.city = str;
            return this;
        }

        public Builder address(String str) {
            this.address = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder zipcode(String str) {
            this.zipcode = str;
            return this;
        }

        public Builder deftime(Integer num) {
            this.deftime = num;
            return this;
        }

        public Builder full_address(String str) {
            this.full_address = str;
            return this;
        }

        public Builder district(String str) {
            this.district = str;
            return this;
        }

        public Builder town(String str) {
            this.town = str;
            return this;
        }

        public Builder logistics_status(Integer num) {
            this.logistics_status = num;
            return this;
        }

        public Builder icno(String str) {
            this.icno = str;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public BuyerAddress build() {
            return new BuyerAddress(this);
        }
    }
}
