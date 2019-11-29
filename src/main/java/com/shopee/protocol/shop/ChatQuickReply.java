package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class ChatQuickReply extends Message {
    public static final f DEFAULT_CONTENT = f.f32736b;
    public static final f DEFAULT_EXTINFO = f.f32736b;
    public static final Integer DEFAULT_ID = 0;
    public static final Boolean DEFAULT_IS_ON = false;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f content;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f extinfo;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_on;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ChatQuickReply(Integer num, Integer num2, f fVar, f fVar2, Boolean bool, Integer num3) {
        this.id = num;
        this.userid = num2;
        this.content = fVar;
        this.extinfo = fVar2;
        this.is_on = bool;
        this.mtime = num3;
    }

    private ChatQuickReply(Builder builder) {
        this(builder.id, builder.userid, builder.content, builder.extinfo, builder.is_on, builder.mtime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatQuickReply)) {
            return false;
        }
        ChatQuickReply chatQuickReply = (ChatQuickReply) obj;
        if (!equals((Object) this.id, (Object) chatQuickReply.id) || !equals((Object) this.userid, (Object) chatQuickReply.userid) || !equals((Object) this.content, (Object) chatQuickReply.content) || !equals((Object) this.extinfo, (Object) chatQuickReply.extinfo) || !equals((Object) this.is_on, (Object) chatQuickReply.is_on) || !equals((Object) this.mtime, (Object) chatQuickReply.mtime)) {
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
        f fVar = this.content;
        int hashCode3 = (hashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.extinfo;
        int hashCode4 = (hashCode3 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        Boolean bool = this.is_on;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.mtime;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatQuickReply> {
        public f content;
        public f extinfo;
        public Integer id;
        public Boolean is_on;
        public Integer mtime;
        public Integer userid;

        public Builder() {
        }

        public Builder(ChatQuickReply chatQuickReply) {
            super(chatQuickReply);
            if (chatQuickReply != null) {
                this.id = chatQuickReply.id;
                this.userid = chatQuickReply.userid;
                this.content = chatQuickReply.content;
                this.extinfo = chatQuickReply.extinfo;
                this.is_on = chatQuickReply.is_on;
                this.mtime = chatQuickReply.mtime;
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

        public Builder content(f fVar) {
            this.content = fVar;
            return this;
        }

        public Builder extinfo(f fVar) {
            this.extinfo = fVar;
            return this;
        }

        public Builder is_on(Boolean bool) {
            this.is_on = bool;
            return this;
        }

        public Builder mtime(Integer num) {
            this.mtime = num;
            return this;
        }

        public ChatQuickReply build() {
            return new ChatQuickReply(this);
        }
    }
}
