package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.core.widget.i;

public class h extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1206a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final u f1207b;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.f1207b = new u(this);
        this.f1207b.a(attributeSet, i);
        this.f1207b.b();
        ar a2 = ar.a(getContext(), attributeSet, f1206a, i, 0);
        setCheckMarkDrawable(a2.a(0));
        a2.a();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        u uVar = this.f1207b;
        if (uVar != null) {
            uVar.a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        u uVar = this.f1207b;
        if (uVar != null) {
            uVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
