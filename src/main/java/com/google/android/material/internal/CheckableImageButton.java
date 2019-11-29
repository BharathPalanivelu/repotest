package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import androidx.appcompat.a;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.g.a.d;
import androidx.core.g.w;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13358a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private boolean f13359b;

    public CheckableImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        w.a((View) this, (androidx.core.g.a) new androidx.core.g.a() {
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.a(true);
                dVar.b(CheckableImageButton.this.isChecked());
            }
        });
    }

    public void setChecked(boolean z) {
        if (this.f13359b != z) {
            this.f13359b = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public boolean isChecked() {
        return this.f13359b;
    }

    public void toggle() {
        setChecked(!this.f13359b);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.f13359b) {
            return mergeDrawableStates(super.onCreateDrawableState(i + f13358a.length), f13358a);
        }
        return super.onCreateDrawableState(i);
    }
}
