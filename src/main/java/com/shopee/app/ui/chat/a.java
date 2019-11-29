package com.shopee.app.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import com.garena.android.appkit.b.b;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.ItemDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.data.viewmodel.chat.ChatIntention;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.chat2.n;
import com.shopee.app.ui.chat2.o;
import com.shopee.app.util.x;
import com.shopee.app.web.protocol.RightItemMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a extends b implements x<b> {

    /* renamed from: a  reason: collision with root package name */
    public static ItemDetail f20001a;

    /* renamed from: b  reason: collision with root package name */
    public static OrderDetail f20002b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Long, ItemDetail> f20003c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    int f20004d;

    /* renamed from: e  reason: collision with root package name */
    ChatIntention f20005e;

    /* renamed from: f  reason: collision with root package name */
    private b f20006f;

    /* renamed from: g  reason: collision with root package name */
    private n f20007g;

    public String j() {
        return "chat_window";
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f20007g = o.a(this, this.f20004d, this.f20005e);
        a((View) this.f20007g);
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        a.C0296a e2 = aVar.f(1).e(0);
        e2.a("@" + com.garena.android.appkit.tools.b.e(R.string.sp_user_name_placeholder)).a("more", (int) R.drawable.com_garena_shopee_ic_more);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f20006f = c.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.f20006f.a(this);
    }

    /* access modifiers changed from: protected */
    public void a(com.shopee.app.ui.common.a aVar) {
        aVar.a(hashCode(), this.f20007g);
    }

    /* renamed from: c */
    public b b() {
        return this.f20006f;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, Intent intent) {
        if (i == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            if (stringArrayListExtra != null) {
                this.f20007g.b((List<String>) stringArrayListExtra);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i, Intent intent) {
        if (i == -1) {
            ItemDetail itemDetail = f20001a;
            if (itemDetail != null) {
                this.f20007g.a(itemDetail);
                f20001a = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i, Intent intent) {
        if (i == -1 && f20001a != null) {
            int intExtra = intent.getIntExtra("type", 0);
            if (intExtra == 0) {
                this.f20007g.b(f20001a);
            } else if (intExtra == 1) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(f20001a);
                this.f20007g.c((List<ItemDetail>) arrayList);
            } else if (intExtra == 3) {
                this.f20007g.c(f20001a);
            }
            f20001a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i, Intent intent) {
        if (i == -1 && !f20003c.isEmpty()) {
            this.f20007g.c((List<ItemDetail>) new ArrayList(f20003c.values()));
        }
        f20003c.clear();
    }

    /* access modifiers changed from: package-private */
    public void e(int i, Intent intent) {
        if (i == -1) {
            OrderDetail orderDetail = f20002b;
            if (orderDetail != null) {
                this.f20007g.a(orderDetail);
            }
        }
        f20003c.clear();
    }

    public void onBackPressed() {
        if (!this.f20007g.u()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public static e.a d(boolean z) {
        e.a aVar = new e.a();
        e.b bVar = new e.b(4, (int) R.string.sp_label_view_profile, (Object) new RightItemMessage("button", "view", com.garena.android.appkit.tools.b.e(R.string.sp_label_view_profile)), (int) R.drawable.ic_viewprofile);
        e.b bVar2 = new e.b(4, (int) R.string.sp_label_back_to_home, (Object) new RightItemMessage("button", "home", com.garena.android.appkit.tools.b.e(R.string.sp_label_back_to_home)), (int) R.drawable.ic_backtohomepage);
        e.b bVar3 = new e.b(4, (int) R.string.sp_report_this_user2, (Object) new RightItemMessage("button", "report", com.garena.android.appkit.tools.b.e(R.string.sp_report_user2)), (int) R.drawable.ic_reportthisuser);
        int i = z ? R.string.sp_unblock_user : R.string.sp_block_user;
        e.b bVar4 = new e.b(4, i, (Object) new RightItemMessage("button", "block", com.garena.android.appkit.tools.b.e(i)), (int) R.drawable.ic_blockthisuser);
        e.b bVar5 = new e.b(4, (int) R.string.label_need_help, (Object) new RightItemMessage("button", "need_help", com.garena.android.appkit.tools.b.e(R.string.label_need_help)), (int) R.drawable.ic_need_help);
        aVar.a(bVar);
        aVar.a(bVar2);
        aVar.a(bVar3);
        aVar.a(bVar4);
        aVar.a(bVar5);
        aVar.a((e.c) new e.c() {
            public void a(int i, Object obj) {
                com.garena.android.appkit.b.b.a("CLICK", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(i), obj)), b.a.UI_BUS);
            }
        });
        aVar.a((e.d) new e.d() {
            public void a(boolean z) {
                com.garena.android.appkit.b.b.a("ON_SHOW", new com.garena.android.appkit.b.a(Boolean.valueOf(z)), b.a.UI_BUS);
            }
        });
        return aVar;
    }
}
