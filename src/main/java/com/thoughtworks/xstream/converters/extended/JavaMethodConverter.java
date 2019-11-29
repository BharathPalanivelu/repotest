package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JavaMethodConverter implements Converter {
    private final SingleValueConverter javaClassConverter;

    public JavaMethodConverter(ClassLoaderReference classLoaderReference) {
        this((SingleValueConverter) new JavaClassConverter(classLoaderReference));
    }

    public JavaMethodConverter(ClassLoader classLoader) {
        this(new ClassLoaderReference(classLoader));
    }

    protected JavaMethodConverter(SingleValueConverter singleValueConverter) {
        this.javaClassConverter = singleValueConverter;
    }

    public boolean canConvert(Class cls) {
        return cls.equals(Method.class) || cls.equals(Constructor.class);
    }

    public void marshal(Object obj, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        if (obj instanceof Method) {
            Method method = (Method) obj;
            marshalMethod(hierarchicalStreamWriter, this.javaClassConverter.toString(method.getDeclaringClass()), method.getName(), method.getParameterTypes());
            return;
        }
        Constructor constructor = (Constructor) obj;
        marshalMethod(hierarchicalStreamWriter, this.javaClassConverter.toString(constructor.getDeclaringClass()), (String) null, constructor.getParameterTypes());
    }

    private void marshalMethod(HierarchicalStreamWriter hierarchicalStreamWriter, String str, String str2, Class[] clsArr) {
        hierarchicalStreamWriter.startNode("class");
        hierarchicalStreamWriter.setValue(str);
        hierarchicalStreamWriter.endNode();
        if (str2 != null) {
            hierarchicalStreamWriter.startNode("name");
            hierarchicalStreamWriter.setValue(str2);
            hierarchicalStreamWriter.endNode();
        }
        hierarchicalStreamWriter.startNode("parameter-types");
        for (Class singleValueConverter : clsArr) {
            hierarchicalStreamWriter.startNode("class");
            hierarchicalStreamWriter.setValue(this.javaClassConverter.toString(singleValueConverter));
            hierarchicalStreamWriter.endNode();
        }
        hierarchicalStreamWriter.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        try {
            boolean equals = unmarshallingContext.getRequiredType().equals(Method.class);
            hierarchicalStreamReader.moveDown();
            Class cls = (Class) this.javaClassConverter.fromString(hierarchicalStreamReader.getValue());
            hierarchicalStreamReader.moveUp();
            String str = null;
            if (equals) {
                hierarchicalStreamReader.moveDown();
                str = hierarchicalStreamReader.getValue();
                hierarchicalStreamReader.moveUp();
            }
            hierarchicalStreamReader.moveDown();
            ArrayList arrayList = new ArrayList();
            while (hierarchicalStreamReader.hasMoreChildren()) {
                hierarchicalStreamReader.moveDown();
                arrayList.add(this.javaClassConverter.fromString(hierarchicalStreamReader.getValue()));
                hierarchicalStreamReader.moveUp();
            }
            Class[] clsArr = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
            hierarchicalStreamReader.moveUp();
            if (equals) {
                return cls.getDeclaredMethod(str, clsArr);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (NoSuchMethodException e2) {
            throw new ConversionException((Throwable) e2);
        }
    }
}
