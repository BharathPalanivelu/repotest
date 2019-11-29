package com.thoughtworks.xstream.annotations;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.SingleValueConverterWrapper;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.mapper.Mapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class AnnotationReflectionConverter extends ReflectionConverter {
    private final AnnotationProvider annotationProvider;
    private final Map<Class<? extends ConverterMatcher>, Converter> cachedConverters = new HashMap();

    @Deprecated
    public AnnotationReflectionConverter(Mapper mapper, ReflectionProvider reflectionProvider, AnnotationProvider annotationProvider2) {
        super(mapper, reflectionProvider);
        this.annotationProvider = annotationProvider2;
    }

    /* access modifiers changed from: protected */
    public void marshallField(MarshallingContext marshallingContext, Object obj, Field field) {
        XStreamConverter xStreamConverter = (XStreamConverter) this.annotationProvider.getAnnotation(field, XStreamConverter.class);
        if (xStreamConverter != null) {
            Class<? extends ConverterMatcher> value = xStreamConverter.value();
            ensureCache(value);
            marshallingContext.convertAnother(obj, this.cachedConverters.get(value));
            return;
        }
        marshallingContext.convertAnother(obj);
    }

    private void ensureCache(Class<? extends ConverterMatcher> cls) {
        if (!this.cachedConverters.containsKey(cls)) {
            this.cachedConverters.put(cls, newInstance(cls));
        }
    }

    /* access modifiers changed from: protected */
    public Object unmarshallField(UnmarshallingContext unmarshallingContext, Object obj, Class cls, Field field) {
        XStreamConverter xStreamConverter = (XStreamConverter) this.annotationProvider.getAnnotation(field, XStreamConverter.class);
        if (xStreamConverter == null) {
            return unmarshallingContext.convertAnother(obj, cls);
        }
        Class<? extends ConverterMatcher> value = xStreamConverter.value();
        ensureCache(value);
        return unmarshallingContext.convertAnother(obj, cls, this.cachedConverters.get(value));
    }

    private Converter newInstance(Class<? extends ConverterMatcher> cls) {
        try {
            if (SingleValueConverter.class.isAssignableFrom(cls)) {
                return new SingleValueConverterWrapper((SingleValueConverter) cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            }
            return (Converter) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InvocationTargetException e2) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e2.getCause());
        } catch (InstantiationException e3) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e3);
        } catch (IllegalAccessException e4) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e4);
        } catch (NoSuchMethodException e5) {
            throw new ObjectAccessException("Cannot construct " + cls.getName(), e5);
        }
    }
}
