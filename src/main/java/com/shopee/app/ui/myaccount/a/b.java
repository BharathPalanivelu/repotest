package com.shopee.app.ui.myaccount.a;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import com.afollestad.materialdialogs.f;
import com.devspark.robototextview.widget.RobotoTextView;
import com.shopee.app.a;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.c.e;
import com.shopee.app.data.store.ba;
import com.shopee.app.ui.common.r;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.ui.home.me.v3.OptionRow;
import com.shopee.app.util.ak;
import com.shopee.app.util.bc;
import com.shopee.app.util.k.f;
import com.shopee.app.util.k.g;
import com.shopee.app.util.k.h;
import com.shopee.app.util.x;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import java.util.HashMap;

public class b extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public a f23332a;

    /* renamed from: b  reason: collision with root package name */
    public bc f23333b;

    /* renamed from: c  reason: collision with root package name */
    public ak f23334c;

    /* renamed from: d  reason: collision with root package name */
    public UserInfo f23335d;

    /* renamed from: e  reason: collision with root package name */
    public r f23336e;

    /* renamed from: f  reason: collision with root package name */
    public h f23337f;

    /* renamed from: g  reason: collision with root package name */
    public ba f23338g;
    public Activity h;
    public e i;
    private HashMap j;

    public b(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.b(context, "context");
        Object b2 = ((x) context).b();
        if (b2 != null) {
            ((com.shopee.app.ui.myaccount.d) b2).a(this);
            View.inflate(context, R.layout.my_account_view_3, this);
            r();
            return;
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.ui.myaccount.MyAccountComponent");
    }

    public a getMPresenter() {
        a aVar = this.f23332a;
        if (aVar == null) {
            j.b("mPresenter");
        }
        return aVar;
    }

    public void setMPresenter(a aVar) {
        j.b(aVar, "<set-?>");
        this.f23332a = aVar;
    }

    public bc getMScope() {
        bc bcVar = this.f23333b;
        if (bcVar == null) {
            j.b("mScope");
        }
        return bcVar;
    }

    public void setMScope(bc bcVar) {
        j.b(bcVar, "<set-?>");
        this.f23333b = bcVar;
    }

    public ak getMNavigator() {
        ak akVar = this.f23334c;
        if (akVar == null) {
            j.b("mNavigator");
        }
        return akVar;
    }

    public void setMNavigator(ak akVar) {
        j.b(akVar, "<set-?>");
        this.f23334c = akVar;
    }

    public UserInfo getMUser() {
        UserInfo userInfo = this.f23335d;
        if (userInfo == null) {
            j.b("mUser");
        }
        return userInfo;
    }

    public void setMUser(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.f23335d = userInfo;
    }

    public r getMProgress() {
        r rVar = this.f23336e;
        if (rVar == null) {
            j.b("mProgress");
        }
        return rVar;
    }

    public void setMProgress(r rVar) {
        j.b(rVar, "<set-?>");
        this.f23336e = rVar;
    }

    public h getMUploader() {
        h hVar = this.f23337f;
        if (hVar == null) {
            j.b("mUploader");
        }
        return hVar;
    }

    public void setMUploader(h hVar) {
        j.b(hVar, "<set-?>");
        this.f23337f = hVar;
    }

    public ba getMUploadStore() {
        ba baVar = this.f23338g;
        if (baVar == null) {
            j.b("mUploadStore");
        }
        return baVar;
    }

    public void setMUploadStore(ba baVar) {
        j.b(baVar, "<set-?>");
        this.f23338g = baVar;
    }

    public Activity getMActivity() {
        Activity activity = this.h;
        if (activity == null) {
            j.b("mActivity");
        }
        return activity;
    }

    public void setMActivity(Activity activity) {
        j.b(activity, "<set-?>");
        this.h = activity;
    }

    public e getCleanTemporaryFilesInteractor() {
        e eVar = this.i;
        if (eVar == null) {
            j.b("cleanTemporaryFilesInteractor");
        }
        return eVar;
    }

    public void setCleanTemporaryFilesInteractor(e eVar) {
        j.b(eVar, "<set-?>");
        this.i = eVar;
    }

    private void r() {
        ((OptionRow) a(a.C0250a.myEReceipt)).setHidden(!ar.f().e().settingConfigStore().showEReceipt());
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.app_version);
        j.a((Object) robotoTextView, "app_version");
        robotoTextView.setText("Shopee v " + com.shopee.app.react.modules.app.appmanager.a.c());
    }

    public void a() {
        getMNavigator().t();
    }

    public void b() {
        getMNavigator().O();
    }

    public void c() {
        getMNavigator().j();
    }

    public void d() {
        getMNavigator().Y();
    }

    public void e() {
        getMNavigator().X();
    }

    public void f() {
        getMNavigator().al();
    }

    public void g() {
        getMNavigator().U();
    }

    public void h() {
        getMNavigator().E();
    }

    public void i() {
        getMNavigator().y();
    }

    public void j() {
        getMNavigator().ae();
    }

    public void k() {
        getMNavigator().A();
    }

    public void l() {
        getMNavigator().z();
    }

    public void m() {
        getMNavigator().B();
    }

    public void n() {
        getMNavigator().a((Context) getMActivity());
    }

    public void o() {
        Pair<g, f> b2 = getMUploader().b();
        if (b2 != null) {
            ((f) b2.second).c();
            a(b2);
            return;
        }
        s();
    }

    public void p() {
        t();
    }

    public static final class a extends f.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23340a;

        a(b bVar) {
            this.f23340a = bVar;
        }

        public void onNegative(com.afollestad.materialdialogs.f fVar) {
            if (fVar == null) {
                j.a();
            }
            fVar.dismiss();
        }

        public void onPositive(com.afollestad.materialdialogs.f fVar) {
            this.f23340a.getMNavigator().an();
        }
    }

    public void q() {
        com.shopee.app.ui.dialog.a.a(getContext(), 0, (int) R.string.sp_account_deletion_warning, (int) R.string.sp_label_cancel, (int) R.string.sp_label_ok, (f.b) new a(this), false);
    }

    private void a(Pair<g, com.shopee.app.util.k.f> pair) {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_logout_confirmation_pending_upload, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new d(this, pair));
    }

    public static final class d implements a.C0318a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23343a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Pair f23344b;

        d(b bVar, Pair pair) {
            this.f23343a = bVar;
            this.f23344b = pair;
        }

        public void onPositive() {
            this.f23343a.getMProgress().a();
            ((com.shopee.app.util.k.f) this.f23344b.second).e();
            this.f23343a.getMUploadStore().b((g) this.f23344b.first);
            ar.f().i();
            this.f23343a.getMActivity().finish();
        }

        public void onNegative() {
            ((com.shopee.app.util.k.f) this.f23344b.second).d();
        }
    }

    private void s() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.sp_logout_confirmation, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new c(this));
    }

    public static final class c implements a.C0318a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23342a;

        public void onNegative() {
        }

        c(b bVar) {
            this.f23342a = bVar;
        }

        public void onPositive() {
            this.f23342a.getMProgress().a();
            ar.f().i();
            this.f23342a.getMActivity().finish();
        }
    }

    private void t() {
        com.shopee.app.ui.dialog.a.a(getContext(), (int) R.string.settings_dialog_clear_cache, (int) R.string.sp_label_no, (int) R.string.sp_label_yes, (a.C0318a) new C0366b(this));
    }

    /* renamed from: com.shopee.app.ui.myaccount.a.b$b  reason: collision with other inner class name */
    public static final class C0366b implements a.C0318a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f23341a;

        public void onNegative() {
        }

        C0366b(b bVar) {
            this.f23341a = bVar;
        }

        public void onPositive() {
            this.f23341a.getCleanTemporaryFilesInteractor().e();
            Toast.makeText(this.f23341a.getContext(), R.string.settings_cache_cleared, 0).show();
        }
    }
}
