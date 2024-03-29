package com.squareup.wire;

import com.shopee.shopeetracker.bimodel.TrackingType;
import com.squareup.wire.Message;
import e.v;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Wire {
    private final Map<Class<? extends Message.Builder>, BuilderAdapter<? extends Message.Builder>> builderAdapters;
    private final Map<Class<? extends ProtoEnum>, EnumAdapter<? extends ProtoEnum>> enumAdapters;
    private final Map<Class<? extends Message>, MessageAdapter<? extends Message>> messageAdapters;
    final ExtensionRegistry registry;

    public static <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }

    public Wire(Class<?>... clsArr) {
        this((List<Class<?>>) Arrays.asList(clsArr));
    }

    public Wire(List<Class<?>> list) {
        this.messageAdapters = new LinkedHashMap();
        this.builderAdapters = new LinkedHashMap();
        this.enumAdapters = new LinkedHashMap();
        this.registry = new ExtensionRegistry();
        for (Class<?> declaredFields : list) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (field.getType().equals(Extension.class)) {
                    try {
                        this.registry.add((Extension) field.get((Object) null));
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized <M extends Message> MessageAdapter<M> messageAdapter(Class<M> cls) {
        MessageAdapter<M> messageAdapter;
        messageAdapter = this.messageAdapters.get(cls);
        if (messageAdapter == null) {
            messageAdapter = new MessageAdapter<>(this, cls);
            this.messageAdapters.put(cls, messageAdapter);
        }
        return messageAdapter;
    }

    /* access modifiers changed from: package-private */
    public synchronized <B extends Message.Builder> BuilderAdapter<B> builderAdapter(Class<B> cls) {
        BuilderAdapter<B> builderAdapter;
        builderAdapter = this.builderAdapters.get(cls);
        if (builderAdapter == null) {
            builderAdapter = new BuilderAdapter<>(cls);
            this.builderAdapters.put(cls, builderAdapter);
        }
        return builderAdapter;
    }

    /* access modifiers changed from: package-private */
    public synchronized <E extends ProtoEnum> EnumAdapter<E> enumAdapter(Class<E> cls) {
        EnumAdapter<E> enumAdapter;
        enumAdapter = this.enumAdapters.get(cls);
        if (enumAdapter == null) {
            enumAdapter = new EnumAdapter<>(cls);
            this.enumAdapters.put(cls, enumAdapter);
        }
        return enumAdapter;
    }

    public <M extends Message> M parseFrom(byte[] bArr, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(bArr), cls);
    }

    public <M extends Message> M parseFrom(byte[] bArr, int i, int i2, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(bArr, "bytes");
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "offset < 0");
        Preconditions.checkArgument(i2 >= 0, "count < 0");
        if (i + i2 > bArr.length) {
            z = false;
        }
        Preconditions.checkArgument(z, "offset + count > bytes");
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(bArr, i, i2), cls);
    }

    public <M extends Message> M parseFrom(InputStream inputStream, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(inputStream, TrackingType.INPUT);
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(inputStream), cls);
    }

    public <M extends Message> M parseFrom(v vVar, Class<M> cls) throws IOException {
        Preconditions.checkNotNull(vVar, TrackingType.INPUT);
        Preconditions.checkNotNull(cls, "messageClass");
        return parseFrom(WireInput.newInstance(vVar), cls);
    }

    private <M extends Message> M parseFrom(WireInput wireInput, Class<M> cls) throws IOException {
        return messageAdapter(cls).read(wireInput);
    }
}
