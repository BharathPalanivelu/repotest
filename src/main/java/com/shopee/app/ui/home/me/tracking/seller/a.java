package com.shopee.app.ui.home.me.tracking.seller;

import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.tracking.trackingv3.b;
import com.shopee.app.tracking.trackingv3.model.ImpressionData;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.a.j;
import d.a.z;
import d.l;
import java.util.HashMap;

public final class a implements com.shopee.app.tracking.c.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f22434a = "seller";

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<Integer, Info.InfoBuilder> f22435b = z.c(l.a(Integer.valueOf(R.id.listingWebView), Info.InfoBuilder.Companion.builder().withPageSection("my_products").withData(j.a(b.f19172a))));

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<Integer, Info.InfoBuilder> f22436c = z.c(l.a(Integer.valueOf(R.id.btnAddNewProductEmpty), Info.InfoBuilder.Companion.builder().withTargetType("add_products")), l.a(Integer.valueOf(R.id.followers), Info.InfoBuilder.Companion.builder().withTargetType("followers_button")), l.a(Integer.valueOf(R.id.following), Info.InfoBuilder.Companion.builder().withTargetType("following_button")), l.a(Integer.valueOf(R.id.settings_icon), Info.InfoBuilder.Companion.builder().withTargetType("account_settings")), l.a(Integer.valueOf(R.id.chat_btn), Info.InfoBuilder.Companion.builder().withTargetType(BaseEvent.SDK_CHAT)), l.a(Integer.valueOf(R.id.btnViewMyShop), Info.InfoBuilder.Companion.builder().withTargetType("view_seller")));

    public Info.InfoBuilder a(int i) {
        Info.InfoBuilder infoBuilder = this.f22435b.get(Integer.valueOf(i));
        if (infoBuilder == null) {
            return null;
        }
        infoBuilder.withPageType(this.f22434a);
        infoBuilder.withData(new ImpressionData(j.a(b.f19172a)));
        return infoBuilder;
    }

    public final Info.InfoBuilder b(int i) {
        Info.InfoBuilder infoBuilder;
        if (this.f22435b.containsKey(Integer.valueOf(i))) {
            infoBuilder = this.f22435b.get(Integer.valueOf(i));
        } else if (this.f22436c.containsKey(Integer.valueOf(i))) {
            infoBuilder = this.f22436c.get(Integer.valueOf(i));
        } else {
            infoBuilder = null;
        }
        if (infoBuilder == null) {
            return null;
        }
        infoBuilder.withPageType(this.f22434a);
        infoBuilder.withData(b.f19172a);
        return infoBuilder;
    }

    public final Info.InfoBuilder a(String str) {
        d.d.b.j.b(str, "featureName");
        if (d.d.b.j.a((Object) str, (Object) "seller_wallet")) {
            str = "wallet";
        } else if (d.d.b.j.a((Object) str, (Object) "shop_rating")) {
            str = "my_rating";
        } else if (n.f22642a.a(str) == null) {
            str = "self_design_button";
        }
        return Info.InfoBuilder.Companion.builder().withPageType("seller").withTargetType(str);
    }
}
