package com.squareup.wire;

import com.squareup.wire.Message;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Redactor<T extends Message> {
    private static final Redactor<?> NOOP_REDACTOR = new Redactor<Message>((Constructor) null, (List) null, (List) null, (List) null) {
        public Message redact(Message message) {
            return message;
        }
    };
    private static final Map<Class<? extends Message>, Redactor> redactors = new LinkedHashMap();
    private final Constructor<?> builderConstructor;
    private final List<Field> messageFields;
    private final List<Redactor<?>> messageRedactors;
    private final List<Field> redactedFields;

    Redactor(Constructor<?> constructor, List<Field> list, List<Field> list2, List<Redactor<?>> list3) {
        this.builderConstructor = constructor;
        this.redactedFields = list;
        this.messageFields = list2;
        this.messageRedactors = list3;
    }

    public static synchronized <T extends Message> Redactor<T> get(Class<T> cls) {
        Redactor<?> redactor;
        synchronized (Redactor.class) {
            Redactor<T> redactor2 = redactors.get(cls);
            if (redactor2 != null) {
                return redactor2;
            }
            FutureRedactor futureRedactor = new FutureRedactor();
            redactors.put(cls, futureRedactor);
            try {
                Class<?> cls2 = Class.forName(cls.getName() + "$Builder");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Field field : cls.getDeclaredFields()) {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
                        if (protoField == null || !protoField.redacted()) {
                            if (Message.class.isAssignableFrom(field.getType())) {
                                Field declaredField = cls2.getDeclaredField(field.getName());
                                Redactor<?> redactor3 = get(declaredField.getType());
                                if (redactor3 != NOOP_REDACTOR) {
                                    arrayList2.add(declaredField);
                                    arrayList3.add(redactor3);
                                }
                            }
                        } else if (protoField.label() != Message.Label.REQUIRED) {
                            arrayList.add(cls2.getDeclaredField(field.getName()));
                        } else {
                            throw new IllegalArgumentException(String.format("Field %s is REQUIRED and cannot be redacted.", new Object[]{field}));
                        }
                    }
                }
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    redactor = new Redactor<>(cls2.getConstructor(new Class[]{cls}), arrayList, arrayList2, arrayList3);
                } else {
                    redactor = NOOP_REDACTOR;
                }
                futureRedactor.setDelegate(redactor);
                redactors.put(cls, redactor);
                return redactor;
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new AssertionError(e3);
            }
        }
    }

    public T redact(T t) {
        if (t == null) {
            return null;
        }
        try {
            Message.Builder builder = (Message.Builder) this.builderConstructor.newInstance(new Object[]{t});
            for (Field field : this.redactedFields) {
                field.set(builder, (Object) null);
            }
            for (int i = 0; i < this.messageFields.size(); i++) {
                Field field2 = this.messageFields.get(i);
                field2.set(builder, this.messageRedactors.get(i).redact((Message) field2.get(builder)));
            }
            return builder.build();
        } catch (Exception e2) {
            throw new AssertionError(e2.getMessage());
        }
    }

    private static class FutureRedactor<T extends Message> extends Redactor<T> {
        private Redactor<T> delegate;

        public FutureRedactor() {
            super((Constructor<?>) null, (List<Field>) null, (List<Field>) null, (List<Redactor<?>>) null);
        }

        public void setDelegate(Redactor<T> redactor) {
            this.delegate = redactor;
        }

        public T redact(T t) {
            Redactor<T> redactor = this.delegate;
            if (redactor != null) {
                return redactor.redact(t);
            }
            throw new IllegalStateException("Delegate was not set.");
        }
    }
}
