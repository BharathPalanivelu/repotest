package com.thoughtworks.xstream.converters.javabean;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.javabean.JavaBeanProvider;
import com.thoughtworks.xstream.converters.reflection.MissingFieldException;
import com.thoughtworks.xstream.core.util.FastField;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.HashSet;

public class JavaBeanConverter implements Converter {
    protected final JavaBeanProvider beanProvider;
    private String classAttributeIdentifier;
    protected final Mapper mapper;
    private final Class type;

    public JavaBeanConverter(Mapper mapper2) {
        this(mapper2, (Class) null);
    }

    public JavaBeanConverter(Mapper mapper2, Class cls) {
        this(mapper2, new BeanProvider(), cls);
    }

    public JavaBeanConverter(Mapper mapper2, JavaBeanProvider javaBeanProvider) {
        this(mapper2, javaBeanProvider, (Class) null);
    }

    public JavaBeanConverter(Mapper mapper2, JavaBeanProvider javaBeanProvider, Class cls) {
        this.mapper = mapper2;
        this.beanProvider = javaBeanProvider;
        this.type = cls;
    }

    public JavaBeanConverter(Mapper mapper2, String str) {
        this(mapper2, (JavaBeanProvider) new BeanProvider());
        this.classAttributeIdentifier = str;
    }

    public boolean canConvert(Class cls) {
        Class cls2 = this.type;
        return (cls2 == null || cls2 == cls) && this.beanProvider.canInstantiate(cls);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        String str = this.classAttributeIdentifier;
        if (str == null) {
            str = this.mapper.aliasForSystemAttribute("class");
        }
        final String str2 = str;
        final Object obj2 = obj;
        final HierarchicalStreamWriter hierarchicalStreamWriter2 = hierarchicalStreamWriter;
        final MarshallingContext marshallingContext2 = marshallingContext;
        this.beanProvider.visitSerializableProperties(obj, new JavaBeanProvider.Visitor() {
            public boolean shouldVisit(String str, Class cls) {
                return JavaBeanConverter.this.mapper.shouldSerializeMember(cls, str);
            }

            public void visit(String str, Class cls, Class cls2, Object obj) {
                if (obj != null) {
                    writeField(str, cls, obj, cls2);
                }
            }

            private void writeField(String str, Class cls, Object obj, Class cls2) {
                Class<?> cls3 = obj.getClass();
                Class defaultImplementationOf = JavaBeanConverter.this.mapper.defaultImplementationOf(cls);
                ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter2, JavaBeanConverter.this.mapper.serializedMember(obj2.getClass(), str), cls3);
                if (!cls3.equals(defaultImplementationOf)) {
                    String str2 = str2;
                    if (str2 != null) {
                        hierarchicalStreamWriter2.addAttribute(str2, JavaBeanConverter.this.mapper.serializedClass(cls3));
                    }
                }
                marshallingContext2.convertAnother(obj);
                hierarchicalStreamWriter2.endNode();
            }
        });
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Object instantiateNewInstance = instantiateNewInstance(unmarshallingContext);
        AnonymousClass2 r1 = new HashSet() {
            public boolean add(Object obj) {
                if (super.add(obj)) {
                    return true;
                }
                throw new DuplicatePropertyException(((FastField) obj).getName());
            }
        };
        Class<?> cls = instantiateNewInstance.getClass();
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            String realMember = this.mapper.realMember(cls, hierarchicalStreamReader.getNodeName());
            if (this.mapper.shouldSerializeMember(cls, realMember)) {
                if (this.beanProvider.propertyDefinedInClass(realMember, cls)) {
                    this.beanProvider.writeProperty(instantiateNewInstance, realMember, unmarshallingContext.convertAnother(instantiateNewInstance, determineType(hierarchicalStreamReader, instantiateNewInstance, realMember)));
                    r1.add(new FastField((Class) cls, realMember));
                } else {
                    throw new MissingFieldException(cls.getName(), realMember);
                }
            }
            hierarchicalStreamReader.moveUp();
        }
        return instantiateNewInstance;
    }

    private Object instantiateNewInstance(UnmarshallingContext unmarshallingContext) {
        Object currentObject = unmarshallingContext.currentObject();
        return currentObject == null ? this.beanProvider.newInstance(unmarshallingContext.getRequiredType()) : currentObject;
    }

    private Class determineType(HierarchicalStreamReader hierarchicalStreamReader, Object obj, String str) {
        String str2;
        String str3 = this.classAttributeIdentifier;
        if (str3 == null) {
            str3 = this.mapper.aliasForSystemAttribute("class");
        }
        if (str3 == null) {
            str2 = null;
        } else {
            str2 = hierarchicalStreamReader.getAttribute(str3);
        }
        if (str2 != null) {
            return this.mapper.realClass(str2);
        }
        return this.mapper.defaultImplementationOf(this.beanProvider.getPropertyType(obj, str));
    }

    public static class DuplicateFieldException extends ConversionException {
        public DuplicateFieldException(String str) {
            super(str);
        }
    }

    public static class DuplicatePropertyException extends ConversionException {
        public DuplicatePropertyException(String str) {
            super("Duplicate property " + str);
            add("property", str);
        }
    }
}
