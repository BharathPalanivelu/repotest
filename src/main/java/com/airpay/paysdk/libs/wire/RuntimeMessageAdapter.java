package com.airpay.paysdk.libs.wire;

import com.airpay.paysdk.libs.wire.Message;
import com.airpay.paysdk.libs.wire.Message.Builder;
import com.airpay.paysdk.libs.wire.ProtoAdapter;
import com.airpay.paysdk.libs.wire.WireField;
import com.airpay.paysdk.libs.wire.internal.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> cls) {
        Class<B> builderType2 = getBuilderType(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Field field : cls.getDeclaredFields()) {
            WireField wireField = (WireField) field.getAnnotation(WireField.class);
            if (wireField != null) {
                linkedHashMap.put(Integer.valueOf(wireField.tag()), new FieldBinding(wireField, field, builderType2));
            }
        }
        return new RuntimeMessageAdapter<>(cls, builderType2, Collections.unmodifiableMap(linkedHashMap));
    }

    RuntimeMessageAdapter(Class<M> cls, Class<B> cls2, Map<Integer, FieldBinding<M, B>> map) {
        super(FieldEncoding.LENGTH_DELIMITED, cls);
        this.messageType = cls;
        this.builderType = cls2;
        this.fieldBindings = map;
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, FieldBinding<M, B>> fieldBindings() {
        return this.fieldBindings;
    }

    /* access modifiers changed from: package-private */
    public B newBuilder() {
        try {
            return (Message.Builder) this.builderType.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> cls) {
        try {
            return Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    public int encodedSize(M m) {
        int i = m.cachedSerializedSize;
        if (i != 0) {
            return i;
        }
        int i2 = 0;
        for (FieldBinding next : this.fieldBindings.values()) {
            Object obj = next.get(m);
            if (obj != null) {
                i2 += next.adapter().encodedSizeWithTag(next.tag, obj);
            }
        }
        int h = i2 + m.unknownFields().h();
        m.cachedSerializedSize = h;
        return h;
    }

    public void encode(ProtoWriter protoWriter, M m) throws IOException {
        for (FieldBinding next : this.fieldBindings.values()) {
            Object obj = next.get(m);
            if (obj != null) {
                next.adapter().encodeWithTag(protoWriter, next.tag, obj);
            }
        }
        protoWriter.writeBytes(m.unknownFields());
    }

    public M redact(M m) {
        Message.Builder newBuilder = m.newBuilder();
        for (FieldBinding next : this.fieldBindings.values()) {
            if (!next.redacted || next.label != WireField.Label.REQUIRED) {
                boolean isAssignableFrom = Message.class.isAssignableFrom(next.singleAdapter().javaType);
                if (next.redacted || (isAssignableFrom && !next.label.isRepeated())) {
                    Object fromBuilder = next.getFromBuilder(newBuilder);
                    if (fromBuilder != null) {
                        next.set(newBuilder, next.adapter().redact(fromBuilder));
                    }
                } else if (isAssignableFrom && next.label.isRepeated()) {
                    Internal.redactElements((List) next.getFromBuilder(newBuilder), next.singleAdapter());
                }
            } else {
                throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{next.name, this.javaType.getName()}));
            }
        }
        newBuilder.clearUnknownFields();
        return newBuilder.build();
    }

    public boolean equals(Object obj) {
        return (obj instanceof RuntimeMessageAdapter) && ((RuntimeMessageAdapter) obj).messageType == this.messageType;
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        for (FieldBinding next : this.fieldBindings.values()) {
            Object obj = next.get(m);
            if (obj != null) {
                sb.append(", ");
                sb.append(next.name);
                sb.append('=');
                if (next.redacted) {
                    obj = REDACTED;
                }
                sb.append(obj);
            }
        }
        sb.replace(0, 2, this.messageType.getSimpleName() + '{');
        sb.append('}');
        return sb.toString();
    }

    public M decode(ProtoReader protoReader) throws IOException {
        ProtoAdapter protoAdapter;
        Message.Builder newBuilder = newBuilder();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                FieldBinding fieldBinding = this.fieldBindings.get(Integer.valueOf(nextTag));
                if (fieldBinding != null) {
                    try {
                        if (fieldBinding.isMap()) {
                            protoAdapter = fieldBinding.adapter();
                        } else {
                            protoAdapter = fieldBinding.singleAdapter();
                        }
                        fieldBinding.value(newBuilder, protoAdapter.decode(protoReader));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                        newBuilder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf((long) e2.value));
                    }
                } else {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    newBuilder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newBuilder.build();
            }
        }
    }
}
