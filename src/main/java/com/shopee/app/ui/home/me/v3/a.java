package com.shopee.app.ui.home.me.v3;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.places.model.PlaceFields;
import com.shopee.app.a;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.ChatBadgeStore;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.theme.ThemeStore;
import com.shopee.app.data.viewmodel.MeCounter;
import com.shopee.app.data.viewmodel.ShopDetail;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.home.me.MeCoverImageView;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.app.util.z;
import com.shopee.id.R;
import d.d.b.j;
import d.d.b.r;
import d.m;
import java.util.Arrays;

public class a extends ConstraintLayout {
    public com.shopee.app.tracking.a A;
    public MeCounter B;
    public ChatBadgeStore C;
    public ThemeStore D;
    private com.shopee.app.ui.actionbar.a E;
    private ShopDetail F;
    /* access modifiers changed from: private */
    public boolean G;
    private com.shopee.app.ui.home.me.tracking.d H;
    private com.shopee.app.ui.home.me.tracking.a I;
    private String J;

    /* renamed from: g  reason: collision with root package name */
    public MeCoverImageView f22479g;
    public View h;
    public ImageView i;
    public ImageView j;
    public TextView k;
    public Button l;
    public Button m;
    public TextView n;
    public TextView o;
    public View p;
    public View q;
    public TextView r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Activity w;
    public ak x;
    public SettingConfigStore y;
    public UserInfo z;

