package com.squareup.wire;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import e.f;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

final class MessageAdapter<M extends Message> {
    private static final String FULL_BLOCK = "█";
    private static final String REDACTED = "██";
    private final Class<Message.Builder<M>> builderType;
    private final TagMap<FieldInfo> fieldInfoMap;
    private final Class<M> messageType;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Wire wire;

    public static final class FieldInfo {
        /* access modifiers changed from: private */
        public final Field builderField;
        /* access modifiers changed from: private */
        public final Method builderMethod;
        final Message.Datatype datatype;
        EnumAdapter<? extends ProtoEnum> enumAdapter;
        final Class<? extends ProtoEnum> enumType;
        final Message.Label label;
        MessageAdapter<? extends Message> messageAdapter;
        /* access modifiers changed from: private */
        public final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final boolean redacted;
        final int tag;

        private FieldInfo(int i, String str, Message.Datatype datatype2, Message.Label label2, boolean z, Class<?> cls, Field field, Field field2, Method method) {
            this.tag = i;
            this.name = str;
            this.datatype = datatype2;
            this.label = label2;
            this.redacted = z;
            if (datatype2 == Message.Datatype.ENUM) {
                this.enumType = cls;
                this.messageType = null;
            } else if (datatype2 == Message.Datatype.MESSAGE) {
                this.messageType = cls;
                this.enumType = null;
            } else {
                this.enumType = null;
                this.messageType = null;
            }
            this.messageField = field;
            this.builderField = field2;
            this.builderMethod = method;
        }
    }

