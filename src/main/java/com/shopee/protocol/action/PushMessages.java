package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class PushMessages extends Message {
    public static final List<f> DEFAULT_DEVICES = Collections.emptyList();
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_REQUESTID = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2)
    public final BackendParam bparam;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.BYTES)
    public final List<f> devices;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String requestid;

    public PushMessages(String str, BackendParam backendParam, List<f> list, String str2) {
        this.requestid = str;
        this.bparam = backendParam;
        this.devices = immutableCopyOf(list);
        this.msg = str2;
    }

    private PushMessages(Builder builder) {
        this(builder.requestid, builder.bparam, builder.devices, builder.msg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushMessages)) {
            return false;
        }
        PushMessages pushMessages = (PushMessages) obj;
        if (!equals((Object) this.requestid, (Object) pushMessages.requestid) || !equals((Object) this.bparam, (Object) pushMessages.bparam) || !equals((List<?>) this.devices, (List<?>) pushMessages.devices) || !equals((Object) this.msg, (Object) pushMessages.msg)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.requestid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        BackendParam backendParam = this.bparam;
        int hashCode2 = (hashCode + (backendParam != null ? backendParam.hashCode() : 0)) * 37;
        List<f> list = this.devices;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushMessages> {
        public BackendParam bparam;
        public List<f> devices;
        public String msg;
        public String requestid;

        public Builder() {
        }

        public Builder(PushMessages pushMessages) {
            super(pushMessages);
            if (pushMessages != null) {
                this.requestid = pushMessages.requestid;
                this.bparam = pushMessages.bparam;
                this.devices = PushMessages.copyOf(pushMessages.devices);
                this.msg = pushMessages.msg;
            }
        }

        public Builder requestid(String str) {
            this.requestid = str;
            return this;
        }

        public Builder bparam(BackendParam backendParam) {
            this.bparam = backendParam;
            return this;
        }

        public Builder devices(List<f> list) {
            this.devices = checkForNulls(list);
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public PushMessages build() {
            return new PushMessages(this);
        }
    }
}
