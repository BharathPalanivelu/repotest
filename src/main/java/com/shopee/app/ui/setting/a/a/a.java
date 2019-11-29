package com.shopee.app.ui.setting.a.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.f;
import com.devspark.robototextview.widget.RobotoTextView;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.app.a;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.al;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.data.viewmodel.RedDotData;
import com.shopee.app.ui.setting.cell.SettingTwoLineItemView_;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.web.protocol.SalesforceChatData;
import com.shopee.id.R;
import com.shopee.protocol.action.Notification;
import java.util.HashMap;

public final class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public FollowCounter f25038a;

    /* renamed from: b  reason: collision with root package name */
    public com.shopee.app.util.n f25039b;

    /* renamed from: c  reason: collision with root package name */
    public com.shopee.app.network.http.a.j f25040c;

    /* renamed from: d  reason: collision with root package name */
    public com.shopee.app.util.s f25041d;

    /* renamed from: e  reason: collision with root package name */
    public UserInfo f25042e;

    /* renamed from: f  reason: collision with root package name */
    private com.shopee.app.ui.setting.a.e f25043f;

    /* renamed from: g  reason: collision with root package name */
    private bc f25044g;
    private ak h;
    private al i;
    private SettingConfigStore j;
    private HashMap k;

    /* renamed from: com.shopee.app.ui.setting.a.a.a$a  reason: collision with other inner class name */
    public interface C0387a {
        void a(int i);
    }

    public a(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(com.shopee.app.ui.setting.a.d dVar) {
        d.d.b.j.b(dVar, "data");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d.d.b.j.b(context, "context");
        View.inflate(context, R.layout.forbidden_view_layout, this);
        Object b2 = ((com.shopee.app.util.x) context).b();
        if (b2 != null) {
            ((com.shopee.app.ui.setting.m) b2).a(this);
            c();
            return;
        }
        throw new d.m("null cannot be cast to non-null type com.shopee.app.ui.setting.SettingComponent");
    }

    public final com.shopee.app.ui.setting.a.e getPresenter() {
        return this.f25043f;
    }

    public final void setPresenter(com.shopee.app.ui.setting.a.e eVar) {
        this.f25043f = eVar;
    }

    public final bc getScope() {
        return this.f25044g;
    }

    public final void setScope(bc bcVar) {
        this.f25044g = bcVar;
    }

    public final ak getNavigator() {
        return this.h;
    }

    public final void setNavigator(ak akVar) {
        this.h = akVar;
    }

    public final al getMLoginStore() {
        return this.i;
    }

    public final void setMLoginStore(al alVar) {
        this.i = alVar;
    }

    public final SettingConfigStore getMSettingConfigStore() {
        return this.j;
    }

    public final void setMSettingConfigStore(SettingConfigStore settingConfigStore) {
        this.j = settingConfigStore;
    }

    public final FollowCounter getFollowCounter() {
        FollowCounter followCounter = this.f25038a;
        if (followCounter == null) {
            d.d.b.j.b("followCounter");
        }
        return followCounter;
    }

    public final void setFollowCounter(FollowCounter followCounter) {
        d.d.b.j.b(followCounter, "<set-?>");
        this.f25038a = followCounter;
    }

    public final com.shopee.app.util.n getEventBus() {
        com.shopee.app.util.n nVar = this.f25039b;
        if (nVar == null) {
            d.d.b.j.b("eventBus");
        }
        return nVar;
    }

    public final void setEventBus(com.shopee.app.util.n nVar) {
        d.d.b.j.b(nVar, "<set-?>");
        this.f25039b = nVar;
    }

    public final com.shopee.app.network.http.a.j getTabRedDotApi() {
        com.shopee.app.network.http.a.j jVar = this.f25040c;
        if (jVar == null) {
            d.d.b.j.b("tabRedDotApi");
        }
        return jVar;
    }

    public final void setTabRedDotApi(com.shopee.app.network.http.a.j jVar) {
        d.d.b.j.b(jVar, "<set-?>");
        this.f25040c = jVar;
    }

    public final com.shopee.app.util.s getFeatureToggleManager() {
        com.shopee.app.util.s sVar = this.f25041d;
        if (sVar == null) {
            d.d.b.j.b("featureToggleManager");
        }
        return sVar;
    }

    public final void setFeatureToggleManager(com.shopee.app.util.s sVar) {
        d.d.b.j.b(sVar, "<set-?>");
        this.f25041d = sVar;
    }

    public final UserInfo getUserInfo() {
        UserInfo userInfo = this.f25042e;
        if (userInfo == null) {
            d.d.b.j.b("userInfo");
        }
        return userInfo;
    }

    public final void setUserInfo(UserInfo userInfo) {
        d.d.b.j.b(userInfo, "<set-?>");
        this.f25042e = userInfo;
    }

    private final void c() {
        com.shopee.app.ui.setting.a.e eVar = this.f25043f;
        if (eVar != null) {
            eVar.a(this);
        }
        bc bcVar = this.f25044g;
        if (bcVar != null) {
            bcVar.a(this.f25043f);
        }
        d();
        com.shopee.app.ui.setting.a.e eVar2 = this.f25043f;
        if (eVar2 != null) {
            eVar2.e();
        }
        SettingTwoLineItemView_ settingTwoLineItemView_ = (SettingTwoLineItemView_) a(a.C0250a.help_mode);
        d.d.b.j.a((Object) settingTwoLineItemView_, "help_mode");
        al alVar = this.i;
        boolean z2 = false;
        settingTwoLineItemView_.setChecked(alVar != null ? alVar.o() : false);
        ((SettingTwoLineItemView_) a(a.C0250a.help_mode)).setOnClickListener(new ah(this));
        SettingTwoLineItemView_ settingTwoLineItemView_2 = (SettingTwoLineItemView_) a(a.C0250a.forbiddenZoneBtn);
        d.d.b.j.a((Object) settingTwoLineItemView_2, "forbiddenZoneBtn");
        SettingConfigStore settingConfigStore = this.j;
        if (settingConfigStore != null) {
            z2 = settingConfigStore.isForbiddenZoneBtnEnabled();
        }
        settingTwoLineItemView_2.setChecked(z2);
        ((SettingTwoLineItemView_) a(a.C0250a.forbiddenZoneBtn)).setOnClickListener(new ai(this));
    }

    static final class ah implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25055a;

        ah(a aVar) {
            this.f25055a = aVar;
        }

        public final void onClick(View view) {
            al mLoginStore = this.f25055a.getMLoginStore();
            if (mLoginStore != null) {
                SettingTwoLineItemView_ settingTwoLineItemView_ = (SettingTwoLineItemView_) this.f25055a.a(a.C0250a.help_mode);
                d.d.b.j.a((Object) settingTwoLineItemView_, "help_mode");
                mLoginStore.a(settingTwoLineItemView_.c());
            }
        }
    }

    static final class ai implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25056a;

        ai(a aVar) {
            this.f25056a = aVar;
        }

        public final void onClick(View view) {
            SettingConfigStore mSettingConfigStore = this.f25056a.getMSettingConfigStore();
            if (mSettingConfigStore != null) {
                SettingTwoLineItemView_ settingTwoLineItemView_ = (SettingTwoLineItemView_) this.f25056a.a(a.C0250a.forbiddenZoneBtn);
                d.d.b.j.a((Object) settingTwoLineItemView_, "forbiddenZoneBtn");
                mSettingConfigStore.setForbiddenZoneBtnEnabled(settingTwoLineItemView_.c());
            }
            ar.a(false);
        }
    }

    private final void d() {
        com.shopee.app.ui.setting.a.e eVar = this.f25043f;
        if (eVar != null) {
            ((RobotoTextView) a(a.C0250a.btnDebugAlert)).setOnClickListener(new e(eVar));
            ((RobotoTextView) a(a.C0250a.btnNetworkLogs)).setOnClickListener(new o(eVar));
            ((RobotoTextView) a(a.C0250a.btnNetworkInterceptor)).setOnClickListener(new y(eVar));
            ((SettingTwoLineItemView_) a(a.C0250a.checkBoxFrescoConfig)).setOnClickListener(eVar.f25094e);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxMemoryDebug)).setOnClickListener(eVar.f25095f);
            ((RobotoTextView) a(a.C0250a.btnCCMS)).setOnClickListener(new z(eVar));
            ((RobotoTextView) a(a.C0250a.btnFetchFeatureToggle)).setOnClickListener(new aa(eVar));
            ((Button) a(a.C0250a.btnCheckFeatureToggle)).setOnClickListener(new ab(eVar));
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxGroupBuyEntrance)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxBundleDeals)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxHidePhoneCall)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxMallTabShown)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxMallTabRN)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxHomeTabRN)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxEnableSSL)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxProductShippingWeight)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxProductWeight)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxMySales)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxShowProductPkgSize)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxNonIntegratedMall)).setOnClickListener(eVar.f25096g);
            ((SettingTwoLineItemView_) a(a.C0250a.checkboxShowTrackingLogs)).setOnClickListener(eVar.f25092c);
            ((SettingTwoLineItemView_) a(a.C0250a.checkBoxForceMeCache)).setOnClickListener(eVar.f25093d);
            ((RobotoTextView) a(a.C0250a.btnSendAllTrackingEvents)).setOnClickListener(new ac(eVar));
            ((RobotoTextView) a(a.C0250a.btnTrackingInfo)).setOnClickListener(new ad(eVar));
            ((RobotoTextView) a(a.C0250a.btnCameraPhoto)).setOnClickListener(new ae(eVar));
            ((RobotoTextView) a(a.C0250a.btnCameraVideo)).setOnClickListener(new f(eVar));
            ((RobotoTextView) a(a.C0250a.btnCameraAllPhoto)).setOnClickListener(new g(eVar));
            ((RobotoTextView) a(a.C0250a.btnCameraAllVideo)).setOnClickListener(new h(eVar));
            ((RobotoTextView) a(a.C0250a.btnPickAddrRN)).setOnClickListener(new i(eVar));
            ((RobotoTextView) a(a.C0250a.btnRedirectAddProduct)).setOnClickListener(new j(eVar));
            ((RobotoTextView) a(a.C0250a.btnCrashApp)).setOnClickListener(new k(eVar));
            ((RobotoTextView) a(a.C0250a.btnClearToolTip)).setOnClickListener(new l(eVar));
            ((RobotoTextView) a(a.C0250a.btnCoinAnim)).setOnClickListener(new m(eVar));
            ((RobotoTextView) a(a.C0250a.sf_chat)).setOnClickListener(new b(this));
            ((RobotoTextView) a(a.C0250a.app_theme_btn)).setOnClickListener(new n(eVar));
            ((RobotoTextView) a(a.C0250a.bca_register)).setOnClickListener(new p(eVar));
            ((RobotoTextView) a(a.C0250a.kredit_camera)).setOnClickListener(new q(eVar));
            ((RobotoTextView) a(a.C0250a.kredit_camera_3)).setOnClickListener(new r(eVar));
            ((RobotoTextView) a(a.C0250a.check_permissions)).setOnClickListener(new s(eVar));
            ((RobotoTextView) a(a.C0250a.request_permissions)).setOnClickListener(new t(eVar));
            ((RobotoTextView) a(a.C0250a.facebook_check_status)).setOnClickListener(new u(eVar));
            ((RobotoTextView) a(a.C0250a.facebook_connect_account)).setOnClickListener(new v(eVar));
            ((RobotoTextView) a(a.C0250a.btnSetTongdunDomain)).setOnClickListener(new w(eVar));
            ((RobotoTextView) a(a.C0250a.btnSubmitNetworkReport)).setOnClickListener(new x(eVar));
            ((RobotoTextView) a(a.C0250a.btnCopyFirebaseInstanceId)).setOnClickListener(new c(eVar, this));
            ((RobotoTextView) a(a.C0250a.btnMockFeedRedDotServerResponse)).setOnClickListener(new d(this));
            SettingTwoLineItemView_ settingTwoLineItemView_ = (SettingTwoLineItemView_) a(a.C0250a.checkBoxFrescoConfig);
            d.d.b.j.a((Object) settingTwoLineItemView_, "checkBoxFrescoConfig");
            settingTwoLineItemView_.setChecked(eVar.k());
            SettingTwoLineItemView_ settingTwoLineItemView_2 = (SettingTwoLineItemView_) a(a.C0250a.checkboxMemoryDebug);
            d.d.b.j.a((Object) settingTwoLineItemView_2, "checkboxMemoryDebug");
            settingTwoLineItemView_2.setChecked(eVar.l());
            SettingTwoLineItemView_ settingTwoLineItemView_3 = (SettingTwoLineItemView_) a(a.C0250a.checkboxShowTrackingLogs);
            d.d.b.j.a((Object) settingTwoLineItemView_3, "checkboxShowTrackingLogs");
            settingTwoLineItemView_3.setChecked(eVar.j());
            SettingTwoLineItemView_ settingTwoLineItemView_4 = (SettingTwoLineItemView_) a(a.C0250a.checkBoxForceMeCache);
            d.d.b.j.a((Object) settingTwoLineItemView_4, "checkBoxForceMeCache");
            al alVar = this.i;
            settingTwoLineItemView_4.setChecked(d.d.b.j.a((Object) alVar != null ? alVar.E() : null, (Object) true));
            SettingConfigStore settingConfigStore = eVar.f25091a;
            d.d.b.j.a((Object) settingConfigStore, "mSettingStore");
            a(settingConfigStore);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25063a;

        e(com.shopee.app.ui.setting.a.e eVar) {
            this.f25063a = eVar;
        }

        public final void onClick(View view) {
            this.f25063a.i();
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25073a;

        o(com.shopee.app.ui.setting.a.e eVar) {
            this.f25073a = eVar;
        }

        public final void onClick(View view) {
            this.f25073a.n();
        }
    }

    static final class y implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25083a;

        y(com.shopee.app.ui.setting.a.e eVar) {
            this.f25083a = eVar;
        }

        public final void onClick(View view) {
            this.f25083a.o();
        }
    }

    static final class z implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25084a;

        z(com.shopee.app.ui.setting.a.e eVar) {
            this.f25084a = eVar;
        }

        public final void onClick(View view) {
            this.f25084a.f();
        }
    }

    static final class aa implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25045a;

        aa(com.shopee.app.ui.setting.a.e eVar) {
            this.f25045a = eVar;
        }

        public final void onClick(View view) {
            this.f25045a.g();
        }
    }

    static final class ab implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25046a;

        ab(com.shopee.app.ui.setting.a.e eVar) {
            this.f25046a = eVar;
        }

        public final void onClick(View view) {
            this.f25046a.h();
        }
    }

    static final class ac implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25047a;

        ac(com.shopee.app.ui.setting.a.e eVar) {
            this.f25047a = eVar;
        }

        public final void onClick(View view) {
            this.f25047a.t();
        }
    }

    static final class ad implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25048a;

        ad(com.shopee.app.ui.setting.a.e eVar) {
            this.f25048a = eVar;
        }

        public final void onClick(View view) {
            this.f25048a.y();
        }
    }

    static final class ae implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25049a;

        ae(com.shopee.app.ui.setting.a.e eVar) {
            this.f25049a = eVar;
        }

        public final void onClick(View view) {
            this.f25049a.u();
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25064a;

        f(com.shopee.app.ui.setting.a.e eVar) {
            this.f25064a = eVar;
        }

        public final void onClick(View view) {
            this.f25064a.v();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25065a;

        g(com.shopee.app.ui.setting.a.e eVar) {
            this.f25065a = eVar;
        }

        public final void onClick(View view) {
            this.f25065a.w();
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25066a;

        h(com.shopee.app.ui.setting.a.e eVar) {
            this.f25066a = eVar;
        }

        public final void onClick(View view) {
            this.f25066a.x();
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25067a;

        i(com.shopee.app.ui.setting.a.e eVar) {
            this.f25067a = eVar;
        }

        public final void onClick(View view) {
            this.f25067a.s();
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25068a;

        j(com.shopee.app.ui.setting.a.e eVar) {
            this.f25068a = eVar;
        }

        public final void onClick(View view) {
            this.f25068a.m();
        }
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25069a;

        k(com.shopee.app.ui.setting.a.e eVar) {
            this.f25069a = eVar;
        }

        public final void onClick(View view) {
            this.f25069a.p();
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25070a;

        l(com.shopee.app.ui.setting.a.e eVar) {
            this.f25070a = eVar;
        }

        public final void onClick(View view) {
            this.f25070a.q();
        }
    }

    static final class m implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25071a;

        m(com.shopee.app.ui.setting.a.e eVar) {
            this.f25071a = eVar;
        }

        public final void onClick(View view) {
            this.f25071a.r();
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25059a;

        b(a aVar) {
            this.f25059a = aVar;
        }

        public final void onClick(View view) {
            this.f25059a.a();
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25072a;

        n(com.shopee.app.ui.setting.a.e eVar) {
            this.f25072a = eVar;
        }

        public final void onClick(View view) {
            this.f25072a.z();
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25074a;

        p(com.shopee.app.ui.setting.a.e eVar) {
            this.f25074a = eVar;
        }

        public final void onClick(View view) {
            this.f25074a.A();
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25075a;

        q(com.shopee.app.ui.setting.a.e eVar) {
            this.f25075a = eVar;
        }

        public final void onClick(View view) {
            this.f25075a.B();
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25076a;

        r(com.shopee.app.ui.setting.a.e eVar) {
            this.f25076a = eVar;
        }

        public final void onClick(View view) {
            this.f25076a.C();
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25077a;

        s(com.shopee.app.ui.setting.a.e eVar) {
            this.f25077a = eVar;
        }

        public final void onClick(View view) {
            this.f25077a.D();
        }
    }

    static final class t implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25078a;

        t(com.shopee.app.ui.setting.a.e eVar) {
            this.f25078a = eVar;
        }

        public final void onClick(View view) {
            this.f25078a.E();
        }
    }

    static final class u implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25079a;

        u(com.shopee.app.ui.setting.a.e eVar) {
            this.f25079a = eVar;
        }

        public final void onClick(View view) {
            this.f25079a.F();
        }
    }

    static final class v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25080a;

        v(com.shopee.app.ui.setting.a.e eVar) {
            this.f25080a = eVar;
        }

        public final void onClick(View view) {
            this.f25080a.G();
        }
    }

    static final class w implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25081a;

        w(com.shopee.app.ui.setting.a.e eVar) {
            this.f25081a = eVar;
        }

        public final void onClick(View view) {
            this.f25081a.H();
        }
    }

    static final class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25082a;

        x(com.shopee.app.ui.setting.a.e eVar) {
            this.f25082a = eVar;
        }

        public final void onClick(View view) {
            this.f25082a.I();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.shopee.app.ui.setting.a.e f25060a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f25061b;

        c(com.shopee.app.ui.setting.a.e eVar, a aVar) {
            this.f25060a = eVar;
            this.f25061b = aVar;
        }

        public final void onClick(View view) {
            com.shopee.app.ui.setting.a.e eVar = this.f25060a;
            Context context = this.f25061b.getContext();
            if (context != null) {
                eVar.a((Activity) context);
                return;
            }
            throw new d.m("null cannot be cast to non-null type android.app.Activity");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25062a;

        d(a aVar) {
            this.f25062a = aVar;
        }

        public final void onClick(View view) {
            this.f25062a.b();
        }
    }

    private final void a(SettingConfigStore settingConfigStore) {
        SettingTwoLineItemView_ settingTwoLineItemView_ = (SettingTwoLineItemView_) a(a.C0250a.checkboxGroupBuyEntrance);
        d.d.b.j.a((Object) settingTwoLineItemView_, "checkboxGroupBuyEntrance");
        settingTwoLineItemView_.setChecked(settingConfigStore.showMePageGroupBuy());
        SettingTwoLineItemView_ settingTwoLineItemView_2 = (SettingTwoLineItemView_) a(a.C0250a.checkboxBundleDeals);
        d.d.b.j.a((Object) settingTwoLineItemView_2, "checkboxBundleDeals");
        settingTwoLineItemView_2.setChecked(settingConfigStore.isBundleEnabled());
        SettingTwoLineItemView_ settingTwoLineItemView_3 = (SettingTwoLineItemView_) a(a.C0250a.checkboxHidePhoneCall);
        d.d.b.j.a((Object) settingTwoLineItemView_3, "checkboxHidePhoneCall");
        settingTwoLineItemView_3.setChecked(settingConfigStore.hidePhonePublicOption());
        SettingTwoLineItemView_ settingTwoLineItemView_4 = (SettingTwoLineItemView_) a(a.C0250a.checkboxMallTabShown);
        d.d.b.j.a((Object) settingTwoLineItemView_4, "checkboxMallTabShown");
        settingTwoLineItemView_4.setChecked(settingConfigStore.isShowMallTab());
        SettingTwoLineItemView_ settingTwoLineItemView_5 = (SettingTwoLineItemView_) a(a.C0250a.checkboxMallTabRN);
        d.d.b.j.a((Object) settingTwoLineItemView_5, "checkboxMallTabRN");
        settingTwoLineItemView_5.setChecked(settingConfigStore.isMallTabRN(0));
        SettingTwoLineItemView_ settingTwoLineItemView_6 = (SettingTwoLineItemView_) a(a.C0250a.checkboxHomeTabRN);
        d.d.b.j.a((Object) settingTwoLineItemView_6, "checkboxHomeTabRN");
        settingTwoLineItemView_6.setChecked(settingConfigStore.isHomeTabRN(0));
        SettingTwoLineItemView_ settingTwoLineItemView_7 = (SettingTwoLineItemView_) a(a.C0250a.checkboxEnableSSL);
        d.d.b.j.a((Object) settingTwoLineItemView_7, "checkboxEnableSSL");
        settingTwoLineItemView_7.setChecked(settingConfigStore.sslEnabled());
        SettingTwoLineItemView_ settingTwoLineItemView_8 = (SettingTwoLineItemView_) a(a.C0250a.checkboxProductShippingWeight);
        d.d.b.j.a((Object) settingTwoLineItemView_8, "checkboxProductShippingWeight");
        settingTwoLineItemView_8.setChecked(settingConfigStore.showProductWeight());
        SettingTwoLineItemView_ settingTwoLineItemView_9 = (SettingTwoLineItemView_) a(a.C0250a.checkboxProductWeight);
        d.d.b.j.a((Object) settingTwoLineItemView_9, "checkboxProductWeight");
        settingTwoLineItemView_9.setChecked(settingConfigStore.isProductWeightOptional());
        SettingTwoLineItemView_ settingTwoLineItemView_10 = (SettingTwoLineItemView_) a(a.C0250a.checkboxMySales);
        d.d.b.j.a((Object) settingTwoLineItemView_10, "checkboxMySales");
        settingTwoLineItemView_10.setChecked(settingConfigStore.getMySaleNewStringsEnabled());
        SettingTwoLineItemView_ settingTwoLineItemView_11 = (SettingTwoLineItemView_) a(a.C0250a.checkboxShowProductPkgSize);
        d.d.b.j.a((Object) settingTwoLineItemView_11, "checkboxShowProductPkgSize");
        settingTwoLineItemView_11.setChecked(settingConfigStore.isProductDimension());
        SettingTwoLineItemView_ settingTwoLineItemView_12 = (SettingTwoLineItemView_) a(a.C0250a.checkboxNonIntegratedMall);
        d.d.b.j.a((Object) settingTwoLineItemView_12, "checkboxNonIntegratedMall");
        settingTwoLineItemView_12.setChecked(settingConfigStore.nonIntegratedMallReturnEnabled());
    }

    public final void a(int i2, C0387a aVar, String... strArr) {
        d.d.b.j.b(aVar, "callback");
        d.d.b.j.b(strArr, "options");
        new f.a(getContext()).a((CharSequence[]) strArr).a(i2, (f.C0065f) new aj(i2, aVar)).c((CharSequence) "Choose").e((CharSequence) "Cancel").c();
    }

    static final class aj implements f.C0065f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f25057a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C0387a f25058b;

        aj(int i, C0387a aVar) {
            this.f25057a = i;
            this.f25058b = aVar;
        }

        public final boolean a(com.afollestad.materialdialogs.f fVar, View view, int i, CharSequence charSequence) {
            if (this.f25057a == i) {
                return true;
            }
            this.f25058b.a(i);
            return true;
        }
    }

    public final void a(String str) {
        d.d.b.j.b(str, "trackingInfo");
        new f.a(getContext()).a((CharSequence) "Tracking Info").b((CharSequence) str).c((CharSequence) "OK").c();
    }

    public final void a(String str, boolean z2) {
        d.d.b.j.b(str, "featureName");
        f.a aVar = new f.a(getContext());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" is ");
        sb.append(z2 ? "ON" : "OFF");
        aVar.b((CharSequence) sb.toString()).c();
    }

    public final void a(String str, int i2) {
        d.d.b.j.b(str, "imageUri");
        if (!TextUtils.isEmpty(str)) {
            com.squareup.a.w.a(getContext()).a(Uri.parse(str)).a((float) i2).a((ImageView) a(a.C0250a.kreditCroppedImage));
        }
    }

    public final String getFeaureToggleName() {
        MaterialEditText materialEditText = (MaterialEditText) a(a.C0250a.featureToggleName);
        d.d.b.j.a((Object) materialEditText, "featureToggleName");
        return String.valueOf(materialEditText.getText());
    }

    public final void a() {
        SalesforceChatData salesforceChatData = new SalesforceChatData("https://shopeetest-shopee-help.cs6.force.com/s/contactus?language=in", (String) null, (String) null, (String) null, 12, (g) null);
        ak akVar = this.h;
        if (akVar != null) {
            akVar.a(salesforceChatData);
        }
    }

    public final void b(String str) {
        d.d.b.j.b(str, "text");
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("copiedFirebaseInstanceIdToken", str));
            com.shopee.app.h.r a2 = com.shopee.app.h.r.a();
            a2.a("Copied to clipboard: " + str);
        }
    }

    public final void b() {
        Context context = getContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_forbidden_zone_set_feed_red_dot_dialog, (ViewGroup) null);
        FollowCounter followCounter = this.f25038a;
        if (followCounter == null) {
            d.d.b.j.b("followCounter");
        }
        RedDotData redDotData = followCounter.getRedDotData();
        TextView textView = (TextView) inflate.findViewById(R.id.last_dismiss_red_dot);
        int lastDismissDotCreationTime = redDotData.getLastDismissDotCreationTime();
        String a2 = com.garena.android.appkit.tools.a.a.a(lastDismissDotCreationTime, "ID");
        d.d.b.j.a((Object) textView, "lastDismissRedDotText");
        textView.setText("Last dismissed red dot creation time: " + lastDismissDotCreationTime + SQLBuilder.PARENTHESES_LEFT + a2 + SQLBuilder.PARENTHESES_RIGHT);
        int currentCreationTime = redDotData.getCurrentCreationTime();
        String a3 = com.garena.android.appkit.tools.a.a.a(currentCreationTime, "ID");
        TextView textView2 = (TextView) inflate.findViewById(R.id.showing_red_dot);
        d.d.b.j.a((Object) textView2, "showingRedDotText");
        textView2.setText("Showing red dot creation time: " + currentCreationTime + SQLBuilder.PARENTHESES_LEFT + a3 + SQLBuilder.PARENTHESES_RIGHT);
        EditText editText = (EditText) inflate.findViewById(R.id.mock_creation_time);
        builder.setView(inflate).setPositiveButton("Send as core-server noti", new ag(editText)).setNegativeButton("Send as Mall api response", new af(editText, this));
        builder.create().show();
    }

    static final class ag implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f25054a;

        ag(EditText editText) {
            this.f25054a = editText;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                EditText editText = this.f25054a;
                d.d.b.j.a((Object) editText, "mockInput");
                long parseLong = Long.parseLong(editText.getText().toString());
                com.shopee.app.network.a.a a2 = com.shopee.app.network.f.a(24);
                if (a2 != null) {
                    byte[] byteArray = new Notification.Builder().noticode(28).notification_time(Integer.valueOf((int) parseLong)).build().toByteArray();
                    ((com.shopee.app.network.c.i.w) a2).c(byteArray, byteArray.length);
                    return;
                }
                throw new d.m("null cannot be cast to non-null type com.shopee.app.network.processors.notification.NotificationProcessor");
            } catch (Exception unused) {
                com.shopee.app.h.r.a().a("Please input a valid number");
            }
        }
    }

    static final class af implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f25050a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f25051b;

        af(EditText editText, a aVar) {
            this.f25050a = editText;
            this.f25051b = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                EditText editText = this.f25050a;
                d.d.b.j.a((Object) editText, "mockInput");
                final long parseLong = Long.parseLong(editText.getText().toString());
                new com.shopee.app.d.c.d.a(this, this.f25051b.getEventBus(), this.f25051b.getFeatureToggleManager(), this.f25051b.getUserInfo(), this.f25051b.getFollowCounter(), this.f25051b.getTabRedDotApi()) {

                    /* renamed from: c  reason: collision with root package name */
                    final /* synthetic */ af f25052c;

                    {
                        this.f25052c = r7;
                    }

                    /* access modifiers changed from: protected */
                    public void c() {
                        this.f25052c.f25051b.getFollowCounter().onReceiveNewRedDot((int) parseLong);
                        this.f16402a.a().bu.a();
                    }
                }.a();
            } catch (Exception unused) {
                com.shopee.app.h.r.a().a("Please input a valid number");
            }
        }
    }
}