    public a(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public void c() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.b(context, "context");
        this.J = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.MeCoverView3);
            this.G = obtainStyledAttributes.getBoolean(0, false);
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
        if (!isInEditMode()) {
            Object b2 = ((x) context).b();
            if (b2 != null) {
                ((com.shopee.app.ui.home.e) b2).a(this);
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.HomeComponent");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public MeCoverImageView getCover$app_indonesiaRelease() {
        MeCoverImageView meCoverImageView = this.f22479g;
        if (meCoverImageView == null) {
            j.b(PlaceFields.COVER);
        }
        return meCoverImageView;
    }

    public void setCover$app_indonesiaRelease(MeCoverImageView meCoverImageView) {
        j.b(meCoverImageView, "<set-?>");
        this.f22479g = meCoverImageView;
    }

    public View getOverLay$app_indonesiaRelease() {
        View view = this.h;
        if (view == null) {
            j.b("overLay");
        }
        return view;
    }

    public void setOverLay$app_indonesiaRelease(View view) {
        j.b(view, "<set-?>");
        this.h = view;
    }

    public ImageView getAvatar$app_indonesiaRelease() {
        ImageView imageView = this.i;
        if (imageView == null) {
            j.b("avatar");
        }
        return imageView;
    }

    public void setAvatar$app_indonesiaRelease(ImageView imageView) {
        j.b(imageView, "<set-?>");
        this.i = imageView;
    }

    public ImageView getShopType$app_indonesiaRelease() {
        ImageView imageView = this.j;
        if (imageView == null) {
            j.b("shopType");
        }
        return imageView;
    }

    public void setShopType$app_indonesiaRelease(ImageView imageView) {
        j.b(imageView, "<set-?>");
        this.j = imageView;
    }

    public TextView getShopName$app_indonesiaRelease() {
        TextView textView = this.k;
        if (textView == null) {
            j.b("shopName");
        }
        return textView;
    }

    public void setShopName$app_indonesiaRelease(TextView textView) {
        j.b(textView, "<set-?>");
        this.k = textView;
    }

    public Button getLoginButton$app_indonesiaRelease() {
        Button button = this.l;
        if (button == null) {
            j.b("loginButton");
        }
        return button;
    }

    public void setLoginButton$app_indonesiaRelease(Button button) {
        j.b(button, "<set-?>");
        this.l = button;
    }

    public Button getSignupButton$app_indonesiaRelease() {
        Button button = this.m;
        if (button == null) {
            j.b("signupButton");
        }
        return button;
    }

    public void setSignupButton$app_indonesiaRelease(Button button) {
        j.b(button, "<set-?>");
        this.m = button;
    }

    public TextView getFollowers$app_indonesiaRelease() {
        TextView textView = this.n;
        if (textView == null) {
            j.b("followers");
        }
        return textView;
    }

    public void setFollowers$app_indonesiaRelease(TextView textView) {
        j.b(textView, "<set-?>");
        this.n = textView;
    }

    public TextView getFollowing$app_indonesiaRelease() {
        TextView textView = this.o;
        if (textView == null) {
            j.b("following");
        }
        return textView;
    }

    public void setFollowing$app_indonesiaRelease(TextView textView) {
        j.b(textView, "<set-?>");
        this.o = textView;
    }

    public View getSeparator$app_indonesiaRelease() {
        View view = this.p;
        if (view == null) {
            j.b("separator");
        }
        return view;
    }

    public void setSeparator$app_indonesiaRelease(View view) {
        j.b(view, "<set-?>");
        this.p = view;
    }

    public View getSellerEntry$app_indonesiaRelease() {
        View view = this.q;
        if (view == null) {
            j.b("sellerEntry");
        }
        return view;
    }

    public void setSellerEntry$app_indonesiaRelease(View view) {
        j.b(view, "<set-?>");
        this.q = view;
    }

    public TextView getSellerEntryText$app_indonesiaRelease() {
        TextView textView = this.r;
        if (textView == null) {
            j.b("sellerEntryText");
        }
        return textView;
    }

    public void setSellerEntryText$app_indonesiaRelease(TextView textView) {
        j.b(textView, "<set-?>");
        this.r = textView;
    }

    public String getMFollowersLabel3$app_indonesiaRelease() {
        String str = this.s;
        if (str == null) {
            j.b("mFollowersLabel3");
        }
        return str;
    }

    public void setMFollowersLabel3$app_indonesiaRelease(String str) {
        j.b(str, "<set-?>");
        this.s = str;
    }

    public String getM1FollowerLabel3$app_indonesiaRelease() {
        String str = this.t;
        if (str == null) {
            j.b("m1FollowerLabel3");
        }
        return str;
    }

    public void setM1FollowerLabel3$app_indonesiaRelease(String str) {
        j.b(str, "<set-?>");
        this.t = str;
    }

    public String getMFollowingLabel3$app_indonesiaRelease() {
        String str = this.u;
        if (str == null) {
            j.b("mFollowingLabel3");
        }
        return str;
    }

    public void setMFollowingLabel3$app_indonesiaRelease(String str) {
        j.b(str, "<set-?>");
        this.u = str;
    }

    public String getM1FollowingLabel3$app_indonesiaRelease() {
        String str = this.v;
        if (str == null) {
            j.b("m1FollowingLabel3");
        }
        return str;
    }

    public void setM1FollowingLabel3$app_indonesiaRelease(String str) {
        j.b(str, "<set-?>");
        this.v = str;
    }

    public Activity getActivity$app_indonesiaRelease() {
        Activity activity = this.w;
        if (activity == null) {
            j.b("activity");
        }
        return activity;
    }

    public void setActivity$app_indonesiaRelease(Activity activity) {
        j.b(activity, "<set-?>");
        this.w = activity;
    }

    public ak getNavigator$app_indonesiaRelease() {
        ak akVar = this.x;
        if (akVar == null) {
            j.b("navigator");
        }
        return akVar;
    }

    public void setNavigator$app_indonesiaRelease(ak akVar) {
        j.b(akVar, "<set-?>");
        this.x = akVar;
    }

    public SettingConfigStore getConfigStore$app_indonesiaRelease() {
        SettingConfigStore settingConfigStore = this.y;
        if (settingConfigStore == null) {
            j.b("configStore");
        }
        return settingConfigStore;
    }

    public void setConfigStore$app_indonesiaRelease(SettingConfigStore settingConfigStore) {
        j.b(settingConfigStore, "<set-?>");
        this.y = settingConfigStore;
    }

    public UserInfo getUserInfo$app_indonesiaRelease() {
        UserInfo userInfo = this.z;
        if (userInfo == null) {
            j.b("userInfo");
        }
        return userInfo;
    }

    public void setUserInfo$app_indonesiaRelease(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.z = userInfo;
    }

    public com.shopee.app.tracking.a getActionTracker$app_indonesiaRelease() {
        com.shopee.app.tracking.a aVar = this.A;
        if (aVar == null) {
            j.b("actionTracker");
        }
        return aVar;
    }

    public void setActionTracker$app_indonesiaRelease(com.shopee.app.tracking.a aVar) {
        j.b(aVar, "<set-?>");
        this.A = aVar;
    }

    public MeCounter getMeCounter$app_indonesiaRelease() {
        MeCounter meCounter = this.B;
        if (meCounter == null) {
            j.b("meCounter");
        }
        return meCounter;
    }

    public void setMeCounter$app_indonesiaRelease(MeCounter meCounter) {
        j.b(meCounter, "<set-?>");
        this.B = meCounter;
    }

    public ChatBadgeStore getChatBadgeStore$app_indonesiaRelease() {
        ChatBadgeStore chatBadgeStore = this.C;
        if (chatBadgeStore == null) {
            j.b("chatBadgeStore");
        }
        return chatBadgeStore;
    }

    public void setChatBadgeStore$app_indonesiaRelease(ChatBadgeStore chatBadgeStore) {
        j.b(chatBadgeStore, "<set-?>");
        this.C = chatBadgeStore;
    }

    public ThemeStore getThemeStore$app_indonesiaRelease() {
        ThemeStore themeStore = this.D;
        if (themeStore == null) {
            j.b("themeStore");
        }
        return themeStore;
    }

    public void setThemeStore$app_indonesiaRelease(ThemeStore themeStore) {
        j.b(themeStore, "<set-?>");
        this.D = themeStore;
    }

    public com.shopee.app.ui.actionbar.a getMActionBar() {
        return this.E;
    }

    public void setMActionBar(com.shopee.app.ui.actionbar.a aVar) {
        this.E = aVar;
    }

    public com.shopee.app.ui.home.me.tracking.d getTrackSession() {
        return this.H;
    }

    public void setTrackSession(com.shopee.app.ui.home.me.tracking.d dVar) {
        this.H = dVar;
    }

    public com.shopee.app.ui.home.me.tracking.a getCoverTrackSession() {
        return this.I;
    }

    public void setCoverTrackSession(com.shopee.app.ui.home.me.tracking.a aVar) {
        this.I = aVar;
    }

    public void b() {
        if (!isInEditMode()) {
            this.J = getThemeStore$app_indonesiaRelease().getActionBarTheme().getLongBg();
            i();
        }
    }

    public void b(View view) {
        j.b(view, "view");
        com.shopee.app.ui.home.me.tracking.d trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a(view);
        }
        getNavigator$app_indonesiaRelease().f();
    }

