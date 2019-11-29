package com.shopee.protocol.shop;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class NotiMsg extends Message {
    public static final Integer DEFAULT_CMD = 0;
    public static final Integer DEFAULT_CTIME = 0;
    public static final f DEFAULT_MSG = f.f32736b;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_SHOPID = 0;
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer ctime;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f msg;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long msgid;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer shopid;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;

    public NotiMsg(Long l, Integer num, Integer num2, f fVar, Integer num3, Integer num4) {
        this.msgid = l;
        this.shopid = num;
        this.cmd = num2;
        this.msg = fVar;
        this.ctime = num3;
        this.status = num4;
    }

    private NotiMsg(Builder builder) {
        this(builder.msgid, builder.shopid, builder.cmd, builder.msg, builder.ctime, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NotiMsg)) {
            return false;
        }
        NotiMsg notiMsg = (NotiMsg) obj;
        if (!equals((Object) this.msgid, (Object) notiMsg.msgid) || !equals((Object) this.shopid, (Object) notiMsg.shopid) || !equals((Object) this.cmd, (Object) notiMsg.cmd) || !equals((Object) this.msg, (Object) notiMsg.msg) || !equals((Object) this.ctime, (Object) notiMsg.ctime) || !equals((Object) this.status, (Object) notiMsg.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.msgid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.shopid;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.cmd;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.msg;
        int hashCode4 = (hashCode3 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        Integer num3 = this.ctime;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.status;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<NotiMsg> {
        public Integer cmd;
        public Integer ctime;
        public f msg;
        public Long msgid;
        public Integer shopid;
        public Integer status;

        public Builder() {
        }

        public Builder(NotiMsg notiMsg) {
            super(notiMsg);
            if (notiMsg != null) {
                this.msgid = notiMsg.msgid;
                this.shopid = notiMsg.shopid;
                this.cmd = notiMsg.cmd;
                this.msg = notiMsg.msg;
                this.ctime = notiMsg.ctime;
                this.status = notiMsg.status;
            }
        }

        public Builder msgid(Long l) {
            this.msgid = l;
            return this;
        }

        public Builder shopid(Integer num) {
            this.shopid = num;
            return this;
        }

        public Builder cmd(Integer num) {
            this.cmd = num;
            return this;
        }

        public Builder msg(f fVar) {
            this.msg = fVar;
            return this;
        }

        public Builder ctime(Integer num) {
            this.ctime = num;
            return this;
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public NotiMsg build() {
            return new NotiMsg(this);
        }
    }
}
