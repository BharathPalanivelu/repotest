package com.squareup.wire;

import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.chat.core.model.PreChatField;
import com.squareup.wire.MessageAdapter;
import com.squareup.wire.UnknownFieldMap;
import e.f;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Message implements Serializable {
    /* access modifiers changed from: private */
    public static final Wire WIRE = new Wire((Class<?>[]) new Class[0]);
    private static final long serialVersionUID = 0;
    private transient int cachedSerializedSize;
    protected transient int hashCode = 0;
    private transient boolean haveCachedSerializedSize;
    /* access modifiers changed from: private */
    public transient UnknownFieldMap unknownFields;

    public enum Datatype {
        INT32(1),
        INT64(2),
        UINT32(3),
        UINT64(4),
        SINT32(5),
        SINT64(6),
        BOOL(7),
        ENUM(8),
        STRING(9),
        BYTES(10),
        MESSAGE(11),
        FIXED32(12),
        SFIXED32(13),
        FIXED64(14),
        SFIXED64(15),
        FLOAT(16),
        DOUBLE(17);
        
        public static final Comparator<Datatype> ORDER_BY_NAME = null;
        private static final Map<String, Datatype> TYPES_BY_NAME = null;
        private final int value;

        static {
            ORDER_BY_NAME = new Comparator<Datatype>() {
                public int compare(Datatype datatype, Datatype datatype2) {
                    return datatype.name().compareTo(datatype2.name());
                }
            };
            TYPES_BY_NAME = new LinkedHashMap();
            TYPES_BY_NAME.put("int32", INT32);
            TYPES_BY_NAME.put("int64", INT64);
            TYPES_BY_NAME.put("uint32", UINT32);
            TYPES_BY_NAME.put("uint64", UINT64);
            TYPES_BY_NAME.put("sint32", SINT32);
            TYPES_BY_NAME.put("sint64", SINT64);
            TYPES_BY_NAME.put("bool", BOOL);
            TYPES_BY_NAME.put("enum", ENUM);
            TYPES_BY_NAME.put(PreChatField.STRING, STRING);
            TYPES_BY_NAME.put("bytes", BYTES);
            TYPES_BY_NAME.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, MESSAGE);
            TYPES_BY_NAME.put("fixed32", FIXED32);
            TYPES_BY_NAME.put("sfixed32", SFIXED32);
            TYPES_BY_NAME.put("fixed64", FIXED64);
            TYPES_BY_NAME.put("sfixed64", SFIXED64);
            TYPES_BY_NAME.put("float", FLOAT);
            TYPES_BY_NAME.put("double", DOUBLE);
        }

        private Datatype(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public WireType wireType() {
            switch (this) {
                case INT32:
                case INT64:
                case UINT32:
                case UINT64:
                case SINT32:
                case SINT64:
                case BOOL:
                case ENUM:
                    return WireType.VARINT;
                case FIXED32:
                case SFIXED32:
                case FLOAT:
                    return WireType.FIXED32;
                case FIXED64:
                case SFIXED64:
                case DOUBLE:
                    return WireType.FIXED64;
                case STRING:
                case BYTES:
                case MESSAGE:
                    return WireType.LENGTH_DELIMITED;
                default:
                    throw new AssertionError("No wiretype for datatype " + this);
            }
        }

        public static Datatype of(String str) {
            return TYPES_BY_NAME.get(str);
        }
    }

    public enum Label {
        REQUIRED(32),
        OPTIONAL(64),
        REPEATED(128),
        PACKED(256),
        ONE_OF(512);
        
        public static final Comparator<Label> ORDER_BY_NAME = null;
        private final int value;

        static {
            ORDER_BY_NAME = new Comparator<Label>() {
                public int compare(Label label, Label label2) {
                    return label.name().compareTo(label2.name());
                }
            };
        }

        private Label(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public boolean isRepeated() {
            return this == REPEATED || this == PACKED;
        }

        public boolean isPacked() {
            return this == PACKED;
        }

        public boolean isOneOf() {
            return this == ONE_OF;
        }
    }

    protected Message() {
    }

    /* access modifiers changed from: protected */
    public void setBuilder(Builder builder) {
        if (builder.unknownFieldMap != null) {
            this.unknownFields = new UnknownFieldMap(builder.unknownFieldMap);
        }
    }

    /* access modifiers changed from: protected */
    public Collection<List<UnknownFieldMap.FieldValue>> unknownFields() {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap == null) {
            return Collections.emptySet();
        }
        return unknownFieldMap.fieldMap.values();
    }

    /* access modifiers changed from: protected */
    public static <T> List<T> copyOf(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    protected static <T> List<T> immutableCopyOf(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        if (list instanceof MessageAdapter.ImmutableList) {
            return list;
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <E extends Enum & ProtoEnum> int intFromEnum(E e2) {
        return WIRE.enumAdapter(e2.getClass()).toInt((ProtoEnum) e2);
    }

    public static <E extends Enum & ProtoEnum> E enumFromInt(Class<E> cls, int i) {
        return (Enum) WIRE.enumAdapter(cls).fromInt(i);
    }

    public byte[] toByteArray() {
        return WIRE.messageAdapter(getClass()).toByteArray(this);
    }

    public void writeTo(byte[] bArr) {
        writeTo(bArr, 0, bArr.length);
    }

    public void writeTo(byte[] bArr, int i, int i2) {
        write(WireOutput.newInstance(bArr, i, i2));
    }

    private void write(WireOutput wireOutput) {
        try {
            WIRE.messageAdapter(getClass()).write(this, wireOutput);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void writeUnknownFieldMap(WireOutput wireOutput) throws IOException {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap != null) {
            unknownFieldMap.write(wireOutput);
        }
    }

    public int getSerializedSize() {
        if (!this.haveCachedSerializedSize) {
            this.cachedSerializedSize = WIRE.messageAdapter(getClass()).getSerializedSize(this);
            this.haveCachedSerializedSize = true;
        }
        return this.cachedSerializedSize;
    }

    public int getUnknownFieldsSerializedSize() {
        UnknownFieldMap unknownFieldMap = this.unknownFields;
        if (unknownFieldMap == null) {
            return 0;
        }
        return unknownFieldMap.getSerializedSize();
    }

    /* access modifiers changed from: protected */
    public boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* access modifiers changed from: protected */
    public boolean equals(List<?> list, List<?> list2) {
        if (list != null && list.isEmpty()) {
            list = null;
        }
        if (list2 != null && list2.isEmpty()) {
            list2 = null;
        }
        return list == list2 || (list != null && list.equals(list2));
    }

    public String toString() {
        return WIRE.messageAdapter(getClass()).toString(this);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(this, getClass());
    }

    public static abstract class Builder<T extends Message> {
        UnknownFieldMap unknownFieldMap;

        public abstract T build();

        public Builder() {
        }

        public Builder(Message message) {
            if (message != null && message.unknownFields != null) {
                this.unknownFieldMap = new UnknownFieldMap(message.unknownFields);
            }
        }

        public void addVarint(int i, long j) {
            try {
                ensureUnknownFieldMap().addVarint(i, Long.valueOf(j));
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        }

        public void addFixed32(int i, int i2) {
            try {
                ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(i2));
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        }

        public void addFixed64(int i, long j) {
            try {
                ensureUnknownFieldMap().addFixed64(i, Long.valueOf(j));
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        }

        public void addLengthDelimited(int i, f fVar) {
            try {
                ensureUnknownFieldMap().addLengthDelimited(i, fVar);
            } catch (IOException e2) {
                throw new IllegalArgumentException(e2.getMessage());
            }
        }

        /* access modifiers changed from: package-private */
        public UnknownFieldMap ensureUnknownFieldMap() {
            if (this.unknownFieldMap == null) {
                this.unknownFieldMap = new UnknownFieldMap();
            }
            return this.unknownFieldMap;
        }

        public void checkRequiredFields() {
            Message.WIRE.builderAdapter(getClass()).checkRequiredFields(this);
        }

        protected static <T> List<T> checkForNulls(List<T> list) {
            if (list != null && !list.isEmpty()) {
                int i = 0;
                int size = list.size();
                while (i < size) {
                    if (list.get(i) != null) {
                        i++;
                    } else {
                        throw new NullPointerException("Element at index " + i + " is null");
                    }
                }
            }
            return list;
        }
    }
}
