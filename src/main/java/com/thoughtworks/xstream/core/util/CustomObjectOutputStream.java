package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.DataHolder;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;

public class CustomObjectOutputStream extends ObjectOutputStream {
    private static final String DATA_HOLDER_KEY = "com.thoughtworks.xstream.core.util.CustomObjectOutputStream";
    private FastStack callbacks = new FastStack(1);
    private FastStack customFields = new FastStack(1);

    public interface StreamCallback {
        void close() throws IOException;

        void defaultWriteObject() throws IOException;

        void flush() throws IOException;

        void writeFieldsToStream(Map map) throws IOException;

        void writeToStream(Object obj) throws IOException;
    }

    public static synchronized CustomObjectOutputStream getInstance(DataHolder dataHolder, StreamCallback streamCallback) {
        CustomObjectOutputStream customObjectOutputStream;
        synchronized (CustomObjectOutputStream.class) {
            try {
                customObjectOutputStream = (CustomObjectOutputStream) dataHolder.get(DATA_HOLDER_KEY);
                if (customObjectOutputStream == null) {
                    customObjectOutputStream = new CustomObjectOutputStream(streamCallback);
                    dataHolder.put(DATA_HOLDER_KEY, customObjectOutputStream);
                } else {
                    customObjectOutputStream.pushCallback(streamCallback);
                }
            } catch (IOException e2) {
                throw new ConversionException("Cannot create CustomObjectStream", e2);
            }
        }
        return customObjectOutputStream;
    }

    public CustomObjectOutputStream(StreamCallback streamCallback) throws IOException, SecurityException {
        this.callbacks.push(streamCallback);
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

    public void defaultWriteObject() throws IOException {
        peekCallback().defaultWriteObject();
    }

    /* access modifiers changed from: protected */
    public void writeObjectOverride(Object obj) throws IOException {
        peekCallback().writeToStream(obj);
    }

    public void writeBoolean(boolean z) throws IOException {
        peekCallback().writeToStream(z ? Boolean.TRUE : Boolean.FALSE);
    }

    public void writeByte(int i) throws IOException {
        peekCallback().writeToStream(new Byte((byte) i));
    }

    public void writeInt(int i) throws IOException {
        peekCallback().writeToStream(new Integer(i));
    }

    public void writeChar(int i) throws IOException {
        peekCallback().writeToStream(new Character((char) i));
    }

    public void writeDouble(double d2) throws IOException {
        peekCallback().writeToStream(new Double(d2));
    }

    public void writeFloat(float f2) throws IOException {
        peekCallback().writeToStream(new Float(f2));
    }

    public void writeLong(long j) throws IOException {
        peekCallback().writeToStream(new Long(j));
    }

    public void writeShort(int i) throws IOException {
        peekCallback().writeToStream(new Short((short) i));
    }

    public void write(byte[] bArr) throws IOException {
        peekCallback().writeToStream(bArr);
    }

    public void writeChars(String str) throws IOException {
        peekCallback().writeToStream(str.toCharArray());
    }

    public void writeUTF(String str) throws IOException {
        peekCallback().writeToStream(str);
    }

    public void write(int i) throws IOException {
        peekCallback().writeToStream(new Byte((byte) i));
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        peekCallback().writeToStream(bArr2);
    }

    public void flush() throws IOException {
        peekCallback().flush();
    }

    public void close() throws IOException {
        peekCallback().close();
    }

    public ObjectOutputStream.PutField putFields() {
        CustomPutField customPutField = new CustomPutField();
        this.customFields.push(customPutField);
        return customPutField;
    }

    public void writeFields() throws IOException {
        peekCallback().writeFieldsToStream(((CustomPutField) this.customFields.pop()).asMap());
    }

    private class CustomPutField extends ObjectOutputStream.PutField {
        private final Map fields;

        private CustomPutField() {
            this.fields = new OrderRetainingMap();
        }

        public Map asMap() {
            return this.fields;
        }

        public void write(ObjectOutput objectOutput) throws IOException {
            CustomObjectOutputStream.this.peekCallback().writeToStream(asMap());
        }

        public void put(String str, Object obj) {
            this.fields.put(str, obj);
        }

        public void put(String str, byte b2) {
            put(str, (Object) new Byte(b2));
        }

        public void put(String str, char c2) {
            put(str, (Object) new Character(c2));
        }

        public void put(String str, double d2) {
            put(str, (Object) new Double(d2));
        }

        public void put(String str, float f2) {
            put(str, (Object) new Float(f2));
        }

        public void put(String str, int i) {
            put(str, (Object) new Integer(i));
        }

        public void put(String str, long j) {
            put(str, (Object) new Long(j));
        }

        public void put(String str, short s) {
            put(str, (Object) new Short(s));
        }

        public void put(String str, boolean z) {
            put(str, (Object) z ? Boolean.TRUE : Boolean.FALSE);
        }
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public void useProtocolVersion(int i) {
        throw new UnsupportedOperationException();
    }

    public void writeBytes(String str) {
        throw new UnsupportedOperationException();
    }

    public void writeUnshared(Object obj) {
        throw new UnsupportedOperationException();
    }
}
