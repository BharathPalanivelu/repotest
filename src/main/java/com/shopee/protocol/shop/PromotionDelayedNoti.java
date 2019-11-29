package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PromotionDelayedNoti extends Message {
    public static final String DEFAULT_ACTION_CONTENT = "";
    public static final String DEFAULT_ACTION_ICON = "";
    public static final String DEFAULT_ACTION_TITLE = "";
    public static final String DEFAULT_ACTION_URL = "";
    public static final Integer DEFAULT_DELAY_DAYS = 0;
    public static final String DEFAULT_PUSH_CONTENT = "";
    public static final Integer DEFAULT_SEND_TIME = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String action_content;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String action_icon;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String action_title;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String action_url;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer delay_days;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String push_content;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer send_time;

    public PromotionDelayedNoti(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5) {
        this.send_time = num;
        this.delay_days = num2;
        this.action_url = str;
        this.action_icon = str2;
        this.action_title = str3;
        this.action_content = str4;
        this.push_content = str5;
    }

    private PromotionDelayedNoti(Builder builder) {
        this(builder.send_time, builder.delay_days, builder.action_url, builder.action_icon, builder.action_title, builder.action_content, builder.push_content);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PromotionDelayedNoti)) {
            return false;
        }
        PromotionDelayedNoti promotionDelayedNoti = (PromotionDelayedNoti) obj;
        if (!equals((Object) this.send_time, (Object) promotionDelayedNoti.send_time) || !equals((Object) this.delay_days, (Object) promotionDelayedNoti.delay_days) || !equals((Object) this.action_url, (Object) promotionDelayedNoti.action_url) || !equals((Object) this.action_icon, (Object) promotionDelayedNoti.action_icon) || !equals((Object) this.action_title, (Object) promotionDelayedNoti.action_title) || !equals((Object) this.action_content, (Object) promotionDelayedNoti.action_content) || !equals((Object) this.push_content, (Object) promotionDelayedNoti.push_content)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.send_time;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.delay_days;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.action_url;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.action_icon;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.action_title;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.action_content;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.push_content;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PromotionDelayedNoti> {
        public String action_content;
        public String action_icon;
        public String action_title;
        public String action_url;
        public Integer delay_days;
        public String push_content;
        public Integer send_time;

        public Builder() {
        }

        public Builder(PromotionDelayedNoti promotionDelayedNoti) {
            super(promotionDelayedNoti);
            if (promotionDelayedNoti != null) {
                this.send_time = promotionDelayedNoti.send_time;
                this.delay_days = promotionDelayedNoti.delay_days;
                this.action_url = promotionDelayedNoti.action_url;
                this.action_icon = promotionDelayedNoti.action_icon;
                this.action_title = promotionDelayedNoti.action_title;
                this.action_content = promotionDelayedNoti.action_content;
                this.push_content = promotionDelayedNoti.push_content;
            }
        }

        public Builder send_time(Integer num) {
            this.send_time = num;
            return this;
        }

        public Builder delay_days(Integer num) {
            this.delay_days = num;
            return this;
        }

        public Builder action_url(String str) {
            this.action_url = str;
            return this;
        }

        public Builder action_icon(String str) {
            this.action_icon = str;
            return this;
        }

        public Builder action_title(String str) {
            this.action_title = str;
            return this;
        }

        public Builder action_content(String str) {
            this.action_content = str;
            return this;
        }

        public Builder push_content(String str) {
            this.push_content = str;
            return this;
        }

        public PromotionDelayedNoti build() {
            return new PromotionDelayedNoti(this);
        }
    }
}
