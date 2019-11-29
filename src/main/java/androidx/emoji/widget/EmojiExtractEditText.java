package androidx.emoji.widget;

import android.content.Context;
import android.inputmethodservice.ExtractEditText;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.widget.i;

public class EmojiExtractEditText extends ExtractEditText {

    /* renamed from: a  reason: collision with root package name */
    private b f2083a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2084b;

    public EmojiExtractEditText(Context context) {
        super(context);
        a((AttributeSet) null, 0, 0);
    }

    public EmojiExtractEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 16842862, 0);
    }

    public EmojiExtractEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i, 0);
    }

    public EmojiExtractEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(attributeSet, i, i2);
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        if (!this.f2084b) {
            this.f2084b = true;
            setMaxEmojiCount(new a(this, attributeSet, i, i2).a());
            setKeyListener(super.getKeyListener());
        }
    }

    public void setKeyListener(KeyListener keyListener) {
        if (keyListener != null) {
            keyListener = getEmojiEditTextHelper().a(keyListener);
        }
        super.setKeyListener(keyListener);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return getEmojiEditTextHelper().a(super.onCreateInputConnection(editorInfo), editorInfo);
    }

    public void setMaxEmojiCount(int i) {
        getEmojiEditTextHelper().a(i);
    }

    public void setEmojiReplaceStrategy(int i) {
        getEmojiEditTextHelper().b(i);
    }

    public int getEmojiReplaceStrategy() {
        return getEmojiEditTextHelper().b();
    }

    public int getMaxEmojiCount() {
        return getEmojiEditTextHelper().a();
    }

    private b getEmojiEditTextHelper() {
        if (this.f2083a == null) {
            this.f2083a = new b(this);
        }
        return this.f2083a;
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
