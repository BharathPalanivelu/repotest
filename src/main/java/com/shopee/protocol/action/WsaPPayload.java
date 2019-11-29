package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class WsaPPayload extends Message {
    public static final List<KV> DEFAULT_KV_LIST = Collections.emptyList();
    public static final f DEFAULT_RAW_PAYLOAD = f.f32736b;
    public static final Integer DEFAULT_RETURN_CODE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = KV.class, tag = 2)
    public final List<KV> kv_list;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final f raw_payload;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer return_code;

    public WsaPPayload(Integer num, List<KV> list, f fVar) {
        this.return_code = num;
        this.kv_list = immutableCopyOf(list);
        this.raw_payload = fVar;
    }

    private WsaPPayload(Builder builder) {
        this(builder.return_code, builder.kv_list, builder.raw_payload);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WsaPPayload)) {
            return false;
        }
        WsaPPayload wsaPPayload = (WsaPPayload) obj;
        if (!equals((Object) this.return_code, (Object) wsaPPayload.return_code) || !equals((List<?>) this.kv_list, (List<?>) wsaPPayload.kv_list) || !equals((Object) this.raw_payload, (Object) wsaPPayload.raw_payload)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.return_code;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<KV> list = this.kv_list;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        f fVar = this.raw_payload;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WsaPPayload> {
        public List<KV> kv_list;
        public f raw_payload;
        public Integer return_code;

        public Builder() {
        }

        public Builder(WsaPPayload wsaPPayload) {
            super(wsaPPayload);
            if (wsaPPayload != null) {
                this.return_code = wsaPPayload.return_code;
                this.kv_list = WsaPPayload.copyOf(wsaPPayload.kv_list);
                this.raw_payload = wsaPPayload.raw_payload;
            }
        }

        public Builder return_code(Integer num) {
            this.return_code = num;
            return this;
        }

        public Builder kv_list(List<KV> list) {
            this.kv_list = checkForNulls(list);
            return this;
        }

        public Builder raw_payload(f fVar) {
            this.raw_payload = fVar;
            return this;
        }

        public WsaPPayload build() {
            return new WsaPPayload(this);
        }
    }
}
