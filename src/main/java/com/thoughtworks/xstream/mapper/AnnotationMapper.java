package com.thoughtworks.xstream.mapper;

import com.thoughtworks.xstream.InitializationException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAliasType;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamConverters;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.ConverterRegistry;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.SingleValueConverterWrapper;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.util.DependencyInjectionFactory;
import com.thoughtworks.xstream.core.util.TypedNull;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnnotationMapper extends MapperWrapper implements AnnotationConfiguration {
    /* access modifiers changed from: private */
    public final Set<Class<?>> annotatedTypes;
    private transient Object[] arguments;
    private transient AttributeMapper attributeMapper;
    private transient ClassAliasingMapper classAliasingMapper;
    private final Map<Class<?>, Map<List<Object>, Converter>> converterCache;
    private final ConverterRegistry converterRegistry;
    private transient DefaultImplementationsMapper defaultImplementationsMapper;
    private transient FieldAliasingMapper fieldAliasingMapper;
    private transient ImplicitCollectionMapper implicitCollectionMapper;
    private transient LocalConversionMapper localConversionMapper;
    private boolean locked;

    public AnnotationMapper(Mapper mapper, ConverterRegistry converterRegistry2, ConverterLookup converterLookup, ClassLoaderReference classLoaderReference, ReflectionProvider reflectionProvider) {
        super(mapper);
        this.converterCache = new HashMap();
        this.annotatedTypes = Collections.synchronizedSet(new HashSet());
        this.converterRegistry = converterRegistry2;
        this.annotatedTypes.add(Object.class);
        setupMappers();
        this.locked = true;
        Object reference = classLoaderReference.getReference();
        Object[] objArr = new Object[6];
        objArr[0] = this;
        objArr[1] = classLoaderReference;
        objArr[2] = reflectionProvider;
        objArr[3] = converterLookup;
        objArr[4] = new JVM();
        objArr[5] = reference == null ? new TypedNull(ClassLoader.class) : reference;
        this.arguments = objArr;
    }

    public AnnotationMapper(Mapper mapper, ConverterRegistry converterRegistry2, ConverterLookup converterLookup, ClassLoader classLoader, ReflectionProvider reflectionProvider, JVM jvm) {
        this(mapper, converterRegistry2, converterLookup, new ClassLoaderReference(classLoader), reflectionProvider);
    }

    public String realMember(Class cls, String str) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        return super.realMember(cls, str);
    }

    public String serializedClass(Class cls) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        return super.serializedClass(cls);
    }

    public Class defaultImplementationOf(Class cls) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        Class defaultImplementationOf = super.defaultImplementationOf(cls);
        if (!this.locked) {
            processAnnotations(defaultImplementationOf);
        }
        return defaultImplementationOf;
    }

    public Converter getLocalConverter(Class cls, String str) {
        if (!this.locked) {
            processAnnotations(cls);
        }
        return super.getLocalConverter(cls, str);
    }

    public void autodetectAnnotations(boolean z) {
        this.locked = !z;
    }

    public void processAnnotations(Class[] clsArr) {
        if (clsArr != null && clsArr.length != 0) {
            this.locked = true;
            UnprocessedTypesSet unprocessedTypesSet = new UnprocessedTypesSet();
            for (Class add : clsArr) {
                unprocessedTypesSet.add(add);
            }
            processTypes(unprocessedTypesSet);
        }
    }

    private void processAnnotations(Class cls) {
        if (cls != null) {
            UnprocessedTypesSet unprocessedTypesSet = new UnprocessedTypesSet();
            unprocessedTypesSet.add(cls);
            processTypes(unprocessedTypesSet);
        }
    }

    private void processTypes(Set<Class<?>> set) {
        while (!set.isEmpty()) {
            Iterator<Class<?>> it = set.iterator();
            Class next = it.next();
            it.remove();
            synchronized (next) {
                if (!this.annotatedTypes.contains(next)) {
                    try {
                        if (!next.isPrimitive()) {
                            addParametrizedTypes(next, set);
                            processConverterAnnotations(next);
                            processAliasAnnotation(next, set);
                            processAliasTypeAnnotation(next);
                            if (next.isInterface()) {
                                this.annotatedTypes.add(next);
                            } else {
                                processImplicitCollectionAnnotation(next);
                                Field[] declaredFields = next.getDeclaredFields();
                                for (Field field : declaredFields) {
                                    if (!field.isEnumConstant()) {
                                        if ((field.getModifiers() & 136) <= 0) {
                                            addParametrizedTypes(field.getGenericType(), set);
                                            if (!field.isSynthetic()) {
                                                processFieldAliasAnnotation(field);
                                                processAsAttributeAnnotation(field);
                                                processImplicitAnnotation(field);
                                                processOmitFieldAnnotation(field);
                                                processLocalConverterAnnotation(field);
                                            }
                                        }
                                    }
                                }
                                this.annotatedTypes.add(next);
                            }
                        }
                    } finally {
                        this.annotatedTypes.add(next);
                    }
                }
            }
        }
    }

    private void addParametrizedTypes(Type type, final Set<Class<?>> set) {
        final HashSet hashSet = new HashSet();
        AnonymousClass1 r1 = new LinkedHashSet<Type>() {
            public boolean add(Type type) {
                if (type instanceof Class) {
                    return set.add((Class) type);
                }
                if (type == null || hashSet.contains(type)) {
                    return false;
                }
                return super.add(type);
            }
        };
        while (type != null) {
            hashSet.add(type);
            int i = 0;
            if (type instanceof Class) {
                Class cls = (Class) type;
                set.add(cls);
                if (!cls.isPrimitive()) {
                    for (TypeVariable add : cls.getTypeParameters()) {
                        r1.add(add);
                    }
                    r1.add(cls.getGenericSuperclass());
                    Type[] genericInterfaces = cls.getGenericInterfaces();
                    int length = genericInterfaces.length;
                    while (i < length) {
                        r1.add(genericInterfaces[i]);
                        i++;
                    }
                }
            } else if (type instanceof TypeVariable) {
                Type[] bounds = ((TypeVariable) type).getBounds();
                int length2 = bounds.length;
                while (i < length2) {
                    r1.add(bounds[i]);
                    i++;
                }
            } else if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                r1.add(parameterizedType.getRawType());
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length3 = actualTypeArguments.length;
                while (i < length3) {
                    r1.add(actualTypeArguments[i]);
                    i++;
                }
            } else if (type instanceof GenericArrayType) {
                r1.add(((GenericArrayType) type).getGenericComponentType());
            }
            if (!r1.isEmpty()) {
                Iterator it = r1.iterator();
                it.remove();
                type = (Type) it.next();
            } else {
                type = null;
            }
        }
    }

    private void processConverterAnnotations(Class<?> cls) {
        if (this.converterRegistry != null) {
            XStreamConverters xStreamConverters = (XStreamConverters) cls.getAnnotation(XStreamConverters.class);
            XStreamConverter xStreamConverter = (XStreamConverter) cls.getAnnotation(XStreamConverter.class);
            ArrayList<XStreamConverter> arrayList = xStreamConverters != null ? new ArrayList<>(Arrays.asList(xStreamConverters.value())) : new ArrayList<>();
            if (xStreamConverter != null) {
                arrayList.add(xStreamConverter);
            }
            for (XStreamConverter xStreamConverter2 : arrayList) {
                Converter cacheConverter = cacheConverter(xStreamConverter2, xStreamConverter != null ? cls : null);
                if (cacheConverter != null) {
                    if (xStreamConverter != null || cacheConverter.canConvert(cls)) {
                        this.converterRegistry.registerConverter(cacheConverter, xStreamConverter2.priority());
                    } else {
                        throw new InitializationException("Converter " + xStreamConverter2.value().getName() + " cannot handle annotated class " + cls.getName());
                    }
                }
            }
        }
    }

    private void processAliasAnnotation(Class<?> cls, Set<Class<?>> set) {
        XStreamAlias xStreamAlias = (XStreamAlias) cls.getAnnotation(XStreamAlias.class);
        if (xStreamAlias != null) {
            ClassAliasingMapper classAliasingMapper2 = this.classAliasingMapper;
            if (classAliasingMapper2 != null) {
                classAliasingMapper2.addClassAlias(xStreamAlias.value(), cls);
                if (xStreamAlias.impl() != Void.class) {
                    this.defaultImplementationsMapper.addDefaultImplementation(xStreamAlias.impl(), cls);
                    if (cls.isInterface()) {
                        set.add(xStreamAlias.impl());
                        return;
                    }
                    return;
                }
                return;
            }
            throw new InitializationException("No " + ClassAliasingMapper.class.getName() + " available");
        }
    }

    private void processAliasTypeAnnotation(Class<?> cls) {
        XStreamAliasType xStreamAliasType = (XStreamAliasType) cls.getAnnotation(XStreamAliasType.class);
        if (xStreamAliasType != null) {
            ClassAliasingMapper classAliasingMapper2 = this.classAliasingMapper;
            if (classAliasingMapper2 != null) {
                classAliasingMapper2.addTypeAlias(xStreamAliasType.value(), cls);
                return;
            }
            throw new InitializationException("No " + ClassAliasingMapper.class.getName() + " available");
        }
    }

    @Deprecated
    private void processImplicitCollectionAnnotation(Class<?> cls) {
        XStreamImplicitCollection xStreamImplicitCollection = (XStreamImplicitCollection) cls.getAnnotation(XStreamImplicitCollection.class);
        if (xStreamImplicitCollection == null) {
            return;
        }
        if (this.implicitCollectionMapper != null) {
            String value = xStreamImplicitCollection.value();
            String item = xStreamImplicitCollection.item();
            try {
                Type genericType = cls.getDeclaredField(value).getGenericType();
                Class<?> cls2 = genericType instanceof ParameterizedType ? getClass(((ParameterizedType) genericType).getActualTypeArguments()[0]) : null;
                if (cls2 == null) {
                    this.implicitCollectionMapper.add(cls, value, (String) null, Object.class);
                } else if (item.equals("")) {
                    this.implicitCollectionMapper.add(cls, value, (String) null, cls2);
                } else {
                    this.implicitCollectionMapper.add(cls, value, item, cls2);
                }
            } catch (NoSuchFieldException unused) {
                throw new InitializationException(cls.getName() + " does not have a field named '" + value + "' as required by " + XStreamImplicitCollection.class.getName());
            }
        } else {
            throw new InitializationException("No " + ImplicitCollectionMapper.class.getName() + " available");
        }
    }

    private void processFieldAliasAnnotation(Field field) {
        XStreamAlias xStreamAlias = (XStreamAlias) field.getAnnotation(XStreamAlias.class);
        if (xStreamAlias != null) {
            FieldAliasingMapper fieldAliasingMapper2 = this.fieldAliasingMapper;
            if (fieldAliasingMapper2 != null) {
                fieldAliasingMapper2.addFieldAlias(xStreamAlias.value(), field.getDeclaringClass(), field.getName());
                return;
            }
            throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
        }
    }

    private void processAsAttributeAnnotation(Field field) {
        if (((XStreamAsAttribute) field.getAnnotation(XStreamAsAttribute.class)) != null) {
            AttributeMapper attributeMapper2 = this.attributeMapper;
            if (attributeMapper2 != null) {
                attributeMapper2.addAttributeFor(field);
                return;
            }
            throw new InitializationException("No " + AttributeMapper.class.getName() + " available");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processImplicitAnnotation(java.lang.reflect.Field r9) {
        /*
            r8 = this;
            java.lang.Class<com.thoughtworks.xstream.annotations.XStreamImplicit> r0 = com.thoughtworks.xstream.annotations.XStreamImplicit.class
            java.lang.annotation.Annotation r0 = r9.getAnnotation(r0)
            com.thoughtworks.xstream.annotations.XStreamImplicit r0 = (com.thoughtworks.xstream.annotations.XStreamImplicit) r0
            if (r0 == 0) goto L_0x00a9
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r1 = r8.implicitCollectionMapper
            if (r1 == 0) goto L_0x0087
            java.lang.String r4 = r9.getName()
            java.lang.String r1 = r0.itemFieldName()
            java.lang.String r0 = r0.keyFieldName()
            java.lang.Class<java.util.Map> r2 = java.util.Map.class
            java.lang.Class r3 = r9.getType()
            boolean r2 = r2.isAssignableFrom(r3)
            java.lang.Class r3 = r9.getType()
            boolean r3 = r3.isArray()
            r5 = 0
            if (r3 != 0) goto L_0x0045
            java.lang.reflect.Type r3 = r9.getGenericType()
            boolean r6 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r6 == 0) goto L_0x0045
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r3 = r3[r2]
            java.lang.Class r3 = r8.getClass(r3)
            r6 = r3
            goto L_0x0046
        L_0x0045:
            r6 = r5
        L_0x0046:
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x006b
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r2 = r8.implicitCollectionMapper
            java.lang.Class r9 = r9.getDeclaringClass()
            if (r1 == 0) goto L_0x0059
            boolean r7 = r3.equals(r1)
            if (r7 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r1 = r5
        L_0x005a:
            if (r0 == 0) goto L_0x0064
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0064
            r7 = r0
            goto L_0x0065
        L_0x0064:
            r7 = r5
        L_0x0065:
            r3 = r9
            r5 = r1
            r2.add(r3, r4, r5, r6, r7)
            goto L_0x00a9
        L_0x006b:
            if (r1 == 0) goto L_0x007d
            boolean r0 = r3.equals(r1)
            if (r0 != 0) goto L_0x007d
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r0 = r8.implicitCollectionMapper
            java.lang.Class r9 = r9.getDeclaringClass()
            r0.add(r9, r4, r1, r6)
            goto L_0x00a9
        L_0x007d:
            com.thoughtworks.xstream.mapper.ImplicitCollectionMapper r0 = r8.implicitCollectionMapper
            java.lang.Class r9 = r9.getDeclaringClass()
            r0.add(r9, r4, r6)
            goto L_0x00a9
        L_0x0087:
            com.thoughtworks.xstream.InitializationException r9 = new com.thoughtworks.xstream.InitializationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No "
            r0.append(r1)
            java.lang.Class<com.thoughtworks.xstream.mapper.ImplicitCollectionMapper> r1 = com.thoughtworks.xstream.mapper.ImplicitCollectionMapper.class
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = " available"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.thoughtworks.xstream.mapper.AnnotationMapper.processImplicitAnnotation(java.lang.reflect.Field):void");
    }

    private void processOmitFieldAnnotation(Field field) {
        if (((XStreamOmitField) field.getAnnotation(XStreamOmitField.class)) != null) {
            FieldAliasingMapper fieldAliasingMapper2 = this.fieldAliasingMapper;
            if (fieldAliasingMapper2 != null) {
                fieldAliasingMapper2.omitField(field.getDeclaringClass(), field.getName());
                return;
            }
            throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
        }
    }

    private void processLocalConverterAnnotation(Field field) {
        XStreamConverter xStreamConverter = (XStreamConverter) field.getAnnotation(XStreamConverter.class);
        if (xStreamConverter != null) {
            Converter cacheConverter = cacheConverter(xStreamConverter, field.getType());
            if (cacheConverter != null) {
                LocalConversionMapper localConversionMapper2 = this.localConversionMapper;
                if (localConversionMapper2 != null) {
                    localConversionMapper2.registerLocalConverter(field.getDeclaringClass(), field.getName(), cacheConverter);
                    return;
                }
                throw new InitializationException("No " + LocalConversionMapper.class.getName() + " available");
            }
        }
    }

    private Converter cacheConverter(XStreamConverter xStreamConverter, Class cls) {
        Object[] objArr;
        String str;
        Converter converter;
        ArrayList arrayList = new ArrayList();
        if (cls != null && xStreamConverter.useImplicitType()) {
            arrayList.add(cls);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(xStreamConverter.booleans());
        arrayList2.add(xStreamConverter.bytes());
        arrayList2.add(xStreamConverter.chars());
        arrayList2.add(xStreamConverter.doubles());
        arrayList2.add(xStreamConverter.floats());
        arrayList2.add(xStreamConverter.ints());
        arrayList2.add(xStreamConverter.longs());
        arrayList2.add(xStreamConverter.shorts());
        arrayList2.add(xStreamConverter.strings());
        arrayList2.add(xStreamConverter.types());
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                int length = Array.getLength(next);
                for (int i = 0; i < length; i++) {
                    Object obj = Array.get(next, i);
                    if (!arrayList.contains(obj)) {
                        arrayList.add(obj);
                    }
                }
            }
        }
        Class<? extends ConverterMatcher> value = xStreamConverter.value();
        Map map = this.converterCache.get(value);
        Converter converter2 = map != null ? (Converter) map.get(arrayList) : null;
        if (converter2 == null) {
            int size = arrayList.size();
            if (size > 0) {
                Object[] objArr2 = this.arguments;
                objArr = new Object[(objArr2.length + size)];
                System.arraycopy(objArr2, 0, objArr, size, objArr2.length);
                System.arraycopy(arrayList.toArray(new Object[size]), 0, objArr, 0, size);
            } else {
                objArr = this.arguments;
            }
            try {
                if (!SingleValueConverter.class.isAssignableFrom(value) || Converter.class.isAssignableFrom(value)) {
                    converter = (Converter) DependencyInjectionFactory.newInstance(value, objArr);
                } else {
                    converter = new SingleValueConverterWrapper((SingleValueConverter) DependencyInjectionFactory.newInstance(value, objArr));
                }
                if (map == null) {
                    map = new HashMap();
                    this.converterCache.put(value, map);
                }
                map.put(arrayList, converter2);
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate converter ");
                sb.append(value.getName());
                if (cls != null) {
                    str = " for type " + cls.getName();
                } else {
                    str = "";
                }
                sb.append(str);
                throw new InitializationException(sb.toString(), e2);
            }
        }
        return converter2;
    }

    private Class<?> getClass(Type type) {
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        return null;
    }

    private void setupMappers() {
        this.classAliasingMapper = (ClassAliasingMapper) lookupMapperOfType(ClassAliasingMapper.class);
        this.defaultImplementationsMapper = (DefaultImplementationsMapper) lookupMapperOfType(DefaultImplementationsMapper.class);
        this.implicitCollectionMapper = (ImplicitCollectionMapper) lookupMapperOfType(ImplicitCollectionMapper.class);
        this.fieldAliasingMapper = (FieldAliasingMapper) lookupMapperOfType(FieldAliasingMapper.class);
        this.attributeMapper = (AttributeMapper) lookupMapperOfType(AttributeMapper.class);
        this.localConversionMapper = (LocalConversionMapper) lookupMapperOfType(LocalConversionMapper.class);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = this.arguments.length - 2;
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeObject(this.arguments[i]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setupMappers();
        int readInt = objectInputStream.readInt();
        this.arguments = new Object[(readInt + 2)];
        for (int i = 0; i < readInt; i++) {
            this.arguments[i] = objectInputStream.readObject();
            Object[] objArr = this.arguments;
            if (objArr[i] instanceof ClassLoaderReference) {
                objArr[readInt + 1] = ((ClassLoaderReference) objArr[i]).getReference();
            }
        }
        this.arguments[readInt] = new JVM();
    }

    private final class UnprocessedTypesSet extends LinkedHashSet<Class<?>> {
        private UnprocessedTypesSet() {
        }

        public boolean add(Class<?> cls) {
            if (cls == null) {
                return false;
            }
            while (cls.isArray()) {
                cls = cls.getComponentType();
            }
            String name = cls.getName();
            if (name.startsWith("java.") || name.startsWith("javax.")) {
                return false;
            }
            boolean add = AnnotationMapper.this.annotatedTypes.contains(cls) ? false : super.add(cls);
            if (add) {
                XStreamInclude xStreamInclude = (XStreamInclude) cls.getAnnotation(XStreamInclude.class);
                if (xStreamInclude != null) {
                    Class[] value = xStreamInclude.value();
                    if (value != null) {
                        for (Class add2 : value) {
                            add((Class<?>) add2);
                        }
                    }
                }
            }
            return add;
        }
    }
}
