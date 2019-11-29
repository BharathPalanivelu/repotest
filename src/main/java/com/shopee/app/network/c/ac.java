package com.shopee.app.network.c;

import android.util.Pair;
import com.garena.android.appkit.b.b;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.t;
import com.shopee.app.database.orm.bean.DBContactInfo;
import com.shopee.app.h.o;
import com.shopee.app.network.d.z;
import com.shopee.app.network.f;
import com.shopee.app.util.n;
import com.shopee.protocol.action.ContactBrief;
import com.shopee.protocol.action.ResponseGetContacts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ac extends c implements com.shopee.app.network.a.a<ResponseGetContacts> {
    public int a() {
        return 111;
    }

    public void c(byte[] bArr, int i) throws IOException {
        ResponseGetContacts responseGetContacts = (ResponseGetContacts) f.f18486a.parseFrom(bArr, 0, i, ResponseGetContacts.class);
        c(responseGetContacts.requestid);
        c().a(responseGetContacts);
    }

    private a c() {
        return ar.f().e().getContactProcessor();
    }

    public void a(String str) {
        b.a("RESPONSE_LOCAL_CONTACT_ERROR", new com.garena.android.appkit.b.a(-100), b.a.NETWORK_BUS);
    }

    public Pair<String, ResponseGetContacts> a(byte[] bArr) throws IOException {
        ResponseGetContacts responseGetContacts = (ResponseGetContacts) f.f18486a.parseFrom(bArr, 0, bArr.length, ResponseGetContacts.class);
        return new Pair<>(responseGetContacts.requestid, responseGetContacts);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final n f17785a;

        /* renamed from: b  reason: collision with root package name */
        private final t f17786b;

        public a(n nVar, t tVar) {
            this.f17785a = nVar;
            this.f17786b = tVar;
        }

        private boolean b(ResponseGetContacts responseGetContacts) {
            if (responseGetContacts.errcode.intValue() == 0) {
                return true;
            }
            this.f17785a.a("RESPONSE_LOCAL_CONTACT_ERROR", new com.garena.android.appkit.b.a(responseGetContacts.errcode));
            return false;
        }

        public void a(ResponseGetContacts responseGetContacts) {
            if (b(responseGetContacts)) {
                ArrayList arrayList = new ArrayList();
                z zVar = (z) o.a().f(responseGetContacts.requestid);
                if (zVar != null) {
                    if (zVar.d() == 0) {
                        this.f17786b.c(zVar.c());
                    }
                    for (ContactBrief a2 : responseGetContacts.contacts == null ? new ArrayList() : responseGetContacts.contacts) {
                        DBContactInfo dBContactInfo = new DBContactInfo();
                        dBContactInfo.d(2);
                        com.shopee.app.d.b.b.a(a2, dBContactInfo, zVar.c());
                        arrayList.add(dBContactInfo);
                    }
                    this.f17786b.a((List<DBContactInfo>) arrayList);
                    this.f17785a.a("RESPONSE_LOCAL_CONTACT_SUCCESS", (com.garena.android.appkit.b.a) new com.shopee.app.ui.follow.following.o(responseGetContacts.requestid, responseGetContacts.total_count.intValue()));
                }
            }
        }
    }
}
