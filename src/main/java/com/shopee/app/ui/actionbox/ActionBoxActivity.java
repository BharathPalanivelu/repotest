package com.shopee.app.ui.actionbox;

import android.os.Bundle;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.ActionRequiredCounter;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.d;
import com.shopee.app.ui.actionbox2.f;
import com.shopee.app.ui.actionbox2.g;
import com.shopee.app.ui.home.e;
import com.shopee.app.util.ak;
import com.shopee.app.util.x;
import com.shopee.id.R;

public class ActionBoxActivity extends b implements x<e> {

    /* renamed from: a  reason: collision with root package name */
    int f19329a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f19330b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f19331c = 4;

    /* renamed from: d  reason: collision with root package name */
    ActionRequiredCounter f19332d;

    /* renamed from: e  reason: collision with root package name */
    ak f19333e;

    /* renamed from: f  reason: collision with root package name */
    com.shopee.app.tracking.trackingv3.b f19334f;

    /* renamed from: g  reason: collision with root package name */
    private e f19335g;
    private f h;

    public String j() {
        return "notification_folder";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.h = g.a(this, this.f19331c);
        a((View) this.h);
        if (bundle == null) {
            int i = this.f19330b;
            if (i != -1) {
                this.f19333e.e(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        int i = this.f19331c;
        int i2 = R.string.sp_notifications;
        if (i == 1) {
            i2 = R.string.sp_shopee_promotions;
        } else if (i != 4) {
            if (i == 12) {
                i2 = R.string.sp_label_discuss_messages;
            } else if (i != 13) {
                switch (i) {
                    case 6:
                        i2 = R.string.sp_shopee_updates;
                        break;
                    case 7:
                        i2 = R.string.sp_ratings;
                        break;
                    case 8:
                        i2 = R.string.sp_wallet_updates;
                        break;
                    case 9:
                        i2 = R.string.sp_paid_ads;
                        break;
                    case 10:
                        i2 = R.string.sp_social_updates;
                        break;
                }
            } else {
                i2 = R.string.sp_label_pay_later_updates;
            }
        }
        aVar.f(1).e(0).a((a.b) new com.shopee.app.ui.actionbar.g(this)).a((a.b) new d(this)).b(i2);
    }

    /* access modifiers changed from: protected */
    public o p_() {
        o oVar = new o();
        oVar.a("noti_folder", com.shopee.app.tracking.a.a.c(this.f19331c));
        oVar.a("noti_folder_tab", ViewProps.NONE);
        return oVar;
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f19335g = com.shopee.app.ui.home.b.c().a(com.shopee.app.react.g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.f19335g.a(this);
    }

    /* renamed from: c */
    public e b() {
        return this.f19335g;
    }
}
