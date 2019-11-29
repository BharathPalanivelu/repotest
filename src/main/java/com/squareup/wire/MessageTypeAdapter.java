package com.squareup.wire;

import com.google.a.c.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.l;
import com.google.a.w;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import com.squareup.wire.MessageAdapter;
import com.squareup.wire.UnknownFieldMap;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class MessageTypeAdapter<M extends Message> extends w<M> {
    private static final BigInteger POWER_64 = new BigInteger("18446744073709551616");
    private final f gson;
    private final Class<M> type;
    private final Wire wire;

    public MessageTypeAdapter(Wire wire2, f fVar, a<M> aVar) {
        this.wire = wire2;
        this.gson = fVar;
        this.type = aVar.getRawType();
    }

    public void write(c cVar, M m) throws IOException {
        if (m == null) {
            cVar.f();
            return;
        }
        MessageAdapter<M> messageAdapter = this.wire.messageAdapter(m.getClass());
        cVar.d();
        for (MessageAdapter.FieldInfo next : messageAdapter.getFields()) {
            Object fieldValue = messageAdapter.getFieldValue(m, next);
            if (fieldValue != null) {
                cVar.a(next.name);
                emitJson(cVar, fieldValue, next.datatype, next.label);
            }
        }
        if (m instanceof ExtendableMessage) {
            emitExtensions((ExtendableMessage) m, cVar);
        }
        Collection<List<UnknownFieldMap.FieldValue>> unknownFields = m.unknownFields();
        if (unknownFields != null) {
            for (List<UnknownFieldMap.FieldValue> next2 : unknownFields) {
                int tag = ((UnknownFieldMap.FieldValue) next2.get(0)).getTag();
                cVar.a("" + tag);
                cVar.b();
                boolean z = true;
                for (UnknownFieldMap.FieldValue fieldValue2 : next2) {
                    int i = AnonymousClass1.$SwitchMap$com$squareup$wire$WireType[fieldValue2.getWireType().ordinal()];
                    if (i == 1) {
                        if (z) {
                            cVar.b("varint");
                        }
                        cVar.a((Number) fieldValue2.getAsLong());
                    } else if (i == 2) {
                        if (z) {
                            cVar.b("fixed32");
                        }
                        cVar.a((Number) fieldValue2.getAsInteger());
                    } else if (i == 3) {
                        if (z) {
                            cVar.b("fixed64");
                        }
                        cVar.a((Number) fieldValue2.getAsLong());
                    } else if (i == 4) {
                        if (z) {
                            cVar.b("length-delimited");
                        }
                        cVar.b(fieldValue2.getAsBytes().b());
                    } else {
                        throw new AssertionError("Unknown wire type " + fieldValue2.getWireType());
                    }
                    z = false;
                }
                cVar.c();
            }
        }
        cVar.e();
    }

    private <M extends ExtendableMessage<?>, E> void emitExtensions(ExtendableMessage<M> extendableMessage, c cVar) throws IOException {
        if (extendableMessage.extensionMap != null) {
            for (int i = 0; i < extendableMessage.extensionMap.size(); i++) {
                emitExtension(extendableMessage.extensionMap.getExtension(i), extendableMessage.extensionMap.getExtensionValue(i), cVar);
            }
        }
    }

    private <M extends ExtendableMessage<?>, E> void emitExtension(Extension<M, E> extension, E e2, c cVar) throws IOException {
        cVar.a(extension.getName());
        emitJson(cVar, e2, extension.getDatatype(), extension.getLabel());
    }

    private void emitJson(c cVar, Object obj, Message.Datatype datatype, Message.Label label) throws IOException {
        if (datatype != Message.Datatype.UINT64) {
            this.gson.a(obj, (Type) obj.getClass(), cVar);
        } else if (label.isRepeated()) {
            List list = (List) obj;
            cVar.b();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                emitUint64((Long) list.get(i), cVar);
            }
            cVar.c();
        } else {
            emitUint64((Long) obj, cVar);
        }
    }

    private void emitUint64(Long l, c cVar) throws IOException {
        if (l.longValue() < 0) {
            cVar.a((Number) POWER_64.add(BigInteger.valueOf(l.longValue())));
        } else {
            cVar.a((Number) l);
        }
    }

    public M read(com.google.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.j();
            return null;
        }
        MessageAdapter<M> messageAdapter = this.wire.messageAdapter(this.type);
        Message.Builder<M> newBuilder = messageAdapter.newBuilder();
        aVar.c();
        while (aVar.f() == b.NAME) {
            String g2 = aVar.g();
            MessageAdapter.FieldInfo field = messageAdapter.getField(g2);
            if (field == null) {
                Extension<ExtendableMessage<?>, ?> extension = messageAdapter.getExtension(g2);
                if (extension == null) {
                    parseUnknownField(aVar, newBuilder, Integer.parseInt(g2));
                } else {
                    ((ExtendableMessage.ExtendableBuilder) newBuilder).setExtension(extension, parseValue(extension.getLabel(), getType(extension), parse(aVar)));
                }
            } else {
                messageAdapter.setBuilderMethod(newBuilder, field, parseValue(field.label, getType(field), parse(aVar)));
            }
        }
        aVar.d();
        return newBuilder.build();
    }

    private l parse(com.google.a.d.a aVar) {
        return (l) this.gson.a(aVar, (Type) l.class);
    }

    private Type getType(MessageAdapter.FieldInfo fieldInfo) {
        if (fieldInfo.datatype == Message.Datatype.ENUM) {
            return fieldInfo.enumType;
        }
        if (fieldInfo.datatype == Message.Datatype.MESSAGE) {
            return fieldInfo.messageType;
        }
        return javaType(fieldInfo.datatype);
    }

    private Object parseValue(Message.Label label, Type type2, l lVar) {
        if (!label.isRepeated()) {
            return readJson(type2, lVar);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<l> it = lVar.n().iterator();
        while (it.hasNext()) {
            arrayList.add(readJson(type2, it.next()));
        }
        return arrayList;
    }

    private Type getType(Extension<ExtendableMessage<?>, ?> extension) {
        Message.Datatype datatype = extension.getDatatype();
        if (datatype == Message.Datatype.ENUM) {
            return extension.getEnumType();
        }
        if (datatype == Message.Datatype.MESSAGE) {
            return extension.getMessageType();
        }
        return javaType(datatype);
    }

    private void parseUnknownField(com.google.a.d.a aVar, Message.Builder<M> builder, int i) throws IOException {
        aVar.a();
        UnknownFieldMap.UnknownFieldType of = UnknownFieldMap.UnknownFieldType.of(aVar.h());
        while (aVar.f() != b.END_ARRAY) {
            int i2 = AnonymousClass1.$SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType[of.ordinal()];
            if (i2 == 1) {
                builder.addVarint(i, (long) aVar.m());
            } else if (i2 == 2) {
                builder.addFixed32(i, aVar.m());
            } else if (i2 == 3) {
                builder.addFixed64(i, (long) aVar.m());
            } else if (i2 == 4) {
                builder.addLengthDelimited(i, e.f.b(aVar.h()));
            } else {
                throw new AssertionError("Unknown field type " + of);
            }
        }
        aVar.b();
    }

    private Object readJson(Type type2, l lVar) {
        return this.gson.a(lVar, type2);
    }

    /* renamed from: com.squareup.wire.MessageTypeAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType = new int[UnknownFieldMap.UnknownFieldType.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType = new int[WireType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|(2:45|46)|47|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|(3:55|56|58)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|47|49|50|51|52|53|54|55|56|58) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x010e */
        static {
            /*
                com.squareup.wire.Message$Datatype[] r0 = com.squareup.wire.Message.Datatype.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$squareup$wire$Message$Datatype = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.squareup.wire.Message$Datatype r2 = com.squareup.wire.Message.Datatype.INT32     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x001f }
                com.squareup.wire.Message$Datatype r3 = com.squareup.wire.Message.Datatype.UINT32     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x002a }
                com.squareup.wire.Message$Datatype r4 = com.squareup.wire.Message.Datatype.SINT32     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.FIXED32     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x004b }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.INT64     // Catch:{ NoSuchFieldError -> 0x004b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.UINT64     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.SINT64     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x006e }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.FIXED64     // Catch:{ NoSuchFieldError -> 0x006e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r6 = 9
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x007a }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.SFIXED64     // Catch:{ NoSuchFieldError -> 0x007a }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r6 = 10
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.BOOL     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r6 = 11
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.FLOAT     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r6 = 12
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x009e }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.DOUBLE     // Catch:{ NoSuchFieldError -> 0x009e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r6 = 13
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.STRING     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r6 = 14
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r4 = $SwitchMap$com$squareup$wire$Message$Datatype     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.squareup.wire.Message$Datatype r5 = com.squareup.wire.Message.Datatype.BYTES     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r6 = 15
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                com.squareup.wire.UnknownFieldMap$UnknownFieldType[] r4 = com.squareup.wire.UnknownFieldMap.UnknownFieldType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType = r4
                int[] r4 = $SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType     // Catch:{ NoSuchFieldError -> 0x00c9 }
                com.squareup.wire.UnknownFieldMap$UnknownFieldType r5 = com.squareup.wire.UnknownFieldMap.UnknownFieldType.VARINT     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                int[] r4 = $SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType     // Catch:{ NoSuchFieldError -> 0x00d3 }
                com.squareup.wire.UnknownFieldMap$UnknownFieldType r5 = com.squareup.wire.UnknownFieldMap.UnknownFieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                int[] r4 = $SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType     // Catch:{ NoSuchFieldError -> 0x00dd }
                com.squareup.wire.UnknownFieldMap$UnknownFieldType r5 = com.squareup.wire.UnknownFieldMap.UnknownFieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r4 = $SwitchMap$com$squareup$wire$UnknownFieldMap$UnknownFieldType     // Catch:{ NoSuchFieldError -> 0x00e7 }
                com.squareup.wire.UnknownFieldMap$UnknownFieldType r5 = com.squareup.wire.UnknownFieldMap.UnknownFieldType.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x00e7 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e7 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00e7 }
            L_0x00e7:
                com.squareup.wire.WireType[] r4 = com.squareup.wire.WireType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$squareup$wire$WireType = r4
                int[] r4 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x00fa }
                com.squareup.wire.WireType r5 = com.squareup.wire.WireType.VARINT     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0104 }
                com.squareup.wire.WireType r4 = com.squareup.wire.WireType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x010e }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.FIXED64     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                int[] r0 = $SwitchMap$com$squareup$wire$WireType     // Catch:{ NoSuchFieldError -> 0x0118 }
                com.squareup.wire.WireType r1 = com.squareup.wire.WireType.LENGTH_DELIMITED     // Catch:{ NoSuchFieldError -> 0x0118 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0118 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0118 }
            L_0x0118:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.MessageTypeAdapter.AnonymousClass1.<clinit>():void");
        }
    }

    private Type javaType(Message.Datatype datatype) {
        switch (datatype) {
            case INT32:
            case UINT32:
            case SINT32:
            case FIXED32:
            case SFIXED32:
                return Integer.TYPE;
            case INT64:
            case UINT64:
            case SINT64:
            case FIXED64:
            case SFIXED64:
                return Long.TYPE;
            case BOOL:
                return Boolean.TYPE;
            case FLOAT:
                return Float.TYPE;
            case DOUBLE:
                return Double.TYPE;
            case STRING:
                return String.class;
            case BYTES:
                return e.f.class;
            default:
                throw new AssertionError("Unknown datatype: " + datatype);
        }
    }
}
