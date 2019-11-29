package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatItemLink extends Message {
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Long DEFAULT_ITEMID = 0L;
    public static final Long DEFAULT_PCHATID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long itemid;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long pchatid;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer userid;

    public ChatItemLink(Integer num, Long l, Integer num2, Long l2, Integer num3, Integer num4, Integer num5) {
        this.id = num;
        this.pchatid = l;
        this.shopid = num2;
        this.itemid = l2;
        this.userid = num3;
        this.status = num4;
        this.ctime = num5;
    }

    private ChatItemLink(Builder builder) {
        this(builder.id, builder.pchatid, builder.shopid, builder.itemid, builder.userid, builder.status, builder.ctime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatItemLink)) {
            return false;
        }
        ChatItemLink chatItemLink = (ChatItemLink) obj;
        if (!equals((Object) this.id, (Object) chatItemLink.id) || !equals((Object) this.pchatid, (Object) chatItemLink.pchatid) || !equals((Object) this.shopid, (Object) chatItemLink.shopid) || !equals((Object) this.itemid, (Object) chatItemLink.itemid) || !equals((Object) this.userid, (Object) chatItemLink.userid) || !equals((Object) this.status, (Object) chatItemLink.status) || !equals((Object) this.ctime, (Object) chatItemLink.ctime)) {
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
        Long l = this.pchatid;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.shopid;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.itemid;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num3 = this.userid;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        if (num5 != null) {
            i2 = num5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatItemLink> {
        public Integer ctime;
        public Integer id;
        public Long itemid;
        public Long pchatid;
        public Integer shopid;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ChatItemLink chatItemLink) {
            super(chatItemLink);
            if (chatItemLink != null) {
                this.id = chatItemLink.id;
                this.pchatid = chatItemLink.pchatid;
                this.shopid = chatItemLink.shopid;
                this.itemid = chatItemLink.itemid;
                this.userid = chatItemLink.userid;
                this.status = chatItemLink.status;
                this.ctime = chatItemLink.ctime;
            }
        }

        public Builder id(Integer num) {
            this.id = num;
            return this;
        }

        public Builder pchatid(Long l) {
            this.pchatid = l;
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

        public Builder userid(Integer num) {
            this.userid = num;
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

        public ChatItemLink build() {
            return new ChatItemLink(this);
        }
    }
}
