package com.shopee.live.livestreaming.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

public class TouchableConstraintLayout extends ConstraintLayout {

    /* renamed from: g  reason: collision with root package name */
    protected a f28797g;
    protected long h;

    public interface a {
        void a();
    }

    public TouchableConstraintLayout(Context context) {
        super(context);
    }

    public TouchableConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchableConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.h = System.currentTimeMillis();
        } else if ((action == 1 || action == 3) && System.currentTimeMillis() - this.h <= 100) {
            a aVar = this.f28797g;
            if (aVar != null) {
                aVar.a();
            }
        }
        if (action == 0 || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setTouchListener(a aVar) {
        this.f28797g = aVar;
    }
}
