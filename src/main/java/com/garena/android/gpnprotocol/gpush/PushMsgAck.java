package com.garena.android.gpnprotocol.gpush;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PushMsgAck extends Message {
    public static final List<Integer> DEFAULT_FAILLIST = Collections.emptyList();
    public static final Integer DEFAULT_MSGID = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.UINT32)
    public final List<Integer> FailList;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer Msgid;

    public PushMsgAck(Integer num, List<Integer> list) {
        this.Msgid = num;
        this.FailList = immutableCopyOf(list);
    }

    private PushMsgAck(Builder builder) {
        this(builder.Msgid, builder.FailList);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushMsgAck)) {
            return false;
        }
        PushMsgAck pushMsgAck = (PushMsgAck) obj;
        if (!equals((Object) this.Msgid, (Object) pushMsgAck.Msgid) || !equals((List<?>) this.FailList, (List<?>) pushMsgAck.FailList)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.Msgid;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<Integer> list = this.FailList;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<PushMsgAck> {
        public List<Integer> FailList;
        public Integer Msgid;

        public Builder() {
        }

        public Builder(PushMsgAck pushMsgAck) {
            super(pushMsgAck);
            if (pushMsgAck != null) {
                this.Msgid = pushMsgAck.Msgid;
                this.FailList = PushMsgAck.copyOf(pushMsgAck.FailList);
            }
        }

        public Builder Msgid(Integer num) {
            this.Msgid = num;
            return this;
        }

        public Builder FailList(List<Integer> list) {
            this.FailList = checkForNulls(list);
            return this;
        }

        public PushMsgAck build() {
            checkRequiredFields();
            return new PushMsgAck(this);
        }
    }
}
