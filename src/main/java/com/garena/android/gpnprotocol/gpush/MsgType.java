package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;

public final class MsgType extends Message {
    public static final Integer DEFAULT_APPID = 0;
    public static final f DEFAULT_DATA = f.f32736b;
    public static final Integer DEFAULT_MSGID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer Appid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final f Data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer Msgid;

    public MsgType(Integer num, Integer num2, f fVar) {
        this.Appid = num;
        this.Msgid = num2;
        this.Data = fVar;
    }

    private MsgType(Builder builder) {
        this(builder.Appid, builder.Msgid, builder.Data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MsgType)) {
            return false;
        }
        MsgType msgType = (MsgType) obj;
        if (!equals((Object) this.Appid, (Object) msgType.Appid) || !equals((Object) this.Msgid, (Object) msgType.Msgid) || !equals((Object) this.Data, (Object) msgType.Data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.Appid;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.Msgid;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        f fVar = this.Data;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MsgType> {
        public Integer Appid;
        public f Data;
        public Integer Msgid;

        public Builder() {
        }

        public Builder(MsgType msgType) {
            super(msgType);
            if (msgType != null) {
                this.Appid = msgType.Appid;
                this.Msgid = msgType.Msgid;
                this.Data = msgType.Data;
            }
        }

        public Builder Appid(Integer num) {
            this.Appid = num;
            return this;
        }

        public Builder Msgid(Integer num) {
            this.Msgid = num;
            return this;
        }

        public Builder Data(f fVar) {
            this.Data = fVar;
            return this;
        }

        public MsgType build() {
            checkRequiredFields();
            return new MsgType(this);
        }
    }
}
