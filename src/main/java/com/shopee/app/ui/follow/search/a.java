package com.shopee.app.ui.follow.search;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.SearchProductItem;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;

public class a extends FrameLayout implements n<UserBriefInfo> {

    /* renamed from: a  reason: collision with root package name */
    TextView f21772a;

    /* renamed from: b  reason: collision with root package name */
    TextView f21773b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f21774c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f21775d;

    /* renamed from: e  reason: collision with root package name */
    RobotoButton f21776e;

    /* renamed from: f  reason: collision with root package name */
    bi f21777f;

    /* renamed from: g  reason: collision with root package name */
    UserInfo f21778g;
    ak h;
    private UserBriefInfo i;

    /* renamed from: com.shopee.app.ui.follow.search.a$a  reason: collision with other inner class name */
    public interface C0321a {
        void a(a aVar);
    }

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((C0321a) ((x) context).b()).a(this);
    }

    public void a(UserBriefInfo userBriefInfo) {
        this.i = userBriefInfo;
        if (userBriefInfo instanceof SearchProductItem) {
            this.i = (UserBriefInfo) ((SearchProductItem) userBriefInfo).getExtra();
        }
        this.f21772a.setText(this.i.getUserName());
        this.f21773b.setText(this.i.getNickName());
        z.a(getContext()).a(this.i.getPortrait()).a(this.f21774c);
        if (this.i.isOfficialShop()) {
            this.f21775d.setImageResource(R.drawable.ic_product_details_shopeemall);
            this.f21775d.setVisibility(0);
        } else if (this.i.isShopeeVerified()) {
            this.f21775d.setImageResource(R.drawable.ic_shop_verified_tick);
            this.f21775d.setVisibility(0);
        } else {
            this.f21775d.setVisibility(8);
        }
    }

    public void a() {
        this.h.c(this.i.getUserId());
    }
}
