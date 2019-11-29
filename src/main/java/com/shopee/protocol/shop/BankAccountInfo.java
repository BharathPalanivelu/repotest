package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BankAccountInfo extends Message {
    public static final String DEFAULT_ACCOUNT_NAME = "";
    public static final Long DEFAULT_ACCOUNT_NO = 0L;
    public static final String DEFAULT_ACCOUNT_NUMBER = "";
    public static final Integer DEFAULT_BANKACCOUNT_ID = 0;
    public static final Integer DEFAULT_BANK_CODE = 0;
    public static final String DEFAULT_BANK_NAME = "";
    public static final Integer DEFAULT_BRANCH_CODE = 0;
    public static final String DEFAULT_BRANCH_NAME = "";
    public static final String DEFAULT_ICNO = "";
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_REAL_NAME = "";
    public static final String DEFAULT_REGION = "";
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String account_name;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long account_no;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String account_number;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer bank_code;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bank_name;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer bankaccount_id;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer branch_code;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String branch_name;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String icno;
    @ProtoField(tag = 13)
    public final BankAccountInfo last_bank_account;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String real_name;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String region;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer status;

    public BankAccountInfo(Long l, String str, Integer num, String str2, String str3, String str4, String str5, Integer num2, Integer num3, String str6, String str7, Integer num4, BankAccountInfo bankAccountInfo, Integer num5) {
        this.account_no = l;
        this.bank_name = str;
        this.branch_code = num;
        this.account_name = str2;
        this.real_name = str3;
        this.icno = str4;
        this.account_number = str5;
        this.mtime = num2;
        this.bank_code = num3;
        this.region = str6;
        this.branch_name = str7;
        this.status = num4;
        this.last_bank_account = bankAccountInfo;
        this.bankaccount_id = num5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private BankAccountInfo(com.shopee.protocol.shop.BankAccountInfo.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.Long r2 = r0.account_no
            java.lang.String r3 = r0.bank_name
            java.lang.Integer r4 = r0.branch_code
            java.lang.String r5 = r0.account_name
            java.lang.String r6 = r0.real_name
            java.lang.String r7 = r0.icno
            java.lang.String r8 = r0.account_number
            java.lang.Integer r9 = r0.mtime
            java.lang.Integer r10 = r0.bank_code
            java.lang.String r11 = r0.region
            java.lang.String r12 = r0.branch_name
            java.lang.Integer r13 = r0.status
            com.shopee.protocol.shop.BankAccountInfo r14 = r0.last_bank_account
            java.lang.Integer r15 = r0.bankaccount_id
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.BankAccountInfo.<init>(com.shopee.protocol.shop.BankAccountInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BankAccountInfo)) {
            return false;
        }
        BankAccountInfo bankAccountInfo = (BankAccountInfo) obj;
        if (!equals((Object) this.account_no, (Object) bankAccountInfo.account_no) || !equals((Object) this.bank_name, (Object) bankAccountInfo.bank_name) || !equals((Object) this.branch_code, (Object) bankAccountInfo.branch_code) || !equals((Object) this.account_name, (Object) bankAccountInfo.account_name) || !equals((Object) this.real_name, (Object) bankAccountInfo.real_name) || !equals((Object) this.icno, (Object) bankAccountInfo.icno) || !equals((Object) this.account_number, (Object) bankAccountInfo.account_number) || !equals((Object) this.mtime, (Object) bankAccountInfo.mtime) || !equals((Object) this.bank_code, (Object) bankAccountInfo.bank_code) || !equals((Object) this.region, (Object) bankAccountInfo.region) || !equals((Object) this.branch_name, (Object) bankAccountInfo.branch_name) || !equals((Object) this.status, (Object) bankAccountInfo.status) || !equals((Object) this.last_bank_account, (Object) bankAccountInfo.last_bank_account) || !equals((Object) this.bankaccount_id, (Object) bankAccountInfo.bankaccount_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.account_no;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        String str = this.bank_name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.branch_code;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.account_name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.real_name;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.icno;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.account_number;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num2 = this.mtime;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.bank_code;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str6 = this.region;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.branch_name;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        BankAccountInfo bankAccountInfo = this.last_bank_account;
        int hashCode13 = (hashCode12 + (bankAccountInfo != null ? bankAccountInfo.hashCode() : 0)) * 37;
        Integer num5 = this.bankaccount_id;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BankAccountInfo> {
        public String account_name;
        public Long account_no;
        public String account_number;
        public Integer bank_code;
        public String bank_name;
        public Integer bankaccount_id;
        public Integer branch_code;
        public String branch_name;
        public String icno;
        public BankAccountInfo last_bank_account;
        public Integer mtime;
        public String real_name;
        public String region;
        public Integer status;

        public Builder() {
        }

        public Builder(BankAccountInfo bankAccountInfo) {
            super(bankAccountInfo);
            if (bankAccountInfo != null) {
                this.account_no = bankAccountInfo.account_no;
                this.bank_name = bankAccountInfo.bank_name;
                this.branch_code = bankAccountInfo.branch_code;
                this.account_name = bankAccountInfo.account_name;
                this.real_name = bankAccountInfo.real_name;
                this.icno = bankAccountInfo.icno;
                this.account_number = bankAccountInfo.account_number;
                this.mtime = bankAccountInfo.mtime;
                this.bank_code = bankAccountInfo.bank_code;
                this.region = bankAccountInfo.region;
                this.branch_name = bankAccountInfo.branch_name;
                this.status = bankAccountInfo.status;
                this.last_bank_account = bankAccountInfo.last_bank_account;
                this.bankaccount_id = bankAccountInfo.bankaccount_id;
            }
        }

        public Builder account_no(Long l) {
            this.account_no = l;
            return this;
        }

        public Builder bank_name(String str) {
            this.bank_name = str;
            return this;
        }

        public Builder branch_code(Integer num) {
            this.branch_code = num;
            return this;
        }

        public Builder account_name(String str) {
            this.account_name = str;
            return this;
        }

        public Builder real_name(String str) {
            this.real_name = str;
            return this;
        }

        public Builder icno(String str) {
            this.icno = str;
            return this;
        }

        public Builder account_number(String str) {
            this.account_number = str;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder bank_code(Integer num) {
            this.bank_code = num;
            return this;
        }

        public Builder region(String str) {
            this.region = str;
            return this;
        }

        public Builder branch_name(String str) {
            this.branch_name = str;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder last_bank_account(BankAccountInfo bankAccountInfo) {
            this.last_bank_account = bankAccountInfo;
            return this;
        }

        public Builder bankaccount_id(Integer num) {
            this.bankaccount_id = num;
            return this;
        }

        public BankAccountInfo build() {
            return new BankAccountInfo(this);
        }
    }
}
