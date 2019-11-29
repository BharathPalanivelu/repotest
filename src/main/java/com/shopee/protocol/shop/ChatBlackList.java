package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ChatBlackList extends Message {
    public static final Long DEFAULT_BLOCK_OPT = 0L;
    public static final Integer DEFAULT_BL_USERID = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final Integer DEFAULT_ID = 0;
    public static final Integer DEFAULT_MTIME = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_USERID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer bl_userid;
    @ProtoField(tag = 7, type = Message.Datatype.INT64)
    public final Long block_opt;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer id;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer mtime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userid;

    public ChatBlackList(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Long l) {
        this.id = num;
        this.userid = num2;
        this.bl_userid = num3;
        this.status = num4;
        this.ctime = num5;
        this.mtime = num6;
        this.block_opt = l;
    }

    private ChatBlackList(Builder builder) {
        this(builder.id, builder.userid, builder.bl_userid, builder.status, builder.ctime, builder.mtime, builder.block_opt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChatBlackList)) {
            return false;
        }
        ChatBlackList chatBlackList = (ChatBlackList) obj;
        if (!equals((Object) this.id, (Object) chatBlackList.id) || !equals((Object) this.userid, (Object) chatBlackList.userid) || !equals((Object) this.bl_userid, (Object) chatBlackList.bl_userid) || !equals((Object) this.status, (Object) chatBlackList.status) || !equals((Object) this.ctime, (Object) chatBlackList.ctime) || !equals((Object) this.mtime, (Object) chatBlackList.mtime) || !equals((Object) this.block_opt, (Object) chatBlackList.block_opt)) {
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
        Integer num3 = this.bl_userid;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.ctime;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.mtime;
        int hashCode6 = (hashCode5 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Long l = this.block_opt;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ChatBlackList> {
        public Integer bl_userid;
        public Long block_opt;
        public Integer ctime;
        public Integer id;
        public Integer mtime;
        public Integer status;
        public Integer userid;

        public Builder() {
        }

        public Builder(ChatBlackList chatBlackList) {
            super(chatBlackList);
            if (chatBlackList != null) {
                this.id = chatBlackList.id;
                this.userid = chatBlackList.userid;
                this.bl_userid = chatBlackList.bl_userid;
                this.status = chatBlackList.status;
                this.ctime = chatBlackList.ctime;
                this.mtime = chatBlackList.mtime;
                this.block_opt = chatBlackList.block_opt;
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

        public Builder bl_userid(Integer num) {
            this.bl_userid = num;
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

        public Builder block_opt(Long l) {
            this.block_opt = l;
            return this;
        }

        public ChatBlackList build() {
            return new ChatBlackList(this);
        }
    }
}
