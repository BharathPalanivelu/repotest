package com.thoughtworks.xstream.converters.reflection;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.core.ReferencingMarshallingContext;
import com.thoughtworks.xstream.core.util.CustomObjectInputStream;
import com.thoughtworks.xstream.core.util.CustomObjectOutputStream;
import com.thoughtworks.xstream.core.util.HierarchicalStreams;
import com.thoughtworks.xstream.core.util.SerializationMembers;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.io.Externalizable;
import java.io.IOException;
import java.io.NotActiveException;
import java.io.ObjectInputValidation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ExternalizableConverter implements Converter {
    private final ClassLoaderReference classLoaderReference;
    /* access modifiers changed from: private */
    public Mapper mapper;
    private transient SerializationMembers serializationMembers;

    public ExternalizableConverter(Mapper mapper2, ClassLoaderReference classLoaderReference2) {
        this.mapper = mapper2;
        this.classLoaderReference = classLoaderReference2;
        this.serializationMembers = new SerializationMembers();
    }

    public ExternalizableConverter(Mapper mapper2, ClassLoader classLoader) {
        this(mapper2, new ClassLoaderReference(classLoader));
    }

    public ExternalizableConverter(Mapper mapper2) {
        this(mapper2, ExternalizableConverter.class.getClassLoader());
    }

    public boolean canConvert(Class cls) {
        return JVM.canCreateDerivedObjectOutputStream() && Externalizable.class.isAssignableFrom(cls);
    }

    public void marshal(Object obj, final HierarchicalStreamWriter hierarchicalStreamWriter, final MarshallingContext marshallingContext) {
        Object callWriteReplace = this.serializationMembers.callWriteReplace(obj);
        if (callWriteReplace != obj && (marshallingContext instanceof ReferencingMarshallingContext)) {
            ((ReferencingMarshallingContext) marshallingContext).replace(obj, callWriteReplace);
        }
        if (callWriteReplace.getClass() != obj.getClass()) {
            String aliasForSystemAttribute = this.mapper.aliasForSystemAttribute("resolves-to");
            if (aliasForSystemAttribute != null) {
                hierarchicalStreamWriter.addAttribute(aliasForSystemAttribute, this.mapper.serializedClass(callWriteReplace.getClass()));
            }
            marshallingContext.convertAnother(callWriteReplace);
            return;
        }
        try {
            CustomObjectOutputStream instance = CustomObjectOutputStream.getInstance(marshallingContext, new CustomObjectOutputStream.StreamCallback() {
                public void writeToStream(Object obj) {
                    if (obj == null) {
                        hierarchicalStreamWriter.startNode("null");
                        hierarchicalStreamWriter.endNode();
                        return;
                    }
                    ExtendedHierarchicalStreamWriterHelper.startNode(hierarchicalStreamWriter, ExternalizableConverter.this.mapper.serializedClass(obj.getClass()), obj.getClass());
                    marshallingContext.convertAnother(obj);
                    hierarchicalStreamWriter.endNode();
                }

                public void writeFieldsToStream(Map map) {
                    throw new UnsupportedOperationException();
                }

                public void defaultWriteObject() {
                    throw new UnsupportedOperationException();
                }

                public void flush() {
                    hierarchicalStreamWriter.flush();
                }

                public void close() {
                    throw new UnsupportedOperationException("Objects are not allowed to call ObjectOutput.close() from writeExternal()");
                }
            });
            ((Externalizable) callWriteReplace).writeExternal(instance);
            instance.popCallback();
        } catch (IOException e2) {
            throw new ConversionException("Cannot serialize " + callWriteReplace.getClass().getName() + " using Externalization", e2);
        }
    }

    public Object unmarshal(final HierarchicalStreamReader hierarchicalStreamReader, final UnmarshallingContext unmarshallingContext) {
        Class requiredType = unmarshallingContext.getRequiredType();
        try {
            Constructor declaredConstructor = requiredType.getDeclaredConstructor((Class[]) null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            final Externalizable externalizable = (Externalizable) declaredConstructor.newInstance((Object[]) null);
            CustomObjectInputStream instance = CustomObjectInputStream.getInstance((DataHolder) unmarshallingContext, (CustomObjectInputStream.StreamCallback) new CustomObjectInputStream.StreamCallback() {
                public Object readFromStream() {
                    hierarchicalStreamReader.moveDown();
                    Object convertAnother = unmarshallingContext.convertAnother(externalizable, HierarchicalStreams.readClassType(hierarchicalStreamReader, ExternalizableConverter.this.mapper));
                    hierarchicalStreamReader.moveUp();
                    return convertAnother;
                }

                public Map readFieldsFromStream() {
                    throw new UnsupportedOperationException();
                }

                public void defaultReadObject() {
                    throw new UnsupportedOperationException();
                }

                public void registerValidation(ObjectInputValidation objectInputValidation, int i) throws NotActiveException {
                    throw new NotActiveException("stream inactive");
                }

                public void close() {
                    throw new UnsupportedOperationException("Objects are not allowed to call ObjectInput.close() from readExternal()");
                }
            }, this.classLoaderReference);
            externalizable.readExternal(instance);
            instance.popCallback();
            return this.serializationMembers.callReadResolve(externalizable);
        } catch (NoSuchMethodException e2) {
            throw new ConversionException("Cannot construct " + requiredType.getClass() + ", missing default constructor", e2);
        } catch (InvocationTargetException e3) {
            throw new ConversionException("Cannot construct " + requiredType.getClass(), e3);
        } catch (InstantiationException e4) {
            throw new ConversionException("Cannot construct " + requiredType.getClass(), e4);
        } catch (IllegalAccessException e5) {
            throw new ConversionException("Cannot construct " + requiredType.getClass(), e5);
        } catch (IOException e6) {
            throw new ConversionException("Cannot externalize " + requiredType.getClass(), e6);
        } catch (ClassNotFoundException e7) {
            throw new ConversionException("Cannot externalize " + requiredType.getClass(), e7);
        }
    }

    private Object readResolve() {
        this.serializationMembers = new SerializationMembers();
        return this;
    }
}
