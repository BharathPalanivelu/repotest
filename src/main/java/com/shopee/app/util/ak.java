package com.shopee.app.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.share.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.tools.b;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.VMItemAttribute;
import com.shopee.app.data.viewmodel.VariationData;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.h.m;
import com.shopee.app.h.r;
import com.shopee.app.line.a;
import com.shopee.app.react.ReactActivity_;
import com.shopee.app.react.modules.app.data.k;
import com.shopee.app.react.protocol.PushData;
import com.shopee.app.ui.actionbox.ActionBoxActivity_;
import com.shopee.app.ui.activity.ActivityActivity_;
import com.shopee.app.ui.activity.ShopUpdatesActivity_;
import com.shopee.app.ui.auth.AuthTabActivity_;
import com.shopee.app.ui.auth.password.ResetPasswordActivity_;
import com.shopee.app.ui.auth.password.SetNewPasswordActivity_;
import com.shopee.app.ui.auth.phone.PhoneVerifyActivity_;
import com.shopee.app.ui.auth.signup.email.EmailCaptchaActivity_;
import com.shopee.app.ui.auth.signup.email.EmailRegisterActivity_;
import com.shopee.app.ui.auth.signup.thirdparty.ThirdPartyRegisterActivity_;
import com.shopee.app.ui.bca.BCAEditXcoActivity;
import com.shopee.app.ui.bca.BCARegisterActivity;
import com.shopee.app.ui.chat.ChatActivity_;
import com.shopee.app.ui.chat2.ChatListActivity_;
import com.shopee.app.ui.chat2.MessageShortcutsActivity_;
import com.shopee.app.ui.chat2.MessageShortcutsEditActivity_;
import com.shopee.app.ui.chat2.block.BlockedUserActivity_;
import com.shopee.app.ui.chat2.order.OrderSelectActivity_;
import com.shopee.app.ui.chat2.order.singletab.OrderSingleTabActivity_;
import com.shopee.app.ui.chat2.product.ProductSelectionActivity_;
import com.shopee.app.ui.customer.list.MyCustomerActivity_;
import com.shopee.app.ui.customer.order.CustomerOrdersActivity_;
import com.shopee.app.ui.follow.following.FollowingActivity;
import com.shopee.app.ui.follow.following.recommend.RecommendFriendsActivity_;
import com.shopee.app.ui.follow.search.SearchUserActivity_;
import com.shopee.app.ui.home.HomeActivity_;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.home.me.editprofile.EditProfileActivity_;
import com.shopee.app.ui.home.me.v3.MyShopActivity_;
import com.shopee.app.ui.income.MyIncomeActivity_;
import com.shopee.app.ui.income.TransactionActivity_;
import com.shopee.app.ui.maps.BBMapLocationActivity;
import com.shopee.app.ui.myaccount.EmailSetActivity_;
import com.shopee.app.ui.myaccount.MyAccountActivity_;
import com.shopee.app.ui.myaccount.PhoneSettings.PhoneSettingsActivity_;
import com.shopee.app.ui.myaccount.SocialAccounts.SocialAccountsActivity_;
import com.shopee.app.ui.myproduct.MyProductActivity_;
import com.shopee.app.ui.order.MyOrderActivity_;
import com.shopee.app.ui.order.search.GetSearchShopCustomerActivity_;
import com.shopee.app.ui.product.add.AddProductActivity_;
import com.shopee.app.ui.product.add.FacebookPageActivity_;
import com.shopee.app.ui.product.add.wholesale.WholesaleActivity_;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.ui.product.attributes.AttributeListActivity_;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.ui.product.comment.CommentsActivity_;
import com.shopee.app.ui.product.comment.FeedsComment.FeedsCommentActivity_;
import com.shopee.app.ui.product.newsearch.SearchTabActivity_;
import com.shopee.app.ui.product.rating.RatingImageActivity_;
import com.shopee.app.ui.scanner.ScannerActivity_;
import com.shopee.app.ui.setting.NotificationBatchActivity_;
import com.shopee.app.ui.setting.SettingActivity_;
import com.shopee.app.ui.setting.emailnotification.EmailNotificationActivity_;
import com.shopee.app.ui.setting.language.LanguageSettingActivity_;
import com.shopee.app.ui.setting.notification2.NotificationActivity2_;
import com.shopee.app.ui.setting.privacy.PrivacyActivity_;
import com.shopee.app.ui.shopassistant.ShopAssistantActivity_;
import com.shopee.app.ui.shopassistant.chatSetting.ChatSettingActivity_;
import com.shopee.app.ui.shopassistant.shopProfile.ShopProfileActivity_;
import com.shopee.app.ui.shopassistant.shopSetting.SetAutoReplyActivity_;
import com.shopee.app.ui.shopassistant.shopSetting.ShopSettingActivity_;
import com.shopee.app.ui.tutorial.TutorialActivity_;
import com.shopee.app.ui.webview.WebPageActivity_;
import com.shopee.app.ui.webview.simpleweb.SimpleWebPageActivity_;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.youtube.OpenYouTubePlayerActivity;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.ImageSearchData;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.app.web.protocol.PhotoRatingPageData;
import com.shopee.app.web.protocol.RightItemMessage;
import com.shopee.app.web.protocol.SalesforceChatData;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.id.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import tencent.tls.platform.SigType;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    private Activity f26153a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26154b = true;

    /* renamed from: c  reason: collision with root package name */
    private s f26155c = ar.f().e().featureToggleManager();

    /* renamed from: d  reason: collision with root package name */
    private k f26156d = ar.f().e().rnConfigProvider();

    public ak(Activity activity) {
        this.f26153a = activity;
    }

    public Context a() {
        return this.f26153a;
    }

    public void a(int i, int i2) {
        RecommendFriendsActivity_.a(this.f26153a).b(i).c(i2).a();
    }

    public void b() {
        AuthTabActivity_.a(this.f26153a).b(0).a(1);
    }

    public void c() {
        ThirdPartyRegisterActivity_.a(this.f26153a).a(8);
    }

    public void a(a aVar) {
        ThirdPartyRegisterActivity_.a(this.f26153a).b(2).a((Serializable) aVar).a(29);
    }

    public void a(int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "seller/collections/" + i + Constants.URL_PATH_DELIMITER).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void d() {
        EmailCaptchaActivity_.a(this.f26153a).a(2);
    }

    public void a(String str, String str2) {
        EmailRegisterActivity_.a(this.f26153a).a(str).b(str2).a(2);
    }

    public String a(ChatIntention chatIntention, int i) {
        ChatActivity_.a(this.f26153a).a(chatIntention).b(i).a();
        return ChatActivity_.class.getSimpleName();
    }

    public String a(long j, int i, int i2, String str) {
        ChatActivity_.a(this.f26153a).a(new ChatIntention(j, i, 0, str)).b(i2).a();
        return ChatActivity_.class.getSimpleName();
    }

    public String a(long j, int i, int i2) {
        return a(j, i, i2, "");
    }

    public String a(int i, int i2, long j) {
        ChatActivity_.a(this.f26153a).a(new ChatIntention(0, i, j, "")).b(i2).a();
        return ChatActivity_.class.getSimpleName();
    }

    public void a(long j) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(String.format(i.f7040c + "order/detail/?checkoutid=%d", new Object[]{Long.valueOf(j)})).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(long j, long j2, int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(String.format(i.f7040c + "order/detail/?orderid=%d&checkoutid=%d&shopid=%d&rightnav=order", new Object[]{Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i)})).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(long j, long j2) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(String.format(i.f7040c + "order/detail/?orderid=%d&checkoutid=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)})).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void b(int i) {
        a("SHOP_PAGE", "shopid=" + i, "action");
    }

    public void a(int i, String str) {
        o oVar = new o();
        oVar.a("shopid", (Number) Integer.valueOf(i));
        oVar.a(ShareConstants.FEED_SOURCE_PARAM, "search");
        oVar.a("tab", str);
        a("SHOP_PAGE", oVar.toString(), "");
    }

    public void b(long j) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/payment/" + j).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void c(long j) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/payment/" + j + "/select/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(int i, long j) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/payment/" + j).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    @Deprecated
    public void c(int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/user/" + i).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(int i, boolean z) {
        o oVar = new o();
        oVar.a("userId", (Number) Integer.valueOf(i));
        oVar.a("isSeller", Boolean.valueOf(z));
        a("SHOP_PAGE_RATING", oVar.toString(), "");
    }

    public void a(String str) {
        WebPageActivity_.a(this.f26153a).b(str).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void e() {
        ChatListActivity_.a(this.f26153a).a();
    }

    public void d(int i) {
        ChatActivity_.a(this.f26153a).a(new ChatIntention(0, 0, 0)).b(i).a();
    }

    public void b(int i, long j) {
        a("PRODUCT_PAGE", "shopid=" + i + "&itemid=" + j, "action");
    }

    public void c(int i, long j) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/" + i + "/snapshot/" + j).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void f() {
        AuthTabActivity_.a(this.f26153a).b(1).a(1);
    }

    public void b(String str) {
        ((AuthTabActivity_.a) AuthTabActivity_.a(this.f26153a).a(str).b(1).k(67108864)).a(1);
    }

    public String g() {
        Activity activity = this.f26153a;
        activity.startActivity(new Intent(activity, ChatListActivity_.class));
        return ChatListActivity_.class.getSimpleName();
    }

    public String e(int i) {
        ActionBoxActivity_.a(this.f26153a).b(i).a();
        return ActionBoxActivity_.class.getSimpleName();
    }

    public void a(int i, UploadManager uploadManager, boolean z, boolean z2) {
        UploadGroup uploading = uploadManager.getUploading();
        if (uploading == null) {
            if (z) {
                Activity activity = this.f26153a;
                com.shopee.app.ui.dialog.a.a((Context) activity, "type=" + i);
                return;
            }
            AddProductActivity_.a(this.f26153a).b(i).a(7);
        } else if (z2) {
            com.shopee.app.ui.dialog.a.a((Context) this.f26153a, uploadManager, uploading, (int) R.string.sp_block_add_product_msg);
        }
    }

    public void c(String str) {
        ResetPasswordActivity_.a(this.f26153a).a(str).a(2);
    }

    public void b(String str, String str2) {
        SetNewPasswordActivity_.a(this.f26153a).a(as.a(str)).b(str2).a(2);
    }

    public void h() {
        MyProductActivity_.a(this.f26153a).a();
    }

    public void f(int i) {
        MyProductActivity_.a(this.f26153a).b(i).a();
    }

    public void i() {
        MyOrderActivity_.a(this.f26153a).b(1).a();
    }

    public void j() {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/wallet/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void k() {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/seen_item/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void b(int i, String str) {
        MyOrderActivity_.a(this.f26153a).b(1).a(str).c(i).a();
    }

    public void g(int i) {
        b(i, "");
    }

    public void l() {
        if (this.f26155c.a("rn_order_list_buyer")) {
            m(0);
        } else {
            MyOrderActivity_.a(this.f26153a).b(0).a();
        }
    }

    public void h(int i) {
        if (this.f26155c.a("rn_order_list_buyer")) {
            m(i);
        } else {
            MyOrderActivity_.a(this.f26153a).b(0).c(i).a();
        }
    }

    private void m(int i) {
        a("ORDER_LIST_BUYER", "initialTabIndex=" + i, "");
    }

    public void a(long j, int i) {
        a(j, i, "");
    }

    public void a(long j, int i, String str) {
        String format = String.format(i.f7040c + "order/detail/?shopid=%d&orderid=%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        if (!TextUtils.isEmpty(str)) {
            format = format + "&filter=" + str;
        }
        WebPageActivity_.a(this.f26153a).b(format).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void d(long j) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_transaction_history));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "seller/trans/" + j).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void b(long j, int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(String.format(i.f7040c + "order/detail/?shopid=%d&orderid=%d&rightnav=order", new Object[]{Integer.valueOf(i), Long.valueOf(j)})).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void i(int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/" + i + "/followers/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void j(int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/" + i + "/following/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void m() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_my_likes));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/likes/").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void n() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_label_digital_purchase));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7041d + "produk-digital" + "/m/orders").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void o() {
        a("GROUP_BUY_LANDING_PAGE", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
    }

    public void p() {
        ShopAssistantActivity_.a(this.f26153a).a();
    }

    public void q() {
        u("SHOPEE_BUDDY_LANDING_PAGE");
    }

    public void r() {
        MyCustomerActivity_.a(this.f26153a).a();
    }

    public void s() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_my_performance));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "seller/performance/").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void a(int i, int i2, String str, String str2) {
        CustomerOrdersActivity_.a(this.f26153a).b(i).c(i2).a(str).b(str2).a();
    }

    public void t() {
        ((EditProfileActivity_.a) EditProfileActivity_.a(this.f26153a).k(536870912)).a();
    }

    public void d(String str) {
        SearchUserActivity_.a(this.f26153a).a(str).a();
    }

    public void a(String str, boolean z) {
        a(str, z, (String) null);
    }

    public void a(String str, boolean z, String str2) {
        SearchUserActivity_.a(this.f26153a).a(str).a(z).b(str2).a();
    }

    public void b(String str, boolean z) {
        SearchConfig defaultUserConfig = SearchConfig.defaultUserConfig();
        defaultUserConfig.setOfficialShopOnly(z);
        ((SearchTabActivity_.a) SearchTabActivity_.a(this.f26153a).b(WebRegister.GSON.b(defaultUserConfig, SearchConfig.class)).a(str).k(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)).a(10029);
    }

    private static NavbarMessage aw() {
        NavbarMessage navbarMessage = new NavbarMessage();
        RightItemMessage rightItemMessage = new RightItemMessage();
        ArrayList arrayList = new ArrayList();
        RightItemMessage rightItemMessage2 = new RightItemMessage();
        rightItemMessage2.setType(BaseEvent.SDK_CHAT);
        arrayList.add(rightItemMessage2);
        rightItemMessage.setItems(arrayList);
        navbarMessage.setRightItemsConfig(rightItemMessage);
        return navbarMessage;
    }

    public void u() {
        e("");
    }

    public static void a(Activity activity) {
        new ak(activity).e("");
    }

    public void e(String str) {
        if (this.f26156d.d()) {
            g(str);
            return;
        }
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/cart?pass_back_string=" + str + "&" + ("_ts=" + com.garena.android.appkit.tools.a.a.b())).a(WebRegister.GSON.b((Object) aw())).a();
    }

    public void f(String str) {
        if (this.f26156d.d()) {
            g("");
            return;
        }
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/cart?" + ("_ts=" + com.garena.android.appkit.tools.a.a.b())).a(WebRegister.GSON.b((Object) aw())).c(str).a();
    }

    public void g(String str) {
        o oVar = new o();
        oVar.a("passBackString", str);
        a("CART", WebRegister.GSON.a((l) oVar), AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
    }

    public void a(long j, UploadManager uploadManager) {
        UploadGroup uploading = uploadManager.getUploading();
        if (uploading == null) {
            AddProductActivity_.a(this.f26153a).a(j).a();
        } else {
            com.shopee.app.ui.dialog.a.a((Context) this.f26153a, uploadManager, uploading, (int) R.string.sp_block_add_product_msg);
        }
    }

    public void v() {
        ((HomeActivity_.a) HomeActivity_.a(this.f26153a).k(67108864)).a(true).a();
    }

    public void h(String str) {
        ((HomeActivity_.a) HomeActivity_.a(this.f26153a).k(67108864)).a(true).a(str).a();
    }

    public void w() {
        ((HomeActivity_.a) HomeActivity_.a(this.f26153a).k(67108864)).a();
    }

    public void i(String str) {
        Activity activity = this.f26153a;
        if (!(activity instanceof c)) {
            ((HomeActivity_.a) HomeActivity_.a(activity).k(67108864)).a(str).a();
        } else {
            ((c) activity).d(str);
        }
    }

    public void a(boolean z) {
        SettingActivity_.a(this.f26153a).a(z).a();
    }

    public void x() {
        ScannerActivity_.a(this.f26153a).a(1002);
    }

    public void y() {
        LanguageSettingActivity_.a(this.f26153a).a();
    }

    public void j(String str) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_help_centre));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(l.f7045a + "answer/" + str).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void k(String str) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_help_centre));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(l.f7045a + "article/" + str + Constants.URL_PATH_DELIMITER).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void z() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_community_rule));
        SimpleWebPageActivity_.a(this.f26153a).b(l.j).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void A() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_tip_n_trick));
        SimpleWebPageActivity_.a(this.f26153a).b(l.k).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void B() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_help_centre));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(l.f7045a + "category/policy/").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void l(String str) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_help_centre));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(l.f7045a + "answer/" + str + "/?category/account").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void C() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_label_terms_of_service));
        SimpleWebPageActivity_.a(this.f26153a).b(l.l).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void D() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_label_privacy_policy));
        SimpleWebPageActivity_.a(this.f26153a).b(l.m).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void m(String str) {
        if (!str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
            str = Marker.ANY_NON_NULL_MARKER + str;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        this.f26153a.startActivity(intent);
    }

    public void b(long j, int i, int i2) {
        CommentsActivity_.a(this.f26153a).a(j).d(i2).b(i).a();
    }

    public void a(long j, int i, boolean z) {
        CommentsActivity_.a(this.f26153a).a(j).b(i).c(z ? 1 : 0).a();
    }

    public void E() {
        BlockedUserActivity_.a(this.f26153a).a();
    }

    public void F() {
        MyIncomeActivity_.a(this.f26153a).a();
    }

    public void G() {
        MyIncomeActivity_.a(this.f26153a).b(1).c(R.string.sp_label_pending_release).a();
    }

    public void H() {
        ShopSettingActivity_.a(this.f26153a).a();
    }

    public void I() {
        ReactActivity_.a(this.f26153a).a("SHOP_SETTINGS_PAGE").a();
    }

    public void J() {
        ShopProfileActivity_.a(this.f26153a).a();
    }

    public void K() {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/bankaccount/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void L() {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/bankaccount/add").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void M() {
        TransactionActivity_.a(this.f26153a).b(0).a();
    }

    public void d(int i, long j) {
        String str;
        if (m.a(i)) {
            str = i.f7040c + "buyer/return/seller/view/orderid/" + j;
        } else {
            str = i.f7040c + "buyer/return/view/orderid/" + j;
        }
        WebPageActivity_.a(this.f26153a).b(str).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(boolean z, long j) {
        String str;
        if (z) {
            str = i.f7040c + "buyer/return/seller/view/" + j;
        } else {
            str = i.f7040c + "buyer/return/view/" + j;
        }
        WebPageActivity_.a(this.f26153a).b(str).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(boolean z, long j, int i) {
        WebPageActivity_.a(this.f26153a).b((i.f7040c + "buyer/return/view/" + j) + "?purerefund=1").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(OrderDetail orderDetail) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/return/add/shopid/" + orderDetail.getShopId() + "/orderid/" + orderDetail.getOrderId()).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void e(int i, long j) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/orders/cancel/seller/shopid/" + i + "/orderid/" + j).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(int i, long j, boolean z) {
        String str = i.f7040c + "buyer/orders/cancel_view/";
        if (z) {
            str = str + "seller/";
        }
        WebPageActivity_.a(this.f26153a).b(str + "shopid/" + i + "/orderid/" + j).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void N() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_bugs_and_feedback));
        WebPageActivity_.a(this.f26153a).b(l.o).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void f(int i, long j) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "order/requested_cancellation_details/?orderid=" + j + "&shopid=" + i).a();
    }

    public void O() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_label_my_address));
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/edit_addresses/").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void a(Class cls) {
        Activity activity = this.f26153a;
        activity.startActivity(new Intent(activity, cls));
    }

    public void n(String str) {
        WebPageActivity_.a(this.f26153a).b(str).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void c(long j, int i) {
        FeedsCommentActivity_.a(this.f26153a).a(j).b(i).a();
    }

    public void P() {
        String packageName = this.f26153a.getPackageName();
        try {
            Activity activity = this.f26153a;
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            Activity activity2 = this.f26153a;
            activity2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public void a(long j, long j2, boolean z) {
        String str;
        if (!z) {
            String str2 = i.f7040c + "seller/logistics/shipping_fee/?itemid=" + j;
            if (j2 != 0) {
                str2 = str2 + "&editid=" + j2;
            }
            str = str2 + "&new_app=true";
        } else {
            str = i.f7040c + "seller/logistics/shipping/item/?itemid=" + j;
            if (j2 != 0) {
                str = str + "&editid=" + j2;
            }
        }
        WebPageActivity_.a(this.f26153a).b(str).a(330);
    }

    public void b(long j, long j2) {
        String str = i.f7040c + "seller/logistics/item_weight/?itemid=" + j;
        if (j2 != 0) {
            str = str + "&editid=" + j2;
        }
        WebPageActivity_.a(this.f26153a).b(str).a(330);
    }

    public void Q() {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "seller/logistics/settings/").a();
    }

    public void R() {
        MyAccountActivity_.a(this.f26153a).a();
    }

    public void S() {
        PhoneSettingsActivity_.a(this.f26153a).a();
    }

    public void T() {
        SocialAccountsActivity_.a(this.f26153a).a();
    }

    public void a(String str, List<Integer> list, int i) {
        o oVar = new o();
        if (!af.a(list)) {
            i iVar = new i();
            for (Integer intValue : list) {
                iVar.a((Number) Integer.valueOf(intValue.intValue()));
            }
            oVar.a("appRecentLeafIds", (l) iVar);
        }
        oVar.a("productName", str);
        oVar.a("editingLeafId", (Number) Integer.valueOf(i));
        a("ADD_PRODUCT_CATEGORY", oVar.toString(), "");
    }

    public void e(long j) {
        n(i.f7040c + "buyer/logistics/select/" + j + Constants.URL_PATH_DELIMITER);
    }

    public void a(long j, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = "?filter=" + str;
        } else {
            str2 = "";
        }
        n(i.f7040c + "seller/logistics/" + j + str2);
    }

    public void b(long j, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = "?filter=" + str;
        } else {
            str2 = "";
        }
        n(i.f7040c + "seller/logistics/" + j + str2);
    }

    public void f(long j) {
        n(i.f7040c + "seller/order/revise/" + j + Constants.URL_PATH_DELIMITER);
    }

    public void d(long j, int i) {
        n(i.f7040c + "buyer/logistics/info/" + i + Constants.URL_PATH_DELIMITER + j + Constants.URL_PATH_DELIMITER);
    }

    public void a(Context context) throws ActivityNotFoundException {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName())));
        } catch (ActivityNotFoundException unused) {
            r.a().b((int) R.string.sp_cannot_find_local_market_app);
        }
    }

    public void U() {
        PrivacyActivity_.a(this.f26153a).a();
    }

    public void o(String str) {
        SetAutoReplyActivity_.a(this.f26153a).a(str).a(1);
    }

    public void k(int i) {
        n(i.f7040c + "shop/" + i + "/report/");
    }

    public void V() {
        n(i.f7040c + "seller/portal/");
    }

    public void W() {
        MyShopActivity_.a(this.f26153a).a();
    }

    public void X() {
        ChatSettingActivity_.a(this.f26153a).a();
    }

    public void Y() {
        u("E_RECEIPT_SETTINGS");
    }

    public void Z() {
        o oVar = new o();
        oVar.a("userFlow", "change_phone");
        a("VERIFY_PASSWORD", oVar.toString(), "");
    }

    public void p(String str) {
        EmailSetActivity_.a(this.f26153a).a(str).a(24);
    }

    public void q(String str) {
        FacebookPageActivity_.a(this.f26153a).a(str).a(550);
    }

    public void l(int i) {
        ShopUpdatesActivity_.a(this.f26153a).b(i).a();
    }

    public void aa() {
        l(0);
    }

    public void b(boolean z) {
        if (z) {
            l(1);
        } else {
            ActivityActivity_.a(this.f26153a).a();
        }
    }

    public void ab() {
        TutorialActivity_.a(this.f26153a).a(20123);
    }

    public void ac() {
        NotificationActivity2_.a(this.f26153a).a();
    }

    public void a(int i, int i2, String str) {
        ProductSelectionActivity_.a(this.f26153a).b(i2).c(i).a(str).a(816);
    }

    public void b(int i, int i2) {
        OrderSelectActivity_.a(this.f26153a).b(i2).c(i).a(6271);
    }

    public void c(int i, int i2) {
        OrderSingleTabActivity_.a(this.f26153a).b(i2).c(i).a(6271);
    }

    public void ad() {
        EmailNotificationActivity_.a(this.f26153a).a();
    }

    private void y(String str) {
        ar.f().e().appLifeCycleManager().b();
        this.f26153a.startActivity(new Intent((String) null, Uri.parse("ytv://" + str), this.f26153a, OpenYouTubePlayerActivity.class));
    }

    public void r(String str) {
        ar.f().e().appLifeCycleManager().b();
        this.f26153a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + str)));
    }

    public void a(String str, SettingConfigStore settingConfigStore) {
        if (settingConfigStore.youtubePlayerEnabled()) {
            y(str);
        } else {
            r(str);
        }
    }

    public void ae() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_help_centre));
        WebPageActivity_.a(this.f26153a).b(l.f7045a).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void s(String str) {
        o oVar = new o();
        oVar.a("navigate_url", str);
        a("TRANSFER_PAGE", WebRegister.GSON.a((l) oVar), AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
    }

    public void t(String str) {
        o oVar = new o();
        oVar.a("help_center", str);
        a("TRANSFER_PAGE", WebRegister.GSON.a((l) oVar), AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
    }

    public void b(OrderDetail orderDetail) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/" + orderDetail.getUserId() + "/rating/?orderid=" + orderDetail.getOrderId() + "#tab=about").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void c(OrderDetail orderDetail) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/" + orderDetail.getShopId() + "/rating/?orderid=" + orderDetail.getOrderId()).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void e(long j, int i) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "order/buyer/rate_order/" + j + "/?shopid=" + i).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void d(OrderDetail orderDetail) {
        e(orderDetail.getOrderId(), orderDetail.getShopId());
    }

    public void e(OrderDetail orderDetail) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "order/seller/rate_order/" + orderDetail.getOrderId() + "/?shopid=" + orderDetail.getShopId()).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void f(OrderDetail orderDetail) {
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/rating/seller?orderid=" + orderDetail.getOrderId()).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void g(long j) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_label_change_rating));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/rating/buyer/" + j).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void af() {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_xiaomi_guide));
        WebPageActivity_.a(this.f26153a).b(l.f7047c).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void ag() {
        PackageManager packageManager = this.f26153a.getPackageManager();
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.miui.securitycenter/com.miui.securityscan.MainActivity");
        if (launchIntentForPackage != null) {
            this.f26153a.startActivity(launchIntentForPackage);
            return;
        }
        Intent launchIntentForPackage2 = packageManager.getLaunchIntentForPackage("com.miui.securitycenter");
        if (launchIntentForPackage2 != null) {
            this.f26153a.startActivity(launchIntentForPackage2);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:com.shopee.id"));
        intent.addFlags(SigType.TLS);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        this.f26153a.startActivity(intent);
    }

    public void h(long j) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_label_dispute_rating));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "shop/rating/dispute/" + j).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void ah() {
        NavbarMessage navbarMessage = new NavbarMessage();
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "seller/portal/collection/app_landing").a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void ai() {
        ReactActivity_.a(this.f26153a).a("REFERRAL_PROGRAM_HOME").a();
    }

    public void aj() {
        new NavbarMessage();
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "koin-shopee/").a("{\"isTransparent\":1}").a();
    }

    public void ak() {
        WebPageActivity_.a(this.f26153a).b(i.f7041d + "seller_loan").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void al() {
        NotificationBatchActivity_.a(this.f26153a).a();
    }

    public void a(int i, String str, String str2, int i2) {
        GetSearchShopCustomerActivity_.a(this.f26153a).c(i).a(str).b(str2).b(i2).d(1).a();
    }

    public void am() {
        GetSearchShopCustomerActivity_.a(this.f26153a).a();
    }

    public void an() {
        WebPageActivity_.a(this.f26153a).b(l.f7046b).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void a(int i, String str, int i2, int i3, byte[] bArr, String str2) {
        AttributeListActivity_.a(this.f26153a).b(i).a(str).c(i2).a(bArr).d(i3).b(str2).a(25);
    }

    public void a(VMItemAttribute vMItemAttribute, byte[] bArr, int i, u uVar) {
        AttributeListActivity_.a(this.f26153a).b(vMItemAttribute.getAttrId()).a(vMItemAttribute.getDisplayName()).c(0).a(true).a(bArr).d(i).b(uVar.b()).a(25);
    }

    public void a(float f2, float f3, String str, String str2) {
        Intent intent = new Intent(this.f26153a, BBMapLocationActivity.class);
        intent.putExtra("BUNDLE_LATITUDE_KEY", f2);
        intent.putExtra("BUNDLE_LONGITUDE_KEY", f3);
        intent.putExtra("BUNDLE_TITLE_KEY", b.e(R.string.sp_shop_location));
        intent.putExtra("BUNDLE_SEND_ACTION_KEY", true);
        intent.putExtra("BUNDLE_HOME_ACTION_ID", R.drawable.com_garena_shopee_ic_back);
        intent.putExtra("BUNDLE_SET_MARKER_ID", str);
        intent.putExtra("BUNDLE_SHOP_NAME_ID", str2);
        this.f26153a.startActivity(intent);
    }

    public void ao() {
        MessageShortcutsActivity_.a(this.f26153a).a();
    }

    public void c(int i, String str) {
        MessageShortcutsEditActivity_.a(this.f26153a).b(i).a(str).a(28);
    }

    public void ap() {
        MessageShortcutsEditActivity_.a(this.f26153a).a(28);
    }

    public void a(VariationData variationData) {
        a("ADD_PRODUCT_EDIT_PRICE_STOCK", WebRegister.GSON.b((Object) variationData), "");
    }

    public void b(VariationData variationData) {
        a("ADD_PRODUCT_EDIT_VARIATION", WebRegister.GSON.b((Object) variationData), "");
    }

    public void b(int i, boolean z) {
        a(bn.e(i, z), "", "");
    }

    public void aq() {
        a("WALLET_VN", "", "");
    }

    public void ar() {
        a("WALLET_JKO", "", "");
    }

    public void u(String str) {
        a(str, "", "");
    }

    public void a(String str, String str2, String str3) {
        a(str, 0, str2, str3, 0);
    }

    public void a(String str, String str2, String str3, int i) {
        a(str, 0, str2, str3, i);
    }

    public void a(String str, int i, String str2, String str3) {
        a(str, i, str2, str3, 0);
    }

    public void a(String str, int i, String str2, String str3, int i2) {
        com.shopee.app.react.d.b.a(this.f26153a, str, new PushData(str2), str3, i2, i);
        aj.a(this.f26153a, i);
    }

    public void a(String str, String str2, String str3, String str4) {
        PhoneVerifyActivity_.a(this.f26153a).b(5).d(str2).a(str3).e(str).c(str4).f("seed_login").f(2).d((int) R.string.sp_need_otp_info).e((int) R.string.sp_verify_capital).c((int) R.string.sp_verify_capital).a(false).a(9);
    }

    public void v(String str) {
        NavbarMessage navbarMessage = new NavbarMessage();
        navbarMessage.setTitle(b.e(R.string.sp_ach_title));
        WebPageActivity_.a a2 = WebPageActivity_.a(this.f26153a);
        a2.b(i.f7040c + "buyer/bankaccount/add?skip=1&" + str).a(WebRegister.GSON.b((Object) navbarMessage)).a();
    }

    public void a(boolean z, Long l, List<WholesaleTierModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        WholesaleActivity_.a(a()).a(l).a((ArrayList<WholesaleTierModel>) arrayList).a(z && this.f26154b).a(551);
        this.f26154b = false;
    }

    public void c(long j, long j2) {
        String str = i.f7040c + "seller/logistics/item_dimension/?itemid=" + j;
        if (j2 != 0) {
            str = str + "&editid=" + j2;
        }
        WebPageActivity_.a(this.f26153a).b(str).a(330);
    }

    public void a(SalesforceChatData salesforceChatData) {
        com.shopee.app.util.sfchat.b.f26507a.a(this.f26153a, salesforceChatData);
    }

    public void i(long j) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/return/logistics/" + j + "/aftership/").a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void j(long j) {
        WebPageActivity_.a(this.f26153a).b(i.f7040c + "buyer/return/shipping/details/" + j).a(WebRegister.GSON.b((Object) new NavbarMessage())).a();
    }

    public void as() {
        ((HomeActivity_.a) HomeActivity_.a(this.f26153a).k(603979776)).a("imageSearch").a();
    }

    public void a(ImageSearchData imageSearchData) {
        com.shopee.app.ui.d.c.a(this.f26153a, imageSearchData);
    }

    public void a(PhotoRatingPageData photoRatingPageData) {
        RatingImageActivity_.a(this.f26153a).b(photoRatingPageData.getShopID()).a(photoRatingPageData.getItemID()).a(photoRatingPageData.withCommentsOnly()).e(photoRatingPageData.getType()).d(photoRatingPageData.getImageIndex()).c(photoRatingPageData.getCommentIndex()).a(7222);
    }

    public void w(String str) {
        ((HomeActivity_.a) HomeActivity_.a(this.f26153a).k(603979776)).a("imageSearchHint?imageSearchUri=" + str).a();
    }

    public void at() {
        ReactActivity_.a(this.f26153a).a("VOUCHER_WALLET_HOME_PAGE").a();
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        BCARegisterActivity.f19979c.a(this.f26153a, str, str2, str3, str4, str5, str6, str7, str8, i, i2);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, int i2) {
        BCAEditXcoActivity.f19970c.a(this.f26153a, str, str2, str3, str4, str5, str6, str7, str8, str9, i, i2);
    }

    public void x(String str) {
        String b2 = bl.f7034a.b(str);
        if (!TextUtils.isEmpty(b2)) {
            WebPageActivity_.a(this.f26153a).b(b2).a("{\"isTransparent\":1}").a();
        }
    }

    public void au() {
        WebPageActivity_.a(this.f26153a).b(bl.f7034a.b()).a();
    }

    public void av() {
        a(FollowingActivity.class);
    }
}
