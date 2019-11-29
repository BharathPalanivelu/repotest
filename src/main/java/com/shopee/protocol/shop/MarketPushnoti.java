package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class MarketPushnoti extends Message {
    public static final String DEFAULT_ACTION_CONTENT = "";
    public static final String DEFAULT_BANNER = "";
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_ERROR_MSG = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_OPERATOR_EMAIL = "";
    public static final String DEFAULT_PLACEHOLDER_STRING = "";
    public static final Integer DEFAULT_SCHEDULE_TIME = 0;
    public static final Integer DEFAULT_SEND_OPTION = 0;
    public static final String DEFAULT_STATUS = "";
    public static final Integer DEFAULT_TASK_ID = 0;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String action_content;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String banner;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String country;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String description;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String error_msg;
    @ProtoField(tag = 17, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String operator_email;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String placeholder_string;
    @ProtoField(tag = 19, type = Message.Datatype.INT32)
    public final Integer schedule_time;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer send_option;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String status;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer task_id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String url;

    public MarketPushnoti(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Integer num2, Integer num3, String str11, Integer num4, f fVar, String str12, Integer num5) {
        this.task_id = num;
        this.operator_email = str;
        this.description = str2;
        this.banner = str3;
        this.url = str4;
        this.title = str5;
        this.content = str6;
        this.placeholder_string = str7;
        this.country = str8;
        this.status = str9;
        this.error_msg = str10;
        this.ctime = num2;
        this.mtime = num3;
        this.name = str11;
        this.send_option = num4;
        this.extinfo = fVar;
        this.action_content = str12;
        this.schedule_time = num5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MarketPushnoti(com.shopee.protocol.shop.MarketPushnoti.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.Integer r2 = r0.task_id
            java.lang.String r3 = r0.operator_email
            java.lang.String r4 = r0.description
            java.lang.String r5 = r0.banner
            java.lang.String r6 = r0.url
            java.lang.String r7 = r0.title
            java.lang.String r8 = r0.content
            java.lang.String r9 = r0.placeholder_string
            java.lang.String r10 = r0.country
            java.lang.String r11 = r0.status
            java.lang.String r12 = r0.error_msg
            java.lang.Integer r13 = r0.ctime
            java.lang.Integer r14 = r0.mtime
            java.lang.String r15 = r0.name
            r20 = r1
            java.lang.Integer r1 = r0.send_option
            r16 = r1
            e.f r1 = r0.extinfo
            r17 = r1
            java.lang.String r1 = r0.action_content
            r18 = r1
            java.lang.Integer r1 = r0.schedule_time
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.MarketPushnoti.<init>(com.shopee.protocol.shop.MarketPushnoti$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPushnoti)) {
            return false;
        }
        MarketPushnoti marketPushnoti = (MarketPushnoti) obj;
        if (!equals((Object) this.task_id, (Object) marketPushnoti.task_id) || !equals((Object) this.operator_email, (Object) marketPushnoti.operator_email) || !equals((Object) this.description, (Object) marketPushnoti.description) || !equals((Object) this.banner, (Object) marketPushnoti.banner) || !equals((Object) this.url, (Object) marketPushnoti.url) || !equals((Object) this.title, (Object) marketPushnoti.title) || !equals((Object) this.content, (Object) marketPushnoti.content) || !equals((Object) this.placeholder_string, (Object) marketPushnoti.placeholder_string) || !equals((Object) this.country, (Object) marketPushnoti.country) || !equals((Object) this.status, (Object) marketPushnoti.status) || !equals((Object) this.error_msg, (Object) marketPushnoti.error_msg) || !equals((Object) this.ctime, (Object) marketPushnoti.ctime) || !equals((Object) this.mtime, (Object) marketPushnoti.mtime) || !equals((Object) this.name, (Object) marketPushnoti.name) || !equals((Object) this.send_option, (Object) marketPushnoti.send_option) || !equals((Object) this.extinfo, (Object) marketPushnoti.extinfo) || !equals((Object) this.action_content, (Object) marketPushnoti.action_content) || !equals((Object) this.schedule_time, (Object) marketPushnoti.schedule_time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.task_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.operator_email;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.banner;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.url;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.title;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.content;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.placeholder_string;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.country;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.status;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.error_msg;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Integer num2 = this.ctime;
        int hashCode12 = (hashCode11 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        int hashCode13 = (hashCode12 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str11 = this.name;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 37;
        Integer num4 = this.send_option;
        int hashCode15 = (hashCode14 + (num4 != null ? num4.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode16 = (hashCode15 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str12 = this.action_content;
        int hashCode17 = (hashCode16 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Integer num5 = this.schedule_time;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MarketPushnoti> {
        public String action_content;
        public String banner;
        public String content;
        public String country;
        public Integer ctime;
        public String description;
        public String error_msg;
        public f extinfo;
        public Integer mtime;
        public String name;
        public String operator_email;
        public String placeholder_string;
        public Integer schedule_time;
        public Integer send_option;
        public String status;
        public Integer task_id;
        public String title;
        public String url;

        public Builder() {
        }

        public Builder(MarketPushnoti marketPushnoti) {
            super(marketPushnoti);
            if (marketPushnoti != null) {
                this.task_id = marketPushnoti.task_id;
                this.operator_email = marketPushnoti.operator_email;
                this.description = marketPushnoti.description;
                this.banner = marketPushnoti.banner;
                this.url = marketPushnoti.url;
                this.title = marketPushnoti.title;
                this.content = marketPushnoti.content;
                this.placeholder_string = marketPushnoti.placeholder_string;
                this.country = marketPushnoti.country;
                this.status = marketPushnoti.status;
                this.error_msg = marketPushnoti.error_msg;
                this.ctime = marketPushnoti.ctime;
                this.mtime = marketPushnoti.mtime;
                this.name = marketPushnoti.name;
                this.send_option = marketPushnoti.send_option;
                this.extinfo = marketPushnoti.extinfo;
                this.action_content = marketPushnoti.action_content;
                this.schedule_time = marketPushnoti.schedule_time;
            }
        }

        public Builder task_id(Integer num) {
            this.task_id = num;
            return this;
        }

        public Builder operator_email(String str) {
            this.operator_email = str;
            return this;
        }

        public Builder description(String str) {
            this.description = str;
            return this;
        }

        public Builder banner(String str) {
            this.banner = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder placeholder_string(String str) {
            this.placeholder_string = str;
            return this;
        }

        public Builder country(String str) {
            this.country = str;
            return this;
        }

        public Builder status(String str) {
            this.status = str;
            return this;
        }

        public Builder error_msg(String str) {
            this.error_msg = str;
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

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder send_option(Integer num) {
            this.send_option = num;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder action_content(String str) {
            this.action_content = str;
            return this;
        }

        public Builder schedule_time(Integer num) {
            this.schedule_time = num;
            return this;
        }

        public MarketPushnoti build() {
            return new MarketPushnoti(this);
        }
    }
}
