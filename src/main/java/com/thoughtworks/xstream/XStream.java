package com.thoughtworks.xstream;

import com.facebook.common.util.UriUtil;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.salesforce.android.chat.core.model.PreChatField;
import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.ConverterRegistry;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.SingleValueConverterWrapper;
import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;
import com.thoughtworks.xstream.converters.basic.BigIntegerConverter;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import com.thoughtworks.xstream.converters.basic.ByteConverter;
import com.thoughtworks.xstream.converters.basic.CharConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.converters.basic.DoubleConverter;
import com.thoughtworks.xstream.converters.basic.FloatConverter;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.LongConverter;
import com.thoughtworks.xstream.converters.basic.NullConverter;
import com.thoughtworks.xstream.converters.basic.ShortConverter;
import com.thoughtworks.xstream.converters.basic.StringBufferConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.basic.URIConverter;
import com.thoughtworks.xstream.converters.basic.URLConverter;
import com.thoughtworks.xstream.converters.collections.ArrayConverter;
import com.thoughtworks.xstream.converters.collections.BitSetConverter;
import com.thoughtworks.xstream.converters.collections.CharArrayConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.converters.collections.PropertiesConverter;
import com.thoughtworks.xstream.converters.collections.SingletonCollectionConverter;
import com.thoughtworks.xstream.converters.collections.SingletonMapConverter;
import com.thoughtworks.xstream.converters.collections.TreeMapConverter;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
import com.thoughtworks.xstream.converters.extended.ColorConverter;
import com.thoughtworks.xstream.converters.extended.DynamicProxyConverter;
import com.thoughtworks.xstream.converters.extended.EncodedByteArrayConverter;
import com.thoughtworks.xstream.converters.extended.FileConverter;
import com.thoughtworks.xstream.converters.extended.FontConverter;
import com.thoughtworks.xstream.converters.extended.GregorianCalendarConverter;
import com.thoughtworks.xstream.converters.extended.JavaClassConverter;
import com.thoughtworks.xstream.converters.extended.JavaFieldConverter;
import com.thoughtworks.xstream.converters.extended.JavaMethodConverter;
import com.thoughtworks.xstream.converters.extended.LocaleConverter;
import com.thoughtworks.xstream.converters.extended.LookAndFeelConverter;
import com.thoughtworks.xstream.converters.extended.SqlDateConverter;
import com.thoughtworks.xstream.converters.extended.SqlTimeConverter;
import com.thoughtworks.xstream.converters.extended.SqlTimestampConverter;
import com.thoughtworks.xstream.converters.extended.TextAttributeConverter;
import com.thoughtworks.xstream.converters.reflection.ExternalizableConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.converters.reflection.SerializableConverter;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.DefaultConverterLookup;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.MapBackedDataHolder;
import com.thoughtworks.xstream.core.ReferenceByIdMarshallingStrategy;
import com.thoughtworks.xstream.core.ReferenceByXPathMarshallingStrategy;
import com.thoughtworks.xstream.core.TreeMarshallingStrategy;
import com.thoughtworks.xstream.core.util.CompositeClassLoader;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import com.thoughtworks.xstream.core.util.CustomObjectOutputStream;
import com.thoughtworks.xstream.core.util.SelfStreamingInstanceChecker;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.StatefulWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.AnnotationConfiguration;
import com.thoughtworks.xstream.mapper.ArrayMapper;
import com.thoughtworks.xstream.mapper.AttributeAliasingMapper;
import com.thoughtworks.xstream.mapper.AttributeMapper;
import com.thoughtworks.xstream.mapper.CachingMapper;
import com.thoughtworks.xstream.mapper.ClassAliasingMapper;
import com.thoughtworks.xstream.mapper.DefaultImplementationsMapper;
import com.thoughtworks.xstream.mapper.DefaultMapper;
import com.thoughtworks.xstream.mapper.DynamicProxyMapper;
import com.thoughtworks.xstream.mapper.FieldAliasingMapper;
import com.thoughtworks.xstream.mapper.ImmutableTypesMapper;
import com.thoughtworks.xstream.mapper.ImplicitCollectionMapper;
import com.thoughtworks.xstream.mapper.LocalConversionMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import com.thoughtworks.xstream.mapper.OuterClassMapper;
import com.thoughtworks.xstream.mapper.PackageAliasingMapper;
import com.thoughtworks.xstream.mapper.SecurityMapper;
import com.thoughtworks.xstream.mapper.SystemAttributeAliasingMapper;
import com.thoughtworks.xstream.mapper.XStream11XmlFriendlyMapper;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.ExplicitTypePermission;
import com.thoughtworks.xstream.security.NoPermission;
import com.thoughtworks.xstream.security.RegExpTypePermission;
import com.thoughtworks.xstream.security.TypeHierarchyPermission;
import com.thoughtworks.xstream.security.TypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Pattern;

public class XStream {
    private static final String ANNOTATION_MAPPER_TYPE = "com.thoughtworks.xstream.mapper.AnnotationMapper";
    public static final int ID_REFERENCES = 1002;
    private static final Pattern IGNORE_ALL = Pattern.compile(".*");
    public static final int NO_REFERENCES = 1001;
    public static final int PRIORITY_LOW = -10;
    public static final int PRIORITY_NORMAL = 0;
    public static final int PRIORITY_VERY_HIGH = 10000;
    public static final int PRIORITY_VERY_LOW = -20;
    public static final int SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES = 1006;
    public static final int SINGLE_NODE_XPATH_RELATIVE_REFERENCES = 1005;
    public static final int XPATH_ABSOLUTE_REFERENCES = 1004;
    public static final int XPATH_RELATIVE_REFERENCES = 1003;
    private AnnotationConfiguration annotationConfiguration;
    private AttributeAliasingMapper attributeAliasingMapper;
    private AttributeMapper attributeMapper;
    private ClassAliasingMapper classAliasingMapper;
    private ClassLoaderReference classLoaderReference;
    private ConverterLookup converterLookup;
    private ConverterRegistry converterRegistry;
    private DefaultImplementationsMapper defaultImplementationsMapper;
    private FieldAliasingMapper fieldAliasingMapper;
    private HierarchicalStreamDriver hierarchicalStreamDriver;
    private ImmutableTypesMapper immutableTypesMapper;
    private ImplicitCollectionMapper implicitCollectionMapper;
    private LocalConversionMapper localConversionMapper;
    private Mapper mapper;
    private MarshallingStrategy marshallingStrategy;
    private PackageAliasingMapper packageAliasingMapper;
    private ReflectionProvider reflectionProvider;
    private SecurityMapper securityMapper;
    private SystemAttributeAliasingMapper systemAttributeAliasingMapper;

