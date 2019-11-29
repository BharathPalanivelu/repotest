package com.shopee.app.ui.order.search;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.bm;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class j extends RelativeLayout implements n<f> {

    /* renamed from: a  reason: collision with root package name */
    TextView f23823a;

    /* renamed from: b  reason: collision with root package name */
    TextView f23824b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f23825c;

    /* renamed from: d  reason: collision with root package name */
    TextView f23826d;

    public j(Context context) {
        super(context);
    }

    public void a(f fVar) {
        z.a(getContext()).a(fVar.f23815f).a(this.f23825c);
        int i = fVar.f23810a;
        if (i == 1) {
            d(fVar);
        } else if (i == 2) {
            c(fVar);
        } else if (i == 3) {
            b(fVar);
        }
    }

    private void b(f fVar) {
        this.f23823a.setVisibility(8);
        this.f23826d.setVisibility(0);
        this.f23824b.setVisibility(0);
        if (!TextUtils.isEmpty(fVar.i)) {
            this.f23824b.setText(fVar.f23811b);
            this.f23826d.setText(Html.fromHtml(b.a(R.string.sp_recipient_info, bm.b(fVar.f23813d, fVar.i))));
            return;
        }
        this.f23824b.setText(fVar.f23811b);
        this.f23826d.setText(fVar.f23813d);
    }

    private void c(f fVar) {
        this.f23823a.setVisibility(8);
        this.f23826d.setVisibility(0);
        this.f23824b.setVisibility(0);
        if (!TextUtils.isEmpty(fVar.i)) {
            this.f23824b.setText(fVar.f23811b);
            this.f23826d.setText(Html.fromHtml(b.a(R.string.sp_order_id_info, bm.b(fVar.j, fVar.i))));
            return;
        }
        this.f23824b.setText(fVar.f23811b);
        this.f23826d.setText(fVar.j);
    }

    private void d(f fVar) {
        if (TextUtils.isEmpty(fVar.i)) {
            this.f23823a.setText(fVar.f23811b);
        } else if (!fVar.f23811b.equals(b.e(R.string.sp_label_deleted_user))) {
            this.f23823a.setText(Html.fromHtml(bm.b(fVar.f23811b, fVar.i)));
        } else {
            this.f23823a.setText(fVar.f23811b);
        }
        this.f23824b.setVisibility(8);
        this.f23826d.setVisibility(8);
    }
}
