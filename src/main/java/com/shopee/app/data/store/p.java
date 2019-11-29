package com.shopee.app.data.store;

import com.shopee.app.database.b;
import com.shopee.app.database.orm.a.i;
import com.shopee.app.database.orm.a.j;
import com.shopee.app.database.orm.bean.DBChatMessage;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import java.util.HashMap;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private i f17324a = b.f().m();

    /* renamed from: b  reason: collision with root package name */
    private j f17325b = b.f().n();

    public boolean a(long j) {
        return this.f17324a.b(j);
    }

    public void a(List<DBChatMessage> list) {
        this.f17324a.a(list);
    }

    public DBChatToOffer b(long j) {
        return this.f17325b.a(j);
    }

    public List<DBChatToOffer> b(List<Long> list) {
        return this.f17325b.b(list);
    }

    public DBChatToOffer a(long j, int i, int i2, long j2) {
        return this.f17325b.a(j, i, i2, j2);
    }

    public void a(DBChatMessage dBChatMessage) {
        this.f17324a.a(dBChatMessage);
    }

    public void c(List<DBChatToOffer> list) {
        this.f17325b.a(list);
    }

    public DBChatMessage a(Long l) {
        return this.f17324a.a(l.longValue());
    }

    public DBChatMessage a(String str) {
        return this.f17324a.a(str);
    }

    public List<DBChatMessage> a(int i, int i2) {
        return this.f17324a.a(i, i2);
    }

    public HashMap<Long, DBChatMessage> d(List<Long> list) {
        List<DBChatMessage> b2 = this.f17324a.b(list);
        HashMap<Long, DBChatMessage> hashMap = new HashMap<>();
        for (DBChatMessage next : b2) {
            hashMap.put(Long.valueOf(next.b()), next);
        }
        return hashMap;
    }

    public void a(int i) {
        this.f17324a.a(i);
    }

    public void b(DBChatMessage dBChatMessage) {
        this.f17324a.b(dBChatMessage);
    }

    public void b(int i, int i2) {
        this.f17324a.b(i, i2);
    }
}
