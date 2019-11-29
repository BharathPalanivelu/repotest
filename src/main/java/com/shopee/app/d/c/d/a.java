package com.shopee.app.d.c.d;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.viewmodel.FollowCounter;
import com.shopee.app.network.http.a.j;
import com.shopee.app.network.http.data.reddot.TabRedDot;
import com.shopee.app.network.http.data.reddot.TabRedDotStatusData;
import com.shopee.app.network.http.data.reddot.TabRedDotStatusResponse;
import com.shopee.app.network.http.data.reddot.TabReddotStatusRequest;
import com.shopee.app.util.i;
import com.shopee.app.util.n;
import com.shopee.app.util.s;
import f.m;
import java.util.Iterator;

public class a extends com.shopee.app.d.c.a {

    /* renamed from: c  reason: collision with root package name */
    private final s f16765c;

    /* renamed from: d  reason: collision with root package name */
    private final UserInfo f16766d;

    /* renamed from: e  reason: collision with root package name */
    private final FollowCounter f16767e;

    /* renamed from: f  reason: collision with root package name */
    private final j f16768f;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetHomeRedDotInteractor";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(n nVar, s sVar, UserInfo userInfo, FollowCounter followCounter, j jVar) {
        super(nVar);
        d.d.b.j.b(nVar, "dataEventBus");
        d.d.b.j.b(sVar, "featureToggleManager");
        d.d.b.j.b(userInfo, "userInfo");
        d.d.b.j.b(followCounter, "followCounter");
        d.d.b.j.b(jVar, "tabRedDotApi");
        this.f16765c = sVar;
        this.f16766d = userInfo;
        this.f16767e = followCounter;
        this.f16768f = jVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        Object obj;
        boolean z;
        if (this.f16766d.isLoggedIn() && this.f16765c.a("feed")) {
            try {
                TabReddotStatusRequest tabReddotStatusRequest = new TabReddotStatusRequest(d.a.j.a(new TabRedDot(28, this.f16767e.getRedDotData().getLastDismissDotCreationTime())));
                j jVar = this.f16768f;
                String a2 = com.shopee.app.network.http.b.a.a();
                d.d.b.j.a((Object) a2, "RequestUtil.getCSRFCookieValue()");
                String str = i.f7040c;
                d.d.b.j.a((Object) str, "CONST.URL_BASE");
                m<TabRedDotStatusResponse> a3 = jVar.a(a2, str, tabReddotStatusRequest).a();
                if (a3.d()) {
                    TabRedDotStatusResponse e2 = a3.e();
                    if (e2 != null) {
                        TabRedDotStatusData data = e2.getData();
                        if (data != null) {
                            Iterator it = data.getRedDots().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                if (((TabRedDot) obj).getNotiCode() == 28) {
                                    z = true;
                                    continue;
                                } else {
                                    z = false;
                                    continue;
                                }
                                if (z) {
                                    break;
                                }
                            }
                            TabRedDot tabRedDot = (TabRedDot) obj;
                            if (tabRedDot != null) {
                                this.f16767e.onReceiveNewRedDot(tabRedDot.getCreationTime());
                                this.f16402a.a().bu.a();
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                com.garena.android.appkit.d.a.a(e3);
            }
        }
    }
}
