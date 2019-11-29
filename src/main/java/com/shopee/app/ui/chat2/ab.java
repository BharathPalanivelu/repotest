package com.shopee.app.ui.chat2;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.n;
import com.shopee.id.R;

public class ab extends LinearLayout implements n<aj> {

    /* renamed from: a  reason: collision with root package name */
    TextView f20252a;

    /* renamed from: b  reason: collision with root package name */
    ImageView f20253b;

    public ab(Context context) {
        super(context);
    }

    public void a(aj ajVar) {
        this.f20252a.setText(ajVar.f20279b);
        if (!TextUtils.isEmpty(ajVar.f20279b)) {
            this.f20253b.setImageDrawable(b.f(R.drawable.com_garena_shopee_ic_arrow_right));
            this.f20252a.setTextColor(b.a(R.color.black87));
            return;
        }
        this.f20252a.setText(b.e(R.string.sp_label_add_new_msg_shortcut));
        this.f20253b.setImageDrawable(b.f(R.drawable.ic_addto));
        this.f20252a.setTextColor(b.a(R.color.complement));
    }
}
