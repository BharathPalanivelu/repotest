package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.FastField;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.Primitives;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ToAttributedValueConverter implements Converter {
    private static final String STRUCTURE_MARKER = "";
    /* access modifiers changed from: private */
    public final Mapper enumMapper;
    /* access modifiers changed from: private */
    public final ConverterLookup lookup;
    /* access modifiers changed from: private */
    public final Mapper mapper;
    /* access modifiers changed from: private */
    public final ReflectionProvider reflectionProvider;
    private final Class type;
    /* access modifiers changed from: private */
    public final Field valueField;

    public ToAttributedValueConverter(Class cls, Mapper mapper2, ReflectionProvider reflectionProvider2, ConverterLookup converterLookup, String str) {
        this(cls, mapper2, reflectionProvider2, converterLookup, str, (Class) null);
    }

    public ToAttributedValueConverter(Class cls, Mapper mapper2, ReflectionProvider reflectionProvider2, ConverterLookup converterLookup, String str, Class cls2) {
        this.type = cls;
        this.mapper = mapper2;
        this.reflectionProvider = reflectionProvider2;
        this.lookup = converterLookup;
        Mapper mapper3 = null;
        if (str == null) {
            this.valueField = null;
        } else {
            try {
                Field declaredField = (cls2 != null ? cls2 : cls).getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                this.valueField = declaredField;
            } catch (NoSuchFieldException e2) {
                throw new IllegalArgumentException(e2.getMessage() + ": " + str);
            }
        }
        this.enumMapper = JVM.is15() ? UseAttributeForEnumMapper.createEnumMapper(mapper2) : mapper3;
    }

    public boolean canConvert(Class cls) {
        return this.type == cls;
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        HierarchicalStreamWriter hierarchicalStreamWriter2 = hierarchicalStreamWriter;
        final Class<?> cls = obj.getClass();
        final HashMap hashMap = new HashMap();
        String[] strArr = new String[1];
        Object[] objArr = new Object[1];
        Class[] clsArr = new Class[1];
        final Class[] clsArr2 = new Class[1];
        final Class[] clsArr3 = clsArr;
        final Object[] objArr2 = objArr;
        final String[] strArr2 = strArr;
        final HierarchicalStreamWriter hierarchicalStreamWriter3 = hierarchicalStreamWriter;
        this.reflectionProvider.visitSerializableFields(obj, new ReflectionProvider.Visitor() {
            public void visit(String str, Class cls, Class cls2, Object obj) {
                Object obj2;
                if (ToAttributedValueConverter.this.mapper.shouldSerializeMember(cls2, str)) {
                    FastField fastField = new FastField(cls2, str);
                    String serializedMember = ToAttributedValueConverter.this.mapper.serializedMember(cls2, str);
                    if (!hashMap.containsKey(serializedMember)) {
                        hashMap.put(serializedMember, ToAttributedValueConverter.this.reflectionProvider.getField(cls, str));
                    } else if (!ToAttributedValueConverter.this.fieldIsEqual(fastField)) {
                        ConversionException conversionException = new ConversionException("Cannot write attribute twice for object");
                        conversionException.add("alias", serializedMember);
                        conversionException.add("type", cls.getName());
                        throw conversionException;
                    }
                    if (UseAttributeForEnumMapper.isEnum(cls)) {
                        obj2 = ToAttributedValueConverter.this.enumMapper.getConverterFromItemType((String) null, cls, (Class) null);
                    } else {
                        obj2 = ToAttributedValueConverter.this.mapper.getLocalConverter(cls2, str);
                    }
                    if (obj2 == null) {
                        obj2 = ToAttributedValueConverter.this.lookup.lookupConverterForType(cls);
                    }
                    if (obj != null) {
                        boolean z = ToAttributedValueConverter.this.valueField != null && ToAttributedValueConverter.this.fieldIsEqual(fastField);
                        if (z) {
                            clsArr2[0] = cls2;
                            clsArr3[0] = cls;
                            objArr2[0] = obj;
                            strArr2[0] = "";
                        }
                        if (obj2 instanceof SingleValueConverter) {
                            String singleValueConverter = ((SingleValueConverter) obj2).toString(obj);
                            if (z) {
                                strArr2[0] = singleValueConverter;
                            } else if (singleValueConverter != null) {
                                hierarchicalStreamWriter3.addAttribute(serializedMember, singleValueConverter);
                            }
                        } else if (!z) {
                            ConversionException conversionException2 = new ConversionException("Cannot write element as attribute");
                            conversionException2.add("alias", serializedMember);
                            conversionException2.add("type", cls.getName());
                            throw conversionException2;
                        }
                    }
                }
            }
        });
        if (strArr[0] != null) {
            Class<?> cls2 = objArr[0].getClass();
            Class defaultImplementationOf = this.mapper.defaultImplementationOf(clsArr[0]);
            if (!cls2.equals(defaultImplementationOf)) {
                String serializedClass = this.mapper.serializedClass(cls2);
                if (!serializedClass.equals(this.mapper.serializedClass(defaultImplementationOf))) {
                    String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("class");
                    if (aliasForSystemAttribute != null) {
                        hierarchicalStreamWriter2.addAttribute(aliasForSystemAttribute, serializedClass);
                    }
                }
            }
            if (strArr[0] == "") {
                marshallingContext.convertAnother(objArr[0]);
                return;
            }
            hierarchicalStreamWriter2.setValue(strArr[0]);
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Field field;
        Class cls;
        Class<?> cls2;
        HashSet hashSet;
        Iterator it;
        Object obj;
        HierarchicalStreamReader hierarchicalStreamReader2 = hierarchicalStreamReader;
        Object newInstance = this.reflectionProvider.newInstance(unmarshallingContext.getRequiredType());
        Class<?> cls3 = newInstance.getClass();
        HashSet hashSet2 = new HashSet();
        Iterator attributeNames = hierarchicalStreamReader.getAttributeNames();
        HashSet hashSet3 = new HashSet();
        hashSet3.add(this.mapper.aliasForSystemAttribute("class"));
        while (attributeNames.hasNext()) {
            String str = (String) attributeNames.next();
            if (!hashSet3.contains(str)) {
                String realMember = this.mapper.realMember(cls3, str);
                Field fieldOrNull = this.reflectionProvider.getFieldOrNull(cls3, realMember);
                if (fieldOrNull == null) {
                    cls2 = cls3;
                    it = attributeNames;
                    hashSet = hashSet3;
                } else if (Modifier.isTransient(fieldOrNull.getModifiers())) {
                    continue;
                } else {
                    it = attributeNames;
                    Class<?> type2 = fieldOrNull.getType();
                    Class<?> declaringClass = fieldOrNull.getDeclaringClass();
                    if (UseAttributeForEnumMapper.isEnum(type2)) {
                        hashSet = hashSet3;
                        cls2 = cls3;
                        obj = this.enumMapper.getConverterFromItemType((String) null, type2, (Class) null);
                    } else {
                        cls2 = cls3;
                        hashSet = hashSet3;
                        obj = this.mapper.getLocalConverter(declaringClass, realMember);
                    }
                    if (obj == null) {
                        obj = this.lookup.lookupConverterForType(type2);
                    }
                    if (!(obj instanceof SingleValueConverter)) {
                        ConversionException conversionException = new ConversionException("Cannot read field as a single value for object");
                        conversionException.add("field", realMember);
                        conversionException.add("type", cls2.getName());
                        throw conversionException;
                    } else if (obj != null) {
                        Object fromString = ((SingleValueConverter) obj).fromString(hierarchicalStreamReader2.getAttribute(str));
                        if (type2.isPrimitive()) {
                            type2 = Primitives.box(type2);
                        }
                        if (fromString == null || type2.isAssignableFrom(fromString.getClass())) {
                            this.reflectionProvider.writeField(newInstance, realMember, fromString, declaringClass);
                            if (!hashSet2.add(new FastField((Class) declaringClass, realMember))) {
                                throw new AbstractReflectionConverter.DuplicateFieldException(realMember + " [" + declaringClass.getName() + "]");
                            }
                        } else {
                            ConversionException conversionException2 = new ConversionException("Cannot assign object to type");
                            conversionException2.add("object type", fromString.getClass().getName());
                            conversionException2.add("target type", type2.getName());
                            throw conversionException2;
                        }
                    }
                }
                attributeNames = it;
                hashSet3 = hashSet;
                cls3 = cls2;
            }
        }
        Field field2 = this.valueField;
        if (field2 != null) {
            Class<?> declaringClass2 = field2.getDeclaringClass();
            String name = this.valueField.getName();
            if (name == null) {
                field = null;
            } else {
                field = this.reflectionProvider.getField(declaringClass2, name);
            }
            if (name == null || field == null) {
                UnmarshallingContext unmarshallingContext2 = unmarshallingContext;
                ConversionException conversionException3 = new ConversionException("Cannot assign value to field of type");
                conversionException3.add("element", hierarchicalStreamReader.getNodeName());
                conversionException3.add("field", name);
                conversionException3.add("target type", unmarshallingContext.getRequiredType().getName());
                throw conversionException3;
            }
            String readClassAttribute = HierarchicalStreams.readClassAttribute(hierarchicalStreamReader2, this.mapper);
            if (readClassAttribute != null) {
                cls = this.mapper.realClass(readClassAttribute);
            } else {
                cls = this.mapper.defaultImplementationOf(this.reflectionProvider.getFieldType(newInstance, name, declaringClass2));
            }
            Object convertAnother = unmarshallingContext.convertAnother(newInstance, cls, this.mapper.getLocalConverter(field.getDeclaringClass(), field.getName()));
            Class fieldType = this.reflectionProvider.getFieldType(newInstance, name, declaringClass2);
            if (!fieldType.isPrimitive()) {
                cls = fieldType;
            }
            if (convertAnother == null || cls.isAssignableFrom(convertAnother.getClass())) {
                this.reflectionProvider.writeField(newInstance, name, convertAnother, declaringClass2);
                if (!hashSet2.add(new FastField((Class) declaringClass2, name))) {
                    throw new AbstractReflectionConverter.DuplicateFieldException(name + " [" + declaringClass2.getName() + "]");
                }
            } else {
                ConversionException conversionException4 = new ConversionException("Cannot assign object to type");
                conversionException4.add("object type", convertAnother.getClass().getName());
                conversionException4.add("target type", cls.getName());
                throw conversionException4;
            }
        }
        return newInstance;
    }

    /* access modifiers changed from: private */
    public boolean fieldIsEqual(FastField fastField) {
        return this.valueField.getName().equals(fastField.getName()) && this.valueField.getDeclaringClass().getName().equals(fastField.getDeclaringClass());
    }
}
