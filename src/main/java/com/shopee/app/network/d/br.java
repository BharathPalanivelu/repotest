package com.shopee.app.network.d;

import com.beetalklib.network.d.f;
import com.shopee.app.appuser.UserInfo;
import com.shopee.protocol.action.SetUserInfo;

public class br extends az {

    /* renamed from: a  reason: collision with root package name */
    private UserInfo f18220a;

    /* access modifiers changed from: protected */
    public f a() {
        SetUserInfo.Builder builder = new SetUserInfo.Builder();
        builder.requestid(i().a()).pn_option(Long.valueOf(this.f18220a.getPnOption()));
        return new f(67, builder.build().toByteArray());
    }

    public void a(UserInfo userInfo, boolean z) {
        userInfo.toggleAllowAllNoti(z);
        this.f18220a = userInfo;
        g();
    }

    public void b(UserInfo userInfo, boolean z) {
        userInfo.setChatsNotiOn(z);
        this.f18220a = userInfo;
        g();
    }

    public void c(UserInfo userInfo, boolean z) {
        userInfo.setActionRequiredNotiOn(z);
        this.f18220a = userInfo;
        g();
    }

    public void d(UserInfo userInfo, boolean z) {
        userInfo.setActivityNotiOn(z);
        this.f18220a = userInfo;
        g();
    }

    public void e(UserInfo userInfo, boolean z) {
        userInfo.setOOSNotiOn(z);
        this.f18220a = userInfo;
        g();
    }

    public void f(UserInfo userInfo, boolean z) {
        userInfo.setSmartNotiOn(z);
        this.f18220a = userInfo;
        g();
    }

    public void g(UserInfo userInfo, boolean z) {
        userInfo.setNotiShopeePromotionOn(z);
        this.f18220a = userInfo;
        g();
    }

    public void h(UserInfo userInfo, boolean z) {
        userInfo.setNotiPersonalContent(z);
        this.f18220a = userInfo;
        g();
    }

    public void i(UserInfo userInfo, boolean z) {
        userInfo.setNotiRating(z);
        this.f18220a = userInfo;
        g();
    }

    public void j(UserInfo userInfo, boolean z) {
        userInfo.setEmailAllNoti(z);
        this.f18220a = userInfo;
        g();
    }

    public void k(UserInfo userInfo, boolean z) {
        userInfo.setEmailOrder(z);
        this.f18220a = userInfo;
        g();
    }

    public void l(UserInfo userInfo, boolean z) {
        userInfo.setEmailList(z);
        this.f18220a = userInfo;
        g();
    }

    public void m(UserInfo userInfo, boolean z) {
        userInfo.setEmailNews(z);
        this.f18220a = userInfo;
        g();
    }

    public void n(UserInfo userInfo, boolean z) {
        userInfo.setEmailPersonalised(z);
        this.f18220a = userInfo;
        g();
    }

    public void o(UserInfo userInfo, boolean z) {
        userInfo.setWallet(z);
        this.f18220a = userInfo;
        g();
    }

    public void p(UserInfo userInfo, boolean z) {
        userInfo.setNotiFeedCommented(z);
        this.f18220a = userInfo;
        g();
    }

    public void q(UserInfo userInfo, boolean z) {
        userInfo.setNotiFeedLiked(z);
        this.f18220a = userInfo;
        g();
    }

    public void r(UserInfo userInfo, boolean z) {
        userInfo.setNotiFeedMentioned(z);
        this.f18220a = userInfo;
        g();
    }
}
