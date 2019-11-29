package com.shopee.app.ui.chat2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.util.l;

public class ChatRecyclerView extends RecyclerView {
    private boolean M = false;

    public ChatRecyclerView(Context context) {
        super(context);
    }

    public ChatRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i4 - i2;
        if (i5 >= l.p) {
            this.M = true;
        } else if (i5 <= (-l.p) && i4 != 0) {
            this.M = false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.M && motionEvent.getAction() == 0) {
            b.a("ON_HIDE_CHAT_PANEL", new a(), b.a.UI_BUS);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
