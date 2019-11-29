package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class MarketPushnotiTasklist extends Message {
    public static final String DEFAULT_BANNER = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_ERROR_MSG = "";
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final String DEFAULT_PURE_ACTION_CONTENT = "";
    public static final String DEFAULT_PUSH_CONTENT = "";
    public static final Integer DEFAULT_SEND_OPTION = 0;
    public static final String DEFAULT_STATUS = "";
    public static final Integer DEFAULT_TASK_ID = 0;
    public static final Integer DEFAULT_TASK_TYPE = 0;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_USER_ID = 0;
    public static final String DEFAULT_VALUE_STRING = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String banner;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String error_msg;
    @ProtoField(tag = 15, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String pure_action_content;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String push_content;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer send_option;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer task_id;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer task_type;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String url;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer user_id;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String value_string;

    public MarketPushnotiTasklist(Integer num, Integer num2, Integer num3, String str, String str2, String str3, String str4, Integer num4, Integer num5, String str5, String str6, String str7, Integer num6, Integer num7, f fVar, String str8) {
        this.id = num;
        this.task_id = num2;
        this.user_id = num3;
        this.value_string = str;
        this.push_content = str2;
        this.status = str3;
        this.error_msg = str4;
        this.ctime = num4;
        this.mtime = num5;
        this.url = str5;
        this.banner = str6;
        this.title = str7;
        this.task_type = num6;
        this.send_option = num7;
        this.extinfo = fVar;
        this.pure_action_content = str8;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MarketPushnotiTasklist(com.shopee.protocol.shop.MarketPushnotiTasklist.Builder r20) {
        /*
            r19 = this;
            r0 = r20
            r1 = r19
            java.lang.Integer r2 = r0.id
            java.lang.Integer r3 = r0.task_id
            java.lang.Integer r4 = r0.user_id
            java.lang.String r5 = r0.value_string
            java.lang.String r6 = r0.push_content
            java.lang.String r7 = r0.status
            java.lang.String r8 = r0.error_msg
            java.lang.Integer r9 = r0.ctime
            java.lang.Integer r10 = r0.mtime
            java.lang.String r11 = r0.url
            java.lang.String r12 = r0.banner
            java.lang.String r13 = r0.title
            java.lang.Integer r14 = r0.task_type
            java.lang.Integer r15 = r0.send_option
            r18 = r1
            e.f r1 = r0.extinfo
            r16 = r1
            java.lang.String r1 = r0.pure_action_content
            r17 = r1
            r1 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r19.setBuilder(r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.shop.MarketPushnotiTasklist.<init>(com.shopee.protocol.shop.MarketPushnotiTasklist$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPushnotiTasklist)) {
            return false;
        }
        MarketPushnotiTasklist marketPushnotiTasklist = (MarketPushnotiTasklist) obj;
        if (!equals((Object) this.id, (Object) marketPushnotiTasklist.id) || !equals((Object) this.task_id, (Object) marketPushnotiTasklist.task_id) || !equals((Object) this.user_id, (Object) marketPushnotiTasklist.user_id) || !equals((Object) this.value_string, (Object) marketPushnotiTasklist.value_string) || !equals((Object) this.push_content, (Object) marketPushnotiTasklist.push_content) || !equals((Object) this.status, (Object) marketPushnotiTasklist.status) || !equals((Object) this.error_msg, (Object) marketPushnotiTasklist.error_msg) || !equals((Object) this.ctime, (Object) marketPushnotiTasklist.ctime) || !equals((Object) this.mtime, (Object) marketPushnotiTasklist.mtime) || !equals((Object) this.url, (Object) marketPushnotiTasklist.url) || !equals((Object) this.banner, (Object) marketPushnotiTasklist.banner) || !equals((Object) this.title, (Object) marketPushnotiTasklist.title) || !equals((Object) this.task_type, (Object) marketPushnotiTasklist.task_type) || !equals((Object) this.send_option, (Object) marketPushnotiTasklist.send_option) || !equals((Object) this.extinfo, (Object) marketPushnotiTasklist.extinfo) || !equals((Object) this.pure_action_content, (Object) marketPushnotiTasklist.pure_action_content)) {
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
        Integer num2 = this.task_id;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.user_id;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.value_string;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.push_content;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.status;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.error_msg;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num4 = this.ctime;
        int hashCode8 = (hashCode7 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mtime;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str5 = this.url;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.banner;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.title;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num6 = this.task_type;
        int hashCode13 = (hashCode12 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.send_option;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        f fVar = this.extinfo;
        int hashCode15 = (hashCode14 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        String str8 = this.pure_action_content;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MarketPushnotiTasklist> {
        public String banner;
        public Integer ctime;
        public String error_msg;
        public f extinfo;
        public Integer id;
        public Integer mtime;
        public String pure_action_content;
        public String push_content;
        public Integer send_option;
        public String status;
        public Integer task_id;
        public Integer task_type;
        public String title;
        public String url;
        public Integer user_id;
        public String value_string;

        public Builder() {
        }

        public Builder(MarketPushnotiTasklist marketPushnotiTasklist) {
            super(marketPushnotiTasklist);
            if (marketPushnotiTasklist != null) {
                this.id = marketPushnotiTasklist.id;
                this.task_id = marketPushnotiTasklist.task_id;
                this.user_id = marketPushnotiTasklist.user_id;
                this.value_string = marketPushnotiTasklist.value_string;
                this.push_content = marketPushnotiTasklist.push_content;
                this.status = marketPushnotiTasklist.status;
                this.error_msg = marketPushnotiTasklist.error_msg;
                this.ctime = marketPushnotiTasklist.ctime;
                this.mtime = marketPushnotiTasklist.mtime;
                this.url = marketPushnotiTasklist.url;
                this.banner = marketPushnotiTasklist.banner;
                this.title = marketPushnotiTasklist.title;
                this.task_type = marketPushnotiTasklist.task_type;
                this.send_option = marketPushnotiTasklist.send_option;
                this.extinfo = marketPushnotiTasklist.extinfo;
                this.pure_action_content = marketPushnotiTasklist.pure_action_content;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder task_id(Integer num) {
            this.task_id = num;
            return this;
        }

        public Builder user_id(Integer num) {
            this.user_id = num;
            return this;
        }

        public Builder value_string(String str) {
            this.value_string = str;
            return this;
        }

        public Builder push_content(String str) {
            this.push_content = str;
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

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder banner(String str) {
            this.banner = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder task_type(Integer num) {
            this.task_type = num;
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

        public Builder pure_action_content(String str) {
            this.pure_action_content = str;
            return this;
        }

        public MarketPushnotiTasklist build() {
            return new MarketPushnotiTasklist(this);
        }
    }
}
