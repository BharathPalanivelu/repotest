package com.shopee.app.network.c;

import android.util.LongSparseArray;
import android.util.Pair;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.database.orm.bean.DBItemDetail;
import com.shopee.app.h.o;
import com.shopee.app.network.d.t;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseBatchItemScore;
import com.shopee.protocol.action.SearchItemScore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class u extends c implements com.shopee.app.network.a.a<ResponseBatchItemScore> {
    public int a() {
        return 240;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseBatchItemScore responseBatchItemScore = (ResponseBatchItemScore) f.f18486a.parseFrom(bArr, 0, i, ResponseBatchItemScore.class);
        c(responseBatchItemScore.requestid);
        c().a(responseBatchItemScore);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetBatchItemScoreProcessor();
    }

    public Pair<String, ResponseBatchItemScore> a(byte[] bArr) throws IOException {
        ResponseBatchItemScore responseBatchItemScore = (ResponseBatchItemScore) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseBatchItemScore.class);
        return new Pair<>(responseBatchItemScore.requestid, responseBatchItemScore);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f18052a;

        /* renamed from: b  reason: collision with root package name */
        private final ah f18053b;

        public a(n nVar, ah ahVar) {
            this.f18052a = nVar;
            this.f18053b = ahVar;
        }

        public void a(ResponseBatchItemScore responseBatchItemScore) {
            if (b(responseBatchItemScore) && !af.a(responseBatchItemScore.items)) {
                LongSparseArray longSparseArray = new LongSparseArray(responseBatchItemScore.items.size());
                ArrayList arrayList = new ArrayList(responseBatchItemScore.items.size());
                for (SearchItemScore next : responseBatchItemScore.items) {
                    arrayList.add(next.itemid);
                    longSparseArray.put(next.itemid.longValue(), next);
                }
                List<DBItemDetail> c2 = this.f18053b.c((List<Long>) arrayList);
                for (DBItemDetail next2 : c2) {
                    next2.e(b.a(((SearchItemScore) longSparseArray.get(next2.a())).view_count, 0));
                }
                this.f18053b.a(c2);
                t tVar = (t) o.a().f(responseBatchItemScore.requestid);
                if (tVar != null) {
                    this.f18052a.a("CMD_GET_ITEM_SCORES_SUCCESS", new com.garena.android.appkit.b.a(Integer.valueOf(tVar.f18449a)));
                }
            }
        }

        private boolean b(ResponseBatchItemScore responseBatchItemScore) {
            if (responseBatchItemScore.errcode.intValue() == 0) {
                return true;
            }
            this.f18052a.a("CMD_GET_ITEM_SCORES_ERROR", new com.garena.android.appkit.b.a(responseBatchItemScore.errcode));
            return false;
        }

        public void a() {
            this.f18052a.a("CMD_GET_ITEM_SCORES_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
