package com.shopee.app.ui.home.me.tracking;

import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.tracking.c.a;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.ui.home.me.v3.feature.n;
import com.shopee.id.R;
import d.a.z;
import d.d.b.j;
import d.l;
import java.util.HashMap;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f22422a = "me";

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<Integer, String> f22423b = z.c(l.a(Integer.valueOf(R.id.btnLogin), "log_in"), l.a(Integer.valueOf(R.id.btnSignup), "sign_up"), l.a(Integer.valueOf(R.id.followers), "followers_button"), l.a(Integer.valueOf(R.id.following), "following_button"), l.a(Integer.valueOf(R.id.settings_icon), "account_settings"), l.a(Integer.valueOf(R.id.cart_btn), "cart_button"), l.a(Integer.valueOf(R.id.chat_btn), BaseEvent.SDK_CHAT), l.a(Integer.valueOf(R.id.avatar), "profile_icon"));

    public Info.InfoBuilder a(int i) {
        String str = this.f22423b.get(Integer.valueOf(i));
        if (str != null) {
            return Info.InfoBuilder.Companion.builder().withPageType(this.f22422a).withTargetType(str);
        }
        return null;
    }

    public final Info.InfoBuilder a(String str) {
        j.b(str, "featureName");
        if (j.a((Object) str, (Object) "airpay_vn_wallet")) {
            str = "wallet";
        } else if (j.a((Object) str, (Object) "to_pay")) {
            str = "to_pay";
        } else if (j.a((Object) str, (Object) "to_ship")) {
            str = "to_ship";
        } else if (j.a((Object) str, (Object) "to_rate")) {
            str = "to_rate";
        } else if (j.a((Object) str, (Object) "to_return")) {
            str = "return_and_refund";
        } else if (j.a((Object) str, (Object) "to_receive")) {
            str = "to_receive";
        } else if (n.f22642a.a(str) == null) {
            str = "self_design_button";
        }
        return Info.InfoBuilder.Companion.builder().withPageType(this.f22422a).withTargetType(str);
    }
}