    /* access modifiers changed from: package-private */
    public Message.Builder<M> newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InstantiationException e3) {
            throw new AssertionError(e3);
        }
    }

    /* access modifiers changed from: package-private */
    public Collection<FieldInfo> getFields() {
        return this.fieldInfoMap.values();
    }

    /* access modifiers changed from: package-private */
    public FieldInfo getField(String str) {
        Integer num = this.tagMap.get(str);
        if (num == null) {
            return null;
        }
        return this.fieldInfoMap.get(num.intValue());
    }

    /* access modifiers changed from: package-private */
    public Object getFieldValue(M m, FieldInfo fieldInfo) {
        if (fieldInfo.messageField != null) {
            try {
                return fieldInfo.messageField.get(m);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        } else {
            throw new AssertionError("Field is not of type \"Message\"");
        }
    }

    public void setBuilderField(Message.Builder<M> builder, FieldInfo fieldInfo, Object obj) {
        try {
            fieldInfo.builderField.set(builder, obj);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public void setBuilderMethod(Message.Builder<M> builder, FieldInfo fieldInfo, Object obj) {
        try {
            fieldInfo.builderMethod.invoke(builder, new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    MessageAdapter(Wire wire2, Class<M> cls) {
        Field[] fieldArr;
        int i;
        Class<M> cls2 = cls;
        this.wire = wire2;
        this.messageType = cls2;
        this.builderType = getBuilderType(cls2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field = declaredFields[i2];
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                int tag = protoField.tag();
                String name = field.getName();
                this.tagMap.put(name, Integer.valueOf(tag));
                Class cls3 = null;
                Message.Datatype type = protoField.type();
                if (type == Message.Datatype.ENUM) {
                    cls3 = getEnumType(field);
                } else if (type == Message.Datatype.MESSAGE) {
                    cls3 = getMessageType(field);
                }
                Integer valueOf = Integer.valueOf(tag);
                Message.Label label = protoField.label();
                boolean redacted = protoField.redacted();
                fieldArr = declaredFields;
                FieldInfo fieldInfo = r5;
                i = length;
                FieldInfo fieldInfo2 = new FieldInfo(tag, name, type, label, redacted, cls3, field, getBuilderField(name), getBuilderMethod(name, field.getType()));
                linkedHashMap.put(valueOf, fieldInfo);
            } else {
                fieldArr = declaredFields;
                i = length;
            }
            i2++;
            declaredFields = fieldArr;
            length = i;
        }
        this.fieldInfoMap = TagMap.of(linkedHashMap);
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            return Class.forName(cls.getName() + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Field getBuilderField(String str) {
        try {
            return this.builderType.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + this.builderType.getName() + "." + str);
        }
    }

    private Method getBuilderMethod(String str, Class<?> cls) {
        try {
            return this.builderType.getMethod(str, new Class[]{cls});
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + this.builderType.getName() + "." + str + SQLBuilder.PARENTHESES_LEFT + cls.getName() + SQLBuilder.PARENTHESES_RIGHT);
        }
    }

    private Class<? extends Message> getMessageType(Field field) {
        Class<?> type = field.getType();
        if (Message.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).messageType();
        }
        return null;
    }

    private Class<? extends Enum> getEnumType(Field field) {
        Class<?> type = field.getType();
        if (Enum.class.isAssignableFrom(type)) {
            return type;
        }
        if (List.class.isAssignableFrom(type)) {
            return ((ProtoField) field.getAnnotation(ProtoField.class)).enumType();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize(M m) {
        int i;
        int i2 = 0;
        for (FieldInfo next : getFields()) {
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                int i3 = next.tag;
                Message.Datatype datatype = next.datatype;
                Message.Label label = next.label;
                if (!label.isRepeated()) {
                    i = getSerializedSize(i3, fieldValue, datatype);
                } else if (label.isPacked()) {
                    i = getPackedSize((List) fieldValue, i3, datatype);
                } else {
                    i = getRepeatedSize((List) fieldValue, i3, datatype);
                }
                i2 += i;
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                i2 += getExtensionsSerializedSize(extendableMessage.extensionMap);
            }
        }
        return i2 + m.getUnknownFieldsSerializedSize();
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < extensionMap.size(); i3++) {
            Extension<T, ?> extension = extensionMap.getExtension(i3);
            Object extensionValue = extensionMap.getExtensionValue(i3);
            int tag = extension.getTag();
            Message.Datatype datatype = extension.getDatatype();
            Message.Label label = extension.getLabel();
            if (!label.isRepeated()) {
                i = getSerializedSize(tag, extensionValue, datatype);
            } else if (label.isPacked()) {
                i = getPackedSize((List) extensionValue, tag, datatype);
            } else {
                i = getRepeatedSize((List) extensionValue, tag, datatype);
            }
            i2 += i;
        }
        return i2;
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        for (Object serializedSize : list) {
            i2 += getSerializedSize(i, serializedSize, datatype);
        }
        return i2;
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        for (Object serializedSizeNoTag : list) {
            i2 += getSerializedSizeNoTag(serializedSizeNoTag, datatype);
        }
        return WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i2) + i2;
    }

    /* access modifiers changed from: package-private */
    public void write(M m, WireOutput wireOutput) throws IOException {
        for (FieldInfo next : getFields()) {
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                int i = next.tag;
                Message.Datatype datatype = next.datatype;
                Message.Label label = next.label;
                if (!label.isRepeated()) {
                    writeValue(wireOutput, i, fieldValue, datatype);
                } else if (label.isPacked()) {
                    writePacked(wireOutput, (List) fieldValue, i, datatype);
                } else {
                    writeRepeated(wireOutput, (List) fieldValue, i, datatype);
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                writeExtensions(wireOutput, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(wireOutput);
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
        for (int i = 0; i < extensionMap.size(); i++) {
            Extension<T, ?> extension = extensionMap.getExtension(i);
            Object extensionValue = extensionMap.getExtensionValue(i);
            int tag = extension.getTag();
            Message.Datatype datatype = extension.getDatatype();
            Message.Label label = extension.getLabel();
            if (!label.isRepeated()) {
                writeValue(wireOutput, tag, extensionValue, datatype);
            } else if (label.isPacked()) {
                writePacked(wireOutput, (List) extensionValue, tag, datatype);
            } else {
                writeRepeated(wireOutput, (List) extensionValue, tag, datatype);
            }
        }
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        for (Object writeValue : list) {
            writeValue(wireOutput, i, writeValue, datatype);
        }
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        int i2 = 0;
        for (Object serializedSizeNoTag : list) {
            i2 += getSerializedSizeNoTag(serializedSizeNoTag, datatype);
        }
        wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
        wireOutput.writeVarint32(i2);
        for (Object writeValueNoTag : list) {
            writeValueNoTag(wireOutput, writeValueNoTag, datatype);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] toByteArray(M m) {
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append("{");
        String str = "";
        for (FieldInfo next : getFields()) {
            Object fieldValue = getFieldValue(m, next);
            if (fieldValue != null) {
                sb.append(str);
                sb.append(next.name);
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                if (next.redacted) {
                    fieldValue = REDACTED;
                }
                sb.append(fieldValue);
                str = ", ";
            }
        }
        if (m instanceof ExtendableMessage) {
            sb.append(str);
            sb.append("{extensions=");
            sb.append(((ExtendableMessage) m).extensionsToString());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
    }

    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
        int utf8Length;
        int varint32Size;
        switch (datatype) {
            case INT32:
                return WireOutput.int32Size(((Integer) obj).intValue());
            case INT64:
            case UINT64:
                return WireOutput.varint64Size(((Long) obj).longValue());
            case UINT32:
                return WireOutput.varint32Size(((Integer) obj).intValue());
            case SINT32:
                return WireOutput.varint32Size(WireOutput.zigZag32(((Integer) obj).intValue()));
            case SINT64:
                return WireOutput.varint64Size(WireOutput.zigZag64(((Long) obj).longValue()));
            case BOOL:
                return 1;
            case ENUM:
                return getEnumSize((ProtoEnum) obj);
            case STRING:
                utf8Length = utf8Length((String) obj);
                varint32Size = WireOutput.varint32Size(utf8Length);
                break;
            case BYTES:
                utf8Length = ((f) obj).h();
                varint32Size = WireOutput.varint32Size(utf8Length);
                break;
            case MESSAGE:
                return getMessageSize((Message) obj);
            case FIXED32:
            case SFIXED32:
            case FLOAT:
                return 4;
            case FIXED64:
            case SFIXED64:
            case DOUBLE:
                return 8;
            default:
                throw new RuntimeException();
        }
        return varint32Size + utf8Length;
    }

    private int utf8Length(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    private <E extends ProtoEnum> int getEnumSize(E e2) {
        return WireOutput.varint32Size(this.wire.enumAdapter(e2.getClass()).toInt(e2));
    }

    private <MM extends Message> int getMessageSize(MM mm) {
        int serializedSize = mm.getSerializedSize();
        return WireOutput.varint32Size(serializedSize) + serializedSize;
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
    }

    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
                wireOutput.writeSignedVarint32(((Integer) obj).intValue());
                return;
            case INT64:
            case UINT64:
                wireOutput.writeVarint64(((Long) obj).longValue());
                return;
            case UINT32:
                wireOutput.writeVarint32(((Integer) obj).intValue());
                return;
            case SINT32:
                wireOutput.writeVarint32(WireOutput.zigZag32(((Integer) obj).intValue()));
                return;
            case SINT64:
                wireOutput.writeVarint64(WireOutput.zigZag64(((Long) obj).longValue()));
                return;
            case BOOL:
                wireOutput.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                return;
            case ENUM:
                writeEnum((ProtoEnum) obj, wireOutput);
                return;
            case STRING:
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                wireOutput.writeVarint32(bytes.length);
                wireOutput.writeRawBytes(bytes);
                return;
            case BYTES:
                f fVar = (f) obj;
                wireOutput.writeVarint32(fVar.h());
                wireOutput.writeRawBytes(fVar.i());
                return;
            case MESSAGE:
                writeMessage((Message) obj, wireOutput);
                return;
            case FIXED32:
            case SFIXED32:
                wireOutput.writeFixed32(((Integer) obj).intValue());
                return;
            case FLOAT:
                wireOutput.writeFixed32(Float.floatToIntBits(((Float) obj).floatValue()));
                return;
            case FIXED64:
            case SFIXED64:
                wireOutput.writeFixed64(((Long) obj).longValue());
                return;
            case DOUBLE:
                wireOutput.writeFixed64(Double.doubleToLongBits(((Double) obj).doubleValue()));
                return;
            default:
                throw new RuntimeException();
        }
    }

    private <MM extends Message> void writeMessage(MM mm, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(mm.getSerializedSize());
        this.wire.messageAdapter(mm.getClass()).write(mm, wireOutput);
    }

    private <E extends ProtoEnum> void writeEnum(E e2, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(this.wire.enumAdapter(e2.getClass()).toInt(e2));
    }

    /* access modifiers changed from: package-private */
    public M read(WireInput wireInput) throws IOException {
        Extension<ExtendableMessage<?>, ?> extension;
        Message.Label label;
        Message.Datatype datatype;
        long j;
        WireInput wireInput2 = wireInput;
        try {
            Message.Builder newInstance = this.builderType.newInstance();
            Storage storage = new Storage();
            while (true) {
                int readTag = wireInput.readTag();
                int i = readTag >> 3;
                WireType valueOf = WireType.valueOf(readTag);
                if (i == 0) {
                    for (Integer intValue : storage.getTags()) {
                        int intValue2 = intValue.intValue();
                        FieldInfo fieldInfo = this.fieldInfoMap.get(intValue2);
                        List<Object> list = storage.get(intValue2);
                        if (fieldInfo != null) {
                            setBuilderField(newInstance, fieldInfo, list);
                        } else {
                            setExtension((ExtendableMessage.ExtendableBuilder) newInstance, getExtension(intValue2), list);
                        }
                    }
                    return newInstance.build();
                }
                FieldInfo fieldInfo2 = this.fieldInfoMap.get(i);
                if (fieldInfo2 != null) {
                    datatype = fieldInfo2.datatype;
                    label = fieldInfo2.label;
                    extension = null;
                } else {
                    Extension<ExtendableMessage<?>, ?> extension2 = getExtension(i);
                    if (extension2 == null) {
                        readUnknownField(newInstance, wireInput2, i, valueOf);
                    } else {
                        Message.Datatype datatype2 = extension2.getDatatype();
                        Message.Label label2 = extension2.getLabel();
                        extension = extension2;
                        datatype = datatype2;
                        label = label2;
                    }
                }
                if (!label.isPacked() || valueOf != WireType.LENGTH_DELIMITED) {
                    Object readValue = readValue(wireInput2, i, datatype);
                    if (datatype == Message.Datatype.ENUM && (readValue instanceof Integer)) {
                        newInstance.addVarint(i, (long) ((Integer) readValue).intValue());
                    } else if (label.isRepeated()) {
                        storage.add(i, readValue);
                    } else if (extension != null) {
                        setExtension((ExtendableMessage.ExtendableBuilder) newInstance, extension, readValue);
                    } else if (label.isOneOf()) {
                        setBuilderMethod(newInstance, fieldInfo2, readValue);
                    } else {
                        setBuilderField(newInstance, fieldInfo2, readValue);
                    }
                } else {
                    int readVarint32 = wireInput.readVarint32();
                    long position = wireInput.getPosition();
                    int pushLimit = wireInput2.pushLimit(readVarint32);
                    while (true) {
                        j = ((long) readVarint32) + position;
                        if (wireInput.getPosition() >= j) {
                            break;
                        }
                        Object readValue2 = readValue(wireInput2, i, datatype);
                        if (datatype != Message.Datatype.ENUM || !(readValue2 instanceof Integer)) {
                            storage.add(i, readValue2);
                        } else {
                            newInstance.addVarint(i, (long) ((Integer) readValue2).intValue());
                        }
                    }
                    wireInput2.popLimit(pushLimit);
                    if (wireInput.getPosition() != j) {
                        throw new IOException("Packed data had wrong length!");
                    }
                }
            }
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    private Object readValue(WireInput wireInput, int i, Message.Datatype datatype) throws IOException {
        switch (datatype) {
            case INT32:
            case UINT32:
                return Integer.valueOf(wireInput.readVarint32());
            case INT64:
            case UINT64:
                return Long.valueOf(wireInput.readVarint64());
            case SINT32:
                return Integer.valueOf(WireInput.decodeZigZag32(wireInput.readVarint32()));
            case SINT64:
                return Long.valueOf(WireInput.decodeZigZag64(wireInput.readVarint64()));
            case BOOL:
                return Boolean.valueOf(wireInput.readVarint32() != 0);
            case ENUM:
                EnumAdapter<? extends ProtoEnum> enumAdapter = getEnumAdapter(i);
                int readVarint32 = wireInput.readVarint32();
                try {
                    return enumAdapter.fromInt(readVarint32);
                } catch (IllegalArgumentException unused) {
                    return Integer.valueOf(readVarint32);
                }
            case STRING:
                return wireInput.readString();
            case BYTES:
                return wireInput.readBytes();
            case MESSAGE:
                return readMessage(wireInput, i);
            case FIXED32:
            case SFIXED32:
                return Integer.valueOf(wireInput.readFixed32());
            case FLOAT:
                return Float.valueOf(Float.intBitsToFloat(wireInput.readFixed32()));
            case FIXED64:
            case SFIXED64:
                return Long.valueOf(wireInput.readFixed64());
            case DOUBLE:
                return Double.valueOf(Double.longBitsToDouble(wireInput.readFixed64()));
            default:
                throw new RuntimeException();
        }
    }

    private Message readMessage(WireInput wireInput, int i) throws IOException {
        int readVarint32 = wireInput.readVarint32();
        if (wireInput.recursionDepth < 64) {
            int pushLimit = wireInput.pushLimit(readVarint32);
            wireInput.recursionDepth++;
            Message read = getMessageAdapter(i).read(wireInput);
            wireInput.checkLastTagWas(0);
            wireInput.recursionDepth--;
            wireInput.popLimit(pushLimit);
            return read;
        }
        throw new IOException("Wire recursion limit exceeded");
    }

    private MessageAdapter<? extends Message> getMessageAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.messageAdapter != null) {
            return fieldInfo.messageAdapter;
        }
        MessageAdapter<? extends Message> messageAdapter = this.wire.messageAdapter(getMessageClass(i));
        if (fieldInfo != null) {
            fieldInfo.messageAdapter = messageAdapter;
        }
        return messageAdapter;
    }

    private EnumAdapter<? extends ProtoEnum> getEnumAdapter(int i) {
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo != null && fieldInfo.enumAdapter != null) {
            return fieldInfo.enumAdapter;
        }
        EnumAdapter<? extends ProtoEnum> enumAdapter = this.wire.enumAdapter(getEnumClass(i));
        if (fieldInfo != null) {
            fieldInfo.enumAdapter = enumAdapter;
        }
        return enumAdapter;
    }

    private Class<Message> getMessageClass(int i) {
        Class<? extends Message> cls;
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo == null) {
            cls = null;
        } else {
            cls = fieldInfo.messageType;
        }
        if (cls != null) {
            return cls;
        }
        Extension<ExtendableMessage<?>, ?> extension = getExtension(i);
        return extension != null ? extension.getMessageType() : cls;
    }

    private void readUnknownField(Message.Builder builder, WireInput wireInput, int i, WireType wireType) throws IOException {
        switch (wireType) {
            case VARINT:
                builder.ensureUnknownFieldMap().addVarint(i, Long.valueOf(wireInput.readVarint64()));
                return;
            case FIXED32:
                builder.ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(wireInput.readFixed32()));
                return;
            case FIXED64:
                builder.ensureUnknownFieldMap().addFixed64(i, Long.valueOf(wireInput.readFixed64()));
                return;
            case LENGTH_DELIMITED:
                builder.ensureUnknownFieldMap().addLengthDelimited(i, wireInput.readBytes(wireInput.readVarint32()));
                return;
            case START_GROUP:
                wireInput.skipGroup();
                return;
            case END_GROUP:
                return;
            default:
                throw new RuntimeException("Unsupported wire type: " + wireType);
        }
    }

    private static class Storage {
        private Map<Integer, ImmutableList<Object>> map;

        private Storage() {
        }

        /* access modifiers changed from: package-private */
        public void add(int i, Object obj) {
            Map<Integer, ImmutableList<Object>> map2 = this.map;
            ImmutableList immutableList = map2 == null ? null : map2.get(Integer.valueOf(i));
            if (immutableList == null) {
                immutableList = new ImmutableList();
                if (this.map == null) {
                    this.map = new LinkedHashMap();
                }
                this.map.put(Integer.valueOf(i), immutableList);
            }
            immutableList.list.add(obj);
        }

        /* access modifiers changed from: package-private */
        public Set<Integer> getTags() {
            Map<Integer, ImmutableList<Object>> map2 = this.map;
            if (map2 == null) {
                return Collections.emptySet();
            }
            return map2.keySet();
        }

        /* access modifiers changed from: package-private */
        public List<Object> get(int i) {
            Map<Integer, ImmutableList<Object>> map2 = this.map;
            if (map2 == null) {
                return null;
            }
            return map2.get(Integer.valueOf(i));
        }
    }

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, i);
    }

    /* access modifiers changed from: package-private */
    public Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, str);
    }

    private void setExtension(ExtendableMessage.ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        extendableBuilder.setExtension(extension, obj);
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        Class<? extends ProtoEnum> cls;
        FieldInfo fieldInfo = this.fieldInfoMap.get(i);
        if (fieldInfo == null) {
            cls = null;
        } else {
            cls = fieldInfo.enumType;
        }
        if (cls != null) {
            return cls;
        }
        Extension<ExtendableMessage<?>, ?> extension = getExtension(i);
        return extension != null ? extension.getEnumType() : cls;
    }

    static class ImmutableList<T> extends AbstractList<T> implements Serializable, Cloneable, RandomAccess {
        /* access modifiers changed from: private */
        public final List<T> list = new ArrayList();

        public Object clone() {
            return this;
        }

        ImmutableList() {
        }

        public int size() {
            return this.list.size();
        }

        public T get(int i) {
            return this.list.get(i);
        }
    }
}
