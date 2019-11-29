package com.thoughtworks.xstream;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.ConverterLookup;
import com.thoughtworks.xstream.converters.ConverterMatcher;
import com.thoughtworks.xstream.converters.ConverterRegistry;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.javabean.JavaBeanProvider;
import com.thoughtworks.xstream.converters.reflection.FieldKeySorter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.JVM;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.naming.NameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.mapper.Mapper;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.TypeHierarchyPermission;
import com.thoughtworks.xstream.security.TypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.datatype.DatatypeFactory;

public class XStreamer {
    private static final TypePermission[] PERMISSIONS = {new TypeHierarchyPermission(ConverterMatcher.class), new TypeHierarchyPermission(Mapper.class), new TypeHierarchyPermission(XStream.class), new TypeHierarchyPermission(ReflectionProvider.class), new TypeHierarchyPermission(JavaBeanProvider.class), new TypeHierarchyPermission(FieldKeySorter.class), new TypeHierarchyPermission(ConverterLookup.class), new TypeHierarchyPermission(ConverterRegistry.class), new TypeHierarchyPermission(HierarchicalStreamDriver.class), new TypeHierarchyPermission(MarshallingStrategy.class), new TypeHierarchyPermission(MarshallingContext.class), new TypeHierarchyPermission(UnmarshallingContext.class), new TypeHierarchyPermission(NameCoder.class), new TypeHierarchyPermission(TypePermission.class), new WildcardTypePermission(new String[]{JVM.class.getPackage().getName() + ".**"}), new TypeHierarchyPermission(DatatypeFactory.class)};

    public String toXML(XStream xStream, Object obj) throws ObjectStreamException {
        StringWriter stringWriter = new StringWriter();
        try {
            toXML(xStream, obj, stringWriter);
            return stringWriter.toString();
        } catch (ObjectStreamException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new ConversionException("Unexpected IO error from a StringWriter", e3);
        }
    }

    public void toXML(XStream xStream, Object obj, Writer writer) throws IOException {
        ObjectOutputStream createObjectOutputStream = new XStream().createObjectOutputStream(writer);
        try {
            createObjectOutputStream.writeObject(xStream);
            createObjectOutputStream.flush();
            xStream.toXML(obj, writer);
        } finally {
            createObjectOutputStream.close();
        }
    }

    public Object fromXML(String str) throws ClassNotFoundException, ObjectStreamException {
        try {
            return fromXML((Reader) new StringReader(str));
        } catch (ObjectStreamException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new ConversionException("Unexpected IO error from a StringReader", e3);
        }
    }

    public Object fromXML(String str, TypePermission[] typePermissionArr) throws ClassNotFoundException, ObjectStreamException {
        try {
            return fromXML((Reader) new StringReader(str), typePermissionArr);
        } catch (ObjectStreamException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new ConversionException("Unexpected IO error from a StringReader", e3);
        }
    }

    public Object fromXML(HierarchicalStreamDriver hierarchicalStreamDriver, String str) throws ClassNotFoundException, ObjectStreamException {
        try {
            return fromXML(hierarchicalStreamDriver, (Reader) new StringReader(str));
        } catch (ObjectStreamException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new ConversionException("Unexpected IO error from a StringReader", e3);
        }
    }

    public Object fromXML(HierarchicalStreamDriver hierarchicalStreamDriver, String str, TypePermission[] typePermissionArr) throws ClassNotFoundException, ObjectStreamException {
        try {
            return fromXML(hierarchicalStreamDriver, (Reader) new StringReader(str), typePermissionArr);
        } catch (ObjectStreamException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new ConversionException("Unexpected IO error from a StringReader", e3);
        }
    }

    public Object fromXML(Reader reader) throws IOException, ClassNotFoundException {
        return fromXML((HierarchicalStreamDriver) new XppDriver(), reader);
    }

    public Object fromXML(Reader reader, TypePermission[] typePermissionArr) throws IOException, ClassNotFoundException {
        return fromXML((HierarchicalStreamDriver) new XppDriver(), reader, typePermissionArr);
    }

    public Object fromXML(HierarchicalStreamDriver hierarchicalStreamDriver, Reader reader) throws IOException, ClassNotFoundException {
        return fromXML(hierarchicalStreamDriver, reader, new TypePermission[]{AnyTypePermission.ANY});
    }

    public Object fromXML(HierarchicalStreamDriver hierarchicalStreamDriver, Reader reader, TypePermission[] typePermissionArr) throws IOException, ClassNotFoundException {
        XStream xStream = new XStream(hierarchicalStreamDriver);
        for (TypePermission addPermission : typePermissionArr) {
            xStream.addPermission(addPermission);
        }
        HierarchicalStreamReader createReader = hierarchicalStreamDriver.createReader(reader);
        ObjectInputStream createObjectInputStream = xStream.createObjectInputStream(createReader);
        try {
            createObjectInputStream = ((XStream) createObjectInputStream.readObject()).createObjectInputStream(createReader);
            return createObjectInputStream.readObject();
        } catch (Throwable th) {
            throw th;
        } finally {
            createObjectInputStream.close();
        }
    }

    public static TypePermission[] getDefaultPermissions() {
        return (TypePermission[]) PERMISSIONS.clone();
    }
}
