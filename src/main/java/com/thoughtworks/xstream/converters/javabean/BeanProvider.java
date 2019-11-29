package com.thoughtworks.xstream.converters.javabean;

import com.thoughtworks.xstream.converters.javabean.JavaBeanProvider;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BeanProvider implements JavaBeanProvider {
    protected static final Object[] NO_PARAMS = new Object[0];
    protected PropertyDictionary propertyDictionary;

    public interface Visitor extends JavaBeanProvider.Visitor {
    }

    public BeanProvider() {
        this(new PropertyDictionary(new NativePropertySorter()));
    }

    public BeanProvider(Comparator comparator) {
        this(new PropertyDictionary(new ComparingPropertySorter(comparator)));
    }

    public BeanProvider(PropertyDictionary propertyDictionary2) {
        this.propertyDictionary = propertyDictionary2;
    }

    public Object newInstance(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e2) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e3);
        } catch (SecurityException e4) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e4);
        } catch (ExceptionInInitializerError e5) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e5);
        }
    }

    public void visitSerializableProperties(Object obj, JavaBeanProvider.Visitor visitor) {
        PropertyDescriptor[] serializableProperties = getSerializableProperties(obj);
        int i = 0;
        while (i < serializableProperties.length) {
            PropertyDescriptor propertyDescriptor = serializableProperties[i];
            try {
                Method readMethod = propertyDescriptor.getReadMethod();
                String name = propertyDescriptor.getName();
                Class<?> declaringClass = readMethod.getDeclaringClass();
                if (visitor.shouldVisit(name, declaringClass)) {
                    visitor.visit(name, propertyDescriptor.getPropertyType(), declaringClass, readMethod.invoke(obj, new Object[0]));
                }
                i++;
            } catch (IllegalArgumentException e2) {
                throw new ObjectAccessException("Could not get property " + obj.getClass() + "." + propertyDescriptor.getName(), e2);
            } catch (IllegalAccessException e3) {
                throw new ObjectAccessException("Could not get property " + obj.getClass() + "." + propertyDescriptor.getName(), e3);
            } catch (InvocationTargetException e4) {
                throw new ObjectAccessException("Could not get property " + obj.getClass() + "." + propertyDescriptor.getName(), e4);
            }
        }
    }

    public void writeProperty(Object obj, String str, Object obj2) {
        PropertyDescriptor property = getProperty(str, obj.getClass());
        try {
            property.getWriteMethod().invoke(obj, new Object[]{obj2});
        } catch (IllegalArgumentException e2) {
            throw new ObjectAccessException("Could not set property " + obj.getClass() + "." + property.getName(), e2);
        } catch (IllegalAccessException e3) {
            throw new ObjectAccessException("Could not set property " + obj.getClass() + "." + property.getName(), e3);
        } catch (InvocationTargetException e4) {
            throw new ObjectAccessException("Could not set property " + obj.getClass() + "." + property.getName(), e4);
        }
    }

    public Class getPropertyType(Object obj, String str) {
        return getProperty(str, obj.getClass()).getPropertyType();
    }

    public boolean propertyDefinedInClass(String str, Class cls) {
        return getProperty(str, cls) != null;
    }

    public boolean canInstantiate(Class cls) {
        try {
            return newInstance(cls) != null;
        } catch (ObjectAccessException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Constructor getDefaultConstrutor(Class cls) {
        Constructor[] constructors = cls.getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getParameterTypes().length == 0 && Modifier.isPublic(constructor.getModifiers())) {
                return constructor;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptor[] getSerializableProperties(Object obj) {
        ArrayList arrayList = new ArrayList();
        Iterator propertiesFor = this.propertyDictionary.propertiesFor(obj.getClass());
        while (propertiesFor.hasNext()) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) propertiesFor.next();
            if (canStreamProperty(propertyDescriptor)) {
                arrayList.add(propertyDescriptor);
            }
        }
        return (PropertyDescriptor[]) arrayList.toArray(new PropertyDescriptor[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    public boolean canStreamProperty(PropertyDescriptor propertyDescriptor) {
        return (propertyDescriptor.getReadMethod() == null || propertyDescriptor.getWriteMethod() == null) ? false : true;
    }

    public boolean propertyWriteable(String str, Class cls) {
        return getProperty(str, cls).getWriteMethod() != null;
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptor getProperty(String str, Class cls) {
        return this.propertyDictionary.propertyDescriptor(cls, str);
    }
}
