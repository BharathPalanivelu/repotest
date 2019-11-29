package com.facebook.react.bridge;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;

public class JsonWriter implements Closeable {
    private final Deque<Scope> mScopes = new ArrayDeque();
    private final Writer mWriter;

    private enum Scope {
        EMPTY_OBJECT,
        OBJECT,
        EMPTY_ARRAY,
        ARRAY
    }

    public JsonWriter(Writer writer) {
        this.mWriter = writer;
    }

    public JsonWriter beginArray() throws IOException {
        open(Scope.EMPTY_ARRAY, '[');
        return this;
    }

    public JsonWriter endArray() throws IOException {
        close(']');
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        open(Scope.EMPTY_OBJECT, '{');
        return this;
    }

    public JsonWriter endObject() throws IOException {
        close('}');
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        if (str != null) {
            beforeName();
            string(str);
            this.mWriter.write(58);
            return this;
        }
        throw new NullPointerException("name can not be null");
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        beforeValue();
        this.mWriter.write("null");
        return this;
    }

    public JsonWriter rawValue(String str) throws IOException {
        beforeValue();
        this.mWriter.write(str);
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        beforeValue();
        this.mWriter.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public JsonWriter value(double d2) throws IOException {
        beforeValue();
        this.mWriter.append(Double.toString(d2));
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        beforeValue();
        this.mWriter.write(Long.toString(j));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        beforeValue();
        this.mWriter.append(number.toString());
        return this;
    }

    public void close() throws IOException {
        this.mWriter.close();
    }

    /* renamed from: com.facebook.react.bridge.JsonWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$JsonWriter$Scope = new int[Scope.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.facebook.react.bridge.JsonWriter$Scope[] r0 = com.facebook.react.bridge.JsonWriter.Scope.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$JsonWriter$Scope = r0
                int[] r0 = $SwitchMap$com$facebook$react$bridge$JsonWriter$Scope     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.react.bridge.JsonWriter$Scope r1 = com.facebook.react.bridge.JsonWriter.Scope.EMPTY_ARRAY     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$JsonWriter$Scope     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.react.bridge.JsonWriter$Scope r1 = com.facebook.react.bridge.JsonWriter.Scope.EMPTY_OBJECT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$JsonWriter$Scope     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.react.bridge.JsonWriter$Scope r1 = com.facebook.react.bridge.JsonWriter.Scope.ARRAY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$JsonWriter$Scope     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.facebook.react.bridge.JsonWriter$Scope r1 = com.facebook.react.bridge.JsonWriter.Scope.OBJECT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.JsonWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private void beforeValue() throws IOException {
        Scope peek = this.mScopes.peek();
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$JsonWriter$Scope[peek.ordinal()];
        if (i == 1) {
            replace(Scope.ARRAY);
        } else if (i == 2) {
            throw new IllegalArgumentException(Scope.EMPTY_OBJECT.name());
        } else if (i == 3) {
            this.mWriter.write(44);
        } else if (i != 4) {
            throw new IllegalStateException("Unknown scope: " + peek);
        }
    }

    private void beforeName() throws IOException {
        Scope peek = this.mScopes.peek();
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$JsonWriter$Scope[peek.ordinal()];
        if (i != 1) {
            if (i == 2) {
                replace(Scope.OBJECT);
                return;
            } else if (i != 3) {
                if (i == 4) {
                    this.mWriter.write(44);
                    return;
                }
                throw new IllegalStateException("Unknown scope: " + peek);
            }
        }
        throw new IllegalStateException("name not allowed in array");
    }

    private void open(Scope scope, char c2) throws IOException {
        this.mScopes.push(scope);
        this.mWriter.write(c2);
    }

    private void close(char c2) throws IOException {
        this.mScopes.pop();
        this.mWriter.write(c2);
    }

    private void string(String str) throws IOException {
        this.mWriter.write(34);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                this.mWriter.write("\\f");
            } else if (charAt != 13) {
                if (charAt != '\"' && charAt != '\\') {
                    if (charAt != 8232 && charAt != 8233) {
                        switch (charAt) {
                            case 8:
                                this.mWriter.write("\\b");
                                break;
                            case 9:
                                this.mWriter.write("\\t");
                                break;
                            case 10:
                                this.mWriter.write("\\n");
                                break;
                            default:
                                if (charAt > 31) {
                                    this.mWriter.write(charAt);
                                    break;
                                } else {
                                    this.mWriter.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                                    break;
                                }
                        }
                    } else {
                        this.mWriter.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    }
                } else {
                    this.mWriter.write(92);
                    this.mWriter.write(charAt);
                }
            } else {
                this.mWriter.write("\\r");
            }
        }
        this.mWriter.write(34);
    }

    private void replace(Scope scope) {
        this.mScopes.pop();
        this.mScopes.push(scope);
    }
}