    /* access modifiers changed from: protected */
    public boolean useXStream11XmlFriendlyMapper() {
        return false;
    }

    /* access modifiers changed from: protected */
    public MapperWrapper wrapMapper(MapperWrapper mapperWrapper) {
        return mapperWrapper;
    }

    public XStream() {
        this((ReflectionProvider) null, (Mapper) null, (HierarchicalStreamDriver) new XppDriver());
    }

    public XStream(ReflectionProvider reflectionProvider2) {
        this(reflectionProvider2, (Mapper) null, (HierarchicalStreamDriver) new XppDriver());
    }

    public XStream(HierarchicalStreamDriver hierarchicalStreamDriver2) {
        this((ReflectionProvider) null, (Mapper) null, hierarchicalStreamDriver2);
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2) {
        this(reflectionProvider2, (Mapper) null, hierarchicalStreamDriver2);
    }

    public XStream(ReflectionProvider reflectionProvider2, Mapper mapper2, HierarchicalStreamDriver hierarchicalStreamDriver2) {
        this(reflectionProvider2, hierarchicalStreamDriver2, (ClassLoader) new CompositeClassLoader(), mapper2);
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoaderReference classLoaderReference2) {
        this(reflectionProvider2, hierarchicalStreamDriver2, classLoaderReference2, (Mapper) null);
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoader classLoader) {
        this(reflectionProvider2, hierarchicalStreamDriver2, classLoader, (Mapper) null);
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoader classLoader, Mapper mapper2) {
        this(reflectionProvider2, hierarchicalStreamDriver2, new ClassLoaderReference(classLoader), mapper2, new DefaultConverterLookup());
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoaderReference classLoaderReference2, Mapper mapper2) {
        this(reflectionProvider2, hierarchicalStreamDriver2, classLoaderReference2, mapper2, new DefaultConverterLookup());
    }

