package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.util.Fields;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.DynamicProxyMapper;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class DynamicProxyConverter implements Converter {
    private static final InvocationHandler DUMMY = new InvocationHandler() {
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return null;
        }
    };
    private static final Field HANDLER = Fields.locate(Proxy.class, InvocationHandler.class, false);
    private ClassLoaderReference classLoaderReference;
    private Mapper mapper;

    public DynamicProxyConverter(Mapper mapper2) {
        this(mapper2, DynamicProxyConverter.class.getClassLoader());
    }

    public DynamicProxyConverter(Mapper mapper2, ClassLoaderReference classLoaderReference2) {
        this.classLoaderReference = classLoaderReference2;
        this.mapper = mapper2;
    }

    public DynamicProxyConverter(Mapper mapper2, ClassLoader classLoader) {
        this(mapper2, new ClassLoaderReference(classLoader));
    }

    public boolean canConvert(Class cls) {
        return cls.equals(DynamicProxyMapper.DynamicProxy.class) || Proxy.isProxyClass(cls);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(obj);
        addInterfacesToXml(obj, hierarchicalStreamWriter);
        hierarchicalStreamWriter.startNode("handler");
        String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("class");
        if (aliasForSystemAttribute != null) {
            hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(invocationHandler.getClass()));
        }
        marshallingContext.convertAnother(invocationHandler);
        hierarchicalStreamWriter.endNode();
    }

    private void addInterfacesToXml(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter) {
        Class[] interfaces = obj.getClass().getInterfaces();
        for (Class serializedClass : interfaces) {
            hierarchicalStreamWriter.startNode("interface");
            hierarchicalStreamWriter.setValue(this.mapper.serializedClass(serializedClass));
            hierarchicalStreamWriter.endNode();
        }
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        Object obj;
        Class cls;
        ArrayList arrayList = new ArrayList();
        while (true) {
            obj = null;
            if (!hierarchicalStreamReader.hasMoreChildren()) {
                cls = null;
                break;
            }
            hierarchicalStreamReader.moveDown();
            String nodeName = hierarchicalStreamReader.getNodeName();
            if (nodeName.equals("interface")) {
                arrayList.add(this.mapper.realClass(hierarchicalStreamReader.getValue()));
            } else if (nodeName.equals("handler")) {
                String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("class");
                if (aliasForSystemAttribute != null) {
                    cls = this.mapper.realClass(hierarchicalStreamReader.getAttribute(aliasForSystemAttribute));
                    break;
                }
            } else {
                continue;
            }
            hierarchicalStreamReader.moveUp();
        }
        if (cls != null) {
            Class[] clsArr = new Class[arrayList.size()];
            arrayList.toArray(clsArr);
            if (HANDLER != null) {
                obj = Proxy.newProxyInstance(this.classLoaderReference.getReference(), clsArr, DUMMY);
            }
            InvocationHandler invocationHandler = (InvocationHandler) unmarshallingContext.convertAnother(obj, cls);
            hierarchicalStreamReader.moveUp();
            Field field = HANDLER;
            if (field == null) {
                return Proxy.newProxyInstance(this.classLoaderReference.getReference(), clsArr, invocationHandler);
            }
            Fields.write(field, obj, invocationHandler);
            return obj;
        }
        throw new ConversionException("No InvocationHandler specified for dynamic proxy");
    }
}
