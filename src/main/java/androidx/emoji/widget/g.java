package androidx.emoji.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.i;

public class g extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private h f2099a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2100b;

    public g(Context context) {
        super(context);
        a();
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public g(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private void a() {
        if (!this.f2100b) {
            this.f2100b = true;
            getEmojiTextViewHelper().a();
        }
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().a(z);
    }

    private h getEmojiTextViewHelper() {
        if (this.f2099a == null) {
            this.f2099a = new h(this);
        }
        return this.f2099a;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