    private XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoaderReference classLoaderReference2, Mapper mapper2, final DefaultConverterLookup defaultConverterLookup) {
        this(reflectionProvider2, hierarchicalStreamDriver2, classLoaderReference2, mapper2, (ConverterLookup) new ConverterLookup() {
            public Converter lookupConverterForType(Class cls) {
                return DefaultConverterLookup.this.lookupConverterForType(cls);
            }
        }, (ConverterRegistry) new ConverterRegistry() {
            public void registerConverter(Converter converter, int i) {
                DefaultConverterLookup.this.registerConverter(converter, i);
            }
        });
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoader classLoader, Mapper mapper2, ConverterLookup converterLookup2, ConverterRegistry converterRegistry2) {
        this(reflectionProvider2, hierarchicalStreamDriver2, new ClassLoaderReference(classLoader), mapper2, converterLookup2, converterRegistry2);
    }

    public XStream(ReflectionProvider reflectionProvider2, HierarchicalStreamDriver hierarchicalStreamDriver2, ClassLoaderReference classLoaderReference2, Mapper mapper2, ConverterLookup converterLookup2, ConverterRegistry converterRegistry2) {
        this.reflectionProvider = reflectionProvider2 == null ? JVM.newReflectionProvider() : reflectionProvider2;
        this.hierarchicalStreamDriver = hierarchicalStreamDriver2;
        this.classLoaderReference = classLoaderReference2;
        this.converterLookup = converterLookup2;
        this.converterRegistry = converterRegistry2;
        this.mapper = mapper2 == null ? buildMapper() : mapper2;
        setupMappers();
        setupSecurity();
        setupAliases();
        setupDefaultImplementations();
        setupConverters();
        setupImmutableTypes();
        setMode(1003);
    }

    private Mapper buildMapper() {
        Mapper defaultMapper = new DefaultMapper(this.classLoaderReference);
        if (useXStream11XmlFriendlyMapper()) {
            defaultMapper = new XStream11XmlFriendlyMapper(defaultMapper);
        }
        Mapper attributeMapper2 = new AttributeMapper(new DefaultImplementationsMapper(new ArrayMapper(new OuterClassMapper(new ImplicitCollectionMapper(new SystemAttributeAliasingMapper(new AttributeAliasingMapper(new FieldAliasingMapper(new ClassAliasingMapper(new PackageAliasingMapper(new DynamicProxyMapper(defaultMapper)))))))))), this.converterLookup, this.reflectionProvider);
        if (JVM.is15()) {
            attributeMapper2 = buildMapperDynamically("com.thoughtworks.xstream.mapper.EnumMapper", new Class[]{Mapper.class}, new Object[]{attributeMapper2});
        }
        Mapper immutableTypesMapper2 = new ImmutableTypesMapper(new LocalConversionMapper(attributeMapper2));
        if (JVM.is18()) {
            immutableTypesMapper2 = buildMapperDynamically("com.thoughtworks.xstream.mapper.LambdaMapper", new Class[]{Mapper.class}, new Object[]{immutableTypesMapper2});
        }
        Object securityMapper2 = new SecurityMapper(immutableTypesMapper2);
        if (JVM.is15()) {
            securityMapper2 = buildMapperDynamically(ANNOTATION_MAPPER_TYPE, new Class[]{Mapper.class, ConverterRegistry.class, ConverterLookup.class, ClassLoaderReference.class, ReflectionProvider.class}, new Object[]{securityMapper2, this.converterRegistry, this.converterLookup, this.classLoaderReference, this.reflectionProvider});
        }
        return new CachingMapper(wrapMapper((MapperWrapper) securityMapper2));
    }

    private Mapper buildMapperDynamically(String str, Class[] clsArr, Object[] objArr) {
        try {
            return (Mapper) Class.forName(str, false, this.classLoaderReference.getReference()).getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e2) {
            throw new InitializationException("Could not instantiate mapper : " + str, e2);
        } catch (LinkageError e3) {
            throw new InitializationException("Could not instantiate mapper : " + str, e3);
        }
    }

    private void setupMappers() {
        this.packageAliasingMapper = (PackageAliasingMapper) this.mapper.lookupMapperOfType(PackageAliasingMapper.class);
        this.classAliasingMapper = (ClassAliasingMapper) this.mapper.lookupMapperOfType(ClassAliasingMapper.class);
        this.fieldAliasingMapper = (FieldAliasingMapper) this.mapper.lookupMapperOfType(FieldAliasingMapper.class);
        this.attributeMapper = (AttributeMapper) this.mapper.lookupMapperOfType(AttributeMapper.class);
        this.attributeAliasingMapper = (AttributeAliasingMapper) this.mapper.lookupMapperOfType(AttributeAliasingMapper.class);
        this.systemAttributeAliasingMapper = (SystemAttributeAliasingMapper) this.mapper.lookupMapperOfType(SystemAttributeAliasingMapper.class);
        this.implicitCollectionMapper = (ImplicitCollectionMapper) this.mapper.lookupMapperOfType(ImplicitCollectionMapper.class);
        this.defaultImplementationsMapper = (DefaultImplementationsMapper) this.mapper.lookupMapperOfType(DefaultImplementationsMapper.class);
        this.immutableTypesMapper = (ImmutableTypesMapper) this.mapper.lookupMapperOfType(ImmutableTypesMapper.class);
        this.localConversionMapper = (LocalConversionMapper) this.mapper.lookupMapperOfType(LocalConversionMapper.class);
        this.securityMapper = (SecurityMapper) this.mapper.lookupMapperOfType(SecurityMapper.class);
        this.annotationConfiguration = (AnnotationConfiguration) this.mapper.lookupMapperOfType(AnnotationConfiguration.class);
    }

    /* access modifiers changed from: protected */
    public void setupSecurity() {
        if (this.securityMapper != null) {
            addPermission(AnyTypePermission.ANY);
        }
    }

    /* access modifiers changed from: protected */
    public void setupAliases() {
        if (this.classAliasingMapper != null) {
            alias("null", Mapper.Null.class);
            alias("int", Integer.class);
            alias("float", Float.class);
            alias("double", Double.class);
            alias("long", Long.class);
            alias("short", Short.class);
            alias("char", Character.class);
            alias("byte", Byte.class);
            alias("boolean", Boolean.class);
            alias("number", Number.class);
            alias("object", Object.class);
            alias("big-int", BigInteger.class);
            alias("big-decimal", BigDecimal.class);
            alias("string-buffer", StringBuffer.class);
            alias(PreChatField.STRING, String.class);
            alias("java-class", Class.class);
            alias("method", Method.class);
            alias("constructor", Constructor.class);
            alias("field", Field.class);
            alias("date", Date.class);
            alias(ShareConstants.MEDIA_URI, URI.class);
            alias("url", URL.class);
            alias("bit-set", BitSet.class);
            alias("map", Map.class);
            alias("entry", Map.Entry.class);
            alias("properties", Properties.class);
            alias("list", List.class);
            alias("set", Set.class);
            alias("sorted-set", SortedSet.class);
            alias("linked-list", LinkedList.class);
            alias("vector", Vector.class);
            alias("tree-map", TreeMap.class);
            alias("tree-set", TreeSet.class);
            alias("hashtable", Hashtable.class);
            alias("empty-list", Collections.EMPTY_LIST.getClass());
            alias("empty-map", Collections.EMPTY_MAP.getClass());
            alias("empty-set", Collections.EMPTY_SET.getClass());
            alias("singleton-list", Collections.singletonList(this).getClass());
            alias("singleton-map", Collections.singletonMap(this, (Object) null).getClass());
            alias("singleton-set", Collections.singleton(this).getClass());
            if (JVM.isAWTAvailable()) {
                alias("awt-color", JVM.loadClassForName("java.awt.Color", false));
                alias("awt-font", JVM.loadClassForName("java.awt.Font", false));
                alias("awt-text-attribute", JVM.loadClassForName("java.awt.font.TextAttribute"));
            }
            if (JVM.isSQLAvailable()) {
                alias("sql-timestamp", JVM.loadClassForName("java.sql.Timestamp"));
                alias("sql-time", JVM.loadClassForName("java.sql.Time"));
                alias("sql-date", JVM.loadClassForName("java.sql.Date"));
            }
            alias(UriUtil.LOCAL_FILE_SCHEME, File.class);
            alias("locale", Locale.class);
            alias("gregorian-calendar", Calendar.class);
            if (JVM.is14()) {
                aliasDynamically("auth-subject", "javax.security.auth.Subject");
                alias("linked-hash-map", JVM.loadClassForName("java.util.LinkedHashMap"));
                alias("linked-hash-set", JVM.loadClassForName("java.util.LinkedHashSet"));
                alias("trace", JVM.loadClassForName("java.lang.StackTraceElement"));
                alias("currency", JVM.loadClassForName("java.util.Currency"));
                aliasType("charset", JVM.loadClassForName("java.nio.charset.Charset"));
            }
            if (JVM.is15()) {
                aliasDynamically("duration", "javax.xml.datatype.Duration");
                alias("concurrent-hash-map", JVM.loadClassForName("java.util.concurrent.ConcurrentHashMap"));
                alias("enum-set", JVM.loadClassForName("java.util.EnumSet"));
                alias("enum-map", JVM.loadClassForName("java.util.EnumMap"));
                alias("string-builder", JVM.loadClassForName("java.lang.StringBuilder"));
                alias("uuid", JVM.loadClassForName("java.util.UUID"));
            }
            if (JVM.loadClassForName("java.lang.invoke.SerializedLambda") != null) {
                aliasDynamically("serialized-lambda", "java.lang.invoke.SerializedLambda");
            }
        }
    }

    private void aliasDynamically(String str, String str2) {
        Class loadClassForName = JVM.loadClassForName(str2);
        if (loadClassForName != null) {
            alias(str, loadClassForName);
        }
    }

    /* access modifiers changed from: protected */
    public void setupDefaultImplementations() {
        if (this.defaultImplementationsMapper != null) {
            addDefaultImplementation(HashMap.class, Map.class);
            addDefaultImplementation(ArrayList.class, List.class);
            addDefaultImplementation(HashSet.class, Set.class);
            addDefaultImplementation(TreeSet.class, SortedSet.class);
            addDefaultImplementation(GregorianCalendar.class, Calendar.class);
        }
    }

    /* access modifiers changed from: protected */
    public void setupConverters() {
        registerConverter((Converter) new ReflectionConverter(this.mapper, this.reflectionProvider), -20);
        registerConverter((Converter) new SerializableConverter(this.mapper, this.reflectionProvider, this.classLoaderReference), -10);
        registerConverter((Converter) new ExternalizableConverter(this.mapper, this.classLoaderReference), -10);
        registerConverter((Converter) new NullConverter(), 10000);
        registerConverter((SingleValueConverter) new IntConverter(), 0);
        registerConverter((SingleValueConverter) new FloatConverter(), 0);
        registerConverter((SingleValueConverter) new DoubleConverter(), 0);
        registerConverter((SingleValueConverter) new LongConverter(), 0);
        registerConverter((SingleValueConverter) new ShortConverter(), 0);
        registerConverter((Converter) new CharConverter(), 0);
        registerConverter((SingleValueConverter) new BooleanConverter(), 0);
        registerConverter((SingleValueConverter) new ByteConverter(), 0);
        registerConverter((SingleValueConverter) new StringConverter(), 0);
        registerConverter((SingleValueConverter) new StringBufferConverter(), 0);
        registerConverter((SingleValueConverter) new DateConverter(), 0);
        registerConverter((Converter) new BitSetConverter(), 0);
        registerConverter((SingleValueConverter) new URIConverter(), 0);
        registerConverter((SingleValueConverter) new URLConverter(), 0);
        registerConverter((SingleValueConverter) new BigIntegerConverter(), 0);
        registerConverter((SingleValueConverter) new BigDecimalConverter(), 0);
        registerConverter((Converter) new ArrayConverter(this.mapper), 0);
        registerConverter((Converter) new CharArrayConverter(), 0);
        registerConverter((Converter) new CollectionConverter(this.mapper), 0);
        registerConverter((Converter) new MapConverter(this.mapper), 0);
        registerConverter((Converter) new TreeMapConverter(this.mapper), 0);
        registerConverter((Converter) new TreeSetConverter(this.mapper), 0);
        registerConverter((Converter) new SingletonCollectionConverter(this.mapper), 0);
        registerConverter((Converter) new SingletonMapConverter(this.mapper), 0);
        registerConverter((Converter) new PropertiesConverter(), 0);
        registerConverter((Converter) new EncodedByteArrayConverter(), 0);
        registerConverter((SingleValueConverter) new FileConverter(), 0);
        if (JVM.isSQLAvailable()) {
            registerConverter((SingleValueConverter) new SqlTimestampConverter(), 0);
            registerConverter((SingleValueConverter) new SqlTimeConverter(), 0);
            registerConverter((SingleValueConverter) new SqlDateConverter(), 0);
        }
        registerConverter((Converter) new DynamicProxyConverter(this.mapper, this.classLoaderReference), 0);
        registerConverter((SingleValueConverter) new JavaClassConverter(this.classLoaderReference), 0);
        registerConverter((Converter) new JavaMethodConverter(this.classLoaderReference), 0);
        registerConverter((Converter) new JavaFieldConverter(this.classLoaderReference), 0);
        if (JVM.isAWTAvailable()) {
            registerConverter((Converter) new FontConverter(this.mapper), 0);
            registerConverter((Converter) new ColorConverter(), 0);
            registerConverter((SingleValueConverter) new TextAttributeConverter(), 0);
        }
        if (JVM.isSwingAvailable()) {
            registerConverter((Converter) new LookAndFeelConverter(this.mapper, this.reflectionProvider), 0);
        }
        registerConverter((SingleValueConverter) new LocaleConverter(), 0);
        registerConverter((Converter) new GregorianCalendarConverter(), 0);
        if (JVM.is14()) {
            registerConverterDynamically("com.thoughtworks.xstream.converters.extended.SubjectConverter", 0, new Class[]{Mapper.class}, new Object[]{this.mapper});
            registerConverterDynamically("com.thoughtworks.xstream.converters.extended.ThrowableConverter", 0, new Class[]{ConverterLookup.class}, new Object[]{this.converterLookup});
            registerConverterDynamically("com.thoughtworks.xstream.converters.extended.StackTraceElementConverter", 0, (Class[]) null, (Object[]) null);
            registerConverterDynamically("com.thoughtworks.xstream.converters.extended.CurrencyConverter", 0, (Class[]) null, (Object[]) null);
            registerConverterDynamically("com.thoughtworks.xstream.converters.extended.RegexPatternConverter", 0, (Class[]) null, (Object[]) null);
            registerConverterDynamically("com.thoughtworks.xstream.converters.extended.CharsetConverter", 0, (Class[]) null, (Object[]) null);
        }
        if (JVM.is15()) {
            if (JVM.loadClassForName("javax.xml.datatype.Duration") != null) {
                registerConverterDynamically("com.thoughtworks.xstream.converters.extended.DurationConverter", 0, (Class[]) null, (Object[]) null);
            }
            registerConverterDynamically("com.thoughtworks.xstream.converters.enums.EnumConverter", 0, (Class[]) null, (Object[]) null);
            registerConverterDynamically("com.thoughtworks.xstream.converters.enums.EnumSetConverter", 0, new Class[]{Mapper.class}, new Object[]{this.mapper});
            registerConverterDynamically("com.thoughtworks.xstream.converters.enums.EnumMapConverter", 0, new Class[]{Mapper.class}, new Object[]{this.mapper});
            registerConverterDynamically("com.thoughtworks.xstream.converters.basic.StringBuilderConverter", 0, (Class[]) null, (Object[]) null);
            registerConverterDynamically("com.thoughtworks.xstream.converters.basic.UUIDConverter", 0, (Class[]) null, (Object[]) null);
        }
        if (JVM.is18()) {
            registerConverterDynamically("com.thoughtworks.xstream.converters.reflection.LambdaConverter", 0, new Class[]{Mapper.class, ReflectionProvider.class, ClassLoaderReference.class}, new Object[]{this.mapper, this.reflectionProvider, this.classLoaderReference});
        }
        registerConverter((Converter) new SelfStreamingInstanceChecker(this.converterLookup, (Object) this), 0);
    }

    private void registerConverterDynamically(String str, int i, Class[] clsArr, Object[] objArr) {
        try {
            Object newInstance = Class.forName(str, false, this.classLoaderReference.getReference()).getConstructor(clsArr).newInstance(objArr);
            if (newInstance instanceof Converter) {
                registerConverter((Converter) newInstance, i);
            } else if (newInstance instanceof SingleValueConverter) {
                registerConverter((SingleValueConverter) newInstance, i);
            }
        } catch (Exception e2) {
            throw new InitializationException("Could not instantiate converter : " + str, e2);
        } catch (LinkageError e3) {
            throw new InitializationException("Could not instantiate converter : " + str, e3);
        }
    }

    /* access modifiers changed from: protected */
    public void setupImmutableTypes() {
        if (this.immutableTypesMapper != null) {
            addImmutableType(Boolean.TYPE);
            addImmutableType(Boolean.class);
            addImmutableType(Byte.TYPE);
            addImmutableType(Byte.class);
            addImmutableType(Character.TYPE);
            addImmutableType(Character.class);
            addImmutableType(Double.TYPE);
            addImmutableType(Double.class);
            addImmutableType(Float.TYPE);
            addImmutableType(Float.class);
            addImmutableType(Integer.TYPE);
            addImmutableType(Integer.class);
            addImmutableType(Long.TYPE);
            addImmutableType(Long.class);
            addImmutableType(Short.TYPE);
            addImmutableType(Short.class);
            addImmutableType(Mapper.Null.class);
            addImmutableType(BigDecimal.class);
            addImmutableType(BigInteger.class);
            addImmutableType(String.class);
            addImmutableType(URI.class);
            addImmutableType(URL.class);
            addImmutableType(File.class);
            addImmutableType(Class.class);
            addImmutableType(Collections.EMPTY_LIST.getClass());
            addImmutableType(Collections.EMPTY_SET.getClass());
            addImmutableType(Collections.EMPTY_MAP.getClass());
            if (JVM.isAWTAvailable()) {
                addImmutableTypeDynamically("java.awt.font.TextAttribute");
            }
            if (JVM.is14()) {
                addImmutableTypeDynamically("java.nio.charset.Charset");
                addImmutableTypeDynamically("java.util.Currency");
            }
        }
    }

    private void addImmutableTypeDynamically(String str) {
        Class loadClassForName = JVM.loadClassForName(str);
        if (loadClassForName != null) {
            addImmutableType(loadClassForName);
        }
    }

    public void setMarshallingStrategy(MarshallingStrategy marshallingStrategy2) {
        this.marshallingStrategy = marshallingStrategy2;
    }

    public String toXML(Object obj) {
        StringWriter stringWriter = new StringWriter();
        toXML(obj, (Writer) stringWriter);
        return stringWriter.toString();
    }

    public void toXML(Object obj, Writer writer) {
        HierarchicalStreamWriter createWriter = this.hierarchicalStreamDriver.createWriter(writer);
        try {
            marshal(obj, createWriter);
        } finally {
            createWriter.flush();
        }
    }

    public void toXML(Object obj, OutputStream outputStream) {
        HierarchicalStreamWriter createWriter = this.hierarchicalStreamDriver.createWriter(outputStream);
        try {
            marshal(obj, createWriter);
        } finally {
            createWriter.flush();
        }
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter) {
        marshal(obj, hierarchicalStreamWriter, (DataHolder) null);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, DataHolder dataHolder) {
        this.marshallingStrategy.marshal(hierarchicalStreamWriter, obj, this.converterLookup, this.mapper, dataHolder);
    }

    public Object fromXML(String str) {
        return fromXML((Reader) new StringReader(str));
    }

    public Object fromXML(Reader reader) {
        return unmarshal(this.hierarchicalStreamDriver.createReader(reader), (Object) null);
    }

    public Object fromXML(InputStream inputStream) {
        return unmarshal(this.hierarchicalStreamDriver.createReader(inputStream), (Object) null);
    }

    public Object fromXML(URL url) {
        return fromXML(url, (Object) null);
    }

    public Object fromXML(File file) {
        return fromXML(file, (Object) null);
    }

    public Object fromXML(String str, Object obj) {
        return fromXML((Reader) new StringReader(str), obj);
    }

    public Object fromXML(Reader reader, Object obj) {
        return unmarshal(this.hierarchicalStreamDriver.createReader(reader), obj);
    }

    public Object fromXML(URL url, Object obj) {
        return unmarshal(this.hierarchicalStreamDriver.createReader(url), obj);
    }

    public Object fromXML(File file, Object obj) {
        HierarchicalStreamReader createReader = this.hierarchicalStreamDriver.createReader(file);
        try {
            return unmarshal(createReader, obj);
        } finally {
            createReader.close();
        }
    }

    public Object fromXML(InputStream inputStream, Object obj) {
        return unmarshal(this.hierarchicalStreamDriver.createReader(inputStream), obj);
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader) {
        return unmarshal(hierarchicalStreamReader, (Object) null, (DataHolder) null);
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, Object obj) {
        return unmarshal(hierarchicalStreamReader, obj, (DataHolder) null);
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, Object obj, DataHolder dataHolder) {
        try {
            return this.marshallingStrategy.unmarshal(obj, hierarchicalStreamReader, dataHolder, this.converterLookup, this.mapper);
        } catch (ConversionException e2) {
            Package packageR = getClass().getPackage();
            String implementationVersion = packageR != null ? packageR.getImplementationVersion() : null;
            if (implementationVersion == null) {
                implementationVersion = "not available";
            }
            e2.add(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, implementationVersion);
            throw e2;
        }
    }

    public void alias(String str, Class cls) {
        ClassAliasingMapper classAliasingMapper2 = this.classAliasingMapper;
        if (classAliasingMapper2 != null) {
            classAliasingMapper2.addClassAlias(str, cls);
            return;
        }
        throw new InitializationException("No " + ClassAliasingMapper.class.getName() + " available");
    }

    public void aliasType(String str, Class cls) {
        ClassAliasingMapper classAliasingMapper2 = this.classAliasingMapper;
        if (classAliasingMapper2 != null) {
            classAliasingMapper2.addTypeAlias(str, cls);
            return;
        }
        throw new InitializationException("No " + ClassAliasingMapper.class.getName() + " available");
    }

    public void alias(String str, Class cls, Class cls2) {
        alias(str, cls);
        addDefaultImplementation(cls2, cls);
    }

    public void aliasPackage(String str, String str2) {
        PackageAliasingMapper packageAliasingMapper2 = this.packageAliasingMapper;
        if (packageAliasingMapper2 != null) {
            packageAliasingMapper2.addPackageAlias(str, str2);
            return;
        }
        throw new InitializationException("No " + PackageAliasingMapper.class.getName() + " available");
    }

    public void aliasField(String str, Class cls, String str2) {
        FieldAliasingMapper fieldAliasingMapper2 = this.fieldAliasingMapper;
        if (fieldAliasingMapper2 != null) {
            fieldAliasingMapper2.addFieldAlias(str, cls, str2);
            return;
        }
        throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
    }

    public void aliasAttribute(String str, String str2) {
        AttributeAliasingMapper attributeAliasingMapper2 = this.attributeAliasingMapper;
        if (attributeAliasingMapper2 != null) {
            attributeAliasingMapper2.addAliasFor(str2, str);
            return;
        }
        throw new InitializationException("No " + AttributeAliasingMapper.class.getName() + " available");
    }

    public void aliasSystemAttribute(String str, String str2) {
        SystemAttributeAliasingMapper systemAttributeAliasingMapper2 = this.systemAttributeAliasingMapper;
        if (systemAttributeAliasingMapper2 != null) {
            systemAttributeAliasingMapper2.addAliasFor(str2, str);
            return;
        }
        throw new InitializationException("No " + SystemAttributeAliasingMapper.class.getName() + " available");
    }

    public void aliasAttribute(Class cls, String str, String str2) {
        aliasField(str2, cls, str);
        useAttributeFor(cls, str);
    }

    public void useAttributeFor(String str, Class cls) {
        AttributeMapper attributeMapper2 = this.attributeMapper;
        if (attributeMapper2 != null) {
            attributeMapper2.addAttributeFor(str, cls);
            return;
        }
        throw new InitializationException("No " + AttributeMapper.class.getName() + " available");
    }

    public void useAttributeFor(Class cls, String str) {
        AttributeMapper attributeMapper2 = this.attributeMapper;
        if (attributeMapper2 != null) {
            attributeMapper2.addAttributeFor(cls, str);
            return;
        }
        throw new InitializationException("No " + AttributeMapper.class.getName() + " available");
    }

    public void useAttributeFor(Class cls) {
        AttributeMapper attributeMapper2 = this.attributeMapper;
        if (attributeMapper2 != null) {
            attributeMapper2.addAttributeFor(cls);
            return;
        }
        throw new InitializationException("No " + AttributeMapper.class.getName() + " available");
    }

    public void addDefaultImplementation(Class cls, Class cls2) {
        DefaultImplementationsMapper defaultImplementationsMapper2 = this.defaultImplementationsMapper;
        if (defaultImplementationsMapper2 != null) {
            defaultImplementationsMapper2.addDefaultImplementation(cls, cls2);
            return;
        }
        throw new InitializationException("No " + DefaultImplementationsMapper.class.getName() + " available");
    }

    public void addImmutableType(Class cls) {
        ImmutableTypesMapper immutableTypesMapper2 = this.immutableTypesMapper;
        if (immutableTypesMapper2 != null) {
            immutableTypesMapper2.addImmutableType(cls);
            return;
        }
        throw new InitializationException("No " + ImmutableTypesMapper.class.getName() + " available");
    }

    public void registerConverter(Converter converter) {
        registerConverter(converter, 0);
    }

    public void registerConverter(Converter converter, int i) {
        ConverterRegistry converterRegistry2 = this.converterRegistry;
        if (converterRegistry2 != null) {
            converterRegistry2.registerConverter(converter, i);
        }
    }

    public void registerConverter(SingleValueConverter singleValueConverter) {
        registerConverter(singleValueConverter, 0);
    }

    public void registerConverter(SingleValueConverter singleValueConverter, int i) {
        ConverterRegistry converterRegistry2 = this.converterRegistry;
        if (converterRegistry2 != null) {
            converterRegistry2.registerConverter(new SingleValueConverterWrapper(singleValueConverter), i);
        }
    }

    public void registerLocalConverter(Class cls, String str, Converter converter) {
        LocalConversionMapper localConversionMapper2 = this.localConversionMapper;
        if (localConversionMapper2 != null) {
            localConversionMapper2.registerLocalConverter(cls, str, converter);
            return;
        }
        throw new InitializationException("No " + LocalConversionMapper.class.getName() + " available");
    }

    public void registerLocalConverter(Class cls, String str, SingleValueConverter singleValueConverter) {
        registerLocalConverter(cls, str, (Converter) new SingleValueConverterWrapper(singleValueConverter));
    }

    public Mapper getMapper() {
        return this.mapper;
    }

    public ReflectionProvider getReflectionProvider() {
        return this.reflectionProvider;
    }

    public ConverterLookup getConverterLookup() {
        return this.converterLookup;
    }

    public void setMode(int i) {
        switch (i) {
            case 1001:
                setMarshallingStrategy(new TreeMarshallingStrategy());
                return;
            case 1002:
                setMarshallingStrategy(new ReferenceByIdMarshallingStrategy());
                return;
            case 1003:
                setMarshallingStrategy(new ReferenceByXPathMarshallingStrategy(ReferenceByXPathMarshallingStrategy.RELATIVE));
                return;
            case 1004:
                setMarshallingStrategy(new ReferenceByXPathMarshallingStrategy(ReferenceByXPathMarshallingStrategy.ABSOLUTE));
                return;
            case 1005:
                setMarshallingStrategy(new ReferenceByXPathMarshallingStrategy(ReferenceByXPathMarshallingStrategy.RELATIVE | ReferenceByXPathMarshallingStrategy.SINGLE_NODE));
                return;
            case 1006:
                setMarshallingStrategy(new ReferenceByXPathMarshallingStrategy(ReferenceByXPathMarshallingStrategy.ABSOLUTE | ReferenceByXPathMarshallingStrategy.SINGLE_NODE));
                return;
            default:
                throw new IllegalArgumentException("Unknown mode : " + i);
        }
    }

    public void addImplicitCollection(Class cls, String str) {
        addImplicitCollection(cls, str, (String) null, (Class) null);
    }

    public void addImplicitCollection(Class cls, String str, Class cls2) {
        addImplicitCollection(cls, str, (String) null, cls2);
    }

    public void addImplicitCollection(Class cls, String str, String str2, Class cls2) {
        addImplicitMap(cls, str, str2, cls2, (String) null);
    }

    public void addImplicitArray(Class cls, String str) {
        addImplicitCollection(cls, str);
    }

    public void addImplicitArray(Class cls, String str, Class cls2) {
        addImplicitCollection(cls, str, cls2);
    }

    public void addImplicitArray(Class cls, String str, String str2) {
        addImplicitCollection(cls, str, str2, (Class) null);
    }

    public void addImplicitMap(Class cls, String str, Class cls2, String str2) {
        addImplicitMap(cls, str, (String) null, cls2, str2);
    }

    public void addImplicitMap(Class cls, String str, String str2, Class cls2, String str3) {
        ImplicitCollectionMapper implicitCollectionMapper2 = this.implicitCollectionMapper;
        if (implicitCollectionMapper2 != null) {
            implicitCollectionMapper2.add(cls, str, str2, cls2, str3);
            return;
        }
        throw new InitializationException("No " + ImplicitCollectionMapper.class.getName() + " available");
    }

    public DataHolder newDataHolder() {
        return new MapBackedDataHolder();
    }

    public ObjectOutputStream createObjectOutputStream(Writer writer) throws IOException {
        return createObjectOutputStream(this.hierarchicalStreamDriver.createWriter(writer), "object-stream");
    }

    public ObjectOutputStream createObjectOutputStream(HierarchicalStreamWriter hierarchicalStreamWriter) throws IOException {
        return createObjectOutputStream(hierarchicalStreamWriter, "object-stream");
    }

    public ObjectOutputStream createObjectOutputStream(Writer writer, String str) throws IOException {
        return createObjectOutputStream(this.hierarchicalStreamDriver.createWriter(writer), str);
    }

    public ObjectOutputStream createObjectOutputStream(OutputStream outputStream) throws IOException {
        return createObjectOutputStream(this.hierarchicalStreamDriver.createWriter(outputStream), "object-stream");
    }

    public ObjectOutputStream createObjectOutputStream(OutputStream outputStream, String str) throws IOException {
        return createObjectOutputStream(this.hierarchicalStreamDriver.createWriter(outputStream), str);
    }

    public ObjectOutputStream createObjectOutputStream(HierarchicalStreamWriter hierarchicalStreamWriter, String str) throws IOException {
        final StatefulWriter statefulWriter = new StatefulWriter(hierarchicalStreamWriter);
        statefulWriter.startNode(str, (Class) null);
        return new CustomObjectOutputStream(new CustomObjectOutputStream.StreamCallback() {
            public void writeToStream(Object obj) {
                XStream.this.marshal(obj, statefulWriter);
            }

            public void writeFieldsToStream(Map map) throws NotActiveException {
                throw new NotActiveException("not in call to writeObject");
            }

            public void defaultWriteObject() throws NotActiveException {
                throw new NotActiveException("not in call to writeObject");
            }

            public void flush() {
                statefulWriter.flush();
            }

            public void close() {
                if (statefulWriter.state() != StatefulWriter.STATE_CLOSED) {
                    statefulWriter.endNode();
                    statefulWriter.close();
                }
            }
        });
    }

    public ObjectInputStream createObjectInputStream(Reader reader) throws IOException {
        return createObjectInputStream(this.hierarchicalStreamDriver.createReader(reader));
    }

    public ObjectInputStream createObjectInputStream(InputStream inputStream) throws IOException {
        return createObjectInputStream(this.hierarchicalStreamDriver.createReader(inputStream));
    }

    public ObjectInputStream createObjectInputStream(final HierarchicalStreamReader hierarchicalStreamReader) throws IOException {
        return new CustomObjectInputStream((CustomObjectInputStream.StreamCallback) new CustomObjectInputStream.StreamCallback() {
            public Object readFromStream() throws EOFException {
                if (hierarchicalStreamReader.hasMoreChildren()) {
                    hierarchicalStreamReader.moveDown();
                    Object unmarshal = XStream.this.unmarshal(hierarchicalStreamReader);
                    hierarchicalStreamReader.moveUp();
                    return unmarshal;
                }
                throw new EOFException();
            }

            public Map readFieldsFromStream() throws IOException {
                throw new NotActiveException("not in call to readObject");
            }

            public void defaultReadObject() throws NotActiveException {
                throw new NotActiveException("not in call to readObject");
            }

            public void registerValidation(ObjectInputValidation objectInputValidation, int i) throws NotActiveException {
                throw new NotActiveException("stream inactive");
            }

            public void close() {
                hierarchicalStreamReader.close();
            }
        }, this.classLoaderReference);
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoaderReference.setReference(classLoader);
    }

    public ClassLoader getClassLoader() {
        return this.classLoaderReference.getReference();
    }

    public ClassLoaderReference getClassLoaderReference() {
        return this.classLoaderReference;
    }

    public void omitField(Class cls, String str) {
        FieldAliasingMapper fieldAliasingMapper2 = this.fieldAliasingMapper;
        if (fieldAliasingMapper2 != null) {
            fieldAliasingMapper2.omitField(cls, str);
            return;
        }
        throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
    }

    public void ignoreUnknownElements() {
        ignoreUnknownElements(IGNORE_ALL);
    }

    public void ignoreUnknownElements(String str) {
        ignoreUnknownElements(Pattern.compile(str));
    }

    public void ignoreUnknownElements(Pattern pattern) {
        FieldAliasingMapper fieldAliasingMapper2 = this.fieldAliasingMapper;
        if (fieldAliasingMapper2 != null) {
            fieldAliasingMapper2.addFieldsToIgnore(pattern);
            return;
        }
        throw new InitializationException("No " + FieldAliasingMapper.class.getName() + " available");
    }

    public void processAnnotations(Class[] clsArr) {
        AnnotationConfiguration annotationConfiguration2 = this.annotationConfiguration;
        if (annotationConfiguration2 != null) {
            annotationConfiguration2.processAnnotations(clsArr);
            return;
        }
        throw new InitializationException("No com.thoughtworks.xstream.mapper.AnnotationMapper available");
    }

    public void processAnnotations(Class cls) {
        processAnnotations(new Class[]{cls});
    }

    public void autodetectAnnotations(boolean z) {
        AnnotationConfiguration annotationConfiguration2 = this.annotationConfiguration;
        if (annotationConfiguration2 != null) {
            annotationConfiguration2.autodetectAnnotations(z);
        }
    }

    public void addPermission(TypePermission typePermission) {
        SecurityMapper securityMapper2 = this.securityMapper;
        if (securityMapper2 != null) {
            securityMapper2.addPermission(typePermission);
        }
    }

    public void allowTypes(String[] strArr) {
        addPermission(new ExplicitTypePermission(strArr));
    }

    public void allowTypes(Class[] clsArr) {
        addPermission(new ExplicitTypePermission(clsArr));
    }

    public void allowTypeHierarchy(Class cls) {
        addPermission(new TypeHierarchyPermission(cls));
    }

    public void allowTypesByRegExp(String[] strArr) {
        addPermission(new RegExpTypePermission(strArr));
    }

    public void allowTypesByRegExp(Pattern[] patternArr) {
        addPermission(new RegExpTypePermission(patternArr));
    }

    public void allowTypesByWildcard(String[] strArr) {
        addPermission(new WildcardTypePermission(strArr));
    }

    public void denyPermission(TypePermission typePermission) {
        addPermission(new NoPermission(typePermission));
    }

    public void denyTypes(String[] strArr) {
        denyPermission(new ExplicitTypePermission(strArr));
    }

    public void denyTypes(Class[] clsArr) {
        denyPermission(new ExplicitTypePermission(clsArr));
    }

    public void denyTypeHierarchy(Class cls) {
        denyPermission(new TypeHierarchyPermission(cls));
    }

    public void denyTypesByRegExp(String[] strArr) {
        denyPermission(new RegExpTypePermission(strArr));
    }

    public void denyTypesByRegExp(Pattern[] patternArr) {
        denyPermission(new RegExpTypePermission(patternArr));
    }

    public void denyTypesByWildcard(String[] strArr) {
        denyPermission(new WildcardTypePermission(strArr));
    }

    public static class InitializationException extends XStreamException {
        public InitializationException(String str, Throwable th) {
            super(str, th);
        }

        public InitializationException(String str) {
            super(str);
        }
    }
}
