package androidx.emoji.widget;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji.b.a;

final class d extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f2094a;

    d(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        super(inputConnection, false);
        this.f2094a = textView;
        a.a().a(editorInfo);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        if (a.a((InputConnection) this, a(), i, i2, false) || super.deleteSurroundingText(i, i2)) {
            return true;
        }
        return false;
    }

    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        if (a.a((InputConnection) this, a(), i, i2, true) || super.deleteSurroundingTextInCodePoints(i, i2)) {
            return true;
        }
        return false;
    }

    private Editable a() {
        return this.f2094a.getEditableText();
    }
}
