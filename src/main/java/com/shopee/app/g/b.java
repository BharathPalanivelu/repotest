package com.shopee.app.g;

import android.util.Pair;
import com.shopee.app.d.c.a.a;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.d;
import com.shopee.app.data.store.e;
import com.shopee.app.data.viewmodel.ActivityCounter;
import com.shopee.app.data.viewmodel.ActivityItemInfo;
import com.shopee.app.data.viewmodel.UserBriefInfo;
import com.shopee.app.database.orm.bean.DBActivityItem;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.h.t;
import com.shopee.app.network.d.ad;
import com.shopee.app.network.d.at;
import com.shopee.app.network.d.au;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final e f17469a;

    /* renamed from: b  reason: collision with root package name */
    private final ah f17470b;

    /* renamed from: c  reason: collision with root package name */
    private final bh f17471c;

    /* renamed from: d  reason: collision with root package name */
    private final ActivityCounter f17472d;

    /* renamed from: e  reason: collision with root package name */
    private final d f17473e;

    public b(e eVar, ah ahVar, bh bhVar, ActivityCounter activityCounter, d dVar) {
        this.f17469a = eVar;
        this.f17470b = ahVar;
        this.f17471c = bhVar;
        this.f17472d = activityCounter;
        this.f17473e = dVar;
    }

    public List<ActivityItemInfo> a(a aVar) {
        UserBriefInfo userBriefInfo;
        DBUserInfo dBUserInfo;
        List<DBActivityItem> b2 = this.f17469a.b(this.f17473e.b(aVar.f17474a));
        ArrayList arrayList = new ArrayList();
        Set<Long> ids = this.f17472d.getIds();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (DBActivityItem next : b2) {
            int g2 = next.g();
            DBItemDetail dBItemDetail = null;
            if (g2 > 0) {
                dBUserInfo = this.f17471c.a(g2);
                boolean z = false;
                if (dBUserInfo == null) {
                    arrayList2.add(Integer.valueOf(g2));
                    dBUserInfo = DBUserInfo.b(g2);
                } else if (dBUserInfo.g() == 0) {
                    z = true;
                }
                userBriefInfo = t.a().a(g2);
                if (userBriefInfo == null && !z) {
                    arrayList4.add(Integer.valueOf(g2));
                }
            } else {
                dBUserInfo = null;
                userBriefInfo = null;
            }
            long i = next.i();
            if (i > 0) {
                dBItemDetail = this.f17470b.a(i);
                if (dBItemDetail == null) {
                    arrayList3.add(new Pair(Integer.valueOf(next.h()), Long.valueOf(next.i())));
                }
            }
            ActivityItemInfo activityItemInfo = new ActivityItemInfo();
            com.shopee.app.d.b.b.a(next, dBUserInfo, dBItemDetail, activityItemInfo, userBriefInfo);
            if (ids.contains(Long.valueOf((long) next.d()))) {
                activityItemInfo.setUnread(true);
            }
            arrayList.add(activityItemInfo);
        }
        if (arrayList2.size() > 0) {
            new au().a((List<Integer>) arrayList2);
        }
        if (arrayList4.size() > 0) {
            new at().a(arrayList4, new ArrayList());
        }
        if (arrayList3.size() > 0) {
            new ad().a(arrayList3);
        }
        return arrayList;
    }

    public static class a extends a.C0253a {

        /* renamed from: a  reason: collision with root package name */
        public final int f17474a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f17475b;

        private a(boolean z, int i) {
            super("GetActivityListInteractor_" + z + "_" + i, "use_case", 500, true);
            this.f17475b = z;
            this.f17474a = i;
        }

        public static a a() {
            return new a(true, -1);
        }

        public static a a(int i) {
            return new a(false, i);
        }
    }
}
