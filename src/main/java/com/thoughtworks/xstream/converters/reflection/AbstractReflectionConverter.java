package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.Caching;
import com.thoughtworks.xstream.core.ReferencingMarshallingContext;
import com.thoughtworks.xstream.core.util.ArrayIterator;
import com.thoughtworks.xstream.core.util.SerializationMembers;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class AbstractReflectionConverter implements Converter, Caching {
    protected final Mapper mapper;
    private transient ReflectionProvider pureJavaReflectionProvider;
    protected final ReflectionProvider reflectionProvider;
    protected transient SerializationMembers serializationMembers = this.serializationMethodInvoker.serializationMembers;
    protected transient SerializationMethodInvoker serializationMethodInvoker = new SerializationMethodInvoker();

    /* access modifiers changed from: protected */
    public boolean shouldUnmarshalTransientFields() {
        return false;
    }

    public AbstractReflectionConverter(Mapper mapper2, ReflectionProvider reflectionProvider2) {
        this.mapper = mapper2;
        this.reflectionProvider = reflectionProvider2;
    }

    /* access modifiers changed from: protected */
    public boolean canAccess(Class cls) {
        try {
            this.reflectionProvider.getFieldOrNull(cls, "%");
            return true;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        Object callWriteReplace = this.serializationMembers.callWriteReplace(obj);
        if (callWriteReplace != obj && (marshallingContext instanceof ReferencingMarshallingContext)) {
            ((ReferencingMarshallingContext) marshallingContext).replace(obj, callWriteReplace);
        }
        if (callWriteReplace.getClass() != obj.getClass()) {
            String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("resolves-to");
            if (aliasForSystemAttribute != null) {
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(callWriteReplace.getClass()));
            }
            marshallingContext.convertAnother(callWriteReplace);
            return;
        }
        doMarshal(callWriteReplace, hierarchicalStreamWriter, marshallingContext);
    }

    /* access modifiers changed from: protected */
    public void doMarshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        final HashMap hashMap2 = hashMap;
        final Object obj2 = obj;
        final HierarchicalStreamWriter hierarchicalStreamWriter2 = hierarchicalStreamWriter;
        final ArrayList arrayList2 = arrayList;
        this.reflectionProvider.visitSerializableFields(obj, new ReflectionProvider.Visitor() {
            final Set writtenAttributes = new HashSet();

            public void visit(String str, Class cls, Class cls2, Object obj) {
                if (AbstractReflectionConverter.this.mapper.shouldSerializeMember(cls2, str)) {
                    if (!hashMap2.containsKey(str)) {
                        Class cls3 = obj2.getClass();
                        if (cls2 != obj2.getClass() && !AbstractReflectionConverter.this.mapper.shouldSerializeMember(cls3, str)) {
                            cls3 = cls2;
                        }
                        hashMap2.put(str, AbstractReflectionConverter.this.reflectionProvider.getField(cls3, str));
                    }
                    SingleValueConverter converterFromItemType = AbstractReflectionConverter.this.mapper.getConverterFromItemType(str, cls, cls2);
                    if (converterFromItemType != null) {
                        String aliasForAttribute = AbstractReflectionConverter.this.mapper.aliasForAttribute(AbstractReflectionConverter.this.mapper.serializedMember(cls2, str));
                        if (obj != null) {
                            if (!this.writtenAttributes.contains(str)) {
                                String singleValueConverter = converterFromItemType.toString(obj);
                                if (singleValueConverter != null) {
                                    hierarchicalStreamWriter2.addAttribute(aliasForAttribute, singleValueConverter);
                                }
                            } else {
                                throw new ConversionException("Cannot write field with name '" + str + "' twice as attribute for object of type " + obj2.getClass().getName());
                            }
                        }
                        this.writtenAttributes.add(str);
                        return;
                    }
                    arrayList2.add(new FieldInfo(str, cls, cls2, obj));
                }
            }
        });
        final ArrayList arrayList3 = arrayList;
        final MarshallingContext marshallingContext2 = marshallingContext;
        final HierarchicalStreamWriter hierarchicalStreamWriter3 = hierarchicalStreamWriter;
        final HashMap hashMap3 = hashMap;
        new Object(this) {
            final /* synthetic */ AbstractReflectionConverter this$0;

            {
                Iterator it;
                String str;
                Class cls;
                String str2;
                this.this$0 = r12;
                for (FieldInfo fieldInfo : arrayList3) {
                    if (fieldInfo.value != null) {
                        Mapper.ImplicitCollectionMapping implicitCollectionDefForFieldName = this.this$0.mapper.getImplicitCollectionDefForFieldName(obj2.getClass(), fieldInfo.fieldName);
                        if (implicitCollectionDefForFieldName != null) {
                            if (!(!(marshallingContext2 instanceof ReferencingMarshallingContext) || fieldInfo.value == Collections.EMPTY_LIST || fieldInfo.value == Collections.EMPTY_SET || fieldInfo.value == Collections.EMPTY_MAP)) {
                                ((ReferencingMarshallingContext) marshallingContext2).registerImplicit(fieldInfo.value);
                            }
                            boolean z = fieldInfo.value instanceof Collection;
                            boolean z2 = (fieldInfo.value instanceof Map) && implicitCollectionDefForFieldName.getKeyFieldName() == null;
                            if (fieldInfo.value.getClass().isArray()) {
                                it = new ArrayIterator(fieldInfo.value);
                            } else if (z) {
                                it = ((Collection) fieldInfo.value).iterator();
                            } else if (z2) {
                                it = ((Map) fieldInfo.value).entrySet().iterator();
                            } else {
                                it = ((Map) fieldInfo.value).values().iterator();
                            }
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (next == null) {
                                    cls = Object.class;
                                    str = this.this$0.mapper.serializedClass((Class) null);
                                } else if (z2) {
                                    if (implicitCollectionDefForFieldName.getItemFieldName() != null) {
                                        str2 = implicitCollectionDefForFieldName.getItemFieldName();
                                    } else {
                                        str2 = this.this$0.mapper.serializedClass(Map.Entry.class);
                                    }
                                    Map.Entry entry = (Map.Entry) next;
                                    ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter3, str2, entry.getClass());
                                    writeItem(entry.getKey(), marshallingContext2, hierarchicalStreamWriter3);
                                    writeItem(entry.getValue(), marshallingContext2, hierarchicalStreamWriter3);
                                    hierarchicalStreamWriter3.endNode();
                                } else if (implicitCollectionDefForFieldName.getItemFieldName() != null) {
                                    cls = implicitCollectionDefForFieldName.getItemType();
                                    str = implicitCollectionDefForFieldName.getItemFieldName();
                                } else {
                                    cls = next.getClass();
                                    str = this.this$0.mapper.serializedClass(cls);
                                }
                                writeField(fieldInfo.fieldName, str, cls, fieldInfo.definedIn, next);
                            }
                        } else {
                            writeField(fieldInfo.fieldName, (String) null, fieldInfo.type, fieldInfo.definedIn, fieldInfo.value);
                        }
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public void writeField(String str, String str2, Class cls, Class cls2, Object obj) {
                Class cls3 = obj != null ? obj.getClass() : cls;
                HierarchicalStreamWriter hierarchicalStreamWriter = hierarchicalStreamWriter3;
                if (str2 == null) {
                    str2 = this.this$0.mapper.serializedMember(obj2.getClass(), str);
                }
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, str2, cls3);
                if (obj != null) {
                    Class defaultImplementationOf = this.this$0.mapper.defaultImplementationOf(cls);
                    if (!cls3.equals(defaultImplementationOf)) {
                        String serializedClass = this.this$0.mapper.serializedClass(cls3);
                        if (!serializedClass.equals(this.this$0.mapper.serializedClass(defaultImplementationOf))) {
                            String aliasForSystemAttribute = this.this$0.mapper.aliasForSystemAttribute("class");
                            if (aliasForSystemAttribute != null) {
                                hierarchicalStreamWriter3.addAttribute(aliasForSystemAttribute, serializedClass);
                            }
                        }
                    }
                    if (((Field) hashMap3.get(str)).getDeclaringClass() != cls2) {
                        String aliasForSystemAttribute2 = this.this$0.mapper.aliasForSystemAttribute("defined-in");
                        if (aliasForSystemAttribute2 != null) {
                            hierarchicalStreamWriter3.addAttribute(aliasForSystemAttribute2, this.this$0.mapper.serializedClass(cls2));
                        }
                    }
                    this.this$0.marshallField(marshallingContext2, obj, this.this$0.reflectionProvider.getField(cls2, str));
                }
                hierarchicalStreamWriter3.endNode();
            }

            /* access modifiers changed from: package-private */
            public void writeItem(Object obj, MarshallingContext marshallingContext, HierarchicalStreamWriter hierarchicalStreamWriter) {
                if (obj == null) {
                    ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.this$0.mapper.serializedClass((Class) null), Mapper.Null.class);
                    hierarchicalStreamWriter.endNode();
                    return;
                }
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, this.this$0.mapper.serializedClass(obj.getClass()), obj.getClass());
                marshallingContext.convertAnother(obj);
                hierarchicalStreamWriter.endNode();
            }
        };
    }

    /* access modifiers changed from: protected */
    public void marshallField(MarshallingContext marshallingContext, Object obj, Field field) {
        marshallingContext.convertAnother(obj, this.mapper.getLocalConverter(field.getDeclaringClass(), field.getName()));
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return this.serializationMembers.callReadResolve(doUnmarshal(instantiateNewInstance(hierarchicalStreamReader, unmarshallingContext), hierarchicalStreamReader, unmarshallingContext));
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doUnmarshal(java.lang.Object r18, com.thoughtworks.xstream.io.HierarchicalStreamReader r19, com.thoughtworks.xstream.converters.UnmarshallingContext r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.Class r4 = r18.getClass()
            com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$3 r5 = new com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$3
            r5.<init>()
            java.util.Iterator r6 = r19.getAttributeNames()
        L_0x0015:
            boolean r7 = r6.hasNext()
            java.lang.String r8 = " to type "
            java.lang.String r9 = "Cannot convert type "
            if (r7 == 0) goto L_0x00af
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            com.thoughtworks.xstream.mapper.Mapper r10 = r0.mapper
            java.lang.String r11 = r10.attributeForAlias(r7)
            java.lang.String r10 = r10.realMember(r4, r11)
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r11 = r0.reflectionProvider
            java.lang.reflect.Field r11 = r11.getFieldOrNull(r4, r10)
            if (r11 == 0) goto L_0x0015
            boolean r12 = r0.shouldUnmarshalField(r11)
            if (r12 == 0) goto L_0x0015
            java.lang.Class r12 = r11.getDeclaringClass()
            com.thoughtworks.xstream.mapper.Mapper r13 = r0.mapper
            boolean r13 = r13.shouldSerializeMember(r12, r10)
            if (r13 != 0) goto L_0x004a
            goto L_0x0015
        L_0x004a:
            com.thoughtworks.xstream.mapper.Mapper r13 = r0.mapper
            java.lang.Class r14 = r11.getType()
            com.thoughtworks.xstream.converters.SingleValueConverter r13 = r13.getConverterFromAttribute(r12, r10, r14)
            java.lang.Class r11 = r11.getType()
            if (r13 == 0) goto L_0x0015
            java.lang.String r7 = r2.getAttribute((java.lang.String) r7)
            java.lang.Object r7 = r13.fromString(r7)
            boolean r13 = r11.isPrimitive()
            if (r13 == 0) goto L_0x006c
            java.lang.Class r11 = com.thoughtworks.xstream.core.util.Primitives.box(r11)
        L_0x006c:
            if (r7 == 0) goto L_0x00a0
            java.lang.Class r13 = r7.getClass()
            boolean r13 = r11.isAssignableFrom(r13)
            if (r13 == 0) goto L_0x0079
            goto L_0x00a0
        L_0x0079:
            com.thoughtworks.xstream.converters.ConversionException r1 = new com.thoughtworks.xstream.converters.ConversionException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.Class r3 = r7.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = r11.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x00a0:
            com.thoughtworks.xstream.core.util.FastField r8 = new com.thoughtworks.xstream.core.util.FastField
            r8.<init>((java.lang.Class) r12, (java.lang.String) r10)
            r5.add(r8)
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r8 = r0.reflectionProvider
            r8.writeField(r1, r10, r7, r12)
            goto L_0x0015
        L_0x00af:
            r7 = 0
        L_0x00b0:
            boolean r10 = r19.hasMoreChildren()
            if (r10 == 0) goto L_0x026d
            r19.moveDown()
            java.lang.String r10 = r19.getNodeName()
            java.lang.Class r11 = r0.readDeclaringClass(r2)
            if (r11 != 0) goto L_0x00c5
            r12 = r4
            goto L_0x00c6
        L_0x00c5:
            r12 = r11
        L_0x00c6:
            com.thoughtworks.xstream.mapper.Mapper r13 = r0.mapper
            java.lang.String r13 = r13.realMember(r12, r10)
            com.thoughtworks.xstream.mapper.Mapper r14 = r0.mapper
            com.thoughtworks.xstream.mapper.Mapper$ImplicitCollectionMapping r14 = r14.getImplicitCollectionDefForFieldName(r12, r13)
            if (r14 != 0) goto L_0x01db
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r14 = r0.reflectionProvider
            java.lang.reflect.Field r12 = r14.getFieldOrNull(r12, r13)
            if (r12 != 0) goto L_0x0165
            com.thoughtworks.xstream.mapper.Mapper r14 = r0.mapper
            java.lang.Class r14 = r14.getItemTypeForItemFieldName(r4, r13)
            if (r14 == 0) goto L_0x00f5
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.String r11 = com.thoughtworks.xstream.core.util.HierarchicalStreams.readClassAttribute(r2, r11)
            if (r11 == 0) goto L_0x00f3
            com.thoughtworks.xstream.mapper.Mapper r14 = r0.mapper
            java.lang.Class r11 = r14.realClass(r11)
            r14 = r11
        L_0x00f3:
            r6 = 0
            goto L_0x0120
        L_0x00f5:
            com.thoughtworks.xstream.mapper.Mapper r14 = r0.mapper     // Catch:{ CannotResolveClassException -> 0x010b }
            java.lang.Class r14 = r14.realClass(r10)     // Catch:{ CannotResolveClassException -> 0x010b }
            com.thoughtworks.xstream.mapper.Mapper r15 = r0.mapper     // Catch:{ CannotResolveClassException -> 0x010c }
            java.lang.Class r6 = r20.getRequiredType()     // Catch:{ CannotResolveClassException -> 0x010c }
            java.lang.String r6 = r15.getFieldNameForItemTypeAndName(r6, r14, r10)     // Catch:{ CannotResolveClassException -> 0x010c }
            r16 = r14
            r14 = r6
            r6 = r16
            goto L_0x010e
        L_0x010b:
            r14 = 0
        L_0x010c:
            r6 = r14
            r14 = 0
        L_0x010e:
            if (r6 == 0) goto L_0x011b
            if (r6 == 0) goto L_0x0115
            if (r14 != 0) goto L_0x0115
            goto L_0x011b
        L_0x0115:
            r16 = r14
            r14 = r6
            r6 = r16
            goto L_0x0120
        L_0x011b:
            r0.handleUnknownField(r11, r13, r4, r10)
            r6 = r14
            r14 = 0
        L_0x0120:
            if (r14 != 0) goto L_0x0125
            r11 = 0
            goto L_0x01fb
        L_0x0125:
            java.lang.Class<java.util.Map$Entry> r11 = java.util.Map.Entry.class
            boolean r11 = r11.equals(r14)
            if (r11 == 0) goto L_0x015f
            r19.moveDown()
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.Class r11 = com.thoughtworks.xstream.core.util.HierarchicalStreams.readClassType(r2, r11)
            java.lang.Object r11 = r3.convertAnother(r1, r11)
            r19.moveUp()
            r19.moveDown()
            com.thoughtworks.xstream.mapper.Mapper r15 = r0.mapper
            java.lang.Class r15 = com.thoughtworks.xstream.core.util.HierarchicalStreams.readClassType(r2, r15)
            java.lang.Object r15 = r3.convertAnother(r1, r15)
            r19.moveUp()
            java.util.Map r11 = java.util.Collections.singletonMap(r11, r15)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
            java.lang.Object r11 = r11.next()
            goto L_0x01fb
        L_0x015f:
            java.lang.Object r11 = r3.convertAnother(r1, r14)
            goto L_0x01fb
        L_0x0165:
            r6 = 0
            if (r11 != 0) goto L_0x0193
            r11 = 0
        L_0x0169:
            if (r12 == 0) goto L_0x0191
            boolean r11 = r0.shouldUnmarshalField(r12)
            if (r11 == 0) goto L_0x017f
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.Class r14 = r12.getDeclaringClass()
            boolean r11 = r11.shouldSerializeMember(r14, r13)
            if (r11 == 0) goto L_0x017f
            r11 = 1
            goto L_0x0180
        L_0x017f:
            r11 = 0
        L_0x0180:
            if (r11 != 0) goto L_0x0191
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r14 = r0.reflectionProvider
            java.lang.Class r12 = r12.getDeclaringClass()
            java.lang.Class r12 = r12.getSuperclass()
            java.lang.reflect.Field r12 = r14.getFieldOrNull(r12, r13)
            goto L_0x0169
        L_0x0191:
            r6 = r12
            goto L_0x0195
        L_0x0193:
            r6 = r12
            r11 = 0
        L_0x0195:
            if (r6 == 0) goto L_0x01d6
            if (r11 != 0) goto L_0x01ab
            boolean r11 = r0.shouldUnmarshalField(r6)
            if (r11 == 0) goto L_0x01d6
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.Class r12 = r6.getDeclaringClass()
            boolean r11 = r11.shouldSerializeMember(r12, r13)
            if (r11 == 0) goto L_0x01d6
        L_0x01ab:
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.String r11 = com.thoughtworks.xstream.core.util.HierarchicalStreams.readClassAttribute(r2, r11)
            if (r11 == 0) goto L_0x01ba
            com.thoughtworks.xstream.mapper.Mapper r12 = r0.mapper
            java.lang.Class r11 = r12.realClass(r11)
            goto L_0x01c4
        L_0x01ba:
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.Class r12 = r6.getType()
            java.lang.Class r11 = r11.defaultImplementationOf(r12)
        L_0x01c4:
            java.lang.Object r12 = r0.unmarshallField(r3, r1, r11, r6)
            java.lang.Class r14 = r6.getType()
            boolean r15 = r14.isPrimitive()
            if (r15 != 0) goto L_0x01d3
            goto L_0x01d4
        L_0x01d3:
            r14 = r11
        L_0x01d4:
            r11 = r12
            goto L_0x01d8
        L_0x01d6:
            r11 = 0
            r14 = 0
        L_0x01d8:
            r12 = r6
            r6 = 0
            goto L_0x01fb
        L_0x01db:
            java.lang.String r6 = r14.getFieldName()
            java.lang.Class r11 = r14.getItemType()
            if (r11 != 0) goto L_0x01f5
            com.thoughtworks.xstream.mapper.Mapper r11 = r0.mapper
            java.lang.String r11 = com.thoughtworks.xstream.core.util.HierarchicalStreams.readClassAttribute(r2, r11)
            com.thoughtworks.xstream.mapper.Mapper r12 = r0.mapper
            if (r11 == 0) goto L_0x01f0
            goto L_0x01f1
        L_0x01f0:
            r11 = r10
        L_0x01f1:
            java.lang.Class r11 = r12.realClass(r11)
        L_0x01f5:
            r14 = r11
            java.lang.Object r11 = r3.convertAnother(r1, r14)
            r12 = 0
        L_0x01fb:
            if (r11 == 0) goto L_0x022f
            java.lang.Class r15 = r11.getClass()
            boolean r15 = r14.isAssignableFrom(r15)
            if (r15 == 0) goto L_0x0208
            goto L_0x022f
        L_0x0208:
            com.thoughtworks.xstream.converters.ConversionException r1 = new com.thoughtworks.xstream.converters.ConversionException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.Class r3 = r11.getClass()
            java.lang.String r3 = r3.getName()
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = r14.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x022f:
            if (r12 == 0) goto L_0x0247
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r6 = r0.reflectionProvider
            java.lang.Class r10 = r12.getDeclaringClass()
            r6.writeField(r1, r13, r11, r10)
            com.thoughtworks.xstream.core.util.FastField r6 = new com.thoughtworks.xstream.core.util.FastField
            java.lang.Class r10 = r12.getDeclaringClass()
            r6.<init>((java.lang.Class) r10, (java.lang.String) r13)
            r5.add(r6)
            goto L_0x0268
        L_0x0247:
            if (r14 == 0) goto L_0x0268
            if (r6 != 0) goto L_0x025e
            com.thoughtworks.xstream.mapper.Mapper r6 = r0.mapper
            java.lang.Class r12 = r20.getRequiredType()
            if (r11 == 0) goto L_0x0258
            java.lang.Class r13 = r11.getClass()
            goto L_0x025a
        L_0x0258:
            java.lang.Class<com.thoughtworks.xstream.mapper.Mapper$Null> r13 = com.thoughtworks.xstream.mapper.Mapper.Null.class
        L_0x025a:
            java.lang.String r6 = r6.getFieldNameForItemTypeAndName(r12, r13, r10)
        L_0x025e:
            if (r7 != 0) goto L_0x0265
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
        L_0x0265:
            r0.writeValueToImplicitCollection(r11, r7, r1, r6)
        L_0x0268:
            r19.moveUp()
            goto L_0x00b0
        L_0x026d:
            if (r7 == 0) goto L_0x02a0
            java.util.Set r2 = r7.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0277:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x02a0
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getValue()
            boolean r5 = r4 instanceof com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.ArraysList
            if (r5 == 0) goto L_0x029e
            com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$ArraysList r4 = (com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.ArraysList) r4
            java.lang.Object r4 = r4.toPhysicalArray()
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r5 = r0.reflectionProvider
            java.lang.Object r3 = r3.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r6 = 0
            r5.writeField(r1, r3, r4, r6)
            goto L_0x0277
        L_0x029e:
            r6 = 0
            goto L_0x0277
        L_0x02a0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.doUnmarshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object unmarshallField(UnmarshallingContext unmarshallingContext, Object obj, Class cls, Field field) {
        return unmarshallingContext.convertAnother(obj, cls, this.mapper.getLocalConverter(field.getDeclaringClass(), field.getName()));
    }

    /* access modifiers changed from: protected */
    public boolean shouldUnmarshalField(Field field) {
        return !Modifier.isTransient(field.getModifiers()) || shouldUnmarshalTransientFields();
    }

    private void handleUnknownField(Class cls, String str, Class cls2, String str2) {
        if (cls == null) {
            Class cls3 = cls2;
            while (cls3 != null) {
                if (this.mapper.shouldSerializeMember(cls3, str2)) {
                    cls3 = cls3.getSuperclass();
                } else {
                    return;
                }
            }
        }
        throw new UnknownFieldException(cls2.getName(), str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.util.Collection} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeValueToImplicitCollection(java.lang.Object r6, java.util.Map r7, java.lang.Object r8, java.lang.String r9) {
        /*
            r5 = this;
            java.lang.Object r0 = r7.get(r9)
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 != 0) goto L_0x00a0
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r0 = r5.reflectionProvider
            r1 = 0
            java.lang.Class r0 = r0.getFieldType(r8, r9, r1)
            boolean r2 = r0.isArray()
            if (r2 == 0) goto L_0x001d
            com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$ArraysList r8 = new com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$ArraysList
            r8.<init>(r0)
            r0 = r8
            goto L_0x009d
        L_0x001d:
            com.thoughtworks.xstream.mapper.Mapper r2 = r5.mapper
            java.lang.Class r0 = r2.defaultImplementationOf(r0)
            java.lang.Class<java.util.Collection> r2 = java.util.Collection.class
            boolean r2 = r2.isAssignableFrom(r0)
            if (r2 != 0) goto L_0x0067
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            boolean r2 = r2.isAssignableFrom(r0)
            if (r2 == 0) goto L_0x0034
            goto L_0x0067
        L_0x0034:
            com.thoughtworks.xstream.converters.reflection.ObjectAccessException r6 = new com.thoughtworks.xstream.converters.reflection.ObjectAccessException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "Field "
            r7.append(r1)
            r7.append(r9)
            java.lang.String r9 = " of "
            r7.append(r9)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r7.append(r8)
            java.lang.String r8 = " is configured for an implicit Collection or Map, but field is of type "
            r7.append(r8)
            java.lang.String r8 = r0.getName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0067:
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r2 = r5.pureJavaReflectionProvider
            if (r2 != 0) goto L_0x0072
            com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider r2 = new com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider
            r2.<init>()
            r5.pureJavaReflectionProvider = r2
        L_0x0072:
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r2 = r5.pureJavaReflectionProvider
            java.lang.Object r0 = r2.newInstance(r0)
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x0080
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            goto L_0x0097
        L_0x0080:
            com.thoughtworks.xstream.mapper.Mapper r2 = r5.mapper
            java.lang.Class r3 = r8.getClass()
            com.thoughtworks.xstream.mapper.Mapper$ImplicitCollectionMapping r2 = r2.getImplicitCollectionDefForFieldName(r3, r9)
            com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$MappingList r3 = new com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter$MappingList
            r4 = r0
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r2 = r2.getKeyFieldName()
            r3.<init>(r4, r2)
            r2 = r3
        L_0x0097:
            com.thoughtworks.xstream.converters.reflection.ReflectionProvider r3 = r5.reflectionProvider
            r3.writeField(r8, r9, r0, r1)
            r0 = r2
        L_0x009d:
            r7.put(r9, r0)
        L_0x00a0:
            r0.add(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter.writeValueToImplicitCollection(java.lang.Object, java.util.Map, java.lang.Object, java.lang.String):void");
    }

    private Class readDeclaringClass(HierarchicalStreamReader hierarchicalStreamReader) {
        String str;
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("defined-in");
        if (aliasForSystemAttribute == null) {
            str = null;
        } else {
            str = hierarchicalStreamReader.getAttribute(aliasForSystemAttribute);
        }
        if (str == null) {
            return null;
        }
        return this.mapper.realClass(str);
    }

    /* access modifiers changed from: protected */
    public Object instantiateNewInstance(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String str;
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("resolves-to");
        if (aliasForSystemAttribute == null) {
            str = null;
        } else {
            str = hierarchicalStreamReader.getAttribute(aliasForSystemAttribute);
        }
        Object currentObject = unmarshallingContext.currentObject();
        if (currentObject != null) {
            return currentObject;
        }
        if (str != null) {
            return this.reflectionProvider.newInstance(this.mapper.realClass(str));
        }
        return this.reflectionProvider.newInstance(unmarshallingContext.getRequiredType());
    }

    public void flushCache() {
        this.serializationMethodInvoker.flushCache();
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        this.serializationMethodInvoker = new SerializationMethodInvoker();
        this.serializationMembers = this.serializationMethodInvoker.serializationMembers;
        return this;
    }

    public static class DuplicateFieldException extends ConversionException {
        public DuplicateFieldException(String str) {
            super("Duplicate field " + str);
            add("field", str);
        }
    }

    public static class UnknownFieldException extends ConversionException {
        public UnknownFieldException(String str, String str2) {
            super("No such field " + str + "." + str2);
            add("field", str2);
        }
    }

    private static class FieldInfo {
        final Class definedIn;
        final String fieldName;
        final Class type;
        final Object value;

        FieldInfo(String str, Class cls, Class cls2, Object obj) {
            this.fieldName = str;
            this.type = cls;
            this.definedIn = cls2;
            this.value = obj;
        }
    }

    private static class ArraysList extends ArrayList {
        final Class physicalFieldType;

        ArraysList(Class cls) {
            this.physicalFieldType = cls;
        }

        /* access modifiers changed from: package-private */
        public Object toPhysicalArray() {
            Object[] array = toArray();
            Object newInstance = Array.newInstance(this.physicalFieldType.getComponentType(), array.length);
            if (this.physicalFieldType.getComponentType().isPrimitive()) {
                for (int i = 0; i < array.length; i++) {
                    Array.set(newInstance, i, Array.get(array, i));
                }
            } else {
                System.arraycopy(array, 0, newInstance, 0, array.length);
            }
            return newInstance;
        }
    }

    private class MappingList extends AbstractList {
        private final Map fieldCache = new HashMap();
        private final String keyFieldName;
        private final Map map;

        public MappingList(Map map2, String str) {
            this.map = map2;
            this.keyFieldName = str;
        }

        public boolean add(Object obj) {
            if (obj == null) {
                boolean z = !this.map.containsKey((Object) null);
                this.map.put((Object) null, (Object) null);
                return z;
            }
            Class<?> cls = obj.getClass();
            if (this.keyFieldName != null) {
                Field field = (Field) this.fieldCache.get(cls);
                if (field == null) {
                    field = AbstractReflectionConverter.this.reflectionProvider.getField(cls, this.keyFieldName);
                    this.fieldCache.put(cls, field);
                }
                if (field != null) {
                    try {
                        if (this.map.put(field.get(obj), obj) == null) {
                            return true;
                        }
                        return false;
                    } catch (IllegalArgumentException e2) {
                        throw new ObjectAccessException("Could not get field " + field.getClass() + "." + field.getName(), e2);
                    } catch (IllegalAccessException e3) {
                        throw new ObjectAccessException("Could not get field " + field.getClass() + "." + field.getName(), e3);
                    }
                }
            } else if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.map.put(entry.getKey(), entry.getValue()) == null) {
                    return true;
                }
                return false;
            }
            throw new ConversionException("Element of type " + obj.getClass().getName() + " is not defined as entry for map of type " + this.map.getClass().getName());
        }

        public Object get(int i) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.map.size();
        }
    }
}
