package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Chat extends Message {
    public static final Integer DEFAULT_ARCHIVE = 0;
    public static final Integer DEFAULT_BUY_COUNT = 0;
    public static final Long DEFAULT_CHATID = 0L;
    public static final Integer DEFAULT_CLEAR_TIME = 0;
    public static final Long DEFAULT_CLEAR_TIME_NANO = 0L;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_LAST_MSGID = 0L;
    public static final Integer DEFAULT_LAST_MSG_TIME = 0;
    public static final Long DEFAULT_LAST_MSG_TIME_NANO = 0L;
    public static final Long DEFAULT_LAST_READ = 0L;
    public static final Long DEFAULT_MODELID = 0L;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Long DEFAULT_MTIME_NANO = 0L;
    public static final Long DEFAULT_OFFER_PRICE = 0L;
    public static final Integer DEFAULT_OFFER_STATUS = 0;
    public static final Long DEFAULT_ORDERID = 0L;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final String DEFAULT_PORTRAIT = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final String DEFAULT_TEXT_LAST_READ = "";
    public static final Integer DEFAULT_UNREAD_COUNT = 0;
    public static final Integer DEFAULT_USERID = 0;
    public static final String DEFAULT_USERNAME = "";
    public static final Integer DEFAULT_USER_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer archive;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer buy_count;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long chatid;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer clear_time;
    @ProtoField(tag = 23, type = Message.Datatype.UINT64)
    public final Long clear_time_nano;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer last_msg_time;
    @ProtoField(tag = 22, type = Message.Datatype.UINT64)
    public final Long last_msg_time_nano;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long last_msgid;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long last_read;
    @ProtoField(tag = 12, type = Message.Datatype.INT64)
    public final Long modelid;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 24, type = Message.Datatype.UINT64)
    public final Long mtime_nano;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long offer_price;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer offer_status;
    @ProtoField(tag = 10, type = Message.Datatype.INT64)
    public final Long orderid;
    @ProtoField(tag = 13, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String portrait;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String text_last_read;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer unread_count;
    @ProtoField(tag = 20, type = Message.Datatype.INT32)
    public final Integer user_status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String username;

    public Chat(Long l, Integer num, Integer num2, Long l2, Integer num3, Long l3, Integer num4, Long l4, Integer num5, Long l5, Integer num6, Long l6, Long l7, Integer num7, Long l8, Integer num8, String str, String str2, String str3, Integer num9, Integer num10, Long l9, Long l10, Long l11) {
        this.chatid = l;
        this.userid = num;
        this.shopid = num2;
        this.itemid = l2;
        this.buy_count = num3;
        this.offer_price = l3;
        this.offer_status = num4;
        this.last_msgid = l4;
        this.last_msg_time = num5;
        this.orderid = l5;
        this.archive = num6;
        this.modelid = l6;
        this.pchatid = l7;
        this.clear_time = num7;
        this.last_read = l8;
        this.mtime = num8;
        this.text_last_read = str;
        this.username = str2;
        this.portrait = str3;
        this.user_status = num9;
        this.unread_count = num10;
        this.last_msg_time_nano = l9;
        this.clear_time_nano = l10;
        this.mtime_nano = l11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Chat(com.shopee.protocol.action.Chat.Builder r28) {
        /*
            r27 = this;
            r0 = r28
            r1 = r27
            java.lang.Long r2 = r0.chatid
            java.lang.Integer r3 = r0.userid
            java.lang.Integer r4 = r0.shopid
            java.lang.Long r5 = r0.itemid
            java.lang.Integer r6 = r0.buy_count
            java.lang.Long r7 = r0.offer_price
            java.lang.Integer r8 = r0.offer_status
            java.lang.Long r9 = r0.last_msgid
            java.lang.Integer r10 = r0.last_msg_time
            java.lang.Long r11 = r0.orderid
            java.lang.Integer r12 = r0.archive
            java.lang.Long r13 = r0.modelid
            java.lang.Long r14 = r0.pchatid
            java.lang.Integer r15 = r0.clear_time
            r26 = r1
            java.lang.Long r1 = r0.last_read
            r16 = r1
            java.lang.Integer r1 = r0.mtime
            r17 = r1
            java.lang.String r1 = r0.text_last_read
            r18 = r1
            java.lang.String r1 = r0.username
            r19 = r1
            java.lang.String r1 = r0.portrait
            r20 = r1
            java.lang.Integer r1 = r0.user_status
            r21 = r1
            java.lang.Integer r1 = r0.unread_count
            r22 = r1
            java.lang.Long r1 = r0.last_msg_time_nano
            r23 = r1
            java.lang.Long r1 = r0.clear_time_nano
            r24 = r1
            java.lang.Long r1 = r0.mtime_nano
            r25 = r1
            r1 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r27.setBuilder(r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.protocol.action.Chat.<init>(com.shopee.protocol.action.Chat$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) obj;
        if (!equals((Object) this.chatid, (Object) chat.chatid) || !equals((Object) this.userid, (Object) chat.userid) || !equals((Object) this.shopid, (Object) chat.shopid) || !equals((Object) this.itemid, (Object) chat.itemid) || !equals((Object) this.buy_count, (Object) chat.buy_count) || !equals((Object) this.offer_price, (Object) chat.offer_price) || !equals((Object) this.offer_status, (Object) chat.offer_status) || !equals((Object) this.last_msgid, (Object) chat.last_msgid) || !equals((Object) this.last_msg_time, (Object) chat.last_msg_time) || !equals((Object) this.orderid, (Object) chat.orderid) || !equals((Object) this.archive, (Object) chat.archive) || !equals((Object) this.modelid, (Object) chat.modelid) || !equals((Object) this.pchatid, (Object) chat.pchatid) || !equals((Object) this.clear_time, (Object) chat.clear_time) || !equals((Object) this.last_read, (Object) chat.last_read) || !equals((Object) this.mtime, (Object) chat.mtime) || !equals((Object) this.text_last_read, (Object) chat.text_last_read) || !equals((Object) this.username, (Object) chat.username) || !equals((Object) this.portrait, (Object) chat.portrait) || !equals((Object) this.user_status, (Object) chat.user_status) || !equals((Object) this.unread_count, (Object) chat.unread_count) || !equals((Object) this.last_msg_time_nano, (Object) chat.last_msg_time_nano) || !equals((Object) this.clear_time_nano, (Object) chat.clear_time_nano) || !equals((Object) this.mtime_nano, (Object) chat.mtime_nano)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.chatid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.userid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.buy_count;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l3 = this.offer_price;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num4 = this.offer_status;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Long l4 = this.last_msgid;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num5 = this.last_msg_time;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l5 = this.orderid;
        int hashCode10 = (hashCode9 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num6 = this.archive;
        int hashCode11 = (hashCode10 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l6 = this.modelid;
        int hashCode12 = (hashCode11 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.pchatid;
        int hashCode13 = (hashCode12 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Integer num7 = this.clear_time;
        int hashCode14 = (hashCode13 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Long l8 = this.last_read;
        int hashCode15 = (hashCode14 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Integer num8 = this.mtime;
        int hashCode16 = (hashCode15 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str = this.text_last_read;
        int hashCode17 = (hashCode16 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.username;
        int hashCode18 = (hashCode17 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.portrait;
        int hashCode19 = (hashCode18 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num9 = this.user_status;
        int hashCode20 = (hashCode19 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.unread_count;
        int hashCode21 = (hashCode20 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Long l9 = this.last_msg_time_nano;
        int hashCode22 = (hashCode21 + (l9 != null ? l9.hashCode() : 0)) * 37;
        Long l10 = this.clear_time_nano;
        int hashCode23 = (hashCode22 + (l10 != null ? l10.hashCode() : 0)) * 37;
        Long l11 = this.mtime_nano;
        if (l11 != null) {
            i2 = l11.hashCode();
        }
        int i3 = hashCode23 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Chat> {
        public Integer archive;
        public Integer buy_count;
        public Long chatid;
        public Integer clear_time;
        public Long clear_time_nano;
        public Long itemid;
        public Integer last_msg_time;
        public Long last_msg_time_nano;
        public Long last_msgid;
        public Long last_read;
        public Long modelid;
        public Integer mtime;
        public Long mtime_nano;
        public Long offer_price;
        public Integer offer_status;
        public Long orderid;
        public Long pchatid;
        public String portrait;
        public Integer shopid;
        public String text_last_read;
        public Integer unread_count;
        public Integer user_status;
        public Integer userid;
        public String username;

        public Builder() {
        }

        public Builder(Chat chat) {
            super(chat);
            if (chat != null) {
                this.chatid = chat.chatid;
                this.userid = chat.userid;
                this.shopid = chat.shopid;
                this.itemid = chat.itemid;
                this.buy_count = chat.buy_count;
                this.offer_price = chat.offer_price;
                this.offer_status = chat.offer_status;
                this.last_msgid = chat.last_msgid;
                this.last_msg_time = chat.last_msg_time;
                this.orderid = chat.orderid;
                this.archive = chat.archive;
                this.modelid = chat.modelid;
                this.pchatid = chat.pchatid;
                this.clear_time = chat.clear_time;
                this.last_read = chat.last_read;
                this.mtime = chat.mtime;
                this.text_last_read = chat.text_last_read;
                this.username = chat.username;
                this.portrait = chat.portrait;
                this.user_status = chat.user_status;
                this.unread_count = chat.unread_count;
                this.last_msg_time_nano = chat.last_msg_time_nano;
                this.clear_time_nano = chat.clear_time_nano;
                this.mtime_nano = chat.mtime_nano;
            }
        }

        public Builder chatid(Long l) {
            this.chatid = l;
            return this;
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder itemid(Long l) {
            this.itemid = l;
            return this;
        }

        public Builder buy_count(Integer num) {
            this.buy_count = num;
            return this;
        }

        public Builder offer_price(Long l) {
            this.offer_price = l;
            return this;
        }

        public Builder offer_status(Integer num) {
            this.offer_status = num;
            return this;
        }

        public Builder last_msgid(Long l) {
            this.last_msgid = l;
            return this;
        }

        public Builder last_msg_time(Integer num) {
            this.last_msg_time = num;
            return this;
        }

        public Builder orderid(Long l) {
            this.orderid = l;
            return this;
        }

        public Builder archive(Integer num) {
            this.archive = num;
            return this;
        }

        public Builder modelid(Long l) {
            this.modelid = l;
            return this;
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
            return this;
        }

        public Builder clear_time(Integer num) {
            this.clear_time = num;
            return this;
        }

        public Builder last_read(Long l) {
            this.last_read = l;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public Builder text_last_read(String str) {
            this.text_last_read = str;
            return this;
        }

        public Builder username(String str) {
            this.username = str;
            return this;
        }

        public Builder portrait(String str) {
            this.portrait = str;
            return this;
        }

        public Builder user_status(Integer num) {
            this.user_status = num;
            return this;
        }

        public Builder unread_count(Integer num) {
            this.unread_count = num;
            return this;
        }

        public Builder last_msg_time_nano(Long l) {
            this.last_msg_time_nano = l;
            return this;
        }

        public Builder clear_time_nano(Long l) {
            this.clear_time_nano = l;
            return this;
        }

        public Builder mtime_nano(Long l) {
            this.mtime_nano = l;
            return this;
        }

        public Chat build() {
            return new Chat(this);
        }
    }
}
