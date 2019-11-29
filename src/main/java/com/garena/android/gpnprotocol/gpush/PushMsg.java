package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PushMsg extends Message {
    public static final Long DEFAULT_GPID = 0L;
    public static final List<MsgType> DEFAULT_MSG = Collections.emptyList();
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long GPid;
    @ProtoField(label = Message.Label.REPEATED, messageType = MsgType.class, tag = 2)
    public final List<MsgType> Msg;

    public PushMsg(Long l, List<MsgType> list) {
        this.GPid = l;
        this.Msg = immutableCopyOf(list);
    }

    private PushMsg(Builder builder) {
        this(builder.GPid, builder.Msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushMsg)) {
            return false;
        }
        PushMsg pushMsg = (PushMsg) obj;
        if (!equals((Object) this.GPid, (Object) pushMsg.GPid) || !equals((List<?>) this.Msg, (List<?>) pushMsg.Msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.GPid;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<MsgType> list = this.Msg;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<PushMsg> {
        public Long GPid;
        public List<MsgType> Msg;

        public Builder() {
        }

        public Builder(PushMsg pushMsg) {
            super(pushMsg);
            if (pushMsg != null) {
                this.GPid = pushMsg.GPid;
                this.Msg = PushMsg.copyOf(pushMsg.Msg);
            }
        }

        public Builder GPid(Long l) {
            this.GPid = l;
            return this;
        }

        public Builder Msg(List<MsgType> list) {
            this.Msg = checkForNulls(list);
            return this;
        }

        public PushMsg build() {
            checkRequiredFields();
            return new PushMsg(this);
        }
    }
}
