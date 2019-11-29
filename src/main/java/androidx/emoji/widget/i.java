package androidx.emoji.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji.b.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class i implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f2104a;

    /* renamed from: b  reason: collision with root package name */
    private a.d f2105b;

    /* renamed from: c  reason: collision with root package name */
    private int f2106c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f2107d = 0;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    i(EditText editText) {
        this.f2104a = editText;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f2106c = i;
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.f2107d = i;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f2104a.isInEditMode() && i2 <= i3 && (charSequence instanceof Spannable)) {
            int c2 = androidx.emoji.b.a.a().c();
            if (c2 != 0) {
                if (c2 == 1) {
                    androidx.emoji.b.a.a().a((CharSequence) (Spannable) charSequence, i, i + i3, this.f2106c, this.f2107d);
                    return;
                } else if (c2 != 3) {
                    return;
                }
            }
            androidx.emoji.b.a.a().a(a());
        }
    }

    private a.d a() {
        if (this.f2105b == null) {
            this.f2105b = new a(this.f2104a);
        }
        return this.f2105b;
    }

    private static class a extends a.d {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f2108a;

        a(EditText editText) {
            this.f2108a = new WeakReference(editText);
        }

        public void a() {
            super.a();
            EditText editText = this.f2108a.get();
            if (editText != null && editText.isAttachedToWindow()) {
                Editable editableText = editText.getEditableText();
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                androidx.emoji.b.a.a().a((CharSequence) editableText);
                e.a(editableText, selectionStart, selectionEnd);
            }
        }
    }
}