    public void c(View view) {
        j.b(view, "view");
        com.shopee.app.ui.home.me.tracking.d trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a(view);
        }
        getNavigator$app_indonesiaRelease().b();
        getActionTracker$app_indonesiaRelease().c();
    }

    public void d() {
        com.shopee.app.e.b.b(getLoginButton$app_indonesiaRelease());
        com.shopee.app.e.b.b(getSignupButton$app_indonesiaRelease());
        getShopName$app_indonesiaRelease().setText((CharSequence) null);
        setShopInfoVisibility(false);
        TextView followers$app_indonesiaRelease = getFollowers$app_indonesiaRelease();
        r rVar = r.f32672a;
        Object[] objArr = {0};
        String format = String.format(getMFollowersLabel3$app_indonesiaRelease(), Arrays.copyOf(objArr, objArr.length));
        j.a((Object) format, "java.lang.String.format(format, *args)");
        followers$app_indonesiaRelease.setText(format);
        TextView following$app_indonesiaRelease = getFollowing$app_indonesiaRelease();
        r rVar2 = r.f32672a;
        Object[] objArr2 = {0};
        String format2 = String.format(getMFollowingLabel3$app_indonesiaRelease(), Arrays.copyOf(objArr2, objArr2.length));
        j.a((Object) format2, "java.lang.String.format(format, *args)");
        following$app_indonesiaRelease.setText(format2);
        getCover$app_indonesiaRelease().a(this.J, false, true);
        com.shopee.app.e.b.a(getShopType$app_indonesiaRelease());
    }

    public void setShopDetail(ShopDetail shopDetail) {
        CharSequence charSequence;
        int i2;
        j.b(shopDetail, "shop");
        com.shopee.app.e.b.a(getLoginButton$app_indonesiaRelease());
        com.shopee.app.e.b.a(getSignupButton$app_indonesiaRelease());
        this.F = shopDetail;
        getAvatar$app_indonesiaRelease().setOnClickListener(new f(this));
        getCover$app_indonesiaRelease().setOnClickListener(new g(this));
        getShopName$app_indonesiaRelease().setText(shopDetail.getShopName());
        if (shopDetail.getFollowersCount() == 1) {
            getFollowers$app_indonesiaRelease().setText(getM1FollowerLabel3$app_indonesiaRelease());
        } else {
            TextView followers$app_indonesiaRelease = getFollowers$app_indonesiaRelease();
            r rVar = r.f32672a;
            String mFollowersLabel3$app_indonesiaRelease = getMFollowersLabel3$app_indonesiaRelease();
            Object[] objArr = {shopDetail.getFollowerString()};
            String format = String.format(mFollowersLabel3$app_indonesiaRelease, Arrays.copyOf(objArr, objArr.length));
            j.a((Object) format, "java.lang.String.format(format, *args)");
            followers$app_indonesiaRelease.setText(format);
        }
        if (shopDetail.getFollowingCount() == 1) {
            TextView following$app_indonesiaRelease = getFollowing$app_indonesiaRelease();
            r rVar2 = r.f32672a;
            String m1FollowingLabel3$app_indonesiaRelease = getM1FollowingLabel3$app_indonesiaRelease();
            Object[] objArr2 = {shopDetail.getFollowingString()};
            String format2 = String.format(m1FollowingLabel3$app_indonesiaRelease, Arrays.copyOf(objArr2, objArr2.length));
            j.a((Object) format2, "java.lang.String.format(format, *args)");
            following$app_indonesiaRelease.setText(format2);
        } else {
            TextView following$app_indonesiaRelease2 = getFollowing$app_indonesiaRelease();
            r rVar3 = r.f32672a;
            String mFollowingLabel3$app_indonesiaRelease = getMFollowingLabel3$app_indonesiaRelease();
            Object[] objArr3 = {shopDetail.getFollowingString()};
            String format3 = String.format(mFollowingLabel3$app_indonesiaRelease, Arrays.copyOf(objArr3, objArr3.length));
            j.a((Object) format3, "java.lang.String.format(format, *args)");
            following$app_indonesiaRelease2.setText(format3);
        }
        z.a(getContext()).a((int) R.drawable.ic_me_avatar).a(false).a(shopDetail.getPortrait()).a(getAvatar$app_indonesiaRelease());
        if (shopDetail.isMall()) {
            getShopType$app_indonesiaRelease().setImageResource(R.drawable.ic_shop_shopee_mall);
        } else if (shopDetail.isShopeeVerified()) {
            getShopType$app_indonesiaRelease().setImageResource(R.drawable.ic_shop_verified);
        } else {
            com.shopee.app.e.b.a(getShopType$app_indonesiaRelease());
        }
        TextView sellerEntryText$app_indonesiaRelease = getSellerEntryText$app_indonesiaRelease();
        if (shopDetail.isSeller()) {
            charSequence = com.garena.android.appkit.tools.b.e(R.string.sp_label_my_shop);
        } else {
            charSequence = com.garena.android.appkit.tools.b.e(R.string.sp_label_selling_entry);
        }
        sellerEntryText$app_indonesiaRelease.setText(charSequence);
        if (this.G) {
            org.c.a.b.a(getShopName$app_indonesiaRelease(), com.garena.android.appkit.tools.b.a(R.color.black));
            org.c.a.b.a(getFollowing$app_indonesiaRelease(), com.garena.android.appkit.tools.b.a(R.color.black54));
            org.c.a.b.a(getFollowers$app_indonesiaRelease(), com.garena.android.appkit.tools.b.a(R.color.black54));
        } else {
            CharSequence cover = shopDetail.getCover();
            if (cover == null || d.h.m.a(cover)) {
                getCover$app_indonesiaRelease().a(this.J, false, true);
            } else {
                MeCoverImageView.a(getCover$app_indonesiaRelease(), shopDetail.getCover(), false, false, 6, (Object) null);
            }
        }
        View separator$app_indonesiaRelease = getSeparator$app_indonesiaRelease();
        if (this.G) {
            i2 = com.garena.android.appkit.tools.b.a(R.color.black09);
        } else {
            i2 = com.garena.android.appkit.tools.b.a(R.color.white54);
        }
        org.c.a.b.a(separator$app_indonesiaRelease, i2);
        setShopInfoVisibility(true);
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22495a;

        f(a aVar) {
            this.f22495a = aVar;
        }

        public final void onClick(View view) {
            if (!this.f22495a.G) {
                this.f22495a.getNavigator$app_indonesiaRelease().t();
                com.shopee.app.ui.home.me.tracking.a coverTrackSession = this.f22495a.getCoverTrackSession();
                if (coverTrackSession != null) {
                    j.a((Object) view, "it");
                    coverTrackSession.a(view);
                }
                this.f22495a.b("Portrait");
            }
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22496a;

        g(a aVar) {
            this.f22496a = aVar;
        }

        public final void onClick(View view) {
            com.shopee.app.ui.home.me.tracking.d trackSession = this.f22496a.getTrackSession();
            if (trackSession != null) {
                j.a((Object) view, "it");
                trackSession.a(view);
            }
            if (!this.f22496a.G) {
                this.f22496a.getNavigator$app_indonesiaRelease().t();
                this.f22496a.b("Background");
            }
        }
    }

    public void setShopInfoVisibility(boolean z2) {
        if (z2) {
            com.shopee.app.e.b.b(getFollowers$app_indonesiaRelease());
            com.shopee.app.e.b.b(getFollowing$app_indonesiaRelease());
            com.shopee.app.e.b.b(getSeparator$app_indonesiaRelease());
            return;
        }
        com.shopee.app.e.b.a(getFollowers$app_indonesiaRelease());
        com.shopee.app.e.b.a(getFollowing$app_indonesiaRelease());
        com.shopee.app.e.b.a(getSeparator$app_indonesiaRelease());
    }

    public void d(View view) {
        j.b(view, "view");
        com.shopee.app.ui.home.me.tracking.a coverTrackSession = getCoverTrackSession();
        if (coverTrackSession != null) {
            coverTrackSession.a(view);
        }
        ShopDetail shopDetail = this.F;
        if (shopDetail != null) {
            getNavigator$app_indonesiaRelease().i(shopDetail.getShopId());
            b("Followers");
        }
    }

    public void e(View view) {
        j.b(view, "view");
        com.shopee.app.ui.home.me.tracking.a coverTrackSession = getCoverTrackSession();
        if (coverTrackSession != null) {
            coverTrackSession.a(view);
        }
        ShopDetail shopDetail = this.F;
        if (shopDetail != null) {
            getNavigator$app_indonesiaRelease().j(shopDetail.getShopId());
            b("Following");
        }
    }

    public void e() {
        com.shopee.app.ui.home.me.tracking.a coverTrackSession = getCoverTrackSession();
        if (coverTrackSession != null) {
            coverTrackSession.a((int) R.id.settings_icon);
        }
        getNavigator$app_indonesiaRelease().a(getConfigStore$app_indonesiaRelease().showUpgrade());
        if (!getConfigStore$app_indonesiaRelease().getUpgradeDotDismissed()) {
            getConfigStore$app_indonesiaRelease().setUpgradeDotDismissed(true);
            getConfigStore$app_indonesiaRelease().setPreviousDismissedTime();
        }
        b("Setting");
    }

    public void f(View view) {
        j.b(view, "view");
        com.shopee.app.ui.home.me.tracking.d trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a(this.F);
        }
        getNavigator$app_indonesiaRelease().W();
    }

    public void f() {
        com.shopee.app.ui.home.me.tracking.a coverTrackSession = getCoverTrackSession();
        if (coverTrackSession != null) {
            coverTrackSession.a((int) R.id.chat_btn);
        }
        if (getUserInfo$app_indonesiaRelease().isLoggedIn()) {
            getNavigator$app_indonesiaRelease().e();
        } else {
            getNavigator$app_indonesiaRelease().f();
        }
    }

    public void g() {
        com.shopee.app.ui.home.me.tracking.d trackSession = getTrackSession();
        if (trackSession != null) {
            trackSession.a((int) R.id.cart_btn);
        }
        if (getUserInfo$app_indonesiaRelease().isLoggedIn()) {
            getNavigator$app_indonesiaRelease().u();
        } else {
            getNavigator$app_indonesiaRelease().f();
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        getActionTracker$app_indonesiaRelease().c("", "my_profile", str);
    }

    public void a(String str, int i2) {
        j.b(str, "badgeKey");
        com.shopee.app.ui.actionbar.a mActionBar = getMActionBar();
        if (mActionBar != null) {
            mActionBar.a(str, i2);
        }
    }

    private void i() {
        if (this.G) {
            com.shopee.app.e.b.a(getSellerEntry$app_indonesiaRelease());
            getCover$app_indonesiaRelease().a();
        } else {
            a.C0296a aVar = new a.C0296a();
            aVar.f(0).f().a("");
            if (getUserInfo$app_indonesiaRelease().isLoggedIn()) {
                aVar.a((a.b) new C0326a("ACTION_BAR_SETTING", R.drawable.ic_me_settings_white, "ACTION_BAR_SETTING", R.drawable.ic_me_settings_white, this));
                aVar.a((a.b) new b("ACTION_BAR_CART", R.drawable.ic_nav_cart_white, "ACTION_BAR_CART", R.drawable.ic_nav_cart_white, this));
                aVar.a((a.b) new c("ACTION_BAR_ACTION_BOX", R.drawable.ic_chat_android_white, "ACTION_BAR_ACTION_BOX", R.drawable.ic_chat_android_white, this));
                com.shopee.app.e.b.b(getSellerEntry$app_indonesiaRelease());
            } else {
                aVar.a((a.b) new d("ACTION_BAR_CART", R.drawable.ic_nav_cart_white, "ACTION_BAR_CART", R.drawable.ic_nav_cart_white, this));
                aVar.a((a.b) new e("ACTION_BAR_ACTION_BOX", R.drawable.ic_chat_android_white, "ACTION_BAR_ACTION_BOX", R.drawable.ic_chat_android_white, this));
                com.shopee.app.e.b.a(getSellerEntry$app_indonesiaRelease());
            }
            com.shopee.app.ui.actionbar.a a2 = aVar.a(getContext());
            a2.setId(R.id.me_tab_action_bar);
            setMActionBar(a2);
            addView(getMActionBar());
            j();
            a("ACTION_BAR_CART", getMeCounter$app_indonesiaRelease().getCartCount());
            a("ACTION_BAR_ACTION_BOX", getChatBadgeStore$app_indonesiaRelease().getTotalCount());
            getSellerEntry$app_indonesiaRelease().bringToFront();
        }
        h();
    }

    private void j() {
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        ConstraintLayout constraintLayout = this;
        cVar.a(constraintLayout);
        com.shopee.app.ui.actionbar.a mActionBar = getMActionBar();
        if (mActionBar == null) {
            j.a();
        }
        cVar.a(mActionBar.getId(), 3, 0, 3);
        cVar.b(constraintLayout);
    }

    /* renamed from: com.shopee.app.ui.home.me.v3.a$a  reason: collision with other inner class name */
    public static final class C0326a extends a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22480a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22481b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f22482c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0326a(String str, int i, String str2, int i2, a aVar) {
            super(str2, i2);
            this.f22480a = str;
            this.f22481b = i;
            this.f22482c = aVar;
        }

        public void a() {
            this.f22482c.e();
        }
    }

    public static final class b extends a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22483a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22484b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f22485c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, int i, String str2, int i2, a aVar) {
            super(str2, i2);
            this.f22483a = str;
            this.f22484b = i;
            this.f22485c = aVar;
        }

        public void a() {
            this.f22485c.g();
        }
    }

    public static final class c extends a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22487b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f22488c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, int i, String str2, int i2, a aVar) {
            super(str2, i2);
            this.f22486a = str;
            this.f22487b = i;
            this.f22488c = aVar;
        }

        public void a() {
            this.f22488c.f();
        }
    }

    public static final class d extends a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22489a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22490b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f22491c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, int i, String str2, int i2, a aVar) {
            super(str2, i2);
            this.f22489a = str;
            this.f22490b = i;
            this.f22491c = aVar;
        }

        public void a() {
            this.f22491c.g();
        }
    }

    public static final class e extends a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22492a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f22493b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f22494c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, int i, String str2, int i2, a aVar) {
            super(str2, i2);
            this.f22492a = str;
            this.f22493b = i;
            this.f22494c = aVar;
        }

        public void a() {
            this.f22494c.f();
        }
    }

    public void h() {
        if (!this.G) {
            com.shopee.app.util.o.d.a().a(getContext(), this);
        }
    }

    public void setDefaultCover(String str) {
        j.b(str, "newCover");
        if (!isInEditMode() && !this.G) {
            ShopDetail shopDetail = this.F;
            CharSequence cover = shopDetail != null ? shopDetail.getCover() : null;
            if (cover == null || d.h.m.a(cover)) {
                this.J = str;
                getCover$app_indonesiaRelease().a(this.J, false, true);
            }
        }
    }
}
