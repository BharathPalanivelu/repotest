package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class w extends ToggleButton {

    /* renamed from: a  reason: collision with root package name */
    private final u f1267a;

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1267a = new u(this);
        this.f1267a.a(attributeSet, i);
    }
}
