package com.squareup.wire;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

final class MessageSerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] bytes;
    private final Class<? extends Message> messageClass;

    public MessageSerializedForm(Message message, Class<? extends Message> cls) {
        this.bytes = message.toByteArray();
        this.messageClass = cls;
    }

    /* access modifiers changed from: package-private */
    public Object readResolve() throws ObjectStreamException {
        try {
            return new Wire((Class<?>[]) new Class[0]).parseFrom(this.bytes, this.messageClass);
        } catch (IOException e2) {
            throw new StreamCorruptedException(e2.getMessage());
        }
    }
}
