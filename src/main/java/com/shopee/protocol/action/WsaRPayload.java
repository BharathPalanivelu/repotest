package com.shopee.protocol.action;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import e.f;
import java.util.Collections;
import java.util.List;

public final class WsaRPayload extends Message {
    public static final String DEFAULT_DST = "";
    public static final List<KV> DEFAULT_KV_LIST = Collections.emptyList();
    public static final f DEFAULT_RAW_PAYLOAD = f.f32736b;
    public static final String DEFAULT_V = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String dst;
    @ProtoField(label = Message.Label.REPEATED, messageType = KV.class, tag = 3)
    public final List<KV> kv_list;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final f raw_payload;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String v;

    public WsaRPayload(String str, String str2, List<KV> list, f fVar) {
        this.v = str;
        this.dst = str2;
        this.kv_list = immutableCopyOf(list);
        this.raw_payload = fVar;
    }

    private WsaRPayload(Builder builder) {
        this(builder.v, builder.dst, builder.kv_list, builder.raw_payload);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WsaRPayload)) {
            return false;
        }
        WsaRPayload wsaRPayload = (WsaRPayload) obj;
        if (!equals((Object) this.v, (Object) wsaRPayload.v) || !equals((Object) this.dst, (Object) wsaRPayload.dst) || !equals((List<?>) this.kv_list, (List<?>) wsaRPayload.kv_list) || !equals((Object) this.raw_payload, (Object) wsaRPayload.raw_payload)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.v;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.dst;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<KV> list = this.kv_list;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        f fVar = this.raw_payload;
        if (fVar != null) {
            i2 = fVar.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<WsaRPayload> {
        public String dst;
        public List<KV> kv_list;
        public f raw_payload;
        public String v;

        public Builder() {
        }

        public Builder(WsaRPayload wsaRPayload) {
            super(wsaRPayload);
            if (wsaRPayload != null) {
                this.v = wsaRPayload.v;
                this.dst = wsaRPayload.dst;
                this.kv_list = WsaRPayload.copyOf(wsaRPayload.kv_list);
                this.raw_payload = wsaRPayload.raw_payload;
            }
        }

        public Builder v(String str) {
            this.v = str;
            return this;
        }

        public Builder dst(String str) {
            this.dst = str;
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

        public WsaRPayload build() {
            return new WsaRPayload(this);
        }
    }
}
