package com.shopee.app.network.c;

import android.text.SpannableStringBuilder;
import com.shopee.app.application.ar;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.s;
import com.shopee.app.data.viewmodel.ItemCommentInfo;
import com.shopee.app.database.orm.bean.DBItemComment;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.h.o;
import com.shopee.app.network.d.x;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ResponseItemCmtList;
import com.shopee.protocol.shop.ItemCmt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ab extends c {
    public int a() {
        return 69;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseItemCmtList responseItemCmtList = (ResponseItemCmtList) f.f18486a.parseFrom(bArr, 0, i, ResponseItemCmtList.class);
        c(responseItemCmtList.requestid);
        c().a(responseItemCmtList);
    }

    public void a(String str) {
        c().a();
    }

    private a c() {
        return ar.f().e().newGetItemCmtListProcessor();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private n f17783a;

        /* renamed from: b  reason: collision with root package name */
        private s f17784b;

        public a(n nVar, s sVar) {
            this.f17783a = nVar;
            this.f17784b = sVar;
        }

        public void a(ResponseItemCmtList responseItemCmtList) {
            if (b(responseItemCmtList)) {
                x xVar = (x) o.a().f(responseItemCmtList.requestid);
                if (xVar == null || !xVar.f18459g) {
                    ArrayList arrayList = new ArrayList();
                    if (!af.a(responseItemCmtList.comment)) {
                        for (ItemCmt a2 : responseItemCmtList.comment) {
                            DBItemComment dBItemComment = new DBItemComment();
                            b.a(a2, dBItemComment);
                            arrayList.add(dBItemComment);
                        }
                    }
                    if (xVar == null || !xVar.f18458f) {
                        this.f17784b.a((List<DBItemComment>) arrayList);
                    } else {
                        this.f17784b.a(responseItemCmtList.itemid.longValue(), arrayList, xVar.f18456d, xVar.f18457e);
                    }
                    this.f17783a.a().ac.a();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                if (!af.a(responseItemCmtList.comment)) {
                    for (ItemCmt a3 : responseItemCmtList.comment) {
                        DBItemComment dBItemComment2 = new DBItemComment();
                        b.a(a3, dBItemComment2);
                        ItemCommentInfo itemCommentInfo = new ItemCommentInfo();
                        b.a(dBItemComment2, (DBUserInfo) null, 10, itemCommentInfo);
                        itemCommentInfo.setDisplayString(new SpannableStringBuilder(dBItemComment2.j()));
                        arrayList2.add(itemCommentInfo);
                    }
                }
                this.f17783a.a().aj.a(arrayList2).a();
            }
        }

        private boolean b(ResponseItemCmtList responseItemCmtList) {
            if (responseItemCmtList.errcode.intValue() == 0) {
                return true;
            }
            this.f17783a.a("COMMENT_LIST_ERROR", new com.garena.android.appkit.b.a(responseItemCmtList.errcode));
            return false;
        }

        public void a() {
            this.f17783a.a("COMMENT_LIST_ERROR", new com.garena.android.appkit.b.a(-100));
        }
    }
}
