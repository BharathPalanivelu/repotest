package androidx.emoji.widget;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji.b.a;

final class f implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f2098a;

    f(KeyListener keyListener) {
        this.f2098a = keyListener;
    }

    public int getInputType() {
        return this.f2098a.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return a.a(editable, i, keyEvent) || this.f2098a.onKeyDown(view, editable, i, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f2098a.onKeyUp(view, editable, i, keyEvent);
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f2098a.onKeyOther(view, editable, keyEvent);
    }

    public void clearMetaKeyState(View view, Editable editable, int i) {
        this.f2098a.clearMetaKeyState(view, editable, i);
    }
}
