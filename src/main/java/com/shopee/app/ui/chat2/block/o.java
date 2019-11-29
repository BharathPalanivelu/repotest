package com.shopee.app.ui.chat2.block;

import android.util.Pair;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.k;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import com.shopee.app.util.n;
import java.util.Iterator;

public class o extends com.shopee.app.d.c.a.a<a> {

    /* renamed from: d  reason: collision with root package name */
    private final k f20348d;

    protected o(n nVar, k kVar) {
        super(nVar);
        this.f20348d = kVar;
    }

    public void a(int i) {
        b(new a(i));
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        int i;
        Iterator<DBBlockUser> it = this.f20348d.b().iterator();
        while (true) {
            if (!it.hasNext()) {
                i = 2;
                break;
            }
            DBBlockUser next = it.next();
            if (next.a() == aVar.f20349a) {
                i = !next.b();
                break;
            }
        }
        this.f16405a.a().bS.a(new Pair(Integer.valueOf(aVar.f20349a), Integer.valueOf(i))).a();
    }

    public static class a extends a.C0253a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f20349a;

        public a(int i) {
            super("CheckIfUserIsBlockedInteractor" + i, "use_case0", 500, true);
            this.f20349a = i;
        }
    }
}
