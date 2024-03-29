package com.squareup.wire;

import e.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class UnknownFieldMap {
    Map<Integer, List<FieldValue>> fieldMap;

    enum UnknownFieldType {
        VARINT,
        FIXED32,
        FIXED64,
        LENGTH_DELIMITED;

        public static UnknownFieldType of(String str) {
            if ("varint".equals(str)) {
                return VARINT;
            }
            if ("fixed32".equals(str)) {
                return FIXED32;
            }
            if ("fixed64".equals(str)) {
                return FIXED64;
            }
            if ("length-delimited".equals(str)) {
                return LENGTH_DELIMITED;
            }
            throw new IllegalArgumentException("Unknown type " + str);
        }
    }

    static abstract class FieldValue {
        private final int tag;
        private final WireType wireType;

        public abstract int getSerializedSize();

        public abstract void write(int i, WireOutput wireOutput) throws IOException;

        public FieldValue(int i, WireType wireType2) {
            this.tag = i;
            this.wireType = wireType2;
        }

        public static VarintFieldValue varint(int i, Long l) {
            return new VarintFieldValue(i, l);
        }

        public static Fixed32FieldValue fixed32(int i, Integer num) {
            return new Fixed32FieldValue(i, num);
        }

        public static Fixed64FieldValue fixed64(int i, Long l) {
            return new Fixed64FieldValue(i, l);
        }

        public static LengthDelimitedFieldValue lengthDelimited(int i, f fVar) {
            return new LengthDelimitedFieldValue(i, fVar);
        }

        public int getTag() {
            return this.tag;
        }

        public WireType getWireType() {
            return this.wireType;
        }

        public Integer getAsInteger() {
            throw new IllegalStateException();
        }

        public Long getAsLong() {
            throw new IllegalStateException();
        }

        public f getAsBytes() {
            throw new IllegalStateException();
        }
    }

    static final class VarintFieldValue extends FieldValue {
        private final Long value;

        public VarintFieldValue(int i, Long l) {
            super(i, WireType.VARINT);
            this.value = l;
        }

        public int getSerializedSize() {
            return WireOutput.varint64Size(this.value.longValue());
        }

        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.VARINT);
            wireOutput.writeVarint64(this.value.longValue());
        }

        public Long getAsLong() {
            return this.value;
        }
    }

    static final class Fixed32FieldValue extends FieldValue {
        private final Integer value;

        public int getSerializedSize() {
            return 4;
        }

        public Fixed32FieldValue(int i, Integer num) {
            super(i, WireType.FIXED32);
            this.value = num;
        }

        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED32);
            wireOutput.writeFixed32(this.value.intValue());
        }

        public Integer getAsInteger() {
            return this.value;
        }
    }

    static final class Fixed64FieldValue extends FieldValue {
        private final Long value;

        public int getSerializedSize() {
            return 8;
        }

        public Fixed64FieldValue(int i, Long l) {
            super(i, WireType.FIXED64);
            this.value = l;
        }

        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.FIXED64);
            wireOutput.writeFixed64(this.value.longValue());
        }

        public Long getAsLong() {
            return this.value;
        }
    }

    static final class LengthDelimitedFieldValue extends FieldValue {
        private final f value;

        public LengthDelimitedFieldValue(int i, f fVar) {
            super(i, WireType.LENGTH_DELIMITED);
            this.value = fVar;
        }

        public int getSerializedSize() {
            return WireOutput.varint32Size(this.value.h()) + this.value.h();
        }

        public void write(int i, WireOutput wireOutput) throws IOException {
            wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
            wireOutput.writeVarint32(this.value.h());
            wireOutput.writeRawBytes(this.value.i());
        }

        public f getAsBytes() {
            return this.value;
        }
    }

    UnknownFieldMap() {
    }

    UnknownFieldMap(UnknownFieldMap unknownFieldMap) {
        if (unknownFieldMap.fieldMap != null) {
            ensureFieldMap().putAll(unknownFieldMap.fieldMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void addVarint(int i, Long l) throws IOException {
        addElement(ensureFieldMap(), i, l, WireType.VARINT);
    }

    /* access modifiers changed from: package-private */
    public void addFixed32(int i, Integer num) throws IOException {
        addElement(ensureFieldMap(), i, num, WireType.FIXED32);
    }

    /* access modifiers changed from: package-private */
    public void addFixed64(int i, Long l) throws IOException {
        addElement(ensureFieldMap(), i, l, WireType.FIXED64);
    }

    /* access modifiers changed from: package-private */
    public void addLengthDelimited(int i, f fVar) throws IOException {
        addElement(ensureFieldMap(), i, fVar, WireType.LENGTH_DELIMITED);
    }

    private Map<Integer, List<FieldValue>> ensureFieldMap() {
        if (this.fieldMap == null) {
            this.fieldMap = new TreeMap();
        }
        return this.fieldMap;
    }

    private <T> void addElement(Map<Integer, List<FieldValue>> map, int i, T t, WireType wireType) throws IOException {
        FieldValue fieldValue;
        List list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        int i2 = AnonymousClass1.$SwitchMap$com$squareup$wire$WireType[wireType.ordinal()];
        if (i2 == 1) {
            fieldValue = FieldValue.varint(i, (Long) t);
        } else if (i2 == 2) {
            fieldValue = FieldValue.fixed32(i, (Integer) t);
        } else if (i2 == 3) {
            fieldValue = FieldValue.fixed64(i, (Long) t);
        } else if (i2 == 4) {
            fieldValue = FieldValue.lengthDelimited(i, (f) t);
        } else {
            throw new IllegalArgumentException("Unsupported wireType = " + wireType);
        }
        if (list.size() <= 0 || ((FieldValue) list.get(0)).getWireType() == fieldValue.getWireType()) {
            list.add(fieldValue);
        } else {
            throw new IOException(String.format("Wire type %s differs from previous type %s for tag %s", new Object[]{fieldValue.getWireType(), ((FieldValue) list.get(0)).getWireType(), Integer.valueOf(i)}));
        }
    }

    /* renamed from: com.squareup.wire.UnknownFieldMap$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType = new int[WireType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.squareup.wire.WireType[] r0 = com.squareup.wire.WireType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$squareup$wire$WireType = r0
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.VARINT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.FIXED64     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.UnknownFieldMap.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public int getSerializedSize() {
        Map<Integer, List<FieldValue>> map = this.fieldMap;
        int i = 0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                for (FieldValue serializedSize : (List) next.getValue()) {
                    i = i + WireOutput.varintTagSize(((Integer) next.getKey()).intValue()) + serializedSize.getSerializedSize();
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void write(WireOutput wireOutput) throws IOException {
        Map<Integer, List<FieldValue>> map = this.fieldMap;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                int intValue = ((Integer) next.getKey()).intValue();
                for (FieldValue write : (List) next.getValue()) {
                    write.write(intValue, wireOutput);
                }
            }
        }
    }
}
