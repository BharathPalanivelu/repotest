package com.shopee.app.camera;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shopee.id.R;

public class b extends RelativeLayout {
    public b(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        inflate(context, R.layout.camera_focus_layout, this);
    }

    public void a(Context context) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.camera_focus_anim);
        loadAnimation.setFillEnabled(true);
        loadAnimation.setFillAfter(true);
        ((ImageView) findViewById(R.id.camera_inner)).startAnimation(loadAnimation);
    }
}
