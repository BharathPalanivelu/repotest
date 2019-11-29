package com.shopee.app.ui.home.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.a.a.f;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class a extends RelativeLayout implements n<ActivityItemInfo> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f22027a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22028b;

    /* renamed from: c  reason: collision with root package name */
    ak f22029c;

    public a(Context context) {
        super(context);
        ((e) ((x) context).b()).a(this);
    }

    public void a(ActivityItemInfo activityItemInfo) {
        setBackgroundResource(R.drawable.activity_item_banner_background);
        f a2 = f.a(getContext());
        a2.a((int) R.string.sp_activity_action_box).b();
        a2.a(this.f22028b);
        this.f22027a.setBackgroundResource(R.drawable.action_box_avatar);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f22029c.g();
            }
        });
    }
}
