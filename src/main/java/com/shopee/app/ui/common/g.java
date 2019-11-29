package com.shopee.app.ui.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.shopee.app.data.viewmodel.BannerData;
import com.shopee.app.ui.a.n;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.ui.webview.simpleweb.SimpleWebPageActivity_;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;
import com.squareup.a.w;

public class g extends ImageView implements n<BannerData> {
    public g(Context context) {
        super(context);
    }

    public void a(final BannerData bannerData) {
        w.a(getContext()).a(bannerData.getBannerImage()).a().d().a((ImageView) this);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!TextUtils.isEmpty(bannerData.getPageUrlNav())) {
                    WebPageActivity_.a(g.this.getContext()).b(bannerData.getPageUrlNav()).a(bannerData.getNavbarMsg()).f(bannerData.getPageConfig()).a();
                } else if (!TextUtils.isEmpty(bannerData.getPageUrl())) {
                    NavbarMessage navbarMessage = new NavbarMessage();
                    navbarMessage.setTitle(bannerData.getPageTitle());
                    SimpleWebPageActivity_.a(g.this.getContext()).a(WebRegister.GSON.b((Object) navbarMessage)).b(bannerData.getPageUrl()).a();
                }
            }
        });
    }
}
