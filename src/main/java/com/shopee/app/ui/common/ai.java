package com.shopee.app.ui.common;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.ui.a.n;
import com.shopee.app.util.ak;
import com.shopee.app.util.ao;
import com.shopee.app.util.x;
import com.shopee.id.R;
import com.shopee.protocol.shop.ShopCover;
import com.squareup.a.ah;
import com.squareup.a.w;

public class ai extends ImageView implements n<ShopCover> {

    /* renamed from: a  reason: collision with root package name */
    SettingConfigStore f21141a;

    /* renamed from: b  reason: collision with root package name */
    ak f21142b;

    public interface a {
        void a(ai aiVar);
    }

    public ai(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        ((a) ((x) context).b()).a(this);
    }

    public void a(final ShopCover shopCover) {
        if (shopCover.type.intValue() == 0) {
            w a2 = w.a(getContext());
            a2.a("http://cf.shopee.co.id/file/" + shopCover.image_url).b(b.b(), (int) (((float) b.b()) / 2.0f)).d().a((ImageView) this);
            setOnClickListener((View.OnClickListener) null);
        } else if (shopCover.type.intValue() == 1) {
            w a3 = w.a(getContext());
            a3.a("http://cf.shopee.co.id/file/" + shopCover.image_url).a((ah) new ao(R.drawable.ic_profile_video)).a((ImageView) this);
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ai.this.f21142b.a(shopCover.video_url, ai.this.f21141a);
                }
            });
        }
    }
}
