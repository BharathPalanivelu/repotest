package com.shopee.app.network.c.a;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.database.orm.bean.DBActionContent;
import com.shopee.app.h.o;
import com.shopee.app.network.c.c;
import com.shopee.app.network.d.az;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.ActionContent;
import com.shopee.protocol.action.ResponseActionContentList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a extends c implements com.shopee.app.network.a.a<ResponseActionContentList> {
    public int a() {
        return 105;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseActionContentList responseActionContentList = (ResponseActionContentList) f.f18486a.parseFrom(bArr, 0, i, ResponseActionContentList.class);
        c(responseActionContentList.requestid);
        if (a(responseActionContentList)) {
            if (!af.a(responseActionContentList.action_content_list)) {
                com.shopee.app.data.store.c cVar = new com.shopee.app.data.store.c();
                ArrayList arrayList = new ArrayList();
                for (ActionContent a2 : responseActionContentList.action_content_list) {
                    DBActionContent dBActionContent = new DBActionContent();
                    b.a(a2, dBActionContent);
                    arrayList.add(dBActionContent);
                }
                cVar.a((List<DBActionContent>) arrayList);
            }
            az f2 = o.a().f(responseActionContentList.requestid);
            if (f2 == null || !(f2 instanceof com.shopee.app.network.d.a.a)) {
                com.garena.android.appkit.b.b.a("ACTION_CONTENT_SAVE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
                return;
            }
            com.shopee.app.network.d.a.a aVar = (com.shopee.app.network.d.a.a) f2;
            if (aVar.d()) {
                com.garena.android.appkit.b.b.a("ACTION_CHILD_CONTENT_SAVE", new com.garena.android.appkit.b.a(Long.valueOf(aVar.c())), b.a.NETWORK_BUS);
            } else {
                com.garena.android.appkit.b.b.a("ACTION_CONTENT_SAVE", new com.garena.android.appkit.b.a(), b.a.NETWORK_BUS);
            }
        }
    }

    private boolean a(ResponseActionContentList responseActionContentList) {
        if (responseActionContentList.errcode.intValue() == 0) {
            return true;
        }
        a(responseActionContentList.errcode.intValue());
        return false;
    }

    private void a(int i) {
        com.garena.android.appkit.b.b.a("ACTION_CONTENT_SAVE_FAIL", new com.garena.android.appkit.b.a(Integer.valueOf(i)), b.a.NETWORK_BUS);
    }

    public void a(String str) {
        a(-100);
    }

    public Pair<String, ResponseActionContentList> a(byte[] bArr) throws IOException {
        ResponseActionContentList responseActionContentList = (ResponseActionContentList) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseActionContentList.class);
        return new Pair<>(responseActionContentList.requestid, responseActionContentList);
    }
}
