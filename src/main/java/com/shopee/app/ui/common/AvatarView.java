package com.shopee.app.ui.common;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.app.util.z;

public class AvatarView extends ImageView implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    ak f20975a;

    /* renamed from: b  reason: collision with root package name */
    private String f20976b;

    /* renamed from: c  reason: collision with root package name */
    private int f20977c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20978d = false;

    public interface a {
        void a(AvatarView avatarView);
    }

    public AvatarView(Context context) {
        super(context);
        a(context);
    }

    public AvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        if (!isInEditMode()) {
            ((a) ((x) context).b()).a(this);
            setOnClickListener(this);
            setOnTouchListener(this);
        }
    }

    public void a(int i, String str) {
        this.f20977c = i;
        this.f20976b = str;
        z.a(getContext()).a(this.f20976b).a((ImageView) this);
    }

    public void setAnonymous(boolean z) {
        this.f20978d = z;
    }

    public void onClick(View view) {
        int i = this.f20977c;
        if (i != -1 && !this.f20978d) {
            this.f20975a.c(i);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) {
                return false;
            }
            drawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
            imageView.invalidate();
            return false;
        } else if (action != 1 && action != 3) {
            return false;
        } else {
            ImageView imageView2 = (ImageView) view;
            Drawable drawable2 = imageView2.getDrawable();
            if (drawable2 == null) {
                return false;
            }
            drawable2.clearColorFilter();
            imageView2.invalidate();
            return false;
        }
    }
}
