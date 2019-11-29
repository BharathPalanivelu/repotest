package androidx.emoji.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.emoji.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f2085a;

    public a(View view, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, a.C0044a.EmojiEditText, i, i2);
            this.f2085a = obtainStyledAttributes.getInteger(a.C0044a.EmojiEditText_maxEmojiCount, Integer.MAX_VALUE);
            obtainStyledAttributes.recycle();
        }
    }

    public int a() {
        return this.f2085a;
    }
}
