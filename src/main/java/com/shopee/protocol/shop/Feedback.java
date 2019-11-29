package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Feedback extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_CTIME = 0;
    public static final String DEFAULT_EMAIL = "";
    public static final Integer DEFAULT_ID = 0;
    public static final String DEFAULT_NAME = "";
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String email;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String name;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userid;

    public Feedback(Integer num, Integer num2, String str, String str2, String str3, Integer num3, Integer num4) {
        this.userid = num;
        this.shopid = num2;
        this.name = str;
        this.email = str2;
        this.content = str3;
        this.ctime = num3;
        this.id = num4;
    }

    private Feedback(Builder builder) {
        this(builder.userid, builder.shopid, builder.name, builder.email, builder.content, builder.ctime, builder.id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) obj;
        if (!equals((Object) this.userid, (Object) feedback.userid) || !equals((Object) this.shopid, (Object) feedback.shopid) || !equals((Object) this.name, (Object) feedback.name) || !equals((Object) this.email, (Object) feedback.email) || !equals((Object) this.content, (Object) feedback.content) || !equals((Object) this.ctime, (Object) feedback.ctime) || !equals((Object) this.id, (Object) feedback.id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.userid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.shopid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.email;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.content;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.id;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Feedback> {
        public String content;
        public Integer ctime;
        public String email;
        public Integer id;
        public String name;
        public Integer shopid;
        public Integer userid;

        public Builder() {
        }

        public Builder(Feedback feedback) {
            super(feedback);
            if (feedback != null) {
                this.userid = feedback.userid;
                this.shopid = feedback.shopid;
                this.name = feedback.name;
                this.email = feedback.email;
                this.content = feedback.content;
                this.ctime = feedback.ctime;
                this.id = feedback.id;
            }
        }

        public Builder userid(Integer num) {
            this.userid = num;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder email(String str) {
            this.email = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Feedback build() {
            return new Feedback(this);
        }
    }
}
