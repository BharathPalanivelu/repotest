package androidx.emoji.widget;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji.b.a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

final class e implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f2095a;

    /* renamed from: b  reason: collision with root package name */
    private a.d f2096b;

    e(TextView textView) {
        this.f2095a = textView;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.f2095a.isInEditMode()) {
            return charSequence;
        }
        int c2 = androidx.emoji.b.a.a().c();
        if (c2 != 0) {
            boolean z = true;
            if (c2 == 1) {
                if (i4 == 0 && i3 == 0 && spanned.length() == 0 && charSequence == this.f2095a.getText()) {
                    z = false;
                }
                if (!z || charSequence == null) {
                    return charSequence;
                }
                if (!(i == 0 && i2 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i, i2);
                }
                return androidx.emoji.b.a.a().a(charSequence, 0, charSequence.length());
            } else if (c2 != 3) {
                return charSequence;
            }
        }
        androidx.emoji.b.a.a().a(a());
        return charSequence;
    }

    private a.d a() {
        if (this.f2096b == null) {
            this.f2096b = new a(this.f2095a);
        }
        return this.f2096b;
    }

    private static class a extends a.d {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<TextView> f2097a;

        a(TextView textView) {
            this.f2097a = new WeakReference(textView);
        }

        public void a() {
            super.a();
            TextView textView = this.f2097a.get();
            if (textView != null && textView.isAttachedToWindow()) {
                CharSequence a2 = androidx.emoji.b.a.a().a(textView.getText());
                int selectionStart = Selection.getSelectionStart(a2);
                int selectionEnd = Selection.getSelectionEnd(a2);
                textView.setText(a2);
                if (a2 instanceof Spannable) {
                    e.a((Spannable) a2, selectionStart, selectionEnd);
                }
            }
        }
    }

    static void a(Spannable spannable, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(spannable, i, i2);
        } else if (i >= 0) {
            Selection.setSelection(spannable, i);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        }
    }
}
