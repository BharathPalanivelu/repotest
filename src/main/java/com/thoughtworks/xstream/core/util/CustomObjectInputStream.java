package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.DataHolder;
import com.thoughtworks.xstream.core.ClassLoaderReference;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.util.Map;

public class CustomObjectInputStream extends ObjectInputStream {
    private static final String DATA_HOLDER_KEY = "com.thoughtworks.xstream.core.util.CustomObjectInputStream";
    private FastStack callbacks;
    private final ClassLoaderReference classLoaderReference;

    public interface StreamCallback {
        void close() throws IOException;

        void defaultReadObject() throws IOException;

        Map readFieldsFromStream() throws IOException;

        Object readFromStream() throws IOException;

        void registerValidation(ObjectInputValidation objectInputValidation, int i) throws NotActiveException, InvalidObjectException;
    }

    public boolean markSupported() {
        return false;
    }

    public static CustomObjectInputStream getInstance(DataHolder dataHolder, StreamCallback streamCallback) {
        return getInstance(dataHolder, streamCallback, (ClassLoader) null);
    }

    public static synchronized CustomObjectInputStream getInstance(DataHolder dataHolder, StreamCallback streamCallback, ClassLoader classLoader) {
        CustomObjectInputStream instance;
        synchronized (CustomObjectInputStream.class) {
            instance = getInstance(dataHolder, streamCallback, new ClassLoaderReference(classLoader));
        }
        return instance;
    }

    public static synchronized CustomObjectInputStream getInstance(DataHolder dataHolder, StreamCallback streamCallback, ClassLoaderReference classLoaderReference2) {
        CustomObjectInputStream customObjectInputStream;
        synchronized (CustomObjectInputStream.class) {
            try {
                customObjectInputStream = (CustomObjectInputStream) dataHolder.get(DATA_HOLDER_KEY);
                if (customObjectInputStream == null) {
                    customObjectInputStream = new CustomObjectInputStream(streamCallback, classLoaderReference2);
                    dataHolder.put(DATA_HOLDER_KEY, customObjectInputStream);
                } else {
                    customObjectInputStream.pushCallback(streamCallback);
                }
            } catch (IOException e2) {
                throw new ConversionException("Cannot create CustomObjectStream", e2);
            }
        }
        return customObjectInputStream;
    }

    public CustomObjectInputStream(StreamCallback streamCallback, ClassLoaderReference classLoaderReference2) throws IOException, SecurityException {
        this.callbacks = new FastStack(1);
        this.callbacks.push(streamCallback);
        this.classLoaderReference = classLoaderReference2;
    }

    public CustomObjectInputStream(StreamCallback streamCallback, ClassLoader classLoader) throws IOException, SecurityException {
        this(streamCallback, new ClassLoaderReference(classLoader));
    }

    public void pushCallback(StreamCallback streamCallback) {
        this.callbacks.push(streamCallback);
    }

    public StreamCallback popCallback() {
        return (StreamCallback) this.callbacks.pop();
    }

    public StreamCallback peekCallback() {
        return (StreamCallback) this.callbacks.peek();
    }

    /* access modifiers changed from: protected */
    public Class resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        ClassLoader reference = this.classLoaderReference.getReference();
        if (reference == null) {
            return super.resolveClass(objectStreamClass);
        }
        return Class.forName(objectStreamClass.getName(), false, reference);
    }

    public void defaultReadObject() throws IOException {
        peekCallback().defaultReadObject();
    }

    /* access modifiers changed from: protected */
    public Object readObjectOverride() throws IOException {
        return peekCallback().readFromStream();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return readObject();
    }

    public boolean readBoolean() throws IOException {
        return ((Boolean) peekCallback().readFromStream()).booleanValue();
    }

    public byte readByte() throws IOException {
        return ((Byte) peekCallback().readFromStream()).byteValue();
    }

    public int readUnsignedByte() throws IOException {
        byte byteValue = ((Byte) peekCallback().readFromStream()).byteValue();
        return byteValue < 0 ? byteValue + Byte.MAX_VALUE : byteValue;
    }

    public int readInt() throws IOException {
        return ((Integer) peekCallback().readFromStream()).intValue();
    }

    public char readChar() throws IOException {
        return ((Character) peekCallback().readFromStream()).charValue();
    }

    public float readFloat() throws IOException {
        return ((Float) peekCallback().readFromStream()).floatValue();
    }

    public double readDouble() throws IOException {
        return ((Double) peekCallback().readFromStream()).doubleValue();
    }

    public long readLong() throws IOException {
        return ((Long) peekCallback().readFromStream()).longValue();
    }

    public short readShort() throws IOException {
        return ((Short) peekCallback().readFromStream()).shortValue();
    }

    public int readUnsignedShort() throws IOException {
        short shortValue = ((Short) peekCallback().readFromStream()).shortValue();
        return shortValue < 0 ? shortValue + Short.MAX_VALUE : shortValue;
    }

    public String readUTF() throws IOException {
        return (String) peekCallback().readFromStream();
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        System.arraycopy((byte[]) peekCallback().readFromStream(), 0, bArr, i, i2);
    }

    public int read() throws IOException {
        return readUnsignedByte();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = (byte[]) peekCallback().readFromStream();
        if (bArr2.length == i2) {
            System.arraycopy(bArr2, 0, bArr, i, i2);
            return i2;
        }
        throw new StreamCorruptedException("Expected " + i2 + " bytes from stream, got " + bArr2.length);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public ObjectInputStream.GetField readFields() throws IOException {
        return new CustomGetField(peekCallback().readFieldsFromStream());
    }

    private class CustomGetField extends ObjectInputStream.GetField {
        private Map fields;

        public CustomGetField(Map map) {
            this.fields = map;
        }

        public ObjectStreamClass getObjectStreamClass() {
            throw new UnsupportedOperationException();
        }

        private Object get(String str) {
            return this.fields.get(str);
        }

        public boolean defaulted(String str) {
            return !this.fields.containsKey(str);
        }

        public byte get(String str, byte b2) {
            return defaulted(str) ? b2 : ((Byte) get(str)).byteValue();
        }

        public char get(String str, char c2) {
            return defaulted(str) ? c2 : ((Character) get(str)).charValue();
        }

        public double get(String str, double d2) {
            return defaulted(str) ? d2 : ((Double) get(str)).doubleValue();
        }

        public float get(String str, float f2) {
            return defaulted(str) ? f2 : ((Float) get(str)).floatValue();
        }

        public int get(String str, int i) {
            return defaulted(str) ? i : ((Integer) get(str)).intValue();
        }

        public long get(String str, long j) {
            return defaulted(str) ? j : ((Long) get(str)).longValue();
        }

        public short get(String str, short s) {
            return defaulted(str) ? s : ((Short) get(str)).shortValue();
        }

        public boolean get(String str, boolean z) {
            return defaulted(str) ? z : ((Boolean) get(str)).booleanValue();
        }

        public Object get(String str, Object obj) {
            return defaulted(str) ? obj : get(str);
        }
    }

    public void registerValidation(ObjectInputValidation objectInputValidation, int i) throws NotActiveException, InvalidObjectException {
        peekCallback().registerValidation(objectInputValidation, i);
    }

    public void close() throws IOException {
        peekCallback().close();
    }

    public int available() {
        throw new UnsupportedOperationException();
    }

    public String readLine() {
        throw new UnsupportedOperationException();
    }

    public int skipBytes(int i) {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) {
        throw new UnsupportedOperationException();
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }
}
