package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import com.thoughtworks.xstream.core.util.CustomObjectOutputStream;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputValidation;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializableConverter extends AbstractReflectionConverter {
    private static final String ATTRIBUTE_CLASS = "class";
    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_SERIALIZATION = "serialization";
    private static final String ATTRIBUTE_VALUE_CUSTOM = "custom";
    private static final String ELEMENT_DEFAULT = "default";
    private static final String ELEMENT_FIELD = "field";
    private static final String ELEMENT_FIELDS = "fields";
    private static final String ELEMENT_NULL = "null";
    private static final String ELEMENT_UNSERIALIZABLE_PARENTS = "unserializable-parents";
    private final ClassLoaderReference classLoaderReference;

    public SerializableConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoaderReference classLoaderReference2) {
        super(mapper, new UnserializableParentsReflectionProvider(reflectionProvider));
        this.classLoaderReference = classLoaderReference2;
    }

    public SerializableConverter(Mapper mapper, ReflectionProvider reflectionProvider, ClassLoader classLoader) {
        this(mapper, reflectionProvider, new ClassLoaderReference(classLoader));
    }

    public SerializableConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        this(mapper, (ReflectionProvider) new UnserializableParentsReflectionProvider(reflectionProvider), new ClassLoaderReference((ClassLoader) null));
    }

    public boolean canConvert(Class cls) {
        return JVM.canCreateDerivedObjectOutputStream() && isSerializable(cls);
    }

    private boolean isSerializable(Class cls) {
        if (cls == null || !Serializable.class.isAssignableFrom(cls) || cls.isInterface()) {
            return false;
        }
        if (!this.serializationMembers.supportsReadObject(cls, true) && !this.serializationMembers.supportsWriteObject(cls, true)) {
            return false;
        }
        for (Class isAssignableFrom : hierarchyFor(cls)) {
            if (!Serializable.class.isAssignableFrom(isAssignableFrom)) {
                return canAccess(cls);
            }
        }
        return true;
    }

    public void doMarshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(ATTRIBUTE_SERIALIZATION);
        if (aliasForSystemAttribute != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, ATTRIBUTE_VALUE_CUSTOM);
        }
        Class[] clsArr = new Class[1];
        boolean[] zArr = {false};
        final HierarchicalStreamWriter hierarchicalStreamWriter2 = hierarchicalStreamWriter;
        final MarshallingContext marshallingContext2 = marshallingContext;
        final Class[] clsArr2 = clsArr;
        final Object obj2 = obj;
        final boolean[] zArr2 = zArr;
        AnonymousClass1 r1 = new CustomObjectOutputStream.StreamCallback() {
            public void writeToStream(Object obj) {
                if (obj == null) {
                    hierarchicalStreamWriter2.startNode(SerializableConverter.ELEMENT_NULL);
                    hierarchicalStreamWriter2.endNode();
                    return;
                }
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, SerializableConverter.this.mapper.serializedClass(obj.getClass()), obj.getClass());
                marshallingContext2.convertAnother(obj);
                hierarchicalStreamWriter2.endNode();
            }

            public void writeFieldsToStream(Map map) {
                ObjectStreamClass lookup = ObjectStreamClass.lookup(clsArr2[0]);
                hierarchicalStreamWriter2.startNode(SerializableConverter.ELEMENT_DEFAULT);
                for (String str : map.keySet()) {
                    if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr2[0], str)) {
                        ObjectStreamField field = lookup.getField(str);
                        Object obj = map.get(str);
                        if (field == null) {
                            throw new ObjectAccessException("Class " + obj.getClass().getName() + " may not write a field named '" + str + "'");
                        } else if (obj != null) {
                            ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, SerializableConverter.this.mapper.serializedMember(obj2.getClass(), str), obj.getClass());
                            if (field.getType() != obj.getClass() && !field.getType().isPrimitive()) {
                                String aliasForSystemAttribute = SerializableConverter.this.mapper.aliasForSystemAttribute(SerializableConverter.ATTRIBUTE_CLASS);
                                if (aliasForSystemAttribute != null) {
                                    hierarchicalStreamWriter2.addAttribute(aliasForSystemAttribute, SerializableConverter.this.mapper.serializedClass(obj.getClass()));
                                }
                            }
                            marshallingContext2.convertAnother(obj);
                            hierarchicalStreamWriter2.endNode();
                        }
                    }
                }
                hierarchicalStreamWriter2.endNode();
            }

            public void defaultWriteObject() {
                ObjectStreamClass lookup = ObjectStreamClass.lookup(clsArr2[0]);
                if (lookup != null) {
                    ObjectStreamField[] fields = lookup.getFields();
                    boolean z = false;
                    for (ObjectStreamField objectStreamField : fields) {
                        Object access$000 = SerializableConverter.this.readField(objectStreamField, clsArr2[0], obj2);
                        if (access$000 != null) {
                            if (!zArr2[0]) {
                                hierarchicalStreamWriter2.startNode(SerializableConverter.this.mapper.serializedClass(clsArr2[0]));
                                zArr2[0] = true;
                            }
                            if (!z) {
                                hierarchicalStreamWriter2.startNode(SerializableConverter.ELEMENT_DEFAULT);
                                z = true;
                            }
                            if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr2[0], objectStreamField.getName())) {
                                Class<?> cls = access$000.getClass();
                                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, SerializableConverter.this.mapper.serializedMember(obj2.getClass(), objectStreamField.getName()), cls);
                                if (!cls.equals(SerializableConverter.this.mapper.defaultImplementationOf(objectStreamField.getType()))) {
                                    String aliasForSystemAttribute = SerializableConverter.this.mapper.aliasForSystemAttribute(SerializableConverter.ATTRIBUTE_CLASS);
                                    if (aliasForSystemAttribute != null) {
                                        hierarchicalStreamWriter2.addAttribute(aliasForSystemAttribute, SerializableConverter.this.mapper.serializedClass(cls));
                                    }
                                }
                                marshallingContext2.convertAnother(access$000);
                                hierarchicalStreamWriter2.endNode();
                            }
                        }
                    }
                    if (zArr2[0] && !z) {
                        hierarchicalStreamWriter2.startNode(SerializableConverter.ELEMENT_DEFAULT);
                        hierarchicalStreamWriter2.endNode();
                    } else if (z) {
                        hierarchicalStreamWriter2.endNode();
                    }
                }
            }

            public void flush() {
                hierarchicalStreamWriter2.flush();
            }

            public void close() {
                throw new UnsupportedOperationException("Objects are not allowed to call ObjectOutputStream.close() from writeObject()");
            }
        };
        try {
            boolean z = false;
            for (Class cls : hierarchyFor(obj.getClass())) {
                clsArr[0] = cls;
                if (!Serializable.class.isAssignableFrom(clsArr[0])) {
                    z = true;
                } else {
                    if (z) {
                        marshalUnserializableParent(hierarchicalStreamWriter, marshallingContext, obj);
                        z = false;
                    }
                    if (this.serializationMembers.supportsWriteObject(clsArr[0], false)) {
                        zArr[0] = true;
                        hierarchicalStreamWriter.startNode(this.mapper.serializedClass(clsArr[0]));
                        if (clsArr[0] != this.mapper.defaultImplementationOf(clsArr[0])) {
                            String aliasForSystemAttribute2 = this.mapper.aliasForSystemAttribute(ATTRIBUTE_CLASS);
                            if (aliasForSystemAttribute2 != null) {
                                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute2, clsArr[0].getName());
                            }
                        }
                        CustomObjectOutputStream instance = CustomObjectOutputStream.getInstance(marshallingContext, r1);
                        this.serializationMembers.callWriteObject(clsArr[0], obj, instance);
                        instance.popCallback();
                        hierarchicalStreamWriter.endNode();
                    } else if (this.serializationMembers.supportsReadObject(clsArr[0], false)) {
                        zArr[0] = true;
                        hierarchicalStreamWriter.startNode(this.mapper.serializedClass(clsArr[0]));
                        if (clsArr[0] != this.mapper.defaultImplementationOf(clsArr[0])) {
                            String aliasForSystemAttribute3 = this.mapper.aliasForSystemAttribute(ATTRIBUTE_CLASS);
                            if (aliasForSystemAttribute3 != null) {
                                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute3, clsArr[0].getName());
                            }
                        }
                        r1.defaultWriteObject();
                        hierarchicalStreamWriter.endNode();
                    } else {
                        zArr[0] = false;
                        r1.defaultWriteObject();
                        if (zArr[0]) {
                            hierarchicalStreamWriter.endNode();
                        }
                    }
                }
            }
        } catch (IOException e2) {
            throw new ObjectAccessException("Could not call defaultWriteObject()", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void marshalUnserializableParent(HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext, Object obj) {
        hierarchicalStreamWriter.startNode(ELEMENT_UNSERIALIZABLE_PARENTS);
        super.doMarshal(obj, hierarchicalStreamWriter, marshallingContext);
        hierarchicalStreamWriter.endNode();
    }

    /* access modifiers changed from: private */
    public Object readField(ObjectStreamField objectStreamField, Class cls, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(objectStreamField.getName());
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            return declaredField.get(obj);
        } catch (IllegalArgumentException e2) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e3);
        } catch (NoSuchFieldException e4) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e4);
        } catch (SecurityException e5) {
            throw new ObjectAccessException("Could not get field " + objectStreamField.getClass() + "." + objectStreamField.getName(), e5);
        }
    }

    /* access modifiers changed from: protected */
    public List hierarchyFor(Class<? super Object> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != Object.class && cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public Object doUnmarshal(Object obj, HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Class[] clsArr = new Class[1];
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute(ATTRIBUTE_SERIALIZATION);
        if (aliasForSystemAttribute == null || ATTRIBUTE_VALUE_CUSTOM.equals(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute))) {
            final HierarchicalStreamReader hierarchicalStreamReader2 = hierarchicalStreamReader;
            final UnmarshallingContext unmarshallingContext2 = unmarshallingContext;
            final Object obj2 = obj;
            final Class[] clsArr2 = clsArr;
            AnonymousClass2 r1 = new CustomObjectInputStream.StreamCallback() {
                public Object readFromStream() {
                    hierarchicalStreamReader2.moveDown();
                    Object convertAnother = unmarshallingContext2.convertAnother(obj2, HierarchicalStreams.readClassType(hierarchicalStreamReader2, SerializableConverter.this.mapper));
                    hierarchicalStreamReader2.moveUp();
                    return convertAnother;
                }

                public Map readFieldsFromStream() {
                    Class<?> cls;
                    HashMap hashMap = new HashMap();
                    hierarchicalStreamReader2.moveDown();
                    if (hierarchicalStreamReader2.getNodeName().equals("fields")) {
                        while (hierarchicalStreamReader2.hasMoreChildren()) {
                            hierarchicalStreamReader2.moveDown();
                            if (hierarchicalStreamReader2.getNodeName().equals(SerializableConverter.ELEMENT_FIELD)) {
                                hashMap.put(hierarchicalStreamReader2.getAttribute("name"), unmarshallingContext2.convertAnother(obj2, SerializableConverter.this.mapper.realClass(hierarchicalStreamReader2.getAttribute(SerializableConverter.ATTRIBUTE_CLASS))));
                                hierarchicalStreamReader2.moveUp();
                            } else {
                                throw new ConversionException("Expected <field/> element inside <field/>");
                            }
                        }
                    } else if (hierarchicalStreamReader2.getNodeName().equals(SerializableConverter.ELEMENT_DEFAULT)) {
                        ObjectStreamClass lookup = ObjectStreamClass.lookup(clsArr2[0]);
                        while (hierarchicalStreamReader2.hasMoreChildren()) {
                            hierarchicalStreamReader2.moveDown();
                            String realMember = SerializableConverter.this.mapper.realMember(clsArr2[0], hierarchicalStreamReader2.getNodeName());
                            if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr2[0], realMember)) {
                                String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader2, SerializableConverter.this.mapper);
                                if (readClassAttribute != null) {
                                    cls = SerializableConverter.this.mapper.realClass(readClassAttribute);
                                } else {
                                    ObjectStreamField field = lookup.getField(realMember);
                                    if (field != null) {
                                        cls = field.getType();
                                    } else {
                                        throw new MissingFieldException(clsArr2[0].getName(), realMember);
                                    }
                                }
                                hashMap.put(realMember, unmarshallingContext2.convertAnother(obj2, cls));
                            }
                            hierarchicalStreamReader2.moveUp();
                        }
                    } else {
                        throw new ConversionException("Expected <fields/> or <default/> element when calling ObjectInputStream.readFields()");
                    }
                    hierarchicalStreamReader2.moveUp();
                    return hashMap;
                }

                public void defaultReadObject() {
                    Class cls;
                    if (SerializableConverter.this.serializationMembers.getSerializablePersistentFields(clsArr2[0]) != null) {
                        readFieldsFromStream();
                    } else if (hierarchicalStreamReader2.hasMoreChildren()) {
                        hierarchicalStreamReader2.moveDown();
                        if (hierarchicalStreamReader2.getNodeName().equals(SerializableConverter.ELEMENT_DEFAULT)) {
                            while (hierarchicalStreamReader2.hasMoreChildren()) {
                                hierarchicalStreamReader2.moveDown();
                                String realMember = SerializableConverter.this.mapper.realMember(clsArr2[0], hierarchicalStreamReader2.getNodeName());
                                if (SerializableConverter.this.mapper.shouldSerializeMember(clsArr2[0], realMember)) {
                                    String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader2, SerializableConverter.this.mapper);
                                    if (readClassAttribute != null) {
                                        cls = SerializableConverter.this.mapper.realClass(readClassAttribute);
                                    } else {
                                        cls = SerializableConverter.this.mapper.defaultImplementationOf(SerializableConverter.this.reflectionProvider.getFieldType(obj2, realMember, clsArr2[0]));
                                    }
                                    SerializableConverter.this.reflectionProvider.writeField(obj2, realMember, unmarshallingContext2.convertAnother(obj2, cls), clsArr2[0]);
                                }
                                hierarchicalStreamReader2.moveUp();
                            }
                            hierarchicalStreamReader2.moveUp();
                            return;
                        }
                        throw new ConversionException("Expected <default/> element in readObject() stream");
                    }
                }

                public void registerValidation(final ObjectInputValidation objectInputValidation, int i) {
                    unmarshallingContext2.addCompletionCallback(new Runnable() {
                        public void run() {
                            try {
                                objectInputValidation.validateObject();
                            } catch (InvalidObjectException e2) {
                                throw new ObjectAccessException("Cannot validate object : " + e2.getMessage(), e2);
                            }
                        }
                    }, i);
                }

                public void close() {
                    throw new UnsupportedOperationException("Objects are not allowed to call ObjectInputStream.close() from readObject()");
                }
            };
            while (hierarchicalStreamReader.hasMoreChildren()) {
                hierarchicalStreamReader.moveDown();
                String nodeName = hierarchicalStreamReader.getNodeName();
                if (nodeName.equals(ELEMENT_UNSERIALIZABLE_PARENTS)) {
                    super.doUnmarshal(obj, hierarchicalStreamReader, unmarshallingContext);
                } else {
                    String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader, this.mapper);
                    if (readClassAttribute == null) {
                        clsArr[0] = this.mapper.defaultImplementationOf(this.mapper.realClass(nodeName));
                    } else {
                        clsArr[0] = this.mapper.realClass(readClassAttribute);
                    }
                    if (this.serializationMembers.supportsReadObject(clsArr[0], false)) {
                        CustomObjectInputStream instance = CustomObjectInputStream.getInstance((DataHolder) unmarshallingContext, (CustomObjectInputStream.StreamCallback) r1, this.classLoaderReference);
                        this.serializationMembers.callReadObject(clsArr[0], obj, instance);
                        instance.popCallback();
                    } else {
                        try {
                            r1.defaultReadObject();
                        } catch (IOException e2) {
                            throw new ObjectAccessException("Could not call defaultWriteObject()", e2);
                        }
                    }
                }
                hierarchicalStreamReader.moveUp();
            }
            return obj;
        }
        throw new ConversionException("Cannot deserialize object with new readObject()/writeObject() methods");
    }

    /* access modifiers changed from: protected */
    public void doMarshalConditionally(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (isSerializable(obj.getClass())) {
            doMarshal(obj, hierarchicalStreamWriter, marshallingContext);
        } else {
            super.doMarshal(obj, hierarchicalStreamWriter, marshallingContext);
        }
    }

    /* access modifiers changed from: protected */
    public Object doUnmarshalConditionally(Object obj, HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        return isSerializable(obj.getClass()) ? doUnmarshal(obj, hierarchicalStreamReader, unmarshallingContext) : super.doUnmarshal(obj, hierarchicalStreamReader, unmarshallingContext);
    }

    private static class UnserializableParentsReflectionProvider extends ReflectionProviderWrapper {
        public UnserializableParentsReflectionProvider(ReflectionProvider reflectionProvider) {
            super(reflectionProvider);
        }

        public void visitSerializableFields(Object obj, final ReflectionProvider.Visitor visitor) {
            this.wrapped.visitSerializableFields(obj, new ReflectionProvider.Visitor() {
                public void visit(String str, Class cls, Class cls2, Object obj) {
                    if (!Serializable.class.isAssignableFrom(cls2)) {
                        visitor.visit(str, cls, cls2, obj);
                    }
                }
            });
        }
    }
}
