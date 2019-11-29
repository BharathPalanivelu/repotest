package androidx.emoji.widget;

import android.os.Build;
import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.e;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f2086a;

    /* renamed from: b  reason: collision with root package name */
    private int f2087b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private int f2088c = 0;

    public b(EditText editText) {
        e.a(editText, (Object) "editText cannot be null");
        this.f2086a = Build.VERSION.SDK_INT >= 19 ? new C0048b(editText) : new a();
    }

    public void a(int i) {
        e.a(i, "maxEmojiCount should be greater than 0");
        this.f2087b = i;
        this.f2086a.a(i);
    }

    public int a() {
        return this.f2087b;
    }

    public KeyListener a(KeyListener keyListener) {
        e.a(keyListener, (Object) "keyListener cannot be null");
        return this.f2086a.a(keyListener);
    }

    public InputConnection a(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f2086a.a(inputConnection, editorInfo);
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.f2088c = i;
        this.f2086a.b(i);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f2088c;
    }

    static class a {
        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        /* access modifiers changed from: package-private */
        public InputConnection a(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
        }

        a() {
        }
    }

    /* renamed from: androidx.emoji.widget.b$b  reason: collision with other inner class name */
    private static class C0048b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f2089a;

        /* renamed from: b  reason: collision with root package name */
        private final i f2090b = new i(this.f2089a);

        C0048b(EditText editText) {
            this.f2089a = editText;
            this.f2089a.addTextChangedListener(this.f2090b);
            this.f2089a.setEditableFactory(c.a());
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            this.f2090b.a(i);
        }

        /* access modifiers changed from: package-private */
        public void b(int i) {
            this.f2090b.b(i);
        }

        /* access modifiers changed from: package-private */
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof f) {
                return keyListener;
            }
            return new f(keyListener);
        }

        /* access modifiers changed from: package-private */
        public InputConnection a(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof d) {
                return inputConnection;
            }
            return new d(this.f2089a, inputConnection, editorInfo);
        }
    }
}
