package com.airpay.paysdk.libs.wire;

import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.Message.Builder;
import e.c;
import e.d;
import e.f;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;

public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize = 0;
    protected transient int hashCode = 0;
    private final transient f unknownFields;

    public abstract Builder<M, B> newBuilder();

    protected Message(ProtoAdapter<M> protoAdapter, f fVar) {
        if (protoAdapter == null) {
            throw new NullPointerException("adapter == null");
        } else if (fVar != null) {
            this.adapter = protoAdapter;
            this.unknownFields = fVar;
        } else {
            throw new NullPointerException("unknownFields == null");
        }
    }

    public final f unknownFields() {
        f fVar = this.unknownFields;
        return fVar != null ? fVar : f.f32736b;
    }

    public final M withoutUnknownFields() {
        return newBuilder().clearUnknownFields().build();
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    /* access modifiers changed from: protected */
    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(d dVar) throws IOException {
        this.adapter.encode(dVar, this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream outputStream) throws IOException {
        this.adapter.encode(outputStream, this);
    }

    public static abstract class Builder<T extends Message<T, B>, B extends Builder<T, B>> {
        c unknownFieldsBuffer;
        ProtoWriter unknownFieldsWriter;

        public abstract T build();

        protected Builder() {
        }

        public final Builder<T, B> addUnknownFields(f fVar) {
            if (fVar.h() > 0) {
                if (this.unknownFieldsWriter == null) {
                    this.unknownFieldsBuffer = new c();
                    this.unknownFieldsWriter = new ProtoWriter(this.unknownFieldsBuffer);
                }
                try {
                    this.unknownFieldsWriter.writeBytes(fVar);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final Builder<T, B> addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            if (this.unknownFieldsWriter == null) {
                this.unknownFieldsBuffer = new c();
                this.unknownFieldsWriter = new ProtoWriter(this.unknownFieldsBuffer);
            }
            try {
                fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final Builder<T, B> clearUnknownFields() {
            this.unknownFieldsWriter = null;
            this.unknownFieldsBuffer = null;
            return this;
        }

        public final f buildUnknownFields() {
            c cVar = this.unknownFieldsBuffer;
            return cVar != null ? cVar.clone().r() : f.f32736b;
        }
    }
}
