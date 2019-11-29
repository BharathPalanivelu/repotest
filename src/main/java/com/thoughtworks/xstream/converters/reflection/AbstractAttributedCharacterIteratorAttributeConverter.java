package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.core.util.Fields;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AbstractAttributedCharacterIteratorAttributeConverter extends AbstractSingleValueConverter {
    private static final Method getName;
    private static final Map instanceMaps = new HashMap();
    private transient Map attributeMap;
    private final Class type;

    static {
        Method method = null;
        try {
            method = AttributedCharacterIterator.Attribute.class.getDeclaredMethod("getName", (Class[]) null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
        } catch (NoSuchMethodException | SecurityException unused) {
        }
        getName = method;
    }

    public AbstractAttributedCharacterIteratorAttributeConverter(Class cls) {
        if (AttributedCharacterIterator.Attribute.class.isAssignableFrom(cls)) {
            this.type = cls;
            readResolve();
            return;
        }
        throw new IllegalArgumentException(cls.getName() + " is not a " + AttributedCharacterIterator.Attribute.class.getName());
    }

    public boolean canConvert(Class cls) {
        return cls == this.type && !this.attributeMap.isEmpty();
    }

    public String toString(Object obj) {
        return getName((AttributedCharacterIterator.Attribute) obj);
    }

    private String getName(AttributedCharacterIterator.Attribute attribute) {
        Method method = getName;
        Throwable th = null;
        if (method != null) {
            try {
                return (String) method.invoke(attribute, (Object[]) null);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                th = e2;
            }
        }
        String attribute2 = attribute.toString();
        String name = attribute.getClass().getName();
        if (attribute2.startsWith(name)) {
            return attribute2.substring(name.length() + 1, attribute2.length() - 1);
        }
        throw new ConversionException("Cannot find name of attribute of type " + name, th);
    }

    public Object fromString(String str) {
        if (this.attributeMap.containsKey(str)) {
            return this.attributeMap.get(str);
        }
        throw new ConversionException("Cannot find attribute of type " + this.type.getName() + " with name " + str);
    }

    private Object readResolve() {
        boolean z;
        this.attributeMap = (Map) instanceMaps.get(this.type.getName());
        if (this.attributeMap == null) {
            this.attributeMap = new HashMap();
            Field locate = Fields.locate(this.type, Map.class, true);
            if (locate != null) {
                try {
                    Map map = (Map) Fields.read(locate, (Object) null);
                    if (map != null) {
                        Iterator it = map.entrySet().iterator();
                        loop0:
                        while (true) {
                            z = true;
                            while (z && it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (entry.getKey().getClass() != String.class || entry.getValue().getClass() != this.type) {
                                    z = false;
                                }
                            }
                        }
                        if (z) {
                            this.attributeMap.putAll(map);
                        }
                    }
                } catch (ObjectAccessException unused) {
                }
            }
            if (this.attributeMap.isEmpty()) {
                try {
                    Field[] declaredFields = this.type.getDeclaredFields();
                    for (int i = 0; i < declaredFields.length; i++) {
                        if ((declaredFields[i].getType() == this.type) == Modifier.isStatic(declaredFields[i].getModifiers())) {
                            AttributedCharacterIterator.Attribute attribute = (AttributedCharacterIterator.Attribute) Fields.read(declaredFields[i], (Object) null);
                            this.attributeMap.put(toString(attribute), attribute);
                        }
                    }
                } catch (SecurityException unused2) {
                    this.attributeMap.clear();
                } catch (ObjectAccessException unused3) {
                    this.attributeMap.clear();
                } catch (NoClassDefFoundError unused4) {
                    this.attributeMap.clear();
                }
            }
            instanceMaps.put(this.type.getName(), this.attributeMap);
        }
        return this;
    }
}
